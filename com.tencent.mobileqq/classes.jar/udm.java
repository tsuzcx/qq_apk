import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class udm
  implements ucr
{
  public udm(QCircleFeedWidget paramQCircleFeedWidget, Object paramObject) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      String str = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).id.get();
      yiw.a().a(new QCircleDoublePraiseAnimationEvent(str, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedWidget.a().pageType, QCircleFeedWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedWidget)));
      QLog.d("QCircleDoubleClickLayout", 1, "dispatchEvent id:" + str + " pageType:" + this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFeedWidget.a().pageType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udm
 * JD-Core Version:    0.7.0.1
 */