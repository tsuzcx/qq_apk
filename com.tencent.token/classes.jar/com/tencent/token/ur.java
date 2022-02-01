package com.tencent.token;

import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class ur
  extends tr
{
  public String[] d;
  public long e;
  public List<DeterminVerifyFactorsResult.QuesInfoItem> f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.e = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.f = ((List)paramabc.c.get("param.qqquestion"));
    this.d = ((String[])paramabc.c.get("param.qqquestionanswer"));
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
 * Qualified Name:     com.tencent.token.ur
 * JD-Core Version:    0.7.0.1
 */