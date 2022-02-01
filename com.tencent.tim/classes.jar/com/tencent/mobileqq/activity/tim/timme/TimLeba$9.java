package com.tencent.mobileqq.activity.tim.timme;

import aunq;
import aunr;
import mqq.os.MqqHandler;

class TimLeba$9
  implements Runnable
{
  TimLeba$9(TimLeba paramTimLeba) {}
  
  public void run()
  {
    boolean bool = this.this$0.XP();
    aunr localaunr = aunq.a().a(24L);
    if (localaunr != null)
    {
      localaunr.fV = Boolean.valueOf(bool);
      TimLeba.a(this.this$0).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.tim.timme.TimLeba.9
 * JD-Core Version:    0.7.0.1
 */