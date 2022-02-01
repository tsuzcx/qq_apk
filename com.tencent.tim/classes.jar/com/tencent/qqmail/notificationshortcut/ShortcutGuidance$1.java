package com.tencent.qqmail.notificationshortcut;

import android.content.Context;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

final class ShortcutGuidance$1
  implements QMUIDialogAction.ActionListener
{
  ShortcutGuidance$1(Context paramContext) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.notificationPanelPopGuideOk(new double[0]);
    QMSettingManager.sharedInstance().setNotificationShortCutEnable(true);
    NotificationShortCutManager.enable(this.val$context, true);
    if (!PermissionUtils.hasNotificationPostPermission())
    {
      KvHelper.notificationPanelPopGuideClickOkWithoutPermission(new double[0]);
      ShortcutGuidance.access$000(this.val$context);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.ShortcutGuidance.1
 * JD-Core Version:    0.7.0.1
 */