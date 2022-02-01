package com.tencent.mobileqq.startup.step;

import anpr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LoadDex$4
  implements Runnable
{
  LoadDex$4(LoadDex paramLoadDex) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.a().onProcessStart();
      Step.a.b(30, this.this$0.mDirector, null).step();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDex", 2, "", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex.4
 * JD-Core Version:    0.7.0.1
 */