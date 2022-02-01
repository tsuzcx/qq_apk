package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.watcher.LoadCalendarListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarDetailFragment$1
  implements LoadCalendarListWatcher
{
  CalendarDetailFragment$1(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(int paramInt)
  {
    CalendarDetailFragment.access$000(this.this$0, new CalendarDetailFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */