package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadAttachFolderListWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt, boolean paramBoolean, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess(int paramInt1, int paramInt2);
  
  public abstract void onSuccess(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher
 * JD-Core Version:    0.7.0.1
 */