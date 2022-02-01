package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.ca;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoFeedbackAbnormalLogin
  extends d
{
  private long d;
  private long e;
  
  public static void a(do paramdo, long paramLong1, long paramLong2)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.c.put("param.feedback.msgid", Long.valueOf(paramLong2));
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = l.a(new Object[] { "uin", Long.valueOf(this.d), "msgid", Long.valueOf(this.e) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_feedback_abnormal_login_v2" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramdo.c.get("param.feedback.msgid")).longValue();
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFeedbackAbnormalLogin
 * JD-Core Version:    0.7.0.1
 */