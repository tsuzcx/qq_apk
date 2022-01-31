package com.tencent.wcdb.repair;

import android.database.Cursor;

public abstract interface RepairKit$Callback
{
  public abstract int onProgress(String paramString, int paramInt, Cursor paramCursor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit.Callback
 * JD-Core Version:    0.7.0.1
 */