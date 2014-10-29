#!/bin/bash

# Example on creating some kind of binary file that can be traced

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

# Though almost unique, we add a random string to ensure more uniqueness
echo "RANDOM_STRING=$(LC_CTYPE=C tr -cd 'a-zA-Z0-9' < /dev/urandom | head -c 500)" >> ${JOB_ART_DIR}/${JOB_NAME}_${BUILD_NUMBER}-BINARY.out
