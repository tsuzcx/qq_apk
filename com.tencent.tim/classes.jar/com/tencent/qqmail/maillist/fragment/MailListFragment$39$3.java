package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class MailListFragment$39$3
  implements QMUIDialogAction.ActionListener
{
  MailListFragment$39$3(MailListFragment.39 param39, boolean paramBoolean) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (this.val$isClockSendMail) {
      if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance())) {
        MailListFragment.access$3100(this.this$1.this$0);
      }
    }
    for (;;)
    {
      paramQMUIDialog.dismiss();
      return;
      MailListFragment.access$2900(this.this$1.this$0).deleteWithClockSendMail(MailListFragment.access$2200(this.this$1.this$0), MailListFragment.access$9100(this.this$1.this$0), true);
      continue;
      MailListFragment.access$9300(this.this$1.this$0, MailListFragment.access$2200(this.this$1.this$0), MailListFragment.access$9100(this.this$1.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.39.3
 * JD-Core Version:    0.7.0.1
 */