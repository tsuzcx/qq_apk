package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface ThankCardWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore();
  
  public abstract void onError(String paramString, long paramLong, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.ThankCardWatcher
 * JD-Core Version:    0.7.0.1
 */