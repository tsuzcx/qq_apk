package com.tencent.moai.downloader.network;

import android.annotation.TargetApi;

public class HttpError
  extends Throwable
{
  private int errorCode;
  private String url;
  
  public HttpError(int paramInt, String paramString)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public HttpError(int paramInt, String paramString1, String paramString2)
  {
    super(paramString2);
    this.errorCode = paramInt;
    this.url = paramString1;
  }
  
  public HttpError(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString2, paramThrowable);
    this.errorCode = paramInt;
    this.url = paramString1;
  }
  
  @TargetApi(19)
  protected HttpError(int paramInt, String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString2, paramThrowable, paramBoolean1, paramBoolean2);
    this.errorCode = paramInt;
    this.url = paramString1;
  }
  
  public HttpError(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.errorCode = paramInt;
    this.url = paramString;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpError
 * JD-Core Version:    0.7.0.1
 */