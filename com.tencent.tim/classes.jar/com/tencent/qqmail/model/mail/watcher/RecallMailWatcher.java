package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface RecallMailWatcher
  extends Watchers.Watcher
{
  public abstract void onError(long paramLong, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess(long paramLong);
  
  public abstract void onQueryError(long paramLong, QMNetworkError paramQMNetworkError);
  
  public abstract void onQueryProcess(long paramLong);
  
  public abstract void onQuerySuccess(long paramLong);
  
  public abstract void onSuccess(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.RecallMailWatcher
 * JD-Core Version:    0.7.0.1
 */