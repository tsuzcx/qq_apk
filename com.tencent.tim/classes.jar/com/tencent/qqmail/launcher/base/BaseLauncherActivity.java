package com.tencent.qqmail.launcher.base;

import android.os.Bundle;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.WelcomeActivity;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseLauncherActivity
  extends BaseActivityEx
{
  private static final String TAG = "BaseLauncherActivity";
  private static AtomicBoolean sInit = new AtomicBoolean();
  
  public boolean canEnter()
  {
    return (!QMActivityManager.shareInstance().existPage(WelcomeActivity.class)) && (super.canEnter());
  }
  
  public boolean checkGesturePassword()
  {
    return false;
  }
  
  public boolean checkWelcomePopularize()
  {
    return false;
  }
  
  public void initDataSource()
  {
    QMServiceManager.setEnablePush(true);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", QMScheduledJobs.FromType.CLICK);
    QMScheduledJobs.doJobs(localBundle);
    Threads.runInBackground(new BaseLauncherActivity.1(this));
  }
  
  public void initDom() {}
  
  public void initUI() {}
  
  public boolean isMultiStartAllowed()
  {
    return true;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.BaseLauncherActivity
 * JD-Core Version:    0.7.0.1
 */