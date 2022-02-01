package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.atomic.AtomicInteger;
import rx.functions.Action1;

class SendMailManager$4
  implements Action1<Void>
{
  SendMailManager$4(SendMailManager paramSendMailManager, AtomicInteger paramAtomicInteger, MailManagerDelegate paramMailManagerDelegate, SendMailManager.BinaryFilesData paramBinaryFilesData, Account paramAccount, ComposeMailUI paramComposeMailUI, SendMailRequest paramSendMailRequest) {}
  
  public void call(Void paramVoid)
  {
    this.val$step.set(3);
    QMLog.log(4, SendMailManager.access$100(), "sendMailByPotocol startSendMail");
    paramVoid = new MailManagerDelegate(this.val$newCallback);
    paramVoid.setOnBeforeSend(null);
    paramVoid.setOnSendData(new SendMailManager.4.1(this));
    paramVoid.setOnComplete(new SendMailManager.4.2(this));
    paramVoid = SendMailManager.access$300(this.this$0).sendMail(this.val$account, this.val$mail, paramVoid);
    this.val$sendMailRequest.setProtocolRequest(paramVoid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.4
 * JD-Core Version:    0.7.0.1
 */