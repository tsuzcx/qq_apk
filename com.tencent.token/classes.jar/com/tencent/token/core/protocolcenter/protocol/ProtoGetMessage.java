package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.cu;
import com.tencent.token.dj;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetMessage
  extends d
{
  cs d = cs.a();
  cu e = cu.a();
  private long f;
  private int g;
  private int h;
  private int i;
  private int j;
  private Object k;
  private String l;
  private int m;
  private int n;
  private String o;
  private String p;
  private int q;
  
  public static void a(dn paramdn, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdn.c.put("param.msg.source", Integer.valueOf(paramInt1));
    paramdn.c.put("param.msg.type", Integer.valueOf(paramInt2));
    paramdn.c.put("param.msg.num", Integer.valueOf(paramInt4));
    paramdn.c.put("param.msg.filter", Integer.valueOf(paramInt3));
  }
  
  public static void a(dn paramdn, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, int paramInt6, String paramString2, String paramString3)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdn.c.put("param.msg.source", Integer.valueOf(paramInt1));
    paramdn.c.put("param.msg.type", Integer.valueOf(paramInt2));
    paramdn.c.put("param.msg.num", Integer.valueOf(paramInt4));
    paramdn.c.put("param.msg.filter", Integer.valueOf(paramInt3));
    paramdn.c.put("param.device.lock.guid", paramString1);
    paramdn.c.put("param.device.lock.appid", Integer.valueOf(paramInt5));
    paramdn.c.put("param.device.lock.subappid", Integer.valueOf(paramInt6));
    paramdn.c.put("param.device.lock.appname", paramString2);
    paramdn.c.put("param.skey", paramString3);
  }
  
  protected String a()
  {
    long l1 = cb.c().s();
    long l2 = System.currentTimeMillis();
    if (l1 > l2) {}
    String str;
    for (;;)
    {
      l2 = 300L + l1 / 1000L;
      str = bz.a().b();
      if (str != null) {
        break;
      }
      this.a.b(104);
      return null;
      l1 = l2;
    }
    l1 = 0L;
    if (this.j != 1) {
      l1 = m.a(this.i, this.f);
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", this.f);
      int i1 = ca.a + 1;
      ca.a = i1;
      this.q = i1;
      ((JSONObject)localObject1).put("seq_id", this.q);
      ((JSONObject)localObject1).put("op_time", cb.c().s() / 1000L);
      ((JSONObject)localObject1).put("msg_type", this.i);
      ((JSONObject)localObject1).put("req_msg_num", this.h);
      ((JSONObject)localObject1).put("start_time", l1);
      ((JSONObject)localObject1).put("end_time", l2);
      ((JSONObject)localObject1).put("source", l2);
      ((JSONObject)localObject1).put("end_time", l2);
      ((JSONObject)localObject1).put("source", this.g);
      ((JSONObject)localObject1).put("filter_type", this.j);
      ((JSONObject)localObject1).put("filter_type", this.j);
      if ((this.j == 0) && (this.i == 1))
      {
        ((JSONObject)localObject1).put("guid", this.l);
        ((JSONObject)localObject1).put("appid", this.m);
        ((JSONObject)localObject1).put("subappid", this.n);
        ((JSONObject)localObject1).put("appname", this.o);
        ((JSONObject)localObject1).put("A2", this.p);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      g.a("plain:" + (String)localObject1);
      localObject1 = l.b(((String)localObject1).getBytes());
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        g.c("JSONException:" + localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_message_v2" + (String)localObject1;
  }
  
  protected void a(dn paramdn)
  {
    this.f = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramdn.c.get("param.msg.source")).intValue();
    this.h = ((Integer)paramdn.c.get("param.msg.num")).intValue();
    this.i = ((Integer)paramdn.c.get("param.msg.type")).intValue();
    this.j = ((Integer)paramdn.c.get("param.msg.filter")).intValue();
    if ((this.j == 0) && (this.i == 1))
    {
      this.l = ((String)paramdn.c.get("param.device.lock.guid"));
      this.m = ((Integer)paramdn.c.get("param.device.lock.appid")).intValue();
      this.n = ((Integer)paramdn.c.get("param.device.lock.subappid")).intValue();
      this.o = ((String)paramdn.c.get("param.device.lock.appname"));
      this.p = ((String)paramdn.c.get("param.skey"));
    }
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
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i1 = paramJSONObject.getInt("seq_id");
      if (i1 != this.q)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.q);
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      if (l1 != this.f)
      {
        this.a.a(10000, "uin not match=" + l1 + ":" + this.f);
        return;
      }
      if (this.i == 1)
      {
        this.d.a(this.f);
        if (this.j == 1)
        {
          this.k = new AbnormalLoginMsgResult(paramJSONObject);
          this.a.c();
          return;
        }
        this.d.b = null;
        if (paramJSONObject.has("devs")) {
          this.d.b = new OnlineDeviceResult(paramJSONObject.getJSONArray("devs"));
        }
        this.a = this.d.f.a(paramJSONObject, l1, this.i);
        return;
      }
      this.e.a(this.f);
      this.a = this.e.f.a(paramJSONObject, l1, this.i);
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.k;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetMessage
 * JD-Core Version:    0.7.0.1
 */