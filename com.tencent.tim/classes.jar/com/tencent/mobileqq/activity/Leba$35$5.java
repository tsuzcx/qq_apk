package com.tencent.mobileqq.activity;

import android.widget.TextView;
import aute;
import com.tencent.qphone.base.util.QLog;

class Leba$35$5
  implements Runnable
{
  Leba$35$5(Leba.35 param35, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (this.bHW != -1)
      {
        if (Leba.a(this.a.this$0) != null) {
          Leba.a(this.a.this$0).setVisibility(0);
        }
        aute.updateCustomNoteTxt(Leba.a(this.a.this$0), this.bHW, this.val$num, 0);
        aute.a(this.a.this$0.a(), Leba.a(this.a.this$0), this.bHW, Leba.d(this.a.this$0));
        if (Leba.b(this.a.this$0) != null) {
          Leba.b(this.a.this$0).setVisibility(8);
        }
      }
      else if (Leba.a(this.a.this$0) != null)
      {
        Leba.a(this.a.this$0).setVisibility(8);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.5
 * JD-Core Version:    0.7.0.1
 */