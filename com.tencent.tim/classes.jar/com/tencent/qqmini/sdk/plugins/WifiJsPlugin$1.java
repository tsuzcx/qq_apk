package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class WifiJsPlugin$1
  extends BroadcastReceiver
{
  WifiJsPlugin$1(WifiJsPlugin paramWifiJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction())) {
      WifiJsPlugin.access$000(this.this$0, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.WifiJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */