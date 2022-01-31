package com.qzone.download.strategy;

import com.qzone.download.DownloadResult;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public abstract interface DownloadProcessStrategy
{
  public abstract DownloadPool getDownloadPool(String paramString);
  
  public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
  
  public abstract void prepareRequest(String paramString, HttpRequest paramHttpRequest);
  
  public static enum DownloadPool
  {
    COMMON("common"),  SPECIFIC("specific"),  SPECIFIC1("specific1");
    
    private static final int SIZE = 3;
    final String name;
    
    private DownloadPool(String paramString)
    {
      this.name = paramString;
    }
    
    public static int size()
    {
      return 3;
    }
    
    public String getName()
    {
      return this.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.DownloadProcessStrategy
 * JD-Core Version:    0.7.0.1
 */