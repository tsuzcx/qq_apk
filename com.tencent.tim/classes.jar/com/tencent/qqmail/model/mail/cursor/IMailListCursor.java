package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import java.util.concurrent.Future;

public abstract interface IMailListCursor
{
  public abstract boolean canLoadMore();
  
  public abstract boolean canPopIn();
  
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract Mail getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public abstract long[] getItemIds();
  
  public abstract Future<long[]> getItemIdsInFuture();
  
  public abstract int getState();
  
  public abstract int[] getUnreadItemPosition();
  
  public abstract void loadMore();
  
  public abstract void popIn();
  
  public abstract void refresh(QMRefreshCallback paramQMRefreshCallback);
  
  public abstract void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback);
  
  public abstract void reloadAfterDeleteMailSyncRemote();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.IMailListCursor
 * JD-Core Version:    0.7.0.1
 */