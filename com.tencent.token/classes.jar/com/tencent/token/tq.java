package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class tq
  extends tk
{
  private long d;
  private String e;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.e = ((String)paramaar.c.get("param.bind.sig"));
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
      ((wz)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        localObject = aad.e(paramJSONObject.getString("seed"));
        if (localObject != null)
        {
          sc.b().c();
          sc.b().a((byte[])localObject);
          sc.b().a.a();
        }
      }
      long l = paramJSONObject.getLong("server_time");
      sc.b();
      sc.a(l);
      paramJSONObject = ta.a().d(this.d);
      if (paramJSONObject != null) {
        ta.a().b(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tq
 * JD-Core Version:    0.7.0.1
 */