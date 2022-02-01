package com.tencent.qqmail.register;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import moai.core.watcher.Watchers;

final class RegisterManager$3
  implements QMCallback.ISuccessCallback
{
  RegisterManager$3(String paramString1, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      QMLog.log(4, "RegisterManager", "checkPhoneAndUinRelationship onSuccess : " + paramQMNetworkResponse.getResponseString() + " end");
      paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.containsKey("match")))
      {
        paramQMNetworkRequest = (String)paramQMNetworkRequest.get("match");
        ((CheckPhoneWatcher)Watchers.of(CheckPhoneWatcher.class)).onSuccess(this.val$phone, this.val$uin, paramQMNetworkRequest);
        return;
      }
    }
    QMLog.log(4, "RegisterManager", "checkPhoneAndUinRelationship onSuccess error:" + paramQMNetworkResponse);
    ((CheckPhoneWatcher)Watchers.of(CheckPhoneWatcher.class)).onError(this.val$phone, this.val$uin, new QMNetworkError(3, -10000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.RegisterManager.3
 * JD-Core Version:    0.7.0.1
 */