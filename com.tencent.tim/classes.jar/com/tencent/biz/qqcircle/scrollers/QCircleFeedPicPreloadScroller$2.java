package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.concurrent.ConcurrentHashMap;
import ovd;
import pda;
import pdc;

public class QCircleFeedPicPreloadScroller$2
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$2(pda parampda, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    Object localObject = ovd.a(this.c, this.c.video.width.get(), this.c.video.height.get());
    localObject = new QCircleFeedPicLoader.b().b(true).a(true).c(QCircleFeedPicLoader.b.bgo).a(this.c.cover.picUrl.get()).b(((Integer)((Pair)localObject).first).intValue()).a(((Integer)((Pair)localObject).second).intValue());
    String str = QCircleFeedPicLoader.a().a((QCircleFeedPicLoader.b)localObject);
    if (!pda.a(this.this$0).containsKey(str))
    {
      QCircleFeedPicLoader.a().a((QCircleFeedPicLoader.b)localObject, new pdc(this));
      pda.a(this.this$0).put(str, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.2
 * JD-Core Version:    0.7.0.1
 */