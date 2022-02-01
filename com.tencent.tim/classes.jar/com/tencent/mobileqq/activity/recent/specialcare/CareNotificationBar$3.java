package com.tencent.mobileqq.activity.recent.specialcare;

import aamm;
import android.view.View;

public class CareNotificationBar$3
  implements Runnable
{
  public CareNotificationBar$3(aamm paramaamm) {}
  
  public void run()
  {
    if ((aamm.a(this.this$0) > 0) || (aamm.b(this.this$0) > 0))
    {
      aamm.a(this.this$0);
      this.this$0.updateText();
    }
    while (aamm.a(this.this$0) == null) {
      return;
    }
    aamm.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3
 * JD-Core Version:    0.7.0.1
 */