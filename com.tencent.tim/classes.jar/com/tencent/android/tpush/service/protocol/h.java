package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

public class h
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ssid", this.a);
    localJSONObject.put("bssid", this.b);
    localJSONObject.put("mac", this.c);
    localJSONObject.put("wflist", this.d);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.protocol.h
 * JD-Core Version:    0.7.0.1
 */