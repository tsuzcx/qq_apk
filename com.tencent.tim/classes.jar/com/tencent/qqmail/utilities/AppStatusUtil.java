package com.tencent.qqmail.utilities;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.MainThread;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.notificationshortcut.NotificationShortCutManager;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.nightmode.NightModeUtils;
import com.tencent.qqmail.utilities.patch.QMPatchManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import moai.oss.KvHelper;

public class AppStatusUtil
{
  public static final String ACTION_GOTO_BACKGROUND = "gotoBackground";
  public static final String ACTION_GOTO_FOREGROUND = "gotoForeground";
  private static final int DETECT_INTERVAL = 200;
  private static final int MAX_DETECT_TIMES = 15;
  public static final String TAG = "AppStatusUtil";
  private static final String URL_WAKEUP_LOG = QMNetworkConfig.getCgiRequestHost(0) + "/cgi-bin/" + "app_data_report?logtype=wakeup&";
  private static boolean bIsAppOnBackground = true;
  private static int nDetectTimes = -1;
  private static List<String> sHomePackageNameList;
  private static long startTime = -1L;
  private static final Runnable willGotoBackgroundRunner = new AppStatusUtil.2();
  
  @MainThread
  public static boolean didGotoForeground()
  {
    if ((isAppOnBackGround()) && (!LauncherUtils.IS_CLICK_SHORTCUT) && ((LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_NOTE) || (LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_CALENDAR)))
    {
      LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_MAIN;
      QMActivityManager.shareInstance().finishAllActivity();
      enterAccountListOrFolderList();
    }
    do
    {
      return false;
      LauncherUtils.IS_CLICK_SHORTCUT = false;
      Log.i("AppStatusUtil", "didGotoForeground nDetectTimes=" + nDetectTimes + " isAppOnBackGround=" + isAppOnBackGround());
      if (nDetectTimes > -1)
      {
        Threads.removeCallbackOnMain(willGotoBackgroundRunner);
        nDetectTimes = -1;
      }
    } while (!isAppOnBackGround());
    PopularizeUIHelper.setIsGoBackgroundBefore();
    setAppStatus(true);
    QMNotificationConstructor.getInstance().clearAllNotify();
    QMWatcherCenter.triggerAppGotoForground();
    NightModeUtils.getInstance().handleNightModeAfterGotoForeground();
    NotificationShortCutManager.ensure(QMApplicationContext.sharedInstance());
    startTime = SystemClock.elapsedRealtime();
    Threads.runInBackground(new AppStatusUtil.1());
    QMSyncAdapterManager.checkAccount();
    QMPatchManager.checkPatch();
    QMMailManager.sharedInstance().abortUpgradeFts();
    return true;
  }
  
  private static void enterAccountListOrFolderList()
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 0) {
      localObject = AccountTypeListActivity.createIntent();
    }
    for (;;)
    {
      ((Intent)localObject).setFlags(268435456);
      QMApplicationContext.sharedInstance().startActivity((Intent)localObject);
      return;
      if (((AccountList)localObject).size() == 1) {
        localObject = MailFragmentActivity.createIntentToFolderList(((AccountList)localObject).get(0).getId());
      } else {
        localObject = MailFragmentActivity.createIntentToAccountList();
      }
    }
  }
  
  public static boolean isAppOnBackGround()
  {
    return bIsAppOnBackground;
  }
  
  public static boolean isAppOnForeground()
  {
    return !bIsAppOnBackground;
  }
  
  public static boolean isApplicationActive()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return isApplicationActiveAfterLollipop();
    }
    return isApplicationActiveBeforeLollipop();
  }
  
  private static boolean isApplicationActiveAfterLollipop()
  {
    try
    {
      Field localField1 = ActivityManager.class.getDeclaredField("PROCESS_STATE_TOP");
      localField1.setAccessible(true);
      Field localField2 = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
      localField2.setAccessible(true);
      Iterator localIterator = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (("com.tencent.tim:mail".equals(localRunningAppProcessInfo.processName)) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.importanceReasonCode == 0))
        {
          int i = localField2.getInt(localRunningAppProcessInfo);
          int j = localField1.getInt(null);
          return i == j;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean isApplicationActiveBeforeLollipop()
  {
    Object localObject = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getPackageName();
      return QMApplicationContext.sharedInstance().getPackageName().equals(localObject);
    }
    return false;
  }
  
  public static boolean isScreenLocked()
  {
    return ((KeyguardManager)QMApplicationContext.sharedInstance().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean isScreenOn()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)QMApplicationContext.sharedInstance().getSystemService("power");
      if (Build.VERSION.SDK_INT < 20) {
        return localPowerManager.isScreenOn();
      }
      boolean bool = localPowerManager.isInteractive();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, "AppStatusUtil", "isScreenOn", localThrowable);
    }
    return false;
  }
  
  public static void logWakeup()
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("up;");
    int i = 0;
    while (i < ((AccountList)localObject).size())
    {
      if (((AccountList)localObject).get(i) != null) {
        localStringBuilder.append(((AccountList)localObject).get(i).getEmail()).append(";");
      }
      i += 1;
    }
    if (QMSettingManager.sharedInstance().getUpgradeFromOldApp()) {}
    for (localObject = "1";; localObject = "0")
    {
      localStringBuilder.append((String)localObject);
      QMLogStream.logWithoutUmaNow(0, localStringBuilder.toString(), "Event_App_Wakeup");
      QMLogStream.saveLog("logtype=wakeup&appversion=" + AppConfig.getCodeVersionName() + "&sysversion=Android+" + DeviceUtil.getDeviceInfos().releaseVersion);
      DataCollector.logEvent("Event_App_Wakeup");
      KvHelper.appWakeUp(new double[0]);
      if (QMPushMailNotify.getInstance().getSavedMailNum() > 0) {
        KvHelper.appHasBadge(new double[0]);
      }
      QMABTestManager.hwPushWakeup();
      QMABTestManager.miPushWakeup();
      QMABTestManager.notifySubWakeup();
      return;
    }
  }
  
  private static void monitorTimeZoneChange()
  {
    long l1 = TimeZone.getDefault().getRawOffset() / 1000;
    long l2 = QMSettingManager.sharedInstance().getTimeZoneLastWaken();
    if (l2 == -9223372036854775808L) {
      QMSettingManager.sharedInstance().setTimeZoneLastWaken(l1);
    }
    do
    {
      do
      {
        return;
      } while (l1 == l2);
      Log.d("AppStatusUtil", "Time zone changed");
      QMSettingManager.sharedInstance().setTimeZoneLastWaken(l1);
    } while (!QMSettingManager.sharedInstance().getCalendarDisplay());
    QMCalendarManager.getInstance().handleTimeZoneChange();
  }
  
  private static void processSendingTask() {}
  
  private static void setAppStatus(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bIsAppOnBackground = bool;
      QMLog.log(4, "AppStatusUtil", "setAppStatus:" + paramBoolean);
      return;
    }
  }
  
  public static void willGotoBackground()
  {
    Log.v("AppStatusUtil", "willGotoBackground nDetectTimes=" + nDetectTimes);
    if (nDetectTimes > -1) {
      Threads.removeCallbackOnMain(willGotoBackgroundRunner);
    }
    if ((isScreenLocked()) || (!isApplicationActive())) {
      QMWatcherCenter.triggerAppGotoBackground();
    }
    nDetectTimes = 0;
    Threads.runOnMainThread(willGotoBackgroundRunner, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil
 * JD-Core Version:    0.7.0.1
 */