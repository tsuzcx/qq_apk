package com.tencent.moai.downloader.network;

public class HttpParam
{
  private String key;
  private String value;
  
  public HttpParam() {}
  
  public HttpParam(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpParam
 * JD-Core Version:    0.7.0.1
 */