package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CalendarListFragment$13
  implements View.OnClickListener
{
  CalendarListFragment$13(CalendarListFragment paramCalendarListFragment) {}
  
  public void onClick(View paramView)
  {
    if (CalendarListFragment.access$500(this.this$0))
    {
      CalendarListFragment.access$600(this.this$0).setText(2131719702);
      CalendarListFragment.access$700(this.this$0, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      CalendarListFragment.access$600(this.this$0).setText(2131719689);
      CalendarListFragment.access$700(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.13
 * JD-Core Version:    0.7.0.1
 */