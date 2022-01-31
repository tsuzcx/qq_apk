package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class cs
  extends bm
{
  public String[] c;
  public long d;
  public List e;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str2 = s.a(this.e, this.c);
    if (str2 == null)
    {
      this.a.a(10000, "encrypt ques answer failed", null);
      return null;
    }
    str1 = "?uin=" + this.d + "&sess_id=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_vry_ques" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.e = ((List)paramfs.c.get("param.qqquestion"));
    this.c = ((String[])paramfs.c.get("param.qqquestionanswer"));
  }
  
  protected final void a(JSONObject paramJSONObject)
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
 * Qualified Name:     com.tencent.token.cs
 * JD-Core Version:    0.7.0.1
 */