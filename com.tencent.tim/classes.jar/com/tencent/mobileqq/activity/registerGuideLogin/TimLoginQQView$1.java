package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class TimLoginQQView$1
  implements Runnable
{
  TimLoginQQView$1(TimLoginQQView paramTimLoginQQView) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    this.this$0.zH.getLocationOnScreen(arrayOfInt);
    TimLoginQQView localTimLoginQQView = this.this$0;
    int i = this.this$0.rm.getHeight();
    TimLoginQQView.a(localTimLoginQQView, arrayOfInt[1] + i - (int)(TimLoginQQView.a(this.this$0) * 7.0F + 0.5F));
    QLog.d("LoginActivity.TimLoginQQView", 2, "down bottomLine" + TimLoginQQView.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.1
 * JD-Core Version:    0.7.0.1
 */