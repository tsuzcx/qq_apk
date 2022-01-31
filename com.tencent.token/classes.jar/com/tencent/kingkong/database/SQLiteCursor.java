package com.tencent.kingkong.database;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.Log;
import com.tencent.kingkong.AbstractWindowedCursor;
import com.tencent.kingkong.CursorWindow;
import com.tencent.kingkong.DatabaseUtils;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  static final int NO_COUNT = -1;
  static final String TAG = "SQLiteCursor";
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount = -1;
  private int mCursorWindowCapacity;
  private final SQLiteCursorDriver mDriver;
  private final String mEditTable;
  private final SQLiteQuery mQuery;
  private final Throwable mStackTrace;
  
  public SQLiteCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    if (paramSQLiteQuery == null) {
      throw new IllegalArgumentException("query object cannot be null");
    }
    this.mStackTrace = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.mQuery = paramSQLiteQuery;
    this.mColumns = paramSQLiteQuery.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
  }
  
  @Deprecated
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    this(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  private void fillWindow(int paramInt)
  {
    clearOrCreateWindow(getDatabase().getPath());
    try
    {
      int i;
      if (this.mCount == -1)
      {
        i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, 0);
        this.mCount = this.mQuery.fillWindow(this.mWindow, i, paramInt, true);
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
        if (Log.isLoggable("SQLiteCursor", 3)) {
          Log.d("SQLiteCursor", "received count(*) from native_fill_window: " + this.mCount);
        }
      }
      else
      {
        i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
        this.mQuery.fillWindow(this.mWindow, i, paramInt, false);
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      closeWindow();
      throw localRuntimeException;
    }
  }
  
  public void close()
  {
    super.close();
    try
    {
      this.mQuery.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally {}
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public void deactivate()
  {
    super.deactivate();
    this.mDriver.cursorDeactivated();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mWindow != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    int j = -1;
    if (this.mColumnNameMap == null)
    {
      localObject = this.mColumns;
      int k = localObject.length;
      HashMap localHashMap = new HashMap(k, 1.0F);
      i = 0;
      while (i < k)
      {
        localHashMap.put(localObject[i], Integer.valueOf(i));
        i += 1;
      }
      this.mColumnNameMap = localHashMap;
    }
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      Log.e("SQLiteCursor", "requesting column name with table name -- " + paramString, (Throwable)localObject);
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    i = j;
    if (paramString != null) {
      i = paramString.intValue();
    }
    return i;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (this.mCount == -1) {
      fillWindow(0);
    }
    return this.mCount;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.mQuery.getDatabase();
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
      fillWindow(paramInt2);
    }
    return true;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
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
    if (this.mWindow != null) {
      this.mWindow.clear();
    }
    this.mPos = -1;
    this.mCount = -1;
    this.mDriver.cursorRequeried(this);
    try
    {
      boolean bool = super.requery();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.w("SQLiteCursor", "requery() failed " + localIllegalStateException.getMessage(), localIllegalStateException);
    }
    return false;
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    this.mDriver.setBindArguments(paramArrayOfString);
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    super.setWindow(paramCursorWindow);
    this.mCount = -1;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteCursor
 * JD-Core Version:    0.7.0.1
 */