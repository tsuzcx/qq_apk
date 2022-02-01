package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$34
  implements Func1<JSONObject, Observable<JSONObject>>
{
  SendMailManager$34(SendMailManager paramSendMailManager, long paramLong, SendMailManager.BytesWrittenRecord paramBytesWrittenRecord, SendMailFtnCallback paramSendMailFtnCallback, QMCallback paramQMCallback) {}
  
  public Observable<JSONObject> call(JSONObject paramJSONObject)
  {
    return SendMailManager.access$1700(this.this$0, paramJSONObject, this.val$totalBytesWrittenEstimation, this.val$bytesWrittenRecord, this.val$sendMailFtnCallback, this.val$qmcallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.34
 * JD-Core Version:    0.7.0.1
 */