package com.tencent.mobileqq.activity.recent.specialcare;

import aamm;
import android.view.View;

public class CareNotificationBar$1
  implements Runnable
{
  public CareNotificationBar$1(aamm paramaamm) {}
  
  public void run()
  {
    if (aamm.a(this.this$0) == null) {}
    while (aamm.a(this.this$0).getVisibility() != 0) {
      return;
    }
    aamm.a(this.this$0).clearAnimation();
    aamm.a(this.this$0).startAnimation(aamm.a(this.this$0));
    aamm.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1
 * JD-Core Version:    0.7.0.1
 */