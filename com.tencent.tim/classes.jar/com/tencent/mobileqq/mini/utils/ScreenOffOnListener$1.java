package com.tencent.mobileqq.mini.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import aqmr;

class ScreenOffOnListener$1
  extends BroadcastReceiver
{
  ScreenOffOnListener$1(ScreenOffOnListener paramScreenOffOnListener) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (aqmr.isEmpty(paramIntent.getAction())) {}
    while (ScreenOffOnListener.access$000(this.this$0) == null) {
      return;
    }
    ScreenOffOnListener.access$000(this.this$0).onReceiveListener(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ScreenOffOnListener.1
 * JD-Core Version:    0.7.0.1
 */