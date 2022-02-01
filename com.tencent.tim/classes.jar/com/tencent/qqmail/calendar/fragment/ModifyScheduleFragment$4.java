package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.uitableview.UITableItemCheckBoxView;
import com.tencent.qqmail.utilities.uitableview.UITableItemCheckBoxView.OnCheckChangeListener;

class ModifyScheduleFragment$4
  implements UITableItemCheckBoxView.OnCheckChangeListener
{
  ModifyScheduleFragment$4(ModifyScheduleFragment paramModifyScheduleFragment) {}
  
  public void onChange(UITableItemCheckBoxView paramUITableItemCheckBoxView, boolean paramBoolean)
  {
    paramUITableItemCheckBoxView.setChecked(paramBoolean);
    paramUITableItemCheckBoxView = ModifyScheduleFragment.access$100(this.this$0);
    if (!ModifyScheduleFragment.access$100(this.this$0).isAllDay())
    {
      paramBoolean = true;
      paramUITableItemCheckBoxView.setIsAllDay(paramBoolean);
      if (!ModifyScheduleFragment.access$100(this.this$0).isAllDay()) {
        break label127;
      }
      ModifyScheduleFragment.access$100(this.this$0).setReminder(ModifyScheduleFragment.access$800(this.this$0).getDefaultAllDayReminderTime());
    }
    for (;;)
    {
      ModifyScheduleFragment.access$900(this.this$0, ModifyScheduleFragment.access$100(this.this$0).getStartTime(), ModifyScheduleFragment.access$100(this.this$0).getEndTime(), ModifyScheduleFragment.access$100(this.this$0).isAllDay());
      KeyBoardHelper.hideKeyBoard(ModifyScheduleFragment.access$400(this.this$0));
      this.this$0.render(0);
      return;
      paramBoolean = false;
      break;
      label127:
      ModifyScheduleFragment.access$100(this.this$0).setReminder(ModifyScheduleFragment.access$800(this.this$0).getDefaultReminderTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.4
 * JD-Core Version:    0.7.0.1
 */