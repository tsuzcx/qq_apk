package com.tencent.qqmail.utilities;

import android.app.NotificationManager;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.androidqqmail.tim.TimContactManager;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.nightmode.NightModeUtils;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.osslog.QMOssClient;
import com.tencent.qqmail.utilities.patch.QMPatchManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import moai.oss.KvHelper;

final class AppStatusUtil$2
  implements Runnable
{
  public void run()
  {
    Log.i("AppStatusUtil", "willGotoBackgroundRunner isScreenLocked=" + AppStatusUtil.isScreenLocked() + " isApplicationActive=" + AppStatusUtil.isApplicationActive());
    if ((AppStatusUtil.isScreenLocked()) || (!AppStatusUtil.isApplicationActive()))
    {
      QMWatcherCenter.triggerAppGotoBackground();
      AppStatusUtil.access$200(false);
      AppStatusUtil.access$302(-1);
      QMNotification.postNotification("gotoBackground", null);
      DataCollector.logEvent("Event_App_Sleep");
      QMLogStream.submitLog(true, true);
      QMMailSQLiteHelper.releaseMemory();
      QMLog.log(4, "AppStatusUtil", "app goto background");
      if ((SharedPreferenceUtil.isBadgeIncrement()) && (GesturePasswordManager.getInstance().isGesturePwdPassed()))
      {
        QMLog.log(4, "AppStatusUtil", "goto background, clear badge and blue dot");
        Threads.runInBackground(new AppStatusUtil.2.1(this));
      }
      if (BrandUtil.isMiui()) {
        Threads.runInBackground(new AppStatusUtil.2.2(this));
      }
      TimContactManager.getInstance().sync();
      ((NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification")).cancelAll();
      QMPushManager.clearAllNotification();
      if ((QMSettingManager.sharedInstance().getBonus()) && (QMSettingManager.sharedInstance().getBonusTest())) {
        QMOssClient.getInstance().showSubmitLogNotification();
      }
      if (SharedPreferenceUtil.isGesturePswEnabled()) {
        GesturePasswordManager.getInstance().setGesturePwdPassed(false);
      }
      if (SharedPreferenceUtil.inNightMode()) {
        NightModeUtils.getInstance().hideNightMode(false);
      }
      AdvertiseManager.getInstance().updatePullDownResource();
      if (SharedPreferenceUtil.isExistedCalendarWidget()) {
        CalendarWidgetManager.getInstance().notifyDataChange();
      }
      QMPatchManager.checkPatch();
      if ((QMSettingManager.sharedInstance().isEnableUpgradeFts()) && (!QMMailManager.sharedInstance().isFtsDone()))
      {
        QMLog.log(4, "AppStatusUtil", "resume upgrade fts");
        QMMailManager.sharedInstance().resumeUpgradeFts();
        Threads.runInBackground(new AppStatusUtil.2.3(this));
      }
      if (AppStatusUtil.access$400() > 0L)
      {
        long l = SystemClock.elapsedRealtime() - AppStatusUtil.access$400();
        KvHelper.mailAppearTime(new double[] { l });
        QMLog.log(4, "AppStatusUtil", "Used Time = " + l);
        AppStatusUtil.access$402(-1L);
      }
      return;
    }
    if (AppStatusUtil.access$300() < 15)
    {
      AppStatusUtil.access$308();
      Threads.runOnMainThread(AppStatusUtil.access$500(), 200L);
      return;
    }
    AppStatusUtil.access$302(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil.2
 * JD-Core Version:    0.7.0.1
 */