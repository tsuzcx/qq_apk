package com.tencent.qqmail.activity.setting;

import android.widget.Button;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;

class SettingAccountActivity$12$1
  implements QMUIDialogAction.ActionListener
{
  SettingAccountActivity$12$1(SettingAccountActivity.12 param12) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$1.val$defaultAccountButton.setEnabled(false);
    this.this$1.val$defaultAccountButton.setText(2131719881);
    AccountManager.shareInstance().setDefaultMailAccount(SettingAccountActivity.access$300(this.this$1.this$0));
    if (SettingAccountActivity.access$000(this.this$1.this$0).isQQMail()) {
      DataCollector.logEvent("Event_Set_QQ_Account_As_Default_Mail_Account_In_Setting_Page");
    }
    for (;;)
    {
      paramQMUIDialog.dismiss();
      QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
      QMSyncAdapterManager.checkAccount();
      return;
      DataCollector.logEvent("Event_Set_Protocol_Account_As_Default_Mail_Account_In_Setting_Page");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.12.1
 * JD-Core Version:    0.7.0.1
 */