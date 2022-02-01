package com.tencent.qqmail.model.mail.watcher;

import java.util.ArrayList;
import moai.core.watcher.Watchers.Watcher;

public abstract interface CalendarNotifyWatcher
  extends Watchers.Watcher
{
  public abstract void onNotify(int paramInt, ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.CalendarNotifyWatcher
 * JD-Core Version:    0.7.0.1
 */