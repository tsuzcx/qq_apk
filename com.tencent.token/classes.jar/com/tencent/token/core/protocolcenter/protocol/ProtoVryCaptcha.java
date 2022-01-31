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

public class ProtoVryCaptcha
  extends e
{
  private long d;
  private long e;
  private String f;
  private String g;
  private String h = "";
  private int i;
  
  public static void a(ev paramev, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.c.put("param.scene.id", Integer.valueOf(paramInt));
    paramev.c.put("param.scene.id", Integer.valueOf(paramInt));
    paramev.c.put("param.ticket", paramString1);
    paramev.c.put("param.randstr", paramString2);
  }
  
  protected String a()
  {
    Object localObject1 = null;
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int j = cw.a + 1;
      cw.a = j;
      this.i = j;
      ((JSONObject)localObject2).put("seq_id", this.i);
      ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
      ((JSONObject)localObject2).put("scenario_id", this.e);
      ((JSONObject)localObject2).put("ticket", this.f);
      ((JSONObject)localObject2).put("randstr", this.g);
      localObject2 = ((JSONObject)localObject2).toString();
      h.a("plain:" + (String)localObject2);
      localObject2 = w.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    h.c("params: " + (String)localObject1);
    return c.e() + "/cn/mbtoken3/mbtoken3_verify_captcha_v3" + (String)localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramev.c.get("param.scene.id")).intValue();
    this.f = ((String)paramev.c.get("param.ticket"));
    this.g = ((String)paramev.c.get("param.randstr"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      j = paramJSONObject.getInt("seq_id");
      if (j != this.i)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + j + ",right = " + cw.a().b());
        return;
      }
      if (this.e == 5L) {
        this.h = paramJSONObject.getString("captcha_sig");
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
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoVryCaptcha
 * JD-Core Version:    0.7.0.1
 */