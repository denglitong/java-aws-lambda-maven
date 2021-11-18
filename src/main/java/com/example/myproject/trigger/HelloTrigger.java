package com.example.myproject.trigger;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HelloTrigger {

    private static final String FUNCTION_NAME = "HelloJava";

    private static final Gson gson = new Gson();

    private static final AWSLambda AWS_LAMBDA = getLambdaInstance();

    public static void main(String[] args) {
        Map<String, String> payload = new HashMap<>();
        String userName = "litong.deng + " + System.currentTimeMillis();
        payload.put("name", userName);

        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(FUNCTION_NAME)
                .withPayload(gson.toJson(payload));

        InvokeResult invokeResult = AWS_LAMBDA.invoke(invokeRequest);

        System.out.println(invokeResult);
        String ans = new String(invokeResult.getPayload().array());
        System.out.println(ans);
        assertEquals(String.format("\"Hello, %s !\"", userName), ans);

        System.exit(0); // ? not exit for aws lambda daemon thread?
    }

    /**
     * 1. `aws configure` save in ~/.aws/credentials or export environment
     * 2. keep the region same as your lambda func
     */
    private static AWSLambda getLambdaInstance() {
        return AWSLambdaClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(Regions.US_EAST_2)
                .build();
    }
}
