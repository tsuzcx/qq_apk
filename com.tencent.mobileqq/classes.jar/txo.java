import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class txo
  implements uhq
{
  public txo(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      String str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get();
      int i = tzy.a().a();
      yiw.a().a(new QCircleDoublePraiseAnimationEvent(str, i, QCircleContentImage.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentImage)));
      QLog.d("QCircleContentImage", 1, "dispatchEvent id:" + str + " pageType:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txo
 * JD-Core Version:    0.7.0.1
 */