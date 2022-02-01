package com.tencent.qqmail.account;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.LogoutCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountManager$4
  implements LogoutCallback
{
  AccountManager$4(AccountManager paramAccountManager, Account paramAccount) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, AccountManager.access$300(), "logout account errorCode:" + paramInt1 + " detailCode:" + paramInt2 + " detailMsg:" + paramString);
  }
  
  public void onSuccess(Profile paramProfile)
  {
    QMLog.log(4, AccountManager.access$300(), "logout account success:" + this.val$acc.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.AccountManager.4
 * JD-Core Version:    0.7.0.1
 */