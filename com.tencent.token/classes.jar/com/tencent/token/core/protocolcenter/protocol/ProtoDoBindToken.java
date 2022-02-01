package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoBindToken
  extends d
{
  private String d;
  private String e;
  private long f;
  private int g;
  private int h;
  private cd i = cd.c();
  private int j;
  
  public static void a(dp paramdp, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.c.put("param.bind.type", Integer.valueOf(paramInt));
    paramdp.c.put("param.bind.mobile", paramString1);
    paramdp.c.put("param.bind.areacode", paramString2);
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = cd.c();
    ((cd)localObject1).m();
    Object localObject2 = ((cd)localObject1).j().replaceAll("-", "");
    int k = cc.a + 1;
    cc.a = k;
    this.j = k;
    localObject1 = l.a(new Object[] { "seq_id", Integer.valueOf(this.j), "op_time", Long.valueOf(cd.c().s() / 1000L), "uin", Long.valueOf(this.f), "mobile", this.d, "area_code", URLEncoder.encode(this.e), "imei", cd.b(), "token_seq", localObject2, "token_code", ((cd)localObject1).o(), "bind_type", String.valueOf(this.g) });
    if (localObject1 == null)
    {
      this.a.a(10000, "encrypt imei failed");
      return null;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("?aq_base_sid=");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("&data=");
    ((StringBuilder)localObject2).append((String)localObject1);
    str = ((StringBuilder)localObject2).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(c.e());
    ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_bind_token_by_app_v3");
    ((StringBuilder)localObject1).append(str);
    return ((StringBuilder)localObject1).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.f = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramdp.c.get("param.bind.type")).intValue();
    this.d = ((String)paramdp.c.get("param.bind.mobile"));
    this.e = ((String)paramdp.c.get("param.bind.areacode"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(k);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((e)localObject).a(k, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    Object localObject = l.c(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      k = ((JSONObject)localObject).getInt("seq_id");
      if (k != this.j)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(cc.a().b());
        g.c(paramJSONObject.toString());
        return;
      }
      this.h = ((JSONObject)localObject).getInt("bind_mobile_succ");
      if (1 != this.h) {
        try
        {
          this.a.a(paramJSONObject.getString("info"));
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
      long l = ((JSONObject)localObject).getLong("server_time");
      cd.c().b(l);
      if (((JSONObject)localObject).getInt("seed_available") == 1)
      {
        paramJSONObject = l.d(((JSONObject)localObject).getString("seed"));
        if (paramJSONObject != null)
        {
          this.i.e();
          this.i.a(paramJSONObject);
          cd.c().i();
        }
      }
      paramJSONObject = cs.a().d(this.f);
      if (paramJSONObject != null) {
        cs.a().b(paramJSONObject);
      }
      this.a.c();
      return;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("parseJSON error decodeData=");
    paramJSONObject.append(localObject);
    g.c(paramJSONObject.toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.a;
      localMessage.arg2 = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoBindToken
 * JD-Core Version:    0.7.0.1
 */