package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public abstract interface ResumeTransfer
{
  public abstract void addCacheTmpFile(String paramString1, String paramString2, HttpResponse paramHttpResponse);
  
  public abstract String getResumeTmpFile(String paramString);
  
  public abstract boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse);
  
  public abstract void onDownloadResult(String paramString, boolean paramBoolean);
  
  public abstract void prepareRequest(HttpGet paramHttpGet, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ResumeTransfer
 * JD-Core Version:    0.7.0.1
 */