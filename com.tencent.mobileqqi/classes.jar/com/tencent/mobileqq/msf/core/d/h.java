package com.tencent.mobileqq.msf.core.d;

import com.tencent.qphone.base.util.QLog;

class h
  extends Thread
{
  long a = 0L;
  
  public h(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
  }
  
  public void run()
  {
    
    try
    {
      f.a(0, this.a);
      f.b(this.b);
      f.c(this.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MSF.C.NetworkTraffic", 1, "makeReportRDMData error " + localException, localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.h
 * JD-Core Version:    0.7.0.1
 */