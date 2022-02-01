package com.tencent.mobileqq.qcall;

import alkq;
import com.tencent.qphone.base.util.QLog;

public class QCallProxy$1
  implements Runnable
{
  public QCallProxy$1(alkq paramalkq) {}
  
  public void run()
  {
    try
    {
      this.this$0.dGw();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QCallProxy", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.1
 * JD-Core Version:    0.7.0.1
 */