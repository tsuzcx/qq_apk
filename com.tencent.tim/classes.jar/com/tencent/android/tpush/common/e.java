package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private static final String[] a = { "android.permission.INTERNET", "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE" };
  private static Map<String, Boolean> b = new HashMap(8);
  
  public static boolean a()
  {
    Object localObject1 = b();
    if (localObject1 == null) {
      throw new IllegalArgumentException("The context parameter can not be null!");
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = ((Context)localObject1).getPackageManager();
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((PackageManager)localObject2).getPackageInfo(((Context)localObject1).getPackageName(), 4096).requestedPermissions;
        if (localObject1 == null) {
          return false;
        }
        localObject2 = a;
        int j = localObject2.length;
        i = 0;
        if (i >= j) {
          break;
        }
        String str = localObject2[i];
        boolean bool = a((String[])localObject1, str);
        b.put(str, Boolean.valueOf(bool));
        if (!bool)
        {
          TLogger.ee("PermissionChecker", "The required permission of <" + str + "> does not found!");
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        TLogger.e("PermissionChecker", "check required permissins exception.", localThrowable);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean a(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static Context b()
  {
    if (XGPushManager.getContext() != null) {
      return XGPushManager.getContext();
    }
    return b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.e
 * JD-Core Version:    0.7.0.1
 */