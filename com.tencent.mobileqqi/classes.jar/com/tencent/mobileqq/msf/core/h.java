package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.sdk.n;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;

final class h
  extends Thread
{
  public void run()
  {
    File localFile = new File(n.b());
    try
    {
      e.c();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          boolean bool = e.a(localFile);
          if (!bool) {
            continue;
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          QLog.e(e.a, 1, "run: failed. ", localThrowable1);
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.set(6, localCalendar.get(6) - 7);
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
          localCalendar.set(14, 0);
          localCalendar.getTimeInMillis();
        }
        localThrowable2 = localThrowable2;
        localThrowable2.printStackTrace();
        QLog.e(e.a, 1, "run: failed. ", localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.h
 * JD-Core Version:    0.7.0.1
 */