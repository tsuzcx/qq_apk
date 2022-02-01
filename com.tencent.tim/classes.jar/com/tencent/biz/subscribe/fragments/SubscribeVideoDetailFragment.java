package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import asfe;
import ayxa;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kxv;
import rxn.b;
import rxn.c;
import san;
import sar;
import sbf;
import sbq;
import sew;
import sex;
import sey;
import sez;
import sge;
import shp;
import siu;

public class SubscribeVideoDetailFragment
  extends SubscribeBaseFragment
  implements rxn.c
{
  private static int bwy;
  protected BlockContainer a;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private sbf jdField_a_of_type_Sbf;
  private boolean aLd;
  private sbq b;
  private ImageView iG;
  private ImageView iH;
  private View pM;
  private TextView zK;
  
  protected TextView D()
  {
    return this.zK;
  }
  
  public void a(san paramsan)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.isFullScreen())) {
      this.jdField_a_of_type_Siu.setIsFullScreen(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.isFullScreen());
    }
    super.a(paramsan);
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    paramInt2 = (int)(paramInt2 / paramInt1 * ImmersiveUtils.getScreenWidth());
    int i = ImmersiveUtils.getScreenWidth();
    paramInt1 = paramInt2;
    if (paramInt2 > sbq.bwm) {
      paramInt1 = sbq.bwm;
    }
    return new int[] { i, paramInt1 };
  }
  
  protected View aE()
  {
    return this.iH;
  }
  
  public void ah(boolean paramBoolean, int paramInt)
  {
    if ((ayxa.isLiuHaiUseValid()) && (getActivity() != null) && (this.pM != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.ML()))
      {
        ViewGroup.LayoutParams localLayoutParams = this.pM.getLayoutParams();
        localLayoutParams.height = paramInt;
        this.pM.setLayoutParams(localLayoutParams);
        this.pM.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.pM.setVisibility(8);
  }
  
  protected void dC(View paramView)
  {
    if (this.mContentView != null) {
      this.mContentView.setBackgroundColor(-16777216);
    }
    hideTitleBar();
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    paramView = new Bundle();
    paramView.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    paramView.putSerializable("bundle_key_feed_extra_type_info", this.mExtraTypeInfo);
    this.b = new sbq(paramView);
    this.b.D((ViewGroup)this.mContentView);
    if (this.jdField_a_of_type_Sge != null) {
      this.jdField_a_of_type_Sge.a(this.b);
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131377248));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.mExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.b);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new sar(paramView));
    this.jdField_a_of_type_Sbf = new sbf(paramView);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Sbf);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.start();
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)this.mContentView.findViewById(2131382095));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(this.mExtraTypeInfo);
    this.pM = this.mContentView.findViewById(2131372481);
    this.iG = ((ImageView)this.mContentView.findViewById(2131369672));
    this.iG.setBackgroundResource(2130851489);
    this.iH = ((ImageView)this.mContentView.findViewById(2131369935));
    this.iH.setBackgroundResource(2130851488);
    this.zK = ((TextView)this.mContentView.findViewById(2131369810));
    this.iH.setOnClickListener(new sew(this));
    this.iG.setOnClickListener(new sex(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setBaseVideoViewListenerSets(new sey(this));
  }
  
  public int getContentLayoutId()
  {
    return 2131558877;
  }
  
  public void handleShareDataChange(String paramString, rxn.b paramb)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramb != null) && (this.jdField_a_of_type_Siu != null) && ((paramb.by instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramb.by).type.get() == 3)) {
      kxv.a().a(((CertifiedAccountMeta.StFeed)paramb.by).video.playUrl.get(), new sez(this));
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
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
    asfe.getSubThreadHandler().post(new SubscribeVideoDetailFragment.5(this, paramStFeed));
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.onBackEvent())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ayxa.initLiuHaiProperty(getActivity());
    FloatingScreenManager.getInstance().quitFloatingScreen();
    bwy = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (this.b.Mw()) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)) {
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
    if ((!this.aLb) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.isPlaying()) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.MK()))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.pause();
        this.aLd = true;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.uK(true);
    }
    this.aLb = false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (bwy != hashCode()) {
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.replay();
        QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
      }
    }
    for (;;)
    {
      this.aLd = false;
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
      {
        if ((this.aLd) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.isPlaying())) {
          this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.resume();
        }
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.uK(false);
        QLog.d("SubscribeVideoDetailFragment", 4, "continue to play");
      }
    }
  }
  
  public void p(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (this.b == null)) {
      return;
    }
    this.b.e(paramStFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment
 * JD-Core Version:    0.7.0.1
 */