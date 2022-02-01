package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;

public class ShutDownBroadCast
  extends BaseBroadcastReceiver
{
  private static final String ACTION = "android.intent.action.ACTION_SHUTDOWN";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    paramContext = SafeIntent.createSafeIntet(paramIntent);
    if (paramContext != null)
    {
      QMLog.log(4, "ShutDownBroadCast", "action: " + paramContext.getAction());
      if ((paramContext.getAction() != null) && (paramContext.getAction().equals("android.intent.action.ACTION_SHUTDOWN")))
      {
        paramContext = QMSettingManager.sharedInstance();
        if (paramContext != null) {
          paramContext.setShutdownBefore(true);
        }
        AddAccountLocalLogUtil.timeLineAccountChange("OTHER", "shutingdown");
        QMLog.log(4, "ShutDownBroadCast", "secapp. shutdown device. set shutdownbefore true");
      }
      paramContext = new ComponentName("com.tencent.androidqqmail", "com.tencent.qqmail.utilities.qmbroadcastreceiver.SystemBootBroadCast");
      paramIntent = QMApplicationContext.sharedInstance().getPackageManager();
      if (paramIntent.getComponentEnabledSetting(paramContext) == 2)
      {
        AddAccountLocalLogUtil.timeLineAccountChange("OTHER", "shutdown ComponentState:" + paramIntent.getComponentEnabledSetting(paramContext));
        DataCollector.logDetailEvent("DetailEvent_Shutdown_Behavior", 0L, 0L, "2");
        DataCollector.flush();
      }
      paramIntent.setComponentEnabledSetting(paramContext, 1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.ShutDownBroadCast
 * JD-Core Version:    0.7.0.1
 */