package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$70
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$70(QMMailCGIManager paramQMMailCGIManager, String paramString, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "getVerifyImage", paramQMNetworkResponse.toString());
    Object localObject = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (localObject != null)
    {
      paramQMNetworkResponse = ((JSONObject)localObject).getString("imgurl");
      String str = ((JSONObject)localObject).getString("mverifysession");
      localObject = ((JSONObject)localObject).getString("qm_authimgs_id");
      QMVerify localQMVerify = new QMVerify();
      localQMVerify.setImageUrl(paramQMNetworkResponse);
      localQMVerify.setVerifyCode(null);
      localQMVerify.setVerifyKey(this.val$verifyKKey);
      localQMVerify.setVerifySession(str);
      localQMVerify.setAuthImagesId((String)localObject);
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(paramQMNetworkRequest, localQMVerify);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.70
 * JD-Core Version:    0.7.0.1
 */