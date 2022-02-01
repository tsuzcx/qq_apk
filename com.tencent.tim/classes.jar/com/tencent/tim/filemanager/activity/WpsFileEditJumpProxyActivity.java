package com.tencent.tim.filemanager.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import auen;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class WpsFileEditJumpProxyActivity
  extends BaseActivity
{
  private boolean diy;
  private boolean diz;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      super.doOnCreate(paramBundle);
      paramBundle = getCurrentAccountUin();
      if (((!mAppForground) || (("com.tencent.tim".equals(BaseApplicationImpl.processName)) && (!isUnLockSuccess))) && (this.mCanLock) && (paramBundle != null) && (GesturePWDUtils.getJumpLock(this, paramBundle)))
      {
        this.diz = true;
        return false;
      }
      auen.a(this, new Intent(getIntent()), new Bundle());
      finish();
      overridePendingTransition(0, 0);
      return false;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return false;
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    if (this.diy)
    {
      QLog.i("WpsFileEditJumpProxyActivity", 1, "[WPSEDIT] unlock callback. result:" + isUnLockSuccess);
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
    } while ((!this.diz) || (this.diy));
    startUnlockActivity();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void startUnlockActivity()
  {
    super.startUnlockActivity();
    this.diy = true;
    QLog.i("WpsFileEditJumpProxyActivity", 1, "[WPSEDIT] startUnlockActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.WpsFileEditJumpProxyActivity
 * JD-Core Version:    0.7.0.1
 */