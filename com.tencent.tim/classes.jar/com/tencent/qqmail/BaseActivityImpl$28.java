package com.tencent.qqmail;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BaseActivityImpl$28
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$28(BaseActivityImpl paramBaseActivityImpl, ComposeMailUI paramComposeMailUI) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = this.val$mail.getInformation();
    paramQMUIDialog.setFrom(paramQMUIDialog.getSendContact());
    paramQMUIDialog.setFolderId(QMFolderManager.sharedInstance().getSentFolderId(paramQMUIDialog.getAccountId()));
    BaseActivityImpl.access$1600(this.this$0, this.val$mail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.28
 * JD-Core Version:    0.7.0.1
 */