package com.tencent.qqmail;

import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class PushDialActivity$1
  implements QMUIDialogAction.ActionListener
{
  PushDialActivity$1(PushDialActivity paramPushDialActivity, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    try
    {
      paramQMUIDialog = new Intent("android.intent.action.VIEW", Uri.parse("qqbookdial:" + this.val$dial));
      this.this$0.startActivity(paramQMUIDialog);
      this.this$0.finish();
      return;
    }
    catch (Exception paramQMUIDialog)
    {
      for (;;)
      {
        paramQMUIDialog = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.val$dial));
        this.this$0.startActivity(paramQMUIDialog);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.PushDialActivity.1
 * JD-Core Version:    0.7.0.1
 */