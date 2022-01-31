package com.tencent.kingkong.database;

import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class SQLiteDebug
{
  public static final boolean DEBUG_LOG_SLOW_QUERIES;
  public static final boolean DEBUG_SQL_LOG;
  public static final boolean DEBUG_SQL_STATEMENTS;
  public static final boolean DEBUG_SQL_TIME;
  
  static
  {
    boolean bool = true;
    DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
    DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
    if (getSystemDebuggable() == 1) {}
    for (;;)
    {
      DEBUG_LOG_SLOW_QUERIES = bool;
      return;
      bool = false;
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
  
  public static PagerStats getDatabaseInfo()
  {
    PagerStats localPagerStats = new PagerStats();
    nativeGetPagerStats(localPagerStats);
    localPagerStats.dbStats = SQLiteDatabase.getDbStats();
    return localPagerStats;
  }
  
  private static final int getSystemDebuggable()
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { "ro.debuggable", Integer.valueOf(0) })).intValue();
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private static native void nativeGetPagerStats(PagerStats paramPagerStats);
  
  public static final boolean shouldLogSlowQuery(long paramLong)
  {
    int i = -1;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int j = ((Integer)localClass.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { "db.log.slow_query_threshold", Integer.valueOf(-1) })).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      label61:
      break label61;
    }
    return (i >= 0) && (paramLong >= i);
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
  
  public static class PagerStats
  {
    public ArrayList<SQLiteDebug.DbStats> dbStats;
    public int largestMemAlloc;
    public int memoryUsed;
    public int pageCacheOverflow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteDebug
 * JD-Core Version:    0.7.0.1
 */