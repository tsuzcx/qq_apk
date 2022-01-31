package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoUnbindToken
  extends e
{
  private long d;
  private int e;
  private int f;
  
  public static void a(ev paramev, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong2));
    paramev.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramev.c.put("param.unbind.type", Integer.valueOf(paramInt1));
    paramev.j = paramInt2;
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject2 = cx.c();
    ((cx)localObject2).m();
    String str2 = ((cx)localObject2).j().replaceAll("-", "");
    Object localObject1 = "";
    try
    {
      localObject2 = w.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cx.c().s() / 1000L), "token_seq", str2, "token_code", ((cx)localObject2).o(), "imei", cx.b(), "unbind_type", String.valueOf(this.e) });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        h.c("encrypt data failed:" + localException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_unbind_token" + (String)localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramev.c.get("param.unbind.type")).intValue();
    this.f = paramev.j;
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