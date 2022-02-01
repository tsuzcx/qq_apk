package com.tencent.imcore.message;

import acsb;
import anaz;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import tnt;

public class BaseMessageManager$4
  implements Runnable
{
  public BaseMessageManager$4(tnt paramtnt, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    this.this$0.app.a().aB(this.a);
    this.this$0.bEk();
    long l1 = System.currentTimeMillis();
    long l2 = this.val$startTime;
    if (!this.this$0.app.a().f(this.a.frienduin, this.a.istroop, this.a.uniseq)) {
      this.this$0.app.a().a(this.a, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.this$0.app.a().aB(null);
      return;
      this.this$0.app.a().a().g(this.a.frienduin, this.a.istroop, acsb.czw, acsb.czE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.4
 * JD-Core Version:    0.7.0.1
 */