package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarActivity$13
  implements UITableView.ClickListener
{
  SettingCalendarActivity$13(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramInt == 0)
    {
      SettingCalendarFragmentActivity.flag = SettingCalendarFragmentActivity.REMIND_TIME;
      paramUITableItemView = SettingCalendarFragmentActivity.createIntent();
      this.this$0.startActivity(paramUITableItemView);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        SettingCalendarFragmentActivity.flag = SettingCalendarFragmentActivity.EVENT_DURATION;
        paramUITableItemView = SettingCalendarFragmentActivity.createIntent();
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
      if (paramInt == 2)
      {
        SettingCalendarFragmentActivity.flag = SettingCalendarFragmentActivity.SYNC_TIME;
        paramUITableItemView = SettingCalendarFragmentActivity.createIntent();
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
    } while (paramInt != 3);
    paramUITableItemView = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity(), true);
    paramUITableItemView.setTitle(this.this$0.getString(2131719706));
    paramUITableItemView.addItem(this.this$0.getString(2131691156));
    paramUITableItemView.addItem(this.this$0.getString(2131691152));
    paramUITableItemView.addItem(this.this$0.getString(2131691154));
    paramUITableItemView.setCheckedIndex(this.this$0.getSelectedStartDayOfWeekIndex());
    paramUITableItemView.setOnSheetItemClickListener(new SettingCalendarActivity.13.1(this));
    paramUITableItemView.build().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.13
 * JD-Core Version:    0.7.0.1
 */