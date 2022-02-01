package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory()
  {
    public Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
    {
      return new SQLiteDirectCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (SQLiteDirectQuery)paramAnonymousSQLiteProgram);
    }
    
    public SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
    {
      return new SQLiteDirectQuery(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousCancellationSignal);
    }
  };
  private static final String TAG = "WCDB.SQLiteDirectCursor";
  private final String[] mColumns;
  private int mCount;
  private boolean mCountFinished;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteDirectQuery mQuery;
  
  public SQLiteDirectCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteDirectQuery paramSQLiteDirectQuery)
  {
    if (paramSQLiteDirectQuery != null)
    {
      this.mQuery = paramSQLiteDirectQuery;
      this.mDriver = paramSQLiteCursorDriver;
      this.mColumns = paramSQLiteDirectQuery.getColumnNames();
      this.mCount = -1;
      this.mCountFinished = false;
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  public void close()
  {
    super.close();
    this.mQuery.close();
    this.mDriver.cursorClosed();
  }
  
  public void deactivate()
  {
    super.deactivate();
    this.mDriver.cursorDeactivated();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.mQuery.getBlob(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (!this.mCountFinished)
    {
      Log.w("WCDB.SQLiteDirectCursor", "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
      this.mCount = (this.mPos + this.mQuery.step(2147483647) + 1);
      this.mCountFinished = true;
      this.mQuery.reset(false);
      this.mPos = (this.mQuery.step(this.mPos + 1) - 1);
    }
    return this.mCount;
  }
  
  public double getDouble(int paramInt)
  {
    return this.mQuery.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return (float)this.mQuery.getDouble(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return (int)this.mQuery.getLong(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.mQuery.getLong(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return (short)(int)this.mQuery.getLong(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.mQuery.getString(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return this.mQuery.getType(paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return getType(paramInt) == 0;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    boolean bool = false;
    if (paramInt < 0)
    {
      this.mQuery.reset(false);
      this.mPos = -1;
      return false;
    }
    int i;
    if (this.mCountFinished)
    {
      i = this.mCount;
      if (paramInt >= i)
      {
        this.mPos = i;
        return false;
      }
    }
    if (paramInt < this.mPos)
    {
      Log.w("WCDB.SQLiteDirectCursor", "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
      this.mQuery.reset(false);
      i = this.mQuery.step(paramInt + 1) - 1;
    }
    else
    {
      if (paramInt == this.mPos) {
        return true;
      }
      i = this.mPos + this.mQuery.step(paramInt - this.mPos);
    }
    if (i < paramInt)
    {
      this.mCount = (i + 1);
      this.mCountFinished = true;
      this.mPos = this.mCount;
    }
    else
    {
      this.mPos = i;
      if (i >= this.mCount)
      {
        this.mCount = (i + 1);
        this.mCountFinished = false;
      }
    }
    if (this.mPos < this.mCount) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 129	com/tencent/wcdb/database/SQLiteDirectCursor:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 34	com/tencent/wcdb/database/SQLiteDirectCursor:mQuery	Lcom/tencent/wcdb/database/SQLiteDirectQuery;
    //   15: invokevirtual 133	com/tencent/wcdb/database/SQLiteDirectQuery:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   18: invokevirtual 138	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   21: ifne +7 -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: iconst_m1
    //   30: putfield 87	com/tencent/wcdb/database/SQLiteDirectCursor:mPos	I
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 48	com/tencent/wcdb/database/SQLiteDirectCursor:mCountFinished	Z
    //   38: aload_0
    //   39: iconst_m1
    //   40: putfield 46	com/tencent/wcdb/database/SQLiteDirectCursor:mCount	I
    //   43: aload_0
    //   44: getfield 36	com/tencent/wcdb/database/SQLiteDirectCursor:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   47: aload_0
    //   48: invokeinterface 142 2 0
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 34	com/tencent/wcdb/database/SQLiteDirectCursor:mQuery	Lcom/tencent/wcdb/database/SQLiteDirectQuery;
    //   59: iconst_0
    //   60: invokevirtual 96	com/tencent/wcdb/database/SQLiteDirectQuery:reset	(Z)V
    //   63: aload_0
    //   64: invokespecial 144	com/tencent/wcdb/AbstractCursor:requery	()Z
    //   67: istore_1
    //   68: iload_1
    //   69: ireturn
    //   70: astore_2
    //   71: new 146	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: ldc 149
    //   82: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 157	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 12
    //   97: aload_3
    //   98: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_1
    //   102: anewarray 162	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: aastore
    //   109: invokestatic 165	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	SQLiteDirectCursor
    //   67	2	1	bool	boolean
    //   70	38	2	localIllegalStateException	java.lang.IllegalStateException
    //   114	4	2	localObject	Object
    //   78	20	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	68	70	java/lang/IllegalStateException
    //   11	26	114	finally
    //   28	55	114	finally
    //   115	117	114	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursor
 * JD-Core Version:    0.7.0.1
 */