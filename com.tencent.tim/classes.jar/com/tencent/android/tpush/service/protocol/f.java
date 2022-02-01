package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.common.i;
import org.json.JSONObject;

public class f
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public long k = 0L;
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public int t = 3;
  public o u = null;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("imei", this.a);
    localJSONObject.put("model", this.b);
    localJSONObject.put("os", this.c);
    localJSONObject.put("network", this.d);
    localJSONObject.put("sdCard", this.e);
    localJSONObject.put("sdDouble", this.f);
    localJSONObject.put("resolution", this.g);
    localJSONObject.put("manu", this.h);
    localJSONObject.put("apiLevel", this.i);
    localJSONObject.put("sdkVersionName", this.j);
    localJSONObject.put("isRooted", this.k);
    localJSONObject.put("appList", this.l);
    localJSONObject.put("cpuInfo", this.m);
    localJSONObject.put("language", this.n);
    localJSONObject.put("timezone", this.o);
    localJSONObject.put("launcherName", this.p);
    localJSONObject.put("xgAppList", this.q);
    localJSONObject.put("ntfBar", this.t);
    if (this.u != null) {
      localJSONObject.put("tUinInfo", this.u.a());
    }
    localJSONObject.put("osVersion", this.r);
    if (!i.b(this.s)) {
      localJSONObject.put("ohVersion", this.s);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.f
 * JD-Core Version:    0.7.0.1
 */