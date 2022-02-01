import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.a;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class pfp
  implements QCircleDoubleClickLayout.a
{
  public pfp(QCircleFeedWidget paramQCircleFeedWidget, Object paramObject) {}
  
  public void biX()
  {
    if ((this.bg != null) && ((this.bg instanceof FeedCloudMeta.StFeed)))
    {
      String str = ((FeedCloudMeta.StFeed)this.bg).id.get();
      rwv.a().a(new QCircleDoublePraiseAnimationEvent(str, this.b.getExtraTypeInfo().pageType, QCircleFeedWidget.a(this.b)));
      QLog.d("QCircleDoubleClickLayout", 1, "dispatchEvent id:" + str + " pageType:" + this.b.getExtraTypeInfo().pageType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfp
 * JD-Core Version:    0.7.0.1
 */