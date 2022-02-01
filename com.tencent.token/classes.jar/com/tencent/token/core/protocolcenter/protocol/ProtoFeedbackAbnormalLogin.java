package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
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
  
  public static void a(dp paramdp, long paramLong1, long paramLong2)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdp.c.put("param.feedback.msgid", Long.valueOf(paramLong2));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "uin", Long.valueOf(this.d), "msgid", Long.valueOf(this.e) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?data=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_feedback_abnormal_login_v2");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramdp.c.get("param.feedback.msgid")).longValue();
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