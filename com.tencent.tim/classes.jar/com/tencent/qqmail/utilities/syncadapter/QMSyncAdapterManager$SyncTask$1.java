package com.tencent.qqmail.utilities.syncadapter;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class QMSyncAdapterManager$SyncTask$1
  implements CheckMailCallback
{
  QMSyncAdapterManager$SyncTask$1(QMSyncAdapterManager.SyncTask paramSyncTask, AtomicBoolean paramAtomicBoolean) {}
  
  public void notSync()
  {
    if (this.val$completed.getAndSet(true)) {
      return;
    }
    QMLog.log(5, "QMSyncAdapterManager", "checkMail done, no need to do maillist, email: " + QMSyncAdapterManager.SyncTask.access$800(this.this$0));
    SPManager.getEditor("qmsyncadapter_info").putLong(QMSyncAdapterManager.SyncTask.access$800(this.this$0) + "_last_time", System.currentTimeMillis()).apply();
    QMSyncAdapterManager.access$1200(QMSyncAdapterManager.SyncTask.access$1100(this.this$0));
  }
  
  public void onSync(QMFolder[] paramArrayOfQMFolder)
  {
    QMLog.log(4, "QMSyncAdapterManager", "checkMail done, need to do maillist, email: " + QMSyncAdapterManager.SyncTask.access$800(this.this$0) + ", folders: " + Arrays.toString(paramArrayOfQMFolder));
    QMMailManager.sharedInstance().syncUpdateWithNotification(QMSyncAdapterManager.SyncTask.access$900(this.this$0), paramArrayOfQMFolder, true, QMSyncAdapterManager.SyncTask.access$1000(this.this$0), new QMSyncAdapterManager.SyncTask.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager.SyncTask.1
 * JD-Core Version:    0.7.0.1
 */