package com.tencent.mobileqq.vas;

import acle;
import aclh;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aqiw;
import aqqc;
import aqqd;
import arib;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

public class FriendCloneSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  View Jb;
  View Jc;
  public arib a;
  public int ebA = 0;
  public int ebB = 0;
  public AtomicBoolean eo = new AtomicBoolean(false);
  private DialogInterface.OnCancelListener f = new aqqc(this);
  private aclh h = new aqqd(this);
  public FragmentActivity mActivity;
  QQAppInterface mApp;
  
  public void bV(int paramInt)
  {
    this.ebB = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.Jc.setVisibility(8);
      this.Jb.setVisibility(0);
      return;
    }
    this.Jc.setVisibility(0);
    this.Jb.setVisibility(8);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity = getActivity();
    if (this.mActivity == null) {}
    do
    {
      return;
      this.mApp = this.mActivity.app;
    } while (this.mApp == null);
    setTitle(this.mActivity.getString(2131701618));
    this.leftView.setText(2131690700);
    this.mContentView.findViewById(2131369412).setOnClickListener(this);
    this.mContentView.findViewById(2131369479).setOnClickListener(this);
    this.Jb = this.mContentView.findViewById(2131369413);
    this.Jc = this.mContentView.findViewById(2131369480);
    this.a = new arib(this.mActivity, 2131561628);
    this.mApp.addObserver(this.h);
    if (!aqiw.isNetworkAvailable(this.mActivity)) {
      QQToast.a(this.mActivity, 1, 2131693404, 0).show(this.mActivity.getTitleBarHeight());
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "friendscloning", "friendscloning3", "", 1, 0, 0, "", "", "");
      return;
      ((acle)this.mApp.getBusinessHandler(13)).h(this.mApp.getCurrentAccountUin(), true, 257);
      this.eo.set(true);
      this.a.a(0, getString(2131718674), 0, this.f);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562108;
  }
  
  public void onClick(View paramView)
  {
    if ((this.mActivity == null) || (this.mApp == null)) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aqiw.isNetworkAvailable(this.mActivity)) {
          break;
        }
        QQToast.a(this.mActivity, 1, 2131693404, 0).show(this.mActivity.getTitleBarHeight());
      }
    } while (this.eo.get());
    acle localacle = (acle)this.mApp.getBusinessHandler(13);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.eo.set(true);
      this.a.a(0, getString(2131718674), 0, this.f);
      break;
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "friendscloning", "friendscloning4", "", 1, 0, 0, "", "", "");
      localacle.h(this.mApp.getCurrentAccountUin(), false, 258);
      bV(0);
      continue;
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "friendscloning", "friendscloning5", "", 1, 0, 0, "", "", "");
      localacle.h(this.mApp.getCurrentAccountUin(), true, 258);
      bV(1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mApp != null) {
      this.mApp.removeObserver(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.FriendCloneSettingFragment
 * JD-Core Version:    0.7.0.1
 */