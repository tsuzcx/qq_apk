package com.tencent.qqmail.namelist;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class NameListUIHelper$1
  implements QMUIDialogAction.ActionListener
{
  NameListUIHelper$1(int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    NameListManager.sharedInstance().deleteNameList(this.val$accountId, this.val$type, this.val$emails);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListUIHelper.1
 * JD-Core Version:    0.7.0.1
 */