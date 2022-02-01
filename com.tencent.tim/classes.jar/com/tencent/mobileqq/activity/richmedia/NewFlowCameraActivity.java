package com.tencent.mobileqq.activity.richmedia;

import aaqh;
import aaqi;
import aaqj;
import aaqk;
import aaqq;
import aaqq.a;
import aaqr;
import aaqs;
import aaqu;
import aaqv;
import aaqw;
import aaqx;
import aaqy;
import aaqz;
import aarc;
import aard;
import aare;
import aarf;
import aarg;
import aarh;
import aari;
import aarj;
import aark;
import aarl;
import aarm;
import aarn;
import aaro;
import aarp;
import aarr;
import aars;
import aart;
import aaru;
import aarv;
import aarw;
import aarx;
import aary;
import aarz;
import aasa;
import aasb;
import aasb.b;
import aasb.c;
import aaso;
import aaso.a;
import aasp;
import aasq;
import aasr;
import aasx;
import aatc;
import aate;
import aate.a;
import aatf;
import aavi;
import acbs;
import acfp;
import adfg.a;
import aeah;
import aifl;
import ajrm;
import alvp;
import alvs;
import alvv;
import alwx;
import alyr;
import amae;
import amal;
import ambe;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera.FaceDetectionListener;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import anfe;
import anhk;
import anhm;
import anhz;
import ania;
import anid;
import anih;
import anii;
import anil;
import anil.a;
import anim;
import aniq;
import aniv;
import aniw;
import anjd;
import anjg;
import anki;
import ankq;
import ankt;
import anku;
import anlc;
import anld;
import anot;
import anpc;
import aofw;
import aqft;
import aqha;
import aqhq;
import aqip;
import aqiw;
import aqju;
import aqmj;
import aqmr;
import arhz;
import aurf;
import auri;
import ausj;
import avpq;
import avpw;
import avpw.d;
import avtz;
import avua.b;
import avzl;
import axol;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.a;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.b;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.a;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.f;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.b;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.b;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar.b;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.util.VersionUtils;
import com.tencent.widget.HorizontalListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import prw;
import psd;
import psr;
import psx;
import qqz;
import ram;
import rar;
import ras;
import reu;
import rex;
import rgp;
import rno;
import skj;
import wja;
import zxz;

