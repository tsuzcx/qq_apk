package com.tencent.qqmail.account;

import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.Iterator;
import java.util.Set;

class LoginManager$6
  implements QMCallback.IErrorCallback
{
  LoginManager$6(LoginManager paramLoginManager, int paramInt) {}
  
  public void run(QMNetworkRequest arg1, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "LoginManager", "handleRefreshTokenExpire error, code:" + paramQMNetworkError.code + ", desp:" + paramQMNetworkError.desp + ", accountId:" + this.val$accountId);
    if ((paramQMNetworkError != null) && (paramQMNetworkError.code == 400) && (!StringExtention.isNullOrEmpty(paramQMNetworkError.desp)))
    {
      ??? = (JSONObject)JSONReader.parse(paramQMNetworkError.desp);
      if ((??? == null) || (!"invalid_grant".equals(???.getString("error")))) {
        break label324;
      }
      AccountManager.shareInstance().triggerAccountStateChange(this.val$accountId, -1, "");
      QMLog.log(6, "LoginManager", "handleRefreshTokenExpire invalid_grant");
    }
    label323:
    label324:
    for (int i = 1;; i = 0)
    {
      if (paramQMNetworkError != null) {
        DataCollector.logDetailEvent("DetailEvent_Gmail_Change_Accesstoken", this.val$accountId, paramQMNetworkError.code, paramQMNetworkError.desp);
      }
      for (;;)
      {
        synchronized (LoginManager.access$300(this.this$0))
        {
          paramQMNetworkResponse = (Set)LoginManager.access$300(this.this$0).get(this.val$accountId);
          LoginManager.access$300(this.this$0).remove(this.val$accountId);
          if ((paramQMNetworkResponse == null) || (paramQMNetworkResponse.size() <= 0)) {
            break label323;
          }
          ??? = paramQMNetworkResponse.iterator();
          if (!???.hasNext()) {
            break label323;
          }
          paramQMNetworkResponse = (RefreshTokenCallback)???.next();
          int k = this.val$accountId;
          if (i != 0)
          {
            j = 4;
            paramQMNetworkResponse.onError(k, new QMProtocolError(j, paramQMNetworkError.desp));
            continue;
            if (QMProxyUtil.isClosed()) {
              QMSharedPreferenceManager.getInstance().setGmailErrorMsgShow(true);
            }
            i = 0;
            break;
            DataCollector.logDetailEvent("DetailEvent_Gmail_Change_Accesstoken", this.val$accountId, 1L, "");
          }
        }
        int j = 3001;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.6
 * JD-Core Version:    0.7.0.1
 */