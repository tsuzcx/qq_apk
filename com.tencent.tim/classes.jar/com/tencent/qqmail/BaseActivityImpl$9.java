package com.tencent.qqmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;

class BaseActivityImpl$9
  implements DialogInterface.OnDismissListener
{
  BaseActivityImpl$9(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!PasswordErrHandling.isUserClickHandle()) {
      PasswordErrHandling.setHandling(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.9
 * JD-Core Version:    0.7.0.1
 */