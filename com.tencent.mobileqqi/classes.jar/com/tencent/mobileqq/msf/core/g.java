package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.sdk.n;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

final class g
  extends Thread
{
  public void run()
  {
    int k = 3;
    Object localObject = new File(n.b());
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length != 0)) {
        break label41;
      }
    }
    for (;;)
    {
      return;
      label41:
      Arrays.sort((Object[])localObject, new h(this));
      Calendar localCalendar = Calendar.getInstance();
      try
      {
        String str = a.c();
        if ((str == null) || (str.length() <= 0)) {
          break;
        }
        i = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l;
          localException.printStackTrace();
          int i = 3;
          continue;
          int j = i;
        }
      }
      j = k;
      if (i >= 1)
      {
        if (i <= 14) {
          break label242;
        }
        j = k;
      }
      localCalendar.add(6, j - j * 2);
      l = localCalendar.getTimeInMillis();
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localCalendar = localObject[i];
        if (QLog.isColorLevel()) {
          QLog.d(e.a, 2, "found log file " + localCalendar.getName());
        }
        if (l > localCalendar.lastModified())
        {
          localCalendar.delete();
          if (QLog.isColorLevel()) {
            QLog.d(e.a, 2, "del expires log " + localCalendar.getName());
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g
 * JD-Core Version:    0.7.0.1
 */