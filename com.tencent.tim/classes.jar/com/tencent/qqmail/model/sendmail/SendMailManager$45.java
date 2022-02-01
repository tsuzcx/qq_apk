package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.ftn.FtnManagerImpl;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import java.io.File;
import java.util.Map;
import moai.oss.KvHelper;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$45
  implements Observable.OnSubscribe<JSONObject>
{
  SendMailManager$45(SendMailManager paramSendMailManager, JSONObject paramJSONObject, QMCallback paramQMCallback, SendMailManager.BytesWrittenRecord paramBytesWrittenRecord, long paramLong, SendMailFtnCallback paramSendMailFtnCallback) {}
  
  public void call(Subscriber<? super JSONObject> paramSubscriber)
  {
    JSONObject localJSONObject = SendMailManager.access$1900(this.this$0, this.val$createFileJson);
    Object localObject;
    long l;
    if (localJSONObject.getBoolean("exist").booleanValue())
    {
      if (this.val$callback != null)
      {
        localObject = (QMFileEntity)this.val$createFileJson.getObject("fileEntity", QMFileEntity.class);
        l = ((QMFileEntity)localObject).getFile().length();
        KvHelper.sendmailByFtnSkipAttachSize(new double[] { (float)l / 1024.0F });
        this.val$bytesWrittenRecord.bytesWrittenByFilePathMap.put(((QMFileEntity)localObject).getFile().getPath(), Long.valueOf(l));
        l = this.val$bytesWrittenRecord.getBytesWritten();
        this.val$callback.handleSendData(null, l, this.val$totalBytesWrittenEstimation);
      }
      paramSubscriber.onNext(this.val$createFileJson);
      paramSubscriber.onCompleted();
      Log.d(SendMailManager.access$100(), "exit");
    }
    do
    {
      return;
      int i = localJSONObject.getInteger("nPort").intValue();
      localObject = localJSONObject.getString("sIP");
      String str1 = localJSONObject.getString("sKey");
      String str2 = this.val$createFileJson.getString("sha");
      QMFileEntity localQMFileEntity = (QMFileEntity)this.val$createFileJson.getObject("fileEntity", QMFileEntity.class);
      paramSubscriber = new SendMailManager.45.1(this, localQMFileEntity, localJSONObject, paramSubscriber);
      l = FtnManagerImpl.fileUpload((String)localObject, i, str1, str2, localQMFileEntity.getFile().getPath(), paramSubscriber);
    } while (this.val$sendMailFtnFidCallback == null);
    this.val$sendMailFtnFidCallback.onNormalAttachStratUpload(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.45
 * JD-Core Version:    0.7.0.1
 */