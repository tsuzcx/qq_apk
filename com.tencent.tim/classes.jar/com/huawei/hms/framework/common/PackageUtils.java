package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageUtils
{
  private static final String TAG = "PackageUtils";
  private static String USER_AGENT = null;
  private static final String VERSION = "4.0.2.300";
  
  public static String getVersionName(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.w("PackageUtils", "", paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.common.PackageUtils
 * JD-Core Version:    0.7.0.1
 */