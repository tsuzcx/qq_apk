package com.tencent.qqmail.attachment.activity;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class AttachSaveToWeiYunActivity$9
  implements QMCallback.ISuccessCallback
{
  AttachSaveToWeiYunActivity$9(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      paramQMNetworkRequest = paramQMNetworkResponse.getResponseString();
      QMLog.log(4, "AttachSaveToWeiYunActivity", "saveBigAttachToWeiYun onSuccess: log:" + paramQMNetworkRequest);
      paramQMNetworkResponse = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      paramQMNetworkRequest = "";
      if (paramQMNetworkResponse != null)
      {
        if (paramQMNetworkResponse.containsKey("tips")) {
          paramQMNetworkRequest = (String)paramQMNetworkResponse.get("tips");
        }
        if (paramQMNetworkResponse.containsKey("ret"))
        {
          paramQMNetworkResponse = (String)paramQMNetworkResponse.get("ret");
          AttachSaveToWeiYunActivity.access$500(this.this$0, Integer.valueOf(paramQMNetworkResponse).intValue(), paramQMNetworkRequest);
        }
      }
      else
      {
        return;
      }
      AttachSaveToWeiYunActivity.access$500(this.this$0, -1, paramQMNetworkRequest);
      return;
    }
    AttachSaveToWeiYunActivity.access$500(this.this$0, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.9
 * JD-Core Version:    0.7.0.1
 */