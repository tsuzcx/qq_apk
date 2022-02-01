package com.tencent.mobileqq.app;

import acio;
import anot;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterHandler$2
  extends TimerTask
{
  public PrinterHandler$2(acio paramacio, long paramLong, Timer paramTimer) {}
  
  public void run()
  {
    if (this.this$0.iX.containsKey(Long.valueOf(this.EN)))
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8004021", "0X8004021", (int)this.EN, -1, "", "", "", "");
      this.this$0.a(Long.valueOf(this.EN), false);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, "printID=" + this.EN + ", 超时到了");
      }
    }
    this.C.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.2
 * JD-Core Version:    0.7.0.1
 */