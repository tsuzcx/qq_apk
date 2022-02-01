package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.model.QMCalendarManager;

class ReadIcsFragment$6
  implements View.OnClickListener
{
  ReadIcsFragment$6(ReadIcsFragment paramReadIcsFragment) {}
  
  public void onClick(View paramView)
  {
    int i;
    int j;
    if ((ReadIcsFragment.access$000(this.this$0) != null) && (ReadIcsFragment.access$000(this.this$0) != null))
    {
      i = 0;
      j = paramView.getId();
      if (j != 2131376650) {
        break label72;
      }
      i = 3;
    }
    for (;;)
    {
      QMCalendarManager.getInstance().updateAppointmentStatus(ReadIcsFragment.access$000(this.this$0), i);
      ReadIcsFragment.access$900(this.this$0, i);
      this.this$0.popBackStack();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label72:
      if (j == 2131376652) {
        i = 4;
      } else if (j == 2131376654) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment.6
 * JD-Core Version:    0.7.0.1
 */