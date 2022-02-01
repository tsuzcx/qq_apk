package com.huawei.hms.framework.common;

import android.os.SystemClock;

public class Utils
{
  public static long getCurrentTime(boolean paramBoolean)
  {
    if (paramBoolean) {
      return SystemClock.elapsedRealtime();
    }
    return System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.common.Utils
 * JD-Core Version:    0.7.0.1
 */