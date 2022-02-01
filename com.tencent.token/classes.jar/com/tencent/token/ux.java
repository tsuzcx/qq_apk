package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class ux
  extends tr
{
  private long d;
  private long e;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramabc.c.get("param.feedback.msgid")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ux
 * JD-Core Version:    0.7.0.1
 */