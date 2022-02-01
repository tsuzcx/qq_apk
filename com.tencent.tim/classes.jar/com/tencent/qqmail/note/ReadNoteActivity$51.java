package com.tencent.qqmail.note;

import android.view.View;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ReadNoteActivity$51
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadNoteActivity$51(ReadNoteActivity paramReadNoteActivity, Long paramLong, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    boolean bool;
    if (paramString.equals(this.this$0.getString(2131696292)))
    {
      long l = this.val$UTCLongTime.longValue();
      paramView = ReadNoteActivity.access$100(this.this$0).information.subject;
      if ((!this.val$calendar.contains(":")) && (!this.val$calendar.contains("：")) && (!this.val$calendar.contains("时")) && (!this.val$calendar.contains("点")))
      {
        bool = true;
        paramView = CalendarFragmentActivity.createIntentToModifySchedule(l, paramView, bool);
        this.this$0.startActivity(paramView);
        DataCollector.logEvent("Event_Content_Recognize_Create_Calendar_Event");
        paramQMBottomDialog.dismiss();
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (paramString.equals(this.this$0.getString(2131691484)))
      {
        QMActivityManager.shareInstance().finishAllActivity();
        paramView = CalendarFragmentActivity.createIntentToCheckSchedule(this.val$UTCLongTime.longValue());
        this.this$0.startActivity(paramView);
        DataCollector.logEvent("Event_Content_Recognize_Check_Calendar_Schedule");
        paramQMBottomDialog.dismiss();
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131692324)));
    this.this$0.copy(this.val$calendar);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.51
 * JD-Core Version:    0.7.0.1
 */