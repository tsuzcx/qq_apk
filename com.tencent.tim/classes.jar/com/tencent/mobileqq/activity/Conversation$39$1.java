package com.tencent.mobileqq.activity;

import aahb;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import ust;

public class Conversation$39$1
  implements Runnable
{
  public Conversation$39$1(ust paramust, long paramLong) {}
  
  public void run()
  {
    if (this.a.this$0.a != null)
    {
      this.a.this$0.a.cui();
      if (this.a.this$0.app.a().z(this.FT) == 2)
      {
        Message localMessage = new Message();
        localMessage.obj = Long.valueOf(this.FT);
        this.a.this$0.a.d(37, localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.39.1
 * JD-Core Version:    0.7.0.1
 */