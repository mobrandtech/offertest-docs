package com.mobrand.offertest.example;

public class OffertestConfig {

  private String userid;
  private String apiKey;

  public OffertestConfig(String userid, String apiKey) {
    this.userid = userid;
    this.apiKey = apiKey;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }
}
