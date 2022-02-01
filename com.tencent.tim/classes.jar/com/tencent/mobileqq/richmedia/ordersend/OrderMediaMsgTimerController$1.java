package com.tencent.mobileqq.richmedia.ordersend;

import ambq;
import android.os.Handler;
import android.os.Message;

public class OrderMediaMsgTimerController$1
  implements Runnable
{
  public OrderMediaMsgTimerController$1(ambq paramambq, long paramLong) {}
  
  public void run()
  {
    if (ambq.a(this.this$0) != null)
    {
      Message localMessage = ambq.a(this.this$0).obtainMessage(100);
      localMessage.obj = Long.valueOf(this.rJ);
      ambq.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1
 * JD-Core Version:    0.7.0.1
 */