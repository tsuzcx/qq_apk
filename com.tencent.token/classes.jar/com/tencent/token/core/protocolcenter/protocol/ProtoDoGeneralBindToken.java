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
import com.tmsdk.common.util.TmsLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDoGeneralBindToken
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
    paramdp.c.put("param.type", Integer.valueOf(paramInt));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call bind, token_seq: ");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(" tokenCodeStr: ");
    localStringBuilder.append(((cd)localObject1).o());
    TmsLog.i("mod_seed", localStringBuilder.toString());
    localObject1 = l.a(new Object[] { "uin", Long.valueOf(this.f), "verify_type_id", String.valueOf(this.g), "token_seq", localObject2, "mobile", this.d, "area_code", this.e, "token_code", ((cd)localObject1).o(), "imei", cd.b(), "seq_id", Integer.valueOf(this.j), "op_time", Long.valueOf(cd.c().s() / 1000L) });
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
    ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_general_bind");
    ((StringBuilder)localObject1).append(str);
    return ((StringBuilder)localObject1).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.f = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramdp.c.get("param.type")).intValue();
    this.d = ((String)paramdp.c.get("param.bind.mobile"));
    this.e = ((String)paramdp.c.get("param.bind.areacode"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ProtoDoGeneralBindToken, errcode: ");
    ((StringBuilder)localObject).append(k);
    TmsLog.i("mod_seed", ((StringBuilder)localObject).toString());
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
    localObject = l.c(paramJSONObject.getString("data"));
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
      try
      {
        l = ((JSONObject)localObject).getLong("seed_expire_time");
        cd.c().c(l);
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoGeneralBindToken
 * JD-Core Version:    0.7.0.1
 */