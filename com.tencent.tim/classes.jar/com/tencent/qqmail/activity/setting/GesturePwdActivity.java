package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;
import com.tencent.qqmail.utilities.thread.Threads;

public class GesturePwdActivity
  extends SettingGestureActivity
{
  public boolean checkGesturePassword()
  {
    return false;
  }
  
  public boolean checkWelcomePopularize()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onCreate(paramBundle, paramPersistableBundle);
    getWindow().setSoftInputMode(3);
  }
  
  public Intent onLastFinish()
  {
    return null;
  }
  
  public void onResume()
  {
    super.onResume();
    Threads.runOnMainThread(new GesturePwdActivity.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.GesturePwdActivity
 * JD-Core Version:    0.7.0.1
 */