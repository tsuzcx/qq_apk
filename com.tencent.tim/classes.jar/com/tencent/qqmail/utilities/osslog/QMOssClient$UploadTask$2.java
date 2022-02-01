package com.tencent.qqmail.utilities.osslog;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import rx.functions.Func1;

class QMOssClient$UploadTask$2
  implements Func1<QMNetworkResponse, Integer>
{
  QMOssClient$UploadTask$2(QMOssClient.UploadTask paramUploadTask) {}
  
  public Integer call(QMNetworkResponse paramQMNetworkResponse)
  {
    if (paramQMNetworkResponse != null)
    {
      paramQMNetworkResponse = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkResponse != null)
      {
        paramQMNetworkResponse = paramQMNetworkResponse.getJSONObject("result");
        if (paramQMNetworkResponse != null)
        {
          int i = paramQMNetworkResponse.getIntValue("errCode");
          paramQMNetworkResponse = paramQMNetworkResponse.getString("message");
          if (i == 0) {
            break label94;
          }
          paramQMNetworkResponse = "upload kv/osslog response error, errCode: " + i + ", msg: " + paramQMNetworkResponse;
          QMLog.log(5, "QMOssClient", paramQMNetworkResponse);
          ValidateHelper.assertInDebug(paramQMNetworkResponse, false);
        }
      }
      return Integer.valueOf(1);
      label94:
      return Integer.valueOf(0);
    }
    return Integer.valueOf(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.QMOssClient.UploadTask.2
 * JD-Core Version:    0.7.0.1
 */