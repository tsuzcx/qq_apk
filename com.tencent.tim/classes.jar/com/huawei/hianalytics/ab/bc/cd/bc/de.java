package com.huawei.hianalytics.ab.bc.cd.bc;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.bc.ab;
import org.json.JSONObject;

public class de
  implements fg
{
  private String ab;
  private String bc;
  private String cd;
  private String de;
  private String ef;
  private String fg;
  
  public String ab()
  {
    return this.ab;
  }
  
  public void ab(String paramString)
  {
    this.ab = paramString;
  }
  
  public void ab(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.bc = paramJSONObject.optString("event");
    this.cd = paramJSONObject.optString("properties");
    String str = com.huawei.hianalytics.ab.bc.gh.bc.ab().cd();
    this.cd = com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(bc.ab.ab).ab(str, this.cd);
    this.ab = paramJSONObject.optString("type");
    this.de = paramJSONObject.optString("eventtime");
    this.ef = paramJSONObject.optString("event_session_name");
    this.fg = paramJSONObject.optString("first_session_event");
  }
  
  public String bc()
  {
    return this.de;
  }
  
  public void bc(String paramString)
  {
    this.bc = paramString;
  }
  
  public JSONObject cd()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", this.ab);
    localJSONObject.put("eventtime", this.de);
    localJSONObject.put("event", this.bc);
    localJSONObject.put("event_session_name", this.ef);
    localJSONObject.put("first_session_event", this.fg);
    if (TextUtils.isEmpty(this.cd)) {
      return null;
    }
    localJSONObject.put("properties", new JSONObject(this.cd));
    return localJSONObject;
  }
  
  public void cd(String paramString)
  {
    this.cd = paramString;
  }
  
  public JSONObject de()
  {
    JSONObject localJSONObject = cd();
    String str = com.huawei.hianalytics.ab.bc.gh.bc.ab().cd();
    localJSONObject.put("properties", com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(bc.ab.ab).bc(str, this.cd));
    return localJSONObject;
  }
  
  public void de(String paramString)
  {
    this.de = paramString;
  }
  
  public void ef(String paramString)
  {
    this.ef = paramString;
  }
  
  public void fg(String paramString)
  {
    this.fg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.cd.bc.de
 * JD-Core Version:    0.7.0.1
 */