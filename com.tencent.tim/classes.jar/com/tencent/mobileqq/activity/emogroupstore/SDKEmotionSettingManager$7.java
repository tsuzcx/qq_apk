package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import zdf;

public class SDKEmotionSettingManager$7
  implements Runnable
{
  public SDKEmotionSettingManager$7(zdf paramzdf) {}
  
  public void run()
  {
    if (zdf.a(this.this$0).isFinishing())
    {
      QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->activity finish");
      return;
    }
    QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->preForward--fetch openid timeout");
    this.this$0.aRg = true;
    this.this$0.hideProgressDialog();
    zdf.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7
 * JD-Core Version:    0.7.0.1
 */