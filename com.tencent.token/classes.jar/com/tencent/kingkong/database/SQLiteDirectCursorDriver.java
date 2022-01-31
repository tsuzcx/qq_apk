package com.tencent.kingkong.database;

import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.support.CancellationSignal;

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
    //   0: new 39	com/tencent/kingkong/database/SQLiteQuery
    //   3: dup
    //   4: aload_0
    //   5: getfield 22	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   8: aload_0
    //   9: getfield 26	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mSql	Ljava/lang/String;
    //   12: aload_0
    //   13: getfield 28	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mCancellationSignal	Lcom/tencent/kingkong/support/CancellationSignal;
    //   16: invokespecial 42	com/tencent/kingkong/database/SQLiteQuery:<init>	(Lcom/tencent/kingkong/database/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   19: astore_3
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 46	com/tencent/kingkong/database/SQLiteQuery:bindAllArgsAsStrings	([Ljava/lang/String;)V
    //   25: aload_1
    //   26: ifnonnull +24 -> 50
    //   29: new 48	com/tencent/kingkong/database/SQLiteCursor
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 24	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mEditTable	Ljava/lang/String;
    //   38: aload_3
    //   39: invokespecial 51	com/tencent/kingkong/database/SQLiteCursor:<init>	(Lcom/tencent/kingkong/database/SQLiteCursorDriver;Ljava/lang/String;Lcom/tencent/kingkong/database/SQLiteQuery;)V
    //   42: astore_1
    //   43: aload_0
    //   44: aload_3
    //   45: putfield 53	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mQuery	Lcom/tencent/kingkong/database/SQLiteQuery;
    //   48: aload_1
    //   49: areturn
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 22	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mDatabase	Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 24	com/tencent/kingkong/database/SQLiteDirectCursorDriver:mEditTable	Ljava/lang/String;
    //   60: aload_3
    //   61: invokeinterface 59 5 0
    //   66: astore_1
    //   67: goto -24 -> 43
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 62	com/tencent/kingkong/database/SQLiteQuery:close	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteDirectCursorDriver
 * JD-Core Version:    0.7.0.1
 */