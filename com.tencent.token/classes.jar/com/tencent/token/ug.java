package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ug
  extends tr
{
  private long d;
  private int e;
  private int f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramabc.c.get("param.type")).intValue();
    this.e = paramabc.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.e);
        xj.c(paramJSONObject.toString());
        return;
      }
      long l = paramJSONObject.getLong("server_time");
      sj.b();
      sj.a(l);
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = aao.e(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          sj.b().c();
          sj.b().a(paramJSONObject);
          sj.b().a.a();
        }
      }
      paramJSONObject = th.a().d(this.d);
      if (paramJSONObject != null) {
        th.a().a(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Object localObject = new StringBuilder("handleSuccess");
      ((StringBuilder)localObject).append(this.b.f);
      xj.c(((StringBuilder)localObject).toString());
      localObject = this.b.d.obtainMessage(this.b.f);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ug
 * JD-Core Version:    0.7.0.1
 */