package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetDeviceLock
  extends d
{
  private long d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  public static void a(dn paramdn, long paramLong, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdn.c.put("param.device.lock.id", Integer.valueOf(paramInt1));
    paramdn.c.put("param.device.lock.guid", paramString1);
    paramdn.c.put("param.device.lock.appid", Integer.valueOf(paramInt2));
    paramdn.c.put("param.device.lock.subappid", Integer.valueOf(paramInt3));
    paramdn.c.put("param.device.lock.appname", paramString2);
    paramdn.c.put("param.wtlogin.a2", paramString3);
    paramdn.c.put("param.common.seq", Integer.valueOf(paramInt4));
  }
  
  protected String a()
  {
    String str = bz.a().b();
    g.c("sessId=" + str);
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
      ((JSONObject)localObject2).put("op_time", (int)(cb.c().s() / 1000L));
      g.a("devicelock data=" + localObject2);
      localObject2 = l.b(((JSONObject)localObject2).toString().getBytes());
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
    g.c("get device lock status url =" + (String)localObject1);
    return localObject1;
  }
  
  protected void a(dn paramdn)
  {
    this.d = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramdn.c.get("param.device.lock.id")).intValue();
    this.i = ((String)paramdn.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramdn.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramdn.c.get("param.device.lock.subappid")).intValue();
    this.j = ((String)paramdn.c.get("param.device.lock.appname"));
    this.k = ((String)paramdn.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramdn.c.get("param.common.seq")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.a("decode json=" + paramJSONObject);
      m = paramJSONObject.getInt("seq_id");
      if (m != this.h)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + m + ",right = " + ca.a().b());
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
          cr.a().d(paramJSONObject);
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
        cr.a().e(paramJSONObject);
      }
      else if ((m == 80) && (paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        m = 0;
        while (m < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
          if (localJSONObject.getInt("id") == 71)
          {
            cr.a().a(localJSONObject);
          }
          else
          {
            int n = localJSONObject.getInt("id");
            if (n == 81)
            {
              break label327;
              g.c("parseJSON error decodeData=" + paramJSONObject);
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