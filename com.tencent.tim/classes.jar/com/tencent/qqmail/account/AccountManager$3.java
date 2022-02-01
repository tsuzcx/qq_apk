package com.tencent.qqmail.account;

import com.tencent.qqmail.account.model.Account;
import java.util.ArrayList;

class AccountManager$3
  implements QMAccountSQLiteHelper.IGetAccount
{
  AccountManager$3(AccountManager paramAccountManager, ArrayList paramArrayList) {}
  
  public void onItem(Account paramAccount)
  {
    this.val$accounts.add(paramAccount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.AccountManager.3
 * JD-Core Version:    0.7.0.1
 */