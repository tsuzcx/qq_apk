package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.model.QMCalendarManager;

class ReadScheduleFragment$16
  implements View.OnClickListener
{
  ReadScheduleFragment$16(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    int i;
    int j;
    if (ReadScheduleFragment.access$100(this.this$0) != null)
    {
      i = 0;
      j = paramView.getId();
      if (j != 2131376650) {
        break label62;
      }
      i = 3;
    }
    for (;;)
    {
      ReadScheduleFragment.access$1300(this.this$0, i);
      QMCalendarManager.getInstance().updateAppointmentStatus(ReadScheduleFragment.access$100(this.this$0), i);
      this.this$0.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label62:
      if (j == 2131376652) {
        i = 4;
      } else if (j == 2131376654) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.16
 * JD-Core Version:    0.7.0.1
 */