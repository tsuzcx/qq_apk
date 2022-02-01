package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

public final class wl
  extends ud
{
  private long d;
  private String e;
  private String f;
  private int g;
  private int h;
  private String i;
  private String j;
  private int k;
  private int l;
  private String m;
  private String n;
  private int o;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.e = ((String)paramabm.c.get("param.device.lock.dguid"));
    this.f = ((String)paramabm.c.get("param.device.lock.ddes"));
    this.g = ((Integer)paramabm.c.get("param.device.lock.dappid")).intValue();
    this.h = ((Integer)paramabm.c.get("param.device.lock.dsubappid")).intValue();
    this.i = ((String)paramabm.c.get("param.device.lock.dappname"));
    this.j = ((String)paramabm.c.get("param.device.lock.guid"));
    this.k = ((Integer)paramabm.c.get("param.device.lock.appid")).intValue();
    this.l = ((Integer)paramabm.c.get("param.device.lock.subappid")).intValue();
    this.m = ((String)paramabm.c.get("param.device.lock.appname"));
    this.n = ((String)paramabm.c.get("param.skey"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    i1 = paramJSONObject.getInt("seq_id");
    if (i1 != this.o)
    {
      this.a.a(10030, null, null);
      paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
      paramJSONObject.append(i1);
      paramJSONObject.append(",right = ");
      su.a();
      paramJSONObject.append(su.b());
      xv.c(paramJSONObject.toString());
      return;
    }
    sc.a.a().a(this.d, this.g, this.h, this.i, this.e);
    this.a.a = 0;
  }
  
  public final void b()
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
 * Qualified Name:     com.tencent.token.wl
 * JD-Core Version:    0.7.0.1
 */