package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MBundle;
import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
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

public class c
{
  private static MSolution a()
  {
    MIntent localMIntent = new MIntent();
    localMIntent.mAction = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
    localMIntent.mFlags = 276856832;
    MSolution localMSolution = new MSolution();
    localMSolution.mJumpIntent = localMIntent;
    localMSolution.mHelpInfo = "开启“直接进入系统”获得更好体验，关闭后即可防止出现双锁屏";
    localMSolution.mHelpStyle = 2;
    localMSolution.mIntentCheck = 1;
    localMSolution.mVersion = 1;
    return localMSolution;
  }
  
  private static MSolution a(Context paramContext)
  {
    MIntent localMIntent = new MIntent();
    MSolution localMSolution = new MSolution();
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ChooseLockGeneric"));
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    paramContext = localObject;
    if (localPackageManager != null) {}
    try
    {
      paramContext = localPackageManager.queryIntentActivities(localIntent, 65536);
      if ((paramContext == null) || (paramContext.size() == 0) || (!((ResolveInfo)paramContext.get(0)).activityInfo.exported)) {
        localMIntent.mAction = "android.settings.SETTINGS";
      }
      for (localMSolution.mIntentCheck = 1;; localMSolution.mIntentCheck = 8)
      {
        localMIntent.mFlags = 276856832;
        localMSolution.mJumpIntent = localMIntent;
        localMSolution.mHelpInfo = "取消系统锁屏获得更好体验\n关闭后可设置新锁屏的密码";
        localMSolution.mHelpStyle = 2;
        localMSolution.mVersion = 1;
        return localMSolution;
        localMIntent.mPackage = "com.android.settings";
        localMIntent.mClass = "com.android.settings.ChooseLockGeneric";
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static MSolution a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 30118: 
      return a(paramContext);
    case 30123: 
      return a();
    case 30125: 
      return b(paramContext);
    }
    return c(paramContext);
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString == null) {
      arrayOfString = new String[0];
    }
    try
    {
      paramArrayOfString = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
    }
    catch (Throwable paramArrayOfString)
    {
      for (;;)
      {
        Object localObject2;
        label46:
        int j;
        int i;
        paramArrayOfString = null;
        Object localObject1 = paramArrayOfString;
        paramArrayOfString = null;
        continue;
        i += 1;
      }
    }
    try
    {
      localObject2 = Build.BRAND.toLowerCase(Locale.getDefault());
      localObject1 = paramArrayOfString;
      paramArrayOfString = (String[])localObject2;
      if (localObject1 != null) {
        break label130;
      }
      localObject1 = "";
    }
    catch (Throwable localThrowable)
    {
      break label110;
      break label46;
    }
    localObject2 = paramArrayOfString;
    if (paramArrayOfString == null) {
      localObject2 = "";
    }
    j = arrayOfString.length;
    i = 0;
    if (i < j)
    {
      paramArrayOfString = arrayOfString[i];
      if (!TextUtils.isEmpty(paramArrayOfString))
      {
        paramArrayOfString = paramArrayOfString.toLowerCase(Locale.getDefault());
        if ((((String)localObject1).contains(paramArrayOfString)) || (((String)localObject2).contains(paramArrayOfString))) {
          return true;
        }
      }
    }
    label110:
    return false;
  }
  
