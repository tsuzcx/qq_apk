package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cp;
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

public class ProtoSetMbMobile
  extends e
{
  private long d;
  private String e;
  private String f;
  private String g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  public static void a(ev paramev, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.mbmobile.set", Integer.valueOf(paramInt));
    paramev.c.put("param.mbmobile.mobile", paramString1);
    paramev.c.put("param.mbmoible.areacode", paramString2);
    paramev.c.put("param.wtlogin.a2", paramString3);
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("op_type", this.h);
      ((JSONObject)localObject).put("uin", this.d);
      ((JSONObject)localObject).put("new_mobile", this.i);
      ((JSONObject)localObject).put("area_code", this.j);
      ((JSONObject)localObject).put("A2", this.k);
      ((JSONObject)localObject).put("guid", w.a(cp.a(RqdApplication.l()).b()));
      int m = cw.a + 1;
      cw.a = m;
      this.c = m;
      ((JSONObject)localObject).put("seq_id", this.c);
      ((JSONObject)localObject).put("op_time", (int)(cx.c().s() / 1000L));
      localObject = w.b(((JSONObject)localObject).toString().getBytes());
      if (localObject == null)
      {
        this.a.b(10000);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.a.b(10000);
      return null;
    }
    finally
    {
      if (w.b(((JSONObject)localObject).toString().getBytes()) == null)
      {
        this.a.b(10000);
        return null;
      }
    }
    localObject = "?aq_base_sid=" + str2 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_set_mod_mobile_encrypt" + (String)localObject;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.h = ((Integer)paramev.c.get("param.mbmobile.set")).intValue();
    this.i = ((String)paramev.c.get("param.mbmobile.mobile"));
    this.j = ((String)paramev.c.get("param.mbmoible.areacode"));
    this.k = ((String)paramev.c.get("param.wtlogin.a2"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m == 0)
    {
      paramJSONObject = w.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        if (paramJSONObject.getInt("seq_id") != this.c)
        {
          a(10000, RqdApplication.l().getString(2131230925));
          return;
        }
        this.a.c();
        this.f = paramJSONObject.getString("time1");
        this.g = paramJSONObject.getString("time2");
        this.e = paramJSONObject.optString("extraInfo");
        return;
      }
      h.c("parseJSON error decodeData=" + paramJSONObject);
      this.a.a(10022, RqdApplication.l().getString(2131230925), RqdApplication.l().getString(2131230925));
      return;
    }
    paramJSONObject = paramJSONObject.getString("info");
    this.e = paramJSONObject;
    a(m, paramJSONObject);
  }
  
  protected void b()
  {
    Message localMessage;
    JSONObject localJSONObject;
    if (!this.b.e)
    {
      localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("info", this.e);
      localJSONObject.put("time1", this.f);
      localJSONObject.put("time2", this.g);
      localMessage.obj = localJSONObject;
      localMessage.sendToTarget();
      this.b.e = true;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoSetMbMobile
 * JD-Core Version:    0.7.0.1
 */