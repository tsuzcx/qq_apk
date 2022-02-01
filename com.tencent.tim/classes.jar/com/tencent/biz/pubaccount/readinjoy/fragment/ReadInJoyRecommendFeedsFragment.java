package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import kfn;
import kfv;
import knj;
import kxm;
import lal;
import lbz;
import lcc;
import lcm;
import lcs;
import lct;
import lcu;
import lcv;
import lcw;
import lcx;
import lcy;
import lcz;
import lde;
import lgp;
import lhn;
import lwh;
import meu;
import mqq.app.Constants.LogoutReason;
import odv;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private kfn jdField_a_of_type_Kfn;
  private lcy jdField_a_of_type_Lcy;
  private boolean ajI = true;
  private boolean ajJ = true;
  boolean ajK = false;
  private lct b = new lct();
  boolean firstResume = true;
  private long tW;
  private long tX;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void aLc()
  {
    this.jdField_a_of_type_Lcy = new lcy(this.b, getActivity());
    this.b.a(new lcs[] { new lcw(this.b, getActivity()), new lcv(this.b, getActivity()), new lcx(this.b, this.mApp, getActivity()), this.jdField_a_of_type_Lcy, new lcu(this.b, this.mApp, getActivity()), new lde(this.b, getActivity()), new lcz(this.b, this.mApp, getActivity()) });
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.ajy = true;
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onResume();
    }
    if (this.ajI) {
      lwh.a().aNQ();
    }
    int i;
    if ((!this.ajK) && (getActivity() != null))
    {
      i = getActivity().getIntent().getIntExtra("redpack_type", 1);
      int j = getActivity().getIntent().getIntExtra("plat_source", 1);
      paramBundle = getActivity().getIntent().getStringExtra("roykey");
      this.jdField_a_of_type_Lcy.h(i, j, 2, paramBundle);
      this.b.aKl();
      this.b.aKq();
    }
    this.ajK = true;
    paramBundle = (KandianMergeManager)this.mApp.getManager(162);
    if ((awit.aMG()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.tW = System.currentTimeMillis();
      paramBoolean = paramBundle.Bw();
      localIntent = paramActivity.getIntent();
      i = localIntent.getIntExtra("launch_from", 5);
      if (i == 13)
      {
        bool = localIntent.getBooleanExtra("force_refresh", false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_Kfn != null)
        {
          localIntent.removeExtra("force_refresh");
          paramBoolean = bool;
        }
      }
      l = this.tW - awit.s(this.mApp);
      if ((l >= awit.g(this.mApp)) && (!this.ajI))
      {
        paramBoolean = true;
        if (l < 900000L) {
          odv.bdJ();
        }
        QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + l);
        if (paramBundle.BE()) {
          paramBoolean = true;
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Kfn != null)) {
          lcc.a().aJH();
        }
        if ((this.jdField_a_of_type_Kfn == null) || (!paramBoolean)) {
          break label414;
        }
        lcm.a().a.ajn = true;
        this.jdField_a_of_type_Kfn.O(paramBoolean, 3);
        lcc.a().h(3, null);
        if (((paramActivity instanceof SplashActivity)) && (awit.aMG()))
        {
          if (i == 13) {
            break label404;
          }
          knj.a().ms(true);
        }
        if (!paramBoolean) {
          break label467;
        }
        lwh.a().aNQ();
      }
    }
    label404:
    label414:
    label467:
    while ((this.jdField_a_of_type_Kfn == null) || (!paramBundle.Bw()))
    {
      do
      {
        for (;;)
        {
          Intent localIntent;
          boolean bool;
          long l;
          return;
          this.ajI = false;
          continue;
          knj.a().ms(false);
          continue;
          if ((paramBundle.ok() > 0) && (this.jdField_a_of_type_Kfn != null)) {
            this.jdField_a_of_type_Kfn.lP(false);
          } else if ((this.jdField_a_of_type_Kfn != null) && (this.jdField_a_of_type_Kfn.zg())) {
            this.jdField_a_of_type_Kfn.lP(false);
          }
        }
      } while (!lwh.a().CT());
      if (this.jdField_a_of_type_Kfn != null)
      {
        this.jdField_a_of_type_Kfn.O(false, 8);
        return;
      }
      lwh.a().nI(true);
      return;
    }
    this.jdField_a_of_type_Kfn.lP(true);
  }
  
  public void aCc()
  {
    super.aCc();
    this.ajy = false;
    if (this.ajK) {
      this.b.aKm();
    }
    this.ajK = false;
    if (this.jdField_a_of_type_Kfn != null)
    {
      this.jdField_a_of_type_Kfn.aCc();
      this.jdField_a_of_type_Kfn.aCh();
    }
    if (awit.Vs())
    {
      this.tX = System.currentTimeMillis();
      awit.e(this.tX, this.mApp);
    }
  }
  
  public void aCe()
  {
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.aCe();
    }
  }
  
  public void aIp()
  {
    super.aIp();
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.lP(true);
    }
  }
  
  public void aIq()
  {
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.O(true, 4);
    }
  }
  
  public void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.i(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public int nh()
  {
    if (lhn.oC() != -1) {
      return lhn.oC();
    }
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.jdField_a_of_type_Kfn != null) {
      return this.jdField_a_of_type_Kfn.onBackPressed();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    lbz.a().nb(false);
    aLc();
    this.b.onCreate();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Kfn = ((kfn)kxm.dy.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_Kfn == null)
    {
      this.jdField_a_of_type_Kfn = new kfn(getActivity().getActivity());
      this.jdField_a_of_type_Kfn.onCreate();
    }
    this.jdField_a_of_type_Kfn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$a, this.mChannelCoverId);
    if (lgp.Ch()) {
      lgp.a().nw(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_Kfn.j(), "8014");
    VideoReport.setPageParams(this.jdField_a_of_type_Kfn.j(), new lal().a(0L).a());
    paramLayoutInflater = this.jdField_a_of_type_Kfn.j();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onDestroy();
    }
    this.jdField_a_of_type_Kfn = null;
    this.b.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    if ((awit.aMG()) && (this.jdField_a_of_type_Kfn != null)) {
      this.jdField_a_of_type_Kfn.onLogout(paramLogoutReason);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onPause();
    }
    this.b.onPause();
    meu.a().aOR();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Kfn != null) && (this.ajy)) {
      this.jdField_a_of_type_Kfn.onResume();
    }
    int i = getActivity().getIntent().getIntExtra("redpack_type", 1);
    int j = getActivity().getIntent().getIntExtra("plat_source", 1);
    String str = getActivity().getIntent().getStringExtra("roykey");
    this.jdField_a_of_type_Lcy.h(i, j, 2, str);
    if (!this.ajJ)
    {
      this.b.onResume();
      this.b.aKp();
    }
    this.ajJ = false;
    meu.a().aOQ();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Kfn != null) {
      this.jdField_a_of_type_Kfn.onStop();
    }
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    if (this.jdField_a_of_type_Kfn != null)
    {
      this.jdField_a_of_type_Kfn.O(true, paramInt);
      return;
    }
    kfv.oK(nh());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */