package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import com.tencent.qphone.base.util.QLog;
import kpp;
import kpp.a;
import kqd;
import kqd.a;
import kqf;

public class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  public RIJBiuAndCommentMixDataManager$1(kqd paramkqd, kqf paramkqf, int paramInt) {}
  
  public void run()
  {
    if (kqd.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      kqd.a(this.this$0).b(this.a);
    }
    for (;;)
    {
      if ((this.val$resultCode == 0) && (this.a.getCommentType() == 1))
      {
        kpp.a locala = kpp.a(this.a, false);
        kpp.a().a(locala);
      }
      return;
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend dataManager is destory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.1
 * JD-Core Version:    0.7.0.1
 */