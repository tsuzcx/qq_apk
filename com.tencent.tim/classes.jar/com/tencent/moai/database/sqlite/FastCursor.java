package com.tencent.moai.database.sqlite;

import java.util.Date;
import java.util.HashMap;

public final class FastCursor
  extends AbstractCursor
{
  private static final int NO_COUNT = -1;
  private static final String TAG = "FastCursor";
  private HashMap<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount = -1;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteQuery mQuery;
  private SparseParcelWindow mWindow;
  
  public FastCursor(SQLiteCursorDriver paramSQLiteCursorDriver, SQLiteQuery paramSQLiteQuery)
  {
    if (paramSQLiteQuery == null) {
      throw new IllegalArgumentException("query object cannot be null");
    }
    this.mDriver = paramSQLiteCursorDriver;
    this.mQuery = paramSQLiteQuery;
    this.mColumns = paramSQLiteQuery.getColumnNames();
    this.mWindow = new SparseParcelWindow();
  }
  
  private void fillWindow(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.nanoTime();
    int i = this.mQuery.fillWindow(this.mWindow, paramInt1, paramInt3, paramInt2);
    if (paramInt2 == 2147483647)
    {
      this.mCount = i;
      this.mWindow.initWindow(this.mCount);
    }
    SQLiteDebug.Log.d("FastCursor", "fillWindow for [" + this.mQuery.getSql() + "]\n" + " -> count: " + this.mCount + ", row: " + paramInt1 + ", stepRange: " + paramInt2 + ", copyRange: " + paramInt3 + ", lastStep: " + this.mWindow.getStatementStep() + ", " + (float)(System.nanoTime() - l) / 1000000.0F + "ms");
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.mWindow.getBlob(this.mPos, paramInt);
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
      SQLiteDebug.Log.e("FastCursor", "requesting column name with table name -- " + paramString, (Throwable)localObject);
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
      fillWindow(0, 2147483647, 0);
    }
    return this.mCount;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.mQuery.getDatabase();
  }
  
  public Date getDate(int paramInt)
  {
    return new Date(this.mWindow.getLong(this.mPos, paramInt));
  }
  
  public double getDouble(int paramInt)
  {
    return this.mWindow.getDouble(this.mPos, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.mWindow.getFloat(this.mPos, paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.mWindow.getInt(this.mPos, paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.mWindow.getLong(this.mPos, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return this.mWindow.getShort(this.mPos, paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.mWindow.getString(this.mPos, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return false;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (!this.mWindow.hasData(paramInt2))) {
      fillWindow(paramInt2, 20, 20);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.FastCursor
 * JD-Core Version:    0.7.0.1
 */