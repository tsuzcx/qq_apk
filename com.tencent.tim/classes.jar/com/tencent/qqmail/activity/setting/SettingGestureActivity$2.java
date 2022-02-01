package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.log.QMLog;

class SettingGestureActivity$2
  implements View.OnClickListener
{
  SettingGestureActivity$2(SettingGestureActivity paramSettingGestureActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localObject != null)
    {
      QMLog.log(4, "SettingGestureActivity", "GESPWD initial account:" + ((Account)localObject).getEmail());
      localObject = LoginFragmentActivity.createIntentForGesVerify(((Account)localObject).getId(), ((Account)localObject).getEmail(), false);
      this.this$0.startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QMLog.log(5, "SettingGestureActivity", "GESPWD no account exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.2
 * JD-Core Version:    0.7.0.1
 */