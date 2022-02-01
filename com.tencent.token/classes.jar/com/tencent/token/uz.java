package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class uz
  extends tk
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
    sa.a();
    StringBuilder localStringBuilder = new StringBuilder("sessId=");
    localStringBuilder.append(null);
    xb.c(localStringBuilder.toString());
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramaar.c.get("param.device.lock.id")).intValue();
    this.i = ((String)paramaar.c.get("param.device.lock.guid"));
    this.f = ((Integer)paramaar.c.get("param.device.lock.appid")).intValue();
    this.g = ((Integer)paramaar.c.get("param.device.lock.subappid")).intValue();
    this.j = ((String)paramaar.c.get("param.device.lock.appname"));
    this.k = ((String)paramaar.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramaar.c.get("param.common.seq")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xb.a("decode json=".concat(String.valueOf(paramJSONObject)));
      m = paramJSONObject.getInt("seq_id");
      if (m != this.h)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(m);
        paramJSONObject.append(",right = ");
        sb.a();
        paramJSONObject.append(sb.b());
        xb.c(paramJSONObject.toString());
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
          tb.a().b(paramJSONObject);
        }
        else if (m == 71)
        {
          tb.a().c(paramJSONObject);
        }
        else if ((m == 80) && (paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          m = 0;
          if (m < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
            if (localJSONObject.getInt("id") == 71)
            {
              tb.a().a(localJSONObject);
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
        a(201, RqdApplication.n().getString(2131492910));
        paramJSONObject.printStackTrace();
        return;
      }
      xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.n().getString(2131493068));
      return;
      label306:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uz
 * JD-Core Version:    0.7.0.1
 */