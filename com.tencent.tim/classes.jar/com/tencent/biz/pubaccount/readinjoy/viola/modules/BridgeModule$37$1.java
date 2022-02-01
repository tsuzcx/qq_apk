package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.qphone.base.util.QLog;
import kxm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$37$1
  implements Runnable
{
  BridgeModule$37$1(BridgeModule.37 param37, JSONObject paramJSONObject, JSONArray paramJSONArray) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.val$result.put("uploadVideoList", this.val$jsonArray);
        this.val$result.put("errCode", this.a.val$errCode);
        this.val$result.put("errMsg", this.a.val$errMsg);
        JSONObject localJSONObject = this.val$result;
        if (!this.a.auW) {
          continue;
        }
        i = 1;
        localJSONObject.put("hasVideoPublished", i);
        kxm.a();
      }
      catch (JSONException localJSONException)
      {
        int i;
        QLog.e(BridgeModule.TAG, 1, "getUploadingVideoInfo onResult, put uploadVideoList error =" + QLog.getStackTraceString(localJSONException));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i(BridgeModule.TAG, 2, "getUploadingVideoInfo, onResult=" + this.val$result.toString() + "errCode=" + this.a.val$errCode + "errMsg=" + this.a.val$errMsg);
      }
      if (this.a.val$errCode != 0) {
        QLog.i(BridgeModule.TAG, 1, "responseUploadingVideoListerrCode=" + this.a.val$errCode + "errMsg=" + this.a.val$errMsg);
      }
      this.a.this$0.invokeJS(this.a.val$callback, this.val$result);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.37.1
 * JD-Core Version:    0.7.0.1
 */