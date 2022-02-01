package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMSchedule;
import org.apache.commons.lang3.StringUtils;

class ReadScheduleFragment$17
  implements View.OnClickListener
{
  ReadScheduleFragment$17(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadScheduleFragment.access$100(this.this$0).getRecurrenceType() != -1) {
      if (!StringUtils.isBlank(ReadScheduleFragment.access$000(this.this$0).getExceptionId())) {
        ReadScheduleFragment.access$1000(this.this$0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadScheduleFragment.access$1400(this.this$0);
      continue;
      ReadScheduleFragment.access$1000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.17
 * JD-Core Version:    0.7.0.1
 */