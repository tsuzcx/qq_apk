package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;

public abstract class ActiveSyncResponse
{
  protected String cmdSubType;
  protected String cmdType;
  protected HttpResponse httpResponse;
  
  public ActiveSyncResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    this.cmdType = paramString1;
    this.cmdSubType = paramString2;
    this.httpResponse = paramHttpResponse;
  }
  
  public String getCmdSubType()
  {
    return this.cmdSubType;
  }
  
  public String getCmdType()
  {
    return this.cmdType;
  }
  
  public int getErrorCode()
  {
    return this.httpResponse.getCode();
  }
  
  public String getErrorMsg()
  {
    return this.httpResponse.getMessage();
  }
  
  public int getHttpCode()
  {
    return this.httpResponse.getCode();
  }
  
  public HttpResponse getHttpResponse()
  {
    return this.httpResponse;
  }
  
  public boolean isOk()
  {
    return this.httpResponse.isOk();
  }
  
  public abstract boolean parseResponse();
  
  public void setCmdSubType(String paramString)
  {
    this.cmdSubType = paramString;
  }
  
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.ActiveSyncResponse
 * JD-Core Version:    0.7.0.1
 */