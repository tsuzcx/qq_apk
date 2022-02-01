import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class vjx
  implements wbk
{
  public vjx(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    zwp.a().a(new QCircleContentImmersiveEvent(1));
    ArrayList localArrayList;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      localArrayList = new ArrayList();
      localArrayList.add(vri.a("ext1", "1"));
      if (!QCircleContentImmersiveEvent.isImmersive()) {
        break label98;
      }
    }
    label98:
    for (paramView = "2";; paramView = "1")
    {
      localArrayList.add(vri.a("ext4", paramView));
      vrg.a(90, 2, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, QCircleContentImage.d(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentImage), QCircleContentImage.b(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentImage), localArrayList, QCircleContentImage.f(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentImage));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjx
 * JD-Core Version:    0.7.0.1
 */