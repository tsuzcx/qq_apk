package com.tencent.mobileqq.app;

import aajt;
import acbz;
import acca;
import acci;
import acej;
import acha;
import acln;
import afsf;
import aizb;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import anlm;
import anot;
import anpc;
import anpo;
import aqqu;
import aurk;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkBridgeActivity;
import cooperation.qlink.QlinkShareJumpActivity;
import cooperation.qqfav.widget.QfavJumpActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;
import java.lang.reflect.Field;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.os.MqqHandler;
import mqq.os.MqqInterceptHandler;
import txm;

public class BaseActivity
  extends AppActivity
  implements SkinnableActivityProcesser.Callback
{
  public static final int MSG_SHAKE = 1001;
  public static final int REQUEST_CODE_UNLOCK = 12289;
  public static final String TAG = "qqBaseActivity";
  private static boolean isThemeSwitchOpen;
  public static boolean isUnLockSuccess;
  public static long mAppBackgroundTime;
  public static boolean mAppForground = true;
  public static boolean mIsInMultiScreen;
  private static BroadcastReceiver mScreenReceiver;
  protected static long mShowGesture;
  public static ArrayList<String> sActivityRoute = new ArrayList();
  private static boolean sSensorReady;
  public static BaseActivity sTopActivity;
  private static acln shakeListener;
  public QQAppInterface app;
  private String className = getClass().getSimpleName();
  public int clickX;
  public int clickY;
  protected long currentActivityStayTime;
  public boolean isClearCoverLayer = true;
  private Dialog jumpDialog;
  public boolean mActNeedImmersive = true;
  protected boolean mCanLock = true;
  private ClassLoader mClassLoader;
  public boolean mCurrentActivityShakeFlag = true;
  private EIPCResultCallback mEIPCResultCallback = new acbz(this);
  protected FlingHandler mFlingHandler;
  protected boolean mIsAttachedToWindow;
  protected boolean mIsStatusBarVisibilityNeedGone;
  private MiniMsgUser mMiniMsgUser;
  private Runnable mNFCPauseRunnable;
  private Runnable mNFCResumeRunnable;
  public boolean mNeedStatusTrans = true;
  private boolean mShowOnFirst;
  private StatusBarCorrectTask mStatusBarCorrectTask;
  protected int mStatusBarVisibility = 0;
  protected int mStopFlag;
  public SystemBarCompact mSystemBarComp;
  public int[] mWindowLocation;
  SkinnableActivityProcesser processer;
  Runnable runnableRemoveNotification = null;
  public ScreenShot screenShot;
  
  private void cleanScreenShot()
  {
    if (this.screenShot != null)
    {
      this.screenShot.cMo();
      this.screenShot = null;
      ScreenShot.EN("BaseActivity cleanScreenShot");
    }
  }
  
  public static ArrayList<String> getActivityRoutes()
  {
    return (ArrayList)sActivityRoute.clone();
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
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
  
  private void replaceActivityHandler()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mHandler");
      localField.setAccessible(true);
      Handler localHandler = MqqInterceptHandler.createMqqHandler((Handler)localField.get(this));
      if (localHandler != null) {
        localField.set(this, localHandler);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "", localException);
    }
  }
  
  private void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    boolean bool = paramIntent.getBooleanExtra("key_gesture_showgesture_valid", true);
    if ((bool) && (Math.abs(mShowGesture - SystemClock.uptimeMillis()) < 1000L))
    {
      QLog.d("qqBaseActivity", 1, "startActivityForResult" + mShowGesture + "," + bool);
      return;
    }
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "mCanLock set false, isStartQQ3rdApp");
      }
      this.mCanLock = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    String str = paramIntent.getStringExtra("selfSet_leftViewText");
    if (TextUtils.isEmpty(str)) {
      paramIntent.putExtra("leftViewText", setLastActivityName());
    }
    for (;;)
    {
      try
      {
        startActivityInner(paramIntent, paramInt1, paramInt2);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqBaseActivity", 2, "startActivity failed with: ", paramIntent);
      return;
      paramIntent.putExtra("leftViewText", str);
      paramIntent.removeExtra("selfSet_leftViewText");
    }
  }
  
  private void startActivityInner(Intent paramIntent, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
      if ((this.app != null) && (FlingAllowProvider.contain(getCurrentAccountUin())))
      {
        paramInt2 = hashCode();
        String str = ScreenCapture.getSnapPath(this, paramInt2);
        if (str != null)
        {
          ScreenCapture.captureViewToFile(str, getWindow().getDecorView());
          paramIntent.putExtra("fling_action_key", 1);
          paramIntent.putExtra("fling_code_key", paramInt2);
        }
      }
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    paramInt2 = hashCode();
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void addObserver(acci paramacci)
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.addObserver(paramacci);
    }
  }
  
  public void addObserver(acci paramacci, boolean paramBoolean)
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.addObserver(paramacci, paramBoolean);
    }
  }
  
  public void adjustSimpleStatusBar()
  {
    boolean bool1 = false;
    if (anlm.ayn())
    {
      bool2 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW())) {
        if (!bool2) {
          bool1 = true;
        }
      }
    }
    while (ImmersiveUtils.isSupporImmersive() == 0)
    {
      boolean bool2;
      ImmersiveUtils.setStatusTextColor(bool1, getWindow());
      do
      {
        return;
      } while ((ImmersiveUtils.isSupporImmersive() == 0) || (this.mSystemBarComp == null) || (bool2));
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    ImmersiveUtils.setStatusTextColor(false, getWindow());
  }
  
  protected void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + Foreground.sCountActivity + ",stopflag" + this.mStopFlag);
    }
  }
  
  protected void correctStatusBarHeight()
  {
    if ((!ImmersiveUtils.dly) && (!isInMultiWindow()))
    {
      if (this.mStatusBarCorrectTask == null) {
        this.mStatusBarCorrectTask = new StatusBarCorrectTask();
      }
      ThreadManager.getUIHandler().post(this.mStatusBarCorrectTask);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    anot.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.clickX = ((int)paramMotionEvent.getRawX());
      this.clickY = ((int)paramMotionEvent.getRawY());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"SdCardPath"})
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (isThemeSwitchOpen) {}
    return super.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doInMultiWindowModeStatusBarVisibilityChange(int paramInt) {}
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {
      try
      {
        if ((this instanceof FragmentActivity))
        {
          if (!((FragmentActivity)this).getThisFragmentManager().popBackStackImmediate()) {
            finish();
          }
        }
        else
        {
          super.doOnBackPressed();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "", localThrowable);
        }
        finish();
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = Build.VERSION.SDK_INT;
    anpc.a(this).eW(this);
    setImmersiveStatus();
    replaceActivityHandler();
    if (themeChangeRightNow()) {
      this.processer = new SkinnableActivityProcesser(this, this);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    sActivityRoute.add(getActivityName());
    updateAppRuntime();
    if (getAppRuntime() != null) {
      setVolumeControlStream(3);
    }
    if (!sSensorReady)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new BaseActivity.1(this), 300L);
      sSensorReady = true;
    }
    if (isWrapContent())
    {
      paramBundle = getIntent().getExtras();
      if (paramBundle == null) {}
    }
    try
    {
      i = paramBundle.getInt("fling_action_key");
      if (i != 0)
      {
        if ((1 == i) && (getAppRuntime() != null) && (FlingAllowProvider.contain(getCurrentAccountUin()))) {
          this.mFlingHandler = new FlingTrackerHandler(this);
        }
      }
      else
      {
        setOnMultiScreenChangeListener();
        aurk.b(this.app, this);
        if (isNeedMiniMsg()) {
          this.mMiniMsgUser = new MiniMsgUser(this, getMiniMsgUserParam());
        }
        anlm.a(this.mSystemBarComp, getWindow());
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        i = 0;
        continue;
        this.mFlingHandler = new FlingGestureHandler(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      if ((this.jumpDialog != null) && (this.jumpDialog.isShowing())) {
        this.jumpDialog.dismiss();
      }
      super.doOnDestroy();
      sActivityRoute.remove(getActivityName());
      anpc.a(this).eZ(this);
      if (this.processer != null) {
        this.processer.destory();
      }
      if (this.mNFCPauseRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCPauseRunnable);
        this.mNFCPauseRunnable = null;
      }
      if (this.mNFCResumeRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCResumeRunnable);
        this.mNFCResumeRunnable = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
      }
      AppInterface localAppInterface = getAppInterface();
      if (localAppInterface != null) {
        localAppInterface.removeHandler(getClass());
      }
      if ((MagnifierSDK.a().a().oN > 0.0F) && (BaseApplicationImpl.sImageCache != null)) {
        BaseApplicationImpl.sImageCache.releaseLargeCache();
      }
      if (sTopActivity == this) {
        sTopActivity = null;
      }
      if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.destroy();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("qqBaseActivity", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    acha.dN(this);
    if (26 <= Build.VERSION.SDK_INT) {
      acej.c(this, true, false);
    }
    if (paramIntent != null) {
      ActivityLifecycle.onNewIntent(getActivity(), paramIntent);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    anpc.a(this).eY(this);
    Object localObject = sTopActivity;
    if ((this.currentActivityStayTime != 0L) && (localObject != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, localObject.getClass().getName(), (int)(SystemClock.uptimeMillis() - this.currentActivityStayTime), 0, null);
    }
    cleanScreenShot();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.className);
      ((StringBuilder)localObject).append(" onPause HeapAlloc=");
      ((StringBuilder)localObject).append(Runtime.getRuntime().totalMemory() / 1024L);
      ((StringBuilder)localObject).append(" KB HeapFree=");
      ((StringBuilder)localObject).append(Runtime.getRuntime().freeMemory() / 1024L);
      ((StringBuilder)localObject).append(" KB");
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = BridgeHelper.a(getActivity(), getCurrentAccountUin()).getConfig("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {}
    try
    {
      if (this.mNFCPauseRunnable != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCPauseRunnable);
      }
      this.mNFCPauseRunnable = new BaseActivity.5(this);
      ThreadManager.getSubThreadHandler().post(this.mNFCPauseRunnable);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("qqBaseActivity", 4, "disableNFCEvent failed");
        }
      }
    }
    if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
      this.mMiniMsgUser.onBackground();
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    i = 2;
    super.doOnResume();
    sTopActivity = this;
    anpc.a(this).eX(this);
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      setOnMultiScreenChangeListener();
    }
    Object localObject;
    if ((this instanceof NotificationActivity))
    {
      if (afsf.caD == true) {
        afsf.a().dbJ();
      }
      ThreadManager.excute(new BaseActivity.3(this), 64, null, true);
      mAppForground = GesturePWDUtils.getAppForground(getActivity());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(256);
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(hashCode());
        ((StringBuilder)localObject).append("]");
        ((StringBuilder)localObject).append(this.className);
        ((StringBuilder)localObject).append(" onResume .mAppForground = ");
        ((StringBuilder)localObject).append(mAppForground);
        ((StringBuilder)localObject).append(",mCanLock=");
        ((StringBuilder)localObject).append(this.mCanLock);
        ((StringBuilder)localObject).append(" HeapAlloc=");
        ((StringBuilder)localObject).append(Runtime.getRuntime().totalMemory() / 1024L);
        ((StringBuilder)localObject).append(" KB HeapFree=");
        ((StringBuilder)localObject).append(Runtime.getRuntime().freeMemory() / 1024L);
        ((StringBuilder)localObject).append(" KB HeapMax=");
        ((StringBuilder)localObject).append(Runtime.getRuntime().maxMemory() / 1024L);
        ((StringBuilder)localObject).append(" KB");
        QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (mAppBackgroundTime > 0L) {
        anpo.lz(SystemClock.elapsedRealtime() - mAppBackgroundTime);
      }
      mAppBackgroundTime = 0L;
      localObject = getCurrentAccountUin();
      if (((mAppForground) && ((!"com.tencent.tim".equals(BaseApplicationImpl.processName)) || (isUnLockSuccess))) || (!this.mCanLock) || (localObject == null) || (!GesturePWDUtils.getJumpLock(getActivity(), (String)localObject)) || ((getActivity() instanceof GesturePWDUnlockActivity)) || ((getActivity() instanceof InstallActivity)) || ((getActivity() instanceof UserguideActivity)) || ((getActivity() instanceof JumpActivity)) || ((getActivity() instanceof qfileJumpActivity)) || ((getActivity() instanceof QfavJumpActivity)) || ((getActivity() instanceof LoginActivity)) || ((getActivity() instanceof QlinkBridgeActivity)) || ((getActivity() instanceof QlinkShareJumpActivity))) {
        break label677;
      }
      startUnlockActivity();
    }
    for (;;)
    {
      if ((!mAppForground) && (!(this instanceof JumpActivity)))
      {
        mAppForground = true;
        GesturePWDUtils.setAppForground(getActivity(), mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
      if (GuardManager.a != null) {
        GuardManager.a.y(1, getPreProcess());
      }
      localObject = BridgeHelper.a(getActivity(), getCurrentAccountUin()).getConfig("buscard_registerNFC");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {}
      try
      {
        if (this.mNFCResumeRunnable != null) {
          ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCResumeRunnable);
        }
        this.mNFCResumeRunnable = new BaseActivity.4(this);
        ThreadManager.getSubThreadHandler().post(this.mNFCResumeRunnable);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isDevelopLevel())
          {
            QLog.i("qqBaseActivity", 4, "registerNFCEvent failed");
            continue;
            i = 0;
          }
        }
      }
      this.mIsStatusBarVisibilityNeedGone = false;
      if ((!isNeedInterruptDoMulitWindow()) && (this.mIsAttachedToWindow) && (isInMultiWindow()))
      {
        bool = isNeedStatusBarGone();
        if ((this.mSystemBarComp != null) && (this.mSystemBarComp.isStatusBarVisible == bool))
        {
          if (!bool) {
            break label736;
          }
          this.mSystemBarComp.setStatusBarVisible(i, 0);
          this.mStatusBarVisibility = i;
          doInMultiWindowModeStatusBarVisibilityChange(i);
        }
      }
      if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.onForeground();
      }
      if (Build.VERSION.SDK_INT < 23) {
        anlm.a(this.mSystemBarComp, getWindow());
      }
      return;
      afsf.a().dbI();
      break;
      label677:
      if ((!mAppForground) && (this.mCanLock)) {
        checkUnlockForSpecial();
      } else if ((!mAppForground) && (!this.mCanLock)) {
        isUnLockSuccess = true;
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    cleanScreenShot();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStart " + Foreground.sCountActivity);
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
    aizb.dz(getIntent());
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStop " + Foreground.sCountActivity);
    }
    cleanScreenShot();
    this.mStopFlag = 1;
    mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(this);
    if (!mAppForground)
    {
      GesturePWDUtils.setAppForground(this, mAppForground);
      isUnLockSuccess = false;
      mAppBackgroundTime = SystemClock.elapsedRealtime();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    int i = 0;
    super.doOnWindowFocusChanged(paramBoolean);
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = getClass().getName();
      if (this.app == null)
      {
        bool = true;
        QLog.d("qqBaseActivity", 2, String.format("doOnWindowFocusChanged, isFocused[%s], appIsNull[%s], curName[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), localObject }));
      }
    }
    else
    {
      if ((this.app != null) && (!paramBoolean)) {
        break label315;
      }
    }
    for (;;)
    {
      try
      {
        if (!AppSetting.aHR.equalsIgnoreCase("Xiaomi-MI 5")) {
          continue;
        }
        if (this.runnableRemoveNotification == null) {
          this.runnableRemoveNotification = new BaseActivity.2(this);
        }
        ThreadManager.getUIHandler().postDelayed(this.runnableRemoveNotification, 3000L);
        if ((!isNeedInterruptDoMulitWindow()) && (!this.mIsAttachedToWindow) && (isInMultiWindow()))
        {
          bool = isNeedStatusBarGone();
          if ((this.mSystemBarComp != null) && (this.mSystemBarComp.isStatusBarVisible == bool))
          {
            if (bool) {
              i = 2;
            }
            this.mSystemBarComp.setStatusBarVisible(i, 0);
            this.mStatusBarVisibility = i;
            doInMultiWindowModeStatusBarVisibilityChange(i);
          }
        }
        this.mIsAttachedToWindow = true;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("qqBaseActivity", 4, "doOnWindowFocusChanged failed");
        continue;
      }
      localObject = (KandianMergeManager)this.app.getManager(162);
      if (localObject != null) {
        ((KandianMergeManager)localObject).a(paramBoolean, getClass());
      }
      if ((paramBoolean) && (!this.mShowOnFirst))
      {
        if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
          this.mMiniMsgUser.showOnFirst();
        }
        this.mShowOnFirst = true;
      }
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification");
      }
      this.app.cLs();
      continue;
      label315:
      if (this.runnableRemoveNotification != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.runnableRemoveNotification);
        this.runnableRemoveNotification = null;
      }
    }
  }
  
  public void doRefreshMiniBadge(Bundle paramBundle) {}
  
  public void finish()
  {
    try
    {
      super.finish();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "finish error");
    }
  }
  
  @Deprecated
  public Activity getActivity()
  {
    return this;
  }
  
  public String getActivityName()
  {
    return this.className;
  }
  
  public AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getCIOPageName()
  {
    return getClass().getName();
  }
  
  public boolean getCanLock()
  {
    return this.mCanLock;
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.a();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
  }
  
  public String getCurrentAccountUin()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    if ((localAppRuntime instanceof AppInterface)) {
      return ((AppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return localAppRuntime.getAccount();
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 0;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    localMiniMsgUserParam.filterMsgType = 0;
    return localMiniMsgUserParam;
  }
  
  protected String getPreProcess()
  {
    return null;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  @TargetApi(24)
  public boolean isInMultiWindow()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      bool1 = isInMultiWindowMode();
      if (QLog.isDebugVersion()) {
        QLog.i("qqBaseActivity", 2, " fight...isInMultiWindowMode = " + bool1);
      }
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return false;
  }
  
  protected boolean isNeedMiniMsg()
  {
    return false;
  }
  
  public boolean isNeedStatusBarGone()
  {
    boolean bool = false;
    if (this.mWindowLocation == null) {
      this.mWindowLocation = new int[2];
    }
    getWindow().getDecorView().getLayoutParams();
    getWindow().getDecorView().getLocationOnScreen(this.mWindowLocation);
    if (getWindow().getDecorView().getSystemUiVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((this.mWindowLocation[1] > 10) || (i == 0)) {
        bool = true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("qqBaseActivity", 4, "fight..isNeedStatusBarGone " + bool);
      }
      return bool;
    }
  }
  
  public boolean isSupportScreenShot()
  {
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onAccountChanged ");
      if (getAppRuntime() != null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      if (this.app != null) {
        this.app.hG(0L);
      }
      updateAppRuntime();
      return;
    }
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (sTopActivity == this))
    {
      if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24))
      {
        anot.c(this.app, "dc00898", "", "", "0X800859D", "0X800859D", 0, 0, "", "", "", "");
        anpc.a(this).collectPerformance(null, "MulitScreenMode", paramBoolean, 0L, 0L, null, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("qqBaseActivity", 4, "fight..onMultiWindowModeChanged " + getActivityName());
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.mSystemBarComp != null)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label43;
      }
      this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130847060));
    }
    for (;;)
    {
      anlm.a(this.mSystemBarComp, getWindow());
      return;
      label43:
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusBarColor(getResources().getColor(2131167361));
    }
  }
  
  public void onPreThemeChanged() {}
  
  public void onProcessBackground(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_backgound", paramBundle, this.mEIPCResultCallback);
  }
  
  protected void onProcessForeGround(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MiniMsgIPCServer", 4, "onProcessForeGround" + paramBundle.toString());
    }
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_foregound", paramBundle, this.mEIPCResultCallback);
  }
  
  protected void onRefreshMiniBadge(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_refresh_mini_badge", paramBundle, this.mEIPCResultCallback);
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadData", 2, "LoadDataactivity = " + paramAppRuntime + paramAppRuntime.isLogin());
    }
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      if (paramAppRuntime.isLogin()) {
        return aajt.a().a(localQQAppInterface, BaseApplicationImpl.sApplication, paramBoolean, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadData", 2, new Object[] { "Preload not login account: ", paramAppRuntime.getAccount() });
      }
      try
      {
        paramBoolean = aajt.a().a(localQQAppInterface, BaseApplicationImpl.sApplication, paramBoolean, false);
        return paramBoolean;
      }
      catch (Throwable paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadData", 2, "has account and not login, preload fail.");
        }
        return false;
      }
    }
    return false;
  }
  
  protected void receiveScreenOff() {}
  
  public void removeObserver(acci paramacci)
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.removeObserver(paramacci);
    }
  }
  
  public void setCanLock(boolean paramBoolean)
  {
    if ((!paramBoolean) && (QLog.isColorLevel())) {
      QLog.e("qqBaseActivity", 2, "mCanLock set false", new Throwable());
    }
    this.mCanLock = paramBoolean;
  }
  
  protected void setContentBackgroundResource(int paramInt)
  {
    findViewById(16908290).setBackgroundResource(paramInt);
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive)
      {
        int i = getResources().getColor(2131167361);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            break label99;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130847060));
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      return;
      label99:
      this.mSystemBarComp.setStatusDrawable(null);
    }
  }
  
  public void setImmersiveStatus(int paramInt)
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, paramInt);
      }
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
    }
  }
  
  public void setJumpDialog(Dialog paramDialog)
  {
    this.jumpDialog = paramDialog;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131691039);
  }
  
  @TargetApi(11)
  public void setOnMultiScreenChangeListener()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    do
    {
      for (;;)
      {
        return;
        if (Build.VERSION.SDK_INT >= 21)
        {
          acca localacca = new acca(this);
          try
          {
            View localView = getWindow().getDecorView();
            localView.setOnSystemUiVisibilityChangeListener(localacca);
            if (localView.getSystemUiVisibility() != 0) {
              localacca.onSystemUiVisibilityChange(localView.getSystemUiVisibility());
            }
            if (QLog.isDevelopLevel())
            {
              QLog.d("qqBaseActivity", 4, "setOnMultiScreenChangeListener:" + localView.getSystemUiVisibility() + ",Activity name:" + getClass().getName());
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("qqBaseActivity", 4, "setOnMultiScreenChangeListener happen exception:" + localException.getMessage() + ",Activity name:" + getClass().getName());
  }
  
  public void setStatusBarBlue()
  {
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (this.mSystemBarComp != null)) {
      this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130847060));
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    JumpActivity.aC(paramIntent);
    JumpActivity.handleIntentForQQBrowser(this, paramIntent);
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    JumpActivity.aC(paramIntent);
    JumpActivity.handleIntentForQQBrowser(this, paramIntent);
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    JumpActivity.aC(paramIntent);
    JumpActivity.handleIntentForQQBrowser(this, paramIntent);
    startActivityForResult(paramIntent, paramInt, 2);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    JumpActivity.aC(paramIntent);
    JumpActivity.handleIntentForQQBrowser(this, paramIntent);
    Object localObject;
    if (this.app != null)
    {
      localObject = (aqqu)this.app.getManager(150);
      if ((localObject == null) || (!((aqqu)localObject).a(paramIntent, this.app, this))) {}
    }
    else
    {
      do
      {
        return;
        if (!(this instanceof QQBrowserActivity)) {
          break;
        }
        localObject = ((QQBrowserActivity)this).c();
      } while ((localObject != null) && (((WebViewFragment)localObject).browserApp != null) && (((WebViewFragment)localObject).browserApp.a != null) && (((WebViewFragment)localObject).browserApp.a.b(paramIntent, this)));
    }
    try
    {
      JefsClass.getInstance().b(this, paramIntent, new BaseActivity.8(this, paramIntent, paramInt, paramBundle));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("qqBaseActivity", 1, paramIntent, new Object[0]);
    }
  }
  
  public void startUnlockActivity()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.className);
    }
    GesturePWDUnlockActivity.aXo = true;
    Intent localIntent = new Intent(this, GesturePWDUnlockActivity.class);
    localIntent.putExtra("key_gesture_showgesture_valid", false);
    startActivityForResult(localIntent, 12289);
    mShowGesture = SystemClock.uptimeMillis();
  }
  
  protected boolean themeChangeRightNow()
  {
    return true;
  }
  
  public void turnOffShake()
  {
    BaseActivity.7 local7 = new BaseActivity.7(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local7);
      return;
    }
    local7.run();
  }
  
  public void turnOnShake()
  {
    BaseActivity.6 local6 = new BaseActivity.6(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local6);
      return;
    }
    local6.run();
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 4, "updateAppRuntime, " + localAppRuntime);
    }
  }
  
  static class MyRelativeLayout
    extends RelativeLayout
  {
    public MyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private void cHg()
    {
      Object localObject = this;
      if (localObject != null)
      {
        QLog.e("qqBaseActivity", 1, "view id: " + ((View)localObject).getId());
        localObject = ((View)localObject).getParent();
        if ((localObject != null) && ((localObject instanceof View))) {}
        for (localObject = (View)localObject;; localObject = null) {
          break;
        }
      }
    }
    
    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
    {
      checkMainThread();
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    
    public void checkMainThread()
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("qqBaseActivity", 1, "modify view in subThread");
        cHg();
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      try
      {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "onLayout crash", localException);
        cHg();
      }
    }
    
    public void removeAllViews()
    {
      checkMainThread();
      super.removeAllViews();
    }
    
    public void removeView(View paramView)
    {
      checkMainThread();
      super.removeView(paramView);
    }
    
    public void removeViewInLayout(View paramView)
    {
      checkMainThread();
      super.removeViewInLayout(paramView);
    }
  }
  
  public class StatusBarCorrectTask
    implements Runnable
  {
    public StatusBarCorrectTask() {}
    
    public void run()
    {
      if (ImmersiveUtils.a(BaseActivity.this.getWindow())) {
        BaseActivity.this.recreate();
      }
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 0;
      int i = 0;
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, paramIntent.getAction());
        }
      }
      for (;;)
      {
        return;
        if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          if ((localBaseActivity.mStopFlag == 0) && (localBaseActivity.mCanLock) && (GesturePWDUtils.getGesturePWDState(localBaseActivity, localBaseActivity.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(localBaseActivity, localBaseActivity.getCurrentAccountUin()) == 21) && (!(localBaseActivity instanceof GesturePWDUnlockActivity)) && (!(localBaseActivity instanceof LoginActivity)) && (!GesturePWDUtils.getGestureLocking(localBaseActivity)))
          {
            BaseActivity.mAppForground = false;
            GesturePWDUtils.setAppForground(paramContext, BaseActivity.mAppForground);
            BaseActivity.isUnLockSuccess = false;
            if (BaseActivity.shakeListener == null) {
              continue;
            }
            if (SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131697091), "qqsetting_screenshot_key", false)) {
              break label169;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label172;
            }
            localBaseActivity.turnOffShake();
            return;
            localBaseActivity.receiveScreenOff();
            break;
            label169:
            i = 1;
          }
        }
        else
        {
          label172:
          if ((paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) && (BaseActivity.shakeListener == null))
          {
            if (!SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131697091), "qqsetting_screenshot_key", false)) {}
            for (i = j; i != 0; i = 1)
            {
              localBaseActivity.turnOnShake();
              return;
            }
          }
        }
      }
    }
  }
  
  static class b
    extends acln
  {
    public void FZ()
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        ScreenShot.EN("MyShakeListener - top activity is null");
      }
      do
      {
        return;
        if (!((BaseActivity)localObject).mCurrentActivityShakeFlag)
        {
          ScreenShot.EN("MyShakeListener - shake flag is false");
          return;
        }
      } while (ThreadManager.getSubThreadHandler().hasMessages(1001));
      localObject = ThreadManager.getSubThreadHandler().obtainMessage(1001, new BaseActivity.MyShakeListener.1(this, (BaseActivity)localObject));
      ThreadManager.getSubThreadHandler().sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */