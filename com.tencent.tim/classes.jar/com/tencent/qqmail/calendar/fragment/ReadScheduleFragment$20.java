package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadScheduleFragment$20
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadScheduleFragment$20(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    QMCalendarManager.getInstance();
    if (paramString.equals(this.this$0.getString(2131691107))) {
      ReadScheduleFragment.access$1100(this.this$0, ReadScheduleFragment.access$100(this.this$0), 0, ReadScheduleFragment.access$000(this.this$0));
    }
    for (;;)
    {
      QMCalendarManager.logEvent("Event_Calendar_Delete_Event");
      paramQMBottomDialog.dismiss();
      this.this$0.finish();
      return;
      if (paramString.equals(this.this$0.getString(2131691106))) {
        ReadScheduleFragment.access$1100(this.this$0, ReadScheduleFragment.access$100(this.this$0), 1, ReadScheduleFragment.access$000(this.this$0));
      } else if (paramString.equals(this.this$0.getString(2131691105))) {
        ReadScheduleFragment.access$1100(this.this$0, ReadScheduleFragment.access$100(this.this$0), 2, ReadScheduleFragment.access$000(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.20
 * JD-Core Version:    0.7.0.1
 */