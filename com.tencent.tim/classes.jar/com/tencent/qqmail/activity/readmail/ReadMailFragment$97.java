package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.thread.Threads;

class ReadMailFragment$97
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$97(ReadMailFragment paramReadMailFragment, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Threads.runInBackground(new ReadMailFragment.97.1(this));
    paramQMUIDialog.dismiss();
    ReadMailFragment.access$9700(this.this$0, this.this$0.getString(2131721112));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.97
 * JD-Core Version:    0.7.0.1
 */