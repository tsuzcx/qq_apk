package com.tencent.wcdb.database;

import android.util.Printer;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

public final class SQLiteDebug
{
  private static final String TAG = "WCDB.SQLiteDebug";
  private static volatile int sLastErrorLine;
  private static volatile ArrayList sLastIOTraceStats;
  
  static {}
  
  static void collectLastIOTraceStats(SQLiteConnection paramSQLiteConnection)
  {
    try
    {
      sLastErrorLine = nativeGetLastErrorLine();
      ArrayList localArrayList = new ArrayList();
      long l = paramSQLiteConnection.getNativeHandle(null);
      if (l != 0L)
      {
        nativeGetIOTraceStats(l, localArrayList);
        paramSQLiteConnection.endNativeHandle(null);
      }
      sLastIOTraceStats = localArrayList;
      return;
    }
    catch (RuntimeException paramSQLiteConnection)
    {
      Log.e("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + paramSQLiteConnection.getMessage());
    }
  }
  
  static void collectLastIOTraceStats(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      sLastErrorLine = nativeGetLastErrorLine();
      ArrayList localArrayList = new ArrayList();
      long l = paramSQLiteDatabase.acquireNativeConnectionHandle("collectIoStat", false, false);
      if (l != 0L) {
        nativeGetIOTraceStats(l, localArrayList);
      }
      paramSQLiteDatabase.releaseNativeConnection(l, null);
      sLastIOTraceStats = localArrayList;
      return;
    }
    catch (RuntimeException paramSQLiteDatabase)
    {
      Log.e("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + paramSQLiteDatabase.getMessage());
    }
  }
  
  public static void dump(Printer paramPrinter, String[] paramArrayOfString)
  {
    boolean bool = false;
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("-v")) {
        bool = true;
      }
      i += 1;
    }
    SQLiteDatabase.dumpAll(paramPrinter, bool);
  }
  
  public static SQLiteDebug.PagerStats getDatabaseInfo()
  {
    SQLiteDebug.PagerStats localPagerStats = new SQLiteDebug.PagerStats();
    nativeGetPagerStats(localPagerStats);
    localPagerStats.dbStats = SQLiteDatabase.getDbStats();
    return localPagerStats;
  }
  
  public static int getLastErrorLine()
  {
    return sLastErrorLine;
  }
  
  public static ArrayList getLastIOTraceStats()
  {
    return sLastIOTraceStats;
  }
  
  private static native void nativeGetIOTraceStats(long paramLong, ArrayList paramArrayList);
  
  private static native int nativeGetLastErrorLine();
  
  private static native void nativeGetPagerStats(SQLiteDebug.PagerStats paramPagerStats);
  
  private static native void nativeSetIOTraceFlags(int paramInt);
  
  public static void setIOTraceFlags(int paramInt)
  {
    nativeSetIOTraceFlags(paramInt);
  }
  
  public static final boolean shouldLogSlowQuery(long paramLong)
  {
    return paramLong > 300L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug
 * JD-Core Version:    0.7.0.1
 */