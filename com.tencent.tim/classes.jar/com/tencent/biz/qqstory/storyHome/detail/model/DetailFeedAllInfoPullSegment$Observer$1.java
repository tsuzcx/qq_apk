package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import qro;
import qro.a;
import qro.b;
import qro.c;
import qru;
import ram;

public class DetailFeedAllInfoPullSegment$Observer$1
  implements Runnable
{
  public DetailFeedAllInfoPullSegment$Observer$1(qro.c paramc, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (qro.a(this.a.a).isJobCancelled())
    {
      ram.w("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.val$success)
    {
      Object localObject = (Integer)this.a.getFunctionResult(0);
      if (localObject != null) {
        qro.a(this.a.a).d.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (qro.a(this.a.a).Kl()) {}
      int m;
      int n;
      for (int j = 2;; j = 1)
      {
        int k = 0;
        int i = 1;
        for (;;)
        {
          m = i;
          n = i1;
          if (k >= j) {
            break;
          }
          localObject = (qro.b)this.a.getFunctionResult(i);
          if (localObject != null)
          {
            qro.a(this.a.a).e(((qro.b)localObject).oe, true, ((qro.b)localObject).isOpen);
            qro.a(this.a.a).ad(((qro.b)localObject).isOpen, ((qro.b)localObject).likeCount);
            qro.a(this.a.a).d.mHadLike = ((qro.b)localObject).blo;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (qro.a)this.a.getFunctionResult(m);
        if (localObject != null)
        {
          qro.a(this.a.a).d(((qro.a)localObject).od, true, ((qro.a)localObject).isOpen);
          qro.a(this.a.a).ac(((qro.a)localObject).isOpen, ((qro.a)localObject).commentCount);
          qro.a(this.a.a).ap(((qro.a)localObject).isOpen, ((qro.a)localObject).aEW);
          qro.a(this.a.a).E(((qro.a)localObject).isOpen, ((qro.a)localObject).ayn);
        }
        n += 1;
        m += 1;
      }
      qro.a(this.a.a, qro.a(this.a.a));
      return;
    }
    qro.a(this.a.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1
 * JD-Core Version:    0.7.0.1
 */