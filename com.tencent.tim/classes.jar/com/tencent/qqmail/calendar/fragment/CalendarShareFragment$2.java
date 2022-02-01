package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CalendarShareFragment$2
  implements QMGetVerifyImageWatcher
{
  CalendarShareFragment$2(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError)
  {
    if (paramInt == CalendarShareFragment.access$100(this.this$0).getId()) {
      CalendarShareFragment.access$600(this.this$0, new CalendarShareFragment.2.2(this));
    }
  }
  
  public void onProcess(int paramInt, String paramString) {}
  
  public void onSuccess(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramInt == CalendarShareFragment.access$100(this.this$0).getId()) {
      CalendarShareFragment.access$500(this.this$0, new CalendarShareFragment.2.1(this, paramString2, paramString1, paramString3, paramString4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.2
 * JD-Core Version:    0.7.0.1
 */