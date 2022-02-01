package com.tencent.qqmail.monitor;

import android.database.Cursor;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class DatabaseMonitor
{
  public static final int ACTION_DELETE = 3;
  public static final int ACTION_REPLACE = 2;
  public static final int ACTION_SELECT = 1;
  private static final boolean ON = true;
  private static final String TAG = DatabaseMonitor.class.getSimpleName();
  private static DatabaseMonitor instance = null;
  private final ArrayList<WeakReference<CursorData>> cursorList = new ArrayList();
  private final ArrayList<SQLTime> sqltimeList = new ArrayList();
  
  public static DatabaseMonitor shareInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DatabaseMonitor();
      }
      DatabaseMonitor localDatabaseMonitor = instance;
      return localDatabaseMonitor;
    }
    finally {}
  }
  
  public void markCursor(String paramString, Cursor paramCursor)
  {
    this.cursorList.add(new WeakReference(new CursorData(paramString, paramCursor)));
  }
  
  public void markTime(String paramString, long paramLong)
  {
    this.sqltimeList.add(new SQLTime(paramString, paramLong));
  }
  
  public void toLogcat()
  {
    int k = 0;
    Log.w(TAG, "Cursor没有close");
    Iterator localIterator = this.cursorList.iterator();
    Object localObject;
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localObject = (CursorData)((WeakReference)localIterator.next()).get();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (!((CursorData)localObject).cursor.isClosed())
        {
          j = i + 1;
          Log.w(TAG, "  " + ((CursorData)localObject).sql);
        }
      }
    }
    Log.w(TAG, "没有close的cursor个数: " + i);
    this.cursorList.clear();
    Log.w(TAG, "超过100毫秒的sql语句");
    localIterator = this.sqltimeList.iterator();
    i = k;
    while (localIterator.hasNext())
    {
      localObject = (SQLTime)localIterator.next();
      if (((SQLTime)localObject).time > 100L)
      {
        i += 1;
        Log.w(TAG, " used time: " + localObject + ", sql: " + ((SQLTime)localObject).sql);
      }
    }
    Log.w(TAG, "大于100毫秒的sql个数: " + i);
    this.sqltimeList.clear();
  }
  
  static class CursorData
  {
    Cursor cursor;
    String sql;
    
    CursorData(String paramString, Cursor paramCursor)
    {
      this.cursor = paramCursor;
      this.sql = paramString;
    }
  }
  
  static class SQLTime
  {
    String sql;
    long time;
    
    SQLTime(String paramString, long paramLong)
    {
      this.sql = paramString;
      this.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.monitor.DatabaseMonitor
 * JD-Core Version:    0.7.0.1
 */