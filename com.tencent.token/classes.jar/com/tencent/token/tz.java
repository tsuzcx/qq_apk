package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class tz
  extends tj
{
  private long d;
  private int e;
  private String f;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = ((Long)paramaaq.c.get("param.realuin")).longValue();
    this.e = paramaaq.j;
    this.f = ((String)paramaaq.c.get("param.bind.areacode"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
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
        xa.c(paramJSONObject.toString());
        return;
      }
      long l = paramJSONObject.getLong("server_time");
      sb.b();
      sb.a(l);
      try
      {
        l = paramJSONObject.getLong("seed_expire_time");
        sb.b();
        sb.b(l);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = aac.e(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          sb.b().c();
          sb.b().a(paramJSONObject);
          sb.b().a.a();
        }
      }
      paramJSONObject = sz.a().d(this.d);
      if (paramJSONObject != null) {
        sz.a().a(paramJSONObject);
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
      Object localObject = new StringBuilder("handleSuccess");
      ((StringBuilder)localObject).append(this.b.f);
      xa.c(((StringBuilder)localObject).toString());
      localObject = this.b.d.obtainMessage(this.b.f);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tz
 * JD-Core Version:    0.7.0.1
 */