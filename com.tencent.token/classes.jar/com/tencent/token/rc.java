package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.VpnService;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class rc
{
  private static e a(Context paramContext)
  {
    d locald = new d();
    e locale = new e();
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ChooseLockGeneric"));
    paramContext = paramContext.getPackageManager();
    if (paramContext != null) {}
    try
    {
      paramContext = paramContext.queryIntentActivities(localIntent, 65536);
    }
    catch (Throwable paramContext)
    {
      label60:
      break label60;
    }
    paramContext = null;
    if ((paramContext != null) && (paramContext.size() != 0) && (((ResolveInfo)paramContext.get(0)).activityInfo.exported))
    {
      locald.d = "com.android.settings";
      locald.e = "com.android.settings.ChooseLockGeneric";
      locale.h = 8;
    }
    else
    {
      locald.a = "android.settings.SETTINGS";
      locale.h = 1;
    }
    locald.f = 276856832;
    locale.a = locald;
    locale.b = "取消系统锁屏获得更好体验\n关闭后可设置新锁屏的密码";
    locale.e = 2;
    locale.i = 1;
    return locale;
  }
  
  public static e a(Context paramContext, int paramInt)
  {
    Object localObject1;
    if (paramInt != 30104)
    {
      if (paramInt != 30118)
      {
        if (paramInt != 30123)
        {
          if (paramInt != 30125) {
            return null;
          }
          return b(paramContext);
        }
        paramContext = new d();
        paramContext.a = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
        paramContext.f = 276856832;
        localObject1 = new e();
        ((e)localObject1).a = paramContext;
        ((e)localObject1).b = "开启“直接进入系统”获得更好体验，关闭后即可防止出现双锁屏";
        ((e)localObject1).e = 2;
        ((e)localObject1).h = 1;
        ((e)localObject1).i = 1;
        return localObject1;
      }
      return a(paramContext);
    }
    if (a(new String[] { "xiaomi" }))
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      Object localObject2 = new Intent();
      localObject1 = paramContext.getPackageManager();
      ((Intent)localObject2).setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsContainerManagementActivity"));
      localObject1 = ((PackageManager)localObject1).resolveActivity((Intent)localObject2, 0);
      Object localObject3;
      if ((localObject1 != null) && (((ResolveInfo)localObject1).activityInfo != null) && (((ResolveInfo)localObject1).activityInfo.exported))
      {
        localObject1 = new e();
        localObject3 = new d();
        ((d)localObject3).e = ((Intent)localObject2).getComponent().getClassName();
        ((d)localObject3).d = ((Intent)localObject2).getComponent().getPackageName();
        ((d)localObject3).f = 276856832;
        ((e)localObject1).a = ((d)localObject3);
        ((e)localObject1).h = 8;
        ((e)localObject1).i = 1;
        ((e)localObject1).e = 1;
        ((e)localObject1).g = true;
        ((e)localObject1).f = new ArrayList();
        ((e)localObject1).f.add("xiaomi_ps_1_1_72.png");
        ((e)localObject1).f.add("xiaomi_ps_1_2_72.png");
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null) {
        paramContext = (Context)localObject1;
      }
      do
      {
        return paramContext;
        localObject3 = new Intent();
        localObject1 = paramContext.getPackageManager();
        ((Intent)localObject3).setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.appscontainer.HiddenAppsContainerManagementActivity"));
        localObject1 = ((PackageManager)localObject1).resolveActivity((Intent)localObject3, 0);
        Object localObject4;
        if ((localObject1 != null) && (((ResolveInfo)localObject1).activityInfo != null) && (((ResolveInfo)localObject1).activityInfo.exported))
        {
          localObject2 = c(paramContext);
          localObject1 = new e();
          localObject4 = new d();
          ((d)localObject4).f = 276856832;
          ((d)localObject4).e = ((Intent)localObject3).getComponent().getClassName();
          ((d)localObject4).d = ((Intent)localObject3).getComponent().getPackageName();
          localObject3 = new ArrayList();
          a locala = new a();
          locala.c = 1;
          locala.a = "group_id";
          locala.b = "5";
          ((ArrayList)localObject3).add(locala);
          ((d)localObject4).h = ((ArrayList)localObject3);
          ((e)localObject1).a = ((d)localObject4);
          ((e)localObject1).h = 8;
          ((e)localObject1).i = 1;
          ((e)localObject1).e = 2;
          localObject3 = new StringBuilder("1、找到“");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("”，点击进入\r\n2、然后点击“自定义配置”，选择“保持联网”");
          ((e)localObject1).b = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject1 = null;
        }
        if (localObject1 != null) {
          return localObject1;
        }
        localObject1 = new Intent();
        localObject2 = paramContext.getPackageManager();
        ((Intent)localObject1).setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.appscontainer.AppsContainerManagementActivity"));
        localObject2 = ((PackageManager)localObject2).resolveActivity((Intent)localObject1, 0);
        if ((localObject2 != null) && (((ResolveInfo)localObject2).activityInfo != null) && (((ResolveInfo)localObject2).activityInfo.exported))
        {
          localObject2 = c(paramContext);
          paramContext = new e();
          localObject3 = new d();
          ((d)localObject3).f = 276856832;
          ((d)localObject3).e = ((Intent)localObject1).getComponent().getClassName();
          ((d)localObject3).d = ((Intent)localObject1).getComponent().getPackageName();
          localObject1 = new ArrayList();
          localObject4 = new a();
          ((a)localObject4).c = 1;
          ((a)localObject4).a = "group_id";
          ((a)localObject4).b = "5";
          ((ArrayList)localObject1).add(localObject4);
          ((d)localObject3).h = ((ArrayList)localObject1);
          paramContext.a = ((d)localObject3);
          paramContext.h = 8;
          paramContext.i = 1;
          paramContext.e = 2;
          localObject1 = new StringBuilder("1、找到“");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("”，取消右边的“√”\r\n2、点击右上角“确定”");
          paramContext.b = ((StringBuilder)localObject1).toString();
        }
        else
        {
          paramContext = null;
        }
      } while (paramContext != null);
    }
    return null;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
    }
    catch (Throwable localThrowable1)
    {
      Object localObject2;
      Object localObject3;
      label29:
      label31:
      int i;
      break label29;
    }
    try
    {
      localObject3 = Build.BRAND.toLowerCase(Locale.getDefault());
      localObject1 = localObject3;
    }
    catch (Throwable localThrowable2)
    {
      break label31;
    }
    localObject2 = null;
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = "";
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    i = 0;
    while (i <= 0)
    {
      localObject1 = paramArrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).toLowerCase(Locale.getDefault());
        if ((((String)localObject3).contains((CharSequence)localObject1)) || (((String)localObject2).contains((CharSequence)localObject1))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private static e b(Context paramContext)
  {
    if (paramContext != null) {
      if (Build.VERSION.SDK_INT < 14) {
        return null;
      }
    }
    try
    {
      paramContext = VpnService.prepare(paramContext);
    }
    catch (Throwable paramContext)
    {
      label22:
      d locald;
      break label22;
    }
    paramContext = null;
    if (paramContext == null) {
      return null;
    }
    locald = new d();
    locald.a = paramContext.getAction();
    locald.b = paramContext.getDataString();
    locald.c = paramContext.getType();
    locald.d = paramContext.getComponent().getPackageName();
    locald.e = paramContext.getComponent().getClassName();
    locald.f = paramContext.getFlags();
    paramContext = new e();
    paramContext.a = locald;
    paramContext.e = 0;
    paramContext.h = 0;
    paramContext.i = 1;
    return paramContext;
    return null;
  }
  
  private static String c(Context paramContext)
  {
    return paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rc
 * JD-Core Version:    0.7.0.1
 */