package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeMailActivity$31
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$31(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "ComposeMailActivity", "compose_save");
    paramQMUIDialog.dismiss();
    if ((this.this$0.composeMail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD) || (this.this$0.composeMail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CLOCKED_CARD))
    {
      if (!ComposeMailActivity.access$3500(this.this$0)) {}
      while (!ComposeMailActivity.access$3600(this.this$0)) {
        return;
      }
      ComposeMailActivity.access$3702(this.this$0, true);
      ComposeMailActivity.access$3800(this.this$0);
      return;
    }
    ComposeMailActivity.access$3900(this.this$0);
    paramQMUIDialog = new Intent();
    this.this$0.setResult(1002, paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.31
 * JD-Core Version:    0.7.0.1
 */