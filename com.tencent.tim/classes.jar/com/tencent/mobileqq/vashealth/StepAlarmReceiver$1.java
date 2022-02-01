package com.tencent.mobileqq.vashealth;

import aqtz;
import com.tencent.mobileqq.app.QQAppInterface;

class StepAlarmReceiver$1
  implements Runnable
{
  StepAlarmReceiver$1(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    if (this.this$0.mApp == null) {
      return;
    }
    ((aqtz)this.this$0.mApp.getManager(260)).efF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.1
 * JD-Core Version:    0.7.0.1
 */