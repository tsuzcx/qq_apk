package com.tencent.mobileqq.olympic.activity;

import acfp;
import adau;
import adcl;
import adfn;
import adfp;
import adfw;
import adfx;
import adkw;
import adla.a;
import adla.b;
import adla.c;
import adla.d;
import adla.e;
import adlb;
import akrc;
import akrd;
import akre;
import akre.a;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.RelativeLayout;
import anlm;
import anpc;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.QQBroadcastReceiver;
import mqq.os.MqqHandler;
import rvx;
import wja;

public class ScanTorchActivity
  extends OlympicToolBaseActivity
  implements akre.a, Handler.Callback
{
  public static boolean cul;
  long UY = -1L;
  public adfp a;
  adla.b jdField_a_of_type_Adla$b = null;
  private akre jdField_a_of_type_Akre;
  public ARArguments a;
  private ScanEntryProviderContainerView jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
  private ScanGLRenderEnvFragment jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment;
  private QQBroadcastReceiver jdField_a_of_type_MqqAppQQBroadcastReceiver = new akrd(this);
  private boolean aKb = true;
  private boolean aKc;
  public long aef;
  public long aeg = -1L;
  public long aeh = -1L;
  private long aei;
  private long aej;
  private long aek;
  private boolean ape;
  public String azS;
  Rect bA;
  private boolean bNd;
  public boolean bOR;
  boolean bOZ = false;
  volatile boolean bPk;
  private String bTX;
  public adkw c;
  public int cIF = -1;
  private boolean cum;
  private boolean cun;
  private boolean cuo;
  private int doV;
  private int doW;
  private int doX;
  volatile boolean isPause = false;
  private HashMap<String, Integer> jw = new HashMap();
  public RelativeLayout mRoot;
  public Handler mUiHandler;
  private long yH = -1L;
  
  private void dDa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initArConfig mArEnabled=%s", new Object[] { Boolean.valueOf(this.aKb) }));
    }
    if (!this.aKb) {
      return;
    }
    this.jdField_a_of_type_Adfp.a(this, true, this.c, this.c, this.c, null);
    this.aek = System.currentTimeMillis();
  }
  
  private void dDb()
  {
    ImmersiveUtils.getScreenWidth();
    ImmersiveUtils.getScreenHeight();
    int j;
    int i;
    if (adlb.SCREEN_WIDTH < adlb.cIE)
    {
      j = adlb.SCREEN_WIDTH;
      i = adlb.cIE;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        break label181;
      }
      i -= ImmersiveUtils.getStatusBarHeight(this);
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, String.format("initQrScanRectDisplay screenWidth=%s, screenHeight=%s, exclude=%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) }));
      }
      int m = (int)(adfw.a().uD * Math.min(i, j));
      int k = m;
      if (m <= 0) {
        k = wja.dp2px(248.0F, getResources());
      }
      this.bA = new Rect(0, 0, k, k);
      this.bA.offset(j / 2 - this.bA.centerX(), (int)(i / 2 - 0.55F * this.bA.height()));
      return;
      i = adlb.SCREEN_WIDTH;
      j = adlb.cIE;
      break;
    }
  }
  
  private void dDc()
  {
    if ((this.ape) || (this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment != null)) {}
    do
    {
      return;
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment = ScanGLRenderEnvFragment.a(null);
      localFragmentTransaction.add(2131362899, this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment);
      localFragmentTransaction.commitAllowingStateLoss();
    } while (this.aeh >= 0L);
    this.aeh = System.currentTimeMillis();
  }
  
  private static String format(int paramInt)
  {
    return String.format("%.2f", new Object[] { Float.valueOf(paramInt / 1000.0F) });
  }
  
  private void initData()
  {
    this.mUiHandler = new Handler(this);
    Object localObject2 = getIntent();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      ((Intent)localObject2).setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
      cul = ((Intent)localObject2).getBooleanExtra("log_on", false);
      this.azS = ((Intent)localObject2).getStringExtra("CurrentNickname");
      localObject2 = ((Intent)localObject2).getBundleExtra("web_invoke_params");
      if (QLog.isDevelopLevel()) {
        AudioHelper.I("ScanTorchActivity.initData", (Bundle)localObject2);
      }
      if (localObject2 == null) {
        break label434;
      }
    }
    label429:
    label434:
    for (long l = ((Bundle)localObject2).getLong("PromotionType", 0L);; l = 0L)
    {
      if (l == 2L)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Adla$b == null)
        {
          this.jdField_a_of_type_Adla$b = new adla.c();
          QLog.w("ScanTorchActivity", 1, "initData, 没有运营数据");
        }
        this.jdField_a_of_type_ComTencentMobileqqArARArguments = new ARArguments(false);
        this.jdField_a_of_type_Adfp = new adfp();
        this.c = new adkw(this, this.jdField_a_of_type_Adfp);
        dDa();
        if ((localObject1 != null) && ((this.jdField_a_of_type_Adla$b instanceof adla.d)) && ((this.jdField_a_of_type_Adla$b.UX & 0x1000) != 0L))
        {
          this.jdField_a_of_type_Adla$b = new adla.a();
          this.jdField_a_of_type_Adla$b.d(this.app, (Bundle)localObject1);
          if (TextUtils.isEmpty(((adla.a)this.jdField_a_of_type_Adla$b).buw)) {
            ((adla.a)this.jdField_a_of_type_Adla$b).buw = "-1";
          }
          if (QLog.isColorLevel()) {
            QLog.i("ScanTorchActivity", 2, "transfer Promotion to AR TransferPromotion");
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
        localObject2 = this.jdField_a_of_type_Adla$b;
        if (this.aKb) {
          break label429;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((ScanEntryProviderContainerView)localObject1).a((adla.b)localObject2, bool);
        return;
        if (l == 3L)
        {
          this.jdField_a_of_type_Adla$b = new adla.a();
          this.jdField_a_of_type_Adla$b.d(this.app, (Bundle)localObject2);
          localObject1 = localObject2;
          break;
        }
        if (l == 1L)
        {
          this.jdField_a_of_type_Adla$b = new adla.d();
          this.jdField_a_of_type_Adla$b.d(this.app, (Bundle)localObject2);
          localObject1 = localObject2;
          break;
        }
        localObject1 = localObject2;
        if (l != 4L) {
          break;
        }
        this.jdField_a_of_type_Adla$b = new adla.e();
        this.jdField_a_of_type_Adla$b.d(this.app, (Bundle)localObject2);
        localObject1 = localObject2;
        break;
      }
    }
  }
  
  private void initView()
  {
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    dDb();
    dDc();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView = ((ScanEntryProviderContainerView)findViewById(2131377668));
    ScanEntryProviderContainerView localScanEntryProviderContainerView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView;
    Rect localRect = this.bA;
    if (!this.aKc) {}
    for (boolean bool = true;; bool = false)
    {
      localScanEntryProviderContainerView.setScanRect(localRect, bool);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setRenderEngine(this.jdField_a_of_type_ComTencentMobileqqArViewScanGLRenderEnvFragment.c());
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setInitEnv(this.app, this);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.ces();
      ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.2(this), 100L);
      return;
    }
  }
  
  public final boolean Vr()
  {
    return anlm.pq(ThemeUtil.getCurrentThemeId());
  }
  
  public void cSv()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.cSv();
    }
  }
  
  protected void dDd()
  {
    if (isFinishing()) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        i = this.mRoot.getWidth();
        j = this.mRoot.getHeight();
        if (QLog.isColorLevel()) {
          QLog.i("ScanTorchActivity", 2, String.format("updateQRRect [%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
      } while ((i <= 0) || (j <= 0) || ((adlb.SCREEN_WIDTH == i) && (adlb.cIE == j)));
      adlb.SCREEN_WIDTH = i;
      adlb.cIE = j;
      dDb();
    } while (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView == null);
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.i(this.bA);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnBackPressed");
    }
    doOnBackPressed(true);
  }
  
  public void doOnBackPressed(boolean paramBoolean)
  {
    adcl.a().KB(4);
    setResult(11);
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    if ((i != this.doW) || (j != this.doX)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("doOnConfigurationChanged [%d,%d,%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        this.doW = i;
        this.doX = j;
        ThreadManager.getUIHandler().postDelayed(new ScanTorchActivity.4(this), 100L);
      }
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnCreate");
    }
    getWindow().setFormat(-3);
    getWindow().addFlags(128);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT <= 28) {
        break label283;
      }
      super.getWindow().addFlags(1024);
    }
    for (;;)
    {
      this.ape = false;
      this.yH = System.currentTimeMillis();
      this.mNeedStatusTrans = true;
      this.mActNeedImmersive = false;
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(ArConfigInfo.class.getClassLoader());
        l1 = System.currentTimeMillis();
        if ((Build.MODEL.equalsIgnoreCase("STF-AL10")) || (Build.MODEL.equalsIgnoreCase("LON-AL00-PD")) || (Build.MODEL.equalsIgnoreCase("vivo Y55A")) || (Build.MODEL.equalsIgnoreCase("OPPO_R11st")) || (Build.MODEL.equalsIgnoreCase("vivo_Xplay5A")) || (Build.MODEL.equalsIgnoreCase("EML-AL00")) || (Build.MODEL.equalsIgnoreCase("SM-G9250")) || (Build.MODEL.equalsIgnoreCase("Pixel 2"))) {}
        for (;;)
        {
          super.doOnCreate(paramBundle);
          if (QLog.isColorLevel()) {
            QLog.i("ScanTorchActivity", 2, String.format("super.doOnCreate time cost:%sms SDK version %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(Build.VERSION.SDK_INT) }));
          }
          setContentView(2131561525);
          if (!isInMultiWindow()) {
            break label336;
          }
          QQToast.a(this, acfp.m(2131714010), 0).show();
          finish();
          return true;
          label283:
          super.getWindow().addFlags(256);
          super.getWindow().addFlags(512);
          break;
          this.isClearCoverLayer = false;
        }
        hideTitleBar();
      }
      catch (Exception paramBundle)
      {
        QLog.d("ScanTorchActivity", 1, "doOnCreate fail!", paramBundle);
        this.jdField_a_of_type_MqqAppQQBroadcastReceiver = null;
        finish();
        return true;
      }
    }
    label336:
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      if (paramBundle.getBooleanExtra("from_qr", false)) {
        this.aKb = paramBundle.getBooleanExtra("ar_enabled", false);
      }
      if (!this.aKb) {
        this.aKc = paramBundle.getBooleanExtra("hide_album", false);
      }
    }
    paramBundle = paramBundle.getBundleExtra("web_invoke_params");
    long l1 = 0L;
    if (paramBundle != null) {
      l1 = paramBundle.getLong("PromotionType", 0L);
    }
    if (l1 == 4L) {
      this.aKb = false;
    }
    initView();
    initData();
    if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.tim__alive");
      registerReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_Akre = new akre(this.mUiHandler, this);
    this.jdField_a_of_type_Akre.a(this);
    adau.a(this).start();
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.setUniformResManager(this.c);
    adfx.a().reset();
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.CAMERA") == 0) {
        break label608;
      }
      QLog.d("ScanTorchActivity", 1, "checkSelfPermission. not grant");
      requestPermissions(new akrc(this), 1, new String[] { "android.permission.CAMERA" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("doOnCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      AudioHelper.G(this.mApp);
      return true;
      label608:
      QLog.d("ScanTorchActivity", 1, "checkSelfPermission. grant");
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnDestroy,  needReportRedDot = " + this.bPk);
    }
    if (this.bPk) {
      this.app.reportClickEvent("dc00898", "", this.app.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    if (adfn.bMz) {
      adfn.a().doReport();
    }
    try
    {
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver);
      }
      if (this.mUiHandler != null) {
        this.mUiHandler.removeCallbacksAndMessages(null);
      }
      if (this.jw != null) {
        this.jw.clear();
      }
      doReport();
    }
    catch (Exception localException1)
    {
      try
      {
        if (this.jdField_a_of_type_Adfp != null)
        {
          this.jdField_a_of_type_Adfp.cRn();
          this.jdField_a_of_type_Adfp = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.onDestroy();
        }
        super.doOnDestroy();
        if (Vr()) {
          ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
        this.ape = true;
        rvx.cJ(this);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("ScanTorchActivity", 2, "doOnDestroy mArconfigManager unbind fail. ", localException2);
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    this.bTX = paramIntent;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnPause");
    }
    this.isPause = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnResume");
    }
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.onResume();
    }
    if ((!TextUtils.isEmpty(this.bTX)) && (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView.GB(this.bTX);
      this.bTX = null;
    }
    if ((isInMultiWindow()) && (!this.bOZ))
    {
      QQToast.a(this, acfp.m(2131714009), 1).show();
      this.bOZ = true;
    }
    if (Vr()) {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStart");
    }
    this.aef = System.currentTimeMillis();
    if (this.jdField_a_of_type_Akre != null) {
      this.jdField_a_of_type_Akre.bdL();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStop");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.aef;
    this.app.reportClickEvent("CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(l1 - l2), "", "");
    if (this.jdField_a_of_type_Akre != null) {
      this.jdField_a_of_type_Akre.bdM();
    }
  }
  
  /* Error */
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 849	com/tencent/mobileqq/olympic/activity/OlympicToolBaseActivity:doOnWindowFocusChanged	(Z)V
    //   5: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +36 -> 44
    //   11: ldc 106
    //   13: iconst_2
    //   14: ldc_w 851
    //   17: iconst_2
    //   18: anewarray 110	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 116	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 853	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:cum	Z
    //   34: invokestatic 116	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 122	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: monitorenter
    //   46: iload_1
    //   47: ifeq +29 -> 76
    //   50: aload_0
    //   51: getfield 855	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:cuo	Z
    //   54: ifne +22 -> 76
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 855	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:cuo	Z
    //   62: aload_0
    //   63: getfield 384	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   66: ifnull +10 -> 76
    //   69: aload_0
    //   70: getfield 384	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView	Lcom/tencent/mobileqq/ar/view/ScanEntryProviderContainerView;
    //   73: invokevirtual 858	com/tencent/mobileqq/ar/view/ScanEntryProviderContainerView:cTq	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: iload_1
    //   79: ifeq +10 -> 89
    //   82: aload_0
    //   83: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   86: putfield 860	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:aej	J
    //   89: iload_1
    //   90: ifeq +141 -> 231
    //   93: aload_0
    //   94: getfield 862	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:cun	Z
    //   97: ifne +134 -> 231
    //   100: aload_0
    //   101: invokevirtual 270	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:getIntent	()Landroid/content/Intent;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +111 -> 219
    //   111: aload 6
    //   113: ldc_w 864
    //   116: iconst_0
    //   117: invokevirtual 288	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   120: istore_1
    //   121: aload 6
    //   123: ldc_w 866
    //   126: lconst_0
    //   127: invokevirtual 869	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   130: lstore_2
    //   131: aload 6
    //   133: ldc_w 871
    //   136: lconst_0
    //   137: invokevirtual 869	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   140: lstore 4
    //   142: aload 6
    //   144: ldc_w 873
    //   147: invokevirtual 296	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 6
    //   152: invokestatic 680	adfx:a	()Ladfx;
    //   155: iload_1
    //   156: lload_2
    //   157: lload 4
    //   159: aload 6
    //   161: invokevirtual 877	adfx:b	(ZJJLjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 879	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:bNd	Z
    //   168: ifeq +51 -> 219
    //   171: lload_2
    //   172: lconst_0
    //   173: lcmp
    //   174: ifle +45 -> 219
    //   177: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   180: lstore 4
    //   182: ldc_w 880
    //   185: invokestatic 610	acfp:m	(I)Ljava/lang/String;
    //   188: iconst_1
    //   189: anewarray 110	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: lload 4
    //   196: lload_2
    //   197: lsub
    //   198: invokestatic 597	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: aastore
    //   202: invokestatic 122	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: astore 6
    //   207: aload_0
    //   208: iconst_0
    //   209: aload 6
    //   211: iconst_0
    //   212: invokestatic 883	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   215: invokevirtual 619	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   218: pop
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 862	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:cun	Z
    //   224: aload_0
    //   225: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   228: putfield 885	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:aei	J
    //   231: return
    //   232: astore 6
    //   234: aload_0
    //   235: monitorexit
    //   236: aload 6
    //   238: athrow
    //   239: astore 6
    //   241: goto -22 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ScanTorchActivity
    //   0	244	1	paramBoolean	boolean
    //   130	67	2	l1	long
    //   140	55	4	l2	long
    //   104	106	6	localObject1	Object
    //   232	5	6	localObject2	Object
    //   239	1	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	76	232	finally
    //   76	78	232	finally
    //   234	236	232	finally
    //   207	219	239	java/lang/Exception
  }
  
  public void doReport()
  {
    Intent localIntent = getIntent();
    long l;
    int i;
    int j;
    int k;
    HashMap localHashMap;
    if ((localIntent != null) && (this.yH > 0L) && (this.aeh > 0L) && (this.aeg > 0L))
    {
      l = localIntent.getLongExtra("click_time", 0L);
      i = (int)(this.yH - l);
      j = (int)(this.aeg - this.aeh);
      k = (int)(this.aeh - l);
      if ((i > 0) && (j > 0) && (k > 0))
      {
        localHashMap = new HashMap();
        if (!localIntent.getBooleanExtra("proc_exist", false)) {
          break label315;
        }
        str = "1";
        localHashMap.put("proc_exist", str);
        if (!localIntent.getBooleanExtra("first_click", false)) {
          break label323;
        }
      }
    }
    label315:
    label323:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("first_click", str);
      localHashMap.put("rcv_kill_broadcast", String.valueOf(this.doV));
      localHashMap.put("time_oncreate", format(i));
      localHashMap.put("time_ar_ready", format(j));
      localHashMap.put("time_add_fragment", format(k));
      anpc.a(this).collectPerformance("", "olympic_tool_proc_report", true, j, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, new Object[] { "doReport, params=", localHashMap });
      }
      if (this.UY > 0L)
      {
        l = (System.currentTimeMillis() - this.UY) / 1000L;
        if (l < 7200L) {
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceRecog", true, l, 0L, null, "", true);
        }
      }
      return;
      str = "0";
      break;
    }
  }
  
  public long fp()
  {
    return this.aei;
  }
  
  public void g(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = paramUri;
      if (paramUri == null) {
        localObject = "null";
      }
      QLog.d("ScanTorchActivity", 2, new Object[] { "onDetectScreenshot, uri=", localObject });
    }
    if (!this.bOR) {
      return;
    }
    this.app.reportClickEvent("CliOper", "", "", "0X8006ABD", "0X8006ABD", 0, 0, "1", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QLog.i("ScanTorchActivity", 2, "onMultiWindowModeChanged" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScanTorchActivity
 * JD-Core Version:    0.7.0.1
 */