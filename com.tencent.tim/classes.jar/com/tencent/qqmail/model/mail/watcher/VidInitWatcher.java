package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface VidInitWatcher
  extends Watchers.Watcher
{
  public abstract void onInit(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.VidInitWatcher
 * JD-Core Version:    0.7.0.1
 */