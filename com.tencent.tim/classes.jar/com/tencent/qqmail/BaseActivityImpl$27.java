package com.tencent.qqmail;

import android.content.Context;
import android.widget.Toast;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class BaseActivityImpl$27
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$27(BaseActivityImpl paramBaseActivityImpl, Context paramContext, ComposeMailUI paramComposeMailUI) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
    {
      BaseActivityImpl.access$1500(this.this$0, this.val$finalContext);
      return;
    }
    paramInt = this.val$mail.getInformation().getAccountId();
    long l = this.val$mail.getInformation().getId();
    paramQMUIDialog = this.val$mail.getInformation().getRemoteId();
    QMMailManager.sharedInstance().deleteClockSendMailByRemoteId(paramInt, new long[] { l }, new String[] { paramQMUIDialog }, true);
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131689591, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.27
 * JD-Core Version:    0.7.0.1
 */