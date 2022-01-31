package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.FakeImageView;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import ezh;
import mqq.app.BaseActivity;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  private static final int jdField_a_of_type_Int = 2;
  public static BaseActivity2 a;
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean;
  public static final String g;
  static boolean h;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  protected int e = 0;
  public boolean f = true;
  protected boolean g;
  public String h;
  
  static
  {
    jdField_g_of_type_JavaLangString = BaseActivity2.class.getSimpleName();
    jdField_h_of_type_Boolean = true;
  }
  
  public BaseActivity2()
  {
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
        new ezh(this).start();
      }
    }
    while (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
      return;
    }
    ((SensorManager)getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqAppShakeListener);
    jdField_a_of_type_ComTencentMobileqqAppShakeListener = null;
  }
  
  private boolean a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while (((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) || ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.PICK"))));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
    }
  }
  
  private void d()
  {
    try
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeButtonEnabled(true);
        localActionBar.setDisplayHomeAsUpEnabled(true);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.e);
    }
  }
  
  public View findViewById(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.findViewById(paramInt);
    case 2131231456: 
      localObject = new FakeTextView(this);
      ((TextView)localObject).setId(2131231456);
      return localObject;
    case 2131231457: 
      localObject = new FakeTextView(this);
      ((TextView)localObject).setId(2131231457);
      return localObject;
    case 2131231376: 
      localObject = new FakeTextView(this);
      ((TextView)localObject).setId(2131231376);
      return localObject;
    case 2131231380: 
      localObject = new FakeTextView(this);
      ((TextView)localObject).setId(2131231380);
      return localObject;
    }
    Object localObject = new FakeImageView(this);
    ((ImageView)localObject).setId(2131231461);
    return localObject;
  }
  
  public void onBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_g_of_type_JavaLangString, 2, Log.getStackTraceString(localThrowable));
      }
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    LocaleUtil.a(getBaseContext(), LocaleUtil.b(getApplicationContext()));
    paramBundle = BaseApplicationImpl.a;
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      this.jdField_h_of_type_JavaLangString = paramBundle.getSharedPreferences("Last_Login", i).getString("uin", null);
      if ((this.jdField_h_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
        QLog.d(jdField_g_of_type_JavaLangString, 1, "last uin is null.. has porblem?");
      }
      StatisticCollector.a(this).c(this);
      if (InitSkin.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
      }
      paramBundle = getIntent().getExtras();
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fling_action_key");
        if ((i != 0) && (a())) {
          if (1 != i) {
            break label266;
          }
        }
      }
    }
    label266:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);; this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this))
    {
      if (!jdField_a_of_type_Boolean)
      {
        if (SettingCloneUtil.readValue(this, null, getString(2131563437), "qqsetting_screenshot_key", false)) {
          a(true);
        }
        jdField_a_of_type_Boolean = true;
      }
      d();
      return;
      i = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    StatisticCollector.a(this).f(this);
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onPause");
    }
    this.f = true;
    StatisticCollector.a(this).e(this);
    c();
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume ");
    }
    this.f = false;
    StatisticCollector.a(this).d(this);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = this;
    SharedPreferences.Editor localEditor = getSharedPreferences("screen_shot", 0).edit();
    localEditor.putString("currentactivity", getClass().getName());
    if (Build.VERSION.SDK_INT > 8)
    {
      localEditor.apply();
      jdField_h_of_type_Boolean = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_g_of_type_JavaLangString, 4, "onResume.mAppForground = " + jdField_h_of_type_Boolean + ",mCanLock=" + this.jdField_g_of_type_Boolean);
      }
      if ((jdField_h_of_type_Boolean) || (!this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_JavaLangString == null) || (!GesturePWDUtils.getJumpLock(this, this.jdField_h_of_type_JavaLangString))) {
        break label247;
      }
      a();
    }
    for (;;)
    {
      if (!jdField_h_of_type_Boolean)
      {
        jdField_h_of_type_Boolean = true;
        GesturePWDUtils.setAppForground(this, jdField_h_of_type_Boolean);
      }
      this.e = 0;
      this.jdField_g_of_type_Boolean = true;
      return;
      localEditor.commit();
      break;
      label247:
      if ((!jdField_h_of_type_Boolean) && (this.jdField_g_of_type_Boolean)) {
        b();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStart");
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStop");
    }
    this.e = 1;
    jdField_h_of_type_Boolean = GesturePWDUtils.isAppOnForeground(this);
    if (!jdField_h_of_type_Boolean) {
      GesturePWDUtils.setAppForground(this, jdField_h_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.e = 2;
    if (a(paramIntent)) {
      this.jdField_g_of_type_Boolean = false;
    }
    switch (2)
    {
    }
    try
    {
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(jdField_g_of_type_JavaLangString, 2, "startActivity failed with: ", paramIntent);
      return;
      paramIntent.putExtra("fling_action_key", 2);
      paramIntent.putExtra("fling_code_key", hashCode());
      super.startActivityForResult(paramIntent, paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */