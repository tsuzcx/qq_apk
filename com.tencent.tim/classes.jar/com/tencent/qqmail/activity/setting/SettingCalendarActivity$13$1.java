package com.tencent.qqmail.activity.setting;

import android.view.View;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import moai.oss.KvHelper;

class SettingCalendarActivity$13$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  SettingCalendarActivity$13$1(SettingCalendarActivity.13 param13) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      SettingCalendarActivity.access$100(this.this$1.this$0).modifyDefaultStartDayOfWeek(1);
      KvHelper.eventCalendarWidgetWeekStartSunday(new double[0]);
    }
    for (;;)
    {
      SettingCalendarActivity.access$1600(this.this$1.this$0).setDetail(QMCalendarUtil.getWeekString(SettingCalendarActivity.access$100(this.this$1.this$0).getDefaultStartDayOfWeek()));
      paramQMBottomDialog.dismiss();
      return;
      if (paramInt == 1)
      {
        SettingCalendarActivity.access$100(this.this$1.this$0).modifyDefaultStartDayOfWeek(2);
        KvHelper.eventCalendarWidgetWeekStartMonday(new double[0]);
      }
      else if (paramInt == 2)
      {
        SettingCalendarActivity.access$100(this.this$1.this$0).modifyDefaultStartDayOfWeek(7);
        KvHelper.eventCalendarWidgetWeekStartSaturday(new double[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.13.1
 * JD-Core Version:    0.7.0.1
 */