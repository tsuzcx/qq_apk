package com.tencent.token;

import org.json.JSONObject;

public final class sl
{
  public int a;
  public String b;
  public String c;
  public String d;
  
  public sl(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("id");
    this.c = paramJSONObject.optString("title");
    this.b = paramJSONObject.optString("icon");
    this.d = paramJSONObject.optString("url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sl
 * JD-Core Version:    0.7.0.1
 */