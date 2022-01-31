package com.tencent.service.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tmsdk.base.utils.NetworkUtil;
import tmsdk.QQPIM.ConnectType;

class l
  extends BroadcastReceiver
{
  l(k paramk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) && (NetworkUtil.getNetworkType().value() == 2)) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.l
 * JD-Core Version:    0.7.0.1
 */