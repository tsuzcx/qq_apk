package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarListFragment$6
  implements CalendarStopShareWatcher
{
  CalendarListFragment$6(CalendarListFragment paramCalendarListFragment) {}
  
  public void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(int paramInt, String paramString) {}
  
  public void onSuccess(int paramInt, String paramString)
  {
    CalendarListFragment.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.6
 * JD-Core Version:    0.7.0.1
 */