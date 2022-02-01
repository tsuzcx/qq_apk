package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMMainNetworkReceiver
  extends BaseBroadcastReceiver
{
  private static final String TAG = "QMMainNetworkReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = SafeIntent.createSafeIntet(paramIntent);
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getAction())
    {
      QMLog.log(4, "QMMainNetworkReceiver", "onReceive, action: " + paramContext);
      QMNetworkHandler.getInstance().handleNetworkChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMMainNetworkReceiver
 * JD-Core Version:    0.7.0.1
 */