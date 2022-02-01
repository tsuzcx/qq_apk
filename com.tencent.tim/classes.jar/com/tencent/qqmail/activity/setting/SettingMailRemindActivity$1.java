package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingMailRemindActivity$1
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$1(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingMailRemindActivity.access$000(this.this$0)) {
      if (paramUITableItemView.isChecked()) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      QMSettingManager.sharedInstance().setNewMailPush(bool);
      QMMailManager.sharedInstance().setNewMailPush(bool);
      QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
      SettingMailRemindActivity.access$100(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.1
 * JD-Core Version:    0.7.0.1
 */