package com.mobrand.offertest.example;

import java.util.List;

public class TestResult{

  private String id;
  private int nRedir;
  private List<Test> urls;
  private boolean bundleIdMatch;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getnRedir() {
    return nRedir;
  }

  public void setnRedir(int nRedir) {
    this.nRedir = nRedir;
  }

  public List<Test> getUrls() {
    return urls;
  }

  public void setUrls(List<Test> urls) {
    this.urls = urls;
  }

  public boolean isBundleIdMatch() {
    return bundleIdMatch;
  }

  public void setBundleIdMatch(boolean bundleIdMatch) {
    this.bundleIdMatch = bundleIdMatch;
  }

  @Override
  public String toString() {
    return "TestResult{" + "id='" + id + '\'' + ", nRedir=" + nRedir + ", urls=" + urls + ", bundleIdMatch="
        + bundleIdMatch + '}';
  }

  public static class Test{
    private String url;
    private String contentType;
    private int code;

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getContentType() {
      return contentType;
    }

    public void setContentType(String contentType) {
      this.contentType = contentType;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    @Override
    public String toString() {
      return "Test{" + "url='" + url + '\'' + ", contentType='" + contentType + '\'' + ", code=" + code + '}';
    }

  }

}