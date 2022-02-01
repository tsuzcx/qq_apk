package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import java.util.concurrent.Callable;

class ReadMailFragment$2
  implements Callable<Boolean>
{
  ReadMailFragment$2(ReadMailFragment paramReadMailFragment, int paramInt, String paramString) {}
  
  public Boolean call()
  {
    Object localObject = QMMailManager.sharedInstance().getMailInfoByRemoteId(this.val$accountId, this.val$remoteId);
    if (localObject == null)
    {
      ReadMailFragment.access$202(this.this$0, this.val$accountId);
      ReadMailFragment.access$302(this.this$0, this.val$remoteId);
      if (AccountManager.shareInstance().getAccountList().getAccountById(ReadMailFragment.access$200(this.this$0)).isQQMail()) {
        ReadMailFragment.access$402(this.this$0, Mail.generateId(ReadMailFragment.access$200(this.this$0), ReadMailFragment.access$300(this.this$0)));
      }
      return Boolean.valueOf(false);
    }
    ReadMailFragment.access$002(this.this$0, new MailUI((Mail)localObject));
    QMMailManager.sharedInstance().fillMailExtra(ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$100(this.this$0), false);
    localObject = ReadMailFragment.access$000(this.this$0).getInformation();
    if (localObject != null)
    {
      ReadMailFragment.access$402(this.this$0, ((MailInformation)localObject).getId());
      ReadMailFragment.access$202(this.this$0, ((MailInformation)localObject).getAccountId());
      ReadMailFragment.access$502(this.this$0, ((MailInformation)localObject).getFolderId());
      ReadMailFragment.access$602(this.this$0, ((MailInformation)localObject).getSubject());
      localObject = ((MailInformation)localObject).getSendContact();
      if (localObject != null)
      {
        ReadMailFragment.access$702(this.this$0, ((MailContact)localObject).getName());
        ReadMailFragment.access$802(this.this$0, ((MailContact)localObject).getAddress());
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.2
 * JD-Core Version:    0.7.0.1
 */