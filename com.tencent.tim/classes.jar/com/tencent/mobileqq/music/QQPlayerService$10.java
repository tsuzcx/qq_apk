package com.tencent.mobileqq.music;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqiv;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class QQPlayerService$10
  implements Runnable
{
  QQPlayerService$10(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    SharedPreferences localSharedPreferences = this.this$0.getSharedPreferences("QQPlayerService.sp", 0);
    long l1 = localSharedPreferences.getLong("del_timestamp", 0L);
    long l2 = localCalendar.getTimeInMillis();
    if (l1 < l2)
    {
      localSharedPreferences.edit().putLong("del_timestamp", l2).commit();
      if (QLog.isColorLevel()) {
        QLog.d("MusicCacheManager", 2, "lastDel<today =====>> delCacheByTimeAndSpace");
      }
      aqiv.edV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.10
 * JD-Core Version:    0.7.0.1
 */