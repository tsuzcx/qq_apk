package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

class CalendarListFragment$21
  implements QMRadioGroup.OnCheckedChangeListener
{
  CalendarListFragment$21(CalendarListFragment paramCalendarListFragment) {}
  
  public void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt)
  {
    CalendarListFragment.access$1402(this.this$0, paramInt);
    paramQMRadioGroup = CalendarListFragment.access$1500(this.this$0).iterator();
    while (paramQMRadioGroup.hasNext()) {
      ((QMRadioGroup)paramQMRadioGroup.next()).resetSelectdItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.21
 * JD-Core Version:    0.7.0.1
 */