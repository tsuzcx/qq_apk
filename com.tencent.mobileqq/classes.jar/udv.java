import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

public class udv
  extends ucz
{
  private static final String jdField_a_of_type_JavaLangString = udv.class.getSimpleName();
  private QCircleRockeyPopupView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView;
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372528));
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
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setFeedId(localStFeed.id.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udv
 * JD-Core Version:    0.7.0.1
 */