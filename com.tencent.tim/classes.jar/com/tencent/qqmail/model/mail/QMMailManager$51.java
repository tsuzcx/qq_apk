package com.tencent.qqmail.model.mail;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;

class QMMailManager$51
  implements Runnable
{
  QMMailManager$51(QMMailManager paramQMMailManager, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.getCliAccountUnreadCount(this.val$accountId, true);
    boolean bool = QMMailManager.access$1200(this.this$0, this.val$accountId);
    QMMailManager.access$1300(this.this$0).put(this.val$accountId, i);
    QMMailManager.access$1400(this.this$0).put(this.val$accountId, bool);
    QMWatcherCenter.triggerAccountUnreadCountUpdate(this.val$accountId, i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.51
 * JD-Core Version:    0.7.0.1
 */