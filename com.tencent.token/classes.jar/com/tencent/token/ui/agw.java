package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

final class agw
  implements Runnable
{
  agw(VryMobileForStrategyActivity paramVryMobileForStrategyActivity, String paramString) {}
  
  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 100;
    this.b.mHandler.sendMessage(localMessage);
    VryMobileForStrategyActivity.access$1000(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agw
 * JD-Core Version:    0.7.0.1
 */