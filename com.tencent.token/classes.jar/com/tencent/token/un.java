package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.net.URLEncoder;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONObject;

public final class un
  extends tr
{
  public final String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = si.b + 1;
      si.b = i;
      localJSONObject.put("seq_id", i);
      localObject = su.b();
      localJSONObject.put("rmd_ver", ((su)localObject).g);
      localJSONObject.put("rmd_times", ((su)localObject).h);
      localJSONObject.put("rmd_last_time", ((su)localObject).i);
      localJSONObject.put("config_ver", ti.a().h.b);
      localObject = RqdApplication.n();
      if (localObject != null) {
        localJSONObject.put("sec_sig", URLEncoder.encode((String)localObject));
      }
      localJSONObject.put("channel_id", aao.k());
      localJSONObject.put("wtsdk_guid", aao.a(sg.a(RqdApplication.p()).a.GetGuid()));
      localJSONObject.put("device_name", URLEncoder.encode(aap.x()));
      localJSONObject.put("release_tag", xf.a);
      aao.b(localJSONObject.toString().getBytes());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(localException.getMessage());
      xj.c(((StringBuilder)localObject).toString());
    }
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc) {}
  
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
      xj.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        localObject = paramJSONObject.getJSONObject("new_config");
        ti.a().h.a((JSONObject)localObject);
      }
      if (paramJSONObject.has("update")) {
        su.b().a(paramJSONObject.optJSONObject("update"));
      }
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.un
 * JD-Core Version:    0.7.0.1
 */