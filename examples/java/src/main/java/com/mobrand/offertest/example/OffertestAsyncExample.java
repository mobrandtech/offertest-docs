package com.mobrand.offertest.example;


import com.mobrand.offertest.example.TestResult.Test;
import java.io.IOException;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OffertestAsyncExample {


  private final static String USERID = "YOUR_USER_ID";
  private final static String APIKEY = "YOU_API_KEY";

  public static void main(String[] args) {

    SpringApplication.run(OffertestAsyncExample.class, args);

  }

  @RestController
  public static class OffertestAsyncController{

    @PostMapping(value = "/{id}/result", consumes = "application/json")
    public void getAsyncResponse(@RequestBody TestResult response, @PathVariable("id") String id){


      response.getId();
      response.isBundleIdMatch();
      List<Test> urls = response.getUrls();

      for (Test url : urls) {
        url.getCode();
        url.getContentType();
        url.getUrl();
      }

      System.out.println(response);

    }


  }


  public static class OffertestAsyncClient{

    public static void main(String[] args) {

      try {
        new OffertestAsyncClient().execute();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }


    public void execute() throws IOException {

      OffertestConfig config = new OffertestConfig(USERID, APIKEY);
      OffertestRequest request = new OffertestRequest.Builder(config, "https://www.google.com/", "US", Platform.ANDROID).build();

      //We suggest using ngrok (https://ngrok.com/) to test links locally. This URL must be accessible from Internet.
      request.setCallback("USE_NGROK_URL_TO_TEST_LOCALLY");

      OffertestRequestIO.sendRequest(request);

    }





  }





}
