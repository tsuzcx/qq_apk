package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;

class ReadMailFragment$149
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$149(ReadMailFragment paramReadMailFragment, Long paramLong, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    boolean bool2 = false;
    if (paramString.equals(this.this$0.getString(2131696292)))
    {
      long l = this.val$UTCLongTime.longValue();
      paramView = ReadMailFragment.access$000(this.this$0).getInformation().getSubject();
      boolean bool1 = bool2;
      if (!this.val$calendar.contains(":"))
      {
        bool1 = bool2;
        if (!this.val$calendar.contains("："))
        {
          bool1 = bool2;
          if (!this.val$calendar.contains("时"))
          {
            bool1 = bool2;
            if (!this.val$calendar.contains("点")) {
              bool1 = true;
            }
          }
        }
      }
      paramView = CalendarFragmentActivity.createIntentToModifySchedule(l, paramView, bool1);
      this.this$0.startActivity(paramView);
      this.this$0.getActivity().overridePendingTransition(2130772401, 2130772402);
      DataCollector.logEvent("Event_Content_Recognize_Create_Calendar_Event");
      paramQMBottomDialog.dismiss();
    }
    do
    {
      return;
      if (paramString.equals(this.this$0.getString(2131691484)))
      {
        QMActivityManager.shareInstance().finishAllActivity();
        paramView = CalendarFragmentActivity.createIntentToCheckSchedule(this.val$UTCLongTime.longValue());
        this.this$0.startActivity(paramView);
        this.this$0.getActivity().overridePendingTransition(2130772114, 2130772167);
        DataCollector.logEvent("Event_Content_Recognize_Check_Calendar_Schedule");
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$0.getString(2131692324)))
      {
        this.this$0.copy(this.val$calendar);
        paramQMBottomDialog.dismiss();
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131718775)));
    KvHelper.creditCardBillClickInContentDate(new double[0]);
    ReadMailFragment.access$15200(this.this$0);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.149
 * JD-Core Version:    0.7.0.1
 */