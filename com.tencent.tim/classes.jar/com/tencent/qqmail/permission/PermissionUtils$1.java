package com.tencent.qqmail.permission;

import android.app.Activity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

final class PermissionUtils$1
  implements QMUIDialogAction.ActionListener
{
  PermissionUtils$1(Activity paramActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.eventPermissionGoToSetting(new double[0]);
    PermissionUtils.launchAppDetailPageForResult(this.val$activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.PermissionUtils.1
 * JD-Core Version:    0.7.0.1
 */