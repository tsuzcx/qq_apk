package com.tencent.qqmail;

import android.content.Intent;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$7
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$7(BaseActivityImpl paramBaseActivityImpl, Account paramAccount, int paramInt) {}
  
  private void handleDevLock()
  {
    Intent localIntent = LoginFragmentActivity.createIntentForDeviceLock(this.val$acc.getId(), this.val$acc.getEmail());
    this.this$0.startActivity(localIntent);
  }
  
  private void handlePwdErr()
  {
    if ((this.val$acc.isQQMail()) || (this.val$acc.isGMail()))
    {
      localIntent = LoginFragmentActivity.createIntentForVerifyPswError(this.val$acc.getId(), this.val$acc.getEmail());
      this.this$0.startActivity(localIntent);
      return;
    }
    Intent localIntent = LoginFragmentActivity.createIntentForSettingProtocol(this.val$acc.getId(), true);
    this.this$0.startActivity(localIntent);
  }
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    PasswordErrHandling.setUserClickHandle(true);
    paramQMUIDialog.dismiss();
    if (this.val$state == -5)
    {
      QMLog.log(4, "BaseActivityImpl", "handleDevLock:" + this.val$acc.getEmail());
      handleDevLock();
      return;
    }
    QMLog.log(4, "BaseActivityImpl", "handlePwdErr:" + this.val$acc.getEmail());
    handlePwdErr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.7
 * JD-Core Version:    0.7.0.1
 */