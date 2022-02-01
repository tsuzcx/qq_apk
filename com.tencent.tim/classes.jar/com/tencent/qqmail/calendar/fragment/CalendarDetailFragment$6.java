package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class CalendarDetailFragment$6
  implements UITableView.ClickListener
{
  CalendarDetailFragment$6(CalendarDetailFragment paramCalendarDetailFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setMessage(2131691214).addAction(2131691246, new CalendarDetailFragment.6.2(this))).addAction(0, 2131691210, 2, new CalendarDetailFragment.6.1(this, paramInt))).create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.6
 * JD-Core Version:    0.7.0.1
 */