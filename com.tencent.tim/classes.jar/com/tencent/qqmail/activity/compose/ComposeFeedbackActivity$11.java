package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ComposeFeedbackActivity$11
  implements QMUIDialogAction.ActionListener
{
  ComposeFeedbackActivity$11(ComposeFeedbackActivity paramComposeFeedbackActivity, QMComposeAttachItem paramQMComposeAttachItem) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    this.this$0.removeAttach(this.val$item);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.11
 * JD-Core Version:    0.7.0.1
 */