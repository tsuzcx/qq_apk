package com.tencent.wcdb.database;

public final class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, null);
  }
  
  public void execute()
  {
    execute(null);
  }
  
  /* Error */
  public void execute(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	com/tencent/wcdb/database/SQLiteStatement:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 24	com/tencent/wcdb/database/SQLiteStatement:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 28	com/tencent/wcdb/database/SQLiteStatement:getSql	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 32	com/tencent/wcdb/database/SQLiteStatement:getBindArgs	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:getConnectionFlags	()I
    //   20: aload_1
    //   21: invokevirtual 41	com/tencent/wcdb/database/SQLiteSession:execute	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)V
    //   24: aload_0
    //   25: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   28: return
    //   29: astore_1
    //   30: goto +10 -> 40
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:onCorruption	()V
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	SQLiteStatement
    //   0	46	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   4	24	29	finally
    //   34	40	29	finally
    //   4	24	33	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public long executeInsert()
  {
    return executeInsert(null);
  }
  
  /* Error */
  public long executeInsert(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	com/tencent/wcdb/database/SQLiteStatement:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 24	com/tencent/wcdb/database/SQLiteStatement:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 28	com/tencent/wcdb/database/SQLiteStatement:getSql	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 32	com/tencent/wcdb/database/SQLiteStatement:getBindArgs	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:getConnectionFlags	()I
    //   20: aload_1
    //   21: invokevirtual 56	com/tencent/wcdb/database/SQLiteSession:executeForLastInsertedRowId	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)J
    //   24: lstore_2
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   29: lload_2
    //   30: lreturn
    //   31: astore_1
    //   32: goto +10 -> 42
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:onCorruption	()V
    //   40: aload_1
    //   41: athrow
    //   42: aload_0
    //   43: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SQLiteStatement
    //   0	48	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    //   24	6	2	l	long
    // Exception table:
    //   from	to	target	type
    //   4	25	31	finally
    //   36	42	31	finally
    //   4	25	35	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public int executeUpdateDelete()
  {
    return executeUpdateDelete(null);
  }
  
  /* Error */
  public int executeUpdateDelete(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	com/tencent/wcdb/database/SQLiteStatement:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 24	com/tencent/wcdb/database/SQLiteStatement:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 28	com/tencent/wcdb/database/SQLiteStatement:getSql	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 32	com/tencent/wcdb/database/SQLiteStatement:getBindArgs	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:getConnectionFlags	()I
    //   20: aload_1
    //   21: invokevirtual 64	com/tencent/wcdb/database/SQLiteSession:executeForChangedRowCount	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   24: istore_2
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   29: iload_2
    //   30: ireturn
    //   31: astore_1
    //   32: goto +10 -> 42
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:onCorruption	()V
    //   40: aload_1
    //   41: athrow
    //   42: aload_0
    //   43: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SQLiteStatement
    //   0	48	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    //   24	6	2	i	int
    // Exception table:
    //   from	to	target	type
    //   4	25	31	finally
    //   36	42	31	finally
    //   4	25	35	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public long simpleQueryForLong()
  {
    return simpleQueryForLong(null);
  }
  
  /* Error */
  public long simpleQueryForLong(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	com/tencent/wcdb/database/SQLiteStatement:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 24	com/tencent/wcdb/database/SQLiteStatement:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 28	com/tencent/wcdb/database/SQLiteStatement:getSql	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 32	com/tencent/wcdb/database/SQLiteStatement:getBindArgs	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:getConnectionFlags	()I
    //   20: aload_1
    //   21: invokevirtual 70	com/tencent/wcdb/database/SQLiteSession:executeForLong	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)J
    //   24: lstore_2
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   29: lload_2
    //   30: lreturn
    //   31: astore_1
    //   32: goto +10 -> 42
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:onCorruption	()V
    //   40: aload_1
    //   41: athrow
    //   42: aload_0
    //   43: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SQLiteStatement
    //   0	48	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    //   24	6	2	l	long
    // Exception table:
    //   from	to	target	type
    //   4	25	31	finally
    //   36	42	31	finally
    //   4	25	35	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public String simpleQueryForString()
  {
    return simpleQueryForString(null);
  }
  
  /* Error */
  public String simpleQueryForString(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 20	com/tencent/wcdb/database/SQLiteStatement:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 24	com/tencent/wcdb/database/SQLiteStatement:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 28	com/tencent/wcdb/database/SQLiteStatement:getSql	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 32	com/tencent/wcdb/database/SQLiteStatement:getBindArgs	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:getConnectionFlags	()I
    //   20: aload_1
    //   21: invokevirtual 78	com/tencent/wcdb/database/SQLiteSession:executeForString	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: goto +10 -> 42
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:onCorruption	()V
    //   40: aload_1
    //   41: athrow
    //   42: aload_0
    //   43: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:releaseReference	()V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SQLiteStatement
    //   0	48	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   4	25	31	finally
    //   36	42	31	finally
    //   4	25	35	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteProgram: ");
    localStringBuilder.append(getSql());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */