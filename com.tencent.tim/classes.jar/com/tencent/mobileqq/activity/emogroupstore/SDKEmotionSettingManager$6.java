package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import zdf;

public class SDKEmotionSettingManager$6
  implements Runnable
{
  public SDKEmotionSettingManager$6(zdf paramzdf) {}
  
  public void run()
  {
    if (zdf.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    this.this$0.bqN = true;
    zdf.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6
 * JD-Core Version:    0.7.0.1
 */