package com.tencent.wcdb;

public abstract interface CrossProcessCursor
  extends Cursor
{
  public abstract void fillWindow(int paramInt, CursorWindow paramCursorWindow);
  
  public abstract CursorWindow getWindow();
  
  public abstract boolean onMove(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.CrossProcessCursor
 * JD-Core Version:    0.7.0.1
 */