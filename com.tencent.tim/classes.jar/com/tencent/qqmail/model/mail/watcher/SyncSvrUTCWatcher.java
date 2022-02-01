package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SyncSvrUTCWatcher
  extends Watchers.Watcher
{
  public abstract void onSyncError(QMNetworkError paramQMNetworkError);
  
  public abstract void onSyncSuccess(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SyncSvrUTCWatcher
 * JD-Core Version:    0.7.0.1
 */