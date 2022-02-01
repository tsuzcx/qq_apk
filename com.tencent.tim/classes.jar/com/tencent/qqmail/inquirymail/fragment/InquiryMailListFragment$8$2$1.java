package com.tencent.qqmail.inquirymail.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.inquirymail.InquiryMailManager;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class InquiryMailListFragment$8$2$1
  implements DialogInterface.OnDismissListener
{
  InquiryMailListFragment$8$2$1(InquiryMailListFragment.8.2 param2, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.this$2.this$1.this$0.isAttachedToActivity()) {
      QMLog.log(5, "InquiryMailListFragment", "setOnSheetItemClickListener fragment not attach.");
    }
    do
    {
      return;
      if (this.val$tag.equals(this.this$2.this$1.this$0.getString(2131695021)))
      {
        DataCollector.logEvent("Event_Received_Mail_Fetch");
        InquiryMailListFragment.access$1300(this.this$2.this$1.this$0, 2131695023);
        InquiryMailManager.sharedInstance().retrieveMail(InquiryMailListFragment.access$000(this.this$2.this$1.this$0), this.this$2.val$inquiryMail);
        return;
      }
      if (this.val$tag.equals(this.this$2.this$1.this$0.getString(2131694978)))
      {
        DataCollector.logEvent("Event_Received_Mail_Whitelist");
        InquiryMailListFragment.access$1300(this.this$2.this$1.this$0, 2131694980);
        InquiryMailManager.sharedInstance().addWhiteList(InquiryMailListFragment.access$000(this.this$2.this$1.this$0), this.this$2.val$inquiryMail.getSenderAddress());
        return;
      }
      if (this.val$tag.equals(this.this$2.this$1.this$0.getString(2131695017)))
      {
        DataCollector.logEvent("Event_Received_Mail_Blacklist");
        InquiryMailListFragment.access$1300(this.this$2.this$1.this$0, 2131695019);
        InquiryMailManager.sharedInstance().removeBlackList(InquiryMailListFragment.access$000(this.this$2.this$1.this$0), this.this$2.val$inquiryMail.getSenderAddress());
        return;
      }
    } while (!this.val$tag.equals(this.this$2.this$1.this$0.getString(2131694996)));
    DataCollector.logEvent("Event_Received_Mail_Readmail");
    int i = this.this$2.val$inquiryMail.getAccountId();
    paramDialogInterface = this.this$2.val$inquiryMail.getMailId();
    String str1 = this.this$2.val$inquiryMail.getSubject();
    String str2 = this.this$2.val$inquiryMail.getSenderName();
    String str3 = this.this$2.val$inquiryMail.getSenderAddress();
    long l = Mail.generateId(i, paramDialogInterface);
    paramDialogInterface = new ReadMailFragment(i, QMFolder.generateId(i, String.valueOf(this.this$2.val$inquiryMail.getFolderId()), false), l, paramDialogInterface, str1, str2, str3, false, false, false, true);
    this.this$2.this$1.this$0.startFragment(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.8.2.1
 * JD-Core Version:    0.7.0.1
 */