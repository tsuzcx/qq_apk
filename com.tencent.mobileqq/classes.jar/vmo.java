import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

public class vmo
  extends vmh
{
  private QCircleFollowView a;
  
  public vmo(int paramInt)
  {
    super(paramInt);
  }
  
  protected String a()
  {
    return "QCircleFollowMessagePresenter";
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  void b(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373802));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new vmp(this));
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    paramStNotice = (FeedCloudMeta.StUser)paramStNotice.operation.opUser.get();
    if (paramStNotice != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStNotice);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmo
 * JD-Core Version:    0.7.0.1
 */