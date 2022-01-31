import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.widget.AnimationView;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class ueq
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private QQCircleFeedBase.StPolyLike jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike;
  
  public ueq(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131560577, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373209));
  }
  
  public AnimationView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  }
  
  public QQCircleFeedBase.StPolyLike a()
  {
    return this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike = paramStPolyLike;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ueq
 * JD-Core Version:    0.7.0.1
 */