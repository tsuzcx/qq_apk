package com.tencent.token.ui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ao
  extends BroadcastReceiver
{
  ao(GameLoginSndConfirmView paramGameLoginSndConfirmView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.token.update_btn_interval_time_action")) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ao
 * JD-Core Version:    0.7.0.1
 */