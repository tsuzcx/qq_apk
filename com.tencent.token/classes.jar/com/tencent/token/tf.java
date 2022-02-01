package com.tencent.token;

import org.json.JSONObject;

public final class tf
{
  public int a;
  public String b;
  public String c;
  public String d;
  
  public tf(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("id");
    this.c = paramJSONObject.optString("title");
    this.b = paramJSONObject.optString("icon");
    this.d = paramJSONObject.optString("url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tf
 * JD-Core Version:    0.7.0.1
 */