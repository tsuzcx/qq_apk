package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import lbz;
import lhf;
import lvd;

public class ArticleInfoModule$16
  implements Runnable
{
  public ArticleInfoModule$16(lhf paramlhf, int paramInt1, List paramList, int paramInt2, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    lhf.a(this.this$0, this.aHH);
    if (this.hA == null) {}
    for (List localList = lhf.a(this.this$0, this.aHH, this.val$count, this.val$time, this.akd);; localList = this.hA)
    {
      lvd.cG(lbz.a().a(Integer.valueOf(this.aHH), localList));
      if (this.this$0.mMainThreadHandler != null) {
        break;
      }
      return;
    }
    this.this$0.mMainThreadHandler.post(new ArticleInfoModule.16.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.16
 * JD-Core Version:    0.7.0.1
 */