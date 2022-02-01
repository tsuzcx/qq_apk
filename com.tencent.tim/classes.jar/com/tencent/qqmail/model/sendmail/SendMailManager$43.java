package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$43
  implements Func1<QMNetworkResponse, Observable<JSONObject>>
{
  SendMailManager$43(SendMailManager paramSendMailManager, QMFileEntity paramQMFileEntity, int paramInt) {}
  
  public Observable<JSONObject> call(QMNetworkResponse paramQMNetworkResponse)
  {
    return Observable.create(new SendMailManager.43.1(this, paramQMNetworkResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.43
 * JD-Core Version:    0.7.0.1
 */