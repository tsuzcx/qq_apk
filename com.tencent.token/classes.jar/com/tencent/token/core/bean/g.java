package com.tencent.token.core.bean;

import org.json.JSONObject;

public class g
{
  public int a;
  public String b;
  public String c;
  public String d;
  
  public g(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("id");
    this.c = paramJSONObject.optString("title");
    this.b = paramJSONObject.optString("icon");
    this.d = paramJSONObject.optString("url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.g
 * JD-Core Version:    0.7.0.1
 */