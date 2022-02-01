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
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = cc.c();
    ((cc)localObject1).m();
    Object localObject2 = ((cc)localObject1).j().replaceAll("-", "");
    localObject1 = l.a(new Object[] { "real_uin", Long.valueOf(this.d), "imei", cc.b(), "verify_type", Integer.valueOf(this.f), "token_seq", localObject2, "token_code", ((cc)localObject1).o(), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("?aq_base_sid=");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("&data=");
    ((StringBuilder)localObject2).append((String)localObject1);
    str = ((StringBuilder)localObject2).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(c.e());
    ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_bind_token_by_realname");
    ((StringBuilder)localObject1).append(str);
    return ((StringBuilder)localObject1).toString();
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
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.e);
        g.c(paramJSONObject.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSuccess");
      ((StringBuilder)localObject).append(this.b.f);
      g.c(((StringBuilder)localObject).toString());
      localObject = this.b.d.obtainMessage(this.b.f);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoBindTokenByRealName
 * JD-Core Version:    0.7.0.1
 */