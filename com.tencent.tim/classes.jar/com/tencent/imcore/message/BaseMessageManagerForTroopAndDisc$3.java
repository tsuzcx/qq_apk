package com.tencent.imcore.message;

import acsb;
import anaz;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tnu;

public class BaseMessageManagerForTroopAndDisc$3
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$3(tnu paramtnu, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.a.getLogColorContent() + " holdFlag: " + this.aPU);
    }
    if (!this.aPU)
    {
      this.this$0.app.a().a(this.a, 15000L);
      return;
    }
    this.this$0.app.a().aA(this.a);
    this.this$0.bEk();
    long l1 = System.currentTimeMillis();
    long l2 = this.val$startTime;
    if (this.this$0.app.a().aU(this.a)) {
      this.this$0.app.a().a(this.a, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.this$0.app.a().aA(null);
      return;
      this.this$0.app.a().a().g(this.a.frienduin, this.a.istroop, acsb.czw, acsb.czF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.3
 * JD-Core Version:    0.7.0.1
 */