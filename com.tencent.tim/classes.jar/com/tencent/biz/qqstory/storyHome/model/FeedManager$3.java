package com.tencent.biz.qqstory.storyHome.model;

import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import plu;
import plv;
import pmi;
import ppv;
import ppw;
import pyk;
import qvd;
import qvf;
import qvf.c;
import qvg;
import ram;

public class FeedManager$3
  implements Runnable
{
  public FeedManager$3(qvf paramqvf, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.c(this.dL);
    if (localObject1 == null)
    {
      if (this.aFM)
      {
        localObject1 = (Long)qvf.i().get(this.dL);
        if ((localObject1 != null) && (Math.abs(System.currentTimeMillis() - ((Long)localObject1).longValue()) < 300000L))
        {
          ram.b("Q.qqstory.home.data.FeedManager", "request feed item, ignore same request %s", this.dL);
          return;
        }
      }
      qvf.i().put(this.dL, Long.valueOf(System.currentTimeMillis()));
      localObject1 = new pyk();
      ((pyk)localObject1).nk = new ArrayList();
      localObject2 = new qvd(this.dL, 0, "", "");
      ((pyk)localObject1).nk.add(localObject2);
      ppv.a().a((ppw)localObject1, new qvg(this));
      ram.b("Q.qqstory.home.data.FeedManager", "request feed item, from net %s", this.dL);
      return;
    }
    localObject1 = (FeedItem)qvf.a(this.this$0).a(((FeedItem)localObject1).feedId, (plu)localObject1);
    Object localObject2 = new qvf.c();
    ((qvf.c)localObject2).b = ((FeedItem)localObject1);
    pmi.a().dispatch((Dispatcher.Dispatchable)localObject2);
    ram.b("Q.qqstory.home.data.FeedManager", "request feed item, db rec %s", this.dL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.3
 * JD-Core Version:    0.7.0.1
 */