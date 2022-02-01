package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.huawei.hms.aaid.c.c;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper
{
  public static void doAutoInit(Context paramContext)
  {
    try
    {
      if (isAutoInitEnabled(paramContext))
      {
        HMSLog.i("AutoInit", "Push init start");
        new Thread(new a(paramContext)).start();
      }
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("AutoInit", "Push init failed", paramContext);
    }
  }
  
  public static boolean isAutoInitEnabled(Context paramContext)
  {
    c localc = new c(paramContext, "push_client_self_info");
    if (localc.d("push_kit_auto_init_enabled")) {
      return localc.a("push_kit_auto_init_enabled");
    }
    try
    {
      boolean bool = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static void setAutoInitEnabled(Context paramContext, boolean paramBoolean)
  {
    new c(paramContext, "push_client_self_info").a("push_kit_auto_init_enabled", paramBoolean);
    if (paramBoolean) {
      doAutoInit(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.init.AutoInitHelper
 * JD-Core Version:    0.7.0.1
 */