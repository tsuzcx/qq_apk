import android.arch.lifecycle.MutableLiveData;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import java.util.ArrayList;
import java.util.List;

public class tsw
  extends tvv
{
  private int jdField_a_of_type_Int;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleComponentPageView jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QCircleSlidBottomView jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final String jdField_a_of_type_JavaLangString = "QCirclePolyListPart";
  private tte jdField_a_of_type_Tte;
  private ubt jdField_a_of_type_Ubt;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(ubz<List<FeedCloudMeta.StLightInteractInfo>> paramubz)
  {
    switch (paramubz.a())
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 4: 
      b(paramubz);
      return;
    }
    c(paramubz);
  }
  
  private void b(ubz<List<FeedCloudMeta.StLightInteractInfo>> paramubz)
  {
    if (paramubz.a() == 4) {}
    for (String str = alud.a(2131698381); !paramubz.b(); str = alud.a(2131698293))
    {
      this.jdField_a_of_type_Tte.clearData();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(0);
      a(false, false, false);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(str);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
    a(false, true, false);
  }
  
  private void c(ubz<List<FeedCloudMeta.StLightInteractInfo>> paramubz)
  {
    if (paramubz.a() != null)
    {
      if (paramubz.b()) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
      this.jdField_a_of_type_Tte.a((List)paramubz.a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
      if ((!paramubz.a()) && (!this.jdField_a_of_type_Boolean) && (paramubz.a() != 2)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      a(true, paramubz.b(), paramubz.a());
      return;
      label86:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
      this.jdField_a_of_type_Tte.a((List)paramubz.a());
      this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setRefreshing(false);
    }
  }
  
  public String a()
  {
    return "QCirclePolyListPart";
  }
  
  protected void a(View paramView)
  {
    tsx localtsx = new tsx(this);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView = ((QCircleSlidBottomView)paramView.findViewById(2131373225));
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setOnClickListener(localtsx);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setStatusListener(new tsy(this));
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView = ((QCircleComponentPageView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373222));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373223));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localtsx);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373156));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373211));
    new LinearLayoutManager(paramView.getContext()).setOrientation(1);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a().a(2);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setRefreshing(false);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.jdField_a_of_type_Tte = new tte(this, null);
    paramView.add(this.jdField_a_of_type_Tte);
    this.jdField_a_of_type_Tte.setOnLoadDataDelegate(new tsz(this));
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a(paramView);
    this.jdField_a_of_type_Tte.a(this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a());
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.c();
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof ttf))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((ttf)paramObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_Int = ((ttf)paramObject).jdField_a_of_type_Int;
    }
    if (paramString.equals("poly_zan_list_show"))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = (this.jdField_a_of_type_Int + 1);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a().e();
      this.jdField_a_of_type_Tte.clearData();
      this.jdField_a_of_type_Ubt = ((ubt)a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), ubt.class));
      this.jdField_a_of_type_Ubt.a().removeObservers(a());
      this.jdField_a_of_type_Ubt.a().observe(a(), new tta(this));
      this.jdField_a_of_type_Ubt.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, false, false);
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        tzs.a(70, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      }
    }
    while ((!paramString.equals("poly_zan_list_dismiss")) || (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.b();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView != null) && (this.jdField_a_of_type_Tte.getParentAdapter() != null))
    {
      this.jdField_a_of_type_Tte.getLoadInfo().a(4);
      this.jdField_a_of_type_Tte.getLoadInfo().a(paramBoolean3);
      this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setRefreshing(false);
      this.jdField_a_of_type_Tte.getParentAdapter().a(false);
      this.jdField_a_of_type_Tte.getParentAdapter().a("");
      this.jdField_a_of_type_Tte.getParentAdapter().a(paramBoolean1, paramBoolean3);
      QLog.d("QCirclePolyListPart", 3, "iscuccess:" + paramBoolean1 + " isfinish:" + paramBoolean3);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.b();
      return true;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsw
 * JD-Core Version:    0.7.0.1
 */