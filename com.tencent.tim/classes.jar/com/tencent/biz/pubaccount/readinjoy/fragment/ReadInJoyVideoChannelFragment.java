package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import kfs;
import kfv;
import klg;
import kng;
import kxm;
import lal;
import lbz;
import lcc;
import lfa;
import mye;
import mzj;
import wja;

public class ReadInJoyVideoChannelFragment
  extends ReadInJoyBaseFragment
{
  protected kfs a;
  private boolean ajI = true;
  private boolean ajP;
  private klg b;
  private boolean eF;
  private int from = -1;
  private boolean hasInit;
  private ViewGroup mContainer;
  protected long tY;
  private long tZ;
  private long ua;
  
  private void aJ(Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        if (!this.hasInit)
        {
          kfs localkfs = this.jdField_a_of_type_Kfs;
          if (localkfs == null) {}
        }
        else
        {
          return;
        }
        this.jdField_a_of_type_Kfs = ((kfs)kxm.dy.remove(Integer.valueOf(56)));
        if (this.jdField_a_of_type_Kfs == null)
        {
          this.jdField_a_of_type_Kfs = new kfs(paramActivity);
          this.jdField_a_of_type_Kfs.oD(56);
          this.jdField_a_of_type_Kfs.setChannelType(3);
          this.jdField_a_of_type_Kfs.setFrom(this.from);
          this.jdField_a_of_type_Kfs.i(this.mContainer);
          aLB();
          this.jdField_a_of_type_Kfs.onCreate();
        }
        this.jdField_a_of_type_Kfs.setFrom(this.from);
        this.jdField_a_of_type_Kfs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$a, this.mChannelCoverId);
        paramActivity = (ViewGroup)this.jdField_a_of_type_Kfs.af();
        if (this.from == 1002)
        {
          int j = wja.dp2px(44.5F, getResources());
          i = j;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            i = j + ImmersiveUtils.getStatusBarHeight(getActivity());
          }
          paramActivity.setPadding(0, i, 0, 0);
          this.hasInit = true;
          continue;
        }
        if (this.from != 1003) {
          continue;
        }
      }
      finally {}
      int i = ox();
      if (i > 0) {
        paramActivity.setPadding(0, i, 0, 0);
      }
    }
  }
  
  private void aLA()
  {
    this.jdField_b_of_type_Klg = new klg(getActivity());
    this.jdField_b_of_type_Klg.a(new lfa(this));
  }
  
  private void aLB()
  {
    if ((this.ajP) && (this.jdField_a_of_type_Kfs != null))
    {
      this.jdField_a_of_type_Kfs.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", Long.valueOf(this.tZ));
      this.jdField_a_of_type_Kfs.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", Long.valueOf(this.ua));
      this.jdField_a_of_type_Kfs.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", this.eF);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "doRefreshAndForceInsert()：set intent args finish : " + this.jdField_a_of_type_Kfs.getActivity().getIntent().getExtras().toString());
      }
      this.ajP = false;
    }
  }
  
  private void aLC()
  {
    this.tZ = 0L;
    this.ua = 0L;
    if ((this.jdField_a_of_type_Kfs != null) && (this.jdField_a_of_type_Kfs.getActivity() != null))
    {
      this.jdField_a_of_type_Kfs.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Kfs.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Kfs.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    }
  }
  
  private void ma(boolean paramBoolean)
  {
    if ((this.tY != 0L) && (this.jdField_a_of_type_Kfs != null) && (this.jdField_a_of_type_Kfs.a() != null) && (this.jdField_a_of_type_Kfs.ao() != null) && (this.jdField_a_of_type_Kfs.ao().size() > 0)) {
      kxm.a(56, (System.currentTimeMillis() - this.tY) / 1000L, this.jdField_a_of_type_Kfs.a().c(), (BaseArticleInfo)this.jdField_a_of_type_Kfs.ao().get(0), paramBoolean);
    }
  }
  
  public boolean BT()
  {
    ma(true);
    finish();
    return true;
  }
  
  public mye a()
  {
    if (this.jdField_a_of_type_Kfs != null) {
      return this.jdField_a_of_type_Kfs.a();
    }
    return null;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("notifyShowSelf()：isFirstCreate=").append(paramBoolean).append(", ");
      if (paramBundle == null)
      {
        str = " null";
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      }
    }
    else
    {
      if ((this.mContainer != null) && (!this.hasInit)) {
        aJ(paramActivity);
      }
      this.tY = System.currentTimeMillis();
      this.ajy = true;
      if (this.jdField_a_of_type_Kfs != null) {
        this.jdField_a_of_type_Kfs.aCl();
      }
      if (paramBundle != null)
      {
        this.tZ = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID");
        this.ua = paramBundle.getLong("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ");
        this.eF = paramBoolean;
        if (this.tZ != 0L)
        {
          this.ajP = true;
          aLB();
        }
      }
      if ((awit.aMG()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity))) {
        break label339;
      }
      paramBundle = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramBundle.qD();
      if (i == 1) {
        paramBundle.tG(i);
      }
      label194:
      if (this.jdField_a_of_type_Kfs != null) {
        this.jdField_a_of_type_Kfs.onResume();
      }
      if (((!awit.aMG()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity))) && (!this.eF) && (this.tZ > 0L) && (this.jdField_a_of_type_Kfs != null)) {
        this.jdField_a_of_type_Kfs.refreshList();
      }
      if ((!awit.aMH()) || (!this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.BB()) || (this.jdField_a_of_type_Kfs == null) || (this.from != 1001)) {
        break label350;
      }
      this.jdField_a_of_type_Kfs.lP(true);
      lcc.a().h(3, null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): hasRed refresh ");
      }
    }
    label339:
    label350:
    while ((!awit.aMH()) || (this.jdField_a_of_type_Kfs == null) || (!(getActivity() instanceof SplashActivity)))
    {
      if (this.jdField_b_of_type_Klg != null) {
        this.jdField_b_of_type_Klg.startWatch();
      }
      return;
      str = paramBundle.toString();
      break;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.ql(1);
      break label194;
    }
    long l = System.currentTimeMillis() - awit.a(this.mApp, getActivity());
    if ((l >= 900000L) && (!this.ajI)) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "videochannel tab auto refresh ! duration : " + l);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Kfs.lP(true);
        lcc.a().h(3, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyShowSelf(): isLastExitOver15Min : " + paramBoolean);
      break;
      this.ajI = false;
    }
  }
  
  public void aCc()
  {
    super.aCc();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyHideSelf()");
    }
    this.ajy = false;
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.aCc();
    }
    aLC();
    ma(false);
    this.tY = 0L;
    if ((awit.aMH()) && ((getActivity() instanceof SplashActivity))) {
      awit.a(this.mApp, System.currentTimeMillis(), getActivity());
    }
    mzj.a().z(false, "videoFeeds tab hiseSelf");
    if (this.jdField_b_of_type_Klg != null) {
      this.jdField_b_of_type_Klg.stopWatch();
    }
  }
  
  public void aCe()
  {
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.aCe();
    }
  }
  
  public void aIp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTitleClick()");
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.lP(true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyVideoChannelFragment.1(this));
  }
  
  public void aIq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyClickSelf()");
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.lP(true);
    }
  }
  
  public void aKD()
  {
    super.aKD();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "notifyTabDoubleClick()");
    }
  }
  
  public void aw(Bundle paramBundle)
  {
    super.aw(paramBundle);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onFragmentNewIntent():");
      if (paramBundle != null) {
        break label71;
      }
    }
    label71:
    for (String str = " null";; str = paramBundle.toString())
    {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, str);
      if ((paramBundle != null) && (paramBundle.getBoolean("key_need_refresh_channel_cover_list", false))) {
        lbz.a().qo(56);
      }
      return;
    }
  }
  
  public void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onSuperActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.i(paramInt1, paramInt2, paramIntent);
  }
  
  public int nh()
  {
    return 56;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityCreated()");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onAttach()");
    }
    try
    {
      kng.aEO();
      aLA();
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "preRequestPatchAd error:" + paramActivity.getMessage());
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    ma(false);
    finish();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreate()");
    }
    if (!this.ajz) {
      mzj.a().aO(getActivity());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onCreateView()");
    }
    this.mContainer = new FrameLayout(paramLayoutInflater.getContext());
    if ((!getUserVisibleHint()) && (kxm.AR())) {}
    for (;;)
    {
      VideoReport.setPageId(this.mContainer, "8014");
      VideoReport.setPageParams(this.mContainer, new lal().a(56L).a());
      paramLayoutInflater = this.mContainer;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      aJ(getActivity());
    }
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroy()");
      }
      if (this.jdField_a_of_type_Kfs != null) {
        this.jdField_a_of_type_Kfs.onDestroy();
      }
      aLC();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDestroyView()");
    }
    if (!this.ajz) {
      mzj.a().aP(getActivity());
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onDetach()");
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.aBZ();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onPause()");
    }
    if ((this.ajy) && (this.jdField_a_of_type_Kfs != null)) {
      this.jdField_a_of_type_Kfs.onPause();
    }
    if (this.jdField_b_of_type_Klg != null) {
      this.jdField_b_of_type_Klg.stopWatch();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onResume()");
    }
    if ((this.ajy) && (this.jdField_a_of_type_Kfs != null))
    {
      this.jdField_a_of_type_Kfs.onResume();
      mzj.a().aUI();
    }
    if ((this.jdField_b_of_type_Klg != null) && (!this.jdField_b_of_type_Klg.zK())) {
      this.jdField_b_of_type_Klg.startWatch();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStart()");
    }
    awit.b(getActivity().getAppRuntime());
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoChannelFragment", 2, "onStop()");
    }
    if (this.jdField_a_of_type_Kfs != null) {
      this.jdField_a_of_type_Kfs.onStop();
    }
    mzj.a().z(false, "videoChannelFragment tab onStop");
  }
  
  public void qQ(int paramInt)
  {
    this.from = paramInt;
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    if (this.jdField_a_of_type_Kfs != null)
    {
      this.jdField_a_of_type_Kfs.lP(true);
      return;
    }
    kfv.oK(nh());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment
 * JD-Core Version:    0.7.0.1
 */