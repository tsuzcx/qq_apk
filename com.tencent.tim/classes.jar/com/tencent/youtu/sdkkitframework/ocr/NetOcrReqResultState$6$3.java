package com.tencent.youtu.sdkkitframework.ocr;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class NetOcrReqResultState$6$3
  extends HashMap<String, Object>
{
  NetOcrReqResultState$6$3(NetOcrReqResultState.6 param6, int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(this.val$errorCode));
    put("message", this.val$jsonObject.getString("errormsg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.6.3
 * JD-Core Version:    0.7.0.1
 */