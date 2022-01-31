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
import org.json.JSONException;
import org.json.JSONObject;

public final class cd
  extends bm
{
  private long c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c;; str = null)
    {
      e.c("sessId=" + str);
      if (str != null) {
        break;
      }
      this.a.a(104, null, null);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("dguid", this.j);
      ((JSONObject)localObject2).put("ddes", this.k);
      ((JSONObject)localObject2).put("dappid", this.g);
      ((JSONObject)localObject2).put("dsubappid", this.h);
      ((JSONObject)localObject2).put("dappname", this.o);
      ((JSONObject)localObject2).put("id", this.d);
      ((JSONObject)localObject2).put("guid", this.l);
      ((JSONObject)localObject2).put("appid", this.e);
      ((JSONObject)localObject2).put("subappid", this.f);
      ((JSONObject)localObject2).put("appname", this.m);
      ((JSONObject)localObject2).put("A2", this.n);
      ((JSONObject)localObject2).put("seq_id", this.i);
      ((JSONObject)localObject2).put("op_time", (int)(ag.c().r() / 1000L));
      localObject2 = s.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    str = "?uin=" + this.c + "&aq_base_sid=" + str + "&data=" + (String)localObject1;
    str = b.c() + "/cn/mbtoken3/mbtoken3_device_lock_del_device_v2" + str;
    e.c("del device url =" + str);
    return str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.j = ((String)paramfs.c.get("param.device.lock.dguid"));
    this.k = ((String)paramfs.c.get("param.device.lock.ddes"));
    this.g = ((Integer)paramfs.c.get("param.device.lock.dappid")).intValue();
    this.h = ((Integer)paramfs.c.get("param.device.lock.dsubappid")).intValue();
    this.o = ((String)paramfs.c.get("param.device.lock.dappname"));
    this.d = ((Integer)paramfs.c.get("param.device.lock.id")).intValue();
    this.l = ((String)paramfs.c.get("param.device.lock.guid"));
    this.e = ((Integer)paramfs.c.get("param.device.lock.appid")).intValue();
    this.f = ((Integer)paramfs.c.get("param.device.lock.subappid")).intValue();
    this.m = ((String)paramfs.c.get("param.device.lock.appname"));
    this.n = ((String)paramfs.c.get("param.wtlogin.a2"));
    this.i = ((Integer)paramfs.c.get("param.common.seq")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i1 = paramJSONObject.getInt("seq_id");
      if (i1 != this.i)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder().append("parseJSON error seq is wrong seq=").append(i1).append(",right = ");
        af.a();
        e.c(af.b());
        return;
      }
      i1 = paramJSONObject.getInt("err");
      if (i1 != 0)
      {
        a(i1, paramJSONObject.getString("info"));
        return;
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
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cd
 * JD-Core Version:    0.7.0.1
 */