package com.tencent.token.core.bean;

import com.tencent.token.global.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private long a;
  private int b;
  private long c;
  private String d;
  private int e;
  private long f;
  private int g;
  private int h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  
  public final long a()
  {
    return this.a;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getLong("msg_id");
      this.b = paramJSONObject.getInt("app_id");
      this.c = paramJSONObject.getLong("uin_hash");
      this.d = paramJSONObject.getString("uin_mask");
      this.e = paramJSONObject.getInt("msg_type");
      this.f = paramJSONObject.getLong("msg_create_time");
      this.g = paramJSONObject.getInt("msg_live_time");
      this.h = paramJSONObject.getInt("msg_status");
      this.i = paramJSONObject.getString("msg_head");
      this.j = paramJSONObject.getString("msg_body");
      this.k = paramJSONObject.getString("return_btn_label");
      this.l = paramJSONObject.getString("return_uri");
      this.m = paramJSONObject.getString("accept_btn");
      this.n = paramJSONObject.getString("reject_btn");
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      e.c("JSONException: " + paramJSONObject.getMessage());
    }
    return false;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final long e()
  {
    return this.f;
  }
  
  public final String f()
  {
    return this.i;
  }
  
  public final String g()
  {
    return this.j;
  }
  
  public final String h()
  {
    return this.m;
  }
  
  public final String i()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.b
 * JD-Core Version:    0.7.0.1
 */