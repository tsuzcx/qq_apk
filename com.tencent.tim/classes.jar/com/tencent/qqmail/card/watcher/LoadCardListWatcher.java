package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadCardListWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore(int paramInt);
  
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.LoadCardListWatcher
 * JD-Core Version:    0.7.0.1
 */