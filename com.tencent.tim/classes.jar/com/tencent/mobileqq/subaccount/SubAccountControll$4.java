package com.tencent.mobileqq.subaccount;

import anxk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SubAccountControll$4
  implements Runnable
{
  public SubAccountControll$4(anxk paramanxk) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      if (this.this$0.app != null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.this$0.app.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((this.this$0.app != null) && (this.this$0.app.isRunning())) {
        this.this$0.app.d(false, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControll.4
 * JD-Core Version:    0.7.0.1
 */