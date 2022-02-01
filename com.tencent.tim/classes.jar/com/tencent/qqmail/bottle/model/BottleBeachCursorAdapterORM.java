package com.tencent.qqmail.bottle.model;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.orm.CursorAdapterORM;
import com.tencent.qqmail.utilities.log.QMLog;

public class BottleBeachCursorAdapterORM
  implements CursorAdapterORM<BottleBeach>
{
  private long mCurrentThreadId = 0L;
  private Cursor mCursor = null;
  private int mPosition = -1;
  
  public BottleBeachCursorAdapterORM(Cursor paramCursor)
  {
    this.mCursor = paramCursor;
  }
  
  public BottleBeachCursorAdapterORM(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    this.mCursor = BottleBeachORM.rawQuery(paramSQLiteDatabase, paramString, paramArrayOfString);
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
  
  public BottleBeach getItem(int paramInt)
  {
    Object localObject = null;
    if (this.mCursor != null)
    {
      checkInSameThread();
      localObject = this.mCursor;
      this.mPosition = paramInt;
      boolean bool = ((Cursor)localObject).moveToPosition(paramInt);
      QMLog.log(3, "BottleBeachCursorAdapterORM", "moveToPostion: " + paramInt + ", " + bool);
      localObject = BottleBeachORM.fill(this.mCursor, null);
    }
    return localObject;
  }
  
  public BottleBeach getItem(int paramInt, BottleBeach paramBottleBeach)
  {
    if (this.mCursor != null)
    {
      checkInSameThread();
      Cursor localCursor = this.mCursor;
      this.mPosition = paramInt;
      boolean bool = localCursor.moveToPosition(paramInt);
      QMLog.log(3, "BottleBeachCursorAdapterORM", "moveToPostion: " + paramInt + ", " + bool);
      return BottleBeachORM.fill(this.mCursor, paramBottleBeach);
    }
    return null;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleBeachCursorAdapterORM
 * JD-Core Version:    0.7.0.1
 */