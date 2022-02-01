package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoVerifySmscode
  extends d
{
  public String d;
  public long e;
  private int f;
  private int g;
  
  public static void a(dp paramdp, long paramLong, String paramString, int paramInt)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.c.put("param.smscode", paramString);
    paramdp.c.put("param.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cc.a + 1;
    cc.a = i;
    this.f = i;
    Object localObject = l.a(new Object[] { "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cd.c().s() / 1000L), "uin", Long.valueOf(this.e), "mobile_code", this.d, "verify_type_id", Integer.valueOf(this.g) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt qqtoken code failed");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_verify_mobile_code_v2");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.e = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.d = ((String)paramdp.c.get("param.smscode"));
    this.g = ((Integer)paramdp.c.get("param.type")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, paramJSONObject, paramJSONObject);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifySmscode
 * JD-Core Version:    0.7.0.1
 */