package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface AppUpdateWatcher
  extends Watchers.Watcher
{
  public abstract void onUpdate(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.AppUpdateWatcher
 * JD-Core Version:    0.7.0.1
 */