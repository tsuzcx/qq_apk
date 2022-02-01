package com.tencent.qqmail.activity.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface AppStatusWatcher
  extends Watchers.Watcher
{
  public abstract void gotoBackGround();
  
  public abstract void gotoForGround();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.watcher.AppStatusWatcher
 * JD-Core Version:    0.7.0.1
 */