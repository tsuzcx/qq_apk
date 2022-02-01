package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import npa;

public class ReadInJoyGlobalReporter$1
  extends TimerTask
{
  public ReadInJoyGlobalReporter$1(npa paramnpa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyGlobalReporter", 2, "TimerTask heart = " + NetConnInfoCenter.getServerTimeMillis());
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      this.this$0.c(localQQAppInterface, NetConnInfoCenter.getServerTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.1
 * JD-Core Version:    0.7.0.1
 */