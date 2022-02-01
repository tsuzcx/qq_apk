package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import java.util.HashSet;

class QMCalendarManager$22
  implements QMCalendarManager.ILoadEventListCallback
{
  QMCalendarManager$22(QMCalendarManager paramQMCalendarManager, HashSet paramHashSet, Account paramAccount) {}
  
  public void onComplete(int paramInt)
  {
    this.val$idSet.remove(Integer.valueOf(paramInt));
    if (this.val$idSet.isEmpty()) {
      QMWatcherCenter.triggerCalendarSyncICSComplete(this.val$account.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.22
 * JD-Core Version:    0.7.0.1
 */