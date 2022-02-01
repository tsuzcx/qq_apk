package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
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
  
  public static void a(do paramdo, long paramLong, int paramInt1, int paramInt2)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.type", Integer.valueOf(paramInt1));
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
    Object localObject = cc.c();
    ((cc)localObject).m();
    String str2 = ((cc)localObject).j().replaceAll("-", "");
    localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.d), "imei", cc.b(), "verify_type", Integer.valueOf(this.f), "token_seq", str2, "token_code", ((cc)localObject).o(), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_bind_token_by_realname" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramdo.c.get("param.type")).intValue();
    this.e = paramdo.j;
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
      cc.c().b(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = l.d(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          cc.c().e();
          cc.c().a(paramJSONObject);
          cc.c().i();
        }
      }
      paramJSONObject = cr.a().d(this.d);
      if (paramJSONObject != null) {
        cr.a().b(paramJSONObject);
      }
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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