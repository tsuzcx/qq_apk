package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarShareFragment$1
  implements LoadContactListWatcher
{
  CalendarShareFragment$1(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    CalendarShareFragment.access$000(this.this$0);
  }
  
  public void onSuccess(int paramInt)
  {
    CalendarShareFragment.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.1
 * JD-Core Version:    0.7.0.1
 */