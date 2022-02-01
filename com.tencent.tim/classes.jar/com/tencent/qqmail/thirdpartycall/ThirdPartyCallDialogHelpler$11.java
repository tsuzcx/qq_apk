package com.tencent.qqmail.thirdpartycall;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.common.CommUtils.Callback;

final class ThirdPartyCallDialogHelpler$11
  implements QMUIDialogAction.ActionListener
{
  ThirdPartyCallDialogHelpler$11(CommUtils.Callback paramCallback) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$secondCallback != null) {
      this.val$secondCallback.call();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.11
 * JD-Core Version:    0.7.0.1
 */