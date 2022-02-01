package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import com.tencent.qqmail.utilities.uitableview.UITableItemTextView;

class ModifyScheduleFragment$7
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ModifyScheduleFragment$7(ModifyScheduleFragment paramModifyScheduleFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramInt = Integer.valueOf(paramString).intValue();
    ModifyScheduleFragment.access$100(this.this$0).setRecurrenceType(paramInt);
    ModifyScheduleFragment.access$100(this.this$0).setDaysOfMonth(null);
    QMCalendarUtil.setRecurrenceElementForEvent(ModifyScheduleFragment.access$100(this.this$0));
    paramView = QMCalendarUtil.createReadableStringOfRecurrence(ModifyScheduleFragment.access$100(this.this$0));
    ModifyScheduleFragment.access$1100(this.this$0).setTextWithGrayStyle(paramView);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.7
 * JD-Core Version:    0.7.0.1
 */