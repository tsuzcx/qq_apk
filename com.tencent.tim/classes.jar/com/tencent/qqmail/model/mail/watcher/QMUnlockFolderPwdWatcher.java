package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface QMUnlockFolderPwdWatcher
  extends Watchers.Watcher
{
  public abstract void onCancel(int paramInt1, int paramInt2);
  
  public abstract void onDismiss(int paramInt1, int paramInt2);
  
  public abstract void onError(int paramInt1, int paramInt2);
  
  public abstract void onSuccess(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher
 * JD-Core Version:    0.7.0.1
 */