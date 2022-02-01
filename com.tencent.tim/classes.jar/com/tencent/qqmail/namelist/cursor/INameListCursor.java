package com.tencent.qqmail.namelist.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

public abstract interface INameListCursor
{
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract long getItemId(int paramInt);
  
  public abstract void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.INameListCursor
 * JD-Core Version:    0.7.0.1
 */