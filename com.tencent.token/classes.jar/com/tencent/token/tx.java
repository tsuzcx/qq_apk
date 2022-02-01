package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class tx
  extends tj
{
  private String d;
  private String e;
  private long f;
  private int g;
  private int h;
  private sb i;
  private int j;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.f = ((Long)paramaaq.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramaaq.c.get("param.bind.type")).intValue();
    this.d = ((String)paramaaq.c.get("param.bind.mobile"));
    this.e = ((String)paramaaq.c.get("param.bind.areacode"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(k);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((wy)localObject).a(k, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    Object localObject = aac.d(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      k = ((JSONObject)localObject).getInt("seq_id");
      if (k != this.j)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        sa.a();
        paramJSONObject.append(sa.b());
        xa.c(paramJSONObject.toString());
        return;
      }
      this.h = ((JSONObject)localObject).getInt("bind_mobile_succ");
      if (1 != this.h) {
        try
        {
          this.a.a(paramJSONObject.getString("info"));
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
      long l = ((JSONObject)localObject).getLong("server_time");
      sb.b();
      sb.a(l);
      if (((JSONObject)localObject).getInt("seed_available") == 1)
      {
        paramJSONObject = aac.e(((JSONObject)localObject).getString("seed"));
        if (paramJSONObject != null)
        {
          this.i.c();
          this.i.a(paramJSONObject);
          sb.b().a.a();
        }
      }
      paramJSONObject = sz.a().d(this.f);
      if (paramJSONObject != null) {
        sz.a().a(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(localObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.a;
      localMessage.arg2 = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tx
 * JD-Core Version:    0.7.0.1
 */