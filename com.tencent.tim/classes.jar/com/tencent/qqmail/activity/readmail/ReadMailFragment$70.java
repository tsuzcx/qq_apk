package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class ReadMailFragment$70
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$70(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
    {
      ReadMailFragment.access$13300(this.this$0);
      return;
    }
    ReadMailFragment.access$13400(this.this$0, true);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.70
 * JD-Core Version:    0.7.0.1
 */