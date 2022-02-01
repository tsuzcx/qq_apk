package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.namelist.fragment.NameListFragmentActivity;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingActivity$6
  implements UITableView.ClickListener
{
  SettingActivity$6(SettingActivity paramSettingActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool = true;
    if (paramUITableItemView == SettingActivity.access$1000(this.this$0)) {
      if (!paramUITableItemView.isChecked())
      {
        paramUITableItemView.setChecked(bool);
        QMSettingManager.sharedInstance().setEnableSendMailSound(paramUITableItemView.isChecked());
        QMMailManager.sharedInstance().setSendMailSound(paramUITableItemView.isChecked());
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (paramUITableItemView == SettingActivity.access$1100(this.this$0))
      {
        paramUITableItemView = SettingReplyForwardSubjectActivity.createIntent();
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
      if (paramUITableItemView == SettingActivity.access$1200(this.this$0))
      {
        paramUITableItemView = AccountManager.shareInstance().getAccountList();
        if (paramUITableItemView.size() == 1) {}
        for (paramUITableItemView = NameListFragmentActivity.createIntentToMainList(paramUITableItemView.get(0).getId(), NameListContact.NameListContactType.BLACK.ordinal());; paramUITableItemView = NameListFragmentActivity.createIntentToAccountList(NameListContact.NameListContactType.BLACK.ordinal()))
        {
          this.this$0.startActivity(paramUITableItemView);
          DataCollector.logEvent("Event_Click_Black_Name_List_In_Setting");
          return;
        }
      }
    } while (paramUITableItemView != SettingActivity.access$1300(this.this$0));
    paramUITableItemView = AccountManager.shareInstance().getAccountList();
    if (paramUITableItemView.size() == 1) {}
    for (paramUITableItemView = NameListFragmentActivity.createIntentToMainList(paramUITableItemView.get(0).getId(), NameListContact.NameListContactType.WHITE.ordinal());; paramUITableItemView = NameListFragmentActivity.createIntentToAccountList(NameListContact.NameListContactType.WHITE.ordinal()))
    {
      this.this$0.startActivity(paramUITableItemView);
      DataCollector.logEvent("Event_Click_White_Name_List_In_Setting");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.6
 * JD-Core Version:    0.7.0.1
 */