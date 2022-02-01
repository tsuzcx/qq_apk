package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import anon;
import anot;
import aqha;
import aqiw;
import aqji;
import aqji.c;
import aqju;
import arhz;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import iid;
import iiv;
import ily;
import ioa;
import itq;
import ivm;
import ivv;
import iwu;
import iya;
import jar;
import jas;
import jat;
import jau;
import jav;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import jaw;
import jax;
import jcr;
import jfq;
import jgg;
import jjk;
import jkn;
import jkn.b;
import jkz;
import jlc;
import jll;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4NewGroupChat
  extends MultiVideoCtrlLayerUIBase
{
  public boolean Xg = true;
  private volatile boolean Xh;
  int awC = 0;
  iid jdField_b_of_type_Iid = new jax(this);
  iya jdField_b_of_type_Iya = new jar(this);
  private arhz g;
  
  public MultiVideoCtrlLayerUI4NewGroupChat(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, iya paramiya)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramiya);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
    }
  }
  
  public static int a(String paramString1, VideoAppInterface paramVideoAppInterface, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    if (aqji.pD() <= 0) {
      i = 2131697780;
    }
    int j;
    do
    {
      return i;
      j = paramVideoAppInterface.b().aN().size();
      if (aqji.LZ() <= j)
      {
        if (AudioHelper.aCz()) {
          QLog.w(paramString1, 1, "isFull, 通话成员超出上限[" + j + "]");
        }
        return 2131697778;
      }
    } while (!AudioHelper.aCz());
    QLog.w(paramString1, 1, "isGAudioFull, gAudioMemCount[" + j + "], canAutoInviteMemIntoTroop[" + paramBoolean + "], wording[" + 0 + "]");
    return 0;
  }
  
  private void atf()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.checkScreenShareAvailable();
      atg();
      this.mApp.getHandler().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.7(this), 5000L);
    }
  }
  
  private void ati()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController.b().tm()) {
      return;
    }
    if (this.awC != 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentAvUiQavPanel.getContext(), this.jdField_a_of_type_ComTencentAvUiQavPanel.getResources().getString(this.awC), 1).show();
      return;
    }
    iwu.b(this.mApp, 1032);
  }
  
  private void dn(long paramLong)
  {
    c(paramLong, 0.0F);
  }
  
  private void f(long paramLong, View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if ((paramView.a == VideoConstants.EmShareState.START_SUC) || (paramView.a == VideoConstants.EmShareState.REQUESTING_START)) {
      g(0L, null);
    }
    do
    {
      return;
      paramView = a();
    } while ((paramView == null) || (paramView.isFinishing()) || (paramView.isDestroyed()));
    String str1 = paramView.getString(2131719220);
    Object localObject1 = paramView.getString(2131719217);
    Object localObject2 = paramView.getString(2131719218);
    String str4 = paramView.getString(2131719219);
    String str2 = paramView.getString(2131697810);
    String str3 = paramView.getString(2131697944);
    localObject1 = jkn.a((String)localObject1, (String)localObject2, str4);
    localObject1 = itq.a(paramView, ((jkn.b)localObject1).content, ((jkn.b)localObject1).SG, ((jkn.b)localObject1).link);
    localObject2 = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
    if (!((SharedPreferences)localObject2).contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
    {
      itq.a(paramView, str1, (CharSequence)localObject1, str2, str3, true, 10, new jat(this), new jau(this)).show();
      ((SharedPreferences)localObject2).edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
      return;
    }
    aqha.a(paramView, 230, str1, (CharSequence)localObject1, str2, str3, new jav(this), new jaw(this)).setMessageWithoutAutoLink((CharSequence)localObject1).show();
  }
  
  protected void Fb()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.mG(2131559950);
  }
  
  public void a(long paramLong, View paramView)
  {
    if ((this.mContext == null) || (!(this.mContext.get() instanceof AVActivity))) {}
    boolean bool;
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364460: 
      case 2131365755: 
      case 2131374248: 
        ava();
        return;
      case 2131697529: 
        k(paramLong, paramView);
        return;
      case 2131697539: 
        j(paramLong, paramView);
        return;
      case 2131697537: 
        du(paramLong);
        return;
      case 2131371237: 
      case 2131377282: 
        dw(paramLong);
        return;
      case 2131373944: 
        QLog.d(this.TAG, 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
        {
          jjk.d(this.jdField_a_of_type_ComTencentAvVideoController.b().PZ, this.jdField_a_of_type_ComTencentAvVideoController.b().PY, 10);
          if ((!ivv.tY()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
            super.s(2131697686, 1, this.mRes.getDimensionPixelSize(2131299627));
          }
        }
        if (ivv.tY())
        {
          paramView = ((AVActivity)this.mContext.get()).a();
          if (paramView != null) {
            paramView.onBackPressed();
          }
        }
        super.jg(false);
        return;
      case 2131697528: 
        dv(paramLong);
        return;
      case 2131373941: 
      case 2131373942: 
        QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.HANG_UP");
        jfq.f(this.jdField_a_of_type_ComTencentAvVideoController.b());
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) {
          anon.v(this.mApp);
        }
        kl(true);
        if (this.jdField_a_of_type_Jcr != null)
        {
          this.jdField_a_of_type_Jcr.a(new jas(this, paramLong));
          return;
        }
        anot.a(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
        if (((this.mLastRotation == 90) || (this.mLastRotation == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() != -1) && (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).videoSrcType == 1)) {
          anot.a(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          super.dD(paramLong);
          super.jg(true);
          if (!this.jdField_a_of_type_ComTencentAvVideoController.OB) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.alr, this.jdField_a_of_type_ComTencentAvVideoController.kJ, 102);
          return;
          if (((this.mLastRotation == 90) || (this.mLastRotation == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() != -1) && (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).videoSrcType == 2)) {
            anot.a(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.aqx, this.md, 103);
        return;
      case 2131373947: 
        c(paramLong, paramView);
        return;
      case 2131373939: 
        QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.HAND_FREE");
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.b().aK;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().QB) && (paramView != null)) {
          jjk.F(true, 10);
        }
        while ((this.jdField_a_of_type_ComTencentAvVideoController.b().PQ) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().QB))
        {
          QLog.d(this.TAG, 1, "in mIsPhoneCalling status, could not open Speaker");
          return;
          if (paramView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "DeviceList is null");
            }
          }
          else {
            jjk.F(false, 10);
          }
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.nQ(TraeHelper.aBg);
        return;
      case 2131697526: 
        d(paramLong, paramView);
        return;
      case 2131374253: 
        QLog.w(this.TAG, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        this.c.update(null, new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().isFrontCamera) {
          break label997;
        }
        bool = true;
        paramView.isFrontCamera = bool;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().isFrontCamera) {}
    for (int i = 2131694261;; i = 2131694260)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131374253, this.mRes.getString(i));
      return;
      label997:
      bool = false;
      break;
    }
    h(paramLong, paramView);
    return;
    i(paramLong, paramView);
    return;
    f(paramLong, paramView);
    return;
    dm(paramLong);
    return;
    b(paramLong, paramView);
    return;
    l(paramLong, paramView);
  }
  
  void atc()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "handleExtraData, mStatusType[" + this.awD + "]");
    }
    if ((this.awD == 0) || (this.awD == 1))
    {
      super.w(-1022L, "handleExtraData");
      atd();
    }
    do
    {
      return;
      if (this.awD == 2)
      {
        this.jdField_a_of_type_Jkz.li(true);
        this.jdField_a_of_type_Jkz.lj(true);
        this.md = this.oC;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "handleExterData-->Wrong gaudioStatusType-->type = " + this.awD + " , relationId = " + this.oC + " , relationType = " + this.aqx);
  }
  
  void atd()
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "createOrEnterVideo, mRelationId[" + this.md + "], mIntentRelationId[" + this.oC + "], mStatusType[" + this.awD + "], seq[" + l + "]");
    this.md = this.oC;
    if (this.md <= 0L) {
      return;
    }
    P(l, 2131697696);
    Object localObject1;
    Object localObject2;
    if (this.awD == 0)
    {
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label279;
      }
      localObject2 = ((Intent)localObject1).getParcelableArrayListExtra("invitelist");
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label279;
      }
      localObject1 = new long[((ArrayList)localObject2).size()];
      localObject2 = ((ArrayList)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = AudioHelper.stringToLong(((ResultRecord)((Iterator)localObject2).next()).uin);
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.b().f;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.md, 0, (long[])localObject2, this.isVideo);
      this.Xi = true;
      return;
      if (this.awD != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.aqx, this.md, null, this.isVideo);
      return;
      label279:
      localObject1 = null;
    }
  }
  
  void ate()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refreshMuteBtnState");
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.cA(2131373947)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.ss()) {
        break label80;
      }
      super.mY(2131373947);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.kb(this.jdField_a_of_type_ComTencentAvVideoController.ss());
      return;
      label80:
      super.mZ(2131373947);
    }
  }
  
  public void atg()
  {
    try
    {
      if (this.g == null)
      {
        this.g = new arhz(a(), 0, 2131561627, 17);
        this.g.setBackAndSearchFilter(false);
        this.g.setMessage("");
      }
      this.g.show();
      this.Xh = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.TAG, 2, localException.getMessage());
    }
  }
  
  public void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing()))
      {
        this.g.dismiss();
        this.Xh = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.TAG, 2, localException.getMessage());
    }
  }
  
  @TargetApi(11)
  void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "drawUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label160:
    label241:
    label1276:
    do
    {
      return;
      int i;
      int j;
      if (paramInt1 == 0)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.mSelfUin) && (this.jdField_a_of_type_ComTencentAvVideoController.b().QX)) {
          TraeHelper.a().a(l, this.mApp, 2131230749, null, 0, null);
        }
        if (paramLong == this.mSelfUin) {
          super.ato();
        }
        if ((paramInt1 != 0) && (paramInt1 != 1)) {
          break label398;
        }
        i = -1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().state != 9) {
          break label302;
        }
        if (paramInt1 == 1)
        {
          i = 1;
          e(this.awG, 2131697768, String.valueOf(paramLong), null);
        }
        P(l, 2131697753);
        j = i;
        if (!this.VB) {
          break label392;
        }
        M(l, true);
        paramInt1 = i;
        a(l, "drawUI", paramInt1, paramLong);
      }
      for (;;)
      {
        if (paramInt2 != 42) {
          break label1276;
        }
        super.I(paramLong, true);
        return;
        if ((paramInt1 != 1) || (paramLong == this.mSelfUin)) {
          break label160;
        }
        TraeHelper.a().a(l, this.mApp, 2131230750, null, 0, null);
        break label160;
        if (paramInt1 == 0)
        {
          M(l, false);
          z(l, null);
          super.dC(l);
          j = i;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.b().QX) {
            break label392;
          }
          e(this.awG, 2131697760, String.valueOf(paramLong), null);
          paramInt1 = 0;
          break label241;
        }
        j = i;
        if (paramInt1 == 1)
        {
          j = 1;
          e(this.awG, 2131697768, String.valueOf(paramLong), null);
        }
        paramInt1 = j;
        break label241;
        boolean bool;
        if ((paramInt1 == 5) || (paramInt1 == 6))
        {
          i = 0;
          paramBoolean = true;
          if (paramLong == this.mSelfUin) {
            i = 1;
          }
          if (paramInt1 == 6)
          {
            bool = super.aA(l);
            if (this.jdField_a_of_type_ComTencentAvVideoController.b().tj())
            {
              super.auV();
              dn(l);
            }
            paramBoolean = bool;
            if (i != 0)
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
            if (i == 0)
            {
              super.mx(paramInt1);
              this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
              continue;
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, 1);
            j = this.jdField_a_of_type_ComTencentAvVideoController.b().kK();
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "onSelfVideoIn.-->FirstVideo=" + j + ",index=" + i);
            }
            if ((j != -1) && ((i != j) || (i == 0))) {
              continue;
            }
            this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            continue;
          }
          if (i != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.1", true, true);
          super.v("drawUI.1", l);
          super.g(true, true, true);
          continue;
        }
        if ((paramInt1 == 7) || (paramInt1 == 8))
        {
          paramBoolean = true;
          if (paramInt1 == 8)
          {
            ioa localioa = new ioa();
            localioa.uin = paramLong;
            localioa.videoSrcType = 2;
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localioa);
            this.c.update(null, new Object[] { Integer.valueOf(104), localArrayList });
          }
          if (paramInt1 == 8)
          {
            bool = super.aA(l);
            paramBoolean = bool;
            if (this.jdField_a_of_type_ComTencentAvVideoController.b().tj())
            {
              super.auV();
              paramBoolean = bool;
              if (Build.VERSION.SDK_INT >= 11)
              {
                c(l, 0.0F);
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
            super.mx(paramInt1);
            this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.2", true, true);
          super.v("drawUI.2", l);
          super.g(true, true, true);
          continue;
        }
        if ((paramInt1 == 97) || (paramInt1 == 98))
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.3", true, true);
          super.v("drawUI.3", l);
          super.atm();
        }
      }
    } while (paramInt2 != 43);
    label302:
    super.I(paramLong, false);
    label392:
    label398:
    return;
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 0, false);
    paramView = a();
    if (paramView.a != null)
    {
      if (!paramView.a.xj()) {
        break label51;
      }
      paramView.a.nw(3);
    }
    for (;;)
    {
      atk();
      ily.report("0X800A8D0");
      return;
      label51:
      paramView.a.nt(0);
    }
  }
  
  void dm(long paramLong)
  {
    if (!aC(paramLong))
    {
      aqji.c.SH(false);
      ati();
      O(paramLong, 65535);
    }
    for (;;)
    {
      S(paramLong, 2131697530);
      return;
      aqji.c.SH(true);
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddMembersToGroup");
      ((Intent)localObject).setPackage(this.mApp.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvVideoController.bw();
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      long l = localiiv.getRoomId();
      int i = localiiv.kO();
      ((Intent)localObject).putExtra("room_id", l);
      ((Intent)localObject).putExtra("room_create_time", i);
      ((Intent)localObject).putExtra("uin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.kJ));
      jlc.a((Intent)localObject, paramLong);
      ((Intent)localObject).putParcelableArrayListExtra("memberlist", this.jdField_a_of_type_ComTencentAvVideoController.aO());
      AudioHelper.b("ACTION_ADD_MEMBERS_TO_GROUP", ((Intent)localObject).getExtras(), true);
      this.mApp.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.alw = 1;
      if (ivv.tY())
      {
        localObject = ((AVActivity)this.mContext.get()).a();
        if (localObject != null) {
          ((ivm)localObject).aqT();
        }
      }
    }
  }
  
  void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setMembersInOrOutWording, type[" + paramInt1 + "], id[" + paramInt2 + "], uin[" + paramString1 + "], value[" + paramString2 + "]");
    }
    if (paramInt1 == this.awG) {
      if (paramString1 == null) {
        paramString2 = this.mRes.getString(paramInt2);
      }
    }
    for (;;)
    {
      iwu.a(this.mApp, 3009, paramString2);
      return;
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.d(paramString1, String.valueOf(this.md), this.aqx);
      float f = this.mRes.getDimensionPixelSize(2131297418);
      paramString1 = jll.a((Context)this.mContext.get(), paramString1, this.mZ, f);
      paramString2 = paramString1 + this.mRes.getString(paramInt2);
      continue;
      if (paramInt1 != this.awH) {
        paramString2 = null;
      }
    }
  }
  
  @TargetApi(21)
  public void g(long paramLong, View paramView)
  {
    super.g(paramLong, paramView);
    jll.kQ("0x800AD8D");
  }
  
  protected boolean isFull()
  {
    if (isDestroyed()) {}
    do
    {
      return true;
      this.awC = a(this.TAG, this.mApp, this.md + "", this.Xg);
    } while (this.awC != 0);
    return false;
  }
  
  void l(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("enableInvite")) {
        break label152;
      }
      this.Xg = paramIntent.getBooleanExtra("enableInvite", false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "processExtraData, gaudioStatusType[" + this.jdField_a_of_type_ComTencentAvVideoController.b().anc + "], relationId[" + this.jdField_a_of_type_ComTencentAvVideoController.b().ll + "], isInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.OB + "], mGAudioGroupId[" + this.jdField_a_of_type_ComTencentAvVideoController.kJ + "], isVideo[" + this.isVideo + "], mCanAutoInviteMemIntoTroop[" + this.Xg + "]");
      }
      return;
      label152:
      paramIntent = new Bundle();
      paramIntent.putString("uin", this.jdField_a_of_type_ComTencentAvVideoController.b().ll + "");
      Bundle localBundle = this.mApp.a(3, 0, 0, paramIntent, null);
      AudioHelper.I("request", paramIntent);
      AudioHelper.I("response", localBundle);
      if (localBundle != null) {
        this.Xg = localBundle.getBoolean("enableInvite", false);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mApp.addObserver(this.jdField_b_of_type_Iid);
    this.mApp.addObserver(this.jdField_b_of_type_Iya);
    initUI();
    N(0L, this.jdField_a_of_type_ComTencentAvVideoController.b().sU());
    atc();
  }
  
  public void onDestroy(long paramLong)
  {
    QLog.w(this.TAG, 1, "onDestroy, seq[" + paramLong + "]");
    this.mApp.deleteObserver(this.jdField_b_of_type_Iid);
    this.mApp.deleteObserver(this.jdField_b_of_type_Iya);
    super.onDestroy(paramLong);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "OnKeyDown --> WRONG KeyCode = " + paramInt);
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
                return false;
              } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
              jjk.e(this.jdField_a_of_type_ComTencentAvVideoController.b().PZ, this.jdField_a_of_type_ComTencentAvVideoController.b().PY, 10);
              if (ivv.tY()) {
                break;
              }
            } while (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY);
            super.s(2131697686, 1, this.mRes.getDimensionPixelSize(2131299627));
            return false;
          } while (this.mContext == null);
          paramKeyEvent = (Context)this.mContext.get();
        } while ((paramKeyEvent == null) || (!(paramKeyEvent instanceof AVActivity)));
        paramKeyEvent = (AVActivity)paramKeyEvent;
      } while (paramKeyEvent == null);
      paramKeyEvent = paramKeyEvent.a();
    } while (paramKeyEvent == null);
    paramKeyEvent.onBackPressed();
    return false;
  }
  
  protected void w(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.y(paramBoolean, paramInt);
  }
  
  public class AutoCheckVideoRunnable
    implements Runnable
  {
    public AutoCheckVideoRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d(MultiVideoCtrlLayerUI4NewGroupChat.this.TAG, 2, "AutoCheckVideoRunnable");
      }
      if (MultiVideoCtrlLayerUI4NewGroupChat.this.a != null) {
        MultiVideoCtrlLayerUI4NewGroupChat.this.a.b().QX = true;
      }
      MultiVideoCtrlLayerUI4NewGroupChat.e(MultiVideoCtrlLayerUI4NewGroupChat.this);
      if (MultiVideoCtrlLayerUI4NewGroupChat.this.mApp != null) {
        MultiVideoCtrlLayerUI4NewGroupChat.this.mApp.ak(MultiVideoCtrlLayerUI4NewGroupChat.this.md);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat
 * JD-Core Version:    0.7.0.1
 */