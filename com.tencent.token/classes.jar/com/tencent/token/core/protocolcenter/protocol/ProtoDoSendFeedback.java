package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDoSendFeedback
  extends d
{
  private String d;
  private int e;
  private long f;
  
  public static void a(dn paramdn, long paramLong, String paramString)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdn.c.put("param.feedback.comment", paramString);
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = bz.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = ca.a + 1;
      ca.a = i;
      this.e = i;
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("op_time", cb.c().s() / 1000L);
      ((JSONObject)localObject2).put("net_type", l.k());
      ((JSONObject)localObject2).put("comment", this.d);
      ((JSONObject)localObject2).put("uin", this.f);
      localObject2 = ((JSONObject)localObject2).toString();
      g.a("plain:" + (String)localObject2);
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_feedback_v2" + (String)localObject1;
  }
  
  protected void a(dn paramdn)
  {
    this.f = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.d = ((String)paramdn.c.get("param.feedback.comment"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoSendFeedback
 * JD-Core Version:    0.7.0.1
 */