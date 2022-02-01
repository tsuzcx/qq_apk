package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.orm.CursorAdapterORM;

public class BottleConversationController_QueryFirstMessageCursorAdapterORM
  implements CursorAdapterORM<BottleConversationController.QueryFirstMessage>
{
  private long mCurrentThreadId = 0L;
  private Cursor mCursor = null;
  private int mPosition = -1;
  
  public BottleConversationController_QueryFirstMessageCursorAdapterORM(Cursor paramCursor)
  {
    this.mCursor = paramCursor;
  }
  
  public BottleConversationController_QueryFirstMessageCursorAdapterORM(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    this.mCursor = BottleConversationController_QueryFirstMessageORM.rawQuery(paramSQLiteDatabase, paramString, paramArrayOfString);
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
  
  public BottleConversationController.QueryFirstMessage getItem(int paramInt)
  {
    Object localObject = null;
    if (this.mCursor != null)
    {
      checkInSameThread();
      localObject = this.mCursor;
      this.mPosition = paramInt;
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = BottleConversationController_QueryFirstMessageORM.fill(this.mCursor, null);
    }
    return localObject;
  }
  
  public BottleConversationController.QueryFirstMessage getItem(int paramInt, BottleConversationController.QueryFirstMessage paramQueryFirstMessage)
  {
    if (this.mCursor != null)
    {
      checkInSameThread();
      Cursor localCursor = this.mCursor;
      this.mPosition = paramInt;
      localCursor.moveToPosition(paramInt);
      return BottleConversationController_QueryFirstMessageORM.fill(this.mCursor, paramQueryFirstMessage);
    }
    return null;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_QueryFirstMessageCursorAdapterORM
 * JD-Core Version:    0.7.0.1
 */