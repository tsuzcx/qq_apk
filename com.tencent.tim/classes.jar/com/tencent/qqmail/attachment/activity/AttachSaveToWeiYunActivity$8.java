package com.tencent.qqmail.attachment.activity;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class AttachSaveToWeiYunActivity$8
  implements QMCallback.IErrorCallback
{
  AttachSaveToWeiYunActivity$8(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      paramQMNetworkRequest = paramQMNetworkResponse.getResponseString() + ",checkingCount:" + AttachSaveToWeiYunActivity.access$800(this.this$0) + new StringBuilder().append(",waitForCheckingFirstTime:").append(AttachSaveToWeiYunActivity.access$700(this.this$0)).toString() + new StringBuilder().append(",waitForCheckingPerTime:").append(AttachSaveToWeiYunActivity.access$600(this.this$0)).toString();
      QMLog.log(6, "AttachSaveToWeiYunActivity", "saveNormalAttachToWeiYunChecking onError: log:" + paramQMNetworkRequest);
      paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkRequest.containsKey("status"))
      {
        paramQMNetworkRequest = (String)paramQMNetworkRequest.get("status");
        if (paramQMNetworkRequest.equals("1"))
        {
          AttachSaveToWeiYunActivity.access$802(this.this$0, 0);
          AttachSaveToWeiYunActivity.access$500(this.this$0, 0, "");
          QMWatcherCenter.triggerForwardToWeiYunSuccess();
        }
        do
        {
          return;
          if (paramQMNetworkRequest.equals("-1"))
          {
            AttachSaveToWeiYunActivity.access$802(this.this$0, 0);
            if (AttachSaveToWeiYunActivity.access$000(this.this$0)) {
              AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
            }
            QMWatcherCenter.triggerForwardToWeiYunError(-1);
            return;
          }
          if (AttachSaveToWeiYunActivity.access$800(this.this$0) == 0)
          {
            AttachSaveToWeiYunActivity.access$1100(this.this$0, new AttachSaveToWeiYunActivity.8.1(this), AttachSaveToWeiYunActivity.access$700(this.this$0));
            AttachSaveToWeiYunActivity.access$808(this.this$0);
            return;
          }
        } while (AttachSaveToWeiYunActivity.access$800(this.this$0) >= 10);
        AttachSaveToWeiYunActivity.access$1200(this.this$0, new AttachSaveToWeiYunActivity.8.2(this), AttachSaveToWeiYunActivity.access$600(this.this$0));
        return;
      }
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
      return;
    }
    AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.8
 * JD-Core Version:    0.7.0.1
 */