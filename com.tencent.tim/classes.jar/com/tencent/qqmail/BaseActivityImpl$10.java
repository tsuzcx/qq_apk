package com.tencent.qqmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.model.mail.watcher.AccountStateWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Map;

class BaseActivityImpl$10
  implements AccountStateWatcher
{
  BaseActivityImpl$10(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onStateChange(int paramInt1, int paramInt2, String paramString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if (localAccount == null) {
      return;
    }
    if ((BaseActivityImpl.access$700(this.this$0) != null) && (BaseActivityImpl.access$700(this.this$0).containsKey(localAccount.getEmail())))
    {
      long l = System.currentTimeMillis() - ((Long)BaseActivityImpl.access$700(this.this$0).get(localAccount.getEmail())).longValue();
      if (l < 3600000L)
      {
        QMLog.log(5, "BaseActivityImpl", "onStateChange, do not show account reverify dialog, interval: " + l + "ms");
        return;
      }
    }
    try
    {
      QMLog.log(4, "BaseActivityImpl", "is onStateChange handling : " + PasswordErrHandling.isHandling() + ",account state change : " + paramInt1 + ",state:" + paramInt2);
      if (PasswordErrHandling.isHandling())
      {
        QMLog.log(4, "BaseActivityImpl", "acc : " + paramInt1 + " psw err. not show dialog");
        return;
      }
    }
    finally {}
    QMLog.log(4, "BaseActivityImpl", "go handle onStateChange err:" + paramInt1 + ",state:" + paramInt2);
    if (!BaseActivityImpl.access$500(this.this$0))
    {
      Threads.runInBackground(new BaseActivityImpl.10.1(this, paramInt1, paramInt2, paramString), 2000L);
      return;
    }
    Threads.runOnMainThread(new BaseActivityImpl.10.2(this, paramInt1, localAccount, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.10
 * JD-Core Version:    0.7.0.1
 */