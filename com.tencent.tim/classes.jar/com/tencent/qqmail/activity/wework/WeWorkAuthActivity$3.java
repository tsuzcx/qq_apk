package com.tencent.qqmail.activity.wework;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class WeWorkAuthActivity$3
  implements QMCallback.ISuccessCallback
{
  WeWorkAuthActivity$3(WeWorkAuthActivity paramWeWorkAuthActivity, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
    if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.containsKey("ret")))
    {
      paramQMNetworkRequest = paramQMNetworkRequest.getString("ret");
      if ((paramQMNetworkRequest == null) || (!paramQMNetworkRequest.equals("0"))) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        WeWorkAuthActivity.access$302(this.this$0, 1);
        QMLog.log(4, "LaunchWeWorkAuthActivity", "verifyWeWorkAccount success vid:" + this.val$vid);
      }
      for (;;)
      {
        if (WeWorkAuthActivity.access$200(this.this$0)) {
          WeWorkAuthActivity.access$500(this.this$0);
        }
        return;
        WeWorkAuthActivity.access$302(this.this$0, -1);
        QMLog.log(4, "LaunchWeWorkAuthActivity", "verifyWeWorkAccount error vid:" + this.val$vid);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.wework.WeWorkAuthActivity.3
 * JD-Core Version:    0.7.0.1
 */