package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import aqyg;
import auru;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class NearbyBaseFragment
  extends BaseFragment
  implements Handler.Callback
{
  public static int dan;
  NearbyActivity.TabInfo a = null;
  public NearbyAppInterface b;
  boolean chA;
  public Handler mHandler = new auru(Looper.getMainLooper(), this);
  boolean mIsInited;
  int mVelocity = 5000;
  
  public void a(NearbyActivity.TabInfo paramTabInfo)
  {
    this.a = paramTabInfo;
    this.tabID = paramTabInfo.tabIndex;
  }
  
  public aqyg b()
  {
    return null;
  }
  
  public void ckW()
  {
    super.ckW();
    if (!this.chA)
    {
      if ((this.rootView != null) && (!this.mIsInited) && (!this.mHandler.hasMessages(1))) {
        this.mHandler.sendEmptyMessage(1);
      }
      this.chA = true;
    }
  }
  
  public void doJ()
  {
    aqyg localaqyg = b();
    if ((localaqyg == null) || (this.mHandler == null)) {
      return;
    }
    try
    {
      int i = localaqyg.mWebview.getWebScrollY();
      int j = localaqyg.mWebview.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBaseFragment", 2, "gotoFragmentHead, scrollY=" + i + ", webH=" + j + ", maxV=" + this.mVelocity);
      }
      if (i > j)
      {
        localaqyg.mWebview.getView().scrollTo(0, j);
        this.mHandler.postDelayed(new NearbyBaseFragment.1(this, localaqyg), 60L);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    localException.mWebview.flingScroll(0, -this.mVelocity);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppInterface localAppInterface = null;
    super.onAttach(paramActivity);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramActivity);
    int i = localViewConfiguration.getScaledMaximumFlingVelocity();
    int j = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mVelocity = (i / 4);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyBaseFragment", 2, "onAttach: maxVelocity=" + i + ", minVelocity=" + j);
    }
    if (this.zw)
    {
      if ((paramActivity instanceof BaseActivity)) {
        localAppInterface = ((BaseActivity)paramActivity).getAppInterface();
      }
      if ((localAppInterface instanceof NearbyAppInterface)) {
        this.b = ((NearbyAppInterface)localAppInterface);
      }
      return;
    }
    this.b = null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = false;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((paramBundle != null) && (this.a == null))
    {
      paramViewGroup = paramBundle.getString("info");
      if (!TextUtils.isEmpty(paramViewGroup))
      {
        this.a = new NearbyActivity.TabInfo();
        this.a.fromJson(paramViewGroup);
      }
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder().append("onCreateView: inState==null?");
      if (paramBundle != null) {
        break label170;
      }
    }
    label170:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramViewGroup = paramViewGroup.append(bool1).append(", mTabInfo==null?");
      bool1 = bool2;
      if (this.a == null) {
        bool1 = true;
      }
      QLog.d("NearbyBaseFragment", 2, bool1 + ", this=" + this);
      if ((this.a != null) && (dan == this.a.tabIndex) && (!this.chA)) {
        this.chA = true;
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onSaveInstanceState(paramBundle);
    if ((paramBundle != null) && (this.a != null)) {
      paramBundle.putString("info", this.a.toJson());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSaveInstanceState: outState==null?");
      if (paramBundle != null) {
        break label102;
      }
      bool1 = true;
      paramBundle = localStringBuilder.append(bool1).append(", mTabInfo==null?");
      if (this.a != null) {
        break label107;
      }
    }
    label102:
    label107:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("NearbyBaseFragment", 2, bool1 + ", this=" + this);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment
 * JD-Core Version:    0.7.0.1
 */