@TargetApi(14)
public class NewFlowCameraActivity
  extends FlowActivity
  implements aaqj, aasb.b, aasb.c, aaso.a, aatf, amal, Handler.Callback, View.OnClickListener, MediaScanner.OnMediaInfoScannerListener, RMVideoSwitchCameraPicMgr.b, CameraFilterGLView.a, PtvTemplateManager.c, ImageViewVideoPlayer.b, TCProgressBar.b, Runnable
{
  private static final boolean Ll;
  public static long Mq;
  public static long Mr;
  private static String bdP;
  private static String bdQ;
  private static String bdx;
  public static boolean bxs;
  public static boolean bxt;
  private static boolean byC;
  private static boolean byq;
  public static int ciJ = 1;
  private static int ciK = 7;
  public static float ry = 0.6F;
  protected View Aa;
  private arhz M;
  long Mk;
  private long Ml;
  private long Mo;
  private long Mp;
  private long Ms;
  TextView Oo;
  TextView Or;
  TextView Os;
  TextView Ot;
  TextView Ou;
  TextView Ov;
  private TextView Ow;
  private TextView Ox;
  private Intent R;
  private aaqj jdField_a_of_type_Aaqj;
  private aary jdField_a_of_type_Aary = new aary();
  public aasb a;
  private aasx jdField_a_of_type_Aasx;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = new aaqr(this);
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private ania jdField_a_of_type_Ania = new ania();
  anil.a jdField_a_of_type_Anil$a = new aarr(this);
  private CameraFocusView jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView;
  private c jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$c = new aaqz(this);
  VideoFilterViewPager.b jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$b;
  private VideoFilterViewPager jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  public CameraCover a;
  public ExtendEditText a;
  public FSurfaceViewLayout a;
  private FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  private final reu jdField_a_of_type_Reu = new reu();
  public zxz a;
  Button aK;
  boolean aNE;
  private long activityStartTime;
  aqju ad;
  public aurf b;
  SosoInterface.a b;
  public qqz b;
  private double bJ = 0.7D;
  private double bK = 1.3D;
  private AtomicBoolean bY;
  private AtomicBoolean bZ;
  private int baS;
  private String bdA;
  String bdE;
  String bdF;
  String bdM = "";
  private String bdN;
  private String bdO;
  private String bdR = "";
  private String bdS;
  private String bdT;
  private String bdU;
  private String bdV;
  private String bdz;
  private int bnM = 1;
  public double bo = 0.0D;
  public double bp = 0.0D;
  private boolean bwF;
  private boolean bwI;
  boolean bwO;
  public boolean bwP;
  boolean bwQ;
  public boolean bwT;
  boolean bwV = false;
  public boolean bwW;
  boolean bwX = true;
  private boolean bwY;
  private boolean bwZ;
  private boolean bxA;
  private boolean bxB;
  private boolean bxC;
  private boolean bxD;
  private boolean bxE;
  private boolean bxF;
  private boolean bxG;
  private boolean bxH;
  private boolean bxI;
  public boolean bxJ;
  private boolean bxK;
  public boolean bxL;
  private boolean bxM;
  private boolean bxN = true;
  public boolean bxO;
  public boolean bxP = false;
  public boolean bxQ;
  public boolean bxR;
  boolean bxS = false;
  boolean bxT = false;
  public boolean bxU = true;
  private boolean bxV;
  private boolean bxW;
  public boolean bxX;
  private boolean bxY;
  private boolean bxZ = true;
  private boolean bxa;
  private boolean bxb;
  private boolean bxc;
  private boolean bxd;
  private boolean bxe;
  private boolean bxf;
  boolean bxi = false;
  public boolean bxu;
  public boolean bxv;
  public boolean bxw;
  private boolean bxx;
  boolean bxy = true;
  public boolean bxz;
  public boolean byA = false;
  private volatile boolean byB;
  private boolean bya;
  boolean byb = false;
  private boolean byc;
  private boolean byd;
  private boolean bye;
  private boolean byf = true;
  private boolean byg;
  private boolean byh;
  private boolean byi;
  private boolean byj;
  private boolean byk = true;
  private boolean byl;
  private boolean bym;
  private boolean byn = true;
  private boolean byo;
  private boolean byp;
  private boolean byr;
  private boolean bys = true;
  private boolean byt = true;
  private boolean byu = true;
  private boolean byv;
  private boolean byw;
  private boolean byx;
  public boolean byy = false;
  boolean byz = false;
  public SeekBar.OnSeekBarChangeListener c;
  public RMVideoStateMgr c;
  public AtomicBoolean ca = new AtomicBoolean(false);
  public String callback;
  Button cd;
  public int cfl;
  private int ciL;
  private int ciM;
  public int ciN;
  int ciO = 0;
  int ciP;
  private int ciQ = 1;
  private int ciR;
  public int ciS;
  private int ciT;
  private int ciU = 1;
  private int ciV = 11;
  private int ciW = 25;
  private int ciX = 2;
  private int ciY = 2;
  private int ciZ;
  private int cif = -1;
  private int cig = -1;
  private int cih = -1;
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
  private int cja;
  private int cjb = -999;
  private int cjc = 1;
  private int cjd;
  private int cje;
  private int cjf = -1;
  private String configStr = "";
  RedDotImageView d;
  ViewGroup dO;
  ProgressDialog e;
  public ausj e;
  public CircleProgress e;
  Drawable el;
  public ArrayList<String> eo;
  Bitmap eq;
  private Bitmap er;
  ProgressDialog f;
  Button fc;
  Button jdField_fe_of_type_AndroidWidgetButton;
  Runnable jdField_fe_of_type_JavaLangRunnable = new NewFlowCameraActivity.4(this);
  Runnable ff = new NewFlowCameraActivity.26(this);
  Button jdField_fg_of_type_AndroidWidgetButton;
  Runnable jdField_fg_of_type_JavaLangRunnable = new NewFlowCameraActivity.41(this);
  private Runnable fh = new NewFlowCameraActivity.51(this);
  Button fj;
  Button fk;
  private Button fl;
  private Button fm;
  private LocalMediaInfo g;
  private boolean gS;
  private LinearLayout hY;
  RelativeLayout iO;
  public boolean isCapturing = false;
  boolean isRecording = false;
  private boolean isSend;
  private boolean isTopic;
  public anim mCamera;
  private skj mClient;
  private String mContent = "";
  int mEntranceType = 0;
  private String mFontUrl;
  GestureDetector mGestureDetector;
  public HorizontalListView mListView;
  int mMaximumVelocity;
  int mMinimumVelocity;
  public int mOrientation = 90;
  int mPreviewHeight = -1;
  int mPreviewWidth = -1;
  public int mPriv = 1;
  float mQ = 0.0F;
  private BroadcastReceiver mReceiver = new aarc(this);
  private String mRefer;
  private HashMap<String, String> mReportParams = new HashMap();
  SessionInfo mSessionInfo;
  Drawable mThumb_60;
  public TextView mTip;
  RelativeLayout.LayoutParams mTipLayoutParams;
  public Handler mUIHandler = new Handler();
  public VelocityTracker mVelocityTracker;
  private View mask;
  CheckBox jdField_n_of_type_AndroidWidgetCheckBox;
  private SeekBar jdField_n_of_type_AndroidWidgetSeekBar;
  ImageView nj;
  public String pO;
  public float rx;
  private float rz;
  float screenHeight = 0.0F;
  float screenWidth = 0.0F;
  boolean showGuide = false;
  private String topicId;
  private boolean topicSyncQzone = true;
  private String uN = ad(1);
  public String uO;
  int videoDuration;
  private List<aasq> vu;
  View.OnTouchListener jdField_w_of_type_AndroidViewView$OnTouchListener = new aarl(this);
  AlphaAnimation jdField_w_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView wq;
  public ImageView wr;
  public ImageView ws;
  ImageView wt;
  ImageView wu;
  private ImageView wv;
  private ImageView ww;
  public View xf;
  TextView yw;
  View zI;
  private View zJ;
  View zW;
  View zX;
  View zY;
  public View zZ;
  
  static
  {
    Mq = 1500L;
    bdx = aasa.SDCARD_ROOT + "/tencent" + File.separator + "video_edit_music" + File.separator;
    bdP = bdx + "temp.af";
    bdQ = "";
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      Ll = bool;
      byq = true;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.Jq());
        }
        int i = VideoEnvironment.a("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :code=" + i);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
      byC = true;
      return;
    }
  }
  
  public NewFlowCameraActivity()
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_c_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new aaqu(this);
    this.jdField_a_of_type_Zxz = new aare(this);
  }
  
  private void A(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    float f1;
    int k;
    int i;
    if ((paramInt1 == 10004) || (paramInt1 == 10010))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "quick shoot onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break label633;
      }
      localObject1 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject1);
      localObject2 = getIntent();
      if (paramInt1 != 10010) {
        break label525;
      }
      localObject1 = "forward_source_from_pre_guide";
      ((Intent)localObject2).putExtra((String)localObject1, true);
      localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      if (localObject1 != null)
      {
        localObject2 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG;
        localObject2 = (String)localObject2 + File.separator + "configure.txt";
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((PublishParam)localObject1).fakeVid);
        aqhq.writeFile((String)localObject2, localStringBuilder.toString());
        getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        f1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC();
        k = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj();
        i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
        paramInt2 = i;
        if (i <= 0)
        {
          paramInt2 = i;
          if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
            paramInt2 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
          }
        }
        Gi(paramInt2);
        if (paramInt2 > 0) {
          break label722;
        }
        paramInt2 = this.cje;
      }
    }
    label525:
    label722:
    for (;;)
    {
      cxd();
      this.bwM = false;
      int j = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
      i = j;
      if (j == 0)
      {
        i = j;
        if (paramInt1 == 10010) {
          i = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
        }
      }
      if (i == 1002)
      {
        cxw();
        localObject2 = paramIntent.getStringExtra("forward_source_to_qzone");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          getIntent().putExtra("forward_source_to_qzone", (String)localObject2);
          d(paramIntent.getExtras(), (String)localObject2);
        }
        this.mContent = paramIntent.getStringExtra("key_content");
        paramIntent.putExtra("open_leba_tab_fragment", true);
        setResult(-1, paramIntent);
        finish();
        this.bxz = paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false);
        aaqi.a(this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.bo, this.bp, this.jdField_a_of_type_Aaqj, false, k, paramInt2, this.mContent, this.mPriv, this.eo, this.bxz, this.topicId, this.topicSyncQzone, ((PublishParam)localObject1).thumbPath, ((PublishParam)localObject1).doodlePath, this.cif, this.cig, this.mFontUrl, ((PublishParam)localObject1).fakeVid, ((PublishParam)localObject1).videoDuration, ((PublishParam)localObject1).saveMode, false);
      }
      label633:
      do
      {
        do
        {
          return;
          localObject1 = "forward_source_from_shoot_quick";
          break;
          if (i == 1003)
          {
            this.jdField_b_of_type_Qqz.a(paramIntent, this.wq);
            return;
          }
          setResult(-1, paramIntent);
          finish();
          aaqi.a(this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.bo, this.bp, this.jdField_a_of_type_Aaqj, false, k, paramInt2, this.mContent, this.mPriv, this.eo, this.bxz, this.topicId, this.topicSyncQzone, ((PublishParam)localObject1).thumbPath, ((PublishParam)localObject1).doodlePath, ((PublishParam)localObject1).saveMode, true, false);
          return;
        } while (paramInt2 != 0);
        if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
          aqhq.cn(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
        }
        this.mReportParams.put("result_Event", String.valueOf(2));
        CS(false);
        this.Mo = System.currentTimeMillis();
      } while ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() != 4));
      this.byj = true;
      cxe();
      this.byk = true;
      this.bxU = true;
      return;
    }
  }
  
  private void AG(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.bdN = paramString;
      if (this.mClient == null)
      {
        this.mClient = skj.a();
        this.mClient.bzj();
      }
      String str = ajrm.ms(paramString);
      this.mClient.c(paramString, str, new aarg(this, paramString, str));
    }
  }
  
  private void AH(String paramString)
  {
    QLog.w("PTV.NewFlowCameraActivity", 2, "finishShotPhotoFromStory " + paramString);
    Object localObject;
    long l;
    boolean bool1;
    boolean bool2;
    label158:
    boolean bool3;
    if (paramString != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("startEditVideoTime", SystemClock.uptimeMillis());
      if (this.jdField_a_of_type_Aasb != null) {
        ((Bundle)localObject).putString("mCurrentTemplatePath", this.jdField_a_of_type_Aasb.bec);
      }
      ((Bundle)localObject).putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      ((Bundle)localObject).putLong("story_topic_id", getIntent().getLongExtra("story_topic_id", 0L));
      ((Bundle)localObject).putInt("entrance_type", th());
      l = super.getIntent().getLongExtra("troop_uin", 0L);
      if (th() != 16) {
        break label516;
      }
      bool1 = true;
      if (th() != 5) {
        break label522;
      }
      bool2 = true;
      bool3 = super.getIntent().getBooleanExtra("ignorePersonalPublish", false);
      ram.a("PTV.NewFlowCameraActivity", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if ((!bool1) && (!bool2) && (!bool3)) {
        break label528;
      }
    }
    label516:
    label522:
    label528:
    for (int i = 4358509;; i = 4374893)
    {
      int j = i & 0xFFFF7FFF;
      i = j;
      if (l != 0L) {
        i = j & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
      }
      j = i;
      if (this.mEntranceType == 102)
      {
        Intent localIntent = super.getIntent();
        int k = localIntent.getIntExtra("shareGroupType", 0);
        ((Bundle)localObject).putInt("shareGroupType", k);
        ((Bundle)localObject).putString("shareGroupId", localIntent.getStringExtra("shareGroupId"));
        ((Bundle)localObject).putString("shareGroupName", localIntent.getStringExtra("shareGroupName"));
        ((Bundle)localObject).putLong("groupUin", localIntent.getLongExtra("groupUin", -1L));
        ((Bundle)localObject).putInt("add_video_source", localIntent.getIntExtra("add_video_source", 0));
        i |= 0x200000;
        j = i;
        if (k == 1) {
          j = i & 0xFFFDFFFF;
        }
      }
      ((Bundle)localObject).putBoolean("ignorePersonalPublish", bool3);
      paramString = new EditVideoParams(1, j, new EditTakePhotoSource(paramString, 2, 0, 0), (Bundle)localObject);
      if (l != 0L) {
        paramString.mExtra.putLong("troop_uin", l);
      }
      localObject = new Intent(this, EditVideoActivity.class);
      ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramString);
      ((Intent)localObject).putExtra("op_department", "grp_story");
      ((Intent)localObject).putExtra("op_type", "video_edit");
      i = getIntent().getIntExtra("entrance_type", 99);
      if (i == 15) {
        ((Intent)localObject).putExtra("entrance_type", i);
      }
      startActivityForResult((Intent)localObject, 10002);
      overridePendingTransition(0, 0);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label158;
    }
  }
  
  private void AJ(String paramString)
  {
    go();
    Intent localIntent = new Intent(this, EditVideoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", acfp.m(2131709023));
    paramString = new EditVideoParams(3, 4109, new EditTakeGifSource(paramString, null, null), localBundle);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewFlowCameraActivity.class.getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra(EditVideoParams.class.getName(), paramString);
    localIntent.putExtra("op_type", "gif_edit");
    localIntent.putExtra("op_department", "grp_qzone");
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("DirectBackToQzone", true);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    this.byk = false;
    startActivityForResult(localIntent, 1014);
  }
  
  private void B(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10002) || (paramInt1 == 10006))
    {
      if (paramInt2 != -1) {
        break label32;
      }
      this.jdField_b_of_type_Qqz.a(paramIntent, this.wq);
    }
    label32:
    do
    {
      do
      {
        return;
      } while (paramInt2 != 0);
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        aqhq.cn(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
      }
      h("608", "2", "0", true);
    } while ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() != 4));
    this.byj = true;
    cxe();
    this.byk = true;
    this.bxU = true;
  }
  
  private void C(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10007)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "web onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramInt2 != -1) {
        break label555;
      }
      if (paramIntent != null)
      {
        paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
        if (paramIntent != null)
        {
          this.isSend = true;
          if (paramIntent.bsZ != 1) {
            break label241;
          }
          localObject = paramIntent.thumbPath;
          if (QLog.isColorLevel())
          {
            QLog.d("PTV.NewFlowCameraActivity", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
            QLog.d("PTV.NewFlowCameraActivity", 2, "publishParam =" + paramIntent.toString());
          }
          getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          localObject = new SessionInfo();
          ((SessionInfo)localObject).aTl = "0";
          ((SessionInfo)localObject).cZ = 0;
          getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject);
          getIntent().putExtra("param_entrance", 32);
          getIntent().putExtra("fake_id", paramIntent.fakeVid);
          a(paramIntent);
        }
      }
    }
    return;
    label241:
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG;
    localObject = (String)localObject + File.separator + "configure.txt";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIntent.fakeVid);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "configure file content:" + localStringBuilder.toString());
    }
    aqhq.writeFile((String)localObject, localStringBuilder.toString());
    float f1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
    }
    Gi(paramInt1);
    if (paramInt1 <= 0) {
      paramInt1 = this.cje;
    }
    for (;;)
    {
      cxd();
      this.bwM = false;
      localObject = new SessionInfo();
      ((SessionInfo)localObject).aTl = "0";
      ((SessionInfo)localObject).cZ = 0;
      getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject);
      getIntent().putExtra("param_entrance", 32);
      getIntent().putExtra("fake_id", paramIntent.fakeVid);
      getIntent().putExtra("edit_web", true);
      aaqi.a(this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, true, this.bo, this.bp, this.jdField_a_of_type_Aaqj, false, i, paramInt1, this.mContent, this.mPriv, this.eo, this.bxz, this.topicId, this.topicSyncQzone, paramIntent.thumbPath, paramIntent.doodlePath, paramIntent.saveMode, true, false);
      return;
      label555:
      if (paramInt2 != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
      }
      this.mReportParams.put("result_Event", String.valueOf(2));
      CS(false);
      this.Mo = System.currentTimeMillis();
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() != 4) {
        break;
      }
      this.byj = true;
      cxe();
      this.byk = true;
      return;
    }
  }
  
  private void CO(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mask == null) {
        this.mask = new View(this);
      }
      this.mask.setBackgroundColor(-1);
      this.mask.setAlpha(0.7F);
      if (this.mask.getParent() != null) {
        ((ViewGroup)this.mask.getParent()).removeView(this.mask);
      }
      addContentView(this.mask, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      try
      {
        this.ciU = Settings.System.getInt(getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
        this.ciT = Settings.System.getInt(getContentResolver(), "screen_brightness");
        Settings.System.putInt(getContentResolver(), "screen_brightness", 255);
        return;
      }
      catch (Exception localException1)
      {
        this.ciU = 1;
        this.ciT = 100;
        QLog.d(".photo", 2, new Object[] { "setting not found ", localException1.getMessage() });
        return;
      }
      if (aaqh.cix == 2)
      {
        this.mCamera.PS(false);
        return;
      }
      if (aaqh.cix == 1) {
        try
        {
          Settings.System.putInt(getContentResolver(), "screen_brightness", this.ciT);
          Settings.System.putInt(getContentResolver(), "screen_brightness_mode", this.ciU);
          if ((this.mask != null) && (this.mask.getParent() != null))
          {
            ((ViewGroup)this.mask.getParent()).removeView(this.mask);
            return;
          }
        }
        catch (Exception localException2)
        {
          QLog.d(".photo", 2, new Object[] { "setting not found ", localException2.getMessage() });
        }
      }
    }
  }
  
  private void CP(boolean paramBoolean)
  {
    int i;
    if (aaqh.cix == 1)
    {
      if ((this.jdField_a_of_type_Aasb == null) || (this.jdField_a_of_type_Aasb.yW() != 1)) {
        break label404;
      }
      i = 0;
    }
    for (;;)
    {
      if (!this.byn) {
        i = 0;
      }
      if ((this.byo) && (this.bxX) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) && (i != 0) && (this.jdField_n_of_type_AndroidWidgetSeekBar != null) && (this.jdField_n_of_type_AndroidWidgetSeekBar.getVisibility() != 0) && (this.jdField_b_of_type_Aurf != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
        String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        i = localSharedPreferences.getInt("beauty_level" + str, (int)(ry * 100.0F));
        if (!paramBoolean) {
          break label390;
        }
        Mq = 3500L;
        this.bxO = true;
      }
      for (;;)
      {
        this.ciN = i;
        this.rx = (this.ciN / 5 * 0.05F);
        this.jdField_n_of_type_AndroidWidgetSeekBar.setProgress(i);
        this.jdField_n_of_type_AndroidWidgetSeekBar.setVisibility(0);
        this.jdField_n_of_type_AndroidWidgetSeekBar.setEnabled(true);
        this.jdField_n_of_type_AndroidWidgetSeekBar.setContentDescription(acfp.m(2131709024) + i + "%");
        this.jdField_b_of_type_Aurf.removeMessages(1011);
        this.jdField_b_of_type_Aurf.sendEmptyMessageDelayed(1011, Mq);
        aasr.a().dA(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getContext());
        if ((paramBoolean) && (this.mTip != null))
        {
          this.mTip.setText(acfp.m(2131708984) + i + "%");
          this.mTip.addOnLayoutChangeListener(new aaqs(this, i));
        }
        return;
        if ((this.jdField_a_of_type_Aasb == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aasb.qD()))) {
          break label399;
        }
        if (this.jdField_a_of_type_Aasb.yW() == 1)
        {
          i = 0;
          break;
        }
        i = 1;
        break;
        label390:
        Mq = 1500L;
      }
      label399:
      i = 0;
      continue;
      label404:
      i = 1;
    }
  }
  
  private void CQ(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() == 0) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    }
    this.fk.setBackgroundColor(0);
    int i = getIntent().getIntExtra("edit_video_type", 0);
    Object localObject;
    if (this.bxz)
    {
      this.fk.setVisibility(8);
      this.d.clearAnimation();
      this.d.setVisibility(4);
      if (!this.bxz) {
        break label453;
      }
      this.cd.clearAnimation();
      this.cd.setVisibility(8);
      localObject = this.Oo;
      if (!paramBoolean) {
        break label439;
      }
      i = 0;
      label103:
      ((TextView)localObject).setVisibility(i);
      if (paramBoolean)
      {
        if (!this.bxz) {
          break label445;
        }
        localObject = this.Oo;
        label124:
        anlc.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      label139:
      if ((!this.bxz) || (!paramBoolean) || (!this.bxD)) {
        break label568;
      }
      this.iO.setVisibility(0);
      anlc.a(this.iO, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.bxH) {
        this.fc.setVisibility(8);
      }
      if (this.bxE)
      {
        this.fc.setVisibility(8);
        this.jdField_n_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_n_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new aari(this));
        this.jdField_n_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    for (;;)
    {
      this.mListView.setVisibility(4);
      this.zW.setVisibility(8);
      this.Ot.setVisibility(8);
      this.wr.clearAnimation();
      this.wr.setVisibility(4);
      this.Os.setVisibility(4);
      this.ws.clearAnimation();
      this.ws.setVisibility(4);
      this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(4);
      this.fl.setVisibility(4);
      this.fm.setVisibility(4);
      this.Or.setVisibility(4);
      return;
      if ((i == 10000) || (i == 10003) || (i == 10004) || (i == 10010) || (i == 10002) || (i == 10007))
      {
        this.fk.setVisibility(8);
        break;
      }
      this.fk.setVisibility(0);
      this.fk.setText(acfp.m(2131708992));
      anlc.a(this.fk, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      break;
      label439:
      i = 8;
      break label103;
      label445:
      localObject = this.d;
      break label124;
      label453:
      this.Oo.clearAnimation();
      this.Oo.setVisibility(4);
      if ((i == 10000) || (i == 10004) || (i == 10010) || (i == 10002) || (i == 10003) || (i == 10007))
      {
        this.cd.setVisibility(8);
        break label139;
      }
      this.cd.setVisibility(0);
      if (this.bxz) {}
      for (localObject = this.Oo;; localObject = this.cd)
      {
        anlc.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        break;
      }
      label568:
      this.iO.setVisibility(4);
    }
  }
  
  private void CS(boolean paramBoolean)
  {
    HashMap localHashMap = this.mReportParams;
    int i;
    if (this.bym)
    {
      i = 1;
      localHashMap.put("manualFocused", String.valueOf(i));
      localHashMap = this.mReportParams;
      if (!this.bxu) {
        break label194;
      }
      i = 1;
      label40:
      localHashMap.put("manualZoom", String.valueOf(i));
      localHashMap = this.mReportParams;
      if (!this.byc) {
        break label199;
      }
      i = 1;
      label66:
      localHashMap.put("flashOn", String.valueOf(i));
      localHashMap = this.mReportParams;
      if (!this.byd) {
        break label204;
      }
      i = 1;
      label92:
      localHashMap.put("nightOn", String.valueOf(i));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b().id == 0)) {
        break label209;
      }
      this.mReportParams.put("useFilter", String.valueOf(1));
      this.mReportParams.put("filterId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b().id));
    }
    for (;;)
    {
      ThreadManager.post(new NewFlowCameraActivity.56(this, paramBoolean), 5, null, true);
      return;
      i = 0;
      break;
      label194:
      i = 0;
      break label40;
      label199:
      i = 0;
      break label66;
      label204:
      i = 0;
      break label92;
      label209:
      this.mReportParams.put("useFilter", String.valueOf(0));
    }
  }
  
  private void Gi(int paramInt)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "printFrameNumberLog: totalFilerFrame=" + paramInt);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      paramInt = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "printFrameNumberLog: frameNumOne=" + i + "  frameNumTwo=" + paramInt);
      }
      return;
      int j = -1;
      paramInt = i;
      i = j;
    }
  }
  
  /* Error */
  private void Gk(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1470	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager	Lcom/tencent/mobileqq/activity/richmedia/VideoFilterViewPager;
    //   4: ifnull +51 -> 55
    //   7: aload_0
    //   8: getfield 1470	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager	Lcom/tencent/mobileqq/activity/richmedia/VideoFilterViewPager;
    //   11: invokevirtual 1475	com/tencent/mobileqq/activity/richmedia/VideoFilterViewPager:b	()Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;
    //   14: astore 15
    //   16: aload 15
    //   18: ifnull +37 -> 55
    //   21: aload 15
    //   23: getfield 1508	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:name	Ljava/lang/String;
    //   26: invokestatic 819	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +26 -> 55
    //   32: ldc_w 428
    //   35: ldc_w 1510
    //   38: ldc_w 428
    //   41: ldc_w 428
    //   44: aload 15
    //   46: getfield 1508	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:name	Ljava/lang/String;
    //   49: ldc_w 428
    //   52: invokestatic 1513	aaqi:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 1515	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:ciP	I
    //   59: istore 7
    //   61: aload_0
    //   62: getfield 767	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout	Lcom/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout;
    //   65: invokevirtual 775	com/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout:zk	()I
    //   68: istore_2
    //   69: iload_2
    //   70: istore 5
    //   72: iload_2
    //   73: ifgt +29 -> 102
    //   76: iload_2
    //   77: istore 5
    //   79: aload_0
    //   80: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   83: getfield 778	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   86: ifnull +16 -> 102
    //   89: aload_0
    //   90: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   93: getfield 778	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   96: iconst_0
    //   97: invokevirtual 784	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getRemainedRecordFrames	(I)I
    //   100: istore 5
    //   102: iload 5
    //   104: ifle +9 -> 113
    //   107: aload_0
    //   108: iload 5
    //   110: putfield 790	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:cje	I
    //   113: aconst_null
    //   114: astore 15
    //   116: aload_0
    //   117: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   120: getfield 739	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:bdG	Ljava/lang/String;
    //   123: astore 20
    //   125: aload 20
    //   127: invokestatic 819	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +14 -> 144
    //   133: new 411	java/io/File
    //   136: dup
    //   137: aload 20
    //   139: invokespecial 1517	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 15
    //   144: iload 7
    //   146: ifle +21 -> 167
    //   149: iload 5
    //   151: ifle +16 -> 167
    //   154: aload 15
    //   156: ifnull +11 -> 167
    //   159: aload 15
    //   161: invokevirtual 1520	java/io/File:exists	()Z
    //   164: ifne +19 -> 183
    //   167: aload_0
    //   168: ldc_w 1521
    //   171: invokestatic 1089	acfp:m	(I)Ljava/lang/String;
    //   174: iconst_0
    //   175: invokestatic 1526	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   178: invokevirtual 1530	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   181: pop
    //   182: return
    //   183: aload_0
    //   184: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   187: getfield 1532	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:b	Laasx;
    //   190: getfield 1537	aasx:cjI	I
    //   193: istore 8
    //   195: aload_0
    //   196: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   199: getfield 1532	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:b	Laasx;
    //   202: getfield 1540	aasx:cjJ	I
    //   205: istore 9
    //   207: ldc_w 428
    //   210: astore 15
    //   212: iconst_0
    //   213: istore 10
    //   215: aload_0
    //   216: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   219: getfield 1543	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_Aate	Laate;
    //   222: invokevirtual 1548	aate:a	()Laate$a;
    //   225: astore 16
    //   227: aload 15
    //   229: astore 17
    //   231: iload 10
    //   233: istore 13
    //   235: aload 16
    //   237: ifnull +49 -> 286
    //   240: aload 15
    //   242: astore 17
    //   244: iload 10
    //   246: istore 13
    //   248: aload 16
    //   250: getfield 1551	aate$a:thumbPath	Ljava/lang/String;
    //   253: ifnull +33 -> 286
    //   256: aload 15
    //   258: astore 17
    //   260: iload 10
    //   262: istore 13
    //   264: aload 16
    //   266: getfield 1554	aate$a:state	Ljava/util/concurrent/atomic/AtomicInteger;
    //   269: invokevirtual 920	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   272: iconst_3
    //   273: if_icmpne +13 -> 286
    //   276: iconst_1
    //   277: istore 13
    //   279: aload 16
    //   281: getfield 1551	aate$a:thumbPath	Ljava/lang/String;
    //   284: astore 17
    //   286: bipush 109
    //   288: istore_3
    //   289: iload_1
    //   290: sipush 10004
    //   293: if_icmpeq +24 -> 317
    //   296: iload_1
    //   297: sipush 10000
    //   300: if_icmpeq +17 -> 317
    //   303: iload_1
    //   304: sipush 10007
    //   307: if_icmpeq +10 -> 317
    //   310: iload_1
    //   311: sipush 10010
    //   314: if_icmpne +7 -> 321
    //   317: sipush 1133
    //   320: istore_3
    //   321: new 958	android/os/Bundle
    //   324: dup
    //   325: invokespecial 959	android/os/Bundle:<init>	()V
    //   328: astore 18
    //   330: aload_0
    //   331: getfield 967	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_Aasb	Laasb;
    //   334: ifnull +18 -> 352
    //   337: aload 18
    //   339: ldc_w 969
    //   342: aload_0
    //   343: getfield 967	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_Aasb	Laasb;
    //   346: getfield 974	aasb:bec	Ljava/lang/String;
    //   349: invokevirtual 978	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: iload_1
    //   353: sipush 10003
    //   356: if_icmpne +819 -> 1175
    //   359: iconst_0
    //   360: istore_2
    //   361: getstatic 1559	aniq:ckG	I
    //   364: lookupswitch	default:+60->424, 1:+801->1165, 2:+801->1165, 3:+806->1170, 12:+806->1170, 16:+801->1165, 48:+806->1170
    //   425: ldc 19
    //   427: iconst_3
    //   428: aload 178
    //   430: iconst_3
    //   431: iload_2
    //   432: invokevirtual 995	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   435: aload 18
    //   437: ldc_w 1566
    //   440: iload_2
    //   441: invokevirtual 995	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   444: iload_3
    //   445: sipush 512
    //   448: ior
    //   449: bipush 223
    //   451: iand
    //   452: istore_2
    //   453: aload 18
    //   455: ldc_w 988
    //   458: aload_0
    //   459: invokevirtual 991	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:th	()I
    //   462: invokevirtual 995	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   465: aload 18
    //   467: ldc_w 1568
    //   470: aload_0
    //   471: getfield 552	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:bo	D
    //   474: invokevirtual 1572	android/os/Bundle:putDouble	(Ljava/lang/String;D)V
    //   477: aload 18
    //   479: ldc_w 1574
    //   482: aload_0
    //   483: getfield 554	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:bp	D
    //   486: invokevirtual 1572	android/os/Bundle:putDouble	(Ljava/lang/String;D)V
    //   489: iload_1
    //   490: sipush 10003
    //   493: if_icmpne +740 -> 1233
    //   496: iconst_5
    //   497: istore_3
    //   498: aload_0
    //   499: getfield 1576	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:byr	Z
    //   502: ifeq +6 -> 508
    //   505: bipush 6
    //   507: istore_3
    //   508: ldc_w 1578
    //   511: astore 15
    //   513: iconst_m1
    //   514: istore 4
    //   516: iload_1
    //   517: sipush 10012
    //   520: if_icmpne +986 -> 1506
    //   523: aload_0
    //   524: invokevirtual 722	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:getIntent	()Landroid/content/Intent;
    //   527: invokevirtual 826	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   530: astore 16
    //   532: aload 16
    //   534: ifnull +938 -> 1472
    //   537: aload 16
    //   539: ldc_w 1580
    //   542: invokevirtual 1583	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   545: astore 16
    //   547: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +31 -> 581
    //   553: ldc_w 447
    //   556: iconst_2
    //   557: new 395	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 1585
    //   567: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload 16
    //   572: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 461	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: new 1587	org/json/JSONObject
    //   584: dup
    //   585: aload 16
    //   587: invokespecial 1588	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   590: astore 19
    //   592: aload 19
    //   594: ldc_w 1590
    //   597: iconst_0
    //   598: invokevirtual 1593	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   601: istore 10
    //   603: aload 19
    //   605: ldc_w 1595
    //   608: iconst_0
    //   609: invokevirtual 1593	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   612: istore 11
    //   614: aload 19
    //   616: ldc_w 1597
    //   619: iconst_0
    //   620: invokevirtual 1593	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   623: istore 12
    //   625: iload 4
    //   627: istore_3
    //   628: aload 19
    //   630: ldc_w 1599
    //   633: ldc_w 1578
    //   636: invokevirtual 1603	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   639: astore 16
    //   641: iload 4
    //   643: istore_3
    //   644: aload 16
    //   646: astore 15
    //   648: aload 19
    //   650: ldc_w 1605
    //   653: iconst_m1
    //   654: invokevirtual 1608	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   657: istore 4
    //   659: iload 4
    //   661: istore_3
    //   662: aload 16
    //   664: astore 15
    //   666: aload 19
    //   668: ldc_w 1610
    //   671: ldc_w 428
    //   674: invokevirtual 1603	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   677: astore 19
    //   679: iload_2
    //   680: istore_3
    //   681: iload 11
    //   683: ifne +8 -> 691
    //   686: iload_2
    //   687: bipush 254
    //   689: iand
    //   690: istore_3
    //   691: iload_3
    //   692: istore_2
    //   693: iload 12
    //   695: ifne +8 -> 703
    //   698: iload_3
    //   699: bipush 251
    //   701: iand
    //   702: istore_2
    //   703: iload 4
    //   705: istore 6
    //   707: iload 12
    //   709: istore 14
    //   711: bipush 10
    //   713: istore_3
    //   714: aload 19
    //   716: astore 15
    //   718: iload_2
    //   719: istore 4
    //   721: iload 10
    //   723: istore 12
    //   725: iload 14
    //   727: istore 10
    //   729: iload 6
    //   731: istore_2
    //   732: new 1612	com/tencent/biz/qqstory/takevideo/EditRecordVideoSource
    //   735: dup
    //   736: aload 20
    //   738: iload 5
    //   740: iload 7
    //   742: i2l
    //   743: getstatic 1237	aaqh:cix	I
    //   746: aload_0
    //   747: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   750: getfield 1532	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:b	Laasx;
    //   753: getfield 1537	aasx:cjI	I
    //   756: aload_0
    //   757: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   760: getfield 1532	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:b	Laasx;
    //   763: getfield 1540	aasx:cjJ	I
    //   766: aload_0
    //   767: getfield 767	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout	Lcom/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout;
    //   770: invokevirtual 772	com/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout:zj	()I
    //   773: iload 8
    //   775: iload 9
    //   777: aload_0
    //   778: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   781: invokevirtual 765	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:aC	()F
    //   784: aload 17
    //   786: iload 13
    //   788: invokespecial 1615	com/tencent/biz/qqstory/takevideo/EditRecordVideoSource:<init>	(Ljava/lang/String;IJIIIIIIFLjava/lang/String;Z)V
    //   791: astore 19
    //   793: aload 18
    //   795: ifnonnull +519 -> 1314
    //   798: iload_1
    //   799: invokestatic 1618	com/tencent/biz/qqstory/takevideo/EditVideoParams:c	(I)Landroid/os/Bundle;
    //   802: astore 17
    //   804: new 1035	com/tencent/biz/qqstory/takevideo/EditVideoParams
    //   807: dup
    //   808: iload_3
    //   809: iload 4
    //   811: aload 19
    //   813: aload 17
    //   815: invokespecial 1043	com/tencent/biz/qqstory/takevideo/EditVideoParams:<init>	(IILcom/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;Landroid/os/Bundle;)V
    //   818: astore 18
    //   820: aload_0
    //   821: invokevirtual 722	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:getIntent	()Landroid/content/Intent;
    //   824: ldc_w 1372
    //   827: iconst_0
    //   828: invokevirtual 802	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   831: istore_3
    //   832: aload_0
    //   833: getfield 1576	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:byr	Z
    //   836: ifeq +485 -> 1321
    //   839: iconst_3
    //   840: invokestatic 1623	ras:wN	(I)V
    //   843: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +100 -> 946
    //   849: ldc_w 447
    //   852: iconst_2
    //   853: new 395	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 1625
    //   863: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: iload 7
    //   868: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   871: ldc_w 1627
    //   874: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: iload 5
    //   879: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: ldc_w 1629
    //   885: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload 20
    //   890: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: ldc_w 1631
    //   896: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: getstatic 1237	aaqh:cix	I
    //   902: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: ldc_w 1633
    //   908: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_0
    //   912: getfield 767	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout	Lcom/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout;
    //   915: invokevirtual 772	com/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout:zj	()I
    //   918: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   921: ldc_w 1635
    //   924: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_0
    //   928: getfield 528	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   931: getfield 1532	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:b	Laasx;
    //   934: invokevirtual 1636	aasx:toString	()Ljava/lang/String;
    //   937: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokestatic 461	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload_0
    //   947: getfield 1576	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:byr	Z
    //   950: ifeq +435 -> 1385
    //   953: aload_0
    //   954: getfield 624	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:bnM	I
    //   957: ifne +428 -> 1385
    //   960: iconst_1
    //   961: istore_3
    //   962: iload_3
    //   963: ifeq +427 -> 1390
    //   966: new 712	android/content/Intent
    //   969: dup
    //   970: aload_0
    //   971: ldc_w 1638
    //   974: invokespecial 1052	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   977: astore 17
    //   979: aload 17
    //   981: ldc_w 1640
    //   984: aload_0
    //   985: getfield 1642	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:callback	Ljava/lang/String;
    //   988: invokevirtual 822	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   991: pop
    //   992: aload 17
    //   994: ldc_w 1035
    //   997: invokevirtual 1057	java/lang/Class:getName	()Ljava/lang/String;
    //   1000: aload 18
    //   1002: invokevirtual 726	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1005: pop
    //   1006: aload 17
    //   1008: ldc_w 1059
    //   1011: ldc_w 1644
    //   1014: invokevirtual 822	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1017: pop
    //   1018: aload 17
    //   1020: ldc_w 1063
    //   1023: ldc_w 1065
    //   1026: invokevirtual 822	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1029: pop
    //   1030: aload 17
    //   1032: ldc_w 1646
    //   1035: invokestatic 909	java/lang/System:currentTimeMillis	()J
    //   1038: invokevirtual 761	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1041: pop
    //   1042: aload 17
    //   1044: ldc_w 1648
    //   1047: iload 5
    //   1049: invokevirtual 1068	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1052: pop
    //   1053: aload 17
    //   1055: ldc_w 1650
    //   1058: iload 7
    //   1060: invokevirtual 1068	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1063: pop
    //   1064: aload 17
    //   1066: ldc_w 1590
    //   1069: iload 12
    //   1071: invokevirtual 731	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1074: pop
    //   1075: aload 17
    //   1077: ldc_w 1595
    //   1080: iload 11
    //   1082: invokevirtual 731	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1085: pop
    //   1086: aload 17
    //   1088: ldc_w 1597
    //   1091: iload 10
    //   1093: invokevirtual 731	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1096: pop
    //   1097: iload_1
    //   1098: sipush 10012
    //   1101: if_icmpne +35 -> 1136
    //   1104: aload 17
    //   1106: ldc_w 1599
    //   1109: aload 16
    //   1111: invokevirtual 822	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1114: pop
    //   1115: aload 17
    //   1117: ldc_w 1605
    //   1120: iload_2
    //   1121: invokevirtual 1068	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1124: pop
    //   1125: aload 17
    //   1127: ldc_w 1610
    //   1130: aload 15
    //   1132: invokevirtual 822	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1135: pop
    //   1136: aload_0
    //   1137: aload 17
    //   1139: iload_1
    //   1140: invokevirtual 1072	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1143: aload_0
    //   1144: iconst_0
    //   1145: iconst_0
    //   1146: invokevirtual 1076	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:overridePendingTransition	(II)V
    //   1149: aload_0
    //   1150: iconst_0
    //   1151: putfield 922	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:byj	Z
    //   1154: aload_0
    //   1155: iconst_0
    //   1156: putfield 585	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:byk	Z
    //   1159: aload_0
    //   1160: iconst_1
    //   1161: putfield 1652	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:byl	Z
    //   1164: return
    //   1165: iconst_1
    //   1166: istore_2
    //   1167: goto -743 -> 424
    //   1170: iconst_2
    //   1171: istore_2
    //   1172: goto -748 -> 424
    //   1175: iload_1
    //   1176: bipush 101
    //   1178: if_icmpeq +10 -> 1188
    //   1181: iload_1
    //   1182: sipush 10004
    //   1185: if_icmpne +18 -> 1203
    //   1188: aload 18
    //   1190: ldc_w 1654
    //   1193: bipush 101
    //   1195: invokevirtual 995	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1198: iload_3
    //   1199: istore_2
    //   1200: goto -747 -> 453
    //   1203: iload_1
    //   1204: bipush 104
    //   1206: if_icmpeq +12 -> 1218
    //   1209: iload_3
    //   1210: istore_2
    //   1211: iload_1
    //   1212: sipush 10010
    //   1215: if_icmpne -762 -> 453
    //   1218: aload 18
    //   1220: ldc_w 1654
    //   1223: bipush 104
    //   1225: invokevirtual 995	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1228: iload_3
    //   1229: istore_2
    //   1230: goto -777 -> 453
    //   1233: iconst_2
    //   1234: istore_3
    //   1235: goto -737 -> 498
    //   1238: astore 16
    //   1240: iconst_m1
    //   1241: istore_3
    //   1242: ldc_w 1578
    //   1245: astore 15
    //   1247: iconst_0
    //   1248: istore 10
    //   1250: iconst_0
    //   1251: istore 11
    //   1253: iconst_0
    //   1254: istore 12
    //   1256: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1259: ifeq +31 -> 1290
    //   1262: ldc_w 447
    //   1265: iconst_2
    //   1266: new 395	java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1273: ldc_w 1656
    //   1276: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: aload 16
    //   1281: invokevirtual 1659	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: invokestatic 1661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1290: aload 15
    //   1292: astore 16
    //   1294: bipush 10
    //   1296: istore 6
    //   1298: iload_2
    //   1299: istore 4
    //   1301: ldc_w 428
    //   1304: astore 15
    //   1306: iload_3
    //   1307: istore_2
    //   1308: iload 6
    //   1310: istore_3
    //   1311: goto -579 -> 732
    //   1314: aload 18
    //   1316: astore 17
    //   1318: goto -514 -> 804
    //   1321: iload_3
    //   1322: sipush 10004
    //   1325: if_icmpne +10 -> 1335
    //   1328: iconst_2
    //   1329: invokestatic 1623	ras:wN	(I)V
    //   1332: goto -489 -> 843
    //   1335: iload_3
    //   1336: sipush 10000
    //   1339: if_icmpne +10 -> 1349
    //   1342: iconst_1
    //   1343: invokestatic 1623	ras:wN	(I)V
    //   1346: goto -503 -> 843
    //   1349: iload_3
    //   1350: sipush 10003
    //   1353: if_icmpne +10 -> 1363
    //   1356: iconst_4
    //   1357: invokestatic 1623	ras:wN	(I)V
    //   1360: goto -517 -> 843
    //   1363: iload_3
    //   1364: sipush 10010
    //   1367: if_icmpne +11 -> 1378
    //   1370: bipush 8
    //   1372: invokestatic 1623	ras:wN	(I)V
    //   1375: goto -532 -> 843
    //   1378: iconst_0
    //   1379: invokestatic 1623	ras:wN	(I)V
    //   1382: goto -539 -> 843
    //   1385: iconst_0
    //   1386: istore_3
    //   1387: goto -425 -> 962
    //   1390: new 712	android/content/Intent
    //   1393: dup
    //   1394: aload_0
    //   1395: ldc_w 1049
    //   1398: invokespecial 1052	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1401: astore 17
    //   1403: goto -411 -> 992
    //   1406: astore 16
    //   1408: iconst_m1
    //   1409: istore_3
    //   1410: ldc_w 1578
    //   1413: astore 15
    //   1415: iconst_0
    //   1416: istore 14
    //   1418: iconst_0
    //   1419: istore 11
    //   1421: iload 10
    //   1423: istore 12
    //   1425: iload 14
    //   1427: istore 10
    //   1429: goto -173 -> 1256
    //   1432: astore 16
    //   1434: iconst_m1
    //   1435: istore_3
    //   1436: ldc_w 1578
    //   1439: astore 15
    //   1441: iconst_0
    //   1442: istore 14
    //   1444: iload 10
    //   1446: istore 12
    //   1448: iload 14
    //   1450: istore 10
    //   1452: goto -196 -> 1256
    //   1455: astore 16
    //   1457: iload 10
    //   1459: istore 14
    //   1461: iload 12
    //   1463: istore 10
    //   1465: iload 14
    //   1467: istore 12
    //   1469: goto -213 -> 1256
    //   1472: iconst_m1
    //   1473: istore 6
    //   1475: ldc_w 1578
    //   1478: astore 16
    //   1480: iconst_0
    //   1481: istore 10
    //   1483: iconst_0
    //   1484: istore 11
    //   1486: iconst_0
    //   1487: istore 12
    //   1489: bipush 10
    //   1491: istore_3
    //   1492: iload_2
    //   1493: istore 4
    //   1495: ldc_w 428
    //   1498: astore 15
    //   1500: iload 6
    //   1502: istore_2
    //   1503: goto -771 -> 732
    //   1506: iconst_m1
    //   1507: istore 6
    //   1509: ldc_w 1578
    //   1512: astore 16
    //   1514: iconst_0
    //   1515: istore 10
    //   1517: iconst_0
    //   1518: istore 11
    //   1520: iconst_0
    //   1521: istore 12
    //   1523: iload_2
    //   1524: istore 4
    //   1526: ldc_w 428
    //   1529: astore 15
    //   1531: iload 6
    //   1533: istore_2
    //   1534: goto -802 -> 732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1537	0	this	NewFlowCameraActivity
    //   0	1537	1	paramInt	int
    //   68	1466	2	i	int
    //   288	1204	3	j	int
    //   514	1011	4	k	int
    //   70	978	5	m	int
    //   705	827	6	i1	int
    //   59	1000	7	i2	int
    //   193	581	8	i3	int
    //   205	571	9	i4	int
    //   213	1303	10	bool1	boolean
    //   612	907	11	bool2	boolean
    //   623	899	12	bool3	boolean
    //   233	554	13	bool4	boolean
    //   709	757	14	bool5	boolean
    //   14	1516	15	localObject1	Object
    //   225	885	16	localObject2	Object
    //   1238	42	16	localException1	Exception
    //   1292	1	16	localObject3	Object
    //   1406	1	16	localException2	Exception
    //   1432	1	16	localException3	Exception
    //   1455	1	16	localException4	Exception
    //   1478	35	16	str1	String
    //   229	1173	17	localObject4	Object
    //   328	987	18	localObject5	Object
    //   590	222	19	localObject6	Object
    //   123	766	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   581	603	1238	java/lang/Exception
    //   603	614	1406	java/lang/Exception
    //   614	625	1432	java/lang/Exception
    //   628	641	1455	java/lang/Exception
    //   648	659	1455	java/lang/Exception
    //   666	679	1455	java/lang/Exception
  }
  
  private void Gl(int paramInt)
  {
    ram.i("PTV.NewFlowCameraActivity", "start generating manifest file...");
    long l = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Qqz.a(new aars(this, l, paramInt));
  }
  
  private void Gn(int paramInt)
  {
    aqmj.b(BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit().putInt("camera", paramInt));
  }
  
  private boolean WR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.axh())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_fg_of_type_AndroidWidgetButton.isEnabled())) {
      return false;
    }
    return true;
  }
  
  private boolean WT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "filter=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf;
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
      if ((localObject != null) && (!TextUtils.isEmpty(((FilterDesc)localObject).name))) {
        aaqi.h("", "0X8007805", "", "", ((FilterDesc)localObject).name, "");
      }
    }
    paramInt2 = 109;
    if ((paramInt1 == 10004) || (paramInt1 == 10010) || (paramInt1 == 10000) || (paramInt1 == 10007)) {
      paramInt2 = 1133;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("enable_hw_encode", true);
    if (this.jdField_a_of_type_Aasb != null) {
      ((Bundle)localObject).putString("mCurrentTemplatePath", this.jdField_a_of_type_Aasb.bec);
    }
    ((Bundle)localObject).putInt("entrance_type", th());
    ((Bundle)localObject).putDouble("extra_bless_latitude", this.bo);
    ((Bundle)localObject).putDouble("extra_bless_longitude", this.bp);
    paramInt3 = getIntent().getIntExtra("edit_video_type", 0);
    label202:
    long l;
    int i;
    boolean bool1;
    label265:
    boolean bool2;
    label276:
    boolean bool3;
    if (this.byr)
    {
      ras.wN(3);
      if (paramInt1 != 10003) {
        break label565;
      }
      paramInt3 = 5;
      if (this.byr) {
        paramInt3 = 6;
      }
      paramString1 = new EditTakeVideoSource(paramString1, paramString2, paramLocalMediaInfo);
      l = super.getIntent().getLongExtra("troop_uin", 0L);
      i = paramInt1;
      if (paramInt1 != 10002) {
        break label754;
      }
      i = 10002;
      if (th() != 16) {
        break label571;
      }
      bool1 = true;
      if (th() != 5) {
        break label577;
      }
      bool2 = true;
      bool3 = super.getIntent().getBooleanExtra("ignorePersonalPublish", false);
      ram.a("PTV.NewFlowCameraActivity", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if ((!bool1) && (!bool2) && (!bool3)) {
        break label981;
      }
    }
    label565:
    label571:
    label577:
    label981:
    for (paramInt1 = 4358509;; paramInt1 = 4374893)
    {
      paramInt2 = paramInt1;
      if (l != 0L) {
        paramInt2 = paramInt1 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
      }
      if (this.bxL)
      {
        paramInt1 = paramInt2;
        if (paramLocalMediaInfo.mDuration >= 11000L) {}
      }
      else
      {
        paramInt1 = paramInt2 & 0xFFFF7FFF;
      }
      ((Bundle)localObject).putLong("startEditVideoTime", SystemClock.uptimeMillis());
      ((Bundle)localObject).putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      ((Bundle)localObject).putLong("story_topic_id", getIntent().getLongExtra("story_topic_id", 0L));
      ((Bundle)localObject).putBoolean("ignorePersonalPublish", bool3);
      ((Bundle)localObject).putInt("currentCamera", aaqh.cix);
      if (this.bxL)
      {
        paramInt2 = (int)Math.ceil((float)paramLocalMediaInfo.mDuration * 1.0F / 10000.0F);
        if (paramInt2 < 1)
        {
          ram.e("PTV.NewFlowCameraActivity", "intentToEditVideoActivityFromStory error. expectFragmentCount < 1");
          return;
          if (paramInt3 == 10004)
          {
            ras.wN(2);
            break;
          }
          if (paramInt3 == 10000)
          {
            ras.wN(1);
            break;
          }
          if (paramInt3 == 10003)
          {
            ras.wN(4);
            break;
          }
          if (paramInt3 == 10010)
          {
            ras.wN(8);
            break;
          }
          ras.wN(0);
          break;
          paramInt3 = 2;
          break label202;
          bool1 = false;
          break label265;
          bool2 = false;
          break label276;
        }
        if (paramInt2 > 1) {
          rar.a("video_shoot", "series_shoot", 0, 0, new String[0]);
        }
        ram.d("PTV.NewFlowCameraActivity", "intentToHWEditVideoActivity. expectFragmentCount = %d.", Integer.valueOf(paramInt2));
        ((Bundle)localObject).putInt("expect_fragment_count", paramInt2);
      }
      paramInt2 = paramInt1;
      if (this.mEntranceType == 102)
      {
        paramString2 = super.getIntent();
        paramInt3 = paramString2.getIntExtra("shareGroupType", 0);
        ((Bundle)localObject).putInt("shareGroupType", paramInt3);
        ((Bundle)localObject).putString("shareGroupId", paramString2.getStringExtra("shareGroupId"));
        ((Bundle)localObject).putString("shareGroupName", paramString2.getStringExtra("shareGroupName"));
        ((Bundle)localObject).putLong("groupUin", paramString2.getLongExtra("groupUin", -1L));
        ((Bundle)localObject).putInt("add_video_source", paramString2.getIntExtra("add_video_source", 0));
        paramInt1 |= 0x200000;
        paramInt2 = paramInt1;
        if (paramInt3 == 1) {
          paramInt2 = paramInt1 & 0xFFFDFFFF;
        }
      }
      for (paramInt3 = 1;; paramInt3 = 1)
      {
        label754:
        paramString2 = new EditVideoParams(paramInt3, paramInt2, paramString1, (Bundle)localObject);
        paramString2.mExtra.putBoolean("enable_hw_encode", true);
        if (l != 0L) {
          paramString2.mExtra.putLong("troop_uin", l);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "EditVideoParams params:" + paramString2.toString());
        }
        if ((this.byr) && (this.bnM == 0))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label960;
          }
          paramString1 = new Intent(this, EditWebVideoActivity.class);
          paramString1.putExtra("edit_video_call_back", this.callback);
        }
        for (;;)
        {
          paramString1.putExtra(EditVideoParams.class.getName(), paramString2);
          paramString1.putExtra("op_department", "grp_qq");
          paramString1.putExtra("op_type", "video_edit");
          paramString1.putExtra("stop_record_time", System.currentTimeMillis());
          paramString1.putExtra("entrance_type", this.mEntranceType);
          startActivityForResult(paramString1, i);
          overridePendingTransition(0, 0);
          this.byl = true;
          return;
          paramInt1 = 0;
          break;
          paramString1 = new Intent(this, EditVideoActivity.class);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    anhz.cGk = paramBundle.getBoolean("key_video_presend_enable", false);
    anhz.cGj = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      anhz.dGl = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.aH(paramBoolean))
    {
      this.bxa = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.hA(16);
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.hA(4);
  }
  
  private void a(PublishParam paramPublishParam)
  {
    PtvFilterUtils.hs(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, paramPublishParam.fakeVid);
    cxd();
    this.bwM = false;
    if (paramPublishParam.bsX == 0)
    {
      this.mReportParams.put("result_Event", String.valueOf(0));
      CS(true);
    }
    for (;;)
    {
      b(paramPublishParam);
      return;
      this.mReportParams.put("result_Event", String.valueOf(3));
      CS(false);
    }
  }
  
  private void a(boolean paramBoolean, adfg.a parama)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4);
    int i;
    aasq localaasq;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAdjustment", 2, "shift down triggered");
      }
      i = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_down_mark", 1);
      if (i >= this.ciX)
      {
        i = 0;
        if (i < this.vu.size())
        {
          localaasq = (aasq)this.vu.get(i);
          if ((localaasq.mHeight != anhm.dGd) || (localaasq.mWidth != anhm.dGc)) {
            break label426;
          }
          if (i != 0) {
            break label147;
          }
          ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_down_mark", 1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("DynamicAdjustment", 2, "the lowest resolution reached");
          }
        }
      }
    }
    label147:
    label426:
    do
    {
      for (;;)
      {
        return;
        localaasq = (aasq)this.vu.get(i - 1);
        ((SharedPreferences)localObject).edit().putString("SVDNAdjustment_quality_resolution", localaasq.mWidth + "*" + localaasq.mHeight).putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_up_mark", 1).putInt("SVDNAdjustment_quality_up_threshold", (int)(this.ciZ * this.bJ)).commit();
        if (aaqh.cix == 2) {}
        for (localObject = "back";; localObject = "front")
        {
          aarz.a((String)localObject, anhm.dGc + "*" + anhm.dGd, localaasq.mWidth + "*" + localaasq.mHeight, (int)(this.ciZ * this.bJ), this.cja, parama);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DynamicAdjustment", 2, "adjustment finished , resolution down to : " + localaasq.mWidth + "*" + localaasq.mHeight + "    threshold down to : " + this.ciZ * this.bJ);
          return;
        }
        i += 1;
        break;
        ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_down_mark", i + 1).putInt("SVDNAdjustment_quality_up_mark", 1).commit();
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicAdjustment", 2, "mark + 1 = " + (i + 1));
          return;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicAdjustment", 2, "shift up triggered");
          }
          i = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_up_mark", 1);
          if (i < this.ciY) {
            break label930;
          }
          i = 0;
          for (;;)
          {
            if (i >= this.vu.size()) {
              break label928;
            }
            localaasq = (aasq)this.vu.get(i);
            if ((localaasq.mHeight == anhm.dGd) && (localaasq.mWidth == anhm.dGc))
            {
              if (i == this.vu.size() - 1)
              {
                ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_up_mark", 1).commit();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("DynamicAdjustment", 2, "the highest resolution reached");
                return;
              }
              localaasq = (aasq)this.vu.get(i + 1);
              ((SharedPreferences)localObject).edit().putString("SVDNAdjustment_quality_resolution", localaasq.mWidth + "*" + localaasq.mHeight).putInt("SVDNAdjustment_quality_up_mark", 1).putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_down_threshold", (int)(this.cja * this.bK)).commit();
              if (aaqh.cix == 2) {}
              for (localObject = "back";; localObject = "front")
              {
                aarz.a((String)localObject, anhm.dGc + "*" + anhm.dGd, localaasq.mWidth + "*" + localaasq.mHeight, this.ciZ, (int)(this.cja * this.bK), parama);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("DynamicAdjustment", 2, "adjustment finished , resolution up to :  " + localaasq.mWidth + "*" + localaasq.mHeight + "    threshold up to : " + this.cja * this.bK);
                return;
              }
            }
            i += 1;
          }
        }
      }
      ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_up_mark", i + 1).putInt("SVDNAdjustment_quality_down_mark", 1).commit();
    } while (!QLog.isColorLevel());
    label928:
    label930:
    QLog.d("DynamicAdjustment", 2, "mark + 1 = " + (i + 1));
  }
  
  public static String ad(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return acfp.m(2131708996);
    case 1: 
      return acfp.m(2131708986);
    case 4: 
      return acfp.m(2131709012);
    case 16: 
      return acfp.m(2131709019);
    case 64: 
      return acfp.m(2131709025);
    }
    return acfp.m(2131709008);
  }
  
  private boolean ad(MotionEvent paramMotionEvent)
  {
    if (this.bxJ) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.cxV();
      }
    } while ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4) || (aaqh.cix == 1) || (this.byA));
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.y(f1, f2);
    paramMotionEvent = new anhk();
    paramMotionEvent.x = f1;
    paramMotionEvent.y = f2;
    paramMotionEvent.screenWidth = ((int)this.screenWidth);
    paramMotionEvent.dGb = ((int)this.screenHeight);
    paramMotionEvent.c = this.jdField_a_of_type_Aary;
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[handleMessage] touch focus:" + f1 + " " + f2);
    }
    aarz.cxz();
    this.mCamera.a(paramMotionEvent, new aarm(this));
    this.mCamera.dQn();
    ram.e("PTV.NewFlowCameraActivity", "cameraFocusView consume the touch event");
    aaqi.h("", "0X80075BD", "", "", "", "");
    return true;
  }
  
  @NonNull
  private Bitmap aq()
  {
    return this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth / 8, this.mPreviewHeight / 8, this.bwX, false, this.jdField_a_of_type_Aasx);
  }
  
  /* Error */
  private static Bitmap b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: aconst_null
    //   10: astore 4
    //   12: aload 4
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 2047	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore 5
    //   21: aload 5
    //   23: getstatic 2053	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokestatic 2059	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +216 -> 251
    //   38: aload_0
    //   39: invokeinterface 2064 1 0
    //   44: istore_2
    //   45: iload_2
    //   46: ifeq +205 -> 251
    //   49: aload_0
    //   50: aload_0
    //   51: ldc_w 2066
    //   54: invokeinterface 2070 2 0
    //   59: invokeinterface 2072 2 0
    //   64: istore_1
    //   65: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +30 -> 98
    //   71: ldc_w 447
    //   74: iconst_2
    //   75: new 395	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 2074
    //   85: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 461	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 5
    //   100: iload_1
    //   101: i2l
    //   102: iconst_3
    //   103: aconst_null
    //   104: invokestatic 2080	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +15 -> 124
    //   112: aload_0
    //   113: ifnull +9 -> 122
    //   116: aload_0
    //   117: invokeinterface 2083 1 0
    //   122: aload_3
    //   123: areturn
    //   124: aload_0
    //   125: invokeinterface 2086 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne +113 -> 245
    //   135: aload_3
    //   136: astore 4
    //   138: aload_0
    //   139: ifnull -127 -> 12
    //   142: aload_0
    //   143: invokeinterface 2083 1 0
    //   148: aload_3
    //   149: areturn
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: invokevirtual 2087	java/lang/Exception:printStackTrace	()V
    //   159: aload_0
    //   160: astore 4
    //   162: aload_3
    //   163: ifnull -151 -> 12
    //   166: aload_3
    //   167: invokeinterface 2083 1 0
    //   172: aload_0
    //   173: areturn
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +9 -> 187
    //   181: aload_0
    //   182: invokeinterface 2083 1 0
    //   187: aload_3
    //   188: athrow
    //   189: astore_3
    //   190: goto -13 -> 177
    //   193: astore 4
    //   195: aload_3
    //   196: astore_0
    //   197: aload 4
    //   199: astore_3
    //   200: goto -23 -> 177
    //   203: astore 4
    //   205: aconst_null
    //   206: astore 5
    //   208: aload_0
    //   209: astore_3
    //   210: aload 5
    //   212: astore_0
    //   213: goto -59 -> 154
    //   216: astore 4
    //   218: aload_0
    //   219: astore 5
    //   221: aload_3
    //   222: astore_0
    //   223: aload 5
    //   225: astore_3
    //   226: goto -72 -> 154
    //   229: astore_3
    //   230: aload_0
    //   231: astore 5
    //   233: aload 4
    //   235: astore_0
    //   236: aload_3
    //   237: astore 4
    //   239: aload 5
    //   241: astore_3
    //   242: goto -88 -> 154
    //   245: aload_3
    //   246: astore 4
    //   248: goto -199 -> 49
    //   251: aconst_null
    //   252: astore_3
    //   253: goto -118 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramContext	Context
    //   64	37	1	i	int
    //   44	88	2	bool	boolean
    //   1	166	3	localBitmap1	Bitmap
    //   174	14	3	localObject1	Object
    //   189	7	3	localObject2	Object
    //   199	27	3	localObject3	Object
    //   229	8	3	localException1	Exception
    //   241	12	3	localObject4	Object
    //   3	134	4	localBitmap2	Bitmap
    //   150	5	4	localException2	Exception
    //   160	1	4	localContext	Context
    //   193	5	4	localObject5	Object
    //   203	1	4	localException3	Exception
    //   216	18	4	localException4	Exception
    //   237	10	4	localObject6	Object
    //   19	221	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	150	java/lang/Exception
    //   21	34	174	finally
    //   38	45	189	finally
    //   49	98	189	finally
    //   98	108	189	finally
    //   124	131	189	finally
    //   154	159	193	finally
    //   38	45	203	java/lang/Exception
    //   124	131	216	java/lang/Exception
    //   49	98	229	java/lang/Exception
    //   98	108	229	java/lang/Exception
  }
  
  private void b(PublishParam paramPublishParam)
  {
    aaqq.a locala = new aaqq.a();
    locala.E = this;
    locala.bdL = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG;
    locala.jdField_a_of_type_Aaqj = this.jdField_a_of_type_Aaqj;
    locala.mAudioFilePath = paramPublishParam.audioFilePath;
    int i;
    boolean bool;
    label177:
    String str;
    if (paramPublishParam.saveMode <= 5)
    {
      i = paramPublishParam.saveMode;
      locala.ciH = i;
      locala.aAu = paramPublishParam.videoFilePath;
      locala.mThumbFilePath = paramPublishParam.thumbPath;
      locala.mThumbWidth = 0;
      locala.gP = 0;
      locala.bo = this.bo;
      locala.bp = this.bp;
      locala.mContent = this.mContent;
      locala.mPriv = this.mPriv;
      locala.eo = this.eo;
      locala.bxk = this.bxz;
      locala.topicId = this.topicId;
      locala.topicSyncQzone = this.topicSyncQzone;
      if (paramPublishParam.syncToStory != 1) {
        break label344;
      }
      bool = true;
      locala.syncToStory = bool;
      if (this.ciS == 10007) {
        locala.bxm = true;
      }
      locala.fakeVid = paramPublishParam.fakeVid;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
      i = j;
      if (j <= 0)
      {
        i = j;
        if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
          i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
        }
      }
      locala.ciI = i;
      locala.ciC = ((int)paramPublishParam.videoDuration);
      str = "";
      paramPublishParam = (SessionInfo)getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (paramPublishParam == null) {
        break label350;
      }
      str = paramPublishParam.aTl;
      i = paramPublishParam.cZ;
      paramPublishParam = paramPublishParam.troopUin;
    }
    for (;;)
    {
      locala.mUin = str;
      locala.mUinType = i;
      locala.mTroopUin = paramPublishParam;
      new aaqq(locala).execute(new Void[0]);
      return;
      i = 0;
      break;
      label344:
      bool = false;
      break label177;
      label350:
      paramPublishParam = "";
      i = 0;
    }
  }
  
  private void bQ(Bundle paramBundle)
  {
    this.bxe = paramBundle.getBoolean("enable_local_video", false);
    this.bxz = paramBundle.getBoolean("enable_edit_video", false);
    this.bwI = paramBundle.getBoolean("is_qzone_vip", false);
    this.topicId = paramBundle.getString("topic_id");
    if (!TextUtils.isEmpty(this.topicId)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isTopic = bool;
      this.bxC = paramBundle.getBoolean("enter_ptu", false);
      this.bxH = paramBundle.getBoolean("enable_priv_list", true);
      this.bxD = paramBundle.getBoolean("enable_input_text", true);
      this.bxE = paramBundle.getBoolean("enable_sync_qzone", false);
      this.bxF = paramBundle.getBoolean("enable_origin_video", false);
      this.bxF = paramBundle.getBoolean("enable_origin_video", false);
      this.bdO = paramBundle.getString("confirm_text");
      this.bxG = paramBundle.getBoolean("enable_edit_button", true);
      this.bxI = paramBundle.getBoolean("enable_local_button", true);
      this.bxf = paramBundle.getBoolean("enable_front", false);
      this.cit = paramBundle.getInt("set_sdcard_min_size", 0);
      this.ciu = paramBundle.getInt("from_type", 0);
      this.civ = paramBundle.getInt("clip_strategy", 1);
      aaqi.Gf(this.ciS);
      if ((this.cit >= 57671680L) && (this.cit <= 314572800L)) {
        anld.ama = this.cit;
      }
      if (this.bxL) {
        anld.ama = anld.amb;
      }
      this.mRefer = paramBundle.getString("short_video_refer");
      this.bdA = paramBundle.getString("set_user_callback");
      d(paramBundle, this.mRefer);
      return;
    }
  }
  
  private void bc(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if ((this.mTip == null) || (this.jdField_n_of_type_AndroidWidgetSeekBar == null)) {
      return;
    }
    this.mTip.setText(acfp.m(2131709021) + paramInt + "%");
    if (this.mTipLayoutParams == null) {
      this.mTipLayoutParams = ((RelativeLayout.LayoutParams)this.mTip.getLayoutParams());
    }
    if (this.mThumb_60 != null) {
      j = this.mThumb_60.getIntrinsicWidth();
    }
    for (int i = ((RelativeLayout.LayoutParams)this.jdField_n_of_type_AndroidWidgetSeekBar.getLayoutParams()).leftMargin + j / 2;; i = 0)
    {
      int k = this.mTip.getWidth();
      int m = this.jdField_n_of_type_AndroidWidgetSeekBar.getWidth();
      this.mTipLayoutParams.leftMargin = (i - k / 2 + (m - j) * paramInt / 100);
      if (paramInt < 50) {}
      for (this.mTipLayoutParams.leftMargin = ((int)(this.mTipLayoutParams.leftMargin - (50.0F - paramInt) / 50.0F * wja.dp2px(7.0F, getResources())));; this.mTipLayoutParams.leftMargin = ((int)(this.mTipLayoutParams.leftMargin + (paramInt - 50.0F) / 50.0F * wja.dp2px(5.0F, getResources()))))
      {
        this.mTip.requestLayout();
        if ((paramBoolean) || (this.jdField_n_of_type_AndroidWidgetSeekBar.getVisibility() == 0)) {
          break;
        }
        this.mTip.setVisibility(4);
        return;
      }
    }
  }
  
  private void bd(int paramInt, boolean paramBoolean)
  {
    int i;
    if ((this.byr) && (!this.byu))
    {
      i = 1;
      this.d.clearAnimation();
      if (i == 0) {
        break label42;
      }
      this.d.setVisibility(8);
    }
    label42:
    do
    {
      return;
      i = 0;
      break;
      if (paramInt != 0) {
        break label77;
      }
      this.d.setVisibility(0);
    } while (!paramBoolean);
    anlc.a(this.d, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    return;
    label77:
    this.d.setVisibility(paramInt);
  }
  
  public static boolean bg(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private void bs(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.bxP = false;
    }
    if (this.byc)
    {
      if (aaqh.cix != 1) {
        break label47;
      }
      CO(false);
    }
    while (this.ciS == 10002)
    {
      AH(paramString);
      return;
      label47:
      if (this.cfl == 0) {
        this.mCamera.PS(false);
      }
    }
    if (paramString == null) {}
    label909:
    label1039:
    for (int k = -3;; k = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "finishShotPhoto " + paramString);
      }
      int j = getIntent().getIntExtra("edit_video_type", 0);
      boolean bool1;
      int i;
      int m;
      int i2;
      if (j != 10002)
      {
        bool1 = true;
        i = getIntent().getIntExtra("extra.busi_type", 2);
        m = getIntent().getIntExtra("entry_source", 0);
        if ((i == 3) && ((m == 1) || (m == 2)))
        {
          h("612", "5", "0", true);
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "QZone click take photo report");
          }
        }
        if (j == 10002) {
          i = 1;
        }
        i2 = getIntent().getIntExtra("edit_video_type", 0);
        j = 0;
        if (!this.byr) {
          break label909;
        }
        j = 3;
        i = 6;
      }
      label241:
      boolean bool2;
      Object localObject;
      label992:
      label998:
      label1018:
      for (;;)
      {
        bool2 = getIntent().getBooleanExtra("go_publish_activity", false);
        localObject = EditPicActivity.a(this, paramString, true, true, true, bool1, true, false, false, false, i, th(), j, bool2, null);
        if (this.byr)
        {
          ((Intent)localObject).putExtra("shareto_web_mode", this.bnM);
          ((Intent)localObject).putExtra("edit_video_call_back", this.callback);
        }
        if (this.jdField_a_of_type_Aasb != null) {
          ((Intent)localObject).putExtra("mCurrentTemplatePath", this.jdField_a_of_type_Aasb.bec);
        }
        ((Intent)localObject).putExtra("qcamera_photo_filepath", paramString);
        ((Intent)localObject).putExtra("qcamera_rotate", this.mOrientation);
        if (aaqh.cix == 2) {}
        for (m = 0;; m = 1)
        {
          ((Intent)localObject).putExtra("camera_type", 103);
          ((Intent)localObject).putExtra("camera_front_back", m);
          ((Intent)localObject).putExtra("camera_capture_method", this.cfl);
          ((Intent)localObject).putExtra("babyq_ability", getIntent().getLongExtra("babyq_ability", 0L));
          if (i == 3)
          {
            ((Intent)localObject).putExtra("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
            ((Intent)localObject).putExtra("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
          }
          aaqi.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X8007818", null);
          int i1 = -1;
          bool2 = false;
          bool1 = bool2;
          i = i1;
          j = i1;
          try
          {
            if (this.jdField_a_of_type_Aasb != null)
            {
              j = i1;
              paramString = this.jdField_a_of_type_Aasb.a();
              bool1 = bool2;
              i = i1;
              if (paramString != null)
              {
                j = i1;
                i1 = Integer.valueOf(paramString.id).intValue();
                j = i1;
                boolean bool3 = paramString.hasGesture();
                bool1 = bool2;
                i = i1;
                if (bool3)
                {
                  bool1 = true;
                  i = i1;
                }
              }
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              String str;
              bool1 = bool2;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.i("PTV.NewFlowCameraActivity", 2, "id not integer ");
                bool1 = bool2;
                i = j;
                continue;
                bool1 = false;
                continue;
                if (i == 10010)
                {
                  paramString.putExtra("sub_business_id", 104);
                  continue;
                  paramString.putExtra("editpic_cameratype", 2);
                  continue;
                  continue;
                  paramString = (String)localObject;
                }
              }
            }
          }
          ((Intent)localObject).putExtra("camera_filter_id", i);
          ((Intent)localObject).putExtra("camera_has_gesture_filter", bool1);
          if (k != -1) {
            break label992;
          }
          bool1 = true;
          aarz.d(bool1, m, i, this.cfl);
          paramString = (SessionInfo)((Intent)localObject).getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
          if (paramString == null) {
            break label1033;
          }
          ((Intent)localObject).putExtra("uin", paramString.aTl);
          ((Intent)localObject).putExtra("uintype", paramString.cZ);
          ((Intent)localObject).putExtra("troop_uin", paramString.troopUin);
          ((Intent)localObject).putExtra("uinname", paramString.aTn);
          paramString = wja.a((Intent)localObject, null);
          i = getIntent().getIntExtra("edit_video_type", 0);
          if (i != 10004) {
            break label998;
          }
          paramString.putExtra("sub_business_id", 101);
          localObject = SplashActivity.class.getName();
          str = getIntent().getStringExtra("f_a_a_n");
          if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
            break label1030;
          }
          localObject = str;
          aarz.AK("finish");
          aarz.cW(paramString);
          str = paramString.getStringExtra("pic_confirm_text");
          if (str != null) {
            paramString.putExtra("extra_publish_text", str);
          }
          paramString.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", (String)localObject);
          paramString.putExtra("key_activity_code", getIntent().getStringExtra("key_activity_code"));
          if ((i2 == 10000) || (i2 == 10004) || (i2 == 10010))
          {
            if (!paramBoolean) {
              break label1018;
            }
            paramString.putExtra("editpic_cameratype", 1);
          }
          startActivityForResult(paramString, 1012);
          aaqi.h("", "0X80075C1", "", "", "", "");
          return;
          bool1 = false;
          break;
          if (i2 == 10004)
          {
            j = 2;
            break label241;
          }
          if (i2 == 10000)
          {
            j = 1;
            break label241;
          }
          if (i2 != 10010) {
            break label1039;
          }
          j = 10;
          break label241;
        }
      }
    }
  }
  
  private static Bitmap c(Context paramContext)
  {
    return new rno(paramContext).Z();
  }
  
  private void c(aasx paramaasx)
  {
    boolean bool = true;
    float f1 = this.mPreviewWidth * 1.0F / this.mPreviewHeight;
    if (this.mQ >= f1) {
      bool = false;
    }
    int i;
    if (RMVideoStateMgr.aH(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAl))
    {
      i = 16;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "changeVideoPreviewMapSizeclip_width=" + paramaasx.cjG + "clip_height=" + paramaasx.cjH + "m_dst_width=" + paramaasx.cjI + "dst_width=" + paramaasx.cjJ + "aligned_byte=" + i + "constScreenWidth=" + bool);
      }
      if (!bool) {
        break label398;
      }
      m = paramaasx.cjG % i;
      i1 = paramaasx.cjH % i;
      paramaasx.cjG -= m;
      paramaasx.cjH -= i1;
      if (!this.bwX) {
        break label382;
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, paramaasx, this.ciq);
    }
    int j;
    int k;
    for (;;)
    {
      paramaasx.cjI = paramaasx.cjG;
      paramaasx.cjJ = paramaasx.cjH;
      j = i1;
      k = m;
      if (aniq.dHd > 0)
      {
        j = i1;
        k = m;
        if (aniq.dHd < aniq.dHe)
        {
          f1 = aniq.dHd * 1.0F / aniq.dHe;
          paramaasx.cjI = ((int)(paramaasx.cjG * f1));
          paramaasx.cjJ = ((int)(f1 * paramaasx.cjH));
          k = m;
          j = i1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "changeVideoPreviewMapSizem_clip_width=" + k + "m_clip_height=" + j + "aligned_byte=" + i + "spec.clip_width=" + paramaasx.cjG + "spec.clip_height=" + paramaasx.cjH);
      }
      return;
      i = 4;
      break;
      label382:
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, paramaasx, this.cir);
    }
    label398:
    int m = paramaasx.cjG % i;
    int i1 = paramaasx.cjH % i;
    paramaasx.cjG -= m;
    paramaasx.cjH -= i1;
    if (this.bwX) {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, paramaasx, this.ciq);
    }
    for (;;)
    {
      paramaasx.cjI = paramaasx.cjG;
      paramaasx.cjJ = paramaasx.cjH;
      j = i1;
      k = m;
      if (aniq.dHd <= 0) {
        break;
      }
      j = i1;
      k = m;
      if (aniq.dHd >= aniq.dHe) {
        break;
      }
      f1 = aniq.dHd * 1.0F / aniq.dHe;
      paramaasx.cjI = ((int)(paramaasx.cjG * f1));
      paramaasx.cjJ = ((int)(f1 * paramaasx.cjH));
      j = i1;
      k = m;
      break;
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, paramaasx, this.cir);
    }
  }
  
  private void c(Intent paramIntent, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.ciS = paramIntent.getIntExtra("edit_video_type", 0);
    this.byr = paramIntent.getBooleanExtra("from_web_to_share", false);
    if (paramBundle != null)
    {
      this.byn = paramBundle.getBoolean("flow_camera_disable_beauty_filter", true);
      this.byo = anki.isBeautySwitchOpen();
      this.bys = paramBundle.getBoolean("support_video_shot", true);
      this.byt = paramBundle.getBoolean("support_photo_shot", true);
      this.cjc = paramBundle.getInt("default_camera_mode", 1);
      this.byv = paramBundle.getBoolean("default_open_template", false);
      this.byw = paramBundle.getBoolean("default_use_first_template", false);
      this.byu = paramBundle.getBoolean("default_show_template_btn", true);
      this.bnM = paramBundle.getInt("default_deal_type", 1);
      this.cjd = paramBundle.getInt("support_heart_template", 0);
      this.bdU = paramBundle.getString("h5_activity_id", "");
      localStringBuilder.append("supportVideo:").append(this.bys);
      localStringBuilder.append(", supportPhoto:").append(this.byt);
      localStringBuilder.append(", cameramode:").append(this.cjc);
      localStringBuilder.append(", beauty:").append(this.byn);
      localStringBuilder.append(", unfoldTemplate:").append(this.byv);
      localStringBuilder.append(", usefirstTemplate:").append(this.byw);
      localStringBuilder.append(", showPtvBtn:").append(this.byu);
      localStringBuilder.append(", dealType:").append(this.bnM);
      localStringBuilder.append(", supportHeartTemplate:").append(this.cjd);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "init data info:" + localStringBuilder.toString());
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
    localIntentFilter.addAction("tencent.video.q2v.startUploadPTV");
    localIntentFilter.addAction("tencent.video.q2v.nightMode");
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
  
  private void cvH()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.bdz);
    String str = avtz.a(this.cif, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.cif = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void cwC()
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "createHwEncode: Build.MANUFACTURER = " + Build.MANUFACTURER + " Build.MODEL = " + Build.MODEL + " HwEnvData.supportRecordAndEncode() = " + anhz.axg());
    }
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i;
    if ((localObject1 != null) && (anhz.axg()) && (this.bxa) && (this.ciu == 0) && (VideoEnvironment.lw(2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf))
    {
      localObject2 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.aF(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, ((aasx)localObject2).cjI, ((aasx)localObject2).cjJ);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.jA(-1, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cjL * 1000);
      if (aniq.ckG != 16) {
        break label329;
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
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setHwEncoder(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_Ania.c.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = alvs.a().a();
        cwk();
        localObject1 = ((alvv)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, 2);
        this.bdE = ((alvp)localObject1).yB();
        aqip.bj(this.bdE, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((anid)localObject1, null, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.byY);
        return;
        label329:
        if (aniq.ckG != 12) {
          break label354;
        }
        i = 2;
        break;
        if (aniq.mAudioFormat != 3) {
          j = 2;
        }
      }
      label354:
      i = 1;
    }
  }
  
  private void cwO()
  {
    this.bxP = true;
    File localFile = new File(this.bdF);
    this.cfl = 1;
    CameraCover localCameraCover = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
    aarv localaarv = new aarv(this);
    aary localaary = this.jdField_a_of_type_Aary;
    int i = aary.cjn;
    localaary = this.jdField_a_of_type_Aary;
    localCameraCover.a(localFile, localaarv, i, aary.mMirror, 1, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjG, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjH);
    aaqi.h("", "0X80075BE", "", "", "", "");
  }
  
  private void cwP()
  {
    runOnUiThread(new NewFlowCameraActivity.10(this));
  }
  
  private void cwT()
  {
    this.vu = new ArrayList();
    Object localObject = VideoEnvironment.a.nm;
    int[] arrayOfInt = VideoEnvironment.a.nl;
    if (localObject.length != arrayOfInt.length)
    {
      QLog.e("DynamicAdjustment", 2, "config data : heights length not match the widths length");
      return;
    }
    int i = 0;
    while (i < arrayOfInt.length)
    {
      this.vu.add(new aasq(arrayOfInt[i], localObject[i]));
      i += 1;
    }
    Collections.sort(this.vu, new aaqw(this));
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.KP(500);
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4);
    this.ciX = ((SharedPreferences)localObject).getInt("SVDNAdjustment_max_downmark", 2);
    this.ciY = ((SharedPreferences)localObject).getInt("SVDNAdjustment_max_upmark", 2);
    this.ciV = ((SharedPreferences)localObject).getInt("SVDNAdjustment_up_threshold_base", 11);
    this.ciW = ((SharedPreferences)localObject).getInt("SVDNAdjustment_down_threshold_base", 25);
    this.bJ = ((SharedPreferences)localObject).getFloat("SVDNAdjustment_up_threshold_coefficient", 0.7F);
    this.bK = ((SharedPreferences)localObject).getFloat("SVDNAdjustment_down_threshold_coefficient", 1.3F);
    this.ciZ = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_up_threshold", this.ciV);
    this.cja = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_down_threshold", this.ciW);
    this.rz = ((SharedPreferences)localObject).getFloat("SVDNAdjustment_data_type", 0.5F);
    if ((this.rz < 0.0F) || (this.rz >= 1.0F)) {
      this.rz = 0.5F;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Init dynamic adjustment params. maxDownMark : " + this.ciX + "  maxUpMark : " + this.ciY + "  upThresholdBase : " + this.ciV + "  downThresholdBase : " + this.ciW + "  upThresholdcoefficient : " + this.bJ + "  downThresholdcoefficient : " + this.bK + "  upThreshold : " + this.ciZ + "  downThreshold : " + this.cja);
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(new aaqx(this, (SharedPreferences)localObject));
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.cRd();
  }
  
  private void cwU()
  {
    int k = 0;
    if (!anih.agb()) {
      aaqh.cix = 2;
    }
    int j;
    do
    {
      return;
      if ((this.bxC) || ((this.ciS == 10007) && (this.cjc == 1))) {}
      for (int i = 1;; i = 0)
      {
        j = k;
        if (this.ciS == 10007)
        {
          j = k;
          if (this.cjc == 2) {
            j = 1;
          }
        }
        if (i == 0) {
          break;
        }
        aaqh.cix = 1;
        return;
      }
    } while (j == 0);
    aaqh.cix = 2;
  }
  
  private void cwV()
  {
    if ((aaqh.cix == 1) && (this.jdField_a_of_type_Aasb == null) && (this.byg) && (!this.byr)) {
      cxf();
    }
    if (this.ciS == 10011) {
      cxf();
    }
    if (this.ciS == 10003) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "bless unfold and choose the first template" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
      }
      cxf();
      if (PtvTemplateManager.a(this.appInterface).dI().size() > 0)
      {
        this.mListView.setRestoreX(this.jdField_a_of_type_Aasb.vD());
        this.jdField_a_of_type_Aasb.a((PtvTemplateManager.PtvTemplateInfo)PtvTemplateManager.a(this.appInterface).dI().get(0));
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.d("PtvTemplateManager", 2, "bless unfold PtvTemplate error!", localException1);
      }
    }
    if (this.byr) {}
    try
    {
      if ((this.byv) && (this.byu))
      {
        cxf();
        if (this.byw)
        {
          ArrayList localArrayList = PtvTemplateManager.a(this.appInterface).a(true, false, 2);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            this.mListView.setRestoreX(this.jdField_a_of_type_Aasb.vD());
            this.jdField_a_of_type_Aasb.a((PtvTemplateManager.PtvTemplateInfo)localArrayList.get(0));
          }
        }
      }
      this.byx = true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PTV.NewFlowCameraActivity", 2, "shareToWeb template exception:", localException2);
        }
      }
    }
    if (this.bxC)
    {
      cxf();
      BaseApplicationImpl.getApplication().getSharedPreferences(anku.TAG, 4).edit().putBoolean("is_showed_ptv_guide", true).commit();
    }
  }
  
  private void cwW()
  {
    SharedPreferences localSharedPreferences;
    if (this.bxV)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
      if (!localSharedPreferences.getBoolean("flow_filter_reddot_key", false)) {
        localSharedPreferences.edit().putBoolean("flow_filter_reddot_key", true).commit();
      }
    }
    if (this.bxW)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + ((AppInterface)getAppRuntime()).getCurrentAccountUin(), 4);
      if (!localSharedPreferences.getBoolean("flow_filter_reddot_key", false)) {
        localSharedPreferences.edit().putBoolean("flow_filter_reddot_key", true).commit();
      }
    }
  }
  
  private void cwX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initVideoFilter");
    }
    ThreadManager.post(new NewFlowCameraActivity.21(this), 5, null, true);
  }
  
  private void cwY()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(null);
    alvp localalvp = alvs.a().a().a(this.bdE);
    if (localalvp != null) {
      localalvp.Ts(103);
    }
    for (;;)
    {
      aasp.c("shortvideo_close", null);
      return;
      cwj();
    }
  }
  
  private void cwk()
  {
    float f1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      aasx localaasx = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.bo, this.bp, f1, localaasx.cjI);
    }
  }
  
  private void cwo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new HandleEndVideoEncode(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void cwy()
  {
    anlc.a(this.nj, false, 250);
    v(1002, 0, null);
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().cxZ();
    if (this.fk != null) {
      this.fk.setEnabled(true);
    }
    this.d.setEnabled(true);
  }
  
  private void cxa()
  {
    alvp localalvp = alvs.a().a().a(this.bdE);
    if (localalvp != null) {
      localalvp.Ts(103);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.cyS();
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
      {
        int i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.r(0, i, true);
      }
      cxk();
      return;
      cwj();
    }
  }
  
  private void cxb()
  {
    if (this.byc)
    {
      this.fl.setBackgroundResource(2130844736);
      this.fl.setContentDescription(acfp.m(2131709026));
      this.mCamera.PT(true);
      return;
    }
    this.fl.setBackgroundResource(2130844734);
    this.fl.setContentDescription(acfp.m(2131709013));
    this.mCamera.PT(false);
  }
  
  private void cxc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setNightStatus " + this.byd);
    }
    if (this.byd)
    {
      this.fm.setBackgroundResource(2130844740);
      this.fm.setContentDescription(acfp.m(2131709000));
      return;
    }
    this.fm.setBackgroundResource(2130844738);
    this.fm.setContentDescription(acfp.m(2131709010));
  }
  
  private void cxd()
  {
    if ((this.mOrientation == 90) || (this.mOrientation == 270)) {}
    for (int i = 1;; i = 0)
    {
      if (aaqh.cix == 1) {}
      for (int j = 1;; j = 0)
      {
        h("608", "1", "0", true);
        boolean bool = WW();
        Properties localProperties = new Properties();
        localProperties.setProperty("shortvideo_duration", "" + (int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL);
        localProperties.setProperty("shortvideo_rotation", "" + i);
        localProperties.setProperty("shortvideo_camera", "" + j);
        Object localObject1;
        label328:
        int k;
        if (!bool)
        {
          aaqi.h("", "0X8006A16", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, "");
          aasp.c("shortvideo_send_noeffects", localProperties);
          str1 = "";
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_duration", String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL));
          ((HashMap)localObject2).put("param_orientation", String.valueOf(i));
          if (!TextUtils.isEmpty(str1)) {
            ((HashMap)localObject2).put("param_template", str1);
          }
          if (this.appInterface != null)
          {
            String str2 = this.appInterface.getCurrentAccountUin();
            anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
            if (bool)
            {
              localObject1 = "actPtvUseTemplate";
              localanpc.collectPerformance(str2, (String)localObject1, true, 0L, 0L, (HashMap)localObject2, "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_Aasb != null)
            {
              localObject1 = this.jdField_a_of_type_Aasb.qD();
              if (localObject1 != null)
              {
                localObject2 = new Properties();
                ((Properties)localObject2).setProperty("shortvideo_template_id", "" + (String)localObject1);
                ((Properties)localObject2).setProperty("shortvideo_template_name", "" + str1);
                aasp.c("shortvideo_send_id1", (Properties)localObject2);
              }
            }
            aaqi.h("", "0X800795F", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, "");
            aasp.c("shortvideo_send", localProperties);
          }
        }
        else
        {
          label531:
          do
          {
            return;
            if (this.jdField_a_of_type_Aasb == null) {
              break;
            }
            str1 = this.jdField_a_of_type_Aasb.qD();
            aaqi.h("", "0X8006A19", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, str1);
            if (this.jdField_a_of_type_Aasb != null)
            {
              localObject1 = this.jdField_a_of_type_Aasb.a();
              if ((localObject1 != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject1).hasGesture())) {
                aaqi.h("", "0X80083B1", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, str1);
              }
            }
            aasp.c("shortvideo_send_effects", localProperties);
            if (this.jdField_a_of_type_Aasb == null) {
              break label768;
            }
            k = this.jdField_a_of_type_Aasb.getCurrentPosition();
          } while (k >= this.jdField_a_of_type_Aasb.mTemplateList.size());
        }
        label768:
        for (String str1 = ((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Aasb.mTemplateList.get(k)).name;; str1 = "")
        {
          aavi.a(this.appInterface, str1);
          break;
          str1 = "";
          break label531;
          localObject1 = "actPtvNotUseTemplate";
          break label328;
        }
      }
    }
  }
  
  private void cxe()
  {
    bxt = false;
    if (WW())
    {
      aaqi.ec("", "0X8006A17");
      alvp localalvp = alvs.a().a().a(this.bdE);
      if (localalvp == null) {
        break label114;
      }
      localalvp.Ts(103);
    }
    for (;;)
    {
      CF(true);
      if (this.bxS) {
        this.bxT = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "click left hasChangeCamera" + this.bxS);
      }
      cxk();
      return;
      aaqi.ec("", "0X8006A1B");
      break;
      label114:
      cwj();
    }
  }
  
  private void cxg()
  {
    this.byy = true;
    this.isCapturing = false;
    if (this.ws != null)
    {
      Animation localAnimation = this.ws.getAnimation();
      if (localAnimation != null)
      {
        localAnimation.cancel();
        localAnimation.setAnimationListener(null);
      }
      this.ws.clearAnimation();
      this.ws.setVisibility(4);
      this.wr.setVisibility(0);
    }
    if ((this.byr) && (this.bys) && (!this.byt) && (this.wr != null))
    {
      this.wr.clearAnimation();
      this.wr.setVisibility(0);
      if (this.bxw) {
        this.wr.setImageDrawable(null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "mCameraCapture clearAnimation!");
      }
    }
  }
  
  private void cxh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, "finishShootShortVideo");
    }
    aaqi.a(getIntent().getIntExtra("edit_video_type", -1), "", "", this.mReportParams);
    aaqi.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X8007817", null);
    Object localObject;
    if (this.byc)
    {
      if (aaqh.cix == 1) {
        CO(false);
      }
    }
    else
    {
      localObject = this.mVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
      int i = (int)((VelocityTracker)localObject).getXVelocity();
      if ((!this.isRecording) && (Math.abs(i) > this.mMinimumVelocity)) {
        this.mListView.fling(-i);
      }
      recycleVelocityTracker();
      cxg();
      if (!this.isRecording) {
        break label294;
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new HandleEndVideoEncode(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    }
    for (;;)
    {
      this.bxQ = true;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xf();
        this.isRecording = false;
      }
      this.Ml = SystemClock.uptimeMillis();
      this.cis += 1;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_UP isBlueAnimEnd=" + this.bxv);
      }
      if (this.bxv)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.Xt()) {
          break label403;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK()");
        }
        cwZ();
      }
      return;
      this.mCamera.PS(false);
      break;
      label294:
      localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(84.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(84.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.wr.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.wr.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label403:
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK nop");
    }
    U(this, 2131696921);
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
    }
    cancleProgressDailog();
    cwZ();
  }
  
  private void cxr()
  {
    if (this.bye) {
      this.fm.setVisibility(0);
    }
  }
  
  private void cxs()
  {
    if (anii.isFoundProduct(anii.KEY_DISABLE_FLASH))
    {
      this.fl.setEnabled(false);
      this.fl.setVisibility(8);
      return;
    }
    this.fl.setEnabled(true);
    this.fl.setVisibility(0);
  }
  
  private void cxt()
  {
    if (aaqh.cix == 1) {}
    for (String str = acfp.m(2131709022);; str = acfp.m(2131709004))
    {
      this.jdField_fg_of_type_AndroidWidgetButton.setContentDescription(acfp.m(2131709005) + str + acfp.m(2131708994));
      return;
    }
  }
  
  private void cxu()
  {
    sq("正在合成gif...");
    new b(this, this.mUIHandler, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$c, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj(), true).execute(new Void[0]);
  }
  
  private void cxv()
  {
    if (!this.byo) {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "mbeBeautySurport is false");
      }
    }
    while (!this.byn) {
      return;
    }
    this.jdField_n_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131363379));
    this.jdField_n_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_n_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_c_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_w_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_w_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aart(this));
    this.mThumb_60 = getBaseContext().getResources().getDrawable(2130846622);
    this.mTip = ((TextView)findViewById(2131363381));
    this.mTipLayoutParams = null;
  }
  
  private void cxw()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.x(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    avpw.c(this, this.appInterface.getCurrentAccountUin(), localIntent, -1);
  }
  
  private void doOnResume()
  {
    aaso.a(this);
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_is_cancel_from_music", 4);
    boolean bool = localSharedPreferences.getBoolean("sp_is_cancel_from_music_key", true);
    if ((!this.bwW) || (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 1))
    {
      ThreadManager.postImmediately(new NewFlowCameraActivity.23(this), null, false);
      this.wq.setVisibility(0);
    }
    View localView = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onResume needChangeNewSurfaceView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj + "mIsNeedSetup=" + this.bxU);
    }
    this.bxU = true;
    if (this.bxU) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj = true;
    }
    int i;
    if (((localView == null) || (this.bxU) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj)) && (!this.isSend))
    {
      i = 1;
      if (i == 0) {
        break label283;
      }
      Looper.myQueue().addIdleHandler(new aard(this, bool, localSharedPreferences));
    }
    for (;;)
    {
      this.bxU = false;
      this.bxT = false;
      this.byl = false;
      if ((this.bxd) && (!this.bxb) && (!this.bxc))
      {
        this.mUIHandler.removeCallbacks(this.ff);
        this.bxd = false;
      }
      if (this.ciu == 1) {
        avzl.a().Il(4);
      }
      this.Mo = System.currentTimeMillis();
      return;
      i = 0;
      break;
      label283:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.onResume();
      localSharedPreferences.edit().putBoolean("sp_is_cancel_from_music_key", true).commit();
    }
  }
  
  private void ec(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
    float f1 = ((aasx)localObject).cjJ * 1.0F / ((aasx)localObject).cjI;
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f1 + "dst_height" + ((aasx)localObject).cjJ + "dst_width=" + ((aasx)localObject).cjI);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f1, false, ankt.dip2px(5.0F));
    localObject = this.nj.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.nj.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void gI(long paramLong) {}
  
  private boolean iT(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      gI(l);
      paramString = avtz.a(l);
      if (paramString == null) {
        return false;
      }
      this.cif = paramString.fontId;
      this.cig = paramString.eyB;
      this.mFontUrl = paramString.fontUrl;
      int i = this.cif;
      if (i > 0) {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean k(int paramInt, boolean paramBoolean)
  {
    int i = aaqh.cix;
    if (i == paramInt) {
      return false;
    }
    this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.stopWatching();
    Object localObject;
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xe())
    {
      if (this.bwX) {
        break label507;
      }
      if (byC) {
        break label487;
      }
      localObject = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, false, null);
      if (localObject != null)
      {
        this.wq.setImageBitmap((Bitmap)localObject);
        this.wq.setVisibility(0);
      }
    }
    else
    {
      Ge(104);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xe();
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "click front needChangeNewSurfaceView = " + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xe());
      }
      if (i != 1) {
        break label520;
      }
      aaqh.cix = 2;
      label173:
      Gn(aaqh.cix);
      this.bxS = true;
      if (!paramBoolean) {
        break label527;
      }
      CG(true);
      label194:
      aasr.a().destroy();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) && (!this.bxw)) {
        bd(0, true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) && (this.jdField_a_of_type_Aasb != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_Aasb.bec);
      }
      if (((this.ciS == 10002) || (this.ciS == 10012)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) && (!this.bxw)) {
        anlc.a(this.jdField_fe_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      if ((WU()) && (this.fk != null))
      {
        localObject = this.fk;
        if (!this.bxI) {
          break label552;
        }
        paramInt = 0;
        label338:
        ((Button)localObject).setVisibility(paramInt);
        if (this.bxI) {
          anlc.a(this.fk, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        }
      }
      this.cd.clearAnimation();
      this.cd.setVisibility(8);
      this.wr.setEnabled(true);
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.startWatching();
      localObject = this.jdField_a_of_type_Aary;
      if (aaqh.cix != 1) {
        break label558;
      }
    }
    label520:
    label527:
    label552:
    label558:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((aary)localObject).setMirror(paramBoolean);
      cxs();
      cxt();
      this.bym = false;
      this.bxu = false;
      if (this.hY.getVisibility() == 0) {
        this.hY.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.cxT();
      }
      return true;
      this.wq.setImageResource(2130839767);
      break;
      label487:
      this.wq.setImageDrawable(new ColorDrawable(-16777216));
      break;
      label507:
      this.wq.setImageResource(2130839767);
      break;
      aaqh.cix = 1;
      break label173;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj)
      {
        cwp();
        break label194;
      }
      CG(false);
      break label194;
      paramInt = 8;
      break label338;
    }
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void w(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1011)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramInt2 != 0) {
        break label168;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        aqhq.cn(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
      }
      h("608", "2", "0", true);
      if ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4))
      {
        this.byj = true;
        cxe();
        this.byk = true;
        this.bxU = true;
      }
    }
    label168:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      this.mContent = paramIntent.getStringExtra("key_content");
      if (this.mContent == null) {
        this.mContent = "";
      }
      this.mPriv = paramIntent.getIntExtra("key_priv", 1);
      this.eo = ((ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list"));
      if (this.eo == null) {
        this.eo = new ArrayList();
      }
      this.topicSyncQzone = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.topicSyncQzone);
      this.cif = paramIntent.getIntExtra("key_font_id", -1);
      this.cig = paramIntent.getIntExtra("key_font_format_type", 0);
      this.mFontUrl = paramIntent.getStringExtra("key_font_url");
      this.cih = paramIntent.getIntExtra("key_super_font_id", -1);
      this.bdz = paramIntent.getStringExtra("key_super_font_info");
      bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
    } while (paramIntent == null);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "publishParam : " + paramIntent.toString());
    }
    getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
    float f1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
    Gi(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 <= 0)
    {
      paramInt1 = paramInt2;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        paramInt1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      paramInt2 = paramIntent.recordFrames;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = this.cje;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "start sendShortVideoWithMood --- ");
    }
    paramInt2 = getIntent().getIntExtra("entry_source", 0);
    aaqi.a(this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.bo, this.bp, this.jdField_a_of_type_Aaqj, false, i, paramInt1, this.mContent, this.mPriv, this.eo, this.bxz, this.topicId, this.topicSyncQzone, paramIntent.thumbPath, paramIntent.doodlePath, this.cif, this.cig, this.mFontUrl, paramIntent.fakeVid, paramIntent.videoDuration, paramIntent.saveMode, bool1, paramInt2, bool2, this.cih, this.bdz);
  }
  
  private void x(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.mPriv = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.eo == null) {
            this.eo = new ArrayList();
          }
          this.eo.clear();
          ArrayList localArrayList = paramIntent.getStringArrayList("uin_list");
          if (localArrayList != null) {
            this.eo.addAll(localArrayList);
          }
        }
        if (bg(this.mPriv))
        {
          this.pO = paramIntent.getString("key_setting_raw_json");
          this.uO = paramIntent.getString("key_selected_tag");
        }
        uy();
      }
    }
  }
  
  private void y(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1009)
    {
      this.bwF = false;
      this.mNeedPauseRichMedia = false;
      if (this.zJ != null) {
        this.zJ.setVisibility(8);
      }
      if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        Object localObject;
        if (localBundle.containsKey("extra_key_bundle_priv_key"))
        {
          paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
          if (paramIntent != null)
          {
            this.mPriv = paramIntent.getInt("permission_code");
            if (this.eo == null) {
              this.eo = new ArrayList();
            }
            this.eo.clear();
            localObject = paramIntent.getStringArrayList("uin_list");
            if (localObject != null) {
              this.eo.addAll((Collection)localObject);
            }
            if (bg(this.mPriv))
            {
              this.pO = paramIntent.getString("key_setting_raw_json");
              this.uO = paramIntent.getString("key_selected_tag");
            }
            uy();
          }
        }
        if (localBundle.containsKey("extraIsTopicSyncQzone"))
        {
          boolean bool = localBundle.getBoolean("extraIsTopicSyncQzone");
          this.jdField_n_of_type_AndroidWidgetCheckBox.setChecked(bool);
        }
        if (localBundle.containsKey("contentIntentKey"))
        {
          localObject = localBundle.getString("contentIntentKey");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          this.mContent = paramIntent;
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
        }
        this.cif = localBundle.getInt("extra_key_font_id", -1);
        this.cig = localBundle.getInt("extra_key_font_format_type");
        this.mFontUrl = localBundle.getString("extra_key_font_url");
        this.cih = localBundle.getInt("extra_key_super_font_id", -1);
        this.bdz = localBundle.getString("extra_key_super_font_info");
        this.jdField_b_of_type_Aurf.sendEmptyMessage(1009);
      }
    }
  }
  
  private void z(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1012)
    {
      if (paramInt2 != 0) {
        break label47;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "restart from edit pic");
      }
      this.byj = true;
      cxk();
      this.byk = true;
      this.bxU = true;
    }
    label47:
    while ((paramInt2 != -1) || (paramIntent == null)) {
      return;
    }
    paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
    paramInt2 = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
    if (paramInt1 == 0) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (paramInt1 == 1002)
      {
        cxw();
        this.bwM = false;
        paramIntent.putExtra("open_leba_tab_fragment", true);
        setResult(-1, paramIntent);
        finish();
      }
      while (paramIntent.getBooleanExtra("go_publish_activity", false))
      {
        this.mContent = paramIntent.getStringExtra("key_content");
        if (this.mContent == null) {
          this.mContent = "";
        }
        this.mPriv = paramIntent.getIntExtra("key_priv", 1);
        this.eo = ((ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list"));
        if (this.eo == null) {
          this.eo = new ArrayList();
        }
        this.topicSyncQzone = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.topicSyncQzone);
        this.cif = paramIntent.getIntExtra("key_font_id", -1);
        this.cig = paramIntent.getIntExtra("key_font_format_type", 0);
        this.mFontUrl = paramIntent.getStringExtra("key_font_url");
        this.cih = paramIntent.getIntExtra("key_super_font_id", -1);
        this.bdz = paramIntent.getStringExtra("key_super_font_info");
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        boolean bool = paramIntent.getBooleanExtra("key_timer_delete", false);
        QLog.i("PTV.NewFlowCameraActivity", 2, "get mSetTimerDelete: " + bool);
        avpw.a(this.mContent, localArrayList, this.mPriv, this.eo, this.cif, this.cig, this.mFontUrl, bool, this.cih, this.bdz);
        finish();
        return;
        if (paramInt1 == 1003) {
          this.jdField_b_of_type_Qqz.a(paramIntent, this.wq);
        }
      }
      break;
    }
  }
  
  void AF(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.M == null) {
      this.M = new arhz(this, getTitleBarHeight());
    }
    this.M.setMessage(paramString);
    this.M.show();
  }
  
  public void AI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onCompleted, file path = " + paramString);
    }
    bs(paramString, false);
  }
  
  void CF(boolean paramBoolean)
  {
    cwm();
    cwy();
    if (paramBoolean) {
      CG(true);
    }
    if (WW())
    {
      aasp.c("shortvideo_cancel_effects", null);
      return;
    }
    aasp.c("shortvideo_cancel_noeffects", null);
  }
  
  void CG(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI needUseOld = " + paramBoolean);
    }
    Object localObject3 = getResources().getDisplayMetrics();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ($(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    label346:
    int i;
    if ((VersionUtils.isIceScreamSandwich()) && (!this.bwQ))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof aniw)))
      {
        ((CameraTextureView)localObject2).a = ((aniw)localObject1);
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.bwX = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bo(this.bxY, this.bya);
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this, this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setAppInterface(this.appInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setEnableBeauty(this.byn);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI needAddglview:" + paramBoolean + ", needChangeNewSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj + ", needOpenglView:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAl + ", isSurpportFilter:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) {
          break label928;
        }
        this.Os.setText(getResources().getString(2131701705));
        if (this.ciS == 10002)
        {
          String str = this.jdField_b_of_type_Qqz.mM();
          this.Os.setText(str);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAl) {
          break label1038;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) {
          break label1019;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI isTemplateMode = " + this.bxw);
        }
        if (this.bxw) {
          break label1000;
        }
        if (!this.bxz) {
          break label957;
        }
        if (this.fk != null)
        {
          localObject3 = this.Oo;
          if (!TextUtils.isEmpty(this.fk.getText().toString())) {
            break label947;
          }
          i = 4;
          label449:
          ((TextView)localObject3).setVisibility(i);
          localObject3 = this.d;
          if (!TextUtils.isEmpty(this.fk.getText().toString())) {
            break label952;
          }
          i = 0;
          label481:
          ((RedDotImageView)localObject3).setVisibility(i);
        }
        label487:
        if (this.gS) {
          this.d.showRedDot(true);
        }
        label502:
        this.bxX = true;
        ((FrameLayout.LayoutParams)localObject1).height = 1;
        ((FrameLayout.LayoutParams)localObject1).width = 1;
        label517:
        ((FrameLayout.LayoutParams)localObject1).gravity = 81;
        if (this.bwX) {
          ((FrameLayout.LayoutParams)localObject1).gravity = 49;
        }
        ((View)localObject2).setId(2131367243);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.cze();
        }
        this.bwW = true;
        if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() != 4) {
          break label1080;
        }
        this.d.clearAnimation();
        this.d.setVisibility(4);
        label609:
        if (!this.bxS) {
          break label1099;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xe();
        label630:
        if ((this.ciS == 10011) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a instanceof CameraFilterGLView)))
        {
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a).jdField_a_of_type_Anjd.b = this.jdField_a_of_type_Zxz;
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a).jdField_a_of_type_Anjd.setFaceDetectFlags(true);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a instanceof CameraFilterGLView)) {
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a).jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
        }
        if ((!this.byg) || (!WT())) {
          break label1130;
        }
        if ((this.bwT) || (!this.bxR)) {
          break label1110;
        }
        this.Os.setText(getResources().getString(2131701695));
      }
    }
    for (;;)
    {
      if ((this.byg) || (this.byr)) {
        this.wr.setImageDrawable(null);
      }
      if (!this.bxO) {
        CP(true);
      }
      return;
      ((CameraTextureView)localObject2).a = new aniw(this.mCamera, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof aniv))) {}
      for (((CameraPreview)localObject2).a = ((aniv)localObject1);; ((CameraPreview)localObject2).a = new aniv(this.mCamera, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels))
      {
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.bwX = true;
        break;
      }
      label928:
      if (this.byi) {
        break label346;
      }
      cwX();
      this.byi = true;
      break label346;
      label947:
      i = 0;
      break label449;
      label952:
      i = 4;
      break label481;
      label957:
      this.Oo.setVisibility(4);
      bd(0, false);
      if (!this.showGuide) {
        break label487;
      }
      acbs.k(this.xf.getContext(), this.xf);
      this.showGuide = false;
      break label487;
      label1000:
      this.d.setVisibility(4);
      this.Oo.setVisibility(4);
      break label502;
      label1019:
      this.d.setVisibility(4);
      this.Oo.setVisibility(4);
      break label502;
      label1038:
      this.bxX = false;
      this.d.setVisibility(4);
      this.Oo.setVisibility(4);
      ((FrameLayout.LayoutParams)localObject1).height = ((DisplayMetrics)localObject3).heightPixels;
      ((FrameLayout.LayoutParams)localObject1).width = ((DisplayMetrics)localObject3).widthPixels;
      break label517;
      label1080:
      this.cd.clearAnimation();
      this.cd.setVisibility(8);
      break label609;
      label1099:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAj = false;
      break label630;
      label1110:
      this.Os.setText(getResources().getString(2131701706));
      continue;
      label1130:
      if ((this.ciS == 10007) && (!this.bys) && (this.byt)) {
        this.Os.setText(getResources().getString(2131701695));
      } else if ((this.ciS == 10017) && (!this.bys) && (this.byt)) {
        this.Os.setText(getResources().getString(2131701695));
      } else {
        this.Os.setText(getResources().getString(2131701705));
      }
    }
  }
  
  public void CH(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.bwP + ", mPtvMode: " + false);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.stopWatching();
      if (this.bwP) {}
    }
    else
    {
      return;
    }
    if (!paramBoolean) {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aatf.cwH();
    }
    if (paramBoolean)
    {
      if (alvs.a().a().a(this.bdE) != null) {
        break label297;
      }
      aqip.bj(this.bdE, "sendShortVideo", "[peak] old procedure");
      getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      float f1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC();
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
      Gi(j);
      int i = j;
      if (j <= 0) {
        i = this.cje;
      }
      aaqi.a(this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.bo, this.bp, this.jdField_a_of_type_Aaqj, false, k, i, this.mContent, this.mPriv, this.eo, this.bxz, this.topicId, this.topicSyncQzone, this.cif, this.cig, this.mFontUrl);
      if (VideoEnvironment.awS())
      {
        View localView = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
        if (localView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      CI(paramBoolean);
      this.bwP = false;
      return;
      label297:
      if (VideoEnvironment.awS())
      {
        setResult(1001);
        finish();
      }
      aqip.bj(this.bdE, "sendShortVideo", "[peak] preupload procedure");
      break;
    }
  }
  
  void CI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "exitVideoMode(), mPtvMode = false, clearCache = " + paramBoolean);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if (paramBoolean)
      {
        Ge(103);
        if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
        {
          int i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
          this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.r(0, i, true);
        }
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cyf();
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate != null) {
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate.cyo();
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a == null) || (!this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.mPaused) || (!this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.bzj)) {}
    }
  }
  
  void CJ(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[6];
    if ((this.mPreviewWidth == -1) || (this.mPreviewHeight == -1)) {}
    do
    {
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PTV.NewFlowCameraActivity", 2, "[changeVideoPreviewMapSize]rmStateMgr " + null);
    return;
    aasx localaasx = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
    float f1 = this.mPreviewWidth * 1.0F / this.mPreviewHeight;
    if (this.mQ >= f1) {}
    for (boolean bool = false;; bool = true)
    {
      if (paramBoolean) {
        a(this.mPreviewWidth, this.mPreviewHeight, bool, arrayOfInt);
      }
      try
      {
        b(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        label131:
        if (!paramBoolean) {
          a(this.mPreviewWidth, this.mPreviewHeight, bool, arrayOfInt);
        }
        localaasx.cjG = arrayOfInt[0];
        localaasx.cjH = arrayOfInt[1];
        localaasx.cjI = this.mPreviewWidth;
        localaasx.cjJ = this.mPreviewHeight;
        c(localaasx);
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localaasx, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAl);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        break label131;
      }
    }
  }
  
  public void CK(boolean paramBoolean) {}
  
  public void CL(boolean paramBoolean) {}
  
  void CM(boolean paramBoolean)
  {
    runOnUiThread(new RefreshUITimer(paramBoolean));
  }
  
  public void CR(boolean paramBoolean)
  {
    setResult(1001);
    finish();
  }
  
  protected final void EB() {}
  
  public void Ge(int paramInt) {}
  
  public void Gj(int paramInt) {}
  
  protected void Gm(int paramInt)
  {
    int i;
    int j;
    try
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
      k = i;
      if (i <= 0) {
        k = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
      if (k > 0) {
        this.cje = k;
      }
      str = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG;
      m = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjI;
      i1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjJ;
      localObject2 = "";
      bool2 = false;
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate.a();
      localObject1 = localObject2;
      bool1 = bool2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (((aate.a)localObject3).thumbPath != null)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (((aate.a)localObject3).state.get() == 3)
          {
            bool1 = true;
            localObject1 = ((aate.a)localObject3).thumbPath;
          }
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!aqhq.fileExistsAndNotEmpty((String)localObject1)) && (QLog.isColorLevel())) {
        QLog.e("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivity thumb file null!");
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("startEditVideoTime", SystemClock.uptimeMillis());
      if (this.jdField_a_of_type_Aasb != null) {
        ((Bundle)localObject2).putString("mCurrentTemplatePath", this.jdField_a_of_type_Aasb.bec);
      }
      ((Bundle)localObject2).putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      ((Bundle)localObject2).putLong("story_topic_id", getIntent().getLongExtra("story_topic_id", 0L));
      ((Bundle)localObject2).putInt("entrance_type", th());
      long l = super.getIntent().getLongExtra("troop_uin", 0L);
      if (l != 0L) {
        ((Bundle)localObject2).putLong("troop_uin", l);
      }
      if (this.bxL)
      {
        i = (int)Math.ceil(paramInt * 1.0F / 10000.0F);
        if (i < 1)
        {
          ram.e("PTV.NewFlowCameraActivity", "intentToEditVideoActivityFromStory error. expectFragmentCount < 1");
          return;
        }
        if (i > 1) {
          rar.a("video_shoot", "series_shoot", 0, 0, new String[0]);
        }
        ram.d("PTV.NewFlowCameraActivity", "intentToEditVideoActivityFromStory. expectFragmentCount = %d.", Integer.valueOf(i));
        ((Bundle)localObject2).putInt("expect_fragment_count", i);
      }
      j = 4374893;
      if (th() != 16) {
        break label912;
      }
      bool2 = true;
    }
    catch (Exception localException)
    {
      int k;
      String str;
      int m;
      int i1;
      Object localObject2;
      boolean bool2;
      Object localObject3;
      Object localObject1;
      boolean bool1;
      boolean bool3;
      boolean bool4;
      while (QLog.isColorLevel())
      {
        QLog.d("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivity exception:" + localException);
        return;
        label912:
        bool2 = false;
        continue;
        bool3 = false;
      }
      return;
    }
    if (th() == 5)
    {
      bool3 = true;
      bool4 = super.getIntent().getBooleanExtra("ignorePersonalPublish", false);
      ram.a("PTV.NewFlowCameraActivity", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4));
      if ((bool2) || (bool3) || (bool4)) {
        break label925;
      }
      if (!this.bxL) {
        break label932;
      }
      i = j;
      if (paramInt < 11000L) {
        break label932;
      }
    }
    for (;;)
    {
      j = i;
      if (this.mEntranceType == 102)
      {
        localObject3 = super.getIntent();
        int i2 = ((Intent)localObject3).getIntExtra("shareGroupType", 0);
        ((Bundle)localObject2).putInt("shareGroupType", i2);
        ((Bundle)localObject2).putString("shareGroupId", ((Intent)localObject3).getStringExtra("shareGroupId"));
        ((Bundle)localObject2).putString("shareGroupName", ((Intent)localObject3).getStringExtra("shareGroupName"));
        ((Bundle)localObject2).putLong("groupUin", ((Intent)localObject3).getLongExtra("groupUin", -1L));
        ((Bundle)localObject2).putInt("add_video_source", ((Intent)localObject3).getIntExtra("add_video_source", 0));
        i |= 0x200000;
        j = i;
        if (i2 == 1) {
          j = i & 0xFFFDFFFF;
        }
      }
      ((Bundle)localObject2).putBoolean("ignorePersonalPublish", bool4);
      localObject1 = new EditVideoParams(1, j, new EditRecordVideoSource(str, k, paramInt, aaqh.cix, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjI, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjJ, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj(), m, i1, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC(), (String)localObject1, bool1), (Bundle)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString() + ", RMVideoClipSpec:" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.toString());
      }
      localObject2 = new Intent(this, EditVideoActivity.class);
      ((Intent)localObject2).putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("op_department", "grp_story");
      paramInt = getIntent().getIntExtra("entrance_type", 99);
      if (paramInt == 15) {
        ((Intent)localObject2).putExtra("entrance_type", paramInt);
      }
      ((Intent)localObject2).putExtra("op_type", "video_edit");
      ((Intent)localObject2).putExtra("stop_record_time", System.currentTimeMillis());
      startActivityForResult((Intent)localObject2, 10002);
      overridePendingTransition(2130771998, 2130772018);
      this.byj = false;
      this.byk = false;
      this.byl = true;
      return;
      label925:
      j = 4358509;
      break;
      label932:
      i = j & 0xFFFF7FFF;
    }
  }
  
  protected void K(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2131561359, paramViewGroup);
    this.Aa = $(2131367347);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)$(2131367324));
    this.dO = ((ViewGroup)$(2131367263));
    this.wr = ((ImageView)$(2131367247));
    this.ws = ((ImageView)$(2131367248));
    this.Os = ((TextView)$(2131367345));
    this.Ot = ((TextView)$(2131367306));
    this.Ot.setVisibility(8);
    this.zW = $(2131367269);
    this.wt = ((ImageView)$(2131367270));
    this.zZ = $(2131367279);
    this.zY = $(2131367280);
    this.wu = ((ImageView)$(2131367281));
    this.Ov = ((TextView)$(2131367278));
    this.Ou = ((TextView)$(2131367271));
    this.jdField_fg_of_type_AndroidWidgetButton = ((Button)$(2131367315));
    this.aK = ((Button)$(2131367313));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)$(2131367261));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(aofw.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.iO = ((RelativeLayout)$(2131367260));
    this.fc = ((Button)$(2131367304));
    this.jdField_n_of_type_AndroidWidgetCheckBox = ((CheckBox)$(2131367310));
    this.zI = $(2131367309);
    this.Oo = ((TextView)$(2131367318));
    if (!TextUtils.isEmpty(this.bdO)) {
      this.Oo.setText(this.bdO);
    }
    cxv();
    int i;
    if (this.bxe)
    {
      if (getIntent().getIntExtra("edit_video_type", 0) == 10002)
      {
        i = 1;
        if (i == 0) {
          break label1536;
        }
        this.er = c(this);
      }
    }
    else
    {
      label395:
      this.Or = ((TextView)$(2131367311));
      this.fj = ((Button)$(2131367251));
      this.d = ((RedDotImageView)$(2131367254));
      this.cd = ((Button)$(2131377990));
      this.xf = $(2131367255);
      this.wq = ((ImageView)$(2131367299));
      this.jdField_fe_of_type_AndroidWidgetButton = ((Button)$(2131367256));
      this.jdField_fe_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)$(2131367267));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.nj = ((ImageView)$(2131367297));
      this.mListView = ((HorizontalListView)$(2131368682));
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)$(2131365505));
      this.fl = ((Button)$(2131367314));
      this.fm = ((Button)$(2131367316));
      this.hY = ((LinearLayout)$(2131367325));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)$(2131364211));
      ec((int)this.screenWidth, (int)this.screenHeight);
      this.fc.setOnClickListener(this);
      this.jdField_fg_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.aK.setOnClickListener(this);
      this.wr.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.cd.setOnClickListener(this);
      this.Oo.setOnClickListener(this);
      this.fj.setOnClickListener(this);
      this.wr.setOnClickListener(this);
      this.wr.setEnabled(false);
      this.fl.setOnClickListener(this);
      this.fm.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = ((FSurfaceViewLayout)$(2131367327));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.setDrawableRes(2130846907);
      if (!anih.agb())
      {
        this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
        this.bxy = false;
      }
      this.wr.setOnTouchListener(this.jdField_w_of_type_AndroidViewView$OnTouchListener);
      if (this.ciS == 10003)
      {
        this.cd.setText(acfp.m(2131709015));
        this.cd.setVisibility(8);
      }
      if (!this.byg) {
        break label1567;
      }
      if ((this.bwT) || (!this.bxR)) {
        break label1547;
      }
      this.Os.setText(getResources().getString(2131701695));
      label860:
      if ((this.byg) || (this.byr)) {
        this.wr.setImageDrawable(null);
      }
      if (this.ciS == 10002)
      {
        paramViewGroup = this.jdField_b_of_type_Qqz.mM();
        if (!TextUtils.equals(paramViewGroup, acfp.m(2131709028))) {
          rar.a("video_shoot", "exp_wording", 0, 0, new String[0]);
        }
        this.Os.setText(paramViewGroup);
      }
      ViewCompat.setImportantForAccessibility(this.Os, 2);
      if (!this.bxe) {
        break label1681;
      }
      this.fk = this.jdField_fe_of_type_AndroidWidgetButton;
      paramViewGroup = this.jdField_fe_of_type_AndroidWidgetButton;
      if (!this.bxI) {
        break label1675;
      }
      i = 0;
      label973:
      paramViewGroup.setVisibility(i);
      this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(this.bxI);
      this.fj.setVisibility(8);
      this.fj.setEnabled(false);
      this.ciO = 2130850065;
      if ((this.er != null) && (this.fk != null)) {
        this.fk.setBackgroundDrawable(new BitmapDrawable(this.er));
      }
      if ((this.er == null) && ((this.ciS == 10002) || (this.ciS == 10012)))
      {
        this.fk = this.fj;
        this.aK.setVisibility(0);
        this.fj.setVisibility(8);
        this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(false);
        this.ciO = 0;
      }
      label1119:
      cxs();
      cxr();
      i = getIntent().getIntExtra("edit_video_type", 0);
      if (((!this.byr) && (i != 10000) && (i != 10003) && (i != 10004) && (i != 10010)) || (!this.byk)) {
        break label1731;
      }
      ciJ = 2;
      paramViewGroup = (RelativeLayout.LayoutParams)this.mListView.getLayoutParams();
      if (paramViewGroup != null)
      {
        paramViewGroup.leftMargin = 0;
        this.mListView.setLayoutParams(paramViewGroup);
      }
      label1213:
      paramViewGroup = new Rect();
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.getGlobalVisibleRect(paramViewGroup);
      this.jdField_a_of_type_Reu.mL = paramViewGroup.top;
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167654), 100, getResources().getColor(2131165409));
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
      EB();
      if (this.isTopic)
      {
        this.fc.setVisibility(8);
        this.jdField_n_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_n_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new aaqy(this));
        this.jdField_n_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
      cwV();
      this.d.setReddotXOffsetDp(3);
      this.d.setReddotYOffsetDp(3);
      this.d.setRedDotBase(1);
      cxt();
      if (this.bxL)
      {
        this.wv = ((ImageView)$(2131367276));
        this.ww = ((ImageView)$(2131367274));
        this.Ow = ((TextView)$(2131367275));
        this.Ox = ((TextView)$(2131367277));
        this.bY = new AtomicBoolean(false);
        this.bZ = new AtomicBoolean(false);
      }
      if (this.ciS == 10002) {}
      this.zW.post(new NewFlowCameraActivity.20(this));
      if (this.mSessionInfo != null)
      {
        if (this.mSessionInfo.cZ != 1) {
          break label1781;
        }
        paramViewGroup = "3";
      }
    }
    for (;;)
    {
      if (this.ciS == 10000) {
        rar.a("aio_shoot", "exp_shoot", 0, 0, new String[] { paramViewGroup });
      }
      return;
      i = 0;
      break;
      label1536:
      this.er = b(this);
      break label395;
      label1547:
      this.Os.setText(getResources().getString(2131701706));
      break label860;
      label1567:
      if ((this.ciS == 10007) && (!this.bys) && (this.byt))
      {
        this.Os.setText(getResources().getString(2131701695));
        break label860;
      }
      if ((this.ciS == 10017) && (!this.bys) && (this.byt))
      {
        this.Os.setText(getResources().getString(2131701695));
        break label860;
      }
      this.Os.setText(getResources().getString(2131701705));
      break label860;
      label1675:
      i = 8;
      break label973;
      label1681:
      this.fk = this.fj;
      this.aK.setVisibility(0);
      this.fj.setVisibility(8);
      this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(false);
      this.ciO = 0;
      break label1119;
      label1731:
      ciJ = 1;
      paramViewGroup = (RelativeLayout.LayoutParams)this.mListView.getLayoutParams();
      if (paramViewGroup == null) {
        break label1213;
      }
      paramViewGroup.leftMargin = ((int)(getResources().getDisplayMetrics().widthPixels / 4.5F));
      this.mListView.setLayoutParams(paramViewGroup);
      break label1213;
      label1781:
      if (this.mSessionInfo.cZ == 3000) {
        paramViewGroup = "2";
      } else {
        paramViewGroup = "1";
      }
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
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog");
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
        QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  boolean WQ()
  {
    return false;
  }
  
  public boolean WU()
  {
    this.ciS = getIntent().getIntExtra("edit_video_type", 0);
    return (this.ciS != 10000) && (this.ciS != 10003) && (this.ciS != 10004) && (this.ciS != 10010) && (this.ciS != 10007);
  }
  
  boolean WV()
  {
    String str = anld.a().JE;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    long l = anld.s(str);
    if (l <= anld.ama)
    {
      ram.e("PTV.NewFlowCameraActivity", "checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l + " StorageManager.FREESPACE_LIMIT_EXIT=" + anld.ama + " 手机剩余存储空间不足");
      return false;
    }
    ram.i("PTV.NewFlowCameraActivity", "checkDiskSpaceIsOK. freeSpace=" + l + " StorageManager.FREESPACE_LIMIT_EXIT=" + anld.ama);
    return true;
  }
  
  public boolean WW()
  {
    if (!this.bxw) {}
    while ((this.jdField_a_of_type_Aasb == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aasb.bec))) {
      return false;
    }
    return true;
  }
  
  protected aaqk a()
  {
    return null;
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    ram.w("PTV.NewFlowCameraActivity", "encode video failed");
    paramInt = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("sp_mc_crash_times", paramInt + 1);
    aqmj.b(localEditor);
    ambe.j(paramThrowable);
    this.mUIHandler.post(new NewFlowCameraActivity.11(this));
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = (int)(paramMotionEvent.getX(paramInt) + paramFloat1);
    int j = (int)(paramMotionEvent.getY(paramInt) + paramFloat2);
    ram.d("PTV.NewFlowCameraActivity", "referX = " + paramFloat1 + ", referY = " + paramFloat2);
    ram.d("PTV.NewFlowCameraActivity", "motionEvent.getX(pointIndex) = " + paramMotionEvent.getX(paramInt) + ", motionEvent.getY(pointIndex) = " + paramMotionEvent.getY(paramInt));
    long l = System.currentTimeMillis();
    if (!this.byp)
    {
      if (rex.c(this.jdField_fg_of_type_AndroidWidgetButton, i, j))
      {
        if (this.ciS == 10002)
        {
          ram.d("PTV.NewFlowCameraActivity", "recordButtonPointerDown : click switch camera button , change camera.");
          this.Ms = 0L;
          cxi();
        }
        return true;
      }
      if (this.ciS == 10002)
      {
        if ((paramMotionEvent.getPointerCount() != 2) || (l - this.Ms >= 300L)) {
          break label235;
        }
        ram.d("PTV.NewFlowCameraActivity", "recordButtonPointerDown : double click , change camera.");
        cxi();
      }
    }
    label235:
    for (this.Ms = 0L;; this.Ms = l)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(i, j);
      ad(paramMotionEvent);
      paramMotionEvent.recycle();
      return true;
    }
  }
  
  public void aG(Activity paramActivity) {}
  
  public void aM(boolean paramBoolean, int paramInt)
  {
    super.runOnUiThread(new NewFlowCameraActivity.48(this, paramBoolean, paramInt));
  }
  
  public void as(int paramInt, boolean paramBoolean)
  {
    if (this.bwP)
    {
      this.ciP = paramInt;
      RMVideoStateMgr localRMVideoStateMgr = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      localRMVideoStateMgr.timerCount += 1;
      if (!paramBoolean) {
        break label57;
      }
      CM(true);
    }
    for (;;)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.post(new NewFlowCameraActivity.42(this, paramBoolean));
      return;
      label57:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) {}
      for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();; i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex())
      {
        this.jdField_a_of_type_Ania.aJ(paramInt, i);
        CM(this.bxi);
        if (!this.bxi) {
          break label123;
        }
        this.bxi = false;
        break;
      }
      label123:
      this.bxi = true;
    }
  }
  
  public void auv() {}
  
  void ax(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.bwP) {}
    }
    else {
      while (!this.bwP) {
        return;
      }
    }
    Object localObject = getResources();
    if (paramFloat > 0.0F) {}
    while (paramFloat > 0.0F)
    {
      this.bwP = true;
      int i = ankt.dip2px(59.0F);
      localObject = this.wr.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      ((ViewGroup.LayoutParams)localObject).width = i;
      this.wr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.byg)
      {
        this.wr.setContentDescription(acfp.m(2131709007));
        return;
        ((Resources)localObject).getDimensionPixelSize(2131297332);
      }
      else
      {
        this.wr.setContentDescription(acfp.m(2131708983));
        return;
      }
    }
    CH(false);
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int k = (int)this.screenHeight;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "getVideoClipPreviewMapSize constScreenWidth=" + paramBoolean + String.format("screenWidth=%s,screenHeight=%s", new Object[] { Float.valueOf(this.screenWidth), Float.valueOf(this.screenHeight) }));
    }
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
    int i = 0;
    paramArrayOfInt = $(2131367243);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)$lp(paramArrayOfInt);
    if (!this.bxX)
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramArrayOfInt.setLayoutParams(localLayoutParams);
    }
    int j = (int)this.screenHeight;
    j = (int)this.screenHeight - j;
    if (paramInt2 >= this.screenHeight) {
      paramInt2 = j - 0;
    }
    for (;;)
    {
      this.cin = i;
      this.cip = paramInt2;
      this.ciq = (i * this.mPreviewHeight / paramInt1);
      this.cir = (paramInt2 * this.mPreviewHeight / paramInt1);
      if (this.bwT) {
        ax(5.0F);
      }
      return;
      paramInt2 = (int)this.screenHeight - paramInt2;
      if (this.bwX)
      {
        paramInt2 = j - 0;
      }
      else if (paramInt2 <= 0)
      {
        paramInt2 = j - 0;
      }
      else
      {
        j -= paramInt2;
        i = paramInt2;
        paramInt2 = j;
      }
    }
  }
  
  /* Error */
  public String bj(String paramString)
  {
    // Byte code:
    //   0: invokestatic 3005	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 4229	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 395	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 4231
    //   18: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 4237	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 4239
    //   35: iconst_1
    //   36: anewarray 894	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokestatic 2059	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +217 -> 266
    //   52: aload_1
    //   53: invokeinterface 4242 1 0
    //   58: ifeq +208 -> 266
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 4243
    //   66: invokeinterface 2070 2 0
    //   71: invokeinterface 4244 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 819	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +178 -> 259
    //   84: new 894	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 4248	java/lang/String:getBytes	()[B
    //   92: ldc_w 4250
    //   95: invokespecial 4253	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 4258	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +30 -> 135
    //   108: ldc_w 447
    //   111: iconst_2
    //   112: new 395	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 4260
    //   122: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 1124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: ifnull +11 -> 149
    //   141: aload_1
    //   142: invokeinterface 2083 1 0
    //   147: aload_2
    //   148: astore_3
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_2
    //   154: ldc_w 428
    //   157: astore_1
    //   158: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +33 -> 194
    //   164: ldc_w 447
    //   167: iconst_2
    //   168: new 395	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 4262
    //   178: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_3
    //   182: invokestatic 4266	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   185: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 1661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_1
    //   195: astore_3
    //   196: aload_2
    //   197: ifnull -48 -> 149
    //   200: aload_2
    //   201: invokeinterface 2083 1 0
    //   206: aload_1
    //   207: areturn
    //   208: astore_2
    //   209: aconst_null
    //   210: astore_1
    //   211: aload_1
    //   212: ifnull +9 -> 221
    //   215: aload_1
    //   216: invokeinterface 2083 1 0
    //   221: aload_2
    //   222: athrow
    //   223: astore_2
    //   224: goto -13 -> 211
    //   227: astore_3
    //   228: aload_2
    //   229: astore_1
    //   230: aload_3
    //   231: astore_2
    //   232: goto -21 -> 211
    //   235: astore_3
    //   236: aload_1
    //   237: astore_2
    //   238: ldc_w 428
    //   241: astore_1
    //   242: goto -84 -> 158
    //   245: astore 4
    //   247: aload_2
    //   248: astore_3
    //   249: aload_1
    //   250: astore_2
    //   251: aload_3
    //   252: astore_1
    //   253: aload 4
    //   255: astore_3
    //   256: goto -98 -> 158
    //   259: ldc_w 428
    //   262: astore_2
    //   263: goto -161 -> 102
    //   266: ldc_w 428
    //   269: astore_2
    //   270: goto -135 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	NewFlowCameraActivity
    //   0	273	1	paramString	String
    //   6	195	2	localObject1	Object
    //   208	14	2	localObject2	Object
    //   223	6	2	localObject3	Object
    //   231	39	2	localObject4	Object
    //   136	14	3	localObject5	Object
    //   151	31	3	localException1	Exception
    //   195	1	3	str	String
    //   227	4	3	localObject6	Object
    //   235	1	3	localException2	Exception
    //   248	8	3	localObject7	Object
    //   245	9	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   7	48	151	java/lang/Exception
    //   7	48	208	finally
    //   52	102	223	finally
    //   102	135	223	finally
    //   158	194	227	finally
    //   52	102	235	java/lang/Exception
    //   102	135	245	java/lang/Exception
  }
  
  public void btD() {}
  
  void cancleProgressDailog()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "cancleProgressDailog");
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
    if (QLog.isColorLevel()) {
      QLog.d("face", 4, "getFirstFrame gl_root.getVisibility()=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getVisibility());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
    this.bwO = true;
    this.mUIHandler.removeCallbacks(this.jdField_fg_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "(OLD)LaunchActivity to FirstFrameShown cost : " + (Mr - this.activityStartTime) + "ms");
    }
  }
  
  public void cwB() {}
  
  public void cwD() {}
  
  void cwE()
  {
    int j = this.ciP;
    int i = j;
    if (this.bxL) {
      if (j < 60000) {
        break label154;
      }
    }
    label154:
    for (i = 10000;; i = this.ciP % 10000)
    {
      int k = i / 1000;
      int m = i % 1000;
      j = k;
      if (m >= 500) {
        j = k + 1;
      }
      k = j;
      if (j > ciK) {
        k = ciK;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] adjustRecordTime: time= " + i + ",seconds = " + k + ", ms=" + m);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append("秒");
      this.Or.setText(localStringBuilder);
      return;
    }
  }
  
  public void cwF() {}
  
  public void cwG()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "enterViewVideoMode");
    }
    this.d.showRedDot(false);
    TextView localTextView = this.Or;
    if (this.bxA) {}
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      if (!this.jdField_fg_of_type_AndroidWidgetButton.isEnabled()) {
        this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (this.bxy) {
        this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(0);
      }
      cxs();
      cxr();
      return;
    }
  }
  
  public void cwH()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "exitViewVideoMode");
    }
    this.wr.setEnabled(true);
    if (!this.jdField_fg_of_type_AndroidWidgetButton.isEnabled()) {
      this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.bxy) {
      this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(0);
    }
    cxs();
    cxr();
  }
  
  public void cwI()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new HandleEndVideoEncode(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "recordVideoFinish");
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.wr.setVisibility(4);
    this.ws.clearAnimation();
    this.ws.setVisibility(8);
    this.Os.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.Xt())
    {
      cwZ();
      if (this.byc)
      {
        if (aaqh.cix != 1) {
          break label148;
        }
        CO(false);
      }
    }
    for (;;)
    {
      this.mCamera.dQq();
      return;
      U(this, 2131696921);
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
      cancleProgressDailog();
      cwZ();
      break;
      label148:
      this.mCamera.PS(false);
    }
  }
  
  public void cwJ()
  {
    super.finish();
  }
  
  public void cwL()
  {
    if ((this.M != null) && (this.M.isShowing()) && (!isFinishing())) {
      this.M.dismiss();
    }
  }
  
  public void cwM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo");
    }
    int k;
    int j;
    int i;
    Object localObject;
    if (this.byp)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG))
      {
        QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo error. rmStateMgr.mVideoFileDir is empty.");
        return;
      }
      if (!new File(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG).exists())
      {
        QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo error. rmStateMgr.mVideoFileDir is not exit. rmStateMgr.mVideoFileDir = " + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
        return;
      }
      this.bdS = (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG + File.separatorChar + "video-" + System.currentTimeMillis() + ".mp4");
      int m = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjI;
      k = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjJ;
      j = m;
      i = k;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjJ > anhm.dGc)
      {
        float f1 = 1.0F * anhm.dGc / this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjJ;
        i = (int)(m * f1);
        j = (int)(f1 * k);
        localObject = new aasx();
        ((aasx)localObject).cjE = 0;
        ((aasx)localObject).cjF = 0;
        ((aasx)localObject).cjG = i;
        ((aasx)localObject).cjH = j;
        ((aasx)localObject).cjI = i;
        ((aasx)localObject).cjJ = j;
        c((aasx)localObject);
        j = ((aasx)localObject).cjG;
        i = ((aasx)localObject).cjH;
      }
      k = CameraFilterGLView.f.fP(this.mOrientation);
      if (this.ciS == 10002)
      {
        RMVideoStateMgr.a().c(new amae(this.bdS, j, i, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cjL * 1000, 1, false, k));
        RMVideoStateMgr.a().a(this);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.czf();
      rar.a("aio_shoot", "clk_shoot", 0, 0, new String[0]);
      if (this.byr)
      {
        anjg.Qb(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.czg();
        QLog.d("GestureTestUse", 2, "you start video record result");
      }
      localObject = null;
      if (this.jdField_a_of_type_Aasb != null) {
        localObject = this.jdField_a_of_type_Aasb.qD();
      }
      if (localObject == null) {
        break label565;
      }
      this.mReportParams.put("isTemplateSelected", String.valueOf(true));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.cxU();
      }
      if ((this.ciS == 10002) && (!TextUtils.equals(this.Os.getText().toString().trim(), acfp.m(2131709001)))) {
        rar.a("video_shoot", "press_wording", 0, 0, new String[0]);
      }
      this.wr.postDelayed(new NewFlowCameraActivity.6(this), 100L);
      return;
      RMVideoStateMgr.a().c(new amae(this.bdS, j, i, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cjL * 1000, aniq.bqE, false, k));
      break;
      label565:
      if ((this.bwY) && (this.bwZ) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
        cwC();
      }
      this.mReportParams.put("isTemplateSelected", String.valueOf(false));
    }
  }
  
  public void cwN()
  {
    int k = 0;
    aarz.AK("shootPhoto");
    cxg();
    this.bxQ = true;
    if (this.jdField_a_of_type_Aasb != null) {}
    for (String str = this.jdField_a_of_type_Aasb.qD();; str = null)
    {
      if ((this.jdField_a_of_type_Aasb != null) && (this.jdField_a_of_type_Aasb.a() != null) && (this.jdField_a_of_type_Aasb.a().hasGesture())) {}
      for (boolean bool = true;; bool = false)
      {
        aarz.x(str, this.bdU, bool);
        this.bdF = getIntent().getExtras().getString("qcamera_photo_filepath");
        if (QLog.isColorLevel()) {
          QLog.d(".photo", 2, "shot photo path=" + this.bdF);
        }
        int i;
        if (!TextUtils.isEmpty(this.bdF))
        {
          if (aqmr.isEmpty(str)) {
            break label350;
          }
          i = 1;
          if (aaqh.cix != 2) {
            break label355;
          }
          if ((!this.bxw) || (i == 0)) {
            break label434;
          }
          i = 1;
        }
        for (;;)
        {
          label170:
          int j = i;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
          {
            j = i;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b() != null)
            {
              j = i;
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b().isEmptyFilter()) {
                j = 1;
              }
            }
          }
          if ((j != 0) || (!aeah.afY()) || (this.byd))
          {
            i = k;
            if (this.byc)
            {
              i = 1500;
              if (aaqh.cix == 1) {
                CO(true);
              }
            }
            else
            {
              label250:
              new Handler().postDelayed(new NewFlowCameraActivity.7(this), i);
              this.bxP = true;
            }
          }
          for (;;)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("cameraType", String.valueOf(aaqh.cix));
            localHashMap.put("isTemplateMode", String.valueOf(this.bxw));
            localHashMap.put("templateId", str);
            aaqi.a(getIntent().getIntExtra("edit_video_type", -1), "", "", localHashMap);
            return;
            label350:
            i = 0;
            break;
            label355:
            i = 1;
            break label170;
            this.mCamera.PS(true);
            break label250;
            if (QLog.isColorLevel()) {
              QLog.d(".photo", 2, "shot photo with custom camera");
            }
            if ((this.byc) && (!this.bym))
            {
              aarz.cxz();
              this.mCamera.a(null, new aaru(this));
            }
            else
            {
              cwO();
              cwP();
            }
          }
          label434:
          i = 0;
        }
      }
    }
  }
  
  public void cwQ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onDataReady");
    }
    if (this.mCamera != null) {
      this.mCamera.dQk();
    }
  }
  
  public void cwR()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.cxV();
    }
  }
  
  public void cwS()
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Aasb != null)
    {
      new ArrayList();
      if (this.ciS != 10003) {
        break label130;
      }
      localArrayList = PtvTemplateManager.a(this.appInterface).dI();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onPtvTemplateUpdated: ");
        if (localArrayList != null) {
          break label161;
        }
      }
    }
    label130:
    label161:
    for (int i = 0;; i = localArrayList.size())
    {
      QLog.d("PtvTemplateManager", 2, i);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        PtvTemplateManager.a(this.appInterface).a(null);
        if (this.jdField_a_of_type_Aasb.getCount() == 0)
        {
          this.jdField_a_of_type_Aasb.dn(localArrayList);
          runOnUiThread(new NewFlowCameraActivity.15(this));
        }
      }
      return;
      if (this.byr) {}
      for (i = 2;; i = 1)
      {
        localArrayList = PtvTemplateManager.a(this.appInterface).a(true, false, i);
        break;
      }
    }
  }
  
  public void cwZ()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo rmStateMgr=null");
      }
    }
    do
    {
      return;
      this.bxJ = false;
      if (this.aK != null) {
        this.aK.setVisibility(4);
      }
      if (this.byr) {
        aaqi.h("", "0X8007931", "", "", "", "");
      }
      this.bxv = false;
      cxb();
      if (this.bxL) {
        this.Ox.clearAnimation();
      }
      if (!this.byp) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.em(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cjN = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
      boolean bool = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.hC(this.ciR);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo getVFileAndAFile=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG + "errcode=" + 0 + "hasFrame=" + bool);
      }
      if (!bool)
      {
        QQToast.a(this, acfp.m(2131708997), 0).show();
        if (this.ciS == 10002) {
          rar.a("video_shoot", "exp_time_float", 0, 0, new String[0]);
        }
        this.bxM = true;
        cxa();
        aaqi.h("", "0X80075C0", "", "", "", "");
        bxt = false;
        return;
      }
      if (!this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xb()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo isCurrentPreviewState= true......");
    return;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.cIc = true;
    this.jdField_a_of_type_Aasx = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, false, this.jdField_a_of_type_Aasx);
    if (localObject != null) {
      ThreadManager.post(new NewFlowCameraActivity.31(this, (Bitmap)localObject), 8, null, false);
    }
    CQ(false);
    this.bxc = true;
    localObject = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      this.bwO = false;
    }
    if (!this.byp)
    {
      localObject = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
      float f1 = ((aasx)localObject).cjJ * 1.0F / ((aasx)localObject).cjI;
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "heightRatio=" + f1 + "clipspec.dst_height=" + ((aasx)localObject).cjJ + "clipspec.dst_width=" + ((aasx)localObject).cjI);
      }
      ec((int)this.screenWidth, (int)this.screenHeight);
      aqhq.copyFile(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.Ac(), bdP);
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.tl(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(null, false, false);
    Properties localProperties = new Properties();
    localProperties.setProperty("shortvideo_duration", "" + (int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL);
    if ((this.mOrientation == 90) || (this.mOrientation == 270)) {}
    for (int i = 1;; i = 0)
    {
      if (aaqh.cix == 1) {}
      for (int j = 1;; j = 0)
      {
        if (!WW())
        {
          aaqi.h("", "0X8006A13", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, "");
          aasp.c("shortvideo_record_noeffcts", localProperties);
          if (aaqh.cix != 1) {
            break label1136;
          }
          aasp.c("shortvideo_front_camera", null);
          label728:
          if (this.jdField_a_of_type_Aasb != null) {
            break label1146;
          }
        }
        label1136:
        label1146:
        for (localObject = "";; localObject = this.jdField_a_of_type_Aasb.qD())
        {
          aaqi.h("", "0X80075BF", (String)localObject, "", "", "");
          if (this.jdField_a_of_type_Aasb != null)
          {
            localObject = this.jdField_a_of_type_Aasb.qD();
            if (localObject != null)
            {
              localProperties = new Properties();
              localProperties.setProperty("shortvideo_template_id", (String)localObject);
              localProperties.setProperty("shortvideo_template_name", "" + this.jdField_a_of_type_Aasb.qE());
              aasp.c("shortvideo_record_id1", localProperties);
            }
          }
          if (this.ciS == 10002) {
            rar.a("video_shoot", "press_shoot", 0, 0, new String[] { "1" });
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "replay totaltime = " + (int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL);
          return;
          if (this.jdField_a_of_type_Aasb != null) {}
          for (localObject = this.jdField_a_of_type_Aasb.qD();; localObject = "")
          {
            aaqi.h("", "0X8006A18", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, (String)localObject);
            if ((this.jdField_a_of_type_Aasb != null) && (this.jdField_a_of_type_Aasb.a() != null) && (this.jdField_a_of_type_Aasb.a().hasGesture())) {
              aaqi.h("", "0X80083AF", String.valueOf((int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL), "" + i, "" + j, (String)localObject);
            }
            if (!TextUtils.isEmpty(this.bdU)) {
              aaqi.h("", "0X80083B7", (String)localObject, "", this.bdU, "");
            }
            aasp.c("shortvideo_record_effects", localProperties);
            break;
          }
          aasp.c("shortvideo_back_camera", null);
          break label728;
        }
      }
    }
  }
  
  void cwj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.dPQ();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.mEncodeRef.getAndSet(null);
    }
  }
  
  public void cwl()
  {
    bxt = false;
    this.jdField_a_of_type_Aasx = null;
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, false, this.jdField_a_of_type_Aasx);
    if (localObject != null) {
      ThreadManager.post(new NewFlowCameraActivity.29(this, (Bitmap)localObject), 8, null, false);
    }
    cwY();
    localObject = getIntent();
    ((Intent)localObject).putExtra("flow_back", 0);
    setResult(1001, (Intent)localObject);
    this.jdField_b_of_type_Qqz.bpR();
    super.onBackPressed();
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
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL == 0.0D)
    {
      cwl();
      return;
    }
    if (this.jdField_e_of_type_Ausj == null) {
      this.jdField_e_of_type_Ausj = ausj.a(this, false);
    }
    this.jdField_e_of_type_Ausj.setMainTitle(acfp.m(2131708999));
    this.jdField_e_of_type_Ausj.addButton(acfp.m(2131708987), 3);
    this.jdField_e_of_type_Ausj.addCancelButton(acfp.m(2131708989));
    this.jdField_e_of_type_Ausj.a(new aarh(this));
    this.jdField_e_of_type_Ausj.show();
  }
  
  public void cwp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI");
    }
    CG(false);
  }
  
  public void cwt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "enterVideoMode(), mPtvMode = false");
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cyg();
    this.isRecording = true;
  }
  
  public void cwu()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(0);
    localStringBuilder.append("秒");
    this.Or.setText(localStringBuilder);
    this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
    this.fl.setEnabled(true);
    this.aK.setVisibility(0);
  }
  
  public void cwv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initUI_RecordState mIsVideoMode=" + this.bwP);
    }
    TextView localTextView;
    if (this.bwP)
    {
      this.aK.setVisibility(4);
      this.bxv = true;
      if (this.d.getVisibility() == 0) {
        anlc.a(this.d, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if ((this.fk != null) && (this.fk.getVisibility() == 0)) {
        anlc.a(this.fk, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if (this.ciS == 10002) {
        anlc.a(this.jdField_fe_of_type_AndroidWidgetButton, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.timerCount = 0;
      if ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL <= 0.0D) && (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bzb)) {
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bza = true;
      }
      if (this.byj) {
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bza = true;
      }
      if ((this.ciS != 10002) || (this.byp))
      {
        if (this.jdField_fg_of_type_AndroidWidgetButton.isEnabled()) {
          this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(false);
        }
        this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.fl.isEnabled()) {
        this.fl.setEnabled(false);
      }
      this.fl.setVisibility(4);
      this.fm.setVisibility(4);
      this.jdField_a_of_type_Ania.lo(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL);
      this.Os.setVisibility(8);
      localTextView = this.Or;
      if (!this.bxA) {
        break label370;
      }
    }
    label370:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      if ((this.bxe) && (this.jdField_fe_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_fe_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (this.bxA) {
        LpReportInfo_pf00064.allReport(627, 2);
      }
      return;
    }
  }
  
  public void cww()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState mIsVideoMode=" + this.bwP + ", needGenThumbPic:" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bza);
    }
    Button localButton;
    if (this.bwP)
    {
      if ((QLog.isColorLevel()) && (this.fk != null))
      {
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mSendButton.getVisibility=" + this.d.getVisibility());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mLeftButton.getVisibility=" + this.fk.getVisibility());
      }
      if ((QLog.isColorLevel()) && (this.fk != null))
      {
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mSendButton.isEnabled=" + this.d.isEnabled());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mLeftButton.isEnabled=" + this.fk.isEnabled());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mCameraCapture.isEnabled=" + this.wr.isEnabled());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setNeedWrite(false);
      this.isRecording = false;
      if ((this.d.getVisibility() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf)) {
        bd(0, true);
      }
      if ((WU()) && (this.fk != null))
      {
        if (this.fk.getVisibility() == 4)
        {
          this.fk.setVisibility(0);
          anlc.a(this.fk, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        }
        this.fk.setEnabled(true);
      }
      if (((this.ciS == 10002) || (this.ciS == 10012)) && (this.jdField_fe_of_type_AndroidWidgetButton.getVisibility() == 4))
      {
        localButton = this.jdField_fe_of_type_AndroidWidgetButton;
        if (!this.bxI) {
          break label581;
        }
      }
    }
    label581:
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      anlc.a(this.jdField_fe_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      this.d.setEnabled(true);
      this.cd.clearAnimation();
      this.cd.setVisibility(8);
      CK(false);
      float f1;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bza)
      {
        f1 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aC();
        if (!RMVideoStateMgr.byU) {}
        i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.cjI;
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj();
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate.a(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, f1, i, j);
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bza = false;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i = null;
      }
      boolean bool = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xd();
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (!bool))
      {
        f1 = (float)(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk() * 1000.0F / this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.f(f1, -1);
      }
      return;
    }
  }
  
  public void cwx()
  {
    Object localObject1 = null;
    if (this.wr.isEnabled()) {
      this.wr.setEnabled(false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_previewState, needIntent:" + this.byk + ", shareToWeb:" + this.byr);
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((FilterDesc)localObject2).name)) && (!TextUtils.equals(((FilterDesc)localObject2).name, "EMPTY"))) {
        rar.a("video_shoot", "clk_swipe", tk(), 0, new String[] { ((FilterDesc)localObject2).name });
      }
    }
    if (!this.byp)
    {
      this.ciS = getIntent().getIntExtra("edit_video_type", 0);
      if (((this.ciS != 10000) && (this.ciS != 10003) && (this.ciS != 10004) && (this.ciS != 10010) && (this.ciS != 10012)) || (!this.byk)) {
        break label230;
      }
      Gk(this.ciS);
    }
    label230:
    int i;
    do
    {
      do
      {
        return;
        if ((this.ciS == 10002) && (this.byk))
        {
          i = this.ciP;
          if ((!this.bxL) || (i < 11000L))
          {
            Gl(i);
            return;
          }
          this.mUIHandler.postDelayed(new WaitStartEditActivityRunnable(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, i, null), 100L);
          return;
        }
        if (this.bxA)
        {
          cxu();
          return;
        }
      } while ((this.bxz) && (this.byk));
      if ((this.ciS == 10007) && (this.byk))
      {
        Gk(this.ciS);
        return;
      }
    } while ((this.bxz) || (this.ciS == 10000));
    if ((this.ciS == 10011) && (!bxt))
    {
      if (this.zX == null)
      {
        this.zX = getLayoutInflater().inflate(2131561439, null);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout)this.Aa).addView(this.zX, (ViewGroup.LayoutParams)localObject1);
      }
      this.zX.setVisibility(0);
      this.dO.setVisibility(8);
      ((Button)this.zX.findViewById(2131365412)).setOnClickListener(this);
      if (!bxt) {
        break label678;
      }
    }
    label663:
    label678:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ajrm.k("shoot", new String[] { localObject1 });
      return;
      int k = this.ciP;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
      i = j;
      if (j <= 0) {
        i = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
      if (i > 0) {
        this.cje = i;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.cIc = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(aniq.dGY, k, this.cje, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      localObject2 = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate.a();
      BitmapFactory.Options localOptions;
      if ((localObject2 != null) && (((aate.a)localObject2).thumbPath != null) && (((aate.a)localObject2).state.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.i == null))
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = 2;
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      }
      try
      {
        localObject2 = BitmapFactory.decodeFile(((aate.a)localObject2).thumbPath, localOptions);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label663;
      }
      if (localObject1 != null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
      break;
    }
  }
  
  public void cwz()
  {
    if (this.wr != null) {
      this.wr.setEnabled(true);
    }
    this.bwY = true;
    boolean bool1 = anii.isFoundProductFeature(anii.KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL);
    boolean bool2 = anii.isFoundProductManufacturer(anii.KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK);
    if ((!this.bwO) && ((bool1) || (bool2)) && (!this.byB))
    {
      this.byB = true;
      this.mUIHandler.postDelayed(this.jdField_fg_of_type_JavaLangRunnable, 2000L);
    }
    cxb();
  }
  
  void cxf()
  {
    if (!this.bxY) {}
    do
    {
      do
      {
        return;
      } while ((this.byr) && (!this.byu));
      if (this.jdField_a_of_type_Aasb != null) {
        break label117;
      }
      new ArrayList();
      if (this.ciS != 10003) {
        break;
      }
      localObject1 = PtvTemplateManager.a(this.appInterface).dI();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label117;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PTV.NewFlowCameraActivity", 2, "unfold failed due to no data to show");
    return;
    if (this.byr) {}
    for (int i = 2;; i = 1)
    {
      localObject1 = PtvTemplateManager.a(this.appInterface).a(true, false, i);
      break;
    }
    label117:
    if (this.gS)
    {
      cwW();
      this.d.showRedDot(false);
      this.gS = false;
    }
    this.d.clearAnimation();
    this.d.setVisibility(4);
    this.cd.clearAnimation();
    this.cd.setVisibility(8);
    if ((this.ciS == 10002) || (this.ciS == 10012)) {
      this.jdField_fe_of_type_AndroidWidgetButton.clearAnimation();
    }
    this.Oo.clearAnimation();
    this.Oo.setVisibility(4);
    this.mListView.setVisibility(0);
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = wja.dp2px(84.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).height = wja.dp2px(84.0F, getResources());
    this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)this.wr.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = wja.dp2px(59.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).height = wja.dp2px(59.0F, getResources());
    this.wr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.wr.setImageDrawable(null);
    this.ws.setVisibility(8);
    this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.bxw = true;
    cxs();
    cxr();
    if (this.ciS != 10002) {
      this.Ot.setVisibility(0);
    }
    if (this.bxz) {
      h("612", "4", "0", true);
    }
    Object localObject2;
    label464:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_Aasb == null)
    {
      this.mListView.setStayDisplayOffsetZero(true);
      new ArrayList();
      if (this.ciS == 10003)
      {
        localObject1 = PtvTemplateManager.a(this.appInterface).dI();
        if ((anjg.axy()) && (anjg.axx())) {}
        localObject2 = ((ArrayList)localObject1).iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label565;
        }
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
        if ((localPtvTemplateInfo.category != 1) && (localPtvTemplateInfo.category != 2)) {
          break label542;
        }
        ((Iterator)localObject2).remove();
      }
    }
    for (;;)
    {
      break label464;
      if (this.byr) {}
      for (i = 2;; i = 1)
      {
        localObject1 = PtvTemplateManager.a(this.appInterface).a(true, false, i);
        break;
      }
      label542:
      if ((localPtvTemplateInfo.category == 1) || (localPtvTemplateInfo.category == 2))
      {
        i = 1;
        continue;
        label565:
        if (i != 0) {
          aaqi.h("", "0X8008487", "", "", "", "");
        }
        this.jdField_a_of_type_Aasb = new aasb(this.appInterface, this, (ArrayList)localObject1, ciJ, this.mListView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout);
        this.jdField_a_of_type_Aasb.a(this);
        this.jdField_a_of_type_Aasb.a(this);
        this.mListView.setAdapter(this.jdField_a_of_type_Aasb);
        if ("qzoneOpenDongXiao".equals(this.callback))
        {
          i = p((ArrayList)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "position: " + i);
          }
          if (i != -1) {
            this.mListView.post(new NewFlowCameraActivity.36(this, i));
          }
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
          PtvTemplateManager.a(this.appInterface).a(this);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("setadapter list size: ");
          if (localObject1 == null)
          {
            i = 0;
            QLog.d("PtvTemplateManager", 2, i);
          }
        }
        else
        {
          if ((!this.byr) || (this.byx)) {
            break label841;
          }
        }
        label841:
        for (i = 1;; i = 0)
        {
          if ((aaqh.cix == 1) || (i != 0) || (this.ciS == 10011) || (!anih.agb())) {
            break label844;
          }
          k(-1, false);
          return;
          i = ((ArrayList)localObject1).size();
          break;
        }
        label844:
        break;
      }
    }
  }
  
  void cxi()
  {
    ram.i("PTV.NewFlowCameraActivity", "changeCameraDuringRecord");
    if (!this.byp) {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xf();
    }
    k(-1, true);
    this.mCamera.dQo();
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aatf.cwG();
    if ((aaqh.cix == 2) && (this.byc)) {
      this.mCamera.PS(true);
    }
    for (;;)
    {
      if (!this.byp) {
        cwt();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "start recording start time=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.mStartTime);
      }
      this.bxQ = true;
      this.fk.clearAnimation();
      this.d.clearAnimation();
      this.jdField_fe_of_type_AndroidWidgetButton.clearAnimation();
      this.fk.setVisibility(4);
      this.d.setVisibility(4);
      this.jdField_fe_of_type_AndroidWidgetButton.setVisibility(4);
      return;
      this.mCamera.PS(false);
    }
  }
  
  @TargetApi(11)
  void cxj()
  {
    int i = wja.dp2px(59.0F, getResources());
    int j = wja.dp2px(84.0F, getResources());
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new aarn(this, i, j));
    localValueAnimator.addListener(new aaro(this));
    localValueAnimator.start();
  }
  
  public void cxk()
  {
    int i;
    label116:
    Object localObject;
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if ((WU()) && (this.fk != null) && ((this.fk != this.jdField_fe_of_type_AndroidWidgetButton) || (this.bxI)))
      {
        this.fk.clearAnimation();
        this.fk.setVisibility(0);
        if (this.er == null) {
          break label597;
        }
        this.fk.setBackgroundDrawable(new BitmapDrawable(this.er));
        this.fk.setText("");
      }
      this.Oo.clearAnimation();
      this.Oo.setVisibility(4);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bzf) {
        break label611;
      }
      i = 0;
      bd(i, false);
      if (this.ciS == 10002) {
        this.jdField_fe_of_type_AndroidWidgetButton.clearAnimation();
      }
      this.cd.clearAnimation();
      this.cd.setVisibility(8);
      this.iO.clearAnimation();
      this.iO.setVisibility(4);
      this.wr.setEnabled(true);
      this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.bxy) {
        this.jdField_fg_of_type_AndroidWidgetButton.setVisibility(0);
      }
      cxs();
      cxr();
      localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(84.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(84.0F, getResources());
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.ws.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(59.0F, getResources());
      this.ws.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.wr.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(59.0F, getResources());
      this.wr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
      this.jdField_e_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
      this.wr.setVisibility(0);
      if (!this.bxw) {
        break label622;
      }
      if (this.jdField_a_of_type_Aasb != null) {
        this.jdField_a_of_type_Aasb.cxO();
      }
      this.mListView.setVisibility(0);
      this.Os.setVisibility(0);
      this.d.setVisibility(4);
      this.wr.setImageDrawable(null);
      localObject = this.Ot;
      if (this.ciS == 10002) {
        break label616;
      }
      i = 0;
      label444:
      ((TextView)localObject).setVisibility(i);
      if (this.ciS != 10002) {}
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.CY(false);
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cyf();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append("秒");
      this.Or.setText((CharSequence)localObject);
      this.Or.setVisibility(4);
      if (this.bxL)
      {
        this.ciM = 0;
        this.bY.set(false);
        this.bZ.set(false);
        this.wv.setVisibility(8);
        this.ww.setVisibility(8);
        this.Ow.setVisibility(8);
        this.Ox.setVisibility(8);
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate != null) {
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Aate.cyo();
      }
      return;
      label597:
      this.fk.setBackgroundResource(this.ciO);
      break;
      label611:
      i = 4;
      break label116;
      label616:
      i = 8;
      break label444;
      label622:
      this.mListView.setVisibility(4);
      this.Os.setVisibility(0);
    }
  }
  
  void cxl()
  {
    if (!this.bxL) {}
    while (this.ciP / 10000 == this.ciM) {
      return;
    }
    this.ciM = (this.ciP / 10000);
    ram.i("PTV.NewFlowCameraActivity", "adjustFragmentThumb. fragment count = %d.");
    if ((this.ciM < 6) && (!WV()))
    {
      QQToast.a(this, acfp.m(2131709014), 1).show();
      cxh();
      return;
    }
    Bitmap localBitmap = aq();
    if (localBitmap == null)
    {
      ram.e("PTV.NewFlowCameraActivity", "adjustFragmentThumb error. thumbBitmap = null.");
      return;
    }
    ThreadManager.postImmediately(new NewFlowCameraActivity.43(this, localBitmap), null, false);
  }
  
  void cxm()
  {
    if (!this.bxL) {}
    while ((this.ciP < 8000) || (this.bY.getAndSet(true))) {
      return;
    }
    ram.i("PTV.NewFlowCameraActivity", "show fragment tip.");
    this.Ox.setText(acfp.m(2131708991));
    this.Ox.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1500L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aarp(this));
    this.Ox.startAnimation(localAlphaAnimation);
  }
  
  void cxn()
  {
    if (!this.bxL) {}
    while ((this.ciP < 55000) || (this.bZ.getAndSet(true))) {
      return;
    }
    ram.i("PTV.NewFlowCameraActivity", "show end fragment tip.");
    this.Ox.setText("即将拍满6段进入编辑");
    this.Ox.setVisibility(0);
  }
  
  public void cxo()
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Aasb == null)
    {
      localObject1 = "";
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Aasb != null)
      {
        localObject1 = this.jdField_a_of_type_Aasb.a();
        if ((localObject1 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).category != 0)) {
          break label165;
        }
        localObject1 = localObject3;
      }
    }
    label165:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "filterFirstFrameOK path=" + (String)localObject2);
      }
      if ((this.jdField_a_of_type_Aasb != null) && ("-3".equals(this.jdField_a_of_type_Aasb.qD())))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(PtvTemplateManager.bYN);
        return;
        localObject1 = this.jdField_a_of_type_Aasb.bec;
        break;
      }
      if (localObject1 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject2);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject2, ((PtvTemplateManager.PtvTemplateInfo)localObject1).category, ((PtvTemplateManager.PtvTemplateInfo)localObject1).gestureType, ((PtvTemplateManager.PtvTemplateInfo)localObject1).gestureWording);
      return;
    }
  }
  
  public void cxp() {}
  
  public void cxq()
  {
    runOnUiThread(new NewFlowCameraActivity.46(this));
  }
  
  public void d(Bundle paramBundle, String paramString)
  {
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
            this.jdField_a_of_type_Aaqj.setRefer(paramString);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_Aaqj = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  public Bitmap f(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = null;; localObject1 = null)
    {
      try
      {
        if (this.bwX) {
          continue;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
        if (!TextureView.class.isInstance(localObject2)) {
          continue;
        }
        localObject2 = ((TextureView)localObject2).getBitmap(paramInt1, paramInt2);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("PTV.NewFlowCameraActivity", 2, "getViewBitmap oom" + localOutOfMemoryError);
        return null;
      }
      return localObject1;
    }
  }
  
  int fM(int paramInt)
  {
    int i = paramInt;
    if (RMVideoStateMgr.aH(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.bAl))
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
  
  public String getRefer()
  {
    return this.mRefer;
  }
  
  void go()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.f != null) {
        this.f.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void gs(int paramInt1, int paramInt2)
  {
    if (this.bxJ) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PTV.NewFlowCameraActivity", 2, "[previewSizeAdjustUI]rmStateMgr " + null);
    return;
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    this.bwZ = true;
    CJ(true);
    this.jdField_a_of_type_Aary.G(paramInt1, paramInt2, (int)this.screenWidth, (int)this.screenHeight);
    if ((this.bwZ) && (this.bwY) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {}
    for (;;)
    {
      aasx localaasx = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setPreviewSize(paramInt1, paramInt2, localaasx);
      if ((VersionUtils.isGingerBread()) && (!this.jdField_fg_of_type_AndroidWidgetButton.isEnabled())) {
        this.jdField_fg_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.fl.setEnabled(true);
      this.mUIHandler.removeCallbacks(this.jdField_fe_of_type_JavaLangRunnable);
      if (this.ciP < aniq.dGY) {
        this.mUIHandler.postDelayed(this.jdField_fe_of_type_JavaLangRunnable, 1000L);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PTV.NewFlowCameraActivity", 2, "previewSizeAdjustUI spec: " + localaasx.toString());
      return;
      if (WR())
      {
        localaasx = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.aF(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, localaasx.cjI, localaasx.cjJ);
          cwk();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.jA(-1, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cjL * 1000);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setHwEncoder(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
      }
    }
  }
  
  public void h(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.a locala = new QZoneClickReport.a();
    locala.actionType = paramString1;
    locala.cMI = paramString2;
    locala.reserves = paramString3;
    paramString1 = "";
    if (this.appInterface != null) {
      paramString1 = this.appInterface.getCurrentAccountUin();
    }
    QZoneClickReport.report(paramString1, locala, paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    boolean bool1 = bool2;
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1007: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        go();
        QQToast.a(this, 1, 2131720152, 0).show();
        CR(true);
        return true;
        bool1 = bool2;
      } while (!iT(this.lastLoginUin));
      cvH();
      return true;
      cvH();
      return true;
      if (this.jdField_n_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_n_of_type_AndroidWidgetSeekBar.startAnimation(this.jdField_w_of_type_AndroidViewAnimationAlphaAnimation);
      }
      bool1 = bool2;
    } while (this.mTip == null);
    this.mTip.startAnimation(this.jdField_w_of_type_AndroidViewAnimationAlphaAnimation);
    return true;
  }
  
  protected void initData(Bundle paramBundle)
  {
    super.initData(paramBundle);
    this.cin = 0;
    this.cio = 0;
    this.cip = 0;
    this.ciq = 0;
    this.cir = 0;
    this.Mk = -1L;
    this.eq = null;
    this.bwO = false;
    this.ad = null;
    this.bxd = false;
    this.bxb = false;
    this.bxc = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.bwY = false;
    this.bwZ = false;
    Intent localIntent = super.getIntent();
    this.byg = localIntent.getBooleanExtra("support_photo_merge", false);
    if (paramBundle != null) {
      this.bxR = paramBundle.getBoolean("flow_camera_capture_mode", false);
    }
    if (this.bxR) {
      this.byg = true;
    }
    this.ciR = localIntent.getIntExtra("video_min_frame_count", 11);
    this.byh = localIntent.getBooleanExtra("recapture", false);
    this.showGuide = localIntent.getBooleanExtra("show_guide_view", false);
    this.activityStartTime = localIntent.getLongExtra("activity_start_time", 0L);
    c(localIntent, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Start NewFlowCameraActivity time : " + this.activityStartTime);
    }
    if (this.byr) {
      aaqi.h("", "0X8007930", "", "", "", "");
    }
    try
    {
      if (this.appInterface != null) {
        HwServlet.getConfig(this.appInterface, this.appInterface.getCurrentAccountUin());
      }
      aasp.Gf(this.ciS);
      this.mEntranceType = localIntent.getIntExtra("entrance_type", 99);
      this.mSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO"));
      aaqh.cix = 2;
      if ((anih.agb()) && (!this.byg)) {
        aaqh.cix = 1;
      }
      aaqh.rw = 0.75F;
      if (paramBundle == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
      this.bya = false;
      Object localObject = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
      boolean bool1;
      boolean bool2;
      label586:
      label751:
      int i;
      label940:
      int j;
      if ((localObject != null) && (((ConfigurationInfo)localObject).reqGlEsVersion >= 131072))
      {
        bool1 = true;
        this.bya = bool1;
        this.bxY = false;
        this.bxZ = true;
        bool1 = paramBundle.getBoolean("flow_camera_use_filter_function", false);
        if (bool1)
        {
          this.bxY = ankq.axX();
          this.bxZ = ankq.axY();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "<FilterInit_> useFilter=" + bool1 + " mHasFilterSoLib=" + this.bxY + "  mIsLibVersionErr=" + this.bxZ);
        }
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.be(this.ciS, this.bxY);
        this.byp = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.hB(1);
        if (this.ciS == 10002)
        {
          bool2 = VideoEnvironment.lw(7);
          boolean bool3 = ((Boolean)((psr)psx.a(10)).c("boolean_enable_multi_video_fragment", Boolean.valueOf(true))).booleanValue();
          if ((!bool2) || ((!bool3) && (!this.byp))) {
            break label1250;
          }
          bool1 = true;
          this.bxL = bool1;
          if (paramBundle.getLong("troop_uin", 0L) != 0L) {
            this.bxL = false;
          }
          ram.a("PTV.NewFlowCameraActivity", "avCodecSupportMultiVideoBlock=%s, notMultiVideoBlockBlackList=%s, supportMediaCodec=%s", Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.byp));
        }
        bQ(paramBundle);
        a(paramBundle, false);
        if (this.bxz) {
          h("612", "1", "0", true);
        }
        this.bwQ = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
        this.bwT = paramBundle.getBoolean("flow_camera_video_mode", false);
        localObject = paramBundle.getString("sv_config");
        bool2 = paramBundle.getBoolean("sv_whitelist");
        this.bxV = paramBundle.getBoolean("flow_show_filter_red", false);
        this.bxW = paramBundle.getBoolean("flow_show_filter_red_pkg", false);
        if ((!this.bxV) && (!this.bxW)) {
          break label1256;
        }
        bool1 = true;
        this.gS = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "<hongdian> mShowRedDotConfig=" + this.bxV + " mShowRedDotPkg=" + this.bxW + "  mShowRedDot=" + this.gS);
        }
        this.callback = paramBundle.getString("callback");
        if ((this.ciS != 10003) && (this.ciS != 10011)) {
          aaqh.cix = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", aaqh.cix);
        }
        cwU();
        if ((getIntent().getLongExtra("babyq_ability", 0L) & 1L) > 0L) {
          aaqh.cix = 2;
        }
        this.cjb = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", aaqh.cix);
        paramBundle = this.jdField_a_of_type_Aary;
        if (aaqh.cix != 1) {
          break label1262;
        }
        bool1 = true;
        paramBundle.setMirror(bool1);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.faceGuide", 2, "initdata mHasFilterSoLib =" + this.bxY);
        }
        i = 0;
        paramBundle = (SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (paramBundle != null) {
          i = paramBundle.cZ;
        }
        this.mReportParams.put("sessionType", String.valueOf(i));
        this.jdField_b_of_type_Qqz = new qqz(this, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, localIntent);
        if (th() == 102) {
          this.jdField_b_of_type_Qqz.th(false);
        }
        paramBundle = (Bundle)localObject;
        if (this.ciS == 10002)
        {
          localObject = this.jdField_b_of_type_Qqz.fY((String)localObject);
          paramBundle = (Bundle)localObject;
          if (((Integer)((psr)psx.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == -1)
          {
            this.jdField_b_of_type_Qqz.bpQ();
            paramBundle = (Bundle)localObject;
          }
        }
        j = aqiw.getSystemNetwork(this);
        this.byb = localIntent.getBooleanExtra("ignore_dpc_duration", false);
        this.bxA = localIntent.getBooleanExtra("is_glance_video", false);
        if (!this.byb) {
          break label1268;
        }
        this.videoDuration = localIntent.getIntExtra("video_duration", 20);
        ciK = this.videoDuration;
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 3, paramBundle, bool2, i, j, this.videoDuration);
      }
      for (;;)
      {
        if (this.bxL) {
          aniq.dGY = 60000;
        }
        if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, aaqi.a(this), this)) {
          break label1468;
        }
        this.jdField_b_of_type_Qqz.bpR();
        super.finish();
        return;
        bool1 = false;
        break;
        label1250:
        bool1 = false;
        break label586;
        label1256:
        bool1 = false;
        break label751;
        label1262:
        bool1 = false;
        break label940;
        label1268:
        if (this.bxA)
        {
          this.ciL = localIntent.getIntExtra("glance_video_max_time", QzoneConfig.getInstance().getConfig("MiniVideo", "GlanceVideoMaxTime", 1));
          ciK = this.ciL;
          this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 2, paramBundle, bool2, i, j, this.ciL);
          VideoEnvironment.UR(this.ciL);
          LpReportInfo_pf00064.allReport(627, 1);
        }
        else
        {
          this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 2, paramBundle, bool2, i, j, this.cim);
          if ((this.ciS == 10000) || (this.ciS == 10003) || (this.ciS == 10011) || (this.ciS == 10004) || (this.ciS == 10010)) {
            VideoEnvironment.UR(10);
          }
          if (this.byr) {
            VideoEnvironment.UR(10);
          }
          ciK = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.yY();
          if (this.bxz) {
            aniq.dGY += 100;
          }
        }
      }
      label1468:
      this.mGestureDetector = new GestureDetector(this, new a(this));
      localObject = getResources().getDisplayMetrics();
      this.screenWidth = ((DisplayMetrics)localObject).widthPixels;
      this.screenHeight = ((DisplayMetrics)localObject).heightPixels;
      this.mQ = (this.screenHeight / this.screenWidth);
      this.cik = ((int)this.screenHeight);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new aaqv(this, getApplicationContext());
      if ((this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) && (this.ciS != 10002)) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.mCamera = new anim(this, this.mUIHandler);
      this.mCamera.a(this.jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener);
      this.mCamera.dGT = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.yX();
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.mCamera);
      this.mCamera.a(new anil(this.mUIHandler, this.jdField_a_of_type_Anil$a));
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "initData(), mPtvMode:false,mCaptureMode:false, config=" + paramBundle + ", white=" + bool2);
      }
      cwT();
      GLVideoClipUtil.czn();
      alwx.aCD();
      alwx.dyy = this.ciS;
      alwx.cAd = false;
      alwx.dKr();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.runOnUiThread(new NewFlowCameraActivity.49(this, paramInt, paramBoolean1, paramBoolean2));
  }
  
  public void k(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new NewFlowCameraActivity.45(this, paramString, paramInt));
  }
  
  public void kf(String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.cjN = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zk();
    if (!this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.hC(this.ciR)) {
      return;
    }
    getIntent().getIntExtra("edit_video_type", 0);
    this.bdS = paramString;
    this.bdT = this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdT;
    this.g = new LocalMediaInfo();
    this.g.path = this.bdS;
    this.g.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onEncodeFinish. hwVideoFilePath = " + this.bdS + " ; hwAudioFilePath = " + this.bdT);
    }
    MediaScanner.getInstance(this).queryMediaInfoAsync(this, this.g);
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    paramString.putInt("sp_mc_crash_times", 0);
    aqmj.b(paramString);
  }
  
  public void n(boolean paramBoolean, String paramString, int paramInt)
  {
    super.runOnUiThread(new NewFlowCameraActivity.52(this, paramBoolean, paramString, paramInt));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    w(paramInt1, paramInt2, paramIntent);
    x(paramInt1, paramInt2, paramIntent);
    y(paramInt1, paramInt2, paramIntent);
    z(paramInt1, paramInt2, paramIntent);
    A(paramInt1, paramInt2, paramIntent);
    B(paramInt1, paramInt2, paramIntent);
    C(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1)) {
      this.bwI = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aaqj != null) {
        this.jdField_a_of_type_Aaqj.onActivityResult(this, paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt1 == 1014)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
        }
        if (paramInt2 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
          }
          if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
            aqhq.cn(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG);
          }
          h("608", "2", "0", true);
          if ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4))
          {
            this.byj = true;
            cxe();
            this.byk = true;
            this.bxU = true;
          }
        }
        else if (paramInt2 == -1)
        {
          QLog.i("PTV.NewFlowCameraActivity", 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
          finish();
        }
      }
      else if (paramInt1 == 3)
      {
        if (paramInt2 == -1)
        {
          onBackPressed();
        }
        else if (paramInt2 == 0)
        {
          QLog.d("PTV.NewFlowCameraActivity", 4, "REQ_EDIE_LOCAL_VIDEO RESULT_CANCELED");
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
          }
          this.bxK = true;
          if ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4) || (this.bxJ))
          {
            h("608", "2", "0", true);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.onResume();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
            }
            this.bxJ = false;
          }
        }
      }
    }
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    if (this.bwP)
    {
      if ((this.ciS == 10011) && (this.zX != null) && (this.zX.getVisibility() == 0))
      {
        this.zX.setVisibility(8);
        this.dO.setVisibility(0);
        this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.AQ("PTV.NewFlowCameraActivity");
        cxe();
        return;
      }
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
      boolean bool;
      if (i == 2131367314)
      {
        aarz.cxy();
        if (!this.byc) {}
        for (bool = true;; bool = false)
        {
          this.byc = bool;
          cxb();
          if (this.ciS != 10002) {
            break;
          }
          if (!this.byc) {
            break label88;
          }
          rar.a("video_shoot", "open_flash", 0, 0, new String[0]);
          break;
        }
        label88:
        rar.a("video_shoot", "close_flash", 0, 0, new String[0]);
      }
      else
      {
        label122:
        Object localObject1;
        if (i == 2131367316)
        {
          if (!this.byd)
          {
            bool = true;
            this.byd = bool;
            cxc();
            GLVideoClipUtil.enableNightMode(this.byd);
            if (!this.byd) {
              break label190;
            }
          }
          label190:
          for (localObject1 = "1";; localObject1 = "0")
          {
            anot.a(null, "dc00898", "", "", "0X8007BB7", "0X8007BB7", 0, 0, (String)localObject1, "", "", "");
            break;
            bool = false;
            break label122;
          }
        }
        if (i == 2131367247)
        {
          if ((aqft.cC()) && (!this.bwP) && (QLog.isColorLevel())) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the capture button.");
          }
        }
        else if (i == 2131367251)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
          }
          if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4) {
            cxe();
          }
        }
        else if (i == 2131367313)
        {
          aaqi.ec("", "0X8006A12");
          cwl();
        }
        else if ((i == 2131367254) || (i == 2131367318) || (i == 2131377990))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "click right state is =" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
          }
          if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "click right totalTime=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL);
            }
            if (!this.byr)
            {
              if (this.ciS == 10011)
              {
                if (TextUtils.isEmpty(this.bdN)) {
                  new b(this, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$c, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.zj(), false).execute(new Void[0]);
                }
                for (;;)
                {
                  AF(acfp.m(2131708985));
                  break;
                  AG(this.bdN);
                }
              }
              new alyr(BaseApplication.getContext());
              this.bxb = true;
              cwo();
              this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.stopWatching();
              Ge(102);
              aqip.bj(this.bdE, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL + ",frames = " + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
              localObject1 = alvs.a().a().a(this.bdE);
              if (localObject1 != null) {
                ((alvp)localObject1).b(this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bdG, (int)this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.bL, this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.Ml, this.cis);
              }
              CH(true);
              this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.mPreviewWidth, this.mPreviewHeight, this.bwX, false, null);
              if (!VideoEnvironment.awS())
              {
                setResult(1001);
                finish();
              }
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "click right invisible enable=" + paramView.isEnabled());
            }
            acbs.go(this.xf);
            cxf();
            aaqi.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X800781F", null);
            aaqi.ec("", "0X8006A14");
            aasp.c("shortvideo_effects_entry", null);
            if (this.bxA) {
              LpReportInfo_pf00064.allReport(627, 3);
            }
          }
        }
        else if (i == 2131367315)
        {
          bxt = false;
          k(-1, false);
          if ((aaqh.cix == 1) && (this.jdField_a_of_type_Aasb == null) && (this.bxY)) {
            cxf();
          }
          aaqi.ec("", "0X8006A15");
          aasp.c("shortvideo_rotate_camera", null);
          if (this.ciS == 10002) {
            if (aaqh.cix == 1) {
              rar.a("video_shoot", "camera_front", 0, 0, new String[0]);
            } else {
              rar.a("video_shoot", "camera_back", 0, 0, new String[0]);
            }
          }
        }
        else if (i == 2131367256)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get());
          }
          if ((this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() == 4) || (this.bxJ))
          {
            h("608", "2", "0", true);
            if (WW()) {
              aaqi.ec("", "0X8006A17");
            }
            for (;;)
            {
              CF(true);
              if (this.bxS) {
                this.bxT = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d("face", 2, "click left hasChangeCamera" + this.bxS);
              }
              cxk();
              break;
              aaqi.ec("", "0X8006A1B");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("PTV.NewFlowCameraActivity", 2, "flow_camera_btn_video_local");
          }
          if (this.jdField_a_of_type_Aaqj != null) {
            this.jdField_a_of_type_Aaqj.aG(this);
          }
          this.mUIHandler.postDelayed(new NewFlowCameraActivity.33(this), 1000L);
        }
        else
        {
          Object localObject2;
          Object localObject3;
          Iterator localIterator;
          if (i == 2131367304)
          {
            localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1");
            localObject1 = "";
            if (this.appInterface != null) {
              localObject1 = this.appInterface.getCurrentAccountUin();
            }
            localObject1 = ((String)localObject2).replace("{uin}", (CharSequence)localObject1).replace("{qua}", avpq.getQUA3());
            h("608", "6", "0", true);
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("permission_code", this.mPriv);
            if ((this.eo != null) && (this.eo.size() > 0))
            {
              ((Bundle)localObject2).putStringArrayList("uin_list", this.eo);
              localObject3 = new ArrayList(this.eo.size());
              localIterator = this.eo.iterator();
              while (localIterator.hasNext()) {
                ((ArrayList)localObject3).add(bj((String)localIterator.next()));
              }
              ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
            }
            if ((bg(this.mPriv)) && (!TextUtils.isEmpty(this.pO))) {
              ((Bundle)localObject2).putString("key_setting_raw_json", this.pO);
            }
            avpw.forwardToBrowser(this, (String)localObject1, 2, (Bundle)localObject2, "");
          }
          else
          {
            if (i == 2131367261)
            {
              this.bwF = true;
              this.bxB = true;
              this.mNeedPauseRichMedia = true;
              h("608", "5", "0", true);
              localObject2 = avpw.d.a();
              localObject3 = new Bundle();
              ((Bundle)localObject3).putInt("permission_code", this.mPriv);
              if ((this.eo != null) && (this.eo.size() > 0))
              {
                ((Bundle)localObject3).putStringArrayList("uin_list", this.eo);
                localObject1 = new ArrayList(this.eo.size());
                localIterator = this.eo.iterator();
                while (localIterator.hasNext()) {
                  ((ArrayList)localObject1).add(bj((String)localIterator.next()));
                }
                ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
              }
              if ((bg(this.mPriv)) && (!TextUtils.isEmpty(this.pO))) {
                ((Bundle)localObject3).putString("key_setting_raw_json", this.pO);
              }
              if (this.zJ == null)
              {
                this.zJ = new View(this);
                this.zJ.setBackgroundColor(Color.argb(128, 0, 0, 0));
                this.zJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((RelativeLayout)this.Aa).addView(this.zJ);
              }
              this.zJ.setVisibility(0);
              localObject1 = "";
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
              }
              if (this.isTopic) {}
              for (i = 0;; i = 1)
              {
                avpw.a(this, (avpw.d)localObject2, 1009, "", (String)localObject1, "", "", 0, i, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, this.isTopic, this.topicSyncQzone, this.cif, this.cih, false);
                break;
              }
            }
            if (i == 2131365418)
            {
              rar.a("video_shoot", "clk_now", 0, 0, new String[0]);
              if (aifl.aoW())
              {
                ram.d("PTV.NewFlowCameraActivity", "now app is installed");
                aifl.cM(null);
              }
              else
              {
                rar.a("video_shoot", "exp_now", 0, 0, new String[0]);
                ram.d("PTV.NewFlowCameraActivity", "now app is not installed, ask the user");
                localObject1 = aqha.a(this, 230);
                ((aqju)localObject1).setTitle(null);
                ((aqju)localObject1).setMessage("首次开启直播需下载NOW应用");
                ((aqju)localObject1).setNegativeButton(acfp.m(2131708993), new aarj(this));
                ((aqju)localObject1).setPositiveButton(acfp.m(2131709016), new aark(this));
                ((aqju)localObject1).getBtnight().getPaint().setFakeBoldText(true);
                ((aqju)localObject1).setCancelable(true);
                ((aqju)localObject1).getWindow().setBackgroundDrawable(new ColorDrawable(0));
                ((aqju)localObject1).show();
              }
            }
            else if (i == 2131365412)
            {
              cxe();
              if (this.zX != null)
              {
                this.zX.setVisibility(8);
                this.dO.setVisibility(0);
              }
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
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
      QLog.i("PTV.NewFlowCameraActivity", 2, localStringBuilder.toString());
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = WQ();
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131708998), 0).show();
      finish();
      return;
    }
    this.appInterface = axol.getAppInterface();
    aavi.f = this.appInterface;
    aavi.a(this.appInterface);
    if (this.ciS == 10002) {
      QQStoryFlowCallback.b(this, 1);
    }
    if (this.ciS == 10002) {
      rar.a("video_shoot", "exp_findview", 0, 0, new String[] { "", "", "", th() + "" });
    }
    if ((this.ciS == 10000) || (this.ciS == 10004) || (this.ciS == 10010)) {
      aarz.cxH();
    }
    PerfTracer.traceEnd("Video_component_onCreate");
    this.Ml = 0L;
    this.cis = 0;
    if (this.ciS == 10003)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "Begin to initBlessSpecialPendantConfigInfo!");
      }
      PtvTemplateManager.a(this.appInterface).A(this.appInterface);
    }
    for (;;)
    {
      paramBundle = ViewConfiguration.get(this);
      this.mMinimumVelocity = paramBundle.getScaledMinimumFlingVelocity();
      this.mMaximumVelocity = paramBundle.getScaledMaximumFlingVelocity();
      if (VideoEnvironment.Jr() >= 65) {}
      try
      {
        VideoSourceHelper.nativeSetMaxPhotoFrameCount(0);
        this.jdField_b_of_type_Aurf = new aurf(this);
        this.jdField_b_of_type_Aurf.sendEmptyMessage(1008);
        RMVideoStateMgr.a().byV = true;
        paramBundle = (prw)((psd)psx.a(20)).a(1);
        if (paramBundle.getData() == null) {
          paramBundle.biW();
        }
        Gn(aaqh.cix);
        anpc.report("exposure_newFlowCamera");
        return;
        if (this.byr)
        {
          PtvTemplateManager.a(this.appInterface).z(this.appInterface);
          continue;
        }
        PtvTemplateManager.a(this.appInterface).y(this.appInterface);
      }
      catch (UnsatisfiedLinkError paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "nativeSetMaxPhotoFrameCount:exp=", paramBundle);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mUIHandler.removeCallbacksAndMessages(null);
    if (this.mClient != null) {
      this.mClient.bzk();
    }
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.onDestroy();
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.onDestroy();
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
      }
      if (this.ad != null)
      {
        this.ad.dismiss();
        this.ad = null;
      }
      if (this.ciS == 10002) {
        QQStoryFlowCallback.bI(this);
      }
      if (!this.bxZ) {
        ThreadManager.post(new NewFlowCameraActivity.28(this), 8, null, true);
      }
      aasr.a().setCurrentId(null);
      aasr.a().destroy();
      aasr.a().release();
      if (this.mCamera != null) {
        this.mCamera.a(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor != null) {
        this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.cRe();
      }
      PtvTemplateManager.a(this.appInterface).a(null);
      aarz.a(this.cjb, Mr - this.activityStartTime, this.ciS + "", byq);
      if (aaqh.cix == 2)
      {
        String str1 = "back";
        aarz.ap(str1, anhm.dGc + "*" + anhm.dGd, aarz.bdX);
        aarz.aCD();
        Mr = 0L;
        byq = false;
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAdjustment", 2, "clear firstFrameShownTime :  " + Mr);
        }
        aavi.destroyInstance();
        anjg.nq.clear();
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PTV.NewFlowCameraActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
          continue;
          String str2 = "front";
        }
      }
    }
  }
  
  public void onFailed(int paramInt)
  {
    QLog.e("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onFailed , failCode = " + paramInt);
    bs(null, false);
  }
  
  public void onItemSelected(int paramInt)
  {
    cxs();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mUIHandler.post(new NewFlowCameraActivity.12(this));
      ambe.j(new RuntimeException("onMediaInfoChanged failed"));
      return;
    }
    a(this.ciS, this.bdS, this.bdT, paramLocalMediaInfo, 0, 0);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131708988), 0).show();
      finish();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.bxJ = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.onPause();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(8);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.Xf();
      this.isRecording = false;
    }
    this.R = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
    this.R.putExtras(paramIntent);
    this.R.putExtra("is_qzone_vip", this.bwI);
    this.R.putExtra("param.topicId", this.topicId);
    this.R.putExtra("param.topicSyncQzone", this.topicSyncQzone);
    this.R.putExtra("extra_key_font_id", this.cif);
    this.R.putExtra("extra_key_font_format_type", this.cig);
    this.R.putExtra("extra_key_font_url", this.mFontUrl);
    this.R.putExtra("extra_key_super_font_id", this.cih);
    this.R.putExtra("extra_key_super_font_info", this.bdz);
    this.R.putExtra("short_video_refer", this.mRefer);
    this.R.putExtra("set_user_callback", this.bdA);
    this.jdField_b_of_type_Aurf.postDelayed(new NewFlowCameraActivity.53(this), 0L);
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.wt.setBackgroundResource(2130851770);
    this.wu.setBackgroundResource(2130851770);
    if (this.bwF) {}
    do
    {
      return;
      this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.onPause();
      Object localObject = RMVideoStateMgr.a();
      ((RMVideoStateMgr)localObject).cyn();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.onPause();
      this.bwO = false;
      if (this.ciu == 1) {
        avzl.a().eCO();
      }
      if (((RMVideoStateMgr)localObject).aL.get() == 4) {
        cwm();
      }
      localObject = $(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367243);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      }
      if ((!this.bxd) && (!this.bxb) && (!this.bxc))
      {
        this.bxd = true;
        this.mUIHandler.postDelayed(this.ff, 300000L);
      }
      if (this.ciS == 10002) {
        ((rgp)psx.a(8)).btZ();
      }
      aasr.a().destroy();
      aavi.a(this.appInterface).czq();
    } while ((this.bxJ) || (this.mCamera == null));
    this.mCamera.PR(true);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.isSend)
    {
      this.wt.setBackgroundResource(2130846876);
      this.wu.setBackgroundDrawable(this.el);
    }
    for (;;)
    {
      this.bxP = false;
      if ((this.ciS != 10002) || (this.jdField_b_of_type_Qqz.bnI != 1)) {
        break;
      }
      ram.i("PTV.NewFlowCameraActivity", "onResume do nothing because we are going to publish");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
      }
    }
    if ((!this.bxJ) && (this.mCamera != null) && (!this.isSend)) {
      this.mCamera.dQj();
    }
    if (this.bwF)
    {
      this.mUIHandler.removeCallbacks(this.ff);
      return;
    }
    if (this.bxJ) {
      this.mUIHandler.removeCallbacks(this.ff);
    }
    doOnResume();
    aavi.a(this.appInterface).czp();
  }
  
  public void onStart()
  {
    super.onStart();
    cjC();
    this.bo = 0.0D;
    this.bp = 0.0D;
    this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a = new aarf(this, 1, true, true, 0L, false, false, "NewFlowCameraActivity");
    SosoInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.bxT) {
      this.bxU = true;
    }
    if ((this.jdField_a_of_type_Aasb == null) || (this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a != null))
    {
      SosoInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
      this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a = null;
      this.bo = 0.0D;
      this.bp = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.bwW) {}
    while ((this.aNE) || (!this.wr.isClickable())) {
      return bool;
    }
    if (paramMotionEvent.getAction() != 2) {
      this.byz = false;
    }
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a);
    if (this.jdField_a_of_type_Reu.onTouchEvent(paramMotionEvent, false))
    {
      ram.v("PTV.NewFlowCameraActivity", "mNewStoryCameraZoom consume the touch event");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.cxV();
      }
      if (!this.byz)
      {
        aaqi.h("", "0X80075BC", "", "", "", "");
        this.bxu = true;
      }
      this.byz = true;
      return true;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.aL.get() != 4)
    {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.isShown())) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (!this.byA)) {
        CP(false);
      }
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PTV.NewFlowCameraActivity", 2, "onTouchEvent", localException);
        }
        paramMotionEvent.setAction(3);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  int p(ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList)
  {
    String str = getIntent().getStringExtra("dongxiao_id");
    if (!aqmr.isEmpty(str))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((paramArrayList.get(i) != null) && (((PtvTemplateManager.PtvTemplateInfo)paramArrayList.get(i)).id.equals(str))) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void r(Activity paramActivity, Intent paramIntent) {}
  
  public void run() {}
  
  public void setRefer(String paramString)
  {
    this.mRefer = paramString;
  }
  
  void sq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.f == null) {
          continue;
        }
        go();
        localTextView = (TextView)this.f.findViewById(2131373180);
        if (!aqmr.isEmpty(paramString)) {
          continue;
        }
        localTextView.setText(2131717151);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.f.isShowing()) {
        return;
      }
      this.f.show();
      return;
      this.f = new ReportProgressDialog(this, 2131756467);
      this.f.setCancelable(false);
      this.f.show();
      this.f.setContentView(2131559761);
    }
  }
  
  public int th()
  {
    Object localObject = super.getIntent();
    int j = ((Intent)localObject).getIntExtra("entrance_type", 99);
    int i = j;
    if (j == 100)
    {
      localObject = (SessionInfo)((Intent)localObject).getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localObject == null) {
        break label50;
      }
    }
    label50:
    for (i = ((SessionInfo)localObject).cZ;; i = 0)
    {
      i = anfe.hS(i);
      return i;
    }
  }
  
  public int tk()
  {
    switch (getIntent().getIntExtra("edit_video_type", 0))
    {
    default: 
      return 0;
    case 10002: 
      return 1;
    case 10000: 
      return 2;
    case 10001: 
      return 3;
    }
    return 5;
  }
  
  public void uy()
  {
    this.uN = ad(this.mPriv);
    this.fc.setText(this.uN);
  }
  
  protected void v(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onPreviewResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
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
  
  public int yQ()
  {
    return 0;
  }
  
  public int yU()
  {
    return this.mOrientation;
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
        QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.b);
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
    int mCount;
    
    RefreshUITimer(boolean paramBoolean)
    {
      this.bxj = paramBoolean;
      this.mCount = NewFlowCameraActivity.this.c.timerCount;
    }
    
    public void run()
    {
      if (this.bxj)
      {
        NewFlowCameraActivity.this.cwE();
        NewFlowCameraActivity.this.cxl();
        NewFlowCameraActivity.this.cxm();
        NewFlowCameraActivity.this.cxn();
      }
    }
  }
  
  static class RunnableUpdate
    implements Runnable
  {
    Bitmap et;
    ImageView wx;
    
    RunnableUpdate(Bitmap paramBitmap, ImageView paramImageView)
    {
      this.et = paramBitmap;
      this.wx = paramImageView;
    }
    
    public void run()
    {
      if (this.et != null) {
        this.wx.setImageBitmap(this.et);
      }
    }
  }
  
  public class RunnableUpdateThumb
    implements Runnable
  {
    Bitmap cn;
    public Bitmap eu;
    
    public RunnableUpdateThumb(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2)
    {
      this.cn = paramBitmap1;
      this.eu = paramBitmap2;
    }
    
    private void cxx()
    {
      if ((NewFlowCameraActivity.a(NewFlowCameraActivity.this) == null) || (NewFlowCameraActivity.b(NewFlowCameraActivity.this) == null) || (NewFlowCameraActivity.a(NewFlowCameraActivity.this) == null))
      {
        ram.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. mFragmentAnimThumbView == null or mFragmentThumbView == null or mFragmentNumView == null.");
        return;
      }
      NewFlowCameraActivity.a(NewFlowCameraActivity.this).setImageBitmap(this.cn);
      NewFlowCameraActivity.a(NewFlowCameraActivity.this).setVisibility(0);
      NewFlowCameraActivity.b(NewFlowCameraActivity.this).setVisibility(8);
      int i = ankt.SCREEN_WIDTH;
      int j = ankt.aC(NewFlowCameraActivity.this.getApplicationContext());
      int k = wja.dp2px(47.0F, NewFlowCameraActivity.this.getResources());
      int m = wja.dp2px(75.0F, NewFlowCameraActivity.this.getResources());
      int n = wja.dp2px(12.0F, NewFlowCameraActivity.this.getResources());
      int i1 = wja.dp2px(20.0F, NewFlowCameraActivity.this.getResources());
      ram.i("PTV.NewFlowCameraActivity", "startScaleAnim. sWidth:" + i + " sHeight:" + j + " dWidth:" + k + " dHeight:" + m + " sMarginLeft:" + 0 + " sMarginBottom:" + 0 + " dMarginLeft:" + n + " dMarginBottom:" + i1);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(300L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new aarw(this, k, i, m, j, n, i1));
      localValueAnimator.addListener(new aarx(this));
      localValueAnimator.start();
    }
    
    public void run()
    {
      if (!NewFlowCameraActivity.this.bxL)
      {
        ram.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. enableMultiFragment = %s.", new Object[] { Boolean.valueOf(NewFlowCameraActivity.this.bxL) });
        return;
      }
      cxx();
    }
  }
  
  class WaitStartEditActivityRunnable
    implements Runnable
  {
    public final File[] c;
    public final int ciC;
    public long length;
    public final long startTime = SystemClock.elapsedRealtime();
    
    private WaitStartEditActivityRunnable(String paramString, int paramInt)
    {
      paramString = new File(paramString);
      if (paramString.isDirectory()) {}
      for (this.c = paramString.listFiles();; this.c = null)
      {
        this.length = getLength();
        this.ciC = paramInt;
        NewFlowCameraActivity.this.sq(acfp.m(2131709017));
        return;
      }
    }
    
    private long getLength()
    {
      long l1 = 0L;
      long l2 = l1;
      if (this.c != null)
      {
        File[] arrayOfFile = this.c;
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          l2 = aqhq.getFileSizes(arrayOfFile[i].getAbsolutePath());
          i += 1;
          l1 = l2 + l1;
        }
      }
      return l2;
    }
    
    public void run()
    {
      long l = getLength();
      ram.a("PTV.NewFlowCameraActivity", "recordTime = %d, currentLength = %d, old length = %d", Integer.valueOf(this.ciC), Long.valueOf(l), Long.valueOf(this.length));
      if (l == this.length)
      {
        rar.b("video_shoot", "wait_start_edit", 0, 0, new String[] { Build.MODEL.toLowerCase(), String.valueOf(SystemClock.elapsedRealtime() - this.startTime), String.valueOf(this.ciC) });
        NewFlowCameraActivity.this.go();
        NewFlowCameraActivity.a(NewFlowCameraActivity.this, this.ciC);
        return;
      }
      this.length = l;
      NewFlowCameraActivity.this.mUIHandler.postDelayed(this, 500L);
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
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (NewFlowCameraActivity.this.ciS == 10002) {
        rar.a("video_shoot", "camera_clkdouble", 0, 0, new String[0]);
      }
      if (NewFlowCameraActivity.this.bxJ) {}
      do
      {
        do
        {
          return true;
          if (NewFlowCameraActivity.a(NewFlowCameraActivity.this) != null) {
            NewFlowCameraActivity.a(NewFlowCameraActivity.this).cxV();
          }
        } while (!anih.agb());
        NewFlowCameraActivity.a(NewFlowCameraActivity.this, -1, false);
      } while ((aaqh.cix != 1) || (NewFlowCameraActivity.this.a != null));
      NewFlowCameraActivity.this.cxf();
      return true;
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
      if (NewFlowCameraActivity.this.bwT) {
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      if (Math.abs(f) > this.lB)
      {
        NewFlowCameraActivity.this.ax(f);
        if (NewFlowCameraActivity.a(NewFlowCameraActivity.this) != null) {
          NewFlowCameraActivity.a(NewFlowCameraActivity.this).cxV();
        }
        return true;
      }
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return NewFlowCameraActivity.a(NewFlowCameraActivity.this, paramMotionEvent);
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
  
  public static class b
    extends AsyncTask<Void, Void, Integer>
  {
    public final int RESULT_ERROR = 1;
    public final int RESULT_SUCCESS = 0;
    NewFlowCameraActivity.c a;
    boolean aGY;
    byte[] cD;
    WeakReference<Activity> mActivity;
    String mFileDir;
    String mFileMd5;
    int mOrientation;
    Handler mUiHandler;
    String mVideoPath;
    
    public b(Activity paramActivity, Handler paramHandler, NewFlowCameraActivity.c paramc, String paramString, int paramInt, boolean paramBoolean)
    {
      this.mActivity = new WeakReference(paramActivity);
      this.mUiHandler = paramHandler;
      this.a = paramc;
      this.mFileDir = paramString;
      this.mOrientation = paramInt;
      this.aGY = paramBoolean;
    }
    
    /* Error */
    protected Integer a(Void... paramVarArgs)
    {
      // Byte code:
      //   0: invokestatic 64	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
      //   3: astore_1
      //   4: invokestatic 70	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
      //   7: ifeq +448 -> 455
      //   10: ldc 72
      //   12: iconst_0
      //   13: invokestatic 78	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
      //   16: new 80	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask$1
      //   19: dup
      //   20: aload_0
      //   21: aload_1
      //   22: invokespecial 83	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask$1:<init>	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
      //   25: invokevirtual 89	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
      //   28: invokestatic 70	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
      //   31: ifeq +202 -> 233
      //   34: lconst_0
      //   35: lstore 7
      //   37: aload_1
      //   38: getfield 93	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   41: astore 10
      //   43: aload 10
      //   45: monitorenter
      //   46: aload_1
      //   47: getfield 93	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   50: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   53: istore 9
      //   55: lload 7
      //   57: lstore 5
      //   59: iload 9
      //   61: ifne +101 -> 162
      //   64: lload 7
      //   66: lstore_3
      //   67: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   70: ifeq +14 -> 84
      //   73: lload 7
      //   75: lstore_3
      //   76: ldc 105
      //   78: iconst_2
      //   79: ldc 107
      //   81: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   84: lload 7
      //   86: lstore_3
      //   87: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
      //   90: lstore 5
      //   92: lload 7
      //   94: lstore_3
      //   95: aload_1
      //   96: getfield 93	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   99: ldc2_w 118
      //   102: invokevirtual 125	java/lang/Object:wait	(J)V
      //   105: lload 7
      //   107: lstore_3
      //   108: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
      //   111: lload 5
      //   113: lsub
      //   114: lstore 7
      //   116: lload 7
      //   118: lstore 5
      //   120: lload 7
      //   122: lstore_3
      //   123: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   126: ifeq +36 -> 162
      //   129: lload 7
      //   131: lstore_3
      //   132: ldc 105
      //   134: iconst_2
      //   135: new 127	java/lang/StringBuilder
      //   138: dup
      //   139: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   142: ldc 130
      //   144: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: lload 7
      //   149: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   152: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   155: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   158: lload 7
      //   160: lstore 5
      //   162: aload 10
      //   164: monitorexit
      //   165: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   168: ifeq +11 -> 179
      //   171: ldc 105
      //   173: iconst_2
      //   174: ldc 143
      //   176: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   179: lload 5
      //   181: ldc2_w 144
      //   184: lcmp
      //   185: ifge +48 -> 233
      //   188: bipush 30
      //   190: lload 5
      //   192: l2i
      //   193: isub
      //   194: istore_2
      //   195: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   198: ifeq +28 -> 226
      //   201: ldc 105
      //   203: iconst_2
      //   204: new 127	java/lang/StringBuilder
      //   207: dup
      //   208: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   211: ldc 147
      //   213: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   216: iload_2
      //   217: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   220: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   223: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   226: iload_2
      //   227: i2l
      //   228: lstore_3
      //   229: lload_3
      //   230: invokestatic 155	java/lang/Thread:sleep	(J)V
      //   233: aload_0
      //   234: getfield 43	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mActivity	Ljava/lang/ref/WeakReference;
      //   237: invokevirtual 158	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   240: ifnull +346 -> 586
      //   243: aload_1
      //   244: getfield 162	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:bL	D
      //   247: d2i
      //   248: putstatic 167	aniq:bQi	I
      //   251: aload_1
      //   252: getfield 170	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cjN	I
      //   255: istore_2
      //   256: iload_2
      //   257: ifgt +304 -> 561
      //   260: aload_1
      //   261: getfield 173	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
      //   264: invokevirtual 179	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getFrameIndex	()I
      //   267: putstatic 182	aniq:dHk	I
      //   270: iconst_0
      //   271: putstatic 185	aniq:dFO	I
      //   274: iconst_0
      //   275: putstatic 188	aniq:dHo	I
      //   278: new 190	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
      //   281: dup
      //   282: aconst_null
      //   283: aload_0
      //   284: getfield 45	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mUiHandler	Landroid/os/Handler;
      //   287: aload_0
      //   288: getfield 49	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mFileDir	Ljava/lang/String;
      //   291: aconst_null
      //   292: aconst_null
      //   293: invokespecial 193	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   296: astore_1
      //   297: aload_1
      //   298: iconst_1
      //   299: invokevirtual 197	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PW	(Z)V
      //   302: aload_1
      //   303: iconst_1
      //   304: invokevirtual 200	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:CN	(Z)V
      //   307: aload_0
      //   308: getfield 53	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:aGY	Z
      //   311: ifeq +257 -> 568
      //   314: aload_1
      //   315: iconst_1
      //   316: invokevirtual 203	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PY	(Z)V
      //   319: aload_1
      //   320: iconst_1
      //   321: invokevirtual 206	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PZ	(Z)V
      //   324: aload_1
      //   325: aload_0
      //   326: getfield 51	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mOrientation	I
      //   329: invokevirtual 210	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:UY	(I)V
      //   332: aload_1
      //   333: invokevirtual 213	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
      //   336: aload_0
      //   337: aload_1
      //   338: getfield 216	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:cdZ	Ljava/lang/String;
      //   341: putfield 218	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mVideoPath	Ljava/lang/String;
      //   344: aload_0
      //   345: getfield 218	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mVideoPath	Ljava/lang/String;
      //   348: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   351: ifne +56 -> 407
      //   354: new 226	java/io/File
      //   357: dup
      //   358: aload_0
      //   359: getfield 218	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mVideoPath	Ljava/lang/String;
      //   362: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
      //   365: astore 10
      //   367: aload 10
      //   369: invokevirtual 232	java/io/File:exists	()Z
      //   372: ifeq +35 -> 407
      //   375: new 127	java/lang/StringBuilder
      //   378: dup
      //   379: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   382: aload 10
      //   384: invokevirtual 235	java/io/File:getParent	()Ljava/lang/String;
      //   387: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   390: getstatic 238	java/io/File:separator	Ljava/lang/String;
      //   393: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   396: ldc 240
      //   398: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   401: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   404: invokestatic 245	aqhq:UD	(Ljava/lang/String;)V
      //   407: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   410: ifeq +31 -> 441
      //   413: ldc 105
      //   415: iconst_2
      //   416: new 127	java/lang/StringBuilder
      //   419: dup
      //   420: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   423: ldc 247
      //   425: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   428: aload_0
      //   429: getfield 218	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$b:mVideoPath	Ljava/lang/String;
      //   432: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   435: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   438: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   441: aload_1
      //   442: getfield 250	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:errorCode	I
      //   445: ifne +136 -> 581
      //   448: iconst_0
      //   449: istore_2
      //   450: iload_2
      //   451: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   454: areturn
      //   455: invokestatic 261	aniu:a	()Laniu;
      //   458: invokevirtual 264	aniu:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
      //   461: invokevirtual 269	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
      //   464: pop
      //   465: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   468: ifeq -440 -> 28
      //   471: ldc 105
      //   473: iconst_2
      //   474: ldc_w 271
      //   477: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   480: goto -452 -> 28
      //   483: astore 10
      //   485: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   488: ifeq +12 -> 500
      //   491: ldc 105
      //   493: iconst_2
      //   494: ldc_w 273
      //   497: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   500: aload 10
      //   502: invokevirtual 276	java/lang/UnsatisfiedLinkError:printStackTrace	()V
      //   505: goto -477 -> 28
      //   508: astore 11
      //   510: lload_3
      //   511: lstore 5
      //   513: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   516: ifeq -354 -> 162
      //   519: ldc 105
      //   521: iconst_2
      //   522: new 127	java/lang/StringBuilder
      //   525: dup
      //   526: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   529: ldc_w 278
      //   532: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   535: aload 11
      //   537: invokevirtual 281	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   540: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   543: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   546: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   549: lload_3
      //   550: lstore 5
      //   552: goto -390 -> 162
      //   555: astore_1
      //   556: aload 10
      //   558: monitorexit
      //   559: aload_1
      //   560: athrow
      //   561: iload_2
      //   562: putstatic 182	aniq:dHk	I
      //   565: goto -295 -> 270
      //   568: aload_1
      //   569: iconst_0
      //   570: invokevirtual 203	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PY	(Z)V
      //   573: aload_1
      //   574: iconst_1
      //   575: invokevirtual 284	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PX	(Z)V
      //   578: goto -246 -> 332
      //   581: iconst_1
      //   582: istore_2
      //   583: goto -133 -> 450
      //   586: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   589: ifeq +12 -> 601
      //   592: ldc 105
      //   594: iconst_2
      //   595: ldc_w 286
      //   598: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   601: iconst_1
      //   602: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   605: areturn
      //   606: astore 10
      //   608: goto -375 -> 233
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	611	0	this	b
      //   0	611	1	paramVarArgs	Void[]
      //   194	389	2	i	int
      //   66	484	3	l1	long
      //   57	494	5	l2	long
      //   35	124	7	l3	long
      //   53	7	9	bool	boolean
      //   41	342	10	localObject	Object
      //   483	74	10	localUnsatisfiedLinkError	UnsatisfiedLinkError
      //   606	1	10	localInterruptedException1	java.lang.InterruptedException
      //   508	28	11	localInterruptedException2	java.lang.InterruptedException
      // Exception table:
      //   from	to	target	type
      //   455	480	483	java/lang/UnsatisfiedLinkError
      //   67	73	508	java/lang/InterruptedException
      //   76	84	508	java/lang/InterruptedException
      //   87	92	508	java/lang/InterruptedException
      //   95	105	508	java/lang/InterruptedException
      //   108	116	508	java/lang/InterruptedException
      //   123	129	508	java/lang/InterruptedException
      //   132	158	508	java/lang/InterruptedException
      //   46	55	555	finally
      //   67	73	555	finally
      //   76	84	555	finally
      //   87	92	555	finally
      //   95	105	555	finally
      //   108	116	555	finally
      //   123	129	555	finally
      //   132	158	555	finally
      //   162	165	555	finally
      //   513	549	555	finally
      //   556	559	555	finally
      //   229	233	606	java/lang/InterruptedException
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "generate video result= " + paramInteger);
      }
      if (this.mActivity.get() == null) {
        return;
      }
      switch (paramInteger.intValue())
      {
      default: 
        this.a.a(false, null, null, null);
        return;
      }
      this.a.a(true, this.mVideoPath, this.cD, this.mFileMd5);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity
 * JD-Core Version:    0.7.0.1
 */