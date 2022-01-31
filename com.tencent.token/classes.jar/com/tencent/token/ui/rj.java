package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

final class rj
  implements Runnable
{
  rj(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity, String paramString) {}
  
  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 100;
    this.b.mHandler.sendMessage(localMessage);
    NetActiveVryMobileNoSmsActivity.access$1300(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rj
 * JD-Core Version:    0.7.0.1
 */