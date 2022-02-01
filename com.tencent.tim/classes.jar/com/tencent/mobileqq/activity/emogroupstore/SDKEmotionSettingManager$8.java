package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import zdf;

public class SDKEmotionSettingManager$8
  implements Runnable
{
  public SDKEmotionSettingManager$8(zdf paramzdf) {}
  
  public void run()
  {
    if (zdf.a(this.this$0).isFinishing())
    {
      QLog.i("SDKEmotionSettingManager", 1, "refreshEmotionRunnable -->activity finish");
      return;
    }
    zdf.a(this.this$0).sendBroadcast(new Intent("com.tencent.mobileqq.action.refresh.emotiom"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.8
 * JD-Core Version:    0.7.0.1
 */