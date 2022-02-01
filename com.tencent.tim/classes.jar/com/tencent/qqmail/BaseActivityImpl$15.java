package com.tencent.qqmail;

import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.model.mail.watcher.CalendarNotifyWatcher;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class BaseActivityImpl$15
  implements CalendarNotifyWatcher
{
  BaseActivityImpl$15(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onNotify(int paramInt, ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1)
  {
    int i = 0;
    int k = 0;
    int j;
    if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0))
    {
      Queue localQueue1 = QMRemindererBroadcast.calendarRemindIdQueue;
      Queue localQueue2 = QMRemindererBroadcast.calendarSubjectQueue;
      QMRemindererBroadcast.calendarRemindIdQueue = new ArrayBlockingQueue(QMRemindererBroadcast.calendarRemindIdQueue.size() + paramInt);
      QMRemindererBroadcast.calendarSubjectQueue = new ArrayBlockingQueue(QMRemindererBroadcast.calendarSubjectQueue.size() + paramInt);
      int m = localQueue1.size();
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        QMRemindererBroadcast.calendarRemindIdQueue.add(localQueue1.poll());
        QMRemindererBroadcast.calendarSubjectQueue.add(localQueue2.poll());
        i += 1;
      }
    }
    while (j < paramInt)
    {
      QMRemindererBroadcast.calendarRemindIdQueue.add(paramArrayList.get(j));
      QMRemindererBroadcast.calendarSubjectQueue.add(paramArrayList1.get(j));
      j += 1;
      continue;
      QMRemindererBroadcast.calendarRemindIdQueue = new ArrayBlockingQueue(paramInt);
      QMRemindererBroadcast.calendarSubjectQueue = new ArrayBlockingQueue(paramInt);
      while (i < paramInt)
      {
        QMRemindererBroadcast.calendarRemindIdQueue.add(paramArrayList.get(i));
        QMRemindererBroadcast.calendarSubjectQueue.add(paramArrayList1.get(i));
        i += 1;
      }
    }
    if ((BaseActivityImpl.access$1100(this.this$0) == null) || (!BaseActivityImpl.access$1100(this.this$0).isShowing())) {
      this.this$0.myCalendarRemindDialog(((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue(), (String)QMRemindererBroadcast.calendarSubjectQueue.peek());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.15
 * JD-Core Version:    0.7.0.1
 */