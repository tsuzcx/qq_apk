package com.tencent.qqmail.attachment.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.HashMap;
import moai.oss.KvHelper;

public class QQBrowserUtil
{
  private static final int MOST_INIT_COUNT = 3;
  private static final long NEXT_INIT_QB_INTERNAL = 1296000000L;
  public static final int QQBROWSER_OPEN_FILE_TYPE_BROWSER = 1;
  public static final int QQBROWSER_OPEN_FILE_TYPE_SYSTEM = 3;
  public static final int QQBROWSER_OPEN_FILE_TYPE_X5 = 2;
  private static String TAG = "QQBrowserUtil";
  private static boolean isEnableQQBrowserX5 = QMSettingManager.sharedInstance().isEnableQQBrowserX5();
  private static boolean isQQBrowserInstalled;
  private static boolean setQQBrowserHashMapFinish = false;
  
  static
  {
    isQQBrowserInstalled = DeviceUtil.isQQBrowserInstalled();
  }
  
  private static boolean compareVersion(String paramString1, String paramString2)
  {
    if ((StringExtention.isNullOrEmpty(paramString1)) || (StringExtention.isNullOrEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.max(paramString1.length, paramString2.length);
    int i = 0;
    for (;;)
    {
      if (i >= m) {
        break label106;
      }
      int j;
      if (i < paramString1.length)
      {
        j = Integer.parseInt(paramString1[i]);
        if (i >= paramString2.length) {
          break label87;
        }
      }
      label87:
      for (int k = Integer.parseInt(paramString2[i]);; k = 0)
      {
        if (j <= k) {
          break label93;
        }
        return true;
        j = 0;
        break;
      }
      label93:
      if (j < k) {
        break;
      }
      i += 1;
    }
    label106:
    return true;
  }
  
  public static void init(Context paramContext)
  {
    if ((!isQQBrowserInstalled) && (isEnableQQBrowserX5))
    {
      QMLog.log(4, TAG, "QQBrowserUtil start init");
      int i = SharedPreferenceUtil.getX5CoreInitCount();
      if (i < 3)
      {
        SharedPreferenceUtil.setX5CoreInitThreeCrashLog(SharedPreferenceUtil.getX5CoreInitThreeCrashLog() + "initCount:" + i + ",time:" + System.currentTimeMillis() + ";");
        SharedPreferenceUtil.setX5CoreInitCount(i + 1);
        try
        {
          setQQBrowserHashMap();
          QbSdk.initX5Environment(paramContext, new QQBrowserUtil.1());
          return;
        }
        catch (Throwable paramContext)
        {
          QMLog.log(6, TAG, "init QQBrowser Exception: " + paramContext.toString());
          return;
        }
      }
      if (SharedPreferenceUtil.getX5CoreNextInitTime() == 0L) {
        SharedPreferenceUtil.setX5CoreNextInitTime(System.currentTimeMillis() + 1296000000L);
      }
      for (;;)
      {
        KvHelper.eventX5CoreInitFail(new double[0]);
        QMLog.log(6, TAG, "init QQBrowser Error, initCount:" + i + ",crashLog:" + SharedPreferenceUtil.getX5CoreInitThreeCrashLog());
        return;
        if (SharedPreferenceUtil.getX5CoreNextInitTime() - System.currentTimeMillis() < 0L)
        {
          KvHelper.eventX5CoreReset(new double[0]);
          resetInitQB();
          init(paramContext);
        }
      }
    }
    QMLog.log(4, TAG, "QQBrowserUtil init fail: qb install:" + isQQBrowserInstalled + ",enable x5:" + isEnableQQBrowserX5);
  }
  
  public static boolean isQqBrowserSupport(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getPackageManager().getPackageInfo("com.tencent.mtt", 0);
      if (paramActivity != null) {}
      for (paramActivity = paramActivity.versionName;; paramActivity = "")
      {
        boolean bool = compareVersion(paramActivity, "6.9.0.0");
        QMLog.log(4, TAG, "support qqBrowser " + bool);
        return bool;
      }
      return false;
    }
    catch (Exception paramActivity)
    {
      QMLog.log(6, TAG, "support error:" + paramActivity);
    }
  }
  
  public static int openFileReader(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    int i = 3;
    QMLog.log(4, TAG, "openFileReader setQQBrowserHashMapFinish:" + setQQBrowserHashMapFinish + ", isQQBrowserInstalled:" + isQQBrowserInstalled);
    if ((setQQBrowserHashMapFinish) || (isQQBrowserInstalled)) {}
    try
    {
      i = QbSdk.openFileReader(paramContext, paramString, paramHashMap, null);
      return i;
    }
    catch (Throwable paramContext)
    {
      QMLog.log(6, TAG, "openFileReader Exception: " + paramContext.toString());
    }
    return 3;
  }
  
  public static void resetInitQB()
  {
    SharedPreferenceUtil.setX5CoreInitCount(0);
    SharedPreferenceUtil.setX5CoreNextInitTime(0L);
    SharedPreferenceUtil.setX5CoreInitThreeCrashLog("");
  }
  
  private static void setQQBrowserHashMap()
  {
    try
    {
      setQQBrowserHashMapFinish = false;
      QMLog.log(4, TAG, "setQQBrowserHashMap start");
      HashMap localHashMap = new HashMap();
      localHashMap.put("use_private_classloader", Boolean.valueOf(true));
      QbSdk.initTbsSettings(localHashMap);
      QMLog.log(4, TAG, "setQQBrowserHashMap end");
      setQQBrowserHashMapFinish = true;
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "setQQBrowserHashMap Exception: " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.QQBrowserUtil
 * JD-Core Version:    0.7.0.1
 */