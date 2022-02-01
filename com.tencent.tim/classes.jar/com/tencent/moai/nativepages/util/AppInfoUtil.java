package com.tencent.moai.nativepages.util;

import android.content.Context;

public class AppInfoUtil
{
  private static AppOperationDelegate delegate;
  
  public static boolean downloadApp(Context paramContext, String paramString1, String paramString2)
  {
    return delegate.downloadApp(paramContext, paramString1, paramString2);
  }
  
  public static boolean isAppInstalled(Context paramContext, String paramString)
  {
    return delegate.isAppInstalled(paramContext, paramString);
  }
  
  public static boolean openApp(Context paramContext, String paramString)
  {
    return delegate.openApp(paramContext, paramString);
  }
  
  public static boolean openUrl(Context paramContext, String paramString)
  {
    return delegate.openUrl(paramContext, paramString);
  }
  
  public static void setDelegate(AppOperationDelegate paramAppOperationDelegate)
  {
    delegate = paramAppOperationDelegate;
  }
  
  public static abstract interface AppOperationDelegate
  {
    public abstract boolean downloadApp(Context paramContext, String paramString1, String paramString2);
    
    public abstract boolean isAppInstalled(Context paramContext, String paramString);
    
    public abstract boolean openApp(Context paramContext, String paramString);
    
    public abstract boolean openUrl(Context paramContext, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.AppInfoUtil
 * JD-Core Version:    0.7.0.1
 */