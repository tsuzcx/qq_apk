package com.tencent.qqmail.account.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class LoginUIHelper$5
  implements DialogInterface.OnDismissListener
{
  LoginUIHelper$5(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    
    if (this.val$dismissListener != null) {
      this.val$dismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.5
 * JD-Core Version:    0.7.0.1
 */