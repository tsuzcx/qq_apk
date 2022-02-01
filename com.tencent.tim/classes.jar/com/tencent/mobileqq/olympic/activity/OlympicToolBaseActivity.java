package com.tencent.mobileqq.olympic.activity;

import acfp;
import akqo;
import akqp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import arhz;
import auru;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class OlympicToolBaseActivity
  extends AbsBaseWebViewActivity
{
  public static boolean aJX = true;
  public ARScanAR a;
  public OcrConfig a;
  public ScannerResultReceiver a;
  private boolean aJW;
  public AppInterface app;
  public OlympicToolAppInterface c;
  private int cFG;
  public boolean ctg;
  private boolean cuh;
  private arhz h;
  private Handler.Callback i = new akqp(this);
  private long mClickTime;
  private View.OnClickListener mOnClickListener = new akqo(this);
  public QQAppInterface o;
  private auru p;
  
  private void abe()
  {
    if (this.cuh) {}
    do
    {
      return;
      try
      {
        if (this.h == null)
        {
          this.h = new arhz(this, getTitleBarHeight());
          this.h.setMessage(acfp.m(2131709363));
          this.h.setBackAndSearchFilter(false);
        }
        this.cuh = true;
        this.h.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("ScanBaseActivity", 2, "");
  }
  
  private void bwX()
  {
    this.mClickTime = System.currentTimeMillis();
    this.aJW = NearbyFakeActivity.arr();
    this.p.removeMessages(0);
    if (this.aJW)
    {
      dCl();
      return;
    }
    this.ctg = true;
    abe();
    dCY();
    this.p.sendEmptyMessageDelayed(0, 5000L);
  }
  
  private void dCY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "sendBroadcastToToolProc");
    }
    Intent localIntent = new Intent(this, NearbyReceiver.class);
    localIntent.putExtra("resultreceiver_nearbyfakeactivity", this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver);
    localIntent.setExtrasClassLoader(getClassLoader());
    try
    {
      sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ScanBaseActivity", 2, new Object[] { "sendBroadcastToToolProc, exception=", localThrowable.getMessage(), localThrowable });
    }
  }
  
  private void hideProgress()
  {
    try
    {
      if ((this.h != null) && (this.h.isShowing())) {
        this.h.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanBaseActivity", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void dCU()
  {
    if (this.cFG != 2) {
      dCW();
    }
  }
  
  public void dCV()
  {
    if (this.cFG != 0) {
      bwX();
    }
  }
  
  public void dCW()
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.addFlags(67108864);
    if (this.cFG == 0)
    {
      localIntent.putExtra("from", ScanTorchActivity.class.getSimpleName());
      localIntent.putExtra("forbidGuideBubble", true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanAR != null) {
        localIntent.putExtra("key_ar_config", this.jdField_a_of_type_ComTencentMobileqqArARScanAR);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
        localIntent.putExtra("key_ocr_config", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
      }
      startActivity(localIntent);
      overridePendingTransition(0, 0);
      finish();
      return;
      if (this.cFG == 1) {
        localIntent.putExtra("from", ScanOcrActivity.class.getSimpleName());
      }
    }
  }
  
  public void dCX() {}
  
  public void dCl()
  {
    this.ctg = false;
    this.p.removeMessages(0);
    hideProgress();
    Intent localIntent = new Intent(this, ScanTorchActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.addFlags(65536);
    localIntent.putExtra("click_time", this.mClickTime);
    localIntent.putExtra("first_click", aJX);
    localIntent.putExtra("proc_exist", this.aJW);
    localIntent.putExtra("software", getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
    aJX = false;
    localIntent.putExtra("log_on", ScanTorchActivity.cul);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.bso)) {
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
      startActivityForResult(localIntent, 10);
      overridePendingTransition(0, 0);
      finish();
      return;
      localIntent.putExtra("icon_text", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.bso);
    }
  }
  
  public void dCm()
  {
    if (this.cFG != 1) {
      dCX();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.p = new auru(this.i);
    this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver = new ScannerResultReceiver(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.h != null) {
      this.h.dismiss();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicScannerResultReceiver.a(this);
    }
  }
  
  public String getModuleId()
  {
    if ("ScanTorchActivity".equals(getClass().getSimpleName())) {
      return "module_olympic";
    }
    return super.getModuleId();
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      this.o = ((QQAppInterface)localAppRuntime);
      this.app = this.o;
    }
    while (!(localAppRuntime instanceof OlympicToolAppInterface)) {
      return;
    }
    this.c = ((OlympicToolAppInterface)localAppRuntime);
    this.app = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity
 * JD-Core Version:    0.7.0.1
 */