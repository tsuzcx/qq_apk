package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;

public abstract class ExchangeResponse
{
  protected String cmdType;
  protected HttpResponse httpResponse;
  protected String responseCode;
  
  public ExchangeResponse(String paramString, HttpResponse paramHttpResponse)
  {
    this.cmdType = paramString;
    this.httpResponse = paramHttpResponse;
  }
  
  public String getCmdType()
  {
    return this.cmdType;
  }
  
  public int getHttpCode()
  {
    return this.httpResponse.getCode();
  }
  
  public HttpResponse getHttpResponse()
  {
    return this.httpResponse;
  }
  
  public String getResponseCode()
  {
    return this.responseCode;
  }
  
  public boolean isOk()
  {
    return this.httpResponse.isOk();
  }
  
  public abstract boolean parseResponse();
  
  public void setCmdType(String paramString)
  {
    this.cmdType = paramString;
  }
  
  public void setHttpResponse(HttpResponse paramHttpResponse)
  {
    this.httpResponse = paramHttpResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.ExchangeResponse
 * JD-Core Version:    0.7.0.1
 */