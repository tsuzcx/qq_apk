package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public final class SQLiteGlobal
{
  private static final String TAG = "WCDB.SQLiteGlobal";
  public static final String defaultJournalMode = "PERSIST";
  public static final int defaultPageSize;
  public static final String defaultSyncMode = "FULL";
  public static final int journalSizeLimit = 524288;
  public static final int walAutoCheckpoint = 100;
  public static final int walConnectionPoolSize = 4;
  public static final String walSyncMode = "FULL";
  
  static
  {
    if (!WCDBInitializationProbe.libLoaded) {
      System.loadLibrary("wcdb");
    }
    try
    {
      i = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
    }
    catch (RuntimeException localRuntimeException)
    {
      int i;
      label31:
      break label31;
    }
    i = 4096;
    defaultPageSize = i;
    nativeSetDefaultPageSize(i);
  }
  
  public static void loadLib() {}
  
  private static native int nativeReleaseMemory();
  
  private static native void nativeSetDefaultPageSize(int paramInt);
  
  public static int releaseMemory()
  {
    return nativeReleaseMemory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteGlobal
 * JD-Core Version:    0.7.0.1
 */