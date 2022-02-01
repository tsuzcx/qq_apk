package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.os.Bundle;
import arib;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final boolean aRi = AppSetting.enableTalkBack;
  protected arib a;
  public boolean aWh;
  public boolean bkW;
  protected int cQc;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.cQc = getTitleBarHeight();
    this.a = new arib(this);
    this.bkW = getIntent().getBooleanExtra("abp_flag", false);
    this.aWh = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.aWh) && (!this.bkW)) {
      setLeftViewName(2131690700);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.a != null) {
      this.a.dismiss();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.bkW) {
      overridePendingTransition(2130772000, 2130772001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */