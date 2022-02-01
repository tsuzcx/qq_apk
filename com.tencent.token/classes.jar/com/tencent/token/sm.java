package com.tencent.token;

import org.json.JSONException;
import org.json.JSONObject;

public final class sm
{
  public long a;
  public int b;
  public long c;
  public int d;
  public long e;
  public String f;
  public String g;
  public String h;
  public String i;
  private String j;
  private int k;
  private int l;
  private String m;
  private String n;
  
  public final boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getLong("msg_id");
      this.b = paramJSONObject.getInt("app_id");
      this.c = paramJSONObject.getLong("uin_hash");
      this.j = paramJSONObject.getString("uin_mask");
      this.d = paramJSONObject.getInt("msg_type");
      this.e = paramJSONObject.getLong("msg_create_time");
      this.k = paramJSONObject.getInt("msg_live_time");
      this.l = paramJSONObject.getInt("msg_status");
      this.f = paramJSONObject.getString("msg_head");
      this.g = paramJSONObject.getString("msg_body");
      this.m = paramJSONObject.getString("return_btn_label");
      this.n = paramJSONObject.getString("return_uri");
      this.h = paramJSONObject.getString("accept_btn");
      this.i = paramJSONObject.getString("reject_btn");
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder("JSONException: ");
      localStringBuilder.append(paramJSONObject.getMessage());
      xj.c(localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sm
 * JD-Core Version:    0.7.0.1
 */