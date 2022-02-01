package com.tencent.mobileqq.richmedia.ordersend;

import ambq;
import android.os.Handler;
import android.os.Message;

public class OrderMediaMsgTimerController$4
  implements Runnable
{
  public OrderMediaMsgTimerController$4(ambq paramambq, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ambq.a(this.this$0) != null)
    {
      Message localMessage = ambq.a(this.this$0).obtainMessage(102);
      localMessage.obj = Long.valueOf(this.rJ);
      localMessage.arg1 = this.val$progress;
      localMessage.arg2 = this.val$count;
      ambq.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.4
 * JD-Core Version:    0.7.0.1
 */