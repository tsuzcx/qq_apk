package com.tencent.qqmail.account;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class LoginManager$2
  implements QMCallback.ISuccessCallback
{
  LoginManager$2(LoginManager paramLoginManager, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Object localObject = JSONObject.parseObject(paramQMNetworkResponse.getResponseString());
    if (localObject != null)
    {
      paramQMNetworkRequest = ((JSONObject)localObject).getString("access_token");
      paramQMNetworkResponse = ((JSONObject)localObject).getString("refresh_token");
      String str = ((JSONObject)localObject).getString("token_type");
      int i = ((JSONObject)localObject).getInteger("expires_in").intValue();
      localObject = ((JSONObject)localObject).getString("id_token");
      QMLog.log(4, "LoginManager", "getGMailAccessToken success access_token: " + paramQMNetworkRequest + " refreshToken: " + paramQMNetworkResponse + " tokenType: " + str + " expiresIn: " + i + " idToken: " + (String)localObject);
      QMWatcherCenter.triggerGMailGetTokenSuccess(this.val$code, paramQMNetworkRequest, str, i, paramQMNetworkResponse, (String)localObject);
      return;
    }
    QMLog.log(6, "LoginManager", "getGMailAccessToken success parse response fail!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.2
 * JD-Core Version:    0.7.0.1
 */