package com.tencent.av.ui;

import acfp;
import aeee;
import ahbj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import anon;
import anot;
import aqhs;
import aqmj;
import aqwu;
import aqxa;
import arlc;
import ausj;
import ayxa;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoConstants.a;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.SDKConfigInfo;
import com.tencent.av.core.VcControllerImpl.b;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import igd;
import igs;
import igv;
import iid;
import iiv;
import iiv.a;
import iiz;
import iju;
import iju.a;
import ijv;
import ijw;
import ikg;
import ikl.a;
import ikp;
import ikr;
import ikt;
import ild;
import ilg.a;
import ili.a;
import ill;
import ilu;
import imc;
import imm;
import imp;
import imr;
import ioa;
import iop;
import iow;
import irk;
import irk.a;
import iti;
import itm;
import ivm;
import ivv;
import iwu;
import ixb;
import ixc;
import ixe;
import ixf;
import ixg;
import ixh;
import ixi;
import ixj;
import ixk;
import ixl;
import ixm;
import ixn;
import ixr;
import ixx;
import ixy;
import iya;
import iya.d;
import iya.e;
import izq;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import jci;
import jdh;
import jds;
import jfo;
import jfq;
import jgg;
import jgj;
import jgx;
import jht;
import jik;
import jjb;
import jjc;
import jji;
import jjk;
import jkn;
import jkn.a;
import jko;
import jll;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import wja;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, ili.a, irk.a
{
  String OD = null;
  String OE = null;
  boolean Ox = false;
  String QS = null;
  String QT = null;
  String QU = null;
  String QV = null;
  String QW = null;
  String QX = null;
  public final String TAG = "AVActivity_" + AudioHelper.hG();
  boolean Ta = false;
  boolean Td = false;
  public boolean VD = false;
  boolean VE = false;
  boolean VL = true;
  boolean VM = false;
  boolean VN = false;
  boolean VO = false;
  public boolean VP;
  private boolean VQ;
  boolean VR = true;
  private boolean VS;
  boolean VT = false;
  boolean VU = false;
  BroadcastReceiver X = null;
  aqxa jdField_a_of_type_Aqxa = new ixc(this);
  public VideoController a;
  private AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
  d jdField_a_of_type_ComTencentAvUiAVActivity$d = null;
  public EffectFilterPanel a;
  QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  public GuideHelper a;
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView;
  iiz jdField_a_of_type_Iiz = new c();
  ill jdField_a_of_type_Ill = new ixj(this);
  private imc jdField_a_of_type_Imc = new imc();
  ixx jdField_a_of_type_Ixx;
  private ixy jdField_a_of_type_Ixy;
  public jci a;
  public jdh a;
  public jds a;
  jfo jdField_a_of_type_Jfo = null;
  public jgg a;
  private jkn.a jdField_a_of_type_Jkn$a;
  jko jdField_a_of_type_Jko = null;
  int auG = -1;
  public int auI = 0;
  int avm = 0;
  public CameraUtils b;
  public VideoLayerUI b;
  iid jdField_b_of_type_Iid = new ixk(this);
  private ivm jdField_b_of_type_Ivm;
  public iya b;
  Runnable bH = null;
  Runnable bI = new AVActivity.3(this);
  View.OnClickListener bY = null;
  byte[] bc = null;
  Bitmap bs = null;
  Bitmap bt = null;
  private MessageQueue.IdleHandler jdField_c_of_type_AndroidOsMessageQueue$IdleHandler = new ixb(this);
  private URLDrawable jdField_c_of_type_ComTencentImageURLDrawable;
  public RedTouch c;
  RelativeLayout dX;
  Dialog l = null;
  WeakReference<Activity> mActivity = new WeakReference(this);
  public VideoAppInterface mApp = null;
  String mBindId = null;
  int mBindType = 0;
  public VideoControlUI mControlUI;
  int mExtraType = 0;
  Handler mHandler = new ixh(this);
  public String mName = null;
  public String mPeerUin = null;
  private Sensor mSensor;
  private SensorManager mSensorManager;
  String mSessionId = null;
  int mSessionType = 0;
  public int mUinType = -1;
  int mVipType = 0;
  long op = 0L;
  long oq = 0L;
  
  public AVActivity()
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_b_of_type_Iya = new b();
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.mIsShadow = false;
  }
  
  private void arF()
  {
    if (this.bt == null) {
      this.bt = jll.b(getApplicationContext(), 2130842802);
    }
  }
  
  private void arG()
  {
    View localView = findViewById(2131374249);
    if ((localView != null) && (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.9(this, localView));
    }
  }
  
  private void arN()
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {}
    do
    {
      return;
      View localView = super.findViewById(2131363166);
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.mApp, this, localView);
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.setAnimationTrigger(a());
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.m(new ixi(this));
    } while (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI == null);
    this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Jdh);
  }
  
  private String c(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("uinType", -1);
    int k = jll.cL(j);
    int i = k;
    if (k == 0) {
      i = 3;
    }
    String str1;
    if (j == 1006)
    {
      str1 = paramIntent.getStringExtra("toMobile");
      if (!paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
        break label285;
      }
      str1 = paramIntent.getStringExtra("GroupId");
      j = 0;
      i = 100;
    }
    label285:
    for (;;)
    {
      String str3 = paramIntent.getStringExtra("Fromwhere");
      k = i;
      String str2 = str1;
      if (i == 3)
      {
        k = i;
        str2 = str1;
        if (TextUtils.equals("AIOShareScreen", str3))
        {
          str2 = paramIntent.getStringExtra("uin");
          k = 100;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "genSessionIdFromIntent, [" + j + "," + k + "," + str2 + "]");
      }
      if ((j == -1) || (TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "genSessionIdFromIntent error: uinType " + j + ", relationId " + str2);
        }
        return null;
        if ((i == 1) || (i == 2))
        {
          str1 = paramIntent.getStringExtra("GroupId");
          break;
        }
        str1 = paramIntent.getStringExtra("uin");
        break;
      }
      return igv.a(k, str2, new int[0]);
    }
  }
  
  public static boolean c(Window paramWindow, boolean paramBoolean)
  {
    boolean bool = false;
    int i = ImmersiveUtils.isSupporImmersive();
    if (i == 1) {
      if (paramBoolean)
      {
        int j = paramWindow.getDecorView().getSystemUiVisibility();
        paramWindow.getDecorView().setSystemUiVisibility(j | 0x100 | 0x400);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramWindow.addFlags(-2147483648);
          paramWindow.clearFlags(67108864);
          paramWindow.setStatusBarColor(0);
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(ImmersiveUtils.TAG, 1, "setImmersive, result[" + paramBoolean + "], isSupporImmersive[" + i + "], SystemUiVisibility[0x" + Integer.toHexString(paramWindow.getDecorView().getSystemUiVisibility()) + "], flags[0x" + Integer.toHexString(paramWindow.getAttributes().flags) + "]");
      }
      return paramBoolean;
      if (Build.VERSION.SDK_INT < 19) {
        break;
      }
      paramWindow.addFlags(67108864);
      break;
      paramWindow.clearFlags(67108864);
      break;
      paramBoolean = bool;
      if (AudioHelper.jY(25) == 1)
      {
        AudioHelper.UA("使用了index_disable_immersive");
        paramBoolean = bool;
      }
    }
  }
  
  private void cI(long paramLong)
  {
    if (isDestroyed()) {}
    label7:
    do
    {
      do
      {
        iiv localiiv;
        do
        {
          int i;
          do
          {
            do
            {
              break label7;
              break label7;
              break label7;
              do
              {
                return;
              } while ((this.mControlUI == null) || (this.mControlUI.isDestroyed()));
              localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
              i = localiiv.amI;
              if (QLog.isDevelopLevel()) {
                QLog.w(this.TAG, 1, "SwitchToolbar, sessionType[" + i + "], isInviting[" + localiiv.ta() + "], isToolBarDisplay[" + this.mControlUI.wH() + "|" + this.mControlUI.Ya + "], seq[" + paramLong + "]");
              }
              if ((i != 1) && (i != 3)) {
                break;
              }
            } while ((!this.mControlUI.a.cC(1)) && (!this.mControlUI.a.cC(3)));
            this.mControlUI.a.c(paramLong, 0, true);
            return;
            if (!localiiv.ta()) {
              break;
            }
          } while ((i != 2) || ((!this.mControlUI.a.cC(1)) && (!this.mControlUI.a.cC(3))));
          this.mControlUI.a.c(paramLong, 0, true);
          return;
        } while ((this.jdField_a_of_type_Ixx != null) && (this.jdField_a_of_type_Ixx.isShown()));
        if ((!localiiv.isRecording) || (this.mControlUI.wH())) {
          break;
        }
      } while (this.mApp == null);
      iwu.b(this.mApp, 1022, 2131697970);
      return;
      if (!vU())
      {
        if ((!this.mControlUI.wH()) && ((this.mControlUI.a.cC(1)) || (this.mControlUI.a.cC(3)))) {
          this.mControlUI.a.c(paramLong, 0, false);
        }
        e(paramLong, "SwitchToolbar", this.mControlUI.wH());
        this.mControlUI.mj(0);
        return;
      }
    } while (this.mControlUI.wH());
    e(paramLong, "SwitchToolbar2", this.mControlUI.wH());
    this.mControlUI.mj(0);
  }
  
  private void cK(long paramLong)
  {
    if (this.VS) {}
    do
    {
      return;
      this.VS = true;
    } while (this.mControlUI == null);
    this.mControlUI.cW(paramLong);
  }
  
  public static void d(Window paramWindow)
  {
    try
    {
      paramWindow.addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramWindow);
      return;
    }
    catch (NoSuchFieldException paramWindow) {}
  }
  
  static boolean enableNotch(Activity paramActivity)
  {
    ayxa.initLiuHaiProperty(paramActivity);
    if (ayxa.isLiuHaiUseValid())
    {
      int i = ayxa.getNotchInScreenHeight(paramActivity);
      int j = ImmersiveUtils.getStatusBarHeight(paramActivity);
      QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + i + "], statusBarHeight[" + j + "]");
      if (ayxa.enableNotch(paramActivity))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, enableNotch");
        }
        return true;
      }
      if (("" + Build.MANUFACTURER).equalsIgnoreCase("Lenovo")) {
        VideoControlUI.Yi = true;
      }
    }
    return false;
  }
  
  private void jP(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (AudioHelper.cTR)) {
      this.jdField_a_of_type_ComTencentAvVideoController.b().MN = paramString;
    }
  }
  
  private boolean l(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  void A(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "avideo onCreateUI, SessionType[" + ((iiv)localObject1).amI + "], seq[" + paramLong + "]");
    jik.a(this.mApp, this);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(getApplicationContext());
    if (localObject2 != null) {
      ((iow)localObject2).setApp(this.mApp);
    }
    if (this.dX == null) {
      this.dX = ((RelativeLayout)super.findViewById(2131373968));
    }
    this.bH = new AVActivity.5(this);
    if (this.jdField_b_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this);
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils.addObserver(this.jdField_a_of_type_Ill);
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    localObject2 = super.findViewById(2131363166).findViewById(2131363163);
    try
    {
      ((View)localObject2).setBackgroundResource(2130842961);
      if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI == null) {
        arN();
      }
      if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.requestLayout();
      }
      jn(false);
      if (this.mSessionType == 0)
      {
        QLog.i(this.TAG, 2, "onCreateUI, SessionType[" + this.mSessionType + "], isDoubleMeeting[" + this.Td + "]");
        if (this.Td) {
          this.mSessionType = 1;
        }
      }
      switch (this.mSessionType)
      {
      default: 
        int j = this.mSessionType;
        int i = j;
        if (this.mSessionType == 3)
        {
          i = j;
          if (getIntent() != null)
          {
            i = j;
            if (getIntent().getBooleanExtra("isVideo", false)) {
              i = 4;
            }
          }
        }
        this.jdField_a_of_type_Jkn$a = jkn.a(i);
        if ((this.jdField_a_of_type_Jkn$a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Jkn$a.url)))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_c_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_Jkn$a.url, (URLDrawable.URLDrawableOptions)localObject2);
          this.VQ = false;
          this.jdField_c_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ixl(this));
          this.jdField_c_of_type_ComTencentImageURLDrawable.startDownload();
          if (1 == this.jdField_c_of_type_ComTencentImageURLDrawable.getStatus())
          {
            paramBoolean = true;
            this.VQ = paramBoolean;
            anot.a(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i, this.jdField_a_of_type_Jkn$a.id, "", "", "", "");
            QLog.i(this.TAG, 1, "MoreBtnTips. getDrawableAndToDownloadImage. mMoreBtnTipsImageDownloaded = " + this.VQ);
          }
        }
        else
        {
          if (this.mControlUI != null)
          {
            this.mControlUI.onCreate();
            if ((this.mUinType == 9500) && ((this.mControlUI instanceof DoubleVideoCtrlUI)))
            {
              localObject2 = (DoubleVideoCtrlUI)this.mControlUI;
              ((DoubleVideoCtrlUI)localObject2).a(2131373950, this.jdField_a_of_type_ComTencentAvVideoController.OR, 2130842860);
              if (!this.jdField_a_of_type_ComTencentAvVideoController.OT) {
                ((DoubleVideoCtrlUI)localObject2).a.c(true, 0, false);
              }
            }
          }
          if ((((iiv)localObject1).state != 4) && (((iiv)localObject1).tn()) && (!this.Ta) && (this.mSessionType == 1) && (this.dX != null) && (this.dX.getParent() != null))
          {
            i = jgj.a(this.mApp, ((iiv)localObject1).peerUin, true, true);
            if ((i > 0) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null)) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = aqwu.a(this, (RelativeLayout)this.dX.getParent(), false);
            }
            j = aqwu.getResourceType();
            localObject1 = aqwu.a(this.mApp, i, j, null);
            if (localObject1 != null)
            {
              localObject2 = new File((String)localObject1);
              if ((localObject2 == null) || (!((File)localObject2).exists())) {
                break label1332;
              }
              if (this.mApp != null) {
                this.mApp.getHandler().postDelayed(new AVActivity.7(this, (String)localObject1, j, i), 1000L);
              }
            }
          }
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131376957));
          d(paramLong, "onCreateUI", false);
          if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.ne(0);
          }
          localObject1 = (RelativeLayout)findViewById(2131381799);
          if ((localObject1 != null) && (jdh.wz()))
          {
            this.jdField_a_of_type_Jdh = new jdh(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.mApp, this.dX, this.mControlUI);
            this.jdField_a_of_type_Jdh.setShowState(1);
            if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
              this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_Jdh);
            }
          }
          arG();
          irk.a().a(this.mApp, this);
          localObject1 = new AVActivity.8(this);
          new Handler().post((Runnable)localObject1);
          return;
        }
        break;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.d(this.TAG, 1, "onCreateUI OutOfMemoryError", localOutOfMemoryError);
        continue;
        if (this.mControlUI == null)
        {
          if (!this.Td) {
            break label1035;
          }
          this.mControlUI = new DoubleVideoMeetingCtrlUI(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
          this.mSessionType = ((iiv)localObject1).amI;
        }
        for (;;)
        {
          this.mControlUI.na(this.jdField_b_of_type_ComTencentAvCameraCameraUtils.getCameraNum());
          break;
          label1035:
          this.mControlUI = new DoubleVideoCtrlUI(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
        }
        if (this.Td)
        {
          this.mControlUI = new DoubleVideoMeetingCtrlUI(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
          this.mSessionType = ((iiv)localObject1).amI;
        }
        else
        {
          this.mControlUI = new DoubleVideoCtrlUI(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
          this.mControlUI.na(this.jdField_b_of_type_ComTencentAvCameraCameraUtils.getCameraNum());
          continue;
          if (this.mControlUI == null)
          {
            if (!this.Td) {
              break label1210;
            }
            this.mControlUI = new DoubleVideoMeetingCtrlUI(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
            this.mSessionType = ((iiv)localObject1).amI;
          }
          for (;;)
          {
            this.mControlUI.na(this.jdField_b_of_type_ComTencentAvCameraCameraUtils.getCameraNum());
            break;
            label1210:
            if (((iiv)localObject1).anb == 1)
            {
              this.mControlUI = new MultiVideoCtrlLayerUI4Discussion(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
            }
            else if (((iiv)localObject1).anb == 10)
            {
              this.mControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.mControlUI = new MultiVideoCtrlLayerUI4Discussion(this.mApp, this, this.dX, this.jdField_b_of_type_Iya);
            }
          }
          paramBoolean = false;
          continue;
          label1332:
          QLog.e(this.TAG, 1, "funcall --> !file.exists() + path:" + (String)localObject1);
        }
      }
    }
  }
  
  void B(long paramLong, int paramInt)
  {
    if (isDestroyed()) {
      break label7;
    }
    label7:
    while ((this.mControlUI == null) || (this.mControlUI.isDestroyed())) {
      return;
    }
    int n = this.mControlUI.A(paramLong);
    int i1 = this.mControlUI.mi();
    Object localObject;
    if (this.mControlUI.wH())
    {
      localObject = findViewById(2131374245);
      if ((localObject == null) || (!(((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        break label516;
      }
    }
    label516:
    for (int i = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin;; i = 0)
    {
      int j = 0;
      int k = 0;
      int i2 = n + k;
      int m;
      label121:
      boolean bool;
      if (this.jdField_a_of_type_Jgg != null)
      {
        m = this.jdField_a_of_type_Jgg.ms();
        QLog.w("ChatRoomUtil", 1, "calcControlUIOffset, topOffset[" + i2 + "], topToolbarHeight[" + n + "], topToolbarTop[" + i + "], bottomToolbarHeight[" + i1 + "], chatRoomInputPanelHeight[" + m + "], recordBarHeight[" + j + "], systemBarHeight[" + k + "], from[" + paramInt + "], seq[" + paramLong + "]");
        if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          if ((lI() != 1) || (m <= i1)) {
            break label447;
          }
          localObject = this.jdField_b_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.mControlUI.Ya)
          {
            bool = true;
            label282:
            ((VideoLayerUI)localObject).e(paramLong, i2, m, bool);
          }
        }
        else
        {
          this.mControlUI.auZ();
          if ((this.jdField_a_of_type_Jgg == null) || (paramInt == 1)) {
            break;
          }
          this.jdField_a_of_type_Jgg.nv(i1);
          return;
          if ((n != 0) || (!ayxa.isLiuHaiUseValid())) {
            break label510;
          }
        }
      }
      label447:
      label510:
      for (i = ayxa.getNotchInScreenHeight(this);; i = 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if ((((iiv)localObject).tn()) && ((((iiv)localObject).isRecording) || (((iiv)localObject).Qp)) && (this.jdField_a_of_type_Jdh != null) && (!this.jdField_a_of_type_Jdh.wx()))
        {
          j = this.jdField_a_of_type_Jdh.mc();
          localObject = this.jdField_b_of_type_ComTencentAvUiVideoLayerUI;
          if (j == 0) {}
          for (k = -1;; k = j)
          {
            ((VideoLayerUI)localObject).axV = k;
            m = 0;
            k = i;
            i = m;
            break;
          }
          bool = false;
          break label282;
          localObject = this.jdField_b_of_type_ComTencentAvUiVideoLayerUI;
          if (!this.mControlUI.Ya) {}
          for (bool = true;; bool = false)
          {
            ((VideoLayerUI)localObject).e(paramLong, i2, i1, bool);
            break;
          }
          m = 0;
          break label121;
        }
        j = 0;
        m = 0;
        k = i;
        i = m;
        break;
      }
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.hG();
    QLog.d(this.TAG, 1, "BtnOnClick, id[" + izq.aT(paramView.getId()) + "], nfonWindowFocus[" + this.VR + "], seq[" + l1 + "]");
    if (!this.VR) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Ixx != null) && (this.jdField_a_of_type_Ixx.isShown())) {
        this.jdField_a_of_type_Ixx.bK(paramView);
      }
      while ((paramView.getId() == 2131374249) && (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        iti.a(this.mApp, this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch, 1);
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        return;
        if (this.mControlUI != null)
        {
          this.mControlUI.dE(l1);
          jjk.onClick(paramView.getId());
          this.mControlUI.a(l1, paramView);
          cN(l1);
        }
      }
    }
  }
  
  void F(long paramLong1, long paramLong2) {}
  
  public void G(int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    while ((this.mControlUI == null) || (this.mControlUI.isDestroyed()) || (paramInt == this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.lI())) {
      return;
    }
    long l1 = AudioHelper.hG();
    this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.lS(paramInt);
    if (((this.mControlUI instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
    {
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.dX(l1);
      ((DoubleVideoCtrlUI)this.mControlUI).J(this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX(), vW());
    }
    this.mControlUI.dE(l1);
    this.mControlUI.O(l1, 65535);
    if (this.jdField_a_of_type_Jdh != null)
    {
      this.jdField_a_of_type_Jdh.a(this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX(), this.mControlUI, this.jdField_a_of_type_Jdh.ww());
      this.jdField_a_of_type_Jdh.kf(this.jdField_a_of_type_Jdh.ww());
      this.jdField_a_of_type_Jdh.kg(this.jdField_a_of_type_Jdh.ww());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qv)) {
      jgx.kw("0X8008ABA");
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.b().PT;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.N(this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX(), paramBoolean);
    }
    this.mControlUI.mp(paramInt);
  }
  
  public void S(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "updateDoubleMeeting, from[" + paramString + "], [" + this.Td + "-->" + paramBoolean);
    }
    if (this.Td != paramBoolean) {
      this.Td = paramBoolean;
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    paramView = new PopupMenu(this, paramView);
    jik.a(this.mApp).a(paramView);
    if (AudioHelper.isDev()) {}
    try
    {
      PstnCardTestActivity.addMenuInVideoView(this.mApp, paramView);
      label35:
      paramView.show();
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public AnimationTrigger a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = new AnimationTrigger(this.mApp);
    }
    return this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
  }
  
  public ivm a()
  {
    return this.jdField_b_of_type_Ivm;
  }
  
  @TargetApi(21)
  @Nullable
  public jds a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    this.jdField_a_of_type_Jds = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_Jds.bw(this);
    return this.jdField_a_of_type_Jds;
  }
  
  void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return;
      } while ((this.mControlUI == null) || (this.mControlUI.isDestroyed()));
      this.mControlUI.E(paramLong, paramInt);
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.F(paramInt, false);
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils.setRotation(paramInt);
      this.auI = paramInt;
      if (this.jdField_a_of_type_Jdh != null)
      {
        this.jdField_a_of_type_Jdh.mS(paramInt);
        this.jdField_a_of_type_Jdh.aus();
        this.jdField_a_of_type_Jdh.a(this.mControlUI, this.auI);
      }
    } while ((!this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qp));
    cP(paramLong);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Intent localIntent = wja.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    QLog.w(this.TAG, 1, "enterChatWin, uin[" + paramString1 + "], type[" + paramInt + "], seq[" + paramLong + "]");
    this.Ox = false;
    finish();
    paramInt = 2130772209;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (paramString1 != null) {
      paramInt = ivv.cu(paramString1.anh);
    }
    overridePendingTransition(0, paramInt);
  }
  
  void arH()
  {
    if ((this.mSensorManager == null) && (this.mSensor == null))
    {
      this.mSensorManager = ((SensorManager)getSystemService("sensor"));
      this.mSensor = this.mSensorManager.getDefaultSensor(1);
    }
  }
  
  void arI()
  {
    if ((this.mSensorManager != null) && (this.mSensor != null)) {
      this.mSensorManager.registerListener(this, this.mSensor, 2);
    }
  }
  
  void arJ()
  {
    if ((this.mSensorManager != null) && (this.mSensor != null)) {
      this.mSensorManager.unregisterListener(this);
    }
  }
  
  void arK()
  {
    int i = -1;
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131363166);
    float f1 = getResources().getDimension(2131298123);
    float f2 = getResources().getDimension(2131298126);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.mApp);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131374269);
    if (localObject != null) {
      i = localViewGroup.indexOfChild((View)localObject);
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel, i);
  }
  
  void arL()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131363166);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = null;
    }
  }
  
  public void arM()
  {
    if ((!this.VT) || ((this.l != null) && (this.l.isShowing()))) {}
    try
    {
      this.l.dismiss();
      label31:
      this.VT = false;
      this.l = null;
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  @TargetApi(21)
  public void arO() {}
  
  void arm()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$d == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$d = new d(super.getApplicationContext(), 2);
    }
  }
  
  void arn()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$d != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$d.enable();
    }
  }
  
  void aro()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$d != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$d.disable();
    }
  }
  
  View b(long paramLong)
  {
    if ((this.jdField_a_of_type_Jkn$a == null) || (!this.VQ))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "qav_UserGuide_for_more.init, 没有tips需要显示或者已经显示过, seq[" + paramLong + "]");
      }
      return null;
    }
    if (!this.mControlUI.wH())
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "qav_UserGuide_for_more.init, 工具栏没显示, seq[" + paramLong + "]");
      }
      return null;
    }
    Object localObject = findViewById(2131374249);
    if (localObject == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "qav_UserGuide_for_more.init, !MORE, seq[" + paramLong + "]");
      }
      return null;
    }
    if (((View)localObject).getVisibility() != 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "qav_UserGuide_for_more.init, more按钮没显示出来, seq[" + paramLong + "]");
      }
      return null;
    }
    ImageView localImageView = (ImageView)findViewById(2131374120);
    if (localImageView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "qav_UserGuide_for_more.init, !qav_more_tips, seq[" + paramLong + "]");
      }
      return null;
    }
    if (localImageView.getVisibility() == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "qav_UserGuide_for_more.init, qav_more_tips已经在显示中了, seq[" + paramLong + "]");
      }
      return null;
    }
    QLog.i(this.TAG, 1, "MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = " + this.VQ + ", mMoreBtnTips = " + this.jdField_a_of_type_Jkn$a);
    localImageView.setImageDrawable(this.jdField_c_of_type_ComTencentImageURLDrawable);
    int i = wja.dp2px(10.0F, getResources());
    int j = (int)(25 * getResources().getDisplayMetrics().density / 1.5D);
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationInWindow(arrayOfInt);
    int k = ((View)localObject).getWidth();
    int m = ((View)localObject).getHeight();
    int n = arrayOfInt[0];
    n = k / 2 + n;
    int i1 = arrayOfInt[1] + m + i;
    int i2 = (int)(this.jdField_c_of_type_ComTencentImageURLDrawable.getIntrinsicWidth() / 1.5D);
    int i3 = (int)(this.jdField_c_of_type_ComTencentImageURLDrawable.getIntrinsicHeight() / 1.5D);
    int i4 = n - i2 + j;
    localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i4;
    ((RelativeLayout.LayoutParams)localObject).width = i2;
    ((RelativeLayout.LayoutParams)localObject).height = i3;
    QLog.w(this.TAG, 1, "MoreBtnTips. offset[" + i + "], left_more[" + arrayOfInt[0] + "], top_more[" + arrayOfInt[1] + "], width_more[" + k + "], height_more[" + m + "], width_tips[" + i2 + "], height_tips[" + i3 + "], arrow[" + j + "], dockLeft[" + n + "], dockTop[" + i1 + "], tipsTop[" + i1 + "], tipsLeft[" + i4 + "], seq[" + paramLong + "]");
    return localImageView;
  }
  
  public VideoController b()
  {
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 2131374249) && (paramInt3 == 0))
    {
      F(paramLong, 2000L);
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this, 1, 0);
    }
  }
  
  public void cH(long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentAvCameraCameraUtils == null) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        if (!this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ar(paramLong)) {
          this.jdField_a_of_type_ComTencentAvVideoController.b().n(paramLong, false);
        }
      }
      if (this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null) {
        this.jdField_b_of_type_ComTencentAvCameraCameraUtils.f(paramLong, true);
      }
      if (!this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ar(paramLong))
      {
        QLog.w(this.TAG, 1, "requestCloseCamera, 摄像头本来没打开, seq[" + paramLong + "]");
        if (this.mControlUI != null) {
          this.mControlUI.s(paramLong, true);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().ti()) {}
      while (this.jdField_a_of_type_Jgg != null)
      {
        this.jdField_a_of_type_Jgg.awa();
        return;
        G(1, false);
      }
    }
  }
  
  void cJ(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      aro();
      if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if ((this.jdField_b_of_type_Ivm == null) || (this.jdField_b_of_type_Ivm.vA()))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
          {
            ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if;
            int i = 0;
            if (i < localArrayList.size())
            {
              ioa localioa = (ioa)localArrayList.get(i);
              String str = jji.al(localioa.uin);
              int j = localioa.videoSrcType;
              if ((localioa.mk == 5L) || (localioa.mk == 14L)) {}
              for (boolean bool = true;; bool = false)
              {
                if (!str.equals(this.mApp.getCurrentAccountUin())) {
                  this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, j, false, false, bool);
                }
                i += 1;
                break;
              }
            }
          }
          this.jdField_b_of_type_ComTencentAvCameraCameraUtils.f(paramLong, false);
          this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.onPause();
      }
      if (this.mControlUI != null) {
        this.mControlUI.de(paramLong);
      }
      if (this.jdField_a_of_type_Ixx != null) {
        this.jdField_a_of_type_Ixx.onPause();
      }
      arJ();
      this.jdField_a_of_type_ComTencentAvVideoController.d(true);
      this.jdField_a_of_type_ComTencentAvVideoController.hJ(false);
      if (this.jdField_b_of_type_Ivm != null) {
        this.jdField_b_of_type_Ivm.x(paramLong, this.Ox);
      }
    } while (this.jdField_a_of_type_Jgg == null);
    this.jdField_a_of_type_Jgg.awa();
  }
  
  void cL(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + "|VideoNodeManager", 2, "processExtraData, seq[" + paramLong + "]");
    }
    Object localObject3 = super.getIntent();
    if (localObject3 == null)
    {
      QLog.d(this.TAG, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.I("AVActivity.processExtraData", ((Intent)localObject3).getExtras());
    int m = ((Intent)localObject3).getIntExtra("sessionType", 0);
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int j = localiiv.amI;
    Object localObject1 = ((Intent)localObject3).getStringExtra("Fromwhere");
    boolean bool = ((Intent)localObject3).getBooleanExtra("isDoubleVideoMeeting", false);
    S("processExtraData", bool);
    if ("AVNotification".equals(localObject1))
    {
      if (((localiiv.state == 2) || (localiiv.state == 13)) && (m != 1) && (m != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (localiiv.Qw) {
          break label390;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localiiv.peerUin, 1, true);
        this.jdField_a_of_type_ComTencentAvVideoController.O(localiiv.peerUin, 230);
        this.jdField_a_of_type_ComTencentAvVideoController.ko(230);
      }
      if (localiiv.uinType == 1)
      {
        if (localiiv.anb != 10) {
          break label428;
        }
        anot.a(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
      }
    }
    label390:
    long l1;
    for (;;)
    {
      if (bool) {
        anot.a(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
      if (m != 0) {
        break label464;
      }
      igd.aK(this.TAG, "processExtraData-->can not get session type in intent.");
      ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1015L);
      finish();
      return;
      l1 = Long.valueOf(localiiv.peerUin).longValue();
      this.jdField_a_of_type_ComTencentAvVideoController.c(paramLong, 3, l1);
      this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, l1, 1);
      break;
      label428:
      anot.a(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
    }
    label464:
    String str = null;
    if ((m == 1) || (m == 2))
    {
      str = ((Intent)localObject3).getStringExtra("uin");
      label489:
      if (!"AVNotification".equals(localObject1)) {
        break label2363;
      }
      if ((m != 1) && (m != 2)) {
        break label639;
      }
      str = localiiv.peerUin;
    }
    label1798:
    label2360:
    label2363:
    for (;;)
    {
      int i;
      int k;
      int n;
      if (str == null)
      {
        igd.aK(this.TAG, "processExtraData-->can not get uin in intent.");
        ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
        finish();
        return;
        if ((m != 3) && (m != 4)) {
          break label489;
        }
        str = ((Intent)localObject3).getStringExtra("GroupId");
        i = ((Intent)localObject3).getIntExtra("MeetingConfID", 0);
        k = ((Intent)localObject3).getIntExtra("ConfAppID", 0);
        n = ((Intent)localObject3).getIntExtra("MeetingStasks", -1);
        localiiv.anj = i;
        localiiv.ank = k;
        localiiv.anl = n;
        break label489;
        label639:
        if ((m != 3) && (m != 4)) {
          break label2363;
        }
        if (bool)
        {
          str = localiiv.peerUin;
          continue;
        }
        str = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.kJ);
        continue;
      }
      Object localObject2;
      if ((j == 1) || (j == 2))
      {
        localObject2 = localiiv.peerUin;
        i = jll.cL(localiiv.uinType);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          igd.aK(this.TAG, "can not get the original peeruin");
          ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
          finish();
        }
      }
      else if ((j == 3) || (j == 4))
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.kJ);
        i = this.jdField_a_of_type_ComTencentAvVideoController.alr;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          igd.aK(this.TAG, "can not get the original group uin");
          ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
          finish();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "original session type is none");
        }
        i = 0;
        localObject1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "processExtraData-->IntentSessionType=" + m + ", OriginalSessionType=" + j + ", IntentUin=" + str);
      }
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d(this.TAG, 2, "processExtraData-->OriginalUin=" + (String)localObject1 + ", originalRelationType=" + i);
      }
      if ((j == 0) && (!this.jdField_a_of_type_ComTencentAvVideoController.sw()))
      {
        cM(paramLong);
        label984:
        QLog.w(this.TAG, 1, "processExtraData, mSessionType[" + this.mSessionType + "], mUinType[" + this.mUinType + "], mPeerUin[" + this.mPeerUin + "], mPeerName[" + this.OE + "], mPhoneNum[" + this.QT + "], mSelfNation[" + this.QU + "], mSelfMobile[" + this.QV + "], mIsReceiver[" + this.Ta + "], mIsAudioMode[" + this.VL + "], mExtraUin[" + this.OD + "], mIsPeerNetworkWell[" + this.VM + "], mIsFriend[" + this.VN + "], mFromWhere[" + this.QW + "], intentUinStr[" + str + "], \nsession[" + localiiv + "]");
        aqhs.printHexString(this.TAG, this.bc);
        return;
      }
      if ((j == 3) || (j == 4) || (this.jdField_a_of_type_ComTencentAvVideoController.sw()))
      {
        if ((j != 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.sw())) {
          break label2360;
        }
        localObject1 = "";
      }
      for (;;)
      {
        if ((m == 1) || (m == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.sw()) {
            this.jdField_a_of_type_ComTencentAvVideoController.hI(true);
          }
          for (;;)
          {
            cM(paramLong);
            str = igv.a(3, this.mPeerUin, new int[0]);
            if (igv.a().ci(str)) {
              break;
            }
            localObject1 = igv.a().a(str, false);
            ((iiv)localObject1).PT = false;
            ((iiv)localObject1).Y("processExtraData", 0);
            ((iiv)localObject1).QS = false;
            if (!str.equals(this.mSessionId)) {
              this.mSessionId = str;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w(this.TAG, 2, "mutivideo to doublevideo bug fix call");
            return;
            this.jdField_a_of_type_ComTencentAvVideoController.b(i, Long.valueOf((String)localObject1).longValue(), 97);
          }
        }
        if ((m != 3) && (m != 4)) {
          break label984;
        }
        l1 = Long.valueOf(str).longValue();
        k = 0;
        n = ((Intent)localObject3).getIntExtra("MultiAVType", 0);
        localiiv.Rf = ((Intent)localObject3).getBooleanExtra("disableInvite", false);
        j = k;
        if (localiiv.anb != 0)
        {
          j = k;
          if (n != localiiv.anb)
          {
            j = k;
            if (n != 0) {
              j = 1;
            }
          }
        }
        localiiv.kD(n);
        if (!bool) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.sw())
          {
            this.jdField_a_of_type_ComTencentAvVideoController.hI(true);
            label1519:
            if (j != 0)
            {
              this.jdField_a_of_type_ComTencentAvVideoController.b(i, this.jdField_a_of_type_ComTencentAvVideoController.kJ, 99);
              localiiv.kD(n);
              localiiv.e(paramLong, "processExtraData.1", 3);
            }
            localiiv.aa("processExtraData.1", ((Intent)localObject3).getIntExtra("Type", -1));
            localiiv.ll = l1;
            this.QS = str;
            if (str.compareTo((String)localObject1) != 0) {
              break label1798;
            }
            if (j == 0) {
              break label1786;
            }
            this.mSessionType = m;
            i = ((Intent)localObject3).getIntExtra("uinType", -1);
            localiiv.uinType = i;
            this.mUinType = i;
            this.OD = localiiv.MP;
            if (localiiv.anc == -1) {
              localiiv.aa("processExtraData.2", 0);
            }
            this.VM = localiiv.Qf;
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "processExtraData multiAVType: " + localiiv.anb);
            }
          }
        }
        for (;;)
        {
          if (j != 0) {
            break label1882;
          }
          this.mUinType = localiiv.uinType;
          this.OD = localiiv.MP;
          this.VM = localiiv.Qf;
          break;
          if ((str.compareTo((String)localObject1) == 0) || (!this.jdField_a_of_type_ComTencentAvVideoController.OB)) {
            break label1519;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b(i, this.jdField_a_of_type_ComTencentAvVideoController.kJ, 98);
          localiiv.kD(n);
          break label1519;
          label1786:
          this.mSessionType = localiiv.amI;
          continue;
          localiiv.e(paramLong, "processExtraData.2", m);
          localiiv.uinType = ((Intent)localObject3).getIntExtra("uinType", -1);
          if ((localiiv.anc == 0) || (localiiv.anc == 1)) {
            localiiv.f = ((Intent)localObject3).getLongArrayExtra("DiscussUinList");
          }
          this.mSessionType = m;
          continue;
          localiiv.peerUin = str;
          this.mSessionType = m;
          this.mPeerUin = str;
        }
        label1882:
        break label984;
        if (((j != 1) && (j != 2)) || ((m != 1) && (m != 2))) {
          break label984;
        }
        i = ((Intent)localObject3).getIntExtra("uinType", -1);
        if ((i != -1) && (i != localiiv.uinType))
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { localiiv.anb });
          this.jdField_a_of_type_ComTencentAvVideoController.ko(203);
          if (this.mControlUI != null)
          {
            this.mControlUI.onDestroy(paramLong);
            this.mControlUI = null;
          }
          localObject1 = localiiv.peerUin;
          localObject2 = igv.a(3, (String)localObject1, new int[0]);
          Object localObject4 = igv.a().c((String)localObject2);
          if (localObject4 == null)
          {
            igd.aK(this.TAG, "Can not get SessionInfo : SessionId = " + (String)localObject2);
            finish();
            return;
          }
          localObject3 = ((iiv)localObject4).MP;
          i = localiiv.uinType;
          localObject4 = ((iiv)localObject4).senderUin;
          this.jdField_a_of_type_ComTencentAvVideoController.O((String)localObject1, 231);
          this.jdField_a_of_type_ComTencentAvVideoController.ko(231);
          this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i, (String)localObject1, (String)localObject3, 0, (String)localObject4, false, true);
          cM(paramLong);
          localObject1 = igv.a(3, this.mPeerUin, new int[0]);
          localObject2 = igv.a().a((String)localObject1, false);
          ((iiv)localObject2).PT = true;
          ((iiv)localObject2).Y("processExtraData", 2);
          ((iiv)localObject2).QS = false;
          if (((String)localObject1).equals(this.mSessionId)) {
            break label984;
          }
          this.mSessionId = ((String)localObject1);
          break label984;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
        }
        this.mSessionType = localiiv.amI;
        S("processExtraData", localiiv.Qw);
        this.mUinType = localiiv.uinType;
        this.mPeerUin = localiiv.peerUin;
        this.OE = localiiv.MO;
        this.QX = localiiv.MT;
        this.mBindType = localiiv.bindType;
        this.mBindId = localiiv.MX;
        this.mExtraType = localiiv.extraType;
        this.OD = localiiv.MP;
        this.QT = localiiv.gK();
        this.Ta = localiiv.PT;
        this.VL = localiiv.QE;
        this.VM = localiiv.Qf;
        this.VN = localiiv.isFriend;
        break label984;
      }
    }
  }
  
  void cM(long paramLong)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.mApp.RA + "], isMsfRecv[" + this.mApp.RB + "], seq[" + paramLong + "], \nSessionInfo[" + localiiv + "]");
    Object localObject1;
    boolean bool1;
    String str1;
    Object localObject2;
    String str2;
    long l1;
    if ((this.mApp.RA) || (this.mApp.RB))
    {
      this.mApp.RA = false;
      this.mApp.RB = false;
      ikp.kQ(26);
      localObject1 = super.getIntent();
      AudioHelper.I(this.TAG + "_processIntentData", ((Intent)localObject1).getExtras());
      this.mSessionType = ((Intent)localObject1).getIntExtra("sessionType", 0);
      this.mUinType = ((Intent)localObject1).getIntExtra("uinType", -1);
      this.mPeerUin = ((Intent)localObject1).getStringExtra("uin");
      this.QX = ((Intent)localObject1).getStringExtra("dstClient");
      bool1 = ((Intent)localObject1).getBooleanExtra("isDoubleVideoMeeting", false);
      boolean bool2 = bool1;
      if ("AIOShareScreen".equals(((Intent)localObject1).getStringExtra("Fromwhere")))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "processIntentData, from share screen. uinType[" + this.mUinType + "]");
        }
        if (this.mUinType == 0) {
          bool1 = true;
        }
        localiiv.any = 4;
        bool2 = bool1;
      }
      S("processIntentData", bool2);
      this.mBindId = ((Intent)localObject1).getStringExtra("bindId");
      this.mBindType = ((Intent)localObject1).getIntExtra("bindType", 0);
      this.avm = ((Intent)localObject1).getIntExtra("subServiceType", 0);
      this.mExtraType = ((Intent)localObject1).getIntExtra("extraType", 0);
      this.OE = ((Intent)localObject1).getStringExtra("name");
      this.QU = ((Intent)localObject1).getStringExtra("selfNation");
      this.QV = ((Intent)localObject1).getStringExtra("selfMobile");
      this.QT = ((Intent)localObject1).getStringExtra("toMobile");
      this.Ta = ((Intent)localObject1).getBooleanExtra("receive", false);
      this.VL = ((Intent)localObject1).getBooleanExtra("isAudioMode", true);
      this.op = ((Intent)localObject1).getLongExtra("main_timestamp", 0L);
      this.OD = ((Intent)localObject1).getStringExtra("extraUin");
      str1 = ((Intent)localObject1).getStringExtra("extraCode");
      localObject2 = ((Intent)localObject1).getByteArrayExtra("sig");
      this.VM = ((Intent)localObject1).getBooleanExtra("isPeerNetworkWell", false);
      this.VN = ((Intent)localObject1).getBooleanExtra("isFriend", false);
      this.QW = ((Intent)localObject1).getStringExtra("from");
      this.VD = ((Intent)localObject1).getBooleanExtra("shutCamera", false);
      str2 = ((Intent)localObject1).getStringExtra("headUrl");
      this.oq = aqwu.a(this.mApp, this.mPeerUin, 3, true, null);
      this.mVipType = ((Intent)localObject1).getIntExtra("vipType", 0);
      igd.aI("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.mSessionType + "  mIsAudioMode = " + this.VL);
      ikp.kR(this.mSessionType);
      if (!this.VL) {
        break label867;
      }
      l1 = 1L;
      label659:
      ikp.r(13, l1);
      if ((this.mUinType == 0) && (this.Ta)) {
        this.VN = this.mApp.isFriend(this.mPeerUin);
      }
      if (this.mUinType != 1008) {
        break label903;
      }
      if (localObject2 == null) {
        break label875;
      }
      this.bc = new byte[localObject2.length + 3];
      this.bc[0] = 1;
      this.bc[1] = 1;
      this.bc[2] = -116;
      System.arraycopy(localObject2, 0, this.bc, 3, localObject2.length);
    }
    for (;;)
    {
      AVReport.a().mPeerUin = this.mPeerUin;
      if ((this.mSessionType != 3) && (this.mSessionType != 4)) {
        break label1179;
      }
      localiiv.aa("processIntentData", ((Intent)localObject1).getIntExtra("Type", -1));
      localObject2 = ((Intent)localObject1).getStringExtra("GroupId");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1005;
      }
      igd.aK(this.TAG, "relationIdStr is null");
      this.Ox = true;
      ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
      finish();
      return;
      ikp.ant();
      break;
      label867:
      l1 = 2L;
      break label659;
      label875:
      this.bc = new byte[] { 1, 1, -118 };
      continue;
      label903:
      if (this.mUinType == 1011)
      {
        if (localObject2 != null)
        {
          this.bc = new byte[localObject2.length + 3];
          this.bc[0] = 1;
          this.bc[1] = 1;
          this.bc[2] = -118;
          System.arraycopy(localObject2, 0, this.bc, 3, localObject2.length);
        }
        else
        {
          this.bc = new byte[] { 1, 1, -118 };
        }
      }
      else {
        this.bc = ((byte[])localObject2);
      }
    }
    label1005:
    int j = ((Intent)localObject1).getIntExtra("MultiAVType", 0);
    int i = j;
    if (j == 0)
    {
      j = localiiv.anb;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, "Not get avtype inside intent default value: " + j);
        i = j;
      }
    }
    localiiv.kD(i);
    if (localObject2 != null)
    {
      localiiv.ll = Long.valueOf((String)localObject2).longValue();
      this.QS = ((String)localObject2);
    }
    localiiv.f = ((Intent)localObject1).getLongArrayExtra("DiscussUinList");
    localiiv.Rf = ((Intent)localObject1).getBooleanExtra("disableInvite", false);
    while (this.mSessionType == 0)
    {
      igd.aK(this.TAG, "invalid sessionType!!!");
      this.Ox = true;
      ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1015L);
      finish();
      return;
      label1179:
      localiiv.QU = ((Intent)localObject1).getBooleanExtra("isOtherTerminalOnChating", false);
      if (localiiv.QU)
      {
        localiiv.ln = ((Intent)localObject1).getLongExtra("otherTerminalChatingRoomId", 0L);
        localiiv.QW = ((Intent)localObject1).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    i = ((Intent)localObject1).getIntExtra("remoteStatus", 0);
    if (this.Ta)
    {
      if (TextUtils.isEmpty(this.mPeerUin))
      {
        igd.aK(this.TAG, "uin is empty");
        this.Ox = true;
        ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.OE)) {
        this.OE = this.mPeerUin;
      }
      if ((this.mUinType != 1011) && (localiiv.a.Rt))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.O(localiiv.peerUin, 232);
        this.jdField_a_of_type_ComTencentAvVideoController.ko(232);
      }
      localiiv.e(paramLong, "processIntentData", this.mSessionType);
      localiiv.uinType = this.mUinType;
      localiiv.peerUin = this.mPeerUin;
      localiiv.MO = this.OE;
      localiiv.MP = this.OD;
      localiiv.MQ = str1;
      localiiv.setPhoneNum(this.QT);
      if (!TextUtils.isEmpty(this.mPeerUin)) {
        Looper.myQueue().addIdleHandler(this.jdField_c_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      localiiv.PT = this.Ta;
      localiiv.QE = this.VL;
      localiiv.Qf = this.VM;
      localiiv.MR = this.QU;
      localiiv.MS = this.QV;
      localiiv.MT = this.QX;
      localiiv.MX = this.mBindId;
      localiiv.bindType = this.mBindType;
      localiiv.extraType = this.mExtraType;
      localiiv.signature = this.bc;
      localiiv.isFriend = this.VN;
      localiiv.amK = this.mSessionType;
      localiiv.Qb = this.VD;
      localiiv.colorRingId = this.oq;
      localiiv.vipType = this.mVipType;
      if (i != 4) {
        break label2095;
      }
      bool1 = true;
      label1594:
      localiiv.Qg = bool1;
      localiiv.amO = ((Intent)localObject1).getIntExtra("friendTerminal", 3);
      localiiv.S("processIntentData", this.Td);
      localiiv.ama = this.avm;
      localiiv.actId = ((Intent)localObject1).getStringExtra("actId");
      localiiv.MU = ((Intent)localObject1).getStringExtra("mp_ext_params");
      localiiv.lg = this.op;
      if ((this.mUinType != 1011) && (this.mUinType != 21)) {
        break label2131;
      }
      localiiv.a.headUrl = str2;
      localiiv.a.nickName = ((Intent)localObject1).getStringExtra("name");
      localiiv.a.peerUin = this.mPeerUin;
      if (Long.valueOf(this.mApp.getCurrentAccountUin()).longValue() <= Long.valueOf(this.mPeerUin).longValue()) {
        break label2101;
      }
      localiiv.a.Rs = true;
      localObject1 = this.mApp.getApplication().getApplicationInfo().dataDir + "/" + MD5.toMD5(str2) + ".jpg";
      if (!ahbj.isFileExists((String)localObject1)) {}
    }
    for (;;)
    {
      try
      {
        localiiv.a.ba = BitmapFactory.decodeFile((String)localObject1);
        QLog.w(this.TAG + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.QS + "], bStartByTerminalSwitch[" + localiiv.QU + "], terSwitchStartFromVideoEntry[" + localiiv.QW + "], \nSessionInfo[" + localiiv + "]");
        return;
        if (this.mUinType == 1006)
        {
          if (TextUtils.isEmpty(this.QT))
          {
            igd.aK(this.TAG, "phoneNum is empty");
            this.Ox = true;
            ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
            finish();
            return;
          }
          this.mPeerUin = this.QT;
          if (!TextUtils.isEmpty(this.OE)) {
            break;
          }
          this.OE = this.QT;
          break;
        }
        if (TextUtils.isEmpty(this.mPeerUin))
        {
          igd.aK(this.TAG, "Create video failed because uin is empty");
          this.Ox = true;
          ((ikr)this.mApp.a(4)).d(localiiv.getRoomId(), 5, 1016L);
          finish();
          return;
        }
        if (!TextUtils.isEmpty(this.OE)) {
          break;
        }
        this.OE = this.mPeerUin;
        break;
        label2095:
        bool1 = false;
        break label1594;
        label2101:
        localiiv.a.Rs = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d(this.TAG, 1, "processIntentData OutOfMemoryError", localOutOfMemoryError);
        continue;
      }
      label2131:
      localiiv.a.headUrl = null;
      localiiv.a.nickName = null;
      localiiv.a.Rs = false;
    }
  }
  
  void cN(long paramLong)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    boolean bool;
    if (localInputMethodManager.isActive())
    {
      if ((getCurrentFocus() == null) || (getCurrentFocus().getWindowToken() == null)) {
        break label110;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    for (int i = 1;; i = 2)
    {
      QLog.w(this.TAG, 1, "closeIME , InputMethodManager, result[" + bool + "], step[" + i + "], seq[" + paramLong + "]");
      return;
      label110:
      bool = localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  void cO(long paramLong)
  {
    if ((this.jdField_b_of_type_ComTencentAvCameraCameraUtils == null) || (!this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ar(paramLong))) {
      return;
    }
    QLog.w(this.TAG, 1, "showRotateMenu, seq[" + paramLong + "]");
    arM();
    ausj localausj = ausj.d(this);
    localausj.getWindow().addFlags(524288);
    localausj.getWindow().addFlags(2097152);
    localausj.getWindow().addFlags(128);
    localausj.addButton(2131721760);
    localausj.addCancelButton(2131721058);
    localausj.a(new ixe(this));
    localausj.setOnDismissListener(new ixf(this));
    localausj.setCanceledOnTouchOutside(true);
    localausj.setAnimationTime(150);
    this.l = localausj;
    try
    {
      this.l.show();
      this.VT = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void cP(long paramLong)
  {
    B(paramLong, 0);
  }
  
  public void d(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) {
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (int i = 0;; i = 8)
    {
      int j = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility();
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(i);
      if ((j != i) && (AudioHelper.aCz())) {
        QLog.w(this.TAG, 1, "ShowRecordBtn, from[" + paramString + "], bShown[" + paramBoolean + "], seq[" + paramLong + "]");
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().Qt))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qt = false;
        paramBoolean = this.jdField_a_of_type_Jdh.wB();
        boolean bool = jdh.wz();
        if ((!paramBoolean) || (!bool)) {
          break;
        }
        jgx.kw("0X8008AB2");
      }
      return;
    }
    jgx.kw("0X8008AB1");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      u("dispatchTouchEvent up", AudioHelper.hG());
    }
  }
  
  void e(long paramLong, String paramString, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (QLog.isColorLevel())
    {
      i = -1;
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null)
      {
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) {
          i = 1;
        }
      }
      else {
        QLog.w(this.TAG, 1, "tryShowRecordBtn[" + paramString + "], bShown[" + paramBoolean + "], visibility[" + i + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if ((!jdh.isInBlackList()) && (this.jdField_a_of_type_Jdh != null)) {
        break label146;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(8);
      }
    }
    label146:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        int k = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
        i = j;
        if (k != 1)
        {
          if (k != 2) {
            break label261;
          }
          i = j;
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((i != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.b().Qp))
            {
              this.jdField_a_of_type_Jdh.mS(this.auI);
              this.jdField_a_of_type_Jdh.aus();
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() != 0)) {
                break;
              }
              this.mHandler.removeMessages(272);
              d(paramLong, "tryShowRecordBtn.1", false);
              return;
              i = 0;
              continue;
            }
            this.mHandler.removeMessages(272);
            paramString = this.mHandler.obtainMessage(272);
            paramString.obj = Long.valueOf(paramLong);
            this.mHandler.sendMessageDelayed(paramString, 50L);
            return;
          }
        }
      } while (i == 0);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qp)
      {
        this.jdField_a_of_type_Jdh.mS(0);
        this.jdField_a_of_type_Jdh.aus();
        this.jdField_a_of_type_Jdh.auz();
      }
      this.mHandler.removeMessages(272);
      d(paramLong, "tryShowRecordBtn.2", false);
    } while (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI == null);
    label261:
    this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.ne(0);
  }
  
  public void finish()
  {
    int i = 1;
    if ((!TextUtils.isEmpty(this.QW)) && (this.QW.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    igd.aK(this.TAG, "avideo life_finish, FromWhere[" + this.QW + "]");
    iiv localiiv = igv.a().a();
    if ((localiiv.isRecording) && (this.jdField_a_of_type_Jdh != null))
    {
      this.jdField_a_of_type_Jdh.aur();
      if (this.jdField_a_of_type_Jdh.bR() < 1000L) {
        break label311;
      }
    }
    for (;;)
    {
      localiiv.amW = i;
      anot.a(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      if ((this.Ox) && (localiiv.Rp) && (this.mApp != null))
      {
        String str1 = String.valueOf(localiiv.ll);
        String str2 = this.mApp.getDisplayName(this.mUinType, str1, localiiv.MP);
        Intent localIntent = wja.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
        localIntent.putExtra("uin", str1);
        localIntent.putExtra("uintype", localiiv.uinType);
        localIntent.putExtra("uinname", str2);
        startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + localiiv.Rp + "], session[" + localiiv + "]");
      }
      super.finish();
      return;
      label311:
      i = 2;
    }
  }
  
  public int getRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  public boolean isDestroyed()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return super.isDestroyed();
    }
    return this.auG == 5;
  }
  
  public void jO(String paramString)
  {
    if ((this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX())) {
      return;
    }
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onNeedChangeDoubleScreenMode, id[" + paramString + "], seq[" + l1 + "], hasChangeDoubleScreen[" + this.jdField_a_of_type_ComTencentAvVideoController.b().QG + "]");
    getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().QG)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().hX(true);
      G(2, false);
      iwu.b(this.mApp, 1043);
      return;
    }
    if (this.bY == null) {
      this.bY = new ixg(this, paramString, l1);
    }
    iwu.a(this.mApp, 1044, null, this.bY);
  }
  
  public void jl(boolean paramBoolean)
  {
    RedTouch localRedTouch;
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localRedTouch = this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRedTouch.setVisibility(i);
      return;
    }
  }
  
  public void jm(boolean paramBoolean)
  {
    VideoLayerUI.j(findViewById(2131363166), paramBoolean);
  }
  
  public void jn(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.kF(paramBoolean);
    }
  }
  
  public void jo(boolean paramBoolean)
  {
    QLog.w(this.TAG, 1, "onZimuModeChange, inZimu[" + paramBoolean + "]");
    jdh localjdh;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.mControlUI != null) && (this.jdField_a_of_type_Jdh != null))
    {
      this.jdField_a_of_type_Jdh.XT = paramBoolean;
      localjdh = this.jdField_a_of_type_Jdh;
      if (!paramBoolean) {
        break label87;
      }
    }
    label87:
    for (int i = 0;; i = this.auI)
    {
      localjdh.mS(i);
      this.jdField_a_of_type_Jdh.aus();
      return;
    }
  }
  
  public void jp(boolean paramBoolean)
  {
    int j = 0;
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onRedBagGameModeChange, inGame[" + paramBoolean + "], seq[" + l1 + "]");
    Object localObject;
    if (this.mControlUI != null)
    {
      this.mControlUI.auZ();
      if ((this.mControlUI instanceof DoubleVideoCtrlUI))
      {
        localObject = (DoubleVideoCtrlUI)this.mControlUI;
        if (this.jdField_a_of_type_Jdh == null) {
          break label219;
        }
        i = this.jdField_a_of_type_Jdh.mc();
        ((DoubleVideoCtrlUI)localObject).mn(i);
        cP(l1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.mControlUI != null) && (this.jdField_a_of_type_Jdh != null))
    {
      this.jdField_a_of_type_Jdh.XS = paramBoolean;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.b().Qp) || (this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording))
      {
        localObject = this.jdField_a_of_type_Jdh;
        if (!paramBoolean) {
          break label224;
        }
      }
    }
    label219:
    label224:
    for (int i = j;; i = this.auI)
    {
      ((jdh)localObject).mS(i);
      this.jdField_a_of_type_Jdh.aus();
      localObject = findViewById(2131363166);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label232;
        }
        ((View)localObject).setBackgroundColor(-16777216);
      }
      return;
      i = 0;
      break;
    }
    label232:
    ((View)localObject).setBackgroundDrawable(null);
  }
  
  public void jq(boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    ImmersiveUtils.setStatusTextColor(false, getWindow());
  }
  
  public void jr(boolean paramBoolean)
  {
    if (c(getWindow(), paramBoolean)) {
      this.VU = paramBoolean;
    }
  }
  
  public void js(boolean paramBoolean)
  {
    G(1, false);
    if ((vU()) && (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)) {
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.kn("onChangeUI_quitDoubleScreenStatus");
    }
    if (paramBoolean) {
      ma(2);
    }
    if (this.mApp.ch(3))
    {
      FaceItem localFaceItem = (FaceItem)((ijv)this.mApp.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.isInteract()) || (!localFaceItem.isSameType("face"))) {
        break label138;
      }
    }
    label138:
    for (paramBoolean = true;; paramBoolean = false)
    {
      igd.aJ(this.TAG, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + paramBoolean);
      if (paramBoolean) {
        notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
      return;
    }
  }
  
  public void jt(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "updateNotificationFlag resume[" + paramBoolean + "]");
    }
    jko localjko = jko.a(this.mApp);
    if (localjko != null)
    {
      if (paramBoolean) {
        i = 1;
      }
      localjko.nK(i);
    }
  }
  
  public void jv(String paramString)
  {
    ijv localijv = (ijv)this.mApp.a(3);
    FaceItem localFaceItem = localijv.a(paramString);
    if (localFaceItem != null)
    {
      long l1 = AudioHelper.hG();
      if ((localFaceItem.isUsable()) || (TextUtils.isEmpty(localFaceItem.getResurl()))) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.w(this.TAG, 1, "onAVVoiceRecogComplete, recogResult[" + paramString + "], isResReady[" + bool + "], seq[" + l1 + "]");
        if (!bool) {
          break;
        }
        new iya.e(l1, localFaceItem.getId(), true, 2).n(this.mApp);
        VoiceRecogTips.c(this.mApp, paramString);
        anot.a(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", localFaceItem.getId());
        return;
      }
      localijv.a(l1, localFaceItem);
      return;
    }
    QLog.i(this.TAG, 1, "onAVVoiceRecogComplete. recogResult = " + paramString + ", paly voice sticker falied. voiceStickerItem == null.");
  }
  
  public int lI()
  {
    int i = 1;
    if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
      i = this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.lI();
    }
    return i;
  }
  
  int lU()
  {
    if (this.mApp == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = aqmj.j(getApplicationContext());
    String str = this.mApp.getCurrentAccountUin();
    return localSharedPreferences.getInt("showRecordTip" + String.valueOf(str), 0);
  }
  
  public int lV()
  {
    return this.auG;
  }
  
  void ma(int paramInt)
  {
    if ((this.mControlUI != null) && (this.mControlUI.a() != null)) {
      this.mControlUI.a().ma(paramInt);
    }
  }
  
  public void mb(int paramInt)
  {
    this.auG = paramInt;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    igd.aJ(this.TAG, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.mApp.l(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "life_onActivityResult, requestCode[" + paramInt1 + "], resultCode[" + paramInt2 + "]");
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 801) {
      jik.a(this.mApp, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 == 802)
          {
            jik.b(this.mApp, paramInt2, paramIntent);
            return;
          }
          if (paramInt1 != 1002) {
            break;
          }
        } while (this.jdField_a_of_type_Jci == null);
        this.jdField_a_of_type_Jci.atJ();
        return;
        if ((Build.VERSION.SDK_INT < 21) || (paramInt1 != 8080)) {
          break;
        }
      } while (this.jdField_a_of_type_Jds == null);
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_Jds.n(paramIntent);
        this.jdField_a_of_type_Jds.wE();
        return;
      }
      this.jdField_a_of_type_Jds.auL();
      return;
    } while (paramInt1 != 21001);
    this.mApp.a().o(paramInt2, paramIntent);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    enableNotch(this);
  }
  
  public void onBackPressed()
  {
    if (this.VE == true)
    {
      QLog.i(this.TAG, 1, "avideo onBackPressed, onSaveInstanceState, return");
      return;
    }
    iya.d locald = new iya.d(null);
    this.mApp.l(new Object[] { Integer.valueOf(7002), locald });
    QLog.i(this.TAG, 1, "avideo onBackPressed, BlockSystemBack[" + locald.Wa + "], BlockName[" + locald.Rj + "]");
    boolean bool1 = locald.Wa;
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Jgg != null) {
        bool2 = this.jdField_a_of_type_Jgg.onBackPressed();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      if ((this.jdField_a_of_type_Ixx == null) || (!this.jdField_a_of_type_Ixx.isShown())) {
        break label221;
      }
      bool1 = this.jdField_a_of_type_Ixx.onBackPressed();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Jci != null)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_Jci.wp())
        {
          this.jdField_a_of_type_Jci.atC();
          bool2 = true;
        }
      }
      if (!bool2) {
        super.onBackPressed();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
      VideoConstants.a.Mm = "2";
      return;
      label221:
      bool1 = bool2;
      if (this.mControlUI != null) {
        bool1 = this.mControlUI.onBackPressed();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AudioHelper.rw(this.TAG + ".onCreate.begin");
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + l1 + "], IS_CPU_64_BIT = " + false);
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559886);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    jr(true);
    d(super.getWindow());
    Object localObject1 = super.getAppRuntime();
    paramBundle = (Bundle)localObject1;
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null) {
        break label326;
      }
      QLog.d(this.TAG, 1, "onCreate, 尝试同步获取AppRuntime");
      paramBundle = paramBundle.getRuntime();
      localObject1 = this.TAG;
      localObject2 = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
      if (paramBundle == null) {
        break label320;
      }
      bool = true;
      QLog.d((String)localObject1, 1, bool);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label343;
      }
      igd.aK(this.TAG, "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131721703) + " 0x05";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.Ox = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      label320:
      bool = false;
      break;
      label326:
      QLog.d(this.TAG, 1, "onCreate, BaseApplicationImpl.getApplication is null");
      paramBundle = (Bundle)localObject1;
    }
    label343:
    if ((paramBundle instanceof VideoAppInterface)) {}
    for (this.mApp = ((VideoAppInterface)paramBundle); this.mApp == null; this.mApp = null)
    {
      igd.aK(this.TAG, "onCreate, AppRuntime is no VideoAppInterface, " + paramBundle.getClass().getName() + " exit");
      paramBundle = super.getString(2131721703) + " 0x06";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.Ox = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    jq(true);
    paramBundle = (ikr)this.mApp.a(4);
    localObject1 = igv.a().a();
    if (localObject1 != null)
    {
      QLog.d(this.TAG, 1, "avideo life_onCreate roomId = " + ((iiv)localObject1).getRoomId() + ",isReceiver = " + ((iiv)localObject1).PT);
      if (((iiv)localObject1).PT) {
        paramBundle.d(((iiv)localObject1).getRoomId(), 7, 1L);
      }
    }
    for (;;)
    {
      bool = getIntent().getBooleanExtra("isMakingAcall", false);
      if (bool) {
        paramBundle.d(-1L, 1, 1L);
      }
      QLog.d(this.TAG, 1, "avideo life_onCreate  isMakingAcall =  " + bool);
      AVReport.a().c(getIntent(), this.mApp.getCurrentAccountUin());
      ikg.a().aw(this);
      this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      igd.aK(this.TAG, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = super.getString(2131721703) + " 0x07";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.Ox = true;
      this.mApp.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
      QLog.d(this.TAG, 1, "avideo life_onCreate sessionInfo is null ");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.sn())
    {
      igd.aK(this.TAG, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = super.getString(2131721703) + " 0x08";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.Ox = true;
      this.mApp.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.iq(SDKConfigInfo.getDeviceInfo(getApplicationContext()));
    paramBundle = super.getIntent();
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getIntExtra("uinType", -1);
      localObject1 = paramBundle.getStringExtra("uin");
      if (i == 1008)
      {
        localObject2 = igv.a(3, (String)localObject1, new int[0]);
        localObject2 = igv.a().c((String)localObject2);
        if ((localObject2 == null) || (((iiv)localObject2).uinType == -1))
        {
          localObject2 = igv.a().a();
          if ((((iiv)localObject2).uinType != -1) && ((((iiv)localObject2).ta()) || (((iiv)localObject2).tc())))
          {
            paramBundle = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            paramBundle.setPackage(this.mApp.getApp().getPackageName());
            paramBundle.putExtra("uin", (String)localObject1);
            paramBundle.putExtra("uinType", i);
            this.mApp.getApp().sendBroadcast(paramBundle);
            this.Ox = true;
            this.mApp.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            igd.aK(this.TAG, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + (String)localObject1);
            finish();
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder().append("onCreate, from[");
      if (paramBundle == null)
      {
        paramBundle = "null";
        QLog.i((String)localObject1, 2, paramBundle);
      }
    }
    else
    {
      this.mApp.addObserver(this.jdField_b_of_type_Iid);
      this.mApp.addObserver(this.jdField_b_of_type_Iya);
      this.mApp.addObserver(this.jdField_a_of_type_Iiz);
      this.jdField_a_of_type_ComTencentAvVideoController.fp();
      arm();
      arH();
      this.mSessionId = c(getIntent());
      if ((TextUtils.isEmpty(this.mSessionId)) || (l(getIntent())) || (igv.a().ci(this.mSessionId))) {
        break label1679;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(false, 204, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.b().anb });
      this.jdField_a_of_type_ComTencentAvVideoController.ko(204);
      igv.a().a(this.mSessionId, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onCreate, sessionId[" + this.mSessionId + "]");
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().sT()) {
        cL(l1);
      }
      GraphicRenderMgr.getInstance();
      ThreadManager.post(new AVActivity.4(this), 5, null, false);
      this.jdField_a_of_type_Jko = jko.a(this.mApp);
      mb(0);
      A(l1, false);
      if ((this.mControlUI instanceof DoubleVideoCtrlUI)) {
        itm.a().aqB();
      }
      if (EffectSettingUi.a(this.mApp, false))
      {
        this.jdField_a_of_type_Ixy = new ixy(this);
        this.jdField_a_of_type_Ixy.init();
      }
      this.jdField_b_of_type_Ivm = ivm.a(this.mApp);
      i = this.jdField_a_of_type_ComTencentAvVideoController.b().ani;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, "onCreate changeVideoLayoutMode Style=" + this.jdField_a_of_type_ComTencentAvVideoController.b().amI + "|" + this.jdField_a_of_type_ComTencentAvVideoController.b().ani + "|" + this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel());
      }
      G(i, false);
      this.mApp.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      paramBundle = (ViewStub)findViewById(2131373977);
      this.jdField_a_of_type_Jci = new jci(findViewById(2131373916), paramBundle, 2131374211, this.jdField_a_of_type_ComTencentAvVideoController, this);
      this.jdField_a_of_type_Jgg = new jgg(this, this.mApp);
      if (ThemeUtil.isInNightMode(this.mApp)) {
        findViewById(2131374146).setVisibility(0);
      }
      this.mApp.a().av(this);
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.onCreate(this);
      AudioHelper.rw(this.TAG + ".onCreate.end");
      return;
      paramBundle = paramBundle.getStringExtra("Fromwhere");
      break;
      label1679:
      this.mSessionId = igv.a().a().sessionId;
    }
  }
  
  public void onDestroy()
  {
    this.mIsShadow = false;
    super.onDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_c_of_type_AndroidOsMessageQueue$IdleHandler);
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "avideo life_onDestroy, mActivityState[" + this.auG + "->" + 5 + "], seq[" + l1 + "], isQuit[" + this.Ox + "], session[" + this.mSessionId + "]");
    u("onDestroy", l1);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.onDestroy(l1);
    mb(5);
    if (this.mHandler != null) {
      this.mHandler.removeMessages(272);
    }
    arO();
    if (this.jdField_a_of_type_Jgg != null)
    {
      this.jdField_a_of_type_Jgg.destroy(this.Ox);
      this.jdField_a_of_type_Jgg = null;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) && (this.jdField_a_of_type_Jdh != null)) {
      this.jdField_a_of_type_Jdh.aur();
    }
    if (this.jdField_a_of_type_Jdh != null)
    {
      this.jdField_a_of_type_Jdh.onDestroy();
      this.jdField_a_of_type_Jdh = null;
    }
    if (this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils.deleteObserver(this.jdField_a_of_type_Ill);
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils = null;
    }
    if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.onDestroy();
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI = null;
    }
    if (this.mControlUI != null)
    {
      this.mControlUI.onDestroy(l1);
      this.mControlUI = null;
    }
    if (this.jdField_a_of_type_Ixx != null)
    {
      this.jdField_a_of_type_Ixx.onDestroy();
      this.jdField_a_of_type_Ixx = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
    if (this.mApp != null)
    {
      this.mApp.deleteObserver(this.jdField_a_of_type_Iiz);
      this.mApp.deleteObserver(this.jdField_b_of_type_Iya);
      this.mApp.deleteObserver(this.jdField_b_of_type_Iid);
      this.mApp.getHandler().removeCallbacks(this.bH);
      ilu localilu = this.mApp.a();
      if (localilu != null) {
        localilu.aoc();
      }
    }
    if (this.X != null)
    {
      unregisterReceiver(this.X);
      this.X = null;
    }
    if (this.Ox)
    {
      imp.a().reset();
      if (this.jdField_a_of_type_Jko != null) {
        this.jdField_a_of_type_Jko.cancelNotification(this.mSessionId);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "onDestroy isQuit[" + this.Ox + "], session[" + this.mSessionId + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.mApp != null) {
      this.mApp.b().b().ac("AVActivity.onDestroy", 0);
    }
    this.dX = null;
    this.jdField_a_of_type_Jko = null;
    this.jdField_a_of_type_ComTencentAvUiAVActivity$d = null;
    AudioHelper.cTR = false;
    this.X = null;
    this.jdField_b_of_type_Iya = null;
    this.jdField_a_of_type_Iiz = null;
    if (this.jdField_a_of_type_Ixy != null)
    {
      this.jdField_a_of_type_Ixy.unInit();
      this.jdField_a_of_type_Ixy = null;
    }
    ikg.a().aw(null);
    if (this.mApp != null) {
      this.mApp.l(new Object[] { Integer.valueOf(7004), this.mPeerUin, Boolean.valueOf(this.Ox) });
    }
    irk.a().apM();
    irk.a().a(null, null);
    this.mApp = null;
    if (this.jdField_a_of_type_Jci != null)
    {
      anot.a(null, "CliOper", "", "", "0X800A345", "0X800A345", this.jdField_a_of_type_Jci.lY(), 0, "", "", "", "");
      this.jdField_a_of_type_Jci.doDestroy();
    }
    this.jdField_a_of_type_Jci = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.mControlUI != null) {
      bool = this.mControlUI.onKeyDown(paramInt, paramKeyEvent);
    }
    if (bool) {}
    long l1;
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramInt)
          {
          case 84: 
          case 24: 
          case 25: 
          default: 
            return super.onKeyDown(paramInt, paramKeyEvent);
          }
        } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_ComTencentAvCameraCameraUtils == null));
        paramKeyEvent = this.jdField_a_of_type_ComTencentAvVideoController.b();
      } while (((paramKeyEvent.amI != 2) || (!paramKeyEvent.isConnected())) && ((paramKeyEvent.amI != 4) || (paramKeyEvent.state < 9)));
      l1 = AudioHelper.hG();
    } while (!this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ar(l1));
    cO(l1);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l1 = AudioHelper.hG();
    if (QLog.isColorLevel())
    {
      QLog.w(this.TAG, 1, "life_onNewIntent, seq[" + l1 + "]");
      QLog.d(this.TAG, 2, "");
    }
    if (this.jdField_b_of_type_Ivm != null) {
      this.jdField_b_of_type_Ivm.onResume();
    }
    setIntent(paramIntent);
    int i = paramIntent.getIntExtra("sessionType", 0);
    int j = paramIntent.getIntExtra("MultiAVType", 0);
    if ((this.mSessionType == 1) || (this.mSessionType == 2)) {
      if ((i == 3) || (i == 4))
      {
        if (this.mControlUI != null)
        {
          this.mControlUI.onDestroy(l1);
          this.mControlUI = null;
        }
        cL(l1);
        mb(0);
        A(l1, false);
      }
    }
    label164:
    do
    {
      do
      {
        do
        {
          break label164;
          do
          {
            return;
          } while ((this.mSessionType != 3) && (this.mSessionType != 4));
          if ((j != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.b().anb != 2)) {
            break label290;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb != j) {
            break;
          }
          cL(l1);
          if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.onPause();
          }
        } while (this.mControlUI == null);
        this.mControlUI.onNewIntent(paramIntent);
        return;
        if (this.mControlUI != null)
        {
          this.mControlUI.onDestroy(l1);
          this.mControlUI = null;
        }
        cL(l1);
        mb(0);
        A(l1, false);
        return;
        if ((i != 3) && (i != 4)) {
          break;
        }
        cL(l1);
        if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.onPause();
        }
      } while (this.mControlUI == null);
      this.mControlUI.onNewIntent(paramIntent);
      return;
    } while ((i != 1) && (i != 2));
    label290:
    if (this.mControlUI != null)
    {
      this.mControlUI.onDestroy(l1);
      this.mControlUI = null;
    }
    cL(l1);
    mb(0);
    A(l1, false);
  }
  
  public void onPause()
  {
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "avideo life_onPause, seq[" + l1 + "]");
    aeee.e(this, 2, true);
    irk.a().pause(16);
    jt(false);
    arlc.a(BaseApplicationImpl.getContext(), true, 50, 1);
    this.VP = true;
    try
    {
      this.mIsShadow = false;
      super.onPause();
      mb(3);
      if (this.mControlUI != null) {
        this.mControlUI.aso();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a("state", "0");
        if ("0".equals(VideoConstants.a.Mm)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.TAG, 1, "avideo life_onPause end");
      if (this.jdField_a_of_type_Jci != null)
      {
        this.jdField_a_of_type_Jci.atC();
        this.jdField_a_of_type_Jci.atJ();
      }
      this.jdField_a_of_type_Imc.a(this.mApp, this.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      QLog.w(this.TAG, 1, "life_onPause, exit when onPause Exception, seq[" + l1 + "]", localException);
      this.mApp.q(l1, 1007);
    }
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokevirtual 2903	com/tencent/av/ui/AVActivity:jt	(Z)V
    //   5: invokestatic 296	com/tencent/mobileqq/utils/AudioHelper:hG	()J
    //   8: lstore 9
    //   10: aload_0
    //   11: iconst_2
    //   12: iconst_0
    //   13: invokestatic 2898	aeee:e	(Landroid/content/Context;IZ)V
    //   16: invokestatic 2906	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: bipush 50
    //   21: iconst_0
    //   22: invokestatic 2940	arlc:y	(Landroid/content/Context;II)V
    //   25: invokestatic 2906	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: iconst_0
    //   29: bipush 50
    //   31: iconst_1
    //   32: invokestatic 2911	arlc:a	(Landroid/content/Context;ZII)V
    //   35: invokestatic 2906	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: bipush 50
    //   40: iconst_2
    //   41: invokestatic 2940	arlc:y	(Landroid/content/Context;II)V
    //   44: new 283	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: getfield 305	com/tencent/av/ui/AVActivity:TAG	Ljava/lang/String;
    //   55: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 2942
    //   61: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 2554	com/tencent/mobileqq/utils/AudioHelper:rw	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 281	com/tencent/av/ui/AVActivity:mIsShadow	Z
    //   75: aload_0
    //   76: invokespecial 2943	mqq/app/BaseActivity:onResume	()V
    //   79: invokestatic 1728	igv:a	()Ligv;
    //   82: invokevirtual 2249	igv:a	()Liiv;
    //   85: astore 21
    //   87: aload_0
    //   88: getfield 305	com/tencent/av/ui/AVActivity:TAG	Ljava/lang/String;
    //   91: iconst_1
    //   92: new 283	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 2945
    //   102: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 618	com/tencent/av/ui/AVActivity:VS	Z
    //   109: invokevirtual 508	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: ldc_w 574
    //   115: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload 9
    //   120: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 2947
    //   126: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 21
    //   131: invokevirtual 1382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc_w 436
    //   137: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 532	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 2913	com/tencent/av/ui/AVActivity:VP	Z
    //   151: invokestatic 2952	ioz:aoZ	()V
    //   154: aload_0
    //   155: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   158: iconst_4
    //   159: invokevirtual 1611	com/tencent/av/app/VideoAppInterface:a	(I)Lijo;
    //   162: checkcast 1613	ikr
    //   165: astore 22
    //   167: aload 21
    //   169: getfield 1124	iiv:PT	Z
    //   172: ifeq +16 -> 188
    //   175: aload 22
    //   177: aload 21
    //   179: invokevirtual 1616	iiv:getRoomId	()J
    //   182: bipush 8
    //   184: lconst_1
    //   185: invokevirtual 1621	ikr:d	(JIJ)V
    //   188: aload_0
    //   189: invokevirtual 770	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   192: ldc_w 2636
    //   195: iconst_0
    //   196: invokevirtual 408	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   199: ifeq +13 -> 212
    //   202: aload 22
    //   204: ldc2_w 2637
    //   207: iconst_3
    //   208: lconst_1
    //   209: invokevirtual 1621	ikr:d	(JIJ)V
    //   212: aload_0
    //   213: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   216: invokevirtual 2955	com/tencent/av/app/VideoAppInterface:sK	()Z
    //   219: ifne +10 -> 229
    //   222: aload_0
    //   223: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   226: invokevirtual 2958	com/tencent/av/app/VideoAppInterface:amD	()V
    //   229: aload_0
    //   230: getfield 618	com/tencent/av/ui/AVActivity:VS	Z
    //   233: ifeq +19 -> 252
    //   236: aload_0
    //   237: getfield 135	com/tencent/av/ui/AVActivity:mSessionType	I
    //   240: iconst_1
    //   241: if_icmpeq +11 -> 252
    //   244: aload_0
    //   245: getfield 135	com/tencent/av/ui/AVActivity:mSessionType	I
    //   248: iconst_2
    //   249: if_icmpne +3 -> 252
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 618	com/tencent/av/ui/AVActivity:VS	Z
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 257	com/tencent/av/ui/AVActivity:VE	Z
    //   262: aload_0
    //   263: iconst_2
    //   264: invokevirtual 2735	com/tencent/av/ui/AVActivity:mb	(I)V
    //   267: aload_0
    //   268: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   271: iconst_1
    //   272: invokevirtual 1555	com/tencent/av/VideoController:hJ	(Z)V
    //   275: aload_0
    //   276: getfield 314	com/tencent/av/ui/AVActivity:jdField_b_of_type_Ivm	Livm;
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: getfield 314	com/tencent/av/ui/AVActivity:jdField_b_of_type_Ivm	Livm;
    //   286: invokevirtual 2887	ivm:onResume	()V
    //   289: getstatic 488	android/os/Build$VERSION:SDK_INT	I
    //   292: bipush 21
    //   294: if_icmplt +47 -> 341
    //   297: aload_0
    //   298: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   301: invokevirtual 1180	com/tencent/av/VideoController:a	()Ljds;
    //   304: astore 19
    //   306: aload 19
    //   308: ifnull +33 -> 341
    //   311: aload 19
    //   313: invokevirtual 2961	jds:wG	()Z
    //   316: ifeq +25 -> 341
    //   319: aload_0
    //   320: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   323: invokevirtual 889	com/tencent/av/app/VideoAppInterface:getHandler	()Landroid/os/Handler;
    //   326: new 2963	com/tencent/av/ui/AVActivity$11
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 2964	com/tencent/av/ui/AVActivity$11:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   334: ldc2_w 2965
    //   337: invokevirtual 902	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   340: pop
    //   341: aload_0
    //   342: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   345: invokevirtual 889	com/tencent/av/app/VideoAppInterface:getHandler	()Landroid/os/Handler;
    //   348: new 2968	com/tencent/av/ui/AVActivity$12
    //   351: dup
    //   352: aload_0
    //   353: lload 9
    //   355: invokespecial 2970	com/tencent/av/ui/AVActivity$12:<init>	(Lcom/tencent/av/ui/AVActivity;J)V
    //   358: ldc2_w 2971
    //   361: invokevirtual 902	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   364: pop
    //   365: aload 21
    //   367: getfield 555	iiv:amI	I
    //   370: iconst_2
    //   371: if_icmpne +1073 -> 1444
    //   374: aload 21
    //   376: invokevirtual 2877	iiv:isConnected	()Z
    //   379: ifeq +1011 -> 1390
    //   382: aload 21
    //   384: getfield 858	iiv:peerUin	Ljava/lang/String;
    //   387: astore 19
    //   389: aload 21
    //   391: getfield 2975	iiv:PZ	Z
    //   394: istore 15
    //   396: aload_0
    //   397: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   400: aload_0
    //   401: getfield 149	com/tencent/av/ui/AVActivity:mPeerUin	Ljava/lang/String;
    //   404: invokevirtual 2978	com/tencent/av/VideoController:cl	(Ljava/lang/String;)Z
    //   407: istore 16
    //   409: aload 21
    //   411: getfield 2981	iiv:PX	Z
    //   414: istore 17
    //   416: aload 21
    //   418: getfield 2984	iiv:PY	Z
    //   421: istore 18
    //   423: iload 18
    //   425: ifeq +41 -> 466
    //   428: invokestatic 2989	aqgz:getDeviceModel	()Ljava/lang/String;
    //   431: astore 20
    //   433: aload_0
    //   434: getfield 735	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   437: lload 9
    //   439: invokevirtual 2992	com/tencent/av/camera/CameraUtils:aq	(J)Z
    //   442: ifne +835 -> 1277
    //   445: aload_0
    //   446: getfield 735	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   449: lload 9
    //   451: invokevirtual 1470	com/tencent/av/camera/CameraUtils:ar	(J)Z
    //   454: ifne +823 -> 1277
    //   457: aload_0
    //   458: getfield 735	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   461: lload 9
    //   463: invokevirtual 2995	com/tencent/av/camera/CameraUtils:ca	(J)V
    //   466: aload_0
    //   467: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   470: ifnull +59 -> 529
    //   473: iload 18
    //   475: ifeq +871 -> 1346
    //   478: iload 15
    //   480: ifeq +866 -> 1346
    //   483: iload 17
    //   485: ifeq +830 -> 1315
    //   488: aload_0
    //   489: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   492: lload 9
    //   494: aload 19
    //   496: iconst_1
    //   497: iconst_1
    //   498: iconst_0
    //   499: iload 16
    //   501: invokevirtual 1540	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   504: aload_0
    //   505: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   508: ldc_w 2996
    //   511: invokestatic 2999	jik:b	(Lcom/tencent/av/app/VideoAppInterface;Ljava/lang/String;)Z
    //   514: istore 15
    //   516: aload_0
    //   517: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   520: lload 9
    //   522: iconst_1
    //   523: iload 15
    //   525: invokevirtual 1466	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   528: pop
    //   529: aload_0
    //   530: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   533: ifnull +10 -> 543
    //   536: aload_0
    //   537: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   540: invokevirtual 3000	com/tencent/av/ui/VideoLayerUI:onResume	()V
    //   543: aload_0
    //   544: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   547: ifnull +12 -> 559
    //   550: aload_0
    //   551: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   554: lload 9
    //   556: invokevirtual 3003	com/tencent/av/ui/VideoControlUI:cV	(J)V
    //   559: aload_0
    //   560: getfield 588	com/tencent/av/ui/AVActivity:jdField_a_of_type_Ixx	Lixx;
    //   563: ifnull +10 -> 573
    //   566: aload_0
    //   567: getfield 588	com/tencent/av/ui/AVActivity:jdField_a_of_type_Ixx	Lixx;
    //   570: invokevirtual 3004	ixx:onResume	()V
    //   573: aload_0
    //   574: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   577: iconst_0
    //   578: invokevirtual 1552	com/tencent/av/VideoController:d	(Z)I
    //   581: pop
    //   582: aload_0
    //   583: invokevirtual 3006	com/tencent/av/ui/AVActivity:arn	()V
    //   586: aload_0
    //   587: invokevirtual 3008	com/tencent/av/ui/AVActivity:arI	()V
    //   590: aload_0
    //   591: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   594: invokevirtual 2661	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   597: new 388	android/content/Intent
    //   600: dup
    //   601: ldc_w 2609
    //   604: invokespecial 2610	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   607: invokevirtual 2664	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   610: aload_0
    //   611: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   614: ifnull +20 -> 634
    //   617: aload_0
    //   618: invokevirtual 605	com/tencent/av/ui/AVActivity:vU	()Z
    //   621: ifeq +13 -> 634
    //   624: aload_0
    //   625: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   628: ldc_w 2996
    //   631: invokevirtual 2348	com/tencent/av/ui/VideoLayerUI:kn	(Ljava/lang/String;)V
    //   634: aload 21
    //   636: getfield 555	iiv:amI	I
    //   639: iconst_2
    //   640: if_icmpeq +12 -> 652
    //   643: aload 21
    //   645: getfield 555	iiv:amI	I
    //   648: iconst_1
    //   649: if_icmpne +45 -> 694
    //   652: aload_0
    //   653: getfield 378	com/tencent/av/ui/AVActivity:jdField_a_of_type_Jdh	Ljdh;
    //   656: ifnull +38 -> 694
    //   659: aload_0
    //   660: getfield 378	com/tencent/av/ui/AVActivity:jdField_a_of_type_Jdh	Ljdh;
    //   663: invokevirtual 3011	jdh:md	()I
    //   666: iconst_1
    //   667: if_icmpne +27 -> 694
    //   670: aload 21
    //   672: getfield 1029	iiv:Qp	Z
    //   675: ifeq +19 -> 694
    //   678: aload_0
    //   679: getfield 273	com/tencent/av/ui/AVActivity:mHandler	Landroid/os/Handler;
    //   682: new 3013	com/tencent/av/ui/AVActivity$14
    //   685: dup
    //   686: aload_0
    //   687: invokespecial 3014	com/tencent/av/ui/AVActivity$14:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   690: invokevirtual 942	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   693: pop
    //   694: aload 21
    //   696: getfield 3017	iiv:anr	I
    //   699: iconst_m1
    //   700: if_icmpne +12 -> 712
    //   703: aload 21
    //   705: aload_0
    //   706: invokevirtual 3019	com/tencent/av/ui/AVActivity:lU	()I
    //   709: putfield 3017	iiv:anr	I
    //   712: aload 21
    //   714: getfield 3022	iiv:anq	I
    //   717: iconst_m1
    //   718: if_icmpne +105 -> 823
    //   721: aload_0
    //   722: invokevirtual 329	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   725: invokestatic 2440	aqmj:j	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   728: astore 19
    //   730: aload 21
    //   732: aload 19
    //   734: new 283	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 3024
    //   744: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload_0
    //   748: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   751: invokevirtual 1534	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   754: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: iconst_1
    //   761: invokeinterface 2449 3 0
    //   766: putfield 3022	iiv:anq	I
    //   769: aload 21
    //   771: getfield 3022	iiv:anq	I
    //   774: iconst_1
    //   775: if_icmpne +48 -> 823
    //   778: aload 19
    //   780: invokeinterface 3028 1 0
    //   785: new 283	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 3024
    //   795: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   802: invokevirtual 1534	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   805: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: iconst_0
    //   812: invokeinterface 3034 3 0
    //   817: invokeinterface 3037 1 0
    //   822: pop
    //   823: aload 21
    //   825: getfield 2258	iiv:amW	I
    //   828: ifeq +38 -> 866
    //   831: aload 21
    //   833: getfield 2258	iiv:amW	I
    //   836: iconst_1
    //   837: if_icmpne +1299 -> 2136
    //   840: aload_0
    //   841: iconst_2
    //   842: aload_0
    //   843: invokevirtual 1290	com/tencent/av/ui/AVActivity:getResources	()Landroid/content/res/Resources;
    //   846: ldc_w 3038
    //   849: invokevirtual 3039	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   852: iconst_0
    //   853: invokestatic 3044	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   856: invokevirtual 3047	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   859: pop
    //   860: aload 21
    //   862: iconst_0
    //   863: putfield 2258	iiv:amW	I
    //   866: aload_0
    //   867: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   870: iconst_2
    //   871: anewarray 2461	java/lang/Object
    //   874: dup
    //   875: iconst_0
    //   876: sipush 7000
    //   879: invokestatic 2377	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   882: aastore
    //   883: dup
    //   884: iconst_1
    //   885: aload_0
    //   886: getfield 149	com/tencent/av/ui/AVActivity:mPeerUin	Ljava/lang/String;
    //   889: aastore
    //   890: invokevirtual 2464	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   893: invokestatic 1159	com/tencent/mobileqq/utils/AudioHelper:isDev	()Z
    //   896: ifeq +10 -> 906
    //   899: aload_0
    //   900: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   903: invokestatic 3050	com/tencent/mobileqq/debug/PstnCardTestActivity:showTestBtn	(Lcom/tencent/av/app/VideoAppInterface;)V
    //   906: invokestatic 931	irk:a	()Lirk;
    //   909: bipush 16
    //   911: invokevirtual 3053	irk:resume	(I)V
    //   914: aload 21
    //   916: getfield 2984	iiv:PY	Z
    //   919: istore 15
    //   921: aload 21
    //   923: getfield 2975	iiv:PZ	Z
    //   926: istore 16
    //   928: iload 15
    //   930: ifeq +8 -> 938
    //   933: iload 16
    //   935: ifne +1224 -> 2159
    //   938: invokestatic 931	irk:a	()Lirk;
    //   941: iconst_1
    //   942: invokevirtual 2901	irk:pause	(I)V
    //   945: invokestatic 3056	java/lang/System:currentTimeMillis	()J
    //   948: lstore 11
    //   950: invokestatic 2742	itm:a	()Litm;
    //   953: getfield 3059	itm:of	J
    //   956: lstore 13
    //   958: aload 21
    //   960: invokevirtual 1616	iiv:getRoomId	()J
    //   963: lconst_0
    //   964: lcmp
    //   965: ifle +1204 -> 2169
    //   968: aload 21
    //   970: invokevirtual 1616	iiv:getRoomId	()J
    //   973: lstore 7
    //   975: aload 22
    //   977: lload 7
    //   979: bipush 25
    //   981: lload 11
    //   983: lload 13
    //   985: lsub
    //   986: invokevirtual 1621	ikr:d	(JIJ)V
    //   989: aload_0
    //   990: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   993: ldc_w 2918
    //   996: ldc_w 3061
    //   999: invokevirtual 2542	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/av/VideoController;
    //   1002: pop
    //   1003: ldc_w 2920
    //   1006: putstatic 2547	com/tencent/av/VideoConstants$a:Mm	Ljava/lang/String;
    //   1009: new 283	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1016: aload_0
    //   1017: getfield 305	com/tencent/av/ui/AVActivity:TAG	Ljava/lang/String;
    //   1020: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 3063
    //   1026: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 2554	com/tencent/mobileqq/utils/AudioHelper:rw	(Ljava/lang/String;)V
    //   1035: aload_0
    //   1036: invokevirtual 770	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1039: ldc_w 3065
    //   1042: iconst_0
    //   1043: invokevirtual 392	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1046: ifeq +21 -> 1067
    //   1049: invokestatic 3070	tzc:a	()Ltzc;
    //   1052: aload_0
    //   1053: invokevirtual 770	com/tencent/av/ui/AVActivity:getIntent	()Landroid/content/Intent;
    //   1056: ldc_w 3065
    //   1059: iconst_0
    //   1060: invokevirtual 392	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1063: iconst_1
    //   1064: invokevirtual 3073	tzc:ax	(IZ)V
    //   1067: aload_0
    //   1068: invokevirtual 3074	com/tencent/av/ui/AVActivity:b	()Lcom/tencent/av/VideoController;
    //   1071: invokevirtual 3077	com/tencent/av/VideoController:alS	()V
    //   1074: invokestatic 3079	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   1077: aload_0
    //   1078: invokevirtual 719	com/tencent/av/VideoController:a	(Landroid/content/Context;)Liow;
    //   1081: astore 19
    //   1083: aload 19
    //   1085: ifnull +12 -> 1097
    //   1088: aload 19
    //   1090: lload 9
    //   1092: invokeinterface 3084 3 0
    //   1097: invokestatic 1159	com/tencent/mobileqq/utils/AudioHelper:isDev	()Z
    //   1100: ifeq +46 -> 1146
    //   1103: aload_0
    //   1104: getfield 305	com/tencent/av/ui/AVActivity:TAG	Ljava/lang/String;
    //   1107: iconst_1
    //   1108: new 283	java/lang/StringBuilder
    //   1111: dup
    //   1112: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1115: ldc_w 3086
    //   1118: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload_0
    //   1122: invokevirtual 2126	com/tencent/av/ui/AVActivity:getWindow	()Landroid/view/Window;
    //   1125: invokevirtual 474	android/view/Window:getDecorView	()Landroid/view/View;
    //   1128: invokevirtual 479	android/view/View:getSystemUiVisibility	()I
    //   1131: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1134: ldc_w 436
    //   1137: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: invokestatic 532	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: aload_0
    //   1147: getfield 233	com/tencent/av/ui/AVActivity:jdField_a_of_type_Imc	Limc;
    //   1150: aload_0
    //   1151: aload_0
    //   1152: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   1155: aload_0
    //   1156: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1159: invokevirtual 3089	imc:a	(Lmqq/app/BaseActivity;Lcom/tencent/av/app/VideoAppInterface;Lcom/tencent/av/VideoController;)V
    //   1162: aload_0
    //   1163: getfield 991	com/tencent/av/ui/AVActivity:jdField_a_of_type_Jgg	Ljgg;
    //   1166: ifnull +76 -> 1242
    //   1169: invokestatic 427	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1172: ifeq +41 -> 1213
    //   1175: aload_0
    //   1176: getfield 305	com/tencent/av/ui/AVActivity:TAG	Ljava/lang/String;
    //   1179: iconst_2
    //   1180: new 283	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1187: ldc_w 3091
    //   1190: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload 21
    //   1195: getfield 3094	iiv:Rn	Z
    //   1198: invokevirtual 508	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1201: ldc_w 436
    //   1204: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokestatic 440	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1213: aload 21
    //   1215: getfield 3094	iiv:Rn	Z
    //   1218: ifeq +17 -> 1235
    //   1221: aload_0
    //   1222: getfield 991	com/tencent/av/ui/AVActivity:jdField_a_of_type_Jgg	Ljgg;
    //   1225: iconst_0
    //   1226: invokevirtual 3097	jgg:nt	(I)V
    //   1229: aload 21
    //   1231: iconst_0
    //   1232: putfield 3094	iiv:Rn	Z
    //   1235: aload_0
    //   1236: getfield 991	com/tencent/av/ui/AVActivity:jdField_a_of_type_Jgg	Ljgg;
    //   1239: invokevirtual 1488	jgg:awa	()V
    //   1242: return
    //   1243: astore 19
    //   1245: aload_0
    //   1246: getfield 305	com/tencent/av/ui/AVActivity:TAG	Ljava/lang/String;
    //   1249: iconst_1
    //   1250: new 283	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1257: ldc_w 3099
    //   1260: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 19
    //   1265: invokevirtual 1382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: invokestatic 451	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1274: goto -1195 -> 79
    //   1277: aload 20
    //   1279: ldc_w 3101
    //   1282: invokevirtual 3104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1285: ifeq -819 -> 466
    //   1288: aload_0
    //   1289: getfield 735	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1292: invokevirtual 3107	com/tencent/av/camera/CameraUtils:a	()Landroid/hardware/Camera$Parameters;
    //   1295: ifnonnull -829 -> 466
    //   1298: aload_0
    //   1299: getfield 735	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1302: ldc_w 3109
    //   1305: lload 9
    //   1307: iconst_m1
    //   1308: iconst_m1
    //   1309: invokevirtual 3112	com/tencent/av/camera/CameraUtils:b	(Ljava/lang/String;JII)V
    //   1312: goto -846 -> 466
    //   1315: aload_0
    //   1316: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1319: lload 9
    //   1321: iconst_1
    //   1322: iconst_0
    //   1323: invokevirtual 1466	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1326: pop
    //   1327: aload_0
    //   1328: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1331: lload 9
    //   1333: aload 19
    //   1335: iconst_1
    //   1336: iconst_1
    //   1337: iconst_0
    //   1338: iload 16
    //   1340: invokevirtual 1540	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1343: goto -814 -> 529
    //   1346: iload 18
    //   1348: ifeq +18 -> 1366
    //   1351: aload_0
    //   1352: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1355: lload 9
    //   1357: iconst_1
    //   1358: iconst_0
    //   1359: invokevirtual 1466	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1362: pop
    //   1363: goto -834 -> 529
    //   1366: iload 15
    //   1368: ifeq -839 -> 529
    //   1371: aload_0
    //   1372: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1375: lload 9
    //   1377: aload 19
    //   1379: iconst_1
    //   1380: iconst_1
    //   1381: iconst_0
    //   1382: iload 16
    //   1384: invokevirtual 1540	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;IZZZ)V
    //   1387: goto -858 -> 529
    //   1390: aload 21
    //   1392: getfield 1958	iiv:QU	Z
    //   1395: ifne -866 -> 529
    //   1398: aload_0
    //   1399: getfield 181	com/tencent/av/ui/AVActivity:VD	Z
    //   1402: ifne -873 -> 529
    //   1405: aload 21
    //   1407: lload 9
    //   1409: iconst_1
    //   1410: invokevirtual 1473	iiv:n	(JZ)V
    //   1413: aload_0
    //   1414: getfield 735	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvCameraCameraUtils	Lcom/tencent/av/camera/CameraUtils;
    //   1417: lload 9
    //   1419: invokevirtual 2995	com/tencent/av/camera/CameraUtils:ca	(J)V
    //   1422: aload_0
    //   1423: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1426: ifnull -897 -> 529
    //   1429: aload_0
    //   1430: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1433: lload 9
    //   1435: iconst_1
    //   1436: iconst_0
    //   1437: invokevirtual 1466	com/tencent/av/ui/VideoLayerUI:b	(JZZ)Z
    //   1440: pop
    //   1441: goto -912 -> 529
    //   1444: aload 21
    //   1446: getfield 555	iiv:amI	I
    //   1449: iconst_4
    //   1450: if_icmpne -921 -> 529
    //   1453: aload 21
    //   1455: getfield 1502	iiv:if	Ljava/util/ArrayList;
    //   1458: astore 23
    //   1460: aload 23
    //   1462: new 3114	ixd
    //   1465: dup
    //   1466: aload_0
    //   1467: invokespecial 3115	ixd:<init>	(Lcom/tencent/av/ui/AVActivity;)V
    //   1470: invokestatic 3121	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1473: aload_0
    //   1474: getfield 197	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   1477: invokevirtual 2768	com/tencent/av/VideoController:getVideoAbilityLevel	()I
    //   1480: istore 4
    //   1482: iconst_0
    //   1483: istore_3
    //   1484: iload_3
    //   1485: aload 23
    //   1487: invokevirtual 1507	java/util/ArrayList:size	()I
    //   1490: if_icmpge -961 -> 529
    //   1493: aload 23
    //   1495: iload_3
    //   1496: invokevirtual 1511	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1499: checkcast 1513	ioa
    //   1502: astore 24
    //   1504: aload 24
    //   1506: getfield 1515	ioa:uin	J
    //   1509: invokestatic 1521	jji:al	(J)Ljava/lang/String;
    //   1512: astore 25
    //   1514: aload 24
    //   1516: getfield 1524	ioa:videoSrcType	I
    //   1519: istore 5
    //   1521: aload 24
    //   1523: getfield 3124	ioa:Tp	Z
    //   1526: istore 16
    //   1528: aload_0
    //   1529: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1532: ifnull +371 -> 1903
    //   1535: aload_0
    //   1536: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1539: aload 25
    //   1541: iload 5
    //   1543: invokevirtual 3128	com/tencent/av/ui/VideoLayerUI:h	(Ljava/lang/String;I)Z
    //   1546: istore 15
    //   1548: aload_0
    //   1549: getfield 141	com/tencent/av/ui/AVActivity:mUinType	I
    //   1552: invokestatic 3132	jjc:cI	(I)I
    //   1555: istore 6
    //   1557: aload_0
    //   1558: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   1561: iload 6
    //   1563: aload 25
    //   1565: aload 21
    //   1567: getfield 1767	iiv:ll	J
    //   1570: invokestatic 1661	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1573: invokevirtual 2267	com/tencent/av/app/VideoAppInterface:getDisplayName	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1576: astore 20
    //   1578: aload 24
    //   1580: getfield 3135	ioa:isRender	Z
    //   1583: ifeq +126 -> 1709
    //   1586: aload 25
    //   1588: aload_0
    //   1589: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   1592: invokevirtual 1534	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1595: invokevirtual 1537	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1598: ifne +111 -> 1709
    //   1601: iload 16
    //   1603: ifeq +106 -> 1709
    //   1606: aload 24
    //   1608: getfield 3138	ioa:Tr	Z
    //   1611: ifne +98 -> 1709
    //   1614: aload 20
    //   1616: invokestatic 3141	jji:length	(Ljava/lang/String;)I
    //   1619: bipush 20
    //   1621: if_icmple +561 -> 2182
    //   1624: new 283	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1631: aload 20
    //   1633: iconst_0
    //   1634: bipush 20
    //   1636: invokestatic 3145	jji:subString	(Ljava/lang/String;II)Ljava/lang/String;
    //   1639: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: ldc_w 3147
    //   1645: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1651: astore 19
    //   1653: iload 5
    //   1655: iconst_2
    //   1656: if_icmpne +269 -> 1925
    //   1659: aload_0
    //   1660: ldc_w 3148
    //   1663: invokevirtual 3149	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1666: iconst_1
    //   1667: anewarray 2461	java/lang/Object
    //   1670: dup
    //   1671: iconst_0
    //   1672: aload 19
    //   1674: aastore
    //   1675: invokestatic 3153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1678: astore 19
    //   1680: aload_0
    //   1681: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1684: ifnull +225 -> 1909
    //   1687: aload_0
    //   1688: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1691: instanceof 3155
    //   1694: ifeq +215 -> 1909
    //   1697: aload_0
    //   1698: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1701: sipush 1036
    //   1704: aload 19
    //   1706: invokevirtual 3159	com/tencent/av/ui/VideoControlUI:ai	(ILjava/lang/String;)V
    //   1709: aload_0
    //   1710: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1713: ifnull +183 -> 1896
    //   1716: aload_0
    //   1717: invokespecial 317	com/tencent/av/ui/AVActivity:arF	()V
    //   1720: aload 24
    //   1722: getfield 3135	ioa:isRender	Z
    //   1725: ifne +381 -> 2106
    //   1728: aload 24
    //   1730: getfield 3124	ioa:Tp	Z
    //   1733: ifne +373 -> 2106
    //   1736: iload 4
    //   1738: iconst_4
    //   1739: if_icmpeq +337 -> 2076
    //   1742: aload 21
    //   1744: getfield 3162	iiv:relationType	I
    //   1747: iconst_2
    //   1748: if_icmpne +246 -> 1994
    //   1751: aconst_null
    //   1752: ldc_w 813
    //   1755: ldc_w 676
    //   1758: ldc_w 676
    //   1761: ldc_w 3164
    //   1764: ldc_w 3164
    //   1767: iconst_0
    //   1768: iconst_0
    //   1769: ldc_w 676
    //   1772: ldc_w 676
    //   1775: ldc_w 676
    //   1778: ldc_w 676
    //   1781: invokestatic 823	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1784: aload_0
    //   1785: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1788: lload 9
    //   1790: aload 25
    //   1792: iload 5
    //   1794: aload_0
    //   1795: getfield 201	com/tencent/av/ui/AVActivity:bs	Landroid/graphics/Bitmap;
    //   1798: aload 24
    //   1800: getfield 3135	ioa:isRender	Z
    //   1803: aload 24
    //   1805: getfield 3124	ioa:Tp	Z
    //   1808: invokevirtual 3167	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   1811: iload 15
    //   1813: ifne +83 -> 1896
    //   1816: aload 21
    //   1818: getfield 1585	iiv:Qw	Z
    //   1821: ifne +75 -> 1896
    //   1824: ldc_w 3168
    //   1827: fstore_2
    //   1828: fload_2
    //   1829: fstore_1
    //   1830: aload_0
    //   1831: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1834: aload 25
    //   1836: iload 5
    //   1838: invokevirtual 3170	com/tencent/av/ui/VideoLayerUI:i	(Ljava/lang/String;I)Z
    //   1841: ifeq +20 -> 1861
    //   1844: fload_2
    //   1845: fstore_1
    //   1846: aload_0
    //   1847: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1850: invokevirtual 1079	com/tencent/av/ui/VideoLayerUI:lI	()I
    //   1853: iconst_3
    //   1854: if_icmpeq +7 -> 1861
    //   1857: ldc_w 3171
    //   1860: fstore_1
    //   1861: aload_0
    //   1862: invokevirtual 329	com/tencent/av/ui/AVActivity:getApplicationContext	()Landroid/content/Context;
    //   1865: fload_1
    //   1866: invokestatic 3174	jll:dp2px	(Landroid/content/Context;F)F
    //   1869: fstore_1
    //   1870: aload_0
    //   1871: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1874: aload 25
    //   1876: iload 5
    //   1878: aload 20
    //   1880: fload_1
    //   1881: iconst_m1
    //   1882: invokevirtual 3177	com/tencent/av/ui/VideoLayerUI:a	(Ljava/lang/String;ILjava/lang/String;FI)V
    //   1885: aload_0
    //   1886: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   1889: aload 25
    //   1891: iload 5
    //   1893: invokevirtual 3180	com/tencent/av/ui/VideoLayerUI:at	(Ljava/lang/String;I)V
    //   1896: iload_3
    //   1897: iconst_1
    //   1898: iadd
    //   1899: istore_3
    //   1900: goto -416 -> 1484
    //   1903: iconst_0
    //   1904: istore 15
    //   1906: goto -358 -> 1548
    //   1909: aload_0
    //   1910: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   1913: sipush 1036
    //   1916: aload 19
    //   1918: invokestatic 3183	iwu:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1921: pop
    //   1922: goto -213 -> 1709
    //   1925: aload_0
    //   1926: ldc_w 3184
    //   1929: invokevirtual 3149	com/tencent/av/ui/AVActivity:getString	(I)Ljava/lang/String;
    //   1932: iconst_1
    //   1933: anewarray 2461	java/lang/Object
    //   1936: dup
    //   1937: iconst_0
    //   1938: aload 19
    //   1940: aastore
    //   1941: invokestatic 3153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1944: astore 19
    //   1946: aload_0
    //   1947: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1950: ifnull +28 -> 1978
    //   1953: aload_0
    //   1954: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1957: instanceof 3155
    //   1960: ifeq +18 -> 1978
    //   1963: aload_0
    //   1964: getfield 542	com/tencent/av/ui/AVActivity:mControlUI	Lcom/tencent/av/ui/VideoControlUI;
    //   1967: sipush 1037
    //   1970: aload 19
    //   1972: invokevirtual 3159	com/tencent/av/ui/VideoControlUI:ai	(ILjava/lang/String;)V
    //   1975: goto -266 -> 1709
    //   1978: aload_0
    //   1979: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   1982: sipush 1037
    //   1985: aload 19
    //   1987: invokestatic 3183	iwu:a	(Lcom/tencent/av/app/VideoAppInterface;ILjava/lang/String;)Z
    //   1990: pop
    //   1991: goto -282 -> 1709
    //   1994: aload 21
    //   1996: getfield 959	iiv:anb	I
    //   1999: bipush 10
    //   2001: if_icmpne +39 -> 2040
    //   2004: aconst_null
    //   2005: ldc_w 813
    //   2008: ldc_w 676
    //   2011: ldc_w 676
    //   2014: ldc_w 3186
    //   2017: ldc_w 3186
    //   2020: iconst_0
    //   2021: iconst_0
    //   2022: ldc_w 676
    //   2025: ldc_w 676
    //   2028: ldc_w 676
    //   2031: ldc_w 676
    //   2034: invokestatic 823	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2037: goto -253 -> 1784
    //   2040: aconst_null
    //   2041: ldc_w 813
    //   2044: ldc_w 676
    //   2047: ldc_w 676
    //   2050: ldc_w 3188
    //   2053: ldc_w 3188
    //   2056: iconst_0
    //   2057: iconst_0
    //   2058: ldc_w 676
    //   2061: ldc_w 676
    //   2064: ldc_w 676
    //   2067: ldc_w 676
    //   2070: invokestatic 823	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2073: goto -289 -> 1784
    //   2076: aload_0
    //   2077: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2080: lload 9
    //   2082: aload 25
    //   2084: iload 5
    //   2086: aload_0
    //   2087: getfield 203	com/tencent/av/ui/AVActivity:bt	Landroid/graphics/Bitmap;
    //   2090: aload 24
    //   2092: getfield 3135	ioa:isRender	Z
    //   2095: aload 24
    //   2097: getfield 3124	ioa:Tp	Z
    //   2100: invokevirtual 3167	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2103: goto -292 -> 1811
    //   2106: aload_0
    //   2107: getfield 356	com/tencent/av/ui/AVActivity:jdField_b_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   2110: lload 9
    //   2112: aload 25
    //   2114: iload 5
    //   2116: aload_0
    //   2117: getfield 203	com/tencent/av/ui/AVActivity:bt	Landroid/graphics/Bitmap;
    //   2120: aload 24
    //   2122: getfield 3135	ioa:isRender	Z
    //   2125: aload 24
    //   2127: getfield 3124	ioa:Tp	Z
    //   2130: invokevirtual 3167	com/tencent/av/ui/VideoLayerUI:a	(JLjava/lang/String;ILandroid/graphics/Bitmap;ZZ)V
    //   2133: goto -322 -> 1811
    //   2136: aload_0
    //   2137: getfield 195	com/tencent/av/ui/AVActivity:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   2140: sipush 1023
    //   2143: ldc_w 3189
    //   2146: invokestatic 602	iwu:b	(Lcom/tencent/av/app/VideoAppInterface;II)Z
    //   2149: pop
    //   2150: ldc_w 3191
    //   2153: invokestatic 1119	jgx:kw	(Ljava/lang/String;)V
    //   2156: goto -1296 -> 860
    //   2159: invokestatic 931	irk:a	()Lirk;
    //   2162: iconst_1
    //   2163: invokevirtual 3053	irk:resume	(I)V
    //   2166: goto -1221 -> 945
    //   2169: ldc2_w 2637
    //   2172: lstore 7
    //   2174: goto -1199 -> 975
    //   2177: astore 19
    //   2179: goto -1273 -> 906
    //   2182: aload 20
    //   2184: astore 19
    //   2186: goto -533 -> 1653
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2189	0	this	AVActivity
    //   1829	52	1	f1	float
    //   1827	18	2	f2	float
    //   1483	417	3	i	int
    //   1480	260	4	j	int
    //   1519	596	5	k	int
    //   1555	7	6	m	int
    //   973	1200	7	l1	long
    //   8	2103	9	l2	long
    //   948	34	11	l3	long
    //   956	28	13	l4	long
    //   394	1511	15	bool1	boolean
    //   407	1195	16	bool2	boolean
    //   414	70	17	bool3	boolean
    //   421	926	18	bool4	boolean
    //   304	785	19	localObject1	Object
    //   1243	135	19	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1651	335	19	str1	String
    //   2177	1	19	localException	Exception
    //   2184	1	19	localObject2	Object
    //   431	1752	20	str2	String
    //   85	1910	21	localiiv	iiv
    //   165	811	22	localikr	ikr
    //   1458	36	23	localArrayList	ArrayList
    //   1502	624	24	localioa	ioa
    //   1512	601	25	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	79	1243	java/lang/IllegalArgumentException
    //   899	906	2177	java/lang/Exception
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.VE = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSensorEvent != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramSensorEvent.values);
    }
  }
  
  public void onStart()
  {
    iiv localiiv = igv.a().a();
    ikp.r(20, 1L);
    if ((localiiv != null) && (localiiv.isConnected())) {
      ikp.kQ(31);
    }
    this.mIsShadow = false;
    super.onStart();
    mb(1);
    this.VS = false;
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "avideo life_onStart, seq[" + l1 + "]");
    if (this.mControlUI != null) {
      this.mControlUI.cU(l1);
    }
    if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.onStart();
    }
    if ((this.mSessionType != 1) && (this.mSessionType == 2)) {}
    this.mApp.l(new Object[] { Integer.valueOf(7003), this.mPeerUin });
  }
  
  public void onStop()
  {
    long l1 = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onStop, seq[" + l1 + "]");
    super.onStop();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l2 = AudioHelper.elapsedRealtimeNanos();
    this.mIsShadow = false;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) && (this.jdField_a_of_type_Jdh != null))
    {
      this.jdField_a_of_type_Jdh.aur();
      if (this.jdField_a_of_type_Jdh.bR() < 1000L) {
        break label278;
      }
    }
    label278:
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().amW = i;
      anot.a(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      mb(4);
      if (!this.VO) {
        cJ(l1);
      }
      cK(l1);
      long l3 = AudioHelper.elapsedRealtimeNanos();
      this.mApp.l(new Object[] { Integer.valueOf(7001), this.mPeerUin, Boolean.valueOf(this.Ox) });
      cN(l1);
      QLog.w(this.TAG, 1, "avideo life_onStop, mIsMultiFinish[" + this.VO + "], seq[" + l1 + "], cost[" + (l3 - l2) + "]");
      return;
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2)) {
      return;
    }
    mb(4);
    long l1 = AudioHelper.hG();
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "life_onUserLeaveHint, seq[" + l1 + "]");
    }
    cK(l1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "life_onWindowFocusChanged, hasFocus[" + paramBoolean + "], nfonWindowFocus[" + this.VR);
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.VR = false;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new onWindowFocusChangedRunnable(), 500L);
    if (AVReport.a().UN)
    {
      AVReport.a().nn = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().nE = SystemClock.elapsedRealtime();
  }
  
  public String toString()
  {
    return "TAG[" + this.TAG + "], ActivityState[" + lV() + "], isActivityVisible[" + vY() + "], " + super.toString();
  }
  
  void u(String paramString, long paramLong)
  {
    View localView = findViewById(2131374120);
    if (localView == null) {}
    do
    {
      do
      {
        return;
      } while (localView.getVisibility() != 0);
      localView.setVisibility(4);
      QLog.w(this.TAG, 1, "MoreBtnTips. hide_qav_more_tips. from[" + paramString + "], seq[" + paramLong + "]");
    } while (this.jdField_a_of_type_Jkn$a == null);
    jkn.nJ(this.jdField_a_of_type_Jkn$a.id);
    this.jdField_a_of_type_Jkn$a = null;
    this.jdField_c_of_type_ComTencentImageURLDrawable = null;
    this.VQ = false;
  }
  
  boolean vU()
  {
    if (this.mControlUI == null) {}
    while (!this.mControlUI.cu(4)) {
      return false;
    }
    return true;
  }
  
  boolean vV()
  {
    if (isDestroyed()) {}
    do
    {
      do
      {
        return false;
      } while ((this.mControlUI == null) || (this.mControlUI.isDestroyed()));
      if ((this.mControlUI.a.cC(1)) || (this.mControlUI.a.cC(3))) {
        return true;
      }
    } while ((!vU()) && (!this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX()));
    return true;
  }
  
  public boolean vW()
  {
    return this.VU;
  }
  
  boolean vX()
  {
    if (this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
      return this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX();
    }
    return false;
  }
  
  public boolean vY()
  {
    switch (lV())
    {
    case -1: 
    case 0: 
    case 1: 
    case 4: 
    case 5: 
    default: 
      return false;
    }
    return true;
  }
  
  public static class AnimationTrigger
    implements Runnable
  {
    boolean VV = false;
    final int avp = 1000;
    float downX = -1.0F;
    float downY = -1.0F;
    VideoAppInterface mApp = null;
    
    public AnimationTrigger(VideoAppInterface paramVideoAppInterface)
    {
      this.mApp = paramVideoAppInterface;
    }
    
    public void arQ()
    {
      if (QLog.isColorLevel()) {
        QLog.e("AnimationTrigger", 2, "[childLock] requestShowOrHiddenChildLockUI");
      }
      this.mApp.l(new Object[] { Integer.valueOf(119), Integer.valueOf(3) });
    }
    
    public void arR()
    {
      if (QLog.isColorLevel()) {
        QLog.e("AnimationTrigger", 2, "[childLock] requestShowTips");
      }
      this.mApp.l(new Object[] { Integer.valueOf(119), Integer.valueOf(2) });
    }
    
    public void cancel()
    {
      if (QLog.isColorLevel()) {
        QLog.e("AnimationTrigger", 2, "[childLock] cancel animation");
      }
      this.VV = false;
      this.mApp.l(new Object[] { Integer.valueOf(119), Integer.valueOf(0) });
    }
    
    public void run()
    {
      if (this.mApp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AnimationTrigger", 1, "[childLock] trigger animation, isTriggeredAnimation[" + this.VV + "]");
        }
        this.VV = true;
        this.mApp.l(new Object[] { Integer.valueOf(119), Integer.valueOf(1), Float.valueOf(this.downX), Float.valueOf(this.downY) });
      }
    }
    
    public void u(float paramFloat1, float paramFloat2)
    {
      this.downX = paramFloat1;
      this.downY = paramFloat2;
      this.VV = false;
      this.mApp.getHandler().removeCallbacks(this);
      this.mApp.getHandler().postDelayed(this, 1000L);
    }
    
    public boolean vZ()
    {
      return this.VV;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (AVActivity.this.a != null) && (paramContext.equals("homekey")))
        {
          if (AVActivity.this.a.b().amI == 4)
          {
            if (AVActivity.this.mUinType != 3000) {
              break label237;
            }
            if (!AVActivity.this.a.b().PY) {
              break label210;
            }
            anot.a(null, "CliOper", "", "", "0X80041BB", "0X80041BB", 0, 0, "", "", "", "");
          }
          if (AVActivity.this.Td)
          {
            if (!AVActivity.this.a.b().PY) {
              break label424;
            }
            anot.a(null, "CliOper", "", "", "0X8005216", "0X8005216", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        if (AVActivity.a(AVActivity.this) != null) {
          AVActivity.a(AVActivity.this).jd(AVActivity.this.isResume());
        }
        AVActivity.this.a.a("backgroundReason", "1");
        VideoConstants.a.Mm = "1";
        return;
        label210:
        anot.a(null, "CliOper", "", "", "0X80041BE", "0X80041BE", 0, 0, "", "", "", "");
        break;
        label237:
        if (AVActivity.this.mUinType != 1) {
          break;
        }
        if (AVActivity.this.a.b().PY)
        {
          if (AVActivity.this.a.b().anb == 10)
          {
            anot.a(null, "CliOper", "", "", "0X800593E", "0X800593E", 0, 0, "", "", "", "");
            break;
          }
          anot.a(null, "CliOper", "", "", "0X80046E8", "0X80046E8", 0, 0, "", "", "", "");
          break;
        }
        if (!AVActivity.this.a.b().PZ) {
          break;
        }
        if (AVActivity.this.a.b().anb == 10)
        {
          anot.a(null, "CliOper", "", "", "0X8005941", "0X8005941", 0, 0, "", "", "", "");
          break;
        }
        anot.a(null, "CliOper", "", "", "0X80046EB", "0X80046EB", 0, 0, "", "", "", "");
        break;
        label424:
        anot.a(null, "CliOper", "", "", "0X8005219", "0X8005219", 0, 0, "", "", "", "");
      }
    }
  }
  
  public class b
    extends iya
  {
    b() {}
    
    public void C(long paramLong, int paramInt)
    {
      QLog.w(AVActivity.this.TAG, 1, "onNotify_MenuView_Changed, menuType[" + paramInt + "], seq[" + paramLong + "]");
      AVActivity.this.cP(paramLong);
    }
    
    public void K(Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, " onChangeUI_receiveTransferMsg ");
      }
      if (AVActivity.this.mUinType == 9500) {
        if ((paramObject instanceof VcControllerImpl.b))
        {
          paramObject = (VcControllerImpl.b)paramObject;
          if (paramObject.operation != 6) {
            break label329;
          }
          if ((paramObject.apR & 0x1) != 1) {
            break label275;
          }
          if ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI))
          {
            AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OR = true;
            ((DoubleVideoCtrlUI)AVActivity.this.mControlUI).a(2131373949, true, 2130842860);
          }
        }
      }
      label274:
      label275:
      label329:
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
                  break label274;
                  break label274;
                  break label274;
                  break label274;
                  for (;;)
                  {
                    if (((paramObject.apR & 0x4) == 4) && ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI)))
                    {
                      AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OS = true;
                      ((DoubleVideoCtrlUI)AVActivity.this.mControlUI).auS();
                    }
                    if (((paramObject.apR & 0x8) == 8) && ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI)))
                    {
                      AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OT = false;
                      DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)AVActivity.this.mControlUI;
                      AVActivity.this.mApp.getHandler().postDelayed(new AVActivity.MyControlUIObserver.3(this, localDoubleVideoCtrlUI), 500L);
                    }
                    if (((paramObject.apR & 0x2) == 2) && ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI)))
                    {
                      paramObject = (DoubleVideoCtrlUI)AVActivity.this.mControlUI;
                      AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().o(0L, false);
                    }
                    return;
                    if (((paramObject.apR & 0x1) == 0) && ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI)))
                    {
                      AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OR = false;
                      ((DoubleVideoCtrlUI)AVActivity.this.mControlUI).a(2131373949, false, 2130842860);
                    }
                  }
                } while (paramObject.operation != 5);
                if (paramObject.apR != 2) {
                  break;
                }
              } while (!(AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI));
              paramObject = (DoubleVideoCtrlUI)AVActivity.this.mControlUI;
              paramObject.l(2131698123, 2, 0, paramObject.mRes.getDimensionPixelSize(2131299627));
              return;
            } while ((paramObject.apR != 3) || (!(AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI)));
            paramObject = (DoubleVideoCtrlUI)AVActivity.this.mControlUI;
            paramObject.l(2131698122, 1, 0, paramObject.mRes.getDimensionPixelSize(2131299627));
            return;
          } while (!(paramObject instanceof VcControllerImpl.b));
          paramObject = (VcControllerImpl.b)paramObject;
        } while ((paramObject.operation != 11) || (paramObject.apR != 1) || (!(AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI)));
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OU = true;
      } while (!QLog.isColorLevel());
      QLog.d(AVActivity.this.TAG, 2, "receiveTransferMsg xiaowei Device");
    }
    
    public void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
    {
      boolean bool = true;
      if (AVActivity.this.isDestroyed()) {}
      while ((AVActivity.this.mControlUI == null) || (AVActivity.this.mControlUI.isDestroyed())) {
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        AVActivity.this.mControlUI.kq(true);
        AVActivity.this.mControlUI.ast();
      }
      if ((paramBoolean1) && (paramBoolean2)) {
        AVActivity.this.mControlUI.kq(false);
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        AVActivity.this.F(paramLong1, 50L);
        AVActivity.this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong1, AVActivity.this, 2, 2);
      }
      ild.ij(paramBoolean2);
      AVActivity.this.notifyEvent(Integer.valueOf(6503), Boolean.valueOf(paramBoolean2), null);
      AVActivity localAVActivity = AVActivity.this;
      if ((!paramBoolean1) && (!paramBoolean2)) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        localAVActivity.e(paramLong1, "onNotify_SwitchToolbarAnimation", paramBoolean1);
        return;
      }
    }
    
    public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramAVFunChatMessage == null)) {
        if (QLog.isColorLevel()) {
          QLog.i(AVActivity.this.TAG, 2, "onReceiveCreativeCopMsg, invalid params.");
        }
      }
      for (;;)
      {
        return;
        long l1 = AudioHelper.hG();
        int i = paramAVFunChatMessage.enum_operator.get();
        long l2 = paramAVFunChatMessage.uint64_type.get();
        String str = paramAVFunChatMessage.str_msg.get();
        boolean bool = iop.uR();
        if ((l2 == 14L) && (bool))
        {
          if (i != 1) {
            break label336;
          }
          if (!"SUPPORT_CREATIVECOP_TRUE".equals(str)) {
            break label212;
          }
          ((ikt)AVActivity.this.mApp.a(5)).b(3, 14, "SUPPORT_CREATIVECOP_TRUE");
        }
        while (QLog.isColorLevel())
        {
          QLog.i(AVActivity.this.TAG, 2, "onReceiveCreativeCopMsg, fromUin[" + paramString + "], msg[" + paramAVFunChatMessage.uint64_type.get() + ", " + paramAVFunChatMessage.enum_operator.get() + ", " + paramAVFunChatMessage.str_msg.get() + "]");
          return;
          label212:
          if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX())) {
            AVActivity.this.js(false);
          }
          Object localObject;
          if (AVActivity.this.mControlUI != null)
          {
            localObject = AVActivity.this.mControlUI.a();
            if (localObject == null) {
              break label310;
            }
            ((EffectSettingUi)localObject).setSelectedBtn(2);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(str)) {
              break label334;
            }
            new iya.e(l1, str, false, 4).n(AVActivity.this.mApp);
            break;
            label310:
            localObject = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
            if (localObject != null) {
              ((iiv)localObject).ans = 2;
            }
          }
          label334:
          continue;
          label336:
          if (i == 0) {
            AVActivity.this.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(false));
          }
        }
      }
    }
    
    public void arS() {}
    
    public void arT()
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.ko(false);
      }
    }
    
    public void arU()
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.ko(true);
      }
    }
    
    public void arV()
    {
      AVActivity localAVActivity;
      if (AVActivity.this.mControlUI != null)
      {
        localAVActivity = AVActivity.this;
        if (AVActivity.this.mControlUI.wH()) {
          break label42;
        }
      }
      label42:
      for (boolean bool = true;; bool = false)
      {
        localAVActivity.e(-1050L, "onRequest_RefreshRecordBtn", bool);
        return;
      }
    }
    
    public void arW()
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onChangeUI_SmallView_Position_change, seq[" + l + "]");
      }
      if ((AVActivity.this.mControlUI != null) && ((2 == AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().amI) || (AVActivity.this.Td))) {
        AVActivity.this.mControlUI.y(l, "onChangeUI_SmallView_Position_change");
      }
    }
    
    public void arX()
    {
      if (QLog.isColorLevel()) {
        QLog.i(AVActivity.this.TAG, 2, "onChangeUI_quitDoubleScreenStatus");
      }
      AVActivity.this.js(true);
    }
    
    public void arY()
    {
      iwu.b(AVActivity.this.mApp, 1008, 2131697678);
    }
    
    public void arp()
    {
      AVActivity.this.cP(-1032L);
      if ((AVActivity.this.mControlUI != null) && ((2 == AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().amI) || (AVActivity.this.Td)) && (!AVActivity.this.mControlUI.Yg)) {
        AVActivity.this.mControlUI.y(-1032L, "onChangeUI_ShowControlUI");
      }
    }
    
    public void arq()
    {
      if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OQ)
      {
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.OQ = false;
        AVActivity.this.Ox = true;
        AVActivity.this.finish();
      }
    }
    
    public void arr()
    {
      ViewGroup localViewGroup = (ViewGroup)AVActivity.this.findViewById(2131363166);
      if (localViewGroup != null) {
        imr.a(localViewGroup);
      }
    }
    
    public void ars()
    {
      AVActivity localAVActivity = AVActivity.this;
      if (!AVActivity.this.mControlUI.wH()) {}
      for (boolean bool = true;; bool = false)
      {
        localAVActivity.e(-1048L, "onChangeUI_RecordStateChange", bool);
        return;
      }
    }
    
    public void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.c(paramString1, paramInt1, paramString2, paramInt2);
      }
    }
    
    public void bB(ArrayList<ioa> paramArrayList)
    {
      if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
      {
        long l = AudioHelper.hG();
        Object localObject = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.f(paramArrayList);
        if (QLog.isColorLevel()) {
          QLog.w(AVActivity.this.TAG, 1, "onChangeUI_CloseVideo, seq[" + l + "], infoLogs[" + (String)localObject + "]");
        }
        Collections.sort(paramArrayList, new ixn(this));
        int i = 0;
        if (i < paramArrayList.size())
        {
          localObject = (ioa)paramArrayList.get(i);
          String str = jji.al(((ioa)localObject).uin);
          boolean bool2 = ((ioa)localObject).Tp;
          int j = ((ioa)localObject).videoSrcType;
          boolean bool1;
          if (!str.equals(AVActivity.this.mApp.getCurrentAccountUin()))
          {
            if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.i(str, j))
            {
              if ((AVActivity.this.mControlUI != null) && ((AVActivity.this.mControlUI instanceof MultiVideoCtrlLayerUIBase))) {
                AVActivity.this.mControlUI.mX(1037);
              }
              iwu.a(AVActivity.this.mApp, 1037);
            }
            VideoLayerUI localVideoLayerUI = AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI;
            if ((((ioa)localObject).mk == 5L) || (((ioa)localObject).mk == 14L))
            {
              bool1 = true;
              label260:
              localVideoLayerUI.a(l, str, j, false, bool2, bool1);
            }
          }
          label324:
          for (;;)
          {
            i += 1;
            break;
            bool1 = false;
            break label260;
            if (((ioa)localObject).videoSrcType == 2) {}
            for (j = 1;; j = 0)
            {
              if (j == 0) {
                break label324;
              }
              AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(l, false, false);
              break;
            }
          }
        }
        AVActivity.this.arL();
      }
      if (AVActivity.this.jdField_a_of_type_Jfo != null) {
        AVActivity.this.jdField_a_of_type_Jfo.avM();
      }
      if (AVActivity.this.jdField_a_of_type_Jgg != null) {
        AVActivity.this.jdField_a_of_type_Jgg.awa();
      }
    }
    
    public void be(String paramString1, String paramString2)
    {
      if (AVActivity.this.jdField_a_of_type_Jdh != null) {
        AVActivity.this.jdField_a_of_type_Jdh.aM(paramString1, paramString2);
      }
    }
    
    public void cE(long paramLong)
    {
      if (AVActivity.this.isDestroyed()) {}
      iiv localiiv;
      int j;
      String str;
      int k;
      boolean bool;
      do
      {
        return;
        localiiv = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (QLog.isColorLevel()) {
          QLog.w("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + AVActivity.this.mApp.isBackground_Stop + "], ActivityState[" + AVActivity.this.lV() + "], getVideoAbilityLevel[" + AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel() + "], session[" + localiiv + "], seq[" + paramLong + "]");
        }
        j = AVActivity.this.mSessionType;
        str = AVActivity.this.QS;
        k = AVActivity.this.mUinType;
        if ((AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
          AVActivity.this.d(paramLong, "onChangeUI_DobuleAudio2MultiAudio", false);
        }
        if ((localiiv.isRecording) && (AVActivity.this.jdField_a_of_type_Jdh != null)) {
          AVActivity.this.jdField_a_of_type_Jdh.aur();
        }
        if ((localiiv.Qp) || ((AVActivity.this.jdField_a_of_type_Jdh != null) && (AVActivity.this.jdField_a_of_type_Jdh.md() != 1)))
        {
          localiiv.Qp = false;
          AVActivity.this.jdField_a_of_type_Jdh.auE();
        }
        bool = localiiv.PV;
        if (localiiv.switchState != 11) {
          break;
        }
      } while (AVActivity.this.mControlUI == null);
      AVActivity.this.mControlUI.jZ(null);
      return;
      if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
        if ((AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel() != 4) || (!jkn.xG())) {
          break label594;
        }
      }
      long l2;
      label594:
      for (int i = 3;; i = 4)
      {
        AVActivity.this.G(i, false);
        AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, localiiv.peerUin, 1, false, false, false);
        if (AVActivity.this.mControlUI != null)
        {
          AVActivity.this.mControlUI.onDestroy(paramLong);
          AVActivity.this.mControlUI = null;
        }
        AVActivity.this.dX = null;
        AVActivity.this.S("onChangeUI_DobuleAudio2MultiAudio", false);
        AVActivity.this.mSessionType = localiiv.amI;
        if (AVActivity.this.jdField_a_of_type_Ixx != null) {
          AVActivity.this.jdField_a_of_type_Ixx.hide();
        }
        if (!imm.isNormalSharp())
        {
          AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.f(paramLong, true);
          if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
          }
          localiiv.n(paramLong, false);
        }
        imp.a().reset();
        AVActivity.this.A(paramLong, true);
        if (AVActivity.this.mControlUI != null)
        {
          AVActivity.this.mControlUI.cU(paramLong);
          if (AVActivity.this.auG != 4) {
            AVActivity.this.mControlUI.cV(paramLong);
          }
        }
        l2 = Long.valueOf(AVActivity.this.mApp.getCurrentAccountUin()).longValue();
        if (localiiv.peerUin != null) {
          break label599;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
        return;
      }
      label599:
      localiiv.lm = Long.valueOf(localiiv.peerUin).longValue();
      long l1 = localiiv.ll;
      Object localObject2;
      Object localObject1;
      if (localiiv.uinType == 1)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder().append("onChangeUI_DobuleAudio2MultiAudio uinList[");
          if (localiiv.f != null) {
            break label781;
          }
          localObject1 = "null";
          label665:
          QLog.i("double_2_multi", 4, localObject1 + "]");
        }
        localObject1 = localiiv.f;
        localObject2 = new ArrayList();
        i = 0;
        label705:
        if ((localObject1 == null) || (i >= localObject1.length)) {
          break label814;
        }
        if ((localObject1[i] != l2) && (localObject1[i] != localiiv.lm)) {
          break label795;
        }
      }
      for (;;)
      {
        i += 1;
        break label705;
        if (localiiv.uinType != 3000) {
          break;
        }
        localiiv.f = AVActivity.this.mApp.a(String.valueOf(l1));
        break;
        label781:
        localObject1 = Integer.valueOf(localiiv.f.length);
        break label665;
        label795:
        ((ArrayList)localObject2).add(Long.valueOf(localiiv.f[i]));
      }
      label814:
      if (((ArrayList)localObject2).size() > 0)
      {
        i = ((ArrayList)localObject2).size();
        l2 = ((Long)((ArrayList)localObject2).get(0)).longValue();
        int m = jjc.cJ(localiiv.relationType);
        localObject2 = AVActivity.this.mApp.getDisplayName(m, String.valueOf(l2), String.valueOf(localiiv.ll));
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7) {
          localObject1 = ((String)localObject2).substring(0, 6) + "...";
        }
        localObject2 = localObject1;
        if (i > 1) {
          localObject2 = (String)localObject1 + acfp.m(2131702981) + i + acfp.m(2131702980);
        }
        localObject1 = String.format(AVActivity.this.getString(2131698119), new Object[] { localObject2 });
        if (AVActivity.this.mControlUI != null) {
          AVActivity.this.mControlUI.jZ((String)localObject1);
        }
      }
      for (;;)
      {
        if (bool) {
          AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l1, false, false, -1);
        }
        localiiv.ac("onChangeUI_DobuleAudio2MultiAudio", 0);
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.hN(false);
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.hO(false);
        AVActivity.this.mUinType = localiiv.uinType;
        if (AVActivity.this.mSessionType == 4) {
          AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, AVActivity.this.mSessionType, false, false);
        }
        AVActivity.this.QS = String.valueOf(localiiv.ll);
        if (AVActivity.this.jdField_a_of_type_Jgg != null) {
          AVActivity.this.jdField_a_of_type_Jgg.awa();
        }
        QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio end, oldSessionType[" + j + "], oldUinType[" + k + "], oldRelationId[" + str + "], mRelationId[" + AVActivity.this.QS + "], sessionInfo[" + localiiv + "]");
        return;
        if (QLog.isColorLevel()) {
          QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
        }
      }
    }
    
    public void cF(long paramLong)
    {
      iiv localiiv = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting, cur[" + localiiv + "]");
      }
      int i = AVActivity.this.mSessionType;
      String str = AVActivity.this.QS;
      int j = AVActivity.this.mUinType;
      if ((AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
        AVActivity.this.d(paramLong, "onChangeUI_Normal2Meeting", false);
      }
      if ((localiiv.isRecording) && (AVActivity.this.jdField_a_of_type_Jdh != null)) {
        AVActivity.this.jdField_a_of_type_Jdh.aur();
      }
      if ((localiiv.Qp) || ((AVActivity.this.jdField_a_of_type_Jdh != null) && (AVActivity.this.jdField_a_of_type_Jdh.md() != 1)))
      {
        localiiv.Qp = false;
        AVActivity.this.jdField_a_of_type_Jdh.auE();
      }
      boolean bool = localiiv.PV;
      if (localiiv.switchState == 16) {
        if (AVActivity.this.mControlUI != null) {
          AVActivity.this.mControlUI.jZ(null);
        }
      }
      do
      {
        return;
        if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          AVActivity.this.G(4, false);
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, localiiv.peerUin, 1, false, false, false);
        }
        if (AVActivity.this.mControlUI != null)
        {
          AVActivity.this.mControlUI.onDestroy(paramLong);
          AVActivity.this.mControlUI = null;
        }
        AVActivity.this.dX = null;
        AVActivity.this.S("onChangeUI_Normal2Meeting", true);
        if (localiiv.amI == 2)
        {
          localiiv.amI = 1;
          if (QLog.isColorLevel()) {
            QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting video to audio .");
          }
        }
        AVActivity.this.mSessionType = localiiv.amI;
        if (AVActivity.this.mSessionType == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting illegal session type.");
          }
          AVActivity.this.mSessionType = 1;
        }
        if (AVActivity.this.jdField_a_of_type_Ixx != null) {
          AVActivity.this.jdField_a_of_type_Ixx.hide();
        }
        if (!imm.isNormalSharp())
        {
          AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.f(paramLong, true);
          if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
          }
          localiiv.n(paramLong, false);
        }
        imp.a().reset();
        AVActivity.this.A(paramLong, true);
        if (AVActivity.this.mControlUI != null)
        {
          AVActivity.this.mControlUI.cU(paramLong);
          if (AVActivity.this.auG != 4) {
            AVActivity.this.mControlUI.cV(paramLong);
          }
        }
        if (localiiv.peerUin != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
      return;
      long l = localiiv.ll;
      localiiv.lm = Long.valueOf(localiiv.peerUin).longValue();
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.jZ(null);
      }
      if (bool) {
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_Normal2Meeting", l, false, false, -1);
      }
      localiiv.T("AVActivity.onChangeUI_Normal2Meeting", false);
      AVActivity.this.mUinType = localiiv.uinType;
      AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localiiv.amI, false, true);
      if ((localiiv.PY) || (localiiv.Rr)) {
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localiiv.amI, false, false);
      }
      AVActivity.this.QS = String.valueOf(localiiv.ll);
      if (AVActivity.this.jdField_a_of_type_Jgg != null) {
        AVActivity.this.jdField_a_of_type_Jgg.awa();
      }
      QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting end, oldSessionType[" + i + "], oldUinType[" + j + "], oldRelationId[" + str + "], mRelationId[" + AVActivity.this.QS + "], sessionInfo[" + localiiv + "]");
    }
    
    public void cG(long paramLong)
    {
      AVActivity.this.cH(paramLong);
    }
    
    public void cQ(long paramLong)
    {
      jjb.a("switch_camera", "onRequest_SwitchCamera", 3, new Object[] { Long.valueOf(paramLong) });
      if (AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null) {
        AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.cf(paramLong);
      }
    }
    
    public void cR(long paramLong)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.dE(paramLong);
      }
    }
    
    public void cS(long paramLong)
    {
      AVActivity.c(AVActivity.this, paramLong);
    }
    
    public void g(int paramInt1, int paramInt2, String paramString)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.h(paramInt1, paramInt2, paramString);
      }
    }
    
    public void g(long paramLong, ArrayList<ioa> paramArrayList)
    {
      if ((AVActivity.this.auG == 4) || (AVActivity.this.auG == 5) || (AVActivity.this.auG == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d(AVActivity.this.TAG, 2, "onRequest_ShowVideo ignore ");
        }
        return;
      }
      Object localObject = null;
      if (paramArrayList != null) {
        localObject = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.f(paramArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onRequest_ShowVideo, infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
      }
      int k;
      int j;
      ioa localioa;
      String str2;
      int m;
      boolean bool2;
      boolean bool3;
      int i;
      String str1;
      boolean bool1;
      if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
      {
        k = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel();
        Collections.sort(paramArrayList, new ixm(this));
        if (QLog.isColorLevel()) {
          QLog.w(AVActivity.this.TAG, 1, "onRequest_ShowVideo, after sort infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
        }
        j = 0;
        if (j < paramArrayList.size())
        {
          localioa = (ioa)paramArrayList.get(j);
          str2 = jji.al(localioa.uin);
          m = localioa.videoSrcType;
          bool2 = localioa.Tp;
          bool3 = AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.h(str2, m);
          i = jjc.cI(AVActivity.this.mUinType);
          str1 = AVActivity.this.mApp.getDisplayName(i, str2, String.valueOf(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().ll));
          if (!localioa.isRender) {
            break label1324;
          }
          if (!str2.equals(AVActivity.this.mApp.getCurrentAccountUin()))
          {
            localObject = AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI;
            if ((localioa.mk == 5L) || (localioa.mk == 14L))
            {
              bool1 = true;
              label385:
              ((VideoLayerUI)localObject).a(paramLong, str2, m, true, bool2, bool1);
              if ((!bool2) || (localioa.Tr)) {
                break label1324;
              }
              if (jji.length(str1) <= 20) {
                break label1317;
              }
              localObject = jji.subString(str1, 0, 20) + "...";
              label452:
              if (m != 2) {
                break label808;
              }
              localObject = String.format(AVActivity.this.getString(2131697714), new Object[] { localObject });
              if ((AVActivity.this.mControlUI == null) || (!(AVActivity.this.mControlUI instanceof MultiVideoCtrlLayerUIBase))) {
                break label789;
              }
              AVActivity.this.mControlUI.ai(1036, (String)localObject);
              label520:
              i = 0;
            }
          }
        }
      }
      for (;;)
      {
        label523:
        if (i == 0)
        {
          AVActivity.a(AVActivity.this);
          if ((localioa.isRender) || (localioa.Tp)) {
            break label1151;
          }
          if (k == 4) {
            break label1116;
          }
          if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().relationType != 2) {
            break label1026;
          }
          anot.a(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
          label607:
          if (AVActivity.this.bs == null) {
            AVActivity.this.bs = jll.b(AVActivity.this.getApplicationContext(), 2130842983);
          }
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, AVActivity.this.bs, localioa.isRender, localioa.Tp);
        }
        for (;;)
        {
          if ((!bool3) && (!AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().Qw))
          {
            float f2 = 12.0F;
            float f1 = f2;
            if (bool2)
            {
              f1 = f2;
              if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.lI() != 3) {
                f1 = 18.0F;
              }
            }
            f1 = jll.dp2px(AVActivity.this.getApplicationContext(), f1);
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, str1, f1, -1);
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.at(str2, m);
          }
          j += 1;
          break;
          bool1 = false;
          break label385;
          label789:
          iwu.a(AVActivity.this.mApp, 1036, (String)localObject);
          break label520;
          label808:
          localObject = String.format(AVActivity.this.getString(2131697715), new Object[] { localObject });
          if (QLog.isColorLevel()) {
            QLog.d(AVActivity.this.TAG, 1, "onRequest_ShowVideo, will loading name[" + str1 + "]");
          }
          if ((AVActivity.this.mControlUI != null) && ((AVActivity.this.mControlUI instanceof MultiVideoCtrlLayerUIBase)))
          {
            AVActivity.this.mControlUI.ai(1037, (String)localObject);
            break label520;
          }
          iwu.a(AVActivity.this.mApp, 1037, (String)localObject);
          break label520;
          if ((str2.equals(AVActivity.this.mApp.getCurrentAccountUin())) && (m == 2)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label994;
            }
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, true, bool2);
            i = 0;
            break;
          }
          label994:
          AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ca(paramLong);
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool2);
          i = 1;
          break label523;
          label1026:
          if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10)
          {
            anot.a(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
            break label607;
          }
          anot.a(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
          break label607;
          label1116:
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, AVActivity.this.bt, localioa.isRender, localioa.Tp);
          continue;
          label1151:
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, AVActivity.this.bt, localioa.isRender, localioa.Tp);
        }
        AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.F(AVActivity.this.auI, false);
        if (AVActivity.this.mControlUI != null) {
          AVActivity.this.mControlUI.E(paramLong, AVActivity.this.auI);
        }
        if ((AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().anb != 2)) {
          AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.setRotation(AVActivity.this.auI);
        }
        if (AVActivity.this.jdField_a_of_type_Jfo != null) {
          AVActivity.this.jdField_a_of_type_Jfo.avM();
        }
        if (AVActivity.this.jdField_a_of_type_Jgg == null) {
          break;
        }
        AVActivity.this.jdField_a_of_type_Jgg.awa();
        return;
        label1317:
        localObject = str1;
        break label452;
        label1324:
        i = 0;
      }
    }
    
    public void jM(String paramString)
    {
      if (paramString != null)
      {
        if (!paramString.equals("1")) {
          break label63;
        }
        if (!AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().QG)
        {
          AVActivity.this.jO(null);
          if (!AVActivity.this.isResume()) {
            AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().hX(false);
          }
        }
      }
      label63:
      while (!paramString.startsWith("START")) {
        return;
      }
      paramString = paramString.substring("START_".length());
      AVActivity.this.jO(paramString);
    }
    
    public void jQ(String paramString)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.kh(paramString);
      }
    }
    
    public void jR(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, "onChangeUI_NotifyChangedZimuPeer id=" + paramString);
      }
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("SUPPORT"))) {
        mf(2);
      }
    }
    
    public void ju(boolean paramBoolean) {}
    
    public void jv(boolean paramBoolean)
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onChangeUI_ChildLockStateChange, lock[" + paramBoolean + "], seq[" + l + "]");
      }
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.O(l, 2048);
      }
      if ((AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (AVActivity.this.jdField_a_of_type_Jdh != null)) {
        AVActivity.this.jdField_a_of_type_Jdh.auF();
      }
    }
    
    public void mc(int paramInt) {}
    
    public void md(int paramInt)
    {
      AVActivity.this.ma(paramInt);
    }
    
    public void me(int paramInt)
    {
      int i = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
      if ((i == 1) || (i == 3)) {}
      while ((AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().ta()) || ((AVActivity.this.jdField_a_of_type_Ixx != null) && (AVActivity.this.jdField_a_of_type_Ixx.isShown())) || (AVActivity.this.mControlUI == null)) {
        return;
      }
      if ((AVActivity.this.jdField_a_of_type_Ixx == null) && ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI))) {
        AVActivity.this.jdField_a_of_type_Ixx = new ixx(AVActivity.this.mApp, AVActivity.this, AVActivity.this.mControlUI, (RelativeLayout)AVActivity.a(AVActivity.this, 2131373960));
      }
      if ((AVActivity.this.jdField_a_of_type_Ixx != null) && (AVActivity.this.jdField_a_of_type_Ixx.wa()))
      {
        AVActivity.this.jdField_a_of_type_Ixx.show();
        anot.a(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
        return;
      }
      AVActivity.this.mControlUI.mk(paramInt);
    }
    
    public void mf(int paramInt)
    {
      if (AVActivity.this.jdField_a_of_type_Jdh != null) {
        AVActivity.this.jdField_a_of_type_Jdh.mW(paramInt);
      }
    }
    
    public void mg(int paramInt)
    {
      boolean bool2 = true;
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onChangeUI_MagicFacePlayStateChange, state[" + paramInt + "], seq[" + l + "]");
      }
      AVActivity localAVActivity;
      if (AVActivity.this.mControlUI != null)
      {
        localAVActivity = AVActivity.this;
        if (!AVActivity.this.mControlUI.wH())
        {
          bool1 = true;
          localAVActivity.e(l, "onChangeUI_MagicFacePlayStateChange", bool1);
        }
      }
      else
      {
        if ((AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (AVActivity.this.jdField_a_of_type_Jdh != null)) {
          AVActivity.this.jdField_a_of_type_Jdh.auF();
        }
        localAVActivity = AVActivity.this;
        if (paramInt != 5) {
          break label169;
        }
      }
      label169:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localAVActivity.jo(bool1);
        return;
        bool1 = false;
        break;
      }
    }
    
    public void o(boolean paramBoolean, long paramLong)
    {
      if (AVActivity.this.auG == 4) {}
      do
      {
        return;
        if (AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null) {
          AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ca(paramLong);
        }
        if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          boolean bool = paramBoolean;
          if (!paramBoolean) {
            bool = jik.b(AVActivity.this.mApp, "onRequest_OpenCamera");
          }
          AVActivity.a(AVActivity.this);
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool);
          if ((AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) && (!AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().Qw))
          {
            String str1 = AVActivity.this.mApp.getCurrentAccountUin();
            int i = jjc.cI(AVActivity.this.mUinType);
            String str2 = AVActivity.this.mApp.getDisplayName(i, str1, String.valueOf(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().ll));
            float f = 12.0F;
            if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.i(str1, 1)) {
              f = 18.0F;
            }
            f = jll.dp2px(AVActivity.this.getApplicationContext(), f);
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, AVActivity.this.bt, true, true);
          }
        }
      } while (AVActivity.this.jdField_a_of_type_Jgg == null);
      AVActivity.this.jdField_a_of_type_Jgg.awa();
    }
    
    public void t(long paramLong, int paramInt1, int paramInt2)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.u(paramLong, paramInt1, paramInt2);
      }
    }
    
    public void w(int paramInt, long paramLong)
    {
      if ((AVActivity.this.mControlUI == null) || (AVActivity.this.isDestroyed())) {}
      do
      {
        return;
        QLog.w(AVActivity.this.TAG, 1, "OnNotify_Effect_Toolbar_Selected, btnId[" + paramInt + "], seq[" + paramLong + "]");
        if (paramInt == 100) {
          AVActivity.this.mControlUI.a.c(paramLong, 0, true);
        }
        if (paramInt != 4) {
          break;
        }
        bool = iju.isSupport(AVActivity.this.getBaseContext());
        iju.a.jdMethod_if(bool);
      } while (!bool);
      if (AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null) {
        AVActivity.this.arK();
      }
      if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.lI() != 3) && (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.lI() != 4)) {
        AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.kn("onChangeUI_EffectToolbarSelected");
      }
      boolean bool = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().PT;
      AVActivity.this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.N(AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX(), bool);
      ThreadManager.getUIHandler().post(new AVActivity.MyControlUIObserver.4(this));
      return;
      AVActivity.this.arL();
    }
    
    public void x(int paramInt, long paramLong)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomUtil", 4, "onNotify_ChatRoom_InputPanelChange, lastPanelState[" + paramInt + "], seq[" + paramLong + "]");
      }
      AVActivity.this.B(paramLong, 1);
    }
  }
  
  class c
    extends iiz
  {
    c() {}
    
    public void G(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.G(paramBoolean1, paramBoolean2);
      }
    }
    
    public void T(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onGroundGlassSwitch, fromUin[" + paramString + "], nOff[" + paramInt + "], mSessionType[" + AVActivity.this.mSessionType + "]");
      }
      if ((2 == AVActivity.this.mSessionType) && (AVActivity.this.mControlUI != null)) {
        AVActivity.this.mControlUI.ct(paramInt);
      }
    }
    
    public void U(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, "onGroundGlassWaitTimeChange : nTime=" + paramInt);
      }
      if ((2 == AVActivity.this.mSessionType) && (AVActivity.this.mControlUI != null)) {
        AVActivity.this.mControlUI.mm(paramInt);
      }
    }
    
    public void U(String paramString, boolean paramBoolean)
    {
      if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      long l;
      iiv localiiv;
      int i;
      label339:
      String str;
      do
      {
        do
        {
          for (;;)
          {
            return;
            l = AudioHelper.hG();
            localiiv = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
            igd.aK(AVActivity.this.TAG, "onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + AVActivity.this.mPeerUin + "], mIsDoubleVideoMeeting[" + AVActivity.this.Td + "], mSessionType[" + AVActivity.this.mSessionType + "], mSessionId[" + AVActivity.this.mSessionId + "], mRelationId[" + AVActivity.this.QS + "], seq[" + l + "], \nsession[" + localiiv + "]");
            if ((AVActivity.this.mSessionType != 1) && (AVActivity.this.mSessionType != 2)) {
              break;
            }
            if ((AVActivity.this.mPeerUin != null) && (paramString != null) && (AVActivity.this.mPeerUin.equals(paramString)))
            {
              AVActivity.this.Ox = paramBoolean;
              igd.aK(AVActivity.this.TAG, "onDestroyUI exit 1");
              AVActivity.this.finish();
              AVActivity.this.jm(true);
              if (paramBoolean) {
                break label339;
              }
              i = ivv.cu(localiiv.anh);
              AVActivity.this.overridePendingTransition(0, i);
            }
            while (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
            {
              paramString = aqmj.j(AVActivity.this.getApplicationContext()).edit();
              paramString.putInt("video_position", AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.getPosition());
              paramString.commit();
              jjk.nF(AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.getPosition());
              return;
              AVActivity.this.overridePendingTransition(0, 2130772238);
            }
          }
        } while ((AVActivity.this.mSessionType != 3) && (AVActivity.this.mSessionType != 4));
        str = AVActivity.this.QS;
      } while (((str == null) || (paramString == null) || (!str.equals(paramString))) && ((!AVActivity.this.Td) || (!TextUtils.equals(AVActivity.this.mPeerUin, paramString))));
      AVActivity.this.Ox = paramBoolean;
      igd.aK(AVActivity.this.TAG, "onDestroyUI exit 2");
      AVActivity.this.cJ(l);
      AVActivity.this.VO = true;
      AVActivity.this.finish();
      AVActivity.this.jm(true);
      if (!paramBoolean)
      {
        i = ivv.cu(localiiv.anh);
        AVActivity.this.overridePendingTransition(0, i);
        return;
      }
      AVActivity.this.overridePendingTransition(0, 2130772238);
    }
    
    public void V(String paramString, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i(AVActivity.this.TAG, 2, "onPeerSwitchTerminal, bStartSwitch[" + paramBoolean + "]");
      }
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.V(paramString, paramBoolean);
      }
      ZimuToolbar.sendSupportionToPeer(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController);
      if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().PZ))
      {
        paramString = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
        paramBoolean = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.cl(AVActivity.this.mPeerUin);
        AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.aa(paramString, paramBoolean);
      }
      jdh.b(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController);
      boolean bool;
      if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramBoolean = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording;
        bool = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().Qp;
        if (QLog.isColorLevel()) {
          QLog.d(AVActivity.this.TAG, 2, "onPeerSwitchTerminal, recording=" + paramBoolean + ", beenRecorded=" + bool);
        }
        if (!paramBoolean) {
          break label307;
        }
        if (AVActivity.this.jdField_a_of_type_Jdh != null) {
          AVActivity.this.jdField_a_of_type_Jdh.aur();
        }
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.ama();
      }
      for (;;)
      {
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().Qo = false;
        if (AVActivity.this.jdField_a_of_type_Jdh != null) {
          AVActivity.this.jdField_a_of_type_Jdh.auF();
        }
        return;
        label307:
        if ((bool) && (AVActivity.this.jdField_b_of_type_Iya != null)) {
          AVActivity.this.jdField_b_of_type_Iya.be("self", String.valueOf(3));
        }
      }
    }
    
    public void a(long paramLong, String paramString, boolean paramBoolean)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.f(paramLong, paramString, paramBoolean);
      }
    }
    
    @TargetApi(21)
    public void a(VideoConstants.EmShareState paramEmShareState, int paramInt1, int paramInt2, long paramLong, int paramInt3)
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 2, "onShareStateChange, shareState[" + paramEmShareState + "], shareType[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong + "], multiAvType[" + paramInt3 + "], seq[" + l + "]");
      }
      paramEmShareState = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController;
      if (paramEmShareState == null)
      {
        QLog.i("AVShare", 1, "onShareStateChange, ctrl is null.");
        return;
      }
      paramEmShareState = paramEmShareState.b();
      if ((paramEmShareState.relationType != paramInt2) || (paramEmShareState.ll != paramLong))
      {
        QLog.i("AVShare", 1, "onShareStateChange, not same session");
        return;
      }
      if (paramInt1 == 1)
      {
        if (paramEmShareState.a != VideoConstants.EmShareState.START_FAIL) {
          break label229;
        }
        jds localjds = AVActivity.this.a();
        if (localjds != null) {
          localjds.stop(3);
        }
      }
      for (;;)
      {
        if (paramEmShareState.a == VideoConstants.EmShareState.STOP_SUC) {
          AVActivity.this.mControlUI.dy(l);
        }
        AVActivity.this.runOnUiThread(new AVActivity.MyVideoObserver.1(this));
        return;
        label229:
        if (paramEmShareState.a == VideoConstants.EmShareState.START_SUC)
        {
          AVActivity.this.mControlUI.dx(l);
          jll.kQ("0x800AD8F");
        }
      }
    }
    
    public void a(RecvMsg paramRecvMsg)
    {
      super.a(paramRecvMsg);
      if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController != null))
      {
        AVActivity.this.cP(-1033L);
        AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
        int i = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
        if ((i == 1) || (i == 2))
        {
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.kD(false);
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.nd(2);
        }
      }
      else
      {
        return;
      }
      AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.kD(true);
      AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.nd(1);
    }
    
    public void aR(String paramString1, String paramString2)
    {
      super.aR(paramString1, paramString2);
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.aR(paramString1, paramString2);
      }
    }
    
    public void amT()
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onPauseVideo, begin, seq[" + l + "]");
      }
      if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      for (;;)
      {
        return;
        iiv localiiv = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          String str = localiiv.peerUin;
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(l, str, 1, false, false, AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.cl(AVActivity.this.mPeerUin));
          if (!localiiv.ti()) {
            AVActivity.this.G(1, false);
          }
        }
        if (AVActivity.this.mControlUI != null)
        {
          AVActivity.this.mControlUI.amT();
          AVActivity.this.mControlUI.O(l, 65535);
        }
        if (AVActivity.this.jdField_a_of_type_Jci != null) {
          AVActivity.this.jdField_a_of_type_Jci.atC();
        }
        if (AVActivity.this.jdField_a_of_type_Jfo != null) {
          AVActivity.this.jdField_a_of_type_Jfo.avM();
        }
        boolean bool5;
        if ((AVActivity.this.jdField_a_of_type_ComTencentAvVideoController != null) && (AVActivity.this.jdField_a_of_type_Jdh != null) && (AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null))
        {
          boolean bool1 = localiiv.Qh;
          boolean bool2 = AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ar(l);
          boolean bool3 = localiiv.PZ;
          boolean bool4 = localiiv.isRecording;
          bool5 = localiiv.Qp;
          QLog.w(AVActivity.this.TAG, 1, "onPauseVideo, hangup[" + bool1 + "], cameraOpen[" + bool2 + "], remoteHasVideo[" + bool3 + "], recording[" + bool4 + "], recordedByOther[" + bool5 + "]");
          if ((bool1) || (!bool3))
          {
            if (!bool4) {
              break label452;
            }
            AVActivity.this.jdField_a_of_type_Jdh.aur();
            AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.ama();
            if (!bool1)
            {
              jgx.kw("0X8008ACB");
              if (AVActivity.this.mApp != null) {
                iwu.b(AVActivity.this.mApp, 1023, 2131697980);
              }
            }
          }
        }
        while (AVActivity.this.jdField_a_of_type_Jgg != null)
        {
          AVActivity.this.jdField_a_of_type_Jgg.awa();
          return;
          label452:
          if (bool5) {
            AVActivity.this.jdField_a_of_type_Jdh.auE();
          }
        }
      }
    }
    
    public void amU()
    {
      super.amU();
      if (AVActivity.this.mControlUI != null)
      {
        AVActivity.this.mControlUI.kp(true);
        AVActivity.this.mControlUI.amU();
      }
    }
    
    public void amV()
    {
      super.amV();
      if (AVActivity.this.mControlUI != null)
      {
        AVActivity.this.mControlUI.kp(false);
        AVActivity.this.mControlUI.amV();
      }
    }
    
    public void amW()
    {
      super.amW();
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.amW();
      }
    }
    
    public void amY()
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, "onNeedShowPeerVideo, mIsDoubleVideoMeeting[" + AVActivity.this.Td + "], mPeerUin" + AVActivity.this.mPeerUin + "]");
      }
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.amY();
      }
    }
    
    public void amZ()
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.amZ();
      }
    }
    
    public void ana()
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.ana();
      }
    }
    
    public void b(long paramLong, String paramString, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(AVActivity.this.TAG, 1, "onCloseSessionFinished, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], seq[" + paramLong + "]");
      }
      if (paramString.equals(AVActivity.this.mPeerUin)) {
        TraeHelper.a().b(paramLong, "DEVICE_SPEAKERPHONE");
      }
      if ((AVActivity.this.jdField_a_of_type_Jdh != null) && (AVActivity.this.jdField_a_of_type_Jdh.md() != 1)) {
        AVActivity.this.jdField_a_of_type_Jdh.auE();
      }
    }
    
    public void b(String paramString, long paramLong, byte[] paramArrayOfByte)
    {
      int i = 2;
      int m = (int)(0x3 & paramLong);
      int j = (int)(paramLong >> 4 & 0x7);
      int k = (int)(paramLong >> 7 & 0x7);
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, String.format("onNetLevel_S2C, peerUin[%s], level[%s], detail[%s], netLevel[%s], s2cSelfNetLevel[%s], s2cPeerNetLevel[%s]", new Object[] { paramString, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
      }
      if (AVActivity.this.mControlUI != null) {
        switch (m)
        {
        default: 
          i = -1;
        }
      }
      for (;;)
      {
        paramString = null;
        if (paramArrayOfByte != null) {
          paramString = new String(paramArrayOfByte);
        }
        AVActivity.this.mControlUI.e(i, j, k, paramString);
        return;
        i = 3;
        continue;
        i = 1;
      }
    }
    
    public void bQ(long paramLong)
    {
      AudioHelper.rw(AVActivity.this.TAG + ".onConnected");
      iiv localiiv = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
      ikp.kQ(31);
      String str1 = localiiv.peerUin;
      String str2 = AVActivity.this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("onConnected, mVideoLayerUI[");
      boolean bool;
      if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        bool = true;
        QLog.w(str2, 1, bool + "], peerUin[" + str1 + "], mShutCamera[" + AVActivity.this.VD + "], SessionType[" + localiiv.amI + "], seq[" + paramLong + "]");
        if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.avB();
        }
        if ((localiiv.amI != 2) && (localiiv.amI != 4)) {
          break label560;
        }
        AVActivity.this.jm(false);
        AVActivity.this.jq(false);
      }
      for (;;)
      {
        if (localiiv.amI == 2)
        {
          if (AVActivity.this.VD)
          {
            localiiv.n(paramLong, false);
            AVActivity.this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
          }
          if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
          {
            str1 = localiiv.peerUin;
            bool = localiiv.PZ;
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, bool, false, AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.cl(AVActivity.this.mPeerUin));
          }
        }
        if (localiiv.amI == 1) {
          localiiv.n(paramLong, false);
        }
        AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.bA(paramLong);
        AVActivity.this.cP(paramLong);
        if (AVActivity.this.mApp.isBackground_Stop) {
          AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.alx();
        }
        if (AVActivity.this.mControlUI != null)
        {
          AVActivity.this.mControlUI.bQ(paramLong);
          if ((2 == localiiv.amI) || (AVActivity.this.Td)) {
            AVActivity.this.mControlUI.y(paramLong, "onConnected");
          }
        }
        if (AVActivity.this.mControlUI != null) {
          AVActivity.this.mControlUI.auX();
        }
        ZimuToolbar.sendSupportionToPeer(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController);
        imp.a().aoj();
        jdh.b(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController);
        AVActivity.this.mApp.getHandler().postDelayed(AVActivity.this.bH, 200L);
        AVActivity.this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, AVActivity.this, 4, 0);
        AVActivity.this.F(paramLong, 2000L);
        if (AVActivity.this.jdField_a_of_type_Jgg != null) {
          AVActivity.this.jdField_a_of_type_Jgg.awa();
        }
        return;
        bool = false;
        break;
        label560:
        AVActivity.this.jm(true);
        AVActivity.this.jq(true);
      }
    }
    
    public void bR(long paramLong)
    {
      String str = AVActivity.this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("onResumeVideo, mIsDoubleVideoMeeting[").append(AVActivity.this.Td).append("], mVideoLayerUI[");
      if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.w(str, 1, bool + "], isResume[" + AVActivity.this.isResume() + "], seq[" + paramLong + "]");
        if (AVActivity.this.mControlUI != null) {
          AVActivity.this.mControlUI.asq();
        }
        AVActivity.a(AVActivity.this);
        if ((AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (AVActivity.this.isResume()))
        {
          str = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, 1, true, false, AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.cl(AVActivity.this.mPeerUin));
          AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin, 1, AVActivity.this.bt, true, false);
        }
        if ((AVActivity.this.mControlUI != null) && ((2 == AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().amI) || (AVActivity.this.Td))) {
          AVActivity.this.mControlUI.y(paramLong, "onResumeVideo");
        }
        if (AVActivity.this.jdField_a_of_type_Jfo != null) {
          AVActivity.this.jdField_a_of_type_Jfo.avM();
        }
        if (AVActivity.this.jdField_a_of_type_Jgg != null) {
          AVActivity.this.jdField_a_of_type_Jgg.awa();
        }
        return;
      }
    }
    
    public void bt(int paramInt1, int paramInt2)
    {
      if (AVActivity.this.jdField_a_of_type_Jci != null) {
        AVActivity.this.jdField_a_of_type_Jci.bt(paramInt1, paramInt2);
      }
    }
    
    public void bv(int paramInt1, int paramInt2)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.bv(paramInt1, paramInt2);
      }
    }
    
    public void c(long paramLong, int paramInt, String paramString)
    {
      QLog.w(AVActivity.this.TAG, 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + AVActivity.this.mPeerUin + "], seq[" + paramLong + "]");
      if ((paramString != null) && (!jll.equals(paramString, AVActivity.this.mPeerUin))) {
        return;
      }
      if ((paramInt == 49) && (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController != null) && (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) && (AVActivity.this.jdField_a_of_type_Jdh != null)) {
        AVActivity.this.jdField_a_of_type_Jdh.aur();
      }
      if ((AVActivity.this.jdField_a_of_type_Ixx != null) && (AVActivity.this.jdField_a_of_type_Ixx.isShown())) {
        AVActivity.this.jdField_a_of_type_Ixx.hide();
      }
      if ((AVActivity.this.mControlUI != null) && ((AVActivity.this.mControlUI instanceof DoubleVideoCtrlUI))) {
        AVActivity.this.mControlUI.D(paramLong, paramInt);
      }
      igd.aJ(AVActivity.this.TAG, "DataReport onClose: ");
      ikl.a.a(AVActivity.this.TAG, AVActivity.this.mApp);
      ilg.a.h(AVActivity.this.mApp);
      iju.a.c(AVActivity.this.mApp);
      BeautyToolbar.a.jS(AVActivity.this.mApp.getCurrentAccountUin());
      jfq.f(AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b());
      anon.v(AVActivity.this.mApp);
      paramString = AVActivity.this.mApp.b().getChatRoomId(AVActivity.this.mApp.b().b().peerUin) + "";
      ijw.a(AVActivity.this.mApp, paramString);
      ijw.Z(2, paramString);
      ijw.stop(2);
      AVActivity.this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, AVActivity.this, 3, 2);
    }
    
    public void f(String paramString, Bitmap paramBitmap)
    {
      if ((AVActivity.this.mUinType == 25) && (AVActivity.this.mControlUI != null)) {
        AVActivity.this.mControlUI.i(paramString, paramBitmap);
      }
      super.f(paramString, paramBitmap);
    }
    
    @TargetApi(17)
    public void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, "onRecvAudioFrame=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
      }
    }
    
    public void hF(boolean paramBoolean)
    {
      super.hF(paramBoolean);
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.hF(paramBoolean);
      }
    }
    
    public void i(int paramInt1, long paramLong, int paramInt2) {}
    
    public void iB(String paramString)
    {
      AVActivity.a(AVActivity.this, paramString);
    }
    
    public void iC(String paramString)
    {
      AVActivity.a(AVActivity.this, paramString);
    }
    
    public void iD(String paramString)
    {
      super.iD(paramString);
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.iD(paramString);
      }
    }
    
    public void in(String paramString)
    {
      if ((AVActivity.this.mUinType == 25) && (AVActivity.this.mControlUI != null)) {
        AVActivity.this.mControlUI.jY(paramString);
      }
      super.in(paramString);
    }
    
    public void j(long paramLong1, long paramLong2, long paramLong3)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.m(paramLong1, paramLong2, paramLong3);
      }
    }
    
    public void k(long paramLong1, long paramLong2, long paramLong3)
    {
      if (AVActivity.this.jdField_a_of_type_Jci != null) {
        AVActivity.this.jdField_a_of_type_Jci.l(paramLong1, paramLong2, paramLong3);
      }
    }
    
    public void kJ(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVActivity.this.TAG, 2, "yiler onPlayAnnimate receive id:" + paramInt);
      }
      int i = aqwu.getResourceType();
      String str = aqwu.a(AVActivity.this.mApp, paramInt, i, null);
      if (str == null) {}
      do
      {
        return;
        File localFile = new File(str);
        if ((localFile != null) && (localFile.exists()) && (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().state != 4) && (AVActivity.this.mSessionType == 1) && (AVActivity.this.dX != null) && (AVActivity.this.dX.getParent() != null))
        {
          if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
            AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.avC();
          }
          if (AVActivity.this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
            AVActivity.this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = aqwu.a((Activity)AVActivity.this.mActivity.get(), (RelativeLayout)AVActivity.this.dX.getParent(), false);
          }
          if (!aqwu.a(AVActivity.this.mApp.getApp().getApplicationContext(), AVActivity.this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, AVActivity.this.jdField_a_of_type_Aqxa, paramInt, false)) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d(AVActivity.this.TAG, 2, "yiler onPlayAnnimate finish id:" + paramInt);
    }
    
    public void kn(int paramInt)
    {
      super.kn(paramInt);
      if (AVActivity.this.mControlUI != null)
      {
        AVActivity.this.mControlUI.cv(paramInt);
        if (paramInt == 0) {
          AVActivity.this.mControlUI.kr(true);
        }
      }
      else
      {
        return;
      }
      AVActivity.this.mControlUI.kr(false);
    }
    
    public void kt(int paramInt)
    {
      if (AVActivity.this.jdField_a_of_type_Jci != null) {
        AVActivity.this.jdField_a_of_type_Jci.kt(paramInt);
      }
    }
    
    public void m(long paramLong, int paramInt1, int paramInt2)
    {
      if (AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null) {
        AVActivity.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.b("AVnotify", paramLong, paramInt1, paramInt2);
      }
    }
    
    public void onFinish(String paramString, boolean paramBoolean)
    {
      igd.aK(AVActivity.this.TAG, "onFinish peerUin = " + paramString + " # isQuit :" + paramBoolean + "|" + AVActivity.this.mSessionType + "|" + AVActivity.this.mPeerUin);
      if ((AVActivity.this.mSessionType == 1) || (AVActivity.this.mSessionType == 2)) {
        if ((AVActivity.this.mPeerUin != null) && (paramString != null) && (AVActivity.this.mPeerUin.equals(paramString)))
        {
          AVActivity.this.Ox = paramBoolean;
          AVActivity.this.finish();
          if (paramBoolean) {
            break label260;
          }
          int j = 2130772209;
          int i = j;
          if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController != null)
          {
            paramString = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b();
            i = j;
            if (paramString != null) {
              i = ivv.cu(paramString.anh);
            }
          }
          AVActivity.this.overridePendingTransition(0, i);
        }
      }
      for (;;)
      {
        if (AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          paramString = aqmj.j(AVActivity.this.getApplicationContext()).edit();
          paramString.putInt("video_position", AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.getPosition());
          paramString.commit();
          jjk.nF(AVActivity.this.jdField_b_of_type_ComTencentAvUiVideoLayerUI.getPosition());
        }
        return;
        label260:
        AVActivity.this.overridePendingTransition(0, 2130772238);
      }
    }
    
    public void onServiceConnected()
    {
      super.onServiceConnected();
      if (AVActivity.this.mControlUI != null)
      {
        AVActivity.this.mControlUI.refreshUI();
        AVActivity.this.mControlUI.onServiceConnected();
      }
      if (AVActivity.this.mApp != null)
      {
        if (AVActivity.this.mPeerUin != null) {
          AVActivity.this.mApp.h(AVActivity.this.mUinType, AVActivity.this.mPeerUin, AVActivity.this.OD);
        }
        if (AVActivity.this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          AVActivity.this.mBindType = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().bindType;
          AVActivity.this.mBindId = AVActivity.this.jdField_a_of_type_ComTencentAvVideoController.b().MX;
        }
        if (QLog.isColorLevel()) {
          QLog.d(AVActivity.this.TAG, 2, "setBindInfo: mBindType = " + AVActivity.this.mBindType + ",mBindId = " + AVActivity.this.mBindId);
        }
        AVActivity.this.mApp.U(AVActivity.this.mBindType, AVActivity.this.mBindId);
      }
      if (AVActivity.this.c == null) {
        AVActivity.b(AVActivity.this);
      }
    }
    
    public void onServiceDisconnected()
    {
      super.onServiceDisconnected();
    }
    
    public void q(long paramLong, boolean paramBoolean)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.q(paramLong, paramBoolean);
      }
    }
    
    public void r(long paramLong, int paramInt)
    {
      if (AVActivity.this.mControlUI != null) {
        AVActivity.this.mControlUI.r(paramLong, paramInt);
      }
    }
  }
  
  class d
    extends ixr
  {
    public d(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void E(int paramInt, boolean paramBoolean)
    {
      long l = AudioHelper.hG();
      if (AVActivity.this.auI != paramInt)
      {
        QLog.d(AVActivity.this.TAG, 1, "onVideoOrientationChanged, mRotationAngle[" + AVActivity.this.auI + "->" + paramInt + "], seq[" + l + "], isFinishing[" + AVActivity.this.isFinishing() + "]");
        if (AudioHelper.isDev())
        {
          Display localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
          QLog.w(AVActivity.this.TAG, 1, "onVideoOrientationChanged, Display.getRotation[" + localDisplay.getRotation() + "], seq[" + l + "]");
        }
      }
      if (AVActivity.this.isFinishing()) {
        return;
      }
      switch (paramInt)
      {
      default: 
        AVActivity.this.a(l, 270, paramBoolean);
        return;
      }
      AVActivity.this.a(l, paramInt, paramBoolean);
    }
  }
  
  class onWindowFocusChangedRunnable
    implements Runnable
  {
    onWindowFocusChangedRunnable() {}
    
    public void run()
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(AVActivity.this.TAG, 4, "onWindowFocusChangedRunnable, nfonWindowFocus[" + AVActivity.this.VR + "->true]");
      }
      AVActivity.this.VR = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */