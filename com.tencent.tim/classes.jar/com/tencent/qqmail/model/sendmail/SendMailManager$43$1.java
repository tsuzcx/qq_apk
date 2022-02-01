package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.io.File;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$43$1
  implements Observable.OnSubscribe<JSONObject>
{
  SendMailManager$43$1(SendMailManager.43 param43, QMNetworkResponse paramQMNetworkResponse) {}
  
  public void call(Subscriber<? super JSONObject> paramSubscriber)
  {
    JSONObject localJSONObject = (JSONObject)this.val$response.getResponseJson();
    if (localJSONObject != null)
    {
      Log.d(SendMailManager.access$100(), "checkFile:" + localJSONObject);
      localJSONObject.put("fileEntity", this.this$1.val$fileEntity);
      if (this.this$1.val$taskId != -1)
      {
        Object localObject = SendMailManager.access$1900(this.this$1.this$0, localJSONObject);
        String str = ((JSONObject)localObject).getString("url");
        localObject = ((JSONObject)localObject).getString("fileid");
        QMLog.log(4, SendMailManager.access$100(), "checkFile successs, name: " + this.this$1.val$fileEntity.getFile().getName() + ", fileid: " + (String)localObject);
        SendMailManager.access$1200(this.this$1.this$0).insertTaskAttach(this.this$1.val$taskId, this.this$1.val$fileEntity.getFile().getPath(), str, (String)localObject);
      }
      paramSubscriber.onNext(localJSONObject);
      paramSubscriber.onCompleted();
      return;
    }
    QMLog.log(6, SendMailManager.access$100(), "checkFile Error: json is null");
    paramSubscriber.onError(new QMNetworkError(3, -10000, QMApplicationContext.sharedInstance().getString(2131719541)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.43.1
 * JD-Core Version:    0.7.0.1
 */