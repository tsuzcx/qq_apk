package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadListWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onPopIn(long paramLong, String paramString);
  
  public abstract void onProcess(int paramInt, boolean paramBoolean);
  
  public abstract void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.LoadListWatcher
 * JD-Core Version:    0.7.0.1
 */