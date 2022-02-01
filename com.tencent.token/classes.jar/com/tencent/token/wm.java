package com.tencent.token;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class wm
  extends tr
{
  private JSONArray d;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((JSONArray)paramabc.c.get("param.reportdns.domain"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    aap.a(System.currentTimeMillis() / 1000L);
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wm
 * JD-Core Version:    0.7.0.1
 */