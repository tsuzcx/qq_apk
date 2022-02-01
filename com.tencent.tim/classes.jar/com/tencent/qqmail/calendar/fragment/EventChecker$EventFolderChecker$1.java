package com.tencent.qqmail.calendar.fragment;

import android.content.Context;
import android.view.View;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class EventChecker$EventFolderChecker$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  EventChecker$EventFolderChecker$1(EventChecker.EventFolderChecker paramEventFolderChecker, QMCalendarFolder paramQMCalendarFolder, QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.mContext.getString(2131691068))) {
      QMCalendarManager.getInstance().updateCalendarFolderIsShow(this.val$folder, true);
    }
    if (this.this$0.mNextChecker != null) {
      this.this$0.mNextChecker.validateEventData(this.val$originalEvent, this.val$newEvent, this.val$listener, this.val$solution);
    }
    for (;;)
    {
      paramQMBottomDialog.dismiss();
      return;
      this.val$listener.onCheckSuccess(this.val$solution);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.EventChecker.EventFolderChecker.1
 * JD-Core Version:    0.7.0.1
 */