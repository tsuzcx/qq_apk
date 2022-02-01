package com.tencent.mobileqq.intervideo.now.dynamic;

import aifc;
import aifl;
import aigc;
import aigd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.NowPluginObserver;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;

public class LoadingFragment
  extends IphoneTitleBarFragment
{
  static View mLoadingView;
  NowPluginObserver a = new aigc(this);
  aifl b;
  QQAppInterface mApp;
  
  public static void a(Context paramContext, Bundle paramBundle, View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    mLoadingView = paramView;
    PublicFragmentActivity.start(paramContext, localIntent, LoadingFragment.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mApp == null) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    localFragmentActivity.overridePendingTransition(0, 0);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getArguments().putBoolean("loadingShow", true);
    hideTitleBar();
    if (mLoadingView != null)
    {
      paramLayoutInflater = (FrameLayout)this.mContentView;
      if (paramLayoutInflater != null)
      {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
        if (mLoadingView.getParent() != null) {
          ((ViewGroup)mLoadingView.getParent()).removeView(mLoadingView);
        }
        paramLayoutInflater.addView(mLoadingView, paramViewGroup);
      }
    }
    this.b.a.a.dsk();
  }
  
  public void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561464;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null) {}
    for (paramBundle = null; (paramBundle instanceof QQAppInterface); paramBundle = paramBundle.getAppInterface())
    {
      this.mApp = ((QQAppInterface)paramBundle);
      this.b = ((aifl)paramBundle.getManager(306));
      Global.addNowPluginObserver(this.a);
      return;
    }
    QLog.e("IphoneTitleBarFragment", 1, "app is null");
    finish();
  }
  
  public boolean onBackEvent()
  {
    NowLive.cancelRun();
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      Global.removeNowPluginObserver(this.a);
    }
    if (mLoadingView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)mLoadingView.getParent();
      if (localViewGroup != null)
      {
        QLog.i("LoadingFragment", 4, "removeView ");
        localViewGroup.removeView(mLoadingView);
      }
    }
    mLoadingView = null;
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment
 * JD-Core Version:    0.7.0.1
 */