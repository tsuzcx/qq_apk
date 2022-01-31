package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import bxj;
import bxk;
import bxl;
import bxm;
import bxn;
import bxo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "http://www.imqq.com/mobile/privacy/privacy.html?language={language}";
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new bxn(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private Object jdField_a_of_type_JavaLangObject;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public String b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public String c;
  private FormSimpleItem d;
  public String d;
  private FormSimpleItem e;
  private FormSimpleItem f;
  
  public AboutActivity()
  {
    this.jdField_b_of_type_JavaLangString = "http://www.imqq.com/mobile/terms/terms.html?language={language}";
    this.jdField_c_of_type_JavaLangString = "http://www.imqq.com/mobile/privacy/privacy.html?language={language}";
    this.jdField_d_of_type_JavaLangString = "http://www.imqq.com/mobile/mobile-page.html?language={language}";
  }
  
  private void a(AboutConfig paramAboutConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 8) {
        break label190;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
      }
    }
    label190:
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null)
    {
      return;
      int i = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131559026));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131559027));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840210));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new bxl(this));
      break;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
  }
  
  private void a(AboutConfig paramAboutConfig, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp"))
    {
      paramResourcePluginInfo.strGotoUrl = "http://mapp.3g.qq.com/mqq/faq-en/index.jsp?";
      paramResourcePluginInfo.strResName = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562101);
      paramFormSimpleItem.setVisibility(0);
      if (paramResourcePluginInfo.isNew != 0) {
        break label133;
      }
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130840210));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new bxm(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      if (!paramResourcePluginInfo.strPkgName.equals("com.tx.aboutfunction")) {
        break;
      }
      paramResourcePluginInfo.strGotoUrl = "http://mapp.3g.qq.com/mqq/intro-en/index.jsp?";
      paramResourcePluginInfo.strResName = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562103);
      break;
      label133:
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    setContentView(2130903063);
    setTitle(2131561574);
    paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ((TextView)findViewById(2131230959)).setText("V 6.0.0.6500");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230967));
    Object localObject = new SpannableString(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    if (LocaleUtil.a(getApplicationContext()) == 2)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "ch_simple");
      ((SpannableString)localObject).setSpan(new bxo(this, this.jdField_d_of_type_JavaLangString), 0, this.jdField_a_of_type_AndroidWidgetTextView.getText().length(), 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230968));
      localObject = new SpannableString(this.jdField_c_of_type_AndroidWidgetTextView.getText());
      if (LocaleUtil.a(getApplicationContext()) != 2) {
        break label1308;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "ch_simple");
      label219:
      ((SpannableString)localObject).setSpan(new bxo(this, this.jdField_b_of_type_JavaLangString), 0, this.jdField_c_of_type_AndroidWidgetTextView.getText().length(), 17);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230969));
      localObject = new SpannableString(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      if (LocaleUtil.a(getApplicationContext()) != 2) {
        break label1521;
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "ch_simple");
      label323:
      ((SpannableString)localObject).setSpan(new bxo(this, this.jdField_c_of_type_JavaLangString), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 17);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131230960));
      localObject = paramBundle.a("com.tx.aboutfunction");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131230961));
      if (localObject == null) {
        break label1734;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      label421:
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      }
      localObject = paramBundle.a("com.tx.aboutimage");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131230962));
      if (localObject == null) {
        break label1746;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      label482:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      }
      localObject = paramBundle.a("com.tx.abouthelp");
      this.e = ((FormSimpleItem)findViewById(2131230964));
      if (localObject == null) {
        break label1758;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.e);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) && (this.e.getVisibility() == 0)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = this.e;
      }
      this.f = ((FormSimpleItem)findViewById(2131230963));
      this.f.setVisibility(8);
      this.f.setOnClickListener(new bxj(this));
      this.f.setVisibility(8);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) && (this.f.getVisibility() == 0)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = this.f;
      }
      a(paramBundle);
      paramBundle = "appid: " + String.valueOf(AppSetting.a) + "\n";
      paramBundle = paramBundle + "LC: BC1BCBD9F0EEA1C4\n";
      paramBundle = paramBundle + "buildNum: 6500\n";
      paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
      paramBundle = paramBundle + "subVersion: 6.0.0\n";
      paramBundle = paramBundle + "productID: 130\n";
      paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
      paramBundle = paramBundle + "supVersion: 2013\n";
      paramBundle = paramBundle + "revision: 24935\n";
      paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(AppSetting.d) + "\n";
      paramBundle = paramBundle + "reportVersionName: 6.0.0.6500\n";
      paramBundle = paramBundle + "aboutSubVersionName: V 6.0.0.6500\n";
      paramBundle = paramBundle + "aboutSubVersionLog: 6.0.0.6500.2018-05-20.r24935.YingYongBao\n";
      paramBundle = paramBundle + "isPublicVersion: true\n";
      paramBundle = paramBundle + "versioncode: " + ApkUtils.a(this) + "\n";
      paramBundle = paramBundle + "amem: " + DeviceInfoUtil.d() / 1024L / 1024L + "\n";
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, paramBundle);
      }
      findViewById(2131230965).setOnClickListener(new bxk(this));
      return true;
      if (LocaleUtil.a(getApplicationContext()) == 3)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "ch_chT");
        break;
      }
      if (LocaleUtil.a(getApplicationContext()) == 1)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "English");
        break;
      }
      if (LocaleUtil.a(getApplicationContext()) == 4)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "Japanese");
        break;
      }
      if (LocaleUtil.a(getApplicationContext()) == 5)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "Korean");
        break;
      }
      if (LocaleUtil.a(getApplicationContext()) == 6)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "Deutsch");
        break;
      }
      if (LocaleUtil.a(getApplicationContext()) == 7)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "Fran");
        break;
      }
      if (LocaleUtil.a(getApplicationContext()) != 8) {
        break;
      }
      this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("{language}", "Espa");
      break;
      label1308:
      if (LocaleUtil.a(getApplicationContext()) == 3)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "ch_chT");
        break label219;
      }
      if (LocaleUtil.a(getApplicationContext()) == 1)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "English");
        break label219;
      }
      if (LocaleUtil.a(getApplicationContext()) == 4)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "Japanese");
        break label219;
      }
      if (LocaleUtil.a(getApplicationContext()) == 5)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "Korean");
        break label219;
      }
      if (LocaleUtil.a(getApplicationContext()) == 6)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "Deutsch");
        break label219;
      }
      if (LocaleUtil.a(getApplicationContext()) == 7)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "Fran");
        break label219;
      }
      if (LocaleUtil.a(getApplicationContext()) != 8) {
        break label219;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("{language}", "Espa");
      break label219;
      label1521:
      if (LocaleUtil.a(getApplicationContext()) == 3)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "ch_chT");
        break label323;
      }
      if (LocaleUtil.a(getApplicationContext()) == 1)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "English");
        break label323;
      }
      if (LocaleUtil.a(getApplicationContext()) == 4)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "Japanese");
        break label323;
      }
      if (LocaleUtil.a(getApplicationContext()) == 5)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "Korean");
        break label323;
      }
      if (LocaleUtil.a(getApplicationContext()) == 6)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "Deutsch");
        break label323;
      }
      if (LocaleUtil.a(getApplicationContext()) == 7)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "Fran");
        break label323;
      }
      if (LocaleUtil.a(getApplicationContext()) != 8) {
        break label323;
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("{language}", "Espa");
      break label323;
      label1734:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break label421;
      label1746:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break label482;
      label1758:
      this.e.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_c_of_type_AndroidWidgetTextView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */