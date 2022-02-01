package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import asvt;
import com.tencent.qphone.base.util.QLog;

public class NavigationJsPlugin$1
  implements Runnable
{
  public NavigationJsPlugin$1(asvt paramasvt, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      if (!this.val$activity.moveTaskToBack(false)) {
        this.val$activity.finish();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("NavigationJsPlugin", 1, "Failed to moveTaskBack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */