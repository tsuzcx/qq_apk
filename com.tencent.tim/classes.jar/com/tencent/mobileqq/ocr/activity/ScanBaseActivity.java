package com.tencent.mobileqq.ocr.activity;

import acfp;
import adas;
import adee;
import ades;
import adgy;
import aklr;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arhz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class ScanBaseActivity
  extends FragmentActivity
{
  protected TextView Ws;
  public OcrConfig a;
  public AppInterface app;
  public boolean ctg;
  private arhz h;
  protected TextView mTitleText;
  public QQAppInterface o;
  
  private boolean asd()
  {
    if (this.a == null) {
      this.a = a();
    }
    if (this.a == null)
    {
      QLog.d("ScanBaseActivity", 1, "checkOcrEnable config is null");
      return false;
    }
    boolean bool1 = aklr.ae(this.app.getCurrentAccountUin(), 0);
    if (bool1)
    {
      boolean bool2 = adgy.loadNativeLibrary();
      if (!bool2)
      {
        QLog.d("ScanBaseActivity", 1, "checkOcrEnable load so failed!");
        ThreadManager.post(new ScanBaseActivity.1(this), 5, null, false);
      }
      return bool1 & bool2;
    }
    Object localObject = ((adas)this.app.getManager(220)).a(true);
    if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0))
    {
      new ArrayList();
      new ArrayList();
      ArrayList localArrayList = ((ARCommonConfigInfo)localObject).nativeSoResList;
      localObject = ((ARCommonConfigInfo)localObject).nativeSoResList;
      ades localades = new ades(this.o);
      if (!adee.adM()) {
        localades.a(localArrayList, (ArrayList)localObject, "arcloud");
      }
    }
    return bool1;
  }
  
  public OcrConfig a()
  {
    OcrConfig localOcrConfig = null;
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      localOcrConfig = (OcrConfig)((Bundle)localObject).get("key_ocr_config");
    }
    localObject = localOcrConfig;
    if (localOcrConfig == null)
    {
      localObject = localOcrConfig;
      if ((this.app instanceof QQAppInterface)) {
        localObject = ((aklr)this.app.getManager(228)).a(false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "getOcrConfig:" + localObject);
    }
    return localObject;
  }
  
  public void dCl() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    boolean bool = asd();
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "checkOcrEnable:" + bool);
    }
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
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public String getModuleId()
  {
    if ("ScanTorchActivity".equals(getClass().getSimpleName())) {
      return "module_olympic";
    }
    return super.getModuleId();
  }
  
  public void tP()
  {
    this.Ws = ((TextView)findViewById(2131369579));
    this.mTitleText = ((TextView)findViewById(2131369627));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(this);
      View localView = findViewById(2131379786);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localView.setLayoutParams(localLayoutParams);
    }
    if (AppSetting.enableTalkBack) {
      findViewById(2131369579).setContentDescription(acfp.m(2131713994));
    }
  }
  
  public void updateAppRuntime()
  {
    this.o = ((QQAppInterface)getAppRuntime());
    this.app = this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanBaseActivity
 * JD-Core Version:    0.7.0.1
 */