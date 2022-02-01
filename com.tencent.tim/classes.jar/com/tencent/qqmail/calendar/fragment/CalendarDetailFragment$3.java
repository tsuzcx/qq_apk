package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareWXUrlWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarDetailFragment$3
  implements CalendarShareWXUrlWatcher
{
  CalendarDetailFragment$3(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == CalendarDetailFragment.access$100(this.this$0).getId()) {
      CalendarDetailFragment.access$1100(this.this$0, new CalendarDetailFragment.3.3(this));
    }
  }
  
  public void onProcess(int paramInt)
  {
    if (paramInt == CalendarDetailFragment.access$100(this.this$0).getId()) {
      CalendarDetailFragment.access$500(this.this$0, new CalendarDetailFragment.3.1(this));
    }
  }
  
  public void onSuccess(int paramInt, String paramString)
  {
    if (paramInt == CalendarDetailFragment.access$100(this.this$0).getId()) {
      CalendarDetailFragment.access$1000(this.this$0, new CalendarDetailFragment.3.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */