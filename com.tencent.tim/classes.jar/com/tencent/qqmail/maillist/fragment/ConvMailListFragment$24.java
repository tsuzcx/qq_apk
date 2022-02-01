package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ConvMailListFragment$24
  implements QMUIDialogAction.ActionListener
{
  ConvMailListFragment$24(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    int i = ConvMailListFragment.access$200(this.this$0).getCount();
    long[] arrayOfLong = new long[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfLong[paramInt] = ConvMailListFragment.access$500(this.this$0).getItemId(paramInt);
      paramInt += 1;
    }
    ConvMailListFragment.access$3100(this.this$0).unreadMail(arrayOfLong, false, false);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.24
 * JD-Core Version:    0.7.0.1
 */