package com.tencent.mobileqq.ar.view;

import acfp;
import adaq;
import adau;
import aday;
import adbn;
import adcl;
import adco;
import adda;
import addd;
import adec;
import aded;
import adfd;
import adhf;
import adhf.a;
import adib;
import adie;
import adig;
import adim;
import adin.a;
import adin.e;
import adix;
import adkt;
import adkt.a;
import adku;
import adkw;
import adkw.a;
import adkw.b;
import adkx;
import adky;
import adld;
import adle;
import adlf;
import adlh;
import adli;
import adlj;
import adlk;
import adll;
import adlm;
import adln;
import adlo;
import adlp;
import adlq;
import adlr;
import adls;
import admh;
import adub;
import aduc;
import akqe;
import akqe.c;
import akqu;
import akqu.a;
import akqx;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import anpc;
import aqha;
import aqju;
import aqmr;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.DrawView2.a;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import ssr;
import wja;

public class ARScanEntryView
  extends ScanEntryProviderView
  implements adib, adkt.a, akqu.a, Handler.Callback, View.OnClickListener
{
  public TextView QF;
  public TextView QG;
  TextView QH;
  private TextView QI;
  private TextView QJ;
  private FrameLayout U;
  private long UU;
  long UY = -1L;
  private aday jdField_a_of_type_Aday;
  private adco jdField_a_of_type_Adco;
  private adec jdField_a_of_type_Adec;
  private adub jdField_a_of_type_Adub = new adlq(this);
  private akqu jdField_a_of_type_Akqu;
  public ObjectSurfaceView a;
  public ScanningSurfaceView a;
  public ScanSuccessView a;
  private ScanIconAnimateView jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView;
  private Bundle aA;
  private aqju aj;
  adfd jdField_b_of_type_Adfd;
  private adku jdField_b_of_type_Adku;
  private adkw.a jdField_b_of_type_Adkw$a = new adlr(this);
  private adkw.b jdField_b_of_type_Adkw$b = new adls(this);
  private akqe jdField_b_of_type_Akqe;
  private Rect bE;
  private boolean bOQ;
  public boolean bOR;
  boolean bOS = true;
  private boolean bOT;
  boolean bOU = false;
  boolean bOV = false;
  private boolean bOW;
  private boolean bOX;
  boolean bOY = false;
  boolean bOZ = false;
  private boolean bPa;
  private boolean bPb;
  private boolean bPc;
  private boolean bPd;
  private boolean bPe;
  private boolean bPf;
  private boolean bPg;
  volatile boolean bPh = false;
  private volatile boolean bPi = true;
  private boolean bPj;
  private boolean bPk;
  private boolean bPl = true;
  private boolean bPm;
  private boolean bPn;
  private boolean bPo;
  private boolean bPp;
  private boolean bPq;
  private boolean bPr;
  private boolean bPs;
  private boolean bPt;
  boolean bPu;
  public boolean bPv;
  private boolean bPw;
  private boolean bPx;
  private String bsp;
  private String buz;
  public FrameLayout bv;
  adbn jdField_c_of_type_Adbn;
  private MessageQueue.IdleHandler jdField_c_of_type_AndroidOsMessageQueue$IdleHandler = new adle(this);
  private TouchWebView jdField_c_of_type_ComTencentBizUiTouchWebView;
  private volatile ARCommonConfigInfo jdField_c_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private MapView jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView;
  private MqqHandler jdField_c_of_type_MqqOsMqqHandler;
  public int cIF = -1;
  private int cIG;
  private int cIH;
  private ViewGroup dV;
  private Runnable fY;
  private Runnable fZ;
  public TextView gq;
  public String hL;
  public LinearLayout ip;
  volatile boolean isPause = false;
  private View.OnTouchListener j = new adlf(this);
  private RelativeLayout jF;
  private RelativeLayout jG;
  private HashMap<String, Integer> jw = new HashMap();
  public RelativeLayout mRoot;
  private long mStartTime = -1L;
  private TextView mTitle;
  private Handler mUiHandler;
  int resultCode;
  private ImageView yh;
  private SimpleDateFormat z;
  
  public ARScanEntryView(Context paramContext, admh paramadmh)
  {
    super(paramContext, paramadmh);
  }
  
  private void FX(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.bPt == paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "edge show equal so refuse");
      }
      return;
    }
    this.bPt = paramBoolean;
    if (this.jdField_a_of_type_Admh.b() != null)
    {
      this.jdField_a_of_type_Admh.b().a(paramBoolean, 0.0F, 1.0F);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge do real call flag=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
    }
    this.mUiHandler.post(new ARScanEntryView.9(this, paramBoolean));
    this.jdField_a_of_type_Admh.GA(paramBoolean);
    GB(paramBoolean);
  }
  
  private void Gt(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mUiHandler.post(new ARScanEntryView.10(this));
      return;
    }
    this.mUiHandler.post(new ARScanEntryView.11(this));
  }
  
  private void Gu(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Adec == null) || (this.jdField_a_of_type_Adec.b == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Adec.b.a != null) {
        this.hL = this.jdField_a_of_type_Adec.b.a.but;
      }
      if (this.bPs)
      {
        this.bPs = false;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ip.getLayoutParams();
        localLayoutParams.bottomMargin = wja.dp2px(170.0F, getResources());
        localLayoutParams.addRule(13, 0);
      }
    } while (!paramBoolean);
    this.mAppInterface.reportClickEvent("CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), "", "");
  }
  
  private void Gx(String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch preLaunchToQQBrowseActivity ");
    paramString = jR(paramString);
    b();
    if (this.jdField_c_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.onResume();
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
    }
  }
  
  private MapView a()
  {
    if (this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView == null)
    {
      this.bPv = false;
      this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView = new MapView(this.mContext);
      if (this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings() != null)
      {
        this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setLogoPosition(0);
        this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setScaleViewEnabled(false);
        this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getUiSettings().setScrollGesturesEnabled(false);
      }
      TencentMap localTencentMap = this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap();
      localTencentMap.setOnCameraChangeListener(new adlm(this));
      localTencentMap.setOnMapLoadedCallback(new adln(this));
      this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.setEnabled(true);
      this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView.setClickable(true);
    }
    return this.jdField_c_of_type_ComTencentTencentmapMapsdkMapsMapView;
  }
  
  private void a(ARCommonConfigInfo paramARCommonConfigInfo, long paramLong)
  {
    if ((paramARCommonConfigInfo.recognitions != null) && (paramARCommonConfigInfo.recognitions.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramLong != 0L)
      {
        Object localObject = paramARCommonConfigInfo.recognitions.iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          ARRecognition localARRecognition = (ARRecognition)((Iterator)localObject).next();
          int k = i;
          if (localARRecognition.type == 12L) {
            k = 1;
          }
          i = k;
          if ((1 << (int)localARRecognition.type & paramLong) != 0L)
          {
            localArrayList.add(localARRecognition);
            i = k;
          }
        }
        if ((i == 0) && ((0x1000 & paramLong) != 0L))
        {
          localObject = new ARRecognition();
          ((ARRecognition)localObject).type = 12L;
          ((ARRecognition)localObject).cCe = 1;
          ((ARRecognition)localObject).cCf = 1;
          ((ARRecognition)localObject).priority = 4;
          ((ARRecognition)localObject).cCg = 1;
        }
        paramARCommonConfigInfo.recognitions = localArrayList;
      }
    }
  }
  
  private boolean afd()
  {
    return !this.aA.getBoolean("NoLimitParams", true);
  }
  
  private boolean afe()
  {
    if (this.jdField_a_of_type_Admh.b() != null) {
      return this.jdField_a_of_type_Admh.b().afc();
    }
    return true;
  }
  
  /* Error */
  private boolean afh()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 319	com/tencent/mobileqq/ar/view/ARScanEntryView:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokestatic 546	aduc:b	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   7: astore 4
    //   9: aload 4
    //   11: ldc_w 548
    //   14: iconst_0
    //   15: invokeinterface 551 3 0
    //   20: istore_1
    //   21: aload_0
    //   22: invokespecial 554	com/tencent/mobileqq/ar/view/ARScanEntryView:afi	()Z
    //   25: ifne +49 -> 74
    //   28: aload_0
    //   29: getfield 319	com/tencent/mobileqq/ar/view/ARScanEntryView:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   32: iconst_2
    //   33: invokevirtual 558	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   36: checkcast 560	adua
    //   39: astore 5
    //   41: aload 4
    //   43: ldc_w 562
    //   46: lconst_0
    //   47: invokeinterface 566 4 0
    //   52: lstore_2
    //   53: aload 5
    //   55: ifnull +19 -> 74
    //   58: aload 5
    //   60: aload_0
    //   61: getfield 319	com/tencent/mobileqq/ar/view/ARScanEntryView:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   64: invokevirtual 333	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   67: invokestatic 572	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lload_2
    //   71: invokevirtual 576	adua:al	(JJ)V
    //   74: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +29 -> 106
    //   80: ldc 200
    //   82: iconst_2
    //   83: new 578	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 581
    //   93: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_1
    //   97: invokevirtual 588	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   100: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: iload_1
    //   107: ireturn
    //   108: astore 4
    //   110: aload 4
    //   112: invokevirtual 594	java/lang/Exception:printStackTrace	()V
    //   115: ldc 200
    //   117: iconst_1
    //   118: ldc_w 596
    //   121: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iload_1
    //   125: ireturn
    //   126: astore 4
    //   128: goto -54 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ARScanEntryView
    //   20	105	1	bool	boolean
    //   52	19	2	l	long
    //   7	35	4	localSharedPreferences	SharedPreferences
    //   108	3	4	localException	Exception
    //   126	1	4	localNumberFormatException	java.lang.NumberFormatException
    //   39	20	5	localadua	adua
    // Exception table:
    //   from	to	target	type
    //   28	41	108	java/lang/Exception
    //   58	74	126	java/lang/NumberFormatException
  }
  
  private boolean afi()
  {
    boolean bool2 = false;
    String str1 = aduc.b(this.mAppInterface).getString("key_click_reddot_date", null);
    String str2 = bn(NetConnInfoCenter.getServerTimeMillis());
    boolean bool1 = bool2;
    if (str1 != null)
    {
      bool1 = bool2;
      if (str1.equals(str2)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "hasClickedRedDotToday  result = " + bool1 + ",curDate = " + str2 + ",clickDate = " + str1);
    }
    return bool1;
  }
  
  private TouchWebView b()
  {
    if (this.jdField_c_of_type_ComTencentBizUiTouchWebView == null) {
      cSU();
    }
    return this.jdField_c_of_type_ComTencentBizUiTouchWebView;
  }
  
  private void b(adhf.a parama, ArLBSActivity paramArLBSActivity)
  {
    if (this.jdField_a_of_type_Aday == null)
    {
      this.jdField_a_of_type_Aday = new aday((Activity)this.mContext, a(), this);
      this.jdField_a_of_type_Aday.setOnDismissListener(new adll(this));
    }
    this.jdField_a_of_type_Aday.cPD();
    this.jdField_a_of_type_Aday.a(parama, paramArLBSActivity);
  }
  
  private String bn(long paramLong)
  {
    Object localObject = null;
    if (this.z == null)
    {
      this.z = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      this.z.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      String str = this.z.format(Long.valueOf(paramLong));
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AREngine_ARScanEntryView", 2, "getCurrentDateString exception", localException);
    }
    return localObject;
    return null;
  }
  
  private void c(adhf paramadhf, ArLBSActivity paramArLBSActivity)
  {
    if (paramArLBSActivity == null) {
      new ArLBSActivity();
    }
    do
    {
      return;
      if (paramadhf.retCode == 0)
      {
        if (paramadhf.b == null)
        {
          QQToast.a(this.mContext, paramArLBSActivity.buj, 1).show();
          return;
        }
        this.jdField_b_of_type_Adku.pause();
        FX(false);
        b(paramadhf.b, paramArLBSActivity);
        return;
      }
      if (paramadhf.retCode == 2)
      {
        this.jdField_b_of_type_Adku.resume();
        FX(false);
        if (this.aj == null) {
          this.aj = aqha.a(this.mContext, 230, paramArLBSActivity.buk, paramArLBSActivity.bul, acfp.m(2131702877), acfp.m(2131702869), new adli(this), new adlj(this));
        }
        this.aj.setOnDismissListener(new adlk(this));
        this.aj.show();
        return;
      }
    } while (paramadhf.retCode != -1);
  }
  
  private void c(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "doWhenGetARConfig ");
    if (this.jdField_c_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      return;
    }
    if ((paramARCommonConfigInfo != null) && (paramARCommonConfigInfo.arControllers != null))
    {
      Iterator localIterator = paramARCommonConfigInfo.arControllers.iterator();
      while (localIterator.hasNext())
      {
        ARScanAR localARScanAR = (ARScanAR)localIterator.next();
        if ((localARScanAR != null) && (localARScanAR.cDS == 1))
        {
          this.bsp = localARScanAR.bsp;
          this.buz = localARScanAR.scanLine1;
        }
      }
    }
    if (!this.bPn)
    {
      this.mUiHandler.removeMessages(325);
      this.mUiHandler.sendEmptyMessage(325);
    }
    this.jdField_c_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    if (!this.aA.getBoolean("NoLimitParams", true)) {
      a(this.jdField_c_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, this.aA.getLong("recognitionMask", 0L));
    }
    paramARCommonConfigInfo = this.jdField_a_of_type_Admh.a();
    ThreadManager.postImmediately(new ARScanEntryView.7(this, this.UU, paramARCommonConfigInfo), null, false);
  }
  
  private void cSJ()
  {
    if ((!this.bPb) || (this.bPw)) {}
    while (!this.bPd) {
      return;
    }
    Gy("updateDownloadProgress");
  }
  
  private void cSO()
  {
    if (!adku.aeX())
    {
      QLog.d("AREngine_ARScanEntryView", 1, "ARScanEntryView onCreate error happen");
      return;
    }
    adku localadku = adku.a();
    this.jdField_b_of_type_Adku = localadku;
    this.jdField_a_of_type_Adkl = localadku;
    this.jdField_b_of_type_Adku.a(this.mContext, this.mAppInterface);
  }
  
  private void cSP()
  {
    if (this.bPa) {
      return;
    }
    Activity localActivity = (Activity)this.mContext;
    ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = adau.a(localActivity).a();
    for (;;)
    {
      try
      {
        if ((this.jdField_b_of_type_Adku != null) && (this.jdField_b_of_type_Adku.isInited()))
        {
          long l = System.currentTimeMillis();
          i = this.jdField_b_of_type_Adku.a(false, this.bPl, this.bPn, false, this.jdField_c_of_type_ComTencentMobileqqArAidlARCommonConfigInfo, null, localARScanStarFaceConfigInfo, this, localActivity, this.jdField_c_of_type_Adbn, this.jdField_a_of_type_Admh.b());
          adix.a().aF(System.currentTimeMillis() - l, i);
          if ((i != 0) || (!this.jdField_b_of_type_Adku.aeO())) {
            continue;
          }
          cTi();
        }
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("AREngine_ARScanEntryView", 1, "initAr fail.", localException);
        continue;
      }
      this.bPa = true;
      return;
      QLog.e("AREngine_ARScanEntryView", 1, String.format("initAr fail. result=%s", new Object[] { Integer.valueOf(i) }));
    }
  }
  
  private void cSQ()
  {
    if (this.jdField_a_of_type_Akqu != null)
    {
      this.jdField_a_of_type_Akqu.t(null);
      this.jdField_a_of_type_Akqu = null;
    }
  }
  
  private void cST()
  {
    if (this.bPr) {}
    long l;
    do
    {
      return;
      this.bPr = true;
      l = System.currentTimeMillis();
      ViewStub localViewStub = (ViewStub)findViewById(2131362901);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView = ((ScanningSurfaceView)super.findViewById(2131377683));
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setVisibility(8);
        this.jdField_b_of_type_Adfd = new adfd(this.mContext, this.jdField_b_of_type_Akqe);
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.jdField_b_of_type_Adfd = this.jdField_b_of_type_Adfd;
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView = ((ObjectSurfaceView)super.findViewById(2131372583));
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setVisibility(8);
        this.jdField_b_of_type_Adfd = new adfd(this.mContext, this.jdField_b_of_type_Akqe);
        this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.jdField_b_of_type_Adfd = this.jdField_b_of_type_Adfd;
        this.ip = ((LinearLayout)super.findViewById(2131382311));
        this.gq = ((TextView)super.findViewById(2131379502));
        this.QF = ((TextView)super.findViewById(2131379503));
        this.QG = ((TextView)super.findViewById(2131379504));
        this.QG.setOnClickListener(this);
        this.bv = ((FrameLayout)super.findViewById(2131380118));
        this.bv.setClickable(true);
        this.bv.setOnClickListener(this);
        cSX();
        cSZ();
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          int i = ImmersiveUtils.getStatusBarHeight(this.mContext);
          this.bv.setPadding(0, i, 0, 0);
        }
        cSV();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitARView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
  }
  
  private void cSU()
  {
    if (this.jdField_c_of_type_ComTencentBizUiTouchWebView == null)
    {
      long l = System.currentTimeMillis();
      this.jdField_c_of_type_ComTencentBizUiTouchWebView = ((ScanTorchActivity)this.mContext).b(null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(null);
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.setBackgroundResource(0);
      Drawable localDrawable = this.jdField_c_of_type_ComTencentBizUiTouchWebView.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(0);
      }
      this.U.setVisibility(0);
      this.U.addView(this.jdField_c_of_type_ComTencentBizUiTouchWebView, localLayoutParams);
      adix.a().iJ(System.currentTimeMillis() - l);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitWebView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
    }
  }
  
  private void cSV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("showViewFinder mHasViewFinderShow=%s isPause=%s", new Object[] { Boolean.valueOf(this.bOS), Boolean.valueOf(this.mIsPaused) }));
    }
    if ((this.bOS) || (this.mIsPaused)) {}
    for (;;)
    {
      return;
      this.bOS = true;
      if (this.QJ != null) {
        this.QJ.setVisibility(0);
      }
      while (this.ip != null)
      {
        int i = wja.dp2px(15.0F, getResources());
        this.ip.setBackgroundResource(2131167595);
        this.ip.setPadding(i, i, i, 0);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ip.getLayoutParams();
        localLayoutParams.bottomMargin = wja.dp2px(170.0F, getResources());
        if (this.bPs)
        {
          this.bPs = false;
          localLayoutParams.addRule(13, 0);
        }
        this.ip.setLayoutParams(localLayoutParams);
        cSX();
        return;
        if (this.QJ != null) {
          this.QJ.setVisibility(8);
        }
      }
    }
  }
  
  private void cSW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "hideViewFinder");
    }
    if (this.ip == null) {
      return;
    }
    this.ip.setBackgroundResource(2130846554);
    int i = wja.dp2px(15.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ip.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(170.0F, getResources());
    this.ip.setPadding(i, i, i, wja.dp2px(7.0F, getResources()));
    if (this.bPs)
    {
      this.bPs = false;
      localLayoutParams.addRule(13, 0);
    }
    if (this.QJ != null) {
      this.QJ.setVisibility(8);
    }
    this.bOS = false;
  }
  
  private void cSX()
  {
    if (this.gq == null) {
      return;
    }
    this.gq.setVisibility(8);
    this.QF.setVisibility(8);
    this.QG.setVisibility(8);
    this.hL = null;
    this.ip.setVisibility(8);
  }
  
  private void cSY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTouchView");
    }
    this.ip.setVisibility(8);
    this.bv.setVisibility(0);
    if ((this.jdField_a_of_type_Adec != null) && (this.jdField_a_of_type_Adec.b != null)) {
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void cSZ()
  {
    if (this.bv == null) {
      return;
    }
    this.bv.setVisibility(8);
  }
  
  private void cTa()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "handleARStartFail");
    this.bOQ = true;
    if (this.fY == null) {
      showErrorTips(acfp.m(2131702872));
    }
  }
  
  private void cTb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("checkArDependenceReady time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.mStartTime) }));
    }
    boolean bool1 = adaq.a().adl();
    boolean bool2 = adaq.a().adm();
    QLog.i("AREngine_ARScanEntryView", 1, "checkArDependenceReady. isAREnable = " + bool1 + ", isSupportAr = " + bool2 + ", mIsArSoReady = " + false + ", mIsVideoPluginReady = " + false);
    adkw localadkw = this.jdField_a_of_type_Admh.a();
    Activity localActivity = (Activity)this.mContext;
    if ((bool1) && (bool2) && (localadkw.iN(2)) && (localadkw.iN(8)) && (!this.bPa))
    {
      if ((this.jdField_b_of_type_Adku != null) && (this.jdField_b_of_type_Adku.isInited()))
      {
        if (!this.jdField_b_of_type_Adku.aeO()) {
          cSP();
        }
        if ((this.uA) && (this.jdField_b_of_type_Adku.aeO()) && (this.jdField_b_of_type_Adku.isInited()) && (this.jdField_b_of_type_Adku.qe() == 1)) {
          this.jdField_b_of_type_Adku.resume();
        }
      }
      if (this.jdField_a_of_type_Admh.c() != null) {
        if (this.jdField_a_of_type_Admh.c().isEnableVideoRecord != 1L) {
          break label338;
        }
      }
    }
    label338:
    for (bool1 = true;; bool1 = false)
    {
      adcl.a().FW(bool1);
      QLog.d("AREngine_ARScanEntryView", 1, String.format("checkARVideoRecordEnable enable=%s", new Object[] { Boolean.valueOf(bool1) }));
      if ((!this.bPr) && (!this.mUiHandler.hasMessages(321)))
      {
        this.mUiHandler.sendEmptyMessageDelayed(321, 100L);
        QLog.d("AREngine_ARScanEntryView", 1, "checkArDependenceReady do delay initARView");
      }
      return;
    }
  }
  
  private void cTc()
  {
    if (this.fZ == null)
    {
      this.fZ = new ARScanEntryView.37(this);
      QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck");
    }
    this.bPw = false;
    this.mUiHandler.removeCallbacks(this.fZ);
    this.mUiHandler.postDelayed(this.fZ, 10000L);
  }
  
  private void cTd()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "stopDownloadTimeoutCheck");
    if (this.fZ != null)
    {
      this.mUiHandler.removeCallbacks(this.fZ);
      this.fZ = null;
    }
  }
  
  private void cTe()
  {
    long l2 = 8000L;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.bPx) }));
    }
    if (this.bPx) {}
    while (this.mUiHandler == null) {
      return;
    }
    if (this.fY == null) {
      this.fY = new ARScanEntryView.38(this);
    }
    long l1 = l2;
    if (this.jdField_a_of_type_Admh.c() != null)
    {
      l1 = this.jdField_a_of_type_Admh.c().mARNoResultCheckTime;
      if (l1 > 0L) {
        break label126;
      }
      l1 = l2;
    }
    label126:
    for (;;)
    {
      this.mUiHandler.postDelayed(this.fY, l1);
      return;
    }
  }
  
  private void cTf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "removeTimeoutCheck");
    }
    this.bPx = true;
    this.bPd = false;
    if ((this.mUiHandler != null) && (this.fY != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "do removeTimeoutCheck");
      }
      this.mUiHandler.removeCallbacks(this.fY);
      this.fY = null;
    }
  }
  
  private void cTg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "doAfterAREngineReady = ");
    }
    if (this.jdField_c_of_type_Adbn != null) {
      this.jdField_c_of_type_Adbn.a(this.jdField_b_of_type_Adku);
    }
    akqx localakqx = this.jdField_a_of_type_Admh.a();
    if (localakqx != null) {
      localakqx.w(this.mAppInterface);
    }
    this.bPj = true;
  }
  
  private void cTh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "doHideNonPromotionUI = ");
    }
    this.jF.setVisibility(8);
    this.QH.setVisibility(8);
  }
  
  private void cTi()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "checkReadyToStartARSession = " + this.uA);
    if ((this.jdField_b_of_type_Adku != null) && (this.jdField_b_of_type_Adku.aeO()) && (this.uA)) {
      this.jdField_b_of_type_Adku.start();
    }
  }
  
  private void cTj() {}
  
  private void cTk()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + adkt.a().aeN() + ";mIsResumed=" + this.uA);
    if ((adkt.a().aeN()) && (this.uA)) {
      adkt.a().ho(adky.screenWidth, adky.screenHeight);
    }
  }
  
  private void cTl()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "stopAutoFoucus ");
    adkt.a().cRB();
  }
  
  private void initData()
  {
    Activity localActivity = (Activity)this.mContext;
    adcl.a().bv(localActivity);
    adcl.a().setActivityContext(localActivity);
    adcl.a().bf(this.jdField_a_of_type_Adco);
  }
  
  private void initView()
  {
    long l = System.currentTimeMillis();
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.dV = ((ViewGroup)findViewById(2131379791));
    adld.l(this.mContext, this.dV);
    this.QI = ((TextView)findViewById(2131379793));
    this.mTitle = ((TextView)findViewById(2131379795));
    Object localObject = this.aA.getString("Title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.mTitle.setText((CharSequence)localObject);
    }
    this.QI.setOnClickListener(this);
    this.QI.setContentDescription(acfp.m(2131702871));
    this.QH = ((TextView)findViewById(2131362911));
    this.U = ((FrameLayout)findViewById(2131382169));
    this.jF = ((RelativeLayout)findViewById(2131365421));
    this.jF.setOnTouchListener(this.j);
    this.jF.setOnClickListener(this);
    this.jF.setContentDescription(acfp.m(2131702873));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = ((ScanIconAnimateView)findViewById(2131365425));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.setPopUpListener(new adlp(this));
    this.yh = ((ImageView)findViewById(2131367101));
    localObject = (ViewStub)findViewById(2131362908);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      this.jdField_a_of_type_Adco = new adco(findViewById(2131362934));
    }
    this.jG = ((RelativeLayout)findViewById(2131362904));
    if (this.jdField_c_of_type_Adbn == null)
    {
      this.jdField_c_of_type_Adbn = new adbn();
      localObject = (ScanTorchActivity)this.mContext;
      this.jdField_c_of_type_Adbn.a(this.mAppInterface, (ScanTorchActivity)localObject, this.jG);
      this.jdField_c_of_type_Adbn.b = this;
    }
    if (this.bPn) {
      cTh();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("initView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  private String jR(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("&_wv=");
    paramString.append(Integer.toString(17367040));
    return paramString.toString();
  }
  
  public void Gi(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onEnginePause resetFaceUI = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.bPh = false;
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.clear();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.cRy();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.28(this));
      this.mUiHandler.post(new ARScanEntryView.29(this));
    }
  }
  
  public void Gj(boolean paramBoolean) {}
  
  public void Gs(boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "doAfterProviderViewClose isPromotionPage =  " + afd() + "mHasReachEntryReady:" + this.bPj);
    if ((afd()) || (paramBoolean) || (!this.bPj)) {
      onDestroy();
    }
  }
  
  public void Gv(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTransferDoorGuideImage show = " + paramBoolean);
    }
    if (a(true) == null) {
      return;
    }
    this.jdField_a_of_type_Akqu.Nb(paramBoolean);
  }
  
  public void Gw(boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("updateDownloadStatus, from[");
    if (!paramBoolean)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append("]!mAfterDependenceTimeout=");
      if (this.bPb) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AREngine_ARScanEntryView", 1, bool + ";mIsDownloadTimeout=" + this.bPw);
      if (((this.bPb) || (paramBoolean)) && (!this.bPw)) {
        break label101;
      }
      return;
      bool = false;
      break;
    }
    label101:
    localObject = this.jdField_a_of_type_Admh.a();
    akqx localakqx = this.jdField_a_of_type_Admh.a();
    if ((this.bPn) && (localakqx != null)) {}
    for (bool = localakqx.l(this.mAppInterface);; bool = true)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 2222, " + ((adkw)localObject).aeY() + ";" + bool);
      if ((((adkw)localObject).aeY()) && (bool))
      {
        if ((!this.bPc) && (!this.bPd) && (!paramBoolean)) {
          break;
        }
        hideTips();
        this.bPc = false;
        this.bPd = false;
        cTd();
        return;
      }
      int i;
      if (this.bPn) {
        if ((localakqx != null) && (!localakqx.isDownloading()) && (!((adkw)localObject).aeZ())) {
          i = 1;
        }
      }
      for (;;)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 333, " + ((adkw)localObject).aeZ());
        if (i == 0) {
          break label406;
        }
        a("AR组件加载失败", acfp.m(2131702876), new adlo(this, (adkw)localObject, localakqx));
        this.bPe = true;
        this.bPc = true;
        cTd();
        if (this.bPf) {
          break;
        }
        this.bPf = true;
        anot.a(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
        return;
        i = 0;
        continue;
        if (!((adkw)localObject).aeZ()) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label406:
      Gy("updateDownloadStatus");
      this.bPd = true;
      return;
    }
  }
  
  public void Gy(String paramString)
  {
    bW(paramString, false);
  }
  
  public void KU(int paramInt)
  {
    if (this.mUiHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, "onARStartComplete mUIhandler null retCode " + paramInt);
      }
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.mContext;
      if (localScanTorchActivity.aeg < 0L) {
        localScanTorchActivity.aeg = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "onArReady success + time is " + (System.currentTimeMillis() - this.mStartTime));
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "onArReady success-visiable + time is " + (System.currentTimeMillis() - localScanTorchActivity.fp()));
      }
      this.mUiHandler.sendEmptyMessage(295);
      return;
    case 7: 
      this.mUiHandler.sendEmptyMessage(309);
      return;
    }
    this.mUiHandler.sendEmptyMessage(310);
  }
  
  public void L(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_b_of_type_Akqe != null)
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showTipsWithProgress, from[" + paramString1 + "], tips[" + paramString2 + "], progress[" + paramInt + "], isVisible[" + this.jdField_b_of_type_Akqe.isVisible() + "]");
      this.jdField_b_of_type_Akqe.fu(paramString2, paramInt);
    }
  }
  
  public void Ll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "showTransferDoorGuideText textIndex = " + paramInt);
    }
    if (a(false) == null) {
      return;
    }
    this.jdField_a_of_type_Akqu.Sk(paramInt);
  }
  
  public akqu a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "getPromotionGuide create = " + paramBoolean);
    }
    if (!this.uA) {
      return null;
    }
    if ((this.jdField_a_of_type_Akqu == null) && (paramBoolean))
    {
      this.jdField_a_of_type_Akqu = new akqu((Activity)this.mContext);
      this.jdField_a_of_type_Akqu.a(this);
    }
    return this.jdField_a_of_type_Akqu;
  }
  
  public PromotionConfigInfo.a a()
  {
    return this.jdField_a_of_type_Admh.a().b();
  }
  
  public void a(int paramInt1, adec paramadec, int paramInt2)
  {
    if ((paramadec == null) || (paramadec.b == null))
    {
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, remainCount " + paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.cIF), ", newState=", paramInt1 + ", target=" + paramadec });
    }
    label220:
    int i;
    boolean bool;
    int k;
    switch (paramInt1)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.cIF = paramInt1;
        return;
        this.bOR = true;
        this.jdField_a_of_type_Adec = paramadec;
        this.mUiHandler.post(new ARScanEntryView.21(this, paramadec));
        for (paramInt2 = 100;; paramInt2 = 100)
        {
          try
          {
            switch (paramadec.b.type)
            {
            case 0: 
              anot.a(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, paramadec.b.picId, String.valueOf(paramInt2), String.valueOf(i), "");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              QLog.d("AREngine_ARScanEntryView", 1, "0X80081DF ReportController  error " + localException1.getMessage());
            }
            this.mAppInterface.reportClickEvent("CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), paramadec.b.picId, "2");
          }
          if ((paramadec.b.a == null) || (!paramadec.b.a.bOa)) {
            break;
          }
          this.mUiHandler.post(new ARScanEntryView.22(this, paramadec));
          this.mUiHandler.sendEmptyMessageDelayed(312, 100000L);
          return;
          if (paramadec.b.aeo())
          {
            paramInt2 = 3;
            break label1349;
          }
          if (!paramadec.b.aei()) {
            break label1349;
          }
          paramInt2 = 0;
          break label1349;
          if (paramadec.b.aeo())
          {
            paramInt2 = 1;
            break label1355;
          }
          if (!paramadec.b.aen()) {
            break label1355;
          }
          paramInt2 = 5;
          break label1355;
          if (paramadec.b.aei())
          {
            paramInt2 = 2;
            break label1361;
          }
          bool = paramadec.b.aeo();
          if (bool)
          {
            paramInt2 = 4;
            break label1361;
          }
          paramInt2 = 6;
          break label1361;
          i = 0;
        }
      }
    case 1: 
      this.jdField_a_of_type_Adec = paramadec;
      if (!paramadec.b.aei()) {
        this.mAppInterface.reportClickEvent("CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), paramadec.b.picId, "2");
      }
      if ((paramadec.b.type != 0) && (paramadec.b.type != 5))
      {
        k = aded.a(paramadec);
        i = k;
        if (k == 0) {
          i = 2147483647;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "AREngineCallback.AR_ANIMATION_STATE_END, remainCount is " + i + ",remainCount" + paramInt2);
        }
        if (paramInt2 == 0) {}
        for (i = 100;; i = 100)
        {
          try
          {
            switch (paramadec.b.type)
            {
            case 0: 
              label700:
              anot.a(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, paramadec.b.picId, String.valueOf(i), String.valueOf(k), "");
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + localException2.getMessage());
              continue;
              bool = false;
            }
          }
          if ((paramadec.b.businessId != 0) && ((paramadec.b.a == null) || (TextUtils.isEmpty(paramadec.b.a.but)))) {
            break label999;
          }
          bool = true;
          this.mUiHandler.post(new ARScanEntryView.23(this, paramadec, paramInt2, bool));
          this.mAppInterface.reportClickEvent("CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), paramadec.b.picId, "");
          break;
          if (paramadec.b.aeo())
          {
            i = 3;
            break label1377;
          }
          if (!paramadec.b.aei()) {
            break label1377;
          }
          i = 0;
          break label1377;
          if (paramadec.b.aeo())
          {
            i = 1;
            break label1383;
          }
          if (!paramadec.b.aen()) {
            break label1383;
          }
          i = 5;
          break label1383;
          if (paramadec.b.aei())
          {
            i = 2;
            break label1389;
          }
          bool = paramadec.b.aeo();
          if (bool)
          {
            i = 4;
            break label1389;
          }
          i = 6;
          break label1389;
          k = 0;
        }
      }
      break;
    case 2: 
      label606:
      label999:
      paramInt2 = 100;
    }
    for (;;)
    {
      try
      {
        switch (paramadec.b.type)
        {
        case 0: 
          anot.a(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramadec.b.picId, String.valueOf(paramInt2), String.valueOf(i), "");
        }
      }
      catch (Exception localException3)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + localException3.getMessage());
        continue;
      }
      this.bOR = false;
      this.jdField_a_of_type_Adec = null;
      this.mUiHandler.post(new ARScanEntryView.24(this));
      this.mAppInterface.reportClickEvent("CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), paramadec.b.picId, "");
      break;
      if (paramadec.b.aeo())
      {
        paramInt2 = 3;
      }
      else if (paramadec.b.aei())
      {
        paramInt2 = 0;
        break label1404;
        if (paramadec.b.aeo())
        {
          paramInt2 = 1;
          break label1410;
        }
        if (!paramadec.b.aen()) {
          break label1410;
        }
        paramInt2 = 5;
        break label1410;
        if (paramadec.b.aei())
        {
          paramInt2 = 2;
          break label1416;
        }
        bool = paramadec.b.aeo();
        if (bool)
        {
          paramInt2 = 4;
          break label1416;
        }
        paramInt2 = 6;
        break label1416;
        i = 0;
        paramInt2 = 100;
        continue;
        this.bOR = false;
        this.jdField_a_of_type_Adec = null;
        this.mUiHandler.post(new ARScanEntryView.25(this));
        break;
        i = 1;
        break label606;
        i = 2;
        paramInt2 = 100;
        break label220;
        label1349:
        i = 2;
        break label220;
        label1355:
        i = 1;
        break label220;
        label1361:
        i = 1;
        break label220;
        k = 2;
        i = 100;
        break label700;
        label1377:
        k = 2;
        break label700;
        label1383:
        k = 1;
        break label700;
        label1389:
        k = 1;
        break label700;
        i = 2;
        paramInt2 = 100;
        continue;
      }
      label1404:
      i = 2;
      continue;
      label1410:
      i = 1;
      continue;
      label1416:
      i = 1;
    }
  }
  
  public void a(long paramLong, int paramInt, addd paramaddd, adim paramadim)
  {
    cTf();
    if ((paramLong == 128L) && ((paramadim instanceof adin.a)))
    {
      paramadim = (adin.a)paramadim;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, " externalRenderResult info is isValidData=" + paramadim.bNB + "isNeedShowViewFinder " + paramadim.bNC);
      }
      if (!paramadim.bNB)
      {
        this.bPi = false;
        Gt(paramadim.bNC);
        this.mUiHandler.post(new ARScanEntryView.12(this));
      }
    }
    label432:
    label458:
    label634:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("MIG object RectF(协议原始的数据) ");
              if (paramadim.a == null) {
                break;
              }
              paramaddd = paramadim.a.av.toString();
              QLog.d("AREngine_MIGObjectClassifyResult", 1, paramaddd);
            }
            Gt(false);
          } while (paramadim.a == null);
          Object localObject = new DrawView2.a();
          ((DrawView2.a)localObject).confidence = 99.0F;
          ((DrawView2.a)localObject).enName = (acfp.m(2131702870) + (int)(paramadim.a.ch * 100.0D) + "%");
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, " scantorch activitity result ok " + paramadim.a.ch);
          }
          ((DrawView2.a)localObject).faceID = 10;
          ((DrawView2.a)localObject).as = DrawView2.a.a(paramadim.a.av);
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, "MIG mapMigObjectRect2Screen(协议转化后的数据) object RectF " + ((DrawView2.a)localObject).as);
          }
          ((DrawView2.a)localObject).bV = null;
          ((DrawView2.a)localObject).imgUrl = null;
          ((DrawView2.a)localObject).bMu = paramadim.a.bNF;
          ((DrawView2.a)localObject).bMv = false;
          ((DrawView2.a)localObject).bMt = true;
          ((DrawView2.a)localObject).isStar = true;
          ((DrawView2.a)localObject).bMw = false;
          ((DrawView2.a)localObject).name = paramadim.a.btp;
          if (TextUtils.isEmpty(paramadim.a.bsv))
          {
            paramaddd = " ";
            ((DrawView2.a)localObject).bsv = paramaddd;
            if (!TextUtils.isEmpty(paramadim.a.bsw)) {
              break label634;
            }
            paramaddd = " ";
            ((DrawView2.a)localObject).bsw = paramaddd;
            ((DrawView2.a)localObject).uin = null;
            ((DrawView2.a)localObject).url = null;
            ((DrawView2.a)localObject).bsx = paramadim.a.bsx;
            if (QLog.isColorLevel())
            {
              QLog.d("AREngine_ARScanEntryView", 1, " label name is " + ((DrawView2.a)localObject).name + "isAutoJump " + ((DrawView2.a)localObject).bMu);
              if (TextUtils.isEmpty(paramadim.a.bsw)) {
                QLog.d("AREngine_ARScanEntryView", 1, " profileContent    null  ");
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null) {
              break label647;
            }
            this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.13(this));
          }
          for (;;)
          {
            paramaddd = new ArrayList();
            paramaddd.add(localObject);
            this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setFaceData(paramaddd);
            return;
            paramaddd = "error happen";
            break;
            paramaddd = paramadim.a.bsv;
            break label432;
            paramaddd = paramadim.a.bsw;
            break label458;
            QLog.d("AREngine_ARScanEntryView", 1, " scanningSurfaceView not ready ");
          }
          if (paramLong != 4L) {
            break;
          }
          if ((this.jdField_b_of_type_Adfd != null) && (this.jdField_b_of_type_Adfd.a != null))
          {
            int i = this.jdField_b_of_type_Adfd.a.Hb();
            if ((i != 3) && (i != 2) && (i != 0)) {
              hideTips();
            }
          }
          if ((QLog.isColorLevel()) && (adie.bNm)) {
            QLog.d("AREngine_ARScanEntryView", 2, "onARTrackComplete, recogType = " + paramLong + ",trackMode = " + paramInt + ",trackResult = " + paramaddd + ",localRecogResult = " + paramadim + ",isPause = " + this.isPause);
          }
        } while ((this.isPause) || (paramLong != 4L) || (!(paramadim instanceof adig)));
        paramaddd = (adig)paramadim;
      } while (paramaddd == null);
      paramadim = (Activity)this.mContext;
      if ((paramaddd.us != null) && (paramaddd.us.size() > 0)) {}
      for (;;)
      {
        if (!paramaddd.isTimeOut) {
          break label994;
        }
        this.bPh = false;
        if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.clear();
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.cRy();
          this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.15(this));
        }
        this.mUiHandler.post(new ARScanEntryView.16(this));
        return;
        hideTips();
        break;
        if ((this.jdField_b_of_type_Adfd != null) && (this.jdField_b_of_type_Adfd.ai != null) && (this.jdField_b_of_type_Adfd.ai.isShowing()) && (!paramadim.isFinishing())) {
          this.mUiHandler.post(new ARScanEntryView.14(this));
        }
      }
      if (!this.bPh)
      {
        this.bPh = true;
        this.mUiHandler.post(new ARScanEntryView.17(this));
      }
      if (this.UY < 0L) {
        this.UY = System.currentTimeMillis();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null);
    label647:
    label994:
    if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new ARScanEntryView.18(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setFaceData(paramaddd.us);
  }
  
  public void a(long paramLong, adec paramadec)
  {
    cTf();
    hideTips();
    if ((paramadec == null) || (paramadec.b == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete empty value");
      }
    }
    for (;;)
    {
      return;
      if (!this.bPq) {}
      try
      {
        localObject = this.jdField_b_of_type_Adku.cL();
        if (localObject != null)
        {
          ((ArrayList)localObject).size();
          ((ArrayList)localObject).toString();
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        label68:
        Intent localIntent;
        break label68;
      }
      this.bPq = true;
      if (!paramadec.b.aek()) {
        if ((paramadec.b.a != null) && (paramadec.b.a.bOa) && (paramadec.b.a.bNZ) && (!TextUtils.isEmpty(paramadec.b.a.but)))
        {
          this.mUiHandler.post(new ARScanEntryView.8(this, paramadec));
          if (!this.bOU)
          {
            this.mUiHandler.sendEmptyMessage(306);
            this.mUiHandler.sendEmptyMessageAtTime(313, 100L);
            this.mUiHandler.sendEmptyMessageDelayed(312, 100000L);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete start jump :" + paramadec.b.a.but);
          }
        }
        else if ((paramadec.b.type == 6) && (paramadec.b.a != null) && (!paramadec.b.a.bOa) && (paramadec.b.a.bNZ) && (!TextUtils.isEmpty(paramadec.b.a.but)))
        {
          anot.a(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, paramadec.b.picId, "1", "0", "");
          paramadec = paramadec.b.a.but;
          localObject = (Activity)this.mContext;
          if (kY(paramadec))
          {
            localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setData(Uri.parse(paramadec));
            localIntent.addFlags(268435456);
            localIntent.addCategory("android.intent.category.DEFAULT");
            localIntent.setPackage(this.mAppInterface.getApp().getPackageName());
            this.mContext.startActivity(localIntent);
          }
          while ((this.mContext instanceof Activity))
          {
            ((Activity)localObject).overridePendingTransition(2130772009, 0);
            return;
            localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
            localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
            localIntent.putExtra("url", paramadec);
            localIntent.putExtra("finish_animation_up_down", true);
            ((Activity)localObject).startActivity(localIntent);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, adec paramadec)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onAREnableModelRender, isEnable = " + paramBoolean);
    }
    int i;
    if (!paramBoolean) {
      i = 100;
    }
    for (;;)
    {
      try
      {
        switch (paramadec.b.type)
        {
        case 0: 
          anot.a(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramadec.b.picId, String.valueOf(i), String.valueOf(k), "");
        }
      }
      catch (Exception localException)
      {
        QLog.d("AREngine_ARScanEntryView", 1, "0X80081E0 ReportController  error " + localException.getMessage());
        continue;
        FX(true);
        this.mUiHandler.post(new ARScanEntryView.19(this));
        return;
      }
      if ((!this.jw.containsValue(Integer.valueOf(0))) || (!paramadec.b.aei()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
        }
        if (this.bOT != true) {}
      }
      else
      {
        return;
        if (paramadec.b.aeo())
        {
          i = 3;
          break label433;
        }
        if (!paramadec.b.aei()) {
          break label433;
        }
        i = 0;
        break label433;
        if (paramadec.b.aeo())
        {
          i = 1;
          break label439;
        }
        if (!paramadec.b.aen()) {
          break label439;
        }
        i = 5;
        break label439;
        if (paramadec.b.aei())
        {
          i = 2;
          break label445;
        }
        paramBoolean = paramadec.b.aeo();
        if (paramBoolean)
        {
          i = 4;
          break label445;
        }
        i = 6;
        break label445;
        k = 0;
        i = 100;
        continue;
      }
      if ((paramadec.b.businessId == 1) && (paramadec.b.cFf == 0)) {}
      for (i = 1; (i == 0) || (paramadec.b.aei()); i = 0)
      {
        FX(false);
        this.mUiHandler.post(new ARScanEntryView.20(this));
        return;
      }
      continue;
      int k = 2;
      i = 100;
      continue;
      label433:
      k = 2;
      continue;
      label439:
      k = 1;
      continue;
      label445:
      k = 1;
    }
  }
  
  public void a(adhf paramadhf, ArLBSActivity paramArLBSActivity)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onLBSLocationComplete. retCode = " + paramadhf.retCode + ", LBSActivity = " + paramArLBSActivity);
    ThreadManager.getUIHandler().post(new ARScanEntryView.30(this, paramadhf, paramArLBSActivity));
  }
  
  public void a(PromotionConfigInfo.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "loadTransferDoorGuide ");
    }
    akqu localakqu = a(true);
    if (localakqu == null) {
      return;
    }
    localakqu.d(parama);
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo1, ArCloudConfigInfo paramArCloudConfigInfo2, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onCommonCallbackFromUI, config=" + paramArCloudConfigInfo1 + ", action=" + paramInt1 + ", result=" + paramInt2 + ", data=" + paramObject);
    }
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, adda paramadda)
  {
    this.mUiHandler.post(new ARScanEntryView.26(this, paramadda, paramArVideoResourceInfo));
  }
  
  public void a(String paramString, PromotionConfigInfo.a parama, boolean paramBoolean)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "tryToEnterTransferMode[" + paramString + "], mIsTransferDoorMode[" + this.bPo + "], ready[" + paramBoolean + "]");
    this.bPo = true;
    this.bPn = true;
    if (parama != null) {
      this.mTitle.setText(parama.title);
    }
    cTh();
    if ((this.jdField_c_of_type_Adbn.gl != null) && (this.jdField_c_of_type_Adbn.gl.get() != null)) {
      ((adku)this.jdField_c_of_type_Adbn.gl.get()).cSy();
    }
    if ((!paramBoolean) || (parama == null)) {
      return;
    }
    this.bPp = true;
    Gv(false);
    Ll(1);
    paramString = parama.a();
    this.jdField_c_of_type_Adbn.Kv(2);
    this.jdField_c_of_type_Adbn.cPL();
    this.jdField_c_of_type_Adbn.cPN();
    this.jdField_c_of_type_Adbn.a(paramString);
    cTf();
    hideTips();
  }
  
  public void a(String paramString1, String paramString2, akqe.c paramc)
  {
    if (this.jdField_b_of_type_Akqe != null)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + paramString1 + "], isVisible[" + this.jdField_b_of_type_Akqe.isVisible() + "]", new Throwable("打印调用栈"));
      this.jdField_b_of_type_Akqe.a(paramString1, paramString2, paramc);
    }
  }
  
  public boolean aff()
  {
    return this.uA;
  }
  
  public boolean afg()
  {
    return (this.bPm) && (this.uA) && (this.jdField_b_of_type_Adku.qe() == 2);
  }
  
  public void b(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    c(paramARCommonConfigInfo);
  }
  
  public void bAH()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady isNotifyRecivied " + this.bPu);
    if (Build.VERSION.SDK_INT >= 16)
    {
      b();
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      this.mTitle.setVisibility(8);
      adcl.a().KB(6);
    }
    for (;;)
    {
      if (this.bPu)
      {
        ssr.bAH();
        this.mUiHandler.sendEmptyMessage(307);
      }
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("ar_model", Build.MODEL);
      localHashMap.put("ar_type", "3");
      localHashMap.put("ar_reason", "1");
      anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void bW(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.bPp) || (this.bPe)) && (!this.bOQ))
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showLoadProgress, 已经在穿越门里面了, from[" + paramString + "]");
      return;
    }
    this.jdField_a_of_type_Admh.a();
    int n = (this.cIH + this.cIG) / 2;
    QLog.d("AREngine_ARScanEntryView", 1, "showLoadProgress mCurrentAsyncProgress:=" + this.cIH + ",mCurrentSyncProgress:=" + this.cIG);
    int i;
    label142:
    int k;
    if ((this.jdField_a_of_type_Adco != null) && (this.jdField_a_of_type_Adco.isVisiable()))
    {
      i = 1;
      akqx localakqx = this.jdField_a_of_type_Admh.a();
      if ((localakqx == null) || (!this.bPn)) {
        break label274;
      }
      paramBoolean = localakqx.asF();
      k = localakqx.sp();
    }
    for (;;)
    {
      int m = n;
      if (paramBoolean) {
        m = (n + k) / 2;
      }
      if (i != 0) {
        hideTips();
      }
      for (;;)
      {
        cTc();
        if (this.bPg) {
          break;
        }
        this.bPg = true;
        anot.a(null, "dc00898", "", "", "0X80085B6", "0X80085B6", 0, 0, "", "", "", "");
        return;
        i = 0;
        break label142;
        L(paramString, acfp.m(2131702878), m);
      }
      label274:
      k = 0;
      paramBoolean = false;
    }
  }
  
  public void cRP()
  {
    QLog.d("AREngine_ARScanEntryView", 2, "ARTransferDoorLogicManager onRenderManagerStarted");
    if ((this.uA) && (this.bPo) && (this.bPm))
    {
      QLog.d("AREngine_ARScanEntryView", 2, "start for next Time");
      this.jdField_c_of_type_Adbn.cPN();
      this.jdField_c_of_type_Adbn.a(null);
    }
  }
  
  public void cSI()
  {
    Gw(false);
  }
  
  public void cSR()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewShow. mQQARSession mCurrentStatus:=" + this.jdField_b_of_type_Adku.qe());
    this.mStartTime = System.currentTimeMillis();
    super.cSR();
    cTk();
    cTe();
    if (!this.bPn)
    {
      cTj();
      FX(true);
      this.mAppInterface.addObserver(this.jdField_a_of_type_Adub);
      if (afh())
      {
        this.bPk = true;
        Looper.myQueue().addIdleHandler(this.jdField_c_of_type_AndroidOsMessageQueue$IdleHandler);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Adbn != null) {
        this.jdField_c_of_type_Adbn.doOnResume();
      }
      adcl.a().doOnResume();
      return;
      FX(false);
    }
  }
  
  public void cSS()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewClose. mQQARSession mCurrentStatus:=" + this.jdField_b_of_type_Adku.qe());
    super.cSS();
    cTl();
    this.jdField_a_of_type_Admh.a().cRV();
    FX(false);
    cTf();
    hideTips();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.dDh();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.dDf();
    Looper.myQueue().removeIdleHandler(this.jdField_c_of_type_AndroidOsMessageQueue$IdleHandler);
    this.mAppInterface.removeObserver(this.jdField_a_of_type_Adub);
    if (this.jdField_c_of_type_Adbn != null) {
      this.jdField_c_of_type_Adbn.doOnPause();
    }
    adcl.a().doOnPause();
    this.jdField_a_of_type_Admh.GA(true);
    this.bPx = false;
  }
  
  public void cSj()
  {
    QLog.i("AREngine_ARScanEntryView", 1, "onStartPreviewSuccess");
    cTi();
    cTj();
    cTk();
  }
  
  public void cSv()
  {
    this.bPu = true;
    this.mUiHandler.removeMessages(312);
    QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady " + this.bOV);
    if (this.bOV)
    {
      bAH();
      this.mUiHandler.sendEmptyMessage(307);
      this.mUiHandler.removeMessages(313);
    }
    if (this.jdField_b_of_type_Adku != null) {
      this.jdField_b_of_type_Adku.cSv();
    }
  }
  
  public void ch(int paramInt, String paramString)
  {
    QLog.d("AREngine_ARScanEntryView", 2, "onStartLoadUrl");
    this.bOU = true;
    this.mUiHandler.post(new ARScanEntryView.27(this, paramString));
    this.mUiHandler.sendEmptyMessageDelayed(312, 100000L);
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
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
                do
                {
                  do
                  {
                    return true;
                  } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null);
                  paramMessage = new RelativeLayout.LayoutParams(-1, -1);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.mContext);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
                  this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ankt.SCREEN_WIDTH);
                  this.mRoot.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramMessage);
                  this.mUiHandler.removeMessages(352);
                } while (!afe());
                FX(false);
                this.bOX = true;
                return true;
              } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
              this.mRoot.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
              this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
              if ((this.bOX) && (this.mUiHandler != null)) {
                this.mUiHandler.sendEmptyMessageDelayed(352, 2500L);
              }
              QLog.d("AREngine_ARScanEntryView", 1, "MSG_HIDE_SCAN_SUCCESS_PROGRESS,juhua has call finished ");
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
            this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.resultCode);
            return true;
            this.mUiHandler.sendEmptyMessageDelayed(313, 50L);
            this.resultCode += 1;
          } while (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null);
          this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.resultCode);
          return true;
          paramMessage = (Activity)this.mContext;
        } while ((!this.bOX) || (paramMessage.isFinishing()));
        FX(true);
        return true;
        cTb();
        return true;
        cST();
        return true;
        QLog.d("AREngine_ARScanEntryView", 1, "start AR ready");
        Gu(false);
        this.bPm = true;
        cTg();
        return true;
        cTa();
        return true;
        cTa();
        return true;
        cTa();
        return true;
        cTa();
        return true;
      } while (this.jdField_c_of_type_ComTencentBizUiTouchWebView == null);
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.onPause();
      return true;
      if ((!TextUtils.isEmpty(this.buz)) && (this.QH != null)) {
        this.QH.setText(this.buz.replace("\\n", "\n"));
      }
    } while ((this.bPn) || (this.bPo) || (this.QH == null));
    this.QH.setVisibility(0);
    return true;
  }
  
  public void hideTips()
  {
    if (this.jdField_b_of_type_Akqe != null)
    {
      Throwable localThrowable = null;
      if (this.jdField_b_of_type_Akqe.isVisible()) {
        localThrowable = new Throwable("打印调用栈");
      }
      QLog.w("AREngine_ARScanEntryView", 1, "hideTips", localThrowable);
      this.jdField_b_of_type_Akqe.dCP();
    }
  }
  
  public void hq(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.mUiHandler.sendEmptyMessage(307);
      return;
    case 0: 
      FX(false);
      cTf();
      hideTips();
      this.mUiHandler.sendEmptyMessage(306);
      return;
    }
    this.resultCode = paramInt2;
    this.mUiHandler.sendEmptyMessage(311);
  }
  
  public void hz(int paramInt1, int paramInt2) {}
  
  public String jS(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("https")) || (paramString.startsWith("http"))) {
      return paramString;
    }
    return "https://" + paramString;
  }
  
  public boolean kY(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (aqmr.isEmpty(paramString)) {}
    do
    {
      return bool2;
      String str = paramString.toLowerCase();
      if ((str.startsWith("mqqapi://miniapp/open")) || (str.startsWith("mqqapi://microapp/open"))) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_ARScanEntryView", 2, "checkUrlIsMiniAppJumpSchema, retValue is " + bool1 + ",strUrl" + paramString);
    return bool1;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("AREngine_ARScanEntryView", 1, "onAttachedToWindow ");
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (ScanTorchActivity)this.mContext;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((ScanTorchActivity)localObject2).doOnBackPressed(false);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARScanEntryView", 2, "onClick R.id.touch_view");
      }
      if ((this.jdField_a_of_type_Adec != null) && (this.jdField_a_of_type_Adec.b.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Adec.b.a.but)))
      {
        if (this.jdField_a_of_type_Adec.b.a.bOa) {
          break label518;
        }
        anot.a(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_Adec.b.picId, "0", "1", "");
        if (this.jdField_a_of_type_Adec.b.aeh()) {
          anot.a(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.jdField_a_of_type_Adec.b.picId, "1", "0", "");
        }
        localObject1 = this.jdField_a_of_type_Adec.b.a.but;
        ((ScanTorchActivity)localObject2).setResult(11);
        adcl.a().KB(3);
        if (!kY((String)localObject1)) {
          break label470;
        }
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject2).setPackage(this.mAppInterface.getApp().getPackageName());
        this.mContext.startActivity((Intent)localObject2);
        label321:
        this.bOW = true;
      }
      label470:
      Object localObject3;
      for (;;)
      {
        if ((this.jdField_a_of_type_Adec != null) && (!this.jdField_a_of_type_Adec.b.aei())) {
          this.mAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Adec.b.picId, "2");
        }
        cSZ();
        if ((this.jdField_a_of_type_Adec == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Adec.b.picId))) {
          break;
        }
        this.mAppInterface.reportClickEvent("CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.mAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Adec.b.picId, "");
        break;
        localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_sacan");
        ((Intent)localObject3).putExtra("url", jS((String)localObject1));
        ((ScanTorchActivity)localObject2).startActivity((Intent)localObject3);
        break label321;
        label518:
        anot.a(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_Adec.b.picId, "0", "0", "");
        this.bOT = true;
        FX(false);
        cSW();
        cSX();
        if (this.jdField_b_of_type_Adku != null)
        {
          this.jdField_b_of_type_Adku.iM(1L);
          this.jdField_b_of_type_Adku.cSn();
        }
        bAH();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, "find button clicked what2scanUrl = " + this.bsp);
      }
      this.mAppInterface.reportClickEvent("dc00898", "", this.mAppInterface.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
      Object localObject1 = aduc.b(this.mAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.asH())
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.dDf();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning runiing");
        }
      }
      this.yh.setVisibility(4);
      if (((SharedPreferences)localObject1).getBoolean("key_show_reddot", false))
      {
        localObject3 = bn(NetConnInfoCenter.getServerTimeMillis());
        ((SharedPreferences)localObject1).edit().putString("key_click_reddot_date", (String)localObject3).commit();
        ((SharedPreferences)localObject1).edit().putBoolean("key_show_reddot", false).commit();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning KEY_SHOW_REDDOT true");
        }
      }
      try
      {
        localObject1 = this.bsp;
        if (TextUtils.isEmpty(this.bsp)) {
          localObject1 = "https://ti.qq.com/arinfo/index.html?_nav_alpha=true";
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, "find button clicked jumpurl  = " + (String)localObject1);
        }
        localObject3 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_sacan");
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).putExtra("finish_animation_up_down", false);
        ((ScanTorchActivity)localObject2).startActivity((Intent)localObject3);
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARScanEntryView", 1, "find button clicked start QQBrowserActivity catch an Exception.", localException);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    this.mUiHandler = new Handler(this);
    this.aA = paramBundle;
    this.UU = this.aA.getLong("downloadItems", 14L);
    this.bPn = this.aA.getBoolean("arTransferPromotion", false);
    this.bPl = this.aA.getBoolean("enableARCloud", true);
    if (this.mContentView == null)
    {
      paramBundle = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561214, this, false);
      addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
      initView();
      initData();
      this.mContentView = paramBundle;
    }
    this.jdField_b_of_type_Akqe = new akqe(this.mContext, (RelativeLayout)this.mContentView, new adlh(this));
    this.jdField_c_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    cSO();
    adkt.a().a(this);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    this.bPj = false;
    this.mInited = true;
  }
  
  public void onDestroy()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onDestroy ");
    if (this.bPk) {
      this.mAppInterface.reportClickEvent("dc00898", "", this.mAppInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Admh.a().cRV();
    if ((this.jdField_b_of_type_Adku != null) && (this.jdField_b_of_type_Adku.isInited()))
    {
      this.jdField_b_of_type_Adku.stop();
      this.jdField_b_of_type_Adku.uninit();
    }
    this.jdField_b_of_type_Adku = null;
    adku.cSz();
    adkt.a().b(this);
    if (this.jdField_c_of_type_Adbn != null)
    {
      this.jdField_c_of_type_Adbn.uninit();
      this.jdField_c_of_type_Adbn = null;
    }
    this.mAppInterface.removeObserver(this.jdField_a_of_type_Adub);
    adcl.a().stop();
    removeAllViews();
    this.mContentView = null;
    if ((this.mContext != null) && ((this.mContext instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)this.mContext).doReport();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.dDh();
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.dDf();
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = null;
    }
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
    this.bPb = false;
    this.bPc = false;
    this.bPd = false;
    this.bPw = false;
    cSQ();
    this.jdField_c_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
    this.bPa = false;
    this.mInited = false;
    this.bOQ = false;
    this.bPr = false;
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onPause ");
    FX(false);
    cTl();
    if (this.jdField_c_of_type_Adbn != null) {
      this.jdField_c_of_type_Adbn.doOnPause();
    }
    adcl.a().doOnPause();
    this.isPause = true;
    if (this.jdField_c_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.onPause();
    }
    if (this.mUiHandler != null) {
      this.mUiHandler.sendEmptyMessage(307);
    }
    if (this.jdField_a_of_type_Aday != null) {
      this.jdField_a_of_type_Aday.dismiss();
    }
    if (this.aj != null) {
      this.aj.dismiss();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onResume ");
    super.onResume();
    cTk();
    if ((!this.bPn) && (!this.bPo)) {
      FX(true);
    }
    this.isPause = false;
    if (!this.bOS) {
      cSV();
    }
    if (this.jdField_c_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_c_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    if (this.bOW) {
      FX(true);
    }
    if (this.jw != null) {
      this.jw.clear();
    }
    if (this.bOT == true)
    {
      FX(true);
      if (this.jdField_c_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_c_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      }
    }
    this.bOT = false;
    this.bOU = false;
    this.bOV = false;
    if ((this.jdField_b_of_type_Adfd != null) && (this.jdField_b_of_type_Adfd.ai != null) && (this.jdField_b_of_type_Adfd.ai.isShowing())) {
      this.jdField_b_of_type_Adfd.ai.dismiss();
    }
    if ((this.jdField_b_of_type_Adfd != null) && (this.jdField_b_of_type_Adfd.a != null)) {
      this.jdField_b_of_type_Adfd.a.dCP();
    }
    if (this.jdField_c_of_type_Adbn != null) {
      this.jdField_c_of_type_Adbn.doOnResume();
    }
    adcl.a().doOnResume();
  }
  
  public void setRectAreas(Rect paramRect)
  {
    this.bE = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramRect = (ViewGroup.MarginLayoutParams)this.QH.getLayoutParams();
    paramRect.setMargins(paramRect.leftMargin, this.bE.bottom + wja.dp2px(30.0F, getResources()), paramRect.rightMargin, paramRect.bottomMargin);
  }
  
  public void showErrorTips(String paramString)
  {
    if (this.jdField_b_of_type_Akqe != null)
    {
      QLog.w("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + paramString + "], isVisible[" + this.jdField_b_of_type_Akqe.isVisible() + "]", new Throwable("打印调用栈"));
      this.jdField_b_of_type_Akqe.showTips(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView
 * JD-Core Version:    0.7.0.1
 */