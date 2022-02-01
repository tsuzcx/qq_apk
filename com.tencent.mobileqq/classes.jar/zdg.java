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
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.6;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.HashMap;

public abstract class zdg
  extends zaj
  implements zga, zha
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
  protected zjs a;
  private CertifiedAccountMeta.StShare jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private String jdField_b_of_type_JavaLangString;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = zdg.class.getSimpleName();
  }
  
  public zdg(Bundle paramBundle)
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
  
  private boolean a(long paramLong, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramLong != 0L) {}
    do
    {
      do
      {
        return true;
      } while ((paramStFeed == null) || (this.jdField_b_of_type_Boolean));
      if (zbi.a(paramStFeed.status.get())) {
        return false;
      }
    } while (!zbi.a(paramStFeed.poster.attr.get()));
    return false;
  }
  
  public static boolean e()
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
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(a().getActivity());
    Object localObject = new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(50.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    d();
    if ((a() instanceof SubscribeBaseFragment)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(new zdh(this));
    }
    localObject = new ViewStub(a().getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localLayoutParams.setMargins(0, -ImmersiveUtils.a(50.0F), 0, 0);
    ((ViewStub)localObject).setLayoutParams(localLayoutParams);
    ((ViewStub)localObject).setFitsSystemWindows(true);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject);
    }
    b((View)localObject);
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    a().setPadding(0, 0, 0, ImmersiveUtils.a(50.0F));
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  protected View a()
  {
    return null;
  }
  
  public zda a(int paramInt)
  {
    boolean bool = true;
    zda localzda = new zda();
    localzda.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localzda.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localzda.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if (paramInt == 1) {}
    for (;;)
    {
      localzda.jdField_a_of_type_Boolean = bool;
      localzda.jdField_a_of_type_Int = paramInt;
      return localzda;
      bool = false;
    }
  }
  
  public zjs a()
  {
    return this.jdField_a_of_type_Zjs;
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
        if (!VSNetworkHelper.isProtocolCache(paramString)) {}
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
    b("share_key_subscribe_feeds_update", new yzn(paramStFeed));
    if ((a() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)a()).b(paramStFeed);
    }
    if (this.jdField_a_of_type_Zjs != null) {
      this.jdField_a_of_type_Zjs.a(paramStFeed.poster);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean) {}
  
  public void a(DialogInterface paramDialogInterface) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    }
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(paramBundle.getByteArray("bundle_key_subscribe_feed_bytes_array")));
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)paramBundle.getSerializable("bundle_key_feed_extra_type_info"));
      b("share_key_subscribe_feeds_update", new yzn(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed));
      if (!this.c)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = a().a();
        paramBundle = zbi.a() + File.separator + a(a()) + ".png";
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b(paramBundle);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "showLoadingView!");
      }
      m();
      this.jdField_a_of_type_Zjs = new zjs(a());
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
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.f = paramBoolean;
  }
  
  public void a(SystemBarCompact paramSystemBarCompact)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = paramSystemBarCompact;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b();
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
  
  protected void b(View paramView)
  {
    a(paramView);
  }
  
  protected void c()
  {
    this.c = true;
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "is not own startCount");
    if ((!zbi.a(paramStFeed.poster.attr.get())) && (a() != null))
    {
      zkn.a().a(a(), "subscribe_freshman_interaction_guide", 5000, new zdn(this, paramStFeed));
      a().runOnUiThread(new DetailBaseBlock.6(this));
      zkn.a().a(a(), "subscribe_freshman_share_guide", 10000, new zdo(this));
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.b())) {
      return true;
    }
    return super.c();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(a().getActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new zdi(this), this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    } while (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() == null);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.c();
    }
  }
  
  public void g()
  {
    yyl.a().a((String)zbb.b.get("follow_guide_pics"), 4000, new zdj(this), true);
  }
  
  public void h()
  {
    yyl.a().a((String)zbb.b.get("praise_guide_pics"), 4000, new zdl(this), true);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper.b();
    }
  }
  
  public void j() {}
  
  public void k()
  {
    if (this.d) {
      h();
    }
    if (this.e) {
      g();
    }
  }
  
  public void l()
  {
    if (this.d) {
      h();
    }
    if (this.e) {
      g();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdg
 * JD-Core Version:    0.7.0.1
 */