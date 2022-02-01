package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;

class af
  extends Thread
{
  af(ac paramac) {}
  
  public void run()
  {
    ac.b(this.a, true);
    int i = 0;
    while (i < ac.b(this.a).h)
    {
      i += 1;
      if (ac.c(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
        }
        try
        {
          Thread.sleep(ac.b(this.a).i);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQWiFiScanManager", 2, "accScan, count=" + i + ", stopped");
      }
    }
    ac.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.af
 * JD-Core Version:    0.7.0.1
 */