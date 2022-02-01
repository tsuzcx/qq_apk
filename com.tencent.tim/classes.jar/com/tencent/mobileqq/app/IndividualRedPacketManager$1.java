package com.tencent.mobileqq.app;

import acgn;
import aqqf;
import aqqf.e;
import com.tencent.qphone.base.util.QLog;

public class IndividualRedPacketManager$1
  implements Runnable
{
  public IndividualRedPacketManager$1(acgn paramacgn) {}
  
  public void run()
  {
    this.this$0.EY(true);
    if (QLog.isColorLevel()) {
      QLog.d(acgn.access$000(), 2, "AIO_BG_WIDTH:" + this.this$0.cvT);
    }
    this.this$0.a().eeW();
    this.this$0.a().initResource();
    this.this$0.cJq();
    if (this.this$0.cvZ > 0)
    {
      aqqf.e locale = this.this$0.a().a(String.valueOf(this.this$0.cvZ), true);
      if ((locale == null) || (locale.a == null) || (locale.b == null) || (locale.c == null)) {
        this.this$0.a().v(16L, String.valueOf(this.this$0.cvZ), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */