package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

final class ww
  implements Runnable
{
  ww(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity, String paramString) {}
  
  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 100;
    RealNameStep0VerifyMobileDownActivity.access$500(this.b).sendMessage(localMessage);
    RealNameStep0VerifyMobileDownActivity.access$1700(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ww
 * JD-Core Version:    0.7.0.1
 */