package com.tencent.tpns.baseapi.core.a;

import com.tencent.tpns.baseapi.base.util.Util;
import org.json.JSONObject;

public class b
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  private JSONObject g;
  
  public JSONObject a()
  {
    this.g = new JSONObject();
    if (!Util.isNullOrEmptyString(this.a)) {
      this.g.put("appVersion", this.a);
    }
    if (!Util.isNullOrEmptyString(this.b)) {
      this.g.put("model", this.b);
    }
    if (!Util.isNullOrEmptyString(this.c)) {
      this.g.put("network", this.c);
    }
    if (!Util.isNullOrEmptyString(this.d)) {
      this.g.put("os", this.d);
    }
    if (!Util.isNullOrEmptyString(this.e)) {
      this.g.put("packageName", this.e);
    }
    if (!Util.isNullOrEmptyString(this.f)) {
      this.g.put("sdkVersionName", this.f);
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("appDeviceInfo", this.g);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.a.b
 * JD-Core Version:    0.7.0.1
 */