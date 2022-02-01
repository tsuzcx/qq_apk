package com.tencent.qqmail.account.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract interface AccountLoginWatcher
{
  public abstract void onError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2);
  
  public abstract void onProcess(int paramInt, long paramLong);
  
  public abstract void onSuccess(int paramInt, long paramLong, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.watcher.AccountLoginWatcher
 * JD-Core Version:    0.7.0.1
 */