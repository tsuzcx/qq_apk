package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage
{
  private static WebStorage a;
  
  private static WebStorage a()
  {
    try
    {
      if (a == null) {
        a = new WebStorage();
      }
      WebStorage localWebStorage = a;
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    return a();
  }
  
  public void deleteAllData()
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().n();
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
  }
  
  public void deleteOrigin(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().e(paramString);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().a(paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().b(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().a(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().a(paramString, paramLong);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
  }
  
  @Deprecated
  public static abstract interface QuotaUpdater
  {
    public abstract void updateQuota(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage
 * JD-Core Version:    0.7.0.1
 */