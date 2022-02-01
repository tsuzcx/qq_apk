package com.tencent.qqmail.launcher.third;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.SettingBottleActivity;
import com.tencent.qqmail.activity.setting.SettingFtnActivity;
import com.tencent.qqmail.activity.setting.SettingNoteActivity;
import com.tencent.qqmail.activity.setting.SettingSelectAccountActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class LaunchWebPush$4
  implements QMUIDialogAction.ActionListener
{
  LaunchWebPush$4(int paramInt, Activity paramActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    Intent localIntent = new Intent();
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (this.val$pushType == 1) {
      if (LaunchWebPush.access$100() == 2)
      {
        localObject = ((AccountList)localObject).getDefaultNoteAccount();
        paramQMUIDialog = localIntent;
        if (localObject != null) {
          paramQMUIDialog = SettingSelectAccountActivity.createNoteIntent(((Account)localObject).getId());
        }
      }
    }
    for (;;)
    {
      if (paramQMUIDialog != null) {
        this.val$activity.startActivity(paramQMUIDialog);
      }
      return;
      paramQMUIDialog = localIntent;
      if (LaunchWebPush.access$100() == 1)
      {
        paramQMUIDialog = SettingNoteActivity.createIntent();
        continue;
        if (this.val$pushType == 2)
        {
          if (LaunchWebPush.access$100() == 2)
          {
            localObject = ((AccountList)localObject).getDefaultFtnAccount();
            paramQMUIDialog = localIntent;
            if (localObject != null) {
              paramQMUIDialog = SettingSelectAccountActivity.createFtnIntent(((Account)localObject).getId());
            }
          }
          else
          {
            paramQMUIDialog = localIntent;
            if (LaunchWebPush.access$100() == 1) {
              paramQMUIDialog = SettingFtnActivity.createIntent();
            }
          }
        }
        else
        {
          paramQMUIDialog = localIntent;
          if (this.val$pushType == 3) {
            if (LaunchWebPush.access$100() == 2)
            {
              localObject = ((AccountList)localObject).getDefaultBottleAccount();
              paramQMUIDialog = localIntent;
              if (localObject != null) {
                paramQMUIDialog = SettingSelectAccountActivity.createBottleIntent(((Account)localObject).getId());
              }
            }
            else
            {
              paramQMUIDialog = localIntent;
              if (LaunchWebPush.access$100() == 1) {
                paramQMUIDialog = SettingBottleActivity.createIntent();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchWebPush.4
 * JD-Core Version:    0.7.0.1
 */