package com.tencent.qqmail.model.mail;

import java.util.List;

public abstract interface GroupMailAccountWatcher
{
  public abstract boolean isQQMail(int paramInt);
  
  public abstract void onSyncAdConv(int paramInt, boolean paramBoolean);
  
  public abstract void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong);
  
  public abstract void onSyncLocalComplete();
  
  public abstract void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2);
  
  public abstract void onSyncSubscribeConv(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.GroupMailAccountWatcher
 * JD-Core Version:    0.7.0.1
 */