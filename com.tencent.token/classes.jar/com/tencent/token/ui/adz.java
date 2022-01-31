package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class adz
  extends BroadcastReceiver
{
  adz(UtilsModSetMobileStep2Activity paramUtilsModSetMobileStep2Activity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.token.GET_MOBILE_CODE_INTERVAL")) {
      UtilsModSetMobileStep2Activity.access$000(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adz
 * JD-Core Version:    0.7.0.1
 */