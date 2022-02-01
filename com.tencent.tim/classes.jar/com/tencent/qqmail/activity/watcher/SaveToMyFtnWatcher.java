package com.tencent.qqmail.activity.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface SaveToMyFtnWatcher
  extends Watchers.Watcher
{
  public abstract void onBegin();
  
  public abstract void onError(int paramInt);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.watcher.SaveToMyFtnWatcher
 * JD-Core Version:    0.7.0.1
 */