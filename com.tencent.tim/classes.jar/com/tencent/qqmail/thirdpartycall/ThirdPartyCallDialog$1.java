package com.tencent.qqmail.thirdpartycall;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ThirdPartyCallDialog$1
  implements DialogInterface.OnDismissListener
{
  ThirdPartyCallDialog$1(ThirdPartyCallDialog paramThirdPartyCallDialog, ThirdPartyCallDialog.TPCDialogParams paramTPCDialogParams) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.val$params.mOnDismissListener.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialog.1
 * JD-Core Version:    0.7.0.1
 */