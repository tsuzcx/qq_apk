package com.tencent.qqmail.utilities.keepalive;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.Iterator;
import java.util.Set;
import moai.daemon.DaemonManager;
import moai.oss.KvHelper;

public class KeepAliveManager
{
  private static final int DEFAULT_EXIST_TIME_INTERVAL = 1;
  private static final float DEFAULT_EXIST_TIME_MIN = 0.3F;
  private static final int DEFAULT_INVISIBLE_STATE = 9873;
  private static final int DEFAULT_PUSH_AVERAGE_DELAY = 30;
  private static final int DEFAULT_PUSH_AVERAGE_DELAY_NONQQ = 60;
  private static final int DEFAULT_PUSH_MIN_NUM = 3;
  private static final int DEFAULT_SCHEDULED_JOB_INTERVAL = 1;
  private static final float DEFAULT_SCHEDULED_JOB_MIN = 12.0F;
  private static final int DEFAULT_SHOW_GUIDE_INTERVAL = 5;
  private static final int DEFAULT_SHOW_NOTIFICATION_GUIDE_INTERVAL = 3;
  private static final int INVISIBLE_360 = 512;
  private static final int INVISIBLE_ALL = 1048575;
  private static final int INVISIBLE_GIONEE = 256;
  private static final int INVISIBLE_HUAWEI = 2;
  private static final int INVISIBLE_LENOVO = 4096;
  private static final int INVISIBLE_LETV = 128;
  private static final int INVISIBLE_MEITU = 2048;
  private static final int INVISIBLE_MEIZU = 32;
  private static final int INVISIBLE_NUBIA = 1024;
  private static final int INVISIBLE_OPPO = 8;
  private static final int INVISIBLE_OTHER = 64;
  private static final int INVISIBLE_SAMSUNG = 1;
  private static final int INVISIBLE_VIVO = 16;
  private static final int INVISIBLE_XIAOMI = 4;
  private static final int INVISIBLE_ZUK = 8192;
  private static final String KEY_CONFIG_EXIST_TIME_INTERVAL = "config_exist_time_interval";
  private static final String KEY_CONFIG_EXIST_TIME_MIN = "config_exist_time_min";
  private static final String KEY_CONFIG_PUSH_AVERAGE_DELAY = "config_push_average_delay";
  private static final String KEY_CONFIG_PUSH_MIN_NUM = "config_push_min_num";
  private static final String KEY_CONFIG_SCHEDULED_JOB_INTERVAL = "config_scheduled_job_interval";
  private static final String KEY_CONFIG_SCHEDULED_JOB_MIN = "config_scheduled_job_min";
  private static final String KEY_CONFIG_SHOW_GUIDE_INTERVAL = "config_show_guide_interval";
  private static final String KEY_CONFIG_SHOW_INVISIBLE = "config_show_invisible";
  private static final String KEY_CONFIG_SHOW_NOTIFICATION_GUIDE_INTERVAL = "config_show_notification_guide_interval";
  private static final String KEY_FIRST_ADD_ACCOUNT = "first_add_account";
  private static final String KEY_FIRST_ADD_NONQQ_ACCOUNT = "first_add_nonqq_account";
  private static final String KEY_LAST_SHOW_GUIDE_TIME = "last_show_guide_time";
  private static final String KEY_LAST_SHOW_NOTIFICATION_GUIDE_TIME = "last_show_notification_guide_time";
  private static final String KEY_PUSH_DELAY = "push_delay";
  private static final String KEY_PUSH_NUM = "push_num";
  private static final String KEY_SCHEDULED_JOB_BEGIN = "scheduled_job_begin";
  private static final String KEY_SCHEDULED_JOB_TIMES = "scheduled_job_times";
  private static final String KEY_SHOWN_FOR_FIRST_ADD_ACCOUNT = "shown_for_first_add_account";
  private static final String KEY_SHOWN_FOR_FIRST_ADD_NONQQ_ACCOUNT = "shown_for_first_add_nonqq_account";
  private static final int REASON_ADD_ACCOUNT = 4;
  private static final int REASON_PUSH_DELAY = 2;
  private static final int REASON_PUSH_EXIST_SHORT_TIME = 1;
  private static final int REASON_SCHEDULED_JOB_LESS = 3;
  private static final String SP_NAME = "keep_alive_info";
  private static final String TAG = "KeepAliveManager";
  private static CheckShowGuideTask sCheckShowGuideTask = new CheckShowGuideTask(null);
  private static long sExistTimeInterval;
  private static float sExistTimeMin;
  private static long sPushAverageDelay;
  private static long sPushAverageDelayNonQQ;
  private static int sPushMinNum;
  private static long sScheduledJobInterval;
  private static float sScheduledJobMin;
  private static long sShowGuideInterval;
  public static boolean sShowInvisible;
  private static long sShowNotificationGuideInterval;
  private static boolean sShowingGuide;
  private static int sTryCheckShowGuideTimes;
  
