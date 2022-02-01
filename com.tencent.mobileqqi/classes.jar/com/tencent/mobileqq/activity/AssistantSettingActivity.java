package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import buz;
import bva;
import bvb;
import bvc;
import bvd;
import bve;
import bvf;
import bvg;
import bvh;
import bvi;
import bvj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PreDownloadStrategyAlpha;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
{
  public static int a = 0;
  public static final String a = "setting_aio_realtime_bg_open";
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 1000;
  static final int jdField_d_of_type_Int = 0;
  static final int jdField_e_of_type_Int = 1;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString = "";
  private View jdField_c_of_type_AndroidViewView;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bvc(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231140));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231141));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231145));
    this.d = ((FormSwitchItem)findViewById(2131231146));
    this.h = ((FormSwitchItem)findViewById(2131231147));
    this.e = ((FormSwitchItem)findViewById(2131231143));
    this.f = ((FormSwitchItem)findViewById(2131231142));
    this.g = ((FormSwitchItem)findViewById(2131231144));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231138);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231137);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131231139);
    if (PredownloadTest.a) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (PreDownloadStrategyAlpha.c == 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (!MagicfaceViewController.a()) {
        break label627;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      SettingCloneUtil.readValue(this, null, getString(2131563437), "qqsetting_screenshot_key", false);
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131563451), "qqsetting_auto_receive_pic_key", true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new buz(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563451), "qqsetting_auto_receive_magic_face_key", true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bvd(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563454), "qqsetting_enter_sendmsg_key", false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bve(this));
      bool = SettingCloneUtil.readValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_all_contacts_key", false);
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new bvf(this));
      bool = SettingCloneUtil.readValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_msg_lockscreen_key", true);
      this.h.setChecked(bool);
      this.h.setOnCheckedChangeListener(new bvg(this));
      this.f.setVisibility(8);
      bool = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).getBoolean("setting_aio_realtime_bg_open" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
      this.e.setChecked(bool);
      this.e.setOnCheckedChangeListener(new bvh(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563455), "qqsetting_notify_icon_key", false);
      this.g.setChecked(bool);
      this.g.setOnCheckedChangeListener(new bvi(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bvj(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new bva(this));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new bvb(this));
      this.jdField_a_of_type_AndroidViewView.setContentDescription("流量统计");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("2G/3G/4G下自动接收图片");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("回车键发送消息");
      this.f.setContentDescription("WiFi下自动在后台下载新版本");
      this.d.setContentDescription("联系人列表按字母排列");
      this.g.setContentDescription("系统通知栏显示QQ图标");
      this.h.setContentDescription("锁屏界面显示未读消息提醒");
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break;
      label627:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
  }
  
  protected String a_()
  {
    return getString(2131562380);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903094);
    setTitle(2131562380);
    this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    setVolumeControlStream(3);
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131561702));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */