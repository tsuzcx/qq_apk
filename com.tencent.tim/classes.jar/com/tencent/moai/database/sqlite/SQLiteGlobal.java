package com.tencent.moai.database.sqlite;

import android.os.StatFs;

public final class SQLiteGlobal
{
  private static final String TAG = "SQLiteGlobal";
  private static int sDefaultPageSize;
  private static final Object sLock = new Object();
  
  public static String getDefaultJournalMode()
  {
    return "delete";
  }
  
  public static int getDefaultPageSize()
  {
    synchronized (sLock)
    {
      if (sDefaultPageSize == 0) {
        sDefaultPageSize = new StatFs("/data").getBlockSize();
      }
      int i = sDefaultPageSize;
      return i;
    }
  }
  
  public static String getDefaultSyncMode()
  {
    return "normal";
  }
  
  public static int getJournalSizeLimit()
  {
    return 10000;
  }
  
  public static int getWALAutoCheckpoint()
  {
    return Math.max(1, 1000);
  }
  
  public static int getWALConnectionPoolSize()
  {
    return Math.max(2, 4);
  }
  
  public static String getWALSyncMode()
  {
    return "normal";
  }
  
  private static native int nativeReleaseMemory();
  
  public static int releaseMemory()
  {
    return nativeReleaseMemory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteGlobal
 * JD-Core Version:    0.7.0.1
 */