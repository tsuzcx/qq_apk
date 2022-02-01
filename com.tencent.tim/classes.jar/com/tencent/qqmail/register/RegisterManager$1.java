package com.tencent.qqmail.register;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import moai.core.watcher.Watchers;

final class RegisterManager$1
  implements QMCallback.ISuccessCallback
{
  RegisterManager$1(String paramString1, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      QMLog.log(4, "RegisterManager", "registerByCGI onSuccess : " + paramQMNetworkResponse.getResponseString() + " end");
      paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkRequest == null) {
        break label174;
      }
      if (!paramQMNetworkRequest.containsKey("errcode")) {
        break label132;
      }
      paramQMNetworkRequest = (String)paramQMNetworkRequest.get("errcode");
      if (!paramQMNetworkRequest.equals("0")) {
        break label109;
      }
      ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onSuccess(this.val$phone, this.val$uin);
    }
    label109:
    while (!paramQMNetworkRequest.containsKey("app_code"))
    {
      return;
      ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onError(this.val$phone, this.val$uin, paramQMNetworkRequest);
      return;
    }
    label132:
    paramQMNetworkRequest = (String)paramQMNetworkRequest.get("app_code");
    ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onError(this.val$phone, this.val$uin, paramQMNetworkRequest);
    return;
    label174:
    ((RegisterWatcher)Watchers.of(RegisterWatcher.class)).onError(this.val$phone, this.val$uin, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.RegisterManager.1
 * JD-Core Version:    0.7.0.1
 */