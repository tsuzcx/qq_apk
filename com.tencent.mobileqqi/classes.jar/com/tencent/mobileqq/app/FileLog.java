package com.tencent.mobileqq.app;

import android.text.format.Time;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileLog
{
  private static FileOutputStream a = null;
  
  private static String a(long paramLong)
  {
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if (localTime1.year != localTime2.year) {
      return localTime1.format("%Y-%m-%d %H:%M:%S");
    }
    if (localTime1.yearDay != localTime2.yearDay) {
      return localTime1.format("%m-%d %H:%M:%S");
    }
    return localTime1.format("%H:%M:%S");
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (a == null) {
        a = new FileOutputStream("/sdcard/liteqqlog.txt", true);
      }
      try
      {
        label19:
        paramString = a(System.currentTimeMillis()) + " : " + paramString + "\r\n";
        if (a != null) {
          a.write(paramString.getBytes());
        }
        try
        {
          label69:
          if (a != null) {
            a.flush();
          }
          return;
        }
        catch (IOException paramString) {}
      }
      catch (IOException paramString)
      {
        break label69;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FileLog
 * JD-Core Version:    0.7.0.1
 */