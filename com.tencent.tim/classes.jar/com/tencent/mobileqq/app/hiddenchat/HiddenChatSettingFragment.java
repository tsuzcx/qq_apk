package com.tencent.mobileqq.app.hiddenchat;

import accn;
import acqg;
import acqh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anot;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HiddenChatSettingFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private FormSwitchItem aO;
  private FormSwitchItem aP;
  private accn f = new acqg(this);
  private QQAppInterface mApp;
  
  public static void aj(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.startForResult((Activity)paramContext, localIntent, HiddenChatSettingFragment.class, paramInt);
  }
  
  private void c(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
      this.aO = ((FormSwitchItem)this.mContentView.findViewById(2131374971));
      this.aP = ((FormSwitchItem)this.mContentView.findViewById(2131374972));
      this.mApp.addObserver(this.f);
      boolean bool = acqh.e(this.mApp.getCurrentUin(), getActivity());
      c(this.aO, bool);
      bool = acqh.f(this.mApp.getCurrentUin(), getActivity());
      c(this.aP, bool);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562951;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramCompoundButton == this.aO.a())
    {
      ((CardHandler)this.mApp.getBusinessHandler(2)).aU(paramBoolean, 42318);
      localQQAppInterface = getActivity().app;
      if (paramBoolean) {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800A34C", "0X800A34C", i, 0, "0", "0", "", "");
      }
    }
    while (paramCompoundButton != this.aP.a()) {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i = 2;
      }
    }
    ((CardHandler)this.mApp.getBusinessHandler(2)).aU(paramBoolean, 42319);
    QQAppInterface localQQAppInterface = getActivity().app;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800A350", "0X800A350", i, 0, "0", "0", "", "");
      break;
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131719875));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.removeObserver(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment
 * JD-Core Version:    0.7.0.1
 */