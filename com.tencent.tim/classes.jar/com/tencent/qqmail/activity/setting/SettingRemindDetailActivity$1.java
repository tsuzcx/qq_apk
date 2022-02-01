package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingRemindDetailActivity$1
  implements UITableView.ClickListener
{
  SettingRemindDetailActivity$1(SettingRemindDetailActivity paramSettingRemindDetailActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (!SettingRemindDetailActivity.access$000(this.this$0).isQQMail()) {
        QMSettingManager.sharedInstance().setPushInboxOnly(SettingRemindDetailActivity.access$100(this.this$0), paramUITableItemView.isChecked());
      }
      QMSettingManager.sharedInstance().setNotifyAccountMail(SettingRemindDetailActivity.access$100(this.this$0), paramUITableItemView.isChecked());
      if (!SettingRemindDetailActivity.access$000(this.this$0).isQQMail()) {
        break label106;
      }
      SettingRemindDetailActivity.access$200(this.this$0, paramUITableItemView.isChecked());
    }
    for (;;)
    {
      SettingRemindDetailActivity.access$300(this.this$0);
      SettingRemindDetailActivity.access$400(this.this$0);
      return;
      bool = false;
      break;
      label106:
      QMMailManager.sharedInstance().setNotifyProtocolAccountMail(SettingRemindDetailActivity.access$100(this.this$0), paramUITableItemView.isChecked());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindDetailActivity.1
 * JD-Core Version:    0.7.0.1
 */