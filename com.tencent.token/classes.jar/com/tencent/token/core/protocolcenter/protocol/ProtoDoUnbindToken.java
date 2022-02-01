package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
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
  
  public static void a(dn paramdn, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramdn.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdn.c.put("param.unbind.type", Integer.valueOf(paramInt1));
    paramdn.j = paramInt2;
  }
  
  protected String a()
  {
    String str1 = bz.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject2 = cb.c();
    ((cb)localObject2).m();
    String str2 = ((cb)localObject2).j().replaceAll("-", "");
    Object localObject1 = "";
    try
    {
      localObject2 = l.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cb.c().s() / 1000L), "token_seq", str2, "token_code", ((cb)localObject2).o(), "imei", cb.b(), "unbind_type", String.valueOf(this.e) });
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
  
  protected void a(dn paramdn)
  {
    this.d = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramdn.c.get("param.unbind.type")).intValue();
    this.f = paramdn.j;
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