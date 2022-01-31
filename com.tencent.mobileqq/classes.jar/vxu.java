import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
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
import java.io.File;

public abstract class vxu
  extends wci
{
  private static long jdField_a_of_type_Long;
  protected static final String a;
  protected CertifiedAccountMeta.StFeed a;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  protected CommentBottomBar a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private CertifiedAccountMeta.StShare jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = vxu.class.getSimpleName();
  }
  
  public vxu(Bundle paramBundle)
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
      if (vvz.a(paramStFeed.status.get())) {
        return false;
      }
    } while (!vvz.a(paramStFeed.poster.attr.get()));
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(a().getActivity());
    Object localObject = new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(50.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    b();
    if ((a() instanceof SubscribeBaseFragment)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(new vxv(this));
    }
    localObject = new ViewStub(a().getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    ((ViewStub)localObject).setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject);
    }
    a((View)localObject);
    a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    a().setPadding(0, 0, 0, ImmersiveUtils.a(50.0F));
  }
  
  public static boolean c()
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
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  protected View a()
  {
    return null;
  }
  
  public vxn a(int paramInt)
  {
    boolean bool = true;
    vxn localvxn = new vxn();
    localvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localvxn.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if (paramInt == 1) {}
    for (;;)
    {
      localvxn.jdField_a_of_type_Boolean = bool;
      localvxn.jdField_a_of_type_Int = paramInt;
      return localvxn;
      bool = false;
    }
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
    b("share_key_subscribe_feeds_update", new wbv(paramStFeed));
    if ((a() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)a()).b(paramStFeed);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    }
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(paramBundle.getByteArray("bundle_key_subscribe_feed_bytes_array")));
      b("share_key_subscribe_feeds_update", new wbv(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed));
      c();
      paramBundle = vvz.a() + File.separator + a(a()) + ".png";
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = a().a();
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b(paramBundle);
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
  
  protected void a(View paramView)
  {
    b(paramView);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(a().getActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new vxw(this));
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
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
      return true;
    }
    return super.b();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vxu
 * JD-Core Version:    0.7.0.1
 */