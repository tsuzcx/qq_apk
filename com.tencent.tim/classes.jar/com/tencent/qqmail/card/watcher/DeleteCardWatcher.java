package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface DeleteCardWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString, QMNetworkError paramQMNetworkError);
  
  public abstract void onLocalSuccess(String paramString);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.DeleteCardWatcher
 * JD-Core Version:    0.7.0.1
 */