package com.mobrand.offertest.example;

public class OffertestRequest {

  private String userid;
  private String url;
  private String country;
  private Platform platform;
  private int platformVersion;
  private String carrier;
  private String city;
  private boolean mobile;
  private String expectedBundleId;
  private String apiKey;
  private String callback;

  private OffertestRequest(
      String userid,
      String url,
      String country,
      Platform platform,
      int platformVersion,
      String carrier,
      String city,
      boolean mobile,
      String expectedBundleId,
      String apiKey,
      String callback
  ) {
    this.userid = userid;
    this.url = url;
    this.country = country;
    this.platform = platform;
    this.platformVersion = platformVersion;
    this.carrier = carrier;
    this.city = city;
    this.mobile = mobile;
    this.expectedBundleId = expectedBundleId;
    this.apiKey = apiKey;
    this.callback = callback;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Platform getPlatform() {
    return platform;
  }

  public void setPlatform(Platform platform) {
    this.platform = platform;
  }

  public int getPlatformVersion() {
    return platformVersion;
  }

  public void setPlatformVersion(int platformVersion) {
    this.platformVersion = platformVersion;
  }

  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public boolean isMobile() {
    return mobile;
  }

  public void setMobile(boolean mobile) {
    this.mobile = mobile;
  }

  public String getExpectedBundleId() {
    return expectedBundleId;
  }

  public void setExpectedBundleId(String expectedBundleId) {
    this.expectedBundleId = expectedBundleId;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getCallback() {
    return callback;
  }

  public void setCallback(String callback) {
    this.callback = callback;
  }

  public boolean isAsync(){
    return callback != null;
  }

  public static class Builder {

    private String userid;
    private String url;
    private String country;
    private Platform platform;
    private int platformVersion;
    private String carrier;
    private String city;
    private boolean mobile;
    private String expectedBundleId;
    private String apiKey;
    private String callback;

    public Builder(OffertestConfig config, String url, String country, Platform platform) {
      this.userid = config.getUserid();
      this.apiKey = config.getApiKey();
      this.url = url;
      this.country = country;
      this.platform = platform;
    }

    public Builder setUserid(String userid) {
      this.userid = userid;
      return this;
    }

    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    public Builder setCountry(String country) {
      this.country = country;
      return this;
    }

    public Builder setPlatform(Platform platform) {
      this.platform = platform;
      return this;
    }

    public Builder setPlatformVersion(int platformVersion) {
      this.platformVersion = platformVersion;
      return this;
    }

    public Builder setCarrier(String carrier) {
      this.carrier = carrier;
      return this;
    }

    public Builder setCity(String city) {
      this.city = city;
      return this;
    }

    public Builder setMobile(boolean mobile) {
      this.mobile = mobile;
      return this;
    }

    public Builder setExpectedBundleId(String expectedBundleId) {
      this.expectedBundleId = expectedBundleId;
      return this;
    }

    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder setAsync(String callback) {
      this.callback = callback;
      return this;
    }

    public OffertestRequest build() {
      return new OffertestRequest(
          userid,
          url,
          country,
          platform,
          platformVersion,
          carrier,
          city,
          mobile,
          expectedBundleId,
          apiKey,
          callback
      );
    }
  }



}