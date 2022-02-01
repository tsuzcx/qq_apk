package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.account.LoginManager;

class NetworkManager$SessionTask$1
  implements QMCallback.ISuccessCallback
{
  NetworkManager$SessionTask$1(NetworkManager.SessionTask paramSessionTask, NetworkManager paramNetworkManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    LoginManager.shareInstance().saveAccountLogined(((CGIRequest)paramQMNetworkRequest).accountId, paramQMNetworkRequest, paramQMNetworkResponse);
    if (this.this$1.oldCallback != null) {
      this.this$1.oldCallback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NetworkManager.SessionTask.1
 * JD-Core Version:    0.7.0.1
 */