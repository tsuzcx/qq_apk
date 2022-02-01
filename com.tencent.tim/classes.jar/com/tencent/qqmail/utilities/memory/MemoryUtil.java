package com.tencent.qqmail.utilities.memory;

import android.os.Debug;
import com.tencent.qqmail.utilities.log.LogPathManager;
import java.io.IOException;

public class MemoryUtil
{
  public static String dumpHprofData()
  {
    String str = LogPathManager.getInstance().getHprofDataFilePath();
    try
    {
      Debug.dumpHprofData(str);
      return str;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str;
  }
  
  public static long getFreeMemorySize()
  {
    return Runtime.getRuntime().freeMemory() / 1048576L;
  }
  
  public static long getTotalMemorySize()
  {
    return Runtime.getRuntime().totalMemory() / 1048576L;
  }
  
  public static long getUsedMemorySize()
  {
    long l1 = -1L;
    try
    {
      Runtime localRuntime = Runtime.getRuntime();
      long l2 = localRuntime.freeMemory();
      long l3 = localRuntime.totalMemory();
      l1 = l3 - l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return l1 / 1048576L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.memory.MemoryUtil
 * JD-Core Version:    0.7.0.1
 */