package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener;
import moai.oss.KvHelper;

class CalendarDetailFragment$7$1
  implements QMBottomDialog.BottomGridSheetBuilder.OnSheetItemClickListener
{
  CalendarDetailFragment$7$1(CalendarDetailFragment.7 param7) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView)
  {
    paramView = (String)paramView.getTag();
    if (paramView.equals(this.this$1.this$0.getString(2131720035)))
    {
      paramQMBottomDialog.dismiss();
      KvHelper.eventCalendarShareCalendarByEmail(new double[0]);
      CalendarDetailFragment.access$602(this.this$1.this$0, 0);
      CalendarDetailFragment.access$1300(this.this$1.this$0);
    }
    do
    {
      return;
      if (paramView.equals(this.this$1.this$0.getString(2131720037)))
      {
        paramQMBottomDialog.dismiss();
        KvHelper.eventCalendarShareCalendarByWx(new double[0]);
        CalendarDetailFragment.access$602(this.this$1.this$0, 1);
        CalendarDetailFragment.access$1400(this.this$1.this$0);
        return;
      }
      if (paramView.equals(this.this$1.this$0.getString(2131720036)))
      {
        paramQMBottomDialog.dismiss();
        KvHelper.eventCalendarShareCalendarByQq(new double[0]);
        CalendarDetailFragment.access$602(this.this$1.this$0, 2);
        CalendarDetailFragment.access$1400(this.this$1.this$0);
        return;
      }
    } while (!paramView.equals(this.this$1.this$0.getString(2131720038)));
    paramQMBottomDialog.dismiss();
    KvHelper.eventCalendarShareCalendarByWework(new double[0]);
    CalendarDetailFragment.access$602(this.this$1.this$0, 3);
    CalendarDetailFragment.access$1400(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.7.1
 * JD-Core Version:    0.7.0.1
 */