package com.tencent.qqmail.calendar.fragment;

import android.content.Context;
import android.view.View;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class EventChecker$EventRecurrentChecker$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  EventChecker$EventRecurrentChecker$1(EventChecker.EventRecurrentChecker paramEventRecurrentChecker, ModifyScheduleFragment.Solution paramSolution, QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.mContext.getString(2131691123)))
    {
      this.val$solution.setModifyType(0);
      if (this.this$0.mNextChecker == null) {
        break label131;
      }
      this.this$0.mNextChecker.validateEventData(this.val$originalEvent, this.val$newEvent, this.val$listener, this.val$solution);
    }
    for (;;)
    {
      paramQMBottomDialog.dismiss();
      return;
      if (paramString.equals(this.this$0.mContext.getString(2131691122)))
      {
        this.val$solution.setModifyType(1);
        break;
      }
      if (!paramString.equals(this.this$0.mContext.getString(2131691121))) {
        break;
      }
      this.val$solution.setModifyType(2);
      break;
      label131:
      this.val$listener.onCheckSuccess(this.val$solution);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.EventChecker.EventRecurrentChecker.1
 * JD-Core Version:    0.7.0.1
 */