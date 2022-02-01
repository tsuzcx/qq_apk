package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajee;
import ajer;
import ajfn;
import ajfo;
import ajfp;
import ajgp;
import ajgt;
import ajhj;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqnm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupPCAuthFragment
  extends MsgBackupPcBaseFragment
{
  private boolean cob;
  private boolean coc;
  private Handler de = new Handler(new ajfn(this));
  private int diP = 60;
  private int diQ;
  
  private void QI(int paramInt)
  {
    this.diQ = paramInt;
    if (paramInt == 0)
    {
      this.gJ.setBackgroundResource(2130839524);
      return;
    }
    this.gJ.setBackgroundResource(2130851044);
  }
  
  private void dwX()
  {
    ajhj.a(BaseApplicationImpl.getContext(), "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/pcqq_version_upgrade_919.html", true, true, true, false, null, "biz_src_msg_backup");
  }
  
  protected void a(ajer paramajer)
  {
    super.a(paramajer);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrRsp data = " + paramajer);
    }
    if (paramajer != null)
    {
      ajdt.a().QE(paramajer.Gi());
      ajdt.a().Mr(paramajer.xm());
    }
  }
  
  protected void aZv()
  {
    super.aZv();
    aqnm.setVisible(this.jl, 0);
    aqnm.setVisible(this.jm, 8);
    aqnm.setVisible(this.gJ, 0);
    aqnm.setVisible(this.gI, 8);
    aqnm.setVisible(this.gJ, 0);
    this.Bb.setImageResource(2130842119);
    this.UG.setText(2131690784);
    this.UH.setText(2131690787);
    this.gJ.setText(2131690791);
    if (AppSetting.enableTalkBack) {
      this.gJ.setContentDescription(getString(2131690791));
    }
    this.vg.setRightViewTextVisible(0);
    this.vg.setOnItemSelectListener(new ajfo(this));
    ajee.a().a(new ajfp(this));
    this.t.post(this.ha);
    this.gJ.setOnClickListener(this);
  }
  
  public void dwW()
  {
    ajee.a().a().exit();
    ajgp.b().onDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 0;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (paramMessage.arg1 == 1) {}
      for (int i = 1;; i = 0)
      {
        if (this.gJ != null)
        {
          if (!this.coc) {
            break label149;
          }
          QI(1);
        }
        if (i != 0) {
          break label166;
        }
        if ((this.UG != null) && (!isDetached()))
        {
          this.UG.setTextColor(getResources().getColor(2131166105));
          this.UG.setText(getActivity().getString(2131690729));
        }
        if ((this.UH == null) || (isDetached())) {
          break;
        }
        this.UH.setText(getActivity().getString(2131690787));
        break;
      }
      label149:
      if (i != 0) {}
      for (;;)
      {
        QI(j);
        break;
        j = 2;
      }
      label166:
      if ((this.UG != null) && (!isDetached()))
      {
        this.UG.setTextColor(getResources().getColor(2131167304));
        this.UG.setText(getActivity().getString(2131690784));
      }
      if ((this.UH != null) && (!isDetached())) {
        this.UH.setText(getActivity().getString(2131690787));
      }
    }
  }
  
  protected void initTitle()
  {
    setTitle(getActivity().getString(2131690706));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    ajee.cnI = false;
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  protected void m(Integer paramInteger)
  {
    super.m(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrError result = " + paramInteger);
    }
    if (paramInteger.intValue() == 1028) {
      dwX();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
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
      if (this.diQ == 0)
      {
        this.coc = true;
        this.cob = true;
        this.de.sendEmptyMessage(1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "migrate_sure onclick phone request backup!");
        }
        ajee.a().LV(true);
        ajgt.report("0X800A26A");
      }
      else if ((this.diQ == 1) && (!this.cnI))
      {
        ajgt.report("0X800A26B");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ajee.a().a(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.de.removeMessages(1);
    ajee.a().a(null);
    if (this.ha != null) {
      this.t.removeCallbacks(this.ha);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment
 * JD-Core Version:    0.7.0.1
 */