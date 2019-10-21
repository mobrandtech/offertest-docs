package com.mobrand.offertest.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.Duration;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OffertestRequestIO {

  private static final OkHttpClient client = new OkHttpClient().newBuilder().readTimeout(Duration.ofMinutes(3)).build();
  private static final Gson gson = new Gson();
  private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");


  public static TestResult sendRequest(OffertestRequest offerSyncRequest) throws IOException {

    String json = gson.toJson(offerSyncRequest);

    String url = "https://api.offertest.net/offertest?async=" + offerSyncRequest.isAsync();

    String authorization = offerSyncRequest.getApiKey();

    RequestBody body = RequestBody.create(json, JSON);

    Request request = new Builder()
        .url(url)
        .addHeader("Authorization", "Bearer " + authorization)
        .post(body)
        .build();

    String response = client.newCall(request).execute().body().string();

    if(offerSyncRequest.isAsync()){

      TestResult testResult = new TestResult();
      testResult.setId(response);

      return testResult;

    } else {

      return gson.fromJson(response, TestResult.class);

    }

  }

}
