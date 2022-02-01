package com.tencent.qqmail.permission;

import moai.core.watcher.Watchers.Watcher;

public abstract interface PermissionChangedWatcher
  extends Watchers.Watcher
{
  public abstract void onPermssionChanged(String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.PermissionChangedWatcher
 * JD-Core Version:    0.7.0.1
 */