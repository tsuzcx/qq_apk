package com.tencent.token;

import java.util.HashMap;
import org.json.JSONObject;

public final class vb
  extends ud
{
  public String d;
  public long e;
  private int f;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.e = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.d = ((String)paramabm.c.get("param.mbmobile.mobile"));
    this.f = ((Integer)paramabm.c.get("param.type")).intValue();
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
 * Qualified Name:     com.tencent.token.vb
 * JD-Core Version:    0.7.0.1
 */