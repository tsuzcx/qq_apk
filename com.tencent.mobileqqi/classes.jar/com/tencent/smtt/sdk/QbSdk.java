package com.tencent.smtt.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.utils.ReflectionUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

public class QbSdk
{
  public static final String QB_PACKAGE_NAME = "com.tencent.mtt";
  private static final String SHELL_DEX_FILE = "sdk_shell.jar";
  private static final String SHELL_IMPL_CLASS = "com.tencent.mtt.sdk.shell.SdkShell";
  public static final int VERSION = 1;
  private static boolean mIsSysWebViewForced = false;
  private static int sQbVersion;
  private static Class<?> sShellClass;
  private static Object sShellObj;
  
  public static boolean canLoadX5(Context paramContext)
  {
    if (!init(paramContext)) {}
    do
    {
      return false;
      paramContext = ReflectionUtils.invokeInstance(sShellObj, "canLoadX5");
    } while (paramContext == null);
    return ((Boolean)paramContext).booleanValue();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!init(paramContext)) {}
    do
    {
      return false;
      paramContext = ReflectionUtils.invokeStatic(sShellClass, "canOpenMimeFileType", new Class[] { String.class }, new Object[] { paramString });
    } while (paramContext == null);
    return ((Boolean)paramContext).booleanValue();
  }
  
  private static void deleteFiles(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    for (;;)
    {
      return;
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (localObject.isFile()) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  public static void forceSysWebView(boolean paramBoolean)
  {
    mIsSysWebViewForced = paramBoolean;
  }
  
  public static String getX5CoreTimestamp()
  {
    Object localObject = ReflectionUtils.invokeStatic(sShellClass, "getX5CoreTimestamp", null, new Object[0]);
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  private static boolean init(Context paramContext)
  {
    if (mIsSysWebViewForced) {
      return false;
    }
    try
    {
      Object localObject2 = paramContext.getDir("x5core", 0);
      Object localObject1 = paramContext.getPackageManager();
      Object localObject3 = ((PackageManager)localObject1).getPackageInfo("com.tencent.mtt", 0);
      if ((sQbVersion != 0) && (sQbVersion != ((PackageInfo)localObject3).versionCode))
      {
        sShellClass = null;
        sShellObj = null;
        deleteFiles((File)localObject2);
      }
      sQbVersion = ((PackageInfo)localObject3).versionCode;
      if (sShellClass != null) {
        return true;
      }
      localObject3 = paramContext.createPackageContext("com.tencent.mtt", 2);
      File localFile = new File(((Context)localObject3).getDir("x5_share", 0), "sdk_shell.jar");
      if (!localFile.exists())
      {
        localObject2 = new Intent("com.tencent.mtt.ACTION_INSTALL_X5");
        ((Intent)localObject2).setPackage("com.tencent.mtt");
        localObject1 = ((PackageManager)localObject1).queryIntentServices((Intent)localObject2, 0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          paramContext.startService((Intent)localObject2);
        }
      }
      else
      {
        sShellClass = new DexClassLoader(localFile.getAbsolutePath(), ((File)localObject2).getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.mtt.sdk.shell.SdkShell");
        sShellObj = sShellClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { localObject3 });
        ReflectionUtils.invokeInstance(sShellObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label248:
      break label248;
    }
    return false;
  }
  
  public static boolean isSdkVideoServiceFg(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        if (paramContext.size() == 0) {
          return false;
        }
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName != null))
          {
            boolean bool = localRunningAppProcessInfo.processName.contains("com.tencent.mtt:VideoService");
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */