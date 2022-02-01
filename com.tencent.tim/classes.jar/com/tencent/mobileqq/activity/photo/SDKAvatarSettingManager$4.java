package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import zsi;

public class SDKAvatarSettingManager$4
  implements Runnable
{
  public SDKAvatarSettingManager$4(zsi paramzsi) {}
  
  public void run()
  {
    if (zsi.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    this.this$0.bqN = true;
    zsi.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.4
 * JD-Core Version:    0.7.0.1
 */