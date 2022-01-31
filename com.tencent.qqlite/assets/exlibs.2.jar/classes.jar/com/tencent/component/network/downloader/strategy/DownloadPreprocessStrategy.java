package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface DownloadPreprocessStrategy
{
  public abstract DownloadPool downloadPool(String paramString1, String paramString2);
  
  public abstract void prepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest);
  
  public static enum DownloadPool
  {
    private String a;
    
    private DownloadPool(String paramString)
    {
      this.a = paramString;
    }
    
    public static int size()
    {
      return 2;
    }
    
    public final String getName()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy
 * JD-Core Version:    0.7.0.1
 */