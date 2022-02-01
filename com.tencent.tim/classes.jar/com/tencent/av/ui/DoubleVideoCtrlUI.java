package com.tencent.av.ui;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqhu;
import aqju;
import aqpr;
import atan;
import ayxa;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import igd;
import igv;
import iiv;
import iiv.a;
import ijw;
import ikp;
import ikr;
import ily;
import imm;
import imp;
import ioa;
import irc;
import irk;
import itq;
import ivm;
import ivv;
import iwu;
import iya;
import iya.d;
import iya.f;
import iyd;
import iye;
import iyf;
import iyg;
import iyh;
import iyi;
import iyj;
import iyk;
import iyl;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import jci;
import jcr;
import jdh;
import jfq;
import jgg;
import jiu;
import jjb;
import jji;
import jjk;
import jjp;
import jkn;
import jkn.b;
import jkv;
import jkz;
import jll;
import wja;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  public boolean Ox = false;
  boolean Vu = false;
  public boolean Wg = false;
  public boolean Wh;
  StartTimerRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable = new StartTimerRunnable();
  a jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$a = new a(null);
  jcr jdField_a_of_type_Jcr = null;
  Runnable bK = new DoubleVideoCtrlUI.1(this);
  Runnable bL = new DoubleVideoCtrlUI.2(this);
  Runnable bM = new DoubleVideoCtrlUI.3(this);
  Runnable bN = new DoubleVideoCtrlUI.20(this);
  Runnable bO = new DoubleVideoCtrlUI.21(this);
  RelativeLayout dY = null;
  ImageView gr = null;
  Timer m = null;
  TextView mC = null;
  TextView mD;
  TextView mE = null;
  boolean mIsPaused = false;
  private long ot = -1L;
  long ou = 0L;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, iya paramiya)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramiya);
  }
  
  private ChildLockSign a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mContext != null)
    {
      localObject1 = localObject2;
      if (this.mContext.get() != null)
      {
        Object localObject3 = (Activity)this.mContext.get();
        localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131373962);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockSign((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131366050);
          Resources localResources = ((ViewGroup)localObject2).getResources();
          int i = localResources.getDimensionPixelOffset(2131298075);
          int j = localResources.getDimensionPixelOffset(2131298072);
          int k = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
          int n = localResources.getDimensionPixelOffset(2131298073);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, n, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          ((ChildLockSign)localObject1).setVisibility(8);
        }
      }
    }
    return localObject1;
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    VideoController localVideoController = paramVideoAppInterface.b();
    iiv localiiv = localVideoController.b();
    String str = localiiv.peerUin;
    int i;
    if (paramBoolean) {
      if (localiiv.a(localVideoController)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "sendAddMemberBroadcast, peerUin[" + str + "], supportUinType[" + i + "], fromDoubleMeeting[" + paramBoolean + "], activity[" + paramActivity + "]");
      }
      if (i == 1) {}
      for (int j = 1;; j = 2)
      {
        anot.a(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", j, 0, "", "", "", "");
        if ((i != 3000) || (paramActivity == null) || (!jkn.xI())) {
          break label273;
        }
        paramVideoAppInterface = jkn.hv();
        aqha.a(paramActivity, 230, null, paramVideoAppInterface, "", acfp.m(2131705226), new iyf(), null).show();
        if (QLog.isColorLevel()) {
          QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + paramVideoAppInterface + "]");
        }
        anot.a(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
        return;
        i = 3000;
        break;
        if (!localiiv.b(localVideoController)) {
          break label329;
        }
        i = 1;
        break;
      }
      label273:
      paramActivity = new Intent();
      paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramActivity.putExtra("peerUin", str);
      paramActivity.putExtra("supportUinType", i);
      paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
      paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
      return;
      label329:
      i = 3000;
    }
  }
  
  private void asp()
  {
    QLog.w(this.TAG, 1, "setForground, mRequestPermissionIng[" + this.Yk + "]");
    if (this.Yk) {}
    while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.Ox) || (igv.a().sk())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.alx();
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    int i = 0;
    int j = paramVideoAppInterface.b().b().a.chatType;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt > 0)
    {
      iwu.b(paramVideoAppInterface, 1048, paramInt);
      return;
      if ((j == 3) || (j == 1))
      {
        paramInt = 2131698169;
      }
      else
      {
        paramInt = 2131698168;
        continue;
        if ((j == 3) || (j == 1))
        {
          paramInt = 2131698164;
        }
        else
        {
          paramInt = 2131698163;
          continue;
          if ((j == 3) || (j == 1)) {
            paramInt = 2131698166;
          } else {
            paramInt = 2131698165;
          }
        }
      }
    }
    iwu.a(paramVideoAppInterface, 1048);
  }
  
  private void e(long paramLong, View paramView)
  {
    if (this.mApp == null) {
      return;
    }
    paramView = new iya.d(paramView);
    paramView.u(paramLong, "onClick_InviteMember");
    this.mApp.l(new Object[] { Integer.valueOf(9000), paramView });
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "onClick_InviteMember block[" + paramView.Wa + "]");
    }
    if (paramView.Wa) {
      QLog.w(this.TAG, 1, "onClick_InviteMember, mBlockName[" + paramView.Rj + "]");
    }
    for (;;)
    {
      S(paramLong, 2131697530);
      return;
      jjk.i(this.jdField_a_of_type_ComTencentAvVideoController);
      a(a(), this.mApp, false);
      if ((ivv.tY()) && ((this.mContext.get() instanceof AVActivity)))
      {
        paramView = (AVActivity)this.mContext.get();
        if (paramView != null)
        {
          paramView = paramView.a();
          if (paramView != null) {
            paramView.aqT();
          }
        }
      }
    }
  }
  
  private void f(long paramLong, View paramView)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity == null) || (localAVActivity.isFinishing()) || (localAVActivity.isDestroyed())) {
      return;
    }
    String str1 = localAVActivity.getString(2131719220);
    Object localObject1 = localAVActivity.getString(2131719217);
    Object localObject2 = localAVActivity.getString(2131719218);
    String str4 = localAVActivity.getString(2131719219);
    String str2 = localAVActivity.getString(2131697810);
    String str3 = localAVActivity.getString(2131697944);
    localObject1 = jkn.a((String)localObject1, (String)localObject2, str4);
    localObject1 = itq.a(localAVActivity, ((jkn.b)localObject1).content, ((jkn.b)localObject1).SG, ((jkn.b)localObject1).link);
    localObject2 = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp());
    if (!((SharedPreferences)localObject2).contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
    {
      itq.a(localAVActivity, str1, (CharSequence)localObject1, str2, str3, true, 10, new iyg(this, paramLong, paramView), new iyh(this)).show();
      ((SharedPreferences)localObject2).edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
      return;
    }
    aqha.a(localAVActivity, 230, str1, (CharSequence)localObject1, str2, str3, new iyi(this), new iyj(this, paramLong, paramView)).setMessageWithoutAutoLink((CharSequence)localObject1).show();
  }
  
  private void jB(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().PV)
    {
      irk.a().pause(32);
      super.mY(2131373947);
      this.mApp.l(new Object[] { Integer.valueOf(109) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.b(true, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getResources().getString(2131690630));
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().PV) {
        break label193;
      }
    }
    label193:
    for (paramBoolean = true;; paramBoolean = false)
    {
      kv(paramBoolean);
      return;
      irk.a().resume(32);
      super.mZ(2131373947);
      this.mApp.l(new Object[] { Integer.valueOf(108) });
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.b(false, null);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getResources().getString(2131690618));
      break;
    }
  }
  
  private void jz(boolean paramBoolean)
  {
    if (this.m != null)
    {
      this.m.cancel();
      this.m = null;
      QLog.w(this.TAG, 1, "StartGlassCheck, cancel old Timer");
    }
    this.m = new Timer();
    DoubleVideoCtrlUI.5 local5 = new DoubleVideoCtrlUI.5(this, paramBoolean);
    QLog.w(this.TAG, 1, "StartGlassCheck, begin Timer, bCheck[" + paramBoolean + "]");
    Timer localTimer = this.m;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 10000L)
    {
      localTimer.schedule(local5, l);
      return;
    }
  }
  
  static void o(VideoAppInterface paramVideoAppInterface)
  {
    int i = 2131697612;
    VideoController localVideoController = paramVideoAppInterface.b();
    String str = localVideoController.b().peerUin;
    int j = localVideoController.getPeerTerminalType(str);
    int k = localVideoController.getPeerSdkVersion(str);
    if (localVideoController.b().uinType == 1011) {
      if (k >= 45) {
        break label130;
      }
    }
    while (i != 0)
    {
      iwu.b(paramVideoAppInterface, 1012, i);
      return;
      if (!imm.isNormalSharp()) {
        i = 2131721762;
      } else if (irc.getGLVersion(localVideoController.getAppContext()) == 1) {
        i = 2131721698;
      } else if (k < 16) {
        i = 2131697613;
      } else if ((j == 4) || (j == 2) || (j == 3)) {
        label130:
        i = 0;
      }
    }
    iwu.a(paramVideoAppInterface, 1012);
  }
  
  private void v(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.wr()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.ws())) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.b();
    boolean bool;
    int j;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PV)
    {
      bool = true;
      paramString.O("doMute", bool);
      j = this.jdField_a_of_type_ComTencentAvVideoController.b().kJ();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PV) {
        break label137;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b().Z("doMute", 1);
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoCtrl.doMute", j, i, false);
      jB(true);
      jjk.e(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool = false;
      break;
      label137:
      this.jdField_a_of_type_ComTencentAvVideoController.b().Z("doMute", 0);
    }
  }
  
  private boolean wc()
  {
    long l = System.currentTimeMillis();
    if (l > this.ot + 200L)
    {
      this.ot = l;
      return true;
    }
    return false;
  }
  
  void C(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    O(paramLong, 65535);
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if ((i == 2) && (irc.getGLVersion(this.mApp.getApp()) == 1) && (paramBoolean) && (localiiv.isConnected()))
    {
      o(this.mApp);
      anot.a(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
    }
    asn();
  }
  
  public void D(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onClose, type[" + paramInt + "], seq[" + paramLong + "]");
    }
    asx();
    super.D(paramLong, paramInt);
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int k = localiiv.uinType;
    int i;
    int j;
    label99:
    Object localObject;
    if (localiiv.li == 2L)
    {
      i = 1;
      if (paramInt != 12) {
        break label543;
      }
      j = 1;
      if (((localiiv.tf()) && ((paramInt == 3) || ((j != 0) && (i == 0)) || (paramInt == 42))) || ((localiiv.tg()) && (j != 0) && (i != 0) && ((k == 0) || (k == 1006) || (k == 25) || (k == 24) || (k == 22) || (k == 26) || (k == 1044)))) {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          jjk.r(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(new iyd(this, paramLong));
          auY();
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().gK();
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 1, "onClose phoneNumber is " + (String)localObject);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 3)) {
            break label563;
          }
          if (Build.VERSION.SDK_INT < 17) {
            break label549;
          }
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373933, 8);
          localObject = (Button)this.jdField_a_of_type_ComTencentAvUiQavPanel.v(2131373946);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((Button)localObject).getLayoutParams();
          localLayoutParams.rightMargin = 0;
          localLayoutParams.removeRule(11);
          localLayoutParams.addRule(14);
          ((Button)localObject).setLayoutParams(localLayoutParams);
        }
      }
    }
    for (;;)
    {
      if (paramInt == 3) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131374253, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373946, true);
      localObject = (EffectOperateManager)this.mApp.a(8);
      if (localObject != null) {
        ((EffectOperateManager)localObject).id(false);
      }
      if (this.jdField_a_of_type_Jkv != null)
      {
        this.jdField_a_of_type_Jkv.axy();
        this.jdField_a_of_type_Jkv.axA();
        this.jdField_a_of_type_Jkv.axw();
        this.jdField_a_of_type_Jkv = null;
      }
      this.Ox = true;
      if ((localiiv.isConnected()) && (localiiv.amI == 2) && (!localiiv.PY)) {
        jjk.awZ();
      }
      localiiv.O("onClose", false);
      localiiv.Z("onClose", 0);
      if (paramInt == 24)
      {
        this.Yb = true;
        P(paramLong, 2131698039);
      }
      if (paramInt == 42) {
        this.mApp.getHandler().removeCallbacks(this.bM);
      }
      return;
      i = 0;
      break;
      label543:
      j = 0;
      break label99;
      label549:
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373933, false);
      continue;
      label563:
      anot.a(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373933, true);
    }
  }
  
  void D(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (isDestroyed()) {
      return;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.OT))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, 0, false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
      }
      if ((this.mContext.get() instanceof AVActivity))
      {
        AVActivity localAVActivity = (AVActivity)this.mContext.get();
        if (paramBoolean) {
          break label217;
        }
        bool1 = true;
        label93:
        localAVActivity.jm(bool1);
        if (paramBoolean) {
          break label223;
        }
        bool1 = bool2;
        label108:
        localAVActivity.jq(bool1);
        localAVActivity.jn(paramBoolean);
      }
      if (!paramBoolean) {
        break label229;
      }
      if (this.gr != null) {
        this.gr.setVisibility(8);
      }
      if (this.mC != null) {
        this.mC.setVisibility(8);
      }
      if (this.b != null) {
        this.b.nl(8);
      }
      Q(paramLong, 8);
      if (this.eq != null) {
        this.eq.setVisibility(0);
      }
    }
    for (;;)
    {
      g(Boolean.valueOf(paramBoolean));
      return;
      O(-1014L, 65535);
      break;
      label217:
      bool1 = false;
      break label93;
      label223:
      bool1 = false;
      break label108;
      label229:
      if (this.gr != null) {
        this.gr.setVisibility(0);
      }
      if (this.mC != null) {
        this.mC.setVisibility(0);
      }
      if (this.b != null) {
        this.b.nl(0);
      }
      Q(paramLong, 0);
      if (this.eq != null) {
        this.eq.setVisibility(8);
      }
    }
  }
  
  @TargetApi(11)
  public void E(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PY) || (this.jdField_a_of_type_ComTencentAvVideoController.b().PZ)) {
      c(paramLong, 360 - paramInt);
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.mContext != null)
      {
        localObject1 = localObject2;
        if (this.mContext.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.mContext.get()).findViewById(2131373959);
        }
      }
      if (localObject1 != null) {
        ((ChildLockCircle)localObject1).setRotation(360 - paramInt);
      }
      return;
      c(paramLong, 0.0F);
    }
  }
  
  void F(long paramLong, int paramInt)
  {
    this.gr = ((ImageView)this.mRootView.findViewById(2131373989));
    this.mC = ((TextView)this.mRootView.findViewById(2131373990));
    O(paramLong, 65535);
    asn();
  }
  
  public void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        if (paramBoolean2)
        {
          iwu.b(this.mApp, 1019);
          return;
        }
        iwu.a(this.mApp, 1019);
      } while ((this.mContext.get() == null) || (this.mApp == null));
      iwu.b(this.mApp, 1018);
      anot.a(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PV) {
          this.jdField_a_of_type_ComTencentAvVideoController.b(true, (String)localObject);
        }
        localObject = new atan((Context)this.mContext.get(), null);
        if (jjp.cK("qav_peer_phone_calling.mp3")) {
          ((atan)localObject).a(l, 2, 0, null, jjp.hr() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.b().QE)
        {
          anot.a(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
          ((atan)localObject).a(l, 0, 2131230750, null, null, false, 1, false, true, 0);
          jjp.bz(BaseApplicationImpl.getApplication());
        }
        anot.a(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.b().PV);
    this.jdField_a_of_type_ComTencentAvVideoController.b(false, (String)localObject);
  }
  
  public void H(int paramInt, boolean paramBoolean)
  {
    View localView1;
    View localView2;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.mRootView != null)
    {
      localView1 = this.mRootView.findViewById(2131374245);
      localView2 = this.mRootView.getRootView().findViewById(2131374246);
      if (AudioHelper.jY(0) == 1)
      {
        localView1.setBackgroundColor(2147460352);
        localView2.setBackgroundColor(2147460352);
      }
      if (localView1 != null)
      {
        localLayoutParams1 = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams1 != null)
        {
          if (!wI()) {
            break label173;
          }
          if (paramBoolean) {
            break label145;
          }
          localLayoutParams1.topMargin = (paramInt - mj() + this.mRootView.getWidth() * 106 / 750);
        }
      }
    }
    for (;;)
    {
      localLayoutParams2.topMargin = localLayoutParams1.topMargin;
      localView1.setLayoutParams(localLayoutParams1);
      localView2.setLayoutParams(localLayoutParams2);
      return;
      label145:
      localLayoutParams1.topMargin = (-mj() + this.mRootView.getWidth() * 106 / 750);
      continue;
      label173:
      if (!paramBoolean)
      {
        localLayoutParams1.topMargin = (paramInt - mj() + wja.dp2px(15.0F, this.mRes));
        if (ayxa.isLiuHaiUseValid())
        {
          paramInt = localLayoutParams1.topMargin;
          localLayoutParams1.topMargin = (ayxa.getNotchInScreenHeight((AVActivity)this.mContext.get()) + paramInt);
        }
      }
      else
      {
        localLayoutParams1.topMargin = wja.dp2px(15.0F, this.mRes);
      }
    }
  }
  
  void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    boolean bool = false;
    Object localObject = this.mD;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      localObject = this.dY;
      i = j;
      if (paramBoolean1) {
        i = 0;
      }
      ((RelativeLayout)localObject).setVisibility(i);
      if ((this.mRootView != null) && (paramBoolean2))
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
          paramBoolean2 = bool;
          if (!paramBoolean1) {
            paramBoolean2 = true;
          }
          ((QavPanel)localObject).kd(paramBoolean2);
        }
        new VideoControlUI.d(this.mRootView).kx(paramBoolean1);
      }
      y(-1035L, "changeToDoubleScreen");
      return;
    }
  }
  
  protected void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    jB(paramBoolean2);
  }
  
  public void V(String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onPeerSwitchTerminal, peerUin[" + paramString + "], bStartSwitch[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      iwu.b(this.mApp, 1020);
    }
    for (;;)
    {
      O(l, 65535);
      paramString = imp.a();
      if (!paramBoolean) {
        break;
      }
      paramString.SB = false;
      paramString.apV = 0;
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.apV + ", mIsPeerSupport = " + paramString.SB);
      }
      ivv.arh();
      this.mApp.l(new Object[] { Integer.valueOf(127) });
      return;
      iwu.a(this.mApp, 1020);
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.sq()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amK == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PY))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onPeerSwitchTerminal, local close camera");
        }
        bZ(l);
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        iwu.b(this.mApp, 1021);
      }
      this.mApp.getHandler().postDelayed(this.bL, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.alV();
    }
    paramString.aoj();
  }
  
  ChildLockCircle a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mContext != null)
    {
      localObject1 = localObject2;
      if (this.mContext.get() != null)
      {
        Object localObject3 = (Activity)this.mContext.get();
        localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131373959);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ChildLockCircle((Context)localObject3);
          localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131366050);
          localObject3 = ((ViewGroup)localObject2).getResources();
          int i = ((Resources)localObject3).getDimensionPixelOffset(2131298071);
          int j = ((Resources)localObject3).getDimensionPixelOffset(2131298070);
          int k = ((Resources)localObject3).getDimensionPixelOffset(2131298274);
          localObject3 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, k, 0, 0);
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          ((ChildLockCircle)localObject1).updateText();
        }
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131373949) || (paramInt1 == 2131373950)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.z(paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.i(2131373949, paramBoolean);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373949, paramBoolean);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      QLog.d(this.TAG, 1, "onClick mVideoController == null");
    }
    label792:
    label877:
    do
    {
      String str1;
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
            {
              QLog.d(this.TAG, 1, "onClick mQavPanel == null");
              return;
            }
            if (this.jdField_a_of_type_ComTencentAvVideoController.b().Ql)
            {
              QLog.d(this.TAG, 1, "onClick isChildLock");
              return;
            }
          } while ((this.mContext == null) || (!(this.mContext.get() instanceof AVActivity)));
          str1 = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
          localObject = a();
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131364460: 
          case 2131365755: 
          case 2131374248: 
            ava();
            return;
          case 2131697531: 
            cX(paramLong);
            return;
          case 2131374250: 
            QLog.d(this.TAG, 1, "onClick qav_titlebar_quit_double_screen ");
            ijw.iQ(this.jdField_a_of_type_ComTencentAvVideoController.getChatRoomId(this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin) + "");
            this.c.update(null, new Object[] { Integer.valueOf(134) });
            return;
          case 2131373941: 
          case 2131373942: 
          case 2131373943: 
            QLog.d(this.TAG, 1, "onClick Hangup ");
            bN(paramView);
            return;
          case 2131373939: 
            bool = wc();
            QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + bool);
          }
        } while (!bool);
        boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.b().QB;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          jjk.a(paramView, bool);
          if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.nQ(TraeHelper.aBg);
          return;
        }
        c(paramLong, paramView);
        return;
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if ((paramView != null) && (paramView.uinType == 1044)) {
          anot.a(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d(this.TAG, 1, "onClick HIDE ");
        this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "3");
        com.tencent.av.VideoConstants.a.Mm = "3";
        onBackPressed();
        jjk.d(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        d(paramLong, paramView);
        return;
        i = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
        jjk.cc(paramView.getId(), i);
        b((AVActivity)localObject, str1);
        return;
        QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
        e(paramLong, paramView);
        return;
        h(paramLong, paramView);
        return;
        QLog.w(this.TAG, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        jjb.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
        this.mApp.l(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (!this.jdField_a_of_type_ComTencentAvVideoController.b().isFrontCamera)
        {
          bool = true;
          paramView.isFrontCamera = bool;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.b().isFrontCamera) {
            break label877;
          }
          anot.a(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
        }
        for (i = 2131694261; this.jdField_a_of_type_ComTencentAvUiQavPanel != null; i = 2131694260)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131374253, this.mRes.getString(i));
          return;
          bool = false;
          break label792;
          anot.a(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
        }
        QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          TraeHelper.a().dN(paramLong);
          i = this.jdField_a_of_type_ComTencentAvVideoController.b().uinType;
          paramView = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().MO;
          String str2 = this.jdField_a_of_type_ComTencentAvVideoController.b().MP;
          this.jdField_a_of_type_ComTencentAvVideoController.c(i, paramView, (String)localObject, str2, true);
        }
        jjk.s(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvVideoController.P(str1, this.jdField_a_of_type_ComTencentAvVideoController.b().ana);
        return;
        QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.Voice");
        j(paramLong, paramView);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
      } while ((paramView == null) || (paramView.uinType != 1044));
      anot.a(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
      return;
      QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.Effect");
      k(paramLong, paramView);
      return;
      QLog.d(this.TAG, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
      this.jdField_a_of_type_ComTencentAvVideoController.sendTransferMsg(str1, 1, 5, 1);
      s(2131698124, 0, this.mRes.getDimensionPixelSize(2131299627));
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1)
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().state != 1) {
          break label1324;
        }
      }
      for (int j = 1;; j = 3)
      {
        anot.a(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i, j, "", "", "", "");
        paramView = new Intent((AVActivity)this.mContext.get(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process");
        ((AVActivity)this.mContext.get()).startActivity(paramView);
        S(paramLong, 2131697536);
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if ((paramView == null) || (paramView.uinType != 1044)) {
          break;
        }
        anot.a(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
        return;
        i = 2;
        break label1169;
      }
      QLog.d(this.TAG, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
      anot.a(null, "CliOper", "", "", "0X800A343", "0X800A343", this.jdField_a_of_type_ComTencentAvVideoController.b().amX + 1, 0, "", "", "", "");
      ((AVActivity)this.mContext.get()).mControlUI.kh("Sharpness");
      if (((AVActivity)this.mContext.get()).b.lI() == 1) {
        ((AVActivity)this.mContext.get()).b.dY(paramLong);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 0, false);
      ((AVActivity)this.mContext.get()).jdField_a_of_type_Jci.atB();
      return;
      i(paramLong, paramView);
      return;
      b(paramLong, paramView);
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.b();
    } while ((paramView == null) || (paramView.uinType != 1044));
    label1169:
    label1324:
    anot.a(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
    return;
    f(paramLong, paramView);
    return;
    l(paramLong, paramView);
  }
  
  public void aR(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    iiv localiiv;
    int i;
    label288:
    label372:
    do
    {
      do
      {
        long l;
        do
        {
          return;
          localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
          l = AudioHelper.hG();
          QLog.w(this.TAG, 1, "onInviteReached, peerUin[" + paramString1 + "], showMsg[" + paramString2 + "], remotePhoneState[" + localiiv.amR + "], remoteTerminal[" + localiiv.amO + "], phoneOnLine[" + localiiv.amQ + "], pcOnLine[" + localiiv.amP + "], subState[" + localiiv.li + "], isPeerNetworkWell[" + localiiv.Qf + "], seq[" + l + "]");
        } while ((!localiiv.ta()) || (localiiv.QU) || (localiiv.uinType == 1011) || (!localiiv.peerUin.contains(paramString1)));
        i = localiiv.amR;
        if (i >= 0)
        {
          if (TextUtils.isEmpty(paramString2)) {
            P(l, 2131697558);
          }
        }
        else {
          if (localiiv.li != 0L) {
            break label288;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Jkv != null)
          {
            this.jdField_a_of_type_Jkv.axy();
            this.jdField_a_of_type_Jkv.axz();
          }
          if ((i <= 0) || (i == 3)) {
            break label372;
          }
          mi(i);
          jjk.g(this.jdField_a_of_type_ComTencentAvVideoController);
          return;
          z(l, paramString2);
          break;
          if (localiiv.li == 2L)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.d(localiiv.peerUin, 8, 0L);
            if (!TextUtils.isEmpty(localiiv.MW)) {
              iwu.a(this.mApp, 3008, localiiv.MW);
            }
            anot.a(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
          }
        }
        if (i != 4) {
          break;
        }
      } while ((localiiv.amP != 1) || (localiiv.amQ != 0));
      mi(i);
      return;
    } while ((i != 0) || (!localiiv.Qf) || (localiiv.amO == 2) || (localiiv.amI != 1));
    iwu.b(this.mApp, 1038);
  }
  
  void am(String paramString, int paramInt)
  {
    boolean bool2 = true;
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "avSwitch[" + paramString + "], sessionType[" + paramInt + "], seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
    }
    jkz localjkz;
    if (paramInt == 1)
    {
      refreshUI();
      D(l, false);
      O(l, 65535);
      ml(0);
      new iya.f(l, "avSwitch", 2, null).n(this.mApp);
      localjkz = this.jdField_a_of_type_Jkz;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 1) {
        break label226;
      }
      bool1 = true;
      label149:
      localjkz.lj(bool1);
      localjkz = this.jdField_a_of_type_Jkz;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 1) {
        break label231;
      }
    }
    label226:
    label231:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localjkz.li(bool1);
      y(l, paramString + "_avSwitch");
      return;
      if (paramInt != 2) {
        break;
      }
      D(l, true);
      break;
      bool1 = false;
      break label149;
    }
  }
  
  @TargetApi(11)
  public void amT()
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onPauseVideo, seq[" + l + "]");
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY)
    {
      am("onPauseVideo", 1);
      asx();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onResumeVideo setRotation");
        }
        c(l, 0.0F);
      }
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.b().anm = 0;
    }
  }
  
  public void amW() {}
  
  public void amY()
  {
    if (irc.getGLVersion(this.mApp.getApp()) == 1)
    {
      this.Wh = true;
      return;
    }
    long l = AudioHelper.hG();
    QLog.d(this.TAG, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + this.jdField_a_of_type_ComTencentAvVideoController.b().Qb + ", seq[" + l + "]");
    this.mApp.getHandler().removeCallbacks(this.bK);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qb)
    {
      am("onNeedShowPeerVideo.1", 2);
      O(l, 65535);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().e(l, "onNeedShowPeerVideo.2", 2);
      am("onNeedShowPeerVideo.2", 2);
    }
    this.Wh = true;
  }
  
  public void amZ()
  {
    long l = AudioHelper.hG();
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "onSelfAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.getPeerSdkVersion(str);
    if ((i == 5) || (i == 0))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().li != 1L) {
        super.dC(l);
      }
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
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.sp()) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(l);
            } while (this.jdField_a_of_type_ComTencentAvVideoController.b().li == 1L);
            super.dC(l);
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.b().QZ);
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(l);
      } while (this.jdField_a_of_type_ComTencentAvVideoController.b().li == 1L);
      super.dC(l);
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(l);
    } while (this.jdField_a_of_type_ComTencentAvVideoController.b().li == 1L);
    super.dC(l);
  }
  
  public void ana()
  {
    long l = AudioHelper.hG();
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "onOppositeAudioEngineReady, seq[" + l + "]");
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.getPeerSdkVersion(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.sp()) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().QY)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(l);
    super.dC(l);
  }
  
  public void asm()
  {
    this.mApp.getHandler().postDelayed(new DoubleVideoCtrlUI.6(this), 100L);
  }
  
  void asn()
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 21) || (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1011)) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374249, 8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374253, 8);
      AVActivity localAVActivity = a();
      if (localAVActivity != null) {
        localAVActivity.jl(false);
      }
    }
  }
  
  public void aso()
  {
    super.aso();
    this.mIsPaused = true;
    asp();
    asv();
  }
  
  public void asq()
  {
    long l = AudioHelper.hG();
    QLog.d(this.TAG, 1, "onResumeVideo, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.b().amI + "], seq[" + l + "]");
    if (irc.getGLVersion(this.mApp.getApp()) == 1)
    {
      iwu.a(this.mApp, 1012, this.mApp.getApp().getString(2131721742));
      anot.a(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      anot.a(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().e(l, "onResumeVideo", 2);
      am("onResumeVideo", 2);
      ThreadManager.excute(new DoubleVideoCtrlUI.11(this, l), 16, null, false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qm) {
        jC(true);
      }
    }
    for (;;)
    {
      dE(l);
      return;
      O(l, 65535);
    }
  }
  
  void asr()
  {
    auR();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Jks);
  }
  
  void ass()
  {
    kl(true);
    if (this.jdField_a_of_type_Jcr != null) {
      this.jdField_a_of_type_Jcr.a(new iye(this));
    }
  }
  
  public void ast()
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$a.reset();
    O(-1027L, 65535);
  }
  
  void asu()
  {
    ChildLockCircle localChildLockCircle = a();
    if (localChildLockCircle != null) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().Ql)) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localChildLockCircle.lm(bool);
      return;
    }
  }
  
  void asv()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mContext != null)
    {
      localObject1 = localObject2;
      if (this.mContext.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.mContext.get()).findViewById(2131373959);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).asv();
    }
  }
  
  void asw()
  {
    this.mApp.getHandler().removeCallbacks(this.bO);
    this.mApp.getHandler().postDelayed(this.bO, 3000L);
  }
  
  public void asx()
  {
    long l = AudioHelper.hG();
    asv();
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().Ql)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().Ql = false;
      this.mApp.l(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.mApp.getHandler().postDelayed(new DoubleVideoCtrlUI.22(this, l), 300L);
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 0, false);
    paramView = a();
    if (paramView != null)
    {
      if (!paramView.jdField_a_of_type_Jgg.xj()) {
        break label44;
      }
      paramView.jdField_a_of_type_Jgg.nw(3);
    }
    for (;;)
    {
      ily.report("0X800A8D0");
      return;
      label44:
      paramView.jdField_a_of_type_Jgg.nt(0);
    }
  }
  
  void b(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    QLog.w(this.TAG, 1, "onClick QavPanel.ViewID.CALL_PHONE, type[" + i + "], PhoneNum[" + AudioHelper.s(this.jdField_a_of_type_ComTencentAvVideoController.b().gK()) + "]");
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentAvVideoController.b().gK())));
    anot.a(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.Ox = true;
    this.jdField_a_of_type_ComTencentAvVideoController.O(paramString, 236);
    this.jdField_a_of_type_ComTencentAvVideoController.ko(236);
    this.jdField_a_of_type_ComTencentAvVideoController.P(paramString, 0);
  }
  
  void bN(View paramView)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onClick_Hangup, seq[" + l + "]");
    int i = paramView.getId();
    if ((i == 2131373941) || (i == 2131373942)) {
      igd.aK(this.TAG, "exit when click bottom bar hangup");
    }
    String str;
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
      paramView = new iya.d(paramView);
      this.mApp.l(new Object[] { Integer.valueOf(9002), paramView });
      if (!paramView.Wa) {
        break;
      }
      QLog.w(this.TAG, 1, "onClick_Hangup, mBlockName[" + paramView.Rj + "]");
      return;
      if (i == 2131373943) {
        igd.aK(this.TAG, "exit when click bottom bar hangup no answer");
      }
    }
    kl(true);
    this.jdField_a_of_type_Jcr.a(new iyk(this, l, str));
  }
  
  public void bQ(long paramLong)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    long l = this.jdField_a_of_type_ComTencentAvVideoController.getChatRoomId(localiiv.peerUin);
    QLog.w(this.TAG, 1, "onConnected, roomid[" + l + "], mNeedRemoveAudioCallback[" + this.Vu + "], seq[" + paramLong + "]");
    super.bQ(paramLong);
    db(paramLong);
    if (l > 0L) {
      ((ikr)this.mApp.a(4)).d(l, 26, l);
    }
    String str = l + "";
    jfq.aj(localiiv.amI, str + "");
    if (localiiv.amL != 4) {
      P(paramLong, 2131697685);
    }
    iwu.a(this.mApp, 1038);
    iwu.a(this.mApp, 1050);
    iwu.a(this.mApp, 1049);
    label294:
    label316:
    int i;
    int j;
    label368:
    jkz localjkz;
    if (!localiiv.PT)
    {
      if (localiiv.QB)
      {
        anot.a(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
        if (!localiiv.PV) {
          break label591;
        }
        anot.a(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
        jjk.c(this.jdField_a_of_type_ComTencentAvVideoController);
      }
    }
    else
    {
      if (localiiv.amI != 2) {
        break label622;
      }
      D(paramLong, true);
      C(paramLong, true);
      str = localiiv.peerUin;
      i = this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(str);
      j = this.jdField_a_of_type_ComTencentAvVideoController.getPeerSdkVersion(str);
      if (i != 5) {
        break label641;
      }
      if (!localiiv.QY) {
        break label630;
      }
      super.dC(paramLong);
      localjkz = this.jdField_a_of_type_Jkz;
      if (localiiv.amI != 1) {
        break label766;
      }
    }
    label591:
    label622:
    label630:
    label766:
    for (boolean bool = true;; bool = false)
    {
      localjkz.li(bool);
      i = localiiv.uinType;
      this.mApp.T(i, str);
      this.mApp.l(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_Jkv != null)
      {
        this.jdField_a_of_type_Jkv.axy();
        this.jdField_a_of_type_Jkv.axA();
        this.jdField_a_of_type_Jkv.axw();
        this.jdField_a_of_type_Jkv = null;
      }
      if (localiiv.Qb) {
        this.mApp.getHandler().removeCallbacks(this.cc);
      }
      if (localiiv.amI == 2)
      {
        QLog.w(this.TAG, 1, "onConnected, CheckRemoteCameraRunnable");
        this.mApp.getHandler().removeCallbacks(this.bK);
        this.mApp.getHandler().postDelayed(this.bK, 5000L);
      }
      if ((localiiv.Qb) && (!localiiv.PZ)) {
        am("onConnected", 1);
      }
      return;
      anot.a(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      anot.a(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      break label294;
      km(true);
      break label316;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.dd(paramLong);
      break label368;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.sp())
      {
        if (localiiv.QY)
        {
          super.dC(paramLong);
          break label368;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.dd(paramLong);
        break label368;
      }
      if (!localiiv.isConnected())
      {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.dd(paramLong);
        break label368;
      }
      if (j > 18)
      {
        if ((localiiv.QY) && (localiiv.QZ))
        {
          super.dC(paramLong);
          break label368;
        }
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.dd(paramLong);
        break label368;
      }
      if (localiiv.QY)
      {
        super.dC(paramLong);
        break label368;
      }
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.dd(paramLong);
      break label368;
    }
  }
  
  public void bZ(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onBeforeCloseCamera, seq[" + paramLong + "]");
    }
    O(paramLong, 65535);
  }
  
  public void bv(int paramInt1, int paramInt2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onTerSwitchSyncStatus, cameraStatus[" + paramInt1 + "], micStatus[" + paramInt2 + "]");
    }
    if (isDestroyed()) {
      return;
    }
    if (paramInt1 == 1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      label103:
      iiv localiiv;
      label155:
      boolean bool;
      if (paramInt1 == 0)
      {
        bZ(l);
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if ((paramInt1 == 0) && (!localiiv.PZ)) {
          break label328;
        }
        if (localiiv.amI == 1)
        {
          localiiv.e(l, "onTerSwitchSyncStatus.1", 2);
          am("onTerSwitchSyncStatus.1", localiiv.amI);
        }
        if (paramInt2 != 0) {
          break label362;
        }
        bool = true;
        label162:
        localiiv.O("onTerSwitchSyncStatus", bool);
        if (paramInt2 != 0) {
          break label368;
        }
      }
      String str;
      label328:
      label362:
      label368:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localiiv.Z("onTerSwitchSyncStatus", paramInt1);
        str = localiiv.peerUin;
        if (!localiiv.PV) {
          break label373;
        }
        super.mY(2131373947);
        this.mApp.l(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.b(true, str);
        if ((this.mContext.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getResources().getString(2131690630));
        return;
        da(l);
        this.mApp.l(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l) });
        break label103;
        if (localiiv.amI != 2) {
          break label155;
        }
        localiiv.e(l, "onTerSwitchSyncStatus.2", 1);
        am("onTerSwitchSyncStatus.2", localiiv.amI);
        break label155;
        bool = false;
        break label162;
      }
      label373:
      super.mZ(2131373947);
      this.mApp.l(new Object[] { Integer.valueOf(108) });
      this.jdField_a_of_type_ComTencentAvVideoController.b(false, str);
      if ((this.mContext.get() == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getResources().getString(2131690618));
      return;
    }
  }
  
  void c(long paramLong, View paramView)
  {
    boolean bool = wc();
    QLog.w(this.TAG, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.b().Qd + "], localMute[" + this.jdField_a_of_type_ComTencentAvVideoController.b().PV + "], seq[" + paramLong + "], canClick[" + bool + "]");
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool)) {
      v(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin);
    }
    super.dE(paramLong);
  }
  
  public void c(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void cU(long paramLong)
  {
    super.cU(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().ta())
      {
        if (!AVReport.a().UN) {
          break label196;
        }
        ikp.kQ(29);
        AVReport.a().np = SystemClock.elapsedRealtime();
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amR < 0) {
          break label414;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType != 1011) {
          break label208;
        }
        P(-1015L, 2131697623);
        if (this.jdField_a_of_type_Jkv != null) {
          this.jdField_a_of_type_Jkv.axx();
        }
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected()) {
        this.mApp.getHandler().postDelayed(this.bM, 20000L);
      }
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected())
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
        if ((i == 1) || (i == 3) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qm)) {
          break label431;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b().Ql = false;
        jC(false);
      }
      return;
      label196:
      AVReport.a().nF = SystemClock.elapsedRealtime();
      break;
      label208:
      P(-1015L, 2131697558);
      long l = this.jdField_a_of_type_ComTencentAvVideoController.b().colorRingId;
      String str = aqpr.p(l, 3);
      if (new File(str).exists())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PU) {
          TraeHelper.a().a(paramLong, this.mApp, 0, str, -1, null);
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.b().vipType;
        anot.a(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i, l + "", "", "");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Jkv == null) {
          break label412;
        }
        this.jdField_a_of_type_Jkv.axy();
        this.jdField_a_of_type_Jkv.axz();
        break;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PU) {
          TraeHelper.a().a(paramLong, this.mApp, 2131230756, null, -1, null);
        }
      }
      label412:
      continue;
      label414:
      if (this.jdField_a_of_type_Jkv != null) {
        this.jdField_a_of_type_Jkv.axx();
      }
    }
    label431:
    asx();
  }
  
  public void cV(long paramLong)
  {
    boolean bool2 = false;
    super.cV(paramLong);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (((iiv)localObject1).isConnected())
    {
      if (((iiv)localObject1).li != 1L) {
        super.dC(paramLong);
      }
      localObject2 = this.jdField_a_of_type_Jkz;
      if (((iiv)localObject1).amI != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((jkz)localObject2).li(bool1);
      refreshUI();
      jjk.c(this.jdField_a_of_type_ComTencentAvVideoController);
      this.mIsPaused = false;
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!((iiv)localObject1).Rk)) {
        break;
      }
      this.mApp.getHandler().postDelayed(new DoubleVideoCtrlUI.9(this), 200L);
      return;
    }
    localObject1 = this.TAG;
    Object localObject2 = new StringBuilder().append("onResume, AsyncReadDoubleGlassConfig, mVideoController[");
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      bool1 = true;
    }
    QLog.w((String)localObject1, 1, bool1 + "]");
    asm();
  }
  
  public void cW(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.Yk)) {
      QLog.w(this.TAG, 1, "onStop, mRequestPermissionIng[" + this.Yk + "], seq[" + paramLong + "]");
    }
    super.cW(paramLong);
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected())) {
      super.dD(paramLong);
    }
  }
  
  protected void cX(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$a.a(paramLong, this.mApp, a());
      O(paramLong, 65535);
      S(paramLong, 2131697531);
    }
  }
  
  public void cY(long paramLong) {}
  
  public void cZ(long paramLong)
  {
    boolean bool2 = false;
    if (isDestroyed()) {}
    jiu localjiu;
    do
    {
      return;
      localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697531);
      if (localjiu != null) {
        break;
      }
    } while (!Yj);
    QLog.w(this.TAG, 1, "updateBtn_Record, null, seq[" + paramLong + "]");
    return;
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    boolean bool1;
    if ((localiiv.amI == 3) || (localiiv.amI == 4) || (localiiv.amI == 1))
    {
      bool1 = bool2;
      if (Yj)
      {
        QLog.w(this.TAG, 1, "updateBtn_Record, 场景不支持, seq[" + paramLong + "]");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localjiu.nD(a.d(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$a));
      localjiu.setVisiable(bool1);
      return;
      AVActivity localAVActivity = a();
      if (localAVActivity.jdField_a_of_type_Jdh == null)
      {
        bool1 = bool2;
        if (Yj)
        {
          QLog.w(this.TAG, 1, "updateBtn_Record, !mRecordUiCtrl, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if (!localAVActivity.jdField_a_of_type_Jdh.isEnableRecord())
      {
        bool1 = bool2;
        if (Yj)
        {
          QLog.w(this.TAG, 1, "updateBtn_Record, !isEnableRecord, seq[" + paramLong + "]");
          bool1 = bool2;
        }
      }
      else if ((!localiiv.PY) || (!localiiv.PZ))
      {
        bool1 = bool2;
        if (Yj)
        {
          QLog.w(this.TAG, 1, "updateBtn_Record, sessionInfo.localHasVideo, seq[" + localiiv.PY + "][sessionInfo.remoteHasVideo=" + localiiv.PZ + "]");
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public boolean ct(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (localObject == null) {
      return false;
    }
    if (!((iiv)localObject).Rk) {
      return false;
    }
    if (!((iiv)localObject).PZ)
    {
      QLog.w(this.TAG, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + paramInt + "]");
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((iiv)localObject).anm != paramInt)) {
      QLog.w(this.TAG, 1, "setGlassSwitch, GlassSwitch[" + ((iiv)localObject).anm + "->" + paramInt + "]");
    }
    if (((iiv)localObject).anm == paramInt) {
      return false;
    }
    ((iiv)localObject).anm = paramInt;
    if ((this.mContext == null) || (this.mContext.get() == null)) {
      return false;
    }
    localObject = (AVActivity)this.mContext.get();
    if ((localObject == null) || (((AVActivity)localObject).b == null)) {
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      ((AVActivity)localObject).b.wY();
      iwu.a(this.mApp, 3011);
      continue;
      ((AVActivity)localObject).b.wX();
      iwu.b(this.mApp, 3011);
      continue;
      ((AVActivity)localObject).b.wY();
      iwu.a(this.mApp, 3011);
      continue;
      ((AVActivity)localObject).b.wX();
      iwu.b(this.mApp, 1039);
    }
  }
  
  public int cv(int paramInt)
  {
    b(this.mApp, paramInt);
    return 0;
  }
  
  void d(long paramLong, View paramView)
  {
    Object localObject = new iya.d(paramView);
    if (paramView != null) {
      this.mApp.l(new Object[] { Integer.valueOf(9001), localObject });
    }
    if (((iya.d)localObject).Wa) {
      QLog.w(this.TAG, 1, "onClick_Camera, mBlockName[" + ((iya.d)localObject).Rj + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      S(paramLong, 2131697526);
      return;
      if (a(paramLong, "android.permission.CAMERA", paramView))
      {
        iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
        jjk.j(this.jdField_a_of_type_ComTencentAvVideoController);
        if (localiiv.amI == 1)
        {
          ioa localioa = new ioa();
          localObject = localiiv.peerUin;
          paramView = (View)localObject;
          if (((String)localObject).startsWith("+")) {
            paramView = ((String)localObject).substring(1);
          }
          localioa.uin = jji.B(paramView);
          localioa.videoSrcType = 1;
          paramView = new ArrayList();
          paramView.add(localioa);
          this.mApp.l(new Object[] { Integer.valueOf(104), paramView });
          da(paramLong);
          this.mApp.l(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 1, "onClick_Camera, open1, seq[" + paramLong + "]");
          }
          anot.a(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
          if (localiiv.Qm) {
            this.mApp.getHandler().postDelayed(new DoubleVideoCtrlUI.14(this), 500L);
          }
        }
        else if (localiiv.amI == 2)
        {
          if (localiiv.PY)
          {
            bZ(paramLong);
            this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.TAG, 1, "onClick_Camera, close, seq[" + paramLong + "]");
            }
          }
          else
          {
            da(paramLong);
            this.mApp.l(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
            if (QLog.isColorLevel()) {
              QLog.w(this.TAG, 1, "onClick_Camera, open2, seq[" + paramLong + "]");
            }
          }
        }
      }
    }
  }
  
  public void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (isDestroyed()) {
      return;
    }
    AVActivity localAVActivity = null;
    if (this.mContext.get() != null) {
      localAVActivity = (AVActivity)this.mContext.get();
    }
    boolean bool;
    if (localAVActivity != null) {
      if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(this.TAG, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], isConnected[" + this.jdField_a_of_type_ComTencentAvVideoController.b().state + "], mCameraNum[" + this.aoI + "], remoteHasVideo[" + this.jdField_a_of_type_ComTencentAvVideoController.b().PZ + "], checkCameraResult[" + bool + "], seq[" + paramLong + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374249, 0);
        localAVActivity = a();
        if (localAVActivity != null) {
          localAVActivity.jl(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qc = true;
        if ((paramInt == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().QB) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName))) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axK();
        }
        jjk.awX();
        jjk.o(this.jdField_a_of_type_ComTencentAvVideoController);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ) && (this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected())) {
          am("onAfterOpenCamera", 2);
        }
        dE(paramLong);
      }
      O(paramLong, 65535);
      return;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public void da(long paramLong)
  {
    O(paramLong, 65535);
  }
  
  public void db(long paramLong)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected())
    {
      jiu localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697532);
      if (localjiu != null) {
        localjiu.setVisiable(false);
      }
      return;
    }
    super.db(paramLong);
  }
  
  void f(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setTitleText, mRingAnimator[" + this.jdField_a_of_type_Jkv.ZO + "], startRingAnimator[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (!TextUtils.isEmpty(paramString)) {
      z(paramLong, paramString);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Jkv != null))
    {
      this.jdField_a_of_type_Jkv.axy();
      this.jdField_a_of_type_Jkv.axz();
    }
  }
  
  public void g(long paramLong, View paramView)
  {
    if (Math.abs(SystemClock.elapsedRealtime() - this.ou) < 1000L) {}
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (paramView == null);
    jll.kQ("0x800AD8D");
    this.ou = SystemClock.elapsedRealtime();
    S(paramLong, 2131697532);
    paramView.cy(paramLong);
  }
  
  protected int getLayout()
  {
    return 2131559896;
  }
  
  public void hF(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onNotRecvAudioData, bNotRecv[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean) {
      this.axy = 1;
    }
    while (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin) == 5)
      {
        return;
        this.axy = 2;
      }
      else
      {
        iwu.b(this.mApp, 3005);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin) == 5) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(l);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().li == 1L) {
        break;
      }
      super.dC(l);
      return;
      iwu.a(this.mApp, 3005);
    }
  }
  
  void i(Bitmap paramBitmap)
  {
    paramBitmap = this.jdField_a_of_type_ComTencentAvVideoController.getCircleFaceBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (this.gr != null) {
      this.gr.setImageBitmap(paramBitmap);
    }
  }
  
  public void i(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setQCallHead uin = " + paramString);
      }
      if (this.gr != null) {
        this.gr.setImageBitmap(paramBitmap);
      }
    }
    super.i(paramString, paramBitmap);
  }
  
  public void iD(String paramString) {}
  
  void initUI()
  {
    super.initUI();
    long l = AudioHelper.hG();
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 2) {
        break label468;
      }
      bool = true;
      localQavPanel.g(2131559945, bool, BeautyToolbar.checkShowBeauty(this.jdField_a_of_type_ComTencentAvVideoController, this.mApp));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.atX();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1044) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setNoVideoAndShareBtnMode();
      }
    }
    F(l, this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
    this.mE = ((TextView)this.mRootView.findViewById(2131372190));
    this.mD = ((TextView)this.mRootView.findViewById(2131374250));
    this.dY = ((RelativeLayout)this.mRootView.findViewById(2131373978));
    if (AudioHelper.jY(0) == 1) {
      this.dY.setBackgroundColor(2147483392);
    }
    if (Build.VERSION.SDK_INT <= 20)
    {
      QLog.d(this.TAG, 1, "need reset quit double screen listener");
      this.mD.setOnClickListener(new iyl(this));
    }
    this.gK = ((ImageView)this.mRootView.findViewById(2131373969));
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373941, this.mRes.getString(2131690628));
      }
      D(l, false);
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().Qd) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.i(2131373947, false);
      }
      y(l, "initUI");
      this.jdField_a_of_type_Jcr = new jcr((Context)this.mContext.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.er, null, this.mRootView.findViewById(2131373988), this.mC, this.mRootView.findViewById(2131374119), null);
      jjp.bz(BaseApplicationImpl.getApplication());
      if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1) && ((this.jdField_a_of_type_ComTencentAvVideoController.b().state == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.b().state == 0))) {
        anot.a(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
      }
      return;
      label468:
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373941, this.mRes.getString(2131721711));
      }
      D(l, true);
    }
  }
  
  void jA(boolean paramBoolean)
  {
    int i = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.lk(paramBoolean);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
    }
    QavPanel localQavPanel;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType != 9500) || (this.jdField_a_of_type_ComTencentAvVideoController.OT)) {
          break label135;
        }
        localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)
        {
          paramBoolean = bool1;
          localQavPanel.c(paramBoolean, 0, false);
        }
      }
      else if (this.mC != null)
      {
        this.mC.setTextColor(this.mApp.getApp().getResources().getColor(2131166294));
      }
    }
    label135:
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
      paramBoolean = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {
        paramBoolean = true;
      }
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (paramBoolean) {}
      for (;;)
      {
        localQavPanel.c(paramBoolean, i, true);
        break;
        i = 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 9500) && (!this.jdField_a_of_type_ComTencentAvVideoController.OT))
    {
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {}
      for (paramBoolean = bool3;; paramBoolean = false)
      {
        localQavPanel.c(paramBoolean, 0, false);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)
    {
      paramBoolean = true;
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (!paramBoolean) {
        break label290;
      }
    }
    for (;;)
    {
      localQavPanel.c(paramBoolean, i, false);
      return;
      paramBoolean = false;
      break;
      label290:
      i = 1;
    }
  }
  
  public void jC(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Ql)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().Ql = true;
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qn = this.Ya;
      if (this.Ya) {
        ml(0);
      }
      this.mApp.l(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  public void jY(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 25)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().MO = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setQCallNickName");
      }
      if (this.mC != null) {
        this.mC.setText(paramString);
      }
    }
    super.jY(paramString);
  }
  
  public void jZ(String paramString)
  {
    super.jZ(paramString);
    this.jdField_a_of_type_ComTencentAvVideoController.b().Qm = false;
    asx();
  }
  
  public void jy(boolean paramBoolean)
  {
    View localView;
    if (this.mRootView != null)
    {
      localView = this.mRootView.findViewById(2131363675);
      if (localView != null)
      {
        if ((!paramBoolean) || (localView.getVisibility() == 0)) {
          break label39;
        }
        localView.setVisibility(0);
      }
    }
    label39:
    while ((paramBoolean) || (localView.getVisibility() == 8)) {
      return;
    }
    localView.setVisibility(8);
  }
  
  void lM(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1011) && (paramInt != 2131697623) && (paramInt != 2131721705)) {}
    while (paramInt <= 0) {
      return;
    }
    P(-1016L, paramInt);
  }
  
  void mi(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
  
  public void mj(int paramInt)
  {
    long l = AudioHelper.hG();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected()))
    {
      if (!this.Ya) {
        ml(paramInt);
      }
      return;
    }
    ml(paramInt);
    dE(l);
  }
  
  public void mk(int paramInt)
  {
    if (1 == paramInt) {
      if (!this.mIsPaused)
      {
        asu();
        this.mApp.getHandler().removeCallbacks(this.bN);
      }
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt == 0)
            {
              asv();
              this.mApp.getHandler().removeCallbacks(this.bN);
              return;
            }
          } while (2 == paramInt);
          if (3 != paramInt) {
            break;
          }
          localObject1 = a();
        } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().amU != 2) || (localObject1 == null) || (!((ChildLockSign)localObject1).isEnabled()));
        if (((ChildLockSign)localObject1).getVisibility() != 0)
        {
          ((ChildLockSign)localObject1).setLocked(true);
          ((ChildLockSign)localObject1).setVisibility(0);
          asw();
          return;
        }
        ((ChildLockSign)localObject1).setVisibility(8);
        this.mApp.getHandler().removeCallbacks(this.bO);
        return;
      } while (4 != paramInt);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.mContext != null)
      {
        localObject1 = localObject2;
        if (this.mContext.get() != null) {
          localObject1 = (ChildLockCircle)((Activity)this.mContext.get()).findViewById(2131373959);
        }
      }
    } while (localObject1 == null);
  }
  
  public void ml(int paramInt)
  {
    super.ml(paramInt);
  }
  
  public void mm(int paramInt)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (paramInt != localiiv.ann) {
      QLog.w(this.TAG, 1, "setGlassWaitTime, WaitTime[" + localiiv.ann + "->" + paramInt + "]");
    }
    localiiv.ann = paramInt;
  }
  
  public void mn(int paramInt)
  {
    H(paramInt, true);
  }
  
  public boolean onBackPressed()
  {
    long l = AudioHelper.hG();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "onBackPressed, seq[" + l + "], isChildLock[" + ((iiv)localObject).Ql + "]");
    if (((iiv)localObject).Ql) {
      return true;
    }
    if (super.onBackPressed())
    {
      QLog.w(this.TAG, 1, "onBackPressed called return 2, seq[" + l + "]");
      return true;
    }
    asp();
    String str = ((iiv)localObject).peerUin;
    this.mApp.l(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((!ivv.tY()) && (((iiv)localObject).amI == 2) && (((iiv)localObject).PY)) {
      s(2131697686, 1, this.mRes.getDimensionPixelSize(2131299627));
    }
    if ((((iiv)localObject).tf()) || (((iiv)localObject).tg()))
    {
      lQ(((iiv)localObject).ana);
      this.mApp.getHandler().postDelayed(new DoubleVideoCtrlUI.13(this, l), 150L);
    }
    if (ivv.tY())
    {
      localObject = (Context)this.mContext.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((ivm)localObject).onBackPressed();
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    long l = AudioHelper.hG();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "avideo onCreate, state[" + ((iiv)localObject).state + "], seq[" + l + "]");
    initUI();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axJ();
    if (((iiv)localObject).relationType == 0) {
      ((iiv)localObject).relationType = 3;
    }
    int j;
    int i;
    if ((((iiv)localObject).sY()) || (((iiv)localObject).tc()))
    {
      j = 1;
      if (((iiv)localObject).QE) {
        j = 0;
      }
      i = 1;
      if (!((iiv)localObject).isFriend) {
        i = 4;
      }
      if (1008 == ((iiv)localObject).uinType) {
        i = 4;
      }
    }
    label390:
    label525:
    label1191:
    for (;;)
    {
      if (((iiv)localObject).PT) {}
      for (i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((iiv)localObject).peerUin, j, i);; i = this.jdField_a_of_type_ComTencentAvVideoController.a(l, ((iiv)localObject).peerUin, j, i, ((iiv)localObject).MR, ((iiv)localObject).MS, ((iiv)localObject).gK(), ((iiv)localObject).uinType, ((iiv)localObject).MP, ((iiv)localObject).MQ, ((iiv)localObject).signature, null, null, 0, 0, null, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "result = " + i);
        }
        if (i == 0) {
          break label390;
        }
        igd.aK(this.TAG, "Video connect fail:" + i);
        if (i == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.O(((iiv)localObject).peerUin, 238);
          this.jdField_a_of_type_ComTencentAvVideoController.ko(238);
          this.jdField_a_of_type_ComTencentAvVideoController.P(((iiv)localObject).peerUin, 9);
        }
        this.Ox = true;
        if (this.mContext.get() != null)
        {
          localObject = (Activity)this.mContext.get();
          if (localObject != null) {
            ((Activity)localObject).finish();
          }
        }
        return;
        if (1044 != ((iiv)localObject).uinType) {
          break label1191;
        }
        i = 4;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "onCreate, ofter Request, state[" + ((iiv)localObject).state + "], SessionType[" + ((iiv)localObject).amI + "], deviceName[" + ((iiv)localObject).deviceName + "], seq[" + l + "]");
      }
      label495:
      String str;
      if (((iiv)localObject).ta())
      {
        if (((iiv)localObject).amI == 1)
        {
          this.QK = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService(this.QK);
        }
      }
      else
      {
        if (!((iiv)localObject).isConnected()) {
          break label756;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.sr()) {
          break label708;
        }
        if (((iiv)localObject).amI == 2) {
          D(l, true);
        }
        i = ((iiv)localObject).uinType;
        str = ((iiv)localObject).peerUin;
        this.mApp.T(i, str);
        label563:
        if (((iiv)localObject).Qb) {
          refreshUI();
        }
        if (((iiv)localObject).QE)
        {
          this.jdField_a_of_type_Jkz.lj(true);
          this.jdField_a_of_type_Jkz.lj(true);
        }
        if (!((iiv)localObject).PV) {
          break label1134;
        }
        super.mY(2131373947);
        if ((this.mContext.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getResources().getString(2131690630));
        }
      }
      for (;;)
      {
        C(l, false);
        this.mRootView.post(new DoubleVideoCtrlUI.8(this));
        if (this.jdField_a_of_type_Jcr == null) {
          break;
        }
        this.jdField_a_of_type_Jcr.atK();
        return;
        this.QK = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        break label495;
        label708:
        if ((this.jdField_a_of_type_ComTencentAvVideoController.bt() < 2L) || (((iiv)localObject).PW) || (this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(((iiv)localObject).peerUin) != 5)) {
          break label525;
        }
        jjk.h(this.jdField_a_of_type_ComTencentAvVideoController);
        break label525;
        label756:
        if (((iiv)localObject).isConnecting())
        {
          if (((iiv)localObject).QE) {}
          for (i = 2131697696;; i = 2131721776)
          {
            lM(i);
            break;
          }
        }
        if (((iiv)localObject).ta())
        {
          i = 2131698074;
          if (((iiv)localObject).QU) {
            i = 2131698075;
          }
          if (((iiv)localObject).uinType == 1011) {
            i = 2131697623;
          }
          if (((iiv)localObject).QE)
          {
            QLog.w(this.TAG, 1, "Inviting, remotePhoneState[" + ((iiv)localObject).amR + "], isPeerNetworkWell[" + ((iiv)localObject).Qf + "], remoteOnline[" + ((iiv)localObject).Qg + "], remoteTerminal[" + ((iiv)localObject).amO + "]");
            if ((((iiv)localObject).amR == 0) && (((iiv)localObject).Qf) && (((iiv)localObject).amO != 2) && (((iiv)localObject).amI == 1)) {
              iwu.b(this.mApp, 1038);
            }
          }
          lM(i);
          i = ((iiv)localObject).uinType;
          str = ((iiv)localObject).peerUin;
          this.mApp.T(i, str);
          i = ((iiv)localObject).amR;
          if ((i == 4) && (((iiv)localObject).amP == 1) && (((iiv)localObject).amQ == 0)) {
            mi(i);
          }
          if ((i <= 0) || (i == 3)) {
            break label563;
          }
          mi(i);
          jjk.g(this.jdField_a_of_type_ComTencentAvVideoController);
          break label563;
        }
        if (((iiv)localObject).tc())
        {
          lM(2131697885);
          break label563;
        }
        if ((!((iiv)localObject).tf()) && (!((iiv)localObject).tg())) {
          break label563;
        }
        lQ(((iiv)localObject).ana);
        if (((iiv)localObject).uinType == 1011) {
          lM(2131698046);
        }
        this.mApp.getHandler().postDelayed(new DoubleVideoCtrlUI.7(this, l), 150L);
        break label563;
        label1134:
        super.mZ(2131373947);
        if ((this.mContext.get() != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getResources().getString(2131690618));
        }
      }
    }
  }
  
  public void onDestroy(long paramLong)
  {
    QLog.w(this.TAG, 1, "onDestroy, seq[" + paramLong + "]");
    if (this.m != null)
    {
      this.m.cancel();
      this.m = null;
    }
    if (this.mApp != null)
    {
      this.mApp.iw("DoubleVideoCtrlUI");
      this.mApp.getHandler().removeCallbacks(this.bK);
      this.mApp.getHandler().removeCallbacks(this.bL);
      this.mApp.getHandler().removeCallbacks(this.bM);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable.remove(paramLong);
      kt(true);
    }
    if (this.mRootView != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131366050);
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
      this.mRootView.removeAllViews();
    }
    this.VB = false;
    this.axv = 0;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    this.mRes = null;
    this.c = null;
    this.jdField_a_of_type_Jks = null;
    this.gK = null;
    this.mC = null;
    this.gr = null;
    this.orientationListener = null;
    if (this.jdField_a_of_type_Jcr != null)
    {
      this.jdField_a_of_type_Jcr.destroy();
      this.jdField_a_of_type_Jcr = null;
    }
    super.onDestroy(paramLong);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Ql) {
        bool = true;
      }
      return bool;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
    return false;
  }
  
  public void onServiceConnected()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().ta())
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.b().uinType;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
      this.mApp.T(i, str);
    }
  }
  
  public void q(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1) {
      O(paramLong, 65535);
    }
  }
  
  public void r(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().PY)
      {
        bZ(paramLong);
        this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 1, "onDetectNoDevicePermission local close camera, remote[" + this.jdField_a_of_type_ComTencentAvVideoController.b().PZ + "]");
        }
      }
      QLog.w(this.TAG, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qc = false;
      O(paramLong, 65535);
    }
    super.r(paramLong, paramInt);
  }
  
  public void refreshUI()
  {
    if (isDestroyed()) {
      return;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "refreshUI, SessionType[" + localiiv.amI + "], seq[" + l + "]");
    }
    int i = localiiv.uinType;
    String str = localiiv.peerUin;
    Object localObject3 = localiiv.MP;
    Object localObject2 = this.mApp.a(i, str, (String)localObject3, true, true);
    Object localObject1 = localiiv.MO;
    if (localiiv.PT)
    {
      localObject1 = this.mApp.getDisplayName(i, str, (String)localObject3);
      localiiv.MO = ((String)localObject1);
    }
    if (this.gr == null) {
      this.gr = ((ImageView)this.mRootView.findViewById(2131373989));
    }
    if (this.mC == null) {
      this.mC = ((TextView)this.mRootView.findViewById(2131373990));
    }
    if (this.mE == null)
    {
      this.mE = ((TextView)this.mRootView.findViewById(2131372190));
      if (localiiv.amI == 2) {
        D(l, true);
      }
    }
    else
    {
      if (localiiv.amI != 2) {
        break label483;
      }
      D(l, true);
      label248:
      if (localiiv.uinType == 1011)
      {
        if (localiiv.a.ba == null) {
          break label500;
        }
        i(localiiv.a.ba);
        if (this.mC != null) {
          this.mC.setText(localiiv.a.nickName);
        }
        if (this.mE != null) {
          this.mE.setText(localiiv.a.nickName);
        }
      }
      label282:
      if (localiiv.uinType != 25) {
        break label555;
      }
      localObject2 = localiiv.gK();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localiiv.MP;
      }
      localObject2 = this.mApp.getDisplayName(i, str, (String)localObject1);
      localObject3 = this.mApp.a(i, str, (String)localObject1, true, true);
      this.jdField_a_of_type_ComTencentAvVideoController.n(str);
      if (this.gr != null) {
        this.gr.setImageBitmap((Bitmap)localObject3);
      }
      if ((!((String)localObject2).equals(localiiv.peerUin)) || (localObject1 == null)) {
        break label520;
      }
      if (this.mC != null) {
        this.mC.setText((CharSequence)localObject1);
      }
      if (this.mE != null) {
        this.mE.setText((CharSequence)localObject1);
      }
    }
    for (;;)
    {
      O(l, 65535);
      return;
      D(l, false);
      break;
      label483:
      if (localiiv.amI != 1) {
        break label248;
      }
      jA(false);
      break label248;
      label500:
      if (this.gr == null) {
        break label282;
      }
      this.gr.setImageBitmap(aqhu.G());
      break label282;
      label520:
      if (this.mC != null) {
        this.mC.setText((CharSequence)localObject2);
      }
      if (this.mE != null)
      {
        this.mE.setText((CharSequence)localObject2);
        continue;
        label555:
        if ((this.gr != null) && (this.mC != null))
        {
          this.gr.setImageBitmap((Bitmap)localObject2);
          this.mC.setText((CharSequence)localObject1);
        }
        if (this.mE != null) {
          this.mE.setText((CharSequence)localObject1);
        }
      }
    }
  }
  
  public void s(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onAfterCloseCamera, success[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    O(paramLong, 65535);
    if (paramBoolean)
    {
      km(true);
      jjk.awY();
      jjk.p(this.jdField_a_of_type_ComTencentAvVideoController);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ) {
        am("onAfterCloseCamera", 1);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ) {
        c(paramLong, 0.0F);
      }
    }
  }
  
  public void setBackgroundTransparent() {}
  
  protected void w(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramBoolean, paramInt, false);
  }
  
  protected boolean wd()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected();
  }
  
  class StartTimerRunnable
    implements Runnable
  {
    long seq;
    
    StartTimerRunnable() {}
    
    void dd(long paramLong)
    {
      this.seq = paramLong;
      DoubleVideoCtrlUI.this.mApp.getHandler().postDelayed(DoubleVideoCtrlUI.this.a, 5000L);
      DoubleVideoCtrlUI.this.Vu = true;
    }
    
    void remove(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w(DoubleVideoCtrlUI.this.TAG, 1, "StartTimerRunnable.remove, mNeedRemoveAudioCallback[" + DoubleVideoCtrlUI.this.Vu + "], seq[" + paramLong + "], lastseq[" + this.seq + "]");
      }
      if (DoubleVideoCtrlUI.this.Vu) {
        DoubleVideoCtrlUI.this.mApp.getHandler().removeCallbacks(DoubleVideoCtrlUI.this.a);
      }
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.w(DoubleVideoCtrlUI.this.TAG, 1, "StartTimerRunnable.Run, seq[" + this.seq + "]");
      }
      DoubleVideoCtrlUI.this.dC(this.seq);
    }
  }
  
  static class a
  {
    private int avH = 0;
    private int avI;
    private int avJ = 2130843050;
    Runnable bP = new DoubleVideoCtrlUI.RecordInfo.1(this);
    private AVActivity c;
    private VideoAppInterface mApp;
    
    void a(long paramLong, VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
    {
      this.mApp = paramVideoAppInterface;
      if (this.avH == 0) {
        a(paramLong, paramAVActivity);
      }
      while (this.avH != 1) {
        return;
      }
      dc(paramLong);
    }
    
    void a(long paramLong, AVActivity paramAVActivity)
    {
      QLog.w("RecordInfo", 1, "onClick_Record, start, seq[" + paramLong + "]");
      this.avH = 1;
      this.avJ = 2130843053;
      this.c = paramAVActivity;
      this.mApp.getHandler().postDelayed(this.bP, 1000L);
    }
    
    void dc(long paramLong)
    {
      QLog.w("RecordInfo", 1, "onClick_Record, cancel, seq[" + paramLong + "]");
      reset();
    }
    
    void reset()
    {
      this.avJ = 2130843050;
      this.avH = 0;
      this.avI = 0;
      this.mApp = null;
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */