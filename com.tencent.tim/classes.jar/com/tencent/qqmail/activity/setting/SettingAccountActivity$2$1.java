package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingAccountActivity$2$1
  implements Runnable
{
  SettingAccountActivity$2$1(SettingAccountActivity.2 param2, String paramString) {}
  
  public void run()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(SettingAccountActivity.access$300(this.this$1.this$0));
    if (localAccount == null) {}
    while ((this.val$nickname == null) || (this.val$nickname.equals(SettingAccountActivity.access$400(this.this$1.this$0)))) {
      return;
    }
    SettingAccountActivity.access$500(this.this$1.this$0).setDetail(this.val$nickname);
    if (localAccount.isQQMail())
    {
      QMComposeDataManager.sharedInstance().setQMDefaultNick(SettingAccountActivity.access$300(this.this$1.this$0), this.val$nickname);
      return;
    }
    QMSettingManager.sharedInstance().setAccountNick(SettingAccountActivity.access$300(this.this$1.this$0), this.val$nickname);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.2.1
 * JD-Core Version:    0.7.0.1
 */