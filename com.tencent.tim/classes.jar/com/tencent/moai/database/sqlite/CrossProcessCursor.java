package com.tencent.moai.database.sqlite;

import android.database.Cursor;

public abstract interface CrossProcessCursor
  extends Cursor
{
  public abstract void fillWindow(int paramInt, CursorWindow paramCursorWindow);
  
  public abstract CursorWindow getWindow();
  
  public abstract boolean onMove(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.CrossProcessCursor
 * JD-Core Version:    0.7.0.1
 */