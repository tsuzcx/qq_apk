package com.tencent.token;

import org.json.JSONObject;

public final class st
{
  public int a;
  public String b;
  public String c;
  public String d;
  
  public st(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("id");
    this.c = paramJSONObject.optString("title");
    this.b = paramJSONObject.optString("icon");
    this.d = paramJSONObject.optString("url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.st
 * JD-Core Version:    0.7.0.1
 */