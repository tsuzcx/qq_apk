package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$40$1
  implements Observable.OnSubscribe<JSONObject>
{
  SendMailManager$40$1(SendMailManager.40 param40, QMNetworkResponse paramQMNetworkResponse) {}
  
  public void call(Subscriber<? super JSONObject> paramSubscriber)
  {
    JSONObject localJSONObject = (JSONObject)this.val$qmNetworkResponse.getResponseJson();
    if (localJSONObject != null)
    {
      Log.d(SendMailManager.access$100(), "createFile:" + localJSONObject);
      localJSONObject.put("fileEntity", this.this$1.val$qmFileEntity);
      localJSONObject.put("sha", this.this$1.val$sha);
      localJSONObject.put("md5", this.this$1.val$md5);
      paramSubscriber.onNext(localJSONObject);
      paramSubscriber.onCompleted();
      return;
    }
    QMLog.log(6, SendMailManager.access$100(), "createFile Error: json is null.");
    paramSubscriber.onError(new QMNetworkError(3, -10000, QMApplicationContext.sharedInstance().getString(2131719541)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.40.1
 * JD-Core Version:    0.7.0.1
 */