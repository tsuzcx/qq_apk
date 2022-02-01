package com.tencent.tim.cloudfile.wps;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.app.MobileQQ;

public class WPSListActivity
  extends QQBrowserActivity
{
  private AppInterface mApp;
  
  public WPSListActivity()
  {
    this.s = WPSListWebFragment.class;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    if (this.mApp == null) {
      this.mApp = getAppInterface();
    }
    return super.doOnCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.wps.WPSListActivity
 * JD-Core Version:    0.7.0.1
 */