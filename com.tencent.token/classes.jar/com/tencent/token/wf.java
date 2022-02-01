package com.tencent.token;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class wf
  extends tk
{
  private JSONArray d;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((JSONArray)paramaar.c.get("param.reportdns.domain"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    aae.a(System.currentTimeMillis() / 1000L);
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wf
 * JD-Core Version:    0.7.0.1
 */