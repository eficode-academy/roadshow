#!/bin/bash

# Sets up the git short SHA of the latest commit

# This script can be used in Jenkins with the
# Environment Script Plugin injecting environment
# variables into the build process.
# Enable "Generate environment variable from script"
# found in the "Build Environment" configuration section.

# The plugin need the output of the script to be key=value pairs

trap 'exit_status=$?; trap - INT TERM EXIT ERR; echo "ERROR: Exiting with $exit_status from failing command: $BASH_COMMAND"; exit $exit_status' INT TERM EXIT ERR

TMP=`git rev-parse --short HEAD`

echo "GIT_SHORT_SHA=$TMP"

trap - INT TERM EXIT ERR
