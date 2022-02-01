package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import java.util.HashSet;

class QMCalendarManager$23
  implements QMCalendarManager.ILoadEventListCallback
{
  QMCalendarManager$23(QMCalendarManager paramQMCalendarManager, HashSet paramHashSet, Account paramAccount) {}
  
  public void onComplete(int paramInt)
  {
    this.val$idSet.remove(Integer.valueOf(paramInt));
    if (this.val$idSet.isEmpty())
    {
      QMWatcherCenter.triggerCalendarLoadAllEventComplete(this.val$account.getId());
      CalendarWidgetManager.getInstance().setHasInitDone(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.23
 * JD-Core Version:    0.7.0.1
 */