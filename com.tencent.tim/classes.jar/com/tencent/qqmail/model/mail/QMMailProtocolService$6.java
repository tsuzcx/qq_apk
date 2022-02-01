package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolService$6
  implements MailManagerDelegate.MailErrorCallback
{
  QMMailProtocolService$6(QMMailProtocolService paramQMMailProtocolService, Profile paramProfile, Account paramAccount, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    if ((paramObject instanceof QMProtocolError))
    {
      int i = ((QMProtocolError)paramObject).code;
      if (!QMMailProtocolService.access$000(this.this$0, this.val$profile, i)) {
        break label51;
      }
      this.this$0.sendMail(this.val$account, this.val$mailUI, this.val$callback);
    }
    label51:
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.handleError(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.6
 * JD-Core Version:    0.7.0.1
 */