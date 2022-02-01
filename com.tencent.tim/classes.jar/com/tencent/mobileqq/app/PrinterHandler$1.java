package com.tencent.mobileqq.app;

import acde;
import acio;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterHandler$1
  extends TimerTask
{
  public PrinterHandler$1(acio paramacio, acde paramacde, Timer paramTimer) {}
  
  public void run()
  {
    if (this.this$0.iX.size() > 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, " pc下线了");
      }
      while (this.this$0.iX.size() > 0)
      {
        Iterator localIterator = this.this$0.iX.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          this.d.g(0, l, true);
          this.this$0.a(Long.valueOf(l), false);
        }
      }
    }
    this.B.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.1
 * JD-Core Version:    0.7.0.1
 */