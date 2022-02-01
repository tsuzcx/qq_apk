import android.arch.lifecycle.MutableLiveData;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import java.util.ArrayList;
import java.util.List;

public class vbt
  extends uzu
{
  private int jdField_a_of_type_Int;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleBlockContainer jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QCircleSlidBottomView jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final String jdField_a_of_type_JavaLangString = "QCircleLightInteractListPart";
  private vby jdField_a_of_type_Vby;
  private vub jdField_a_of_type_Vub;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  private void a(vup<List<FeedCloudMeta.StLightInteractInfo>> paramvup)
  {
    switch (paramvup.a())
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 4: 
      b(paramvup);
      return;
    }
    c(paramvup);
  }
  
  private void b(vup<List<FeedCloudMeta.StLightInteractInfo>> paramvup)
  {
    if (paramvup.a() == 4) {}
    for (String str = anni.a(2131697253); (!paramvup.b()) && (this.jdField_a_of_type_Vby.getItemCount() <= 0); str = anni.a(2131697142))
    {
      this.jdField_a_of_type_Vby.clearData();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(0);
      a(false, false, false);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.a(str);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
    a(false, true, false);
  }
  
  private void c(vup<List<FeedCloudMeta.StLightInteractInfo>> paramvup)
  {
    if (paramvup.a() != null)
    {
      if (paramvup.b()) {
        break label69;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.b()) {
        this.jdField_a_of_type_Vby.a((List)paramvup.a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      a(true, paramvup.b(), paramvup.a());
      return;
      label69:
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.b())
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
        this.jdField_a_of_type_Vby.a((List)paramvup.a());
      }
    }
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractListPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean).clone().setModuleIdStr(b());
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractListPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean()).clone().setModuleIdStr(b());
    }
    return null;
  }
  
  public String a()
  {
    return "QCircleLightInteractListPart";
  }
  
  protected void a(View paramView)
  {
    vbu localvbu = new vbu(this);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView = ((QCircleSlidBottomView)paramView.findViewById(2131373844));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373847));
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setOnClickListener(localvbu);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setStatusListener(new vbv(this));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = ((QCircleBlockContainer)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373846));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localvbu);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373788));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373845));
    new LinearLayoutManager(paramView.getContext()).setOrientation(1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().a(2);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableRefresh(false);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.jdField_a_of_type_Vby = new vby(this, null);
    paramView.add(this.jdField_a_of_type_Vby);
    this.jdField_a_of_type_Vby.setOnLoadDataDelegate(new vbw(this));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a(paramView);
    this.jdField_a_of_type_Vby.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.c();
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof vca))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((vca)paramObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_Int = ((vca)paramObject).jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaLangString = ((vca)paramObject).jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_Int = ((vca)paramObject).jdField_b_of_type_Int;
    }
    if (paramString.equals("light_interact_list_show"))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = (this.jdField_a_of_type_Int + 1);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().e();
      this.jdField_a_of_type_Vby.clearData();
      this.jdField_a_of_type_Vub = ((vub)a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get() + this.jdField_b_of_type_Int, vub.class));
      this.jdField_a_of_type_Vub.a().removeObservers(a());
      this.jdField_a_of_type_Vub.a().observe(a(), new vbx(this));
      this.jdField_a_of_type_Vub.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, false, false, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        if (this.jdField_b_of_type_Int != 1) {
          break label252;
        }
        vrc.a(87, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, c());
      }
    }
    label252:
    while ((!paramString.equals("light_interact_list_dismiss")) || (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView == null))
    {
      return;
      vrc.a(70, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, c());
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.d();
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) && (this.jdField_a_of_type_Vby.getBlockMerger() != null))
    {
      this.jdField_a_of_type_Vby.getLoadInfo().a(4);
      this.jdField_a_of_type_Vby.getLoadInfo().a(paramBoolean3);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setRefreshing(false);
      this.jdField_a_of_type_Vby.getBlockMerger().a(false);
      this.jdField_a_of_type_Vby.getBlockMerger().a("");
      this.jdField_a_of_type_Vby.getBlockMerger().a(paramBoolean1, paramBoolean3);
      QLog.d("QCircleLightInteractListPart", 3, "iscuccess:" + paramBoolean1 + " isfinish:" + paramBoolean3);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.d();
      return true;
    }
    return super.a();
  }
  
  protected String b()
  {
    if (this.jdField_b_of_type_Int == 1) {
      return "pushlist";
    }
    if (this.jdField_b_of_type_Int == 2) {
      return "likelist";
    }
    return null;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleLightInteractListPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getPageId("QCircleLightInteractListPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbt
 * JD-Core Version:    0.7.0.1
 */