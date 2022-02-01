import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class vee
  extends vbk
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private QCirclePolymerizationBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean;
  private QCircleFullScreenStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView;
  private van jdField_a_of_type_Van;
  private vbn jdField_a_of_type_Vbn;
  private vxh jdField_a_of_type_Vxh;
  
  public vee(List<aabp> paramList, int paramInt1, int paramInt2)
  {
    super(2131365189, paramList, paramInt1, paramInt2);
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_Vbn = ((vbn)paramList.get(0));
    }
    if ((paramList != null) && (paramList.size() > 1)) {
      this.jdField_a_of_type_Van = ((van)paramList.get(1));
    }
  }
  
  private var a()
  {
    return new vej(this);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Van == null) || (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean == null)) {
      return;
    }
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    switch (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Van.a(localExtraTypeInfo);
      return;
      localExtraTypeInfo.pageType = 7;
      a().a("publish_show_or_hide", Boolean.valueOf(true));
      continue;
      localExtraTypeInfo.pageType = 12;
      a().a("publish_show_or_hide", Boolean.valueOf(false));
      continue;
      localExtraTypeInfo.pageType = 13;
      a().a("publish_show_or_hide", Boolean.valueOf(true));
    }
  }
  
  private void a(int paramInt)
  {
    int i = 255;
    this.jdField_a_of_type_Int += paramInt;
    paramInt = (int)(this.jdField_a_of_type_Int * 1.0F / this.jdField_a_of_type_Float * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      b("polymerization_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView != null)
    {
      if (a(paramLong)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.a("");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.b(null);
  }
  
  private void a(vxq<QQCircleFeedBase.StFeedListBusiRspData> paramvxq)
  {
    if (paramvxq == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramvxq.a())
          {
          case 1: 
          default: 
            return;
          case 0: 
            QLog.e("BlockPart", 1, "handleHeaderRsp() return empty data");
            return;
          }
        } while (paramvxq.a() == null);
        this.jdField_a_of_type_Vbn.setDatas(new ArrayList(Arrays.asList(new QQCircleFeedBase.StFeedListBusiRspData[] { (QQCircleFeedBase.StFeedListBusiRspData)paramvxq.a() })));
        this.jdField_a_of_type_Vbn.notifyLoadingComplete(true);
      } while ((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean == null) || (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType() != 7));
      b("tab_rsp", paramvxq.a());
      paramvxq = (QQCircleFeedBase.StFeedListBusiRspData)paramvxq.a();
    } while ((paramvxq == null) || (!paramvxq.tagPageData.tagInfo.has()));
    vrc localvrc = vrc.a();
    String str = paramvxq.tagPageData.tagInfo.tagId.get();
    if (paramvxq.tagPageData.tagInfo.followState.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localvrc.a(str, bool);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vxh == null) {
      return;
    }
    if (aadg.a("2008"))
    {
      QLog.i("BlockPart", 1, "runPreload");
      aadg.a("2008", new vek(this));
      return;
    }
    this.jdField_a_of_type_Vxh.a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean, false, paramBoolean);
  }
  
  private boolean a(long paramLong)
  {
    return paramLong == 10014L;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    a(0);
  }
  
  private void b(vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    if (paramvxq == null) {
      return;
    }
    boolean bool = paramvxq.a();
    int i;
    switch (paramvxq.a())
    {
    case 1: 
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Van != null))
    {
      this.jdField_a_of_type_Van.getLoadInfo().a(bool);
      this.jdField_a_of_type_Van.notifyLoadingComplete(true);
      return;
      QLog.e("BlockPart", 1, "handleFeedsRsp() return empty data");
      if ((paramvxq.b()) && (this.jdField_a_of_type_Van != null) && (this.jdField_a_of_type_Van.getItemCount() > 0))
      {
        this.jdField_a_of_type_Van.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.a("");
          i = 1;
          continue;
          if (paramvxq.a() == null) {}
          for (String str = anzj.a(2131718459);; str = paramvxq.a())
          {
            QLog.e("BlockPart", 1, "handleFeedsRsp() return error！errMsg:" + str);
            if ((this.jdField_a_of_type_Van != null) && (this.jdField_a_of_type_Van.getItemCount() > 0)) {
              vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, str, 1);
            }
            a(paramvxq.a());
            i = 1;
            break;
          }
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.a();
          }
          if (this.jdField_a_of_type_Van == null) {
            break;
          }
          if (paramvxq.b()) {
            this.jdField_a_of_type_Van.addAll((List)paramvxq.a());
          }
          for (;;)
          {
            this.jdField_a_of_type_Van.getLoadInfo().a(bool);
            i = 1;
            break;
            this.jdField_a_of_type_Van.setDatas((ArrayList)paramvxq.a());
          }
        }
        i = 1;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView = new QCircleFullScreenStatusView(a());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.setBackgroundColor(a().getResources().getColor(2131166234));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.setEmptyImageUrls("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_feed.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_01.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_fullscreen_noaction.png");
    a().setStatusView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Float = zps.a(a(), 40.0F);
    this.jdField_a_of_type_Vxh = ((vxh)a(vxh.class));
    this.jdField_a_of_type_Vxh.a.observe(a(), new vef(this));
    this.jdField_a_of_type_Vxh.b.observe(a(), new veg(this));
    this.jdField_a_of_type_Van.setOnLoadDataDelegate(new veh(this));
    this.jdField_a_of_type_Van.setInteractor(a());
    this.jdField_a_of_type_Van.a(a());
    a();
    super.a(paramView);
    c();
    if ((a() != null) && (a().a() != null))
    {
      a().setEnableRefresh(true);
      a().setEnableLoadMore(true);
      a().a().a(1);
      a().a().addOnScrollListener(new vei(this));
    }
  }
  
  public void a(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean = paramQCirclePolymerizationBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vee
 * JD-Core Version:    0.7.0.1
 */