package com.tencent.mobileqq.activity.richmedia;

import aapr;
import aaps;
import aapt;
import aapu;
import aapv;
import aapw;
import aapx;
import aapy;
import aapz;
import aaqb;
import aaqc;
import aaqd;
import aaqe;
import aaqf;
import aaqg;
import aaqh;
import aaqi;
import aaqj;
import aaqk;
import aaql;
import aaqm;
import aasa;
import aasx;
import aatc;
import aate;
import aate.a;
import aatf;
import acfp;
import alvp;
import alvs;
import alvv;
import alyr;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anhm;
import anhz;
import ania;
import anid;
import anih;
import anii;
import anij;
import anil;
import anil.a;
import anim;
import aniq;
import aniv;
import aniw;
import ankt;
import anlc;
import anpc;
import aqft;
import aqip;
import aqiw;
import aqju;
import auri;
import ausj;
import avzl;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.a;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.b;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.b;
import com.tencent.mobileqq.shortvideo.widget.SimpleProgressBar;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar.b;
import com.tencent.mobileqq.widget.HorizontalItemIndicator;
import com.tencent.mobileqq.widget.TransCircleMaskView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.VersionUtils;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(14)
public class FlowCameraActivity2
  extends FlowActivity
  implements aatf, View.OnClickListener, View.OnLongClickListener, RMVideoSwitchCameraPicMgr.b, ImageViewVideoPlayer.b, TCProgressBar.b
{
  long Mk;
  private long Ml;
  TextView Or;
  private aaqj jdField_a_of_type_Aaqj;
  public aaqm a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private ania jdField_a_of_type_Ania = new ania();
  anil.a jdField_a_of_type_Anil$a = new aapx(this);
  public CameraCover a;
  public CameraGLSurfaceView a;
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  SimpleProgressBar jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar;
  public TCProgressBar a;
  HorizontalItemIndicator jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator;
  TransCircleMaskView jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView;
  public boolean aNE;
  aqju ad;
  SosoInterface.a b;
  private int baS;
  String bdE;
  public String bdF;
  public double bo = 0.0D;
  public double bp = 0.0D;
  private boolean bwN = true;
  boolean bwO;
  public boolean bwP;
  boolean bwQ;
  public boolean bwR;
  boolean bwS;
  boolean bwT;
  boolean bwU;
  public boolean bwV = false;
  public boolean bwW;
  public boolean bwX = true;
  private boolean bwY;
  private boolean bwZ;
  private boolean bxa;
  private boolean bxb;
  private boolean bxc;
  private boolean bxd;
  private boolean bxe;
  private boolean bxf;
  private boolean bxg;
  private boolean bxh;
  boolean bxi = false;
  public RMVideoStateMgr c = RMVideoStateMgr.a();
  public int cil;
  int cim;
  int cin = 0;
  int cio = 0;
  int cip = 0;
  int ciq = 0;
  int cir = 0;
  private int cis;
  private int cit;
  private int ciu = 0;
  private int civ = 1;
  int ciw = 0;
  ProgressDialog jdField_e_of_type_AndroidAppProgressDialog;
  ausj jdField_e_of_type_Ausj;
  Bitmap eq;
  Button jdField_fe_of_type_AndroidWidgetButton;
  Runnable jdField_fe_of_type_JavaLangRunnable = new FlowCameraActivity2.1(this);
  public Button ff;
  Runnable ff;
  public Button fg;
  Runnable fg;
  Button fh;
  RelativeLayout iS;
  anim mCamera;
  boolean mCaptureMode;
  GestureDetector mGestureDetector;
  public int mOrientation;
  public int mPreviewHeight = -1;
  public int mPreviewWidth = -1;
  float mQ = 0.0F;
  private BroadcastReceiver mReceiver = new aaqc(this);
  private String mRefer;
  Handler mUIHandler = new Handler();
  public TextView ni;
  ImageView nj;
  float screenHeight = 0.0F;
  float screenWidth = 0.0F;
  public View.OnTouchListener v = new aapt(this);
  View.OnTouchListener w = new aapu(this);
  ImageView wp;
  ImageView wq;
  TextView yw;
  View zL;
  View zM;
  View zN;
  View zO;
  public View zP;
  public View zQ;
  public View zR;
  View zS;
  View zT;
  public View zU;
  View zV;
  
  static
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.Jq());
      }
      int i = VideoEnvironment.a("AVCodec", null, true);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "LoadExtractedShortVideoSo :code=" + i);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public FlowCameraActivity2()
  {
    this.jdField_ff_of_type_JavaLangRunnable = new FlowCameraActivity2.6(this);
    this.jdField_fg_of_type_JavaLangRunnable = new FlowCameraActivity2.22(this);
  }
  
  private boolean WR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.axh())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    int i;
    int j;
    do
    {
      return false;
      i = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
      j = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JZ();
    } while ((i > 0) || (j > 0) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_fg_of_type_AndroidWidgetButton.isEnabled()));
    return true;
  }
  
  private void bQ(Bundle paramBundle)
  {
    this.bxg = paramBundle.getBoolean("enable_big_video", false);
    this.bxe = paramBundle.getBoolean("enable_local_video", false);
    this.bxf = paramBundle.getBoolean("enable_front", false);
    this.cit = paramBundle.getInt("set_sdcard_min_size", 0);
    this.ciu = paramBundle.getInt("from_type", 0);
    this.civ = paramBundle.getInt("clip_strategy", 1);
    aaqi.ciB = this.ciu;
    if ((this.cit >= 57671680L) && (this.cit <= 314572800L)) {
      anld.ama = this.cit;
    }
    this.mRefer = paramBundle.getString("short_video_refer");
    paramBundle = paramBundle.getString("set_user_callback");
    if (paramBundle == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = Class.forName(paramBundle).newInstance();
          if ((paramBundle instanceof aaqj))
          {
            this.jdField_a_of_type_Aaqj = ((aaqj)paramBundle);
            this.jdField_a_of_type_Aaqj.setRefer(this.mRefer);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_Aaqj = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FlowCameraActivity", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  private void bR(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    label133:
    for (;;)
    {
      return;
      anhz.cGk = paramBundle.getBoolean("key_video_presend_enable", false);
      anhz.cGj = paramBundle.getBoolean("key_video_hard_encode_enable", false);
      float f = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
      if (f > 0.0F) {
        anhz.dGl = (int)(f * 1000.0F);
      }
      if (anhz.axf()) {
        this.bxa = this.c.hA(16);
      }
      for (;;)
      {
        if (!this.bxg) {
          break label133;
        }
        anhz.cGj = false;
        anhz.cGk = false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FlowCameraActivity", 2, "enable big video: mComonent_BigVideo=" + this.bxg);
        return;
        this.c.hA(4);
      }
    }
  }
  
  private void cjC()
  {
    if (this.baS == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.mReceiver, localIntentFilter);
      this.baS = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void cwC()
  {
    int j = 1;
    int k = 2;
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i;
    if ((localObject1 != null) && (anhz.axg()) && (this.bxa) && (this.ciu == 0) && (VideoEnvironment.lw(2)))
    {
      localObject2 = this.c.b;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.aF(this.c.bdG, ((aasx)localObject2).cjI, ((aasx)localObject2).cjJ);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.jA(-1, this.c.cjL * 1000);
      if (aniq.ckG != 16) {
        break label296;
      }
      i = 1;
    }
    for (;;)
    {
      if (aniq.mAudioFormat == 2) {
        j = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.S(aniq.bth, i, 128000, j);
        if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
          break label321;
        }
        this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_Ania.c.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = alvs.a().a();
        cwk();
        i = k;
        if (this.bwR) {
          i = 3;
        }
        localObject1 = ((alvv)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, i);
        this.bdE = ((alvp)localObject1).yB();
        aqip.bj(this.bdE, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((anid)localObject1, null, this.c.byY);
        return;
        label296:
        if (aniq.ckG != 12) {
          break label342;
        }
        i = 2;
        break;
        if (aniq.mAudioFormat != 3) {
          j = 2;
        }
      }
      label321:
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] previewSizeAdjustUI: rmStateMgr.videoContext=null,do not hwencode...");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
      return;
      label342:
      i = 1;
    }
  }
  
  private void cwk()
  {
    float f = this.c.aC();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      aasx localaasx = this.c.b;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.bo, this.bp, f, localaasx.cjI);
    }
  }
  
  private void cwo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new HandleEndVideoEncode(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void cwy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setEnabled(true);
    }
    this.zU.setEnabled(true);
    anlc.a(this.nj, false, 250);
    if (this.zT.isEnabled()) {
      this.zT.setEnabled(false);
    }
    this.zT.setBackgroundResource(2130846889);
    v(1002, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
    }
    this.c.a().cxZ();
    this.zT.setEnabled(true);
  }
  
  private void o(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt, paramFloat, true, ankt.dip2px(5.0F));
    int i = (int)(paramInt * paramFloat);
    ViewGroup.LayoutParams localLayoutParams = this.nj.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = i;
    this.nj.setLayoutParams(localLayoutParams);
  }
  
  public void CF(boolean paramBoolean)
  {
    cwm();
    cwy();
    if (paramBoolean) {
      CG(true);
    }
  }
  
  public void CG(boolean paramBoolean)
  {
    Object localObject3 = getResources().getDisplayMetrics();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ($(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    if ((VersionUtils.isIceScreamSandwich()) && (!this.bwQ))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof aniw)))
      {
        ((CameraTextureView)localObject2).a = ((aniw)localObject1);
        this.c.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.bwX = false;
        if (this.bwR)
        {
          ConfigurationInfo localConfigurationInfo = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
          paramBoolean = VideoEnvironment.isBeautySupported();
          if ((localConfigurationInfo == null) || (localConfigurationInfo.reqGlEsVersion < 131072) || (!paramBoolean)) {
            break label429;
          }
          localObject3 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
          ((FrameLayout.LayoutParams)localObject3).height = this.cik;
          ((FrameLayout.LayoutParams)localObject3).width = ((int)(this.cik * aaqh.rw));
          ((FrameLayout.LayoutParams)localObject3).gravity = 49;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)$(2131367282));
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((FrameLayout.LayoutParams)localObject1).height = 1;
        }
      }
    }
    for (((FrameLayout.LayoutParams)localObject1).width = 1;; ((FrameLayout.LayoutParams)localObject1).width = ((int)(this.cik * aaqh.rw)))
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = 81;
      if (this.bwX) {
        ((FrameLayout.LayoutParams)localObject1).gravity = 49;
      }
      ((View)localObject2).setId(2131367243);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      this.bwW = true;
      return;
      ((CameraTextureView)localObject2).a = new aniw(this.mCamera, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof aniv))) {}
      for (((CameraPreview)localObject2).a = ((aniv)localObject1);; ((CameraPreview)localObject2).a = new aniv(this.mCamera, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels))
      {
        this.c.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.bwX = true;
        break;
      }
      label429:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)$(2131367282));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
      ((FrameLayout.LayoutParams)localObject1).height = this.cik;
    }
  }
  
  public void CH(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.bwP + ", mPtvMode: " + this.bwR);
    }
    if (this.c != null)
    {
      this.c.stopWatching();
      if (this.bwP) {}
    }
    else
    {
      return;
    }
    if (this.bwR)
    {
      cwq();
      if (paramBoolean)
      {
        if (this.bwR) {
          this.bwS = false;
        }
        if (alvs.a().a().a(this.bdE) != null) {
          break label256;
        }
        aqip.bj(this.bdE, "sendShortVideo", "[peak] old procedure");
        getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        float f = this.c.aC();
        Object localObject = this.c;
        if (this.bwR) {
          f = 1.0F;
        }
        aaqi.a(this, (RMVideoStateMgr)localObject, f, this.bwR, this.bo, this.bp, this.jdField_a_of_type_Aaqj, 0);
        if (VideoEnvironment.awS())
        {
          localObject = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
          }
        }
      }
      label224:
      if (paramBoolean) {
        break label296;
      }
    }
    label256:
    label296:
    for (paramBoolean = true;; paramBoolean = false)
    {
      CI(paramBoolean);
      this.bwP = false;
      return;
      this.c.jdField_a_of_type_Aatf.cwH();
      break;
      if ((VideoEnvironment.awS()) && (!this.bwR))
      {
        setResult(1001);
        finish();
      }
      aqip.bj(this.bdE, "sendShortVideo", "[peak] preupload procedure");
      break label224;
    }
  }
  
  void CI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "exitVideoMode(), mPtvMode = " + this.bwR + ", clearCache = " + paramBoolean);
    }
    if (this.c != null)
    {
      if (paramBoolean)
      {
        Ge(103);
        if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
        {
          int i = this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
          this.c.r(0, i, true);
        }
      }
      this.c.cyf();
      if (this.c.jdField_a_of_type_Aate != null) {
        this.c.jdField_a_of_type_Aate.cyo();
      }
      if (this.bwR) {
        this.c.CY(paramBoolean);
      }
      if ((this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a != null) && (this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.mPaused) && (this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.bzj)) {
        this.bwS = false;
      }
    }
  }
  
  public void CJ(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[6];
    if ((this.mPreviewWidth == -1) || (this.mPreviewHeight == -1)) {}
    do
    {
      return;
      if (this.c != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FlowCameraActivity", 2, "[changeVideoPreviewMapSize]rmStateMgr " + null);
    return;
    aasx localaasx = this.c.b;
    float f = this.mPreviewWidth * 1.0F / this.mPreviewHeight;
    if (this.mQ > f) {}
    for (boolean bool = false;; bool = true)
    {
      if (anii.isFoundCoolPad()) {
        bool = true;
      }
      if (paramBoolean) {
        a(this.mPreviewWidth, this.mPreviewHeight, bool, arrayOfInt);
      }
      try
      {
        a(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        label138:
        if (!paramBoolean) {
          a(this.mPreviewWidth, this.mPreviewHeight, bool, arrayOfInt);
        }
        localaasx.cjG = arrayOfInt[0];
        localaasx.cjH = arrayOfInt[1];
        localaasx.cjI = this.mPreviewWidth;
        localaasx.cjJ = this.mPreviewHeight;
        if (bool) {
          if (this.bwX)
          {
            this.c.a(2, localaasx, this.ciq);
            if (!this.bxg) {
              break label314;
            }
            localaasx.cjI = localaasx.cjG;
            localaasx.cjJ = localaasx.cjH;
          }
        }
        for (;;)
        {
          this.c.a(localaasx, false);
          return;
          this.c.a(5, localaasx, this.cir);
          break;
          if (this.bwX)
          {
            this.c.b(2, localaasx, this.ciq);
            break;
          }
          this.c.b(5, localaasx, this.cir);
          break;
          label314:
          b(localaasx);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label138;
      }
    }
  }
  
  public void CK(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] event: current=" + i);
    }
    if ((i >= aniq.dGY) && (this.jdField_ff_of_type_AndroidWidgetButton.isEnabled()))
    {
      this.jdField_ff_of_type_AndroidWidgetButton.setText(2131693782);
      this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_ff_of_type_AndroidWidgetButton.setTextColor(-14531501);
    }
    if (i < aniq.dGY)
    {
      this.jdField_ff_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_ff_of_type_AndroidWidgetButton.setText(2131693781);
      this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_ff_of_type_AndroidWidgetButton.setTextColor(-15550475);
    }
    if (i == 0)
    {
      if ((this.zU.isEnabled()) && (this.zT.isEnabled()))
      {
        anlc.a(this.zU, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        anlc.a(this.zT, 0.0F, -8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        this.zU.setEnabled(false);
        this.zT.setEnabled(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JZ() <= 0) && (!this.bwT) && (!this.mCaptureMode) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 4)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(0);
      }
      this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
      anlc.N(this.jdField_fg_of_type_AndroidWidgetButton, true);
      if ((this.bxe) && (!this.jdField_fe_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    for (;;)
    {
      cwE();
      if (paramBoolean) {
        aaqi.reportClickEvent("", "0X8005F60");
      }
      return;
      if (i > 0)
      {
        if (this.jdField_fg_of_type_AndroidWidgetButton.isEnabled())
        {
          this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
          anlc.O(this.jdField_fg_of_type_AndroidWidgetButton, true);
        }
        if ((!this.zU.isEnabled()) && (!this.zT.isEnabled()))
        {
          anlc.a(this.zU, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
          anlc.a(this.zT, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
          this.zU.setEnabled(true);
          this.zT.setEnabled(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
        }
        if ((this.bxe) && (this.jdField_fe_of_type_AndroidWidgetButton.isEnabled()))
        {
          this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
    }
  }
  
  public void CL(boolean paramBoolean)
  {
    if ((this.bwP) && (!this.bwR))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JX();
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] deleteLastVideoSegment: current= " + i + ",deleteNative = " + paramBoolean);
      }
      alvp localalvp = alvs.a().a().a(this.bdE);
      if ((paramBoolean) && (localalvp != null)) {
        localalvp.Ts(110);
      }
      this.c.r(i, 1, paramBoolean);
    }
  }
  
  void CM(boolean paramBoolean)
  {
    runOnUiThread(new RefreshUITimer(paramBoolean));
  }
  
  public void Ge(int paramInt)
  {
    if ((this.bwP) && (!this.bwR))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JZ();
      if (i > 0)
      {
        int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
        this.c.r(j, i, true);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.dRw();
        alvp localalvp = alvs.a().a().a(this.bdE);
        if (localalvp != null) {
          localalvp.Ts(paramInt);
        }
      }
    }
  }
  
  protected void K(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2131561355, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)$(2131367324));
    this.iS = ((RelativeLayout)$(2131367346));
    this.zM = $(2131367283);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator = ((HorizontalItemIndicator)$(2131367284));
    this.zN = $(2131367317);
    this.zL = $(2131367263);
    this.zR = $(2131367307);
    this.zS = $(2131367244);
    this.zP = $(2131367321);
    this.zQ = $(2131367322);
    this.jdField_ff_of_type_AndroidWidgetButton = ((Button)$(2131367247));
    this.jdField_fg_of_type_AndroidWidgetButton = ((Button)$(2131367315));
    this.fh = ((Button)$(2131367313));
    this.ni = ((TextView)$(2131367312));
    this.Or = ((TextView)$(2131367311));
    this.zT = $(2131367257);
    this.zU = $(2131367258);
    this.wq = ((ImageView)$(2131367299));
    this.jdField_fe_of_type_AndroidWidgetButton = ((Button)$(2131367256));
    this.jdField_fe_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)$(2131367267));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    this.nj = ((ImageView)$(2131367297));
    o((int)this.screenWidth, 0.75F);
    this.fh.setOnClickListener(this);
    this.jdField_fg_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_ff_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.zU.setOnClickListener(this);
    this.zT.setOnClickListener(this);
    this.jdField_ff_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_ff_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.ab(new String[] { acfp.m(2131706354), acfp.m(2131706356) });
    if (this.bwR)
    {
      this.zN.setVisibility(4);
      this.zM.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar = ((SimpleProgressBar)$(2131367264));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-16777216);
      this.jdField_ff_of_type_AndroidWidgetButton.setText(2131693779);
      this.jdField_ff_of_type_AndroidWidgetButton.setBackgroundResource(2130846871);
      this.ni.setVisibility(0);
      this.ni.setText(2131693777);
      this.ni.setTextColor(-8355712);
      paramViewGroup = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getLayoutParams();
      if (paramViewGroup.height != this.cik)
      {
        paramViewGroup.height = this.cik;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setLayoutParams(paramViewGroup);
      }
      if (!"mounted".equals(Environment.getExternalStorageState()))
      {
        paramViewGroup = (TextView)$(2131367296);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setText(2131718865);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-1);
        this.zL.setVisibility(8);
        this.ni.setVisibility(8);
      }
      if (!anih.axl())
      {
        $(2131367296).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundColor(-1);
        this.zL.setVisibility(8);
        this.ni.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView = new TransCircleMaskView(this);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildCount() - 2, paramViewGroup);
      this.jdField_ff_of_type_AndroidWidgetButton.setContentDescription(acfp.m(2131706363));
      if (this.bwR) {
        break label870;
      }
      this.wq.setAlpha(64);
      label710:
      paramViewGroup = this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.b(this.bwR);
      if (paramViewGroup == null) {
        break label882;
      }
      this.wq.setImageBitmap(paramViewGroup);
    }
    for (;;)
    {
      this.wq.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar = ((TCProgressBar)$(2131367305));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setMax(aniq.dHc, aniq.dGY);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundResource(2130839767);
      if (!anih.agb()) {
        this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_ff_of_type_AndroidWidgetButton.setOnTouchListener(this.w);
      this.zM.setBackgroundColor(1275068416);
      if (this.mCaptureMode) {
        this.zM.setVisibility(4);
      }
      if (this.bwT) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
      }
      this.zL.setBackgroundColor(1275068416);
      this.jdField_ff_of_type_AndroidWidgetButton.setLongClickable(false);
      break;
      label870:
      this.wq.setAlpha(32);
      break label710;
      label882:
      this.wq.setImageDrawable(new ColorDrawable(-16777216));
    }
  }
  
  public void Nn()
  {
    cwy();
    CG(true);
  }
  
  public void No() {}
  
  public void Np()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.gl;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getCurrentBitmap();
    }
    if (localBitmap1 != null) {
      this.nj.setImageBitmap(localBitmap1);
    }
    this.nj.setVisibility(0);
    this.nj.setAlpha(0.2F);
  }
  
  void U(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FlowCameraActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_e_of_type_AndroidAppProgressDialog != null) {
        cancleProgressDailog();
      }
      for (;;)
      {
        this.yw.setText(paramInt);
        if (this.jdField_e_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_e_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_e_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131756467);
        this.jdField_e_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_e_of_type_AndroidAppProgressDialog.show();
        this.jdField_e_of_type_AndroidAppProgressDialog.setContentView(2131559761);
        this.yw = ((TextView)this.jdField_e_of_type_AndroidAppProgressDialog.findViewById(2131373180));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FlowCameraActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  boolean WQ()
  {
    return false;
  }
  
  int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    int m = (int)(paramInt2 * aaqh.rw);
    int i;
    int j;
    if (k <= this.screenWidth)
    {
      i = (int)(k * 0.83F);
      j = (k - i) / 2;
      k = i * paramInt2 / m;
      i = i * paramInt1 / m;
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = m;
      paramInt1 = k;
    }
    for (;;)
    {
      if (paramBoolean) {
        i = paramInt1;
      }
      k = paramInt1;
      if (paramInt1 % 2 != 0) {
        k = paramInt1 - 1;
      }
      paramInt1 = i;
      if (i % 2 != 0) {
        paramInt1 = i - 1;
      }
      paramArrayOfInt[2] = k;
      paramArrayOfInt[3] = paramInt1;
      paramArrayOfInt[4] = paramInt2;
      paramArrayOfInt[5] = m;
      return j;
      j = (int)this.screenWidth;
      i = (int)(this.screenWidth * paramInt1 / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(k * paramInt2 / this.screenWidth));
      k = (k - j) / 2;
      paramInt1 = j;
      j = k;
    }
  }
  
  protected aaqk a()
  {
    if (this.bwU) {
      this.jdField_a_of_type_Aaqm = ((aaqm)aaql.a(this, 0));
    }
    return this.jdField_a_of_type_Aaqm;
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if (this.bxg)
    {
      c(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
      return;
    }
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (this.bxg)
    {
      c(paramInt1, paramInt2, paramArrayOfInt);
      return;
    }
    b(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  void a(aasx paramaasx)
  {
    paramaasx.cjI = 240;
    paramaasx.cjJ = 240;
  }
  
  public void as(int paramInt, boolean paramBoolean)
  {
    if (this.bwP)
    {
      if (this.bwR) {
        break label100;
      }
      RMVideoStateMgr localRMVideoStateMgr = this.c;
      localRMVideoStateMgr.timerCount += 1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setProgress(paramInt, paramBoolean);
      if (paramBoolean) {
        CM(true);
      }
    }
    else
    {
      return;
    }
    int i = this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    this.jdField_a_of_type_Ania.aJ(paramInt, i);
    CM(this.bxi);
    if (this.bxi)
    {
      this.bxi = false;
      return;
    }
    this.bxi = true;
    return;
    label100:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(paramInt, paramBoolean);
  }
  
  void ax(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.bwP) {}
    }
    else {
      while ((!this.bwP) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY() > 0) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JZ() > 0)) {
        return;
      }
    }
    Object localObject = getResources();
    int j;
    int i;
    if (paramFloat > 0.0F)
    {
      ((Resources)localObject).getDimensionPixelSize(2131297332);
      j = yN();
      if (this.bwN)
      {
        ((Resources)localObject).getDimensionPixelSize(2131297333);
        i = yP();
        localObject = Integer.valueOf(-14342358);
        ax(j, i, ((Integer)localObject).intValue());
        if (paramFloat <= 0.0F) {
          break label416;
        }
        this.bwP = true;
        this.jdField_ff_of_type_AndroidWidgetButton.setLongClickable(true);
        this.Or.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.ehZ();
        this.jdField_ff_of_type_AndroidWidgetButton.setTextColor(Color.rgb(18, 183, 245));
        this.jdField_ff_of_type_AndroidWidgetButton.setText(2131693781);
        this.jdField_ff_of_type_AndroidWidgetButton.setBackgroundResource(2130846896);
        if (!this.bwR)
        {
          if (!this.bxg) {
            break label365;
          }
          this.jdField_ff_of_type_AndroidWidgetButton.setTextSize(2, 18.0F);
          i = ankt.dip2px(80.0F);
          localObject = this.jdField_ff_of_type_AndroidWidgetButton.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = i;
          ((ViewGroup.LayoutParams)localObject).width = i;
          this.jdField_ff_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    for (;;)
    {
      aaqi.reportClickEvent("", "0X8005F5D");
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setContentDescription(acfp.m(2131706367));
      this.jdField_ff_of_type_AndroidWidgetButton.setContentDescription(acfp.m(2131706357));
      return;
      ((Resources)localObject).getDimensionPixelSize(2131297325);
      i = yO();
      break;
      yN();
      j = ((Resources)localObject).getDimensionPixelSize(2131297332);
      if (this.bwN) {
        yP();
      }
      for (i = ((Resources)localObject).getDimensionPixelSize(2131297333);; i = ((Resources)localObject).getDimensionPixelSize(2131297325))
      {
        localObject = Integer.valueOf(1275068416);
        break;
        yO();
      }
      label365:
      this.jdField_ff_of_type_AndroidWidgetButton.setTextSize(2, 21.0F);
      i = ankt.dip2px(110.0F);
      localObject = this.jdField_ff_of_type_AndroidWidgetButton.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      ((ViewGroup.LayoutParams)localObject).width = i;
      this.jdField_ff_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label416:
    CH(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.eia();
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setContentDescription(acfp.m(2131706358));
    this.jdField_ff_of_type_AndroidWidgetButton.setContentDescription(acfp.m(2131706355));
  }
  
  void ax(int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup.LayoutParams localLayoutParams = this.zN.getLayoutParams();
    localLayoutParams.height = paramInt1;
    this.zN.setLayoutParams(localLayoutParams);
    if (this.bwN)
    {
      localLayoutParams = this.zL.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.zL.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.zN.setBackgroundColor(paramInt3);
      this.zM.setBackgroundColor(paramInt3);
      this.zL.setBackgroundColor(paramInt3);
      return;
      localLayoutParams = this.zM.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.zM.setLayoutParams(localLayoutParams);
    }
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int k = (int)(this.screenWidth * aaqh.rw);
    int i;
    if (paramBoolean)
    {
      i = (int)this.screenWidth;
      paramInt1 = (int)(paramInt1 * this.screenWidth / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(k * paramInt2 / this.screenWidth));
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      paramArrayOfInt[1] = fM(paramArrayOfInt[1]);
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = paramInt1;
      return;
      i = (int)(paramInt2 * this.screenHeight / paramInt1);
      int j = (int)this.screenHeight;
      paramArrayOfInt[0] = ((int)(this.screenWidth * paramInt2 / i));
      paramArrayOfInt[1] = ((int)(k * paramInt1 / this.screenHeight));
      paramInt1 = j;
    }
  }
  
  void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    paramArrayOfInt = $(2131367243);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)$lp(paramArrayOfInt);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramArrayOfInt.setLayoutParams(localLayoutParams);
    this.zL.getMeasuredHeight();
    int k = this.zM.getMeasuredHeight();
    int i = this.zN.getMeasuredHeight();
    int j = (int)(this.screenWidth * aaqh.rw);
    j = (int)this.screenHeight - k - j;
    if (paramInt2 >= this.screenHeight) {
      paramInt2 = j - i;
    }
    for (;;)
    {
      this.cin = i;
      this.cip = paramInt2;
      this.ciq = (i * this.mPreviewHeight / paramInt1);
      this.cir = ((paramInt2 + k) * this.mPreviewHeight / paramInt1);
      paramArrayOfInt = (FrameLayout.LayoutParams)this.Or.getLayoutParams();
      paramArrayOfInt.topMargin = (this.cin + ankt.dip2px(13.0F));
      paramArrayOfInt.topMargin += ankt.dip2px(3.0F);
      this.Or.setLayoutParams(paramArrayOfInt);
      if (this.bwT) {
        ax(5.0F);
      }
      return;
      paramInt2 = (int)this.screenHeight - paramInt2;
      if (this.bwX)
      {
        paramInt2 = j - i;
      }
      else if (i >= paramInt2)
      {
        paramInt2 = j - i;
      }
      else
      {
        j -= paramInt2;
        i = paramInt2;
        paramInt2 = j;
      }
    }
  }
  
  void b(aasx paramaasx)
  {
    int j = paramaasx.cjG;
    int k = paramaasx.cjH;
    int m = anhm.nu.length;
    int i = 0;
    for (;;)
    {
      int i1;
      if (i < m)
      {
        int n = fM(anhm.nu[(i + 1)]);
        i1 = fM(anhm.nu[(i + 3)]);
        if ((j >= anhm.nu[i]) && (k >= n))
        {
          paramaasx.cjI = anhm.nu[i];
          paramaasx.cjJ = n;
        }
      }
      else
      {
        return;
      }
      if ((j >= anhm.nu[(i + 2)]) && (k >= i1))
      {
        paramaasx.cjI = anhm.nu[(i + 2)];
        paramaasx.cjJ = i1;
        return;
      }
      i += 4;
    }
  }
  
  public void bl(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: on=" + paramBoolean1 + ", up=" + paramBoolean2);
    }
    if (this.c == null) {}
    label134:
    do
    {
      return;
      if (paramBoolean2)
      {
        if (this.bwV)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: 发送已录制的");
          }
          if ((this.c == null) || (this.c.Xf())) {
            break label134;
          }
          CH(this.bwV);
        }
        for (;;)
        {
          this.bwV = false;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "onTouchCaptureBtn: 删除已录制的");
          }
          aaqi.reportClickEvent("", "0X8005E93");
          break;
          if (QLog.isColorLevel()) {
            QLog.e("FlowCameraActivity", 2, "onTouchCaptureBtn: rmStateMgr.exitRecordMode() true, 段无效。");
          }
          CH(false);
        }
      }
    } while (this.bwV == paramBoolean1);
    this.bwV = paramBoolean1;
    if (this.bwV)
    {
      this.jdField_ff_of_type_AndroidWidgetButton.setText(2131693779);
      this.ni.setText(acfp.m(2131706366));
      this.ni.setTextColor(-1);
      this.ni.setBackgroundResource(2130838312);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.dlY);
      if (this.zV != null) {
        this.zV.setVisibility(8);
      }
      this.jdField_ff_of_type_AndroidWidgetButton.setBackgroundResource(2130846871);
      return;
    }
    this.jdField_ff_of_type_AndroidWidgetButton.setText(null);
    this.ni.setText(acfp.m(2131706365));
    this.ni.setTextColor(-1);
    this.ni.setBackgroundResource(2130838313);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.dJA);
    if (this.zV == null)
    {
      this.zV = new View(this);
      this.zV.setBackgroundColor(871775498);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.cik);
      this.iS.addView(this.zV, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_ff_of_type_AndroidWidgetButton.setBackgroundResource(2130846868);
      return;
      this.zV.setVisibility(0);
    }
  }
  
  void c(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int i;
    if (paramBoolean)
    {
      i = (int)this.screenWidth;
      paramInt1 = (int)(paramInt1 * this.screenWidth / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(this.screenHeight * paramInt2 / this.screenWidth));
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      paramArrayOfInt[1] = fM(paramArrayOfInt[1]);
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = paramInt1;
      return;
      i = (int)(paramInt2 * this.screenHeight / paramInt1);
      int j = (int)this.screenHeight;
      paramArrayOfInt[0] = ((int)(this.screenWidth * paramInt2 / i));
      paramArrayOfInt[1] = paramInt1;
      paramInt1 = j;
    }
  }
  
  void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Object localObject = $(2131367243);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)$lp((View)localObject);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramInt2 = this.zN.getMeasuredHeight();
    this.zL.getMeasuredHeight();
    this.cin = paramInt2;
    this.cip = ankt.dip2px(140.0F);
    localObject = (FrameLayout.LayoutParams)this.Or.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = (this.cin + ankt.dip2px(13.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin += ankt.dip2px(3.0F);
    this.Or.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i = ankt.dip2px(5.0F);
    localObject = this.zM.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.zM.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.bxh)
    {
      this.cir = 0;
      this.ciq = 0;
      this.zN.setAlpha(0.5F);
      this.zM.setAlpha(0.5F);
      this.zL.setAlpha(0.5F);
    }
    for (;;)
    {
      if (this.bwT) {
        ax(5.0F);
      }
      return;
      this.ciq = (paramInt2 * this.mPreviewHeight / paramInt1);
      this.cir = ((this.cip + i) * this.mPreviewHeight / paramInt1);
      paramArrayOfInt[1] = (((int)this.screenHeight - this.cin - this.cip - i) * this.mPreviewHeight / paramInt1);
      paramInt1 = paramArrayOfInt[0];
      paramArrayOfInt[0] -= paramInt1 % 4;
      paramInt1 = paramArrayOfInt[1];
      paramArrayOfInt[1] -= paramInt1 % 4;
    }
  }
  
  void cancleProgressDailog()
  {
    if (QLog.isColorLevel()) {
      QLog.e("FlowCameraActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_e_of_type_AndroidAppProgressDialog != null) {
        this.jdField_e_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void cwA()
  {
    if (this.wq.getVisibility() == 0)
    {
      this.wq.setVisibility(4);
      this.wq.setAlpha(255);
    }
    if (this.nj.getVisibility() == 0)
    {
      this.nj.setVisibility(8);
      this.nj.setAlpha(255);
    }
    if ((this.bwR) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVisibility(0);
    }
    this.bwO = true;
    this.mUIHandler.removeCallbacks(this.jdField_fg_of_type_JavaLangRunnable);
  }
  
  public void cwB()
  {
    if ((this.bwP) && (!this.bwR)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.dRv();
    }
  }
  
  public void cwD() {}
  
  void cwE()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
    int j = k / 1000;
    int m = k % 1000;
    int i = j;
    if (m >= 500) {
      i = j + 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] adjustRecordTime: time= " + k + ",seconds = " + i + ", ms=" + m);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("\"");
    this.Or.setText(localStringBuilder);
  }
  
  public void cwF()
  {
    if ((!this.bwR) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.recycle();
    }
  }
  
  public void cwG()
  {
    if (!this.bwR)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(0);
      this.Or.setVisibility(0);
      this.jdField_ff_of_type_AndroidWidgetButton.setLongClickable(false);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY() > 0)
      {
        this.zT.setVisibility(0);
        this.zU.setVisibility(0);
      }
      for (;;)
      {
        if (!this.jdField_fg_of_type_AndroidWidgetButton.isEnabled())
        {
          this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
          anlc.N(this.jdField_fg_of_type_AndroidWidgetButton, true);
        }
        return;
        this.zT.setVisibility(4);
        this.zU.setVisibility(4);
      }
    }
    this.cil = ((int)((this.zP.getMeasuredHeight() - this.jdField_ff_of_type_AndroidWidgetButton.getHeight()) * 0.5F) + getResources().getDimensionPixelSize(2131297324));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setVisibility(0);
  }
  
  public void cwH()
  {
    if (!this.bwR)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.recycle();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(4);
      this.Or.setVisibility(4);
      this.zT.setVisibility(4);
      this.zU.setVisibility(4);
      this.jdField_ff_of_type_AndroidWidgetButton.setLongClickable(true);
      this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_ff_of_type_AndroidWidgetButton.setBackgroundResource(2130846872);
      this.jdField_ff_of_type_AndroidWidgetButton.setText(null);
      if (!this.jdField_fg_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
        anlc.N(this.jdField_fg_of_type_AndroidWidgetButton, true);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(0, false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setVisibility(4);
    this.jdField_ff_of_type_AndroidWidgetButton.setOnTouchListener(null);
    this.jdField_ff_of_type_AndroidWidgetButton.setLongClickable(true);
  }
  
  public void cwI()
  {
    if (!this.bwR) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new HandleEndVideoEncode(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "recordVideoFinish(): mOnCaptureBtn = " + this.bwV);
      }
    } while (!this.bwV);
    CH(true);
  }
  
  public void cwJ()
  {
    super.finish();
  }
  
  void cwj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.dPQ();
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.mEncodeRef.getAndSet(null);
    }
  }
  
  public void cwl()
  {
    if (this.aNE)
    {
      cws();
      return;
    }
    Object localObject = null;
    if (this.bwR) {
      localObject = this.c.b;
    }
    this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, this.bwR, (aasx)localObject);
    if ((this.bwR) && (this.bwP))
    {
      CH(false);
      return;
    }
    localObject = alvs.a().a().a(this.bdE);
    if (localObject != null) {
      ((alvp)localObject).Ts(103);
    }
    for (;;)
    {
      localObject = getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      setResult(1001, (Intent)localObject);
      super.onBackPressed();
      return;
      cwj();
    }
  }
  
  void cwm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    }
  }
  
  void cwn()
  {
    if (this.c.bL == 0.0D)
    {
      cwl();
      aaqi.B("", "0X800656F", "1");
      return;
    }
    if (this.jdField_e_of_type_Ausj == null) {
      this.jdField_e_of_type_Ausj = ausj.a(this, false);
    }
    this.jdField_e_of_type_Ausj.setMainTitle(acfp.m(2131706360));
    this.jdField_e_of_type_Ausj.addButton(acfp.m(2131706359), 3);
    this.jdField_e_of_type_Ausj.addCancelButton(acfp.m(2131706361));
    this.jdField_e_of_type_Ausj.a(new aaqf(this));
    this.jdField_e_of_type_Ausj.show();
  }
  
  public void cwp()
  {
    CG(false);
  }
  
  void cwq()
  {
    int i = this.zP.getMeasuredHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.zP.getMeasuredHeight(), 0 });
    localValueAnimator.addUpdateListener(new aapr(this, i));
    localValueAnimator.addListener(new aaps(this));
    localValueAnimator.start();
  }
  
  public void cwr()
  {
    this.jdField_ff_of_type_AndroidWidgetButton.setText(2131693779);
    this.jdField_ff_of_type_AndroidWidgetButton.setBackgroundResource(2130846871);
    this.ni.setText(2131693777);
    this.ni.setTextColor(-8355712);
    this.ni.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setProgressColor(SimpleProgressBar.dlY);
    if (this.zV != null)
    {
      this.iS.removeView(this.zV);
      this.zV = null;
    }
  }
  
  public void cws()
  {
    if (!this.mCaptureMode) {
      this.zM.setVisibility(0);
    }
    this.wp.setImageDrawable(null);
    this.zO.setVisibility(8);
    this.zL.setVisibility(0);
    this.aNE = false;
    this.jdField_ff_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_ff_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public void cwt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterVideoMode(), mPtvMode = " + this.bwR);
    }
    this.c.cyg();
  }
  
  public void cwu()
  {
    if (!this.bwR)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(0);
      localStringBuilder.append("\"");
      this.Or.setText(localStringBuilder);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.Vd(3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a = this;
      this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.bxe)
      {
        this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.dJw = 2;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.dJx = aniq.dGY;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetSimpleProgressBar.setCurrentProgress(0, false);
  }
  
  public void cwv()
  {
    if ((this.bwP) && (!this.bwR))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.Vd(1);
      if ((this.zU.getVisibility() == 0) && (this.zT.getVisibility() == 0) && (this.zU.isEnabled()) && (this.zT.isEnabled()))
      {
        anlc.a(this.zU, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
        anlc.a(this.zT, 0.0F, -8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.zU.setEnabled(false);
      this.zT.setEnabled(false);
      anlc.a(this.jdField_ff_of_type_AndroidWidgetButton, 1.0F, 1.08F, 1.0F, 1.08F, 200, null);
      this.c.timerCount = 0;
      if (this.c.bL <= 0.0D) {
        this.c.bza = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalItemIndicator.setVisibility(4);
      }
      if (this.jdField_fg_of_type_AndroidWidgetButton.isEnabled())
      {
        this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
        anlc.O(this.jdField_fg_of_type_AndroidWidgetButton, true);
      }
      this.jdField_a_of_type_Ania.lo(this.c.bL);
      Drawable[] arrayOfDrawable = this.Or.getCompoundDrawables();
      if (arrayOfDrawable[0] != null) {
        h(arrayOfDrawable[0], Color.argb(255, 255, 0, 43));
      }
      if ((this.bxe) && (this.jdField_fe_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (this.fh.isEnabled())
      {
        this.fh.setEnabled(false);
        this.fh.setAlpha(0.2F);
      }
    }
  }
  
  public void cww()
  {
    float f1 = 1.0F;
    Object localObject;
    float f2;
    int i;
    String str;
    if ((this.bwP) && (!this.bwR))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JZ() <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.Vd(2);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mSendButton.getVisibility=" + this.zU.getVisibility());
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mPreviewButton.getVisibility=" + this.zT.getVisibility());
      }
      if ((this.zU.getVisibility() == 4) && (this.zT.getVisibility() == 4))
      {
        this.zU.setVisibility(0);
        this.zT.setVisibility(0);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mSendButton.isEnabled=" + this.zU.isEnabled());
        QLog.i("FlowCameraActivity", 2, "initUI_IdleState:mPreviewButton.isEnabled=" + this.zT.isEnabled());
      }
      if (!this.zU.isEnabled())
      {
        anlc.a(this.zU, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        this.zU.setEnabled(true);
      }
      anlc.a(this.zT, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      this.zT.setEnabled(true);
      if (this.jdField_ff_of_type_AndroidWidgetButton.isEnabled()) {
        anlc.a(this.jdField_ff_of_type_AndroidWidgetButton, 1.08F, 1.0F, 1.08F, 1.0F, 200, null);
      }
      localObject = this.Or.getCompoundDrawables();
      if (localObject[0] != null)
      {
        localObject[0].setAlpha(255);
        h(localObject[0], -1);
      }
      CK(false);
      if (!this.fh.isEnabled())
      {
        this.fh.setEnabled(true);
        this.fh.setAlpha(1.0F);
      }
      if (this.c.bza)
      {
        f2 = this.c.aC();
        i = 320;
        if (RMVideoStateMgr.byU) {
          i = this.c.b.cjI;
        }
        localObject = this.c.jdField_a_of_type_Aate;
        str = this.c.bdG;
        if (!this.bwR) {
          break label515;
        }
      }
    }
    for (;;)
    {
      ((aate)localObject).a(str, f1, i);
      this.c.bza = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i = null;
      boolean bool = this.c.Xd();
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (!bool))
      {
        f1 = (float)(this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() * 1000.0F / this.c.bL);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.f(f1, -1);
      }
      return;
      label515:
      f1 = f2;
    }
  }
  
  public void cwx()
  {
    if (this.zU.isEnabled()) {
      this.zU.setEnabled(false);
    }
    if (this.jdField_ff_of_type_AndroidWidgetButton.isEnabled())
    {
      this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_ff_of_type_AndroidWidgetButton.setTextColor(-14531501);
    }
    if (this.fh.isEnabled())
    {
      this.fh.setEnabled(false);
      this.fh.setAlpha(0.2F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.isEnabled())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setEnabled(false);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
    int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JZ();
    j = this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(j);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(aniq.dGY, i, j, this.c.bdG);
    Object localObject2 = this.c.jdField_a_of_type_Aate.a();
    BitmapFactory.Options localOptions;
    Object localObject1;
    if ((localObject2 != null) && (((aate.a)localObject2).thumbPath != null) && (((aate.a)localObject2).state.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i == null))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeFile(((aate.a)localObject2).thumbPath, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label235:
      break label235;
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i = new BitmapDrawable(super.getResources(), localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    if (!this.zT.isEnabled())
    {
      this.zT.setEnabled(true);
      this.zT.setBackgroundResource(2130846900);
    }
  }
  
  public void cwz()
  {
    if (this.jdField_ff_of_type_AndroidWidgetButton != null) {
      this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(true);
    }
    this.bwY = true;
    if ((this.bwY) && (this.bwZ) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
      cwC();
    }
    boolean bool = anii.isFoundProductFeature(anii.KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL);
    if ((!this.bwO) && (bool)) {
      this.mUIHandler.postDelayed(this.jdField_fg_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public Bitmap f(int paramInt1, int paramInt2)
  {
    if (!this.bwX)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
      if (TextureView.class.isInstance(localView)) {
        return ((TextureView)localView).getBitmap(paramInt1, paramInt2);
      }
    }
    return null;
  }
  
  int fM(int paramInt)
  {
    int i = paramInt;
    if (anhz.axf())
    {
      int j = paramInt % 16;
      i = paramInt;
      if (j > 0) {
        i = paramInt + (16 - j);
      }
    }
    return i;
  }
  
  public void finish()
  {
    super.finish();
    if ((this.ciu == 1) && (this.bxb)) {
      overridePendingTransition(0, 2130772005);
    }
  }
  
  public void gs(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FlowCameraActivity", 2, "[previewSizeAdjustUI]rmStateMgr " + null);
      }
      return;
    }
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    this.bwZ = true;
    Object localObject;
    if (!this.bwR)
    {
      CJ(true);
      if ((this.bwZ) && (this.bwY) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
        cwC();
      }
      for (;;)
      {
        paramInt1 = i;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar != null) {
          paramInt1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY();
        }
        if ((VersionUtils.isGingerBread()) && (!this.jdField_fg_of_type_AndroidWidgetButton.isEnabled()) && (paramInt1 <= 0)) {
          this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
        }
        this.mUIHandler.removeCallbacks(this.jdField_fe_of_type_JavaLangRunnable);
        if (paramInt1 >= aniq.dGY) {
          break;
        }
        this.mUIHandler.postDelayed(this.jdField_fe_of_type_JavaLangRunnable, 1000L);
        return;
        if (WR())
        {
          localObject = this.c.b;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.aF(this.c.bdG, ((aasx)localObject).cjI, ((aasx)localObject).cjJ);
          cwk();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.jA(-1, this.c.cjL * 1000);
          if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
          {
            this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("FlowCameraActivity", 2, "[@] previewSizeAdjustUI:[changeCamera] rmStateMgr.videoContext=null,do not hwencode...");
            }
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.dPP();
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
          }
        }
      }
    }
    int[] arrayOfInt = new int[6];
    aasx localaasx = this.c.b;
    label367:
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
      if (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView) {
        break label563;
      }
      bool = true;
      label379:
      int j = a(paramInt1, paramInt2, arrayOfInt, bool);
      int k = TransCircleMaskView.bv(this);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)$lp((View)localObject);
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      localLayoutParams.topMargin = (k + j);
      ((View)localObject).setLayoutParams(localLayoutParams);
      localaasx.cjG = arrayOfInt[0];
      localaasx.cjH = arrayOfInt[1];
      localaasx.cjI = paramInt1;
      localaasx.cjJ = paramInt2;
      if (!this.bwX) {
        break label569;
      }
      this.c.a(2, localaasx, 0);
    }
    for (;;)
    {
      localaasx.cjI = arrayOfInt[4];
      localaasx.cjJ = arrayOfInt[5];
      a(localaasx);
      this.c.a(localaasx, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight, localaasx);
      break;
      localObject = $(2131367243);
      break label367;
      label563:
      bool = false;
      break label379;
      label569:
      this.c.a(5, localaasx, 0);
    }
  }
  
  void h(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof GradientDrawable)) {
      ((GradientDrawable)paramDrawable).setColor(paramInt);
    }
    while (!(paramDrawable instanceof ColorDrawable)) {
      return;
    }
    ((ColorDrawable)paramDrawable).setColor(paramInt);
  }
  
  protected void initData(Bundle paramBundle)
  {
    int j = 1;
    super.initData(paramBundle);
    this.cin = 0;
    this.cio = 0;
    this.cip = 0;
    this.ciq = 0;
    this.cir = 0;
    this.Mk = -1L;
    this.eq = null;
    this.bwO = false;
    this.bwS = false;
    this.ad = null;
    this.bxd = false;
    this.bxb = false;
    this.bxc = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.bwY = false;
    this.bwZ = false;
    aaqh.cix = 2;
    aaqh.rw = 0.75F;
    if (paramBundle == null) {
      return;
    }
    this.bwR = paramBundle.getBoolean("flow_camera_ptv_mode", false);
    bQ(paramBundle);
    bR(paramBundle);
    this.bwQ = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
    this.mCaptureMode = paramBundle.getBoolean("flow_camera_capture_mode", false);
    this.bwT = paramBundle.getBoolean("flow_camera_video_mode", false);
    if (this.bwR)
    {
      this.bwU = paramBundle.getBoolean("flow_camera_show_panel", true);
      aaqh.cix = 1;
      if (!anih.agb()) {
        aaqh.cix = 2;
      }
      aaqh.rw = 1.0F;
      this.cim = paramBundle.getInt("flow_key_ptv_max_time", 20);
    }
    String str = paramBundle.getString("sv_config");
    boolean bool = paramBundle.getBoolean("sv_whitelist");
    paramBundle = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    if (paramBundle != null) {}
    for (int i = paramBundle.cZ;; i = 0)
    {
      int k = aqiw.getSystemNetwork(this);
      if (this.bwR) {
        j = 0;
      }
      this.c.a((AppInterface)getAppRuntime(), j, str, bool, i, k, this.cim);
      if (!this.c.a(this, aaqi.a(this), this))
      {
        super.finish();
        return;
      }
      this.mGestureDetector = new GestureDetector(this, new a(this));
      paramBundle = getResources().getDisplayMetrics();
      this.screenWidth = paramBundle.widthPixels;
      this.screenHeight = paramBundle.heightPixels;
      this.mQ = (this.screenHeight / this.screenWidth);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new aaqb(this, this);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.mCamera = new anim(this, this.mUIHandler);
      this.c.a(this.mCamera);
      this.mCamera.a(new anil(this.mUIHandler, this.jdField_a_of_type_Anil$a));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FlowCameraActivity", 2, "initData(), mPtvMode:" + this.bwR + ",mCaptureMode:" + this.mCaptureMode + ", config=" + str + ", white=" + bool);
      return;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void k(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new FlowCameraActivity2.23(this, paramString, paramInt));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aaqj != null) {
      this.jdField_a_of_type_Aaqj.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.bwR) && (this.bwP))
    {
      cwn();
      return;
    }
    cwl();
  }
  
  public void onClick(View paramView)
  {
    if (!this.bwW) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      Object localObject1;
      if (i == 2131367247)
      {
        if ((aqft.cC()) && (!this.bwR) && (!this.bwP))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FlowCameraActivity", 2, "Press the capture button.");
          }
          this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_ff_of_type_AndroidWidgetButton.setClickable(false);
          this.jdField_ff_of_type_AndroidWidgetButton.setOnLongClickListener(null);
          localObject1 = new File(aasa.bdZ);
          if (!((File)localObject1).exists()) {
            ((File)localObject1).mkdirs();
          }
          this.bdF = aaqh.qC();
          localObject1 = new File(this.bdF);
          anij localanij = anij.a();
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(localanij.dGP, localCameraInfo);
          i = (this.mOrientation + 45) / 90 * 90;
          if (localCameraInfo.facing == 1) {}
          for (i = (localCameraInfo.orientation - i + 360) % 360;; i = (i + localCameraInfo.orientation) % 360)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.a((File)localObject1, new aaqg(this, (File)localObject1), i, false);
            if (aaqh.cix != 1) {
              break label253;
            }
            aaqi.B("", "0X8005F5A", "0");
            break;
          }
          label253:
          aaqi.B("", "0X8005F5A", "1");
        }
      }
      else if (i == 2131367257)
      {
        if (this.c.aL.get() == 4)
        {
          CF(true);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JY() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlowCameraActivity", 2, "mVideoDrawablePlayer.getVFileAndAFile=" + this.c.bdG);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.em(this.c.bdG) != 0)
          {
            this.c.l(0, acfp.m(2131706362), false);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.cIc = true;
            this.zT.setEnabled(false);
            if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.dPT();
            }
            U(this, 2131696921);
            this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
            cancleProgressDailog();
            this.bxc = true;
            localObject1 = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
            if (localObject1 != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject1);
              this.bwO = false;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) || (this.bxg))
            {
              localObject1 = this.c.b;
              float f = ((aasx)localObject1).cjJ * 1.0F / ((aasx)localObject1).cjI;
              o((int)this.screenWidth, f);
            }
            this.c.tl(4);
            aaqi.reportClickEvent("", "0X8005F5F");
          }
        }
      }
      else if (i == 2131367258)
      {
        localObject1 = new alyr(BaseApplication.getContext());
        for (;;)
        {
          try
          {
            i = aaqh.cix;
            if (this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount() <= 1) {
              continue;
            }
            bool = true;
            ((alyr)localObject1).bQ(i, bool);
          }
          catch (NullPointerException localNullPointerException)
          {
            boolean bool;
            continue;
            Object localObject2 = null;
            continue;
            localObject2 = null;
            continue;
          }
          this.bxb = true;
          cwo();
          this.c.stopWatching();
          Ge(102);
          aqip.bj(this.bdE, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.c.bL + ",frames = " + this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
          localObject1 = alvs.a().a().a(this.bdE);
          if (localObject1 != null) {
            ((alvp)localObject1).b(this.c.bdG, (int)this.c.bL, this.c.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.Ml, this.cis);
          }
          CH(true);
          if (!this.bwR) {
            continue;
          }
          localObject1 = this.c.b;
          this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, this.bwR, (aasx)localObject1);
          if (!VideoEnvironment.awS())
          {
            setResult(1001);
            finish();
          }
          if (aaqh.cix != 1) {
            continue;
          }
          aaqi.B("", "0X8005F5E", "0");
          break;
          bool = false;
        }
        aaqi.B("", "0X8005F5E", "1");
      }
      else
      {
        if (i == 2131367315)
        {
          this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
          this.c.stopWatching();
          if (!this.bwX)
          {
            if (!this.bwR) {
              break;
            }
            localObject1 = this.c.b;
            localObject1 = this.c.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, this.bwR, (aasx)localObject1);
            if (localObject1 != null)
            {
              this.wq.setImageBitmap((Bitmap)localObject1);
              label931:
              this.wq.setVisibility(0);
              Ge(104);
              this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.Vd(3);
              this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.invalidate();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
              if (aaqh.cix != 1) {
                break label1027;
              }
            }
          }
          label1027:
          for (aaqh.cix = 2;; aaqh.cix = 1)
          {
            cwp();
            this.jdField_ff_of_type_AndroidWidgetButton.setEnabled(false);
            this.c.startWatching();
            break;
            this.wq.setImageResource(2130839767);
            break label931;
            this.wq.setImageResource(2130839767);
            break label931;
          }
        }
        if (i == 2131367313)
        {
          if ((this.bwP) || (this.bwR))
          {
            onBackPressed();
          }
          else
          {
            localObject1 = getIntent();
            ((Intent)localObject1).putExtra("flow_back", 0);
            setResult(1001, (Intent)localObject1);
            finish();
          }
        }
        else if (i == 2131367256)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FlowCameraActivity", 2, "flow_camera_btn_video_local");
          }
          if (this.jdField_a_of_type_Aaqj != null) {
            this.jdField_a_of_type_Aaqj.aG(this);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("SERIAL=").append(auri.getSerial()).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("FlowCameraActivity", 2, localStringBuilder.toString());
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = WQ();
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    PerfTracer.traceEnd("Video_component_onCreate");
    this.Ml = 0L;
    this.cis = 0;
    anpc.report("exposure_flowCamera");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.baS == 1)
      {
        unregisterReceiver(this.mReceiver);
        this.baS = 0;
      }
      if (this.jdField_e_of_type_Ausj != null) {
        this.jdField_e_of_type_Ausj.dismiss();
      }
      if (!this.bwR) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a = null;
      }
      this.c.onDestroy();
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
      }
      if (this.ad != null)
      {
        this.ad.dismiss();
        this.ad = null;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FlowCameraActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.bwR)) {
      this.c.a().onBackPressed();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!this.bwW)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FlowCameraActivity", 2, "onLongClick mIsCameraSetup false just return;");
      }
      return false;
    }
    if (paramView.getId() == 2131367247)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "onLongClick mPtvMode = " + this.bwR + ", mIsVideoMode = " + this.bwP);
      }
      if (this.bwR) {
        break label114;
      }
      if (this.bwP)
      {
        this.c.jdField_a_of_type_Aatf.cwG();
        cwt();
      }
    }
    for (;;)
    {
      return true;
      label114:
      int i = this.zP.getMeasuredHeight();
      paramView = ValueAnimator.ofInt(new int[] { 0, i });
      paramView.addUpdateListener(new aapy(this, i));
      paramView.addListener(new aapz(this));
      paramView.start();
      aaqi.reportClickEvent("", "0X8005E92");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.bwS)
    {
      this.c.onPause();
      if ((this.bwR) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
      }
      this.bwO = false;
    }
    if (this.ciu == 1) {
      avzl.a().eCO();
    }
    if (this.c.aL.get() == 4) {
      cwm();
    }
    View localView = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
    if ((anii.isFoundProduct(anii.KEY_NOT_CALLBACK_WHEN_SCREENOFF_MODEL)) && (localView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
    if ((!this.bwR) && (!this.bxd) && (!this.bxb) && (!this.bxc))
    {
      this.bxd = true;
      this.mUIHandler.postDelayed(this.jdField_ff_of_type_JavaLangRunnable, 300000L);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!this.bwS) && (this.bwW)) {
      this.c.onResume();
    }
    View localView = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
    if (((!this.bwS) || (localView == null)) && (this.c.aL.get() != 4))
    {
      if (localView != null) {
        break label144;
      }
      Looper.myQueue().addIdleHandler(new aaqd(this));
    }
    for (;;)
    {
      this.bwS = false;
      if ((!this.bwR) && (this.bxd) && (!this.bxb) && (!this.bxc))
      {
        this.mUIHandler.removeCallbacks(this.jdField_ff_of_type_JavaLangRunnable);
        this.bxd = false;
      }
      if (this.ciu == 1) {
        avzl.a().Il(4);
      }
      return;
      label144:
      if ((this.bwR) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    cjC();
    this.bo = 0.0D;
    this.bp = 0.0D;
    this.b = new aaqe(this, 1, true, true, 0L, false, false, "FlowCameraActivity2");
    SosoInterface.a(this.b);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.b != null)
    {
      SosoInterface.c(this.b);
      this.b = null;
      this.bo = 0.0D;
      this.bp = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.bwW) {}
    while ((this.bwR) || (this.aNE) || (!this.jdField_ff_of_type_AndroidWidgetButton.isClickable())) {
      return bool;
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void p(File paramFile)
  {
    this.zM.setVisibility(4);
    this.zL.setVisibility(4);
    this.ni.setVisibility(4);
    this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(4);
    if ($(2131367302) == null) {
      ((ViewStub)$(2131367303)).setVisibility(0);
    }
    if (this.zO == null) {
      this.zO = $(2131367302);
    }
    if (this.wp == null) {
      this.wp = ((ImageView)$(this.zO, 2131367298));
    }
    Object localObject = URLDrawable.getDrawable(paramFile, URLDrawable.URLDrawableOptions.obtain());
    ((URLDrawable)localObject).downloadImediatly();
    this.wp.setImageDrawable((Drawable)localObject);
    this.zO.setVisibility(0);
    this.aNE = true;
    localObject = (Button)$(this.zO, 2131367301);
    Button localButton = (Button)$(this.zO, 2131367300);
    ((Button)localObject).setOnClickListener(new aapv(this, paramFile));
    localButton.setOnClickListener(new aapw(this, paramFile, localButton));
  }
  
  protected void v(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "onPreviewResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
    }
    if (paramInt1 == 1002)
    {
      this.Mk = System.currentTimeMillis();
      this.bxc = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.dPS();
    }
  }
  
  int yN()
  {
    if (this.cin == 0) {
      this.cin = getResources().getDimensionPixelSize(2131297335);
    }
    return this.cin;
  }
  
  int yO()
  {
    if (this.cio == 0) {
      this.cio = getResources().getDimensionPixelSize(2131297334);
    }
    return this.cio;
  }
  
  int yP()
  {
    if (this.cip == 0) {
      this.cip = getResources().getDimensionPixelSize(2131297333);
    }
    return this.cip;
  }
  
  public int yQ()
  {
    if (!this.bwR) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.JW();
    }
    return -1;
  }
  
  class HandleEndVideoEncode
    implements Runnable
  {
    private SVHwEncoder b;
    
    HandleEndVideoEncode(SVHwEncoder paramSVHwEncoder)
    {
      this.b = paramSVHwEncoder;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.b);
      }
      if (this.b != null) {
        this.b.dPP();
      }
    }
  }
  
  class RefreshUITimer
    implements Runnable
  {
    boolean bxj;
    final int[] jE = { 255, 191, 127, 63, 0, 63, 127, 191 };
    int mCount;
    
    RefreshUITimer(boolean paramBoolean)
    {
      this.bxj = paramBoolean;
      this.mCount = FlowCameraActivity2.this.c.timerCount;
      this.mCount %= 32;
    }
    
    public void run()
    {
      Drawable[] arrayOfDrawable = FlowCameraActivity2.this.Or.getCompoundDrawables();
      if (this.bxj) {
        FlowCameraActivity2.this.cwE();
      }
      if (arrayOfDrawable[0] != null) {
        arrayOfDrawable[0].setAlpha(this.jE[(this.mCount / 4)]);
      }
      if ((FlowCameraActivity2.this.c.aL.get() == 2) && (arrayOfDrawable[0] != null))
      {
        arrayOfDrawable[0].setAlpha(255);
        FlowCameraActivity2.this.h(arrayOfDrawable[0], -1);
      }
    }
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    float lB;
    
    public a(Context paramContext)
    {
      this.lB = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return super.onDown(paramMotionEvent);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      if ((FlowCameraActivity2.this.mCaptureMode) || (FlowCameraActivity2.this.bwT)) {
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      if (Math.abs(f) > this.lB)
      {
        FlowCameraActivity2.this.ax(f);
        return true;
      }
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2
 * JD-Core Version:    0.7.0.1
 */