package com.tencent.mobileqq.msf.core.net.a;

import org.json.JSONObject;

public class h
{
  public String a;
  public long b;
  public boolean c;
  
  public h() {}
  
  public h(String paramString, long paramLong, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramBoolean;
  }
  
  public static h a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new h(paramJSONObject.getString("ssid"), paramJSONObject.getLong("time"), paramJSONObject.getBoolean("available"));
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ssid", this.a);
      localJSONObject.put("time", this.b);
      localJSONObject.put("available", this.c);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.h
 * JD-Core Version:    0.7.0.1
 */