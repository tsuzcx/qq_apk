package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SearchMailWatcher
  extends Watchers.Watcher
{
  public abstract void onComplete();
  
  public abstract void onError(QMNetworkError paramQMNetworkError, boolean paramBoolean);
  
  public abstract void onLock(int paramInt1, int paramInt2);
  
  public abstract void onProcess(long paramLong);
  
  public abstract void onSuccess(long[] paramArrayOfLong, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SearchMailWatcher
 * JD-Core Version:    0.7.0.1
 */