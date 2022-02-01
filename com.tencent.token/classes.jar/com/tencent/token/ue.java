package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class ue
  extends tk
{
  private String d;
  private long e;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.e = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.d = ((String)paramaar.c.get("param.feedback.comment"));
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
 * Qualified Name:     com.tencent.token.ue
 * JD-Core Version:    0.7.0.1
 */