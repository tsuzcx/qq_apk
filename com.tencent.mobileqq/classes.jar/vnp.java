import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class vnp
  extends vbk
  implements aaam
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout;
  private QCircleFullScreenStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView;
  private uzt jdField_a_of_type_Uzt;
  private vnv jdField_a_of_type_Vnv;
  private boolean jdField_a_of_type_Boolean;
  
  public vnp(int paramInt)
  {
    super(paramInt, null, 1, 1);
  }
  
  private var a()
  {
    return new vnu(this);
  }
  
  private void a()
  {
    Object localObject = a().getResources().getString(2131697214);
    String str = a().getResources().getString(2131697213);
    if (a() != null)
    {
      a().a().addOnScrollListener(new vnq(this, str, (String)localObject));
      localObject = a();
      if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.isSingleFeed()) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      ((QCircleBlockContainer)localObject).setEnableRefresh(bool);
      return;
    }
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if ((this.jdField_a_of_type_Uzt != null) && (paramQCircleFeedEvent.mState == 3)) {
      a().finish();
    }
  }
  
  private void a(@NotNull vbf paramvbf)
  {
    if ((paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
    {
      if (a(paramvbf))
      {
        c(paramvbf);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.a();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(long paramLong)
  {
    return paramLong == 10014L;
  }
  
  private boolean a(vbf paramvbf)
  {
    return (!paramvbf.jdField_a_of_type_Boolean) && (paramvbf.jdField_a_of_type_Long != 0L);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView != null) && (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null)) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView.startRewardAni(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getPolyLike(), this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.a(), this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.b(), true, null, false);
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131374004));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373265);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379827));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)paramView.findViewById(2131364802).findViewById(2131369451));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setUnPraiseDrawable(2130844011);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setPraisedDrawable(2130844011);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setIsContentDetail(true);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vnr(this));
    if ((this.jdField_a_of_type_Uzt != null) && (this.jdField_a_of_type_Uzt.a() != null) && (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null))
    {
      this.jdField_a_of_type_Uzt.a().c((int)this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getVideoCurrentPosition());
      this.jdField_a_of_type_Uzt.d(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getDataPosInList());
    }
  }
  
  private void b(@NotNull vbf paramvbf)
  {
    Object localObject;
    if ((paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
    {
      localObject = new ArrayList();
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((FeedCloudRead.StGetFeedDetailRsp)paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feed.get();
      ((ArrayList)localObject).add(localStFeed);
      vjy.a().a(localStFeed.id.get(), (ArrayList)localStFeed.vecComment.get());
      this.jdField_a_of_type_Uzt.setDatas((ArrayList)localObject);
    }
    int i;
    if ((paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedListRsp))
    {
      localObject = (FeedCloudRead.StGetFeedListRsp)paramvbf.jdField_a_of_type_ComTencentMobileqqPbMessageMicro;
      if (paramvbf.jdField_a_of_type_Long != 0L) {
        break label201;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramvbf.jdField_a_of_type_Boolean)
        {
          paramvbf = new FeedCloudMeta.StFeed();
          paramvbf.dittoFeed.dittoId.set(-1);
          ((FeedCloudRead.StGetFeedListRsp)localObject).vecFeed.get().add(0, paramvbf);
        }
        this.jdField_a_of_type_Uzt.addAll(((FeedCloudRead.StGetFeedListRsp)localObject).vecFeed.get());
      }
      paramvbf = this.jdField_a_of_type_Uzt;
      if ((!this.jdField_a_of_type_Uzt.getLoadInfo().a()) && (i != 0)) {
        break label206;
      }
    }
    label201:
    label206:
    for (boolean bool = true;; bool = false)
    {
      paramvbf.a(true, bool);
      return;
      i = 0;
      break;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView = new QCircleFullScreenStatusView(a());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.setBackgroundColor(a().getResources().getColor(2131166234));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.setEmptyImageUrls("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_feed.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/1-fullscreen/text_fullscreen_11.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_fullscreen_noaction.png");
    a().setStatusView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView);
  }
  
  private void c(@NotNull vbf paramvbf)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView != null)
    {
      if (!a(paramvbf.jdField_a_of_type_Long)) {
        break label77;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.a("");
    }
    for (;;)
    {
      QLog.w("BlockPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramvbf.jdField_a_of_type_Long), paramvbf.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Uzt.clearData();
      this.jdField_a_of_type_Uzt.notifyDataSetChanged();
      return;
      label77:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.b(null);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Uzt = new uzt(new Bundle());
    Object localObject = new ExtraTypeInfo();
    ((ExtraTypeInfo)localObject).pageType = 69;
    this.jdField_a_of_type_Uzt.a((ExtraTypeInfo)localObject);
    this.jdField_a_of_type_Uzt.setInteractor(a());
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.setExtraTypeInfo((ExtraTypeInfo)localObject);
    }
    this.jdField_a_of_type_Uzt.setOnLoadDataDelegate(new vns(this));
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getFeed() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getFeed();
      this.jdField_a_of_type_Uzt.a((FeedCloudMeta.StFeed)localObject);
    }
    this.jdField_a_of_type_Uzt.a(a());
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Uzt);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Vnv.a().observe(a(), new vnt(this));
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Vnv = ((vnv)a(vnv.class));
    if ((a() != null) && (a().getIntent() != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    }
    d();
    super.a(paramView);
    b(paramView);
    b();
    c();
    a();
    e();
    aaak.a().a(this);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.isSingleFeed());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    aaak.a().b(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    vtq.a("", 54, 1, 1, "", "", "", "", "", null, a().getPageId(), a().getFromPageId());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */