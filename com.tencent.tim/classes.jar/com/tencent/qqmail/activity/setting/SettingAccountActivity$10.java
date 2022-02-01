package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingAccountActivity$10
  implements UITableView.ClickListener
{
  SettingAccountActivity$10(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingAccountActivity.access$1700(this.this$0)) {
      if ((SettingAccountActivity.access$000(this.this$0).isQQMail()) || (SettingAccountActivity.access$000(this.this$0).isGMail()))
      {
        paramUITableItemView = LoginFragmentActivity.createIntentForAccountSetting(SettingAccountActivity.access$300(this.this$0), SettingAccountActivity.access$000(this.this$0).getEmail());
        this.this$0.startActivity(paramUITableItemView);
      }
    }
    do
    {
      return;
      if ((SettingAccountActivity.access$000(this.this$0).isExchangeMail()) || (SettingAccountActivity.access$000(this.this$0).isActiveSyncMail()))
      {
        paramUITableItemView = LoginFragmentActivity.createIntentForSettingProtocol(SettingAccountActivity.access$300(this.this$0), false);
        break;
      }
      paramUITableItemView = LoginFragmentActivity.createIntentForSettingProtocol(SettingAccountActivity.access$300(this.this$0), false);
      break;
      if (paramUITableItemView == SettingAccountActivity.access$1800(this.this$0))
      {
        paramUITableItemView = SettingSyncMethodActivity.createIntent(SettingAccountActivity.access$300(this.this$0));
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
    } while (paramUITableItemView != SettingAccountActivity.access$1900(this.this$0));
    paramUITableItemView = SettingSyncMailCountActivity.createIntent(SettingAccountActivity.access$300(this.this$0));
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.10
 * JD-Core Version:    0.7.0.1
 */