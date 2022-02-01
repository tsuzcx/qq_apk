package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import ppf;
import ppi;
import ppm;
import qoo;
import rar;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
{
  protected ppi<QQStoryFriendSettings> a = ppf.a(qoo.class, ppm.d(ppi.class), new Object[0]);
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a.j(this, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.onDestroy(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    rar.R(7, this.currentActivityStayTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettings
 * JD-Core Version:    0.7.0.1
 */