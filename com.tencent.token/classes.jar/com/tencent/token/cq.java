package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cq
  extends bm
{
  private long c;
  private int d;
  private int e;
  
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
    Object localObject2 = ag.c();
    ((ag)localObject2).m();
    String str2 = ((ag)localObject2).j().replaceAll("-", "");
    Object localObject1 = "";
    try
    {
      localObject2 = s.a(new Object[] { "real_uin", Long.valueOf(this.c), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(ag.c().r() / 1000L), "token_seq", str2, "token_code", ((ag)localObject2).o(), "imei", ag.b(), "unbind_type", String.valueOf(this.d) });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        e.c("encrypt data failed:" + localException.getMessage());
      }
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject1;
    return b.c() + "/cn/mbtoken3/mbtoken3_unbind_token" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.d = ((Integer)paramfs.c.get("param.unbind.type")).intValue();
    this.e = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cq
 * JD-Core Version:    0.7.0.1
 */