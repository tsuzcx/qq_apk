package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.watcher.CalendarFolderDeleteWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarListFragment$3
  implements CalendarFolderDeleteWatcher
{
  CalendarListFragment$3(CalendarListFragment paramCalendarListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    CalendarListFragment.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.3
 * JD-Core Version:    0.7.0.1
 */