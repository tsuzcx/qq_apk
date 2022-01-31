package com.tencent.smtt.sdk;

import java.util.Set;

public class GeolocationPermissions
{
  private static GeolocationPermissions mInstance;
  private android.webkit.GeolocationPermissions mSysInstance = android.webkit.GeolocationPermissions.getInstance();
  
  private static GeolocationPermissions createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = mInstance;
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    return createInstance();
  }
  
  public void allow(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().geolocationPermissionsAllow(paramString);
      return;
    }
    this.mSysInstance.allow(paramString);
  }
  
  public void clear(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().geolocationPermissionsClear(paramString);
      return;
    }
    this.mSysInstance.clear(paramString);
  }
  
  public void clearAll()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().geolocationPermissionsClearAll();
      return;
    }
    this.mSysInstance.clearAll();
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().geolocationPermissionsGetAllowed(paramString, paramValueCallback);
      return;
    }
    this.mSysInstance.getAllowed(paramString, paramValueCallback);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().geolocationPermissionsGetOrigins(paramValueCallback);
      return;
    }
    this.mSysInstance.getOrigins(paramValueCallback);
  }
  
  public static abstract interface Callback
  {
    public abstract void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.GeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */