package com.tencent.qqmail.utilities.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;

final class QMSyncAdapterManager$3
  implements Runnable
{
  QMSyncAdapterManager$3(String paramString) {}
  
  public void run()
  {
    QMSyncAdapterManager.access$602(true);
    Account localAccount = new Account(this.val$name, QMSyncAdapterManager.access$200());
    try
    {
      bool = ((Boolean)AccountManager.get(QMApplicationContext.sharedInstance()).removeAccount(localAccount, null, null).getResult()).booleanValue();
      QMSyncAdapterManager.access$602(false);
      QMLog.log(4, "QMSyncAdapterManager", "deleteAccount, success: " + bool + ", account: " + this.val$name);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager.3
 * JD-Core Version:    0.7.0.1
 */