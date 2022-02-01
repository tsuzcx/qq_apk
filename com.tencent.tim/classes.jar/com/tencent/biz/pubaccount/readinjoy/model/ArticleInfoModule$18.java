package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import lhf;

public class ArticleInfoModule$18
  implements Runnable
{
  public ArticleInfoModule$18(lhf paramlhf, int paramInt1, List paramList, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void run()
  {
    lhf.a(this.this$0, this.aHH);
    if (this.hA == null) {}
    for (List localList = lhf.a(this.this$0, this.aHH, this.val$count, this.val$time, this.akd); this.this$0.mMainThreadHandler == null; localList = this.hA) {
      return;
    }
    this.this$0.mMainThreadHandler.post(new ArticleInfoModule.18.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.18
 * JD-Core Version:    0.7.0.1
 */