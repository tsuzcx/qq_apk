package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;

public class SystemBootBroadCast
  extends BaseBroadcastReceiver
{
  private static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE";
  private static final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";
  private static final String TAG = "SystemBootBroadCast";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = SafeIntent.createSafeIntet(paramIntent);
    if (paramContext != null)
    {
      QMLog.log(4, "SystemBootBroadCast", "action: " + paramContext.getAction());
      if ((paramContext.getAction() != null) && ((paramContext.getAction().equals("android.intent.action.BOOT_COMPLETED")) || (paramContext.getAction().equals("android.intent.action.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE"))))
      {
        paramIntent = new Bundle();
        paramIntent.putSerializable("from", QMScheduledJobs.FromType.BOOT);
        QMScheduledJobs.doJobs(paramIntent);
        QMLog.log(4, "SystemBootBroadCast", "secapp. bootcomplete");
        AddAccountLocalLogUtil.timeLineAccountChange("OTHER", "systemboot:" + paramContext.getAction());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.SystemBootBroadCast
 * JD-Core Version:    0.7.0.1
 */