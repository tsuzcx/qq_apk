package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class ux
  extends ud
{
  private String d;
  private long e;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.e = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.d = ((String)paramabm.c.get("param.feedback.comment"));
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