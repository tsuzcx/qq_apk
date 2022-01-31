import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;

public class ugj
  extends uga
{
  private QCircleExpandableTextView a;
  private QCircleExpandableTextView b;
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373165));
      this.b = ((QCircleExpandableTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373167));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    FeedCloudMeta.StRecomForward localStRecomForward;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((paramObject instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      paramObject = (FeedCloudMeta.StFeed)paramObject;
      ((QCircleAsyncTextView)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.b()).c();
      if (!paramObject.isRecomFd.get()) {
        break label248;
      }
      localStRecomForward = paramObject.recomForward;
      if (!TextUtils.isEmpty(localStRecomForward.title.get())) {
        break label132;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(8);
    }
    while (paramObject.content.get().isEmpty())
    {
      this.b.setVisibility(8);
      return;
      label132:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(localStRecomForward.title.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(0);
    }
    if (this.b.b() != null) {
      a((FeedCloudMeta.StUser)paramObject.poster.get(), paramObject.content.get(), (QCircleAsyncTextView)this.b.b());
    }
    this.b.setText(paramObject.poster.nick.get().trim() + ":" + paramObject.content.get(), false);
    return;
    label248:
    if (TextUtils.isEmpty(paramObject.content.get())) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(8);
    }
    for (;;)
    {
      this.b.setVisibility(8);
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(paramObject.content.get(), false);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugj
 * JD-Core Version:    0.7.0.1
 */