package com.tencent.mobileqq.msgbackup.fragment;

import ajfm;
import ajgt;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupMigrateFragment
  extends MsgBackupBaseFragment
{
  protected void aZv()
  {
    super.aZv();
    this.gI.setEnabled(true);
    this.gI.setText(2131690704);
    if (AppSetting.enableTalkBack) {
      this.gI.setContentDescription(getString(2131690704));
    }
    this.UG.setText(getActivity().getString(2131690730));
    this.jl.setVisibility(0);
    this.t.post(this.ha);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (paramMessage.arg1 == 1) {}
      for (;;)
      {
        if (this.gI != null) {
          this.gI.setEnabled(bool);
        }
        if (bool) {
          break label141;
        }
        if ((this.UG != null) && (!isDetached()))
        {
          this.UG.setTextColor(getResources().getColor(2131166105));
          this.UG.setText(getActivity().getString(2131690729));
        }
        if ((this.UH == null) || (isDetached())) {
          break;
        }
        this.UH.setText(getActivity().getString(2131690757));
        break;
        bool = false;
      }
      label141:
      if ((this.UG != null) && (!isDetached()))
      {
        this.UG.setTextColor(getResources().getColor(2131167304));
        this.UG.setText(getActivity().getString(2131690730));
      }
      if ((this.UH != null) && (!isDetached())) {
        this.UH.setText(getActivity().getString(2131690758));
      }
    }
  }
  
  protected void initTitle()
  {
    super.initTitle();
    setTitle(getActivity().getString(2131690732));
    this.vg.setOnItemSelectListener(new ajfm(this));
  }
  
  protected void kJ()
  {
    super.kJ();
    this.gI.setOnClickListener(this);
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
      PublicFragmentActivity.startForResult(getActivity(), MsgBackupSelectionFragment.class, 1000);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupMigrateFragment", 2, "migrate_btn onclick");
      }
      ajgt.report("0X800A230");
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.ha != null) {
      this.t.removeCallbacks(this.ha);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment
 * JD-Core Version:    0.7.0.1
 */