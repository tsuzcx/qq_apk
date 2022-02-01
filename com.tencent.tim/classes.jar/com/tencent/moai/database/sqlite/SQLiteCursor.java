package com.tencent.moai.database.sqlite;

import com.tencent.moai.database.ExtraUtils;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  static final int NO_COUNT = -1;
  static final String TAG = "SQLiteCursor";
  private static OnCursorWindowGrowListener sOnCursorWindowGrowListener;
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
    this.mRowIdColumnIndex = ExtraUtils.findRowIdColumnIndex(this.mColumns);
  }
  
  @Deprecated
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    this(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  private void checkColumnIndex(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalStateException("Column not found, row: " + this.mPos + ", col: " + paramInt + ", sql: " + getSql());
    }
  }
  
  private void fillWindow(int paramInt)
  {
    clearOrCreateWindow(getDatabase().getPath());
    for (;;)
    {
      long l;
      try
      {
        l = System.nanoTime();
        if (this.mCount != -1) {
          break label250;
        }
        i = ExtraUtils.cursorPickFillWindowStartPosition(paramInt, 0);
        this.mCount = this.mQuery.fillWindow(this.mWindow, i, paramInt, 10);
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
        l = (System.nanoTime() - l) / 1000000L;
        if ((this.mCount <= 0) || (l / this.mCount <= 500L)) {
          break label354;
        }
        SQLiteDebug.Log.w("SQLiteCursor", "fillWindow for [" + getSql() + "], count: " + this.mCount + ", " + l + "ms");
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        SQLiteDebug.Log.e("SQLiteCursor", "fillWindow for [" + getSql() + "] throws an exception " + localRuntimeException.toString());
        closeWindow();
        throw localRuntimeException;
      }
      SQLiteDebug.Log.d("SQLiteCursor", "fillWindow for [" + getSql() + "], count: " + this.mCount + ", " + l + "ms");
      return;
      label250:
      int i = ExtraUtils.cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
      this.mQuery.fillWindow(this.mWindow, i, paramInt, 0);
      SQLiteDebug.Log.w("SQLiteCursor", "fillWindow for [" + getSql() + "], count: " + this.mCount + ", startPos: " + i + ", requiredPos: " + paramInt + ", " + (float)(System.nanoTime() - l) / 1000000.0F + "ms");
      return;
      label354:
      if (l <= 100L) {}
    }
  }
  
  private void growCursorWindow(int paramInt, Throwable paramThrowable)
  {
    this.mWindow.grow(paramThrowable);
    this.mCount = -1;
    fillWindow(this.mPos);
    if (sOnCursorWindowGrowListener != null) {
      sOnCursorWindowGrowListener.onGrow(this.mPos, paramInt, this.mWindow.getGrowTimes(), this.mWindow.getCurSize(), CursorWindow.getDefaultSize(), getSql(), paramThrowable);
    }
  }
  
  public static void setOnCursorWindowGrowListener(OnCursorWindowGrowListener paramOnCursorWindowGrowListener)
  {
    sOnCursorWindowGrowListener = paramOnCursorWindowGrowListener;
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
  
  public byte[] getBlob(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = super.getBlob(paramInt);
        return arrayOfByte;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    if (this.mColumnNameMap == null)
    {
      localObject = this.mColumns;
      int j = localObject.length;
      HashMap localHashMap = new HashMap(j, 1.0F);
      i = 0;
      while (i < j)
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
      SQLiteDebug.Log.e("SQLiteCursor", "requesting column name with table name -- " + paramString, (Throwable)localObject);
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
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
  
  public double getDouble(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        double d = super.getDouble(paramInt);
        return d;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public float getFloat(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        float f = super.getFloat(paramInt);
        return f;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public int getInt(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        int i = super.getInt(paramInt);
        return i;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public long getLong(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        long l = super.getLong(paramInt);
        return l;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public short getShort(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        short s = super.getShort(paramInt);
        return s;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public final String getSql()
  {
    return this.mQuery.getSql();
  }
  
  public String getString(int paramInt)
  {
    checkColumnIndex(paramInt);
    for (;;)
    {
      try
      {
        String str = super.getString(paramInt);
        return str;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        growCursorWindow(paramInt, localIllegalStateException);
      }
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
      fillWindow(paramInt2);
    }
    return true;
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
      SQLiteDebug.Log.w("SQLiteCursor", "requery() failed " + localIllegalStateException.getMessage(), localIllegalStateException);
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
  
  public static abstract interface OnCursorWindowGrowListener
  {
    public abstract void onGrow(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteCursor
 * JD-Core Version:    0.7.0.1
 */