package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;

class CalendarShareFragment$10
  implements Runnable
{
  CalendarShareFragment$10(CalendarShareFragment paramCalendarShareFragment) {}
  
  public void run()
  {
    List localList = QMContactManager.sharedInstance().fetchLocalCachingShowingContacts();
    if ((localList != null) && (!localList.isEmpty())) {
      Threads.runOnMainThread(new CalendarShareFragment.10.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.10
 * JD-Core Version:    0.7.0.1
 */