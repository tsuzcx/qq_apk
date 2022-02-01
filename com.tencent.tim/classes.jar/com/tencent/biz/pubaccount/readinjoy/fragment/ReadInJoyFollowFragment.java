package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anpc;
import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import kfs;
import kxm;
import lbz;

public class ReadInJoyFollowFragment
  extends ReadInJoyBaseFragment
{
  protected kfs a;
  private int aIz = 1;
  private boolean ajy;
  private View mContentView;
  
  public static ReadInJoyFollowFragment a()
  {
    ReadInJoyFollowFragment localReadInJoyFollowFragment = new ReadInJoyFollowFragment();
    localReadInJoyFollowFragment.setArguments(new Bundle());
    return localReadInJoyFollowFragment;
  }
  
  private void initUI()
  {
    ViewGroup localViewGroup = (ViewGroup)this.mContentView.findViewById(2131376777);
    this.a = new kfs(getActivity());
    this.a.oD(70);
    this.a.setChannelType(0);
    this.a.i(localViewGroup);
    this.a.onCreate();
  }
  
  public boolean BS()
  {
    return kxm.AP();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    super.a(paramMessageRecord, paramInt, paramBundle);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.a != null) {
      this.a.aBY();
    }
    this.ajy = true;
    if ((!awit.aMG()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      paramActivity = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramActivity.qD();
      if (i == 2) {
        paramActivity.tG(i);
      }
      if ((this.b != null) && (this.b.de(2) > 0) && (this.a != null)) {
        this.a.lP(true);
      }
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.onResume();
      }
      anpc.a(getActivity()).collectPerformance(this.mApp.getCurrentUin(), "actReadInJoyEnterDD", true, 0L, 0L, null, null);
      return;
      this.b.ql(2);
    }
  }
  
  public void aCc()
  {
    super.aCc();
    this.ajy = false;
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void aCe()
  {
    if (this.a != null) {
      this.a.aCe();
    }
  }
  
  public void aIp()
  {
    if (this.a != null) {
      this.a.lP(true);
    }
  }
  
  public void aIq()
  {
    if (this.a != null) {
      this.a.lP(true);
    }
  }
  
  public void f(MessageRecord paramMessageRecord)
  {
    super.f(paramMessageRecord);
  }
  
  public void g(MessageRecord paramMessageRecord)
  {
    super.g(paramMessageRecord);
  }
  
  public void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    super.i(paramInt1, paramInt2, paramIntent);
  }
  
  public int nh()
  {
    return 70;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mInflater = LayoutInflater.from(getActivity());
    this.mContentView = this.mInflater.inflate(2131560381, paramViewGroup, false);
    initUI();
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.onDestroy();
    lbz.a().aJg();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.a.aBZ();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.ajy) {
      this.a.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.ajy) {
      this.a.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.ajy) {
      this.a.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFollowFragment
 * JD-Core Version:    0.7.0.1
 */