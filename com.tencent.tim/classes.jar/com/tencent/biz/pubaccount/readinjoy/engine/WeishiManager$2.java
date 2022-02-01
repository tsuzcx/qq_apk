package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import lcr;

public class WeishiManager$2
  implements Runnable
{
  public WeishiManager$2(lcr paramlcr, QQMessageFacade paramQQMessageFacade, String paramString, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.d(acbn.blN, 1008);
    if (localMessageRecord != null) {}
    for (localMessageRecord = lcr.a(this.this$0, localMessageRecord, this.ael, this.val$time);; localMessageRecord = this.this$0.a(this.ael, this.val$time))
    {
      if (localMessageRecord != null) {
        this.a.b(localMessageRecord, lcr.a(this.this$0).getCurrentUin());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.2
 * JD-Core Version:    0.7.0.1
 */