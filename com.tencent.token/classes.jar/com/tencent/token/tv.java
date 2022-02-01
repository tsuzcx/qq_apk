package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class tv
  extends tk
{
  private String d;
  
  public final String a()
  {
    sa.a();
    aad.a(new Object[] { "uin", this.d });
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaar.c.get("param.realuin"));
    this.d = localStringBuilder.toString();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    xb.a("ProtoDelUnverifyUin:errCode".concat(String.valueOf(i)));
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tv
 * JD-Core Version:    0.7.0.1
 */