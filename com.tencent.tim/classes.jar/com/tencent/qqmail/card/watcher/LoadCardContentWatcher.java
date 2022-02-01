package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadCardContentWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.LoadCardContentWatcher
 * JD-Core Version:    0.7.0.1
 */