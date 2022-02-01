package com.tencent.qqmail.register;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import moai.core.watcher.Watchers;

final class RegisterManager$2
  implements QMCallback.IErrorCallback
{
  RegisterManager$2(String paramString1, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      QMLog.log(6, "RegisterManager", "registerByCGI onError : " + paramQMNetworkResponse.getResponseString() + " end");
      paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkRequest == null) {
        break label170;
      }
      if (!paramQMNetworkRequest.containsKey("errcode")) {
        break label128;
      }
      paramQMNetworkRequest = (String)paramQMNetworkRequest.get("errcode");
      QMLog.log(6, "RegisterManager", "registerByCGI error errCode:" + paramQMNetworkRequest);
      ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onError(this.val$phone, this.val$uin, paramQMNetworkRequest);
    }
    label128:
    while (!paramQMNetworkRequest.containsKey("app_code")) {
      return;
    }
    paramQMNetworkRequest = (String)paramQMNetworkRequest.get("app_code");
    ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onError(this.val$phone, this.val$uin, paramQMNetworkRequest);
    return;
    label170:
    ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onError(this.val$phone, this.val$uin, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.RegisterManager.2
 * JD-Core Version:    0.7.0.1
 */