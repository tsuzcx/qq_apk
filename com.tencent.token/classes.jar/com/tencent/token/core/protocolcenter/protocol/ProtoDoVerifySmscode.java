package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
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
  
  public static void a(dn paramdn, long paramLong, String paramString, int paramInt)
  {
    paramdn.c.put("param.realuin", Long.valueOf(paramLong));
    paramdn.c.put("param.smscode", paramString);
    paramdn.c.put("param.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str1 = bz.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = ca.a + 1;
    ca.a = i;
    this.f = i;
    String str2 = l.a(new Object[] { "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cb.c().s() / 1000L), "uin", Long.valueOf(this.e), "mobile_code", this.d, "verify_type_id", Integer.valueOf(this.g) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt qqtoken code failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_verify_mobile_code_v2" + str1;
  }
  
  protected void a(dn paramdn)
  {
    this.e = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.d = ((String)paramdn.c.get("param.smscode"));
    this.g = ((Integer)paramdn.c.get("param.type")).intValue();
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