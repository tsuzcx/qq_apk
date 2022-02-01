package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.view.CalendarTableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;
import java.util.HashMap;

class CalendarListFragment$20
  implements UITableView.ClickListener
{
  CalendarListFragment$20(CalendarListFragment paramCalendarListFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if ((paramUITableItemView instanceof CalendarTableItemView))
    {
      paramUITableItemView = (CalendarTableItemView)paramUITableItemView;
      if (paramUITableItemView.getIsLeftChecked()) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setIsLeftChecked(bool);
      QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((ArrayList)CalendarListFragment.access$800(this.this$0).get(Integer.valueOf(0))).get(paramInt - 1);
      CalendarListFragment.access$900(this.this$0).put(Integer.valueOf(localQMCalendarFolder.getId()), Boolean.valueOf(paramUITableItemView.getIsLeftChecked()));
      CalendarListFragment.access$1000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.20
 * JD-Core Version:    0.7.0.1
 */