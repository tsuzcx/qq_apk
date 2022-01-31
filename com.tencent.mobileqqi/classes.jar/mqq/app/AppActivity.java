package mqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarImplJB;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import mqq.app.permission.PermissionManager;
import mqq.util.WeakReference;

public class AppActivity
  extends ActionBarActivity
{
  protected static int sResumeCount = 0;
  private boolean mIsFinishingInOnCreate = false;
  private boolean mIsResultWaiting;
  protected boolean mIsResume = false;
  private boolean mIsSplashing = false;
  private boolean mIsStartSkipped = false;
  private Intent mNewIntent;
  private Bundle mOnCreateBundle = null;
  private Bundle mOnRestoreBundle;
  private Bundle mPostCreateBundle = null;
  private int mRequestCode;
  private int mResultCode;
  private Intent mResultData;
  protected AppRuntime mRuntime = null;
  private int mWindowFocusState = -1;
  public PermissionManager permissionManager = PermissionManager.init(this);
  
  private void forceShowOverflowMenu()
  {
    try
    {
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(this);
      Field localField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
      if (localField != null)
      {
        localField.setAccessible(true);
        localField.setBoolean(localViewConfiguration, false);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void requestFeature()
  {
    try
    {
      Object localObject = ActionBarActivity.class.getDeclaredField("mImpl");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      Field localField = Class.forName("android.support.v7.app.ActionBarActivityDelegate").getDeclaredField("mHasActionBar");
      localField.setAccessible(true);
      localField.setBoolean(localObject, true);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doDispatchKeyEvent(paramKeyEvent);
  }
  
  protected boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void doOnBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("qqBaseActivity", 2, "", localThrowable);
    }
  }
  
  protected void doOnConfigurationChanged(Configuration paramConfiguration) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    MobileQQ.sMobileQQ.appActivities.add(new WeakReference(this));
    this.mOnCreateBundle = null;
    this.mRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    MobileQQ.sMobileQQ.appActivities.remove(new WeakReference(this));
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent) {}
  
  protected void doOnPause() {}
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    this.mPostCreateBundle = null;
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle) {}
  
  protected void doOnResume() {}
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  protected void doOnStart() {}
  
  protected void doOnStop() {}
  
  protected void doOnUserLeaveHint() {}
  
  protected void doOnWindowFocusChanged(boolean paramBoolean) {}
  
  public final AppRuntime getAppRuntime()
  {
    return this.mRuntime;
  }
  
  public void hideActionBar()
  {
    try
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().hide();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final boolean isResume()
  {
    return this.mIsResume;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.mIsSplashing) {
      doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      this.mIsResultWaiting = true;
      this.mRequestCode = paramInt1;
      this.mResultCode = paramInt2;
      this.mResultData = paramIntent;
    }
  }
  
  public void onBackPressed()
  {
    if (this.mIsSplashing) {
      return;
    }
    doOnBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mIsSplashing) {
      doOnConfigurationChanged(paramConfiguration);
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      requestFeature();
    }
    supportRequestWindowFeature(8);
    try
    {
      this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
      if (this.mIsSplashing)
      {
        this.mOnCreateBundle = paramBundle;
        forceShowOverflowMenu();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        try
        {
          doOnCreate(paramBundle);
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    if ((!this.mIsSplashing) || (this.mIsFinishingInOnCreate)) {
      doOnDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.mIsSplashing) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (paramInt == 82) {}
      try
      {
        ActionBar localActionBar = getSupportActionBar();
        bool1 = bool2;
        if (localActionBar == null) {
          continue;
        }
        Object localObject = null;
        if ((localActionBar instanceof ActionBarImplJB)) {
          localObject = localActionBar.getClass().getSuperclass().getDeclaredField("mActionBar");
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((Field)localObject).setAccessible(true);
            localObject = ((Field)localObject).get(localActionBar);
            bool1 = bool2;
            if (localObject == null) {
              break;
            }
          }
          return doOnKeyDown(paramInt, paramKeyEvent);
          if (localActionBar.getClass().getName().equals("android.support.v7.app.ActionBarImplICS")) {
            localObject = localActionBar.getClass().getDeclaredField("mActionBar");
          }
        }
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
      }
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.mIsSplashing) {}
    try
    {
      doOnNewIntent(paramIntent);
      return;
    }
    catch (Exception paramIntent) {}
    this.mNewIntent = paramIntent;
    return;
  }
  
  protected void onPause()
  {
    if (!this.mIsSplashing) {
      doOnPause();
    }
    int i = sResumeCount - 1;
    sResumeCount = i;
    if ((i <= 0) && (this.mRuntime != null)) {
      this.mRuntime.isBackground_Pause = true;
    }
    this.mIsResume = false;
    super.onPause();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnPostCreate(paramBundle);
      return;
    }
    this.mPostCreateBundle = paramBundle;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.permissionManager.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnRestoreInstanceState(paramBundle);
      return;
    }
    this.mOnRestoreBundle = paramBundle;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mIsResume = true;
    int i = sResumeCount + 1;
    sResumeCount = i;
    if ((i > 0) && (this.mRuntime != null)) {
      this.mRuntime.isBackground_Pause = false;
    }
    if (!this.mIsSplashing) {
      doOnResume();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mIsSplashing) {
      doOnSaveInstanceState(paramBundle);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    int i = ApplicationLifeController.getController().getVisibleActivityCount();
    ApplicationLifeController.getController().onActivityStart(this);
    if ((i == 0) && (this.mRuntime != null))
    {
      this.mRuntime.getApplication().delStateFile();
      this.mRuntime.onRunningForeground();
    }
    try
    {
      if (!this.mIsSplashing)
      {
        doOnStart();
        getSupportActionBar().show();
        return;
      }
      this.mIsStartSkipped = true;
      getSupportActionBar().hide();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onStop()
  {
    ApplicationLifeController.getController().onActivityStop(this);
    if ((ApplicationLifeController.getController().getVisibleActivityCount() == 0) && (this.mRuntime != null))
    {
      this.mRuntime.saveLastAccountState();
      this.mRuntime.onRunningBackground(null);
    }
    if (!this.mIsSplashing) {
      doOnStop();
    }
    for (;;)
    {
      super.onStop();
      return;
      this.mIsStartSkipped = false;
    }
  }
  
  protected void onUserLeaveHint()
  {
    if (!this.mIsSplashing) {
      doOnUserLeaveHint();
    }
    super.onUserLeaveHint();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    MobileQQ.sMobileQQ.onActivityFocusChanged(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (!this.mIsSplashing)
    {
      doOnWindowFocusChanged(paramBoolean);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mWindowFocusState = i;
      return;
    }
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return false;
  }
  
  public void preloadUi() {}
  
  public void realOnCreate()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.mIsSplashing)
    {
      this.mIsSplashing = false;
      bool1 = false;
    }
    try
    {
      boolean bool3 = doOnCreate(this.mOnCreateBundle);
      bool1 = bool3;
    }
    catch (Exception localException2)
    {
      label27:
      AppRuntime localAppRuntime;
      break label27;
    }
    if ((bool1) && (!isFinishing()))
    {
      localAppRuntime = this.mRuntime;
      if ((sResumeCount <= 0) && (BaseActivity.sResumeCount <= 0)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      localAppRuntime.isBackground_Pause = bool1;
      localAppRuntime = this.mRuntime;
      if (ApplicationLifeController.getController().getVisibleActivityCount() <= 0)
      {
        bool1 = true;
        label81:
        localAppRuntime.isBackground_Stop = bool1;
        if (this.mIsStartSkipped)
        {
          doOnStart();
          this.mIsStartSkipped = false;
          if (this.mOnRestoreBundle != null)
          {
            doOnRestoreInstanceState(this.mOnRestoreBundle);
            this.mOnRestoreBundle = null;
          }
          doOnPostCreate(this.mPostCreateBundle);
          if (this.mIsResultWaiting)
          {
            doOnActivityResult(this.mRequestCode, this.mResultCode, this.mResultData);
            this.mIsResultWaiting = false;
            this.mResultData = null;
          }
          if (this.mNewIntent == null) {}
        }
      }
      try
      {
        doOnNewIntent(this.mNewIntent);
        label179:
        this.mNewIntent = null;
        if (isResume()) {
          doOnResume();
        }
        if (this.mWindowFocusState != -1)
        {
          if (this.mWindowFocusState != 1) {
            break label229;
          }
          bool1 = bool2;
          label213:
          doOnWindowFocusChanged(bool1);
        }
        label229:
        do
        {
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label81;
          bool1 = false;
          break label213;
        } while (!isFinishing());
        this.mIsSplashing = true;
        this.mIsFinishingInOnCreate = true;
        return;
      }
      catch (Exception localException1)
      {
        break label179;
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent) {}
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
  }
  
  public boolean showPreview()
  {
    return false;
  }
  
  public void superFinish()
  {
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.AppActivity
 * JD-Core Version:    0.7.0.1
 */