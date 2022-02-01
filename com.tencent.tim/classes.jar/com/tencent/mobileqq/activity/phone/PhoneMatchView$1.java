package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import zrb;

public class PhoneMatchView$1
  implements Runnable
{
  PhoneMatchView$1(PhoneMatchView paramPhoneMatchView) {}
  
  public void run()
  {
    this.this$0.j(2131719519, 1000L, true);
    PhoneMatchView.a(this.this$0).sendEmptyMessageDelayed(0, 15000L);
    if (this.this$0.k == null)
    {
      this.this$0.k = new zrb(this);
      this.this$0.app.registObserver(this.this$0.k);
    }
    ThreadManager.excute(new PhoneMatchView.1.2(this), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView.1
 * JD-Core Version:    0.7.0.1
 */