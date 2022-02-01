package com.tencent.mobileqq.activity;

import android.os.SystemClock;
import anpc;
import aqlr;
import aurf;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import zjq;

class Leba$10
  implements Runnable
{
  Leba$10(Leba paramLeba) {}
  
  public void run()
  {
    List localList = zjq.a().a(this.this$0.a(), this.this$0.app);
    this.this$0.e.post(new Leba.10.1(this, localList));
    if (Leba.a(this.this$0))
    {
      Leba.b(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.a(this.this$0);
      anpc.a(BaseApplication.getContext()).collectPerformance(aqlr.getUin(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10
 * JD-Core Version:    0.7.0.1
 */