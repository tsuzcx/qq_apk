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
    if (paramSQLiteDirectQuery == null) {
      throw new IllegalArgumentException("query object cannot be null");
    }
    this.mQuery = paramSQLiteDirectQuery;
    this.mDriver = paramSQLiteCursorDriver;
    this.mColumns = paramSQLiteDirectQuery.getColumnNames();
    this.mCount = -1;
    this.mCountFinished = false;
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
    boolean bool = true;
    if (paramInt < 0)
    {
      this.mQuery.reset(false);
      this.mPos = -1;
      return false;
    }
    if ((this.mCountFinished) && (paramInt >= this.mCount))
    {
      this.mPos = this.mCount;
      return false;
    }
    int i;
    if (paramInt < this.mPos)
    {
      Log.w("WCDB.SQLiteDirectCursor", "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
      this.mQuery.reset(false);
      i = this.mQuery.step(paramInt + 1) - 1;
      if (i >= paramInt) {
        break label152;
      }
      this.mCount = (i + 1);
      this.mCountFinished = true;
      this.mPos = this.mCount;
      label107:
      if (this.mPos >= this.mCount) {
        break label180;
      }
    }
    for (;;)
    {
      return bool;
      if (paramInt == this.mPos) {
        return true;
      }
      i = this.mPos + this.mQuery.step(paramInt - this.mPos);
      break;
      label152:
      this.mPos = i;
      if (i < this.mCount) {
        break label107;
      }
      this.mCount = (i + 1);
      this.mCountFinished = false;
      break label107;
      label180:
      bool = false;
    }
  }
  
  public boolean requery()
  {
    if (isClosed()) {
      return false;
    }
    try
    {
      if (!this.mQuery.getDatabase().isOpen()) {
        return false;
      }
    }
    finally {}
    this.mPos = -1;
    this.mCountFinished = false;
    this.mCount = -1;
    this.mDriver.cursorRequeried(this);
    this.mQuery.reset(false);
    try
    {
      boolean bool = super.requery();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.w("WCDB.SQLiteDirectCursor", "requery() failed " + localIllegalStateException.getMessage(), new Object[] { localIllegalStateException });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursor
 * JD-Core Version:    0.7.0.1
 */