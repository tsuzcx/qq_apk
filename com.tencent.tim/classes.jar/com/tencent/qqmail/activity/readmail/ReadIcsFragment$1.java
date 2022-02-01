package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.model.mail.watcher.QMCalendarSyncICSWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadIcsFragment$1
  implements QMCalendarSyncICSWatcher
{
  ReadIcsFragment$1(ReadIcsFragment paramReadIcsFragment) {}
  
  public void onComplete(int paramInt)
  {
    QMLog.log(4, "ReadIcsFragment", "load event complete " + paramInt);
    if ((ReadIcsFragment.access$000(this.this$0) != null) && (ReadIcsFragment.access$000(this.this$0).getAccountId() == paramInt)) {
      ReadIcsFragment.access$200(this.this$0, new ReadIcsFragment.1.1(this));
    }
  }
  
  public void onStart(int paramInt)
  {
    QMLog.log(4, "ReadIcsFragment", "load event start " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment.1
 * JD-Core Version:    0.7.0.1
 */