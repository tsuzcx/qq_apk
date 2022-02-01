package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;
import sar;
import sbd;
import sbf;
import sel;
import sem;
import sge;
import shp;
import siu;
import sqn;

public class SubscribeMultiPicFragment
  extends SubscribeBaseFragment
{
  private long CM;
  private BlockContainer a;
  private boolean aLc;
  private sbd b;
  private LinearLayout fi;
  private View hU;
  private View pK;
  private View pL;
  private TextView zJ;
  
  private void bxk()
  {
    if ((this.b != null) && (this.b.b() != null) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.getExtraTypeInfo() != null)) {
      sqn.b(this.b.b().poster.id.get(), "auth_" + siu.b(this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.getExtraTypeInfo()), "read", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.CM), "", this.b.b().id.get() });
    }
  }
  
  private void initView()
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    localBundle.putSerializable("bundle_key_feed_extra_type_info", this.mExtraTypeInfo);
    this.b = new sbd(localBundle);
    this.b.b(getActivity().mSystemBarComp);
    if (this.jdField_a_of_type_Sge != null) {
      this.jdField_a_of_type_Sge.a(this.b);
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131365508));
    this.fi = ((LinearLayout)this.mContentView.findViewById(2131370681));
    this.pK = this.mContentView.findViewById(2131369672);
    this.hU = this.mContentView.findViewById(2131369896);
    this.zJ = ((TextView)this.mContentView.findViewById(2131369810));
    this.pL = this.mContentView.findViewById(2131370299);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.mExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.b);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new sar(localBundle));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new sbf(localBundle));
    this.pK.setOnClickListener(new sel(this));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.start();
    this.hU.setOnClickListener(new sem(this));
  }
  
  protected TextView D()
  {
    return this.zJ;
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    float f1 = 1.333333F;
    float f2 = paramInt2 / paramInt1;
    if (f2 > 1.333333F) {}
    for (;;)
    {
      paramInt1 = (int)(f1 * ImmersiveUtils.getScreenWidth());
      return new int[] { (int)(paramInt1 / f2), paramInt1 };
      f1 = f2;
    }
  }
  
  protected View aE()
  {
    return this.hU;
  }
  
  public View aF()
  {
    return this.pL;
  }
  
  public View aG()
  {
    return this.hU;
  }
  
  protected void dC(View paramView) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    hideTitleBar();
    initView();
  }
  
  public void fr(long paramLong)
  {
    this.CM = paramLong;
  }
  
  public int getContentLayoutId()
  {
    return 2131558846;
  }
  
  public LinearLayout i()
  {
    return this.fi;
  }
  
  public boolean isNeedMiniMsg()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return this.aLc;
  }
  
  protected void n(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.b != null) {
      this.b.a(paramStFeed);
    }
  }
  
  public void o(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.o(paramStFeed);
    ThreadManager.getSubThreadHandler().post(new SubscribeMultiPicFragment.3(this, paramStFeed));
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.onBackEvent())) {
      return true;
    }
    if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.sourceType == 9001))
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      MiniAppLauncher.startMiniApp(getActivity(), str, 2016, null, null);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.onDestroy();
    }
    shp.a().tg("subscribe_freshman_interaction_guide");
    shp.a().tg("subscribe_freshman_share_guide");
    if (this.b != null) {
      this.b.release();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bxk();
  }
  
  public void onResume()
  {
    super.onResume();
    this.CM = System.currentTimeMillis();
  }
  
  public int uj()
  {
    return ImmersiveUtils.dpToPx(50.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment
 * JD-Core Version:    0.7.0.1
 */