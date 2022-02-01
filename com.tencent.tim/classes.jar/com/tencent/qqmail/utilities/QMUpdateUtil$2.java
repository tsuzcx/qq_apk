package com.tencent.qqmail.utilities;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMUpdateUtil$2
  implements QMUIDialogAction.ActionListener
{
  QMUpdateUtil$2(QMUpdateUtil paramQMUpdateUtil, int paramInt, Context paramContext, String paramString1, String paramString2) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (QMUpdateUtil.access$300(this.this$0, this.val$forceType))
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setFlags(67108864);
      localIntent.addCategory("android.intent.category.HOME");
      localIntent.setFlags(268435456);
      this.val$context.startActivity(localIntent);
    }
    QMUpdateUtil.isTipsShowing = false;
    paramQMUIDialog.dismiss();
    QMLog.log(4, QMUpdateUtil.access$000(), "new url:" + this.val$updateUrl + ", new version:" + this.val$version);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUpdateUtil.2
 * JD-Core Version:    0.7.0.1
 */