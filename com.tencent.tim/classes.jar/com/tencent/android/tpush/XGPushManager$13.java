package com.tencent.android.tpush;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$13
  implements Runnable
{
  XGPushManager$13(Context paramContext, XGLocalMessage paramXGLocalMessage) {}
  
  public void run()
  {
    long l = XGPushManager.a(this.a, this.b, -1L);
    TLogger.i("XGPushManager", "ret :" + l + ",msgID:" + this.b.getMsgId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.13
 * JD-Core Version:    0.7.0.1
 */