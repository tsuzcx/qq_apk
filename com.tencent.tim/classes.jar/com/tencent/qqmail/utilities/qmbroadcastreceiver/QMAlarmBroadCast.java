package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager.OnChangedListener;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.QMAlarmManager;

public class QMAlarmBroadCast
  extends BaseBroadcastReceiver
{
  public static final int DEFAUL_PUSH_ALARM_INTERVAL = 5;
  private static final String KEY_PUSH_ALARM = "push_alarm";
  private static final String SP_NAME = "qmalarm_info";
  private static final String TAG = "QMAlarmBroadCast";
  private static PendingIntent sPendingIntent;
  private static long sPushAlarmInterval;
  private static QMAlarmBroadCast sReceiver = new QMAlarmBroadCast();
  private static SPManager.OnChangedListener sSPChangedListener;
  
  static
  {
    sPendingIntent = PendingIntent.getService(QMApplicationContext.sharedInstance(), 16042553, QMPushService.createPushAlarmIntent(), 134217728);
    sSPChangedListener = new QMAlarmBroadCast.1();
    initInterval();
    SPManager.registerOnChangedListener("qmalarm_info", sSPChangedListener);
    cancelDeprecatedAlarm();
  }
  
  private static void cancelDeprecatedAlarm()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QMMainNetworkReceiver.class);
    localIntent.setAction("com.tencent.androidqqmail.ACTOIN_ALARM");
    QMAlarmManager.unRegisterAlarm(PendingIntent.getBroadcast(QMApplicationContext.sharedInstance(), 0, localIntent, 0));
  }
  
  public static void handleUpdateConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = (JSONObject)JSONReader.parse(paramString);
      QMLog.log(4, "QMAlarmBroadCast", "handleUpdateConfig, json: " + localJSONObject);
      SPManager.getEditor("qmalarm_info").putLong("push_alarm", JSONReader.getLong(localJSONObject, "pi", 5L)).commit();
      SPManager.notifyChanged("qmalarm_info");
      initInterval();
      register();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, "QMAlarmBroadCast", "handleUpdateConfig failed " + paramString);
      }
    }
  }
  
  private static void initInterval()
  {
    sPushAlarmInterval = SPManager.getSp("qmalarm_info", true).getLong("push_alarm", 5L) * 60L * 1000L;
    if (sPushAlarmInterval < 180000L) {}
    for (long l = 300000L;; l = sPushAlarmInterval)
    {
      sPushAlarmInterval = l;
      QMLog.log(4, "QMAlarmBroadCast", "initInterval, pushAlarm: " + sPushAlarmInterval + "ms");
      return;
    }
  }
  
  public static void register()
  {
    QMLog.log(4, "QMAlarmBroadCast", "regist alarm, pushAlarm: " + sPushAlarmInterval + "ms");
    registerPushAlarm(sPushAlarmInterval);
    registerScreen();
  }
  
  public static void registerPushAlarm(long paramLong)
  {
    QMAlarmManager.registerSingleExactlyAlarm(paramLong, sPendingIntent);
  }
  
  private static void registerScreen()
  {
    unregisterScreen();
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    try
    {
      QMApplicationContext.sharedInstance().registerReceiver(sReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void unregister()
  {
    QMLog.log(4, "QMAlarmBroadCast", "unregister alarm");
    unregisterPushAlarm();
    unregisterScreen();
  }
  
  public static void unregisterPushAlarm()
  {
    QMAlarmManager.unRegisterAlarm(sPendingIntent);
  }
  
  private static void unregisterScreen()
  {
    try
    {
      QMApplicationContext.sharedInstance().unregisterReceiver(sReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = SafeIntent.createSafeIntet(paramIntent);
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getAction())
    {
      QMLog.log(4, "QMAlarmBroadCast", "onAlarmReceive, action: " + paramContext);
      if (("android.intent.action.USER_PRESENT".equals(paramContext)) || ("android.intent.action.SCREEN_ON".equals(paramContext))) {
        Threads.runInBackground(new QMAlarmBroadCast.2(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast
 * JD-Core Version:    0.7.0.1
 */