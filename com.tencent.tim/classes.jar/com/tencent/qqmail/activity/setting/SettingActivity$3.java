package com.tencent.qqmail.activity.setting;

import android.widget.LinearLayout;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingActivity$3
  implements UITableView.ClickListener
{
  SettingActivity$3(SettingActivity paramSettingActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramInt == ((LinearLayout)paramUITableItemView.getParent()).getChildCount() - 1)
    {
      paramUITableItemView = AccountTypeListActivity.createIntent("extra_from_setting");
      this.this$0.startActivity(paramUITableItemView);
    }
    while ((SettingActivity.access$200(this.this$0) == null) || (paramInt >= SettingActivity.access$200(this.this$0).size())) {
      return;
    }
    paramUITableItemView = SettingAccountActivity.createIntent(SettingActivity.access$200(this.this$0).get(paramInt).getId());
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.3
 * JD-Core Version:    0.7.0.1
 */