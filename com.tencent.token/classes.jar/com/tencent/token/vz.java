package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

public final class vz
  extends tr
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
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.e = ((String)paramabc.c.get("param.device.lock.dguid"));
    this.f = ((String)paramabc.c.get("param.device.lock.ddes"));
    this.g = ((Integer)paramabc.c.get("param.device.lock.dappid")).intValue();
    this.h = ((Integer)paramabc.c.get("param.device.lock.dsubappid")).intValue();
    this.i = ((String)paramabc.c.get("param.device.lock.dappname"));
    this.j = ((String)paramabc.c.get("param.device.lock.guid"));
    this.k = ((Integer)paramabc.c.get("param.device.lock.appid")).intValue();
    this.l = ((Integer)paramabc.c.get("param.device.lock.subappid")).intValue();
    this.m = ((String)paramabc.c.get("param.device.lock.appname"));
    this.n = ((String)paramabc.c.get("param.skey"));
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
      si.a();
      paramJSONObject.append(si.b());
      xj.c(paramJSONObject.toString());
      return;
    }
    rp.a.a().a(this.d, this.g, this.h, this.i, this.e);
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
 * Qualified Name:     com.tencent.token.vz
 * JD-Core Version:    0.7.0.1
 */