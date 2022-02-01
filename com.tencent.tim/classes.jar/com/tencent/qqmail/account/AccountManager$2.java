package com.tencent.qqmail.account;

import com.tencent.moai.database.sqlite.SQLiteDatabase.HookType;
import com.tencent.moai.database.sqlite.SQLiteDatabase.UpdateHook;

class AccountManager$2
  implements SQLiteDatabase.UpdateHook
{
  AccountManager$2(AccountManager paramAccountManager) {}
  
  public void callback(SQLiteDatabase.HookType paramHookType, String paramString1, String paramString2, int paramInt)
  {
    AccountManager.access$202(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.AccountManager.2
 * JD-Core Version:    0.7.0.1
 */