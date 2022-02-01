package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class CalendarDetailFragment$9
  implements View.OnClickListener
{
  CalendarDetailFragment$9(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onClick(View paramView)
  {
    QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity());
    if (CalendarDetailFragment.access$100(this.this$0).isShareOwnerFolder()) {}
    for (int i = 2131691073;; i = 2131691072)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localMessageDialogBuilder.setMessage(i).addAction(2131691246, new CalendarDetailFragment.9.2(this))).addAction(0, 2131691840, 2, new CalendarDetailFragment.9.1(this))).create().show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.9
 * JD-Core Version:    0.7.0.1
 */