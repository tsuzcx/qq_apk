package com.tencent.qqmail.schema;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class SchemaUtil$1$1$1$1
  implements QMUIDialogAction.ActionListener
{
  SchemaUtil$1$1$1$1(SchemaUtil.1.1.1 param1, Activity paramActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "SchemaUtil", "click to upgrade");
    paramQMUIDialog.dismiss();
    if (IntentUtil.intentToPriorityMarket(this.val$activity, QMApplicationContext.sharedInstance().getPackageName(), true)) {
      QMPushConfigUtil.sendDownloadUpgrade();
    }
    do
    {
      return;
      paramQMUIDialog = QMPushConfigUtil.getNewVersionUrl();
    } while (StringExtention.isNullOrEmpty(paramQMUIDialog));
    QMAttachUtils.goToDownload(this.val$activity, paramQMUIDialog, 1, "", null);
    Toast.makeText(this.val$activity, 2131719974, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaUtil.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */