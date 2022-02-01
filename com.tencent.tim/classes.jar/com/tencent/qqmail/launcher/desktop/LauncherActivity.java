package com.tencent.qqmail.launcher.desktop;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.launcher.base.WelcomeLoader;
import com.tencent.qqmail.utilities.thread.Threads;

public class LauncherActivity
  extends Activity
{
  public static final String TAG = "LauncherActivity";
  
  private void initForPush()
  {
    Threads.runInBackground(new LauncherActivity.2(this));
  }
  
  private void wakeup()
  {
    LauncherUtils.gotoMainPage(this);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initForPush();
    if (!isTaskRoot())
    {
      finish();
      return;
    }
    getWindow().setWindowAnimations(0);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setContentView(2131559460);
    boolean bool = LauncherUtils.wakeup;
    LauncherUtils.wakeup = true;
    if (bool)
    {
      if (!WelcomeLoader.getInstance().isFinish()) {
        break label80;
      }
      wakeup();
    }
    for (;;)
    {
      finish();
      return;
      label80:
      WelcomeLoader.getInstance().registerCallback(new LauncherActivity.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.desktop.LauncherActivity
 * JD-Core Version:    0.7.0.1
 */