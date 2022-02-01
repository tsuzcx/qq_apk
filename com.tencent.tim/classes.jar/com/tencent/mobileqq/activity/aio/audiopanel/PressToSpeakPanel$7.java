package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import alic;
import android.widget.TextView;

class PressToSpeakPanel$7
  implements Runnable
{
  PressToSpeakPanel$7(PressToSpeakPanel paramPressToSpeakPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    if (PressToSpeakPanel.a(this.this$0).VY()) {
      this.this$0.jd(this.bQk);
    }
    if (PressToSpeakPanel.c(this.this$0) == 1)
    {
      if (this.this$0.RF())
      {
        PressToSpeakPanel.a(this.this$0).setText(acfp.m(2131709874));
        return;
      }
      PressToSpeakPanel.a(this.this$0).setText(acfp.m(2131709872));
      return;
    }
    if (PressToSpeakPanel.c(this.this$0) == 2)
    {
      PressToSpeakPanel.a(this.this$0).setText(acfp.m(2131709869));
      return;
    }
    PressToSpeakPanel.a(this.this$0).setText(AudioPanel.a(this.bF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.7
 * JD-Core Version:    0.7.0.1
 */