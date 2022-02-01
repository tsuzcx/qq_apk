package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class AggregateMailListFragment$28
  implements QMUIDialogAction.ActionListener
{
  AggregateMailListFragment$28(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    int i = AggregateMailListFragment.access$200(this.this$0).getCount() - AggregateMailListFragment.access$200(this.this$0).getPopularizedCount();
    long[] arrayOfLong = new long[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfLong[paramInt] = AggregateMailListFragment.access$500(this.this$0).getItemId(paramInt);
      paramInt += 1;
    }
    AggregateMailListFragment.access$3200(this.this$0).unreadMail(arrayOfLong, false, false);
    AggregateMailListFragment.access$4000(this.this$0);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.28
 * JD-Core Version:    0.7.0.1
 */