package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;

class SettingQmDefaultNickActivity$1
  implements Runnable
{
  SettingQmDefaultNickActivity$1(SettingQmDefaultNickActivity paramSettingQmDefaultNickActivity) {}
  
  public void run()
  {
    QMComposeDataManager.sharedInstance().loadComposeDataThroughNetwork(SettingQmDefaultNickActivity.access$000(this.this$0).getId(), new SettingQmDefaultNickActivity.1.1(this), new SettingQmDefaultNickActivity.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultNickActivity.1
 * JD-Core Version:    0.7.0.1
 */