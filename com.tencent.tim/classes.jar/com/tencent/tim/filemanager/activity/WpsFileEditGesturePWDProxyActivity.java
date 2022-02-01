package com.tencent.tim.filemanager.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import auen;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class WpsFileEditGesturePWDProxyActivity
  extends BaseActivity
{
  private boolean diy;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setTitle(null);
    return bool;
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    if (this.diy)
    {
      QLog.i("WpsFileEditGesturePWDProxyActivity", 1, "[WPSEDIT] unlock callback. result:" + isUnLockSuccess);
      if (isUnLockSuccess) {
        auen.a(this, new Intent(getIntent()), new Bundle());
      }
      finish();
      overridePendingTransition(0, 0);
    }
    do
    {
      return;
      super.doOnResume();
    } while (this.diy);
    startUnlockActivity();
    this.diy = true;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void startUnlockActivity()
  {
    super.startUnlockActivity();
    this.diy = true;
    QLog.i("WpsFileEditGesturePWDProxyActivity", 1, "[WPSEDIT] startUnlockActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.WpsFileEditGesturePWDProxyActivity
 * JD-Core Version:    0.7.0.1
 */