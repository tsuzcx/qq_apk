package com.tencent.qqmail.ftn.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface FtnGetDownloadUrlWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.watcher.FtnGetDownloadUrlWatcher
 * JD-Core Version:    0.7.0.1
 */