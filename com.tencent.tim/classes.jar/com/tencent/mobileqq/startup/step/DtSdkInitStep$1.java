package com.tencent.mobileqq.startup.step;

import anpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class DtSdkInitStep$1
  implements Runnable
{
  public void run()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      long l = System.currentTimeMillis();
      anpl.start();
      QLog.d("DtSdkInitStep", 1, "init beacon-dt success ! cost : " + (System.currentTimeMillis() - l) + " ms");
      return;
    }
    QLog.d("DtSdkInitStep", 1, "init beacon-dt error ! app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep.1
 * JD-Core Version:    0.7.0.1
 */