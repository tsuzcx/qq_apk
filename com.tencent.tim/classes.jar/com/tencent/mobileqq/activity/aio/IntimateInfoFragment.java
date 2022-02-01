package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import wll;
import wxr;
import wxv;

public class IntimateInfoFragment
  extends PublicBaseFragment
{
  private wxr a;
  
  public void aCM()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if (localSystemBarCompact != null)
    {
      localSystemBarCompact.setStatusDrawable(null);
      localSystemBarCompact.setStatusBarColor(0);
      localSystemBarCompact.setStatusColor(0);
      if (!ThemeUtil.isNowThemeIsNight(getActivity().app, true, null)) {
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      }
    }
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a.initData();
    aCM();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getActivity().getIntent().getStringExtra("FORWARD_PEER_UIN");
    this.a = wxv.a(getActivity().app, getActivity(), getActivity(), paramLayoutInflater);
    if ((this.a == null) || (this.a.getRootView() == null)) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.a.getRootView())
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if ((this.a instanceof wll)) {
        ((wll)this.a).setCurrentShowType(2);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.a instanceof wll)) {
      ((wll)this.a).onPaused();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.yy(true);
    this.a.bZg();
    this.a.bZo();
    if ((this.a instanceof wll)) {
      ((wll)this.a).onResumed();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.yx(true);
    this.a.bZe();
    this.a.bZg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoFragment
 * JD-Core Version:    0.7.0.1
 */