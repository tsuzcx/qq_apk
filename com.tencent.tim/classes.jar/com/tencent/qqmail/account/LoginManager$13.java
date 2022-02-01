package com.tencent.qqmail.account;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.util.Date;

class LoginManager$13
  implements QMCallback.ISuccessCallback
{
  LoginManager$13(LoginManager paramLoginManager, QQMailAccount paramQQMailAccount, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, String paramString5) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    long l1 = new Date().getTime() / 1000L;
    try
    {
      long l2 = ((JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString())).getLongValue("utctime");
      l1 = l2;
    }
    catch (Exception paramQMNetworkRequest)
    {
      for (;;)
      {
        QMLog.log(6, "LoginManager", "get svr utc err:" + paramQMNetworkRequest.toString());
      }
    }
    SharedPreferenceUtil.setLoginSvrUTC(l1);
    QMLog.log(4, "LoginManager", "syncLoginSvrUTC ok:" + l1);
    this.val$account.login(this.val$currentLoginId, this.val$userName, this.val$a2, this.val$password, this.val$uin, this.val$isBizMail, this.val$isBindPhone, this.val$phonenum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.13
 * JD-Core Version:    0.7.0.1
 */