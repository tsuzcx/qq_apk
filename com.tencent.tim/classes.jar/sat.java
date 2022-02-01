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

public abstract class sat
  extends ryh
  implements scw.b, sdx
{
  public static final String TAG = sat.class.getSimpleName();
  private static long lastClickTime;
  protected CertifiedAccountMeta.StFeed a;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  public CommentBottomBar a;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  protected sgy a;
  private String aDG;
  private boolean aKN;
  private boolean aKO;
  private boolean aKP;
  private boolean aKQ;
  private CertifiedAccountMeta.StShare jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private PopViewAnimationDrawableHelper jdField_b_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper;
  private StatusView jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView;
  protected ExtraTypeInfo mExtraTypeInfo;
  public PopupWindow mPopupWindow;
  private View pF;
  
  public sat(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void Je()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(getParentFragment().getActivity());
    Object localObject = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(50.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    biW();
    if ((getParentFragment() instanceof SubscribeBaseFragment)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(new sau(this));
    }
    localObject = new ViewStub(getParentFragment().getActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localLayoutParams.setMargins(0, -ImmersiveUtils.dpToPx(50.0F), 0, 0);
    ((ViewStub)localObject).setLayoutParams(localLayoutParams);
    ((ViewStub)localObject).setFitsSystemWindows(true);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject);
    }
    ea((View)localObject);
    ea(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    getParentRecyclerView().setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0F));
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
      } while ((paramStFeed == null) || (this.mIsDestroyed));
      if (rze.fh(paramStFeed.status.get())) {
        return false;
      }
    } while (!rze.bg(paramStFeed.poster.attr.get()));
    return false;
  }
  
  public static boolean qH()
  {
    long l = System.currentTimeMillis();
    if (l - lastClickTime <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "click too fast");
      }
      lastClickTime = l;
      return true;
    }
    lastClickTime = l;
    return false;
  }
  
  protected void G(long paramLong, String paramString)
  {
    if ((aC() != null) && (aC().getVisibility() == 0)) {
      aC().setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView != null)
    {
      String str;
      if ((paramString == null) || (paramString.trim().length() != 0))
      {
        str = paramString;
        if (!VSNetworkHelper.fQ(paramString)) {}
      }
      else
      {
        str = null;
      }
      this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.qH(str);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(8);
    }
  }
  
  public san a(int paramInt)
  {
    boolean bool = true;
    san localsan = new san();
    localsan.mFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localsan.mUrl = this.aDG;
    localsan.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if (paramInt == 1) {}
    for (;;)
    {
      localsan.ayK = bool;
      localsan.shareFromType = paramInt;
      return localsan;
      bool = false;
    }
  }
  
  public sgy a()
  {
    return this.jdField_a_of_type_Sgy;
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setCurrentFeed(paramStFeed);
    }
    setShareData("share_key_subscribe_feeds_update", new rxn.b(paramStFeed));
    if ((getParentFragment() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)getParentFragment()).o(paramStFeed);
    }
    if (this.jdField_a_of_type_Sgy != null) {
      this.jdField_a_of_type_Sgy.a(paramStFeed.poster);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean) {}
  
  public void a(DialogInterface paramDialogInterface) {}
  
  protected View aC()
  {
    return null;
  }
  
  public CertifiedAccountMeta.StFeed b()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.bkV();
    }
    if ((aC() != null) && (aC().getVisibility() == 0)) {
      aC().setVisibility(8);
    }
    View localView;
    if ((aC() != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
    {
      localView = aC();
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
  
  public void b(SystemBarCompact paramSystemBarCompact)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = paramSystemBarCompact;
  }
  
  protected void biW()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(getParentFragment().getActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new sav(this), this.mExtraTypeInfo);
    } while (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() == null);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
  }
  
  protected void bxJ()
  {
    this.aKN = true;
  }
  
  public void bxK()
  {
    sgm.a().a((String)ryy.eQ.get("follow_guide_pics"), 4000, new saw(this), true);
  }
  
  public void bxL()
  {
    sgm.a().a((String)ryy.eQ.get("praise_guide_pics"), 4000, new say(this), true);
  }
  
  public void bxM()
  {
    if (this.aKO) {
      bxL();
    }
    if (this.aKP) {
      bxK();
    }
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    QLog.d(TAG, 2, "is not own startCount");
    if ((!rze.bg(paramStFeed.poster.attr.get())) && (getActivity() != null))
    {
      shp.a().a(getActivity(), "subscribe_freshman_interaction_guide", 5000, new sba(this, paramStFeed));
      getActivity().runOnUiThread(new DetailBaseBlock.6(this));
      shp.a().a(getActivity(), "subscribe_freshman_share_guide", 10000, new sbb(this));
    }
  }
  
  protected void ea(View paramView)
  {
    addFloatView(paramView);
  }
  
  protected void hideLoadingView()
  {
    if (this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.hideLoadingView();
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.onBackPressed())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.release();
    }
  }
  
  public void onDismiss()
  {
    if (this.aKO) {
      bxL();
    }
    if (this.aKP) {
      bxK();
    }
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    }
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(paramBundle.getByteArray("bundle_key_subscribe_feed_bytes_array")));
      this.mExtraTypeInfo = ((ExtraTypeInfo)paramBundle.getSerializable("bundle_key_feed_extra_type_info"));
      setShareData("share_key_subscribe_feeds_update", new rxn.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed));
      if (!this.aKN)
      {
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView = getBlockContainer().a();
        paramBundle = rze.no() + File.separator + a(getExtraTypeInfo()) + ".png";
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.qJ(paramBundle);
        QLog.d(TAG, 1, "showLoadingView!");
      }
      Je();
      this.jdField_a_of_type_Sgy = new sgy(getActivity());
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
  
  public void onShow() {}
  
  public void release()
  {
    if (this.jdField_b_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper != null) {
      this.jdField_b_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper.releaseHandler();
    }
  }
  
  public void u(View paramView, boolean paramBoolean)
  {
    this.pF = paramView;
    this.aKQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sat
 * JD-Core Version:    0.7.0.1
 */