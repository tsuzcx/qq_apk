package com.tencent.qqmail.thirdpartycall;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmail.utilities.common.CommUtils.Callback;

final class ThirdPartyCallDialogHelpler$10
  implements DialogInterface.OnCancelListener
{
  ThirdPartyCallDialogHelpler$10(CommUtils.Callback paramCallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    this.val$secondCallback.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.10
 * JD-Core Version:    0.7.0.1
 */