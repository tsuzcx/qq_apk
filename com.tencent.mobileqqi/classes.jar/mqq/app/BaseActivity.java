package mqq.app;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarImplJB;
import android.view.KeyEvent;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.app.permission.PermissionManager;

public class BaseActivity
  extends ActionBarActivity
{
  protected static int sResumeCount = 0;
  private AppRuntime app;
  private boolean isResume;
  protected boolean mIsShadow;
  private MobileQQ mqq;
  public PermissionManager permissionManager = PermissionManager.init(this);
  
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
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {}
    try
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        return true;
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
          if (localObject == null) {
            break;
          }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
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
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.permissionManager.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */