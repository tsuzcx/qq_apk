package com.tencent.qqmail.calendar.data;

import android.database.Cursor;
import com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher;

class ScheduleListCursor$1$1
  implements Runnable
{
  ScheduleListCursor$1$1(ScheduleListCursor.1 param1, Cursor paramCursor) {}
  
  public void run()
  {
    this.this$1.this$0.close();
    ScheduleListCursor.access$002(this.this$1.this$0, this.val$newCusor);
    this.this$1.val$watcher.onLoadSuccess(this.this$1.val$day, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.ScheduleListCursor.1.1
 * JD-Core Version:    0.7.0.1
 */