package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.Log;

public final class g
{
  private static String a = null;
  private static Resources b = null;
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "id");
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (b == null) {
      b = paramContext.getResources();
    }
    return b.getIdentifier(paramString1, paramString2, a(paramContext));
  }
  
  private static String a(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getPackageName();
    }
    return a;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "string");
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getResources().getString(a(paramContext, paramString, "string"));
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext)
    {
      Log.e("UpdateSDK", "recource get error name: " + paramString);
    }
    return "";
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "layout");
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "drawable");
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "color");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.g
 * JD-Core Version:    0.7.0.1
 */