package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.utilities.log.QMLog;

final class CGIManager$2
  implements QMCallback.IErrorCallback
{
  CGIManager$2(QMCallback paramQMCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "CGIManager", "wrapCGICallback onError");
    if (this.val$callback != null)
    {
      Object localObject = paramQMNetworkError;
      if (paramQMNetworkError.code == 504)
      {
        localObject = paramQMNetworkError;
        if (paramQMNetworkRequest != null)
        {
          localObject = paramQMNetworkError;
          if (paramQMNetworkRequest.getRequestUrlString() != null)
          {
            localObject = paramQMNetworkError;
            if (paramQMNetworkRequest.getRequestUrlString().startsWith("http://shot.mail.qq.com"))
            {
              QMLog.log(4, "CGIManager", "Subscribe Shot CGI reLogin:" + paramQMNetworkRequest.getRequestUrlString());
              localObject = new QMCGIError(-2);
            }
          }
        }
      }
      this.val$callback.handleError(paramQMNetworkRequest, paramQMNetworkResponse, (QMNetworkError)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIManager.2
 * JD-Core Version:    0.7.0.1
 */