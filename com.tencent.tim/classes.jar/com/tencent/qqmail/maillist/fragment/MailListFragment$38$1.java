package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.thread.Threads;

class MailListFragment$38$1
  implements QMUIDialogAction.ActionListener
{
  MailListFragment$38$1(MailListFragment.38 param38) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (MailListFragment.access$200(this.this$1.this$0).canLoadMore()) {}
    long[] arrayOfLong;
    for (paramInt = MailListFragment.access$100(this.this$1.this$0).getCount() - 1;; paramInt = MailListFragment.access$100(this.this$1.this$0).getCount())
    {
      arrayOfLong = new long[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfLong[i] = MailListFragment.access$200(this.this$1.this$0).getItemId(i);
        i += 1;
      }
    }
    Threads.runInBackground(new MailListFragment.38.1.1(this, arrayOfLong));
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.38.1
 * JD-Core Version:    0.7.0.1
 */