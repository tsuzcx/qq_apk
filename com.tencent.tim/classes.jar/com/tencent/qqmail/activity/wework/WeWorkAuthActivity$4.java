package com.tencent.qqmail.activity.wework;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class WeWorkAuthActivity$4
  implements QMCallback.IErrorCallback
{
  WeWorkAuthActivity$4(WeWorkAuthActivity paramWeWorkAuthActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    WeWorkAuthActivity.access$302(this.this$0, -1);
    QMLog.log(4, "LaunchWeWorkAuthActivity", "verifyWeWorkAccount error vid:" + this.val$vid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.wework.WeWorkAuthActivity.4
 * JD-Core Version:    0.7.0.1
 */