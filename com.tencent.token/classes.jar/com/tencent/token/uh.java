package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class uh
  extends tk
{
  private long d;
  private int e;
  private int f;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramaar.c.get("param.unbind.type")).intValue();
    this.f = paramaar.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      wz localwz = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      localwz.a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uh
 * JD-Core Version:    0.7.0.1
 */