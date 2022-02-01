package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import ujt;

class KandianMergeManager$18
  implements Runnable
{
  KandianMergeManager$18(KandianMergeManager paramKandianMergeManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    KandianMergeManager.a(this.this$0).b().a(acbn.blx, 7220, false, false);
    if (this.a.extInt == 2)
    {
      KandianMergeManager.a(this.this$0).b().t(acbn.blx, 7220, this.a.uniseq);
      if (KandianMergeManager.a(this.this$0).get() > 0) {
        this.this$0.qk(2);
      }
    }
    do
    {
      return;
      if (this.a.extInt == 1)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.aTl = acbn.blw;
        localSessionInfo.cZ = 1008;
        ujt.a(KandianMergeManager.a(this.this$0), localSessionInfo);
        return;
      }
    } while (this.a.extInt != 5);
    KandianMergeManager.a(this.this$0).b().t(acbn.blx, 7220, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.18
 * JD-Core Version:    0.7.0.1
 */