package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoBindTokenByRealName
  extends d
{
  private long d;
  private int e;
  private int f;
  
  public static void a(dn paramdn, long paramLong, int paramInt1, int paramInt2)
  {
    paramdn.c.put("param.realuin", Long.valueOf(paramLong));
    paramdn.c.put("param.type", Integer.valueOf(paramInt1));
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
    Object localObject = cb.c();
    ((cb)localObject).m();
    String str2 = ((cb)localObject).j().replaceAll("-", "");
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.d), "imei", cb.b(), "verify_type", Integer.valueOf(this.f), "token_seq", str2, "token_code", ((cb)localObject).o(), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cb.c().s() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_bind_token_by_realname" + str1;
  }
  
  protected void a(dn paramdn)
  {
    this.d = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramdn.c.get("param.type")).intValue();
    this.e = paramdn.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.e);
        return;
      }
      long l = paramJSONObject.getLong("server_time");
      cb.c().b(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = l.d(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          cb.c().e();
          cb.c().a(paramJSONObject);
          cb.c().i();
        }
      }
      paramJSONObject = cq.a().d(this.d);
      if (paramJSONObject != null) {
        cq.a().b(paramJSONObject);
      }
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      g.c("handleSuccess" + this.b.f);
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoBindTokenByRealName
 * JD-Core Version:    0.7.0.1
 */