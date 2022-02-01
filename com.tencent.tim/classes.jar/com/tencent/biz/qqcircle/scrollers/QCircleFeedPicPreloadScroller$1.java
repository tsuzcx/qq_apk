package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ovd;
import pda;
import pdb;

public class QCircleFeedPicPreloadScroller$1
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$1(pda parampda, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Iterator localIterator = this.c.images.get().iterator();
    int i = 0;
    boolean bool;
    if (localIterator.hasNext())
    {
      Object localObject1 = (FeedCloudMeta.StImage)localIterator.next();
      Object localObject2 = ovd.a(this.c, ((FeedCloudMeta.StImage)localObject1).width.get(), ((FeedCloudMeta.StImage)localObject1).height.get());
      QCircleFeedPicLoader.b localb = new QCircleFeedPicLoader.b().b(true);
      if (i == 0)
      {
        bool = true;
        label82:
        localObject1 = localb.a(bool).a(((FeedCloudMeta.StImage)localObject1).picUrl.get()).b(((Integer)((Pair)localObject2).first).intValue()).a(((Integer)((Pair)localObject2).second).intValue()).c(QCircleFeedPicLoader.b.bgo + i);
        localObject2 = QCircleFeedPicLoader.a().a((QCircleFeedPicLoader.b)localObject1);
        if (pda.a(this.this$0).containsKey(localObject2)) {
          break label209;
        }
        QCircleFeedPicLoader.a().a((QCircleFeedPicLoader.b)localObject1, new pdb(this));
        i += 1;
        pda.a(this.this$0).put(localObject2, Boolean.valueOf(false));
      }
    }
    label209:
    for (;;)
    {
      break;
      bool = false;
      break label82;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.1
 * JD-Core Version:    0.7.0.1
 */