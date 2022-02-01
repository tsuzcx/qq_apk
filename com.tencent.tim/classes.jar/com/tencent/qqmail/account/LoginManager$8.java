package com.tencent.qqmail.account;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class LoginManager$8
  implements QMCallback.ISuccessCallback
{
  LoginManager$8(LoginManager paramLoginManager, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Object localObject = JSONObject.parseObject(paramQMNetworkResponse.getResponseString());
    if (localObject != null)
    {
      paramQMNetworkRequest = ((JSONObject)localObject).getString("id");
      paramQMNetworkResponse = ((JSONObject)localObject).getString("email");
      String str = ((JSONObject)localObject).getString("name");
      localObject = ((JSONObject)localObject).getString("picture");
      QMLog.log(4, "LoginManager", "getGMailUserInfo success access_token: " + this.val$accessToken + " id: " + paramQMNetworkRequest + " email: " + paramQMNetworkResponse + " name: " + str + " picture: " + (String)localObject);
      QMWatcherCenter.triggerGMailGetUserInfoSuccess(this.val$accessToken, paramQMNetworkRequest, paramQMNetworkResponse, str, (String)localObject);
      return;
    }
    QMLog.log(6, "LoginManager", "getGMailUserInfo success parse response fail!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.8
 * JD-Core Version:    0.7.0.1
 */