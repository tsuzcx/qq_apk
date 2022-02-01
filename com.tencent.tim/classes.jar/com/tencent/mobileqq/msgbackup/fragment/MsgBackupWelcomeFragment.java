package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajgt;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MsgBackupWelcomeFragment
  extends MsgBackupBaseFragment
{
  protected void aZv()
  {
    super.aZv();
    this.jj.setVisibility(0);
  }
  
  protected void initTitle()
  {
    super.initTitle();
    setTitle(getActivity().getString(2131690731));
  }
  
  protected void kJ()
  {
    super.kJ();
    this.aG.setOnClickListener(this);
    this.aH.setOnClickListener(this);
    if (AppSetting.enableTalkBack)
    {
      this.aG.setContentDescription(getString(2131690727));
      this.aH.setContentDescription(getString(2131690728));
      this.vg.setLeftViewName(2131690768);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ajgt.report("0X800A22E");
      PublicFragmentActivity.startForResult(getActivity(), MsgBackupMigrateFragment.class, 1000);
      continue;
      ajgt.report("0X800A268");
      ajdt.a().QE(1);
      PublicFragmentActivity.startForResult(getActivity(), MsgBackupPCAuthFragment.class, 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment
 * JD-Core Version:    0.7.0.1
 */