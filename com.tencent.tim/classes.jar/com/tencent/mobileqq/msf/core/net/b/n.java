package com.tencent.mobileqq.msf.core.net.b;

import org.json.JSONObject;

public class n
{
  public String a;
  public long b;
  public boolean c;
  public int d;
  
  public n() {}
  
  public n(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramBoolean;
    this.d = paramInt;
  }
  
  public static n a(String paramString)
  {
    try
    {
      paramString = paramString.split("&#&");
      if (paramString.length != 3) {
        return null;
      }
      paramString = new n(paramString[0], Long.parseLong(paramString[1]), Boolean.parseBoolean(paramString[2]), 0);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static n a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new n(paramJSONObject.getString("ssid"), paramJSONObject.getLong("time"), paramJSONObject.getBoolean("available"), 0);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a).append("&#&");
    localStringBuffer.append(this.b).append("&#&");
    localStringBuffer.append(this.c).append("&#&");
    localStringBuffer.append(this.d);
    return localStringBuffer.toString();
  }
  
  public JSONObject b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.n
 * JD-Core Version:    0.7.0.1
 */