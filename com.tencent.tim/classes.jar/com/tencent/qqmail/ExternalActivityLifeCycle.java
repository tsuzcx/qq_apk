package com.tencent.qqmail;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.qqmail.paintpad.MailPaintPadActivity;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

public class ExternalActivityLifeCycle
  implements Application.ActivityLifecycleCallbacks
{
  private static final ArrayList<Class> EXTERNAL_ACTIVITY_WHITE_NAME_LIST = new ArrayList();
  private static final String TAG = "ExternalActivityLifeCycler";
  
  static
  {
    EXTERNAL_ACTIVITY_WHITE_NAME_LIST.add(MailPaintPadActivity.class);
    EXTERNAL_ACTIVITY_WHITE_NAME_LIST.add(WelcomeActivity.class);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (EXTERNAL_ACTIVITY_WHITE_NAME_LIST.contains(paramActivity.getClass()))
    {
      QMLog.log(4, "ExternalActivityLifeCycler", "onActivityPaused " + paramActivity.getComponentName());
      AppStatusUtil.willGotoBackground();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (EXTERNAL_ACTIVITY_WHITE_NAME_LIST.contains(paramActivity.getClass()))
    {
      QMLog.log(4, "ExternalActivityLifeCycler", "onActivityResumed " + paramActivity.getComponentName());
      if (!(paramActivity instanceof WelcomeActivity)) {
        GesturePasswordManager.getInstance().onActivityStarted(paramActivity, true);
      }
      AppStatusUtil.didGotoForeground();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.ExternalActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */