package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadVipContactListWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher
 * JD-Core Version:    0.7.0.1
 */