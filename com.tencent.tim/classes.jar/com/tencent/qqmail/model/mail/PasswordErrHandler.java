package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.log.QMLog;

public class PasswordErrHandler
{
  public static void saveStateAndShowErr(int paramInt1, int paramInt2)
  {
    saveStateAndShowErr(paramInt1, paramInt2, "");
  }
  
  public static void saveStateAndShowErr(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "PasswordErrHandler", "ProtocolPswErrHandler show err. state:" + paramInt2 + ",aid:" + paramInt1 + ",tips:" + paramString);
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if (localAccount != null)
    {
      if (!localAccount.isActiveSyncMail()) {
        AccountManager.shareInstance().saveAccountState(paramInt1, paramInt2);
      }
      AccountManager.shareInstance().triggerAccountStateChange(paramInt1, paramInt2, paramString);
      QMLog.log(6, "PasswordErrHandler", AddAccountLocalLogUtil.getAllAccountLog());
      if (paramInt2 == -1) {
        QMMailManager.sharedInstance().stopIdle(localAccount);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.PasswordErrHandler
 * JD-Core Version:    0.7.0.1
 */