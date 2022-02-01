package com.tencent.mobileqq.activity.aio;

import aagd;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$3
  implements Runnable
{
  CustomizeStrategyFactory$3(CustomizeStrategyFactory paramCustomizeStrategyFactory, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      this.val$info.e = aagd.a(this.val$info.a.aSI);
      this.val$info.bdQ = true;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "preProcessAnim-preProcess finished");
      }
      CustomizeStrategyFactory.a().b(this.val$info);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CustomizeStrategyFactory", 2, "preProcessAnim-throw:" + localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.3
 * JD-Core Version:    0.7.0.1
 */