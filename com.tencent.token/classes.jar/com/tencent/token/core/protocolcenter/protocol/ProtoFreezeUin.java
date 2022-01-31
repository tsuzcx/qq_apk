package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoFreezeUin
  extends e
{
  private final String d = "/cn/mbtoken3/mbtoken3_freeze_action";
  private long e;
  private int f;
  private int g;
  private String h;
  private int i = -1;
  private int j;
  
  public static void a(ev paramev, long paramLong, int paramInt, String paramString)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.wtlogin.a2", paramString);
    paramev.c.put("param.factor.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int k = cw.a + 1;
    cw.a = k;
    this.f = k;
    String str2 = w.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cx.c().s() / 1000L), "a2_sign", this.h, "sign_qq", Integer.valueOf(this.g) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_freeze_action" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.h = ((String)paramev.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramev.c.get("param.factor.type")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      a(k, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      k = paramJSONObject.getInt("seq_id");
      if (k != this.f)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + k + ",right = " + cw.a().b());
        return;
      }
      h.a("freeze result = " + paramJSONObject);
      try
      {
        this.i = paramJSONObject.getInt("sign_status");
        this.j = paramJSONObject.getInt("auto_melt_time");
        this.a.c();
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.i;
      localMessage.obj = Integer.valueOf(this.j);
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFreezeUin
 * JD-Core Version:    0.7.0.1
 */