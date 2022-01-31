package com.tencent.kingkong.database;

import com.tencent.kingkong.support.CancellationSignal;

public final class SQLiteQuery
  extends SQLiteProgram
{
  private static final String TAG = "SQLiteQuery";
  private final CancellationSignal mCancellationSignal;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, null, paramCancellationSignal);
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  /* Error */
  int fillWindow(com.tencent.kingkong.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 28	com/tencent/kingkong/database/SQLiteQuery:acquireReference	()V
    //   4: aload_1
    //   5: invokevirtual 31	com/tencent/kingkong/CursorWindow:acquireReference	()V
    //   8: aload_0
    //   9: invokevirtual 35	com/tencent/kingkong/database/SQLiteQuery:getSession	()Lcom/tencent/kingkong/database/SQLiteSession;
    //   12: aload_0
    //   13: invokevirtual 39	com/tencent/kingkong/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 43	com/tencent/kingkong/database/SQLiteQuery:getBindArgs	()[Ljava/lang/Object;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iload 4
    //   25: aload_0
    //   26: invokevirtual 47	com/tencent/kingkong/database/SQLiteQuery:getConnectionFlags	()I
    //   29: aload_0
    //   30: getfield 17	com/tencent/kingkong/database/SQLiteQuery:mCancellationSignal	Lcom/tencent/kingkong/support/CancellationSignal;
    //   33: invokevirtual 53	com/tencent/kingkong/database/SQLiteSession:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/CursorWindow;IIZILcom/tencent/kingkong/support/CancellationSignal;)I
    //   36: istore_2
    //   37: aload_1
    //   38: invokevirtual 56	com/tencent/kingkong/CursorWindow:releaseReference	()V
    //   41: aload_0
    //   42: invokevirtual 57	com/tencent/kingkong/database/SQLiteQuery:releaseReference	()V
    //   45: iload_2
    //   46: ireturn
    //   47: astore 5
    //   49: aload_0
    //   50: invokevirtual 60	com/tencent/kingkong/database/SQLiteQuery:onCorruption	()V
    //   53: aload 5
    //   55: athrow
    //   56: astore 5
    //   58: aload_1
    //   59: invokevirtual 56	com/tencent/kingkong/CursorWindow:releaseReference	()V
    //   62: aload 5
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: invokevirtual 57	com/tencent/kingkong/database/SQLiteQuery:releaseReference	()V
    //   70: aload_1
    //   71: athrow
    //   72: astore 5
    //   74: ldc 8
    //   76: new 62	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   83: ldc 66
    //   85: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 5
    //   90: invokevirtual 73	com/tencent/kingkong/database/SQLiteException:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 75
    //   98: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 39	com/tencent/kingkong/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   105: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 84	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   114: pop
    //   115: aload 5
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	SQLiteQuery
    //   0	118	1	paramCursorWindow	com.tencent.kingkong.CursorWindow
    //   0	118	2	paramInt1	int
    //   0	118	3	paramInt2	int
    //   0	118	4	paramBoolean	boolean
    //   47	7	5	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   56	7	5	localObject	java.lang.Object
    //   72	44	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   8	37	47	com/tencent/kingkong/database/SQLiteDatabaseCorruptException
    //   8	37	56	finally
    //   49	56	56	finally
    //   74	118	56	finally
    //   4	8	65	finally
    //   37	41	65	finally
    //   58	65	65	finally
    //   8	37	72	com/tencent/kingkong/database/SQLiteException
  }
  
  public String toString()
  {
    return "SQLiteQuery: " + getSql();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteQuery
 * JD-Core Version:    0.7.0.1
 */