package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.util.QLog;

class m
  extends Thread
{
  m(l paraml) {}
  
  public void run()
  {
    c.a().onServiceConnected();
    int i = this.a.registerMsfService(false, true);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.Proxy", 2, " registerMsfService result:" + i);
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.m
 * JD-Core Version:    0.7.0.1
 */