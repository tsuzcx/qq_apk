package com.tencent.qqmail.model.mail.watcher;

import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarScheduleTableHookWatcher
  extends Watchers.Watcher
{
  public abstract void updateHook(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.CalendarScheduleTableHookWatcher
 * JD-Core Version:    0.7.0.1
 */