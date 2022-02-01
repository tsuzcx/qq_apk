package com.huawei.hianalytics.ab.bc.kl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.File;

public class bc
{
  public static boolean ab(Context paramContext)
  {
    long l = com.huawei.hianalytics.ab.bc.ij.ab.bc(paramContext, "Privacy_MY", "flashKeyTime", -1L);
    return System.currentTimeMillis() - l > 43200000L;
  }
  
  public static boolean ab(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return true;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) != 0)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "not have read phone permission!");
        return true;
      }
    }
    else if (paramContext.checkSelfPermission(paramString) != 0)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "not have read phone permission!");
      return true;
    }
    return false;
  }
  
  @SuppressLint({"DefaultLocale"})
  public static boolean ab(Context paramContext, String paramString, int paramInt)
  {
    paramString = com.huawei.hianalytics.ab.bc.ij.ab.ab(paramContext, paramString) + ".xml";
    long l = new File(paramContext.getFilesDir(), "../shared_prefs/" + paramString).length();
    if (l > paramInt)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) }));
      return true;
    }
    return false;
  }
  
  public static boolean ab(String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return true;
      try
      {
        long l = Long.parseLong(paramString);
        if (paramLong1 - l <= paramLong2) {
          return false;
        }
      }
      catch (NumberFormatException paramString)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("TaskAssistant", "isTimeExpired(): Data type conversion error : number format !");
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.kl.bc
 * JD-Core Version:    0.7.0.1
 */