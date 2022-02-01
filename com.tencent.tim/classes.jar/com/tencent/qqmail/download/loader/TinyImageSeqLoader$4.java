package com.tencent.qqmail.download.loader;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.HashMap;

class TinyImageSeqLoader$4
  implements QMCallback.ISuccessCallback
{
  TinyImageSeqLoader$4(TinyImageSeqLoader paramTinyImageSeqLoader, String paramString1, String paramString2, MediaItemInfo paramMediaItemInfo) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    JSONObject localJSONObject = (JSONObject)paramQMNetworkResponse.getResponseJson();
    String str = paramQMNetworkResponse.getResponseString();
    paramQMNetworkRequest = localJSONObject;
    if (str != null)
    {
      paramQMNetworkRequest = localJSONObject;
      if (!str.equals(""))
      {
        paramQMNetworkResponse.setResponseJson(JSONReader.parse(str));
        paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
      }
    }
    TinyImageSeqLoader.access$200(this.this$0).put(this.val$imageKey, paramQMNetworkRequest);
    TinyImageSeqLoader.access$100(this.this$0, this.val$imageKey, this.val$imageUrl, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader.4
 * JD-Core Version:    0.7.0.1
 */