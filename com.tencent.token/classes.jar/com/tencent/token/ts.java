package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ts
  extends tj
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
  
  public final String a()
  {
    rz.a();
    StringBuilder localStringBuilder = new StringBuilder("sessId=");
    localStringBuilder.append(null);
    xa.c(localStringBuilder.toString());
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = ((Long)paramaaq.c.get("param.uinhash")).longValue();
    this.k = ((String)paramaaq.c.get("param.device.lock.dguid"));
    this.l = ((String)paramaaq.c.get("param.device.lock.ddes"));
    this.h = ((Integer)paramaaq.c.get("param.device.lock.dappid")).intValue();
    this.i = ((Integer)paramaaq.c.get("param.device.lock.dsubappid")).intValue();
    this.p = ((String)paramaaq.c.get("param.device.lock.dappname"));
    this.e = ((Integer)paramaaq.c.get("param.device.lock.id")).intValue();
    this.m = ((String)paramaaq.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramaaq.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramaaq.c.get("param.device.lock.subappid")).intValue();
    this.n = ((String)paramaaq.c.get("param.device.lock.appname"));
    this.o = ((String)paramaaq.c.get("param.wtlogin.a2"));
    this.j = ((Integer)paramaaq.c.get("param.common.seq")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      i1 = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (i1 != this.j)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i1);
        paramJSONObject.append(",right = ");
        sa.a();
        paramJSONObject.append(sa.b());
        xa.c(paramJSONObject.toString());
        return;
      }
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
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
 * Qualified Name:     com.tencent.token.ts
 * JD-Core Version:    0.7.0.1
 */