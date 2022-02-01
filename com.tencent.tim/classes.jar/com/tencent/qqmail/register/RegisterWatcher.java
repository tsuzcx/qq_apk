package com.tencent.qqmail.register;

import moai.core.watcher.Watchers.Watcher;

public abstract interface RegisterWatcher
  extends Watchers.Watcher
{
  public abstract void onError(String paramString1, String paramString2, String paramString3);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.RegisterWatcher
 * JD-Core Version:    0.7.0.1
 */