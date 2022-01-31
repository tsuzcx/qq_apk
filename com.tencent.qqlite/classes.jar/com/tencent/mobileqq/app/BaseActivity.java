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
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.mobileqq.utils.pathtracker.VipPathTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import cooperation.qqfav.widget.QfavJumpActivity;
import cqb;
import cqc;
import cqd;
import java.io.File;
import java.lang.reflect.Field;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class BaseActivity
  extends AppActivity
  implements SkinnableActivityProcesser.Callback
{
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean = false;
  protected static final String a_ = "qqBaseActivity";
  static final int c_ = 0;
  public static boolean isUnLockSuccess = false;
  public static boolean mAppForground = true;
  public static BaseActivity sTopActivity;
  public static boolean u = false;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  public QQAppInterface app;
  private boolean b;
  public int d_ = 0;
  public boolean t = true;
  
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
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.a(paramBusinessObserver);
    }
  }
  
  public void addTouchFeedback()
  {
    Object localObject1 = null;
    if ((this.app == null) || (this.app.a() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (Settings.System.getInt(this.app.a().getContentResolver(), "haptic_feedback_enabled", 1) != 1);
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
      localObject1 = this.app.a().getResources().getIntArray(((Integer)localObject1).intValue());
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break;
      }
      localObject1 = this.app.a().getResources().getIntArray(2131230725);
    } while ((localObject1 == null) || (localObject1.length <= 0));
    localObject2 = new long[localObject1.length];
    i = 0;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i];
      i += 1;
    }
    ((Vibrator)this.app.a().getSystemService("vibrator")).vibrate((long[])localObject2, -1);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public String b_()
  {
    return getString(2131363113);
  }
  
  public void b_() {}
  
  protected String c_()
  {
    return null;
  }
  
  public void c_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + BaseApplicationImpl.a().getVisibleActivityCount() + ",stopflag" + this.d_);
    }
  }
  
  public void d(int paramInt)
  {
    findViewById(16908290).setBackgroundResource(paramInt);
  }
  
  @SuppressLint({"SdCardPath"})
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
    {
      if ((paramKeyEvent.getKeyCode() != 24) || (!new File("/mnt/sdcard/skin/res/").isDirectory())) {
        break label71;
      }
      if (SkinEngine.getInstances().getSkinRootPath() == null) {
        break label57;
      }
      SkinEngine.getInstances().setSkinRootPath(this, null);
    }
    for (;;)
    {
      return super.doDispatchKeyEvent(paramKeyEvent);
      label57:
      SkinEngine.getInstances().setSkinRootPath(this, "/mnt/sdcard/skin/res/");
      continue;
      label71:
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
    if (!a()) {}
    try
    {
      super.doOnBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "", localThrowable);
      }
      finish();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    StatisticCollector.a(this).c(this);
    this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    if ((getAppRuntime() instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app != null) {
      setVolumeControlStream(3);
    }
    if (!jdField_a_of_type_Boolean)
    {
      if (SettingCloneUtil.readValue(this, null, getString(2131363054), "qqsetting_screenshot_key", false)) {
        turnOnShake();
      }
      jdField_a_of_type_Boolean = true;
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new cqd(this, null);
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      label204:
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {}
      try
      {
        i = paramBundle.getInt("fling_action_key");
        if ((i != 0) && (b()))
        {
          if ((1 == i) && (this.app != null) && (FlingAllowProvider.contain(this.app.a()))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);
          }
        }
        else
        {
          VipPathTracker.a().a(this);
          return false;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          int i = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this);
        }
      }
    }
    catch (Exception paramBundle)
    {
      break label204;
    }
  }
  
  public void doOnDestroy()
  {
    if (!this.b)
    {
      VipPathTracker.a().b(this);
      this.b = true;
    }
    super.doOnDestroy();
    StatisticCollector.a(this).f(this);
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    if (this.app != null) {
      this.app.a(getClass());
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label151:
      if ((AppSetting.j) && (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.releaseLargeCache();
      }
      if (sTopActivity == this) {
        sTopActivity = null;
      }
      ReflecterHelper.a(this);
      return;
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    StatisticCollector.a(this).e(this);
    if (this.app != null)
    {
      ((SaveTrafficHandler)this.app.a(16)).a(true);
      this.app.a(-1L);
    }
    c();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onPause");
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
    StatisticCollector.a(this).d(this);
    if (this.app != null)
    {
      ((SaveTrafficHandler)this.app.a(16)).a(false);
      StatisticCollector.a(this).a(this.app);
    }
    int i;
    label73:
    SharedPreferences.Editor localEditor;
    if ((this instanceof NotificationActivity))
    {
      EquipmentLockImpl.a().b();
      if (Build.VERSION.SDK_INT <= 10) {
        break label503;
      }
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label508;
      }
      localEditor.apply();
      label121:
      if (this.app != null) {
        this.app.z();
      }
      mAppForground = GesturePWDUtils.getAppForground(getActivity());
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume.mAppForground = " + mAppForground + ",mCanLock=" + this.t);
      }
      if (((mAppForground) && ((!"com.tencent.qqlite".equals(BaseApplicationImpl.processName)) || (isUnLockSuccess))) || (!this.t) || (this.app == null) || (!GesturePWDUtils.getJumpLock(getActivity(), this.app.a())) || ((getActivity() instanceof GesturePWDUnlockActivity)) || ((getActivity() instanceof InstallActivity)) || ((getActivity() instanceof JumpActivity)) || ((getActivity() instanceof qfileJumpActivity)) || ((getActivity() instanceof QfavJumpActivity)) || ((getActivity() instanceof LoginActivity))) {
        break label519;
      }
      w();
      label337:
      if ((mAppForground) || (this.app == null)) {
        break label559;
      }
      label350:
      if ((!mAppForground) && (!(this instanceof JumpActivity)))
      {
        mAppForground = true;
        GesturePWDUtils.setAppForground(getActivity(), mAppForground);
      }
      this.d_ = 0;
      this.t = true;
      if (BaseApplicationImpl.jdField_a_of_type_Long > 0L)
      {
        long l1 = SystemClock.uptimeMillis();
        if (!(this instanceof SplashActivity)) {
          break label575;
        }
        long l2 = l1 - BaseApplicationImpl.jdField_a_of_type_Long;
        Log.d("AutoMonitor", "ActionLoginA, cost=" + l2);
        StatisticCollector.a(this.app.a()).a(null, "actLoginA", true, l2, 0L, null, null);
        if (!NetworkUtil.e(this)) {
          break label568;
        }
        BaseApplicationImpl.jdField_a_of_type_Long = -l1;
      }
    }
    for (;;)
    {
      if (GuardManager.a != null) {
        GuardManager.a.b(1, c_());
      }
      return;
      EquipmentLockImpl.a().a();
      break;
      label503:
      i = 0;
      break label73;
      label508:
      localEditor.commit();
      break label121;
      label519:
      if ((!mAppForground) && (this.t))
      {
        c_();
        break label337;
      }
      if ((mAppForground) || (this.t)) {
        break label337;
      }
      isUnLockSuccess = true;
      break label337;
      label559:
      if (!mAppForground) {
        break label350;
      }
      break label350;
      label568:
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      continue;
      label575:
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStart " + BaseApplicationImpl.a().getVisibleActivityCount());
    }
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStop " + BaseApplicationImpl.a().getVisibleActivityCount());
    }
    c();
    this.d_ = 1;
    mAppForground = GesturePWDUtils.isAppOnForeground(getActivity());
    if (!mAppForground)
    {
      GesturePWDUtils.setAppForground(getActivity(), mAppForground);
      isUnLockSuccess = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((this.app != null) && (paramBoolean)) {
      this.app.i();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.b) && (!(this instanceof FrameActivity)))
    {
      VipPathTracker.a().c(this);
      this.b = true;
    }
  }
  
  @Deprecated
  public Activity getActivity()
  {
    return this;
  }
  
  public int getPathNodeID()
  {
    return hashCode();
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131492887);
  }
  
  public TransFileController getTransFileControlller()
  {
    if (this.app == null) {
      return null;
    }
    return this.app.a();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (this.app != null) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onAccountChanged ");
        if (this.app != null) {
          break label63;
        }
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      this.app.a(0L);
      return;
    }
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
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.c(paramBusinessObserver);
    }
  }
  
  public void setCanLock(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (u)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startActivity.mShowGesture == true. no startactivity.");
      }
      return;
    }
    this.d_ = 2;
    if (a(paramIntent)) {
      this.t = false;
    }
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (u)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startActivity.mShowGesture == true. no startactivity.");
      }
      return;
    }
    startActivityForResult(paramIntent, paramInt, 2);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.d_ = 2;
    if (a(paramIntent)) {
      this.t = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    String str = paramIntent.getStringExtra("selfSet_leftViewText");
    if (TextUtils.isEmpty(str)) {
      paramIntent.putExtra("leftViewText", b_());
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
    if ((this.app != null) && (FlingAllowProvider.contain(this.app.a())))
    {
      paramInt2 = hashCode();
      str = ScreenCapture.getSnapPath(getActivity(), paramInt2);
      if (str != null)
      {
        ScreenCapture.captureViewToFile(str, getActivity().getWindow().getDecorView());
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
  
  public void turnOffShake()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppShakeListener != null)
    {
      ((SensorManager)getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqAppShakeListener);
      jdField_a_of_type_ComTencentMobileqqAppShakeListener = null;
    }
  }
  
  public void turnOnShake()
  {
    ThreadManager.b().post(new cqb(this));
  }
  
  public void w()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(getActivity(), GesturePWDUnlockActivity.class));
    u = true;
    new Handler().postDelayed(new cqc(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */