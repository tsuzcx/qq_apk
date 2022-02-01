import com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Collections;

public class vyd
  implements vqj
{
  public vyd(QCircleBaseVideoView paramQCircleBaseVideoView, int paramInt, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    QCircleBaseVideoView.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView, QCircleBaseVideoView.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView), "video_exchange_url", this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView.a(), Collections.singletonList(vtt.a("ret_code", String.valueOf(paramLong))));
    if (VSNetworkHelper.a((int)paramLong)) {
      return;
    }
    QCircleBaseVideoView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo, this.jdField_a_of_type_Int);
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    QCircleBaseVideoView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView, paramStVideo, this.jdField_a_of_type_Int);
    if (!paramBoolean) {
      QCircleBaseVideoView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView, QCircleBaseVideoView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView), "video_exchange_url", this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBaseVideoView.a(), Collections.singletonList(vtt.a("ret_code", "0")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyd
 * JD-Core Version:    0.7.0.1
 */