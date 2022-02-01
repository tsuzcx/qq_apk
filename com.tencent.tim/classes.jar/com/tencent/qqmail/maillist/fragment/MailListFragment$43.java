package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class MailListFragment$43
  implements QMUIDialogAction.ActionListener
{
  MailListFragment$43(MailListFragment paramMailListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$0.markAllMailRead();
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.43
 * JD-Core Version:    0.7.0.1
 */