package com.mobrand.offertest.example;

import java.io.IOException;

public class OffertestSyncExample {



  private final static String USERID = "YOUR_USER_ID";
  private final static String APIKEY = "YOU_API_KEY";



  public static void main(String[] args) throws IOException {

    new OffertestSyncExample().run();

  }


  private void run() throws IOException {


    OffertestConfig config = new OffertestConfig(USERID, APIKEY);
    OffertestRequest offerSyncRequest = new OffertestRequest.Builder(
        config,
        "http://www.google.com/",
        "US",
        Platform.IPAD)
        //.setAsync("http://www.google.pt")
        .build();

    TestResult testResult = OffertestRequestIO.sendRequest(offerSyncRequest);
    System.out.println(testResult);


  }





}
