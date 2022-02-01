package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class vg
  extends tr
{
  private long d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  public final String a()
  {
    sh.a();
    StringBuilder localStringBuilder = new StringBuilder("sessId=");
    localStringBuilder.append(null);
    xj.c(localStringBuilder.toString());
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramabc.c.get("param.device.lock.id")).intValue();
    this.i = ((String)paramabc.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramabc.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramabc.c.get("param.device.lock.subappid")).intValue();
    this.j = ((String)paramabc.c.get("param.device.lock.appname"));
    this.k = ((String)paramabc.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramabc.c.get("param.common.seq")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xj.a("decode json=".concat(String.valueOf(paramJSONObject)));
      m = paramJSONObject.getInt("seq_id");
      if (m != this.h)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(m);
        paramJSONObject.append(",right = ");
        si.a();
        paramJSONObject.append(si.b());
        xj.c(paramJSONObject.toString());
        return;
      }
    }
    for (;;)
    {
      try
      {
        m = paramJSONObject.getInt("id");
        paramJSONObject = paramJSONObject.getJSONArray("result");
        if (m == 70)
        {
          ti.a().b(paramJSONObject);
        }
        else if (m == 71)
        {
          ti.a().c(paramJSONObject);
        }
        else if ((m == 80) && (paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          m = 0;
          if (m < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
            if (localJSONObject.getInt("id") == 71)
            {
              ti.a().a(localJSONObject);
              break label306;
            }
            localJSONObject.getInt("id");
            break label306;
          }
        }
        this.a.a = 0;
        return;
      }
      catch (JSONException paramJSONObject)
      {
        a(201, RqdApplication.p().getString(2131492910));
        paramJSONObject.printStackTrace();
        return;
      }
      xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.p().getString(2131493068));
      return;
      label306:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vg
 * JD-Core Version:    0.7.0.1
 */