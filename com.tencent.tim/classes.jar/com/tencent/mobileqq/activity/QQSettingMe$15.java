package com.tencent.mobileqq.activity;

import android.view.View;
import aqdj;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$15
  implements Runnable
{
  QQSettingMe$15(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    aqdj localaqdj = aqdj.a(this.this$0.app, this.val$uin, (byte)1);
    this.this$0.b.setFaceDrawable(this.this$0.app, localaqdj, 1, this.val$uin, 200, true, true, 6);
    this.this$0.ud.setVisibility(VasFaceManager.f(this.val$uin, this.this$0.app));
    this.this$0.bUf();
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "updateFace, " + this.val$uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.15
 * JD-Core Version:    0.7.0.1
 */