package com.tencent.qqmail.thirdpartycall;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.common.CommUtils.Callback;

final class ThirdPartyCallDialogHelpler$13
  implements QMUIDialogAction.ActionListener
{
  ThirdPartyCallDialogHelpler$13(CommUtils.Callback paramCallback) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$thirdCallback != null) {
      this.val$thirdCallback.call();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.13
 * JD-Core Version:    0.7.0.1
 */