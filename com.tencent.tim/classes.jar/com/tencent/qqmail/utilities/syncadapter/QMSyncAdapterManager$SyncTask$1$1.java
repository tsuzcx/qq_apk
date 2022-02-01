package com.tencent.qqmail.utilities.syncadapter;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.SyncUpdateCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class QMSyncAdapterManager$SyncTask$1$1
  implements SyncUpdateCallback
{
  QMSyncAdapterManager$SyncTask$1$1(QMSyncAdapterManager.SyncTask.1 param1) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    if (this.this$1.val$completed.getAndSet(true)) {}
    Account localAccount;
    do
    {
      return;
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(QMSyncAdapterManager.SyncTask.access$900(this.this$1.this$0));
    } while (localAccount == null);
    int i = localAccount.getAccountState();
    if (i != 0) {
      SPManager.getEditor("qmsyncadapter_info").putLong(QMSyncAdapterManager.SyncTask.access$800(this.this$1.this$0) + "_last_time", System.currentTimeMillis()).apply();
    }
    QMLog.log(5, "QMSyncAdapterManager", "sync failed: " + QMSyncAdapterManager.SyncTask.access$800(this.this$1.this$0) + ", accountState: " + i + ", error: " + paramQMNetworkError);
    QMSyncAdapterManager.access$1200(QMSyncAdapterManager.SyncTask.access$1100(this.this$1.this$0));
  }
  
  public void onSuccess(int paramInt)
  {
    if (this.this$1.val$completed.getAndSet(true)) {
      return;
    }
    QMLog.log(4, "QMSyncAdapterManager", "sync mail success: " + QMSyncAdapterManager.SyncTask.access$800(this.this$1.this$0) + ", num: " + paramInt);
    QMSyncAdapterManager.SyncTask.access$1100(this.this$1.this$0).mailNum.getAndAdd(paramInt);
    SPManager.getEditor("qmsyncadapter_info").putLong(QMSyncAdapterManager.SyncTask.access$800(this.this$1.this$0) + "_last_time", System.currentTimeMillis()).apply();
    QMSyncAdapterManager.access$1200(QMSyncAdapterManager.SyncTask.access$1100(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager.SyncTask.1.1
 * JD-Core Version:    0.7.0.1
 */