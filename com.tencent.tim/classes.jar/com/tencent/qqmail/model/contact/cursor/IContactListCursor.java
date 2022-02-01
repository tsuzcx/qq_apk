package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.MailContact;

public abstract interface IContactListCursor
{
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract MailContact getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public abstract void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.IContactListCursor
 * JD-Core Version:    0.7.0.1
 */