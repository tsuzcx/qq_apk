package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMGesturePasswordView;

class SettingGestureActivity$3$2
  implements SettingGestureActivity.VerifyCallback
{
  SettingGestureActivity$3$2(SettingGestureActivity.3 param3) {}
  
  public void handleError(int paramInt)
  {
    QMSettingManager.sharedInstance().saveTryGestureTimes(paramInt);
    paramInt = QMSettingManager.sharedInstance().getTryGestureTimes();
    SettingGestureActivity.access$000(this.this$1.this$0).showError(String.format(this.this$1.this$0.getResources().getString(2131719850), new Object[] { Integer.valueOf(5 - paramInt) }));
  }
  
  public void handleExceedMaxTimes()
  {
    QMLog.log(4, "SettingGestureActivity", "handleExceed. goto verify psw page.");
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localObject != null)
    {
      QMSettingManager.sharedInstance().saveTryGestureTimes(6);
      localObject = LoginFragmentActivity.createIntentForGesVerify(((Account)localObject).getId(), ((Account)localObject).getEmail(), true);
      this.this$1.this$0.startActivity((Intent)localObject);
      this.this$1.this$0.finishWithNoCheck();
      return;
    }
    QMLog.log(5, "SettingGestureActivity", "handleExceed no account exist");
  }
  
  public void handleSuccess()
  {
    DataCollector.logEvent("Event_Gesture_auth_success");
    QMSettingManager.sharedInstance().saveTryGestureTimes(0);
    QMLog.log(4, "SettingGestureActivity", "unlock success");
    GesturePasswordManager.getInstance().setGesturePwdPassed(true);
    this.this$1.this$0.finish();
    if (QMActivityManager.shareInstance().getActivitySize() <= 0)
    {
      this.this$1.this$0.overridePendingTransition(2130772023, 2130772423);
      return;
    }
    this.this$1.this$0.overridePendingTransition(2130772423, 2130772025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.3.2
 * JD-Core Version:    0.7.0.1
 */