package com.tencent.qqmail.attachment.activity;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class AttachSaveToWeiYunActivity$7
  implements QMCallback.ISuccessCallback
{
  AttachSaveToWeiYunActivity$7(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      paramQMNetworkRequest = paramQMNetworkResponse.getResponseString() + ",checkingCount:" + AttachSaveToWeiYunActivity.access$800(this.this$0) + ",waitForCheckingFirstTime:" + AttachSaveToWeiYunActivity.access$700(this.this$0) + new StringBuilder().append(",waitForCheckingPerTime:").append(AttachSaveToWeiYunActivity.access$600(this.this$0)).toString();
      QMLog.log(4, "AttachSaveToWeiYunActivity", "saveNormalAttachToWeiYunChecking onSuccess: log:" + paramQMNetworkRequest);
      paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkRequest != null)
      {
        if (!paramQMNetworkRequest.containsKey("status")) {
          break label300;
        }
        paramQMNetworkRequest = (String)paramQMNetworkRequest.get("status");
        if (!paramQMNetworkRequest.equals("1")) {
          break label185;
        }
        AttachSaveToWeiYunActivity.access$802(this.this$0, 0);
        if (AttachSaveToWeiYunActivity.access$000(this.this$0)) {
          AttachSaveToWeiYunActivity.access$500(this.this$0, 0, "");
        }
      }
      label185:
      do
      {
        do
        {
          return;
          if (!paramQMNetworkRequest.equals("-1")) {
            break;
          }
          AttachSaveToWeiYunActivity.access$802(this.this$0, 0);
        } while (!AttachSaveToWeiYunActivity.access$000(this.this$0));
        AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
        return;
        if (AttachSaveToWeiYunActivity.access$800(this.this$0) == 0)
        {
          AttachSaveToWeiYunActivity.access$900(this.this$0, new AttachSaveToWeiYunActivity.7.1(this), AttachSaveToWeiYunActivity.access$700(this.this$0));
          AttachSaveToWeiYunActivity.access$808(this.this$0);
          return;
        }
      } while (AttachSaveToWeiYunActivity.access$800(this.this$0) >= 10);
      AttachSaveToWeiYunActivity.access$1000(this.this$0, new AttachSaveToWeiYunActivity.7.2(this), AttachSaveToWeiYunActivity.access$600(this.this$0));
      return;
      label300:
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
      return;
    }
    AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.7
 * JD-Core Version:    0.7.0.1
 */