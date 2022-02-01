package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class AttachSaveToWeiYunActivity$6
  implements QMCallback.IErrorCallback
{
  AttachSaveToWeiYunActivity$6(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      paramQMNetworkRequest = paramQMNetworkResponse.getResponseString();
      QMLog.log(6, "AttachSaveToWeiYunActivity", "saveNormalAttachToWeiYunBuildTask onError: log:" + paramQMNetworkRequest);
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.6
 * JD-Core Version:    0.7.0.1
 */