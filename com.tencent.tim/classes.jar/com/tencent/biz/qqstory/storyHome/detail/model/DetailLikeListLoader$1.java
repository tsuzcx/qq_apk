package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import pmi;
import psm;
import psx;
import qrv;
import qrv.a;
import ram;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (psm)psx.a(15);
    ??? = qrv.a(this.this$0);
    if (qrv.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((psm)localObject1).c((String)???, bool);
      localObject1 = new qrv.a(new ErrorMessage(), qrv.a(this.this$0));
      ((qrv.a)localObject1).aFe = true;
      ((qrv.a)localObject1).aFd = qrv.a(this.this$0);
      ((qrv.a)localObject1).mType = qrv.a(this.this$0);
      ((qrv.a)localObject1).mHasLike = -1;
      ((qrv.a)localObject1).mLikeCount = -1;
      ((qrv.a)localObject1).mLikeEntryList = ((List)???);
      synchronized (this.this$0)
      {
        if (!qrv.b(this.this$0))
        {
          pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
          ram.b("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        ram.w("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */