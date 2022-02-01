package com.tencent.biz.qrcode.activity;

import acfp;
import admn;
import ahav;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import anot;
import anpc;
import aqgv;
import aqhs;
import arhz;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.biz.widgets.ScannerView.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import kaw;
import org.json.JSONException;
import org.json.JSONObject;
import rvs;
import rvu;
import rvv;
import rvw;
import rvx;
import rwc;
import rwe;
import rwf;
import rwg;

public class ScannerActivity
  extends BaseActivity
{
  public static boolean aJX = true;
  private boolean XM;
  public ScannerParams a;
  private ScannerView.b jdField_a_of_type_ComTencentBizWidgetsScannerView$b = new rvs(this);
  public ARScanAR a;
  public OcrConfig a;
  private rwc jdField_a_of_type_Rwc;
  private rwe jdField_a_of_type_Rwe = new rvu(this);
  private rwf jdField_a_of_type_Rwf;
  private String aCI;
  private boolean aJV;
  private boolean aJW;
  public boolean aJY;
  private boolean aJZ;
  private boolean aKa = true;
  private boolean aKb;
  private boolean aKc;
  private Handler.Callback c = new rvw(this);
  private arhz h;
  private long mClickTime;
  private Handler mUiHandler;
  private View pw;
  private long start_time = -1L;
  
  private JSONObject P()
    throws JSONException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = getIntent();
    String str = this.aCI;
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return localObject1;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Intent)localObject3).hasExtra("report_params"))
      {
        localObject3 = ((Intent)localObject3).getStringExtra("report_params");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = new JSONObject((String)localObject3);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new JSONObject();
      if (TextUtils.isEmpty(str)) {
        break label270;
      }
      ((JSONObject)localObject2).put("type", 9);
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(((JSONObject)localObject2).optString("md5"))) && (!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        long l = System.currentTimeMillis();
        localObject1 = aqhs.bytes2HexStr(ahav.t(str));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((JSONObject)localObject2).put("md5", ((String)localObject1).toUpperCase());
        }
        if (QLog.isColorLevel()) {
          QLog.d("ScannerActivity", 2, "buildQRReportParams md5:" + (String)localObject1 + " cost:" + (System.currentTimeMillis() - l));
        }
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ScannerActivity", 2, "buildQRReportParams params:" + ((JSONObject)localObject2).toString());
      return localObject2;
      label270:
      ((JSONObject)localObject2).put("type", 8);
    }
  }
  
  private void bwW()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams = new ScannerParams();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from = localIntent.getStringExtra("from");
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCL = localIntent.getStringExtra("subfrom");
    if ("addcontacts".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from)) {
      anpc.a(getApplicationContext()).b(this.app, "", "addfriend_QR", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKi = localIntent.getBooleanExtra("QRDecode", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.bvA = localIntent.getIntExtra("detectType", 1);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCN = localIntent.getStringExtra("preResult");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKl = "qlink".equalsIgnoreCase(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKk = super.getPackageManager().hasSystemFeature("android.hardware.camera");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM)) {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKh = true;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKe = localIntent.getBooleanExtra("scanForResult", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKf = localIntent.getBooleanExtra("finishAfterSucc", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKm = false;
      this.pw = findViewById(2131377682);
      ViewCompat.setImportantForAccessibility(this.pw, 2);
      if (("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from)) || ("web-ar".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))) {
        this.aKb = true;
      }
      this.aKc = localIntent.getBooleanExtra("hide_album", false);
      this.start_time = localIntent.getLongExtra("start_time", -1L);
      QLog.i("ScannerActivity", 1, "mScannerParams: " + this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.toString());
      return;
      if ("ImagePreviewActivity".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
      {
        anpc.a(getApplicationContext()).b(this.app, "", "bigpicture_QR", 1);
      }
      else if ("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKj = true;
        anpc.a(getApplicationContext()).b(this.app, "", "bulb_QR", 1);
      }
      else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
      {
        anpc.a(getApplicationContext()).b(this.app, "", "find_QR", 1);
      }
      else if ("publicAccountNew".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKg = true;
      }
      else if ((!ScanTorchActivity.class.getSimpleName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from)) && ("QRDisplayActivity".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from)))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKj = true;
      }
    }
  }
  
  private void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.aJV = true;
    if (QLog.isColorLevel()) {
      QLog.i("ScannerActivity", 1, "handleScannerResult scannerResult:" + paramString2 + "  scannerType:" + paramString1 + " resultType:" + paramInt1 + " reqType:" + paramInt2);
    }
    if ((paramInt1 & 0x1) == 1) {
      if (kaw.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
      {
        localIntent = new Intent("com.tencent.biz.pubaccount.scanResultAction");
        if (paramString1 != null)
        {
          if (paramString1.equalsIgnoreCase("QR_CODE")) {
            localIntent.putExtra("com.tencent.biz.pubaccount.scanResultType", 2);
          }
        }
        else
        {
          localIntent.putExtra("com.tencent.biz.pubaccount.scanResultData", paramString2);
          sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
          if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKg) {
            break label418;
          }
          getIntent().putExtra("scanResult", paramString2);
          setResult(-1, getIntent());
          finish();
        }
      }
    }
    label343:
    while ((paramInt1 & 0x2) != 2)
    {
      do
      {
        for (;;)
        {
          return;
          localIntent.putExtra("com.tencent.biz.pubaccount.scanResultType", 1);
          continue;
          if (!admn.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from)) {
            break;
          }
          localIntent = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
          localIntent.putExtra("com.tencent.ark.scanResultData", paramString2);
          localIntent.putExtra("com.tencent.ark.scanResultType", paramString1);
          sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
          finish();
        }
        if ("micro_app".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
        {
          localIntent = new Intent("com.tencent.mobileqq.microapp.out.plugins.scanResultAction");
          if (paramString1 != null)
          {
            if (!paramString1.equalsIgnoreCase("QR_CODE")) {
              break label343;
            }
            localIntent.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 2);
          }
          for (;;)
          {
            localIntent.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultData", paramString2);
            sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
            finish();
            break;
            localIntent.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 1);
          }
        }
      } while (!"mini_app".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from));
      Intent localIntent = new Intent("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
      localIntent.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType", paramString1);
      localIntent.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData", paramString2);
      sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
      finish();
      return;
      rvx.a(paramString1, paramString2, this, this.app, this.pw, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams, this.jdField_a_of_type_Rwe);
      return;
    }
    label418:
    RecogUtil.jumpMiniCode(paramString2, this);
    finish();
  }
  
  private void x(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Rwf == null) {
      this.jdField_a_of_type_Rwf = new rwf(this, this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b);
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 3;
    }
    this.aCI = paramString1;
    this.jdField_a_of_type_Rwf.x(paramString1, i, paramString2);
  }
  
  public void abe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "showProgress mProgressShowing:" + this.XM);
    }
    if (this.XM) {}
    do
    {
      return;
      try
      {
        if (this.h == null)
        {
          this.h = new arhz(this, getTitleBarHeight());
          this.h.setMessage(acfp.m(2131714000));
          this.h.setBackAndSearchFilter(false);
        }
        this.XM = true;
        this.h.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("ScannerActivity", 2, "");
  }
  
  public void bwX()
  {
    long l = System.currentTimeMillis();
    this.mClickTime = System.currentTimeMillis();
    this.aJW = NearbyFakeActivity.arr();
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeMessages(1);
      this.mUiHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    if (this.jdField_a_of_type_Rwc == null) {
      this.jdField_a_of_type_Rwc = new rwc(this);
    }
    QLog.d("ScannerActivity", 2, "launchAr time pre: " + (System.currentTimeMillis() - l));
    this.jdField_a_of_type_Rwc.a("qr", 5000L, new rvv(this, l));
  }
  
  public void bwY()
  {
    QLog.d("ScannerActivity", 2, String.format("doLaunchAr", new Object[0]));
    if (this.jdField_a_of_type_Rwc != null)
    {
      this.jdField_a_of_type_Rwc.onDestroy();
      this.jdField_a_of_type_Rwc = null;
    }
    Object localObject;
    if ((this.app instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)this.app.getManager(13);
      if (localObject != null) {
        ((WebProcessManager)localObject).egu();
      }
      localObject = new Intent(this, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
    }
    Intent localIntent = new Intent(this, ScanTorchActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("click_time", this.mClickTime);
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    localIntent.putExtra("first_click", aJX);
    localIntent.putExtra("proc_exist", this.aJW);
    localIntent.putExtra("software", getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
    aJX = false;
    localIntent.putExtra("log_on", ScanTorchActivity.cul);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanAR != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.bso)) {
        break label607;
      }
      localIntent.putExtra("icon_text", "QQ-AR");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.bsm)) {
        localIntent.putExtra("icon_url", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.bsm);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.scanLine1)) {
        localIntent.putExtra("scan_ar_default_tips", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.scanLine1);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.scanLine2)) {
        localIntent.putExtra("scan_ar_default_tips2", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.scanLine2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
        localIntent.putExtra("key_ocr_config", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
      }
      localIntent.putExtra("key_ar_config", this.jdField_a_of_type_ComTencentMobileqqArARScanAR);
      localIntent.putExtra("CurrentNickname", aqgv.B(this.app, this.app.getCurrentAccountUin()));
      localIntent.putExtra("from_qr", true);
      localIntent.putExtra("ar_enabled", this.aKb);
      localIntent.putExtra("hide_album", this.aKc);
      localIntent.putExtra("from", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from);
      if ((TextUtils.equals("web-ar", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from)) && (getIntent() != null))
      {
        localIntent.putExtra("click_time", getIntent().getLongExtra("click_time", this.mClickTime));
        localIntent.putExtra("web_url_switch", getIntent().getIntExtra("web_url_switch", 0));
        localIntent.putExtra("jump_from_web", getIntent().getBooleanExtra("jump_from_web", true));
        localIntent.putExtra("icon_text", getIntent().getStringExtra("icon_text"));
        localIntent.putExtra("icon_url", getIntent().getStringExtra("icon_url"));
      }
      localIntent.putExtra("start_time", this.start_time);
      Bundle localBundle = getIntent().getBundleExtra("web_invoke_params");
      localObject = localBundle;
      if (localBundle == null) {
        localObject = new Bundle();
      }
      localIntent.putExtra("web_invoke_params", (Bundle)localObject);
      startActivityForResult(localIntent, 10);
      overridePendingTransition(0, 0);
      this.aJY = true;
      return;
      label607:
      localIntent.putExtra("icon_text", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.bso);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    }
    hideProgress();
    switch (paramInt1)
    {
    default: 
      if (this.aJV) {
        finish();
      }
      break;
    }
    do
    {
      return;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("retdata");
        if (!TextUtils.isEmpty(paramIntent)) {
          QWalletHelper.doQWalletQRCodeRet(this, paramIntent);
        }
      }
      finish();
      return;
      finish();
      return;
      this.aJZ = true;
      switch (paramInt2)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("ScannerActivity", 2, "doOnActivityResult default finish.");
        }
        finish();
        return;
      case 11: 
        finish();
        return;
      case 12: 
        finish();
        overridePendingTransition(0, 0);
        return;
      case 13: 
        paramInt1 = paramIntent.getIntExtra("detectType", 1);
        String str1 = paramIntent.getStringExtra("scannerResult");
        String str2 = paramIntent.getStringExtra("scannerType");
        this.aCI = null;
        if (paramIntent.hasExtra("filePath")) {
          this.aCI = paramIntent.getStringExtra("filePath");
        }
        if (paramInt1 == 2)
        {
          finish();
          return;
        }
        e(paramInt1, str2, str1, 3);
        return;
      }
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnActivityResult RESULT_QR_PHOTO_PATH path: " + paramIntent);
      }
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM = paramIntent;
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKh = true;
    } while (!isResume());
    this.pw.setVisibility(0);
    x(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM, 3, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCN);
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM = null;
    return;
    finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onCreate");
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131560597);
    bwW();
    this.aJZ = false;
    this.aJV = false;
    this.mUiHandler = new Handler(this.c);
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("hansSavedState", false);
      i = bool;
      if (QLog.isColorLevel())
      {
        QLog.d("ScannerActivity", 2, "hansSavedState : " + bool);
        i = bool;
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM)) && (i == 0)) {
        bwX();
      }
      paramBundle = (rwg)this.app.getManager(243);
      if (paramBundle != null) {
        paramBundle.a(getApplicationContext(), this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams);
      }
      rvx.aD(this.app);
      return true;
      if (getIntent().getBooleanExtra("from_+", false)) {
        anot.a(null, "dc00898", "", "", "0X80085A9", "0X80085A9", 0, 0, "", "", "", "");
      } else {
        anot.a(null, "dc00898", "", "", "0X80085AA", "0X80085AA", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from, "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onDestroy mHasARBack:" + this.aJZ + "  mHasStartedAR:" + this.aJY);
    }
    if ((!this.aJY) || (this.aJZ))
    {
      if (admn.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.from))
      {
        localObject = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultData", "");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultType", "");
        sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
      }
      Object localObject = (rwg)this.app.getManager(243);
      if (localObject != null) {
        ((rwg)localObject).bxf();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnDestroy in onScannerDestroy");
      }
    }
    if (this.jdField_a_of_type_Rwf != null)
    {
      this.jdField_a_of_type_Rwf.onDestroy();
      this.jdField_a_of_type_Rwf = null;
    }
    if (this.jdField_a_of_type_Rwc != null)
    {
      this.jdField_a_of_type_Rwc.onDestroy();
      this.jdField_a_of_type_Rwc = null;
    }
    if (this.h != null)
    {
      this.h.dismiss();
      this.h = null;
    }
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
    super.doOnDestroy();
    rvx.cJ(this);
    this.app = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnNewIntent");
    }
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM)) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aKh = true;
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onPause");
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onResume");
    }
    super.doOnResume();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM))
    {
      this.pw.setVisibility(0);
      x(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.bvA, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCN);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.aCM = null;
    }
    if ((QLog.isColorLevel()) && (this.aKa) && (this.start_time > 0L))
    {
      QLog.d("ScannerActivity", 2, new Object[] { Long.valueOf(System.currentTimeMillis() - this.start_time) });
      this.aKa = false;
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnSaveInstanceState");
    }
    paramBundle.putBoolean("hansSavedState", true);
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnStop");
    }
    super.doOnStop();
    hideProgress();
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "finish");
    }
    super.finish();
  }
  
  public void hideProgress()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "hideProgress  mProgressShowing:" + this.XM);
    }
    try
    {
      if (this.mUiHandler != null) {
        this.mUiHandler.removeMessages(1);
      }
      if ((this.h != null) && (this.h.isShowing())) {
        this.h.dismiss();
      }
      this.XM = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "startActivity  mHasGetResult:" + this.aJV);
    }
    super.startActivity(paramIntent);
    if (this.aJV) {
      finish();
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "startActivityForResult requestCode:" + paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public static abstract class a
    implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
  {
    public abstract void doCancel();
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      doCancel();
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      doCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */