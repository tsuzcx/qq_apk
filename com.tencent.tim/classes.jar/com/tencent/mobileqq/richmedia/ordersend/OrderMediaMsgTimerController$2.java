package com.tencent.mobileqq.richmedia.ordersend;

import ambq;
import android.os.Handler;
import android.os.Message;

public class OrderMediaMsgTimerController$2
  implements Runnable
{
  public OrderMediaMsgTimerController$2(ambq paramambq, String paramString) {}
  
  public void run()
  {
    if (ambq.a(this.this$0) != null)
    {
      Message localMessage = ambq.a(this.this$0).obtainMessage(100);
      localMessage.obj = this.val$path;
      ambq.a(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.2
 * JD-Core Version:    0.7.0.1
 */