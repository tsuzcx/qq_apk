package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler.NetworkListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import moai.oss.KvHelper;
import rx.functions.Action0;

class SendMailManager$7
  implements Action0
{
  SendMailManager$7(SendMailManager paramSendMailManager, SendMailRequest paramSendMailRequest, boolean paramBoolean, AtomicBoolean paramAtomicBoolean1, long paramLong, AtomicBoolean paramAtomicBoolean2, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, AtomicBoolean paramAtomicBoolean3, AtomicInteger paramAtomicInteger, MailManagerDelegate paramMailManagerDelegate, QMNetworkHandler.NetworkListener paramNetworkListener) {}
  
  public void call()
  {
    Log.d(SendMailManager.access$100(), "sendMail doOnCompleted, isAbort: " + this.val$sendMailRequest.getIsAbort());
    KvHelper.eventCgiCompose(new double[0]);
    if (this.val$isSendMailWitchAttach)
    {
      if (!QMABTestManager.isSendMailByFtn()) {
        break label159;
      }
      if (!this.val$isSendMailSuccess.get()) {
        break label150;
      }
      KvHelper.eventNewComposeSuccessWithAttach(new double[0]);
    }
    for (;;)
    {
      SendMailManager.access$500(this.this$0, this.val$start, this.val$hasChanged, this.val$networkErrorMsg, this.val$detailInfo, this.val$isSendMailSuccess, this.val$isAbort, this.val$step);
      this.val$step.set(8);
      if ((!this.val$sendMailRequest.getIsAbort().get()) && (this.val$callback != null)) {
        this.val$callback.handleComplete(null);
      }
      QMNetworkHandler.getInstance().unregisterNetworkListener(this.val$networkListener);
      return;
      label150:
      KvHelper.eventNewComposeFailedWithAttach(new double[0]);
      continue;
      label159:
      if (this.val$isSendMailSuccess.get()) {
        KvHelper.eventOldComposeSuccessWithAttach(new double[0]);
      } else {
        KvHelper.eventOldComposeFailedWithAttach(new double[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.7
 * JD-Core Version:    0.7.0.1
 */