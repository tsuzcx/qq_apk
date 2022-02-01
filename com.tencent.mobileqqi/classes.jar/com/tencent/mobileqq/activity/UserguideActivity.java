package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qquserguide.UserguideFragment;
import com.tencent.mobileqq.activity.qquserguide.UserguideVideoFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class UserguideActivity
  extends AppActivity
{
  public static final String a = "UserGuide";
  static boolean jdField_b_of_type_Boolean = false;
  static boolean e = false;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  UserguideFragment jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean c;
  boolean d;
  
  public static boolean a(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("qq_version", null);
    if (!"6604".equals(paramContext)) {}
    for (e = true;; e = false)
    {
      if (jdField_b_of_type_Boolean) {
        e = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UserGuide", 2, "sIsUserguidShowed: " + e + " old qqversion = " + paramContext + " new qqversion = " + "6604" + "isNeed " + e);
      }
      e = false;
      return e;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return e;
  }
  
  public void a()
  {
    Intent localIntent;
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 0);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent = new Intent(this, LoginActivity.class);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    long l = System.currentTimeMillis();
    this.c = true;
    super.doOnCreate(paramBundle);
    setContentView(2130903650);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("userguide_type", 1);
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment = new UserguideVideoFragment(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.a(null);
    paramBundle = (FrameLayout)findViewById(2131233235);
    try
    {
      paramBundle.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.a(getLayoutInflater(), paramBundle, null));
      if ("MI-ONE C1".equals(Build.MODEL))
      {
        finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.b(null);
    if (QLog.isDevelopLevel()) {
      QLog.d("userguide", 4, "pic_onCreateTime = " + (System.currentTimeMillis() - l));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.c();
    e = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment = null;
    this.mRuntime = null;
    System.gc();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.a();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.a();
    hideActionBar();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.d();
      this.c = false;
    }
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void finish()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQquserguideUserguideFragment.e();
    a();
    e = false;
    super.finish();
    BaseApplicationImpl.d += SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    this.d = true;
    super.onLogout(paramLogoutReason);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideActivity
 * JD-Core Version:    0.7.0.1
 */