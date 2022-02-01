package com.tencent.moai.database.sqlite;

import android.database.Cursor;

public final class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private final CancellationSignal mCancellationSignal;
  private final SQLiteDatabase mDatabase;
  private final String mEditTable;
  private SQLiteQuery mQuery;
  private final String mSql;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mEditTable = paramString2;
    this.mSql = paramString1;
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  public void cursorClosed() {}
  
  public void cursorDeactivated() {}
  
  public void cursorRequeried(Cursor paramCursor) {}
  
  /* Error */
  public Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 39	com/tencent/moai/database/sqlite/SQLiteQuery
    //   3: dup
    //   4: aload_0
    //   5: getfield 22	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   8: aload_0
    //   9: getfield 26	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mSql	Ljava/lang/String;
    //   12: aload_0
    //   13: getfield 28	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mCancellationSignal	Lcom/tencent/moai/database/sqlite/CancellationSignal;
    //   16: invokespecial 42	com/tencent/moai/database/sqlite/SQLiteQuery:<init>	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/moai/database/sqlite/CancellationSignal;)V
    //   19: astore_3
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 46	com/tencent/moai/database/sqlite/SQLiteQuery:bindAllArgsAsStrings	([Ljava/lang/String;)V
    //   25: aload_1
    //   26: ifnonnull +24 -> 50
    //   29: new 48	com/tencent/moai/database/sqlite/SQLiteCursor
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 24	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mEditTable	Ljava/lang/String;
    //   38: aload_3
    //   39: invokespecial 51	com/tencent/moai/database/sqlite/SQLiteCursor:<init>	(Lcom/tencent/moai/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Lcom/tencent/moai/database/sqlite/SQLiteQuery;)V
    //   42: astore_1
    //   43: aload_0
    //   44: aload_3
    //   45: putfield 53	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mQuery	Lcom/tencent/moai/database/sqlite/SQLiteQuery;
    //   48: aload_1
    //   49: areturn
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 22	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mDatabase	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 24	com/tencent/moai/database/sqlite/SQLiteDirectCursorDriver:mEditTable	Ljava/lang/String;
    //   60: aload_3
    //   61: invokeinterface 59 5 0
    //   66: astore_1
    //   67: goto -24 -> 43
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 62	com/tencent/moai/database/sqlite/SQLiteQuery:close	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	SQLiteDirectCursorDriver
    //   0	77	1	paramCursorFactory	SQLiteDatabase.CursorFactory
    //   0	77	2	paramArrayOfString	String[]
    //   19	53	3	localSQLiteQuery	SQLiteQuery
    // Exception table:
    //   from	to	target	type
    //   20	25	70	java/lang/RuntimeException
    //   29	43	70	java/lang/RuntimeException
    //   50	67	70	java/lang/RuntimeException
  }
  
  public void setBindArguments(String[] paramArrayOfString)
  {
    this.mQuery.bindAllArgsAsStrings(paramArrayOfString);
  }
  
  public String toString()
  {
    return "SQLiteDirectCursorDriver: " + this.mSql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteDirectCursorDriver
 * JD-Core Version:    0.7.0.1
 */