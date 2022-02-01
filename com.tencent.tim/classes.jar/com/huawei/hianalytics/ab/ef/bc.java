package com.huawei.hianalytics.ab.ef;

import org.json.JSONObject;

public class bc
  extends com.huawei.hianalytics.ab.bc.cd.bc.bc
{
  private String gh = "";
  
  public JSONObject cd()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("protocol_version", "1");
    localJSONObject.put("compress_mode", "1");
    localJSONObject.put("serviceid", this.de);
    localJSONObject.put("appid", this.ab);
    localJSONObject.put("hmac", this.gh);
    localJSONObject.put("chifer", this.fg);
    localJSONObject.put("timestamp", this.bc);
    localJSONObject.put("servicetag", this.cd);
    localJSONObject.put("requestid", this.ef);
    return localJSONObject;
  }
  
  public void gh(String paramString)
  {
    this.gh = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.ef.bc
 * JD-Core Version:    0.7.0.1
 */