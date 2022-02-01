package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import anot;
import aqiw;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.RecvMsg;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iid;
import iiv;
import ioa;
import iya;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class SmallScreenMultiVideoControlUI$1
  extends iid
{
  SmallScreenMultiVideoControlUI$1(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void A(long paramLong1, long paramLong2)
  {
    super.A(paramLong1, paramLong2);
    this.this$0.a(paramLong2, 5, false, 72);
  }
  
  public void R(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    label205:
    ioa localioa;
    switch (paramInt1)
    {
    default: 
    case 96: 
    case 97: 
    case 98: 
    case 90: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.w("SmallScreenMultiVideoControlUI", 1, "onGaOperationResult, EV_GA_SDK_REQUEST_VIDEO_SUC, info[" + paramLong3 + "], seq[" + paramLong1 + "]");
          }
          if (paramLong3 == 1L)
          {
            this.this$0.jI("onGaOperationResult");
            this.this$0.arb();
            this.this$0.f(paramLong1, this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if);
            return;
          }
        } while (paramLong3 != 0L);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "request video failed");
        }
        this.this$0.a(paramLong2, paramInt1, false, -1);
        return;
      } while (paramLong3 != 3L);
      ArrayList localArrayList = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if;
      paramInt1 = 0;
      if (paramInt1 < localArrayList.size())
      {
        localioa = (ioa)localArrayList.get(paramInt1);
        if ((paramLong2 != localioa.uin) || (localioa.videoSrcType != 1)) {
          break;
        }
      }
      break;
    }
    for (boolean bool = localioa.Tp;; bool = false)
    {
      this.this$0.jdField_a_of_type_Iya.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
      this.this$0.arb();
      return;
      paramInt1 += 1;
      break label205;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "go on stage failed");
      }
      if (this.this$0.aqx != 2) {
        break;
      }
      anot.a(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SmallScreenMultiVideoControlUI", 2, "Go Off Stage-->roomMode=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ang + " isBeBan" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QN + " isPressSpeaking=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QJ + " isOnlyManagerCanOnStage=" + this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QK);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "onMemberBanOrCancelBanAudio, groupUin[" + paramLong1 + "], userUin[" + paramLong2 + "], relationType[" + paramInt + "], bBan[" + paramBoolean + "], seq[" + l + "]");
    }
    if ((this.this$0.bJ() != paramLong1) || (paramLong2 != this.this$0.mSelfUin) || (paramInt != 1)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QN = true;
    } while (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().PY);
    this.this$0.cD(l);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.this$0.mSelfUin, this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "onMemberVideoOut, groupId[" + paramLong2 + "], friendUin[" + paramLong3 + "], videoSrcType[" + paramInt + "], seq[" + paramLong1 + "]");
    }
    if (paramLong3 == this.this$0.mSelfUin) {
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().PY) {
        this.this$0.cD(paramLong1);
      }
    }
    for (;;)
    {
      this.this$0.a(paramLong3, 6, false, 73);
      return;
      ioa localioa = new ioa();
      localioa.uin = paramLong3;
      localioa.videoSrcType = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localioa);
      this.this$0.jdField_a_of_type_Iya.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    if (this.this$0.aqx != 1) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() == 0)
      {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong1, "onMemberPPTInOrOut", false, false);
        this.this$0.arb();
        this.this$0.g(false, false, false);
        return;
      }
      if ((!aqiw.isWifiConnected((Context)this.this$0.mContext.get())) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().kK() == -1) && (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().Rb)) {
        break;
      }
    } while (this.this$0.auE >= 4);
    this.this$0.mApp.getHandler().removeCallbacks(this.this$0.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
    this.this$0.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.QJ = "onMemberPPTInOrOut";
    this.this$0.mApp.getHandler().postDelayed(this.this$0.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
    return;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong1, "onMemberPPTInOrOut", true, true);
    this.this$0.arb();
    this.this$0.g(true, true, true);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.this$0.bJ() != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.this$0.bJ() + " ,isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.this$0.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramLong == 0L) || (paramLong == this.this$0.mSelfUin)) {
      return;
    }
    this.this$0.jf(paramBoolean1);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {}
    for (paramInt = 42;; paramInt = 43)
    {
      this.this$0.a(paramLong, 2, paramBoolean2, paramInt);
      return;
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
  }
  
  public void amA() {}
  
  public void amB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo --> Start");
    }
    Object localObject = (SmallScreenService)this.this$0.mContext.get();
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label62;
      }
      ((SmallScreenRelativeLayout)localObject).post(new SmallScreenMultiVideoControlUI.1.2(this));
    }
    label62:
    while (!QLog.isColorLevel())
    {
      return;
      localObject = ((SmallScreenService)localObject).a(1);
      break;
    }
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onVideoSrcTypeChange-->mGroupId=" + this.this$0.bJ() + " userUin=" + paramLong2 + " groupUin=" + paramLong1 + " videoSrcType=" + paramInt1 + " relationType" + paramInt2);
    }
    if (paramLong1 != this.this$0.bJ()) {}
    while (paramInt2 != 1) {
      return;
    }
    this.this$0.a(paramLong2, 10, false, paramInt1);
    if ((paramInt1 == 2) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().PZ))
    {
      this.this$0.mApp.l(new Object[] { Integer.valueOf(111), Boolean.valueOf(true) });
      return;
    }
    this.this$0.mApp.l(new Object[] { Integer.valueOf(111), Boolean.valueOf(false) });
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.this$0.aqx != 1) {}
    do
    {
      do
      {
        return;
      } while (paramLong1 != this.this$0.bJ());
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.this$0.mUinType);
      localIntent.putExtra("info", paramLong2);
      localIntent.putExtra("strMsg", paramString);
      localIntent.putExtra("MultiAVType", this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().anb);
      localIntent.putExtra("from", "SmallScreenMultiVideoControlUI1");
      paramString = (SmallScreenService)this.this$0.mContext.get();
      if (paramString != null)
      {
        localIntent.setPackage(this.this$0.mApp.getApplication().getPackageName());
        paramString.sendBroadcast(localIntent);
        paramString.stopSelf();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().Qw) {
      if (this.this$0.bJ() != paramLong1) {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberLeave,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.this$0.bJ() + " ,isQQUser = " + paramBoolean);
        }
      }
    }
    while (paramLong2 == this.this$0.mSelfUin)
    {
      return;
      super.b(paramLong1, paramLong2, paramBoolean);
      this.this$0.a(paramLong2, 1, true, 71);
      return;
    }
    this.this$0.ari();
  }
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    if (paramBoolean1) {
      i = 7;
    }
    for (int j = 78;; j = 79)
    {
      this.this$0.a(paramLong2, i, false, j);
      return;
      i = 8;
    }
  }
  
  public void b(String paramString, String[] paramArrayOfString)
  {
    super.b(paramString, paramArrayOfString);
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.d(paramArrayOfString, String.valueOf(this.this$0.bJ()), this.this$0.aqx);
    if (i == 1) {
      this.this$0.mRes.getString(2131697707);
    }
    for (;;)
    {
      this.this$0.a(Long.valueOf(paramString).longValue(), 82, true, -1);
      return;
      String.format(this.this$0.mRes.getString(2131697706), new Object[] { Integer.valueOf(i) });
    }
  }
  
  public void bG(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onDestroyUI");
    }
    super.bG(paramLong);
    this.this$0.mApp.getHandler().postDelayed(new SmallScreenMultiVideoControlUI.1.1(this, paramLong), 1500L);
  }
  
  public void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.this$0.aqx != 1) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QO = true;
  }
  
  public void d(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.this$0.aqx != 1) {}
    do
    {
      return;
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QO = false;
    } while (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().PY);
  }
  
  public void g(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.this$0.aqx != 1) {}
    do
    {
      return;
      if (paramInt2 == 102)
      {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QK = true;
        return;
      }
    } while (paramInt2 != 103);
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().PY) {}
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QK = false;
  }
  
  public void h(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.this$0.aqx != 1) {
      return;
    }
    switch (paramInt2)
    {
    case 102: 
    case 103: 
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.e("SmallScreenMultiVideoControlUI.onSpeakModeChanged", this.this$0.bJ(), false);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QJ = true;
      return;
    case 108: 
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ang = 108;
      return;
    case 107: 
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ang = 107;
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ang = 104;
  }
  
  public void l(long paramLong, int paramInt1, int paramInt2)
  {
    long l = this.this$0.bJ();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "onGroupVideoChatClosed, relationId[" + paramLong + "], curGroupId[" + l + "]");
    }
    if (l != paramLong) {}
    do
    {
      do
      {
        return;
      } while (this.this$0.aqx != 1);
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.this$0.mUinType);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", "SmallScreenMultiVideoControlUI2");
      SmallScreenService localSmallScreenService = (SmallScreenService)this.this$0.mContext.get();
      if (localSmallScreenService != null)
      {
        localIntent.setPackage(this.this$0.mApp.getApplication().getPackageName());
        localSmallScreenService.sendBroadcast(localIntent);
        this.this$0.jg(true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  public void m(long paramLong, int paramInt)
  {
    boolean bool = true;
    if (paramLong == this.this$0.mSelfUin) {
      return;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      this.this$0.jf(bool);
      return;
      if (paramInt != 0) {
        break;
      }
      bool = false;
    }
  }
  
  public void o(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteSomeoneEnter-->firstUin=" + paramLong + " length=" + paramInt);
    }
    super.o(paramLong, paramInt);
    this.this$0.a(paramLong, 68, true, -1);
  }
  
  public void onServiceConnected()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onServiceConnected");
    }
    super.onServiceConnected();
    if (this.this$0.bJ() != 0L)
    {
      int i = this.this$0.mUinType;
      Object localObject = String.valueOf(this.this$0.bJ());
      this.this$0.mApp.T(i, (String)localObject);
      if ((this.this$0.n != null) && (this.this$0.n.length == 0) && (this.this$0.mUinType == 3000) && (this.this$0.mType == 0))
      {
        localObject = this.this$0.mApp.a((String)localObject);
        if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject != null))
        {
          this.this$0.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
          this.this$0.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false);
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void p(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onFirstFrameDataComeIn");
    }
    paramInt = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().b(paramLong, paramInt);
    if ((paramInt != -1) && (((ioa)this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(paramInt)).Tp)) {}
    this.this$0.jJ("onFirstFrameDataComeIn");
  }
  
  public void y(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.this$0.aqW();
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QX = true;
    if (this.this$0.mUinType == 1) {
      this.this$0.mApp.ak(this.this$0.bJ());
    }
  }
  
  public void z(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onEnterRoomSuc-->GroupID=" + paramLong2);
    }
    this.this$0.aqW();
    this.this$0.mApp.getHandler().postDelayed(new AutoCheckVideoRunnable(), 500L);
  }
  
  class AutoCheckVideoRunnable
    implements Runnable
  {
    AutoCheckVideoRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "AutoCheckVideoRunnable");
      }
      if (SmallScreenMultiVideoControlUI.1.this.this$0.a != null) {
        SmallScreenMultiVideoControlUI.1.this.this$0.a.b().QX = true;
      }
      SmallScreenMultiVideoControlUI.1.this.this$0.ara();
      if ((SmallScreenMultiVideoControlUI.1.this.this$0.mUinType == 1) && (SmallScreenMultiVideoControlUI.1.this.this$0.mApp != null)) {
        SmallScreenMultiVideoControlUI.1.this.this$0.mApp.ak(SmallScreenMultiVideoControlUI.1.this.this$0.bJ());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */