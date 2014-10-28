#!/bin/bash

# This build step ensures unique build artifacts are stored for later reference
# to be copied between jobs (copy artifact, archive artifact and fingerprinter).
# It enabled they can be saved as release artifacts, further it ensures that
# build promotions have unique files to fingerprint and track.
# This tracking means, if we copy these artifact along a pipeline, that we can
# track job dependency changes also.

# The default storage location for artifacts for the projects are chosen to be:
#JOB_ART_DIR=artifacts
# ...  which actually Jenkins job workspace/artifacts

# Unless another location is given?

trap 'exit_status=$?; trap - INT TERM EXIT ERR; echo "ERROR: Exiting with $exit_status from failing command: $BASH_COMMAND"; exit $exit_status' INT TERM EXIT ERR

if [ $# -ne 1 ]
	then
		echo "Script must be called with artifact dir as argument:"
		echo "`basename $0` artifacts-directory"
		exit 1;
	else
		JOB_ART_DIR=$1
		echo "DELETING artifacts dir $JOB_ART_DIR, and creating new with artifacts..."
fi

# clean old left overs, if not wiping workspace, and create dir again
rm -rf ${JOB_ART_DIR}
mkdir -p ${JOB_ART_DIR}

# These simpel artifact is created as key=value pair for later re-use in other 
# jobs or for reference. The BUILD_ID serves as being unique.
# Job-names and numbers make them easy to track.
# NOTICE that we had problems with several files having the same md5sum file, typically because
# the file content is the same and the md5sum is only based on the content.
# This "collision" means jobs see dependency changes on random other jobs.
# To avoid this we add a random string to the file named the same env var each time
# including a timestamp. If we load several of the files the random variable will be overwritten
# but it is not used anyway.

# GIT_SHORT_SHA is planned to use to read along the pipeline in those cases where we can not transfer
# the git sha with jenkins functionality.
echo "GIT_SHORT_SHA=${GIT_SHORT_SHA}" > ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-GIT_SHORT_SHA.env
# ... no need to append unique information - it unique itself.

# GIT_COMMIT is the complete length version of GIT_SHORT_SHA
echo "GIT_COMMIT=${GIT_COMMIT}" > ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-GIT_COMMIT.env

# BUILD if from Jenkins:
# BUILD_ID
#    The current build id, such as "2005-08-22_23-59-59" (YYYY-MM-DD_hh-mm-ss)
echo "BUILD_ID=${BUILD_ID}" > ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-BUILD_ID.env
# Though almost unique, we add a random string to ensure more uniqueness
echo "RANDOM_STRING=$(LC_CTYPE=C tr -cd 'a-zA-Z0-9' < /dev/urandom | head -c 80)" >> ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-BUILD_ID.env

# Both these build numbers are major.minor.path-buildnumber and will across project often hit the same version.
# Thus these files must be unique (often the env. vars. added to the files are empty)
echo "YXLON_BUILD_NUMBER=${BUILD_NUMBER}" > ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-YXLON_BUILD_NUMBER.env
echo "RANDOM_STRING=$(LC_CTYPE=C tr -cd 'a-zA-Z0-9' < /dev/urandom | head -c 80)" >> ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-YXLON_BUILD_NUMBER.env

echo "YXLON_VERSION_NUMBER=${YXLON_VERSION_NUMBER}" > ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-YXLON_VERSION_NUMBER.env
echo "RANDOM_STRING=$(LC_CTYPE=C tr -cd 'a-zA-Z0-9' < /dev/urandom | head -c 80)" >> ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-YXLON_VERSION_NUMBER.env

# This should be unique enough itself, and is just use for tracking problem later on.
env > ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-env-dump.out

echo done!
trap - INT TERM EXIT ERR
