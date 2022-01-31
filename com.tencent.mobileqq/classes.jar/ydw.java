import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.DetailBaseAdapter.6;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.HashMap;

public abstract class ydw
  extends yiu
  implements ygo, yho
{
  private static long jdField_a_of_type_Long;
  public static final String a;
  protected CertifiedAccountMeta.StFeed a;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private View jdField_a_of_type_AndroidViewView;
  public PopupWindow a;
  private PopViewAnimationDrawableHelper jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper;
  protected ExtraTypeInfo a;
  public CommentBottomBar a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  protected ylt a;
  private boolean jdField_a_of_type_Boolean;
  private CertifiedAccountMeta.StShare jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ydw.class.getSimpleName();
  }
  
  public ydw(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private String a(ExtraTypeInfo paramExtraTypeInfo)
  {
    if (paramExtraTypeInfo != null) {}
    switch (paramExtraTypeInfo.pageType)
    {
    case 7001: 
    default: 
      return "certified_account_preload_pic";
    case 7000: 
      return "certified_account_preload_video";
    }
    return "certified_account_personal_preload_loading";
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(getParentFragment().getActivity());
    Object localObject = new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(50.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    f();
    if ((getParentFragment() instanceof SubscribeBaseFragment)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(new ydx(this));
    }
    localObject = new ViewStub(getParentFragment().getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localLayoutParams.setMargins(0, -ImmersiveUtils.a(50.0F), 0, 0);
    ((ViewStub)localObject).setLayoutParams(localLayoutParams);
    ((ViewStub)localObject).setFitsSystemWindows(true);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject);
    }
    a((View)localObject);
    a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    getParentRecyclerView().setPadding(0, 0, 0, ImmersiveUtils.a(50.0F));
  }
  
  public static boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "click too fast");
      }
      jdField_a_of_type_Long = l;
      return true;
    }
    jdField_a_of_type_Long = l;
    return false;
  }
  
  private boolean a(long paramLong, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramLong != 0L) {}
    do
    {
      do
      {
        return true;
      } while ((paramStFeed == null) || (this.mIsDestroyed));
      if (ybu.a(paramStFeed.status.get())) {
        return false;
      }
    } while (!ybu.a(paramStFeed.poster.attr.get()));
    return false;
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  protected View a()
  {
    return null;
  }
  
  public ydo a(int paramInt)
  {
    boolean bool = true;
    ydo localydo = new ydo();
    localydo.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localydo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localydo.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if (paramInt == 1) {}
    for (;;)
    {
      localydo.jdField_a_of_type_Boolean = bool;
      localydo.jdField_a_of_type_Int = paramInt;
      return localydo;
      bool = false;
    }
  }
  
  public ylt a()
  {
    return this.jdField_a_of_type_Ylt;
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((a() != null) && (a().getVisibility() == 0)) {
      a().setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null)
    {
      String str;
      if ((paramString == null) || (paramString.trim().length() != 0))
      {
        str = paramString;
        if (!VSNetworkHelper.a(paramString)) {}
      }
      else
      {
        str = null;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(str);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setCurrentFeed(paramStFeed);
    }
    setShareData("share_key_subscribe_feeds_update", new yif(paramStFeed));
    if ((getParentFragment() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)getParentFragment()).b(paramStFeed);
    }
    if (this.jdField_a_of_type_Ylt != null) {
      this.jdField_a_of_type_Ylt.a(paramStFeed.poster);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean) {}
  
  public void a(DialogInterface paramDialogInterface) {}
  
  protected void a(View paramView)
  {
    addFloatView(paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.d = paramBoolean;
  }
  
  public void a(SystemBarCompact paramSystemBarCompact)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = paramSystemBarCompact;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.c();
    }
    if ((a() != null) && (a().getVisibility() == 0)) {
      a().setVisibility(8);
    }
    View localView;
    if ((a() != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
    {
      localView = a();
      if (paramStFeed.status.get() != 3) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.getVisibility() == 8)) {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(0);
      }
      return;
    }
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "is not own startCount");
    if ((!ybu.a(paramStFeed.poster.attr.get())) && (getActivity() != null))
    {
      ymo.a().a(getActivity(), "subscribe_freshman_interaction_guide", 5000, new yed(this, paramStFeed));
      getActivity().runOnUiThread(new DetailBaseAdapter.6(this));
      ymo.a().a(getActivity(), "subscribe_freshman_share_guide", 10000, new yee(this));
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(getParentFragment().getActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new ydy(this), this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    } while (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() == null);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.f();
    }
  }
  
  public void h()
  {
    yld.a().a((String)ybn.b.get("follow_guide_pics"), 4000, new ydz(this), true);
  }
  
  public void i()
  {
    yld.a().a((String)ybn.b.get("praise_guide_pics"), 4000, new yeb(this), true);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper.b();
    }
  }
  
  public void k() {}
  
  public void l()
  {
    if (this.jdField_b_of_type_Boolean) {
      i();
    }
    if (this.c) {
      h();
    }
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_Boolean) {
      i();
    }
    if (this.c) {
      h();
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.b())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.c();
    }
  }
  
  public void onPrepareParams(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    }
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(paramBundle.getByteArray("bundle_key_subscribe_feed_bytes_array")));
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)paramBundle.getSerializable("bundle_key_feed_extra_type_info"));
      setShareData("share_key_subscribe_feeds_update", new yif(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = getComponentPageView().a();
        paramBundle = ybu.a() + File.separator + a(getExtraTypeInfo()) + ".png";
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.e(paramBundle);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "showLoadingView!");
      }
      a();
      this.jdField_a_of_type_Ylt = new ylt(getActivity());
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydw
 * JD-Core Version:    0.7.0.1
 */