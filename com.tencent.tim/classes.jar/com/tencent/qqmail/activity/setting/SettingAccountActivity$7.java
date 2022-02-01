package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingAccountActivity$7
  implements UITableView.ClickListener
{
  SettingAccountActivity$7(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingAccountActivity.access$200(this.this$0)) {
      SettingAccountActivity.access$1100(this.this$0).selectAvatar(true, SettingAccountActivity.access$000(this.this$0).getProfile(), SettingAccountActivity.access$000(this.this$0).getEmail());
    }
    do
    {
      return;
      if (paramUITableItemView == SettingAccountActivity.access$500(this.this$0))
      {
        if (SettingAccountActivity.access$000(this.this$0).isQQMail())
        {
          String str = QMSettingManager.sharedInstance().getAccountNick(SettingAccountActivity.access$300(this.this$0));
          paramInt = SettingAccountActivity.access$300(this.this$0);
          paramUITableItemView = str;
          if (str == null) {
            paramUITableItemView = "";
          }
          paramUITableItemView = SettingQmDefaultNickActivity.createIntent(paramInt, paramUITableItemView);
          this.this$0.startActivity(paramUITableItemView);
          return;
        }
        SettingAccountActivity.access$1200(this.this$0, true);
        return;
      }
      if (paramUITableItemView == SettingAccountActivity.access$800(this.this$0))
      {
        paramUITableItemView = SettingQmDefaultAliasActivity.createIntent(SettingAccountActivity.access$300(this.this$0));
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
    } while (paramUITableItemView != SettingAccountActivity.access$1300(this.this$0));
    paramUITableItemView = SettingSignatureActivity.createIntent(SettingAccountActivity.access$300(this.this$0));
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.7
 * JD-Core Version:    0.7.0.1
 */