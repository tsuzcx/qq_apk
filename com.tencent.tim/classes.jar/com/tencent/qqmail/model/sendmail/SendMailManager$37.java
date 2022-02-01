package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$37
  implements Func1<QMFileEntity, Observable<JSONObject>>
{
  SendMailManager$37(SendMailManager paramSendMailManager, int paramInt) {}
  
  public Observable<JSONObject> call(QMFileEntity paramQMFileEntity)
  {
    return SendMailManager.access$1800(this.this$0, paramQMFileEntity, this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.37
 * JD-Core Version:    0.7.0.1
 */