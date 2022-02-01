package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QCirclePolyLikeFrameLayout$1
  implements Runnable
{
  QCirclePolyLikeFrameLayout$1(QCirclePolyLikeFrameLayout paramQCirclePolyLikeFrameLayout, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    if ((QCirclePolyLikeFrameLayout.a(this.this$0) != null) && ((this.a instanceof QCirclePolyPraiseUpdateEvent)))
    {
      QCirclePolyPraiseUpdateEvent localQCirclePolyPraiseUpdateEvent = (QCirclePolyPraiseUpdateEvent)this.a;
      if (QCirclePolyLikeFrameLayout.a(this.this$0).id.get().equals(localQCirclePolyPraiseUpdateEvent.mTargetFeedId)) {
        QCirclePolyLikeFrameLayout.a(this.this$0, localQCirclePolyPraiseUpdateEvent.mNewStPolyLike);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolyLikeFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */