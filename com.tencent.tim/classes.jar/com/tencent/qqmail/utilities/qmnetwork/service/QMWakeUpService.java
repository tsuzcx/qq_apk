package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;

public class QMWakeUpService
  extends BaseService
{
  private static final String ARG_FROM_OTHERAPP = "arg_from_other_app";
  private static final String EXTRA_FROM_MAILWATCHDOG = "mailwatchdog";
  private static final String EXTRA_FROM_MTT = "com.tencent.mtt";
  private static final String EXTRA_FROM_PB = "com.tencent.pb";
  private static final String PUSH_CLASSNAME = "com.tencent.qqmail.utilities.qmnetwork.service.QMPushService";
  private static final String TAG = "QMWakeupService";
  
  @NonNull
  private QMScheduledJobs.FromType handleCommondExtra(Intent paramIntent)
  {
    QMScheduledJobs.FromType localFromType = QMScheduledJobs.FromType.UNKNOWN;
    String str2 = "";
    String str1 = str2;
    if (paramIntent != null) {}
    try
    {
      str1 = paramIntent.getStringExtra("arg_from_other_app");
      QMLog.log(4, "QMWakeupService", "fromOtherApp: " + str1);
      if ((str1 != null) && (!str1.equals(""))) {}
      switch (str1.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          return localFromType;
        }
        break;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        int i;
        QMLog.log(6, "QMWakeupService", paramIntent.getMessage());
        str1 = str2;
        continue;
        if (str1.equals("mailwatchdog"))
        {
          i = 0;
          continue;
          if (str1.equals("com.tencent.pb"))
          {
            i = 1;
            continue;
            if (str1.equals("com.tencent.mtt")) {
              i = 2;
            }
          }
        }
      }
      return QMScheduledJobs.FromType.WATCHDOG;
    }
    return QMScheduledJobs.FromType.PB;
    return QMScheduledJobs.FromType.MTT;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QMLog.log(4, "QMWakeupService", "onCreate");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent = SafeIntent.createSafeIntet(paramIntent);
    QMLog.log(4, "QMWakeupService", "onStartCommand");
    QMScheduledJobs.FromType localFromType = handleCommondExtra(paramIntent);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", localFromType);
    QMScheduledJobs.doJobs(localBundle);
    stopSelf();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMWakeUpService
 * JD-Core Version:    0.7.0.1
 */