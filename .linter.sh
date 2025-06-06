#!/bin/bash
cd /home/kavia/workspace/code-generation/recipehub-34830-f8039d55/recipehub_main_container
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

