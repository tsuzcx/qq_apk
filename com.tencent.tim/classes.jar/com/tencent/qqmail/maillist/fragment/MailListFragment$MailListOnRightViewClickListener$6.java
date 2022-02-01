package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class MailListFragment$MailListOnRightViewClickListener$6
  implements Runnable
{
  MailListFragment$MailListOnRightViewClickListener$6(MailListFragment.MailListOnRightViewClickListener paramMailListOnRightViewClickListener, int paramInt) {}
  
  public void run()
  {
    if (MailListFragment.access$100(this.this$1.this$0) == null) {
      QMLog.log(6, "MailListFragment", "onRightViewClick begin unread,adapter null");
    }
    Mail localMail;
    do
    {
      return;
      localMail = MailListFragment.access$100(this.this$1.this$0).getItem(this.val$position);
    } while ((localMail == null) || (localMail.getInformation() == null));
    QMLog.log(4, "MailListFragment", "onRightViewClick begi Unread, mailIds:" + localMail.getInformation().getId() + ",isUnread:" + localMail.getStatus().isUnread());
    if (!localMail.getStatus().isUnread()) {}
    for (boolean bool = true;; bool = false)
    {
      if (localMail.getStatus().isAdConv())
      {
        MailListFragment.access$3400(this.this$1.this$0);
        bool = false;
      }
      MailListFragment.access$2900(this.this$1.this$0).unreadMail(new long[] { localMail.getInformation().getId() }, bool, false);
      if (!localMail.getStatus().isUnread()) {
        break;
      }
      DataCollector.logEvent("Event_Maillist_Mark_Read");
      return;
    }
    DataCollector.logEvent("Event_Maillist_Mark_UnRead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.MailListOnRightViewClickListener.6
 * JD-Core Version:    0.7.0.1
 */