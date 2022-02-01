package com.tencent.wcdb;

import android.database.ContentObserver;
import android.database.DataSetObserver;

public class MergeCursor
  extends AbstractCursor
{
  private Cursor mCursor;
  private Cursor[] mCursors;
  private DataSetObserver mObserver = new DataSetObserver()
  {
    public void onChanged()
    {
      MergeCursor.this.mPos = -1;
    }
    
    public void onInvalidated()
    {
      MergeCursor.this.mPos = -1;
    }
  };
  
  public MergeCursor(Cursor[] paramArrayOfCursor)
  {
    this.mCursors = paramArrayOfCursor;
    int i = 0;
    this.mCursor = paramArrayOfCursor[0];
    for (;;)
    {
      paramArrayOfCursor = this.mCursors;
      if (i >= paramArrayOfCursor.length) {
        break;
      }
      if (paramArrayOfCursor[i] != null) {
        paramArrayOfCursor[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
  }
  
  public void close()
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].close();
      }
      i += 1;
    }
    super.close();
  }
  
  public void deactivate()
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.mCursor.getBlob(paramInt);
  }
  
  public String[] getColumnNames()
  {
    Cursor localCursor = this.mCursor;
    if (localCursor != null) {
      return localCursor.getColumnNames();
    }
    return new String[0];
  }
  
  public int getCount()
  {
    int m = this.mCursors.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      k = j;
      if (arrayOfCursor[i] != null) {
        k = j + arrayOfCursor[i].getCount();
      }
      i += 1;
    }
    return j;
  }
  
  public double getDouble(int paramInt)
  {
    return this.mCursor.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.mCursor.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.mCursor.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.mCursor.getLong(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return this.mCursor.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.mCursor.getString(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return this.mCursor.getType(paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return this.mCursor.isNull(paramInt);
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    this.mCursor = null;
    int j = this.mCursors.length;
    paramInt1 = 0;
    int i = 0;
    while (paramInt1 < j)
    {
      localObject = this.mCursors;
      if (localObject[paramInt1] != null)
      {
        if (paramInt2 < localObject[paramInt1].getCount() + i)
        {
          this.mCursor = this.mCursors[paramInt1];
          break;
        }
        i += this.mCursors[paramInt1].getCount();
      }
      paramInt1 += 1;
    }
    Object localObject = this.mCursor;
    if (localObject != null) {
      return ((Cursor)localObject).moveToPosition(paramInt2 - i);
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
  }
  
  public boolean requery()
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if ((arrayOfCursor[i] != null) && (!arrayOfCursor[i].requery())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      Cursor[] arrayOfCursor = this.mCursors;
      if (arrayOfCursor[i] != null) {
        arrayOfCursor[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.MergeCursor
 * JD-Core Version:    0.7.0.1
 */