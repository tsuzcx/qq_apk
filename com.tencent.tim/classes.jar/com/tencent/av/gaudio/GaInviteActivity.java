package com.tencent.av.gaudio;

import aeee;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import anot;
import aqha;
import aqju;
import aqpr;
import aqwu;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igv;
import iid;
import iiv;
import ink;
import inm;
import java.io.File;
import jjc;
import jko;
import jlm;

public class GaInviteActivity
  extends BaseGaInvite
{
  public String OG = "";
  public boolean Tg = true;
  boolean Th = false;
  boolean Ti = false;
  boolean Tj = false;
  boolean Tk = false;
  protected boolean Tl;
  boolean Tm = false;
  iid jdField_a_of_type_Iid = new inm(this);
  jko jdField_a_of_type_Jko = null;
  jlm jdField_a_of_type_Jlm = null;
  int aqD = -1;
  final int aqE = 0;
  final int aqF = 1;
  final int aqG = 2;
  long commingRingId = -1L;
  iiv d = null;
  AudioManager mAudioManager = null;
  
  void aD(Intent paramIntent) {}
  
  public void aou()
  {
    if (this.Ti) {
      anot.a(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Jko != null) {
        this.jdField_a_of_type_Jko.cancelNotification(this.d.sessionId);
      }
      z(-1041L, 8);
      return;
      anot.a(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
    }
  }
  
  public void aov()
  {
    QLog.w(this.TAG, 1, "startGActivity");
    cn(AudioHelper.hG());
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.mGroupId));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.l);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.d.anb);
    localIntent.putExtra("uin", String.valueOf(this.mGroupId));
    localIntent.putExtra("uinType", this.mUinType);
    localIntent.putExtra("isFromInviteDialog", true);
    aD(localIntent);
    AudioHelper.I("GaInviteActivity.startGActivity", localIntent.getExtras());
    super.startActivity(localIntent);
    this.Tl = true;
    super.finish();
    overridePendingTransition(2130772239, 0);
  }
  
  public void aow()
  {
    QLog.w(this.TAG, 1, "quitGAudioDialog");
    a locala1 = new a(0);
    a locala2 = new a(1);
    aqha.a(this, 230, null, getString(2131697710), 2131721690, 2131697626, locala1, locala2).show();
  }
  
  public void aox()
  {
    finish();
  }
  
  public void aoy()
  {
    long l = AudioHelper.hG();
    boolean bool = jjc.cJ(this.mApp.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "startRingAndShake avCallBtnState[" + bool + "], Silent[" + this.Tj + "], seq[" + l + "]");
    }
    if (!bool) {
      return;
    }
    Object localObject;
    if (!this.Tj)
    {
      TraeHelper.a().startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.OB)
      {
        this.Tk = true;
        this.jdField_a_of_type_Jlm = new jlm(this.mApp);
        localObject = this.jdField_a_of_type_Jlm.a(this.mApp.getCurrentAccountUin());
        if (localObject == null) {
          break label207;
        }
        this.commingRingId = aqwu.a(this.mApp, ((ExtensionInfo)localObject).uin, 3, true, null);
        if (this.commingRingId != 0L) {
          break label215;
        }
        TraeHelper.a().a(l, this.mApp, 2131230755, -1, null);
      }
    }
    for (;;)
    {
      TraeHelper.a(this.mApp, false, l);
      return;
      label207:
      this.commingRingId = 0L;
      break;
      label215:
      localObject = aqpr.p(this.commingRingId, 3);
      if (new File((String)localObject).exists())
      {
        TraeHelper.a().a(l, this.mApp, 0, (String)localObject, -1, null);
        anot.a(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.commingRingId + "", "", "");
      }
      else
      {
        TraeHelper.a().a(l, this.mApp, 2131230755, -1, null);
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
        ((Intent)localObject).setPackage(this.mApp.getApp().getPackageName());
        ((Intent)localObject).putExtra("comming_ring_down_key", this.commingRingId);
        this.mApp.getApp().sendBroadcast((Intent)localObject);
      }
    }
  }
  
  public void cm(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.c(paramLong, this.aqx, this.mGroupId);
    super.finish();
  }
  
  public void cn(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "stopRingAndShake seq[" + paramLong + "], IsPlayingRing[" + this.Tk + "]");
    }
    if (this.Tk)
    {
      this.Tk = false;
      TraeHelper.a().dN(paramLong);
    }
    TraeHelper.t(this.mApp);
  }
  
  protected void initUI() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.getWindow().addFlags(2097152);
    paramBundle = getIntent();
    aC(paramBundle);
    this.OG = paramBundle.getStringExtra("inviteId");
    this.aqD = paramBundle.getIntExtra("memberType", -1);
    boolean bool = paramBundle.getBooleanExtra("hasGVideoJoined", false);
    int i = paramBundle.getIntExtra("MultiAVType", -1);
    Object localObject = b(paramBundle);
    long l1 = AudioHelper.hG();
    String str = this.TAG;
    localObject = new StringBuilder().append("onCreate[").append((String)localObject).append("], mInviterUin[").append(this.mf).append("], mInviteId[").append(this.OG).append("], mGroupId[").append(this.mGroupId).append("], mMemberType[").append(this.aqD).append("], mRelationType[").append(this.aqx).append("], mHasGVideoJoined[").append(bool).append("], multiAVType[").append(i).append("], mMemberList[");
    if (this.l != null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append("], mApp[");
      if (this.mApp == null) {
        break label337;
      }
      bool = true;
      label225:
      localObject = ((StringBuilder)localObject).append(bool).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label342;
      }
    }
    label337:
    label342:
    for (bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], seq[" + l1 + "]");
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onCreate-from: " + paramBundle.getStringExtra("Fromwhere"));
      }
      if (this.mApp != null) {
        break label347;
      }
      super.finish();
      return;
      bool = false;
      break;
      bool = false;
      break label225;
    }
    label347:
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      super.finish();
      return;
    }
    this.mAudioManager = ((AudioManager)super.getSystemService("audio"));
    if ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)) {
      this.Tj = true;
    }
    paramBundle = igv.a(this.aqx, String.valueOf(this.mGroupId), new int[0]);
    if (igv.a().ci(paramBundle)) {}
    for (this.d = igv.a().c(paramBundle); (this.l == null) && (this.aqx == 2); this.d = igv.a().a())
    {
      super.finish();
      return;
    }
    if ((this.mf == 0L) || (this.mGroupId == 0L))
    {
      super.finish();
      return;
    }
    long l2 = this.jdField_a_of_type_ComTencentAvVideoController.bu();
    if (this.mGroupId != l2)
    {
      QLog.w(this.TAG, 1, "onCreate, id不一致, currentInviteId[" + l2 + "], mGroupId[" + this.mGroupId + "], seq[" + l1 + "]");
      cm(l1);
      return;
    }
    initUI();
    if (this.Tg) {
      jn("onCreate");
    }
    this.mApp.addObserver(this.jdField_a_of_type_Iid);
    this.Th = true;
    if ((this instanceof GaInviteDialogActivity)) {
      this.Ti = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.mGroupId, i);
      startTimer(60000);
      return;
      if ((this instanceof GaInviteLockActivity)) {
        this.Ti = true;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mApp != null) {
      this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
    }
    if (this.jdField_a_of_type_Jko != null)
    {
      this.jdField_a_of_type_Jko.cancelNotification(this.d.sessionId);
      this.jdField_a_of_type_Jko = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.OQ = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onKeyDown, keyCode[" + paramInt + "], seq[" + l + "]");
    if (paramInt == 4) {
      cm(l);
    }
    for (;;)
    {
      return false;
      if ((paramInt == 26) || (paramInt == 25) || (paramInt == 24)) {
        cn(l);
      }
    }
  }
  
  public void onPause()
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onPause, mSilent[" + this.Tj + "], seq[" + l + "]");
    cn(l);
    aeee.e(this, 2, true);
    this.Th = false;
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    aoy();
    aeee.e(this, 2, false);
    if (this.jdField_a_of_type_Jko != null) {
      this.jdField_a_of_type_Jko.cancelNotification(this.d.sessionId);
    }
    String str;
    if (this.Th)
    {
      if (!this.Ti) {
        break label174;
      }
      if (VideoController.isScreenLocked(this))
      {
        str = "1";
        anot.a(null, "CliOper", "", "", "0X8009E92", "0X8009E92", 0, 0, str, "", "", "");
      }
    }
    else
    {
      label85:
      if (this.mApp.g(this.aqx, this.mGroupId)) {
        break label202;
      }
      QLog.w(this.TAG, 1, "onResume finish, mGroupId[" + this.mGroupId + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.alH();
      this.jdField_a_of_type_ComTencentAvVideoController.o(this.aqx, this.mGroupId);
      finish();
    }
    label174:
    label202:
    while (this.Tm)
    {
      return;
      str = "2";
      break;
      anot.a(null, "CliOper", "", "", "Multi_call", "Popup_force", 0, 0, "", "", "", "");
      break label85;
    }
    this.Tm = true;
    ChatActivityUtils.a(this, true, new ink(this));
  }
  
  public void onStop()
  {
    super.onStop();
    if (!super.isFinishing())
    {
      if (this.jdField_a_of_type_Jko == null) {
        this.jdField_a_of_type_Jko = jko.a(this.mApp);
      }
      String str1 = String.valueOf(this.mGroupId);
      Bitmap localBitmap = this.mApp.a(this.mUinType, str1, null, true, true);
      int i = jjc.cJ(this.aqx);
      String str2 = this.mApp.getDisplayName(i, Long.toString(this.mf), str1);
      this.jdField_a_of_type_Jko.a(this.d.sessionId, str2, localBitmap, str1, 43, this.mUinType, 3);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i;
    String str;
    if (paramBoolean)
    {
      long l = this.mGroupId;
      i = jjc.cJ(this.aqx);
      str = this.mApp.getDisplayName(i, Long.toString(this.mf), String.valueOf(l));
      if (!(this instanceof GaInviteLockActivity)) {
        break label162;
      }
      if (getApplicationContext().getString(2131694249).equalsIgnoreCase(this.mw.getText().toString()))
      {
        str = a(this.aqx, this.mGroupId, null, true, false);
        this.mw.setText(str);
      }
    }
    for (;;)
    {
      QLog.w(this.TAG, 1, "onWindowFocusChanged, uinType_Invite[" + i + "], inviteFriendName[" + str + "]");
      findViewById(2131374015).setContentDescription(str);
      return;
      label162:
      this.mw.setText(str);
      str = str + super.getApplicationContext().getString(2131694249);
    }
  }
  
  public void z(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.aqx, this.mGroupId, paramInt, false);
    super.finish();
  }
  
  class a
    implements DialogInterface.OnClickListener
  {
    int aqH;
    
    public a(int paramInt)
    {
      this.aqH = paramInt;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      switch (this.aqH)
      {
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (GaInviteActivity.this.a.sw()) {
          GaInviteActivity.this.a.hI(true);
        }
        for (;;)
        {
          GaInviteActivity.this.aov();
          break;
          if (GaInviteActivity.this.a.OB) {
            GaInviteActivity.this.a.alF();
          }
        }
        GaInviteActivity.this.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity
 * JD-Core Version:    0.7.0.1
 */