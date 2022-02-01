package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import ujt;

class KandianMergeManager$26
  implements Runnable
{
  KandianMergeManager$26(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = acbn.blw;
    localSessionInfo.cZ = 1008;
    ujt.a(KandianMergeManager.a(this.this$0), localSessionInfo);
    KandianMergeManager.a(this.this$0).b().a(this.VE, this.aMY, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.26
 * JD-Core Version:    0.7.0.1
 */