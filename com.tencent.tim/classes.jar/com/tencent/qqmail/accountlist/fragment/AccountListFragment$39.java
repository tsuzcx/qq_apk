package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.activity.setting.SettingActivity;
import com.tencent.qqmail.activity.setting.SettingCacheClearActivity.ClickRemindClearCache;

class AccountListFragment$39
  implements SettingCacheClearActivity.ClickRemindClearCache
{
  AccountListFragment$39(AccountListFragment paramAccountListFragment) {}
  
  public void click()
  {
    this.this$0.startActivity(SettingActivity.createIntent("from_account_list"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.39
 * JD-Core Version:    0.7.0.1
 */