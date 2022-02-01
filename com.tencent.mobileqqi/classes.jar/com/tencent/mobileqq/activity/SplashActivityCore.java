package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dki;
import dkj;
import dkk;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;

public class SplashActivityCore
  implements Handler.Callback
{
  private static final long DEBUG_EXPIRED_TIME = 1728000000L;
  private static final int DELAY_NEXT_ACTIVITY = 110;
  static final int MSG_CANNOT_PLAY_MP4 = 5;
  static final int MSG_CAN_PLAY_MP4 = 4;
  static final int MSG_START_ACTIVITY = 3;
  static final int MSG_UPDATE_DB_PROMPT = 2;
  static final int MSG_UPDATE_PROGRESS = 1;
  private static final int TIMEOUT_NEXT_ACTIVITY = 1400;
  List allDB;
  QQAppInterface app;
  public Handler handler = new Handler(this);
  boolean isShowedUserguide;
  public MediaPlayer mTestMp;
  private InstallActivity mWrapperActivity;
  QQCustomDialog upgradeAlertDilog;
  ProgressDialog upgradeProgressDilog;
  
  public SplashActivityCore(InstallActivity paramInstallActivity)
  {
    this.mWrapperActivity = paramInstallActivity;
    this.handler.sendEmptyMessageDelayed(3, 1400L);
  }
  
  public static boolean checkDebugVersion(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    Object localObject = paramActivity.getPackageManager();
    try
    {
      long l = new File(((PackageManager)localObject).getApplicationInfo(paramActivity.getPackageName(), 0).sourceDir).lastModified();
      if (System.currentTimeMillis() - l >= 1728000000L)
      {
        localObject = DialogUtil.a(paramActivity, 0);
        ((QQCustomDialog)localObject).setTitle(BaseApplicationImpl.getContext().getString(2131559133));
        ((QQCustomDialog)localObject).setPositiveButton("ok", new dki());
        ((QQCustomDialog)localObject).setOnDismissListener(new dkj(paramActivity, paramQQAppInterface));
        ((QQCustomDialog)localObject).show();
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
  
  public static void reportDeviceStat(SharedPreferences paramSharedPreferences, String paramString, Context paramContext)
  {
    if (paramSharedPreferences.getInt("needDoReportAppDeviceStat", 0) == 1) {}
    for (;;)
    {
      try
      {
        StatisticCollector.a(BaseApplication.getContext()).c(paramString);
        paramSharedPreferences = paramSharedPreferences.edit();
        paramSharedPreferences.putInt("needDoReportAppDeviceStat", 0);
        paramSharedPreferences.commit();
        return;
      }
      catch (Exception paramSharedPreferences)
      {
        paramSharedPreferences.printStackTrace();
        return;
      }
      int j = paramSharedPreferences.getInt("firstTimeCollectpdInt", 0);
      try
      {
        i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
        if ((j != 0) && (i == j)) {
          continue;
        }
        paramSharedPreferences = paramSharedPreferences.edit();
        paramSharedPreferences.putInt("firstTimeCollectpdInt", i);
        paramSharedPreferences.putInt("needDoReportAppDeviceStat", 1);
        paramSharedPreferences.commit();
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          int i = 0;
        }
      }
    }
  }
  
  Intent getMainIntent()
  {
    Intent localIntent1 = new Intent(this.mWrapperActivity, SplashActivity.class);
    if (!TextUtils.isEmpty(this.mWrapperActivity.getIntent().getStringExtra("selfuin"))) {
      localIntent1.putExtras(this.mWrapperActivity.getIntent());
    }
    Intent localIntent2 = this.mWrapperActivity.getIntent();
    if (localIntent2.getBooleanExtra("start_from_notification", false))
    {
      localIntent1.putExtras(localIntent2);
      localIntent1.addFlags(67108864);
    }
    return localIntent1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        this.upgradeProgressDilog.setProgress(paramMessage.arg1);
        return true;
        this.upgradeProgressDilog.setMessage(paramMessage.obj.toString());
        return true;
        startNextActivity();
        return true;
        if (QLog.isDevelopLevel()) {
          QLog.d("Splash.testCanPlayMp4", 4, "play video" + System.currentTimeMillis());
        }
      } while (this.isShowedUserguide);
      this.isShowedUserguide = true;
      if (this.mTestMp != null)
      {
        this.mTestMp.stop();
        this.mTestMp.release();
        this.mTestMp = null;
      }
      this.handler.removeMessages(4);
      this.handler.removeMessages(5);
      paramMessage = new Intent(this.mWrapperActivity, UserguideActivity.class);
      paramMessage.putExtra("userguide_type", 0);
      this.mWrapperActivity.startActivity(paramMessage);
      this.mWrapperActivity.finish();
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("Splash.testCanPlayMp4", 4, "play pic" + System.currentTimeMillis());
      }
    } while (this.isShowedUserguide);
    this.isShowedUserguide = true;
    if (this.mTestMp != null) {}
    try
    {
      this.mTestMp.stop();
      this.mTestMp.release();
      this.mTestMp = null;
      this.handler.removeMessages(4);
      this.handler.removeMessages(5);
      paramMessage = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
      paramMessage.putString("qq_version", "6604");
      paramMessage.commit();
      if ((this.mWrapperActivity.getAppRuntime() != null) && (this.mWrapperActivity.getAppRuntime().isLogin()))
      {
        paramMessage = new Intent(this.mWrapperActivity, SplashActivity.class);
        paramMessage.putExtra("tab_index", 0);
        paramMessage.addFlags(67108864);
        this.mWrapperActivity.startActivity(paramMessage);
        this.mWrapperActivity.overridePendingTransition(2130968617, 0);
        this.mWrapperActivity.finish();
        return true;
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          QLog.d("Splash.testCanPlayMp4", 4, "release failed: " + Log.getStackTraceString(paramMessage));
          continue;
          paramMessage = new Intent(this.mWrapperActivity, LoginActivity.class);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.handler.removeMessages(3);
    if (this.mTestMp != null)
    {
      this.mTestMp.stop();
      this.mTestMp.release();
      this.mTestMp = null;
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivityCore", 2, "onResume!");
    }
    if (this.handler.hasMessages(3))
    {
      this.handler.removeMessages(3);
      this.handler.sendEmptyMessageDelayed(3, 110L);
    }
  }
  
  boolean startNextActivity()
  {
    SystemUtil.a(BaseApplicationImpl.getContext());
    this.app = ((QQAppInterface)this.mWrapperActivity.getAppRuntime());
    if ((AppSetting.a == 537032257) && (checkDebugVersion(this.mWrapperActivity, this.app))) {
      return false;
    }
    Object localObject;
    if (NotificationActivity.a == null)
    {
      ReportLog.a(this.app.getAccount());
      localObject = this.app.a(ServerConfigManager.ConfigType.common, "QQIniUrl");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        ReportLog.g = ((String)localObject).trim();
      }
      ReportLog.a(null, "SplashActivity onCreate()");
      localObject = this.app.a();
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label549;
      }
      localObject = "0";
    }
    label274:
    label284:
    label549:
    for (;;)
    {
      ((ServerConfigManager)this.app.getManager(4)).report((byte)4, "", AppSetting.a(this.mWrapperActivity.getApplication(), (String)localObject));
      localObject = this.mWrapperActivity.getSharedPreferences("mobileQQi", 0);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      localEditor.remove("firstTimeRun");
      localEditor.commit();
      reportDeviceStat((SharedPreferences)localObject, "", this.mWrapperActivity);
      int i;
      int j;
      int k;
      if (this.mWrapperActivity.getAppRuntime().isLogin()) {
        if (GesturePWDUtils.getSplashLock(this.mWrapperActivity, this.mWrapperActivity.getAppRuntime().getAccount()))
        {
          GesturePWDUtils.setStartFromSplash(this.mWrapperActivity, true);
          if (UserguideActivity.a(this.mWrapperActivity))
          {
            localObject = null;
            i = 1;
            j = 1;
            int m = 1;
            k = j;
            j = i;
            i = m;
            if (j != 0) {
              break label441;
            }
            this.mWrapperActivity.startActivity((Intent)localObject);
            if (i == 0) {
              break label423;
            }
            this.mWrapperActivity.overridePendingTransition(0, 0);
          }
        }
      }
      for (;;)
      {
        this.app = null;
        this.mWrapperActivity.finish();
        return true;
        localObject = getMainIntent();
        i = 0;
        break;
        GesturePWDUtils.mEnterFromSplash = false;
        if (UserguideActivity.a(this.mWrapperActivity))
        {
          localObject = null;
          i = 1;
          j = 0;
          break label274;
        }
        localObject = getMainIntent();
        i = 0;
        j = 0;
        break label274;
        GesturePWDUtils.mEnterFromSplash = false;
        if (UserguideActivity.a(this.mWrapperActivity))
        {
          i = 0;
          localObject = null;
          j = 1;
          k = 0;
          break label284;
        }
        localObject = new Intent(this.mWrapperActivity, LoginActivity.class);
        j = 0;
        k = 0;
        i = 0;
        break label284;
        label423:
        if (k == 0) {
          this.mWrapperActivity.overridePendingTransition(2130968617, 0);
        }
      }
      label441:
      testCanPlayMp4(Uri.parse("android.resource://" + this.mWrapperActivity.getPackageName() + "/" + 2131165212));
      if (QLog.isDevelopLevel()) {
        QLog.d("Splash.testCanPlayMp4", 4, "testCanPlayMp4 start = " + System.currentTimeMillis());
      }
      this.handler.sendEmptyMessageDelayed(5, 8000L);
      return false;
      this.mWrapperActivity.finish();
      this.app = null;
      return false;
    }
  }
  
  public void testCanPlayMp4(Uri paramUri)
  {
    String str = (DeviceInfoUtil.g() + "-" + DeviceInfoUtil.h()).toLowerCase();
    if (QLog.isColorLevel()) {
      QLog.d("UserGuide", 2, "deviceInfo : " + str);
    }
    if ((str.startsWith("lenovo-lenovo a60")) || (str.startsWith("lenovo-lenovo a288t")) || (str.startsWith("samsung-gt-s7562")) || (str.startsWith("samsung-gt-i8552")) || (str.startsWith("samsung-sch-i879")) || (str.startsWith("samsung-sch-i869")) || (str.startsWith("bbk-vivo y1")) || (str.startsWith("samsung-sch-i829")) || (str.startsWith("bbk-vivo y3t")) || (str.startsWith("samsung-gt-i8262d")) || (str.startsWith("samsung-gt-s7572")) || (str.contains("unknown")))
    {
      this.handler.sendEmptyMessage(5);
      return;
    }
    new Thread(new dkk(this, paramUri), "Splash.TestCanPlayMp4").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivityCore
 * JD-Core Version:    0.7.0.1
 */