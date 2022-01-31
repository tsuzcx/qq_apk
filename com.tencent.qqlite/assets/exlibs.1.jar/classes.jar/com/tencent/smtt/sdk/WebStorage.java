package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage
{
  private static WebStorage mInstance;
  private android.webkit.WebStorage mSysWebStorage = android.webkit.WebStorage.getInstance();
  
  private static WebStorage createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WebStorage();
      }
      WebStorage localWebStorage = mInstance;
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    return createInstance();
  }
  
  public void deleteAllData()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webStorageDeleteAllData();
      return;
    }
    this.mSysWebStorage.deleteAllData();
  }
  
  public void deleteOrigin(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webStorageDeleteOrigin(paramString);
      return;
    }
    this.mSysWebStorage.deleteOrigin(paramString);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webStorageGetOrigins(paramValueCallback);
      return;
    }
    this.mSysWebStorage.getOrigins(paramValueCallback);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webStorageGetQuotaForOrigin(paramString, paramValueCallback);
      return;
    }
    this.mSysWebStorage.getQuotaForOrigin(paramString, paramValueCallback);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webStorageGetUsageForOrigin(paramString, paramValueCallback);
      return;
    }
    this.mSysWebStorage.getUsageForOrigin(paramString, paramValueCallback);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webStorageSetQuotaForOrigin(paramString, paramLong);
      return;
    }
    this.mSysWebStorage.setQuotaForOrigin(paramString, paramLong);
  }
  
  public static class Origin
  {
    private String mOrigin = null;
    private long mQuota = 0L;
    private long mUsage = 0L;
    
    protected Origin(String paramString)
    {
      this.mOrigin = paramString;
    }
    
    protected Origin(String paramString, long paramLong)
    {
      this.mOrigin = paramString;
      this.mQuota = paramLong;
    }
    
    protected Origin(String paramString, long paramLong1, long paramLong2)
    {
      this.mOrigin = paramString;
      this.mQuota = paramLong1;
      this.mUsage = paramLong2;
    }
    
    public String getOrigin()
    {
      return this.mOrigin;
    }
    
    public long getQuota()
    {
      return this.mQuota;
    }
    
    public long getUsage()
    {
      return this.mUsage;
    }
  }
  
  @Deprecated
  public static abstract interface QuotaUpdater
  {
    public abstract void updateQuota(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage
 * JD-Core Version:    0.7.0.1
 */