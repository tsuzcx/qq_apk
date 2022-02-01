package com.tencent.mobileqq.apollo.process.data;

import abow;
import aboy;
import com.tencent.qphone.base.util.QLog;

public class CmGameLifeCycle$1
  implements Runnable
{
  public CmGameLifeCycle$1(abow paramabow, aboy paramaboy) {}
  
  public void run()
  {
    this.b.cDO();
    this.b.cDP();
    if (QLog.isColorLevel()) {
      QLog.d(abow.TAG, 2, "onCurrentGame showMsgTips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle.1
 * JD-Core Version:    0.7.0.1
 */