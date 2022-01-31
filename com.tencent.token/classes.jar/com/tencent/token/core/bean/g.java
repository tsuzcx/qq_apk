package com.tencent.token.core.bean;

import org.json.JSONObject;

public class g
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public int f;
  public String g;
  public int h;
  
  public g(OnlineDeviceResult paramOnlineDeviceResult) {}
  
  public void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.getString("dguid");
    this.b = paramJSONObject.getString("dname");
    this.c = paramJSONObject.getString("dtype");
    this.d = paramJSONObject.getString("ddes");
    this.e = paramJSONObject.getInt("dappid");
    this.f = paramJSONObject.getInt("dsubappid");
    this.g = paramJSONObject.getString("dappname");
    this.h = paramJSONObject.getInt("dflag");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.g
 * JD-Core Version:    0.7.0.1
 */