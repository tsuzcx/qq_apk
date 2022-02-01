package com.tencent.av.ui;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import aqha;
import aqiw;
import aqju;
import aqlr;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import igd;
import igv;
import iiv;
import ikx;
import imm;
import imp;
import imq;
import iow;
import irc;
import ivv;
import iwq;
import iwu;
import iya;
import iya.b;
import iya.d;
import iyc;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import jdu;
import jdv;
import jdw;
import jdx;
import jdy;
import jdz;
import jea;
import jeb;
import jec;
import jed;
import jee;
import jgg;
import jht;
import jik;
import jiu;
import jjc;
import jjk;
import jjk.a;
import jkr;
import jks;
import jkv;
import jkz;
import jlc;
import jle;
import jll;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public abstract class VideoControlUI
{
  public static boolean Yi;
  static boolean Yj;
  static int axE = -1;
  Animation L = null;
  Animation M = null;
  String QK = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public String RG;
  public String RH;
  public final String TAG = getClass().getSimpleName() + "_" + AudioHelper.hG();
  boolean VB = false;
  private boolean VC;
  public boolean Ya = true;
  protected boolean Yb;
  public boolean Yc = false;
  public boolean Yd;
  private boolean Ye = true;
  private boolean Yf;
  public boolean Yg;
  public boolean Yh = true;
  public boolean Yk = false;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new jdv(this);
  public VideoController a;
  public QavPanel a;
  ShowSharpInfoRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = null;
  TimmerRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
  ToolbarAnimationRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable = new ToolbarAnimationRunnable();
  private a jdField_a_of_type_ComTencentAvUiVideoControlUI$a;
  private b jdField_a_of_type_ComTencentAvUiVideoControlUI$b;
  c jdField_a_of_type_ComTencentAvUiVideoControlUI$c;
  e jdField_a_of_type_ComTencentAvUiVideoControlUI$e;
  f jdField_a_of_type_ComTencentAvUiVideoControlUI$f = null;
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
  jkr jdField_a_of_type_Jkr = new jdz(this);
  jks jdField_a_of_type_Jks = null;
  jkv jdField_a_of_type_Jkv = null;
  public jkz a;
  public int aoI;
  int auE = 0;
  int axA = 0;
  int axB = 0;
  int axC = 0;
  int axD = 0;
  public int axF;
  private int axG;
  public int axH = 0;
  public final int axI = 256;
  public final int axJ = 257;
  int axv = 0;
  int axw = 0;
  int axx = 0;
  int axy = 0;
  int axz = 0;
  QavPanel.e jdField_b_of_type_ComTencentAvUiQavPanel$e;
  f jdField_b_of_type_ComTencentAvUiVideoControlUI$f = null;
  public VideoNetStateBar b;
  iwq jdField_b_of_type_Iwq;
  private iyc jdField_b_of_type_Iyc;
  public iya c;
  Runnable cc = new VideoControlUI.4(this);
  public String deviceName = Build.MANUFACTURER + "." + Build.MODEL;
  LinearLayout dh = null;
  RelativeLayout eq = null;
  RelativeLayout er = null;
  RelativeLayout es = null;
  ImageView gK = null;
  float hT = 0.0F;
  View il = null;
  View.OnTouchListener l = new jee(this);
  public VideoAppInterface mApp = null;
  Context mApplicationContext = null;
  public WeakReference<Context> mContext = null;
  public GestureDetector mGestureDetector = null;
  public Resources mRes = null;
  public ViewGroup mRootView = null;
  Toast mToast = null;
  public TextView mZ = null;
  TextView na = null;
  public TextView nb = null;
  public final long oU = 1500L;
  OrientationEventListener orientationListener = null;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, iya paramiya)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar = null;
    this.jdField_a_of_type_Jkz = null;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "VideoControlUI");
    }
    this.mApp = paramVideoAppInterface;
    this.mContext = new WeakReference(paramAVActivity);
    this.mRootView = paramViewGroup;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$e = new e();
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$e);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b = new b(Looper.getMainLooper());
    paramVideoAppInterface = a();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.mRes = paramVideoAppInterface.getResources();
    if (this.mRes == null)
    {
      igd.aK(this.TAG, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131721703) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      igd.aK(this.TAG, "mVideoController is null. exit video progress");
      paramAVActivity = this.mRes.getString(2131721703) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.c = paramiya;
    this.axB = this.mRes.getDimensionPixelSize(2131298353);
    this.hT = this.mRes.getDimension(2131298355);
    this.axC = this.mRes.getDimensionPixelSize(2131298356);
    this.axD = this.mRes.getDimensionPixelSize(2131298371);
  }
  
  private void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a();
    Window localWindow;
    if ((Build.VERSION.SDK_INT >= 19) && (localObject != null))
    {
      localWindow = ((AVActivity)localObject).getWindow();
      if (localWindow != null) {
        if ((!paramBoolean1) || (!paramBoolean2)) {
          break label272;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (wI()) {
          break label272;
        }
        i = 1;
        int j = i;
        if (i == 0)
        {
          localObject = ((AVActivity)localObject).findViewById(2131373957);
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((View)localObject).isShown()) {
              j = 1;
            }
          }
          if (Yi) {
            j = 1;
          }
        }
        if (j == 0) {
          continue;
        }
        localWindow.setFlags(2048, 1024);
        if (!QLog.isDevelopLevel()) {
          break label271;
        }
        str2 = ImmersiveUtils.TAG;
        localStringBuilder = new StringBuilder().append("setSystemStatusBar, ");
        if (j == 0) {
          continue;
        }
        localObject = "显示";
      }
      catch (Exception localException)
      {
        String str2;
        StringBuilder localStringBuilder;
        if (!QLog.isDevelopLevel()) {
          break label271;
        }
        QLog.w(ImmersiveUtils.TAG, 1, "setSystemStatusBar, Exception", localException);
        return;
        String str1 = "隐藏";
        continue;
      }
      QLog.w(str2, 1, (String)localObject + "状态栏, isToolBarDisplay[" + paramBoolean1 + "], recordNeedShowBar[" + paramBoolean2 + "], SystemUiVisibility[0x" + Integer.toHexString(localWindow.getDecorView().getSystemUiVisibility()) + "], flags[0x" + Integer.toHexString(localWindow.getAttributes().flags) + "]");
      return;
      localWindow.addFlags(1024);
      continue;
      label271:
      return;
      label272:
      int i = 0;
    }
  }
  
  private void N(long paramLong, int paramInt)
  {
    if (isDestroyed()) {}
    do
    {
      return;
      if ((!CameraUtils.a(this.mApplicationContext).aq(paramLong)) && (!CameraUtils.a(this.mApplicationContext).ar(paramLong))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(this.TAG, 1, "enableCameraRelatedBtn, cameraAvailable[" + paramInt + "], already opening or opened");
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.b().anu = paramInt;
    O(paramLong, 65535);
  }
  
  public static int a(iiv paramiiv, int paramInt)
  {
    int j = 2131698050;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = 2131698046;
    }
    for (;;)
    {
      if (paramiiv.uinType == 1011)
      {
        if (paramInt != 9) {
          break;
        }
        i = 2131721705;
      }
      return i;
      i = 2131721723;
      continue;
      i = j;
      if (!paramiiv.Qg)
      {
        i = 2131698048;
        continue;
        i = 2131697893;
        continue;
        i = 2131698047;
        continue;
        i = 2131698045;
        continue;
        i = 2131698049;
        continue;
        i = 2131698046;
        continue;
        i = 2131697966;
      }
    }
    return 2131697623;
  }
  
  public static boolean ag(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (!VideoController.isScreenLocked(paramContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected static boolean hasSmartBar()
  {
    if (axE == -1)
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break label32;
      }
      axE = 0;
    }
    for (;;)
    {
      if (axE == 1)
      {
        return true;
        try
        {
          label32:
          bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
          if (Build.DEVICE.equals("mx2"))
          {
            bool = true;
            if (!bool) {
              break label125;
            }
            i = 1;
            axE = i;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            boolean bool = false;
            continue;
            if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9")))
            {
              bool = false;
              continue;
              label125:
              i = 0;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void inflate(int paramInt)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.getLayoutInflater().inflate(paramInt, this.mRootView);
    }
  }
  
  private void kg(boolean paramBoolean)
  {
    M(paramBoolean, true);
  }
  
  private int mf()
  {
    if ((!this.Yg) && (!this.Ya)) {}
    for (int i = 1; i != 0; i = 0) {
      return mg();
    }
    return mh();
  }
  
  private int mg()
  {
    return this.mRes.getDimensionPixelSize(2131298036);
  }
  
  private int mh()
  {
    int i = 0;
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(99);
    if (localRelativeLayout != null)
    {
      localRelativeLayout.measure(0, 0);
      i = localRelativeLayout.getMeasuredHeight();
    }
    return i;
  }
  
  private boolean wJ()
  {
    return Build.MODEL.equalsIgnoreCase("Redmi Note 4");
  }
  
  public int A(long paramLong)
  {
    int i = 0;
    if (this.mRootView == null) {}
    while (this.er == null) {
      return 0;
    }
    int j = this.mRes.getDimensionPixelSize(2131299741);
    if ((this.mRootView.getRootView().findViewById(2131374242) == null) || (!this.Ya))
    {
      QLog.w(this.TAG, 1, "getTopToolbarHeight, topToolbarHeight[" + i + "], margin[" + j + "], mInToolBarAnimation[" + this.Yg + "], mToolbarDisplayFrameNow[" + this.axF + "], seq[" + paramLong + "]");
      return i;
    }
    if (this.Yg) {
      i = j / 5;
    }
    for (i = Math.max(this.axF, 0) * i;; i = j)
    {
      i += mj();
      break;
    }
  }
  
  public void A(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAVActivity.getString(2131697834);
      paramString = localAVActivity.getString(2131697835);
    }
    for (;;)
    {
      i(paramLong, str, paramString);
      return;
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        str = localAVActivity.getString(2131697844);
        paramString = localAVActivity.getString(2131697845);
      }
      else
      {
        if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
          break;
        }
        str = localAVActivity.getString(2131697842);
        paramString = localAVActivity.getString(2131697843);
      }
    }
  }
  
  public void D(long paramLong, int paramInt)
  {
    if (isDestroyed()) {
      return;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onClose, type[" + paramInt + "], sessionInfo[" + localiiv + "], seq[" + paramLong + "]");
    }
    if (localiiv.tf()) {
      lQ(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Jkz != null) {
        this.jdField_a_of_type_Jkz.lh(false);
      }
      if ((!ivv.tY()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373939, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373944, false);
      return;
      if ((paramInt == 25) || (paramInt == 56)) {
        lQ(paramInt);
      }
      asr();
    }
  }
  
  public void E(long paramLong, int paramInt) {}
  
  public void G(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void K(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void L(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373939, paramBoolean);
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, paramBoolean);
      this.Ye = paramBoolean;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.L(this.Ye, this.Yf);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131374253, paramBoolean);
  }
  
  void M(long paramLong, boolean paramBoolean)
  {
    this.VC = paramBoolean;
  }
  
  public void N(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axJ();
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.b().deviceName;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, this.QK, str);
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.QK + "], deviceName[" + str + "], seq[" + paramLong + "]");
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(paramLong, str);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.startService(this.QK);
  }
  
  public void O(long paramLong, int paramInt)
  {
    if (isDestroyed()) {}
    do
    {
      return;
      Yj = AudioHelper.aCz();
      if ((paramInt & 0x1) == 1) {
        dH(paramLong);
      }
      if ((paramInt & 0x2) == 2) {
        aD(paramLong);
      }
      if ((paramInt & 0x4) == 4) {
        cZ(paramLong);
      }
      if ((paramInt & 0x8) == 8) {
        aE(paramLong);
      }
      if ((paramInt & 0x10) == 16) {
        dL(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        dI(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        aC(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        dM(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        dG(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        dJ(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        dK(paramLong);
      }
      if ((paramInt & 0x1000) == 4096) {
        db(paramLong);
      }
      if ((paramInt & 0x2000) == 8192) {
        dF(paramLong);
      }
      cY(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.atZ();
    } while (!Yj);
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "updateBtn, sessionInfo[" + localiiv + "], screenStyle[" + localiiv.ani + "], remoteHasVideo[" + localiiv.PZ + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
  }
  
  void P(long paramLong, int paramInt)
  {
    if (paramInt > 0)
    {
      z(paramLong, this.mRes.getString(paramInt));
      return;
    }
    z(paramLong, null);
  }
  
  void Q(long paramLong, int paramInt)
  {
    if (this.mZ != null)
    {
      if ((QLog.isDevelopLevel()) || (this.mZ.getVisibility() != paramInt)) {
        QLog.w(this.TAG, 1, "setVisibility_ConnectInfoView_MiddleCenter, visibility[" + this.mZ.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.mZ.setVisibility(paramInt);
    }
  }
  
  void R(long paramLong, int paramInt)
  {
    if (this.na != null)
    {
      if ((QLog.isDevelopLevel()) || (this.na.getVisibility() != paramInt)) {
        QLog.w(this.TAG, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.na.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.na.setVisibility(paramInt);
    }
  }
  
  void S(long paramLong, int paramInt)
  {
    if ((2131697531 != paramInt) && (2131697529 != paramInt) && (2131697538 != paramInt)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 0, true);
    }
  }
  
  public void V(String paramString, boolean paramBoolean) {}
  
  public AlphaAnimation a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setStartOffset(0L);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      return localAlphaAnimation;
    }
  }
  
  public AVActivity a()
  {
    if (this.mContext == null) {}
    while (!(this.mContext.get() instanceof AVActivity)) {
      return null;
    }
    return (AVActivity)this.mContext.get();
  }
  
  public EffectSettingUi a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      return (EffectSettingUi)this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2);
    }
    return null;
  }
  
  public QavPanel a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanel;
  }
  
  void a(long paramLong, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {}
    label210:
    label216:
    do
    {
      boolean bool2;
      do
      {
        return;
        if (!localAVActivity.isResume())
        {
          QLog.w(this.TAG, 1, "showPermissionDialog, no isResume, seq[" + paramLong + "]");
          return;
        }
        boolean bool1;
        if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0)
        {
          bool1 = true;
          if (localAVActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label210;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          QLog.w(this.TAG, 1, "showPermissionDialog, issueType[" + paramInt + "], showNormalDialog[" + paramBoolean + "], checkCameraResult[" + bool1 + "], checkRecordResult[" + bool2 + "], seq[" + paramLong + "]");
          if ((bool1) || (bool2) || (paramInt != 2)) {
            break label216;
          }
          localAVActivity.requestPermissions(this, 0, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
          this.Yd = true;
          return;
          bool1 = false;
          break;
        }
        switch (paramInt)
        {
        default: 
          return;
        case 2: 
          if (!bool1)
          {
            localAVActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
            this.Yd = true;
            return;
          }
          break;
        }
      } while (!paramBoolean);
      j(paramLong, paramString1, paramString2);
      return;
      if (!bool2)
      {
        localAVActivity.requestPermissions(this, 2, new String[] { "android.permission.RECORD_AUDIO" });
        return;
      }
    } while (!paramBoolean);
    j(paramLong, paramString1, paramString2);
  }
  
  public abstract void a(long paramLong, View paramView);
  
  boolean a(long paramLong, String paramString, View paramView)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return false;
    }
    label54:
    int k;
    int j;
    if (localAVActivity.checkSelfPermission(paramString) == 0)
    {
      i = 1;
      if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
        break label269;
      }
      if ((i == 0) || (localAVActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
        break label183;
      }
      i = 1;
      k = 1;
      j = i;
    }
    for (int i = k;; i = 0)
    {
      if (j == 0)
      {
        if (ag(localAVActivity))
        {
          paramView = new jdx(this, paramString, paramLong, paramView);
          QLog.w(this.TAG, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.Yk + "], seq[" + paramLong + "]");
          this.Yk = true;
          if (i == 0)
          {
            localAVActivity.requestPermissions(paramView, 0, new String[] { paramString });
            return false;
            i = 0;
            break;
            label183:
            i = 0;
            break label54;
          }
          localAVActivity.requestPermissions(paramView, 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return false;
        }
        QLog.w(this.TAG, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
        A(paramLong, paramString);
        return false;
      }
      return true;
      label269:
      j = i;
    }
  }
  
  boolean aC(long paramLong)
  {
    boolean bool3 = true;
    if (isDestroyed()) {}
    jiu localjiu;
    do
    {
      return false;
      localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697530);
      if (localjiu != null) {
        break;
      }
    } while (!Yj);
    QLog.w(this.TAG, 1, "updateBtn_InviteMember, null, seq[" + paramLong + "]");
    return false;
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int i;
    boolean bool1;
    if (localiiv.uinType == 1044)
    {
      i = 8;
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool2 = true;
        label105:
        localjiu.kU(bool2);
        if (i != 0) {
          break label334;
        }
      }
      label334:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        localjiu.setVisiable(bool2);
        return bool1;
        if ((localiiv.amI == 3) || (localiiv.amI == 4))
        {
          if (localiiv.tm())
          {
            if (!Yj) {
              break label356;
            }
            QLog.w(this.TAG, 1, "updateBtn_InviteMember, isHrConf, seq[" + paramLong + "]");
            i = 8;
            bool1 = false;
            break;
          }
          if (((this instanceof MultiVideoCtrlLayerUIBase)) && (((MultiVideoCtrlLayerUIBase)this).isFull()))
          {
            if (!Yj) {
              break label348;
            }
            QLog.w(this.TAG, 1, "updateBtn_InviteMember, isFull, seq[" + paramLong + "]");
            i = 0;
            bool1 = false;
            break;
          }
        }
        if (!isKeyguardLock()) {
          break label340;
        }
        if (Yj) {
          QLog.w(this.TAG, 1, "updateBtn_InviteMember, isKeyguardLock, seq[" + paramLong + "]");
        }
        i = 0;
        bool1 = false;
        break;
        bool2 = false;
        break label105;
      }
      label340:
      i = 0;
      bool1 = true;
      continue;
      label348:
      i = 0;
      bool1 = false;
      continue;
      label356:
      i = 8;
      bool1 = false;
    }
  }
  
  boolean aD(long paramLong)
  {
    if (isDestroyed()) {}
    jiu localjiu;
    do
    {
      return false;
      localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697526);
      if (localjiu != null) {
        break;
      }
    } while (!Yj);
    QLog.w(this.TAG, 1, "updateBtn_Camera, null, seq[" + paramLong + "]");
    return false;
    boolean bool1;
    if (irc.getGLVersion(this.mApp.getApp()) == 1)
    {
      if (!Yj) {
        break label627;
      }
      QLog.w(this.TAG, 1, "updateBtn_Camera, GLVersion, seq[" + paramLong + "]");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        localjiu.kU(bool2);
        if (Yj) {
          QLog.d(this.TAG, 1, "updateBtn_Camera, enable[" + bool1 + "], seq[" + paramLong + "]");
        }
        return bool1;
        iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (localiiv.uinType == 1044)
        {
          localjiu.setVisiable(false);
          bool1 = false;
          break;
        }
        if ((localiiv.amI == 1) || (localiiv.amI == 2))
        {
          if ((localiiv.ta()) || (localiiv.tf()) || (localiiv.tg()))
          {
            if (!Yj) {
              break label627;
            }
            QLog.w(this.TAG, 1, "updateBtn_Camera, state[" + localiiv.state + "], seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.sq()) {
            break label450;
          }
          if (!Yj) {
            break label627;
          }
          QLog.w(this.TAG, 1, "updateBtn_Camera, !canAVShift, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (((localiiv.amI == 3) || (localiiv.amI == 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.OB))
        {
          if (!Yj) {
            break label627;
          }
          QLog.w(this.TAG, 1, "updateBtn_Camera, 没有进入房间, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        label450:
        if (!localiiv.Qc)
        {
          if (!Yj) {
            break label627;
          }
          QLog.w(this.TAG, 1, "updateBtn_Camera, cameraPermission, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (localiiv.anu == 0)
        {
          if (!Yj) {
            break label627;
          }
          QLog.w(this.TAG, 1, "updateBtn_Camera, mCameraAvailable, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (!CameraUtils.a((Context)this.mContext.get()).aq(paramLong)) {
          break label632;
        }
        if (!Yj) {
          break label627;
        }
        QLog.w(this.TAG, 1, "updateBtn_Camera, isCameraOpening, seq[" + paramLong + "]");
        bool1 = false;
        break;
      }
      label627:
      bool1 = false;
      continue;
      label632:
      bool1 = true;
    }
  }
  
  public boolean aE(long paramLong)
  {
    if (isDestroyed()) {}
    jiu localjiu1;
    jiu localjiu2;
    do
    {
      return false;
      localjiu1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697529);
      localjiu2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697539);
    } while ((localjiu1 == null) && (localjiu2 == null));
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (iow.uW()) {
      if (!CameraUtils.a((Context)this.mContext.get()).aq(paramLong)) {
        break label268;
      }
    }
    label268:
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool3 = true;
      boolean bool2 = bool1;
      bool1 = bool3;
      if (localiiv.PY) {
        if (localjiu1 != null)
        {
          if (!bool2)
          {
            bool3 = true;
            label110:
            localjiu1.kU(bool3);
            localjiu1.setClickable(bool2);
            localjiu1.setVisiable(bool1);
          }
        }
        else if (localjiu2 != null) {
          localjiu2.setVisiable(false);
        }
      }
      for (;;)
      {
        if (localjiu2 != null) {
          localjiu2.kF(this.mApp.b().b().Na);
        }
        if (Yj) {
          QLog.d(this.TAG, 1, "updateBtn_EffectAndVoice, enable[" + bool2 + "], seq[" + paramLong + "]");
        }
        return true;
        bool1 = false;
        bool2 = false;
        break;
        bool3 = false;
        break label110;
        if (localjiu2 != null)
        {
          localjiu2.kU(false);
          localjiu2.setClickable(true);
          localjiu2.setVisiable(true);
        }
        if (localjiu1 != null) {
          localjiu1.setVisiable(false);
        }
      }
    }
  }
  
  public void aR(String paramString1, String paramString2) {}
  
  public void ai(int paramInt, String paramString)
  {
    if (paramInt == 1037) {}
    for (paramInt = 256;; paramInt = 257)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.removeMessages(paramInt);
        paramString = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.obtainMessage(paramInt, paramString);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.sendMessageDelayed(paramString, 1500L);
      }
      return;
    }
  }
  
  public void amT() {}
  
  public void amU()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onPauseAudio");
    }
  }
  
  public void amV()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onResumeAudio");
    }
  }
  
  public void amW() {}
  
  public void amY() {}
  
  public void amZ() {}
  
  public void ana() {}
  
  public void ari()
  {
    if (this.gK != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.gK.setVisibility(0);
      this.gK.startAnimation(localAlphaAnimation);
    }
  }
  
  public void aso()
  {
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.j(this.mApp);
    }
    if (this.jdField_b_of_type_Iyc != null) {
      this.jdField_b_of_type_Iyc.onPause();
    }
  }
  
  public void asq() {}
  
  void asr() {}
  
  public void ass() {}
  
  public void ast() {}
  
  public void auQ()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.removeMessages(256);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.removeMessages(257);
    }
  }
  
  void auR()
  {
    this.jdField_a_of_type_Jks = new jks();
    this.jdField_a_of_type_Jks.setDuration(100);
    this.jdField_a_of_type_Jks.nL(8);
    this.jdField_a_of_type_Jks.h(new int[] { 2130842829, 2130842830 });
    this.jdField_a_of_type_Jks.a(this.jdField_a_of_type_Jkr);
  }
  
  void auS()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.OS)) {
      this.mApp.getHandler().removeCallbacks(this.cc);
    }
  }
  
  public void auT()
  {
    iwu.l(this.mApp);
  }
  
  public void auU()
  {
    iwu.m(this.mApp);
  }
  
  public void auV()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("displayToolBar, isToolBarDisplay[").append(wH()).append("], mApp[");
      if (this.mApp == null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.mApp != null) {
        break;
      }
      return;
    }
    if (!wH())
    {
      kt(false);
      ml(0);
    }
    this.mApp.getHandler().removeCallbacks(this.cc);
  }
  
  public void auW()
  {
    if (isDestroyed()) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373939, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373944, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373941, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373942, false);
  }
  
  public void auX()
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.avF();
    }
  }
  
  public void auY() {}
  
  public void auZ()
  {
    M(wH(), true);
  }
  
  void ava()
  {
    if (this.axv - this.axx > 2)
    {
      this.axx = this.axv;
      this.axw = 0;
    }
    this.axw += 1;
    if (this.axw > 5)
    {
      this.axw = 0;
      this.axx = 0;
      kw(true);
    }
  }
  
  protected void b(long paramLong, View paramView) {}
  
  public long bN()
  {
    return 0L;
  }
  
  public void bQ(long paramLong)
  {
    if (this.jdField_a_of_type_Jkz != null) {
      this.jdField_a_of_type_Jkz.onConnected();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onConnected");
    }
  }
  
  public abstract void bZ(long paramLong);
  
  public void bv(int paramInt1, int paramInt2) {}
  
  void c(long paramLong, float paramFloat)
  {
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.b(paramLong, paramFloat);
    }
    if (this.jdField_b_of_type_Iyc != null) {
      this.jdField_b_of_type_Iyc.setRotation(paramFloat);
    }
  }
  
  public abstract void c(long paramLong, View paramView);
  
  public void c(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void cU(long paramLong)
  {
    this.auE = 2;
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.onStart();
    }
    this.Yd = false;
  }
  
  public void cV(long paramLong)
  {
    this.auE = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    iiv localiiv;
    do
    {
      return;
      if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.onResume();
      }
      if (this.jdField_b_of_type_Iwq != null) {
        this.jdField_b_of_type_Iwq.k(this.mApp);
      }
      if (this.jdField_b_of_type_Iyc != null) {
        this.jdField_b_of_type_Iyc.onResume();
      }
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if ((localiiv.isConnected()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      }
    } while ((!localiiv.ta()) || (localiiv.PT) || (localiiv.isConnected()) || (!localiiv.isVideo()) || ((aqiw.isWifiConnected(null)) && (AudioHelper.jY(0) != 1)));
    iwu.b(this.mApp, 1050);
  }
  
  public void cW(long paramLong)
  {
    this.auE = 5;
    dD(paramLong);
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.onStop();
    }
    if (this.jdField_a_of_type_Jkz != null) {
      this.jdField_a_of_type_Jkz.li(false);
    }
  }
  
  public void cX(long paramLong) {}
  
  protected void cY(long paramLong) {}
  
  protected void cZ(long paramLong) {}
  
  public boolean ct(int paramInt)
  {
    return false;
  }
  
  boolean cu(int paramInt)
  {
    if (a() != null) {
      return a().cu(paramInt);
    }
    return false;
  }
  
  public int cv(int paramInt)
  {
    return 0;
  }
  
  public abstract void d(long paramLong, View paramView);
  
  public abstract void d(long paramLong, boolean paramBoolean, int paramInt);
  
  public void dC(long paramLong)
  {
    if (this.VB) {}
    while ((this.auE < 2) || (this.auE > 4) || ((VideoLayerUIBase.b(this.jdField_a_of_type_ComTencentAvVideoController.b())) && (!wd()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "startTimer, seq[" + paramLong + "]");
    }
    this.VB = true;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable == null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = new TimmerRunnable();
    }
    this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable, 0L);
    z(paramLong, null);
  }
  
  public void dD(long paramLong)
  {
    if (!this.VB) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "stopTimer, seq[" + paramLong + "]");
    }
    this.VB = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable != null)
    {
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    }
    ki(null);
  }
  
  public void dE(long paramLong)
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      boolean bool = QLog.isDevelopLevel();
      String str = "";
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      Object localObject = a();
      if ((localObject != null) && (((AVActivity)localObject).vV()))
      {
        this.mApp.getHandler().removeCallbacks(this.cc);
        localObject = str;
        if (bool) {
          localObject = "isKeepToolBar";
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w(this.TAG, 1, "resetToolBarTimer, mToolbarDisplay[" + this.Ya + "], SessionType[" + localiiv.amI + "], log[" + (String)localObject + "], seq[" + paramLong + "]");
        return;
        if ((localiiv.amI == 2) || (localiiv.amI == 4))
        {
          this.mApp.getHandler().removeCallbacks(this.cc);
          localObject = str;
          if (this.Ya) {
            if ((localiiv.amI == 2) && (!localiiv.isConnected()))
            {
              localObject = str;
              if (bool) {
                localObject = "not Connected";
              }
            }
            else if ((localiiv.amI == 4) && (localiiv.tj()))
            {
              localObject = str;
              if (bool) {
                localObject = "not Recv Data";
              }
            }
            else
            {
              this.mApp.getHandler().postDelayed(this.cc, 6000L);
              localObject = str;
              if (bool) {
                localObject = acfp.m(2131716369);
              }
            }
          }
        }
        else if (localiiv.amI != 1)
        {
          localObject = str;
          if (localiiv.amI != 3) {}
        }
        else
        {
          this.mApp.getHandler().removeCallbacks(this.cc);
          localObject = str;
          if (!this.Ya)
          {
            ml(0);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void dF(long paramLong)
  {
    boolean bool3 = true;
    if (isDestroyed()) {}
    jiu localjiu;
    do
    {
      do
      {
        return;
        localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697538);
        if (localjiu != null) {
          break;
        }
      } while (!Yj);
      QLog.w(this.TAG, 1, "updateBtn_VirtualBackground, null, seq[" + paramLong + "]");
      return;
      if ((Context)this.mContext.get() != null) {
        break;
      }
    } while (!Yj);
    QLog.w(this.TAG, 1, "updateBtn_VirtualBackground, context is null, seq[" + paramLong + "]");
    return;
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (AEFilterSupport.uP()) {
      if (!CameraUtils.a((Context)this.mContext.get()).aq(paramLong)) {
        break label293;
      }
    }
    label291:
    label293:
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool4 = true;
      boolean bool2 = bool1;
      bool1 = bool4;
      if (localiiv.PY) {
        if (!bool2)
        {
          label182:
          localjiu.kU(bool3);
          localjiu.setClickable(bool2);
          localjiu.setVisiable(bool1);
        }
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label291;
        }
        QLog.i(this.TAG, 2, "updateBtn_VirtualBackground, visible[" + bool1 + "], enable[" + bool2 + "], localHasVideo[" + localiiv.PY + "]");
        return;
        bool1 = false;
        bool2 = false;
        break;
        bool3 = false;
        break label182;
        localjiu.setVisiable(false);
        bool1 = false;
      }
      break;
    }
  }
  
  void dG(long paramLong)
  {
    int j = 8;
    if (isDestroyed()) {
      return;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int i;
    if (!iow.uW())
    {
      i = j;
      if (Yj)
      {
        QLog.w(this.TAG, 1, "updateBtn_Beauty, !isEnableAEModuleManager, seq[" + paramLong + "]");
        i = j;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.mK(i);
      if (!Yj) {
        break;
      }
      QLog.d(this.TAG, 1, "updateBtn_Beauty, show[" + i + "], seq[" + paramLong + "]");
      return;
      if (!localiiv.PY)
      {
        i = j;
        if (Yj)
        {
          QLog.w(this.TAG, 1, "updateBtn_Beauty, !localHasVideo, seq[" + paramLong + "]");
          i = j;
        }
      }
      else if (!ikx.tM())
      {
        i = j;
        if (Yj)
        {
          QLog.w(this.TAG, 1, "updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[" + paramLong + "]");
          i = j;
        }
      }
      else if ((AEFilterSupport.uP()) && (!AEFilterSupport.cp(2)))
      {
        i = j;
        if (Yj)
        {
          QLog.w(this.TAG, 1, "updateBtn_Beauty, AEKitSo not ready, seq[" + paramLong + "]");
          i = j;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  void dH(long paramLong)
  {
    boolean bool = false;
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int j;
    if ((((iiv)localObject).amI == 1) && (!((iiv)localObject).isConnected()))
    {
      j = 8;
      i = j;
      if (Yj) {
        QLog.w(this.TAG, 1, "updateBtn_More, !isConnected, seq[" + paramLong + "]");
      }
    }
    for (int i = j;; i = 0)
    {
      j = this.jdField_a_of_type_ComTencentAvUiQavPanel.cy(2131374249);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374249, i);
      localObject = a();
      if ((j != i) && (localObject != null))
      {
        if (i == 0) {
          bool = true;
        }
        ((AVActivity)localObject).jl(bool);
        ((AVActivity)localObject).b(paramLong, 2131374249, j, i);
      }
      if (!Yj) {
        break;
      }
      QLog.d(this.TAG, 1, "updateBtn_More, show[" + i + "], lastvisibility[" + j + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  void dI(long paramLong)
  {
    if (isDestroyed()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PY) && (this.aoI > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374253, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374253, 8);
  }
  
  void dJ(long paramLong)
  {
    if (isDestroyed()) {}
    jiu localjiu;
    do
    {
      return;
      localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697537);
      if (localjiu != null) {
        break;
      }
    } while (!Yj);
    QLog.w(this.TAG, 1, "updateBtn_VideoMode, null, seq[" + paramLong + "]");
    return;
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int i = 2130843059;
    if (localiiv.ani == 4) {
      i = 2130843058;
    }
    localjiu.nD(i);
    if ((!localiiv.PY) && (!localiiv.PZ)) {}
    for (boolean bool = false;; bool = true)
    {
      localjiu.setVisiable(bool);
      if (!Yj) {
        break;
      }
      QLog.d(this.TAG, 1, "updateBtn_VideoMode, bShow[" + bool + "], screenStyle[" + localiiv.ani + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  void dK(long paramLong)
  {
    boolean bool2 = false;
    if (isDestroyed()) {}
    int i;
    boolean bool3;
    do
    {
      jiu localjiu;
      do
      {
        return;
        localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697534);
        if (localjiu != null) {
          break;
        }
      } while (!Yj);
      QLog.w(this.TAG, 1, "updateBtn_ScreenShot, null, seq[" + paramLong + "]");
      return;
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      int j = 8;
      i = j;
      if (!localiiv.Ql) {
        if (localiiv.amI != 4)
        {
          i = j;
          if (localiiv.amI != 2) {}
        }
        else
        {
          i = 0;
        }
      }
      bool3 = wJ();
      boolean bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      localjiu.setVisiable(bool1);
    } while (!Yj);
    QLog.d(this.TAG, 1, "updateBtn_ScreenShot, visible[" + i + "], seq[" + paramLong + "], isBlackMachine[" + bool3 + "]");
  }
  
  void dL(long paramLong)
  {
    if (isDestroyed()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.sp())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373939, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373939, true);
  }
  
  void dM(long paramLong)
  {
    boolean bool3 = false;
    if (isDestroyed()) {}
    jiu localjiu;
    do
    {
      return;
      localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697528);
      if (localjiu != null) {
        break;
      }
    } while (!Yj);
    QLog.w(this.TAG, 1, "updateBtn_ControlMember, null, seq[" + paramLong + "]");
    return;
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int i;
    boolean bool1;
    if ((localiiv.amI == 1) || (localiiv.amI == 2))
    {
      i = 8;
      bool1 = false;
    }
    for (;;)
    {
      label102:
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        localjiu.kU(bool2);
        localjiu.setClickable(bool1);
        bool2 = bool3;
        if (i == 0) {
          bool2 = true;
        }
        localjiu.setVisiable(bool2);
        if (!Yj) {
          break;
        }
        QLog.d(this.TAG, 1, "updateBtn_ControlMember, enable[" + bool1 + "], visible[" + i + "], seq[" + paramLong + "]");
        return;
        if ((localiiv.amI != 3) && (localiiv.amI != 4)) {
          break label288;
        }
        if ((!localiiv.QO) && (!localiiv.QP))
        {
          i = 8;
          bool1 = false;
          break label102;
        }
        if (localiiv.tm())
        {
          i = 8;
          bool1 = false;
          break label102;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {
          break label288;
        }
        i = 0;
        bool1 = false;
        break label102;
      }
      label288:
      i = 0;
      bool1 = true;
    }
  }
  
  public abstract void da(long paramLong);
  
  public void db(long paramLong)
  {
    if ((QLog.isColorLevel()) && (paramLong == -1052L)) {
      QLog.i(this.TAG, 2, "updateBtn_ScreenShare");
    }
    if (isDestroyed()) {}
    jiu localjiu;
    Context localContext;
    do
    {
      do
      {
        return;
        localjiu = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131697532);
        if (localjiu != null) {
          break;
        }
      } while (!Yj);
      QLog.w(this.TAG, 1, "updateBtn_ScreenShare, null, seq[" + paramLong + "]");
      return;
      localContext = (Context)this.mContext.get();
      if (localContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("normal_2_meeting", 2, "updateBtn_ScreenShare context is null.");
    return;
    if (Build.VERSION.SDK_INT < 21) {
      localjiu.setVisiable(false);
    }
    iiv localiiv;
    for (;;)
    {
      localiiv = igv.a().a();
      if (localiiv.uinType != 1044) {
        break;
      }
      localjiu.setVisiable(false);
      localjiu.setClickable(false);
      return;
      localjiu.setVisiable(true);
    }
    if ((localiiv.a == VideoConstants.EmShareState.START_SUC) || (localiiv.a == VideoConstants.EmShareState.REQUESTING_START))
    {
      localjiu.nD(2130842869);
      localjiu.setText(localContext.getResources().getString(2131697533));
      return;
    }
    localjiu.nD(2130842868);
    localjiu.setText(localContext.getResources().getString(2131697532));
  }
  
  public void de(long paramLong)
  {
    this.auE = 4;
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.onPause();
    }
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog deniedForAudioRecord(2) 04");
  }
  
  @QQPermissionDenied(1)
  public void deniedForCamera()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog deniedForCamera(1) 02");
  }
  
  @QQPermissionDenied(0)
  public void deniedForCameraAudio()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog deniedForCameraAudio(1) 00");
  }
  
  protected void dx(long paramLong) {}
  
  protected void dy(long paramLong) {}
  
  String dz(String paramString)
  {
    return paramString;
  }
  
  public void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.f(paramInt1, paramInt2, paramInt3, paramString);
    }
  }
  
  void f(long paramLong, String paramString, boolean paramBoolean) {}
  
  @TargetApi(21)
  public void g(long paramLong, View paramView)
  {
    if (!igv.a().a().tp())
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
      }
      ScreenShareCtrl.showTips(7);
      return;
    }
    S(paramLong, 2131697532);
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramView != null) {
      paramView.b(a(), paramLong);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.post(new VideoControlUI.11(this));
  }
  
  void g(Boolean paramBoolean)
  {
    ku(paramBoolean.booleanValue());
  }
  
  protected abstract int getLayout();
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog grantForAudioRecord(2) 03");
  }
  
  @QQPermissionGrant(1)
  public void grantForCamera()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog grantForCamera(1) 01");
  }
  
  @QQPermissionGrant(0)
  public void grantForCameraAudio()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog grantForCameraAudio(1) 0");
  }
  
  public void h(int paramInt1, int paramInt2, String paramString) {}
  
  public void h(long paramLong, View paramView)
  {
    if (isDestroyed()) {
      return;
    }
    dE(paramLong);
    paramView = new iya.d(paramView);
    paramView.u(paramLong, null);
    this.mApp.l(new Object[] { Integer.valueOf(9005), paramView });
    if (paramView.Wa) {
      QLog.w(this.TAG, 1, "onClick_More, mBlockName[" + paramView.Rj + "], seq" + paramLong + "]");
    }
    for (;;)
    {
      a().cP(paramLong);
      return;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel.cC(1)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 0, true);
      } else {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 1, true);
      }
    }
  }
  
  public void hF(boolean paramBoolean) {}
  
  void i(long paramLong, View paramView)
  {
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onClick_ScreenShot, seq[" + paramLong + "]");
    this.mApp.addObserver(new jdw(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.b != null)) {
      paramView.b.dZ(l1);
    }
    jjk.a.axb();
  }
  
  void i(long paramLong, String paramString1, String paramString2)
  {
    if (isDestroyed()) {
      return;
    }
    AVActivity localAVActivity = a();
    paramString1 = aqha.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131721058, new jeb(this, paramLong));
    if (jll.i(localAVActivity)) {}
    for (int i = 2131697846;; i = 2131697847)
    {
      paramString1.setPositiveButton(i, new jea(this, paramLong)).show();
      return;
    }
  }
  
  public void i(String paramString, Bitmap paramBitmap) {}
  
  public void iD(String paramString) {}
  
  void initUI()
  {
    if (this.mRootView == null) {}
    AVActivity localAVActivity;
    do
    {
      return;
      inflate(getLayout());
      this.er = ((RelativeLayout)this.mRootView.findViewById(2131374241));
      this.es = ((RelativeLayout)this.mRootView.getRootView().findViewById(2131374242));
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.mRootView.findViewById(2131374149));
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$c = new c(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$c);
      this.jdField_b_of_type_ComTencentAvUiQavPanel$e = new jdu(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_ComTencentAvUiQavPanel$e);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.l(new jdy(this));
      this.eq = ((RelativeLayout)this.mRootView.findViewById(2131370361));
      localAVActivity = a();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "initUI-->can not get AVActivity");
    return;
    this.nb = ((TextView)localAVActivity.findViewById(2131374206));
    this.mGestureDetector = new GestureDetector((Context)this.mContext.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.nb.setOnTouchListener(this.l);
    this.nb.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.mRootView.findViewById(2131374142) != null) && (this.mRootView.findViewById(2131374143) != null))
    {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.mApp, localAVActivity, this.mRootView);
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.onCreate();
    }
    this.na = ((TextView)this.mRootView.findViewById(2131365755));
    this.mZ = ((TextView)this.mRootView.findViewById(2131374248));
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    if (this.jdField_a_of_type_Jkz != null) {
      this.jdField_a_of_type_Jkz.lh(false);
    }
    this.jdField_a_of_type_Jkz = jkz.a(this.jdField_a_of_type_Jkz, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    this.jdField_a_of_type_Jkz.lh(true);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
    ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131373916);
    this.jdField_b_of_type_Iwq = new iwq();
    this.jdField_b_of_type_Iwq.a(this.mApp, localViewGroup);
    this.jdField_b_of_type_Iyc = new iyc(this.mApp);
    this.jdField_b_of_type_Iyc.bM(localViewGroup);
    if (AudioHelper.jY(0) == 1)
    {
      this.er.setBackgroundColor(2147475117);
      this.es.setBackgroundColor(2147475117);
      this.er.findViewById(2131374245).setBackgroundColor(2145838842);
      this.es.findViewById(2131374246).setBackgroundColor(2145838842);
    }
    new d(this.mRootView).e(localAVActivity);
  }
  
  public boolean isDestroyed()
  {
    return this.auE == 6;
  }
  
  @TargetApi(16)
  public boolean isKeyguardLock()
  {
    if (this.mContext.get() != null)
    {
      Context localContext = (Context)this.mContext.get();
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
          }
          if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
          {
            boolean bool = localKeyguardManager.isKeyguardSecure();
            if (bool) {
              return true;
            }
          }
          return false;
        }
        catch (SecurityException localSecurityException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "isKeyguardLocked() = " + localSecurityException);
          }
          return aqlr.isScreenLocked(localContext);
        }
      }
      return aqlr.isScreenLocked(localContext);
    }
    return true;
  }
  
  void j(long paramLong, View paramView)
  {
    jjk.axa();
    paramView = new iya.b(paramView, 1);
    paramView.avC = 5;
    this.mApp.l(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.Wa) {
      QLog.w(this.TAG, 1, "onClick_Voice, mBlockName[" + paramView.Rj + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      S(paramLong, 2131697529);
      return;
      QLog.w(this.TAG, 1, "onClick_Voice, mEffectBtnID[" + paramView.avC + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.L(paramLong, paramView.avC);
    }
  }
  
  void j(long paramLong, String paramString1, String paramString2)
  {
    if (this.mContext == null) {
      return;
    }
    QLog.w(this.TAG, 1, "showPermissionDialog, msg[" + paramString1 + "], title[" + paramString2 + "], seq[" + paramLong + "]");
    AVActivity localAVActivity = a();
    paramString1 = aqha.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131721058, new jed(this, paramLong));
    if (jll.i(localAVActivity)) {}
    for (int i = 2131697846;; i = 2131697847)
    {
      paramString1 = paramString1.setPositiveButton(i, new jec(this, paramLong));
      if (!localAVActivity.isResume()) {
        break;
      }
      try
      {
        paramString1.show();
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d(this.TAG, 1, "showPermissionDialog, crash", paramString1);
        return;
      }
    }
  }
  
  public void jY(String paramString) {}
  
  public void jZ(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().switchState == 11)
    {
      iwu.b(this.mApp, 1015);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().switchState == 16)
    {
      iwu.b(this.mApp, 1061);
      return;
    }
    iwu.a(this.mApp, 1047);
  }
  
  void k(long paramLong, View paramView)
  {
    paramView = new iya.b(paramView, 2);
    paramView.avC = -1;
    this.mApp.l(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.Wa) {
      QLog.w(this.TAG, 1, "onClick_Effect, mBlockName[" + paramView.Rj + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      S(paramLong, 2131697529);
      return;
      QLog.w(this.TAG, 1, "onClick_Effect, mEffectBtnID[" + paramView.avC + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.L(paramLong, paramView.avC);
    }
  }
  
  public void kh(String paramString)
  {
    QLog.w(this.TAG, 1, "hideToolBar[" + paramString + "], isToolBarDisplay[" + wH() + "], mToolbarDisplay[" + this.Ya + "]");
    if (this.Ya) {
      ml(0);
    }
    this.mApp.getHandler().removeCallbacks(this.cc);
  }
  
  void ki(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    TextView localTextView;
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.w(this.TAG, 1, "setChatTime, time[" + paramString + "]");
        }
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.v(2131364460);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!jll.aai);
    if (TextUtils.isEmpty(paramString))
    {
      jll.b(localTextView, "");
      return;
    }
    jll.b(localTextView, jll.dD(paramString));
  }
  
  public void kk(boolean paramBoolean)
  {
    kn(paramBoolean);
  }
  
  public void kl(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity != null) && (localAVActivity.a != null)) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 2;; i = 0)
    {
      localAVActivity.a.nw(i);
      return;
    }
  }
  
  void km(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
  }
  
  void kn(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable == null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = new ShowSharpInfoRunnable();
    }
    if (paramBoolean)
    {
      this.mApp.getHandler().post(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable);
      return;
    }
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable);
  }
  
  public void ko(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.kI(paramBoolean);
    }
  }
  
  public void kp(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.kJ(paramBoolean);
    }
  }
  
  public void kq(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.kH(paramBoolean);
    }
  }
  
  public void kr(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.kK(paramBoolean);
    }
  }
  
  public void ks(boolean paramBoolean)
  {
    M(wH(), paramBoolean);
  }
  
  public void kt(boolean paramBoolean)
  {
    if (this.Ya != paramBoolean)
    {
      this.Ya = paramBoolean;
      this.mApp.l(new Object[] { Integer.valueOf(170), Boolean.valueOf(this.Ya) });
    }
  }
  
  public void ku(boolean paramBoolean)
  {
    if (this.mRootView == null) {}
    View localView;
    do
    {
      return;
      localView = this.mRootView.findViewById(2131374260);
    } while (localView == null);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  protected void kv(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      iwu.a(this.jdField_a_of_type_ComTencentAvVideoController.mApp, i, 3000L);
      return;
    }
  }
  
  public void kw(boolean paramBoolean)
  {
    if (this.nb == null) {
      return;
    }
    if (paramBoolean) {
      this.nb.setVisibility(0);
    }
    for (;;)
    {
      AudioHelper.cTR = paramBoolean;
      kk(paramBoolean);
      return;
      this.nb.setVisibility(8);
    }
  }
  
  void l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mToast != null)
    {
      int i = Build.VERSION.SDK_INT;
      if ((i != 14) && (i != 15)) {
        this.mToast.cancel();
      }
    }
    this.mToast = null;
    Context localContext = (Context)this.mContext.get();
    if (localContext != null)
    {
      if (paramInt4 == 0) {}
      try
      {
        this.mToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).show();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.TAG, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.mToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).show(paramInt4);
      return;
    }
  }
  
  public void l(long paramLong, View paramView)
  {
    paramView = new iya.b(paramView, 2);
    paramView.avC = -1;
    this.mApp.l(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.Wa) {
      QLog.w(this.TAG, 1, "onClick_VirtualBackground, mBlockName[" + paramView.Rj + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      S(paramLong, 2131697538);
      jjc.b("0X800ADA9", 0, 0, "", "", "", "");
      return;
      QLog.w(this.TAG, 1, "onClick_VirtualBackground, mEffectBtnID[" + paramView.avC + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c(paramLong, 4, true);
    }
  }
  
  void lM(int paramInt) {}
  
  void lQ(int paramInt)
  {
    lM(a(this.jdField_a_of_type_ComTencentAvVideoController.b(), paramInt));
  }
  
  public void m(long paramLong1, long paramLong2, long paramLong3)
  {
    int i;
    if (!this.Yf)
    {
      if (paramLong1 != 0L) {
        break label63;
      }
      i = 2968;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 1, "doUpdateAudioVolumeChange nexValue:=" + i);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAudioVolumeValue(i);
      return;
      label63:
      if (paramLong1 == 100L) {
        i = 7187;
      } else {
        i = (int)(2968.75F + 4218.75F * (float)paramLong1 / 100.0F);
      }
    }
  }
  
  public void mX(int paramInt)
  {
    if (paramInt == 1037) {}
    for (paramInt = 256;; paramInt = 257)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.removeMessages(paramInt);
      }
      return;
    }
  }
  
  void mY(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, this.mRes.getString(2131694248));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.h(2131373947, true);
    this.Yf = true;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.L(this.Ye, this.Yf);
  }
  
  void mZ(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, this.mRes.getString(2131694240));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.h(2131373947, false);
    this.Yf = false;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.L(this.Ye, this.Yf);
  }
  
  public int mi()
  {
    int j = 0;
    if (this.mRootView == null) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return j;
    }
    int i = mf();
    j = this.mRes.getDimensionPixelSize(2131299723);
    if (this.Yg)
    {
      j = i / 5;
      j = Math.max(this.axF, 0) * j;
      if (j <= i) {}
    }
    for (;;)
    {
      j = i;
      if (!hasSmartBar()) {
        break;
      }
      return i + this.mRes.getDimensionPixelSize(2131298333);
      i = j;
      if (j <= 0)
      {
        i = mg();
        continue;
        if (this.Ya) {
          if ((this.mContext.get() != null) && (jll.getScreenWidth((Context)this.mContext.get()) <= 320)) {
            i = this.mRes.getDimensionPixelSize(2131298031) + j;
          } else {}
        }
      }
    }
  }
  
  public int mj()
  {
    if ((new d(this.mRootView).wK()) && (this.mContext.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.mContext.get());
    }
    return 0;
  }
  
  public abstract void mj(int paramInt);
  
  public abstract void mk(int paramInt);
  
  public void ml(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.isPressed())) {}
    label568:
    label710:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e(this.TAG, 2, "switchToolBar-->mVideoController is null, Why???");
            return;
          } while (((this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.OS)) || (this.Yc) || ((!this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)));
          bool2 = this.Ya;
          if (this.mRootView != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.TAG, 2, "switchToolBar-->mRootView is null Why");
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PY) || (this.jdField_a_of_type_ComTencentAvVideoController.b().PZ) || (this.jdField_a_of_type_ComTencentAvVideoController.b().Qw)) {
          break label568;
        }
        kt(true);
        QLog.w(this.TAG, 1, "switchToolBar, ToolbarDisplay[" + bool2 + "->" + this.Ya + "], type[" + paramInt + "]");
        ivv.arh();
        if (!this.Ya) {
          break label710;
        }
        iwu.b(this.mApp, false);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "WL_DEBUG switchToolBar mQavPanel.isShown()[" + this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown() + "], mTopToolbar.isShown()[" + this.er.isShown() + "]");
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.er.isShown()));
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
      }
      this.er.setVisibility(0);
      this.es.setVisibility(8);
      this.axz += 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "WL_DEBUG switchToolBar type=" + paramInt + ", toolbarShowTimes: " + this.axz);
      }
      if (paramInt == 1)
      {
        this.L = a(true);
        this.M = a(true);
      }
      for (;;)
      {
        if ((this instanceof MultiVideoCtrlLayerUIBase)) {
          ((MultiVideoCtrlLayerUIBase)this).atk();
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$f == null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI$f = new f(2);
        }
        if (this.jdField_b_of_type_ComTencentAvUiVideoControlUI$f == null) {
          this.jdField_b_of_type_ComTencentAvUiVideoControlUI$f = new f(1);
        }
        this.L.setAnimationListener(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$f);
        this.M.setAnimationListener(this.jdField_b_of_type_ComTencentAvUiVideoControlUI$f);
        if (imm.isLowLevelDevice()) {
          break label799;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.L);
        }
        this.er.startAnimation(this.M);
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1)
        {
          kt(true);
          break;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 3) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qw))
        {
          kt(true);
          break;
        }
        if (imp.a().a.mIsShow)
        {
          kt(true);
          break;
        }
        if (!this.Ya) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          kt(bool1);
          break;
        }
        this.L = AnimationUtils.loadAnimation((Context)this.mContext.get(), 2130772199);
        this.M = AnimationUtils.loadAnimation((Context)this.mContext.get(), 2130772236);
        continue;
        ((RelativeLayout)this.mRootView.getRootView().findViewById(2131374039)).setVisibility(4);
        if (paramInt == 1)
        {
          this.L = a(false);
          this.M = a(false);
        }
        else
        {
          this.L = AnimationUtils.loadAnimation((Context)this.mContext.get(), 2130772198);
          this.M = AnimationUtils.loadAnimation((Context)this.mContext.get(), 2130772235);
        }
      }
      if (this.mApp != null) {
        this.mApp.l(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.Ya), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$f != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$f.onAnimationEnd(null);
      }
    } while (this.mApp == null);
    label799:
    this.mApp.l(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.Ya), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void mm(int paramInt) {}
  
  public void mp(int paramInt) {}
  
  public void na(int paramInt)
  {
    this.aoI = paramInt;
  }
  
  public boolean onBackPressed()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a() != null)
    {
      bool1 = bool2;
      if (a().isShown()) {
        bool1 = a().onBackPressed();
      }
    }
    return bool1;
  }
  
  public void onCreate()
  {
    this.auE = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$a == null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$a = new a();
      if (this.mContext.get() == null) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "register camera availability change receiver");
      }
      this.mApplicationContext = ((Context)this.mContext.get()).getApplicationContext();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      if (this.mApplicationContext != null) {
        this.mApplicationContext.registerReceiver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$a, localIntentFilter);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      IntentFilter localIntentFilter;
      return;
    }
    QLog.d(this.TAG, 2, "CANNOT register camera availability change receiver!");
  }
  
  public void onDestroy(long paramLong)
  {
    this.auE = 6;
    if (this.jdField_b_of_type_Iwq != null)
    {
      this.jdField_b_of_type_Iwq.i(this.mApp);
      this.jdField_b_of_type_Iwq = null;
    }
    if (this.jdField_b_of_type_Iyc != null)
    {
      this.jdField_b_of_type_Iyc.destroy();
      this.jdField_b_of_type_Iyc = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$b = null;
    }
    dD(paramLong);
    if (this.mApp != null)
    {
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.mApp.getHandler().removeCallbacks(this.cc);
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$e != null)
      {
        this.mApp.deleteObserver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$e);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$e = null;
      }
    }
    if (this.jdField_a_of_type_Jkz != null) {
      this.jdField_a_of_type_Jkz.lh(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$a != null))
    {
      if (this.mApplicationContext == null) {
        break label394;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "UnRegister camera availability change receiver");
      }
      this.mApplicationContext.unregisterReceiver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$a);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$a = null;
      this.mApplicationContext = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.dz(paramLong);
        this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
      }
      this.mRes = null;
      this.mContext = null;
      this.mApp = null;
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      if (this.mRootView != null)
      {
        this.mRootView.removeAllViews();
        this.mRootView = null;
      }
      this.orientationListener = null;
      this.jdField_a_of_type_Jks = null;
      this.L = null;
      this.M = null;
      this.mToast = null;
      this.er = null;
      this.es = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$f = null;
      this.jdField_b_of_type_ComTencentAvUiVideoControlUI$f = null;
      this.gK = null;
      this.il = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
      this.c = null;
      this.mZ = null;
      this.na = null;
      this.jdField_a_of_type_Jkv = null;
      this.jdField_a_of_type_Jkr = null;
      this.jdField_a_of_type_Jkz = null;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
      if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.onDestroy();
        this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar = null;
      }
      return;
      label394:
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
  }
  
  public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onServiceConnected() {}
  
  public void q(long paramLong, boolean paramBoolean) {}
  
  public void r(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onDetectNoDevicePermission, issueType[" + this.axH + "->" + paramInt + "], isRequestCameraPermission[" + this.Yd + "], seq[" + paramLong + "]");
    }
    this.axH = paramInt;
    this.RG = "";
    AVActivity localAVActivity = a();
    String str2;
    String str1;
    if (paramInt == 1)
    {
      QLog.w(this.TAG, 1, "请求相机权限.2");
      str2 = localAVActivity.getString(2131697834);
      str1 = localAVActivity.getString(2131697835);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().ti())
      {
        this.RG = "0X8004892";
        this.RH = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1)
        {
          this.RG = "0X8004898";
          this.RH = "0X8004899";
        }
      }
    }
    do
    {
      for (;;)
      {
        this.Yh = true;
        anot.a(null, "CliOper", "", "", this.RG, this.RG, 0, 0, "", "", this.deviceName, "");
        if (!ag(localAVActivity)) {
          break label753;
        }
        if ((paramInt != 2) || (!this.Yd)) {
          break;
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)
        {
          this.RG = "0X800488C";
          this.RH = "0X800488D";
        }
      }
      if (paramInt == 2)
      {
        QLog.w(this.TAG, 1, "请求相机权限.3");
        str2 = localAVActivity.getString(2131697834);
        str1 = localAVActivity.getString(2131697835);
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().ti())
        {
          this.RG = "0X80049D3";
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1) {
            this.RG = "0X80049D4";
          }
        }
        for (;;)
        {
          this.Yh = false;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amK == 1) {
            this.RG = "0X80049D1";
          } else if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {
            this.RG = "0X80049D2";
          }
        }
      }
      if (paramInt == 3)
      {
        QLog.w(this.TAG, 1, "请求麦克风权限.1");
        str2 = localAVActivity.getString(2131697844);
        str1 = localAVActivity.getString(2131697845);
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().ti())
        {
          this.RG = "0X800488F";
          this.RH = "0X8004890";
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1)
          {
            this.RG = "0X8004895";
            this.RH = "0X8004896";
          }
        }
        for (;;)
        {
          this.Yh = true;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)
          {
            this.RG = "0X8004889";
            this.RH = "0X800488A";
          }
          else if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1)
          {
            this.RG = "0X8004885";
            this.RH = "0X8004886";
          }
        }
      }
      if ((paramInt == 4) && (localAVActivity != null))
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.ss()) {
          iwu.b(this.mApp, 3004);
        }
        str1 = "";
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().ti())
        {
          str1 = "0X8004891";
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1) {
            str1 = "0X8004897";
          }
        }
        for (;;)
        {
          anot.a(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.deviceName, "");
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {
            str1 = "0X800488B";
          } else if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1) {
            str1 = "0X8004887";
          }
        }
      }
    } while (paramInt != 2048);
    this.jdField_a_of_type_ComTencentAvVideoController.b().Qd = true;
    return;
    a(paramLong, paramInt, str2, str1, true);
    return;
    label753:
    j(paramLong, str2, str1);
  }
  
  public void refreshUI() {}
  
  void s(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mToast != null)
    {
      int i = Build.VERSION.SDK_INT;
      if ((i != 14) && (i != 15)) {
        this.mToast.cancel();
      }
    }
    this.mToast = null;
    Context localContext = (Context)this.mContext.get();
    if (localContext != null)
    {
      if (paramInt3 == 0) {}
      try
      {
        this.mToast = QQToast.a(localContext, paramInt1, paramInt2).show();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.TAG, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.mToast = QQToast.a(localContext, paramInt1, paramInt2).show(paramInt3);
      return;
    }
  }
  
  public abstract void s(long paramLong, boolean paramBoolean);
  
  public void u(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void w(boolean paramBoolean, int paramInt) {}
  
  public boolean wH()
  {
    return (this.er != null) && (this.er.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.getVisibility() == 0);
  }
  
  protected boolean wI()
  {
    boolean bool = false;
    if (this.mApp != null) {
      bool = jik.a(this.mApp).wI();
    }
    return bool;
  }
  
  protected abstract boolean wd();
  
  public boolean wm()
  {
    return true;
  }
  
  protected void y(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {}
    int i;
    int j;
    float f;
    do
    {
      return;
      i = jll.getScreenHeight(localAVActivity);
      j = jll.getScreenWidth(localAVActivity);
      f = jll.e(localAVActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.TAG, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + mi() + "], topBarHeight[" + A(paramLong) + "], density[" + f + "], screenSize[" + j + ", " + i + "], hasSmartBar[" + hasSmartBar() + "]");
  }
  
  void z(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "setConnectInfo, str[" + paramString + "], seq[" + paramLong + "]");
    }
    if (this.mZ != null)
    {
      this.mZ.setText(paramString);
      jll.b(this.mZ, paramString);
    }
    if (this.na != null) {
      this.na.setText(paramString);
    }
    if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.kp(paramString);
    }
  }
  
  class ShowSharpInfoRunnable
    implements Runnable
  {
    ShowSharpInfoRunnable() {}
    
    public void run()
    {
      if ((VideoControlUI.this.a == null) || (VideoControlUI.this.nb == null) || (VideoControlUI.this.mApp == null)) {
        return;
      }
      Object localObject1 = VideoControlUI.this.a.b();
      if (VideoLayerUIBase.b((iiv)localObject1)) {}
      for (Object localObject2 = ((iiv)localObject1).MN;; localObject2 = VideoControlUI.this.a.gG())
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        localObject2 = localObject1;
        if (AudioHelper.cTR)
        {
          AVActivity localAVActivity = VideoControlUI.this.a();
          localObject2 = localObject1;
          if (localAVActivity != null)
          {
            localObject2 = localObject1;
            if (localAVActivity.b != null)
            {
              localObject2 = localAVActivity.b.hl();
              localObject2 = (String)localObject1 + "\r\n" + (String)localObject2;
            }
          }
        }
        localObject1 = localObject2;
        try
        {
          localObject2 = (String)localObject2 + "\r\n";
          localObject1 = localObject2;
          localObject2 = (String)localObject2 + jle.a(VideoControlUI.this.a.getAppContext()).hx();
          localObject1 = localObject2;
          localObject2 = (String)localObject2 + "\r\n";
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          label208:
          break label208;
        }
        VideoControlUI.this.nb.setText((CharSequence)localObject1);
        QLog.w(VideoControlUI.this.TAG, 1, "ShowSharpInfo\n" + (String)localObject1);
        VideoControlUI.this.mApp.getHandler().postDelayed(this, 1000L);
        return;
      }
    }
  }
  
  class TimmerRunnable
    implements Runnable
  {
    TimmerRunnable() {}
    
    public void run()
    {
      if ((VideoControlUI.this.a != null) && (VideoControlUI.this.VB))
      {
        String str = jll.formatTime(VideoControlUI.this.a.bt());
        VideoControlUI localVideoControlUI = VideoControlUI.this;
        localVideoControlUI.axv += 1;
        str = VideoControlUI.this.dz(str);
        VideoControlUI.this.ki(str);
        VideoControlUI.this.mApp.getHandler().postDelayed(this, 1000L);
      }
    }
  }
  
  class ToolbarAnimationRunnable
    implements Runnable
  {
    ToolbarAnimationRunnable() {}
    
    public void run()
    {
      VideoControlUI.this.mApp.l(new Object[] { Integer.valueOf(102) });
      if (!VideoControlUI.this.Yg) {
        return;
      }
      VideoControlUI localVideoControlUI;
      if (VideoControlUI.this.Ya) {
        localVideoControlUI = VideoControlUI.this;
      }
      for (localVideoControlUI.axF += 1;; localVideoControlUI.axF -= 1)
      {
        if (VideoControlUI.this.axF > 5) {
          VideoControlUI.this.axF = 5;
        }
        if (VideoControlUI.this.axF < 0) {
          VideoControlUI.this.axF = 0;
        }
        VideoControlUI.this.mApp.getHandler().postDelayed(this, VideoControlUI.a(VideoControlUI.this));
        return;
        localVideoControlUI = VideoControlUI.this;
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (VideoControlUI.this.a == null)) {
        return;
      }
      long l = jlc.a(paramIntent);
      paramContext = paramIntent.getStringExtra("camera_id");
      int i = paramIntent.getIntExtra("availability", 1);
      QLog.w(VideoControlUI.this.TAG, 1, "CameraAvailabilityReceiver, cameraId[" + paramContext + "], availability[" + i + "], mCameraAvailable[" + VideoControlUI.this.a.b().anu + "], seq[" + l + "]");
      VideoControlUI.this.mApp.X(paramContext, i);
      if (i == 0)
      {
        VideoControlUI.a(VideoControlUI.this, l, i);
        return;
      }
      paramContext = VideoControlUI.this.mApp.u();
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.entrySet().iterator();
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
        } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
      }
      for (i = 0;; i = -1)
      {
        VideoControlUI.a(VideoControlUI.this, l, i);
        return;
      }
    }
  }
  
  public class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      String str = (String)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 256: 
        iwu.a(VideoControlUI.this.mApp, 1037, str);
        return;
      }
      iwu.a(VideoControlUI.this.mApp, 1036, str);
    }
  }
  
  static class c
    implements View.OnTouchListener
  {
    WeakReference<VideoControlUI> mWeakReference;
    
    c(VideoControlUI paramVideoControlUI)
    {
      this.mWeakReference = new WeakReference(paramVideoControlUI);
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      paramView = (VideoControlUI)this.mWeakReference.get();
      if (paramView != null) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      for (;;)
      {
        return false;
        paramView.dE(0L);
      }
    }
  }
  
  public static class d
  {
    View in;
    View io;
    
    public d(View paramView)
    {
      this.in = paramView.findViewById(2131374227);
      this.io = paramView.getRootView().findViewById(2131374228);
    }
    
    static void z(View paramView, int paramInt)
    {
      if (paramView == null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
    }
    
    public void e(BaseActivity paramBaseActivity)
    {
      if ((paramBaseActivity == null) || (this.in == null)) {}
      do
      {
        do
        {
          do
          {
            return;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
              break;
            }
            this.in.setVisibility(8);
          } while (this.io == null);
          this.io.setVisibility(8);
          return;
          int i = ImmersiveUtils.getStatusBarHeight(paramBaseActivity);
          QLog.w("QavStatusBar", 1, "adjust, height[" + i + "]");
          if (i > 0)
          {
            z(this.in, i);
            z(this.io, i);
          }
        } while (AudioHelper.jY(0) != 1);
        this.in.setBackgroundColor(2140405971);
      } while (this.io == null);
      this.io.setBackgroundColor(2140405971);
    }
    
    void kx(boolean paramBoolean)
    {
      if (this.in != null)
      {
        QLog.w("QavStatusBar", 1, "setBackgroundColor, bDoubleScreen[" + paramBoolean + "]");
        if (paramBoolean) {
          this.in.setBackgroundColor(-16777216);
        }
      }
      else
      {
        return;
      }
      this.in.setBackgroundColor(0);
    }
    
    public boolean wK()
    {
      return (this.in != null) && (this.in.getVisibility() == 0);
    }
  }
  
  class e
    extends iya
  {
    e() {}
    
    public void cT(long paramLong)
    {
      if (VideoControlUI.this.isDestroyed()) {}
      while ((!VideoControlUI.this.wH()) || (!VideoControlUI.this.a.cC(0))) {
        return;
      }
      VideoControlUI.this.a.c(paramLong, 0, true);
    }
    
    public void f(long paramLong, boolean paramBoolean, int paramInt)
    {
      if (VideoControlUI.this.isDestroyed()) {}
      do
      {
        return;
        if (VideoControlUI.this.wH()) {
          break;
        }
      } while (!paramBoolean);
      VideoControlUI.this.c.update(null, new Object[] { Integer.valueOf(110), Long.valueOf(paramLong) });
      VideoControlUI.this.a.L(paramLong, paramInt);
    }
  }
  
  class f
    implements Animation.AnimationListener
  {
    int axK = 0;
    
    f(int paramInt)
    {
      this.axK = paramInt;
    }
    
    @TargetApi(11)
    public void onAnimationEnd(Animation paramAnimation)
    {
      long l = AudioHelper.hG();
      VideoControlUI.this.mApp.getHandler().removeCallbacks(VideoControlUI.this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      if ((VideoControlUI.this.mApp != null) && (paramAnimation != null) && (2 == this.axK)) {
        VideoControlUI.this.mApp.l(new Object[] { Integer.valueOf(118), Boolean.valueOf(VideoControlUI.this.Ya), Boolean.valueOf(false), Long.valueOf(paramAnimation.getDuration()) });
      }
      QLog.w(VideoControlUI.this.TAG, 1, "onAnimationEnd, mToolBarType[" + this.axK + "], animation[" + paramAnimation + "], mToolbarDisplay[" + VideoControlUI.this.Ya + "], seq[" + l + "]");
      if (!VideoControlUI.this.Ya)
      {
        if (VideoControlUI.this.er != null) {
          VideoControlUI.this.er.setVisibility(4);
        }
        if (VideoControlUI.this.es != null) {
          VideoControlUI.this.es.setVisibility(0);
        }
        if (VideoControlUI.this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          VideoControlUI.this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(4);
        }
        if (Build.VERSION.SDK_INT >= 19) {
          VideoControlUI.this.mRootView.setBackgroundColor(0);
        }
        iwu.b(VideoControlUI.this.mApp, true);
        VideoControlUI.this.axF = 0;
        if (VideoControlUI.this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramAnimation = VideoControlUI.this.jdField_a_of_type_ComTencentAvVideoController.b();
          if (((paramAnimation.relationType == 2) || (paramAnimation.relationType == 1)) && (!VideoControlUI.this.jdField_a_of_type_ComTencentAvVideoController.b().tj())) {
            VideoControlUI.this.c(l, 360 - VideoControlUI.this.axA);
          }
        }
      }
      for (;;)
      {
        VideoControlUI.this.Yg = false;
        VideoControlUI.this.mApp.l(new Object[] { Integer.valueOf(102) });
        return;
        if (VideoControlUI.this.er != null) {
          VideoControlUI.this.er.setVisibility(0);
        }
        if (VideoControlUI.this.es != null) {
          VideoControlUI.this.es.setVisibility(8);
        }
        if (VideoControlUI.this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          VideoControlUI.this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
          VideoControlUI.this.jdField_a_of_type_ComTencentAvUiQavPanel.setAlpha(1.0F);
        }
        if (VideoControlUI.this.il != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(VideoControlUI.this.TAG, 2, "onAnimationEnd, change member list ui to visible");
          }
          VideoControlUI.this.il.setVisibility(0);
        }
        VideoControlUI.a(VideoControlUI.this, true);
        VideoControlUI.this.axF = 5;
        if (VideoControlUI.this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramAnimation = VideoControlUI.this.jdField_a_of_type_ComTencentAvVideoController.b();
          if ((paramAnimation.relationType == 2) || (paramAnimation.relationType == 1)) {
            VideoControlUI.this.c(l, 0.0F);
          }
        }
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      VideoControlUI.this.Yg = true;
      if ((VideoControlUI.this.mApp != null) && (paramAnimation != null) && (2 == this.axK)) {
        VideoControlUI.this.mApp.l(new Object[] { Integer.valueOf(118), Boolean.valueOf(VideoControlUI.this.Ya), Boolean.valueOf(true), Long.valueOf(paramAnimation.getDuration()) });
      }
      QLog.w(VideoControlUI.this.TAG, 1, "[" + this.axK + "]onAnimationStart[" + paramAnimation + "]");
      VideoControlUI.a(VideoControlUI.this, (int)(VideoControlUI.this.L.getDuration() / 5L));
      if (VideoControlUI.this.Ya) {
        VideoControlUI.this.axF = 0;
      }
      for (;;)
      {
        VideoControlUI.this.mApp.getHandler().post(VideoControlUI.this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
        return;
        VideoControlUI.this.axF = 5;
        VideoControlUI.a(VideoControlUI.this, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */