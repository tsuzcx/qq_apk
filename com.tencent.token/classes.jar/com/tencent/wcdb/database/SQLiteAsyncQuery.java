package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteAsyncQuery
  extends SQLiteProgram
{
  private static final String TAG = "WCDB.SQLiteAsyncQuery";
  private final int mResultColumns = getColumnNames().length;
  
  public SQLiteAsyncQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
  }
  
  private static native int nativeCount(long paramLong);
  
  private static native int nativeFillRows(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  void acquire()
  {
    if (this.mPreparedStatement == null)
    {
      acquirePreparedStatement();
      this.mPreparedStatement.bindArguments(getBindArgs());
    }
  }
  
  int fillRows(ChunkedCursorWindow paramChunkedCursorWindow, int paramInt1, int paramInt2)
  {
    acquire();
    if (paramChunkedCursorWindow.getNumColumns() != this.mResultColumns) {
      paramChunkedCursorWindow.setNumColumns(this.mResultColumns);
    }
    try
    {
      paramInt1 = nativeFillRows(this.mPreparedStatement.getPtr(), paramChunkedCursorWindow.mWindowPtr, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (SQLiteDatabaseCorruptException paramChunkedCursorWindow)
    {
      onCorruption();
      throw paramChunkedCursorWindow;
    }
    catch (SQLiteException paramChunkedCursorWindow)
    {
      Log.e("WCDB.SQLiteAsyncQuery", "Got exception on fillRows: " + paramChunkedCursorWindow.getMessage() + ", SQL: " + getSql());
      throw paramChunkedCursorWindow;
    }
  }
  
  int getCount()
  {
    acquire();
    try
    {
      int i = nativeCount(this.mPreparedStatement.getPtr());
      return i;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      onCorruption();
      throw localSQLiteDatabaseCorruptException;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("WCDB.SQLiteAsyncQuery", "Got exception on getCount: " + localSQLiteException.getMessage() + ", SQL: " + getSql());
      throw localSQLiteException;
    }
  }
  
  void release()
  {
    releasePreparedStatement();
  }
  
  void reset()
  {
    if (this.mPreparedStatement != null) {
      this.mPreparedStatement.reset(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncQuery
 * JD-Core Version:    0.7.0.1
 */