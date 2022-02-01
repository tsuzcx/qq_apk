package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.CalendarShareError;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareWatcher;

class CalendarShareFragment$3
  implements CalendarShareWatcher
{
  CalendarShareFragment$3(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void onError(int paramInt, String[] paramArrayOfString, CalendarShareError paramCalendarShareError)
  {
    if (paramInt == CalendarShareFragment.access$100(this.this$0).getId()) {
      CalendarShareFragment.access$900(this.this$0, new CalendarShareFragment.3.3(this, paramCalendarShareError));
    }
  }
  
  public void onProcess(int paramInt, String[] paramArrayOfString)
  {
    if (paramInt == CalendarShareFragment.access$100(this.this$0).getId()) {
      CalendarShareFragment.access$700(this.this$0, new CalendarShareFragment.3.1(this));
    }
  }
  
  public void onSuccess(int paramInt, String[] paramArrayOfString)
  {
    if (paramInt == CalendarShareFragment.access$100(this.this$0).getId()) {
      CalendarShareFragment.access$800(this.this$0, new CalendarShareFragment.3.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.3
 * JD-Core Version:    0.7.0.1
 */