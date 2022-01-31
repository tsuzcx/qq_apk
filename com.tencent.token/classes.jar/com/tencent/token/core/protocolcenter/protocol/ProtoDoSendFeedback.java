package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDoSendFeedback
  extends e
{
  private String d;
  private int e;
  private long f;
  
  public static void a(ev paramev, long paramLong, String paramString)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.feedback.comment", paramString);
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      int i = cw.a + 1;
      cw.a = i;
      this.e = i;
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
      ((JSONObject)localObject2).put("net_type", w.k());
      ((JSONObject)localObject2).put("comment", this.d);
      ((JSONObject)localObject2).put("uin", this.f);
      localObject2 = ((JSONObject)localObject2).toString();
      h.a("plain:" + (String)localObject2);
      localObject2 = w.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_feedback_v2" + (String)localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.f = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.d = ((String)paramev.c.get("param.feedback.comment"));
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