package com.tencent.qqmail.model.readmail;

import android.app.Activity;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class ForwardMailHelper$3
  implements QMUIDialogAction.ActionListener
{
  ForwardMailHelper$3(MailUI paramMailUI, Activity paramActivity, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if ((BigAttachHelper.isTencentAccount(this.val$mailData)) && (BigAttachHelper.attachSizeExcceedTen(this.val$mailData))) {
      ForwardMailHelper.access$100(this.val$activity, this.val$accountId, this.val$mailData);
    }
    for (;;)
    {
      paramQMUIDialog.dismiss();
      return;
      ForwardMailHelper.access$000(this.val$activity, 4, this.val$accountId, this.val$mailData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.ForwardMailHelper.3
 * JD-Core Version:    0.7.0.1
 */