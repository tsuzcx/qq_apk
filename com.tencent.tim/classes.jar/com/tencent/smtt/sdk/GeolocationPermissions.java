package com.tencent.smtt.sdk;

import java.util.Set;

public class GeolocationPermissions
{
  private static GeolocationPermissions a;
  
  private static GeolocationPermissions a()
  {
    try
    {
      if (a == null) {
        a = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = a;
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    return a();
  }
  
  public void allow(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().g(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().allow(paramString);
  }
  
  public void clear(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().f(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clear(paramString);
  }
  
  public void clearAll()
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().o();
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clearAll();
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().c(paramString, paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getAllowed(paramString, paramValueCallback);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().b(paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getOrigins(paramValueCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.GeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */