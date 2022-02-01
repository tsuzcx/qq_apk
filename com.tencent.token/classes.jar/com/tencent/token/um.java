package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class um
  extends ud
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
    st.a();
    StringBuilder localStringBuilder = new StringBuilder("sessId=");
    localStringBuilder.append(null);
    xv.c(localStringBuilder.toString());
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.k = ((String)paramabm.c.get("param.device.lock.dguid"));
    this.l = ((String)paramabm.c.get("param.device.lock.ddes"));
    this.h = ((Integer)paramabm.c.get("param.device.lock.dappid")).intValue();
    this.i = ((Integer)paramabm.c.get("param.device.lock.dsubappid")).intValue();
    this.p = ((String)paramabm.c.get("param.device.lock.dappname"));
    this.e = ((Integer)paramabm.c.get("param.device.lock.id")).intValue();
    this.m = ((String)paramabm.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramabm.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramabm.c.get("param.device.lock.subappid")).intValue();
    this.n = ((String)paramabm.c.get("param.device.lock.appname"));
    this.o = ((String)paramabm.c.get("param.wtlogin.a2"));
    this.j = ((Integer)paramabm.c.get("param.common.seq")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      i1 = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (i1 != this.j)
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
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
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
 * Qualified Name:     com.tencent.token.um
 * JD-Core Version:    0.7.0.1
 */