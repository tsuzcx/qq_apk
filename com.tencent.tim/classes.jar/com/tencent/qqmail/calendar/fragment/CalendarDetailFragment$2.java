package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarDetailFragment$2
  implements CalendarStopShareWatcher
{
  CalendarDetailFragment$2(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == CalendarDetailFragment.access$100(this.this$0).getId()) {
      CalendarDetailFragment.access$400(this.this$0, new CalendarDetailFragment.2.3(this));
    }
  }
  
  public void onProcess(int paramInt, String paramString)
  {
    if (paramInt == CalendarDetailFragment.access$100(this.this$0).getId()) {
      CalendarDetailFragment.access$200(this.this$0, new CalendarDetailFragment.2.1(this));
    }
  }
  
  public void onSuccess(int paramInt, String paramString)
  {
    if (paramInt == CalendarDetailFragment.access$100(this.this$0).getId()) {
      CalendarDetailFragment.access$300(this.this$0, new CalendarDetailFragment.2.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */