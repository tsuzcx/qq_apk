package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.util.HashMap;

class MailListFragment$MailListOnRightViewClickListener$3$1
  implements Runnable
{
  MailListFragment$MailListOnRightViewClickListener$3$1(MailListFragment.MailListOnRightViewClickListener.3 param3) {}
  
  public void run()
  {
    QMLog.log(4, "MailListFragment", "onRightViewClick begin Delete, mAccountId:" + MailListFragment.access$2200(this.this$2.this$1.this$0) + ", mailIds:" + this.this$2.val$mail.getInformation().getId());
    MailListFragment.access$400(this.this$2.this$1.this$0).put(Integer.valueOf(this.this$2.val$position), Long.valueOf(this.this$2.val$mail.getInformation().getId()));
    if (this.this$2.val$isClockSendMail)
    {
      if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
      {
        MailListFragment.access$3100(this.this$2.this$1.this$0);
        return;
      }
      MailListFragment.access$2900(this.this$2.this$1.this$0).deleteWithClockSendMail(MailListFragment.access$2200(this.this$2.this$1.this$0), this.this$2.val$mail.getInformation().getId(), true);
      DataCollector.logEvent("Event_Delete_Timer_Mail_Success");
      return;
    }
    MailListFragment.access$2900(this.this$2.this$1.this$0).deleteMail(MailListFragment.access$2200(this.this$2.this$1.this$0), this.this$2.val$mail.getInformation().getId(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.MailListOnRightViewClickListener.3.1
 * JD-Core Version:    0.7.0.1
 */