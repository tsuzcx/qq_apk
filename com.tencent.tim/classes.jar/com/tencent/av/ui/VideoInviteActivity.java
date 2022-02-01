package com.tencent.av.ui;

import aeee;
import ajdo;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import anpc;
import aqha;
import aqiw;
import aqju;
import aqlr;
import aqpr;
import aqwu;
import arlc;
import ausj;
import ayxa;
import com.tencent.av.VideoConstants.a;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import igv;
import ihn;
import iid;
import iiv;
import iiv.a;
import iiv.b;
import iiz;
import ikn;
import ikp;
import ikr;
import imb;
import imc;
import itm;
import ivv;
import iwq;
import iwu;
import java.io.File;
import java.lang.ref.WeakReference;
import jcr;
import jeg;
import jei;
import jek;
import jel;
import jem;
import jen;
import jep;
import jeq;
import jey;
import jez;
import jfb;
import jgj;
import jjc;
import jjh;
import jji;
import jkg;
import jko;
import jkq;
import jll;
import jlp;
import mqq.app.BaseActivity;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int avs = 60000;
  public static int axO = 50000;
  public ImageButton M;
  public ImageButton N;
  public String OD = null;
  public String OE = null;
  public boolean Ox = false;
  String RJ;
  public final String TAG;
  public boolean Td = false;
  boolean Tl = false;
  boolean Tm = false;
  public boolean VD;
  public boolean VL = false;
  public boolean WU = false;
  public boolean Yl = false;
  boolean Ym = true;
  public boolean Yn = false;
  public boolean Yo = false;
  boolean Yp = false;
  public QavPanel a;
  public VipFullScreenVideoView a;
  iid jdField_a_of_type_Iid = new jei(this);
  iiz jdField_a_of_type_Iiz = new jeq(this);
  public jcr a;
  jey jdField_a_of_type_Jey;
  jko jdField_a_of_type_Jko = null;
  jlp jdField_a_of_type_Jlp;
  final int aqE = 0;
  final int aqF = 1;
  int avm = 0;
  int axN;
  public int axP = 0;
  public int axQ = 0;
  public int axR = 0;
  private imc jdField_b_of_type_Imc = new imc();
  iwq jdField_b_of_type_Iwq;
  Runnable bJ = new VideoInviteActivity.7(this);
  byte[] bd = null;
  Bitmap bu = null;
  Runnable cd = new VideoInviteActivity.8(this);
  long commingRingId = -1L;
  public iiv e = null;
  public RelativeLayout et = null;
  public ImageView gL = null;
  public WeakReference<Activity> mActivity = new WeakReference(this);
  public VideoAppInterface mApp = null;
  AudioManager mAudioManager = null;
  String mBindId = null;
  int mBindType = 0;
  boolean mIsCreated = false;
  public boolean mIsResume = false;
  public TextView mNameView = null;
  public int mOnlineStatus = 0;
  public String mPeerUin = null;
  BroadcastReceiver mReceiver = null;
  long mSeq;
  public int mUinType = 0;
  public TextView nc;
  TextView nd = null;
  long oW = 0L;
  long oX = -1L;
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_Jcr = null;
    long l = AudioHelper.hG();
    this.TAG = (getClass().getSimpleName() + "_" + l);
    this.mSeq = l;
    kk("VideoInviteActivity");
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void k(String paramString, int paramInt1, int paramInt2)
  {
    if (aqwu.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, paramString, paramInt1, null, paramInt2, false))
    {
      jA(true);
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  private void kz(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Jko == null) {
      this.jdField_a_of_type_Jko = jko.a(this.mApp);
    }
    if (jjc.xA()) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotification", 2, "updateInviteNotification show[" + paramBoolean + "], mIsAudioMode[" + this.VL + "], isOnlyAudio[" + this.e.QE + "], session[" + this.e + "]");
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = this.mApp.a(this.mUinType, this.mPeerUin, this.OD, true, true);
        this.OE = this.mApp.getDisplayName(this.mUinType, this.mPeerUin, this.OD);
        if (this.e.QE)
        {
          this.jdField_a_of_type_Jko.a(true, this.e.sessionId, this.OE, localBitmap, null, 45, this.mUinType, 1);
          return;
        }
        this.jdField_a_of_type_Jko.a(true, this.e.sessionId, this.OE, localBitmap, null, 40, this.mUinType, 2);
        return;
      }
      this.jdField_a_of_type_Jko.cancelNotification(this.e.sessionId);
      return;
      paramBoolean = true;
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.BtnOnClick(paramView);
    }
  }
  
  public void O(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "refuseVideoRequest", new Throwable("refuseVideoRequest"));
    }
    this.WU = false;
    TraeHelper.t(this.mApp);
    if ((this.mIsResume) && (this.jdField_a_of_type_Jcr != null) && (!this.Yo)) {
      this.jdField_a_of_type_Jcr.a(new jem(this, paramLong, paramBoolean));
    }
    do
    {
      return;
      if (this.Td)
      {
        b().a(paramLong, this.mPeerUin, 1, true);
        long l = jji.B(this.mPeerUin);
        b().c(paramLong, 3, l);
        this.Yn = true;
        b().f(paramLong, l, 1);
        this.Ox = true;
        super.finish();
        return;
      }
      b().a(paramLong, this.mPeerUin, 1, false);
      b().O(this.mPeerUin, 249);
      b().ko(249);
    } while (!paramBoolean);
    b().P(this.mPeerUin, 1);
  }
  
  ausj a(Context paramContext)
  {
    paramContext = new b(paramContext);
    paramContext.getWindow().setWindowAnimations(2131755426);
    return paramContext;
  }
  
  public void a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = a(paramContext);; paramContext = ausj.b(paramContext))
    {
      paramContext.addButton(2131697849);
      paramContext.addButton(2131697851);
      paramContext.addButton(2131697850);
      if (wN()) {
        paramContext.addButton(2131697848);
      }
      paramContext.addCancelButton(2131721058);
      paramContext.a(new jek(this, paramBoolean));
      paramContext.a(new jel(this, paramContext, paramBoolean, paramLong));
      paramContext.show();
      return;
    }
  }
  
  public void aE(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label266:
    for (;;)
    {
      return;
      if (jkq.o(paramIntent)) {
        anot.a(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l = AudioHelper.hG();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.e == null)
        {
          paramIntent = null;
          if (!TextUtils.equals(str2, paramIntent)) {
            break label194;
          }
          dP(l);
          label98:
          anot.a(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label266;
        }
        QLog.i(this.TAG, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "]");
        return;
        paramIntent = this.e.sessionId;
        break;
        label194:
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.i(this.TAG, 2, "checkParamAndDoAction not same , coming[" + str2 + "], cur[" + paramIntent + "]");
        break label98;
        if ("com.tencent.qav.notify.refuse".equals(str1)) {
          O(l, true);
        }
      }
    }
  }
  
  public void avd()
  {
    int i = 0;
    if (this.e == null) {}
    label9:
    int j;
    do
    {
      int k;
      String str;
      do
      {
        do
        {
          break label9;
          do
          {
            return;
          } while (this.et == null);
          j = jgj.a(this.mApp, this.mPeerUin, false, this.VL);
        } while (j == 0);
        k = aqiw.getSystemNetwork(BaseApplicationImpl.getContext());
        if ((k == 4) || (k == 1)) {
          i = 1;
        }
        k = aqwu.getResourceType();
        str = aqwu.a(this.mApp, j, aqwu.getResourceType(), null);
      } while (TextUtils.isEmpty(str));
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = aqwu.a(this, this.et, true);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()))
      {
        k(str, k, j);
        return;
      }
    } while (i == 0);
    this.axR = j;
    jgj.c(this.mApp, j);
  }
  
  @TargetApi(16)
  void ave()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public void avf()
  {
    sendBroadcast(new Intent("tencent.video.v2nearbyV.exit"));
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.multiMsg", 2, "exitNearbyVideo");
    }
  }
  
  void avg()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startVideoChatActivity");
    }
    TraeHelper.a().connectHighestPriorityDevice();
    this.mApp.getHandler().removeCallbacks(this.bJ);
    this.mApp.getHandler().removeCallbacks(this.cd);
    if (b().OQ) {
      this.mApp.l(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    if (this.Td)
    {
      String str = this.mPeerUin;
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", str);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.OE);
      super.startActivity(localIntent);
      this.Ox = false;
      this.Tl = true;
      super.finish();
      super.overridePendingTransition(2130772239, 2130772238);
      return;
    }
    localIntent.putExtra("uinType", this.mUinType);
    localIntent.putExtra("bindType", this.mBindType);
    localIntent.putExtra("bindId", this.mBindId);
    localIntent.putExtra("uin", this.mPeerUin);
    localIntent.putExtra("name", this.OE);
    localIntent.putExtra("extraUin", this.OD);
    localIntent.putExtra("receive", true);
    localIntent.putExtra("isAudioMode", this.VL);
    localIntent.putExtra("sig", this.bd);
    localIntent.putExtra("subServiceType", this.avm);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startVideoChatActivity: mBindType = " + this.mBindType + ",mBindId = " + this.mBindId + ",BindType = " + this.e.bindType);
    }
    if (this.mUinType == 0) {
      localIntent.putExtra("isFriend", this.mApp.isFriend(this.mPeerUin));
    }
    if (this.VL) {
      localIntent.putExtra("sessionType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("shutCamera", this.VD);
      localIntent.putExtra("isSender", false);
      break;
      localIntent.putExtra("sessionType", 2);
    }
  }
  
  void avh()
  {
    long l1 = AudioHelper.hG();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("onVideoRequestTimeout, seq[").append(l1).append("], state[");
      if (this.e != null) {
        break label127;
      }
    }
    label127:
    for (int i = -1;; i = this.e.state)
    {
      QLog.w(str, 2, i + "]");
      if ((this.e == null) || ((!this.e.isConnecting()) && (!this.e.isConnected())) || (this.mPeerUin == null) || (!this.mPeerUin.equals(this.e.peerUin))) {
        break;
      }
      finish();
      return;
    }
    TraeHelper.t(this.mApp);
    dN(l1);
    if ((this.mIsResume) && (this.jdField_a_of_type_Jcr != null))
    {
      this.jdField_a_of_type_Jcr.a(new jep(this, l1));
      return;
    }
    this.WU = false;
    if (this.Td)
    {
      long l2 = jji.B(this.mPeerUin);
      b().c(l1, 3, l2);
      if (!this.Yn)
      {
        this.Yn = true;
        b().f(l1, l2, 2);
      }
      this.Ox = true;
      finish();
      return;
    }
    b().O(this.mPeerUin, 247);
    b().ko(247);
    b().P(this.mPeerUin, 0);
  }
  
  protected void avi()
  {
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.avi();
    }
  }
  
  void avj()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showGAudioDialog");
    }
    a locala1 = new a(0);
    a locala2 = new a(1);
    aqha.a(this, 230, null, super.getString(2131697710), 2131721690, 2131697626, locala1, locala2).show();
  }
  
  void avk()
  {
    String str2 = "";
    int i;
    String str1;
    if (b() != null)
    {
      i = this.e.uinType;
      str1 = this.e.MP;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.axQ = 99;
        str1 = str2;
      }
      for (;;)
      {
        this.RJ = str1;
        return;
        if (this.Td)
        {
          this.axQ = 7;
          str1 = super.getString(2131697839);
        }
        else
        {
          this.axQ = 0;
          str1 = str2;
          continue;
          str1 = super.getString(2131697840) + this.mApp.getDisplayName(1, str1, null);
          this.axQ = 1;
          continue;
          str1 = super.getString(2131697840) + this.mApp.getDisplayName(3000, str1, null);
          this.axQ = 2;
          continue;
          str1 = super.getString(2131697837);
          this.axQ = 3;
          continue;
          str1 = super.getString(2131697836);
          this.axQ = 4;
          continue;
          str1 = super.getString(2131697841);
          this.axQ = 5;
          continue;
          str1 = super.getString(2131697838);
          this.axQ = 6;
          continue;
          str1 = super.getString(2131696065);
          this.axQ = 7;
        }
      }
      str1 = null;
      i = 0;
    }
  }
  
  void avl()
  {
    this.et = ((RelativeLayout)super.findViewById(2131377556));
    Drawable localDrawable = jjh.d(super.getApplicationContext(), 2130842961);
    if (localDrawable != null)
    {
      this.et.setBackgroundDrawable(localDrawable);
      return;
    }
    this.et.setBackgroundResource(2130842961);
  }
  
  public VideoController b()
  {
    return this.mApp.b();
  }
  
  public void dN(long paramLong)
  {
    QLog.w(this.TAG, 1, "stopRing, mLastPlayRingTime[" + this.oW + "->" + 0 + "]");
    this.oW = 0L;
    if (TraeHelper.a() != null) {
      TraeHelper.a().dN(paramLong);
    }
  }
  
  public void dO(long paramLong)
  {
    Object localObject;
    if (this.mApp == null)
    {
      localObject = null;
      boolean bool = jjc.cJ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "playRing avCallBtnState[" + bool + "], seq[" + paramLong + "]");
      }
      if (bool) {
        break label86;
      }
    }
    label86:
    label237:
    do
    {
      long l;
      do
      {
        return;
        localObject = this.mApp.getCurrentAccountUin();
        break;
        if (!jkg.isRingerNormal(this)) {
          break label469;
        }
        if ((this.Yl) || (!this.Ym)) {
          break label237;
        }
        l = System.currentTimeMillis();
        QLog.w(this.TAG, 1, "playRing, mIsRingPlaying[" + this.oW + "->" + l + "], seq[" + paramLong + "]");
      } while (this.oW != 0L);
      this.oW = l;
      TraeHelper.a().dN(paramLong);
      if ((this.mApp == null) || (this.mApp.getApp() == null))
      {
        this.commingRingId = 0L;
        if (this.commingRingId != 0L) {
          break label275;
        }
        TraeHelper.a().a(paramLong, this.mApp, 2131230755, -1, null);
      }
      for (;;)
      {
        TraeHelper.a(this.mApp, false, paramLong);
        return;
        this.commingRingId = aqwu.a(this.mApp, this.mApp.getAccount(), 3, false, this.mPeerUin);
        break;
        localObject = aqpr.p(this.commingRingId, 3);
        if (new File((String)localObject).exists())
        {
          TraeHelper.a().b(paramLong, this.mApp, 0, (String)localObject, -1, null);
          anot.a(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.commingRingId + "", "", "");
        }
        else
        {
          TraeHelper.a().a(paramLong, this.mApp, 2131230755, -1, null);
          if ((this.mApp != null) && (this.mApp.getApp() != null))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
            ((Intent)localObject).setPackage(this.mApp.getApp().getPackageName());
            ((Intent)localObject).putExtra("comming_ring_down_key", this.commingRingId);
            this.mApp.getApp().sendBroadcast((Intent)localObject);
          }
        }
      }
    } while (!jkg.isRingerVibrate(this));
    label275:
    label469:
    TraeHelper.a(this.mApp, false, paramLong);
  }
  
  public void dP(long paramLong)
  {
    if (!wM()) {}
    boolean bool;
    String str;
    label33:
    do
    {
      return;
      if ((!this.VL) && (!this.VD)) {
        break;
      }
      bool = true;
      if (!bool) {
        break label102;
      }
      str = "tim_msg_tab_voice_rec";
      anpc.report(str);
    } while (!ChatActivityUtils.a(this, bool, new jen(this, paramLong, bool)));
    avf();
    if ((b().OB) || (b().sw())) {
      avj();
    }
    for (;;)
    {
      TraeHelper.t(this.mApp);
      dN(paramLong);
      return;
      bool = false;
      break;
      label102:
      str = "tim_msg_tab_video_rec";
      break label33;
      avg();
    }
  }
  
  public void finish()
  {
    QLog.w(this.TAG, 1, "finish", new Throwable());
    super.finish();
  }
  
  public void initUI()
  {
    avl();
    this.jdField_b_of_type_Iwq = new iwq();
    this.jdField_b_of_type_Iwq.a(this.mApp, this.et);
    this.axN = 1;
    if ((!aqiw.isWifiConnected(super.getApplicationContext())) && (!aqiw.bX(super.getApplicationContext()))) {
      this.axN = 2;
    }
    this.nc = ((TextView)super.findViewById(2131363171));
    this.nd = ((TextView)super.findViewById(2131363160));
    if ((this.nd != null) && (!TextUtils.isEmpty(this.RJ)))
    {
      this.nd.setVisibility(0);
      this.nd.setText(this.RJ);
      jll.b(this.nd, this.RJ);
      if (this.Td) {
        this.nc.setVisibility(4);
      }
    }
  }
  
  public void jA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.nd != null) {
        this.nd.setTextColor(super.getResources().getColor(2131166294));
      }
      if (this.mNameView != null) {
        this.mNameView.setTextColor(super.getResources().getColor(2131166294));
      }
      if (this.nc != null) {
        this.nc.setTextColor(super.getResources().getColor(2131166294));
      }
      if (this.jdField_b_of_type_Iwq != null)
      {
        this.jdField_b_of_type_Iwq.lV(super.getResources().getColor(2131166294));
        this.jdField_b_of_type_Iwq.lW(-1291845633);
      }
    }
    do
    {
      return;
      if (this.nd != null) {
        this.nd.setTextColor(-11113603);
      }
      if (this.mNameView != null) {
        this.mNameView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.nc != null) {
        this.nc.setTextColor(Color.parseColor("#566B7D"));
      }
    } while (this.jdField_b_of_type_Iwq == null);
    this.jdField_b_of_type_Iwq.lV(-11113603);
    this.jdField_b_of_type_Iwq.lW(-11113603);
  }
  
  public void kj(String paramString)
  {
    boolean bool = VideoController.isScreenLocked(this);
    int i;
    Object localObject;
    if (bool)
    {
      i = 1;
      if (QLog.isColorLevel())
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("checkAndSwitchMode isLocked[").append(bool).append("], mode[").append(i).append("], cur[");
        if (this.jdField_a_of_type_Jey != null) {
          break label135;
        }
        localObject = "null";
        label70:
        QLog.i(str, 2, localObject + "], destroy[" + this.Yp + "], from[" + paramString + "]");
      }
      kk("checkAndSwitchMode");
      if (!this.Yp) {
        break label150;
      }
    }
    label135:
    label150:
    do
    {
      do
      {
        return;
        i = 2;
        break;
        localObject = Integer.valueOf(this.jdField_a_of_type_Jey.mk());
        break label70;
        if (this.jdField_a_of_type_Jey == null)
        {
          ky(bool);
          return;
        }
      } while (i == this.jdField_a_of_type_Jey.mk());
      paramString = this.jdField_a_of_type_Jey;
      this.jdField_a_of_type_Jey.onDestroy();
      ky(bool);
      this.jdField_a_of_type_Jey.a(paramString);
      if (this.mIsCreated)
      {
        this.jdField_a_of_type_Jey.initUI();
        this.jdField_a_of_type_Jey.updateUI();
      }
    } while (!this.mIsResume);
    this.jdField_a_of_type_Jey.onResume();
  }
  
  public void kk(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraceLogForAV", 2, "traceLog from[" + paramString + "], seq[" + this.mSeq + "], mode[" + this.jdField_a_of_type_Jey + "]");
    }
  }
  
  public void ky(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Jey = new jfb(this);; this.jdField_a_of_type_Jey = new jez(this))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "initVideoInviteUI isLocked[" + paramBoolean + "]");
      }
      return;
    }
  }
  
  public void nb(int paramInt)
  {
    if (this.axN == paramInt) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.axN = paramInt;
      return;
      iwu.b(this.mApp, 1040, 2131698168);
      continue;
      iwu.b(this.mApp, 1040, 2131698163);
      continue;
      iwu.b(this.mApp, 1040, 2131698165);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ayxa.initLiuHaiProperty(this);
    if ((ayxa.isLiuHaiUseValid()) && (ayxa.enableNotch(this)) && (QLog.isDevelopLevel())) {
      QLog.w(this.TAG, 1, "onAttachedToWindow");
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l3 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "avideo onCreate, seq[" + l3 + "]");
    kk("onCreate");
    if (this.jdField_a_of_type_Jey == null) {
      ky(VideoController.isScreenLocked(getApplicationContext()));
    }
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.kA(true);
    }
    ikp.kQ(29);
    this.oX = System.currentTimeMillis();
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130772239, 0);
    AVActivity.c(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    AVActivity.d(super.getWindow());
    if ((!uu()) || (!wL()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "init param failure.");
      }
      this.Ox = true;
      super.finish();
      return;
    }
    paramBundle = this.mPeerUin;
    label229:
    int i;
    label306:
    label484:
    long l2;
    label420:
    long l1;
    if (this.Td)
    {
      paramBundle = igv.a(100, paramBundle, new int[0]);
      this.mAudioManager = ((AudioManager)super.getSystemService("audio"));
      this.e = igv.a().c(paramBundle);
      paramBundle = b();
      if (paramBundle != null) {
        break label998;
      }
      paramBundle = null;
      if (paramBundle != null) {
        paramBundle.c(getClass().getName(), getIntent());
      }
      StringBuilder localStringBuilder;
      if ((this.e == null) || (!this.e.tc()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = this.TAG;
          localStringBuilder = new StringBuilder().append("session state error! ");
          if (this.e == null) {
            break label1006;
          }
          i = this.e.state;
          QLog.w(paramBundle, 2, i);
        }
        if ((this.e == null) || (!this.e.ta()) || (this.mPeerUin == null) || (!this.mPeerUin.equals(this.e.peerUin))) {
          break label1011;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, "onCreate state[" + this.e.state + "], peerUin[" + this.mPeerUin + "]");
        }
      }
      aE(getIntent());
      if (b().OB != true)
      {
        TraeHelper.a(this.mApp.getApp().getApplicationContext(), b());
        dN(l3);
        if (this.e.amK != 1) {
          break label1174;
        }
        TraeHelper.a().startService("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      this.mApp.addObserver(this.jdField_a_of_type_Iiz);
      this.mApp.addObserver(this.jdField_a_of_type_Iid);
      l2 = System.currentTimeMillis();
      l1 = this.e.lp;
      i = 0;
      if ((l1 <= 0L) || (l2 - l1 >= avs)) {
        break label1192;
      }
      if (l2 - l1 < axO) {
        break label1187;
      }
      i = 1;
      label553:
      this.mApp.getHandler().postDelayed(this.bJ, avs + l1 - l2);
      if (i == 0) {
        break label1198;
      }
      avi();
      label585:
      if (b().kA() <= 0) {
        break label1225;
      }
      b().uploadSharpNode(203, this.mPeerUin);
      label609:
      this.axP = jkg.X(this);
      this.mBindId = this.e.MX;
      this.mBindType = this.e.bindType;
      this.bd = this.e.signature;
      this.avm = this.e.ama;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      paramBundle.addAction("tencent.video.q2v.sdk.onRequestVideo");
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      paramBundle.addAction("android.intent.action.USER_PRESENT");
      this.mReceiver = new c();
      super.registerReceiver(this.mReceiver, paramBundle);
      avk();
      if (this.mUinType == 25)
      {
        ajdo localajdo = (ajdo)this.mApp.getManager(11);
        localStringBuilder = null;
        paramBundle = localStringBuilder;
        if (localajdo != null)
        {
          paramBundle = localStringBuilder;
          if (this.OD != null) {
            paramBundle = localajdo.c(this.OD);
          }
        }
        if (paramBundle == null) {
          break label1278;
        }
        paramBundle = localajdo.dv(this.OD);
        if ((paramBundle == null) || (!this.mApp.isFriend(paramBundle))) {
          break label1242;
        }
        anot.a(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if ((!this.Ox) && (this.e.tc())) {
        kz(false);
      }
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("fullscreen", false))) {
        ihn.amq();
      }
      if (this.jdField_a_of_type_Jey != null) {
        this.jdField_a_of_type_Jey.initUI();
      }
      if ((this.e.uinType == 21) || (this.e.uinType == 1011))
      {
        this.WU = true;
        dP(l3);
        if (this.jdField_a_of_type_Jey != null) {
          this.jdField_a_of_type_Jey.updateUI();
        }
      }
      if (this.jdField_a_of_type_Jcr != null) {
        this.jdField_a_of_type_Jcr.atK();
      }
      this.mIsCreated = true;
      return;
      paramBundle = igv.a(3, paramBundle, new int[0]);
      break;
      label998:
      paramBundle = paramBundle.a();
      break label229;
      label1006:
      i = -1;
      break label306;
      label1011:
      if ((this.e != null) && ((this.e.isConnecting()) || (this.e.isConnected())) && (this.mPeerUin != null) && (this.mPeerUin.equals(this.e.peerUin)))
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, "onCreate state[" + this.e.state + "], peerUin[" + this.mPeerUin + "]");
        }
        finish();
        break label420;
      }
      b().O(this.mPeerUin, 245);
      b().ko(245);
      b().P(this.mPeerUin, 2);
      this.Ox = true;
      super.finish();
      return;
      label1174:
      TraeHelper.a().startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      break label484;
      label1187:
      i = 0;
      break label553;
      label1192:
      l1 = l2;
      break label553;
      label1198:
      this.mApp.getHandler().postDelayed(this.cd, l1 + axO - l2);
      break label585;
      label1225:
      b().uploadSharpNode(202, this.mPeerUin);
      break label609;
      label1242:
      anot.a(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
      continue;
      label1278:
      anot.a(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "avideo onDestroy, seq[" + l + "]");
    super.onDestroy();
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.i(this.mApp);
    }
    ikn.bS(this.oX);
    this.oX = -1L;
    this.mApp.getHandler().removeCallbacks(this.bJ);
    this.mApp.getHandler().removeCallbacks(this.cd);
    if (this.jdField_a_of_type_Jlp != null)
    {
      this.jdField_a_of_type_Jlp.unlock();
      this.jdField_a_of_type_Jlp = null;
    }
    this.mApp.deleteObserver(this.jdField_a_of_type_Iiz);
    this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
    if (this.mReceiver != null)
    {
      super.unregisterReceiver(this.mReceiver);
      this.mReceiver = null;
    }
    dN(l);
    TraeHelper.t(this.mApp);
    this.nd = null;
    this.bu = null;
    this.jdField_a_of_type_Jlp = null;
    this.jdField_a_of_type_Jko = null;
    this.gL = null;
    this.mNameView = null;
    this.nc = null;
    this.M = null;
    this.N = null;
    this.mAudioManager = null;
    this.et = null;
    this.jdField_a_of_type_Iiz = null;
    this.jdField_a_of_type_Iid = null;
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.onDestroy();
    }
    this.e = null;
    this.Yp = true;
    kk("onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Jey != null) {
      bool = this.jdField_a_of_type_Jey.onKeyDown(paramInt, paramKeyEvent);
    }
    if (bool) {}
    while (this.WU) {
      return true;
    }
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onKeyDown, seq[" + l + "]");
    if ((paramInt == 25) || (paramInt == 24))
    {
      TraeHelper.t(this.mApp);
      dN(l);
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (paramInt == 26) {
        dN(l);
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.TAG, 1, "onNewIntent()");
    kk("onNewIntent");
    aE(paramIntent);
  }
  
  public void onPause()
  {
    QLog.d(this.TAG, 1, "onPause");
    super.onPause();
    aeee.e(this, 2, true);
    iA(false);
    b().a("state", "0");
    if ("0".equals(VideoConstants.a.Mm)) {
      b().a("backgroundReason", "5");
    }
    if (!this.Tl) {
      arlc.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.j(this.mApp);
    }
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.onPause();
    }
    this.mIsResume = false;
    this.jdField_b_of_type_Imc.a(this.mApp, b());
  }
  
  protected void onRestart()
  {
    QLog.d(this.TAG, 1, "onRestart");
    super.onRestart();
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.onRestart();
    }
  }
  
  public void onResume()
  {
    kj("onResume");
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onResume, mCheckQAVPermission[" + this.Tm + "], isInLockMode[" + wP() + "], seq[" + l1 + "]");
    super.onResume();
    aeee.e(this, 2, false);
    arlc.y(BaseApplicationImpl.getContext(), 50, 0);
    arlc.a(BaseApplicationImpl.getContext(), false, 50, 1);
    arlc.y(BaseApplicationImpl.getContext(), 50, 2);
    wO();
    this.Yl = false;
    iA(true);
    iiv localiiv = igv.a().a();
    ikr localikr = (ikr)this.mApp.a(4);
    if ((localikr != null) && (localiiv != null))
    {
      long l2 = System.currentTimeMillis();
      long l3 = itm.a().of;
      localikr.d(localiiv.getRoomId(), 24, l2 - l3);
    }
    b().d(VideoInviteActivity.class);
    b().a("state", "1");
    VideoConstants.a.Mm = "0";
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.k(this.mApp);
    }
    if (!this.Tm)
    {
      this.Tm = true;
      ChatActivityUtils.a(this, true, new jeg(this, l1));
    }
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.onResume();
    }
    if (!wP()) {
      dO(l1);
    }
    this.mIsResume = true;
    this.jdField_b_of_type_Imc.a(this, this.mApp, b());
  }
  
  public void onStart()
  {
    QLog.d(this.TAG, 1, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.onStart();
    }
    if (wP())
    {
      long l = AudioHelper.hG();
      if (VideoController.isScreenOn(this)) {
        dO(l);
      }
    }
  }
  
  public void onStop()
  {
    long l = AudioHelper.hG();
    boolean bool = jkg.isRingerNormal(this);
    QLog.w(this.TAG, 1, "avideo onStop, isRingerNormal[" + bool + "], mIsAccepted[" + this.WU + "], seq[" + l + "]");
    super.onStop();
    if ((bool) && (!this.WU)) {
      dN(l);
    }
    if (this.e == null) {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "onStop mSessionInfo is null ");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Jey != null) {
        this.jdField_a_of_type_Jey.onStop();
      }
      this.mIsResume = false;
    } while ((this.Ox) || (!this.e.tc()));
    kz(true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Jey != null) {
      this.jdField_a_of_type_Jey.kA(false);
    }
  }
  
  public void refreshUI()
  {
    if (this.e == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.mPeerUin;
      int j = this.mUinType;
      int i = j;
      Object localObject1 = localObject2;
      if (this.e.bindType == 1)
      {
        i = j;
        localObject1 = localObject2;
        if (this.mUinType == 9500)
        {
          i = j;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.e.MX))
          {
            localObject1 = this.e.MX;
            i = 0;
          }
        }
      }
      if (this.gL != null)
      {
        this.bu = this.mApp.a(i, (String)localObject1, this.OD, true, true);
        this.gL.setImageBitmap(this.bu);
        localObject2 = jll.b(super.getApplicationContext(), 2130842961);
        if (this.et != null)
        {
          if (localObject2 == null) {
            break label320;
          }
          long l = System.currentTimeMillis();
          localObject2 = new BitmapDrawable((Bitmap)localObject2);
          this.et.setBackgroundDrawable((Drawable)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "blur time = " + (System.currentTimeMillis() - l) + "ms");
          }
        }
      }
      while (this.mNameView != null)
      {
        this.OE = this.mApp.getDisplayName(i, (String)localObject1, this.OD);
        if ((this.mUinType == 25) && (this.OE.equals(this.mPeerUin)))
        {
          this.OE = this.e.gK();
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 2, "mPeerName = " + this.OE);
          }
        }
        this.mNameView.setText(this.OE);
        return;
        label320:
        localObject2 = jjh.d(super.getApplicationContext(), 2130842961);
        if (localObject2 != null) {
          this.et.setBackgroundDrawable((Drawable)localObject2);
        } else {
          this.et.setBackgroundResource(2130842961);
        }
      }
    }
  }
  
  boolean uu()
  {
    this.mApp = ((VideoAppInterface)super.getAppRuntime());
    if (this.mApp != null)
    {
      this.jdField_a_of_type_Jlp = new jlp(super.getApplicationContext(), 1, "video wifi lock");
      return true;
    }
    return false;
  }
  
  boolean wL()
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject = super.getIntent();
    if ((localObject != null) && (!jkq.o((Intent)localObject)))
    {
      this.mPeerUin = ((Intent)localObject).getStringExtra("peerUin");
      if (TextUtils.isEmpty(this.mPeerUin))
      {
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "initVideoParam uin is empty!");
        }
      }
      for (bool1 = bool3;; bool1 = true)
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i(this.TAG, 2, "initVideoParam fromIntent peer[" + this.mPeerUin + "], uinType[" + this.mUinType + "], audioMode[" + this.VL + "], ret[" + bool1 + "]");
          bool2 = bool1;
        }
        return bool2;
        this.mUinType = ((Intent)localObject).getIntExtra("uinType", 0);
        this.OD = ((Intent)localObject).getStringExtra("extraUin");
        this.mOnlineStatus = ((Intent)localObject).getIntExtra("curUserStatus", 0);
        this.VL = ((Intent)localObject).getBooleanExtra("isAudioMode", false);
        this.Yl = ((Intent)localObject).getBooleanExtra("powerKey", false);
        this.Ym = ((Intent)localObject).getBooleanExtra("isPlayRing", true);
        this.Td = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
      }
    }
    localObject = igv.a().a();
    boolean bool1 = bool4;
    if (localObject != null)
    {
      this.mUinType = ((iiv)localObject).uinType;
      this.mPeerUin = ((iiv)localObject).peerUin;
      if (!TextUtils.isEmpty(this.mPeerUin)) {
        break label399;
      }
      bool1 = bool4;
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "initVideoParam uin is empty!");
      }
    }
    for (bool1 = bool4;; bool1 = true)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.TAG, 2, "initVideoParam from Session peer[" + this.mPeerUin + "], uinType[" + this.mUinType + "], audioMode[" + this.VL + "], ret[" + bool1 + "]");
      return bool1;
      label399:
      this.mUinType = ((iiv)localObject).uinType;
      this.OD = ((iiv)localObject).MP;
      this.mOnlineStatus = b().kx();
      this.VL = ((iiv)localObject).QE;
      bool1 = bool2;
      if (((iiv)localObject).jdField_a_of_type_Iiv$a.anA <= 0) {
        if (((iiv)localObject).jdField_a_of_type_Iiv$b.chatType != 0)
        {
          bool1 = bool2;
          if (((iiv)localObject).jdField_a_of_type_Iiv$b.groupId > 0L) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.Ym = bool1;
      this.Td = ((iiv)localObject).Qw;
    }
  }
  
  protected boolean wM()
  {
    if (this.jdField_a_of_type_Jlp == null) {
      this.jdField_a_of_type_Jlp = new jlp(super.getApplicationContext(), 1, "video wifi lock");
    }
    if ((jkg.isWifiEnv(super.getApplicationContext())) && (this.jdField_a_of_type_Jlp != null)) {
      this.jdField_a_of_type_Jlp.xS();
    }
    return true;
  }
  
  boolean wN()
  {
    return (!aqlr.isScreenLocked(super.getApplicationContext())) || (Build.VERSION.SDK_INT >= 16);
  }
  
  protected boolean wO()
  {
    return b().co(this.mPeerUin);
  }
  
  public boolean wP()
  {
    return this.jdField_a_of_type_Jey instanceof jfb;
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
      if (VideoInviteActivity.this.mApp == null) {
        return;
      }
      long l = AudioHelper.hG();
      QLog.w(VideoInviteActivity.this.TAG, 1, "onClick, seq[" + l + "]");
      switch (this.aqH)
      {
      default: 
        return;
      case 0: 
        paramDialogInterface.dismiss();
        VideoInviteActivity.this.b().alF();
        if (VideoInviteActivity.this.b().sw()) {
          VideoInviteActivity.this.b().hI(false);
        }
        VideoInviteActivity.this.WU = true;
        paramDialogInterface = VideoInviteActivity.this.b();
        if (VideoInviteActivity.this.VL) {}
        for (paramInt = 1;; paramInt = 2)
        {
          paramDialogInterface.a(l, paramInt, false, true);
          VideoInviteActivity.this.avg();
          return;
        }
      }
      paramDialogInterface.dismiss();
      VideoInviteActivity.this.O(l, true);
      VideoInviteActivity.this.finish();
    }
  }
  
  class b
    extends ausj
  {
    public b(Context paramContext)
    {
      super();
      super.getWindow().addFlags(524288);
      super.getWindow().addFlags(128);
      super.getWindow().addFlags(1024);
      super.getWindow().addFlags(2097152);
    }
  }
  
  class c
    extends BroadcastReceiver
  {
    c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d(VideoInviteActivity.this.TAG, 2, "onReceive action = " + str);
      }
      if ("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO".equals(str)) {
        VideoInviteActivity.this.refreshUI();
      }
      do
      {
        return;
        if ("tencent.video.q2v.sdk.onRequestVideo".equals(str))
        {
          QLog.d(VideoInviteActivity.this.TAG, 1, "onReceive action = " + str);
          VideoInviteActivity.this.wO();
          return;
        }
        if ("android.intent.action.USER_PRESENT".equals(str))
        {
          VideoInviteActivity.this.kj("ACTION_USER_PRESENT");
          return;
        }
      } while (VideoInviteActivity.this.a == null);
      VideoInviteActivity.this.a.a(paramContext, str, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */