package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.content.Intent;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SdcardFileExplorer$11$1
  implements QMUIDialogAction.ActionListener
{
  SdcardFileExplorer$11$1(SdcardFileExplorer.11 param11, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Intent localIntent = this.this$1.this$0.getIntent();
    localIntent.putExtra("savePath", this.val$savePath);
    this.this$1.this$0.setResult(0, localIntent);
    paramQMUIDialog.dismiss();
    this.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.11.1
 * JD-Core Version:    0.7.0.1
 */