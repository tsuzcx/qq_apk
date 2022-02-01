package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface OperationAttachFolderWatcher
  extends Watchers.Watcher
{
  public abstract void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess(long[] paramArrayOfLong);
  
  public abstract void onSuccess(long[] paramArrayOfLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.OperationAttachFolderWatcher
 * JD-Core Version:    0.7.0.1
 */