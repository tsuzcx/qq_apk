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

public class phu
  extends phl
{
  private QCircleExpandableTextView b;
  private QCircleExpandableTextView c;
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)this.mContainer.findViewById(2131374517));
      this.c = ((QCircleExpandableTextView)this.mContainer.findViewById(2131374519));
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    FeedCloudMeta.StRecomForward localStRecomForward;
    if ((this.mData != null) && ((paramObject instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.mPos;
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      paramObject = (FeedCloudMeta.StFeed)paramObject;
      ((QCircleAsyncTextView)this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.x()).bxX();
      if (!paramObject.isRecomFd.get()) {
        break label248;
      }
      localStRecomForward = paramObject.recomForward;
      if (!TextUtils.isEmpty(localStRecomForward.title.get())) {
        break label132;
      }
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(8);
    }
    while (paramObject.content.get().isEmpty())
    {
      this.c.setVisibility(8);
      return;
      label132:
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(localStRecomForward.title.get());
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(0);
    }
    if (this.c.x() != null) {
      a((FeedCloudMeta.StUser)paramObject.poster.get(), paramObject.content.get(), (QCircleAsyncTextView)this.c.x());
    }
    this.c.setText(paramObject.poster.nick.get().trim() + ":" + paramObject.content.get(), false);
    return;
    label248:
    if (TextUtils.isEmpty(paramObject.content.get())) {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(8);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      return;
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(paramObject.content.get(), false);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phu
 * JD-Core Version:    0.7.0.1
 */