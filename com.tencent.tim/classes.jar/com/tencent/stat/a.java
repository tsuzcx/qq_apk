package com.tencent.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class a
  extends BroadcastReceiver
{
  a(NetworkManager paramNetworkManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NetworkManager.a(this.a) != null) {
      NetworkManager.a(this.a).post(new b(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.a
 * JD-Core Version:    0.7.0.1
 */