package com.tencent.mobileqq.activity.miniaio;

import com.tencent.qphone.base.util.QLog;
import zof;

public class MiniPie$3
  implements Runnable
{
  public MiniPie$3(zof paramzof) {}
  
  public void run()
  {
    if (!this.this$0.brS) {
      zof.a(this.this$0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.this$0.TAG, 2, "EmotionPanel already added");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.3
 * JD-Core Version:    0.7.0.1
 */