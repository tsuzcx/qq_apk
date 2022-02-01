package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.RspBase;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.IOException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMUmaManager$57
  implements Observable.OnSubscribe<byte[]>
{
  QMUmaManager$57(QMUmaManager paramQMUmaManager, QMNetworkResponse paramQMNetworkResponse, byte[] paramArrayOfByte) {}
  
  public void call(Subscriber<? super byte[]> paramSubscriber)
  {
    QMUmaManager.QMPUmaException localQMPUmaException2 = null;
    byte[] arrayOfByte2 = this.val$response.getResponseData();
    Object localObject;
    if (arrayOfByte2 == null)
    {
      QMLog.log(6, "QMUmaManager", "decrypt rspbase parse fail: [null]");
      localObject = null;
    }
    byte[] arrayOfByte1;
    while (localObject == null)
    {
      localObject = new QMUmaManager.QMPUmaException(this.this$0);
      ((QMUmaManager.QMPUmaException)localObject).retCode = -1;
      paramSubscriber.onError((Throwable)localObject);
      return;
      try
      {
        localObject = new RspBase().parseFrom(arrayOfByte2);
      }
      catch (IOException localIOException)
      {
        QMLog.log(6, "QMUmaManager", "decrypt rspbase parse fail: " + StringExtention.base64Encode(arrayOfByte2, arrayOfByte2.length));
        arrayOfByte1 = null;
      }
    }
    int i = arrayOfByte1.cmd;
    QMUmaManager.QMPUmaException localQMPUmaException1;
    if (arrayOfByte1.ret == 0)
    {
      Log.d("terrytan", QMUmaManager.access$200(this.this$0) + "uma suc:" + arrayOfByte1.cmd);
      if (arrayOfByte1 == null)
      {
        paramSubscriber.onNext(null);
        paramSubscriber.onCompleted();
        return;
      }
      try
      {
        arrayOfByte1 = QMUmaManager.access$1400(this.this$0, this.val$key, arrayOfByte1.pkg.toByteArray());
        if (arrayOfByte1 != null)
        {
          paramSubscriber.onNext(arrayOfByte1);
          paramSubscriber.onCompleted();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(6, "QMUmaManager", "decrypt rspbase decrpyt fail");
          localQMPUmaException1 = localQMPUmaException2;
        }
        localQMPUmaException1 = new QMUmaManager.QMPUmaException(this.this$0);
        localQMPUmaException1.retCode = -1;
        paramSubscriber.onError(localQMPUmaException1);
        return;
      }
    }
    switch (localQMPUmaException1.ret)
    {
    default: 
      localQMPUmaException2 = new QMUmaManager.QMPUmaException(this.this$0);
      localQMPUmaException2.retCode = localQMPUmaException1.ret;
      paramSubscriber.onError(localQMPUmaException2);
    }
    for (;;)
    {
      Log.e("terrytan", QMUmaManager.access$200(this.this$0) + "uma " + localQMPUmaException1.cmd + " err:" + localQMPUmaException1.ret);
      return;
      paramSubscriber.onError(new QMUmaManager.QMUmaSessionTimeoutException(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.57
 * JD-Core Version:    0.7.0.1
 */