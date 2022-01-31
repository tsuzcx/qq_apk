package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase
{
  protected static final String LOGTAG = "webviewdatabase";
  private static WebViewDatabase mInstance;
  private Context mContext;
  private android.webkit.WebViewDatabase mSysWebViewDatabase;
  
  protected WebViewDatabase(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static WebViewDatabase createInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WebViewDatabase(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    return createInstance(paramContext);
  }
  
  public void clearFormData()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webViewDatabaseClearFormData(this.mContext);
      return;
    }
    this.mSysWebViewDatabase.clearFormData();
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webViewDatabaseClearHttpAuthUsernamePassword(this.mContext);
      return;
    }
    this.mSysWebViewDatabase.clearHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().webViewDatabaseClearUsernamePassword(this.mContext);
      return;
    }
    this.mSysWebViewDatabase.clearUsernamePassword();
  }
  
  public boolean hasFormData()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().webViewDatabaseHasFormData(this.mContext);
    }
    return this.mSysWebViewDatabase.hasFormData();
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().webViewDatabaseHasHttpAuthUsernamePassword(this.mContext);
    }
    return this.mSysWebViewDatabase.hasHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().webViewDatabaseHasUsernamePassword(this.mContext);
    }
    return this.mSysWebViewDatabase.hasUsernamePassword();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewDatabase
 * JD-Core Version:    0.7.0.1
 */