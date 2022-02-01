package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.report.QMPushReportManager;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPushService$12
  implements Runnable
{
  QMPushService$12(QMPushService paramQMPushService) {}
  
  public void run()
  {
    Threads.removeCallbackInBackground(this);
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = QMPushService.access$1800();
    SharedPreferences.Editor localEditor = QMPushService.access$1900();
    long l2 = localSharedPreferences.getLong("last_record_time", 0L);
    localEditor.putLong("last_record_time", l1);
    l1 -= l2;
    if (l1 < 86400000L)
    {
      QMPushReportManager.existing(l1);
      if (localSharedPreferences.getLong("life_begin_time", -1L) == -1L) {
        localEditor.putLong("life_begin_time", System.currentTimeMillis());
      }
      localEditor.putLong("life_exist_time", l1 + localSharedPreferences.getLong("life_exist_time", 0L));
    }
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.12
 * JD-Core Version:    0.7.0.1
 */