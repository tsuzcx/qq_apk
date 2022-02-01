package com.tencent.token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public final class aoc
{
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext != null;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        return paramContext;
      }
      return null;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int c(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        return i;
      }
      return 0;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoc
 * JD-Core Version:    0.7.0.1
 */