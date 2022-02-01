package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$40
  implements Func1<QMNetworkResponse, Observable<JSONObject>>
{
  SendMailManager$40(SendMailManager paramSendMailManager, QMFileEntity paramQMFileEntity, String paramString1, String paramString2) {}
  
  public Observable<JSONObject> call(QMNetworkResponse paramQMNetworkResponse)
  {
    return Observable.create(new SendMailManager.40.1(this, paramQMNetworkResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.40
 * JD-Core Version:    0.7.0.1
 */