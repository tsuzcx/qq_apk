package com.tencent.qqmail.card.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

public abstract interface ICardDataListCursor
{
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract long getItemId(int paramInt);
  
  public abstract void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.ICardDataListCursor
 * JD-Core Version:    0.7.0.1
 */