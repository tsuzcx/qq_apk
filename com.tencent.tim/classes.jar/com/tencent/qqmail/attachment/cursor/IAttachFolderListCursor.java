package com.tencent.qqmail.attachment.cursor;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

public abstract interface IAttachFolderListCursor
{
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract Attach getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public abstract long[] getItemIds();
  
  public abstract int getState();
  
  public abstract void refresh(QMRefreshCallback paramQMRefreshCallback);
  
  public abstract void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.IAttachFolderListCursor
 * JD-Core Version:    0.7.0.1
 */