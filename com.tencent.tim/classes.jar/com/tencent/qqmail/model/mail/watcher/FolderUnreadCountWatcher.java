package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface FolderUnreadCountWatcher
  extends Watchers.Watcher
{
  public abstract void onUpdateAccount(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void onUpdateFolder(int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.FolderUnreadCountWatcher
 * JD-Core Version:    0.7.0.1
 */