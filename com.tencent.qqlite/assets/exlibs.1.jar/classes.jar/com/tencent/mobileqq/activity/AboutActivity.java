package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;
import ux;
import uy;
import uz;
import va;
import vb;

public class AboutActivity
  extends IphoneTitleBarActivity
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new va(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_a_of_type_JavaLangString = "http://mobile.qq.com/android/";
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString = "http://ti.qq.com/agreement/index.html";
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_c_of_type_JavaLangString = "http://ti.3g.qq.com/g/s?aid=h&hu=MobileQQ";
  private FormSimpleItem d;
  private FormSimpleItem e;
  
  private void a(AboutConfig paramAboutConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已是最新版本");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("有新版本可用");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839373));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new uy(this));
  }
  
  private void a(AboutConfig paramAboutConfig, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130839373));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new uz(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    setContentView(2130903040);
    setTitle(2131363815);
    paramBundle = this.app.a();
    Object localObject = (TextView)findViewById(2131296421);
    ((TextView)localObject).setText("V 3.3.0.544");
    ((TextView)localObject).setFocusable(true);
    ((TextView)localObject).setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296434));
    localObject = new SpannableString(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new vb(this, this.jdField_a_of_type_JavaLangString), 0, this.jdField_a_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296435));
    localObject = new SpannableString(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new vb(this, this.jdField_b_of_type_JavaLangString), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    findViewById(2131296433).setFocusable(true);
    findViewById(2131296433).setFocusableInTouchMode(true);
    findViewById(2131296437).setFocusable(true);
    findViewById(2131296437).setFocusableInTouchMode(true);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296436));
    localObject = new SpannableString(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new vb(this, this.jdField_c_of_type_JavaLangString + "&sid=" + this.app.getSid()), 0, this.jdField_c_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296423));
    a(paramBundle);
    localObject = paramBundle.a("com.tx.aboutfunction");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296425));
    if (localObject != null)
    {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      localObject = paramBundle.a("com.tx.aboutimage");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296427));
      if (localObject == null) {
        break label965;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      label458:
      localObject = paramBundle.a("com.tx.abouthelp");
      this.d = ((FormSimpleItem)findViewById(2131296431));
      if (localObject == null) {
        break label977;
      }
      a(paramBundle, (ResourcePluginInfo)localObject, this.d);
    }
    for (;;)
    {
      this.e = ((FormSimpleItem)findViewById(2131296429));
      this.e.setVisibility(0);
      this.e.setOnClickListener(new ux(this));
      paramBundle = "appid: " + String.valueOf(AppSetting.a) + "\n";
      paramBundle = paramBundle + "LC: D5FF4A21E905B75B\n";
      paramBundle = paramBundle + "buildNum: 544\n";
      paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
      paramBundle = paramBundle + "subVersion: 3.3.0\n";
      paramBundle = paramBundle + "productID: 130\n";
      paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
      paramBundle = paramBundle + "supVersion: 2013\n";
      paramBundle = paramBundle + "revision: 107392\n";
      paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
      paramBundle = paramBundle + "reportVersionName: 3.3.0.544\n";
      paramBundle = paramBundle + "aboutSubVersionName: V 3.3.0.544\n";
      paramBundle = paramBundle + "aboutSubVersionLog: 3.3.0.544.2015-07-08.r107392.YingYongBao\n";
      paramBundle = paramBundle + "isPublicVersion: true\n";
      paramBundle = paramBundle + "versioncode: " + ApkUtils.a(this) + "\n";
      paramBundle = paramBundle + "amem: " + DeviceInfoUtil.d() / 1024L / 1024L + "\n";
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, paramBundle);
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label965:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break label458;
      label977:
      this.d.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_b_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_c_of_type_AndroidWidgetTextView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */