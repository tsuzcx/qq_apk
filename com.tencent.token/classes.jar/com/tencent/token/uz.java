package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.net.URLEncoder;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONObject;

public final class uz
  extends ud
{
  public final String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = su.b + 1;
      su.b = i;
      localJSONObject.put("seq_id", i);
      localObject = tg.b();
      localJSONObject.put("rmd_ver", ((tg)localObject).g);
      localJSONObject.put("rmd_times", ((tg)localObject).h);
      localJSONObject.put("rmd_last_time", ((tg)localObject).i);
      localJSONObject.put("config_ver", tu.a().h.b);
      localJSONObject.put("channel_id", aay.k());
      localJSONObject.put("wtsdk_guid", aay.a(ss.a(RqdApplication.n()).a.GetGuid()));
      localJSONObject.put("device_name", URLEncoder.encode(aaz.x()));
      localJSONObject.put("release_tag", xr.a);
      aay.b(localJSONObject.toString().getBytes());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(localException.getMessage());
      xv.c(((StringBuilder)localObject).toString());
    }
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm) {}
  
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
      xv.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        localObject = paramJSONObject.getJSONObject("new_config");
        tu.a().h.a((JSONObject)localObject);
      }
      if (paramJSONObject.has("update")) {
        tg.b().a(paramJSONObject.optJSONObject("update"));
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uz
 * JD-Core Version:    0.7.0.1
 */