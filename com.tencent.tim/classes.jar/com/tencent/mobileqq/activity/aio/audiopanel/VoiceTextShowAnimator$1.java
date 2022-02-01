package com.tencent.mobileqq.activity.aio.audiopanel;

import java.util.TimerTask;
import wqs;
import wqs.a;

public class VoiceTextShowAnimator$1
  extends TimerTask
{
  public VoiceTextShowAnimator$1(wqs paramwqs) {}
  
  public void run()
  {
    int i = wqs.a(this.this$0) / 3;
    wqs.a(this.this$0, wqs.l()[(i % 3)]);
    if (wqs.a(this.this$0) != null) {
      wqs.a(this.this$0).caM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1
 * JD-Core Version:    0.7.0.1
 */