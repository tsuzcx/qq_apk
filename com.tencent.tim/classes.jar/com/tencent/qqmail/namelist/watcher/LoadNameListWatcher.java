package com.tencent.qqmail.namelist.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadNameListWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore(int paramInt);
  
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.watcher.LoadNameListWatcher
 * JD-Core Version:    0.7.0.1
 */