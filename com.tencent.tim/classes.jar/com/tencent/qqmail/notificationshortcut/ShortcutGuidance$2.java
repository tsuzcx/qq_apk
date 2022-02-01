package com.tencent.qqmail.notificationshortcut;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

final class ShortcutGuidance$2
  implements QMUIDialogAction.ActionListener
{
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.notificationPanelPopGuideCancel(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.ShortcutGuidance.2
 * JD-Core Version:    0.7.0.1
 */