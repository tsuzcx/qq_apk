package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.log.QMLog;

class NetworkManager$SessionTask$2
  implements QMCallback.IErrorCallback
{
  NetworkManager$SessionTask$2(NetworkManager.SessionTask paramSessionTask, NetworkManager paramNetworkManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      bool1 = bool2;
      if ((paramQMNetworkRequest instanceof CGIRequest))
      {
        QQMailAccount localQQMailAccount = NetworkManager.access$000(this.this$1.this$0, (CGIRequest)paramQMNetworkRequest);
        QMCGIError localQMCGIError = (QMCGIError)paramQMNetworkError;
        bool1 = bool2;
        if (localQMCGIError.isNeedRetryAutologin())
        {
          bool1 = true;
          NetworkManager.SessionTask.access$100(this.this$1, paramQMNetworkError, localQQMailAccount);
          localQQMailAccount.autoLogin(localQMCGIError);
        }
      }
    }
    QMLog.log(6, "NET_MANAGER", "session task error, code: " + paramQMNetworkError.code + " desp: " + paramQMNetworkError.desp + " url: " + paramQMNetworkError.url + " retry autoLogin:" + bool1 + " header:" + NetworkManager.access$200(this.this$1.this$0, paramQMNetworkRequest.getRequestHeaders()));
    if ((!bool1) && (this.this$1.oldCallback != null)) {
      this.this$1.oldCallback.handleError(paramQMNetworkRequest, paramQMNetworkResponse, paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NetworkManager.SessionTask.2
 * JD-Core Version:    0.7.0.1
 */