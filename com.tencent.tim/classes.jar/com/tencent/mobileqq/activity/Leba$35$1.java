package com.tencent.mobileqq.activity;

import android.widget.TextView;
import aute;

class Leba$35$1
  implements Runnable
{
  Leba$35$1(Leba.35 param35, int paramInt) {}
  
  public void run()
  {
    if (this.val$num > 0)
    {
      if (Leba.c(this.a.this$0) != null) {
        Leba.c(this.a.this$0).setVisibility(0);
      }
      aute.updateCustomNoteTxt(Leba.c(this.a.this$0), 9, this.val$num, 0);
    }
    while (Leba.c(this.a.this$0) == null) {
      return;
    }
    Leba.c(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.1
 * JD-Core Version:    0.7.0.1
 */