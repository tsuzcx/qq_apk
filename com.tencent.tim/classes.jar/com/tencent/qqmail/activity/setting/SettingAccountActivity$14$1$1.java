package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.ui.QMTips;

class SettingAccountActivity$14$1$1
  implements Runnable
{
  SettingAccountActivity$14$1$1(SettingAccountActivity.14.1 param1) {}
  
  public void run()
  {
    this.this$2.this$1.this$0.getTips().dismissTipsManually();
    QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 0)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      this.this$2.this$1.this$0.finishWithNoCheck();
      localObject = AccountTypeListActivity.createIntent();
      this.this$2.this$1.this$0.startActivity((Intent)localObject);
      SettingAccountActivity.14.access$2400(this.this$2.this$1);
      SettingAccountActivity.14.access$2500(this.this$2.this$1);
      FolderDataManager.sharedInstance().deleteFolderDataList();
      AccountManager.shareInstance().setDefaultMailAccount(0);
      SettingGestureConfigActivity.disableGesturePassword();
    }
    for (;;)
    {
      int i = QMSettingManager.sharedInstance().getFirstAccountIDForBottle();
      QMSettingManager.sharedInstance().setDefaultBottleAccountID(this.this$2.val$currentDefaultBottleAccountId, i);
      QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
      QMSettingManager.sharedInstance().setNameListContactHasLoad(SettingAccountActivity.access$300(this.this$2.this$1.this$0), false);
      return;
      if (this.this$2.val$isDefaultMailAccount) {
        AccountManager.shareInstance().setDefaultMailAccount(((AccountList)localObject).get(0).getId());
      }
      this.this$2.this$1.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.14.1.1
 * JD-Core Version:    0.7.0.1
 */