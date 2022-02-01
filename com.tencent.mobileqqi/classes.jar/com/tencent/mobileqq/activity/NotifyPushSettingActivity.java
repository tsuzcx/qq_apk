package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import cyd;
import cye;
import cyf;
import cyg;
import cyh;
import cyi;
import cyj;
import cyk;
import cyl;
import cym;
import cyn;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  public static final String b = "click_notifylight_count";
  public static final String c = "LED_light";
  private View jdField_a_of_type_AndroidViewView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String a;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  
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
    return paramContext.getSharedPreferences("mobileQQi", 0).getInt(paramString1, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("mobileQQi", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new cyf(paramQQAppInterface, paramString));
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "click_notifylight_count");
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQi", 0).getInt(paramString1, 0);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "click_notifylight_count");
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, "LED_light", paramInt);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232002);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231995));
    this.g = ((FormSwitchItem)findViewById(2131232000));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231994);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231997));
    this.c = ((FormSwitchItem)findViewById(2131231998));
    this.d = ((FormSwitchItem)findViewById(2131231999));
    this.e = ((FormSwitchItem)findViewById(2131231996));
    this.f = ((FormSwitchItem)findViewById(2131232003));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131232001));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new cyd(this));
    if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("spcial_care_qq_setting", true)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840212));
    }
    boolean bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131563458), "qqsetting_notify_showcontent_key", true);
    boolean bool2 = SettingCloneUtil.readValue(this, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
    boolean bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131562526), "qqsetting_notify_blncontrol_key", true);
    boolean bool4 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131563461), "qqsetting_notify_myfeedpush_key", true);
    boolean bool5 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131561654), "qqsetting_receivemsg_whenexit_key", true);
    boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131562309), "qqsetting_lock_screen_whenexit_key", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cyg(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
    this.g.setChecked(bool2);
    this.g.setOnCheckedChangeListener(new cyh(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cyi(this));
    this.c.setChecked(bool4);
    this.c.setOnCheckedChangeListener(new cyj(this));
    this.d.setChecked(bool5);
    this.d.setOnCheckedChangeListener(new cyk(this));
    this.e.setChecked(bool6);
    if (bool1) {
      this.e.setVisibility(0);
    }
    for (;;)
    {
      this.e.setOnCheckedChangeListener(new cyl(this));
      this.e.setContentDescription("锁屏显示消息弹框");
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new cym(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new cyn(this));
      bool1 = QZoneShareAlbumAssistantManager.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.f.setChecked(bool1);
      this.f.setOnCheckedChangeListener(new cye(this));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("声音");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知时指示灯闪烁");
      this.c.setContentDescription("与我相关的动态");
      this.d.setContentDescription("通知内显示消息内容");
      this.f.setContentDescription("消息列表显示共享相册助手");
      this.g.setContentDescription("夜间防骚扰模式");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("特别关心");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("群消息设置");
      return;
      this.e.setVisibility(8);
    }
  }
  
  protected String a_()
  {
    return getString(2131562523);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903295);
    setTitle(2131562523);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    d();
  }
  
  public void onPause()
  {
    super.onPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */