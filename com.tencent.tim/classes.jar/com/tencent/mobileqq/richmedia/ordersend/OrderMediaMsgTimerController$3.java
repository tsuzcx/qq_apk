package com.tencent.mobileqq.richmedia.ordersend;

import ambq;
import android.os.Handler;
import android.os.Message;

public class OrderMediaMsgTimerController$3
  implements Runnable
{
  public OrderMediaMsgTimerController$3(ambq paramambq, long paramLong) {}
  
  public void run()
  {
    if (ambq.a(this.this$0) != null)
    {
      Message localMessage = ambq.a(this.this$0).obtainMessage(101);
      localMessage.obj = Long.valueOf(this.rJ);
      ambq.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3
 * JD-Core Version:    0.7.0.1
 */