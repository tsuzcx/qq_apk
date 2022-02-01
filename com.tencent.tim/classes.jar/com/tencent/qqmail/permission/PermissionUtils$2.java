package com.tencent.qqmail.permission;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

final class PermissionUtils$2
  implements QMUIDialogAction.ActionListener
{
  PermissionUtils$2(PermissionUtils.CancelPermissionWarinCallback paramCancelPermissionWarinCallback) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.eventPermissionCancelSetting(new double[0]);
    if (this.val$cancelPermissionWarinCallback != null) {
      this.val$cancelPermissionWarinCallback.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.PermissionUtils.2
 * JD-Core Version:    0.7.0.1
 */