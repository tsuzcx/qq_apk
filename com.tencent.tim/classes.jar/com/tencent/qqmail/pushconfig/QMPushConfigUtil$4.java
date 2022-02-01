package com.tencent.qqmail.pushconfig;

import android.content.Intent;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.ArrayList;

final class QMPushConfigUtil$4
  implements QMUIDialogAction.ActionListener
{
  QMPushConfigUtil$4(ArrayList paramArrayList) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Intent localIntent = LaunchWebPush.createPushSchemaIntent(((QMPushConfigItem)this.val$items.get(0)).getAction());
    paramQMUIDialog.dismiss();
    QMApplicationContext.sharedInstance().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigUtil.4
 * JD-Core Version:    0.7.0.1
 */