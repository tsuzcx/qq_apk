package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import com.tencent.token.agn;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

public final class SQLiteDebug
{
  private static volatile int a;
  private static volatile ArrayList<IOTraceStats> b;
  
  static {}
  
  static void a(SQLiteConnection paramSQLiteConnection)
  {
    try
    {
      a = nativeGetLastErrorLine();
      localObject = new ArrayList();
      long l = paramSQLiteConnection.a(null);
      if (l != 0L)
      {
        nativeGetIOTraceStats(l, (ArrayList)localObject);
        paramSQLiteConnection.a();
      }
      b = (ArrayList)localObject;
      return;
    }
    catch (RuntimeException paramSQLiteConnection)
    {
      Object localObject = new StringBuilder("Cannot collect I/O trace statistics: ");
      ((StringBuilder)localObject).append(paramSQLiteConnection.getMessage());
      Log.a("WCDB.SQLiteDebug", ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      a = nativeGetLastErrorLine();
      localObject = new ArrayList();
      agn localagn = paramSQLiteDatabase.b();
      localagn.a(null, 2, null);
      long l = localagn.a.a("collectIoStat");
      if (l != 0L)
      {
        if (l != 0L) {
          nativeGetIOTraceStats(l, (ArrayList)localObject);
        }
        paramSQLiteDatabase = paramSQLiteDatabase.b();
        if (paramSQLiteDatabase.a != null) {
          paramSQLiteDatabase.a.a();
        }
        paramSQLiteDatabase.b();
        b = (ArrayList)localObject;
        return;
      }
      throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    }
    catch (RuntimeException paramSQLiteDatabase)
    {
      Object localObject = new StringBuilder("Cannot collect I/O trace statistics: ");
      ((StringBuilder)localObject).append(paramSQLiteDatabase.getMessage());
      Log.a("WCDB.SQLiteDebug", ((StringBuilder)localObject).toString());
    }
  }
  
  public static final boolean a(long paramLong)
  {
    return paramLong > 300L;
  }
  
  private static native void nativeGetIOTraceStats(long paramLong, ArrayList<IOTraceStats> paramArrayList);
  
  private static native int nativeGetLastErrorLine();
  
  private static native void nativeGetPagerStats(PagerStats paramPagerStats);
  
  private static native void nativeSetIOTraceFlags(int paramInt);
  
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
      paramString = new StringBuilder();
      paramString.append(paramInt2);
      paramString.append("/");
      paramString.append(paramInt3);
      paramString.append("/");
      paramString.append(paramInt4);
      this.cache = paramString.toString();
    }
  }
  
  public static class IOTraceStats
  {
    public String dbName;
    public String journalMode;
    public long lastJournalReadOffset;
    public byte[] lastJournalReadPage;
    public long lastJournalWriteOffset;
    public byte[] lastJournalWritePage;
    public long lastReadOffset;
    public byte[] lastReadPage;
    public long lastWriteOffset;
    public byte[] lastWritePage;
    public long pageCount;
    public long pageSize;
    public String path;
    
    @SuppressLint({"DefaultLocale"})
    public String toString()
    {
      return String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", new Object[] { this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset) });
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
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug
 * JD-Core Version:    0.7.0.1
 */