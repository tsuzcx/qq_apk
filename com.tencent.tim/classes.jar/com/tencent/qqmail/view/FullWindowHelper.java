package com.tencent.qqmail.view;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.log.QMLog;

public class FullWindowHelper
{
  public static String TAG = "FullWindowHelper";
  
  public static void changeToFullScreen(Window paramWindow, Activity paramActivity)
  {
    try
    {
      paramWindow.setFlags(1024, 1024);
      if (VersionUtils.hasKitKat()) {
        StatusBarUtil.hideStatusBarView(paramActivity);
      }
      return;
    }
    catch (Exception paramWindow)
    {
      QMLog.log(6, TAG, "changeToFullScreen exp:" + paramWindow.toString());
    }
  }
  
  public static void changeToFullScreenSaveNavigationBar(Window paramWindow, Activity paramActivity)
  {
    if (paramWindow != null) {}
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i = 1284;
        if (Build.VERSION.SDK_INT >= 19) {
          i = 5380;
        }
        paramWindow.getDecorView().setSystemUiVisibility(i);
        paramWindow.addFlags(1024);
        if (StatusBarUtil.availableVersion()) {
          StatusBarUtil.hideStatusBarView(paramActivity);
        }
      }
      return;
    }
    catch (Exception paramWindow)
    {
      QMLog.log(6, TAG, "changeToFullScreenSaveNavigationBar exp:" + paramWindow.toString());
    }
  }
  
  public static void changeToNotFullScreen(Window paramWindow, Activity paramActivity)
  {
    try
    {
      paramWindow.clearFlags(1024);
      if ((VersionUtils.hasKitKat()) && (!VersionUtils.hasLolipop())) {
        StatusBarUtil.showStatusBarView(paramActivity);
      }
      return;
    }
    catch (Exception paramWindow)
    {
      QMLog.log(6, TAG, "changeToNotFullScreen exp:" + paramWindow.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FullWindowHelper
 * JD-Core Version:    0.7.0.1
 */