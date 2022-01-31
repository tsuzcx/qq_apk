package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
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

public class ProtoDoBindTokenByRealName
  extends e
{
  private long d;
  private int e;
  private int f;
  
  public static void a(ev paramev, long paramLong, int paramInt1, int paramInt2)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.c.put("param.type", Integer.valueOf(paramInt1));
    paramev.j = paramInt2;
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
    localObject = w.a(new Object[] { "real_uin", Long.valueOf(this.d), "imei", cx.b(), "verify_type", Integer.valueOf(this.f), "token_seq", str2, "token_code", ((cx)localObject).o(), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_bind_token_by_realname" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramev.c.get("param.type")).intValue();
    this.e = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.e);
        return;
      }
      long l = paramJSONObject.getLong("server_time");
      cx.c().b(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = w.d(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          cx.c().e();
          cx.c().a(paramJSONObject);
          cx.c().i();
        }
      }
      paramJSONObject = do.a().d(this.d);
      if (paramJSONObject != null) {
        do.a().b(paramJSONObject);
      }
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      h.c("handleSuccess" + this.b.f);
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