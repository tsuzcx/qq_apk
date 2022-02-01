package com.tencent.smtt.sdk.a;

import org.json.JSONObject;

public class b
{
  private int a;
  private int b;
  private String c;
  private long d;
  
  public static b a(JSONObject paramJSONObject)
  {
    b localb = null;
    if (paramJSONObject != null)
    {
      localb = new b();
      localb.a = paramJSONObject.optInt("id", -1);
      localb.b = paramJSONObject.optInt("cmd_id", -1);
      localb.c = paramJSONObject.optString("ext_params", "");
      localb.d = (1000L * paramJSONObject.optLong("expiration", 0L));
    }
    return localb;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return System.currentTimeMillis() > this.d;
  }
  
  public String toString()
  {
    return "[id=" + this.a + ", cmd=" + this.b + ", extra='" + this.c + '\'' + ", expiration=" + a.a(this.d) + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */