package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uj
  extends ud
{
  private long d;
  private String e;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.e = ((String)paramabm.c.get("param.bind.sig"));
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
      ((xt)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        localObject = aay.e(paramJSONObject.getString("seed"));
        if (localObject != null)
        {
          sv.b();
          sv.b();
          sv.a((byte[])localObject);
          sv.b();
        }
      }
      long l = paramJSONObject.getLong("server_time");
      sv.b();
      sv.a(l);
      paramJSONObject = tt.a().d(this.d);
      if (paramJSONObject != null) {
        tt.a().a(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uj
 * JD-Core Version:    0.7.0.1
 */