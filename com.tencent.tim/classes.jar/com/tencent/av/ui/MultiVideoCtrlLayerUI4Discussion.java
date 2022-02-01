package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import anon;
import anot;
import aqha;
import aqiw;
import aqjl;
import aqju;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import iid;
import iiv;
import ioa;
import ivm;
import ivv;
import iwu;
import iya;
import jal;
import jam;
import jan;
import jao;
import jap;
import jaq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jcr;
import jfq;
import jjk;
import jkm;
import jkz;
import jll;
import mqq.app.MobileQQ;

public class MultiVideoCtrlLayerUI4Discussion
  extends MultiVideoCtrlLayerUIBase
{
  iid b = new jao(this);
  Map<String, String> dg = new HashMap();
  boolean mDestroy = false;
  
  public MultiVideoCtrlLayerUI4Discussion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, iya paramiya)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramiya);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
    }
  }
  
  public void E(long paramLong, int paramInt)
  {
    super.E(paramLong, paramInt);
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().tj())) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0) {
        bool = ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).isRender;
      }
      for (int i = ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).videoSrcType; (bool) && (i != 0); i = 0)
      {
        jjk.cd(i, paramInt);
        return;
        bool = true;
      }
    }
  }
  
  protected void Fb()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.mG(2131559951);
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    super.a(paramLong, paramInt1, paramBoolean, paramInt2, paramInt3);
    if (((paramInt1 == 0) || (5 == paramInt1)) && (aqjl.cW(this.mApp.w(String.valueOf(this.md))))) {
      c(paramLong, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    boolean bool = false;
    if ((this.mContext == null) || (!(this.mContext.get() instanceof AVActivity))) {}
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
          jjk.d(this.jdField_a_of_type_ComTencentAvVideoController.b().PZ, this.jdField_a_of_type_ComTencentAvVideoController.b().PY, 1);
          if ((!ivv.tY()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
            s(2131697686, 1, this.mRes.getDimensionPixelSize(2131299627));
          }
        }
        if (ivv.tY())
        {
          paramView = (Context)this.mContext.get();
          if ((paramView instanceof AVActivity))
          {
            paramView = ((AVActivity)paramView).a();
            if (paramView != null) {
              paramView.onBackPressed();
            }
          }
        }
        jg(false);
        return;
      case 2131697528: 
        dv(paramLong);
        return;
      case 2131697530: 
        dm(paramLong);
        return;
      case 2131373941: 
      case 2131373942: 
        QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.HANG_UP");
        jfq.f(this.jdField_a_of_type_ComTencentAvVideoController.b());
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) {
          anon.v(this.mApp);
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().ii.size() > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.b().QP))
        {
          aqha.a((Context)this.mContext.get(), 230).setTitle(((Context)this.mContext.get()).getString(2131697817)).setMessage(((Context)this.mContext.get()).getString(2131697815)).setNegativeButton(((Context)this.mContext.get()).getString(2131697814), new jam(this)).setPositiveButton(((Context)this.mContext.get()).getString(2131697816), new jal(this, paramLong)).show();
          return;
        }
        paramView = new Bundle();
        paramView.putString("uin", String.valueOf(this.md));
        paramView = this.mApp.a(5, 0, 0, paramView, null);
        if (paramView == null)
        {
          dl(paramLong);
          return;
        }
        long l1 = paramView.getLong("Origin", 0L);
        long l2 = paramView.getLong("OriginExtra", 0L);
        i = paramView.getInt("SelfRight", -1);
        if (((l1 & 0x2) == 2L) && (aqjl.ah(l2) == 0))
        {
          mw(i);
          return;
        }
        dl(paramLong);
        return;
      case 2131373947: 
        c(paramLong, paramView);
        return;
      case 2131373939: 
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PQ) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().QB))
        {
          QLog.d(this.TAG, 1, "in mIsPhoneCalling status, could not open Speaker");
          return;
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
        if (!this.jdField_a_of_type_ComTencentAvVideoController.b().isFrontCamera) {
          bool = true;
        }
        paramView.isFrontCamera = bool;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().isFrontCamera) {}
    for (int i = 2131694261;; i = 2131694260)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131374253, this.mRes.getString(i));
      return;
    }
    h(paramLong, paramView);
    return;
    i(paramLong, paramView);
  }
  
  void atc()
  {
    if ((this.awD == 0) || (this.awD == 1))
    {
      w(-1022L, "handleExtraData");
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
    QLog.w(this.TAG, 1, "createOrEnterVideo, mRelationId[" + this.md + "], mIntentRelationId[" + this.oC + "], seq[" + l + "]");
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
        break label267;
      }
      localObject2 = ((Intent)localObject1).getParcelableArrayListExtra("invitelist");
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label267;
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
      label267:
      localObject1 = null;
    }
  }
  
  void ate()
  {
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.cA(2131373947)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.ss()) {
        break label63;
      }
      mY(2131373947);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.kb(this.jdField_a_of_type_ComTencentAvVideoController.ss());
      return;
      label63:
      mZ(2131373947);
    }
  }
  
  void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "drawUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label188:
    label340:
    do
    {
      return;
      int j;
      int i;
      if (paramInt1 == 0)
      {
        if ((paramLong != this.mSelfUin) && (this.jdField_a_of_type_ComTencentAvVideoController.b().QX)) {
          TraeHelper.a().a(l, this.mApp, 2131230749, null, 0, null);
        }
        if ((paramLong != this.jdField_a_of_type_ComTencentAvVideoController.b().lm) && (paramLong != this.mSelfUin)) {
          iwu.a(this.mApp, 1047);
        }
        if (paramLong == this.mSelfUin) {
          ato();
        }
        if ((paramInt1 != 0) && (paramInt1 != 1)) {
          break label449;
        }
        j = -1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().state != 9) {
          break label340;
        }
        if (paramInt1 == 1)
        {
          j = 1;
          e(this.awG, 2131697735, String.valueOf(paramLong), null);
        }
        P(l, 2131697753);
        i = j;
        if (!this.VB) {
          break label443;
        }
        M(l, true);
        paramInt1 = j;
        a(l, "drawUI", paramInt1, paramLong);
      }
      for (;;)
      {
        if (paramInt2 != 42) {
          break label1543;
        }
        I(paramLong, true);
        return;
        if (paramInt1 != 1) {
          break label188;
        }
        if (paramLong != this.mSelfUin) {
          TraeHelper.a().a(l, this.mApp, 2131230750, null, 0, null);
        }
        iwu.a(this.mApp, 1047);
        break label188;
        if (paramInt1 == 0)
        {
          M(l, false);
          z(l, null);
          dC(l);
          i = j;
          if (paramLong == this.mSelfUin) {
            break label443;
          }
          i = j;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.b().QX) {
            break label443;
          }
          e(this.awG, 2131697684, String.valueOf(paramLong), null);
          paramInt1 = 0;
          break label269;
        }
        i = j;
        if (paramInt1 == 1)
        {
          i = 1;
          e(this.awG, 2131697735, String.valueOf(paramLong), null);
        }
        paramInt1 = i;
        break label269;
        Object localObject1;
        Object localObject2;
        if (paramInt1 == 68)
        {
          float f = this.mRes.getDimensionPixelSize(2131297418);
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.d(String.valueOf(paramLong), String.valueOf(this.md), this.aqx);
          localObject2 = jll.a((Context)this.mContext.get(), (String)localObject1, this.mZ, f);
          if (this.awE == 1) {}
          for (localObject1 = this.mRes.getString(2131697707);; localObject1 = String.format(this.mRes.getString(2131697706), new Object[] { Integer.valueOf(this.awE) }))
          {
            localObject1 = this.mRes.getString(2131697705) + (String)localObject2 + (String)localObject1;
            e(this.awH, 0, null, (String)localObject1);
            break;
          }
        }
        if (paramInt1 == 82)
        {
          e(this.awH, 0, null, this.Rs);
        }
        else
        {
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
              bool = aA(l);
              if (this.jdField_a_of_type_ComTencentAvVideoController.b().tj())
              {
                auV();
                c(l, 0.0F);
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
                mx(paramInt1);
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
            v("drawUI.1", l);
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
              this.c.update(null, new Object[] { Integer.valueOf(104), localObject2 });
            }
            if (paramInt1 == 8)
            {
              bool = aA(l);
              paramBoolean = bool;
              if (this.jdField_a_of_type_ComTencentAvVideoController.b().tj())
              {
                auV();
                c(l, 0.0F);
                paramBoolean = bool;
              }
            }
            for (;;)
            {
              if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().QX) || (!paramBoolean)) {
                break label1416;
              }
              if (this.auE >= 4) {
                break;
              }
              if ((!aqiw.isWifiConnected((Context)this.mContext.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rb)) {
                break label1418;
              }
              mx(paramInt1);
              this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.QJ = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
              break label280;
              anot.a(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
            }
            continue;
            this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.2", true, true);
            v("drawUI.2", l);
            g(true, true, true);
          }
          else if ((paramInt1 == 97) || (paramInt1 == 98))
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
            }
            this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "drawUI.3", true, true);
            v("drawUI.3", l);
            atm();
          }
        }
      }
    } while (paramInt2 != 43);
    label269:
    label280:
    label443:
    label449:
    I(paramLong, false);
    label1416:
    label1418:
    return;
  }
  
  void c(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.mApp.getHandler().postDelayed(new MultiVideoCtrlLayerUI4Discussion.7(this, paramLong), 1000L);
  }
  
  public void c(String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    String str1 = this.jdField_a_of_type_ComTencentAvVideoController.d(paramArrayOfString, String.valueOf(this.md), this.aqx);
    float f = this.mRes.getDimensionPixelSize(2131297418);
    if (i == 1)
    {
      paramArrayOfString = this.mRes.getString(2131697707);
      if (paramString.equals(this.mApp.getCurrentAccountUin())) {
        break label290;
      }
      String str2 = this.jdField_a_of_type_ComTencentAvVideoController.d(paramString, String.valueOf(this.md), this.aqx);
      f = this.mRes.getDimensionPixelSize(2131297420);
      str1 = jll.a((Context)this.mContext.get(), str1, this.mZ, f);
      str2 = jll.a((Context)this.mContext.get(), str2, this.mZ, f);
      this.Rs = (str2 + this.mRes.getString(2131697704) + str1 + paramArrayOfString);
    }
    for (paramArrayOfString = str1;; paramArrayOfString = str1)
    {
      QLog.w(this.TAG, 1, "onOtherMemberInvited, inviterUin[" + paramString + "], invitedName[" + paramArrayOfString + "]");
      a(Long.valueOf(paramString).longValue(), 82, true, -1, 0);
      return;
      paramArrayOfString = String.format(this.mRes.getString(2131697706), new Object[] { Integer.valueOf(i) });
      break;
      label290:
      str1 = jll.a((Context)this.mContext.get(), str1, this.mZ, f);
      this.Rs = (this.mRes.getString(2131697705) + str1 + paramArrayOfString);
    }
  }
  
  void d(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mApp.getHandler().postDelayed(new MultiVideoCtrlLayerUI4Discussion.1(this, paramInt2, paramString1), 1000L);
  }
  
  public void d(String paramString, String[] paramArrayOfString)
  {
    this.mApp.getHandler().postDelayed(new MultiVideoCtrlLayerUI4Discussion.5(this, paramString, paramArrayOfString), 1000L);
  }
  
  public void dl(long paramLong)
  {
    kl(true);
    if (this.jdField_a_of_type_Jcr != null) {
      this.jdField_a_of_type_Jcr.a(new jan(this, paramLong));
    }
    do
    {
      return;
      super.dD(paramLong);
      jg(true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.alr, this.jdField_a_of_type_ComTencentAvVideoController.kJ, 102);
      }
      for (;;)
      {
        anot.a(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
        if (((this.mLastRotation != 90) && (this.mLastRotation != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() == -1) || (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).videoSrcType != 1)) {
          break;
        }
        anot.a(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.aqx, this.md, 103);
      }
    } while (((this.mLastRotation != 90) && (this.mLastRotation != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() == -1) || (((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).videoSrcType != 2));
    anot.a(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
  }
  
  void dm(long paramLong)
  {
    if (isFull()) {
      iwu.b(this.mApp, 1032, 2131697778);
    }
    for (;;)
    {
      S(paramLong, 2131697530);
      return;
      anot.a(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddContactsToDiscuss");
      ((Intent)localObject).putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.kJ));
      ((Intent)localObject).putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.aQ());
      ((Intent)localObject).putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.b().ie);
      ((Intent)localObject).putExtra("selectNotAcceptFlag", false);
      ((Intent)localObject).setPackage(this.mApp.getApplication().getPackageName());
      this.mApp.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.alw = 1;
      if (ivv.tY())
      {
        localObject = (Context)this.mContext.get();
        if ((localObject instanceof AVActivity))
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((ivm)localObject).aqT();
          }
        }
      }
    }
  }
  
  void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setMembersInOrOutWording --> Type = " + paramInt1 + " , Id = " + paramInt2 + " , Uin = " + paramString1 + " , value = " + paramString2);
    }
    if (paramInt1 == this.awG)
    {
      if (paramString1 == null)
      {
        paramString2 = this.mRes.getString(paramInt2);
        iwu.a(this.mApp, 3009, paramString2);
        return;
      }
      if (this.Xj)
      {
        if (aqjl.cW(this.mApp.w(String.valueOf(this.md))))
        {
          d(paramInt1, paramInt2, paramString1, paramString2);
          return;
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.d(paramString1, String.valueOf(this.md), this.aqx);
      }
    }
    for (;;)
    {
      float f = this.mRes.getDimensionPixelSize(2131297418);
      paramString1 = jll.a((Context)this.mContext.get(), paramString1, this.mZ, f);
      paramString2 = paramString1 + this.mRes.getString(paramInt2);
      break;
      long l = Long.valueOf(paramString1).longValue();
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.b().b(l, this.jdField_a_of_type_ComTencentAvVideoController.b().ii);
      if (paramString1 == null)
      {
        paramString1 = this.mRes.getString(2131694561);
      }
      else
      {
        paramString2 = paramString1.telInfo.mobile;
        if (paramString2 == null)
        {
          paramString1 = this.mRes.getString(2131694561);
        }
        else
        {
          paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.dd(paramString2);
          if (paramString1 == null)
          {
            paramString1 = jkm.v(paramString2, 4);
            if (paramString1 == null) {
              paramString1 = this.mRes.getString(2131694561);
            }
          }
          else
          {
            continue;
            if (paramInt1 == this.awH) {
              break;
            }
            paramString2 = null;
            break;
          }
        }
      }
    }
  }
  
  public void g(long paramLong, View paramView)
  {
    S(paramLong, 2131697532);
  }
  
  protected boolean isFull()
  {
    int i = this.mApp.e(this.aqx, Long.toString(this.md));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "isFull-->Discuss Num = " + i);
    }
    return i >= 100;
  }
  
  void l(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "processExtraData--> Type = " + this.jdField_a_of_type_ComTencentAvVideoController.b().anc + " , relationId = " + this.jdField_a_of_type_ComTencentAvVideoController.b().ll + " , isInRoom = " + this.jdField_a_of_type_ComTencentAvVideoController.OB + " , RoomRelationId = " + this.jdField_a_of_type_ComTencentAvVideoController.kJ);
    }
  }
  
  void mw(int paramInt)
  {
    Object localObject = this.mApp;
    AVActivity localAVActivity = (AVActivity)this.mContext.get();
    String str = this.mApp.getApplication().getResources().getString(2131694711);
    localObject = aqha.a(localAVActivity, 230).setMessage(str).setNegativeButton(2131694712, new jaq(this)).setPositiveButton(2131694713, new jap(this, (VideoAppInterface)localObject, paramInt));
    if (localAVActivity.isResume()) {
      ((aqju)localObject).show();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "OnCreate");
    }
    this.mDestroy = false;
    this.mApp.addObserver(this.b);
    initUI();
    N(0L, this.jdField_a_of_type_ComTencentAvVideoController.b().sU());
    atc();
  }
  
  public void onDestroy(long paramLong)
  {
    this.mDestroy = true;
    QLog.w(this.TAG, 1, "onDestroy, seq[" + paramLong + "]");
    this.mApp.deleteObserver(this.b);
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
              return false;
              this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
              return false;
            } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
            jjk.e(this.jdField_a_of_type_ComTencentAvVideoController.b().PZ, this.jdField_a_of_type_ComTencentAvVideoController.b().PY, 1);
            if (ivv.tY()) {
              break;
            }
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY);
          s(2131697686, 1, this.mRes.getDimensionPixelSize(2131299627));
          return false;
        } while (this.mContext == null);
        paramKeyEvent = (Context)this.mContext.get();
      } while ((paramKeyEvent == null) || (!(paramKeyEvent instanceof AVActivity)));
      paramKeyEvent = ((AVActivity)paramKeyEvent).a();
    } while (paramKeyEvent == null);
    paramKeyEvent.onBackPressed();
    return false;
  }
  
  public void p(boolean paramBoolean, long paramLong)
  {
    long l1 = this.mApp.w(String.valueOf(this.md));
    String str1;
    String str2;
    String str3;
    if (l1 > 0L)
    {
      long l2 = this.jdField_a_of_type_ComTencentAvVideoController.bw();
      long l3 = this.jdField_a_of_type_ComTencentAvVideoController.bx();
      str1 = String.valueOf(l2);
      str2 = String.valueOf(l1);
      str3 = String.valueOf(paramLong) + "_" + str1 + "_" + String.valueOf(l3) + "_" + str2;
      if (!paramBoolean) {
        break label189;
      }
    }
    label189:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800827C", "0X800827C", i, 0, str2, "", str3, "");
      QLog.e(this.TAG, 1, "onCreateRoomSuc post conf, GroupID = " + paramLong + ", strRoomId=" + str1);
      return;
    }
  }
  
  protected void w(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.x(paramBoolean, paramInt);
  }
  
  public class AutoCheckVideoRunnable
    implements Runnable
  {
    public AutoCheckVideoRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d(MultiVideoCtrlLayerUI4Discussion.this.TAG, 2, "AutoCheckVideoRunnable");
      }
      if (MultiVideoCtrlLayerUI4Discussion.this.a != null) {
        MultiVideoCtrlLayerUI4Discussion.this.a.b().QX = true;
      }
      MultiVideoCtrlLayerUI4Discussion.this.atl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion
 * JD-Core Version:    0.7.0.1
 */