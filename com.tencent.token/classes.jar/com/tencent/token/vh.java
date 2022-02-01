package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.AbnormalLoginMsgResult;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class vh
  extends tk
{
  tc d;
  te e;
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
  
  public final String a()
  {
    sc.b().i();
    System.currentTimeMillis();
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.f = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramaar.c.get("param.msg.source")).intValue();
    this.h = ((Integer)paramaar.c.get("param.msg.num")).intValue();
    this.i = ((Integer)paramaar.c.get("param.msg.type")).intValue();
    this.j = ((Integer)paramaar.c.get("param.msg.filter")).intValue();
    if ((this.j == 0) && (this.i == 1))
    {
      this.l = ((String)paramaar.c.get("param.device.lock.guid"));
      this.m = ((Integer)paramaar.c.get("param.device.lock.appid")).intValue();
      this.n = ((Integer)paramaar.c.get("param.device.lock.subappid")).intValue();
      this.o = ((String)paramaar.c.get("param.device.lock.appname"));
      this.p = ((String)paramaar.c.get("param.skey"));
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.getInt("err");
    if (i1 != 0)
    {
      a(i1, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i1 = paramJSONObject.getInt("seq_id");
      if (i1 != this.q)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i1);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.q);
        xb.c(paramJSONObject.toString());
        return;
      }
      long l1 = paramJSONObject.getLong("uin");
      long l2 = this.f;
      Object localObject;
      if (l1 != l2)
      {
        paramJSONObject = this.a;
        localObject = new StringBuilder("uin not match=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.f);
        paramJSONObject.a(10000, ((StringBuilder)localObject).toString(), null);
        return;
      }
      if (this.i == 1)
      {
        this.d.a(l2);
        if (this.j == 1)
        {
          this.k = new AbnormalLoginMsgResult(paramJSONObject);
          this.a.a = 0;
          return;
        }
        this.d.b = null;
        localObject = new ArrayList();
        if (paramJSONObject.has("devs"))
        {
          OnlineDeviceResult localOnlineDeviceResult = new OnlineDeviceResult(paramJSONObject.getJSONArray("devs"));
          if (localOnlineDeviceResult.mDevicesList != null) {
            ((ArrayList)localObject).addAll(localOnlineDeviceResult.mDevicesList);
          }
          this.d.b = new OnlineDeviceResult(paramJSONObject.getJSONArray("devs"));
        }
        ri.a.a().a(this.f, (List)localObject);
        this.a = this.d.f.a(paramJSONObject, l1, this.i);
        return;
      }
      this.e.a(l2);
      this.a = this.e.f.a(paramJSONObject, l1, this.i);
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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
 * Qualified Name:     com.tencent.token.vh
 * JD-Core Version:    0.7.0.1
 */