package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import igv;
import iid;
import iiv;
import ioa;
import ivm;
import ivv;
import iwq;
import iwu;
import iya;
import iym;
import iyn;
import iyo;
import iyq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import jcr;
import jds;
import jgg;
import jjc;
import jko;
import jkz;
import jll;
import mqq.app.BaseActivity;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  boolean Ox = false;
  String Rm = null;
  String Rn = null;
  public boolean Wk = false;
  public boolean Wl = false;
  QueryPeerVideoRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable = new QueryPeerVideoRunnable();
  jcr jdField_a_of_type_Jcr = null;
  jko jdField_a_of_type_Jko = null;
  iid b;
  Runnable bD = null;
  ImageView gr = null;
  TextView mC = null;
  public long mSelfUin = Long.valueOf(this.Rn).longValue();
  public long ow;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, iya paramiya)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramiya);
    this.jdField_b_of_type_Iid = new iyn(this);
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if ((paramVideoAppInterface.PY) || (paramVideoAppInterface.PZ)) {
      paramVideoAppInterface.e(-1033L, "DoubleVideoMeetingCtrlUI", 4);
    }
    for (;;)
    {
      paramVideoAppInterface.uinType = 0;
      paramVideoAppInterface.MO = this.mApp.getDisplayName(0, paramVideoAppInterface.peerUin, null);
      return;
      paramVideoAppInterface.e(-1033L, "DoubleVideoMeetingCtrlUI", 3);
    }
  }
  
  private void asy()
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (localiiv.uinType == -1) {
      localiiv.uinType = 0;
    }
    if (TextUtils.isEmpty(localiiv.peerUin)) {
      localiiv.peerUin = String.valueOf(this.ow);
    }
    int i = localiiv.uinType;
    String str1 = localiiv.peerUin;
    Bitmap localBitmap = this.mApp.a(i, str1, null, true, true);
    String str2 = this.mApp.getDisplayName(i, str1, null);
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "updateHeadBitmap, uinType[" + i + "], peerUin[" + str1 + "], name[" + str2 + "]");
    }
    if (this.gr == null) {
      this.gr = ((ImageView)this.mRootView.findViewById(2131373989));
    }
    if (this.mC == null) {
      this.mC = ((TextView)this.mRootView.findViewById(2131373990));
    }
    this.gr.setImageBitmap(localBitmap);
    if (!TextUtils.equals(this.mC.getText().toString(), str2))
    {
      this.mC.setText(str2);
      this.jdField_a_of_type_Jko.a(localiiv.sessionId, str2, localBitmap, String.valueOf(localiiv.ll), 48, 0, localiiv.amI);
    }
  }
  
  public void E(long paramLong, int paramInt)
  {
    c(paramLong, 360 - paramInt);
  }
  
  public void E(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "updateWhenCreateOrEnterRoomSuc, seq[" + paramLong + "], create[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    iiv localiiv;
    do
    {
      return;
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      localiiv.R("onEnterRoomSuc", true);
      localiiv.QX = true;
      if (TextUtils.isEmpty(localiiv.peerUin)) {
        localiiv.peerUin = String.valueOf(localiiv.ll);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, 0, true, true, localiiv.peerUin);
      asB();
      AVActivity localAVActivity = (AVActivity)this.mContext.get();
      if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
        localAVActivity.runOnUiThread(new DoubleVideoMeetingCtrlUI.6(this, localAVActivity, paramBoolean, paramLong));
      }
    } while (!localiiv.Rr);
    this.mApp.getHandler().postDelayed(new DoubleVideoMeetingCtrlUI.7(this, paramLong), 500L);
  }
  
  public void G(long paramLong, int paramInt)
  {
    TraeHelper.a().dN(paramLong);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().QE) {
      super.dE(paramLong);
    }
    this.Ox = true;
    this.jdField_a_of_type_ComTencentAvVideoController.b(paramLong, this.ow, true, paramInt);
    super.dD(paramLong);
    jg(true);
    anot.a(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
  }
  
  public void a(long paramLong, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onClick, id[" + AudioHelper.b(paramView, paramView.getId()) + "], seq[" + paramLong + "]");
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    String str = localiiv.peerUin;
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "Error View Id.ID=" + paramView.getId());
      }
    case 2131373931: 
    case 2131373933: 
    case 2131697526: 
    case 2131374249: 
    case 2131697530: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              d(paramLong, paramView);
              return;
              h(paramLong, paramView);
              return;
              QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
              if (QLog.isColorLevel()) {
                QLog.i("double_2_multi", 2, "onClick in meeting");
              }
              DoubleVideoCtrlUI.a(a(), this.mApp, true);
              super.dE(paramLong);
              anot.a(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
            } while (!ivv.tY());
            paramView = (Context)this.mContext.get();
          } while ((paramView == null) || (!(paramView instanceof AVActivity)));
          paramView = (AVActivity)paramView;
        } while (paramView == null);
        paramView = paramView.a();
      } while (paramView == null);
      paramView.aqT();
      return;
    case 2131364460: 
    case 2131365755: 
    case 2131374248: 
      ava();
      return;
    case 2131373941: 
    case 2131373942: 
      QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.HANG_UP");
      kl(true);
      a(paramLong, localiiv, 1);
      return;
    case 2131373947: 
      c(paramLong, paramView);
      return;
    case 2131373939: 
      QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.HAND_FREE");
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.nQ(TraeHelper.aBg);
      if ((localiiv.QB) && (localiiv.aK != null)) {
        anot.a(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.dE(paramLong);
        return;
        anot.a(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
    case 2131373944: 
      QLog.d(this.TAG, 1, "avideo onClick QavPanel.ViewID.HIDE");
      onBackPressed();
      anot.a(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (localiiv.PY)
      {
        anot.a(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      anot.a(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
    case 2131374253: 
      QLog.w(this.TAG, 1, "onClick, switch_camera, seq[" + paramLong + "]");
      this.mApp.l(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      return;
    case 2131373946: 
      QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
      int i = localiiv.uinType;
      paramView = localiiv.MO;
      this.jdField_a_of_type_ComTencentAvVideoController.c(i, str, paramView, null, true);
      return;
    case 2131697534: 
      i(paramLong, paramView);
      return;
    }
    g(paramLong, paramView);
  }
  
  @TargetApi(21)
  public void a(long paramLong, iiv paramiiv, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "closeChat, from[" + paramInt + "], session[" + paramiiv + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(VideoConstants.EmShareOps.STOP);
    }
    localObject = a();
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((jds)localObject).stop(1);
      }
      localObject = this.jdField_a_of_type_Jcr;
      if ((paramiiv.Ra) || (localObject == null)) {
        break label250;
      }
      i = j;
      switch (paramInt)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label233;
      }
      this.mApp.getHandler().postDelayed(new DoubleVideoMeetingCtrlUI.4(this, paramLong, i), 1000L);
      return;
      localObject = ((AVActivity)localObject).a();
      break;
      paramiiv.C(paramLong, 0L);
      i = 12;
      lQ(43);
      continue;
      paramiiv.C(paramLong, 0L);
      lQ(3);
      i = 3;
    }
    label233:
    ((jcr)localObject).a(new iyq(this, paramLong, i));
    return;
    label250:
    G(paramLong, 0);
  }
  
  void aqW()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "resumeUI");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qx) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.ss()) {
      super.mY(2131373947);
    }
    for (;;)
    {
      mo(this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
      return;
      super.mZ(2131373947);
    }
  }
  
  public void asA()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "cancelNotification");
    }
    if (this.jdField_a_of_type_Jko != null) {
      this.jdField_a_of_type_Jko.cancelNotification(this.jdField_a_of_type_ComTencentAvVideoController.b().sessionId);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.alM();
  }
  
  public void asB()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "showNotification quit[" + this.Ox + "], inMeetingRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.b().Qx + "]");
        }
      } while ((this.Ox) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qx) || (igv.a().sk()));
      String str = this.jdField_a_of_type_ComTencentAvVideoController.b().MO;
      Bitmap localBitmap = this.mApp.a(0, this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin, null, true, true);
      this.jdField_a_of_type_Jko.a(this.jdField_a_of_type_ComTencentAvVideoController.b().sessionId, str, localBitmap, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().ll), 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
    } while (this.jdField_a_of_type_Jko == null);
    this.jdField_a_of_type_ComTencentAvVideoController.alL();
  }
  
  void asr()
  {
    super.auR();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Jks);
  }
  
  void ass()
  {
    kl(true);
    if (this.jdField_a_of_type_Jcr != null) {
      this.jdField_a_of_type_Jcr.a(new iym(this));
    }
  }
  
  public void asz()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "request peer video");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "requestPeerVideo-->ERROR mVideoControl is NULL");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "Peer VideoInfoList Size is null");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.ck("Meeting_requestPeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().ih.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size())
    {
      if (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i)).uin != this.mSelfUin) {
        this.jdField_a_of_type_ComTencentAvVideoController.b().ih.add(this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i));
      }
      i += 1;
    }
    jE(false);
    this.jdField_a_of_type_ComTencentAvVideoController.F(false);
  }
  
  boolean az(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong, "checkRemoteHasVideo.1", false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() == 1) && (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).uin == this.mSelfUin))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong, "checkRemoteHasVideo.2", false, true);
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong, "checkRemoteHasVideo.3", true, true);
    return true;
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "refreshUI, relationId[" + paramLong2 + "], friendUin[" + paramLong3 + "], refreshType[" + paramInt + "], isAVActivityBackground[" + this.jdField_a_of_type_ComTencentAvVideoController.b().Ra + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().Ra) {}
    RefreshUIRunnable localRefreshUIRunnable;
    AVActivity localAVActivity;
    do
    {
      return;
      localRefreshUIRunnable = new RefreshUIRunnable(paramLong1, paramInt, paramLong3, paramLong2);
      localAVActivity = (AVActivity)this.mContext.get();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "refreshUI-->Can not get AVActivity");
    return;
    localAVActivity.runOnUiThread(localRefreshUIRunnable);
  }
  
  void b(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "showOrClosePeerVideo, bShow[" + paramBoolean + "], videoSrcType[" + paramInt + "], friendUin[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    az(paramLong1);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ) {
      kb("showOrClosePeerVideo");
    }
    if (paramBoolean)
    {
      ka("showOrClosePeerVideo");
      return;
    }
    ioa localioa = new ioa();
    localioa.uin = paramLong2;
    localioa.videoSrcType = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localioa);
    this.c.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if (paramInt == 2) {
      iwu.a(this.mApp, 1036);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0)
    {
      ka("showOrClosePeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong1, "showOrClosePeerVideo", false, true);
    mo(this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
  }
  
  public void bZ(long paramLong) {}
  
  void c(long paramLong, View paramView)
  {
    int i;
    if (a(paramLong, "android.permission.RECORD_AUDIO", null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.ss();
      kv(bool);
      if (!bool) {
        break label148;
      }
      i = this.jdField_a_of_type_ComTencentAvVideoController.kB();
      this.jdField_a_of_type_ComTencentAvVideoController.e("DoubleVideoMeetingCtrlUI.doMute.1", this.ow, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoMeetingCtrlUI.doMute.1", i, this.jdField_a_of_type_ComTencentAvVideoController.kB(), false);
      super.mZ(2131373947);
      if (this.mApp != null) {
        this.mApp.l(new Object[] { Integer.valueOf(108) });
      }
      anot.a(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.dE(paramLong);
      return;
      label148:
      i = this.jdField_a_of_type_ComTencentAvVideoController.kB();
      this.jdField_a_of_type_ComTencentAvVideoController.e("DoubleVideoMeetingCtrlUI.doMute.2", this.ow, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoMeetingCtrlUI.doMute.2", i, this.jdField_a_of_type_ComTencentAvVideoController.kB(), false);
      super.mY(2131373947);
      if (this.mApp != null) {
        this.mApp.l(new Object[] { Integer.valueOf(109) });
      }
      anot.a(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
    }
  }
  
  public void c(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onVideoViewChange-->BigViewUin = " + paramString1 + " ,BigViewVideoSrcType = " + paramInt1 + " ,SmallViewUin = " + paramString2 + " ,SmallViewVideoSrcType = " + paramInt2);
    }
    long l1 = jjc.A(paramString1);
    long l2 = jjc.A(paramString2);
    if ((l1 == 0L) || (l2 == 0L)) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 2) {
          iwu.a(this.mApp, 1036);
        }
        paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.b().b(l1, paramInt1);
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.b().b(l2, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onVideoViewChange-->BigViewIndex = " + paramInt1 + " ,SmallViewIndex = " + paramInt2);
        }
      } while ((paramInt1 == -1) || (paramInt2 == -1));
      paramString1 = (ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(paramInt1);
      paramString2 = (ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(paramInt2);
      paramString2.Tp = true;
      paramString1.Tp = false;
      this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.set(paramInt1, paramString2);
      this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.set(paramInt2, paramString1);
      if (QLog.isColorLevel())
      {
        ??? = this.jdField_a_of_type_ComTencentAvVideoController.f(this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if);
        QLog.d(this.TAG, 2, "onVideoViewChange finish" + (String)???);
      }
      synchronized (this.jdField_a_of_type_ComTencentAvVideoController.b().ig)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().ig.set(paramInt1, paramString2);
        this.jdField_a_of_type_ComTencentAvVideoController.b().ig.set(paramInt2, paramString1);
        this.jdField_a_of_type_ComTencentAvVideoController.b().amI();
        ((AVActivity)this.mContext.get()).b.b(paramString1.uin, paramString1.videoSrcType, paramString2.uin, paramString2.videoSrcType);
        asz();
        if (l2 == this.mSelfUin)
        {
          anot.a(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
          return;
        }
      }
    } while (l2 != this.ow);
    anot.a(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
    if (this.Wk)
    {
      anot.a(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
  }
  
  void cL(long paramLong)
  {
    Object localObject = (AVActivity)this.mContext.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "processExtraData-->can not get the activity");
      }
      jg(true);
    }
    do
    {
      return;
      localObject = ((AVActivity)localObject).getIntent();
      boolean bool = false;
      if (localObject != null) {
        bool = ((Intent)localObject).getBooleanExtra("isEnter", false);
      }
      localObject = igv.a(100, String.valueOf(this.ow), new int[0]);
      localObject = igv.a().c((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "processExtraData uin[" + this.ow + "], info[" + localObject + "]");
      }
      if ((bool) || ((localObject != null) && (((iiv)localObject).tc())))
      {
        TraeHelper.a().dN(paramLong);
        TraeHelper.a();
        TraeHelper.t(this.mApp);
        if ((localObject != null) && (((iiv)localObject).state == 0))
        {
          jg(true);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, this.ow, null, false);
        P(paramLong, 2131697696);
        return;
      }
    } while ((localObject != null) && (((iiv)localObject).state != 0));
    this.jdField_a_of_type_ComTencentAvVideoController.a(3, this.ow, 8, new long[] { this.ow }, false);
    P(paramLong, 2131698074);
  }
  
  public void cU(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onStart, seq[" + paramLong + "]");
    }
    super.cU(paramLong);
  }
  
  public void cV(long paramLong)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onResume, seq[" + paramLong + "]");
    }
    super.cV(paramLong);
    refreshUI();
    jkz localjkz;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().Ra = false;
      this.jdField_a_of_type_ComTencentAvVideoController.b().isBackground = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qx)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().td()) {
          super.dC(paramLong);
        }
        localjkz = this.jdField_a_of_type_Jkz;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 3) {
          break label189;
        }
        bool1 = true;
        localjkz.lj(bool1);
        localjkz = this.jdField_a_of_type_Jkz;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 3) {
          break label194;
        }
      }
    }
    label189:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localjkz.li(bool1);
      resumeVideo();
      aqW();
      this.mApp.T(0, this.Rm);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void cW(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onStop, seq[" + paramLong + "]");
    }
    super.cW(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.b().Ra = true;
    }
  }
  
  public int cv(int paramInt)
  {
    DoubleVideoCtrlUI.b(this.mApp, paramInt);
    return 0;
  }
  
  void d(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", null))
    {
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
      paramView.Rr = false;
      if (paramView.PY) {
        break label123;
      }
      da(paramLong);
      this.mApp.l(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "onClick, Open Camera, seq[" + paramLong + "]");
      }
    }
    for (;;)
    {
      dE(paramLong);
      S(paramLong, 2131697526);
      return;
      label123:
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "onClick, Close Camera, seq[" + paramLong + "]");
      }
      bZ(paramLong);
      this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      df(paramLong);
    }
  }
  
  public void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (isDestroyed()) {}
    do
    {
      iiv localiiv;
      do
      {
        do
        {
          return;
          localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
        } while (localiiv.Ra);
        O(paramLong, 65535);
        if (!paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "Go On Stage onAfterOpenCamera");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.sv();
        if ((paramInt == 3) && (!localiiv.QB) && ("DEVICE_EARPHONE".equals(localiiv.deviceName))) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axK();
        }
      } while ((localiiv.PZ) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      mo(localiiv.amI);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "Open Camera Failed");
  }
  
  public void da(long paramLong)
  {
    O(paramLong, 65535);
  }
  
  public void de(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onPause, seq[" + paramLong + "], quit[" + this.Ox + "]");
    }
    super.de(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().Ra = true;
      this.jdField_a_of_type_ComTencentAvVideoController.b().isBackground = true;
      if (((!ivv.tY()) || ((!aqiw.isWifiConnected((Context)this.mContext.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rb))) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PY))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.alO();
        this.c.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374253, 8);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qb = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qx) {
        super.dD(paramLong);
      }
      kb("OnPause");
      if ((this.Ox) || (!ivv.tY())) {
        this.jdField_a_of_type_ComTencentAvVideoController.ck("Meeting_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, true, true);
    }
    this.mApp.iw("DoubleVideoMeetingCtrlUI");
    this.mApp.getHandler().removeCallbacks(this.cc);
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
  }
  
  public void df(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.alO();
    O(paramLong, 65535);
  }
  
  public void f(long paramLong, ArrayList<ioa> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "notifyShowVideo-->info list is null");
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if ((((ioa)paramArrayList.get(i)).uin == this.mSelfUin) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.c.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        if (this.gr.getVisibility() != 0) {
          break;
        }
        mo(this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
        return;
      }
      i += 1;
    }
  }
  
  public void g(long paramLong, View paramView)
  {
    super.g(paramLong, paramView);
    jll.kQ("0x800AD8D");
  }
  
  protected int getLayout()
  {
    return 2131559894;
  }
  
  void initUI()
  {
    super.initUI();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.mG(2131559948);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.atX();
      Activity localActivity = (Activity)this.mContext.get();
      if (localActivity != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_Jkz = jkz.a(this.jdField_a_of_type_Jkz, localActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_Jkz.lh(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
      }
    }
    this.gK = ((ImageView)this.mRootView.findViewById(2131373969));
    if ((AVActivity)this.mContext.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "initUI-->activity is null");
      }
      jg(true);
      return;
    }
    this.jdField_a_of_type_Jcr = new jcr((Context)this.mContext.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.er, null, this.mRootView.findViewById(2131373988), this.mC, this.mRootView.findViewById(2131374119), null);
  }
  
  void jD(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "quitDoubleVideoMeeting, needAnimation[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean)
    {
      asr();
      this.jdField_a_of_type_ComTencentAvVideoController.b(l, this.ow, false, 2);
      this.Ox = true;
    }
  }
  
  void jE(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showOrHideAcceptBtn-->isShow = " + paramBoolean);
    }
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.a(paramBoolean, new iyo(this));
    }
    if (paramBoolean)
    {
      iwu.b(this.mApp, 1030);
      return;
    }
    iwu.a(this.mApp, 1030);
  }
  
  public void jI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addRequestVideoTimeoutRunnable,Function = " + paramString);
    }
    if (this.bD == null) {
      this.bD = new RequestVideoTimeoutRunnale();
    }
    for (;;)
    {
      this.mApp.getHandler().postDelayed(this.bD, 30000L);
      return;
      this.mApp.getHandler().removeCallbacks(this.bD);
    }
  }
  
  public void jg(boolean paramBoolean)
  {
    this.Ox = paramBoolean;
    this.mApp.l(new Object[] { Integer.valueOf(28), String.valueOf(this.ow), Boolean.valueOf(paramBoolean) });
    if (this.Ox) {
      asA();
    }
  }
  
  void ka(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable.QJ = paramString;
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
    this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable, 1000L);
  }
  
  public void kb(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "removeRequestVideoTimeoutRunnbale-->Function = " + paramString);
    }
    if (this.bD != null) {
      this.mApp.getHandler().removeCallbacks(this.bD);
    }
  }
  
  void lM(int paramInt)
  {
    if (paramInt > 0) {
      P(-1016L, paramInt);
    }
  }
  
  public void mj(int paramInt)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "showToolBars, isAllOnstageMembersNotRecvData[" + this.jdField_a_of_type_ComTencentAvVideoController.b().tj() + "], mToolbarDisplay[" + this.Ya + "], session[" + this.jdField_a_of_type_ComTencentAvVideoController.b() + "], seq[" + l + "]");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().tj())
    {
      super.ml(paramInt);
      dE(l);
    }
  }
  
  public void mk(int paramInt) {}
  
  void mo(int paramInt)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "avSwitch, sessionType[" + paramInt + "], seq[" + l + "]");
    }
    View localView = this.mRootView.findViewById(2131366049);
    AVActivity localAVActivity = (AVActivity)this.mContext.get();
    boolean bool1;
    if (paramInt == 3)
    {
      this.gr.setVisibility(0);
      this.mC.setVisibility(0);
      this.eq.setVisibility(8);
      if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.nl(0);
      }
      auV();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.ka(false);
      if (localAVActivity == null) {
        break label337;
      }
      localAVActivity.jm(true);
      localAVActivity.jq(true);
      localAVActivity.jn(false);
      bool1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 3) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        this.jdField_a_of_type_Jkz.lj(bool2);
        this.jdField_a_of_type_Jkz.li(bool2);
        g(Boolean.valueOf(bool1));
        O(l, 65535);
        this.mApp.l(new Object[] { Integer.valueOf(102) });
        return;
        if (paramInt != 4) {
          break label337;
        }
        localView.setBackgroundColor(this.mRes.getColor(2131167595));
        this.gr.setVisibility(8);
        this.mC.setVisibility(8);
        this.eq.setVisibility(0);
        if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.nl(8);
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.ka(true);
        if (localAVActivity != null)
        {
          localAVActivity.jm(false);
          localAVActivity.jq(false);
          localAVActivity.jn(true);
        }
        bool1 = true;
        break;
      }
      label337:
      bool1 = false;
    }
  }
  
  public void mp(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onLayoutModeChange --> ScreenType = " + paramInt + " , hasSetBigVideoView = " + this.jdField_a_of_type_ComTencentAvVideoController.b().tl());
    }
    Iterator localIterator;
    ioa localioa;
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel())
      {
        localIterator = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.iterator();
        while (localIterator.hasNext())
        {
          localioa = (ioa)localIterator.next();
          if (!localioa.Tp) {
            localioa.Tq = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0) {
        ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tq = true;
      }
    }
    for (;;)
    {
      asz();
      return;
      if (paramInt == 4)
      {
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().tl()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0))
        {
          ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tp = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
          }
        }
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel())
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.iterator();
          while (localIterator.hasNext())
          {
            localioa = (ioa)localIterator.next();
            if (!localioa.Tp) {
              localioa.Tq = true;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0)
        {
          ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tq = true;
        }
      }
    }
  }
  
  public boolean onBackPressed()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
    this.mApp.l(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if (!ivv.tY()) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
        super.s(2131697686, 1, this.mRes.getDimensionPixelSize(2131299627));
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          localObject = (Context)this.mContext.get();
        } while ((localObject == null) || (!(localObject instanceof AVActivity)));
        localObject = (AVActivity)localObject;
      } while (localObject == null);
      localObject = ((AVActivity)localObject).a();
    } while (localObject == null);
    ((ivm)localObject).onBackPressed();
    return false;
  }
  
  public void onCreate()
  {
    int i = 1;
    Object localObject = (BaseActivity)this.mContext.get();
    if (localObject == null) {}
    for (;;)
    {
      return;
      super.onCreate();
      long l = AudioHelper.hG();
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "onCreate, SessionType[" + localiiv.amI + "], localHasVideo[" + localiiv.PY + "], seq[" + l + "]");
      }
      if (localiiv.Rq)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "onCreate, localMute[" + localiiv.PV + "], localHasVideo[" + localiiv.PY + "], hasLocalVideoWhenSwitch[" + localiiv.Rr + "], deviceName[" + localiiv.deviceName + "]");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.M("switch2DoubleMeeting_onCreate", localiiv.PV);
        VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
        if (localiiv.PV) {
          localVideoController.V("switch2DoubleMeeting_onCreate", i);
        }
      }
      else
      {
        initUI();
        N(l, localiiv.Rq);
        this.mApp.addObserver(this.jdField_b_of_type_Iid);
        this.Rm = localiiv.peerUin;
      }
      try
      {
        this.ow = Long.valueOf(this.Rm).longValue();
        this.jdField_a_of_type_Jko = jko.a(this.mApp);
        cL(l);
        asy();
        if (this.jdField_a_of_type_Jcr != null) {
          this.jdField_a_of_type_Jcr.atK();
        }
        if (!(localObject instanceof AVActivity)) {
          continue;
        }
        localObject = (AVActivity)localObject;
        if (((AVActivity)localObject).a == null) {
          continue;
        }
        ((AVActivity)localObject).a.nw(3);
        return;
        i = 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          igd.aL(this.TAG, localNumberFormatException.getMessage());
        }
      }
    }
  }
  
  public void onDestroy(long paramLong)
  {
    QLog.w(this.TAG, 1, "onDestroy, seq[" + paramLong + "]");
    this.mApp.deleteObserver(this.jdField_b_of_type_Iid);
    this.jdField_a_of_type_Jkz.lj(false);
    this.jdField_a_of_type_Jkz.li(false);
    if (this.mRootView != null) {
      this.mRootView.removeAllViews();
    }
    if (this.jdField_a_of_type_Jcr != null)
    {
      this.jdField_a_of_type_Jcr.destroy();
      this.jdField_a_of_type_Jcr = null;
    }
    super.onDestroy(paramLong);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 24: 
    case 25: 
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().PY)
    {
      anot.a(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    anot.a(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  public void refreshUI()
  {
    super.refreshUI();
    asy();
  }
  
  void resumeVideo()
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    boolean bool = localiiv.PZ;
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "resumeVideo, remoteHasVideo[" + bool + "], displayViewList[" + localiiv.jdField_if.size() + "], seq[" + l + "], \nsessionInfo[" + localiiv + "]");
    }
    if ((localiiv.amI == 4) && (!localiiv.PY) && ((localiiv.jdField_if.size() == 0) || (!bool)))
    {
      localiiv.e(l, "resumeVideo", 3);
      QLog.w(this.TAG, 1, "resumeVideo, fix SessionType");
    }
    ArrayList localArrayList = new ArrayList();
    ioa localioa = new ioa();
    localioa.uin = Long.valueOf(localiiv.peerUin).longValue();
    localioa.videoSrcType = 1;
    localArrayList.add(localioa);
    localioa = new ioa();
    localioa.uin = Long.valueOf(localiiv.peerUin).longValue();
    localioa.videoSrcType = 2;
    localArrayList.add(localioa);
    this.c.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if ((localiiv.b(this.mSelfUin, 1) == -1) || (localiiv.PY))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.sv();
    }
    if ((localiiv.PY) && (!localiiv.PZ)) {
      this.Wl = true;
    }
    if (localiiv.jdField_if.size() > 0) {
      asz();
    }
    auV();
  }
  
  public void s(long paramLong, boolean paramBoolean)
  {
    if (isDestroyed()) {
      return;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (!localiiv.PZ)
    {
      mo(localiiv.amI);
      return;
    }
    O(paramLong, 65535);
  }
  
  protected boolean wd()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = this.jdField_a_of_type_ComTencentAvVideoController.b().td();
      bool2 = this.jdField_a_of_type_ComTencentAvVideoController.b().te();
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  class QueryPeerVideoRunnable
    implements Runnable
  {
    public String QJ;
    
    QueryPeerVideoRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d(DoubleVideoMeetingCtrlUI.this.TAG, 2, "QueryPeerVideoRunnable-->Function Name = " + this.QJ);
      }
      DoubleVideoMeetingCtrlUI.this.asz();
    }
  }
  
  class RefreshUIRunnable
    implements Runnable
  {
    long friendUin;
    long ll;
    int refreshType;
    long seq = 0L;
    
    public RefreshUIRunnable(long paramLong1, int paramInt, long paramLong2, long paramLong3)
    {
      this.seq = paramLong1;
      this.friendUin = paramLong2;
      this.refreshType = paramInt;
      this.ll = paramLong3;
    }
    
    private void g(int paramInt, long paramLong1, long paramLong2)
    {
      if (paramInt == 1) {
        DoubleVideoMeetingCtrlUI.this.b(this.seq, true, 1, paramLong1);
      }
      do
      {
        do
        {
          return;
          if (paramInt == 2)
          {
            DoubleVideoMeetingCtrlUI.this.b(this.seq, false, 1, paramLong1);
            return;
          }
          if (paramInt == 3)
          {
            DoubleVideoMeetingCtrlUI.this.b(this.seq, true, 2, paramLong1);
            return;
          }
          if (paramInt == 4)
          {
            DoubleVideoMeetingCtrlUI.this.b(this.seq, false, 2, paramLong1);
            return;
          }
          if (paramInt == 5)
          {
            DoubleVideoMeetingCtrlUI.this.M(this.seq, false);
            DoubleVideoMeetingCtrlUI.this.z(this.seq, null);
            DoubleVideoMeetingCtrlUI.c(DoubleVideoMeetingCtrlUI.this, this.seq);
            return;
          }
          if (paramInt != 6) {
            break;
          }
        } while (paramLong1 == DoubleVideoMeetingCtrlUI.this.mSelfUin);
        DoubleVideoMeetingCtrlUI.this.jD(true);
        return;
      } while (!QLog.isColorLevel());
      QLog.w(DoubleVideoMeetingCtrlUI.this.TAG, 1, "refreshUI, ERROR, refreshType[" + paramInt + "], friendUin[" + paramLong1 + "], seq[" + this.seq + "]");
    }
    
    public void run()
    {
      if (DoubleVideoMeetingCtrlUI.this.isDestroyed()) {
        return;
      }
      g(this.refreshType, this.friendUin, this.ll);
    }
  }
  
  class RequestVideoTimeoutRunnale
    implements Runnable
  {
    RequestVideoTimeoutRunnale() {}
    
    public void run()
    {
      if (DoubleVideoMeetingCtrlUI.this.a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(DoubleVideoMeetingCtrlUI.this.TAG, 2, "RequestVideoTimeoutRunnale-->VideoControl is null");
        }
        return;
      }
      DoubleVideoMeetingCtrlUI.this.a.ck("Meeting_RequestVideoTimeoutRunnale");
      DoubleVideoMeetingCtrlUI.this.jE(true);
      iwu.a(DoubleVideoMeetingCtrlUI.this.mApp, 1036);
      iwu.a(DoubleVideoMeetingCtrlUI.this.mApp, 1037);
      DoubleVideoMeetingCtrlUI.this.a.b().b(DoubleVideoMeetingCtrlUI.this.mSelfUin, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */