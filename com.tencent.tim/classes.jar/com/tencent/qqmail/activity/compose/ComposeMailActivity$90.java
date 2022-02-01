package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ComposeMailActivity$90
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$90(ComposeMailActivity paramComposeMailActivity, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    ComposeMailActivity.access$1700(this.this$0).setDefaultSelect(this.val$addr.split("@")[0] + "@qq.com");
    ComposeMailActivity.access$1800(this.this$0, ComposeMailActivity.access$1700(this.this$0).getChooseAccountId(), ComposeMailActivity.access$1700(this.this$0).getChooseName());
    ComposeMailActivity.access$1900(this.this$0);
    ComposeMailActivity.access$8100(this.this$0);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.90
 * JD-Core Version:    0.7.0.1
 */