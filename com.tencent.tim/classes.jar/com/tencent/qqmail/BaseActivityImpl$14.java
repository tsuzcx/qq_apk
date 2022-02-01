package com.tencent.qqmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.watcher.XqqwxPublicAccountWatcher;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Date;

class BaseActivityImpl$14
  implements XqqwxPublicAccountWatcher
{
  BaseActivityImpl$14(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onX(int paramInt, String paramString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && (localAccount.isBizMail())) {
      QMLog.log(4, "BaseActivityImpl", "xqqwxWatcher. " + paramInt + " isbiz.");
    }
    do
    {
      return;
      if (!AppStatusUtil.isAppOnForeground()) {
        QMLog.log(4, "BaseActivityImpl", "xqqwxWatcher. app not active. ignore");
      }
      if (!BaseActivityImpl.access$500(this.this$0))
      {
        Threads.runInBackground(new BaseActivityImpl.14.1(this, paramInt, paramString), 2000L);
        return;
      }
    } while (new Date().getTime() - SharedPreferenceUtil.getXQQWXShowLastTime() < 1800000L);
    Threads.runOnMainThread(new BaseActivityImpl.14.2(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.14
 * JD-Core Version:    0.7.0.1
 */