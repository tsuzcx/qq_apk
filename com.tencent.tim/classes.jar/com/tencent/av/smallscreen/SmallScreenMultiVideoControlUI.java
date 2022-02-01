package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqiw;
import atan;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iid;
import iiv;
import iiv.a;
import iiv.b;
import ioa;
import irc;
import ivn;
import iwu;
import iya;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jjp;
import jko;
import jll;

public class SmallScreenMultiVideoControlUI
  extends SmallScreenVideoControlUI
{
  static int auk;
  String QI = null;
  atan jdField_a_of_type_Atan = null;
  StartRecvVideoRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable = new StartRecvVideoRunnable();
  iid jdField_a_of_type_Iid = new SmallScreenMultiVideoControlUI.1(this);
  jko jdField_a_of_type_Jko = null;
  int aqx = 0;
  Runnable bC = null;
  Runnable bD = null;
  Runnable bE = null;
  Runnable bF = null;
  boolean mQuit = false;
  long mSelfUin = 0L;
  int mType = -1;
  int mUinType = -1;
  long[] n = null;
  
  static
  {
    int i = 16;
    auk = 16;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      auk = i;
      return;
      i = 9;
    }
  }
  
  public SmallScreenMultiVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, iya paramiya)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramiya);
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "drawUI, type[" + paramInt1 + "], uin[" + paramLong + "], fresh[" + paramBoolean + "], originalType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    label153:
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.mSelfUin) && (this.jdField_a_of_type_ComTencentAvVideoController.b().QX) && (this.jdField_a_of_type_ComTencentAvVideoController.b().anb != 2)) {
        TraeHelper.a().a(l, this.mApp, 2131230749, null, 0, null);
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label391;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().state != 9) {
        break label375;
      }
      localObject2 = this.mRes.getString(2131698090);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.sw())
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf.equals("1"))) {
          break label361;
        }
        localObject1 = localObject2;
      }
      label256:
      if (this.mTitleView != null) {
        this.mTitleView.setText((CharSequence)localObject1);
      }
      if (this.VB) {
        this.VC = true;
      }
      jll.b(this.mTitleView, (String)localObject1);
      label293:
      notifyDataChange();
    }
    for (;;)
    {
      label297:
      arc();
      return;
      if ((paramInt1 != 1) || (paramLong == this.mSelfUin) || (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2) || (!this.jdField_a_of_type_ComTencentAvVideoController.sx())) {
        break label153;
      }
      TraeHelper.a().a(l, this.mApp, 2131230750, null, 0, null);
      break label153;
      label361:
      localObject1 = this.mRes.getString(2131698080);
      break label256;
      label375:
      if (paramInt1 != 0) {
        break label293;
      }
      this.VC = false;
      startTimer();
      break label293;
      label391:
      if ((paramInt1 != 68) && (paramInt1 != 82))
      {
        if ((paramInt1 == 5) || (paramInt1 == 6))
        {
          paramInt2 = 0;
          paramBoolean = true;
          if (paramLong == this.mSelfUin) {
            paramInt2 = 1;
          }
          if (paramInt1 == 6)
          {
            boolean bool = vE();
            paramBoolean = bool;
            if (paramInt2 != 0)
            {
              paramBoolean = bool;
              if (!this.jdField_a_of_type_ComTencentAvVideoController.b().isBackground)
              {
                this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
                paramBoolean = bool;
              }
            }
          }
          if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().QX) || (!paramBoolean)) {
            continue;
          }
          if (this.auE >= 4) {
            break;
          }
          if ((aqiw.isWifiConnected((Context)this.mContext.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.b().Rb))
          {
            if (paramInt2 == 0)
            {
              this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
              continue;
            }
            paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, 1);
            int i = this.jdField_a_of_type_ComTencentAvVideoController.b().kK();
            if (QLog.isColorLevel()) {
              QLog.d("SmallScreenMultiVideoControlUI", 2, "onSelfVideoIn.-->FirstVideo=" + i + ",index=" + paramInt2);
            }
            if ((i != -1) && ((paramInt2 != i) || (paramInt2 == 0))) {
              continue;
            }
            this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
            continue;
          }
          if (paramInt2 != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.1", true, true);
          arb();
          g(true, true, true);
          continue;
        }
        if ((paramInt1 == 7) || (paramInt1 == 8))
        {
          paramBoolean = true;
          if (paramInt1 == 8)
          {
            localObject1 = new ioa();
            ((ioa)localObject1).uin = paramLong;
            ((ioa)localObject1).videoSrcType = 2;
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.jdField_a_of_type_Iya.update(null, new Object[] { Integer.valueOf(104), localObject2 });
          }
          for (;;)
          {
            if (paramInt1 == 8) {
              paramBoolean = vE();
            }
            if (((!this.jdField_a_of_type_ComTencentAvVideoController.b().Qw) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().QX)) || (!paramBoolean)) {
              break label297;
            }
            if (this.auE >= 4) {
              break;
            }
            if ((!aqiw.isWifiConnected((Context)this.mContext.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rb)) {
              break label1125;
            }
            this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
            break label297;
            if (this.aqx == 2) {
              anot.a(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
            }
          }
          label1125:
          this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.2", true, true);
          arb();
          g(true, true, true);
        }
        else if ((paramInt1 == 97) || (paramInt1 == 98))
        {
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          }
        }
        else if (paramInt1 == 10)
        {
          paramBoolean = vE();
          if ((this.jdField_a_of_type_ComTencentAvVideoController.b().QX) && (paramBoolean))
          {
            if (this.auE >= 4) {
              break;
            }
            if ((aqiw.isWifiConnected((Context)this.mContext.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.b().Rb))
            {
              this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.3", true, true);
              arb();
              g(true, true, true);
            }
          }
        }
      }
    }
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin=" + paramLong + " type=" + paramInt1 + " isRefreshTitle=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (paramLong == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin == 0");
      }
    }
    do
    {
      return;
      if (this.mApp != null)
      {
        RefreshUIRunnable localRefreshUIRunnable = new RefreshUIRunnable(paramInt1, paramLong, paramBoolean, paramInt2);
        this.mApp.getHandler().post(localRefreshUIRunnable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->mApp == null");
  }
  
  void aqW()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {}
    long l = bJ();
    this.mApp.T(this.mUinType, String.valueOf(l));
  }
  
  void aqX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData-->mType=" + this.jdField_a_of_type_ComTencentAvVideoController.b().anc + " IntentGroupId=" + this.jdField_a_of_type_ComTencentAvVideoController.b().ll + " isInRoom=" + this.jdField_a_of_type_ComTencentAvVideoController.OB + " mRoomDiscussionId=" + this.jdField_a_of_type_ComTencentAvVideoController.kJ);
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (localiiv != null)
    {
      this.mUinType = localiiv.uinType;
      if (this.mUinType != 3000) {
        break label278;
      }
      this.aqx = 2;
    }
    for (;;)
    {
      if ((localiiv.jdField_a_of_type_Iiv$a.anA > 0) && (localiiv.jdField_a_of_type_Iiv$b.groupId <= 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData sessionInfo.mAnychat_Info.matchStatus = " + localiiv.jdField_a_of_type_Iiv$a.anA);
        }
        if (((localiiv.jdField_a_of_type_Iiv$a.anA == 1) || (localiiv.jdField_a_of_type_Iiv$a.anA == 2)) && (this.mTitleView != null)) {
          this.mTitleView.setText(2131698091);
        }
      }
      this.mType = localiiv.anc;
      this.n = localiiv.f;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData mGroupId = " + bJ());
      }
      return;
      label278:
      if (this.mUinType == 1) {
        this.aqx = 1;
      } else if (this.mUinType == 0) {
        this.aqx = 3;
      } else {
        this.aqx = localiiv.relationType;
      }
    }
  }
  
  void aqY()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "closeRemoteVideo, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.ck("Meeting_closeRemoteVideo");
      this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "closeRemoteVideo", false, true);
      arb();
    }
    jJ("closeRemoteVideo");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_Iya.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if });
    }
  }
  
  void aqZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshGAFList");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) && (QLog.isColorLevel())) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshGAFList-->mVideoContrl is null");
    }
  }
  
  void ara()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoControl is null");
      }
    }
    label230:
    label248:
    do
    {
      int i;
      for (;;)
      {
        return;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.OB)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoController.mGAudioInRoom =" + this.jdField_a_of_type_ComTencentAvVideoController.OB);
          }
        }
        else
        {
          i = this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, 1);
          int j = this.jdField_a_of_type_ComTencentAvVideoController.ky();
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->index=" + i + ", onstageNum=" + j);
          }
          if ((!aqiw.isWifiConnected((Context)this.mContext.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rb)) {
            break;
          }
          if (i != -1)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.ky() >= auk) {
              break label248;
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PY) && (!this.jdField_a_of_type_ComTencentAvVideoController.sv())) {
              break label230;
            }
          }
          while (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0)
          {
            vF();
            return;
            if (QLog.isColorLevel())
            {
              QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->go on stage fail,can not find the session");
              continue;
              this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
              this.jdField_a_of_type_ComTencentAvVideoController.alN();
            }
          }
        }
      }
      if (i != -1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.alN();
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() <= 0);
    this.jdField_a_of_type_ComTencentAvVideoController.b().a(-1023L, "enterOrResumeRemoteOrLocalVideo", true, true);
    arb();
    g(true, true, true);
  }
  
  @SuppressLint({"NewApi"})
  void arb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "switchUIMode, sessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
    }
    this.mApp.l(new Object[] { Integer.valueOf(102) });
  }
  
  void arc()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.sw()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf.equals("1")))
    {
      int k = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$a.anA;
      int j = 0;
      i = j;
      switch (k)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((this.mTitleView != null) && (i != 0)) {
        this.mTitleView.setText(i);
      }
      return;
      i = 2131698082;
      continue;
      i = 2131698090;
    }
  }
  
  long bJ()
  {
    long l = 0L;
    iiv localiiv;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if ((localiiv.jdField_a_of_type_Iiv$a.anA > 0) && (localiiv.jdField_a_of_type_Iiv$b.groupId > 0L)) {
        l = localiiv.jdField_a_of_type_Iiv$b.groupId;
      }
    }
    else
    {
      return l;
    }
    return localiiv.ll;
  }
  
  void cD(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.alO();
    this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong, "goOffStage", false, false);
    this.jdField_a_of_type_Iya.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    arb();
  }
  
  void f(long paramLong, ArrayList<ioa> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        ioa localioa = (ioa)paramArrayList.get(i);
        if ((localioa.uin == this.mSelfUin) && (localioa.videoSrcType == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_Iya.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        return;
      }
      i += 1;
    }
  }
  
  void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      if (this.aqx == 2) {
        if (!aqiw.isWifiConnected((Context)this.mContext.get()))
        {
          anot.a(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
          if (!paramBoolean2) {
            break label230;
          }
          iwu.b(this.mApp, 3013);
        }
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        f(AudioHelper.hG(), this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if);
      }
      return;
      anot.a(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
      break;
      if (this.aqx != 1) {
        break;
      }
      if (aqiw.isWifiConnected((Context)this.mContext.get()))
      {
        anot.a(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
        break;
      }
      anot.a(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
      break;
      label230:
      iwu.a(this.mApp, 3013);
      continue;
      iwu.a(this.mApp, 3013);
      iwu.a(this.mApp, 1030);
    }
  }
  
  protected void initUI()
  {
    super.initUI();
    String str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().state == 9)
    {
      str2 = this.mRes.getString(2131698090);
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.sw()) {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf.equals("1"))) {
          break label156;
        }
      }
    }
    label156:
    for (String str1 = str2;; str1 = this.mRes.getString(2131698080))
    {
      if (this.mTitleView != null) {
        this.mTitleView.setText(str1);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.b().sU()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PV)) {
        this.jdField_a_of_type_ComTencentAvVideoController.e("SmallScreenMultiVideoControlUI.initUI", this.jdField_a_of_type_ComTencentAvVideoController.b().ll, false);
      }
      return;
    }
  }
  
  void jI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Add-->FunctionName=" + paramString);
    }
    if (this.bD != null) {
      this.mApp.getHandler().removeCallbacks(this.bD);
    }
    for (;;)
    {
      this.mApp.getHandler().postDelayed(this.bD, 30000L);
      return;
      this.bD = new RequestVideoTimeOutRunnable();
    }
  }
  
  void jJ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Remove-->FunctionName=" + paramString);
    }
    if (this.bD != null) {
      this.mApp.getHandler().removeCallbacks(this.bD);
    }
  }
  
  public void je(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    super.je(paramBoolean);
    this.mApp.addObserver(this.jdField_a_of_type_Iid);
    aqX();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().sU())
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName;
      TraeHelper.a().a(l, this.QK, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenMultiVideoControlUI", 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.QK + "], deviceName[" + (String)localObject + "], seq[" + l + "]");
      }
      TraeHelper.a().b(l, (String)localObject);
    }
    y(l, paramBoolean);
    arc();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.sw()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf.equals("1")))
    {
      localObject = (ivn)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(0);
      if ((localObject != null) && (((ivn)localObject).a != null))
      {
        ((ivn)localObject).a.setBackgroundResource(2130843117);
        ((ivn)localObject).gp.setVisibility(8);
      }
    }
  }
  
  void jf(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (this.jdField_a_of_type_Atan == null)
    {
      this.jdField_a_of_type_Atan = new atan((Context)this.mContext.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (jjp.cK("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_Atan.a(l, 2, 0, null, jjp.hr() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!jjp.cK("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_Atan.dN(l);
      break;
    }
    this.jdField_a_of_type_Atan.a(l, 2, 0, null, jjp.hr() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  void jg(boolean paramBoolean)
  {
    this.mQuit = paramBoolean;
    this.mApp.l(new Object[] { Integer.valueOf(28), String.valueOf(bJ()), Boolean.valueOf(paramBoolean) });
  }
  
  void notifyDataChange()
  {
    aqZ();
  }
  
  public void onDestroy(long paramLong)
  {
    this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
    this.mApp.getHandler().removeCallbacks(this.bC);
    this.mApp.getHandler().removeCallbacks(this.bD);
    this.mApp.getHandler().removeCallbacks(this.bE);
    this.mApp.getHandler().removeCallbacks(this.bF);
    this.bC = null;
    this.bD = null;
    this.bE = null;
    this.bF = null;
    if (this.jdField_a_of_type_Atan != null)
    {
      this.jdField_a_of_type_Atan.dN(paramLong);
      this.jdField_a_of_type_Atan = null;
    }
    super.onDestroy(paramLong);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.mContext != null) && (!aqiw.isWifiConnected((Context)this.mContext.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() != -1)) {
      this.jdField_a_of_type_ComTencentAvVideoController.ck("Small_onPause");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onResume");
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.OB)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.alI();
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().state != 9) {
          break label223;
        }
        this.VC = true;
        String str2 = this.mRes.getString(2131698090);
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentAvVideoController.sw())
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf.equals("1"))) {
            break label210;
          }
          str1 = str2;
        }
        if (this.mTitleView != null) {
          this.mTitleView.setText(str1);
        }
      }
    }
    for (;;)
    {
      startTimer();
      if (this.jdField_a_of_type_Jko != null) {
        this.jdField_a_of_type_Jko.cancelNotification(this.jdField_a_of_type_ComTencentAvVideoController.b().sessionId);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b().isBackground = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {
        resumeVideo();
      }
      aqW();
      return;
      label210:
      str1 = this.mRes.getString(2131698080);
      break;
      label223:
      this.VC = false;
    }
  }
  
  void resumeVideo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
    }
    if (this.bC == null) {
      this.bC = new AutoCheckRunnable();
    }
    for (;;)
    {
      this.mApp.getHandler().postDelayed(this.bC, 500L);
      return;
      this.mApp.getHandler().removeCallbacks(this.bC);
    }
  }
  
  boolean vE()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() == 0)
    {
      aqY();
      g(false, false, false);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() == 1) && (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).uin == this.mSelfUin))
    {
      g(false, false, false);
      jJ("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  boolean vF()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return false;
        int j = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size();
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().PY) {
          i = j - 1;
        }
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
      return false;
    } while (irc.getGLVersion(this.mApp.getApp()) == 1);
    anot.a(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    int i = this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->VideoAblityLevel=" + i);
    }
    if (i != 4)
    {
      if (this.aqx != 2) {
        break label333;
      }
      anot.a(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      iwu.b(this.mApp, 3007);
      this.jdField_a_of_type_ComTencentAvVideoController.b().ih.clear();
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size())
      {
        if ((((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i)).Tq) && (l != ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i)).uin)) {
          this.jdField_a_of_type_ComTencentAvVideoController.b().ih.add(this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i));
        }
        i += 1;
      }
      label333:
      if (this.aqx != 1) {}
    }
    g(false, false, false);
    return this.jdField_a_of_type_ComTencentAvVideoController.F(false);
  }
  
  void y(long paramLong, boolean paramBoolean)
  {
    if ((this.mType == 0) || (this.mType == 1))
    {
      aqY();
      z(paramLong, paramBoolean);
    }
    for (;;)
    {
      aqW();
      return;
      if (this.mType == 2)
      {
        String str1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().state == 9)
        {
          this.VC = true;
          String str2 = this.mRes.getString(2131698090);
          str1 = str2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.sw())
          {
            if ((this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_a_of_type_Iiv$b.Nf.equals("1"))) {
              str1 = str2;
            }
          }
          else {
            label137:
            if (this.mTitleView != null) {
              this.mTitleView.setText(str1);
            }
          }
        }
        for (;;)
        {
          startTimer();
          break;
          str1 = this.mRes.getString(2131698080);
          break label137;
          this.VC = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "handleExterData-->Wrong gaudioStatusType-->type=" + this.mType + ",relationId=" + bJ() + ",relationType=" + this.aqx);
      }
    }
  }
  
  void z(long paramLong, boolean paramBoolean)
  {
    long l = bJ();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "createOrEnterGAudio, mType[" + this.mType + "], relationType[" + this.aqx + "], groupId[" + l + "], seq[" + paramLong + "], isDoubleAudioToMultiAudio[" + paramBoolean + "]");
    }
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio-->mGroupId == 0");
      }
    }
    do
    {
      do
      {
        return;
        String str = this.mRes.getString(2131698082);
        if (this.mTitleView != null) {
          this.mTitleView.setText(str);
        }
        if (this.mType != 0) {
          break;
        }
      } while ((this.n != null) || (this.aqx != 2));
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
      }
      jg(true);
      return;
    } while ((this.mType != 1) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.aqx, l, this.n, false);
  }
  
  class AutoCheckRunnable
    implements Runnable
  {
    AutoCheckRunnable() {}
    
    public void run()
    {
      SmallScreenMultiVideoControlUI.this.ara();
    }
  }
  
  class RefreshUIRunnable
    implements Runnable
  {
    boolean Vv;
    int aul;
    int type;
    long uin;
    
    public RefreshUIRunnable(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.uin = paramLong;
      this.type = paramInt1;
      this.Vv = paramBoolean;
      this.aul = paramInt2;
    }
    
    public void run()
    {
      SmallScreenMultiVideoControlUI.this.a(this.type, this.uin, this.Vv, this.aul);
    }
  }
  
  class RequestVideoTimeOutRunnable
    implements Runnable
  {
    RequestVideoTimeOutRunnable() {}
    
    public void run()
    {
      if (SmallScreenMultiVideoControlUI.this.a != null)
      {
        SmallScreenMultiVideoControlUI.this.a.ck("Small_RequestVideoTimeOutRunnable");
        iwu.a(SmallScreenMultiVideoControlUI.this.mApp, 1036);
        iwu.a(SmallScreenMultiVideoControlUI.this.mApp, 1037);
        iwu.b(SmallScreenMultiVideoControlUI.this.mApp, 1030, 2131698099);
        SmallScreenMultiVideoControlUI.this.a.b().b(SmallScreenMultiVideoControlUI.this.mSelfUin, true, true);
        SmallScreenMultiVideoControlUI.this.g(true, false, true);
        if (SmallScreenMultiVideoControlUI.this.aqx == 2) {
          anot.a(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
    }
  }
  
  class StartRecvVideoRunnable
    implements Runnable
  {
    public String QJ;
    
    StartRecvVideoRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.QJ);
      }
      SmallScreenMultiVideoControlUI.this.vF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI
 * JD-Core Version:    0.7.0.1
 */