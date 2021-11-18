#!/usr/bin/env bash

FUNCTION_NAME='HelloJava'
INPUT_EVENT_PAYLOAD='file://event.json'
OUTPUT_JSON='out.json'

aws lambda invoke \
    --function-name ${FUNCTION_NAME} \
    --payload ${INPUT_EVENT_PAYLOAD} \
    ${OUTPUT_JSON}

cat ${OUTPUT_JSON}
echo ""