  private static MSolution b(Context paramContext)
  {
    if ((paramContext == null) || (Build.VERSION.SDK_INT < 14)) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = VpnService.prepare(paramContext);
        if (paramContext == null) {
          continue;
        }
        MIntent localMIntent = new MIntent();
        localMIntent.mAction = paramContext.getAction();
        localMIntent.mUri = paramContext.getDataString();
        localMIntent.mType = paramContext.getType();
        localMIntent.mPackage = paramContext.getComponent().getPackageName();
        localMIntent.mClass = paramContext.getComponent().getClassName();
        localMIntent.mFlags = paramContext.getFlags();
        paramContext = new MSolution();
        paramContext.mJumpIntent = localMIntent;
        paramContext.mHelpStyle = 0;
        paramContext.mIntentCheck = 0;
        paramContext.mVersion = 1;
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
    }
  }
  
  private static MSolution c(Context paramContext)
  {
    Object localObject;
    if ((!a(new String[] { "xiaomi" })) || (Build.VERSION.SDK_INT >= 23)) {
      localObject = null;
    }
    do
    {
      MSolution localMSolution;
      do
      {
        do
        {
          return localObject;
          localMSolution = d(paramContext);
          localObject = localMSolution;
        } while (localMSolution != null);
        localMSolution = e(paramContext);
        localObject = localMSolution;
      } while (localMSolution != null);
      paramContext = f(paramContext);
      localObject = paramContext;
    } while (paramContext != null);
    return null;
  }
  
  private static MSolution d(Context paramContext)
  {
    Intent localIntent = new Intent();
    paramContext = paramContext.getPackageManager();
    localIntent.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsContainerManagementActivity"));
    paramContext = paramContext.resolveActivity(localIntent, 0);
    if ((paramContext != null) && (paramContext.activityInfo != null) && (paramContext.activityInfo.exported))
    {
      paramContext = new MSolution();
      MIntent localMIntent = new MIntent();
      localMIntent.mClass = localIntent.getComponent().getClassName();
      localMIntent.mPackage = localIntent.getComponent().getPackageName();
      localMIntent.mFlags = 276856832;
      paramContext.mJumpIntent = localMIntent;
      paramContext.mIntentCheck = 8;
      paramContext.mVersion = 1;
      paramContext.mHelpStyle = 1;
      paramContext.mHelpImageLocal = true;
      paramContext.mHelpImageList = new ArrayList();
      paramContext.mHelpImageList.add("xiaomi_ps_1_1_72.png");
      paramContext.mHelpImageList.add("xiaomi_ps_1_2_72.png");
      return paramContext;
    }
    return null;
  }
  
  private static MSolution e(Context paramContext)
  {
    Object localObject1 = new Intent();
    Object localObject2 = paramContext.getPackageManager();
    ((Intent)localObject1).setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.appscontainer.HiddenAppsContainerManagementActivity"));
    localObject2 = ((PackageManager)localObject2).resolveActivity((Intent)localObject1, 0);
    if ((localObject2 != null) && (((ResolveInfo)localObject2).activityInfo != null) && (((ResolveInfo)localObject2).activityInfo.exported))
    {
      paramContext = g(paramContext);
      localObject2 = new MSolution();
      MIntent localMIntent = new MIntent();
      localMIntent.mFlags = 276856832;
      localMIntent.mClass = ((Intent)localObject1).getComponent().getClassName();
      localMIntent.mPackage = ((Intent)localObject1).getComponent().getPackageName();
      localObject1 = new ArrayList();
      MBundle localMBundle = new MBundle();
      localMBundle.mValueType = 1;
      localMBundle.mKey = "group_id";
      localMBundle.mValue = "5";
      ((ArrayList)localObject1).add(localMBundle);
      localMIntent.mExtras = ((ArrayList)localObject1);
      ((MSolution)localObject2).mJumpIntent = localMIntent;
      ((MSolution)localObject2).mIntentCheck = 8;
      ((MSolution)localObject2).mVersion = 1;
      ((MSolution)localObject2).mHelpStyle = 2;
      ((MSolution)localObject2).mHelpInfo = ("1、找到“" + paramContext + "”，点击进入\r\n2、然后点击“自定义配置”，选择“保持联网”");
      return localObject2;
    }
    return null;
  }
  
  private static MSolution f(Context paramContext)
  {
    Object localObject1 = new Intent();
    Object localObject2 = paramContext.getPackageManager();
    ((Intent)localObject1).setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.appscontainer.AppsContainerManagementActivity"));
    localObject2 = ((PackageManager)localObject2).resolveActivity((Intent)localObject1, 0);
    if ((localObject2 != null) && (((ResolveInfo)localObject2).activityInfo != null) && (((ResolveInfo)localObject2).activityInfo.exported))
    {
      paramContext = g(paramContext);
      localObject2 = new MSolution();
      MIntent localMIntent = new MIntent();
      localMIntent.mFlags = 276856832;
      localMIntent.mClass = ((Intent)localObject1).getComponent().getClassName();
      localMIntent.mPackage = ((Intent)localObject1).getComponent().getPackageName();
      localObject1 = new ArrayList();
      MBundle localMBundle = new MBundle();
      localMBundle.mValueType = 1;
      localMBundle.mKey = "group_id";
      localMBundle.mValue = "5";
      ((ArrayList)localObject1).add(localMBundle);
      localMIntent.mExtras = ((ArrayList)localObject1);
      ((MSolution)localObject2).mJumpIntent = localMIntent;
      ((MSolution)localObject2).mIntentCheck = 8;
      ((MSolution)localObject2).mVersion = 1;
      ((MSolution)localObject2).mHelpStyle = 2;
      ((MSolution)localObject2).mHelpInfo = ("1、找到“" + paramContext + "”，取消右边的“√”\r\n2、点击右上角“确定”");
      return localObject2;
    }
    return null;
  }
  
  private static String g(Context paramContext)
  {
    return paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.c
 * JD-Core Version:    0.7.0.1
 */