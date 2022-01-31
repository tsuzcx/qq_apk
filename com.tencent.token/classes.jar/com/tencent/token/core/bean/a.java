package com.tencent.token.core.bean;

import org.json.JSONObject;

public final class a
{
  public String a;
  public String b;
  
  public a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("pic_url");
    this.b = paramJSONObject.optString("click_url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.a
 * JD-Core Version:    0.7.0.1
 */