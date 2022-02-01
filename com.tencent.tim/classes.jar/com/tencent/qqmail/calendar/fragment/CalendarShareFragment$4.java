package com.tencent.qqmail.calendar.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqmail.activity.compose.ComposeAddrView;
import com.tencent.qqmail.activity.compose.MailAddrsViewControl;

class CalendarShareFragment$4
  implements View.OnTouchListener
{
  CalendarShareFragment$4(CalendarShareFragment paramCalendarShareFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    CalendarShareFragment.access$1000(this.this$0).getAddrsViewControl().setSelectedAddrBtn(paramView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.4
 * JD-Core Version:    0.7.0.1
 */