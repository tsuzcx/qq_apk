package com.huawei.hms.common.a;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class a
  extends CursorWrapper
  implements CrossProcessCursor
{
  private AbstractWindowedCursor a;
  
  public a(Cursor paramCursor)
  {
    super(paramCursor);
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor cannot be null");
    }
    if (!(paramCursor instanceof CursorWrapper)) {
      throw new IllegalArgumentException("cursor:" + paramCursor + " is not a subclass for CursorWrapper");
    }
    paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor();
    if (paramCursor == null) {
      throw new IllegalArgumentException("getWrappedCursor cannot be null");
    }
    if (!(paramCursor instanceof AbstractWindowedCursor)) {
      throw new IllegalArgumentException("getWrappedCursor:" + paramCursor + " is not a subclass for CursorWrapper");
    }
    this.a = ((AbstractWindowedCursor)paramCursor);
  }
  
  public void a(CursorWindow paramCursorWindow)
  {
    this.a.setWindow(paramCursorWindow);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    this.a.fillWindow(paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow()
  {
    return this.a.getWindow();
  }
  
  public Cursor getWrappedCursor()
  {
    return this.a;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return this.a.onMove(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.a.a
 * JD-Core Version:    0.7.0.1
 */