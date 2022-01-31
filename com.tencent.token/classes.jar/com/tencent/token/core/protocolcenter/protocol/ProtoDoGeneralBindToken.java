package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoGeneralBindToken
  extends e
{
  private String d;
  private String e;
  private long f;
  private int g;
  private int h;
  private cx i = cx.c();
  private int j;
  
  public static void a(ev paramev, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.c.put("param.type", Integer.valueOf(paramInt));
    paramev.c.put("param.bind.mobile", paramString1);
    paramev.c.put("param.bind.areacode", paramString2);
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = cx.c();
    ((cx)localObject).m();
    String str2 = ((cx)localObject).j().replaceAll("-", "");
    int k = cw.a + 1;
    cw.a = k;
    this.j = k;
    localObject = w.a(new Object[] { "uin", Long.valueOf(this.f), "verify_type_id", String.valueOf(this.g), "token_seq", str2, "mobile", this.d, "area_code", this.e, "token_code", ((cx)localObject).o(), "imei", cx.b(), "seq_id", Integer.valueOf(this.j), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt imei failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_general_bind" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.f = ((Long)paramev.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramev.c.get("param.type")).intValue();
    this.d = ((String)paramev.c.get("param.bind.mobile"));
    this.e = ((String)paramev.c.get("param.bind.areacode"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(k, "server errcode=" + k + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    Object localObject = w.c(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      k = ((JSONObject)localObject).getInt("seq_id");
      if (k != this.j)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + k + ",right = " + cw.a().b());
        return;
      }
      this.h = ((JSONObject)localObject).getInt("bind_mobile_succ");
      if (1 != this.h) {}
      try
      {
        this.a.a(paramJSONObject.getString("info"));
        long l = ((JSONObject)localObject).getLong("server_time");
        cx.c().b(l);
        if (((JSONObject)localObject).getInt("seed_available") == 1)
        {
          paramJSONObject = w.d(((JSONObject)localObject).getString("seed"));
          if (paramJSONObject != null)
          {
            this.i.e();
            this.i.a(paramJSONObject);
            cx.c().i();
          }
        }
        paramJSONObject = do.a().d(this.f);
        if (paramJSONObject != null) {
          do.a().b(paramJSONObject);
        }
        this.a.c();
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    h.c("parseJSON error decodeData=" + localObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
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