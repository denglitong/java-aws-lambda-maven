#!/usr/bin/env bash

FUNCTION_NAME='HelloJava'
JAR_FILE='fileb://target/java-lambda-maven-1.0-SNAPSHOT.jar'

mvn clean package

aws lambda update-function-code \
    --function-name ${FUNCTION_NAME} \
    --zip-file ${JAR_FILE}