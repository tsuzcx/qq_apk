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

public class vdj
  extends vbk
{
  private int jdField_a_of_type_Int;
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleBlockContainer jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QCircleSlidBottomView jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final String jdField_a_of_type_JavaLangString = "QCircleLightInteractListPart";
  private vdo jdField_a_of_type_Vdo;
  private vxa jdField_a_of_type_Vxa;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  private void a(vxq<List<FeedCloudMeta.StLightInteractInfo>> paramvxq)
  {
    switch (paramvxq.a())
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 4: 
      b(paramvxq);
      return;
    }
    c(paramvxq);
  }
  
  private void b(vxq<List<FeedCloudMeta.StLightInteractInfo>> paramvxq)
  {
    if (paramvxq.a() == 4) {
      anzj.a(2131697330);
    }
    while ((!paramvxq.b()) && (this.jdField_a_of_type_Vdo.getItemCount() <= 0))
    {
      this.jdField_a_of_type_Vdo.clearData();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(0);
      a(false, false, false);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(null);
      return;
      anzj.a(2131697203);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
    a(false, true, false);
  }
  
  private void c(vxq<List<FeedCloudMeta.StLightInteractInfo>> paramvxq)
  {
    if (paramvxq.a() != null)
    {
      if (paramvxq.b()) {
        break label69;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.c()) {
        this.jdField_a_of_type_Vdo.a((List)paramvxq.a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      a(true, paramvxq.b(), paramvxq.a());
      return;
      label69:
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.c())
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
        this.jdField_a_of_type_Vdo.a((List)paramvxq.a());
      }
    }
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractListPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean).clone().setModuleIdStr(b());
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractListPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean()).clone().setModuleIdStr(b());
    }
    return null;
  }
  
  public String a()
  {
    return "QCircleLightInteractListPart";
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
  
  protected void a(View paramView)
  {
    vdk localvdk = new vdk(this);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView = ((QCircleSlidBottomView)paramView.findViewById(2131373976));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373979));
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setOnClickListener(localvdk);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setStatusListener(new vdl(this));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = ((QCircleBlockContainer)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373978));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localvdk);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373914));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131373977));
    new LinearLayoutManager(paramView.getContext()).setOrientation(1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().a(2);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableRefresh(false);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.jdField_a_of_type_Vdo = new vdo(this, null);
    paramView.add(this.jdField_a_of_type_Vdo);
    this.jdField_a_of_type_Vdo.setOnLoadDataDelegate(new vdm(this));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a(paramView);
    this.jdField_a_of_type_Vdo.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.c();
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof vdq))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((vdq)paramObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_Int = ((vdq)paramObject).jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaLangString = ((vdq)paramObject).jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_Int = ((vdq)paramObject).jdField_b_of_type_Int;
    }
    if (paramString.equals("light_interact_list_show"))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = (this.jdField_a_of_type_Int + 1);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().e();
      this.jdField_a_of_type_Vdo.clearData();
      this.jdField_a_of_type_Vxa = ((vxa)a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get() + this.jdField_b_of_type_Int, vxa.class));
      this.jdField_a_of_type_Vxa.a().removeObservers(a());
      this.jdField_a_of_type_Vxa.a().observe(a(), new vdn(this));
      this.jdField_a_of_type_Vxa.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, false, false, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        if (this.jdField_b_of_type_Int != 1) {
          break label252;
        }
        vtn.a(87, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, c());
      }
    }
    label252:
    while ((!paramString.equals("light_interact_list_dismiss")) || (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView == null))
    {
      return;
      vtn.a(70, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, c());
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.d();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) && (this.jdField_a_of_type_Vdo.getBlockMerger() != null))
    {
      this.jdField_a_of_type_Vdo.getLoadInfo().a(4);
      this.jdField_a_of_type_Vdo.getLoadInfo().a(paramBoolean3);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setRefreshing(false);
      this.jdField_a_of_type_Vdo.getBlockMerger().a(false);
      this.jdField_a_of_type_Vdo.getBlockMerger().a("");
      this.jdField_a_of_type_Vdo.getBlockMerger().a(paramBoolean1, paramBoolean3);
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
    if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 4)) {
      return "likelist";
    }
    return null;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleLightInteractListPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getPageId("QCircleLightInteractListPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdj
 * JD-Core Version:    0.7.0.1
 */