package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;

class SettingQmDefaultAliasActivity$1
  implements Runnable
{
  SettingQmDefaultAliasActivity$1(SettingQmDefaultAliasActivity paramSettingQmDefaultAliasActivity) {}
  
  public void run()
  {
    QMComposeDataManager.sharedInstance().loadComposeDataThroughNetwork(SettingQmDefaultAliasActivity.access$000(this.this$0).getId(), new SettingQmDefaultAliasActivity.1.1(this), new SettingQmDefaultAliasActivity.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultAliasActivity.1
 * JD-Core Version:    0.7.0.1
 */