package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

final class SQLiteCursor$1
  implements SQLiteDatabase.CursorFactory
{
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteProgram paramSQLiteProgram)
  {
    return new SQLiteCursor(paramSQLiteCursorDriver, paramString, (SQLiteQuery)paramSQLiteProgram);
  }
  
  public SQLiteProgram newQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    return new SQLiteQuery(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCursor.1
 * JD-Core Version:    0.7.0.1
 */