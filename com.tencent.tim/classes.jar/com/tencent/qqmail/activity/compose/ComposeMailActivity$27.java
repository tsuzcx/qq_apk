package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ComposeMailActivity$27
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$27(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (ComposeMailActivity.access$3200(this.this$0) != null) {
      ComposeMailActivity.access$3200(this.this$0).findViewById(2131380046).setSelected(false);
    }
    paramQMUIDialog.dismiss();
    ComposeMailActivity.access$3300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.27
 * JD-Core Version:    0.7.0.1
 */