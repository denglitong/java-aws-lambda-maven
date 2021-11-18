#!/usr/bin/env bash

FUNCTION_NAME='HelloJava'
HANDLER='com.example.myproject.handler.HelloHandler'
JAR_FILE='fileb://target/java-lambda-maven-1.0-SNAPSHOT.jar'
# create you role
ROLE='arn:aws:iam::717437220473:role/service-role/lambda_basic_execution'

aws lambda create-function \
    --function-name ${FUNCTION_NAME} \
    --zip-file ${JAR_FILE} \
    --handler ${HANDLER} \
    --runtime java8 \
    --role ${ROLE} \
    --description 'java lambda hello demo'