package com.tencent.qqmail.calendar.fragment;

import android.widget.AutoCompleteTextView;
import com.tencent.qqmail.activity.compose.ComposeAddrView;
import com.tencent.qqmail.activity.compose.MailAddrsViewControl;

class CalendarShareFragment$7
  implements Runnable
{
  CalendarShareFragment$7(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void run()
  {
    CalendarShareFragment.access$1000(this.this$0).getAddrsViewControl().getInputATV().requestFocus();
    this.this$0.showKeyBoard();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.7
 * JD-Core Version:    0.7.0.1
 */