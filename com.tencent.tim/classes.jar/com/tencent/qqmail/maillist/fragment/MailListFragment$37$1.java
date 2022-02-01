package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class MailListFragment$37$1
  implements QMUIDialogAction.ActionListener
{
  MailListFragment$37$1(MailListFragment.37 param37) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    MailListFragment.access$2900(this.this$1.this$0).rejectMail(MailListFragment.access$2200(this.this$1.this$0), MailListFragment.access$2400(this.this$1.this$0), MailListFragment.access$9100(this.this$1.this$0), true, false);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.37.1
 * JD-Core Version:    0.7.0.1
 */