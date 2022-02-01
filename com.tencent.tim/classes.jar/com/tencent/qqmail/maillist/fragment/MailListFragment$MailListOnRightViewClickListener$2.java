package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class MailListFragment$MailListOnRightViewClickListener$2
  implements QMUIDialogAction.ActionListener
{
  MailListFragment$MailListOnRightViewClickListener$2(MailListFragment.MailListOnRightViewClickListener paramMailListOnRightViewClickListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (MailListFragment.access$000(this.this$1.this$0) != null) {
      MailListFragment.access$000(this.this$1.this$0).foldItemView(null);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.MailListOnRightViewClickListener.2
 * JD-Core Version:    0.7.0.1
 */