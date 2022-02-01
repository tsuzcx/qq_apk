package com.tencent.mobileqq.intervideo.now.lifecycle;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.IForeground;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class NowForegroundImpl
  implements IForeground
{
  WeakReference<Activity> mActivity;
  protected AppRuntime mRuntime;
  
  public NowForegroundImpl()
  {
    dsr();
  }
  
  public void dsr()
  {
    this.mRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  }
  
  public void onCreate(Context paramContext)
  {
    QLog.d("NowForegroundImpl", 2, "onCreate context = " + paramContext);
    Foreground.updateRuntimeState(this.mRuntime);
    if ((paramContext instanceof Activity)) {
      this.mActivity = new WeakReference((Activity)paramContext);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("NowForegroundImpl", 2, "onDestroy mRuntime = " + this.mRuntime);
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity != null) {
      Foreground.onDestroy(localActivity);
    }
  }
  
  public void onPause()
  {
    Foreground.onPause(this.mRuntime);
  }
  
  public void onResume()
  {
    Foreground.onResume(this.mRuntime);
  }
  
  public void onStart()
  {
    QLog.d("NowForegroundImpl", 2, "onStart mActivity = " + this.mActivity);
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity != null) {
      Foreground.onStart(this.mRuntime, localActivity);
    }
  }
  
  public void onStop()
  {
    QLog.d("NowForegroundImpl", 2, "onStop mRuntime = " + this.mRuntime);
    Foreground.onStop(this.mRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.lifecycle.NowForegroundImpl
 * JD-Core Version:    0.7.0.1
 */