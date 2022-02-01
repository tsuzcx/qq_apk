import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class vll
  extends uzu
  implements zwr
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout;
  private QCircleFullScreenStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView;
  private uyk jdField_a_of_type_Uyk;
  private vlr jdField_a_of_type_Vlr;
  private boolean jdField_a_of_type_Boolean;
  
  public vll(int paramInt)
  {
    super(paramInt, null, 1, 1);
  }
  
  private uzb a()
  {
    return new vlq(this);
  }
  
  private void a()
  {
    Object localObject = a().getResources().getString(2131697153);
    String str = a().getResources().getString(2131697152);
    if (a() != null)
    {
      a().a().addOnScrollListener(new vlm(this, str, (String)localObject));
      localObject = a();
      if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.isSingleFeed) {
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
    if ((this.jdField_a_of_type_Uyk != null) && (paramQCircleFeedEvent.mState == 3)) {
      a().finish();
    }
  }
  
  private void a(@NotNull uzp paramuzp)
  {
    if ((paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
    {
      if (a(paramuzp))
      {
        c(paramuzp);
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
  
  private boolean a(uzp paramuzp)
  {
    return (!paramuzp.jdField_a_of_type_Boolean) && (paramuzp.jdField_a_of_type_Long != 0L);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView != null) && (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null)) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView.startRewardAni(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getPolyLike(), this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.a(), this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.b(), true, null, false);
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131373871));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373152);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379652));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)paramView.findViewById(2131364755).findViewById(2131369361));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setUnPraiseDrawable(2130843991);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setPraisedDrawable(2130843991);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setIsContentDetail(true);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vln(this));
    if ((this.jdField_a_of_type_Uyk != null) && (this.jdField_a_of_type_Uyk.a() != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null))
    {
      this.jdField_a_of_type_Uyk.a().c((int)this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.mVideoCurrentPosition);
      this.jdField_a_of_type_Uyk.d(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.mDataPosInList);
    }
  }
  
  private void b(@NotNull uzp paramuzp)
  {
    Object localObject;
    if ((paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedDetailRsp))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(((FeedCloudRead.StGetFeedDetailRsp)paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro).feed.get());
      this.jdField_a_of_type_Uyk.setDatas((ArrayList)localObject);
    }
    int i;
    if ((paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro instanceof FeedCloudRead.StGetFeedListRsp))
    {
      localObject = (FeedCloudRead.StGetFeedListRsp)paramuzp.jdField_a_of_type_ComTencentMobileqqPbMessageMicro;
      if (paramuzp.jdField_a_of_type_Long != 0L) {
        break label168;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramuzp.jdField_a_of_type_Boolean)
        {
          paramuzp = new FeedCloudMeta.StFeed();
          paramuzp.dittoFeed.dittoId.set(-1);
          ((FeedCloudRead.StGetFeedListRsp)localObject).vecFeed.get().add(0, paramuzp);
        }
        this.jdField_a_of_type_Uyk.addAll(((FeedCloudRead.StGetFeedListRsp)localObject).vecFeed.get());
      }
      paramuzp = this.jdField_a_of_type_Uyk;
      if ((!this.jdField_a_of_type_Uyk.getLoadInfo().a()) && (i != 0)) {
        break label173;
      }
    }
    label168:
    label173:
    for (boolean bool = true;; bool = false)
    {
      paramuzp.a(true, bool);
      return;
      i = 0;
      break;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView = new QCircleFullScreenStatusView(a());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.setEmptyImageUrls("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/1-img/img_emptystate_feed.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/1-fullscreen/text_fullscreen_11.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/3-action/link_fullscreen_noaction.png");
    a().setStatusView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView);
  }
  
  private void c(@NotNull uzp paramuzp)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView != null)
    {
      if (!a(paramuzp.jdField_a_of_type_Long)) {
        break label77;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.a("");
    }
    for (;;)
    {
      QLog.w("BlockPart", 1, String.format("retCode:%s; msg:%s", new Object[] { String.valueOf(paramuzp.jdField_a_of_type_Long), paramuzp.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Uyk.clearData();
      this.jdField_a_of_type_Uyk.notifyDataSetChanged();
      return;
      label77:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFullScreenStatusView.b(null);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Uyk = new uyk(new Bundle());
    Object localObject = new ExtraTypeInfo();
    ((ExtraTypeInfo)localObject).pageType = 69;
    this.jdField_a_of_type_Uyk.a((ExtraTypeInfo)localObject);
    this.jdField_a_of_type_Uyk.setInteractor(a());
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.setExtraTypeInfo((ExtraTypeInfo)localObject);
    }
    this.jdField_a_of_type_Uyk.setOnLoadDataDelegate(new vlo(this));
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getFeed() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getFeed();
      this.jdField_a_of_type_Uyk.a((FeedCloudMeta.StFeed)localObject);
    }
    this.jdField_a_of_type_Uyk.a(a());
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Uyk);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Vlr.a().observe(a(), new vlp(this));
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Vlr = ((vlr)a(vlr.class));
    if ((a() != null) && (a().getIntent() != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    }
    d();
    super.a(paramView);
    b(paramView);
    b();
    c();
    a();
    e();
    zwp.a().a(this);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.isSingleFeed);
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
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vll
 * JD-Core Version:    0.7.0.1
 */