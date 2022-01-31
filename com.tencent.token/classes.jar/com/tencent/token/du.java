package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class du
  extends bm
{
  bb c = bb.a();
  bd d = bd.a();
  private long e;
  private int f;
  private int g;
  private int h;
  private int i;
  private Object j;
  private String k;
  private int l;
  private int m;
  private String n;
  private String o;
  private int p;
  
  public static void a(fs paramfs, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    paramfs.c.put("param.uinhash", Long.valueOf(paramLong));
    paramfs.c.put("param.msg.source", Integer.valueOf(paramInt1));
    paramfs.c.put("param.msg.type", Integer.valueOf(paramInt2));
    paramfs.c.put("param.msg.num", Integer.valueOf(40));
    paramfs.c.put("param.msg.filter", Integer.valueOf(paramInt3));
  }
  
  protected final String a()
  {
    long l1 = ag.c().r();
    long l2 = System.currentTimeMillis();
    if (l1 > l2)
    {
      l2 = l1 / 1000L + 300L;
      ae.a();
      if (!ax.a().p()) {
        break label76;
      }
      ax.a();
    }
    label76:
    for (String str = ax.c;; str = null)
    {
      if (str != null) {
        break label82;
      }
      this.a.a(104, null, null);
      return null;
      l1 = l2;
      break;
    }
    label82:
    l1 = 0L;
    if (this.i != 1) {
      l1 = t.a(this.h, this.e);
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", this.e);
      int i1 = af.a + 1;
      af.a = i1;
      this.p = i1;
      ((JSONObject)localObject1).put("seq_id", this.p);
      ((JSONObject)localObject1).put("op_time", ag.c().r() / 1000L);
      ((JSONObject)localObject1).put("msg_type", this.h);
      ((JSONObject)localObject1).put("req_msg_num", this.g);
      ((JSONObject)localObject1).put("start_time", l1);
      ((JSONObject)localObject1).put("end_time", l2);
      ((JSONObject)localObject1).put("source", l2);
      ((JSONObject)localObject1).put("end_time", l2);
      ((JSONObject)localObject1).put("source", this.f);
      ((JSONObject)localObject1).put("filter_type", this.i);
      ((JSONObject)localObject1).put("filter_type", this.i);
      if ((this.i == 0) && (this.h == 1))
      {
        ((JSONObject)localObject1).put("guid", this.k);
        ((JSONObject)localObject1).put("appid", this.l);
        ((JSONObject)localObject1).put("subappid", this.m);
        ((JSONObject)localObject1).put("appname", this.n);
        ((JSONObject)localObject1).put("A2", this.o);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      e.a("plain:" + (String)localObject1);
      localObject1 = s.b(((String)localObject1).getBytes());
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        e.c("JSONException:" + localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_message_v2" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramfs.c.get("param.msg.source")).intValue();
    this.g = ((Integer)paramfs.c.get("param.msg.num")).intValue();
    this.h = ((Integer)paramfs.c.get("param.msg.type")).intValue();
    this.i = ((Integer)paramfs.c.get("param.msg.filter")).intValue();
    if ((this.i == 0) && (this.h == 1))
    {
      this.k = ((String)paramfs.c.get("param.device.lock.guid"));
      this.l = ((Integer)paramfs.c.get("param.device.lock.appid")).intValue();
      this.m = ((Integer)paramfs.c.get("param.device.lock.subappid")).intValue();
      this.n = ((String)paramfs.c.get("param.device.lock.appname"));
      this.o = ((String)paramfs.c.get("param.skey"));
    }
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i1 = paramJSONObject.getInt("seq_id");
      if (i1 != this.p)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.p);
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      if (l1 != this.e)
      {
        this.a.a(10000, "uin not match=" + l1 + ":" + this.e, null);
        return;
      }
      if (this.h == 1)
      {
        this.c.a(this.e);
        if (this.i == 1)
        {
          this.j = new AbnormalLoginMsgResult(paramJSONObject);
          this.a.a = 0;
          return;
        }
        this.c.b = null;
        if (paramJSONObject.has("devs")) {
          this.c.b = new OnlineDeviceResult(paramJSONObject.getJSONArray("devs"));
        }
        this.a = this.c.f.a(paramJSONObject, l1, this.h);
        return;
      }
      this.d.a(this.e);
      this.a = this.d.f.a(paramJSONObject, l1, this.h);
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.j;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.du
 * JD-Core Version:    0.7.0.1
 */