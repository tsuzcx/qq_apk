package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ch
  extends bm
{
  private String c;
  private String d;
  private long e;
  private int f;
  private int g;
  private ag h = ag.c();
  private int i;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject = ag.c();
    ((ag)localObject).m();
    String str2 = ((ag)localObject).j().replaceAll("-", "");
    int j = af.a + 1;
    af.a = j;
    this.i = j;
    localObject = s.a(new Object[] { "seq_id", Integer.valueOf(this.i), "op_time", Long.valueOf(ag.c().r() / 1000L), "uin", Long.valueOf(this.e), "mobile", this.c, "area_code", URLEncoder.encode(this.d), "imei", ag.b(), "token_seq", str2, "token_code", ((ag)localObject).o(), "bind_type", String.valueOf(this.f) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt imei failed", null);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_bind_token_by_app_v3" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramfs.c.get("param.bind.type")).intValue();
    this.c = ((String)paramfs.c.get("param.bind.mobile"));
    this.d = ((String)paramfs.c.get("param.bind.areacode"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(j, "server errcode=" + j + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    Object localObject = s.d(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      j = ((JSONObject)localObject).getInt("seq_id");
      if (j != this.i)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(j).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      this.g = ((JSONObject)localObject).getInt("bind_mobile_succ");
      if (1 != this.g) {}
      try
      {
        d locald = this.a;
        paramJSONObject = paramJSONObject.getString("info");
        locald.a = 0;
        locald.c = paramJSONObject;
        long l = ((JSONObject)localObject).getLong("server_time");
        ag.c();
        ag.b(l);
        if (((JSONObject)localObject).getInt("seed_available") == 1)
        {
          paramJSONObject = s.e(((JSONObject)localObject).getString("seed"));
          if (paramJSONObject != null)
          {
            this.h.e();
            this.h.a(paramJSONObject);
            ag.c().i();
          }
        }
        paramJSONObject = ax.a().d(this.e);
        if (paramJSONObject != null) {
          ax.a().b(paramJSONObject);
        }
        this.a.a = 0;
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
    e.c("parseJSON error decodeData=" + localObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.a;
      localMessage.arg2 = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ch
 * JD-Core Version:    0.7.0.1
 */