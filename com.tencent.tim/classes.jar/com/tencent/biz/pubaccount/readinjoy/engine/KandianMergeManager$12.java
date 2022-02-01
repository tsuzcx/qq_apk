package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import kxm;

class KandianMergeManager$12
  implements Runnable
{
  KandianMergeManager$12(KandianMergeManager paramKandianMergeManager, QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.d(acbn.blx, 7220);
    if (localMessageRecord != null) {}
    for (localMessageRecord = KandianMergeManager.a(this.this$0, localMessageRecord, this.ael, this.abC, this.val$from, this.aiT);; localMessageRecord = KandianMergeManager.a(this.this$0, this.ael, this.abC, this.val$from))
    {
      if (localMessageRecord != null)
      {
        kxm.j(localMessageRecord);
        this.a.b(localMessageRecord, KandianMergeManager.a(this.this$0).getCurrentUin());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.12
 * JD-Core Version:    0.7.0.1
 */