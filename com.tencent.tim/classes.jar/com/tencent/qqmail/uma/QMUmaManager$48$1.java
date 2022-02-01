package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.oss.KvHelper;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$48$1
  implements Func1<Throwable, Observable<?>>
{
  QMUmaManager$48$1(QMUmaManager.48 param48) {}
  
  public Observable<?> call(Throwable paramThrowable)
  {
    QMUmaManager.QMPUmaException localQMPUmaException = null;
    if ((paramThrowable instanceof QMUmaManager.QMUmaSessionTimeoutException)) {
      return QMUmaManager.access$400(this.this$1.this$0, CloudProtocolHelper.getCommonInfo(), new QMUmaManager.48.1.1(this));
    }
    if ((paramThrowable instanceof QMUmaManager.QMPUmaException)) {
      localQMPUmaException = (QMUmaManager.QMPUmaException)paramThrowable;
    }
    for (;;)
    {
      Object localObject;
      if (localQMPUmaException != null)
      {
        localObject = new CloudProtocolResult();
        ((CloudProtocolResult)localObject).error_code_ = localQMPUmaException.retCode;
        this.this$1.val$session.callback.onCloudResult((CloudProtocolResult)localObject);
      }
      QMLog.log(5, "QMUmaManager", "retryWhen : no need to retry. error: " + paramThrowable);
      return Observable.empty();
      if ((paramThrowable instanceof QMNetworkError))
      {
        localObject = (QMNetworkError)paramThrowable;
        localQMPUmaException = new QMUmaManager.QMPUmaException(this.this$1.this$0);
        localQMPUmaException.initCause(paramThrowable);
        if ((((QMNetworkError)localObject).desp != null) && (((QMNetworkError)localObject).desp.contains("gp.mail.qq.com"))) {
          KvHelper.umaViaProxy(new double[0]);
        }
        localQMPUmaException.retCode = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.48.1
 * JD-Core Version:    0.7.0.1
 */