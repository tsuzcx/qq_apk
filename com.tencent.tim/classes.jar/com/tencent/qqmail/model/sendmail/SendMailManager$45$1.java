package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.io.File;
import java.util.Map;
import rx.Subscriber;

class SendMailManager$45$1
  extends FtnDefine.FtnCallback
{
  SendMailManager$45$1(SendMailManager.45 param45, QMFileEntity paramQMFileEntity, JSONObject paramJSONObject, Subscriber paramSubscriber) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, SendMailManager.access$100(), "uploadNormalAttachByFtn:" + paramInt1 + ", description:" + paramString);
    this.val$subscriber.onError(new QMNetworkError(9, paramInt1, SendMailManager.access$1300(this.this$1.this$0, paramInt1, paramString)));
  }
  
  public void onProcessData(long paramLong1, long paramLong2)
  {
    if (this.this$1.val$callback != null)
    {
      this.this$1.val$bytesWrittenRecord.bytesWrittenByFilePathMap.put(this.val$fileEntity.getFile().getPath(), Long.valueOf(paramLong1));
      long l = this.this$1.val$bytesWrittenRecord.getBytesWritten();
      Log.d(SendMailManager.access$100(), "sendMailFtnProcess: currPos:" + paramLong1 + " totalLength:" + paramLong2 + ", bytesWritten:" + l + ", totalBytesWrittenEstimation:" + this.this$1.val$totalBytesWrittenEstimation);
      this.this$1.val$callback.handleSendData(null, l, this.this$1.val$totalBytesWrittenEstimation);
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = this.val$data.getString("sFileId");
    QMLog.log(4, SendMailManager.access$100(), "uploadNormalAttachByFtn onSuccess, filedId:" + paramArrayOfByte1);
    this.val$subscriber.onNext(this.this$1.val$createFileJson);
    this.val$subscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.45.1
 * JD-Core Version:    0.7.0.1
 */