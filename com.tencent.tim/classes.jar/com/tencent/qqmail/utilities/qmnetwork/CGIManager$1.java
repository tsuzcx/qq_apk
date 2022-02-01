package com.tencent.qqmail.utilities.qmnetwork;

final class CGIManager$1
  implements QMCallback.ISuccessCallback
{
  CGIManager$1(QMCallback paramQMCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMCGIError localQMCGIError = CGIManager.access$000(paramQMNetworkRequest, paramQMNetworkResponse);
    if (localQMCGIError == null)
    {
      this.val$callback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
      return;
    }
    paramQMNetworkResponse.setError(localQMCGIError);
    this.val$callback.handleError(paramQMNetworkRequest, paramQMNetworkResponse, localQMCGIError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIManager.1
 * JD-Core Version:    0.7.0.1
 */