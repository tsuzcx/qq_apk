package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteQuery
  extends SQLiteProgram
{
  private static final String TAG = "WCDB.SQLiteQuery";
  private final CancellationSignal mCancellationSignal;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  /* Error */
  int fillWindow(com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	com/tencent/wcdb/database/SQLiteQuery:acquireReference	()V
    //   4: aload_1
    //   5: invokevirtual 30	com/tencent/wcdb/CursorWindow:acquireReference	()V
    //   8: aload_0
    //   9: invokevirtual 34	com/tencent/wcdb/database/SQLiteQuery:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   12: aload_0
    //   13: invokevirtual 38	com/tencent/wcdb/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 42	com/tencent/wcdb/database/SQLiteQuery:getBindArgs	()[Ljava/lang/Object;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iload 4
    //   25: aload_0
    //   26: invokevirtual 46	com/tencent/wcdb/database/SQLiteQuery:getConnectionFlags	()I
    //   29: aload_0
    //   30: getfield 16	com/tencent/wcdb/database/SQLiteQuery:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   33: invokevirtual 52	com/tencent/wcdb/database/SQLiteSession:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/CursorWindow;IIZILcom/tencent/wcdb/support/CancellationSignal;)I
    //   36: istore_2
    //   37: aload_1
    //   38: invokevirtual 55	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   41: aload_0
    //   42: invokevirtual 56	com/tencent/wcdb/database/SQLiteQuery:releaseReference	()V
    //   45: iload_2
    //   46: ireturn
    //   47: astore 5
    //   49: goto +73 -> 122
    //   52: astore 5
    //   54: new 58	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   61: astore 6
    //   63: aload 6
    //   65: ldc 62
    //   67: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: aload 5
    //   75: invokevirtual 69	com/tencent/wcdb/database/SQLiteException:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: ldc 71
    //   86: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: aload_0
    //   93: invokevirtual 38	com/tencent/wcdb/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   96: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 8
    //   102: aload 6
    //   104: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 80	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 5
    //   112: athrow
    //   113: astore 5
    //   115: aload_0
    //   116: invokevirtual 83	com/tencent/wcdb/database/SQLiteQuery:onCorruption	()V
    //   119: aload 5
    //   121: athrow
    //   122: aload_1
    //   123: invokevirtual 55	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   126: aload 5
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: invokevirtual 56	com/tencent/wcdb/database/SQLiteQuery:releaseReference	()V
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	SQLiteQuery
    //   0	136	1	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	136	2	paramInt1	int
    //   0	136	3	paramInt2	int
    //   0	136	4	paramBoolean	boolean
    //   47	1	5	localObject	Object
    //   52	59	5	localSQLiteException	SQLiteException
    //   113	14	5	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   61	42	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	37	47	finally
    //   54	113	47	finally
    //   115	122	47	finally
    //   8	37	52	com/tencent/wcdb/database/SQLiteException
    //   8	37	113	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
    //   4	8	129	finally
    //   37	41	129	finally
    //   122	129	129	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteQuery: ");
    localStringBuilder.append(getSql());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQuery
 * JD-Core Version:    0.7.0.1
 */