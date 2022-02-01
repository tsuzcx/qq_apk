package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajee;
import ajeo;
import ajfq;
import ajgp;
import ajgt;
import ajgv;
import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqnm;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupPCConfirmFragment
  extends MsgBackupPcBaseFragment
{
  public static MsgBackupPCConfirmFragment a;
  
  protected void aZv()
  {
    super.aZv();
    aqnm.setVisible(this.jl, 0);
    aqnm.setVisible(this.jm, 8);
    aqnm.setVisible(this.gJ, 8);
    aqnm.setVisible(this.gI, 0);
    aqnm.setVisible(this.gJ, 8);
    this.UG.setText(2131690728);
    this.UH.setText(2131690786);
    this.Bb.setImageResource(2130842119);
    this.gI.setText(2131690704);
    if (AppSetting.enableTalkBack) {
      this.gI.setContentDescription(getString(2131690704));
    }
    if (this.diy == 2)
    {
      this.Bb.setImageResource(2130842118);
      this.UG.setText(getActivity().getString(2131690795));
      this.UH.setVisibility(8);
      if (AppSetting.enableTalkBack) {
        this.gI.setContentDescription(getString(2131690794));
      }
      this.gI.setText(getActivity().getString(2131690794));
      ajgt.report("0X800A280");
    }
    if (this.cnI)
    {
      this.vg.setLeftBackVisible(8);
      this.vg.setRightButton(2131690716);
    }
    this.vg.setOnItemSelectListener(new ajfq(this));
    if (ajee.cnI) {
      ajgt.report("0X800A254");
    }
  }
  
  protected void bC(boolean paramBoolean, Object paramObject)
  {
    super.bC(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCConfirmFragment", 2, "mBizType = " + this.diy);
    }
    if (paramBoolean) {
      paramObject = (ajeo)paramObject;
    }
  }
  
  protected void bindData()
  {
    super.bindData();
    ajee.a().a().b(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ajgp.b().exit();
      paramInt = ajdt.a().Gi();
      if (paramInt == 2) {
        onBackEvent();
      }
      while (paramInt != 1) {
        return true;
      }
      if (this.cnI)
      {
        onBackEvent();
        return true;
      }
      ca(getActivity());
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void exit(boolean paramBoolean)
  {
    Message localMessage = this.mUIHandler.obtainMessage(10001);
    this.mUIHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      ajgv.b("MsgBackupMsgBackupPCConfirmFragment", "activity is null------------->", new Object[0]);
    }
    int i;
    do
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        return false;
      }
      i = ajdt.a().Gi();
      if (i == 2)
      {
        onBackEvent();
        return false;
      }
    } while (i != 1);
    if (this.cnI)
    {
      onBackEvent();
      return false;
    }
    ca(getActivity());
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if ((paramActivity != null) && (this.cnI)) {
      paramActivity.overridePendingTransition(2130772156, 2130772155);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((a != null) && (a.getActivity() != null)) {
      a.getActivity().finish();
    }
    for (;;)
    {
      a = this;
      return;
      ajgv.c("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onAttach getActivity = null,sInstance = null", new Object[0]);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent;
      if (this.diy == 1)
      {
        localIntent = new Intent();
        localIntent.putExtra("backup_select_from", 1);
        localIntent.putExtra("0x11bpush_extra", this.mExtraData);
        PublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupSelectionFragment.class, 1000);
        ajgv.b("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_BACKUP", new Object[0]);
        if (this.cnI) {
          ajgt.report("0X800A255");
        }
      }
      else
      {
        localIntent = new Intent();
        localIntent.putExtra("param_start", 2);
        localIntent.putExtra("0x11bpush_extra", this.mExtraData);
        PublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupPCTransportFragment.class, 1000);
        ajgv.b("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_RESTORE", new Object[0]);
        ajgt.report("0X800A281");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!ajee.cnG) {
      ajee.a().a().b(null);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (a == this) {
      a = null;
    }
    ajgv.c("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onDetach l", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment
 * JD-Core Version:    0.7.0.1
 */