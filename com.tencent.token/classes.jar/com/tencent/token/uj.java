package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class uj
  extends tk
{
  public String d;
  public long e;
  private int f;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.e = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.d = ((String)paramaar.c.get("param.qqtoken"));
    this.f = ((Integer)paramaar.c.get("param.type")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, paramJSONObject, paramJSONObject);
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uj
 * JD-Core Version:    0.7.0.1
 */