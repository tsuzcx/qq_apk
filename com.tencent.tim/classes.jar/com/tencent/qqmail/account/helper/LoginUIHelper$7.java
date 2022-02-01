package com.tencent.qqmail.account.helper;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;

final class LoginUIHelper$7
  implements Runnable
{
  LoginUIHelper$7(QMCGIError paramQMCGIError, Context paramContext, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener, Account paramAccount) {}
  
  public void run()
  {
    int i = this.val$error.appCode;
    Object localObject = this.val$error.desp;
    if ((localObject == null) || (((String)localObject).equals(""))) {
      localObject = this.val$context.getString(2131695520);
    }
    for (;;)
    {
      if (-103 == i)
      {
        LoginUIHelper.access$200(LoginUIHelper.access$100(this.val$context, this.val$context.getString(2131695520), this.val$context.getString(2131695538), this.val$context.getString(2131696547), this.val$okListener, this.val$dismissListener), false);
        return;
      }
      if (-124 == i)
      {
        if (this.val$account != null)
        {
          localObject = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.val$context).setTitle(2131695520)).setMessage((CharSequence)localObject).addAction(2131691246, new LoginUIHelper.7.2(this))).addAction(2131695512, new LoginUIHelper.7.1(this))).create();
          ((QMUIDialog)localObject).setCanceledOnTouchOutside(false);
          ((QMUIDialog)localObject).show();
          LoginUIHelper.access$200((QMUIDialog)localObject, false);
          return;
        }
        LoginUIHelper.processCustomError(this.val$context, (String)localObject, false, this.val$okListener, this.val$dismissListener);
        return;
      }
      LoginUIHelper.processCustomError(this.val$context, (String)localObject, false, this.val$okListener, this.val$dismissListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.7
 * JD-Core Version:    0.7.0.1
 */