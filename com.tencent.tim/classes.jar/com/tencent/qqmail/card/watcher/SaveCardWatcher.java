package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SaveCardWatcher
  extends Watchers.Watcher
{
  public abstract void onBefore();
  
  public abstract void onError(QMNetworkError paramQMNetworkError, int paramInt);
  
  public abstract void onSuccess(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.SaveCardWatcher
 * JD-Core Version:    0.7.0.1
 */