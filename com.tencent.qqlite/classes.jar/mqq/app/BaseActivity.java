package mqq.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class BaseActivity
  extends Activity
{
  protected static int sResumeCount = 0;
  private AppRuntime app;
  private boolean isResume;
  protected boolean mIsShadow;
  private MobileQQ mqq;
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Free Activity]" + getClass().getSimpleName());
    }
  }
  
  public final AppRuntime getAppRuntime()
  {
    return this.app;
  }
  
  protected boolean isLatecyWaitRuntime()
  {
    return false;
  }
  
  public final boolean isResume()
  {
    return this.isResume;
  }
  
  protected boolean isShadow()
  {
    return false;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    onCreateNoRuntime(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreate");
    }
    if (!isLatecyWaitRuntime()) {
      waitAppRuntime();
    }
  }
  
  protected void onCreateNoRuntime(Bundle paramBundle)
  {
    this.mIsShadow = isShadow();
    if (!this.mIsShadow) {
      super.onCreate(paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreateNoRuntime");
    }
    this.mqq = MobileQQ.getMobileQQ();
    this.mqq.addActivity(this);
  }
  
  protected void onDestroy()
  {
    if (!this.mIsShadow) {
      super.onDestroy();
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onDestroy");
    }
    this.mqq.removeActivity(this);
    this.mqq = null;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  protected void onPause()
  {
    if (!this.mIsShadow) {
      super.onPause();
    }
    int i = sResumeCount - 1;
    sResumeCount = i;
    if ((i <= 0) && (this.app != null)) {
      this.app.isBackground_Pause = true;
    }
    this.isResume = false;
  }
  
  protected void onResume()
  {
    if (!this.mIsShadow) {
      super.onResume();
    }
    int i = sResumeCount + 1;
    sResumeCount = i;
    if ((i > 0) && (this.app != null)) {
      this.app.isBackground_Pause = false;
    }
    this.isResume = true;
  }
  
  protected void onStart()
  {
    if (!this.mIsShadow) {
      super.onStart();
    }
    int i = ApplicationLifeController.getController().getVisibleActivityCount();
    ApplicationLifeController.getController().onActivityStart(this);
    if ((i == 0) && (this.app != null))
    {
      this.app.getApplication().delStateFile();
      this.app.onRunningForeground();
    }
  }
  
  protected void onStop()
  {
    if (!this.mIsShadow) {
      super.onStop();
    }
    ApplicationLifeController.getController().onActivityStop(this);
    if ((ApplicationLifeController.getController().getVisibleActivityCount() == 0) && (this.app != null))
    {
      this.app.saveLastAccountState();
      Bundle localBundle = new Bundle();
      this.app.onRunningBackground(localBundle);
    }
  }
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public final void superFinish()
  {
    super.finish();
  }
  
  public AppRuntime waitAppRuntime()
  {
    this.app = this.mqq.waitAppRuntime(this);
    return this.app;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */