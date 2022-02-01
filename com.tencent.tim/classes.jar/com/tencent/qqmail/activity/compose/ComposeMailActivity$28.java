package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ComposeMailActivity$28
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$28(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (ComposeMailActivity.access$3200(this.this$0) != null) {
      ComposeMailActivity.access$3200(this.this$0).findViewById(2131380046).setSelected(false);
    }
    paramQMUIDialog.dismiss();
    this.this$0.composeView.focusAtEditor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.28
 * JD-Core Version:    0.7.0.1
 */