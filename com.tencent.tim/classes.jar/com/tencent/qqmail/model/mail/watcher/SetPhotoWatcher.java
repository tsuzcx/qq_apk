package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface SetPhotoWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt);
  
  public abstract void onSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SetPhotoWatcher
 * JD-Core Version:    0.7.0.1
 */