package com.tencent.qqmail.InlineImage.timing;

import android.os.SystemClock;
import android.util.Log;

public class ReadMailTimer
{
  public static final String TAG = "ReadMailTimer";
  private static long endTime = -1L;
  private static String mailid = "";
  private static long startTime = -1L;
  
  public static void dump()
  {
    Log.i("ReadMailTimer", String.format("Mail[%s] cost-time[%s]", new Object[] { mailid + "", endTime - startTime + "" }));
    startTime = -1L;
    endTime = -1L;
  }
  
  public static void start(String paramString)
  {
    Log.i("ReadMailTimer", "Start " + paramString);
    if (startTime != -1L) {
      dump();
    }
    mailid = paramString;
    startTime = SystemClock.elapsedRealtime();
  }
  
  public static void updateLastTime()
  {
    Log.i("ReadMailTimer", "updateLastTime " + mailid);
    endTime = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.timing.ReadMailTimer
 * JD-Core Version:    0.7.0.1
 */