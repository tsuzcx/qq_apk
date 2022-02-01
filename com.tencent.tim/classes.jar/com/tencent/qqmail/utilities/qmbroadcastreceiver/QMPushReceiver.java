package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollectorImpl;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.osslog.QMOssClient;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import com.tencent.qqmail.utilities.services.QMNotifyService;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.QMAlarmManager;

public class QMPushReceiver
  extends BaseBroadcastReceiver
{
  private static final String TAG = "QMPushReceiver";
  
  private static void reboot()
  {
    QMLog.log(5, "QMPushReceiver", "reboot main and push process!");
    try
    {
      QMApplicationContext.sharedInstance().startService(QMNotifyService.createOnRebootIntent());
      label18:
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("from", QMScheduledJobs.FromType.REBOOT);
      QMAlarmManager.registerSingleExactlyAlarm(5000L, PendingIntent.getService(QMApplicationContext.sharedInstance(), 1451, QMNotifyService.createScheduledJobsIntent(localBundle), 0));
      QMAlarmManager.registerSingleExactlyAlarm(10000L, PendingIntent.getService(QMApplicationContext.sharedInstance(), 2115, QMPushService.createStartIntent(QMPushService.PushStartUpReason.RECEIVERS), 0));
      QMLog.flush();
      QMOssClient.getInstance().flush();
      DataCollectorImpl.flush();
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = SafeIntent.createSafeIntet(paramIntent);
    if (paramIntent == null) {}
    for (paramContext = null;; paramContext = paramIntent.getAction())
    {
      QMLog.log(4, "QMPushReceiver", "Push Receiver, action: " + paramContext);
      if ((!"moai.patch.action".equals(paramContext)) || (!paramIntent.getBooleanExtra("ACTION_KILL", false))) {
        break;
      }
      Threads.runInBackground(new QMPushReceiver.1(this));
      return;
    }
    Threads.runInBackground(new QMPushReceiver.2(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMPushReceiver
 * JD-Core Version:    0.7.0.1
 */