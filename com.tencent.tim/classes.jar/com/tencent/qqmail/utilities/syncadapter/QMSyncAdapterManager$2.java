package com.tencent.qqmail.utilities.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

final class QMSyncAdapterManager$2
  implements Runnable
{
  QMSyncAdapterManager$2(boolean paramBoolean) {}
  
  public void run()
  {
    String str = QMSyncAdapterManager.access$100();
    if (TextUtils.isEmpty(str)) {}
    Account localAccount;
    boolean bool2;
    do
    {
      return;
      localAccount = new Account(str, QMSyncAdapterManager.access$200());
      boolean bool1 = AccountManager.get(QMApplicationContext.sharedInstance()).addAccountExplicitly(localAccount, "", Bundle.EMPTY);
      ContentResolver.addPeriodicSync(localAccount, QMSyncAdapterManager.access$300(), QMSyncAdapterManager.access$400(), QMSyncAdapterManager.access$500());
      bool2 = SPManager.getSp("qmsyncadapter_info").getBoolean("set_sync_auto_once_v4", false);
      QMLog.log(4, "QMSyncAdapterManager", "add account, success: " + bool1 + ", account: " + str + ", period: " + QMSyncAdapterManager.access$500() + "s, force: " + this.val$force + ", setSyncAuto: " + bool2);
    } while ((!this.val$force) && (bool2));
    ContentResolver.setSyncAutomatically(localAccount, QMSyncAdapterManager.access$300(), true);
    ContentResolver.setIsSyncable(localAccount, QMSyncAdapterManager.access$300(), 1);
    QMSyncAdapterManager.setUserRemoved(false);
    SPManager.getEditor("qmsyncadapter_info").putBoolean("set_sync_auto_once_v4", true).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager.2
 * JD-Core Version:    0.7.0.1
 */