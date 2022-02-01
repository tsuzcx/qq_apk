package com.tencent.mobileqq.activity.phone;

import android.widget.Button;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import zqz;

public class PhoneLaunchActivity$1
  implements Runnable
{
  PhoneLaunchActivity$1(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void run()
  {
    if (!aqiw.isNetSupport(this.this$0))
    {
      this.this$0.showToast(2131696348);
      PhoneLaunchActivity.a(this.this$0).setEnabled(true);
      return;
    }
    if (this.this$0.k == null)
    {
      this.this$0.k = new zqz(this);
      this.this$0.app.registObserver(this.this$0.k);
    }
    this.this$0.app.execute(new PhoneLaunchActivity.1.2(this));
    this.this$0.j(2131719519, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1
 * JD-Core Version:    0.7.0.1
 */