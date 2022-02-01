package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.model.task.QMTask;
import moai.core.watcher.Watchers.Watcher;

public abstract interface QMTaskListChangeWatcher
  extends Watchers.Watcher
{
  public abstract void onTaskComplete(QMTask paramQMTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.QMTaskListChangeWatcher
 * JD-Core Version:    0.7.0.1
 */