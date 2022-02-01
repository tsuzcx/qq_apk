package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;

class CalendarEditFragment$5
  implements QMRadioGroup.OnCheckedChangeListener
{
  CalendarEditFragment$5(CalendarEditFragment paramCalendarEditFragment) {}
  
  public void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt)
  {
    CalendarEditFragment.access$502(this.this$0, paramInt);
    paramQMRadioGroup.setSelectedItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarEditFragment.5
 * JD-Core Version:    0.7.0.1
 */