  static
  {
    initConfig();
    SPManager.registerOnChangedListener("keep_alive_info", new KeepAliveManager.1());
    if (SPManager.getSp("keep_alive_info").getLong("scheduled_job_begin", -1L) == -1L) {
      SPManager.getEditor("keep_alive_info").putLong("scheduled_job_begin", System.currentTimeMillis()).apply();
    }
  }
  
  public static void checkShowGuide(boolean paramBoolean)
  {
    Threads.runOnMainThreadIfNotExist(sCheckShowGuideTask.acquire(paramBoolean), 500L);
  }
  
  public static void checkStatusBar()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      StatusBarNotification[] arrayOfStatusBarNotification = ((NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification")).getActiveNotifications();
      if (arrayOfStatusBarNotification != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("Notifications in StatusBar, foreground: ").append(AppStatusUtil.isAppOnForeground()).append(", num: ").append(arrayOfStatusBarNotification.length);
        int j = arrayOfStatusBarNotification.length;
        int i = 0;
        while (i < j)
        {
          StatusBarNotification localStatusBarNotification = arrayOfStatusBarNotification[i];
          Bundle localBundle = localStatusBarNotification.getNotification().extras;
          localStringBuilder.append(", [id: ").append(localStatusBarNotification.getId()).append(", postTime: ").append(localStatusBarNotification.getPostTime()).append(", title: ").append(localBundle.getCharSequence("android.title")).append(", text: ").append(localBundle.getCharSequence("android.text")).append("]");
          i += 1;
        }
        QMLog.log(4, "KeepAliveManager", localStringBuilder.toString());
      }
    }
    if (!PermissionUtils.hasNotificationPostPermission())
    {
      QMLog.log(5, "KeepAliveManager", "no notification permission!");
      KvHelper.noNotificationPermission(new double[0]);
    }
  }
  
  public static void finishInvisibleActivity() {}
  
  private static void guideShown()
  {
    if (!QMPushManager.isThirdPartyPushWorking()) {
      QMApplicationContext.sharedInstance().startService(QMPushService.createRemoveLifeTimeIntent());
    }
    SPManager.getEditor("keep_alive_info").remove("push_delay_qq").remove("push_num_qq").remove("push_delay_nonqq").remove("push_num_nonqq").remove("scheduled_job_begin").remove("scheduled_job_times").remove("first_add_account").putBoolean("shown_for_first_add_account", true).remove("first_add_nonqq_account").putBoolean("shown_for_first_add_nonqq_account", true).putLong("last_show_guide_time", System.currentTimeMillis()).apply();
  }
  
