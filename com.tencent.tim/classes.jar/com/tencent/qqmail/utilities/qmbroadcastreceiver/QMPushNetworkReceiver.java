package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.Context;
import android.content.Intent;

public class QMPushNetworkReceiver
  extends BaseBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QMNetworkHandler.getInstance().handleNetworkChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMPushNetworkReceiver
 * JD-Core Version:    0.7.0.1
 */