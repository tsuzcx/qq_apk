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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Stack;

public class wlu
  extends wku
  implements wrz
{
  public static final int a;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bfyi jdField_a_of_type_Bfyi;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeVideoHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private Stack<CertifiedAccountMeta.StFeed> jdField_a_of_type_JavaUtilStack;
  private int jdField_b_of_type_Int = ImmersiveUtils.a();
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int = this.jdField_b_of_type_Int * 9 / 16;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_Int = ImmersiveUtils.b() * 2 / 3;
  }
  
  public wlu(Bundle paramBundle)
  {
    super(paramBundle);
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowFloatEntrance", "1")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  private float a()
  {
    return this.e / this.jdField_d_of_type_Int;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.e < this.jdField_d_of_type_Int) {
      return false;
    }
    int[] arrayOfInt;
    if ((a() != null) && ((a().getLayoutManager() instanceof StaggeredGridLayoutManager)))
    {
      arrayOfInt = new int[a().getLayoutManager().getColumnCountForAccessibility(null, null)];
      ((StaggeredGridLayoutManager)a().getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    }
    for (int m = arrayOfInt[0];; m = 0)
    {
      int n = paramMotionEvent.getAction();
      int i1 = paramMotionEvent.getActionIndex();
      switch (n)
      {
      case 1: 
      default: 
        return false;
      case 0: 
        this.j = ((int)(paramMotionEvent.getX() + 0.5F));
        this.i = ((int)(paramMotionEvent.getY() + 0.5F));
        this.k = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
        return false;
      }
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      n = (int)(paramMotionEvent.getY() + 0.5F);
      i1 -= this.j;
      n = (int)((n - this.i) * 0.6F);
      if ((Math.abs(i1) > this.h) && (Math.abs(i1) >= Math.abs(n))) {
        break;
      }
      float f1 = paramMotionEvent.getY() - this.i;
      if ((f1 < 0.0F) && (this.g > this.jdField_c_of_type_Int)) {
        return true;
      }
      if ((f1 <= 0.0F) || (this.g >= this.f) || (m != 0)) {
        break;
      }
      return true;
    }
  }
  
  private CertifiedAccountMeta.StFeed b()
  {
    if ((this.jdField_a_of_type_JavaUtilStack == null) || (this.jdField_a_of_type_JavaUtilStack.empty())) {}
    do
    {
      return null;
      this.jdField_a_of_type_JavaUtilStack.pop();
    } while (this.jdField_a_of_type_JavaUtilStack.empty());
    return (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_JavaUtilStack.pop();
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)paramView.findViewById(2131379346));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369401);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369049);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setWifiAutoPlay(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNeedWifiTips(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setHostFragment((SubscribeVideoDetailFragment)a());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(false);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Bfyi = new bfyi(a(), new wmb(this, null));
    this.h = ViewConfiguration.get(a()).getScaledTouchSlop();
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get());
      if ((!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.fileId.get().equals("")) || (!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.playUrl.get().equals(""))) {
        e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(a());
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (bbkk.a(paramStFeed.video.fileId.get())) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "video fileId is empty");
    }
    do
    {
      return;
      if (bbkk.a(paramStFeed.video.playUrl.get()))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video playUrl is empty");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(paramStFeed.cover.url.get());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoFeeds(paramStFeed);
  }
  
  private void f(CertifiedAccountMeta.StFeed paramStFeed)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilStack == null) {
      this.jdField_a_of_type_JavaUtilStack = new Stack();
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramStFeed);
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (this.jdField_a_of_type_JavaUtilStack.size() <= 1) {
        break label58;
      }
    }
    for (;;)
    {
      paramStFeed.a(bool);
      return;
      label58:
      bool = false;
    }
  }
  
  private void q()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new wlv(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setPreviewVideoClickListener(new wlw(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNextVideoClickListener(new wlx(this));
    if (a() != null) {
      a().a(new wly(this));
    }
    a().addOnItemTouchListener(new wlz(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setOnTouchListener(new wma(this));
  }
  
  private void r()
  {
    s();
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(new int[] { this.jdField_b_of_type_Int, this.f });
      if (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f())
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.getLayoutParams().height = this.f;
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.requestLayout();
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.width.get();
    this.e = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.height.get();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "resetVideoHW width:" + this.jdField_d_of_type_Int + ", height:" + this.e);
    if (this.jdField_d_of_type_Int <= 0)
    {
      this.jdField_d_of_type_Int = 1920;
      this.e = 1080;
    }
    int n = (int)(this.jdField_b_of_type_Int * a());
    int m = n;
    if (n > jdField_a_of_type_Int) {
      m = jdField_a_of_type_Int;
    }
    this.f = m;
    this.g = this.f;
  }
  
  protected View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, woz paramwoz)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView = new RelativeVideoHeadItemView(a());
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  }
  
  public wlg a()
  {
    return (wlg)a().a("RELATIVE_ADAPTER_UNIQUE_KEY");
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.e();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    paramStGetFeedDetailRsp = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (wis.a(paramStGetFeedDetailRsp.type.get())))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView.setData(paramStGetFeedDetailRsp);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setData(paramStGetFeedDetailRsp);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (Build.VERSION.SDK_INT > 20) && (this.jdField_c_of_type_Boolean)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_d_of_type_Boolean) {
        break label139;
      }
      e(paramStGetFeedDetailRsp);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      label139:
      QLog.i(jdField_a_of_type_JavaLangString, 1, "has init played");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)a()).mSystemBarComp;
    if ((!axmv.b()) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(new ColorDrawable(-16777216));
    }
    if (this.jdField_a_of_type_JavaUtilStack == null)
    {
      this.jdField_a_of_type_JavaUtilStack = new Stack();
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
        this.jdField_a_of_type_JavaUtilStack.push(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = ((SubscribeFollowInfoView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369355));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setHostActivity(a());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(a());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368508));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368678));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368716));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368561));
    if (a() != null)
    {
      bkvi.a(a());
      bkvi.c(a());
    }
    if ((Build.VERSION.SDK_INT <= 20) || (!this.jdField_c_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    c(this.jdField_a_of_type_AndroidViewViewGroup);
    r();
    q();
  }
  
  protected void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, localLayoutParams);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(String paramString, wpf paramwpf)
  {
    if (("share_key_continue_feeds".equals(paramString)) && (paramwpf != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setContinueFeeds((List)paramwpf.a);
    }
  }
  
  public void a(wpk paramwpk) {}
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f())) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(8);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.e())) {
      return true;
    }
    return super.b();
  }
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      xhb.a(paramStFeed.poster.id.get(), "auth_" + wux.a(a()), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      if (wis.a(paramStFeed.type.get())) {
        break;
      }
      wis.a(a(), paramStFeed);
    } while (a() == null);
    a().finish();
    return;
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.e();
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    f(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    r();
    this.jdField_d_of_type_Boolean = false;
    e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
    b("share_key_subscribe_feeds_update", new wpf(paramStFeed, true));
    a().scrollToPosition(0);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b());
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void l()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onTransAnimateInit disableLoading!");
    b();
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramViewHolder, paramInt);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView.setData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_JavaUtilStack != null) {
      this.jdField_a_of_type_JavaUtilStack.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlu
 * JD-Core Version:    0.7.0.1
 */