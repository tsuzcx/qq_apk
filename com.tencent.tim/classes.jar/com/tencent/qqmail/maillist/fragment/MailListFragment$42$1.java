package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class MailListFragment$42$1
  implements QMUIDialogAction.ActionListener
{
  MailListFragment$42$1(MailListFragment.42 param42) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (MailListFragment.access$000(this.this$1.this$0) != null) {
      MailListFragment.access$000(this.this$1.this$0).foldItemView(null);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.42.1
 * JD-Core Version:    0.7.0.1
 */