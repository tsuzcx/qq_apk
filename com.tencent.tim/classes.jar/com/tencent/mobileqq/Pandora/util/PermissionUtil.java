package com.tencent.mobileqq.Pandora.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

public class PermissionUtil
{
  private static final String TAG = "PermissionUtil";
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (;;)
    {
      try
      {
        int i = paramContext.checkSelfPermission(paramString);
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("PermissionUtil", "CheckSelfPermission is excepiton", paramContext);
        bool = false;
        continue;
      }
      Log.d("CheckPermission", "CheckPermissonisGrant = " + bool);
      return bool;
      bool = false;
      continue;
      if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) != 0) {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.util.PermissionUtil
 * JD-Core Version:    0.7.0.1
 */