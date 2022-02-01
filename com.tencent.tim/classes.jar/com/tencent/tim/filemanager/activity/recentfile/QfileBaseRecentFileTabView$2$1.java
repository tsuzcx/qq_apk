package com.tencent.tim.filemanager.activity.recentfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

class QfileBaseRecentFileTabView$2$1
  implements Runnable
{
  QfileBaseRecentFileTabView$2$1(QfileBaseRecentFileTabView.2 param2, List paramList) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB addAll");
    }
    if (this.a.this$0.AT != null) {
      this.a.this$0.AT.clear();
    }
    if (this.a.this$0.AT == null) {
      this.a.this$0.AT = new ArrayList();
    }
    this.a.this$0.AT.addAll(this.AU);
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.TAG, 2, "queryFileEntitiesFromDB end size[" + this.a.this$0.AT.size() + "]");
    }
    this.a.this$0.dfD();
    SharedPreferences localSharedPreferences = QfileBaseRecentFileTabView.d(this.a.this$0).getApplication().getSharedPreferences("OfflineFileMerge" + QfileBaseRecentFileTabView.c(this.a.this$0).getCurrentUin(), 0);
    long l1 = localSharedPreferences.getLong("LastRequestTime", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) > 86400000L)
    {
      QLog.i(QfileBaseRecentFileTabView.TAG, 1, "updata offlineList");
      QfileBaseRecentFileTabView.a(this.a.this$0);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB -> getRecentFileRecords ");
      }
      return;
      localSharedPreferences.edit().putLong("LastRequestTime", l2).commit();
      QLog.i(QfileBaseRecentFileTabView.TAG, 1, "updata last process time");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView.2.1
 * JD-Core Version:    0.7.0.1
 */