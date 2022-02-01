package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.util.QLog;

class s
  extends Thread
{
  s(q paramq) {}
  
  public void run()
  {
    c.a().onServiceConnected();
    int i = this.a.registerMsfService(false, true);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "registerMsfService result:" + i);
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.s
 * JD-Core Version:    0.7.0.1
 */