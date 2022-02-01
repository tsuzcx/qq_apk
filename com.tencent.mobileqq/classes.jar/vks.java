import android.animation.ValueAnimator;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.10;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.11;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.LbsDescPublishEvent;
import com.tencent.biz.subscribe.event.TagDescPublishEvent;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StGpsPageData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class vks
  extends uzu
  implements aaim, zwr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private QCircleTransitionInnerLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout;
  private QCircleTransitionLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  private QCircleLayerStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLayerStatusView;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private vjm jdField_a_of_type_Vjm;
  private vkb jdField_a_of_type_Vkb;
  private vld jdField_a_of_type_Vld;
  private vlg jdField_a_of_type_Vlg;
  private vsn jdField_a_of_type_Vsn;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c;
  
  private FeedCloudMeta.StFeed a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_Vkb != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Vkb.a() != null)
      {
        localObject3 = this.jdField_a_of_type_Vkb.a();
        if (!(localObject3 instanceof vjs)) {
          break label60;
        }
        localObject1 = ((vjs)localObject3).a;
        if (localObject1 == null) {
          break label91;
        }
        localObject1 = (FeedCloudMeta.StFeed)((QCircleContentImage)localObject1).a();
      }
    }
    for (;;)
    {
      return localObject1;
      label60:
      localObject1 = localObject2;
      if ((localObject3 instanceof vjt))
      {
        localObject3 = ((vjt)localObject3).a;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          return (FeedCloudMeta.StFeed)((QCircleContentVideo)localObject3).a();
          label91:
          localObject1 = null;
        }
      }
    }
  }
  
  private uzb a()
  {
    return new vlc(this);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAlpha(paramInt);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setAlpha(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setFloatValues(new float[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new vkw(this));
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.start();
  }
  
  private void a(View paramView, uzp paramuzp)
  {
    int j = 0;
    String str = bgjb.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count");
    int i;
    if (str.equals(""))
    {
      i = 0;
      if (i < 3) {
        j = 1;
      }
      if ((j == 0) || (uxb.a) || (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean == null) || (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.isSingleFeed) || (a(paramuzp))) {
        break label201;
      }
      n();
      this.jdField_a_of_type_Vlg = new vlg(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Vlg.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      this.jdField_a_of_type_Vlg.a();
      this.jdField_a_of_type_Vlg.a(new vkx(this));
      uxb.a = true;
      bgjb.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count", String.valueOf(i + 1));
      paramuzp = new ArrayList();
      if (!b()) {
        break label195;
      }
    }
    label195:
    for (paramView = "1";; paramView = "2")
    {
      paramuzp.add(vri.a("ext1", paramView));
      vrg.a(85, 1, a(), paramuzp, b());
      return;
      i = Integer.parseInt(str);
      break;
    }
    label201:
    o();
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (this.jdField_a_of_type_Vld != null)
    {
      if (paramQCircleFeedEvent.mState != 3) {
        break label114;
      }
      this.jdField_a_of_type_Vld.a(paramQCircleFeedEvent.mTargetId);
      if ((this.jdField_a_of_type_Vld.getDataList().size() == 0) && (a() != null)) {
        a().finish();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vld.getDataList().size() == 0)
      {
        paramQCircleFeedEvent = this.jdField_a_of_type_Vkb;
        if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo() != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo().sourceType == 10)) {
          paramQCircleFeedEvent.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, false);
        }
      }
      return;
      label114:
      if (paramQCircleFeedEvent.mState == 6) {
        a(paramQCircleFeedEvent.mTargetId);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      vld localvld = this.jdField_a_of_type_Vld;
      if (localvld != null)
      {
        ArrayList localArrayList = localvld.getDataList();
        if (localArrayList != null)
        {
          int i = localArrayList.size() - 1;
          while (i >= 0)
          {
            if (paramString.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).poster.id.get())) {
              try
              {
                localvld.delete(i);
                localvld.notifyItemRemoved(i);
                return;
              }
              catch (Throwable paramString)
              {
                QLog.e("QCircleContentPart", 1, "onReceiveEvent() delete local feed error!", paramString);
                return;
              }
            }
            i -= 1;
          }
        }
      }
    }
  }
  
  private void a(@Nullable uzp paramuzp)
  {
    paramuzp = (FeedCloudRead.StGetFeedListRsp)paramuzp.a;
    QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData;
    if (paramuzp.busiRspData.has()) {
      localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
    }
    try
    {
      localStFeedListBusiRspData.mergeFrom(paramuzp.busiRspData.get().toByteArray());
      if (localStFeedListBusiRspData.tagPageData.has())
      {
        if (paramuzp.vecFeed.size() == 0) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLayerStatusView.a(true);
        }
        paramuzp = localStFeedListBusiRspData.tagPageData.tagDesc.get();
        if (!TextUtils.isEmpty(paramuzp)) {
          zwp.a().a(new TagDescPublishEvent(paramuzp));
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      do
      {
        do
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        } while (!localStFeedListBusiRspData.gpsPageData.has());
        paramuzp = localStFeedListBusiRspData.gpsPageData.pageDesc.get();
      } while (TextUtils.isEmpty(paramuzp));
      zwp.a().a(new LbsDescPublishEvent(paramuzp));
    }
  }
  
  private boolean a(long paramLong)
  {
    return paramLong == 10014L;
  }
  
  private boolean a(uzp paramuzp)
  {
    if ((paramuzp != null) && ((paramuzp.a instanceof FeedCloudRead.StGetFeedListRsp))) {
      return ((FeedCloudRead.StGetFeedListRsp)paramuzp.a).vecFeed.size() == 0;
    }
    return true;
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLayerStatusView = ((QCircleLayerStatusView)paramView.findViewById(2131378110));
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    FeedCloudMeta.StFeed localStFeed = a();
    boolean bool1 = bool2;
    if (localStFeed != null)
    {
      bool1 = bool2;
      if (2 == localStFeed.type.get()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    RecyclerView.ViewHolder localViewHolder;
    if ((this.jdField_a_of_type_Vkb != null) && (this.jdField_a_of_type_Vkb.a() != null))
    {
      localViewHolder = this.jdField_a_of_type_Vkb.a();
      if (!(localViewHolder instanceof vjs)) {}
    }
    for (int i = ((vjs)localViewHolder).a.b();; i = -1) {
      return (this.jdField_a_of_type_Vsn != null) && (this.jdField_a_of_type_Int == 0) && (i == 0);
    }
  }
  
  private void e()
  {
    QCircleContentImmersiveEvent.resetImmersive();
    this.jdField_a_of_type_Vjm = new vjm();
    this.jdField_a_of_type_Vjm.a(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_Vjm.a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_Vjm.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_Vjm.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private void f()
  {
    Intent localIntent = a().getIntent();
    if (localIntent != null)
    {
      if (((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean")).getTagInfo().has()) {
        a().mPlayScene = 3;
      }
    }
    else {
      return;
    }
    a().mPlayScene = 2;
  }
  
  private void g()
  {
    if ((a() != null) && (a().getIntent().hasExtra("bundle_key_parms_extra")))
    {
      Object localObject = a().getIntent().getBundleExtra("bundle_key_parms_extra");
      if (aaid.a((Bundle)localObject))
      {
        this.jdField_a_of_type_Vsn = new vsn((Bundle)localObject);
        if (this.jdField_a_of_type_Vsn.a() != null)
        {
          localObject = new FrameLayout.LayoutParams(-1, -1);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Vsn.a(), (ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_Vsn.a(this);
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Vkb.a().observe(a(), new vky(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new vkz(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new vla(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new vlb(this));
    }
  }
  
  private void j()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L)
    {
      Toast.makeText(a(), 2131697175, 0).show();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Vkb != null) && (!this.jdField_a_of_type_Vkb.a().a()) && (!this.jdField_a_of_type_Vkb.a().b()))
    {
      this.jdField_a_of_type_Vkb.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, true);
      n();
    }
  }
  
  private void l()
  {
    if ((a() != null) && (a().getIntent() != null)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
        if (this.jdField_a_of_type_Vld != null)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getFeed();
          if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).type.get() != 0))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.jdField_a_of_type_Vld.setDatas((ArrayList)localObject2);
            this.c = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getDataPosInList();
            this.jdField_a_of_type_Vld.a(this.c);
            this.jdField_a_of_type_Vld.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.mVideoCurrentPosition);
            m();
          }
          Object localObject2 = this.jdField_a_of_type_Vld;
          if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo() == null) {}
          for (localObject1 = new ExtraTypeInfo();; localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo())
          {
            ((vld)localObject2).a((ExtraTypeInfo)localObject1);
            this.jdField_a_of_type_Vkb.a().a(null);
            this.jdField_a_of_type_Vkb.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, false);
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(false);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.b(false);
    }
  }
  
  private void o()
  {
    ThreadManager.getUIHandler().postDelayed(new QCircleContentPart.11(this), 500L);
  }
  
  public ReportExtraTypeInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
    }
    if ((this.jdField_a_of_type_Vkb != null) && (this.jdField_a_of_type_Vkb.a() != null))
    {
      RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_Vkb.a();
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = localViewHolder.getAdapterPosition();
    }
    return this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  }
  
  public QCircleTransitionLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  }
  
  public Object a(String paramString, Object paramObject)
  {
    if ("get_report_extra_type_info".equals(paramString)) {
      return a();
    }
    return super.a(paramString, paramObject);
  }
  
  public String a()
  {
    return "QCircleContentPart";
  }
  
  public void a()
  {
    a(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    ThreadManager.getUIHandler().post(new QCircleContentPart.10(this, paramFloat1, paramFloat2));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if ((paramView instanceof QCircleTransitionLayout))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout = ((QCircleTransitionLayout)paramView);
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout = ((QCircleTransitionInnerLayout)paramView.findViewById(2131366680));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout != null) && (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.getBackground() != null)) {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.getBackground().setAlpha(255);
      }
      if (!(a() instanceof PublicTransFragmentActivity)) {
        break label382;
      }
      if ((a() instanceof QCircleBaseFragment)) {
        a().b(false);
      }
      n();
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout, new vkt(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131373871));
      this.jdField_a_of_type_Vkb = ((vkb)a(vkb.class));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramView.findViewById(2131376854));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 1, false));
      bkse localbkse = new bkse();
      this.jdField_a_of_type_Vld = new vld(this, localbkse);
      this.jdField_a_of_type_Vld.a(a());
      this.jdField_a_of_type_Vld.a(a());
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(this.jdField_a_of_type_Vld);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new vkv(this));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370087));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366724));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369046));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369286));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131373125));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373893));
      b(paramView);
      localbkse.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      i();
      l();
      h();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      zwp.a().a(this);
      g();
      e();
      f();
      return;
      label382:
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a();
      if ((a() instanceof QCircleBaseFragment)) {
        a().b(true);
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Vld != null) && (this.jdField_a_of_type_Vld.a())) {
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    a(0);
  }
  
  public void c()
  {
    a(1);
  }
  
  public void d()
  {
    a(1);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleContentImmersiveEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(null);
    }
    if (this.jdField_a_of_type_Vjm != null) {
      this.jdField_a_of_type_Vjm.a();
    }
    zwp.a().b(this);
    if (this.jdField_a_of_type_Vkb != null) {
      this.jdField_a_of_type_Vkb.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if ((this.jdField_a_of_type_Vkb != null) && ((this.jdField_a_of_type_Vkb.a() instanceof vjt)))
    {
      paramActivity = ((vjt)this.jdField_a_of_type_Vkb.a()).a;
      if (!paramActivity.d())
      {
        paramActivity.c();
        paramActivity.setInterrupt(true);
      }
      String str = paramActivity.b();
      if (!TextUtils.isEmpty(str))
      {
        long l = paramActivity.a();
        zwp.a().a(new QCircleFeedVideoPositionLinkEvent(str, l));
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if ((this.jdField_a_of_type_Vkb != null) && ((this.jdField_a_of_type_Vkb.a() instanceof vjt)))
    {
      paramActivity = ((vjt)this.jdField_a_of_type_Vkb.a()).a;
      if (paramActivity.g()) {
        paramActivity.d();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
    while ((!(paramSimpleBaseEvent instanceof QCircleContentImmersiveEvent)) || (this.jdField_a_of_type_Vjm == null)) {
      return;
    }
    this.jdField_a_of_type_Vjm.a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vks
 * JD-Core Version:    0.7.0.1
 */