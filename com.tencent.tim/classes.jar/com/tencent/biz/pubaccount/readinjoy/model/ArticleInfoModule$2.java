package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import lhf;
import ljz.a;
import lkd;

public class ArticleInfoModule$2
  implements Runnable
{
  public ArticleInfoModule$2(lhf paramlhf, long paramLong1, long paramLong2, ljz.a parama, long paramLong3) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.d("ArticleInfoModule", 2, new Object[] { "feedsPreload, loadingTime = ", Long.valueOf(this.ul) });
    QLog.d("ArticleInfoModule", 2, new Object[] { "feedsPreload, schedule cost = ", Long.valueOf(l - this.val$start) });
    this.a.h.getAttributes().put("hitFeedsPreloadCache", Boolean.valueOf(true));
    this.a.h.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.uj));
    lhf.a(this.this$0, this.a.h, this.a.il, this.a.channelID, this.a.result, this.a.im, this.a.success, this.a.akF, this.a.bm);
    lkd.k(this.a.il, this.a.afq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.2
 * JD-Core Version:    0.7.0.1
 */