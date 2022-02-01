package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.os.Bundle;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import java.io.Serializable;

class QMPushReceiver$2
  implements Runnable
{
  QMPushReceiver$2(QMPushReceiver paramQMPushReceiver, String paramString) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    Object localObject;
    int i;
    if (this.val$action != null)
    {
      localObject = this.val$action;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject = QMScheduledJobs.FromType.RECEIVERS;
        }
        break;
      }
    }
    for (;;)
    {
      localBundle.putSerializable("from", (Serializable)localObject);
      QMScheduledJobs.doJobs(localBundle);
      return;
      if (!((String)localObject).equals("android.intent.action.USER_PRESENT")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("android.intent.action.BATTERY_LOW")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("android.intent.action.BATTERY_OKAY")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject).equals("android.intent.action.MEDIA_CHECKING")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject).equals("android.intent.action.MEDIA_EJECT")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject).equals("android.intent.action.MEDIA_MOUNTED")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject).equals("android.intent.action.MEDIA_UNMOUNTED")) {
        break;
      }
      i = 8;
      break;
      if (!((String)localObject).equals("android.intent.action.MEDIA_REMOVED")) {
        break;
      }
      i = 9;
      break;
      localObject = QMScheduledJobs.FromType.SCREEN_ON;
      continue;
      localObject = QMScheduledJobs.FromType.BATTRY;
      continue;
      localObject = QMScheduledJobs.FromType.MEDIA;
      continue;
      localObject = QMScheduledJobs.FromType.RECEIVERS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMPushReceiver.2
 * JD-Core Version:    0.7.0.1
 */