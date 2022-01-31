package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import azz;
import baa;
import bab;
import bac;
import bad;
import bae;
import baf;
import bag;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  public static final String b = "click_notifylight_count";
  public static final String c = "LED_light";
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String a;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  
  public NotifyPushSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "click_notifylight_count");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("QQLite", 0).getInt(paramString1, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("QQLite", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("QQLite", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("QQLite", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("QQLite", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new bag(paramQQAppInterface, paramString));
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "click_notifylight_count");
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("QQLite", 0).getInt(paramString1, 0);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "click_notifylight_count");
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, "LED_light", paramInt);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297375);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297370));
    this.e = ((FormSwitchItem)findViewById(2131297374));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297369);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297372));
    this.c = ((FormSwitchItem)findViewById(2131297373));
    this.d = ((FormSwitchItem)findViewById(2131297371));
    boolean bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131363278), "qqsetting_notify_showcontent_key", true);
    boolean bool2 = SettingCloneUtil.readValue(this, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
    boolean bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131363279), "qqsetting_notify_blncontrol_key", true);
    boolean bool4 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131363744), "qqsetting_receivemsg_whenexit_key", true);
    boolean bool5 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131363745), "qqsetting_lock_screen_whenexit_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new azz(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
    this.e.setChecked(bool2);
    this.e.setOnCheckedChangeListener(new baa(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bab(this));
    this.c.setChecked(bool4);
    this.c.setOnCheckedChangeListener(new bac(this));
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    this.d.setChecked(bool5);
    if (bool1) {
      this.d.setVisibility(0);
    }
    for (;;)
    {
      this.d.setOnCheckedChangeListener(new bad(this));
      this.d.setContentDescription("锁屏显示消息弹框");
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bae(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new baf(this));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("声音");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知时指示灯闪烁");
      this.c.setContentDescription("退出后仍接收消息通知");
      this.e.setContentDescription("夜间防骚扰模式");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("群消息设置");
      return;
      this.d.setVisibility(8);
    }
  }
  
  protected String a_()
  {
    return getString(2131363253);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903249);
    setTitle(2131363253);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.a();
    }
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.app != null) {}
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.app.a().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public int getPathNodeID()
  {
    return 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */