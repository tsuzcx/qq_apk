package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.dr;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetDeviceLock
  extends e
{
  private long d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  public static void a(ev paramev, long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.device.lock.id", Integer.valueOf(paramInt1));
    paramev.c.put("param.device.lock.guid", paramString1);
    paramev.c.put("param.device.lock.appid", Integer.valueOf(paramInt2));
    paramev.c.put("param.device.lock.subappid", Integer.valueOf(paramInt3));
    paramev.c.put("param.device.lock.appname", paramString2);
    paramev.c.put("param.wtlogin.a2", paramString3);
    paramev.c.put("param.common.seq", Integer.valueOf(paramInt4));
  }
  
  protected String a()
  {
    String str = cv.a().b();
    h.c("sessId=" + str);
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      ((JSONObject)localObject2).put("id", this.e);
      ((JSONObject)localObject2).put("guid", this.i);
      ((JSONObject)localObject2).put("appid", this.f);
      ((JSONObject)localObject2).put("subappid", this.g);
      ((JSONObject)localObject2).put("appname", this.j);
      ((JSONObject)localObject2).put("A2", this.k);
      ((JSONObject)localObject2).put("seq_id", this.h);
      ((JSONObject)localObject2).put("op_time", (int)(cx.c().s() / 1000L));
      h.a("devicelock data=" + localObject2);
      localObject2 = w.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_get_device_lock_status_encrypt" + (String)localObject1;
    h.c("get device lock status url =" + (String)localObject1);
    return localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramev.c.get("param.device.lock.id")).intValue();
    this.i = ((String)paramev.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramev.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramev.c.get("param.device.lock.subappid")).intValue();
    this.j = ((String)paramev.c.get("param.device.lock.appname"));
    this.k = ((String)paramev.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramev.c.get("param.common.seq")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.a("decode json=" + paramJSONObject);
      m = paramJSONObject.getInt("seq_id");
      if (m != this.h)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + m + ",right = " + cw.a().b());
        return;
      }
    }
    for (;;)
    {
      try
      {
        m = paramJSONObject.getInt("id");
        paramJSONObject = paramJSONObject.getJSONArray("result");
        if (m == 70)
        {
          dr.a().d(paramJSONObject);
          this.a.c();
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        a(201, RqdApplication.l().getString(2131230767));
        paramJSONObject.printStackTrace();
        return;
      }
      if (m == 71)
      {
        dr.a().e(paramJSONObject);
      }
      else if ((m == 80) && (paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        m = 0;
        while (m < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
          if (localJSONObject.getInt("id") == 71)
          {
            dr.a().a(localJSONObject);
          }
          else
          {
            int n = localJSONObject.getInt("id");
            if (n == 81)
            {
              break label327;
              h.c("parseJSON error decodeData=" + paramJSONObject);
              a(10022, RqdApplication.l().getString(2131230925));
              return;
            }
          }
          label327:
          m += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetDeviceLock
 * JD-Core Version:    0.7.0.1
 */