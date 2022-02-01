package com.tencent.mobileqq.app;

import acln;
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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import anfe;
import anpc;
import aqey;
import aqoo;
import aqoq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.BaseActivity;
import mqq.util.WeakReference;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  private static final int DEFAULT_FLING_ACTION = 2;
  protected static final String TAG = "BaseActivity2";
  static boolean mAppForground = true;
  private static acln shakeListener;
  private static boolean snapChecked;
  static BaseActivity2 topActivity;
  private String className = getClass().getSimpleName();
  protected long currentActivityStayTime;
  boolean isPause = true;
  public String lastLoginUin;
  public boolean mActNeedImmersive = true;
  protected boolean mCanLock = true;
  private FlingHandler mFlingHandler;
  public boolean mNeedStatusTrans = true;
  private BroadcastReceiver mScreenReceiver;
  protected int mStopFlag;
  public SystemBarCompact mSystemBarComp;
  public int[] mWindowLocation;
  SkinnableActivityProcesser processer;
  ScreenShot screenShot;
  
  public static <T extends View> T $(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static <T extends ViewGroup.LayoutParams> T $lp(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  private void cleanScreenShot()
  {
    if (this.screenShot != null)
    {
      this.screenShot.cMo();
      this.screenShot = null;
      ScreenShot.EN("BaseActivity2 cleanScreenShot");
    }
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
  
  private void setShakeEnabled()
  {
    ThreadManager.excute(new BaseActivity2.2(this), 16, null, true);
  }
  
  private void startActivityInner(Intent paramIntent, int paramInt)
  {
    switch (2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", hashCode());
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public <T extends View> T $(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  protected void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.mStopFlag);
    }
  }
  
  public void doInMultiWindowModeStatusBarVisibilityChange(int paramInt) {}
  
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
        QLog.i("BaseActivity2", 2, " fight...isInMultiWindowMode = " + bool1);
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
  
  public boolean isNeedStatusBarGone()
  {
    boolean bool = true;
    if (this.mWindowLocation == null) {
      this.mWindowLocation = new int[2];
    }
    getWindow().getDecorView().getLayoutParams();
    getWindow().getDecorView().getLocationOnScreen(this.mWindowLocation);
    if (this.mWindowLocation[1] > 10) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("BaseActivity2", 4, "fight..isNeedStatusBarGone " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (onBackEvent()) {
      return;
    }
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseActivity2", 2, "", localThrowable);
      }
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    try
    {
      if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
      {
        anfe.akL = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_CREATE ", Long.valueOf(anfe.akL) });
      }
    }
    catch (Exception paramBundle)
    {
      try
      {
        this.lastLoginUin = BaseApplicationImpl.sApplication.getSharedPreferences("Last_Login", 4).getString("uin", null);
        if ((this.lastLoginUin == null) && (QLog.isColorLevel())) {
          QLog.d("BaseActivity2", 1, "last uin is null.. has problem");
        }
        ThreadManagerV2.excute(new LogActivityOnCreateRunnalbe(this), 16, null, true);
        if (InitSkin.sInited) {
          this.processer = new SkinnableActivityProcesser(this, this);
        }
        paramBundle = getIntent().getExtras();
        if (paramBundle != null)
        {
          int i = paramBundle.getInt("fling_action_key");
          if ((i != 0) && (isWrapContent()))
          {
            if (1 == i) {
              this.mFlingHandler = new FlingTrackerHandler(this);
            }
          }
          else {
            this.mCanLock = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
          }
        }
        else if (!snapChecked)
        {
          setShakeEnabled();
          snapChecked = true;
        }
      }
      catch (IllegalStateException paramBundle)
      {
        try
        {
          for (;;)
          {
            paramBundle = new IntentFilter();
            paramBundle.addAction("android.intent.action.SCREEN_OFF");
            this.mScreenReceiver = new a(null);
            registerReceiver(this.mScreenReceiver, paramBundle);
            if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
            {
              getWindow().addFlags(67108864);
              if (this.mActNeedImmersive)
              {
                this.mSystemBarComp = new SystemBarCompact(this, true, getResources().getColor(2131167361));
                if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
                  break;
                }
                this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130847060));
              }
            }
            return;
            paramBundle = paramBundle;
            QLog.e("BaseActivity2", 1, "getLongExtra fail, ", paramBundle);
            continue;
            paramBundle = paramBundle;
            this.lastLoginUin = null;
            if (QLog.isColorLevel()) {
              QLog.e("BaseActivity2", 2, "Get lastLoginUin error", paramBundle);
            }
          }
          this.mFlingHandler = new FlingGestureHandler(this);
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("BaseActivity2", 2, "registerReceiver error", paramBundle);
            }
          }
          this.mSystemBarComp.setStatusDrawable(null);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    topActivity = null;
    anpc.a(this).eZ(this);
    if (this.mScreenReceiver != null) {}
    try
    {
      unregisterReceiver(this.mScreenReceiver);
      label104:
      if (this.processer != null) {
        this.processer.destory();
      }
      return;
    }
    catch (Exception localException)
    {
      break label104;
    }
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onPause");
    }
    this.isPause = true;
    anpc.a(this).eY(this);
    cleanScreenShot();
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      anfe.akP = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_RESUME ", Long.valueOf(anfe.akP) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onResume ");
    }
    this.isPause = false;
    anpc.a(this).eX(this);
    topActivity = this;
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    int i;
    SharedPreferences.Editor localEditor;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label328;
      }
      localEditor.apply();
      label185:
      mAppForground = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseActivity2", 4, "onResume.mAppForground = " + mAppForground + ",mCanLock=" + this.mCanLock);
      }
      if ((mAppForground) || (!this.mCanLock) || (this.lastLoginUin == null) || (!GesturePWDUtils.getJumpLock(this, this.lastLoginUin))) {
        break label338;
      }
      startUnlockActivity();
    }
    for (;;)
    {
      if (!mAppForground)
      {
        mAppForground = true;
        GesturePWDUtils.setAppForground(this, mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
      if ((this.mSystemBarComp != null) && (this.mActNeedImmersive)) {
        this.mSystemBarComp.init();
      }
      return;
      i = 0;
      break;
      label328:
      localEditor.commit();
      break label185;
      label338:
      if ((!mAppForground) && (this.mCanLock)) {
        checkUnlockForSpecial();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      anfe.akN = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_START ", Long.valueOf(anfe.akN) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onStart");
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onStop");
    }
    this.mStopFlag = 1;
    mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(this);
    if (!mAppForground) {
      GesturePWDUtils.setAppForground(this, mAppForground);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent)) {
      this.mCanLock = false;
    }
    try
    {
      startActivityInner(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BaseActivity2", 2, "startActivity failed with: ", paramIntent);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    try
    {
      JefsClass.getInstance().b(this, paramIntent, new BaseActivity2.1(this, paramIntent, paramInt, paramBundle));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("BaseActivity2", 1, paramIntent, new Object[0]);
    }
  }
  
  protected void startUnlockActivity()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "startUnlockActivity..." + this.className);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  static class LogActivityOnCreateRunnalbe
    implements Runnable
  {
    private WeakReference<Activity> W;
    
    public LogActivityOnCreateRunnalbe(Activity paramActivity)
    {
      this.W = new WeakReference(paramActivity);
    }
    
    public void run()
    {
      Activity localActivity = (Activity)this.W.get();
      if (localActivity != null) {
        anpc.a(localActivity).eW(localActivity);
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        BaseActivity2.mAppForground = false;
        GesturePWDUtils.setAppForground(paramContext, BaseActivity2.mAppForground);
      }
      while (!paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
        return;
      }
      BaseActivity2.mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(paramContext);
      GesturePWDUtils.setAppForground(paramContext, BaseActivity2.mAppForground);
    }
  }
  
  static class b
    extends acln
  {
    public void FZ()
    {
      int i = Build.VERSION.SDK_INT;
      Object localObject = BaseApplicationImpl.sApplication;
      boolean bool1;
      if (i > 10)
      {
        i = 4;
        localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("screen_shot", i).getString("currentactivity", null);
        if ((BaseActivity2.topActivity != null) && (BaseActivity2.topActivity.getClass().getName().equals(localObject)))
        {
          bool1 = SettingCloneUtil.readValue(BaseApplicationImpl.sApplication, null, BaseApplicationImpl.sApplication.getString(2131697091), "qqsetting_screenshot_key", false);
          boolean bool2 = aqey.isScreenOn(BaseApplication.getContext());
          if ((bool1) && (bool2))
          {
            if (BaseActivity2.topActivity.screenShot == null)
            {
              if (!BaseActivity2.topActivity.isPause) {
                break label164;
              }
              localObject = BaseActivity2.topActivity.getApplicationContext();
              label118:
              BaseActivity2.topActivity.screenShot = new ScreenShot((Context)localObject, BaseActivity2.topActivity.getWindow());
            }
            bool1 = BaseActivity2.topActivity.screenShot.isShowing();
            if (!bool1) {
              break label172;
            }
            ScreenShot.EN("BaseActivity2 is showing");
          }
        }
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        label164:
        localObject = BaseActivity2.topActivity;
        break label118;
        label172:
        if (!BaseActivity2.topActivity.screenShot.activate()) {
          BaseActivity2.topActivity.cleanScreenShot();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("BaseActivity", 2, "snapshot activate " + bool1);
          return;
          if ((!aqoq.cVk) && (Build.VERSION.SDK_INT < 11)) {
            aqoo.a().setActivityWindowType_TYPE_KEYGUARD(BaseActivity2.topActivity.getWindow());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */