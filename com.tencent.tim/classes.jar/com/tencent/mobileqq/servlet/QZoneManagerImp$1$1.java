package com.tencent.mobileqq.servlet;

import aneo;
import anep;
import com.tencent.qphone.base.util.QLog;

public class QZoneManagerImp$1$1
  implements Runnable
{
  public QZoneManagerImp$1$1(anep paramanep) {}
  
  public void run()
  {
    long l = aneo.a(this.a.this$0);
    aneo.a(this.a.this$0);
    aneo.a(this.a.this$0, aneo.b(this.a.this$0));
    this.a.this$0.lm(l | aneo.a(this.a.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(aneo.a(this.a.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
 * JD-Core Version:    0.7.0.1
 */