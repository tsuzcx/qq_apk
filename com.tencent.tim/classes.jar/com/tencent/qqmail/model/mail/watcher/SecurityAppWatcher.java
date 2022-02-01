package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface SecurityAppWatcher
  extends Watchers.Watcher
{
  public abstract void onSecAppHappen(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SecurityAppWatcher
 * JD-Core Version:    0.7.0.1
 */