package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{
  private static String a()
  {
    return getSystemProperties("ro.product.locale.region", "");
  }
  
  private static String a(Context paramContext, String paramString)
  {
    Object localObject3 = AGConnectServicesConfig.fromContext(paramContext);
    String str = "";
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      paramContext = paramContext.getResources().getAssets().open("agconnect-services.json");
      localObject1 = paramContext;
      localObject2 = paramContext;
      ((AGConnectServicesConfig)localObject3).overlayWith(paramContext);
      localObject1 = paramContext;
      localObject2 = paramContext;
      localObject3 = ((AGConnectServicesConfig)localObject3).getString(paramString);
      localObject1 = localObject3;
      IOUtils.closeQuietly(paramContext);
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.e("Util", "Get " + paramString + " failed: " + paramContext);
        IOUtils.closeQuietly((InputStream)localObject1);
        localObject1 = str;
      }
    }
    finally
    {
      IOUtils.closeQuietly((InputStream)localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    Log.e("Util", "The " + paramString + " is null.");
    return "";
  }
  
  private static boolean a(Context paramContext)
  {
    return paramContext.getPackageName().equals(b.a(paramContext).b());
  }
  
  private static boolean a(String paramString)
  {
    return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(paramString).find();
  }
  
  private static int b(String paramString)
  {
    int j = 0;
    int i = j;
    if (a(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length >= 3) {
        break label28;
      }
      i = j;
    }
    label28:
    do
    {
      return i;
      j = Integer.parseInt(paramString[0]) * 10000000 + Integer.parseInt(paramString[1]) * 100000 + Integer.parseInt(paramString[2]) * 1000;
      i = j;
    } while (paramString.length != 4);
    return j + Integer.parseInt(paramString[3]);
  }
  
  private static String b()
  {
    return getSystemProperties("ro.product.locale", "");
  }
  
  private static String b(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    if (localObject == null)
    {
      HMSLog.e("Util", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
        if ((paramContext != null) && (paramContext.metaData != null))
        {
          paramContext = paramContext.metaData.get("com.huawei.hms.client.appid");
          if (paramContext != null)
          {
            localObject = String.valueOf(paramContext);
            paramContext = (Context)localObject;
            if (!((String)localObject).startsWith("appid=")) {
              continue;
            }
            return ((String)localObject).substring("appid=".length());
          }
        }
        HMSLog.e("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
        return "";
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        HMSLog.e("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
      }
    }
    return "";
  }
  
  private static String c()
  {
    String str = "";
    Locale localLocale = Locale.getDefault();
    if (localLocale != null) {
      str = localLocale.getCountry();
    }
    return str;
  }
  
  private static String c(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    if (localObject == null)
    {
      HMSLog.e("Util", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
        if ((paramContext != null) && (paramContext.metaData != null))
        {
          paramContext = paramContext.metaData.get("com.huawei.hms.client.cpid");
          if (paramContext != null)
          {
            localObject = String.valueOf(paramContext);
            paramContext = (Context)localObject;
            if (!((String)localObject).startsWith("cpid=")) {
              continue;
            }
            return ((String)localObject).substring("cpid=".length());
          }
        }
        HMSLog.i("Util", "In getMetaDataCpId, Failed to read meta data for the CpId.");
        return "";
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        HMSLog.e("Util", "In getMetaDataCpId, Failed to read meta data for the CpId.");
      }
    }
    return "";
  }
  
  public static int compareHmsVersion(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        do
        {
          return -1;
          if (TextUtils.isEmpty(paramString2)) {
            return 1;
          }
          if ((!a(paramString1)) || (!a(paramString2))) {
            break;
          }
          paramString1 = paramString1.split("\\.");
          paramString2 = paramString2.split("\\.");
          if (Integer.parseInt(paramString1[0]) > Integer.parseInt(paramString2[0])) {
            return 1;
          }
        } while (Integer.parseInt(paramString1[0]) < Integer.parseInt(paramString2[0]));
        if (Integer.parseInt(paramString1[1]) > Integer.parseInt(paramString2[1])) {
          return 1;
        }
      } while (Integer.parseInt(paramString1[1]) < Integer.parseInt(paramString2[1]));
      if (Integer.parseInt(paramString1[2]) > Integer.parseInt(paramString2[2])) {
        return 1;
      }
    } while (Integer.parseInt(paramString1[2]) < Integer.parseInt(paramString2[2]));
    return 0;
  }
  
  public static Activity getActiveActivity(Activity paramActivity, Context paramContext)
  {
    if (isBackground(paramContext)) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      if (paramActivity == null) {
        break;
      }
      paramContext = paramActivity;
    } while (!paramActivity.isFinishing());
    return ActivityMgr.INST.getCurrentActivity();
  }
  
  public static String getAppId(Context paramContext)
  {
    Object localObject;
    if (a(paramContext)) {
      localObject = a(paramContext, "client/app_id");
    }
    String str;
    do
    {
      return localObject;
      str = AGConnectServicesConfig.fromContext(paramContext).getString("client/app_id");
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return b(paramContext);
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      HMSLog.e("Util", "In getAppName, context is null.");
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
      return "";
    }
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = paramContext.getPackageName();
      }
      paramContext = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(str, 0));
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("Util", "In getAppName, Failed to get app name.");
      return "";
    }
    catch (Resources.NotFoundException paramContext)
    {
      label77:
      break label77;
    }
  }
  
  public static boolean getBiSetting(Context paramContext)
  {
    if (paramContext == null)
    {
      HMSLog.e("Util", "In getBiSetting, context is null.");
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("Util", "In getBiSetting, Failed to get 'PackageManager' instance.");
      return false;
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null)) {
        return paramContext.metaData.getBoolean("com.huawei.hms.client.bi.setting");
      }
      HMSLog.i("Util", "In getBiSetting, Failed to read meta data bisetting.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("Util", "In getBiSetting, Failed to read meta data bisetting.");
    }
    return false;
  }
  
  public static String getCpId(Context paramContext)
  {
    Object localObject;
    if (a(paramContext)) {
      localObject = a(paramContext, "client/cp_id");
    }
    String str;
    do
    {
      return localObject;
      str = AGConnectServicesConfig.fromContext(paramContext).getString("client/cp_id");
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return c(paramContext);
  }
  
  public static int getHmsVersion(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
      return 0;
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.version");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!TextUtils.isEmpty(paramContext)) {
            return b(paramContext);
          }
        }
      }
      HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
    }
    return 0;
  }
  
  public static String getNetType(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isAvailable())) {
          return paramContext.getTypeName();
        }
      }
    }
    return "";
  }
  
  public static String getProcessName(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == paramInt) {
            return localRunningAppProcessInfo.processName;
          }
        }
      }
    }
    return "";
  }
  
  public static String getProductCountry()
  {
    Object localObject = getSystemProperties("ro.product.locale.region", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    String str;
    do
    {
      return localObject;
      localObject = getSystemProperties("ro.product.locale", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = ((String)localObject).lastIndexOf("_");
        if (i != -1) {
          return ((String)localObject).substring(i + 1);
        }
      }
      str = c();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "";
  }
  
  public static String getSystemProperties(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString1, paramString2 });
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      HMSLog.e("Util", "An exception occurred while reading: getSystemProperties:" + paramString1);
      return paramString2;
    }
    catch (ClassCastException localClassCastException)
    {
      break label51;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label51;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label51;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label51;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label51:
      break label51;
    }
  }
  
  public static Activity getValidActivity(Activity paramActivity1, Activity paramActivity2)
  {
    Activity localActivity;
    if (paramActivity1 != null)
    {
      localActivity = paramActivity1;
      if (!paramActivity1.isFinishing()) {}
    }
    else
    {
      if ((paramActivity2 != null) && (!paramActivity2.isFinishing())) {
        return paramActivity2;
      }
      localActivity = null;
    }
    return localActivity;
    return paramActivity2;
  }
  
  public static boolean isActivityFullscreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) == 1024;
  }
  
  public static boolean isBackground(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {}
    KeyguardManager localKeyguardManager;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            return true;
            localObject = (ActivityManager)paramContext.getSystemService("activity");
            localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
          } while ((localObject == null) || (localKeyguardManager == null));
          localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        } while (localObject == null);
        paramContext = getProcessName(paramContext, Process.myPid());
        localObject = ((List)localObject).iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while (!TextUtils.equals(localRunningAppProcessInfo.processName, paramContext));
    HMSLog.i("Util", "appProcess.importance is " + localRunningAppProcessInfo.importance);
    if (localRunningAppProcessInfo.importance == 100) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool3 = localKeyguardManager.inKeyguardRestrictedInputMode();
      HMSLog.i("Util", "isForground is " + bool1 + "***  isLockedState is " + bool3);
      if (bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static boolean isChinaROM()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    str = b();
    if (!TextUtils.isEmpty(str)) {
      return str.toLowerCase(Locale.US).contains("cn");
    }
    str = c();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    return false;
  }
  
  public static boolean isEMUI()
  {
    HMSLog.i("Util", "is Emui :" + HwBuildEx.VERSION.EMUI_SDK_INT);
    return HwBuildEx.VERSION.EMUI_SDK_INT > 0;
  }
  
  public static void unBindServiceCatchException(Context paramContext, ServiceConnection paramServiceConnection)
  {
    try
    {
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("Util", "On unBindServiceException:" + paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.Util
 * JD-Core Version:    0.7.0.1
 */