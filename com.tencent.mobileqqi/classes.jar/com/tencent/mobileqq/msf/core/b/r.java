package com.tencent.mobileqq.msf.core.b;

import com.tencent.qphone.base.util.QLog;

class r
  extends Thread
{
  r(q paramq) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(30000L);
      i.a(this.a.a);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.NetConnTag", 2, "checkIfNeedSignonNetAgainThread thread sleep exception" + localException, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.r
 * JD-Core Version:    0.7.0.1
 */