package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingBottleActivity$5
  implements UITableView.ClickListener
{
  SettingBottleActivity$5(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingBottleActivity.access$500(this.this$0))
    {
      paramUITableItemView = SettingSelectAccountActivity.createBottleIntent(SettingBottleActivity.access$600(this.this$0));
      this.this$0.startActivity(paramUITableItemView);
    }
    do
    {
      do
      {
        return;
        if (paramUITableItemView != SettingBottleActivity.access$300(this.this$0)) {
          break;
        }
        SettingBottleActivity.access$700(this.this$0);
        paramUITableItemView = AccountManager.shareInstance().getAccountList().getAccountById(SettingBottleActivity.access$600(this.this$0));
      } while (SettingBottleActivity.access$800(this.this$0) == null);
      SettingBottleActivity.access$800(this.this$0).selectAvatar(true, paramUITableItemView.getProfile(), paramUITableItemView.getEmail());
      return;
      if (paramUITableItemView == SettingBottleActivity.access$900(this.this$0))
      {
        SettingBottleActivity.access$1000(this.this$0, true);
        return;
      }
    } while (paramUITableItemView != SettingBottleActivity.access$1100(this.this$0));
    SettingBottleActivity.access$700(this.this$0);
    SettingBottleActivity.access$1200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.5
 * JD-Core Version:    0.7.0.1
 */