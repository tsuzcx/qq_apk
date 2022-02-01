package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ppv;
import ppw;
import pxk;
import pyk;
import pyu;
import qvd;
import qvf;
import ram;

public class GetFeedFeatureHandler$1
  implements Runnable
{
  public GetFeedFeatureHandler$1(pxk parampxk) {}
  
  public void run()
  {
    Object localObject3;
    if (pxk.a(this.this$0))
    {
      localObject1 = this.this$0.mM.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (Long)pxk.bZ.get(localObject2);
        if ((localObject3 != null) && (System.currentTimeMillis() - ((Long)localObject3).longValue() < 30000L))
        {
          ((Iterator)localObject1).remove();
          ram.b("Q.qqstory.home.GetFeedFeatureHandler", "remove same request for feed info:%s", localObject2);
        }
        else
        {
          pxk.bZ.put(localObject2, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.mM.size() == 0) {
      return;
    }
    ram.b("Q.qqstory.home.GetFeedFeatureHandler", "request for feed info:%s", this.this$0.mM);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.this$0.mM.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.this$0.a.a((String)localObject3) == null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((List)localObject1).add(localObject3);
        }
      }
      else {
        this.this$0.mN.add(localObject3);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedItem: first=", ((List)localObject1).get(0) });
      }
      localObject2 = new pyk();
      ((pyk)localObject2).nk = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = new qvd((String)((Iterator)localObject1).next(), 0, "", "");
        ((pyk)localObject2).nk.add(localObject3);
      }
      ppv.a().a((ppw)localObject2, this.this$0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedFeature: first=", this.this$0.mM.get(0) });
    }
    localObject1 = new pyu();
    ((pyu)localObject1).no = this.this$0.mM;
    ppv.a().a((ppw)localObject1, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1
 * JD-Core Version:    0.7.0.1
 */