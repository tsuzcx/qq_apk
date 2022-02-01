package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class tx
  extends tr
{
  private long d;
  private String e;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.e = ((String)paramabc.c.get("param.bind.sig"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xh)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        localObject = aao.e(paramJSONObject.getString("seed"));
        if (localObject != null)
        {
          sj.b().c();
          sj.b().a((byte[])localObject);
          sj.b().a.a();
        }
      }
      long l = paramJSONObject.getLong("server_time");
      sj.b();
      sj.a(l);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tx
 * JD-Core Version:    0.7.0.1
 */