  public static void handleSchemaPush(String paramString)
  {
    try
    {
      String str1 = new String(StringExtention.decode(paramString));
      QMLog.log(4, "KeepAliveManager", "handleSchemaPush, decode config: " + str1 + ", origin config: " + paramString);
      if (str1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      String str2;
      for (;;)
      {
        QMLog.log(5, "KeepAliveManager", "decode config error!", localException);
        str2 = null;
      }
      paramString = (JSONObject)JSONReader.parse(str2);
      if (paramString == null)
      {
        QMLog.log(5, "KeepAliveManager", "json parse error!");
        return;
      }
      SPManager.getEditor("keep_alive_info").putInt("config_show_guide_interval", JSONReader.getInt(paramString, "show", 5)).putInt("config_exist_time_interval", JSONReader.getInt(paramString, "ei", 1)).putFloat("config_exist_time_min", JSONReader.getFloat(paramString, "em", 0.3F)).putInt("config_push_min_num", JSONReader.getInt(paramString, "pn", 3)).putInt("config_push_average_delay_qq", JSONReader.getInt(paramString, "pd", 30)).putInt("config_push_average_delay_nonqq", JSONReader.getInt(paramString, "pdnq", 60)).putInt("config_scheduled_job_interval", JSONReader.getInt(paramString, "si", 1)).putFloat("config_scheduled_job_min", JSONReader.getFloat(paramString, "sm", 12.0F)).putBoolean("config_show_invisible", isShowInvisible(JSONReader.getInt(paramString, "inv", 9873))).apply();
      initConfig();
      SPManager.notifyChanged("keep_alive_info");
    }
  }
  
  private static void initConfig()
  {
    SharedPreferences localSharedPreferences = SPManager.getSp("keep_alive_info", true);
    sShowGuideInterval = localSharedPreferences.getInt("config_show_guide_interval", 5) * 24L * 60L * 60L * 1000L;
    sShowNotificationGuideInterval = localSharedPreferences.getInt("config_show_notification_guide_interval", 3) * 24L * 60L * 60L * 1000L;
    sExistTimeInterval = localSharedPreferences.getInt("config_exist_time_interval", 1) * 24L * 60L * 60L * 1000L;
    sExistTimeMin = localSharedPreferences.getFloat("config_exist_time_min", 0.3F);
    sPushMinNum = localSharedPreferences.getInt("config_push_min_num", 3);
    sPushAverageDelay = localSharedPreferences.getInt("config_push_average_delay_qq", 30) * 60L;
    sPushAverageDelayNonQQ = localSharedPreferences.getInt("config_push_average_delay_nonqq", 60) * 60L;
    sScheduledJobInterval = localSharedPreferences.getInt("config_scheduled_job_interval", 1) * 24L * 60L * 60L * 1000L;
    sScheduledJobMin = localSharedPreferences.getFloat("config_scheduled_job_min", 12.0F);
    sShowInvisible = localSharedPreferences.getBoolean("config_show_invisible", isShowInvisible(9873));
    QMLog.log(4, "KeepAliveManager", "inifConfig, show: " + sShowGuideInterval + "ms, existInterval: " + sExistTimeInterval + "ms, existMin: " + sExistTimeMin + ", pushMinNum: " + sPushMinNum + ", markPushDelay: " + sPushAverageDelay + "/" + sPushAverageDelayNonQQ + "s, scheduledInterval: " + sScheduledJobInterval + "ms, scheduledMin: " + sScheduledJobMin + ", showInvisible: " + sShowInvisible);
  }
  
  public static void installDaemon()
  {
    if ((sShowInvisible) && (QMServiceManager.isPushEnable()) && (QMServiceManager.isUMAPushEnable()))
    {
      DaemonManager.install(QMApplicationContext.sharedInstance());
      DaemonManager.setLogger(new KeepAliveManager.2(), 2);
      DaemonManager.setShowDaemonActivityDelay(1000L);
      DaemonManager.setDaemonActivityInterceptor(new KeepAliveManager.3());
    }
  }
  
  private static boolean isExistShortTime()
  {
    if (QMPushManager.isThirdPartyPushWorking()) {
      QMLog.log(5, "KeepAliveManager", "isExistShortTime, no need to check push exist time");
    }
    long l2;
    long l1;
    do
    {
      return false;
      l2 = System.currentTimeMillis();
      long l3 = SPManager.getSp("webpush_push_info").getLong("life_begin_time", l2);
      l1 = SPManager.getSp("webpush_push_info").getLong("life_exist_time", 0L);
      l2 -= l3;
      QMLog.log(4, "KeepAliveManager", "isExistShortTime, exist: " + l1 + ", interval: " + l2);
    } while ((l2 <= sExistTimeInterval) || ((float)l1 / (float)l2 >= sExistTimeMin));
    return true;
  }
  
  private static boolean isNeedShowForAccount()
  {
    if ((SPManager.getSp("keep_alive_info").getBoolean("first_add_account", false)) && ((BrandUtil.isVivo()) || (BrandUtil.isFuntouchOS()) || (BrandUtil.isSamsung()) || (BrandUtil.isLetv()) || (BrandUtil.isLetvEui()) || (BrandUtil.isHuawei()) || (BrandUtil.isEmui()))) {}
    while ((!SPManager.getSp("keep_alive_info").getBoolean("shown_for_first_add_account", false)) && (SPManager.getSp("keep_alive_info").getBoolean("first_add_nonqq_account", false)) && ((BrandUtil.isHuawei()) || (BrandUtil.isEmui()) || (BrandUtil.isXiaomi()) || (BrandUtil.isMiui()))) {
      return true;
    }
    return false;
  }
  
  private static boolean isPushDelay()
  {
    boolean bool2 = false;
    long l1 = SPManager.getSp("keep_alive_info").getLong("push_delay_qq", 0L);
    int i = SPManager.getSp("keep_alive_info").getInt("push_num_qq", 0);
    long l2 = SPManager.getSp("keep_alive_info").getLong("push_delay_nonqq", 0L);
    int j = SPManager.getSp("keep_alive_info").getInt("push_num_nonqq", 0);
    QMLog.log(4, "KeepAliveManager", "isPushDelay, num: " + i + "/" + j + ", delay: " + l1 + "/" + l2);
    boolean bool1;
    if ((QMPushManager.isThirdPartyPushWorking()) || (i < sPushMinNum) || (l1 / i < sPushAverageDelay))
    {
      bool1 = bool2;
      if (j >= sPushMinNum)
      {
        bool1 = bool2;
        if (l2 / j < sPushAverageDelayNonQQ) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isScheduledJobLess()
  {
    if ((QMPushManager.isThirdPartyPushWorking()) && (!AccountManager.shareInstance().getAccountList().hasProtocolAccount())) {}
    long l1;
    int i;
    do
    {
      return false;
      l1 = System.currentTimeMillis();
      long l2 = SPManager.getSp("keep_alive_info").getLong("scheduled_job_begin", l1);
      i = SPManager.getSp("keep_alive_info").getInt("scheduled_job_times", 0);
      l1 -= l2;
      QMLog.log(4, "KeepAliveManager", "isScheduledJosLess, times: " + i + ", interval: " + l1);
    } while ((l1 <= sScheduledJobInterval) || (i / ((float)l1 / 86400000.0F) >= sScheduledJobMin));
    return true;
  }
  
  private static boolean isShowInvisible(int paramInt)
  {
    if (BrandUtil.isSamsung()) {
      if ((paramInt & 0x1) == 0) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return true;
                              return false;
                              if ((!BrandUtil.isHuawei()) && (!BrandUtil.isEmui())) {
                                break;
                              }
                            } while ((paramInt & 0x2) != 0);
                            return false;
                            if ((!BrandUtil.isXiaomi()) && (!BrandUtil.isMiui())) {
                              break;
                            }
                          } while ((paramInt & 0x4) != 0);
                          return false;
                          if ((!BrandUtil.isOppo()) && (!BrandUtil.isColorOS())) {
                            break;
                          }
                        } while ((paramInt & 0x8) != 0);
                        return false;
                        if ((!BrandUtil.isVivo()) && (!BrandUtil.isFuntouchOS())) {
                          break;
                        }
                      } while ((paramInt & 0x10) != 0);
                      return false;
                      if ((!BrandUtil.isMeizu()) && (!BrandUtil.isFlyme())) {
                        break;
                      }
                    } while ((paramInt & 0x20) != 0);
                    return false;
                    if ((!BrandUtil.isLetv()) && (!BrandUtil.isLetvEui())) {
                      break;
                    }
                  } while ((paramInt & 0x80) != 0);
                  return false;
                  if (!BrandUtil.isGIONEE()) {
                    break;
                  }
                } while ((paramInt & 0x100) != 0);
                return false;
                if (!BrandUtil.isNubia()) {
                  break;
                }
              } while ((paramInt & 0x400) != 0);
              return false;
              if (!BrandUtil.is360()) {
                break;
              }
            } while ((paramInt & 0x200) != 0);
            return false;
            if (!BrandUtil.isLenovo()) {
              break;
            }
          } while ((paramInt & 0x1000) != 0);
          return false;
          if (!BrandUtil.isMeitu()) {
            break;
          }
        } while ((paramInt & 0x800) != 0);
        return false;
        if (!BrandUtil.isZuk()) {
          break;
        }
      } while ((paramInt & 0x2000) != 0);
      return false;
    } while ((paramInt & 0x40) != 0);
    return false;
  }
  
  public static void markFirstAddAccount()
  {
    if (!SPManager.getSp("keep_alive_info").getBoolean("shown_for_first_add_account", false)) {
      SPManager.getEditor("keep_alive_info").putBoolean("first_add_account", true).apply();
    }
  }
  
  public static void markFirstAddNonQQAccount()
  {
    if (!SPManager.getSp("keep_alive_info").getBoolean("shown_for_first_add_nonqq_account", false)) {
      SPManager.getEditor("keep_alive_info").putBoolean("first_add_nonqq_account", true).apply();
    }
  }
  
  public static void markPushDelay(boolean paramBoolean, long paramLong)
  {
    if (paramLong >= 172800L) {
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    String str1;
    if (paramBoolean) {
      str1 = "qq";
    }
    for (;;)
    {
      String str2;
      try
      {
        String str3 = "push_delay_" + str1;
        str1 = "push_num_" + str1;
        paramLong = SPManager.getSp("keep_alive_info").getLong(str3, 0L);
        int i = SPManager.getSp("keep_alive_info").getInt(str1, 0);
        SPManager.getEditor("keep_alive_info").putLong(str3, paramLong + l).putInt(str1, i + 1).apply();
      }
      finally {}
    }
  }
  
  public static void markScheduledJob()
  {
    try
    {
      int i = SPManager.getSp("keep_alive_info").getInt("scheduled_job_times", 0);
      SPManager.getEditor("keep_alive_info").putInt("scheduled_job_times", i + 1).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void showGuide(int paramInt)
  {
    int j = 0;
    int k = Build.VERSION.SDK_INT;
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    QMLog.log(4, "KeepAliveManager", "showGuide, reason: " + paramInt + ", brand: " + Build.BRAND + ", sdk: " + k + ", topPage: " + localActivity + ", foreground: " + AppStatusUtil.isAppOnForeground());
    if ((AppStatusUtil.isAppOnBackGround()) || (localActivity == null)) {
      return;
    }
    QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder(localActivity);
    int i;
    if (k < 21)
    {
      i = j;
      if (QMSyncAdapterManager.isMasterSyncAutomatically())
      {
        i = j;
        if (!QMSyncAdapterManager.isSyncAutomatically()) {}
      }
    }
    else
    {
      i = 1;
    }
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "实时接收新邮件提醒，建议前往" + Hints.OTHER_SYNC.msg;
      localMessageDialogBuilder.addAction("以后再说", new KeepAliveManager.4(paramInt));
      localMessageDialogBuilder.addAction("立即开启", new KeepAliveManager.5());
    }
    for (;;)
    {
      localMessageDialogBuilder.setMessage((CharSequence)localObject1);
      try
      {
        localObject1 = localMessageDialogBuilder.create();
        ((Dialog)localObject1).setCancelable(false);
        ((Dialog)localObject1).setOnDismissListener(new KeepAliveManager.9());
        ((Dialog)localObject1).setOnShowListener(new KeepAliveManager.10(paramInt));
        ((Dialog)localObject1).show();
        Threads.runOnMainThread(new KeepAliveManager.11(), 30000L);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.log(5, "KeepAliveManager", "show guide dialog failed", localThrowable);
        return;
      }
      if ((BrandUtil.isSamsung()) && (k >= 23)) {
        localObject2 = Hints.SAMSUNG_23_WL;
      }
      String str;
      for (;;)
      {
        str = "实时接收新邮件提醒";
        if (BrandUtil.isEmui()) {
          str = "实时接收新邮件提醒" + "、更新角标数";
        }
        str = str + "，建议前往\n\n" + ((Hints)localObject2).msg;
        if ((((Hints)localObject2).action != 0) || (((Hints)localObject2).intent == null)) {
          break label679;
        }
        localMessageDialogBuilder.addAction("以后再说", new KeepAliveManager.6(paramInt));
        localMessageDialogBuilder.addAction("立即开启", new KeepAliveManager.7((Hints)localObject2, paramInt, localActivity));
        localObject2 = str;
        break;
        if ((BrandUtil.isSamsung()) && (k >= 21)) {
          localObject2 = Hints.SAMSUNG_21_WL;
        } else if ((BrandUtil.isSamsung()) && (k >= 18) && (Build.MODEL.contains("N7"))) {
          localObject2 = Hints.SAMSUNG_18_WL;
        } else if (BrandUtil.isEmuiV5()) {
          localObject2 = Hints.EMUI_5_WL;
        } else if (BrandUtil.isEmui()) {
          localObject2 = Hints.EMUI_WL;
        } else if (BrandUtil.isMiuiV5()) {
          localObject2 = Hints.MIUI_5_WL;
        } else if (BrandUtil.isMiui()) {
          localObject2 = Hints.MIUI_8_WL;
        } else if ((BrandUtil.isColorOSV21()) && (k >= 21)) {
          localObject2 = Hints.COLOROS_2_1_22_WL;
        } else if (BrandUtil.isColorOSV21()) {
          localObject2 = Hints.COLOROS_2_1_WL;
        } else if (BrandUtil.isColorOSV2()) {
          localObject2 = Hints.COLOROS_2_WL;
        } else if ((BrandUtil.isColorOSV3()) && (k < 23)) {
          localObject2 = Hints.COLOROS_3_22_WL;
        } else if ((BrandUtil.isColorOSV3()) && (k >= 23)) {
          localObject2 = Hints.COLOROS_3_23_WL;
        } else if (BrandUtil.isFlyme()) {
          localObject2 = Hints.FLYME_5_WL;
        } else if (BrandUtil.isFuntouchOS()) {
          localObject2 = Hints.FUNTOUCH_2_WL;
        } else if (BrandUtil.isVivo()) {
          localObject2 = Hints.VIVO_WL;
        } else if (BrandUtil.isLetvEui()) {
          localObject2 = Hints.EUI_5_WL;
        } else {
          localObject2 = Hints.UNKNOWN;
        }
      }
      label679:
      localMessageDialogBuilder.addAction("我知道了", new KeepAliveManager.8());
      Object localObject2 = str;
    }
  }
  
  public static void showNotificationGuide()
  {
    int i = Build.VERSION.SDK_INT;
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    QMLog.log(4, "KeepAliveManager", "showNotificationGuide, brand: " + Build.BRAND + ", sdk: " + i + ", topPage: " + localActivity + ", foreground: " + AppStatusUtil.isAppOnForeground());
    if ((AppStatusUtil.isAppOnBackGround()) || (localActivity == null)) {
      return;
    }
    Object localObject;
    if (BrandUtil.isColorOSV21()) {
      localObject = Hints.COLOROS_2_1_NTC;
    }
    for (;;)
    {
      QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder(localActivity);
      localMessageDialogBuilder.addAction("以后再说", new KeepAliveManager.12());
      localMessageDialogBuilder.addAction("立刻开启", new KeepAliveManager.13(localActivity, (Hints)localObject));
      localMessageDialogBuilder.setMessage("开启QQ邮箱『通知』功能\n实时接收新邮件提醒");
      try
      {
        localObject = localMessageDialogBuilder.create();
        ((Dialog)localObject).setCancelable(false);
        ((Dialog)localObject).setOnDismissListener(new KeepAliveManager.14());
        ((Dialog)localObject).setOnShowListener(new KeepAliveManager.15());
        ((Dialog)localObject).show();
        Threads.runOnMainThread(new KeepAliveManager.16(), 30000L);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.log(5, "KeepAliveManager", "show guide dialog failed", localThrowable);
        return;
      }
      Hints localHints;
      if (BrandUtil.isColorOS()) {
        localHints = Hints.COLOROS_2_2_NTC;
      } else {
        localHints = Hints.OTHER_NTC;
      }
    }
  }
  
  public static void startInvisibleActivity() {}
  
  static class CheckShowGuideTask
    implements Runnable
  {
    boolean mForce;
    
    CheckShowGuideTask acquire(boolean paramBoolean)
    {
      try
      {
        this.mForce |= paramBoolean;
        return this;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void run()
    {
      int i = 4;
      ValidateHelper.mainThread();
      if (AccountManager.shareInstance().getAccountList().size() == 0) {
        QMLog.log(5, "KeepAliveManager", "no accounts, abort to check");
      }
      for (;;)
      {
        return;
        if (KeepAliveManager.sShowingGuide)
        {
          QMLog.log(5, "KeepAliveManager", "guide is showing, abort to check");
          return;
        }
        if (!QMSettingManager.sharedInstance().getNotifyNewMail())
        {
          QMLog.log(5, "KeepAliveManager", "no notify new mail");
          return;
        }
        if (AppStatusUtil.isAppOnBackGround())
        {
          if (KeepAliveManager.access$208() < 60)
          {
            QMLog.log(5, "KeepAliveManager", "checkShowGuide in background, wait to check again, times: " + KeepAliveManager.sTryCheckShowGuideTimes);
            Threads.runOnMainThreadIfNotExist(this, 500L);
            return;
          }
          KeepAliveManager.access$202(0);
          return;
        }
        KeepAliveManager.access$202(0);
        boolean bool1 = this.mForce;
        this.mForce = false;
        long l1 = System.currentTimeMillis();
        boolean bool2 = PermissionUtils.hasNotificationPostPermission();
        if (!bool2) {
          KvHelper.noNotificationPermission(new double[0]);
        }
        long l2 = l1 - SPManager.getSp("keep_alive_info").getLong("last_show_notification_guide_time", 0L);
        QMLog.log(4, "KeepAliveManager", "check notification guide, force: " + bool1 + ", permission: " + bool2 + ", interval: " + l2 + "ms");
        if ((!bool2) && ((l2 >= KeepAliveManager.sShowNotificationGuideInterval) || (bool1)))
        {
          KeepAliveManager.showNotificationGuide();
          return;
        }
        l1 -= SPManager.getSp("keep_alive_info").getLong("last_show_guide_time", 0L);
        if ((l1 < KeepAliveManager.sShowGuideInterval) && (!bool1))
        {
          QMLog.log(5, "KeepAliveManager", "no need to show guide, interval: " + l1 + "/" + KeepAliveManager.sShowGuideInterval);
          return;
        }
        if (KeepAliveManager.access$500()) {
          i = 1;
        }
        while (i != -1)
        {
          KeepAliveManager.showGuide(i);
          return;
          if (KeepAliveManager.access$600()) {
            i = 2;
          } else if (KeepAliveManager.access$700()) {
            i = 3;
          } else if (!KeepAliveManager.access$800()) {
            i = -1;
          }
        }
      }
    }
  }
  
  static enum Hints
  {
    int action;
    Intent intent;
    String msg;
    Runnable r;
    
    static
    {
      SAMSUNG_21_WL = new Hints("SAMSUNG_21_WL", 1, "【智能管理器-内存-自动运行应用程序】\n\n中开启QQ邮箱的自启动", 0, new Intent().setClassName("com.samsung.android.sm", "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity"), null);
      SAMSUNG_18_WL = new Hints("SAMSUNG_18_WL", 2, "【设置-应用程序许可-QQ邮箱】\n\n中添加QQ邮箱", 0, new Intent().setClassName("com.android.settings", "com.android.settings.Settings"), null);
      EMUI_WL = new Hints("EMUI_WL", 3, "【设置-高级设置-电池管理-受保护应用】\n\n中添加QQ邮箱", 0, new Intent().setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"), null);
      EMUI_5_WL = new Hints("EMUI_5_WL", 4, "【手机管家-自启管理】\n【手机管家-自启管理-应用关联启动管理】\n\n中开启QQ邮箱的自启动和关联启动", 0, new Intent().setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"), null);
      MIUI_5_WL = new Hints("MIUI_5_WL", 5, "【安全中心-授权管理-自启动应用管理】\n\n中开启QQ邮箱的自启动", 0, new Intent().setClassName("com.android.settings", "com.miui.securitycenter.permission.PermMainActivity"), null);
      MIUI_8_WL = new Hints("MIUI_8_WL", 6, "【安全中心-授权管理-自启动管理】\n\n中开启QQ邮箱的自启动", 0, new Intent().setClassName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"), null);
      COLOROS_2_1_WL = new Hints("COLOROS_2_1_WL", 7, "【设置-电量和储存-电量管理-省电设置-纯净后台名单设置-添加应用】\n\n中添加QQ邮箱", 0, new Intent().setClassName("com.oppo.purebackground", "com.oppo.purebackground.Purebackground_AddTrust_Activity"), null);
      COLOROS_2_1_22_WL = new Hints("COLOROS_2_1_22_WL", 8, "【安全中心-设置-电量节省-纯净后台应用管控】\n\n中添加QQ邮箱", 0, new Intent().setClassName("com.color.safecenter", "com.color.purebackground.PureBackgroundSettingActivity"), null);
      COLOROS_2_WL = new Hints("COLOROS_2_WL", 9, "【设置-电量和储存-电量管理-省电设置-纯净后台名单设置】\n\n中添加QQ邮箱", 0, new Intent().setClassName("com.color.safecenter", "com.color.powermanager.settings.PowerMgrSettingsActivity"), null);
      COLOROS_3_22_WL = new Hints("COLOROS_3_22_WL", 10, "【设置-电池-QQ邮箱】\n\n中关闭【后台冻结】和【检测到异常时自动优化】", 0, new Intent().setClassName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"), null);
      COLOROS_3_23_WL = new Hints("COLOROS_3_23_WL", 11, "【设置-电池-耗电保护-QQ邮箱】\n\n中关闭【后台冻结】和【检测到异常时自动优化】", 0, new Intent().setClassName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"), null);
      FLYME_5_WL = new Hints("FLYME_5_WL", 12, "【设置-电量管理-省电优化-待机耗电管理】\n\n中添加QQ邮箱", 0, new Intent().setClassName("com.meizu.safe", "com.meizu.safe.powerui.PowerAppPermissionActivity"), null);
      FUNTOUCH_2_WL = new Hints("FUNTOUCH_2_WL", 13, "【i管家-软件管理-自启动管理】\n\n中开启QQ邮箱的自启动和关联启动\n\n或将QQ邮箱添加到加速白名单中", 0, new Intent().setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"), null);
      VIVO_WL = new Hints("VIVO_WL", 14, "【安全助手-手机加速-自启动管理】\n\n中开启QQ邮箱的自启动", 0, new Intent().setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity"), null);
      EUI_5_WL = new Hints("EUI_5_WL", 15, "【设置-电池-省电管理-高级省电-应用保护】\n\n中禁止自动清理QQ邮箱", 0, new Intent().setClassName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"), null);
      OTHER_SYNC = new Hints("OTHER_SYNC", 16, "【设置-帐户】中开启QQ邮箱自动同步", 1, null, new KeepAliveManager.Hints.1());
      Intent localIntent = new Intent().setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity").putExtra("pkg_name", QMApplicationContext.sharedInstance().getPackageName());
      QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
      if (AppConfig.isBeta())
      {
        i = 2131690412;
        COLOROS_2_2_NTC = new Hints("COLOROS_2_2_NTC", 17, null, 0, localIntent.putExtra("app_name", localQMApplicationContext.getString(i)).putExtra("class_name", "com.tencent.qqmail.launcher.desktop.LaucherActivity"), null);
        localIntent = new Intent().setClassName("com.oppo.notification.center", "com.oppo.notification.center.AppDetailActivity").putExtra("pkg_name", QMApplicationContext.sharedInstance().getPackageName());
        localQMApplicationContext = QMApplicationContext.sharedInstance();
        if (!AppConfig.isBeta()) {
          break label901;
        }
      }
      label901:
      for (int i = 2131690412;; i = 2131690411)
      {
        COLOROS_2_1_NTC = new Hints("COLOROS_2_1_NTC", 18, null, 0, localIntent.putExtra("app_name", localQMApplicationContext.getString(i)).putExtra("class_name", "com.tencent.qqmail.launcher.desktop.LaucherActivity"), null);
        OTHER_NTC = new Hints("OTHER_NTC", 19, null, 0, new Intent().setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", QMApplicationContext.sharedInstance().getPackageName(), null)), null);
        UNKNOWN = new Hints("UNKNOWN", 20, "【系统设置】\n\n中开启QQ邮箱的自启动", 0, null, null);
        $VALUES = new Hints[] { SAMSUNG_23_WL, SAMSUNG_21_WL, SAMSUNG_18_WL, EMUI_WL, EMUI_5_WL, MIUI_5_WL, MIUI_8_WL, COLOROS_2_1_WL, COLOROS_2_1_22_WL, COLOROS_2_WL, COLOROS_3_22_WL, COLOROS_3_23_WL, FLYME_5_WL, FUNTOUCH_2_WL, VIVO_WL, EUI_5_WL, OTHER_SYNC, COLOROS_2_2_NTC, COLOROS_2_1_NTC, OTHER_NTC, UNKNOWN };
        return;
        i = 2131690411;
        break;
      }
    }
    
    private Hints(String paramString, int paramInt, Intent paramIntent, Runnable paramRunnable)
    {
      this.msg = paramString;
      this.action = paramInt;
      this.intent = paramIntent;
      this.r = paramRunnable;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("[").append(name()).append(", [").append(this.msg).append("]");
      if (this.intent != null)
      {
        Object localObject = this.intent.getComponent();
        localStringBuilder.append(", ").append(((ComponentName)localObject).getPackageName()).append("/").append(((ComponentName)localObject).getClassName());
        localObject = this.intent.getExtras();
        if (localObject != null)
        {
          Iterator localIterator = ((Bundle)localObject).keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localStringBuilder.append(", ").append(str).append("=").append(((Bundle)localObject).get(str));
          }
        }
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager
 * JD-Core Version:    0.7.0.1
 */