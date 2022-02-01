package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;
import psa;
import psx;
import qrl;
import qrl.b;
import qvc;
import ram;

public class CommentListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((psa)psx.a(17)).a(qrl.a(this.this$0).mFeedId, qrl.a(this.this$0).isOpen());
    qrl.b localb = new qrl.b(new ErrorMessage(), qrl.a(this.this$0).mFeedId, qrl.a(this.this$0).mSource);
    localb.aCv = false;
    localb.aCu = true;
    localb.nh = ((List)???);
    localb.mTotalCount = -1;
    localb.isEnd = true;
    localb.mType = qrl.a(this.this$0).mType;
    synchronized (this.this$0)
    {
      if (!this.this$0.aCy)
      {
        qrl.a(this.this$0, localb);
        ram.b("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from cache: %s", localb);
        return;
      }
      ram.w("Q.qqstory.detail:CommentListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */