package com.tencent.smtt.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.ReflectionUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QbSdk
{
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String QB_PACKAGE_NAME;
  public static final double SDKVERSION = 1.3D;
  private static final String SHELL_DEX_FILE = "sdk_shell.jar";
  private static final String SHELL_IMPL_CLASS = "com.tencent.mtt.sdk.shell.SdkShell";
  public static final int SVNVERSION = 246018;
  public static final int VERSION = 1;
  private static boolean isInstalled;
  private static boolean mIsSysWebViewForced;
  private static boolean mIsSysWebViewForcedByOuter;
  public static boolean sIsVersionPrinted = false;
  private static String sQbVersionName;
  private static Class<?> sShellClass;
  private static Object sShellObj;
  
  static
  {
    if ((System.getProperty("os.arch").toLowerCase().contains("x86")) || (System.getProperty("os.arch").toLowerCase().contains("i686"))) {}
    for (String str = "com.tencent.mtt.x86";; str = "com.tencent.mtt")
    {
      QB_PACKAGE_NAME = str;
      sQbVersionName = "0";
      mIsSysWebViewForced = false;
      mIsSysWebViewForcedByOuter = false;
      isInstalled = false;
      return;
    }
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    if (!init(paramContext)) {}
    do
    {
      return false;
      ReflectionUtils.invokeInstance(sShellObj, "setAppContext", new Class[] { Context.class }, new Object[] { paramContext });
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
  
  private static void checkX5CoreInstalled()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if (localSDKEngine != null) {
      localSDKEngine.checkX5CoreInstalled();
    }
  }
  
  static boolean checkX5CoreInstalled(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = new File(paramContext.createPackageContext(SDKEngine.X5QQBROWSER_PKG_NAME, 2).getDir("x5_share", 0), "sdk_shell.jar").exists();
        if (bool) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
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
  
  public static void forceSysWebView()
  {
    mIsSysWebViewForcedByOuter = true;
    QbSdkLog.e("QbSdk", "sys WebView: forceSysWebView called");
  }
  
  static void forceSysWebViewInner()
  {
    mIsSysWebViewForced = true;
    QbSdkLog.e("QbSdk", "sys WebView: forceSysWebViewInner called");
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
    if (!sIsVersionPrinted)
    {
      QbSdkLog.e("QbSdk", "svn version is 246018");
      QbSdkLog.e("QbSdk", "sdk version is 1.3");
      sIsVersionPrinted = true;
    }
    if ((mIsSysWebViewForced) || (mIsSysWebViewForcedByOuter)) {
      return false;
    }
    try
    {
      Object localObject2 = paramContext.getDir("x5core", 0);
      Object localObject1 = paramContext.getPackageManager();
      Object localObject3 = ((PackageManager)localObject1).getPackageInfo(QB_PACKAGE_NAME, 0);
      if ((!sQbVersionName.equals("0")) && (!sQbVersionName.equals(((PackageInfo)localObject3).versionName)))
      {
        sShellClass = null;
        sShellObj = null;
        deleteFiles((File)localObject2);
        return false;
      }
      sQbVersionName = ((PackageInfo)localObject3).versionName;
      if (sShellClass != null) {
        return true;
      }
      localObject3 = paramContext.createPackageContext(SDKEngine.X5QQBROWSER_PKG_NAME, 2);
      File localFile = new File(((Context)localObject3).getDir("x5_share", 0), "sdk_shell.jar");
      if (!localFile.exists())
      {
        QbSdkLog.d("X5CoreNeedReboot", "QbSdk--init()--ACTION_INSTALL_X5");
        localObject2 = new Intent("com.tencent.mtt.ACTION_INSTALL_X5");
        ((Intent)localObject2).setPackage(QB_PACKAGE_NAME);
        localObject1 = ((PackageManager)localObject1).queryIntentServices((Intent)localObject2, 0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          paramContext.startService((Intent)localObject2);
        }
        isInstalled = true;
        checkX5CoreInstalled();
        QbSdkLog.e("QbSdk", "sys WebView: no dex");
        return false;
      }
      sShellClass = new DexClassLoader(localFile.getAbsolutePath(), ((File)localObject2).getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.mtt.sdk.shell.SdkShell");
      sShellObj = sShellClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { localObject3 });
      ReflectionUtils.invokeInstance(sShellObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      QbSdkLog.e("QbSdk", "sys WebView: nameNotFound");
      return false;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QbSdkLog.e("QbSdk", "sys WebView: " + paramContext.getMessage());
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QbSdkLog.e("QbSdk", "sys WebView: " + paramContext.getMessage());
      }
    }
  }
  
  static void installX5(Context paramContext)
  {
    if (isInstalled) {}
    for (;;)
    {
      return;
      isInstalled = true;
      try
      {
        Object localObject = paramContext.getPackageManager();
        if (!new File(paramContext.createPackageContext(SDKEngine.X5QQBROWSER_PKG_NAME, 2).getDir("x5_share", 0), "sdk_shell.jar").exists())
        {
          QbSdkLog.d("X5CoreNeedReboot", "QbSdk--installX5()--ACTION_INSTALL_X5");
          Intent localIntent = new Intent("com.tencent.mtt.ACTION_INSTALL_X5");
          localIntent.setPackage(QB_PACKAGE_NAME);
          localObject = ((PackageManager)localObject).queryIntentServices(localIntent, 0);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            paramContext.startService(localIntent);
          }
          checkX5CoreInstalled();
          QbSdkLog.e("QbSdk", "sys WebView: no dex");
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
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
  
  public static void setQbSdkLogClient(QbSdkLogClient paramQbSdkLogClient)
  {
    QbSdkLog.setQbSdkLogClient(paramQbSdkLogClient);
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return MttLoader.openDocWithQb(paramContext, paramString1, paramInt2, paramString2, localHashMap);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.openVideoWithQb(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.loadUrl(paramContext, paramString, localHashMap) == 0;
  }
  
  public static void unForceSysWebView()
  {
    mIsSysWebViewForcedByOuter = false;
    QbSdkLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */