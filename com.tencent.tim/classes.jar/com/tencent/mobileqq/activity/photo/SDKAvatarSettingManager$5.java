package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import zsi;

public class SDKAvatarSettingManager$5
  implements Runnable
{
  public SDKAvatarSettingManager$5(zsi paramzsi) {}
  
  public void run()
  {
    if (zsi.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "-->preForward--fetch openid timeout");
    }
    this.this$0.aRg = true;
    this.this$0.hideProgressDialog();
    zsi.a(this.this$0, zsi.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5
 * JD-Core Version:    0.7.0.1
 */