package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;

class SettingAccountActivity$5
  implements Runnable
{
  SettingAccountActivity$5(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void run()
  {
    QMComposeDataManager.sharedInstance().loadComposeDataThroughNetwork(SettingAccountActivity.access$000(this.this$0).getId(), new SettingAccountActivity.5.1(this), new SettingAccountActivity.5.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.5
 * JD-Core Version:    0.7.0.1
 */