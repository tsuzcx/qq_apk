package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.orm.CursorAdapterORM;

public class BottleBeachController_BeachBottleInfoCursorAdapterORM
  implements CursorAdapterORM<BottleBeachController.BeachBottleInfo>
{
  private long mCurrentThreadId = 0L;
  private Cursor mCursor = null;
  private int mPosition = -1;
  
  public BottleBeachController_BeachBottleInfoCursorAdapterORM(Cursor paramCursor)
  {
    this.mCursor = paramCursor;
  }
  
  public BottleBeachController_BeachBottleInfoCursorAdapterORM(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    this.mCursor = BottleBeachController_BeachBottleInfoORM.rawQuery(paramSQLiteDatabase, paramString, paramArrayOfString);
    this.mCursor.getCount();
  }
  
  private void checkInSameThread()
  {
    long l = Thread.currentThread().getId();
    if (this.mCurrentThreadId == 0L) {
      this.mCurrentThreadId = l;
    }
    while (this.mCurrentThreadId == l) {
      return;
    }
    throw new IllegalStateException("thread changed: origin:" + this.mCurrentThreadId + ", now: " + l);
  }
  
  public void close()
  {
    if (this.mCursor != null)
    {
      checkInSameThread();
      this.mCursor.close();
      this.mCursor = null;
    }
  }
  
  public int getCount()
  {
    if (this.mCursor != null) {
      return this.mCursor.getCount();
    }
    return -1;
  }
  
  public BottleBeachController.BeachBottleInfo getItem(int paramInt)
  {
    Object localObject = null;
    if (this.mCursor != null)
    {
      checkInSameThread();
      localObject = this.mCursor;
      this.mPosition = paramInt;
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = BottleBeachController_BeachBottleInfoORM.fill(this.mCursor, null);
    }
    return localObject;
  }
  
  public BottleBeachController.BeachBottleInfo getItem(int paramInt, BottleBeachController.BeachBottleInfo paramBeachBottleInfo)
  {
    if (this.mCursor != null)
    {
      checkInSameThread();
      Cursor localCursor = this.mCursor;
      this.mPosition = paramInt;
      localCursor.moveToPosition(paramInt);
      return BottleBeachController_BeachBottleInfoORM.fill(this.mCursor, paramBeachBottleInfo);
    }
    return null;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController_BeachBottleInfoCursorAdapterORM
 * JD-Core Version:    0.7.0.1
 */