package com.tencent.mobileqq.activity;

import accz;
import acej;
import acfp;
import aciu;
import aehl;
import aewh;
import aizo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqap;
import aqcx;
import aqfe;
import aqgz;
import avpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import protocol.KQQConfig.UpgradeInfo;
import ubv;
import ubw;
import ubx;
import uby;
import ubz;
import uca;
import ucb;

public class AboutActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView By;
  private TextView Bz;
  private UpgradeDetailWrapper a;
  private String aKw = "https://office.qq.com";
  private String aKx = "https://ti.qq.com/tim/serverinfo.html";
  private String aKy = "https://tim.qq.com/timapp/agreement/tim_privacy_guid_ios.html";
  private accz b = new ucb(this);
  private FormSimpleItem e;
  private FormSimpleItem f;
  private FormSimpleItem g;
  private FormSimpleItem h;
  private FormSimpleItem i;
  private RedTouch jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch;
  private FormSimpleItem jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem k;
  
  private void a(aehl paramaehl)
  {
    this.e.setVisibility(0);
    this.e.setBgType(1);
    this.f.setBgType(2);
    this.e.setRightIcon(null);
    if ((this.a == null) || (this.a.a == null))
    {
      this.e.setRightText("");
      this.e.setOnClickListener(null);
      return;
    }
    int m = this.a.a.iUpgradeType;
    if (m == 0)
    {
      paramaehl = (aizo)this.app.getManager(244);
      if (paramaehl.aqc())
      {
        this.e.showArrow(true);
        this.e.setLeftText(paramaehl.mTitle.toString());
        this.e.setRightText(paramaehl.mSubTitle.toString());
        this.e.setRightIcon(getResources().getDrawable(2130851403));
        this.e.setOnClickListener(new ubx(this, paramaehl));
        anot.a(this.app, "CliOper", "", "", "0X800865B", "0X800865B", 0, 0, "", "", "", "");
        return;
      }
      this.e.setRightText(acfp.m(2131701962));
      this.e.showArrow(false);
      this.e.setRightIcon(null);
      this.e.setOnClickListener(null);
      return;
    }
    this.e.showArrow(true);
    this.e.setRightText(acfp.m(2131701963));
    this.e.setRightIcon(getResources().getDrawable(2130851403));
    if (m == 3)
    {
      this.e.setOnClickListener(new uby(this));
      return;
    }
    this.e.setOnClickListener(new ubz(this));
  }
  
  private void a(aehl paramaehl, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130851403));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new uca(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  public static String getCurrentUin()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  public static String oJ()
  {
    return aqfe.get(BaseApplication.getContext(), "ark_brand_state_" + getCurrentUin()).toString();
  }
  
  public static void zF(int paramInt)
  {
    aqfe.J(BaseApplication.getContext(), "ark_brand_state_" + getCurrentUin(), String.valueOf(paramInt));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.b);
    this.a = aqap.a().b();
    super.setContentView(2131558428);
    setTitle(2131689595);
    paramBundle = this.app.a();
    ((TextView)findViewById(2131378903)).setText(AppSetting.nT());
    this.Bz = ((TextView)findViewById(2131381387));
    int m = this.Bz.getPaint().getFlags();
    this.Bz.getPaint().setFlags(m | 0x8);
    this.Bz.setTextColor(-14782465);
    this.Bz.setOnClickListener(this);
    this.By = ((TextView)findViewById(2131373604));
    m = this.By.getPaint().getFlags();
    this.By.getPaint().setFlags(m | 0x8);
    this.By.setTextColor(-14782465);
    this.By.setOnClickListener(this);
    this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.By).a(53).a();
    if (aciu.ix(1)) {
      aciu.b(this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch);
    }
    this.e = ((FormSimpleItem)findViewById(2131381301));
    Object localObject = paramBundle.a("com.tx.aboutfunction_8_0_3");
    this.f = ((FormSimpleItem)findViewById(2131369354));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.f);
      a(paramBundle);
      this.g = ((FormSimpleItem)findViewById(2131372615));
      this.g.setOnClickListener(new ubv(this));
      this.g.setVisibility(0);
      localObject = paramBundle.a("tim.tx.yinsi");
      this.h = ((FormSimpleItem)findViewById(2131369122));
      if (localObject == null) {
        break label1341;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.h);
      label350:
      localObject = paramBundle.a("tim.tx.android.feedback");
      this.i = ((FormSimpleItem)findViewById(2131366979));
      if (localObject == null) {
        break label1353;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.i);
      label389:
      localObject = paramBundle.a("tim.tx.help");
      this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131368501));
      if (localObject == null) {
        break label1365;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem);
    }
    for (;;)
    {
      this.k = ((FormSimpleItem)findViewById(2131365796));
      this.k.setVisibility(8);
      this.k.setOnClickListener(new ubw(this));
      m = aqgz.getDispalyDpi();
      float f1 = acej.aV();
      if ((m <= 160) || (f1 > 16.0F))
      {
        paramBundle = (ImageView)findViewById(2131363717);
        localObject = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
        if (m <= 160) {
          ((LinearLayout.LayoutParams)localObject).topMargin -= aqcx.dip2px(this, 5.0F);
        }
        ((LinearLayout.LayoutParams)localObject).topMargin -= aqcx.dip2px(this, (f1 - 16.0F) * 4.0F);
        if (((LinearLayout.LayoutParams)localObject).topMargin <= 0) {
          ((LinearLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this, 1.0F);
        }
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = "appid: " + String.valueOf(AppSetting.getAppId()) + "\n";
        paramBundle = paramBundle + "LC: " + AppSetting.getLC() + "\n";
        paramBundle = paramBundle + "buildNum: 3058\n";
        paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
        paramBundle = paramBundle + "isPublicVersion: true\n";
        paramBundle = paramBundle + "isGrayVersion: false\n";
        paramBundle = paramBundle + "subVersion: 3.4.4\n";
        paramBundle = paramBundle + "productID: 130\n";
        paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
        paramBundle = paramBundle + "supVersion: 2013\n";
        paramBundle = paramBundle + "revision: 1d5677cf\n";
        paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
        paramBundle = paramBundle + "reportVersionName: 3.4.4.3058\n";
        paramBundle = paramBundle + "aboutSubVersionName: " + AppSetting.nT() + "\n";
        paramBundle = paramBundle + "aboutSubVersionLog: " + AppSetting.nU() + "\n";
        paramBundle = paramBundle + "versioncode: " + aewh.getVersionCode(this) + "\n";
        paramBundle = paramBundle + "amem: " + aqgz.getSystemAvaialbeMemory() / 1024L / 1024L + "\n";
        paramBundle = paramBundle + "qua: " + avpq.getQUA3() + "\n";
        paramBundle = paramBundle + "qua_mm: " + avpq.getVersionForHabo() + "\n";
        paramBundle = paramBundle + "qua_pic: " + avpq.Ga() + "\n";
        paramBundle = paramBundle + "ciBuildTime\n";
        paramBundle = paramBundle + "APP_ID: " + AppSetting.getAppId() + "\n";
        paramBundle = paramBundle + "NOW: 2021-11-22\n";
        paramBundle = paramBundle + "richstatus: rich_status_android\n";
        paramBundle = paramBundle + "versionBuiltIn: 65\n";
        paramBundle = paramBundle + "64bit: false\n";
        QLog.d("script", 2, paramBundle + "model: " + Build.MODEL + "\n");
      }
      return true;
      this.f.setVisibility(8);
      break;
      label1341:
      this.h.setVisibility(8);
      break label350;
      label1353:
      this.i.setVisibility(8);
      break label389;
      label1365:
      this.jdField_j_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.b);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.By.invalidate();
    this.Bz.invalidate();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      startActivity(localIntent.putExtra("url", this.aKx));
      anot.a(this.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
      continue;
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      startActivity(localIntent.putExtra("url", this.aKy));
      this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch.dGB();
      aciu.Ew("1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */