package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import bjz;
import bka;
import bkb;
import bkd;
import bke;
import bkf;
import bkg;
import bkh;
import bki;
import bkj;
import bkk;
import bkl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class SoundAndVibrateActivity
  extends IphoneTitleBarActivity
{
  public static int a;
  public static String a;
  public static int b;
  float jdField_a_of_type_Float;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private TreeMap jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private final int jdField_c_of_type_Int = 1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_d_of_type_Int = 0;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_e_of_type_Int = 1;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int f = 2;
  private final int g = 3;
  private final int h = 4;
  
  static
  {
    jdField_a_of_type_Int = AppSetting.jdField_e_of_type_Int;
    jdField_b_of_type_Int = AppSetting.f;
    jdField_a_of_type_JavaLangString = "user_choose_";
  }
  
  private Uri a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165184);
    case 1: 
      return Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165185);
    case 2: 
      return Settings.System.DEFAULT_NOTIFICATION_URI;
    }
    Object localObject = ThemeUtil.getThemeVoiceRootPath();
    if (localObject != null)
    {
      localObject = new File((String)localObject + File.separatorChar + "message.mp3");
      if (((File)localObject).exists()) {
        return Uri.fromFile((File)localObject);
      }
    }
    return Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165185);
  }
  
  private void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeMap.values().iterator();
    while (localIterator.hasNext())
    {
      bkl localbkl = (bkl)localIterator.next();
      if (localbkl.jdField_a_of_type_Int == paramInt)
      {
        localbkl.jdField_a_of_type_Boolean = true;
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(localbkl.jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      else
      {
        localbkl.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Uri localUri = a(paramInt1);
    a(paramInt1);
    SettingCloneUtil.writeValueForInt(this, this.app.a(), "sound_type", "qqsetting_notify_soundtype_key", paramInt2);
    if (a().booleanValue())
    {
      d();
      a(localUri);
    }
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramInt, 2131165184);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 1: 
      a(paramInt, 2131165185);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 2: 
      a(paramInt, jdField_a_of_type_Int);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    a(paramInt, jdField_b_of_type_Int);
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  private void e()
  {
    if ((this.app.d() != 0) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      f();
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeMap.values().iterator();
      while (localIterator.hasNext())
      {
        bkl localbkl = (bkl)localIterator.next();
        if (2131296391 == localbkl.jdField_a_of_type_Int) {
          localActionSheet.d(localbkl.jdField_a_of_type_JavaLangString);
        } else {
          localActionSheet.a(localbkl.jdField_a_of_type_JavaLangString, localbkl.jdField_a_of_type_Boolean);
        }
      }
      localActionSheet.a(new bkb(this, localActionSheet));
      localActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    }
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void g()
  {
    bkl localbkl1 = new bkl(this, 0, getResources().getString(2131363650), false);
    bkl localbkl2 = new bkl(this, 1, getResources().getString(2131363651), false);
    bkl localbkl3 = new bkl(this, 2, getResources().getString(2131363652), false);
    bkl localbkl4 = new bkl(this, 3, getResources().getString(2131363653), false);
    bkl localbkl5 = new bkl(this, 2131296391, getResources().getString(2131363114), false);
    this.jdField_a_of_type_JavaUtilTreeMap.put(Integer.valueOf(0), localbkl1);
    this.jdField_a_of_type_JavaUtilTreeMap.put(Integer.valueOf(1), localbkl2);
    this.jdField_a_of_type_JavaUtilTreeMap.put(Integer.valueOf(2), localbkl3);
    this.jdField_a_of_type_JavaUtilTreeMap.put(Integer.valueOf(3), localbkl4);
    this.jdField_a_of_type_JavaUtilTreeMap.put(Integer.valueOf(4), localbkl5);
  }
  
  public Boolean a()
  {
    if ((!this.app.k()) && (!this.app.l()) && (this.app.m()) && ((this.app.a() == null) || (!this.app.a().e()))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void a(Uri paramUri)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      if (paramUri.getScheme().equals("file"))
      {
        paramUri = new FileInputStream(new File(paramUri.getPath()));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUri.getFD());
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        paramUri.close();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        return;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      }
      return;
    }
    catch (Exception paramUri) {}
  }
  
  public void a(SoundAndVibrateActivity.SoundStyle paramSoundStyle)
  {
    switch (bkc.a[paramSoundStyle.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363650) + getString(2131364358));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363651) + getString(2131364359));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363652) + getString(2131364359));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363653) + getString(2131364359));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363650) + getString(2131364359));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363651) + getString(2131364358));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363652) + getString(2131364359));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363653) + getString(2131364359));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363650) + getString(2131364359));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363651) + getString(2131364359));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363652) + getString(2131364358));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363653) + getString(2131364359));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363650) + getString(2131364359));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363651) + getString(2131364359));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363652) + getString(2131364359));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363653) + getString(2131364358));
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.a());
    int j = this.app.d();
    int k = this.app.e();
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298780));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298781));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298784));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298786));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298787));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298782));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298788));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298785));
    Object localObject = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131363645));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131363648));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131363646));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131363647));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298789);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298792));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298791));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298794));
      g();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298793));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298783));
      if (k == 0) {
        break label913;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (this.app.c() != 0) {
        break label902;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label357:
      if (j == 0) {
        break label1179;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      i = SettingCloneUtil.readValueForInt(this, this.app.a(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
      if ((!localSharedPreferences.getBoolean(jdField_a_of_type_JavaLangString + this.app.a(), false)) && (i == jdField_b_of_type_Int))
      {
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putBoolean(jdField_a_of_type_JavaLangString + this.app.a(), true);
        ((SharedPreferences.Editor)localObject).commit();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (i != 2131165184) {
        break label933;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363650) + getString(2131364358));
      label589:
      if (this.app.b() != 0) {
        break label1145;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label607:
      localObject = ThemeUtil.getUserCurrentThemeId(this.app);
      if (((String)localObject).equals("1000")) {
        break label1250;
      }
      localObject = ThemeUtil.getThemeInfo(this, (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
        break label1250;
      }
    }
    label699:
    label1217:
    label1238:
    label1250:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (localSharedPreferences.getBoolean("theme_voice_setting_" + this.app.a(), true))
        {
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new bjz(this));
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new bkd(this));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new bke(this));
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new bkf(this));
          if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1217;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bkg(this));
          if (!this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break label1238;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bkh(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bki(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bkj(this));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bkk(this, localSharedPreferences));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new bka(this));
        return;
        i = 8;
        break;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label357;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label357;
        if (i == 2131165185)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
          a(1);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363651) + getString(2131364358));
          break label589;
        }
        if (i == jdField_a_of_type_Int)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
          a(2);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363652) + getString(2131364358));
          break label589;
        }
        if (i == jdField_b_of_type_Int)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
          a(3);
          SettingCloneUtil.writeValueForInt(this, this.app.a(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
          break label589;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130839426));
        a(1);
        break label589;
        label1145:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label607;
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break label699;
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label699;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break label699;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label785;
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903638);
    setTitle(2131363643);
    c();
    return false;
  }
  
  protected void doOnDestroy()
  {
    d();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */