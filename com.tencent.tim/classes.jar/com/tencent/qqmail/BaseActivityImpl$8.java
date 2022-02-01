package com.tencent.qqmail;

import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$8
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$8(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    PasswordErrHandling.setUserClickHandle(true);
    paramQMUIDialog.dismiss();
    QMLog.log(4, "BaseActivityImpl", "set handling false 1");
    PasswordErrHandling.setHandling(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.8
 * JD-Core Version:    0.7.0.1
 */