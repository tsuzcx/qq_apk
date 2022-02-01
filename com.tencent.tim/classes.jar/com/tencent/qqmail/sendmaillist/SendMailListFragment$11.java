package com.tencent.qqmail.sendmaillist;

import android.view.View;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.onBottomDialogDismissListener;

class SendMailListFragment$11
  implements QMBottomDialog.onBottomDialogDismissListener
{
  SendMailListFragment$11(SendMailListFragment paramSendMailListFragment, View paramView) {}
  
  public void onDismiss()
  {
    if (this.val$sendMailListView != null) {
      ((MailListItemView)((HorizontalScrollItemView)this.val$sendMailListView).getContentView()).setPressedCustom(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.11
 * JD-Core Version:    0.7.0.1
 */