package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.view.CalendarTableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;
import java.util.HashMap;

class CalendarListFragment$15
  implements UITableView.ClickListener
{
  CalendarListFragment$15(CalendarListFragment paramCalendarListFragment, CalendarTableItemView paramCalendarTableItemView, Account paramAccount) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == this.val$addCalItemView)
    {
      paramUITableItemView = new CalendarEditFragment(this.val$account);
      this.this$0.startFragment(paramUITableItemView);
    }
    while (!(paramUITableItemView instanceof CalendarTableItemView)) {
      return;
    }
    paramUITableItemView = (CalendarTableItemView)paramUITableItemView;
    if (!paramUITableItemView.getIsLeftChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setIsLeftChecked(bool);
      QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((ArrayList)CalendarListFragment.access$800(this.this$0).get(Integer.valueOf(this.val$account.getId()))).get(paramInt - 1);
      CalendarListFragment.access$900(this.this$0).put(Integer.valueOf(localQMCalendarFolder.getId()), Boolean.valueOf(paramUITableItemView.getIsLeftChecked()));
      CalendarListFragment.access$1000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.15
 * JD-Core Version:    0.7.0.1
 */