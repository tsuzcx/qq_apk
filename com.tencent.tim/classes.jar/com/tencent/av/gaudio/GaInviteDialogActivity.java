package com.tencent.av.gaudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import aqji.c;
import aqjl;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils.a;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igv;
import iiv;
import inn;
import ivv;

public class GaInviteDialogActivity
  extends GaInviteActivity
{
  boolean Tn = true;
  public int aqI = 0;
  public int aqJ = 0;
  Button bd = null;
  Button be = null;
  View mDivider = null;
  
  private void aoA()
  {
    if (isFinishing()) {
      return;
    }
    aov();
  }
  
  private void aoz()
  {
    if (this.aqx == 2)
    {
      String str = String.valueOf(this.mGroupId);
      if (aqjl.cV(this.mApp.w(str)))
      {
        ChatActivityUtils.a.a(this.TAG, str, new inn(this));
        return;
      }
      aoA();
      return;
    }
    aoA();
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131374013: 
      aqji.c.SF(false);
      super.cm(-1036L);
      return;
    }
    aqji.c.SF(true);
    if ((this.a.OB) || (this.a.sw())) {
      aow();
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
      return;
      long l = AudioHelper.hG();
      sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      QLog.w(this.TAG, 1, "BtnOnClick[qav_gaudio_join], relationId[" + this.d.ll + "], mAnyChatCloseByFriend[" + this.a.OD + "], seq[" + l + "]");
      if (this.a.OD)
      {
        paramView = igv.a().a();
        if (paramView != null) {
          paramView.bN(l);
        }
        this.a.hI(true);
      }
      this.mApp.l(new Object[] { Integer.valueOf(308), Long.valueOf(this.d.ll) });
      aoz();
    }
  }
  
  void aD(Intent paramIntent)
  {
    paramIntent.putExtra("ConfAppID", this.aqI);
    paramIntent.putExtra("MeetingConfID", this.aqJ);
  }
  
  protected void initUI()
  {
    if ((!aqiw.isWifiConnected(super.getApplicationContext())) && ((aqiw.is3Gor4G(super.getApplicationContext())) || (aqiw.isMobileNetWork(super.getApplicationContext())))) {
      this.Tn = false;
    }
    this.mw = ((TextView)super.findViewById(2131374017));
    this.mx = ((TextView)super.findViewById(2131373998));
    this.gn = ((ImageView)super.findViewById(2131374011));
    this.be = ((Button)super.findViewById(2131374013));
    this.bd = ((Button)super.findViewById(2131374020));
    this.gn.setImageResource(2130839584);
    this.mx.setSingleLine();
    this.mDivider = super.findViewById(2131365844);
    if (!this.Tn) {
      ((TextView)super.findViewById(2131374023)).setVisibility(0);
    }
    super.initUI();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onCreate");
    }
    super.setTheme(2131755449);
    super.setContentView(2131559902);
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    iA(false);
  }
  
  public void onResume()
  {
    super.onResume();
    iA(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteDialogActivity
 * JD-Core Version:    0.7.0.1
 */