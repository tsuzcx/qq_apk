package com.tencent.mobileqq.filemanager.activity.recentfile;

import agne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class QfileBaseRecentFileTabView$2
  implements Runnable
{
  QfileBaseRecentFileTabView$2(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.TAG, 2, "queryFileEntitiesFromDB thread start");
    }
    if ((this.this$0.mUin != null) && (this.this$0.mUin.trim().length() != 0)) {}
    for (List localList = QfileBaseRecentFileTabView.a(this.this$0).a().av(this.this$0.mUin);; localList = QfileBaseRecentFileTabView.b(this.this$0).a().eU())
    {
      Collections.sort(localList, this.this$0.comparator);
      if (localList != null) {
        QfileBaseRecentFileTabView.a(this.this$0, new QfileBaseRecentFileTabView.2.1(this, localList));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.2
 * JD-Core Version:    0.7.0.1
 */