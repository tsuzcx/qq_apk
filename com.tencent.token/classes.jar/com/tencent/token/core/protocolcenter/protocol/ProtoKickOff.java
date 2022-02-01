package com.tencent.token.core.protocolcenter.protocol;

import android.os.Handler;
import android.os.Message;
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

public class ProtoKickOff
  extends d
{
  private long d;
  private String e;
  private String f;
  private int g;
  private int h;
  private String i;
  private String j;
  private int k;
  private int l;
  private String m;
  private String n;
  private int o;
  
  public static void a(dp paramdp, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdp.c.put("param.device.lock.dguid", paramString1);
    paramdp.c.put("param.device.lock.ddes", paramString2);
    paramdp.c.put("param.device.lock.dappid", Integer.valueOf(paramInt1));
    paramdp.c.put("param.device.lock.dsubappid", Integer.valueOf(paramInt2));
    paramdp.c.put("param.device.lock.dappname", paramString3);
    paramdp.c.put("param.device.lock.guid", paramString4);
    paramdp.c.put("param.device.lock.appid", Integer.valueOf(paramInt3));
    paramdp.c.put("param.device.lock.subappid", Integer.valueOf(paramInt4));
    paramdp.c.put("param.device.lock.appname", paramString5);
    paramdp.c.put("param.skey", paramString6);
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("A2A2:");
    ((StringBuilder)localObject).append(this.n);
    com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
    int i1 = cc.a + 1;
    cc.a = i1;
    this.o = i1;
    localObject = l.a(new Object[] { "seq_id", Integer.valueOf(this.o), "op_time", Long.valueOf(cd.c().s() / 1000L), "uin", Long.valueOf(this.d), "dguid", this.e, "ddes", this.f, "dappid", Integer.valueOf(this.g), "dappname", this.i, "guid", this.j, "appid", Integer.valueOf(this.k), "subappid", Integer.valueOf(this.l), "appname", this.m, "encryptedA2", l.b(this.n.getBytes()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_kickoff_v2");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.e = ((String)paramdp.c.get("param.device.lock.dguid"));
    this.f = ((String)paramdp.c.get("param.device.lock.ddes"));
    this.g = ((Integer)paramdp.c.get("param.device.lock.dappid")).intValue();
    this.h = ((Integer)paramdp.c.get("param.device.lock.dsubappid")).intValue();
    this.i = ((String)paramdp.c.get("param.device.lock.dappname"));
    this.j = ((String)paramdp.c.get("param.device.lock.guid"));
    this.k = ((Integer)paramdp.c.get("param.device.lock.appid")).intValue();
    this.l = ((Integer)paramdp.c.get("param.device.lock.subappid")).intValue();
    this.m = ((String)paramdp.c.get("param.device.lock.appname"));
    this.n = ((String)paramdp.c.get("param.skey"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    i1 = paramJSONObject.getInt("seq_id");
    if (i1 != this.o)
    {
      this.a.b(10030);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parseJSON error seq is wrong seq=");
      paramJSONObject.append(i1);
      paramJSONObject.append(",right = ");
      paramJSONObject.append(cc.a().b());
      com.tencent.token.global.g.c(paramJSONObject.toString());
      return;
    }
    com.tencent.service.g.a().a(this.d, this.g, this.h, this.i, this.e);
    this.a.c();
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoKickOff
 * JD-Core Version:    0.7.0.1
 */