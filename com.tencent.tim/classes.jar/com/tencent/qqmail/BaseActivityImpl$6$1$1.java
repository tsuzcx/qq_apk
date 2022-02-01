package com.tencent.qqmail;

import android.content.Intent;
import com.tencent.qqmail.activity.setting.SecurityAppTipsActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;

class BaseActivityImpl$6$1$1
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$6$1$1(BaseActivityImpl.6.1 param1) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "BaseActivityImpl", "secapp. click howto");
    DataCollector.logEvent("Event_SecApp_Alert_Howto");
    QMLogStream.logWithoutUmaNow(-40036, this.this$2.val$url, "Event_Error");
    Intent localIntent = SecurityAppTipsActivity.createIntent(this.this$2.val$url);
    this.this$2.this$1.this$0.startActivity(localIntent);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.6.1.1
 * JD-Core Version:    0.7.0.1
 */