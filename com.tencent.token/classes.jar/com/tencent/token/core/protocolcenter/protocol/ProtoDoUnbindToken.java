package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoUnbindToken
  extends d
{
  private long d;
  private int e;
  private int f;
  
  public static void a(do paramdo, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.c.put("param.unbind.type", Integer.valueOf(paramInt1));
    paramdo.j = paramInt2;
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject2 = cc.c();
    ((cc)localObject2).m();
    String str2 = ((cc)localObject2).j().replaceAll("-", "");
    Object localObject1 = "";
    try
    {
      localObject2 = l.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cc.c().s() / 1000L), "token_seq", str2, "token_code", ((cc)localObject2).o(), "imei", cc.b(), "unbind_type", String.valueOf(this.e) });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        g.c("encrypt data failed:" + localException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_unbind_token" + (String)localObject1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramdo.c.get("param.unbind.type")).intValue();
    this.f = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoUnbindToken
 * JD-Core Version:    0.7.0.1
 */