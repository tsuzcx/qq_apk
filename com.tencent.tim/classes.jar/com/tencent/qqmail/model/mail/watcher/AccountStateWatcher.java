package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface AccountStateWatcher
  extends Watchers.Watcher
{
  public abstract void onStateChange(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.AccountStateWatcher
 * JD-Core Version:    0.7.0.1
 */