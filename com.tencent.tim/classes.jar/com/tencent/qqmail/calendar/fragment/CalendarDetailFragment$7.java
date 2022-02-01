package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder;

class CalendarDetailFragment$7
  implements View.OnClickListener
{
  CalendarDetailFragment$7(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onClick(View paramView)
  {
    QMBottomDialog.BottomGridSheetBuilder localBottomGridSheetBuilder = new QMBottomDialog.BottomGridSheetBuilder(this.this$0.getActivity());
    localBottomGridSheetBuilder.addItem(2130840794, this.this$0.getString(2131720035), this.this$0.getString(2131720035), 0);
    if (DeviceUtil.isWeChatInstalled()) {
      localBottomGridSheetBuilder.addItem(2130840799, this.this$0.getString(2131720037), this.this$0.getString(2131720037), 0);
    }
    if (DeviceUtil.isQQInstalled()) {
      localBottomGridSheetBuilder.addItem(2130840795, this.this$0.getString(2131720036), this.this$0.getString(2131720036), 0);
    }
    if (DeviceUtil.isWeWorkInstalled()) {
      localBottomGridSheetBuilder.addItem(2130840797, this.this$0.getString(2131720038), this.this$0.getString(2131720038), 0);
    }
    localBottomGridSheetBuilder.setOnSheetItemClickListener(new CalendarDetailFragment.7.1(this));
    localBottomGridSheetBuilder.build().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.7
 * JD-Core Version:    0.7.0.1
 */