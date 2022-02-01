package com.tencent.qqmail.activity.wework;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class WeWorkAuthActivity$2
  implements QMCallback.IBeforeSendCallback
{
  WeWorkAuthActivity$2(WeWorkAuthActivity paramWeWorkAuthActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    WeWorkAuthActivity.access$302(this.this$0, 0);
    QMLog.log(4, "LaunchWeWorkAuthActivity", "verifyWeWorkAccount before vid:" + this.val$vid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.wework.WeWorkAuthActivity.2
 * JD-Core Version:    0.7.0.1
 */