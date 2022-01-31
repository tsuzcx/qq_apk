package mqq.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class AppActivity
  extends Activity
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
  
  @Deprecated
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
  
  public final boolean isResume()
  {
    return this.mIsResume;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  @Deprecated
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
  
  @Deprecated
  public void onBackPressed()
  {
    if (this.mIsSplashing) {
      return;
    }
    doOnBackPressed();
  }
  
  @Deprecated
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mIsSplashing) {
      doOnConfigurationChanged(paramConfiguration);
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  @Deprecated
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    requestWindowFeature(localIntent);
    this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    super.onCreate(paramBundle);
    if (this.mIsSplashing)
    {
      this.mOnCreateBundle = paramBundle;
      return;
    }
    doOnCreate(paramBundle);
  }
  
  @Deprecated
  protected void onDestroy()
  {
    if ((!this.mIsSplashing) || (this.mIsFinishingInOnCreate)) {
      doOnDestroy();
    }
    super.onDestroy();
  }
  
  @Deprecated
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  @Deprecated
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.mIsSplashing)
    {
      doOnNewIntent(paramIntent);
      return;
    }
    this.mNewIntent = paramIntent;
  }
  
  @Deprecated
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
  
  @Deprecated
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
  
  @Deprecated
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
  
  @Deprecated
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
  
  @Deprecated
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mIsSplashing) {
      doOnSaveInstanceState(paramBundle);
    }
  }
  
  @Deprecated
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
    if (!this.mIsSplashing)
    {
      doOnStart();
      return;
    }
    this.mIsStartSkipped = true;
  }
  
  @Deprecated
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
  
  @Deprecated
  protected void onUserLeaveHint()
  {
    if (!this.mIsSplashing) {
      doOnUserLeaveHint();
    }
    super.onUserLeaveHint();
  }
  
  @Deprecated
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
    if (this.mIsSplashing)
    {
      this.mIsSplashing = false;
      if ((!doOnCreate(this.mOnCreateBundle)) || (isFinishing())) {
        break label224;
      }
      localAppRuntime = this.mRuntime;
      if ((sResumeCount > 0) || (BaseActivity.sResumeCount > 0)) {
        break label209;
      }
      bool1 = true;
      localAppRuntime.isBackground_Pause = bool1;
      localAppRuntime = this.mRuntime;
      if (ApplicationLifeController.getController().getVisibleActivityCount() > 0) {
        break label214;
      }
      bool1 = true;
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
        if (this.mNewIntent != null)
        {
          doOnNewIntent(this.mNewIntent);
          this.mNewIntent = null;
        }
        if (isResume()) {
          doOnResume();
        }
        if (this.mWindowFocusState != -1)
        {
          if (this.mWindowFocusState != 1) {
            break label219;
          }
          bool1 = bool2;
          doOnWindowFocusChanged(bool1);
        }
      }
    }
    label209:
    label214:
    label219:
    label224:
    while (!isFinishing()) {
      for (;;)
      {
        AppRuntime localAppRuntime;
        return;
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
    this.mIsSplashing = true;
    this.mIsFinishingInOnCreate = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.app.AppActivity
 * JD-Core Version:    0.7.0.1
 */