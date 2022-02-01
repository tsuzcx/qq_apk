package com.tencent.qqmail.notificationshortcut;

import android.content.Context;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class ShortcutGuidance$3
  implements QMUIDialogAction.ActionListener
{
  ShortcutGuidance$3(Context paramContext) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    ShortcutGuidance.access$000(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.ShortcutGuidance.3
 * JD-Core Version:    0.7.0.1
 */