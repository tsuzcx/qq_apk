package com.tencent.moai.database.sqlite;

import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;

public final class SQLiteDebug
{
  public static final boolean DEBUG_LOG_SLOW_QUERIES = false;
  public static final boolean DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
  public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
  public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
  
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
  
  public static PagerStats getDatabaseInfo()
  {
    PagerStats localPagerStats = new PagerStats();
    nativeGetPagerStats(localPagerStats);
    localPagerStats.dbStats = SQLiteDatabase.getDbStats();
    return localPagerStats;
  }
  
  private static native void nativeGetPagerStats(PagerStats paramPagerStats);
  
  public static final boolean shouldLogSlowQuery(long paramLong)
  {
    return paramLong >= 10000;
  }
  
  public static class DbStats
  {
    public String cache;
    public String dbName;
    public long dbSize;
    public int lookaside;
    public long pageSize;
    
    public DbStats(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.dbName = paramString;
      this.pageSize = (paramLong2 / 1024L);
      this.dbSize = (paramLong1 * paramLong2 / 1024L);
      this.lookaside = paramInt1;
      this.cache = (paramInt2 + "/" + paramInt3 + "/" + paramInt4);
    }
  }
  
  public static final class Log
  {
    private static int level = 0;
    private static SQLiteDebug.SQLiteLogger logger = new SQLiteDebug.Logcat();
    
    public static void d(String paramString1, String paramString2)
    {
      if (level <= 3) {
        logger.d(paramString1, paramString2);
      }
    }
    
    public static void d(String paramString1, String paramString2, Throwable paramThrowable)
    {
      if (level <= 3) {
        logger.d(paramString1, paramString2 + ", " + paramThrowable.toString());
      }
    }
    
    public static void e(String paramString1, String paramString2)
    {
      if (level <= 6) {
        logger.e(paramString1, paramString2);
      }
    }
    
    public static void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      if (level <= 6) {
        logger.e(paramString1, paramString2 + ", " + paramThrowable.toString());
      }
    }
    
    public static void i(String paramString1, String paramString2)
    {
      if (level <= 4) {
        logger.i(paramString1, paramString2);
      }
    }
    
    public static void i(String paramString1, String paramString2, Throwable paramThrowable)
    {
      if (level <= 4) {
        logger.i(paramString1, paramString2 + ", " + paramThrowable.toString());
      }
    }
    
    public static void setLevel(int paramInt)
    {
      level = paramInt;
    }
    
    public static void setLogger(SQLiteDebug.SQLiteLogger paramSQLiteLogger)
    {
      logger = paramSQLiteLogger;
    }
    
    public static void v(String paramString1, String paramString2)
    {
      if (level <= 2) {
        logger.v(paramString1, paramString2);
      }
    }
    
    public static void v(String paramString1, String paramString2, Throwable paramThrowable)
    {
      if (level <= 2) {
        logger.v(paramString1, paramString2 + ", " + paramThrowable.toString());
      }
    }
    
    public static void w(String paramString1, String paramString2)
    {
      if (level <= 5) {
        logger.w(paramString1, paramString2);
      }
    }
    
    public static void w(String paramString1, String paramString2, Throwable paramThrowable)
    {
      if (level <= 5) {
        logger.w(paramString1, paramString2 + ", " + paramThrowable.toString());
      }
    }
    
    public static void w(String paramString, Throwable paramThrowable)
    {
      if (level <= 5) {
        logger.w(paramString, paramThrowable.toString());
      }
    }
  }
  
  public static class Logcat
    implements SQLiteDebug.SQLiteLogger
  {
    public void d(String paramString1, String paramString2)
    {
      Log.d(paramString1, paramString2);
    }
    
    public void e(String paramString1, String paramString2)
    {
      Log.e(paramString1, paramString2);
    }
    
    public void i(String paramString1, String paramString2)
    {
      Log.i(paramString1, paramString2);
    }
    
    public void v(String paramString1, String paramString2)
    {
      Log.v(paramString1, paramString2);
    }
    
    public void w(String paramString1, String paramString2)
    {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static class PagerStats
  {
    public ArrayList<SQLiteDebug.DbStats> dbStats;
    public int largestMemAlloc;
    public int memoryUsed;
    public int pageCacheOverflow;
  }
  
  public static abstract interface SQLiteLogger
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteDebug
 * JD-Core Version:    0.7.0.1
 */