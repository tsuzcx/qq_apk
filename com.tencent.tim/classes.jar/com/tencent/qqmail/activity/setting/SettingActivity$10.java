package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.inquirymail.InquiryMailFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingActivity$10
  implements UITableView.ClickListener
{
  SettingActivity$10(SettingActivity paramSettingActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingActivity.access$1600(this.this$0))
    {
      QMSettingManager.sharedInstance().setAboutRead();
      if ((QMPushConfigUtil.showUpgradeVersion()) && (!QMSettingManager.sharedInstance().getNewVersionRead()))
      {
        DataCollector.logEvent("Event_Setting_About_New_Click");
        QMSettingManager.sharedInstance().setNewVersionRead(true);
      }
      paramUITableItemView = SettingAboutActivity.createIntent();
      this.this$0.startActivity(paramUITableItemView);
    }
    do
    {
      return;
      if (paramUITableItemView == SettingActivity.access$1700(this.this$0))
      {
        paramUITableItemView = SettingHelpActivity.createIntent("https://kf.qq.com/touch/product/mail_app.html?scene_id=kf1866");
        this.this$0.startActivity(paramUITableItemView);
        return;
      }
      if (paramUITableItemView == SettingActivity.access$1800(this.this$0))
      {
        DataCollector.logEvent("Event_Received_Mail_Entrance_Click");
        paramUITableItemView = AccountManager.shareInstance().getAccountList();
        if ((paramUITableItemView.size() == 1) && (paramUITableItemView.hasQQMailAccounts())) {}
        for (paramUITableItemView = InquiryMailFragmentActivity.createIntentToMailList(paramUITableItemView.getFirstQQAccount().getId());; paramUITableItemView = InquiryMailFragmentActivity.createIntentToAccountList())
        {
          this.this$0.startActivity(paramUITableItemView);
          return;
        }
      }
    } while (paramUITableItemView != SettingActivity.access$1900(this.this$0));
    paramUITableItemView = DeveloperActivity.createIntent();
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.10
 * JD-Core Version:    0.7.0.1
 */