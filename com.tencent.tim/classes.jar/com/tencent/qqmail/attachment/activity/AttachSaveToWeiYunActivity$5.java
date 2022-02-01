package com.tencent.qqmail.attachment.activity;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class AttachSaveToWeiYunActivity$5
  implements QMCallback.ISuccessCallback
{
  AttachSaveToWeiYunActivity$5(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      paramQMNetworkRequest = paramQMNetworkResponse.getResponseString();
      QMLog.log(4, "AttachSaveToWeiYunActivity", "saveNormalAttachToWeiYunBuildTask onSuccess: log:" + paramQMNetworkRequest);
      paramQMNetworkResponse = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkResponse != null)
      {
        if (!paramQMNetworkResponse.containsKey("ret")) {
          break label127;
        }
        paramQMNetworkRequest = (String)paramQMNetworkResponse.get("ret");
        paramQMNetworkResponse = (String)paramQMNetworkResponse.get("taskid");
        if (paramQMNetworkRequest.equals("0")) {
          this.this$0.saveNormalAttachToWeiYunChecking(paramQMNetworkResponse);
        }
      }
      else
      {
        return;
      }
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
      return;
      label127:
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
      return;
    }
    AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.5
 * JD-Core Version:    0.7.0.1
 */