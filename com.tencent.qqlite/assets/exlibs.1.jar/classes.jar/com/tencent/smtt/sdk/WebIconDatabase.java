package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase mInstance;
  private android.webkit.WebIconDatabase mSysWebIconDatabase = android.webkit.WebIconDatabase.getInstance();
  
  private static WebIconDatabase createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = mInstance;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return createInstance();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, IconListener paramIconListener) {}
  
  public void close()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().closeIconDB();
      return;
    }
    this.mSysWebIconDatabase.close();
  }
  
  public void open(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().openIconDB(paramString);
      return;
    }
    this.mSysWebIconDatabase.open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().releaseIconForPageUrl(paramString);
      return;
    }
    this.mSysWebIconDatabase.releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().removeAllIcons();
      return;
    }
    this.mSysWebIconDatabase.removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, final IconListener paramIconListener)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().requestIconForPageUrl(paramString, new IconListener()
      {
        public void onReceivedIcon(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          paramIconListener.onReceivedIcon(paramAnonymousString, paramAnonymousBitmap);
        }
      });
      return;
    }
    this.mSysWebIconDatabase.requestIconForPageUrl(paramString, new android.webkit.WebIconDatabase.IconListener()
    {
      public void onReceivedIcon(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        paramIconListener.onReceivedIcon(paramAnonymousString, paramAnonymousBitmap);
      }
    });
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().retainIconForPageUrl(paramString);
      return;
    }
    this.mSysWebIconDatabase.retainIconForPageUrl(paramString);
  }
  
  @Deprecated
  public static abstract interface IconListener
  {
    public abstract void onReceivedIcon(String paramString, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */