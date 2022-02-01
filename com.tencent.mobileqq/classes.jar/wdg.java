import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

public class wdg
  extends wcw
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wdj(this);
  private QCircleExpandableTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView;
  
  private void a(View paramView)
  {
    if (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    uyy.a().a(paramView, new wdk(this, localStFeed), new wdl(this));
  }
  
  private boolean d()
  {
    return QCircleReportBean.isFeedDetailPage(a().getPageId());
  }
  
  protected String a()
  {
    return "QCircleFeedItemDesPresenter";
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView = ((QCircleExpandableTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373928));
      paramViewStub = (QCircleAsyncTextView)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a();
      if (paramViewStub != null)
      {
        paramViewStub.c();
        paramViewStub.setOnLongClickListener(new wdh(this));
      }
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    if (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
    paramObject = (FeedCloudMeta.StFeed)paramObject;
    if (TextUtils.isEmpty(paramObject.content.get()))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(8);
      return;
    }
    boolean bool = d();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setText(paramObject.content.get(), bool, new wdi(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdg
 * JD-Core Version:    0.7.0.1
 */