import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;

public class ugk
  extends uga
{
  private float jdField_a_of_type_Float = 1.777778F;
  private QCircleDoublePraiseView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView;
  private float jdField_b_of_type_Float = 0.75F;
  private int jdField_b_of_type_Int = ImmersiveUtils.a();
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.type.get() != 3) {
      return;
    }
    int m = paramStFeed.video.width.get();
    int n = paramStFeed.video.height.get();
    int k = this.jdField_b_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    int i = j;
    float f;
    if (m != 0)
    {
      i = j;
      if (n != 0)
      {
        f = m / n;
        if (f < this.jdField_a_of_type_Float) {
          break label129;
        }
        i = (int)(k / this.jdField_a_of_type_Float);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.getLayoutParams().width = k;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.getLayoutParams().height = i;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setLayoutParams(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.getLayoutParams());
      return;
      label129:
      if ((f > this.jdField_b_of_type_Float) && (f <= this.jdField_a_of_type_Float)) {
        i = (int)(k / f);
      } else {
        i = (int)(k / this.jdField_b_of_type_Float);
      }
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView = ((QCircleDoublePraiseView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372527));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setFeed(localStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoublePraiseView.setPageType(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
        a(localStFeed);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugk
 * JD-Core Version:    0.7.0.1
 */