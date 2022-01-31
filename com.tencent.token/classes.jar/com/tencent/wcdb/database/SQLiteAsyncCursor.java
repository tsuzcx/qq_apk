package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;

public class SQLiteAsyncCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteAsyncCursor.1();
  private static final int MAX_KEEP_CHUNKS = 32;
  private static final int MAX_PREFETCH = 256;
  private static final int MIN_FETCH_ROWS = 32;
  private static final String TAG = "WCDB.SQLiteAsyncCursor";
  private final String[] mColumns;
  private volatile int mCount;
  private long mCurrentRow;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteAsyncQuery mQuery;
  private SQLiteAsyncCursor.QueryThread mQueryThread;
  private final Object mWaitLock;
  private ChunkedCursorWindow mWindow;
  
  public SQLiteAsyncCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteAsyncQuery paramSQLiteAsyncQuery)
  {
    if (paramSQLiteAsyncQuery == null) {
      throw new IllegalArgumentException("query object cannot be null");
    }
    this.mQuery = paramSQLiteAsyncQuery;
    this.mDriver = paramSQLiteCursorDriver;
    this.mColumns = paramSQLiteAsyncQuery.getColumnNames();
    this.mCount = -1;
    this.mWaitLock = new Object();
    this.mWindow = new ChunkedCursorWindow(16777216);
    this.mQueryThread = new SQLiteAsyncCursor.QueryThread(this);
    this.mQueryThread.start();
  }
  
  private void checkValidRow()
  {
    if (this.mCurrentRow != 0L) {
      return;
    }
    if (!isValidPosition(this.mPos)) {
      throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
    }
    throw new StaleDataException("Cannot get valid Row object");
  }
  
  private boolean isValidPosition(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getCount());
  }
  
  private boolean requestRow()
  {
    if (this.mWindow == null) {}
    do
    {
      do
      {
        return false;
      } while (!isValidPosition(this.mPos));
      this.mQueryThread.requestPos(this.mPos);
      this.mCurrentRow = this.mWindow.getRowUnsafe(this.mPos);
      if (this.mCurrentRow == 0L) {
        this.mCurrentRow = waitForRow(this.mPos);
      }
    } while (this.mCurrentRow == 0L);
    return true;
  }
  
  private long waitForRow(int paramInt)
  {
    long l;
    for (;;)
    {
      try
      {
        synchronized (this.mWaitLock)
        {
          l = this.mWindow.getRowUnsafe(paramInt);
          if (l != 0L) {
            break;
          }
          if (!isValidPosition(paramInt)) {
            throw new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
          }
        }
        this.mWaitLock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        return 0L;
      }
    }
    return l;
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
    checkValidRow();
    return this.mWindow.getBlobUnsafe(this.mCurrentRow, paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (this.mCount >= 0) {
      return this.mCount;
    }
    if (this.mWindow == null) {
      return -1;
    }
    try
    {
      synchronized (this.mWaitLock)
      {
        if (this.mCount >= 0) {
          break label56;
        }
        this.mWaitLock.wait();
      }
      return this.mCount;
    }
    catch (InterruptedException localInterruptedException) {}
    label56:
    for (;;) {}
  }
  
  public double getDouble(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getDoubleUnsafe(this.mCurrentRow, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return (float)getDouble(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return (int)getLong(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getLongUnsafe(this.mCurrentRow, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return (short)(int)getLong(paramInt);
  }
  
  public String getString(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getStringUnsafe(this.mCurrentRow, paramInt);
  }
  
  public int getType(int paramInt)
  {
    checkValidRow();
    return this.mWindow.getTypeUnsafe(this.mCurrentRow, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return getType(paramInt) == 0;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int i = paramInt;
    if (paramInt < -1) {
      i = -1;
    }
    if (i != this.mPos)
    {
      this.mWindow.endRowUnsafe(this.mCurrentRow);
      this.mCurrentRow = 0L;
    }
    paramInt = getCount();
    if (i >= paramInt)
    {
      this.mPos = paramInt;
      return false;
    }
    this.mPos = i;
    if ((i >= 0) && (requestRow())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void onDeactivateOrClose()
  {
    if (this.mCurrentRow != 0L)
    {
      this.mWindow.endRowUnsafe(this.mCurrentRow);
      this.mCurrentRow = 0L;
    }
    if (this.mQueryThread != null) {
      this.mQueryThread.quit();
    }
    try
    {
      this.mQueryThread.join();
      label46:
      this.mQueryThread = null;
      if (this.mWindow != null)
      {
        this.mWindow.close();
        this.mWindow = null;
      }
      this.mCount = -1;
      this.mPos = -1;
      super.onDeactivateOrClose();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor
 * JD-Core Version:    0.7.0.1
 */