package com.tencent.mobileqq.app;

import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ProcessExitReceiver$1
  implements Runnable
{
  ProcessExitReceiver$1(ProcessExitReceiver paramProcessExitReceiver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getQQProcessName());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ProcessExitReceiver.1
 * JD-Core Version:    0.7.0.1
 */