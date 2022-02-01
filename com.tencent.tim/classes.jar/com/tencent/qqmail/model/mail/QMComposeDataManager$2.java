package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMComposeDataManager$2
  implements QMCallback.IErrorCallback
{
  QMComposeDataManager$2(QMComposeDataManager paramQMComposeDataManager, ICallBack paramICallBack) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    this.val$failCallBack.callback(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMComposeDataManager.2
 * JD-Core Version:    0.7.0.1
 */