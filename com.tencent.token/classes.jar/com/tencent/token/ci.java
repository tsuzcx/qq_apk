package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class ci
  extends bm
{
  private long c;
  private int d;
  private int e;
  
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
    localObject = s.a(new Object[] { "real_uin", Long.valueOf(this.c), "imei", ag.b(), "verify_type", Integer.valueOf(this.e), "token_seq", str2, "token_code", ((ag)localObject).o(), "seq_id", Integer.valueOf(this.d), "op_time", Long.valueOf(ag.c().r() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_bind_token_by_realname" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramfs.c.get("param.type")).intValue();
    this.d = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.d);
        return;
      }
      long l = paramJSONObject.getLong("server_time");
      ag.c();
      ag.b(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = s.e(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          ag.c().e();
          ag.c().a(paramJSONObject);
          ag.c().i();
        }
      }
      paramJSONObject = ax.a().d(this.c);
      if (paramJSONObject != null) {
        ax.a().b(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      e.c("handleSuccess" + this.b.f);
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ci
 * JD-Core Version:    0.7.0.1
 */