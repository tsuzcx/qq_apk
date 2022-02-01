package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

public class WifiChangeReceiver
  extends BroadcastReceiver
{
  private String TAG = "WifiChangeReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QMNetworkUtils.updateWifiSignalLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.WifiChangeReceiver
 * JD-Core Version:    0.7.0.1
 */