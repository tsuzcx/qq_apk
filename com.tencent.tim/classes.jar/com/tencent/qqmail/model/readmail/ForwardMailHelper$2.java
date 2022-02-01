package com.tencent.qqmail.model.readmail;

import android.app.Activity;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class ForwardMailHelper$2
  implements QMUIDialogAction.ActionListener
{
  ForwardMailHelper$2(Activity paramActivity, int paramInt, MailUI paramMailUI) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    ForwardMailHelper.access$000(this.val$activity, 3, this.val$accountId, this.val$mailData);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.ForwardMailHelper.2
 * JD-Core Version:    0.7.0.1
 */