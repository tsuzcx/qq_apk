package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoFeedbackMobileUsing
  extends e
{
  private long d;
  
  public static void a(ev paramev, long paramLong)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = w.a(new Object[] { "uin", Long.valueOf(this.d) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_feedback_mobile_using_v2" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFeedbackMobileUsing
 * JD-Core Version:    0.7.0.1
 */