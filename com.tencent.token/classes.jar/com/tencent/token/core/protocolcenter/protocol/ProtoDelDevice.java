package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoDelDevice
  extends d
{
  private long d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  
  public static void a(do paramdo, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, int paramInt6)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.device.lock.dguid", paramString1);
    paramdo.c.put("param.device.lock.ddes", paramString2);
    paramdo.c.put("param.device.lock.dappid", Integer.valueOf(paramInt1));
    paramdo.c.put("param.device.lock.dsubappid", Integer.valueOf(paramInt2));
    paramdo.c.put("param.device.lock.dappname", paramString3);
    paramdo.c.put("param.device.lock.id", Integer.valueOf(paramInt3));
    paramdo.c.put("param.device.lock.guid", paramString4);
    paramdo.c.put("param.device.lock.appid", Integer.valueOf(paramInt4));
    paramdo.c.put("param.device.lock.subappid", Integer.valueOf(paramInt5));
    paramdo.c.put("param.device.lock.appname", paramString5);
    paramdo.c.put("param.wtlogin.a2", paramString6);
    paramdo.c.put("param.common.seq", Integer.valueOf(paramInt6));
  }
  
  protected String a()
  {
    String str = ca.a().b();
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
      ((JSONObject)localObject2).put("dguid", this.k);
      ((JSONObject)localObject2).put("ddes", this.l);
      ((JSONObject)localObject2).put("dappid", this.h);
      ((JSONObject)localObject2).put("dsubappid", this.i);
      ((JSONObject)localObject2).put("dappname", this.p);
      ((JSONObject)localObject2).put("id", this.e);
      ((JSONObject)localObject2).put("guid", this.m);
      ((JSONObject)localObject2).put("appid", this.f);
      ((JSONObject)localObject2).put("subappid", this.g);
      ((JSONObject)localObject2).put("appname", this.n);
      ((JSONObject)localObject2).put("A2", this.o);
      ((JSONObject)localObject2).put("uin", this.d);
      ((JSONObject)localObject2).put("seq_id", this.j);
      ((JSONObject)localObject2).put("op_time", (int)(cc.c().s() / 1000L));
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
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_device_lock_del_device_encrypt" + (String)localObject1;
    g.c("del device url =" + (String)localObject1);
    return localObject1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.k = ((String)paramdo.c.get("param.device.lock.dguid"));
    this.l = ((String)paramdo.c.get("param.device.lock.ddes"));
    this.h = ((Integer)paramdo.c.get("param.device.lock.dappid")).intValue();
    this.i = ((Integer)paramdo.c.get("param.device.lock.dsubappid")).intValue();
    this.p = ((String)paramdo.c.get("param.device.lock.dappname"));
    this.e = ((Integer)paramdo.c.get("param.device.lock.id")).intValue();
    this.m = ((String)paramdo.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramdo.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramdo.c.get("param.device.lock.subappid")).intValue();
    this.n = ((String)paramdo.c.get("param.device.lock.appname"));
    this.o = ((String)paramdo.c.get("param.wtlogin.a2"));
    this.j = ((Integer)paramdo.c.get("param.common.seq")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      i1 = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (i1 != this.j)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + cb.a().b());
        return;
      }
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDelDevice
 * JD-Core Version:    0.7.0.1
 */