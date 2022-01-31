package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class cm
  extends bm
{
  private String c;
  private int d;
  private long e;
  
  protected final String a()
  {
    Object localObject1 = null;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = af.a + 1;
      af.a = i;
      this.d = i;
      ((JSONObject)localObject2).put("seq_id", this.d);
      ((JSONObject)localObject2).put("op_time", ag.c().r() / 1000L);
      ((JSONObject)localObject2).put("net_type", s.i());
      ((JSONObject)localObject2).put("comment", this.c);
      ((JSONObject)localObject2).put("uin", this.e);
      localObject2 = ((JSONObject)localObject2).toString();
      e.a("plain:" + (String)localObject2);
      localObject2 = s.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        e.c("JSONException:" + localJSONException.getMessage());
      }
    }
    str = "?aq_base_sid=" + str + "&data=" + localObject1;
    return b.c() + "/cn/mbtoken3/mbtoken3_feedback_v2" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.c = ((String)paramfs.c.get("param.feedback.comment"));
  }
  
  protected final void a(JSONObject paramJSONObject)
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
 * Qualified Name:     com.tencent.token.cm
 * JD-Core Version:    0.7.0.1
 */