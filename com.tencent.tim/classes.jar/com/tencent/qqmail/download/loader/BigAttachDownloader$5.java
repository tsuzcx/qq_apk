package com.tencent.qqmail.download.loader;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BigAttachDownloader$5
  implements QMCallback.ISuccessCallback
{
  BigAttachDownloader$5(BigAttachDownloader paramBigAttachDownloader, boolean paramBoolean) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    BigAttachDownloader.access$602(this.this$0, (JSONObject)paramQMNetworkResponse.getResponseJson());
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseString();
    if ((paramQMNetworkRequest != null) && (!paramQMNetworkRequest.equals("")) && (BigAttachDownloader.access$600(this.this$0) == null))
    {
      paramQMNetworkResponse.setResponseJson(JSONReader.parse(paramQMNetworkRequest));
      BigAttachDownloader.access$602(this.this$0, (JSONObject)paramQMNetworkResponse.getResponseJson());
    }
    if (this.val$isRefresh)
    {
      if (BigAttachDownloader.access$600(this.this$0) != null)
      {
        paramQMNetworkRequest = (String)BigAttachDownloader.access$600(this.this$0).get("errcode");
        this.this$0.handleErrorCode(paramQMNetworkRequest);
      }
      return;
    }
    this.this$0.getInfoFromCGIDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.BigAttachDownloader.5
 * JD-Core Version:    0.7.0.1
 */