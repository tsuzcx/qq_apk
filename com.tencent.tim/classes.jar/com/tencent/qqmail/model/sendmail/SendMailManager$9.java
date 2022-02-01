package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$9
  implements Func1<Void, Observable<QMNetworkRequest>>
{
  SendMailManager$9(SendMailManager paramSendMailManager, AtomicInteger paramAtomicInteger, Account paramAccount, ComposeMailUI paramComposeMailUI, QMVerify paramQMVerify, int paramInt, SendMailManager.BinaryFilesData paramBinaryFilesData, SendMailRequest paramSendMailRequest, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate) {}
  
  public Observable<QMNetworkRequest> call(Void paramVoid)
  {
    return Observable.create(new SendMailManager.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.9
 * JD-Core Version:    0.7.0.1
 */