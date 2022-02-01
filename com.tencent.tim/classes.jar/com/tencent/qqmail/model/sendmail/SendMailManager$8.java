package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$8
  implements Func1<Throwable, Observable<? extends QMNetworkRequest>>
{
  SendMailManager$8(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2, StringBuilder paramStringBuilder, MailManagerDelegate paramMailManagerDelegate) {}
  
  public Observable<? extends QMNetworkRequest> call(Throwable paramThrowable)
  {
    KvHelper.eventCgiComposeFail(new double[0]);
    if (QMABTestManager.isSendMailByFtn())
    {
      OssHelper.realTimeReport(new Object[] { Long.valueOf(41639L), "", Integer.valueOf(1) });
      SendMailManager.access$200(this.this$0, paramThrowable);
      this.val$isSendMailSuccess.set(false);
      if (!this.val$isAbort.get())
      {
        if (!(paramThrowable instanceof QMNetworkError)) {
          break label150;
        }
        paramThrowable = (QMNetworkError)paramThrowable;
        QMLog.log(4, SendMailManager.access$100(), "sendMailError", paramThrowable);
        SendMailManager.access$600(this.this$0, paramThrowable, this.val$networkErrorMsg);
      }
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.handleError(paramThrowable);
      }
      return Observable.empty();
      OssHelper.realTimeReport(new Object[] { Long.valueOf(41640L), "", Integer.valueOf(1) });
      break;
      label150:
      paramThrowable = new QMNetworkError(3, -10000, QMApplicationContext.sharedInstance().getString(2131719526));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.8
 * JD-Core Version:    0.7.0.1
 */