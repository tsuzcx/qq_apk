package com.tencent.token;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Process;

public final class dm
{
  public static int a(Context paramContext, String paramString)
  {
    int i = Process.myPid();
    int j = Process.myUid();
    String str = paramContext.getPackageName();
    if (paramContext.checkPermission(paramString, i, j) == -1) {
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      paramString = AppOpsManager.permissionToOp(paramString);
    } else {
      paramString = null;
    }
    if (paramString != null)
    {
      Object localObject = str;
      if (str == null)
      {
        localObject = paramContext.getPackageManager().getPackagesForUid(j);
        if (localObject != null)
        {
          if (localObject.length <= 0) {
            return -1;
          }
          localObject = localObject[0];
        }
        else
        {
          return -1;
        }
      }
      if (Build.VERSION.SDK_INT >= 23) {
        i = ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString, (String)localObject);
      } else {
        i = 1;
      }
      if (i != 0) {
        return -2;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dm
 * JD-Core Version:    0.7.0.1
 */