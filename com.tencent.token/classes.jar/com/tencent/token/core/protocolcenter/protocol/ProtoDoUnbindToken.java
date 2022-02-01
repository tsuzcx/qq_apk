package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
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
  
  public static void a(dp paramdp, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdp.c.put("param.unbind.type", Integer.valueOf(paramInt1));
    paramdp.j = paramInt2;
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject2 = cd.c();
    ((cd)localObject2).m();
    Object localObject3 = ((cd)localObject2).j().replaceAll("-", "");
    Object localObject1 = "";
    try
    {
      localObject2 = l.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cd.c().s() / 1000L), "token_seq", localObject3, "token_code", ((cd)localObject2).o(), "imei", cd.b(), "unbind_type", String.valueOf(this.e) });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("encrypt data failed:");
      ((StringBuilder)localObject3).append(localException.getMessage());
      g.c(((StringBuilder)localObject3).toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_unbind_token");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramdp.c.get("param.unbind.type")).intValue();
    this.f = paramdp.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      e locale = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      locale.a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoUnbindToken
 * JD-Core Version:    0.7.0.1
 */