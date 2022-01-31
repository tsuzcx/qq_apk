package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.mobileqq.widget.FakeImageView;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import ezd;
import eze;
import ezf;
import java.io.File;
import java.lang.reflect.Field;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class BaseActivity
  extends AppActivity
  implements SkinnableActivityProcesser.Callback
{
  public static BaseActivity a;
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean = false;
  protected static final String b_ = "qqBaseActivity";
  static final int c_ = 0;
  public static boolean q = true;
  public static boolean r = false;
  public static boolean s = false;
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  public QQAppInterface b;
  private boolean b;
  public int d_ = 0;
  public boolean p = true;
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          paramIntent.get("1");
          return false;
        }
      }
      catch (Throwable paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
    return true;
  }
  
  private boolean b(Intent paramIntent)
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
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = true;
    if (LocaleUtil.b(getApplicationContext()) != this.jdField_a_of_type_Int)
    {
      this.jdField_b_of_type_Boolean = false;
      e();
    }
  }
  
  private void e()
  {
    finish();
    startActivity(getIntent());
    w_();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
    }
  }
  
  private void g()
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
    catch (Exception localException) {}
  }
  
  public void A()
  {
    Object localObject1 = null;
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (Settings.System.getInt(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver(), "haptic_feedback_enabled", 1) != 1);
        try
        {
          localObject2 = Class.forName("com.android.internal.R$array").getField("config_longPressVibePattern").get(null);
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2;
            int i;
          }
        }
      } while ((localObject1 == null) || (!(localObject1 instanceof Integer)));
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getIntArray(((Integer)localObject1).intValue());
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break;
      }
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getIntArray(2131689493);
    } while ((localObject1 == null) || (localObject1.length <= 0));
    localObject2 = new long[localObject1.length];
    i = 0;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i];
      i += 1;
    }
    ((Vibrator)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("vibrator")).vibrate((long[])localObject2, -1);
  }
  
  public void B()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(a(), GesturePWDUnlockActivity.class));
    s = true;
    new Handler().postDelayed(new eze(this), 1000L);
  }
  
  @Deprecated
  public Activity a()
  {
    return this;
  }
  
  public TransFileController a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.d_ = 2;
    if (b(paramIntent)) {
      this.p = false;
    }
    if (!a(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    String str = paramIntent.getStringExtra("selfSet_leftViewText");
    if (TextUtils.isEmpty(str)) {
      paramIntent.putExtra("leftViewText", a_());
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
      case 0: 
        try
        {
          super.startActivityForResult(paramIntent, paramInt1);
          return;
          paramIntent.putExtra("leftViewText", str);
          paramIntent.removeExtra("selfSet_leftViewText");
          continue;
          super.startActivityForResult(paramIntent, paramInt1);
          return;
        }
        catch (Exception paramIntent)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("qqBaseActivity", 2, "startActivity failed with: ", paramIntent);
          return;
        }
      }
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (FlingAllowProvider.contain(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())))
    {
      paramInt2 = hashCode();
      str = ScreenCapture.getSnapPath(a(), paramInt2);
      if (str != null)
      {
        ScreenCapture.captureViewToFile(str, a().getWindow().getDecorView());
        paramIntent.putExtra("fling_action_key", 1);
        paramIntent.putExtra("fling_code_key", paramInt2);
      }
    }
    super.startActivityForResult(paramIntent, paramInt1);
    return;
    paramInt2 = hashCode();
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBusinessObserver);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String a_()
  {
    return getString(2131561692);
  }
  
  public View b(int paramInt)
  {
    return super.findViewById(paramInt);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(paramBusinessObserver);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public String c_()
  {
    return null;
  }
  
  public void c_() {}
  
  public int d()
  {
    return getResources().getDimensionPixelSize(2131427376);
  }
  
  @SuppressLint({"SdCardPath"})
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((AppSetting.h) && (paramKeyEvent.getAction() == 1))
    {
      if ((paramKeyEvent.getKeyCode() != 24) || (!new File("/mnt/sdcard/skin/res/").isDirectory())) {
        break label77;
      }
      if (SkinEngine.getInstances().getSkinRootPath() == null) {
        break label63;
      }
      SkinEngine.getInstances().setSkinRootPath(this, null);
    }
    for (;;)
    {
      return super.doDispatchKeyEvent(paramKeyEvent);
      label63:
      SkinEngine.getInstances().setSkinRootPath(this, "/mnt/sdcard/skin/res/");
      continue;
      label77:
      if ((paramKeyEvent.getKeyCode() == 25) && (new File("/mnt/sdcard/skin2/res/").isDirectory())) {
        if (SkinEngine.getInstances().getSkinRootPath() != null) {
          SkinEngine.getInstances().setSkinRootPath(this, null);
        } else {
          SkinEngine.getInstances().setSkinRootPath(this, "/mnt/sdcard/skin2/res/", false);
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (!b()) {}
    try
    {
      super.doOnBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, Log.getStackTraceString(localThrowable));
      }
      finish();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onConfigurationChanged(paramConfiguration);
    }
    this.jdField_a_of_type_Int = LocaleUtil.b(getApplicationContext());
    LocaleUtil.a(getBaseContext(), this.jdField_a_of_type_Int);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (a(getIntent()))
    {
      finish();
      return true;
    }
    StatisticCollector.a(this).c(this);
    this.jdField_a_of_type_Int = LocaleUtil.b(getApplicationContext());
    LocaleUtil.a(getBaseContext(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    if ((getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    }
    setVolumeControlStream(3);
    if (!jdField_a_of_type_Boolean)
    {
      if (SettingCloneUtil.readValue(this, null, getString(2131563437), "qqsetting_screenshot_key", false)) {
        y();
      }
      jdField_a_of_type_Boolean = true;
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ezf(this, null);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("fling_action_key");
      if ((i != 0) && (a())) {
        if ((1 != i) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!FlingAllowProvider.contain(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          break label309;
        }
      }
    }
    label309:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);; this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this))
    {
      g();
      return false;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    StatisticCollector.a(this).f(this);
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label132:
      if ((AppSetting.j) && (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.releaseLargeCache();
      }
      if (jdField_a_of_type_ComTencentMobileqqAppBaseActivity == this) {
        jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
      }
      ReflecterHelper.a(this);
      return;
    }
    catch (Exception localException)
    {
      break label132;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    StatisticCollector.a(this).e(this);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((SaveTrafficHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(18)).a(true);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(-1L);
    }
    f();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onPause");
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    StartupTracker.a(null, "AIO_Super_doOnResume_step1");
    super.doOnResume();
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    StatisticCollector.a(this).d(this);
    label91:
    SharedPreferences.Editor localEditor;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((SaveTrafficHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(18)).a(false);
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.i)
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.i = false;
        StatisticCollector.a(this).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else
    {
      StartupTracker.a("AIO_Super_doOnResume_step1", "AIO_Super_doOnResume_step2");
      if (!(this instanceof NotificationActivity)) {
        break label577;
      }
      EquipmentLockImpl.a().b();
      StartupTracker.a("AIO_Super_doOnResume_step2", "AIO_Super_doOnResume_step3");
      localEditor = getSharedPreferences("screen_shot", 0).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label586;
      }
      localEditor.apply();
      label154:
      StartupTracker.a("AIO_Super_doOnResume_step3", "AIO_Super_doOnResume_step4");
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.D();
      }
      StartupTracker.a("AIO_Super_doOnResume_step4", "AIO_Super_doOnResume_step5");
      q = GesturePWDUtils.getAppForground(a());
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume.mAppForground = " + q + ",mCanLock=" + this.p);
      }
      if (((q) && ((!"com.tencent.mobileqqi".equals(BaseApplicationImpl.processName)) || (r))) || (!this.p) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!GesturePWDUtils.getJumpLock(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) || ((a() instanceof GesturePWDUnlockActivity)) || ((a() instanceof InstallActivity)) || ((a() instanceof UserguideActivity)) || ((a() instanceof JumpActivity)) || ((a() instanceof qfileJumpActivity)) || ((a() instanceof LoginActivity))) {
        break label597;
      }
      B();
      label388:
      StartupTracker.a("AIO_Super_doOnResume_step5", "AIO_Super_doOnResume_step6");
      if ((!q) && (!(this instanceof JumpActivity)))
      {
        q = true;
        GesturePWDUtils.setAppForground(a(), q);
      }
      this.d_ = 0;
      this.p = true;
      StartupTracker.a("AIO_Super_doOnResume_step6", "AIO_Super_doOnResume_step7");
      if (BaseApplicationImpl.jdField_a_of_type_Long > 0L)
      {
        long l1 = SystemClock.uptimeMillis();
        if (!(this instanceof SplashActivity)) {
          break label644;
        }
        long l2 = l1 - BaseApplicationImpl.jdField_a_of_type_Long;
        Log.i("AutoMonitor", "ActionLoginA, cost=" + l2);
        StatisticCollector.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actLoginA", true, l2, 0L, null, null);
        if (!NetworkUtil.e(this)) {
          break label637;
        }
        BaseApplicationImpl.jdField_a_of_type_Long = -l1;
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_Super_doOnResume_step7", "AIO_Super_doOnResume_step8");
      if (GuardManager.a != null) {
        GuardManager.a.b(1, c_());
      }
      StartupTracker.a("AIO_Super_doOnResume_step8", null);
      d();
      return;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.i();
      break;
      label577:
      EquipmentLockImpl.a().a();
      break label91;
      label586:
      localEditor.commit();
      break label154;
      label597:
      if ((!q) && (this.p))
      {
        e_();
        break label388;
      }
      if ((q) || (this.p)) {
        break label388;
      }
      r = true;
      break label388;
      label637:
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      continue;
      label644:
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    f();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStart " + BaseApplicationImpl.a().getVisibleActivityCount());
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStop " + BaseApplicationImpl.a().getVisibleActivityCount());
    }
    f();
    this.d_ = 1;
    q = GesturePWDUtils.isAppOnForeground(a());
    if (!q)
    {
      GesturePWDUtils.setAppForground(a(), q);
      r = false;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void e_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + BaseApplicationImpl.a().getVisibleActivityCount() + ",stopflag" + this.d_);
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
  
  public void g(String paramString)
  {
    try
    {
      getSupportActionBar().setTitle(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void j(int paramInt)
  {
    findViewById(16908290).setBackgroundResource(paramInt);
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onAccountChanged ");
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label63;
        }
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0L);
      return;
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
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.isLogin()))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      return RecentDataListManager.a().a(paramAppRuntime, BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramBoolean);
    }
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (s)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startActivity.mShowGesture == true. no startactivity.");
      }
      return;
    }
    this.d_ = 2;
    if (b(paramIntent)) {
      this.p = false;
    }
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (s)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startActivity.mShowGesture == true. no startactivity.");
      }
      return;
    }
    a(paramIntent, paramInt, 2);
  }
  
  public void w_() {}
  
  public void y()
  {
    ThreadManager.b().post(new ezd(this));
  }
  
  public void z()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppShakeListener != null)
    {
      ((SensorManager)getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqAppShakeListener);
      jdField_a_of_type_ComTencentMobileqqAppShakeListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */