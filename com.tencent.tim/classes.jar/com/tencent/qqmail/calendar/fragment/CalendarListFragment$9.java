package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.utilities.ui.QMToggleView;
import com.tencent.qqmail.utilities.ui.QMToggleView.QMToggleViewCallback;
import com.tencent.qqmail.view.QMTopBar;
import moai.oss.KvHelper;

class CalendarListFragment$9
  implements QMToggleView.QMToggleViewCallback
{
  CalendarListFragment$9(CalendarListFragment paramCalendarListFragment) {}
  
  public void didDismiss(QMToggleView paramQMToggleView) {}
  
  public void onDismiss(QMToggleView paramQMToggleView) {}
  
  public void onShow(QMToggleView paramQMToggleView)
  {
    if (paramQMToggleView.isHidden())
    {
      this.this$0.getTopBar().setArrowStatus(1);
      return;
    }
    this.this$0.getTopBar().setArrowStatus(0);
  }
  
  public boolean willSelectRow(QMToggleView paramQMToggleView, int paramInt, String paramString)
  {
    this.this$0.getTopBar().setTitle(paramString);
    if (paramString.equals(this.this$0.getString(2131691206))) {
      CalendarListFragment.access$302(this.this$0, CalendarListFragment.CalendarListType.CALENDAR_LIST);
    }
    for (;;)
    {
      CalendarListFragment.access$400(this.this$0, CalendarListFragment.access$300(this.this$0));
      return true;
      CalendarListFragment.access$302(this.this$0, CalendarListFragment.CalendarListType.DEFAULT_CALENDAR_LIST);
      KvHelper.eventToggleCalendarList(new double[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.9
 * JD-Core Version:    0.7.0.1
 */