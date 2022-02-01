package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

public class o
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("bootTime", this.a);
    localJSONObject.put("countryCode", this.b);
    localJSONObject.put("deviceName", this.c);
    localJSONObject.put("carrierInfo", this.d);
    localJSONObject.put("memorySize", this.e);
    localJSONObject.put("diskSize", this.f);
    localJSONObject.put("sysFileTime", this.g);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.o
 * JD-Core Version:    0.7.0.1
 */