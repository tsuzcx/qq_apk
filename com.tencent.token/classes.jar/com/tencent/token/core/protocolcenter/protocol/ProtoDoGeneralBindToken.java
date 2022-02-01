package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
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
  private cc i = cc.c();
  private int j;
  
  public static void a(do paramdo, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.type", Integer.valueOf(paramInt));
    paramdo.c.put("param.bind.mobile", paramString1);
    paramdo.c.put("param.bind.areacode", paramString2);
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
    int k = cb.a + 1;
    cb.a = k;
    this.j = k;
    TmsLog.i("mod_seed", "call bind, token_seq: " + str2 + " tokenCodeStr: " + ((cc)localObject).o());
    localObject = l.a(new Object[] { "uin", Long.valueOf(this.f), "verify_type_id", String.valueOf(this.g), "token_seq", str2, "mobile", this.d, "area_code", this.e, "token_code", ((cc)localObject).o(), "imei", cc.b(), "seq_id", Integer.valueOf(this.j), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt imei failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_general_bind" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.f = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramdo.c.get("param.type")).intValue();
    this.d = ((String)paramdo.c.get("param.bind.mobile"));
    this.e = ((String)paramdo.c.get("param.bind.areacode"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    TmsLog.i("mod_seed", "ProtoDoGeneralBindToken, errcode: " + k);
    if (k != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(k, "server errcode=" + k + ":" + paramJSONObject, paramJSONObject);
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
        g.c("parseJSON error seq is wrong seq=" + k + ",right = " + cb.a().b());
        return;
      }
      this.h = ((JSONObject)localObject).getInt("bind_mobile_succ");
      if (1 != this.h) {}
      try
      {
        this.a.a(paramJSONObject.getString("info"));
        l = ((JSONObject)localObject).getLong("server_time");
        cc.c().b(l);
      }
      catch (Exception paramJSONObject)
      {
        try
        {
          long l = ((JSONObject)localObject).getLong("seed_expire_time");
          cc.c().c(l);
          paramJSONObject = cr.a().d(this.f);
          if (paramJSONObject != null) {
            cr.a().b(paramJSONObject);
          }
          this.a.c();
          return;
          paramJSONObject = paramJSONObject;
          paramJSONObject.printStackTrace();
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject.printStackTrace();
          }
        }
      }
    }
    g.c("parseJSON error decodeData=" + localObject);
    a(10022, RqdApplication.l().getString(2131230925));
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