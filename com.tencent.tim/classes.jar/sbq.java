import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Stack;

public class sbq
  extends sat
  implements sgl
{
  public static final int bwm = ImmersiveUtils.getScreenHeight() * 2 / 3;
  private long CL;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeVideoHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private boolean aKT;
  private boolean aKU;
  private int bvR;
  private int bwj = this.mScreenWidth * 9 / 16;
  private int bwk;
  private int bwl;
  private ViewGroup cE;
  private Stack<CertifiedAccountMeta.StFeed> e;
  private ImageView iG;
  private ImageView iH;
  private auwc mGestureDetector;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private RelativeLayout mRightContainer;
  private int mScreenWidth = ImmersiveUtils.getScreenWidth();
  private int mTouchSlop;
  private int mVideoHeight;
  private int mVideoWidth;
  private ImageView nS;
  private View pH;
  private View pI;
  
  public sbq(Bundle paramBundle)
  {
    super(paramBundle);
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowFloatEntrance", "1")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aKT = bool;
      return;
    }
  }
  
  private boolean Q(MotionEvent paramMotionEvent)
  {
    if (this.mVideoHeight < this.mVideoWidth) {
      return false;
    }
    int[] arrayOfInt;
    if ((getParentRecyclerView() != null) && ((getParentRecyclerView().getLayoutManager() instanceof StaggeredGridLayoutManager)))
    {
      arrayOfInt = new int[getParentRecyclerView().getLayoutManager().getColumnCountForAccessibility(null, null)];
      ((StaggeredGridLayoutManager)getParentRecyclerView().getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    }
    for (int i = arrayOfInt[0];; i = 0)
    {
      int j = paramMotionEvent.getAction();
      int k = paramMotionEvent.getActionIndex();
      switch (j)
      {
      case 1: 
      default: 
        return false;
      case 0: 
        this.mInitialTouchX = ((int)(paramMotionEvent.getX() + 0.5F));
        this.mInitialTouchY = ((int)(paramMotionEvent.getY() + 0.5F));
        this.bvR = MotionEventCompat.findPointerIndex(paramMotionEvent, k);
        return false;
      }
      k = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      k -= this.mInitialTouchX;
      j = (int)((j - this.mInitialTouchY) * 0.6F);
      if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) >= Math.abs(j))) {
        break;
      }
      float f = paramMotionEvent.getY() - this.mInitialTouchY;
      if ((f < 0.0F) && (this.bwl > this.bwj)) {
        return true;
      }
      if ((f <= 0.0F) || (this.bwl >= this.bwk) || (i != 0)) {
        break;
      }
      return true;
    }
  }
  
  private void aAz()
  {
    this.nS.setOnClickListener(new sbr(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setPreviewVideoClickListener(new sbs(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNextVideoClickListener(new sbt(this));
    if (a() != null) {
      a().a(new sbu(this));
    }
    getParentRecyclerView().addOnItemTouchListener(new sbv(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setOnTouchListener(new sbw(this));
  }
  
  private float aC()
  {
    return this.mVideoHeight / this.mVideoWidth;
  }
  
  private void bxP()
  {
    bxQ();
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.l(new int[] { this.mScreenWidth, this.bwk });
      if (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.isFullScreen())
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.getLayoutParams().height = this.bwk;
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.requestLayout();
      }
    }
  }
  
  private void bxQ()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    this.mVideoWidth = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.width.get();
    this.mVideoHeight = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.height.get();
    QLog.i(TAG, 1, "resetVideoHW width:" + this.mVideoWidth + ", height:" + this.mVideoHeight);
    if (this.mVideoWidth <= 0)
    {
      this.mVideoWidth = 1920;
      this.mVideoHeight = 1080;
    }
    int j = (int)(this.mScreenWidth * aC());
    int i = j;
    if (j > bwm) {
      i = bwm;
    }
    this.bwk = i;
    this.bwl = this.bwk;
  }
  
  private CertifiedAccountMeta.StFeed d()
  {
    if ((this.e == null) || (this.e.empty())) {}
    do
    {
      return null;
      this.e.pop();
    } while (this.e.empty());
    return (CertifiedAccountMeta.StFeed)this.e.pop();
  }
  
  private void eb(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)paramView.findViewById(2131382095));
    this.pH = paramView.findViewById(2131370682);
    this.pI = this.pH.findViewById(2131370299);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setWifiAutoPlay(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNeedWifiTips(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setHostFragment((SubscribeVideoDetailFragment)getParentFragment());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.ee(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.uJ(false);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.ef(this.mRightContainer);
    this.mGestureDetector = new auwc(getActivity(), new sbq.a(null));
    this.mTouchSlop = ViewConfiguration.get(getActivity()).getScaledTouchSlop();
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get());
      if ((!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.fileId.get().equals("")) || (!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.playUrl.get().equals(""))) {
        j(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(getExtraTypeInfo());
  }
  
  private void j(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (aqmr.isEmpty(paramStFeed.video.fileId.get())) {
      QLog.w(TAG, 1, "video fileId is empty");
    }
    do
    {
      return;
      if (aqmr.isEmpty(paramStFeed.video.playUrl.get()))
      {
        QLog.w(TAG, 1, "video playUrl is empty");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null);
    this.aKU = true;
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(paramStFeed.cover.url.get());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoFeeds(paramStFeed);
  }
  
  private void k(CertifiedAccountMeta.StFeed paramStFeed)
  {
    boolean bool = true;
    if (this.e == null) {
      this.e = new Stack();
    }
    this.e.push(paramStFeed);
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (this.e.size() <= 1) {
        break label58;
      }
    }
    for (;;)
    {
      paramStFeed.uJ(bool);
      return;
      label58:
      bool = false;
    }
  }
  
  public void D(ViewGroup paramViewGroup)
  {
    this.cE = paramViewGroup;
  }
  
  protected void G(long paramLong, String paramString)
  {
    super.G(paramLong, paramString);
    if (this.nS != null) {
      this.nS.setVisibility(8);
    }
    if (this.iH != null) {
      this.iH.setVisibility(8);
    }
    if (this.pH != null)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.stop();
      }
      this.pH.setVisibility(8);
    }
  }
  
  public boolean Mw()
  {
    return (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.MK());
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView = new RelativeVideoHeadItemView(getActivity());
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  }
  
  public sbf a()
  {
    return (sbf)getBlockMerger().a("RELATIVE_ADAPTER_UNIQUE_KEY");
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    paramStGetFeedDetailRsp = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (paramStGetFeedDetailRsp != null) && (rzd.fe(paramStGetFeedDetailRsp.type.get())))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView.setData(paramStGetFeedDetailRsp);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setData(paramStGetFeedDetailRsp);
      }
      if ((this.nS != null) && (Build.VERSION.SDK_INT > 20) && (this.aKT)) {
        this.nS.setVisibility(0);
      }
      if (this.iH != null) {
        this.iH.setVisibility(0);
      }
      if (this.aKU) {
        break label143;
      }
      j(paramStGetFeedDetailRsp);
    }
    for (;;)
    {
      if (this.pH.getVisibility() == 8) {
        this.pH.setVisibility(0);
      }
      return;
      label143:
      QLog.i(TAG, 1, "has init played");
    }
  }
  
  protected View aC()
  {
    return this.pI;
  }
  
  public View aD()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.isFullScreen())) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(8);
    }
  }
  
  public void bjg()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void bjh()
  {
    QLog.d(TAG, 1, "onTransAnimateInit disableLoading!");
    bxJ();
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void bji()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void bjj()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((paramStFeed == null) || (System.currentTimeMillis() - this.CL < 500L)) {}
    do
    {
      do
      {
        return;
      } while (paramStFeed == null);
      this.CL = System.currentTimeMillis();
      sqn.b(paramStFeed.poster.id.get(), "auth_" + siu.b(getExtraTypeInfo()), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      if (rzd.fe(paramStFeed.type.get())) {
        break;
      }
      rzd.a(getActivity(), paramStFeed);
    } while (getActivity() == null);
    getActivity().finish();
    return;
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.stop();
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    k(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    bxP();
    this.aKU = false;
    j(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.l(paramStFeed);
    setShareData("share_key_subscribe_feeds_update", new rxn.b(paramStFeed, true));
    getParentRecyclerView().scrollToPosition(0);
  }
  
  protected void ea(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramView.setLayoutParams(localLayoutParams);
    this.cE.addView(paramView, localLayoutParams);
  }
  
  public void handleShareDataChange(String paramString, rxn.b paramb)
  {
    if (("share_key_continue_feeds".equals(paramString)) && (paramb != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setContinueFeeds((List)paramb.by);
    }
  }
  
  public void loadData(rxt paramrxt) {}
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.onBackPressed())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramViewHolder, paramInt);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView.setData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.r(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.e != null) {
      this.e.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.release();
    }
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if ((!anlm.ayn()) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(new ColorDrawable(-16777216));
    }
    if (this.e == null)
    {
      this.e = new Stack();
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
        this.e.push(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = ((SubscribeFollowInfoView)this.cE.findViewById(2131370629));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setHostActivity(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(getExtraTypeInfo());
    this.iG = ((ImageView)this.cE.findViewById(2131369672));
    this.mRightContainer = ((RelativeLayout)this.cE.findViewById(2131369883));
    this.iH = ((ImageView)this.cE.findViewById(2131369935));
    this.nS = ((ImageView)this.cE.findViewById(2131369734));
    if (getActivity() != null)
    {
      ayxa.initLiuHaiProperty(getActivity());
      ayxa.enableNotch(getActivity());
    }
    if ((Build.VERSION.SDK_INT <= 20) || (!this.aKT)) {
      this.nS.setVisibility(8);
    }
    eb(this.cE);
    bxP();
    aAz();
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f1 = paramMotionEvent2.getY() - sbq.a(sbq.this);
      if (sbq.b(sbq.this) < sbq.c(sbq.this)) {
        return false;
      }
      if ((f1 > 0.0F) && (sbq.d(sbq.this) < sbq.e(sbq.this)))
      {
        f2 = sbq.d(sbq.this);
        f1 = Math.abs(f1) + f2;
        localsbq = sbq.this;
        if (f1 > sbq.e(sbq.this))
        {
          i = sbq.e(sbq.this);
          sbq.b(localsbq, i);
        }
      }
      while ((f1 >= 0.0F) || (sbq.d(sbq.this) <= sbq.f(sbq.this))) {
        for (;;)
        {
          float f2;
          if (sbq.a(sbq.this) != null)
          {
            sbq.a(sbq.this).getLayoutParams().height = sbq.d(sbq.this);
            sbq.a(sbq.this).requestLayout();
          }
          return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          i = (int)f1;
        }
      }
      f1 = sbq.d(sbq.this) - Math.abs(f1);
      sbq localsbq = sbq.this;
      if (f1 < sbq.f(sbq.this)) {}
      for (int i = sbq.f(sbq.this);; i = (int)f1)
      {
        sbq.b(localsbq, i);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbq
 * JD-Core Version:    0.7.0.1
 */